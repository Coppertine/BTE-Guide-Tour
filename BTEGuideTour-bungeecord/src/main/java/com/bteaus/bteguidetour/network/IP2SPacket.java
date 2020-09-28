package com.bteaus.bteguidetour.network;

import com.bteaus.bteguidetour.util.SmartObject;
import org.json.simple.JSONObject;

public interface IP2SPacket {
    String getPacketID();
    void onMessage(PacketInfo info, SmartObject data);
}
