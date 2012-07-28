package me.IronCrystal.NPCWorkers.NPCs;

import org.spout.api.geo.World;
import org.spout.api.geo.discrete.Point;
import org.spout.api.player.Player;

public class Miner extends Worker {

	protected Miner miner;
	private MinerState state;
	
	public Miner(String clientName) {
		super(clientName);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Just a little method to start digging
	 */
	public void startChopping() {
		float x = miner.getLookingAt().getX();
		float y = miner.getLookingAt().getY();
		float z = miner.getLookingAt().getZ();

		World world = miner.getHeadPosition().getWorld();

		Point point = new Point(world, x, y, z);

		state = MinerState.MINING;
		
		miner.startDigging(point);
	}
	
	public void stopChopping() {
		float x = miner.getLookingAt().getX();
		float y = miner.getLookingAt().getY();
		float z = miner.getLookingAt().getZ();

		World world = miner.getHeadPosition().getWorld();

		Point point = new Point(world, x, y, z);

		state = MinerState.DONE_MINING;
		
		miner.stopDigging(point);
	}

	/**
	 * Spawning a Miner
	 * Needed?
	 * @param Point, Player
	 */
	public Miner spawn(Point point, Player player) {
		Miner miner = (Miner) point.getWorld().createAndSpawnEntity(point, new Miner(player.getName() + "'s Miner"));
		state = MinerState.JUST_SPAWNED;
		return miner;
	}
	
	/**
	 * Get the state at which the miner is in.
	 */
	public MinerState getState() {
		return state;
	}
	
	
	/**
	 * Enum for telling the state of the Miner.
	 */
	public enum MinerState {
		AT_CHEST,
		MINING,
		DONE_MINING,
		RETURNING_TO_CHEST,
		RETURNING_TO_CHEST_AND_IS_NEAR_CHEST,
		JUST_SPAWNED;
	}
	
}
