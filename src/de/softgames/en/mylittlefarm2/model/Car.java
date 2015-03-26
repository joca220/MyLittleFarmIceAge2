package de.softgames.en.mylittlefarm2.model;

import java.io.Serializable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import de.softgames.en.mylittlefarm2.Constants;
import de.softgames.en.mylittlefarm2.UtilSoftgames;
import de.softgames.en.mylittlefarm2.World;

public class Car implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int curentPosTiled_X;
	private int curentPosTiled_Y;
	private long timeUpdateMovement;
	private int position_X;
	private int position_Y;
	private int tiled_X;
	private int tiled_Y;
	private int direction;
	private boolean flip = false;
	private boolean active = false;
	private boolean stop = false;
	private boolean comeBack = false;
	private boolean canGetReward = false;
	private int rewardXp;
	private int rewardGold;
	
	
	private final int CRUZE = 24;
	private final int CRUZE_RETURN = 29;
	
	
	private final int CARSTOP_X = 26;
	private final int CARSTOP_Y = 24;
	
	
	public Car(int tiledX, int tiledY){
		setDirection(CharacterDirections.DIRECTION_RIGHT);
		this.tiled_X = tiledX;
		this.tiled_Y = tiledY;
	}
	
	public int getCurentPosTiled_X() {
		return curentPosTiled_X;
	}
	
	public void setCurentPosTiled_X(int curentPosTiled_X) {
		this.curentPosTiled_X = curentPosTiled_X;
	}
	
	public int getCurentPosTiled_Y() {
		return curentPosTiled_Y;
	}
	public void setCurentPosTiled_Y(int curentPosTiled_Y) {
		this.curentPosTiled_Y = curentPosTiled_Y;
	}
	public long getTimeUpdateMovement() {
		return timeUpdateMovement;
	}
	
	public void setTimeUpdateMovement(long timeUpdateMovement) {
		this.timeUpdateMovement = timeUpdateMovement;
	}
	
	public int getPosition_X() {
		return position_X;
	}


	public void setPosition_X(int position_X) {
		this.position_X = position_X + curentPosTiled_X;
	}
	

	public int getPosition_Y() {
		return position_Y;
	}


	public void setPosition_Y(int position_Y) {
		this.position_Y = position_Y + curentPosTiled_Y;
	}
	
	public int getTiled_X() {
		return tiled_X;
	}
	public void setTiled_X(int tiled_X) {
		this.tiled_X = tiled_X;
	}
	public int getTiled_Y() {
		return tiled_Y;
	}
	public void setTiled_Y(int tiled_Y) {
		this.tiled_Y = tiled_Y;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public boolean isFlip() {
		return flip;
	}
	public void setFlip(boolean flip) {
		this.flip = flip;
	}

	
	
	public void update(){
		if(isStop()){
			return;
		}
		//if(System.currentTimeMillis() - timeUpdateMovement >= 30){
			//timeUpdateMovement = System.currentTimeMillis();
		  float speed = World.mScaleFactor;//*1.5f; 
			switch(getDirection()){
				case CharacterDirections.DIRECTION_LEFT:
					
					
					curentPosTiled_X -= (4 * speed);
					curentPosTiled_Y -= (2 * speed);
					
					  if (curentPosTiled_X* -1 >= World.tamTiledX / 2) {
						  curentPosTiled_X = 0;
						  curentPosTiled_Y = 0;
						  setTiled_X(getTiled_X() - 1);
						  
						  if(getTiled_X() == CARSTOP_X && getTiled_Y() == CARSTOP_Y && !comeBack){
							  setStop(true);
						  } else if(getTiled_X() == 7 && isComeBack()){//gone car dissapear
							  setComeBack(false);
							  setDirection(CharacterDirections.DIRECTION_RIGHT);
						  }  
					}
					break;
			
				case CharacterDirections.DIRECTION_DOWN:
					curentPosTiled_X -= (4 * speed);
					curentPosTiled_Y += (2 * speed);
				
				
					if (curentPosTiled_X * -1 >= World.tamTiledX / 2) {
						  curentPosTiled_X = 0;
						  curentPosTiled_Y = 0;
						  setTiled_Y(getTiled_Y() + 1);
						  if(getTiled_Y() == CRUZE_RETURN){
							  setDirection(CharacterDirections.DIRECTION_LEFT);
						  }
						  
						
					}
					break;
			
				case CharacterDirections.DIRECTION_RIGHT:
				
					
					curentPosTiled_X += (4 * speed);
					curentPosTiled_Y += (2 * speed);
					
					  if (curentPosTiled_X >= World.tamTiledX / 2) {
						  curentPosTiled_X = 0;
						  curentPosTiled_Y = 0;
						  setTiled_X(getTiled_X() + 1);
						   if(getTiled_X() == CRUZE_RETURN){
							if(isComeBack()){
							   setDirection(CharacterDirections.DIRECTION_DOWN);
							} else {
								 setDirection(CharacterDirections.DIRECTION_UP);
							}
						  }
					}
					break;
			
				case CharacterDirections.DIRECTION_UP:
				
					curentPosTiled_X += (4 * speed);
					curentPosTiled_Y -= (2 * speed);
					
					  if (curentPosTiled_X >= World.tamTiledX / 2) {
						  curentPosTiled_X = 0;
						  curentPosTiled_Y = 0;
						  setTiled_Y(getTiled_Y() - 1);
						  
						   if(getTiled_Y() == CRUZE){
							  setDirection(CharacterDirections.DIRECTION_LEFT);
						  }
					}
					break;
			}
		//}
	}

	public void paint(Canvas canvas){
		Bitmap imageAux = null;
		
		imageAux = getImage(canGetReward);
			
		int widthImage = (int)(imageAux.getWidth() *  World.mScaleFactor);
		int heightImage = (int)(imageAux.getHeight() *  World.mScaleFactor);
	
		if(isFlip()){
			World.mMatrixflip.setTranslate(getPosition_X() + widthImage - widthImage/2, getPosition_Y() - (heightImage/4)*3);
			World.mMatrixflip.preScale(World.mScaleFactor* -1, World.mScaleFactor);
			canvas.drawBitmap(imageAux, World.mMatrixflip, null);
		} else {
			World.mMatrixflip.setTranslate(getPosition_X()  - widthImage/2, getPosition_Y() - (heightImage/4)*3);
			World.mMatrixflip.preScale(World.mScaleFactor, World.mScaleFactor);
			canvas.drawBitmap(imageAux, World.mMatrixflip, null);
		}
		
		if((canGetReward && isStop())){
			UtilSoftgames.paintAnimationStart(canvas, getPosition_X()  , getPosition_Y());
		}
		
	}
	
	private Bitmap getImage(boolean canGetReward){
		Bitmap imageAux = null;
		
			switch(direction){
				case CharacterDirections.DIRECTION_DOWN:
					 if(isComeBack() && isCanGetReward()){ 
							imageAux = Constants.carTruck[2];
					} else if(canGetReward){
						imageAux = Constants.carTruck[4];
					} else {
						imageAux = Constants.carTruck[0];
					}
					flip = false;
					break;
				case CharacterDirections.DIRECTION_LEFT:
					
					 if(isComeBack() && isCanGetReward()){ 
						imageAux = Constants.carTruck[1];
					} else if(canGetReward){
						imageAux = Constants.carTruck[5];
					} else {
						imageAux = Constants.carTruck[3];
					}
					flip = false;
					break;
				case CharacterDirections.DIRECTION_RIGHT:
					
					 if(isComeBack() && isCanGetReward()){ 
							imageAux = Constants.carTruck[2];
					} else if(canGetReward){
						imageAux = Constants.carTruck[4];
					} else {
						imageAux = Constants.carTruck[0];
					}
					flip = true;
					break;
				case CharacterDirections.DIRECTION_UP:

					if(isComeBack() && isCanGetReward()){ 
						imageAux = Constants.carTruck[1];
					} else if(canGetReward){
						imageAux = Constants.carTruck[5];
					} else {
						imageAux = Constants.carTruck[3];
					}
					flip = true;
					break;
			}
		
		return imageAux;
	}
	
	
	
	public boolean isCanGetReward() {
		return canGetReward;
	}

	public void setCanGetReward(boolean canGetReward) {
		this.canGetReward = canGetReward;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean isComeBack() {
		return comeBack;
	}

	public void setComeBack(boolean comeBack) {
		this.comeBack = comeBack;
	}

	public int getRewardXp() {
		return rewardXp;
	}

	public void setRewardXp(int rewardXp) {
		this.rewardXp = rewardXp;
	}

	public int getRewardGold() {
		return rewardGold;
	}

	public void setRewardGold(int rewardGold) {
		this.rewardGold = rewardGold;
	}
	
	
}
