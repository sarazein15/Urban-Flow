package com.example.eventservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "operational_changes")
public class OperationalChange {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String affectedEntity;

    private String changeType;

    private String modifiedValue;

    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference
    private Event event;

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getAffectedEntity() { return affectedEntity; }
    public void setAffectedEntity(String affectedEntity) { this.affectedEntity = affectedEntity; }

    public String getChangeType() { return changeType; }
    public void setChangeType(String changeType) { this.changeType = changeType; }

    public String getModifiedValue() { return modifiedValue; }
    public void setModifiedValue(String modifiedValue) { this.modifiedValue = modifiedValue; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }
}