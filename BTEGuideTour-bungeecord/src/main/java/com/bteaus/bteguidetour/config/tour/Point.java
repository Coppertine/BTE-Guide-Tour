package com.bteaus.bteguidetour.config.tour;

import net.md_5.bungee.api.connection.Server;

public class Point {
    private PointType type;
    private int[] position; // x, y, z, pitch, yaw
    private Server server;

    public Point(PointType type, int[] position, Server server) {
        this.type = type;
        this.position = position;
        this.server = server;
    }
}