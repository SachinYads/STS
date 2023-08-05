package com.jpa.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.xml.crypto.Data;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OLtTestController {
	@GetMapping("/olt_geo")
    @PostMapping
    public ResponseEntity<List<Object>> getZoneLatLong() {
      List<Object> finalData = new ArrayList<>();
      
      try {
    	  FileReader fileReader = new FileReader("D:\\KPN_DEMO\\BackEnd\\OLT_data_new.csv");
          CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

          CSVReader invReader = new CSVReader(new FileReader("D:\\KPN_DEMO\\BackEnd\\Inventory_data_new.csv"));
          List<String[]> invList = invReader.readAll();
          invReader.close();
          
          for (CSVRecord record : csvParser) {
              Map<String, String> resp = new HashMap<>();
              List<Object> row = new ArrayList<>();
              String OLT_NE_ID = record.get("OLT_NE_ID");
              String Latitude = record.get("Latitude");
              String Longitude = record.get("Longitude");
              
              for (String header : csvParser.getHeaderNames()) {
                  resp.put(header, record.get(header));
              }
              
              int invCount = 0;

              for (String[] invRow : invList) {
                  String olt = invRow[1];
                  if (olt.equals(OLT_NE_ID)) {
                      invCount++;
                  }
              }
              row.add(OLT_NE_ID);
              row.add(Latitude);
              row.add(Longitude);
              row.add(resp);
              row.add(invCount);
              finalData.add(row);
          }

          return ResponseEntity.ok(finalData);
      } catch (Exception e) {
          e.printStackTrace();
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
              }
      }
	    

	@GetMapping("/ont_geo")
    public ResponseEntity<List<List<Object>>> getONT() {
        List<List<Object>> finalData = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader("D:\\KPN_DEMO\\BackEnd\\ONT_data_new.csv");
            CSVParser ontParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

            for (CSVRecord Ontrecord : ontParser) {
                String serialNumber = Ontrecord.get("Serialnumber");
                String latitude = Ontrecord.get("Latitude");
                String longitude = Ontrecord.get("Longitude");

                Map<String, String> resp = new HashMap<>();
                for (String header : ontParser.getHeaderNames()) {
                    resp.put(header, Ontrecord.get(header));
                }

                List<Object> row = new ArrayList<>();
                row.add(serialNumber);
                row.add(latitude);
                row.add(longitude);
                row.add(resp);

                finalData.add(row);
            }

            return ResponseEntity.ok(finalData);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    	



	@PostMapping("/polyline_data")
	public ResponseEntity<List<List<List<Double>>>> getPolylineInfo(@RequestBody Map<String, String> olt_id) {
	    List<List<List<Double>>> polylineData = new ArrayList<>();
	    try {
	        FileReader inventoryFileReader = new FileReader("D:\\KPN_DEMO\\BackEnd\\Inventory_data_new.csv");
	        FileReader oltFileReader = new FileReader("D:\\KPN_DEMO\\BackEnd\\OLT_data_new.csv");
	        FileReader ontFileReader = new FileReader("D:\\KPN_DEMO\\BackEnd\\ONT_data_new.csv");

	        CSVParser inventoryParser = new CSVParser(inventoryFileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
	        CSVParser oltParser = new CSVParser(oltFileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
	        CSVParser ontParser = new CSVParser(ontFileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader());

	        List<CSVRecord> oltRecords = oltParser.getRecords();
	        List<CSVRecord> ontRecords = ontParser.getRecords();

	        List<List<Double>> oltCoordinates = new ArrayList<>();
	        double oltLatitude = 0.0;
	        double oltLongitude = 0.0;

	        // Find the latitude and longitude of the specified OLT_NE_ID
	        for (CSVRecord oltRecord : oltRecords) {
	            if (oltRecord.get("OLT_NE_ID").equals(olt_id.get("OLT"))) {
	                oltLatitude = parseDouble(oltRecord.get("Latitude"));
	                oltLongitude = parseDouble(oltRecord.get("Longitude"));
	            }
	        }

	        oltCoordinates.add(List.of(oltLatitude, oltLongitude));

	        // Find coordinates for associated ONTs
	        for (CSVRecord inventoryRecord : inventoryParser) {
	            if (inventoryRecord.get("OLT").equals(olt_id.get("OLT"))) {
	                String ontSerialNumber = inventoryRecord.get("Serialnumber");

	                for (CSVRecord ontRecord : ontRecords) {
	                    if (ontRecord.get("Serialnumber").equals(ontSerialNumber)) {
	                        double ontLatitude = parseDouble(ontRecord.get("Latitude"));
	                        double ontLongitude = parseDouble(ontRecord.get("Longitude"));
	                        
	                        oltCoordinates.add(List.of(ontLatitude, ontLongitude));
	                        break;
	                    }
	                }
	            }
	        }

	        // Add each pair of coordinates to the polylineData list
	        for (int i = 1; i < oltCoordinates.size(); i++) {
	            List<List<Double>> pair = new ArrayList<>();
	            pair.add(oltCoordinates.get(0)); // The first coordinate is the OLT
	            pair.add(oltCoordinates.get(i)); // The second coordinate is an associated ONT
	            polylineData.add(pair);
	        }

	        return ResponseEntity.ok(polylineData);
	    } catch (Exception e) {
	        e.printStackTrace();
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	    }
	}
    private double parseDouble(String s) {
        // Remove any non-numeric characters from the string before parsing
        String cleanedString = s.replaceAll("[^\\d.-]", "");
        return Double.parseDouble(cleanedString);
    }
}