package me.IronCrystal.NPCWorkers.Events;

import java.util.ArrayList;
import java.util.List;

import me.IronCrystal.NPCWorkers.NPCWorkers;
import me.IronCrystal.NPCWorkers.NPCs.Worker;

import org.spout.api.event.Cancellable;
import org.spout.api.event.HandlerList;
import org.spout.api.player.Player;
import org.spout.api.util.config.ConfigurationNode;

public class NPCSpawnEvent extends NPCEvent implements Cancellable {

	private static HandlerList handlers = new HandlerList();
	
	private Player player;
	
	public NPCSpawnEvent(Worker w, Player p) {
		super(w);
		if(NPCWorkers.data.getNode("workers." + p.getName()) == null) {
			String[] string = {"workers." + p.getName()};
			NPCWorkers.data.setNode(new ConfigurationNode(NPCWorkers.data, string, new ArrayList<String>()));
		}
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>) NPCWorkers.data.getNode("workers." + p.getName()).getList();
		list.add(w.getUUID().toString());
		player = p;
	}

	@Override
	public void setCancelled(boolean cancel) {
		this.cancelled = cancel;
	}
	
	public Player getOwner() {
		return player;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public HandlerList getHandlerList() {
		return handlers;
	}

}
