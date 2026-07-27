package com.example.eventservice.controller;

import com.example.eventservice.model.Event;
import com.example.eventservice.model.OperationalChange;
import com.example.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/districts/{districtId}/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // POST /api/districts/{districtId}/events
    // Create a new event inside a district
    @PostMapping
    public ResponseEntity<Event> createEvent(
            @PathVariable Long districtId,
            @RequestBody Event event) {
        Event created = eventService.createEvent(districtId, event);
        return ResponseEntity.ok(created);
    }

    // GET /api/districts/{districtId}/events
    // Get all events for a district
    @GetMapping
    public ResponseEntity<List<Event>> getAllEvents(@PathVariable Long districtId) {
        List<Event> events = eventService.getAllEventsByDistrict(districtId);
        return ResponseEntity.ok(events);
    }

    // GET /api/districts/{districtId}/events/{eventId}
    // Get a single event with its operational changes
    @GetMapping("/{eventId}")
    public ResponseEntity<Event> getEvent(
            @PathVariable Long districtId,
            @PathVariable Long eventId) {
        Event event = eventService.getEventById(districtId, eventId);
        return ResponseEntity.ok(event);
    }

    // POST /api/districts/{districtId}/events/{eventId}/changes
    // Add an operational change to an event
    @PostMapping("/{eventId}/changes")
    public ResponseEntity<Event> addOperationalChange(
            @PathVariable Long districtId,
            @PathVariable Long eventId,
            @RequestBody OperationalChange change) {
        Event updated = eventService.addOperationalChange(districtId, eventId, change);
        return ResponseEntity.ok(updated);
    }

    // DELETE /api/districts/{districtId}/events/{eventId}
    // Delete an event
    @DeleteMapping("/{eventId}")
    public ResponseEntity<Map<String, String>> deleteEvent(
            @PathVariable Long districtId,
            @PathVariable Long eventId) {
        eventService.deleteEvent(districtId, eventId);
        Map<String, String> response = new HashMap<>();
        response.put("message", "Event with id " + eventId + " has been deleted successfully.");
        return ResponseEntity.ok(response);
    }
}