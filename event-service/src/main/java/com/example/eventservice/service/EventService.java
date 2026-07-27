package com.example.eventservice.service;

import com.example.eventservice.model.Event;
import com.example.eventservice.model.OperationalChange;
import com.example.eventservice.repository.EventRepository;
import com.example.eventservice.repository.OperationalChangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private OperationalChangeRepository operationalChangeRepository;

    // Create a new event inside a district
    public Event createEvent(Long districtId, Event event) {
        event.setDistrictId(districtId);
        return eventRepository.save(event);
    }

    // Get all events for a district
    public List<Event> getAllEventsByDistrict(Long districtId) {
        return eventRepository.findByDistrictId(districtId);
    }

    // Get a single event by id, verifying it belongs to the district
    public Event getEventById(Long districtId, Long eventId) {
        return eventRepository.findByIdAndDistrictId(eventId, districtId)
                .orElseThrow(() -> new RuntimeException(
                        "Event not found with id " + eventId + " in district " + districtId));
    }

    // Add an operational change to an event
    public Event addOperationalChange(Long districtId, Long eventId, OperationalChange change) {
        Event event = getEventById(districtId, eventId);
        change.setEvent(event);
        operationalChangeRepository.save(change);
        // Reload the event so the changes list is up to date
        return eventRepository.findByIdAndDistrictId(eventId, districtId)
                .orElseThrow(() -> new RuntimeException("Event not found"));
    }

    // Delete an event
    public void deleteEvent(Long districtId, Long eventId) {
        Event event = getEventById(districtId, eventId);
        eventRepository.delete(event);
    }
}