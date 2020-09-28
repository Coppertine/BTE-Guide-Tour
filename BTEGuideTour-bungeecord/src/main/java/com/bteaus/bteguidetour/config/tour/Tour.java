package com.bteaus.bteguidetour.config.tour;

import de.leonhard.storage.Json;

import java.util.List;

public class Tour {
    private String name;
    private String description;
    private List<Destination> destinations;

    public Tour(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
