package com.jpa.test.entities;

import java.util.Set;

public class Service {
    private Source _source;

    public Source get_source() {
        return _source;
    }

    public void set_source(Source _source) {
        this._source = _source;
    }
    public String getId() {
        return _source.getId();
    }
    public String getServiceDate() {
        return _source.getServiceDate();
    }
    public void setServiceDate(String serviceDate) {
		this._source.serviceDate = serviceDate;
	}
	public String getOperationalState() {
		return _source.operationalState;
	}
	public void setOperationalState(String operationalState) {
		this._source.operationalState = operationalState;
	}
	 public Set<Map.Entry<String, Object>> getSourceProperties() {
	        return _source.getProperties();
	    }
	
}
