package com.jpa.test.controller;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpa.test.entities.AlarmDataResponse;
import com.jpa.test.entities.FilterResponse;
import com.jpa.test.entities.InfoRequest;
import com.jpa.test.entities.InfoResponse;
import com.jpa.test.entities.Service;
import com.opencsv.CSVReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestController
public class ReadFromCSV {

    @GetMapping("/get_zone")
    public String readCSV() throws IOException {
        ClassPathResource resource = new ClassPathResource("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\Zone_data.csv");
        BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));

        StringBuilder buffer = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line).append("\n");
        }

        reader.close();
        return buffer.toString(); 
    }
      
    @GetMapping("/alarms_data")
    public String alarmsData() throws IOException {
        ClassPathResource resource = new ClassPathResource("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\alarms_data.json");
        String json = StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);

        ObjectMapper objectMapper = new ObjectMapper();
        AlarmDataResponse response = objectMapper.readValue(json, AlarmDataResponse.class);

        return objectMapper.writeValueAsString(response.getData());
    }
    
    @PostMapping("/filter")
    public FilterResponse filterData(@RequestBody JsonNode zone) throws IOException {
        String selectedZone = zone.get("Zone").asText();

        List<String> site = new ArrayList<>();
        List<String> olt = new ArrayList<>();
        List<String> ont = new ArrayList<>();

        List<String[]> filteredData = new ArrayList<>();
        Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\Inventory_data_new.csv"))
                .skip(1) // Skip header line
                .map(line -> line.split(","))
                .filter(val -> val[9].equals(selectedZone))
                .forEach(val -> {
                    site.add(val[6]);
                    olt.add(val[1]);
                    ont.add(val[4]);
                    filteredData.add(val);
                });

        return new FilterResponse(new HashSet<>(site), new HashSet<>(olt), ont);
    }
    @PostMapping("/get_lat_long")
    public Map<String, Double[]> getCoord(@RequestBody JsonNode request) {
        // Retrieve ONT coordinates
        Map<String, Double[]> ontCoords = new HashMap<>();
        // Read ONT_data_new.csv and populate ontCoords map

        // Retrieve OLT coordinates
        Map<String, Double[]> oltCoords = new HashMap<>();
        // Read OLT_data_new.csv and populate oltCoords map

        // Construct data map with zones, sites, ONT coordinates, and OLT coordinates
        Map<String, Object> data = new HashMap<>();
        data.put("Zones", createZonesMap());
        data.put("Sites", createSitesMap());
        data.put("ONT", ontCoords);
        data.put("OLT", oltCoords);

        // Extract request parameters
        String type = request.get("type").asText();
        String id = request.get("id").asText();

        // Retrieve and return the corresponding coordinates
        return Map.of("res", getCoordinates(data, type, id));
    }

    private Double[] getCoordinates(Map<String, Object> data, String type, String id) {
        JsonNode coordinates = ((JsonNode) data.get(type)).get(id);
        Double latitude = coordinates.get(0).asDouble();
        Double longitude = coordinates.get(1).asDouble();
        return new Double[]{latitude, longitude};
    }

    private Map<String, JsonNode> createZonesMap() {
        Map<String, JsonNode> zones = new HashMap<>();
        // Populate zones map with zone coordinates
        // Example: zones.put("Dublin", new Double[]{53.350140, -6.266155});
        return zones;
    }

    private Map<String, JsonNode> createSitesMap() {
        Map<String, JsonNode> sites = new HashMap<>();
        // Populate sites map with site coordinates
        // Example: sites.put("Shankill", new Double[]{54.604301, -5.953000});
        return sites;
    }
    @PostMapping("/table_data")
    public Map<String, Object> getTableInfo(@RequestBody Map<String, String> requestData) {
        System.out.println("Hello");
        System.out.println(requestData);

        String type = requestData.get("type");
        String id = requestData.get("id");

        // Read the CSV file
        Map<String, Object> resp;
        try {
            CSVReader reader = new CSVReader(new FileReader(type + "_data_new.csv"));
            List<String[]> lines = reader.readAll();

            // Find the matching data based on the id
            String[] headers = lines.get(0);
            int idColumnIndex = -1;
            for (int i = 0; i < headers.length; i++) {
                if (headers[i].equals(id)) {
                    idColumnIndex = i;
                    break;
                }
            }

            if (idColumnIndex != -1) {
                for (int i = 1; i < lines.size(); i++) {
                    String[] row = lines.get(i);
                    if (row[idColumnIndex].equals(id)) {
                        resp = new HashMap<>();
                        for (int j = 0; j < headers.length; j++) {
                            resp.put(headers[j], row[j]);
                        }
                        return resp;
                    }
                }
            }
            resp = Map.of("resp", "No Data");
        } catch (Exception e) {
            resp = Map.of("resp", "Error: " + e.getMessage());
        }

        return resp;
    }
    @GetMapping("/hierrachy_resource")
    public List<Map<String, Object>> getResourceHierarchy() throws IOException {
        List<Map<String, Object>> t = new ArrayList<>();

        // Read the CSV file
        // Assuming the CSV file has columns: Zone, Site, OLT, LT, PON, Serialnumber
        // Adjust the file path and column names accordingly if they are different in your CSV file
        try (CSVReader reader = new CSVReader(new FileReader("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\Inventory_Latest.csv"))) {
            String[] header = reader.readNext(); // Read the header line

            String[] row;
            while ((row = reader.readNext()) != null) {
                String zone = row[0];
                String site = row[1];
                String olt = row[2];
                String lt = row[3];
                String pon = row[4];
                String ont = row[5];

                // Find or create the Zone node
                Map<String, Object> zoneNode = findOrCreateChild(t, "name", "Zone " + zone);
                List<Map<String, Object>> zoneChildren = getChildList(zoneNode, "children");

                // Find or create the Site node
                Map<String, Object> siteNode = findOrCreateChild(zoneChildren, "name", "Site " + site);
                List<Map<String, Object>> siteChildren = getChildList(siteNode, "children");

                // Find or create the OLT node
                Map<String, Object> oltNode = findOrCreateChild(siteChildren, "name", "OLT " + olt);
                List<Map<String, Object>> oltChildren = getChildList(oltNode, "children");

                // Find or create the LT node
                Map<String, Object> ltNode = findOrCreateChild(oltChildren, "name", "LT " + lt);
                List<Map<String, Object>> ltChildren = getChildList(ltNode, "children");

                // Find or create the PON node
                Map<String, Object> ponNode = findOrCreateChild(ltChildren, "name", "PON " + pon);
                List<Map<String, Object>> ponChildren = getChildList(ponNode, "children");

                // Create the ONT node
                Map<String, Object> ontNode = new HashMap<>();
                ontNode.put("name", "ONT " + ont);
                ontNode.put("children", new ArrayList<>());

                // Add the ONT node to the PON children
                ponChildren.add(ontNode);
            }
        }

        return t;
    }

    private Map<String, Object> findOrCreateChild(List<Map<String, Object>> nodeList, String key, String value) {
        for (Map<String, Object> node : nodeList) {
            if (node.get(key).equals(value)) {
                return node;
            }
        }
        Map<String, Object> newNode = new HashMap<>();
        newNode.put(key, value);
        newNode.put("children", new ArrayList<>());
        nodeList.add(newNode);
        return newNode;
    }

    @SuppressWarnings("unchecked")
    private List<Map<String, Object>> getChildList(Map<String, Object> node, String key) {
        Object childrenObj = node.get(key);
        if (childrenObj instanceof List) {
            return (List<Map<String, Object>>) childrenObj;
        }
        return null;
    }
    
    @GetMapping("/get_zone_with_olt")
    public List<Map<String, List<Integer>>> getZoneOLTONT() throws IOException {
        List<Map<String, List<Integer>>> finalData = new ArrayList<>();

        // Read Zone data
        List<String> zones = Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\Zone_data.csv")).skip(1).map(line -> line.split(",")[0]).collect(Collectors.toList());

        // Read Inventory data
        List<String[]> inventoryData = Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\Inventory_data_new.csv")).map(line -> line.split(",")).collect(Collectors.toList());

        for (String zone : zones) {
            List<String> oltList = new ArrayList<>();
            List<String> ontList = new ArrayList<>();

            for (String[] row : inventoryData) {
                if (row[6].equals(zone)) { // Zone column index might need adjustment
                    oltList.add(row[1]); // OLT column index might need adjustment
                    ontList.add(row[4]); // Serialnumber column index might need adjustment
                }
            }

            int noOfOLTs = (int) oltList.stream().distinct().count();
            int noOfONTs = (int) ontList.stream().distinct().count();

            Map<String, List<Integer>> zoneData = new HashMap<>();
            zoneData.put(zone, List.of(noOfOLTs, noOfONTs));
            finalData.add(zoneData);
        }

        return finalData;
    }
    @GetMapping("/olt_geo")
    public List<Object[]> getOLTGeoData() throws IOException {
        List<Object[]> finalData = new ArrayList<>();

        // Read OLT data
        List<String[]> oltData = Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\OLT_data_new.csv")).map(line -> line.split(",")).collect(Collectors.toList());

        // Read Inventory data
        List<String[]> inventoryData = Files.lines(Paths.get("Inventory_data_new.csv")).map(line -> line.split(",")).collect(Collectors.toList());

        for (String[] row : oltData) {
            String oltNEID = row[0]; // OLT_NE_ID column index might need adjustment
            String latitude = row[1]; // Latitude column index might need adjustment
            String longitude = row[2]; // Longitude column index might need adjustment

            // Filter Inventory data for matching OLT_NE_ID
            List<String> onts = inventoryData.stream()
                    .filter(invRow -> invRow[1].equals(oltNEID)) // OLT column index might need adjustment
                    .map(invRow -> invRow[4]) // Serialnumber column index might need adjustment
                    .collect(Collectors.toList());

            Map<String, String> oltInfo = new HashMap<>();
            oltInfo.put("OLT_NE_ID", oltNEID);
            oltInfo.put("Latitude", latitude);
            oltInfo.put("Longitude", longitude);

            Object[] dataRow = {oltNEID, latitude, longitude, oltInfo, onts.size()};
            finalData.add(dataRow);
        }

        return finalData;
    }
    @GetMapping("/ont_geo")
    public List<Object[]> getONTGeoData() throws IOException {
        List<Object[]> finalData = new ArrayList<>();

        // Read ONT data
        List<String[]> ontData = Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\ONT_data_new.csv")).map(line -> line.split(",")).collect(Collectors.toList());

        for (String[] row : ontData) {
            String serialNumber = row[0]; // Serialnumber column index might need adjustment
            String latitude = row[1]; // Latitude column index might need adjustment
            String longitude = row[2]; // Longitude column index might need adjustment

            Map<String, String> ontInfo = new HashMap<>();
            ontInfo.put("Serialnumber", serialNumber);
            ontInfo.put("Latitude", latitude);
            ontInfo.put("Longitude", longitude);

            Object[] dataRow = {serialNumber, latitude, longitude, ontInfo};
            finalData.add(dataRow);
        }

        return finalData;
    }
    
    @PostMapping("/polyline_data")
    public List<List<List<String>>> getPolylineData(@RequestBody Map<String, String> oltId) throws IOException {
        List<List<List<String>>> latLongData = new ArrayList<>();

        String olt = oltId.get("OLT");

        // Read Inventory data
        List<String[]> inventoryData = Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\Inventory_data_new.csv")).map(line -> line.split(",")).collect(Collectors.toList());

        // Read OLT data
        List<String[]> oltData = Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\OLT_data_new.csv")).map(line -> line.split(",")).collect(Collectors.toList());

        // Read ONT data
        List<String[]> ontData = Files.lines(Paths.get("C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\ONT_data_new.csv")).map(line -> line.split(",")).collect(Collectors.toList());

        String oltLatitude = "";
        String oltLongitude = "";

        for (String[] row : oltData) {
            if (row[0].equals(olt)) {
                oltLatitude = row[1]; // Latitude column index might need adjustment
                oltLongitude = row[2]; // Longitude column index might need adjustment
                break;
            }
        }

        for (String[] row : inventoryData) {
            String ont = row[4]; // Serialnumber column index might need adjustment

            if (row[1].equals(olt)) {
                for (String[] ontRow : ontData) {
                    if (ontRow[0].equals(ont)) {
                        String ontLatitude = ontRow[1]; // Latitude column index might need adjustment
                        String ontLongitude = ontRow[2]; // Longitude column index might need adjustment

                        List<String> oltCoord = new ArrayList<>();
                        oltCoord.add(oltLatitude);
                        oltCoord.add(oltLongitude);

                        List<String> ontCoord = new ArrayList<>();
                        ontCoord.add(ontLatitude);
                        ontCoord.add(ontLongitude);

                        List<List<String>> latLongPair = new ArrayList<>();
                        latLongPair.add(oltCoord);
                        latLongPair.add(ontCoord);

                        latLongData.add(latLongPair);
                        break;
                    }
                }
            }
        }

        return latLongData;
    }
    
    @PostMapping("/service_table")
    public Map<String, Object> getServiceInfo(@RequestBody Map<String, Object> requestData) {
        System.out.println("req_data: " + requestData);

        String serviceKey = requestData.get("key").toString().split(" ")[1];
        String serviceName = requestData.get("service_name").toString();
        String key = requestData.get("key").toString(); // Add this line

        // Read data from JSON file
        String jsonFilePath = "C:\\Users\\sachin.ys\\Desktop\\MyTask\\BackEnd\\service_76.json";
        String jsonData;
        try {
            jsonData = new String(Files.readAllBytes(Paths.get(jsonFilePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }

        // Parse JSON data
        Map<String, Object> jsonDataMap = new HashMap<>();
        try {
            jsonDataMap = new ObjectMapper().readValue(jsonData, new TypeReference<Map<String, Object>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<>();
        }

        Map<String, Object> info = new HashMap<>();
        System.out.println(serviceName);
        for (Map<String, Object> service : (List<Map<String, Object>>) jsonDataMap.get("data")) {
            Map<String, Object> source = (Map<String, Object>) service.get("_source");
            if (source.get("name").equals(serviceName)) {
                System.out.println("service_name matched");

                // Check Key
                if (key.equalsIgnoreCase("service")) {
                    info.put("Service ID", source.get("id"));
                    info.put("Service Date", source.get("serviceDate"));
                    info.put("Operational State", source.get("operationalState"));
                } else if (key.equalsIgnoreCase("L2")) {
                    for (Map.Entry<String, Object> entry : source.entrySet()) {
                        if (entry.getKey().startsWith("Wh.L2")) {
                            info.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else if (key.equalsIgnoreCase("PON")) {
                    for (Map.Entry<String, Object> entry : source.entrySet()) {
                        if (entry.getKey().startsWith("Wh.pon")) {
                            info.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else if (key.equalsIgnoreCase("OLT")) {
                    for (Map.Entry<String, Object> entry : source.entrySet()) {
                        if (entry.getKey().startsWith("Wh.OLT")) {
                            info.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else if (key.equalsIgnoreCase("ONT")) {
                    for (Map.Entry<String, Object> entry : source.entrySet()) {
                        if (entry.getKey().startsWith("Wh.Ont")) {
                            info.put(entry.getKey(), entry.getValue());
                        }
                    }
                } else if (key.equalsIgnoreCase("multicast")) {
                    for (Map.Entry<String, Object> entry : source.entrySet()) {
                        if (entry.getKey().startsWith("Wh.Multicast")) {
                            info.put(entry.getKey(), entry.getValue());
                        }
                    }
                }

                break; // Exit loop since service name matched
            }
        }

        return info;
    }
    @PostMapping("/popup_info")
    public Map<String, Object> getPopupInfoData(@RequestBody Map<String, Double> latLong) {
        // Load the CSV data into a DataFrame (assuming 'OLT_data_new.csv' is in the classpath)
        DataFrame df = DataFrame.read().csv("OLT_data_new.csv");

        double lat = latLong.get("Latitude");
        double lon = latLong.get("Longitude");

        // Round latitude and longitude values to 2 decimal places
        lat = Math.round(lat * 100.0) / 100.0;
        lon = Math.round(lon * 100.0) / 100.0;

        System.out.println(lat + ", " + lon);

        // Format 'Latitude' and 'Longitude' columns in the DataFrame
        df.col("Latitude").apply(v -> String.format("%.2f", v));
        df.col("Longitude").apply(v -> String.format("%.2f", v));

        // Filter the DataFrame based on latitude and longitude values
        DataFrame dfResult = df.filter(row -> row.getDouble("Latitude") == lat && row.getDouble("Longitude") == lon);

        System.out.println(dfResult);

        // Convert the DataFrame result to a map
        Map<String, Object> data = new HashMap<>();
        if (dfResult.rowCount() > 0) {
            dfResult.columns().forEach(column -> data.put(column.name(), dfResult.get(column, 0)));
        }

        return data;
    }
   }
    
    