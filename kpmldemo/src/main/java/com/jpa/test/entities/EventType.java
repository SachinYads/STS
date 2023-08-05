package com.jpa.test.entities;

public class EventType {
	private int communicationsAlarm;
    private int equipmentAlarm;

    public EventType(int communicationsAlarm, int equipmentAlarm) {
        this.communicationsAlarm = communicationsAlarm;
        this.equipmentAlarm = equipmentAlarm;
    }

    public int getCommunicationsAlarm() {
        return communicationsAlarm;
    }

    public int getEquipmentAlarm() {
        return equipmentAlarm;
    }


}
