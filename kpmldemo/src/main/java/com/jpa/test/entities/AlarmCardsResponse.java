package com.jpa.test.entities;

public class AlarmCardsResponse {
    private Severity activeSeverity;
    private Severity clearSeverity;
    private EventType eventType;
    private ImpactType impactType;

    public Severity getActiveSeverity() {
        return activeSeverity;
    }

    public void setActiveSeverity(Severity activeSeverity) {
        this.activeSeverity = activeSeverity;
    }

    public Severity getClearSeverity() {
        return clearSeverity;
    }

    public void setClearSeverity(Severity clearSeverity) {
        this.clearSeverity = clearSeverity;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public ImpactType getImpactType() {
        return impactType;
    }

    public void setImpactType(ImpactType impactType) {
        this.impactType = impactType;
    }
}

    


