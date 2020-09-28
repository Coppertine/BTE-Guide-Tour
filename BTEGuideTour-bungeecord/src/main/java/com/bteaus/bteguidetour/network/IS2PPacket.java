package com.bteaus.bteguidetour.network;

import com.bteaus.bteguidetour.util.SmartObject;

public interface IS2PPacket {
    String getPacketID();
    void onMessage(PacketInfo info, SmartObject data);
}