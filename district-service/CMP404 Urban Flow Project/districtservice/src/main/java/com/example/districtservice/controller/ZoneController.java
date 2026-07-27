package com.example.districtservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.districtservice.service.ZoneService;

@RestController
@RequestMapping("/api/zones")
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @DeleteMapping("/{zoneId}")
    public void deleteZone(@PathVariable Long zoneId) {
        zoneService.deleteZone(zoneId);
    }
}