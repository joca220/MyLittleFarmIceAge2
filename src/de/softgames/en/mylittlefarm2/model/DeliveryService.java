package de.softgames.en.mylittlefarm2.model;

import java.io.Serializable;

public class DeliveryService implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int [] deliveryId = new int[6];
	private int [] classType = new int[6]; // crops or products;
	private int [] rewardCoins = new int[6];
	private int [] rewardXP = new int[6];
	private int [] quantityRequired = new int[6];
	private int [] quantityCurrent = new int[6];
	private boolean [] complete = new boolean[6];
	private int rewardTotalCoins;
	private int rewardTotalXP;
	private int timeRunOut;
	
	public int[] getDeliveryId() {
		return deliveryId;
	}
	
	public void setDeliveryId(int[] deliveryId) {
		this.deliveryId = deliveryId;
	}
	
	public int[] getClassType() {
		return classType;
	}
	
	public void setClassType(int[] classType) {
		this.classType = classType;
	}
	public int[] getRewardCoins() {
		return rewardCoins;
	}
	public void setRewardCoins(int[] rewardCoins) {
		this.rewardCoins = rewardCoins;
	}
	public int[] getRewardXP() {
		return rewardXP;
	}
	public void setRewardXP(int[] rewardXP) {
		this.rewardXP = rewardXP;
	}
	public int[] getQuantityRequired() {
		return quantityRequired;
	}
	public void setQuantityRequired(int[] quantityRequired) {
		this.quantityRequired = quantityRequired;
	}
	public int[] getQuantityCurrent() {
		return quantityCurrent;
	}
	public void setQuantityCurrent(int[] quantityCurrent) {
		this.quantityCurrent = quantityCurrent;
	}
	public int getRewardTotalCoins() {
		return rewardTotalCoins;
	}
	public void setRewardTotalCoins(int rewardTotalCoins) {
		this.rewardTotalCoins = rewardTotalCoins;
	}
	public int getRewardTotalXP() {
		return rewardTotalXP;
	}
	public void setRewardTotalXP(int rewardTotalXP) {
		this.rewardTotalXP = rewardTotalXP;
	}
	public int getTimeRunOut() {
		return timeRunOut;
	}
	public void setTimeRunOut(int timeRunOut) {
		this.timeRunOut = timeRunOut;
	}

	public boolean[] getComplete() {
		return complete;
	}

	public void setComplete(boolean complete, int pos) {
		this.complete[pos] = complete;
	}
	
	
	
	
}
