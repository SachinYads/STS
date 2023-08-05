package com.jpa.test.entities;

public class ImpactType {
	
	private int SA_NON_SERVICE_AFFECTING;
    private int SA_SERVICE_AFFECTING;

    public ImpactType(int SA_NON_SERVICE_AFFECTING, int SA_SERVICE_AFFECTING) {
        this.SA_NON_SERVICE_AFFECTING = SA_NON_SERVICE_AFFECTING;
        this.SA_SERVICE_AFFECTING = SA_SERVICE_AFFECTING;

}
    public int getSA_NON_SERVICE_AFFECTING() {
        return SA_NON_SERVICE_AFFECTING;
    }

    public int getSA_SERVICE_AFFECTING() {
        return SA_SERVICE_AFFECTING;
    }

}
