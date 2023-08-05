package com.jpa.test.entities;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Source {
	    private String name;
	    private String id;
	    String serviceDate;
	    String operationalState;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getServiceDate() {
			return serviceDate;
		}
		public void setServiceDate(String serviceDate) {
			this.serviceDate = serviceDate;
		}
		public String getOperationalState() {
			return operationalState;
		}
		public void setOperationalState(String operationalState) {
			this.operationalState = operationalState;
		}
		 public Set<Map.Entry<String, Object>> getSourceProperties() {
		        return _source.getProperties();
		    }
	}


