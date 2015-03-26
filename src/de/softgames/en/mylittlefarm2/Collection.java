package de.softgames.en.mylittlefarm2;

public class Collection {
	
	private int[] quantityItems;
	
	private int level;
	
	private int reward;
	
	// default constructor
	public Collection(){
		quantityItems = new int[5];
		for(int i = 0; i < 5; i++){
			quantityItems[i] = 0;
		}
		level = 0;
	}

	public int[] getQuantityItems() {
		return quantityItems;
	}

	public void setQuantityItems(int quantityItems, int pos) {
		this.quantityItems[pos] = quantityItems;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getReward() {
		return reward;
	}

	public void setReward(int reward) {
		this.reward = reward;
	}
	
	
}
