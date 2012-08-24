package com.volumetricpixels.supported.NPCWorkers.Events;

import org.spout.api.event.Cancellable;
import org.spout.api.event.HandlerList;

import com.volumetricpixels.supported.NPCWorkers.NPCs.Worker;

/**
 * This event is called every time an NPC dies.
 * It is called in the EventListeners class
 */
public class NPCDeathEvent extends NPCEvent implements Cancellable {
    
	private static HandlerList handlers = new HandlerList();

	public NPCDeathEvent(Worker worker) {
	    super(worker);
	}

	@Override
	public void setCancelled(boolean cancelled) {
		this.cancelled = cancelled;
	}

	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}
	
}
