package com.bteaus.bteguidetour.network.S2P;

import com.bteaus.bteguidetour.Constants;
import com.bteaus.bteguidetour.config.tour.Point;
import com.bteaus.bteguidetour.network.IS2PPacket;
import com.bteaus.bteguidetour.network.PacketInfo;
import com.bteaus.bteguidetour.network.S2PPacket;
import com.bteaus.bteguidetour.util.ChatHelper;
import com.bteaus.bteguidetour.util.SmartObject;
import com.bteaus.bteguidetour.util.TextElement;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import org.json.simple.JSONObject;

public class S2PGetMapPacket extends S2PPacket {
    private final PacketInfo info;
    private final int zoom;
    private Point point;

    public S2PGetMapPacket(PacketInfo info, int zoom) {
        this.info = info;
        this.zoom = zoom;
    }
    @Override
    public String getPacketID() {
        return Constants.getMapID;
    }
    @Override
    public void onMessage(PacketInfo info, SmartObject data) {
        JSONObject point = (JSONObject) data.get("point");

        GeographicProjection projection = new ModifiedAirocean();
        GeographicProjection uprightProj = GeographicProjection.orientProjection(projection, GeographicProjection.Orientation.upright);
        ScaleProjection scaleProj = new ScaleProjection(uprightProj, Constants.SCALE, Constants.SCALE);
        double proj[] = scaleProj.toGeo(Double.parseDouble((String) point.get("x")), Double.parseDouble((String) point.get("z")));

        int zoom = data.getInteger("zoom");
        Location online = OpenStreetMaps.getInstance().getLocation(proj[0], proj[1], zoom);
        CommandSender player = ProxyServer.getInstance().getPlayer(info.getSender());

        if(online == null) {
            player.sendMessage(ChatHelper.getInstance().makeTextComponent(
                    new TextElement("This is not a valid location in the projection!", ChatColor.RED)));
        }

    }
}
