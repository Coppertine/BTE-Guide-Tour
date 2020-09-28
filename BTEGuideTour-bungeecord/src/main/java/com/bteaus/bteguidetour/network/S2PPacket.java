package com.bteaus.bteguidetour.network;

import com.bteaus.bteguidetour.BTEGuideTourBungeeCord;

public abstract class S2PPacket implements IS2PPacket {
    public GuideTourNetworkManager getManager() {
        return GuideTourNetworkManager.getInstance();
    }
}