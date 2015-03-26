package de.softgames.en.mylittlefarm2;


import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Crop {
    private int posX;
    private int posY;
    private int timeTranscurrent = 0;
    private int type;
    private int tiled = 1;
    private boolean withered = false;
    private boolean selected = false;
    private boolean isReady;
    private int nAnimation = 1;
    private boolean flip = false;
    private int id;
    public int timeWatering = 20;
    public boolean readyWatering = false;
    public boolean animationReadyWatering = false;
    public long timeAnimatioWatering = 0;
    public int tiledWateringAnim = 1;
    public int timeTransWater = 0;
    private boolean menuRotate = false;
    private boolean moveFree = false;

    public Crop(int type, int posX, int posY) {
        this.posX = posX;
        this.posY = posY;
        this.type = type;
        isReady = false;
    }

    public void died() {
        this.posX = -1000;
        this.posY = -1000;
        this.type = 0;
        isReady = false;
        withered = false;
    }

    public void paintMove(Canvas canvas) {
    	//canvas.drawBitmap(bitmap, matrix, null);
      /*  Constants.cropsImage[getType()]
                .paint(canvas,
                        getTiled(),
                        (int) (World.posMoveFreeX)
                                - (int) (Constants.cropsImage[getType()].auxImage
                                        .getWidth() * World.mScaleFactor / 8)
                                / 2,
                        (int) (World.posMoveFreeY)
                                - ((int) (Constants.cropsImage[getType()].auxImage
                                        .getHeight() * World.mScaleFactor) / 2),
                        (int) (Constants.cropsImage[getType()].auxImage
                                .getHeight() * World.mScaleFactor),
                        (int) (Constants.cropsImage[getType()].auxImage
                                .getWidth() * World.mScaleFactor) / 8,
                        true, true, isFlip());*/

    }

    public void paint(Canvas canvas, int Pos_Initial_X, int Pos_Initial_Y,
            boolean isSelected) {
    	Bitmap auxBitmap = Constants.cropsImage[getType()][getTiled()-1];
    	
    	if(auxBitmap == null)return;
        if (isMoveFree()) {
            /*Constants.cropsImage[getType()]
                    .paint(canvas,
                            getTiled(),
                            (int) (World.posMoveFreeX)
                                    - (int) (Constants.cropsImage[getType()].auxImage
                                            .getWidth()
                                            * World.mScaleFactor / 8) / 2,
                            (int) (World.posMoveFreeY)
                                    - ((int) (Constants.cropsImage[getType()].auxImage
                                            .getHeight() * World.mScaleFactor) / 2),
                            (int) (Constants.cropsImage[getType()].auxImage
                                    .getHeight() * World.mScaleFactor),
                            (int) (Constants.cropsImage[getType()].auxImage
                                    .getWidth() * World.mScaleFactor) / 8,
                            true, true, isFlip());*/
        	
        	  World.mMatrixflip.setTranslate((int) (World.posMoveFreeX) - (auxBitmap.getWidth()* World.mScaleFactor) / 2, 
        			  			(int) (World.posMoveFreeY) - (auxBitmap.getHeight()* World.mScaleFactor)/2);
        	  
              World.mMatrixflip.preScale(World.mScaleFactor,  World.mScaleFactor);
              canvas.drawBitmap(auxBitmap,World.mMatrixflip, null);

            return;
        }

        
        World.mMatrixflip.setTranslate(Pos_Initial_X + World.posWorldX, 
        		Pos_Initial_Y + World.posWorldY + World.tamTiledY - (int) (auxBitmap .getHeight() * World.mScaleFactor));
      
        World.mMatrixflip.preScale(World.mScaleFactor,  World.mScaleFactor);
        
        canvas.drawBitmap(auxBitmap,World.mMatrixflip, null);
        /*Constants.cropsImage[getType()]
                .paint(canvas,
                        getTiled(),
                        Pos_Initial_X + World.posWorldX,
                        Pos_Initial_Y
                                + World.posWorldY
                                + World.tamTiledY
                                - (int) (Constants.cropsImage[getType()].auxImage
                                        .getHeight() * World.mScaleFactor),

                        (int) (Constants.cropsImage[getType()].auxImage
                                .getHeight() * World.mScaleFactor),
                        (int) (Constants.cropsImage[getType()].auxImage
                                .getWidth() * World.mScaleFactor) / 8,
                        true, isSelected, isFlip());*/

        Paint_Water(canvas, Pos_Initial_X + World.posWorldX
                + World.tamTiledX / 2, Pos_Initial_Y
                + World.posWorldY + World.tamTiledY / 2);

        if (isReady()) {
            UtilSoftgames.paintAnimationStart(canvas, Pos_Initial_X
                    + World.posWorldX + World.tamTiledX / 2, Pos_Initial_Y
                    + World.posWorldY + World.tamTiledY / 2);
        }

    }

    private void Paint_Water(Canvas canvas, int PosWater_X, int PosWater_Y) {
        if (readyWatering) {
            if (animationReadyWatering) {
              /*  Constants.animationWaterCrop.paint(
                        canvas,
                        nAnimation,
                        PosWater_X
                                - (Constants.animationWaterCrop.auxImage
                                        .getWidth() / 4) / 2 - 10,
                        PosWater_Y
                                - Constants.animationWaterCrop.auxImage
                                        .getHeight() / 2 - 15,
                        Constants.animationWaterCrop.auxImage.getHeight(),
                        Constants.animationWaterCrop.auxImage.getWidth() / 4,
                        false, false, false);*/
            	   World.mMatrixflip.setTranslate(PosWater_X  - Constants.animationWaterCrop[nAnimation-1].getWidth()/2 -2, 
            			   PosWater_Y  - Constants.animationWaterCrop[nAnimation-1].getHeight() / 2 - 1);
                 
                   World.mMatrixflip.preScale(World.mScaleFactor,  World.mScaleFactor);
                   
                   canvas.drawBitmap(Constants.animationWaterCrop[nAnimation-1],World.mMatrixflip, null);
                if (System.currentTimeMillis() - timeAnimatioWatering >= 300) {
                    timeAnimatioWatering = System.currentTimeMillis();
                    nAnimation++;

                    if (nAnimation == 5) {
                        nAnimation = 1;
                        animationReadyWatering = false;
                        readyWatering = false;
                        timeWatering = 10 * 60;// 30*60;
                        timeTransWater = 0;
                    }
                }
            } else {
              /*  Constants.waterReady_Img.paint(
                        canvas,
                        tiledWateringAnim,
                        PosWater_X
                                - (Constants.waterReady_Img.auxImage
                                        .getWidth() / 4) / 2 - 10,
                        PosWater_Y
                                - Constants.waterReady_Img.auxImage
                                        .getHeight() / 2 - 15,
                        Constants.waterReady_Img.auxImage.getHeight(),
                        Constants.waterReady_Img.auxImage.getWidth() / 4,
                        false, false, false);*/
            	
            	 
            	World.mMatrixflip.setTranslate(PosWater_X  - Constants.waterReady_Img[tiledWateringAnim-1].getWidth()/2 - 2, 
         			   PosWater_Y  - Constants.waterReady_Img[tiledWateringAnim-1].getHeight() / 2 - 1);
              
                World.mMatrixflip.preScale(World.mScaleFactor,  World.mScaleFactor);
                
                canvas.drawBitmap(Constants.waterReady_Img[tiledWateringAnim-1],World.mMatrixflip, null);

                if (System.currentTimeMillis() - timeAnimatioWatering >= 150) {
                    timeAnimatioWatering = System.currentTimeMillis();
                    tiledWateringAnim++;
                    if (tiledWateringAnim == 5) {
                        tiledWateringAnim = 1;
                    }
                }
            }

        }
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTimeTranscurrent() {
        return timeTranscurrent;
    }

    public void setTimeTranscurrent(int timeTranscurrent) {
        this.timeTranscurrent = timeTranscurrent;

        if (this.timeTranscurrent < (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) / 5)) {
            setTiled(1);
        } else if (this.timeTranscurrent < (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) / 5) * 2) {
            setTiled(2);
        } else if (this.timeTranscurrent < (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) / 5 * 3)) {
            setTiled(3);
        } else if (this.timeTranscurrent < (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) / 5 * 4)) {
            setTiled(4);
        } else if (this.timeTranscurrent < (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) / 5 * 5)) {
            setTiled(5);
        } else if (this.timeTranscurrent < (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) + (Constants.CROPS_TIME_TO_WIN[getType()] * 60) / 3)) {
            setTiled(5);
        } else if (this.timeTranscurrent < (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) + (Constants.CROPS_TIME_TO_WIN[getType()] * 60) / 2)) {
            setTiled(5);
        } else {
            setTiled(5);
        }

        timeTransWater++;
        if (!readyWatering) {
            if (getTiled() <= 4) {
                if (timeTransWater >= timeWatering) {
                    readyWatering = true;
                }
            }
        }
    }

    public int getTiled() {
        return tiled;
    }

    public void setTiled(int tiled) {
        this.tiled = tiled;
        if (!isReady && this.tiled == 5) {
            this.timeTranscurrent = (((Constants.CROPS_TIME_TO_WIN[getType()] * 60)) / 5 * 4);
            readyWatering = false;
            isReady = true;
        }

        if (this.tiled >= 7) {
            isReady = false;
        }
    }

    public String getTimeForPay(boolean isTimeHarvest) {
        String timeForHarvert = " ";
        if (isWhitered() || isReady()) {
            return "0: 00: 00";
        }

        int seconds = 0;

        if (isTimeHarvest) {
            seconds = (Constants.CROPS_TIME_TO_WIN[getType()] * 60)
                    - timeTranscurrent;
        } else {
            seconds = timeWatering - timeTransWater;
        }
        if (seconds <= 0) {
            return "0: 00: 00";
        }

        timeForHarvert = UtilSoftgames.secondsToString(seconds);

        return timeForHarvert;
    }

    public boolean isReady() {
        isReady = false;
        if (getTiled() >= 5 && getPosX() != -1000) {
            isReady = true;
        }
        return isReady;
    }

    public void setReady(boolean isReady) {
        this.isReady = isReady;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isWhitered() {

        withered = false;

        return withered;
    }

    public void setMarchito(boolean marchito) {
        this.withered = marchito;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isMenuRotate() {
        return menuRotate;
    }

    public void setMenuRotate(boolean menuRotate) {
        this.menuRotate = menuRotate;
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public boolean isMoveFree() {
        return moveFree;
    }

    public void setMoveFree(boolean moveFree) {
        this.moveFree = moveFree;
    }

}
