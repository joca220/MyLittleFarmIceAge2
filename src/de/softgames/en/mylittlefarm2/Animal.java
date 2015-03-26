package de.softgames.en.mylittlefarm2;


import android.graphics.Bitmap;
import android.graphics.Canvas;


public class Animal {
    private int Pos_X = 0;

    private int Pos_Y = 0;

    private boolean selected = false;

    private int typeBuildingOwner = 0;

    /*
     * private int posX_1; private int posY_1; private int posX_2; private int
     * posY_2; private int posX_3; private int posY_3;
     */

    private boolean openMenu = false;

    private boolean showTimeUnderConstruction = false;

    private boolean producing = false;

    private int type;

    private int tileAnimationBuilding = 1;

    private int tileAnimationAnimals = 1;

    private boolean statusActive = true;

    public long currentTime = 0;

    private int moneyWin = 0;

    private int moneyPay = 0;

    private int moneyPayDiamonts = 0;

    private int expWin;

    private int avalaible;

    // private int timePlow = 10000;

    // private int timeUnderConstruct = 120;

    private int timeTranscurrentProducing = 0;

    private boolean ready = true;

    private boolean flip = false;

    private long timeStar = 0;

    private int status = 0;

    private boolean menuRotate = false;

    private int updgrade = 1;

    private boolean moveFree = false;

    private int numberProductToProduce = 0;

    private int currentProducts = 0;

    private int nFrames = 10;

    public void setAllPos(int Pos_X, int Pos_Y) {
        this.Pos_X = Pos_X;
        this.Pos_Y = Pos_Y;

    }

    public Animal(int Pos_X, int Pos_Y, int type, int typeBuildingOwner) {
        this.Pos_X = Pos_X;
        this.Pos_Y = Pos_Y;
        this.type = type;
        this.typeBuildingOwner = typeBuildingOwner;
        this.status = Constants.STATUS_ANIMALS_HUNGRY;
        timeTranscurrentProducing = Constants.PRODUCT_ANIMAL_INFO[type][3];

        moneyWin = 100;// cadMoneWin[type];
        moneyPay = 100;// cadMoneyPay[type];
        moneyPayDiamonts = 0;// cadMoneyPayDiamonts[type];
        expWin = 20;// cadExp[type];
        avalaible = 0;// cadAvailable[type];
        // timePlow = transformTime(1,0);
        // timeUnderConstruct = Constants.animalsTimeToConstruct[type][0];

        updgrade = 1;
    }

    public void paintFood(Canvas canvas, int Pos_Initial_X, int Pos_Initial_Y) {
  	  int posX = Pos_Initial_X + World.posWorldX;
        int posY = Pos_Initial_Y + World.posWorldY;
       
        
        if(getType() == 6){
        	posX += 15;
        	posY += 10;
        }
        if (isMoveFree()) {

            return;
        }

        int posAnimal_X = posX;
        int posAnimal_Y = posY;

        if (getCurrentProducts() != 0) {
            canvas.drawBitmap(Constants.productByAnimals[getType()],
                    Pos_Initial_X + World.posWorldX
                            + World.tamTiledX / 2
                            - Constants.productByAnimals[0].getWidth() / 2,
                    Pos_Initial_Y + World.posWorldY
                            - Constants.productByAnimals[0].getHeight(), null);
        }

        switch (status) {
        case Constants.STATUS_ANIMALS_DONE:
            break;
        case Constants.STATUS_ANIMALS_READY:
        	

            canvas.drawBitmap(
                    Constants.productByAnimals[getType()],
                    posAnimal_X + World.tamTiledX / 2 - Constants.productByAnimals[getType()].getWidth() / 2,
                    posAnimal_Y + World.tamTiledY / 2 - (int) (Constants.animalsProducing[getType()][0].getHeight() * World.mScaleFactor) + 5 
                    - Constants.productByAnimals[getType()].getHeight(),
                    null);

            break;
        case Constants.STATUS_ANIMALS_HUNGRY:
        	

            canvas.drawBitmap(Constants.cloudEmpty,
                    posAnimal_X + World.tamTiledX / 2
                            - Constants.cloudEmpty.getWidth() / 2, posAnimal_Y
                            - Constants.cloudEmpty.getHeight(), null);

            canvas.drawBitmap(Constants.foodAnimalSleep,
                    posAnimal_X + World.tamTiledX / 2
                            - Constants.foodAnimalSleep.getWidth() / 2,
                    posAnimal_Y - Constants.cloudEmpty.getHeight() / 2
                            - Constants.foodAnimalSleep.getHeight() / 2 - 20,
                    null);

            canvas.drawText("X " + Constants.PRODUCT_ANIMAL_INFO[getType()][4],
                    posAnimal_X + World.tamTiledX / 2, posAnimal_Y
                            - Constants.cloudEmpty.getHeight() / 2
                            - Constants.foodAnimalSleep.getHeight() / 2 + 20,
                    Constants.fontAnimalfood);

           

            break;
        case Constants.STATUS_ANIMALS_WORKING:
        
            break;
        }

        posAnimal_X += World.tamTiledX / 2;
        posAnimal_Y += World.tamTiledY / 2;

  }
    
    
    public void paint(Canvas canvas, int Pos_Initial_X, int Pos_Initial_Y) {
        int posX = Pos_Initial_X + World.posWorldX;
        int posY = Pos_Initial_Y + World.posWorldY;
        Bitmap auxBitmap  = null;
       
        
        if(getType() == 6){
        	posX += 15;
        	posY += 10;
        }
        if (isMoveFree()) {

            return;
        }

        int posAnimal_X = posX;
        int posAnimal_Y = posY;

     /*   if (getCurrentProducts() != 0) {
            canvas.drawBitmap(Constants.productByAnimals[getType()],
                    Pos_Initial_X + World.posWorldX
                            + World.tamTiledX / 2
                            - Constants.productByAnimals[0].getWidth() / 2,
                    Pos_Initial_Y + World.posWorldY
                            - Constants.productByAnimals[0].getHeight(), null);
        }*/

        switch (status) {
        case Constants.STATUS_ANIMALS_DONE:
            break;
        case Constants.STATUS_ANIMALS_READY:
        	  auxBitmap = Constants.animalsProducing[getType()][0];
         
        	  World.mMatrixflip.setTranslate(posAnimal_X + World.tamTiledX/ 2 - (auxBitmap.getWidth()* World.mScaleFactor) / 2, 
        			  posAnimal_Y + World.tamTiledY/ 2
                      - (auxBitmap.getHeight()* World.mScaleFactor) + 5);
        	  
              World.mMatrixflip.preScale(World.mScaleFactor,  World.mScaleFactor);
              canvas.drawBitmap(auxBitmap,World.mMatrixflip, null);

           /* canvas.drawBitmap(
                    Constants.productByAnimals[getType()],
                    posAnimal_X + World.tamTiledX / 2 - Constants.productByAnimals[getType()].getWidth() / 2,
                    posAnimal_Y + World.tamTiledY / 2 - (int) (Constants.animalsProducing[getType()][0].getHeight() * World.mScaleFactor) + 5 
                    - Constants.productByAnimals[getType()].getHeight(),
                    null);*/

            break;
        case Constants.STATUS_ANIMALS_HUNGRY:
        	  auxBitmap = Constants.animalsHungry[getType()][tileAnimationAnimals-1];
         
        	  

        	  World.mMatrixflip.setTranslate(posAnimal_X + World.tamTiledX/ 2 - (auxBitmap.getWidth()* World.mScaleFactor) / 2, 
        			  posAnimal_Y + World.tamTiledY/ 2
                      - (auxBitmap.getHeight()* World.mScaleFactor) + 5);
        	  
              World.mMatrixflip.preScale(World.mScaleFactor,  World.mScaleFactor);
              canvas.drawBitmap(auxBitmap,World.mMatrixflip, null);

            /*canvas.drawBitmap(Constants.cloudEmpty,
                    posAnimal_X + World.tamTiledX / 2
                            - Constants.cloudEmpty.getWidth() / 2, posAnimal_Y
                            - Constants.cloudEmpty.getHeight(), null);

            canvas.drawBitmap(Constants.foodAnimalSleep,
                    posAnimal_X + World.tamTiledX / 2
                            - Constants.foodAnimalSleep.getWidth() / 2,
                    posAnimal_Y - Constants.cloudEmpty.getHeight() / 2
                            - Constants.foodAnimalSleep.getHeight() / 2 - 20,
                    null);

            canvas.drawText("X " + Constants.PRODUCT_ANIMAL_INFO[getType()][4],
                    posAnimal_X + World.tamTiledX / 2, posAnimal_Y
                            - Constants.cloudEmpty.getHeight() / 2
                            - Constants.foodAnimalSleep.getHeight() / 2 + 20,
                    Constants.fontAnimalfood);
*/
            if (System.currentTimeMillis() - timeStar >= 80) {
                timeStar = System.currentTimeMillis();
                tileAnimationAnimals++;
                if (tileAnimationAnimals >= 10) {
                    tileAnimationAnimals = 1;
                }
            }

            break;
        case Constants.STATUS_ANIMALS_WORKING:
        	auxBitmap = Constants.animalsProducing[getType()][tileAnimationAnimals -1];
          
        	
        	 World.mMatrixflip.setTranslate(posAnimal_X + World.tamTiledX/ 2 - (auxBitmap.getWidth()* World.mScaleFactor) / 2, 
       			  posAnimal_Y + World.tamTiledY/ 2 - (auxBitmap.getHeight()* World.mScaleFactor) + 5);
       	  
             World.mMatrixflip.preScale(World.mScaleFactor,  World.mScaleFactor);
             canvas.drawBitmap(auxBitmap,World.mMatrixflip, null);

            if (System.currentTimeMillis() - timeStar >= 80) {
                timeStar = System.currentTimeMillis();
                tileAnimationBuilding++;
                if (tileAnimationBuilding == 6) {
                    tileAnimationBuilding = 1;
                }

                tileAnimationAnimals++;

                if (tileAnimationAnimals >= 10) {
                    tileAnimationAnimals = 1;
                }
            }
            break;
        }

        posAnimal_X += World.tamTiledX / 2;
        posAnimal_Y += World.tamTiledY / 2;

    }

    public int getMoneyWin() {
        return moneyWin;
    }

    public void setMoneyWin(int moneyWin) {
        this.moneyWin = moneyWin;
    }

    public int getMoneyPay() {
        return moneyPay;
    }

    public void setMoneyPay(int moneyPay) {
        this.moneyPay = moneyPay;
    }

    public int getMoneyPayDiamonts() {
        return moneyPayDiamonts;
    }

    public void setMoneyPayDiamonts(int moneyPayDiamonts) {
        this.moneyPayDiamonts = moneyPayDiamonts;
    }

    public int getExpWin() {
        return expWin;
    }

    public void setExpWin(int expWin) {
        this.expWin = expWin;
    }

    public int getAvalaible() {
        return avalaible;
    }

    public void setAvalaible(int avalaible) {
        this.avalaible = avalaible;
    }

    public long getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(long currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int value) {
        this.status = value;
    }

    public boolean isOpenMenu() {
        return openMenu;
    }

    public void setOpenMenu(boolean openMenu) {
        this.openMenu = openMenu;
    }

    public int getUpdgrade() {
        return updgrade;
    }

    public void setUpdgrade(int updgrade) {
        // timeUnderConstruct =
        // Constants.animalsTimeToConstruct[type][updgrade];
        this.updgrade = updgrade;
    }

    public boolean isMenuRotate() {
        return menuRotate;
    }

    public void setMenuRotate(boolean menuRotate) {
        this.menuRotate = menuRotate;
    }

    public boolean isShowTimeUnderConstruction() {
        return showTimeUnderConstruction;
    }

    public void setShowTimeUnderConstruction(boolean showTimeUnderConstruction) {
        this.showTimeUnderConstruction = showTimeUnderConstruction;
    }

    /*
     * public int getTimeUnderConstruct() { return timeUnderConstruct; }
     * 
     * public void setTimeUnderConstruct(int timeUnderConstruct) {
     * if(timeUnderConstruct <= 0){ timeUnderConstruct = 0; }
     * this.timeUnderConstruct = timeUnderConstruct; }
     */

    public boolean isMoveFree() {
        return moveFree;
    }

    public void setMoveFree(boolean moveFree) {
        this.moveFree = moveFree;
    }

    public boolean getProducing() {
        return producing;
    }

    public void setProducing(boolean value) {
        this.producing = value;
    }

    public int getTimeTranscurrentProducing() {
        return timeTranscurrentProducing;
    }

    public void setTimeTranscurrentProducing(int value) {
        this.timeTranscurrentProducing = value;
    }

    public int getNumberProductToProduce() {
        return numberProductToProduce;
    }

    public void setNumberProductToProduce(int numberProductToProduce) {
        this.numberProductToProduce = numberProductToProduce;
    }

    public int getCurrentProducts() {
        return currentProducts;
    }

    public void setCurrentProducts(int value) {
        this.currentProducts = value;
    }

    public int getPos_X() {
        return Pos_X;
    }

    public void setPos_X(int pos_X) {
        Pos_X = pos_X;
    }

    public int getPos_Y() {
        return Pos_Y;
    }

    public void setPos_Y(int pos_Y) {
        Pos_Y = pos_Y;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isStatusActive() {
        return statusActive;
    }

    public void setStatusActive(boolean statusActive) {
        this.statusActive = statusActive;
    }

    /*
     * public String getTimeForConstruction(){ return
     * UtilSoftgames.secondsToString(getTimeUnderConstruct()); }
     */

    public String getTimeForProducing() {
        return UtilSoftgames.secondsToString(getTimeTranscurrentProducing());
    }

    public int transformTime(int minutes, int hours) {
        int seconds = 0;
        if (hours != 0) {
            minutes = hours * 60;
        }

        seconds = ((minutes * 60));
        // seconds = 200;

        return seconds;
    }

    public boolean canUpgrade() {

        return false;
    }

    public boolean getFlip() {
        return flip;
    }

    public void setFlip(boolean value) {
        this.flip = value;
    }

    public boolean getSelected() {
        return selected;
    }

    public void setSelected(boolean value) {
        this.selected = value;
    }

    public int getTypeBuildingOwner() {
        return typeBuildingOwner;
    }

    public void setTypeBuildingOwner(int typeBuildingOwner) {
        this.typeBuildingOwner = typeBuildingOwner;
    }

}
