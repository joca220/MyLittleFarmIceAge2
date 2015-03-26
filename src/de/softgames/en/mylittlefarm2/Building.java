package de.softgames.en.mylittlefarm2;


import android.graphics.Canvas;
import android.util.Log;


public class Building {
    private int posX;
    private int posY;
    private int posX_1;
    private int posY_1;
    private int posX_2;
    private int posY_2;
    private int posX_3;
    private int posY_3;
    private boolean ready = false;
    // private boolean openMenu = false;
    private boolean menuRotate = false;
    private boolean moveFree = false;
    private boolean flip = false;
    private int type;
    // private int nUpdgrade;
    // public int[] products = new int[5];
    // public int prouductChoosed = -1;
    private int updgrade = 0;
    private int timeUnderConstruct = 120;
    private boolean showTimeUnderConstruction = false;

    public enum Status {
        EMPTY, READY, PRODUCING, PRODUCED, CHOOSE
    };

    private long timeStar = 0;
    private int tileAnimationBuilding = 1;
    private int exp;
    private int coins;
    private int[] timeProducts = new int[4];
    private int timeTranscurrent;
    private int[] itemProduce = new int[4];

    private int[] itemProducingInSlot = new int[5];
    private int[] timeProductsInSlot = new int[5];

    private int currentSlotActive = 0;
    private int valueToPay;
    private int[] materialProcesing1 = new int[4];
    private int[] materialProcesing2 = new int[4];
    private int[] quantityMaterialProcesing1 = new int[4];
    private int[] quantityMaterialProcesing2 = new int[4];

    private int[] diamondAddMaterial_1 = new int[4];
    private int[] diamondAddMaterial_2 = new int[4];

    private int available;
    private int friendsRequired;

    private int[] slot = new int[5];
    private int diamondFinishTime;
    private Status currentStatus;
    private int classType = 0;

    private boolean isFourSpace;

    private boolean openBuilding = false;

    public Building(int posX, int posY, int type, int classType,
            boolean isFourSpace) {
        this.posX = posX;
        this.posY = posY;
        setPosX_1(posX);
        setPosY_1(posY + 1);
        setPosX_2(posX + 1);
        setPosY_2(posY);
        setPosX_3(posX + 1);
        setPosY_3(posY + 1);

        this.type = type;
        this.classType = classType;
        this.isFourSpace = isFourSpace;
        this.currentStatus = Status.CHOOSE;
        setOpenBuilding(false);

        this.timeTranscurrent = 0;

        if (classType == Constants.BUILDINGNORMAL) {
            this.available = Constants.BUILDING_AVAILABLE[getType()][0];
            this.coins = Constants.BUILDING_COINS[getType()];
            this.exp = Constants.BUILDING_EXP[getType()];
            timeUnderConstruct = transformToSeconds(
                    Constants.BUILDING_NEED_UPGRADE[getPosOrderInfos()][6],
                    Constants.BUILDING_NEED_UPGRADE[getPosOrderInfos()][7]);
            for (int i = 0; i < 4; i++) {
                this.itemProduce[i] = Constants.BUILDING_PRODUCTS[getPosOrderInfos()
                        + i][0];
                this.materialProcesing1[i] = Constants.BUILDING_PRODUCTS[getPosOrderInfos()
                        + i][1];
                this.quantityMaterialProcesing1[i] = Constants.BUILDING_PRODUCTS[getPosOrderInfos()
                        + i][2];
                this.materialProcesing2[i] = Constants.BUILDING_PRODUCTS[getPosOrderInfos()
                        + i][3];
                this.quantityMaterialProcesing2[i] = Constants.BUILDING_PRODUCTS[getPosOrderInfos()
                        + i][4];
                this.timeProducts[i] = Constants.BUILDING_PRODUCTS[getPosOrderInfos()
                        + i][8] * 60;

                this.diamondAddMaterial_1[i] = getDiamondsFinishProducts(
                        this.materialProcesing1[i], 9);// Constants.buildingProducts[getPosOrderInfos()
                                                       // + i][9];
                this.diamondAddMaterial_2[i] = getDiamondsFinishProducts(
                        this.materialProcesing2[i], 9);// Constants.buildingProducts[getPosOrderInfos()
                                                       // + i][9];

            }
        } else if (classType == Constants.BUILDINGANIMAL) {
            timeUnderConstruct = getPosOnlyEnclousure() * 60;// transformToSeconds(Constants.buildingNeedUpgrade[getPosOrderInfos()][6],
                                                                                                    // Constants.buildingNeedUpgrade[getPosOrderInfos()][7]);
        }

        this.diamondFinishTime = 1;

        for (int i = 0; i < 5; i++) {
            slot[i] = (i < 2) ? 0 : 1;
        }

        
      /*  if (Constants.buildings[Constants.BUILDING_ORD[type]][getUpdgrade()] == null) {
        	loadBuildingsImg(Constants.BUILDING_ORD[type], getUpdgrade());
        }*/
    }

    
   /* private void loadBuildingsImg(int type, int upgrade) {
        switch (type) {

        case Constants.ENCLOSURE_CHICKEN:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/enclousure/chicken.png", false);
            break;
        case Constants.BAKERY:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/bakery/bakery0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.ENCLOSURE_COW:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/enclousure/cow.png", false);
            break;
        case Constants.ENCLOSURE_SHEEP:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/enclousure/sheep.png", false);
            break;
        case Constants.ENCLOSURE_PIG:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/enclousure/pig.png", false);
            break;
        case Constants.CAKE:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/cakes/cakes0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.DAIRY:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/Dairy/dairy0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.ENCLOSURE_GOAT:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/enclousure/goat.png", false);
            break;
        case Constants.FRUIT_SMASHER:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/Fruit/fruitsmasher0" + (upgrade + 1) + ".png",
                    false);
            break;
        case Constants.SUGAR_FACTORY:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/Sugar/sugar0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.GRILL:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/Grill/grill0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.RESTAURANT:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/Gourmet/gourmet0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.WEAVING_BUILDING:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/Wheel/wheel0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.TAILOR:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/Tailor/tailor0" + (upgrade + 1) + ".png", false);
            break;

        case 16:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/farmhouse/farmhouse0" + (upgrade + 1) + ".png",
                    false);
            break;
        case 17:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/barn/barn0" + (upgrade + 1) + ".png", false);
            break;
        case Constants.FEED_MILL:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/foodmill/foodmachine0" + (upgrade + 1) + ".png",
                    false);
            break;
        case 19:
            Constants.buildings[type][upgrade] = UtilSoftgames.loadImageAssetsSimple(
                    "building/windmill/windmill0" + (upgrade + 1) + ".png",
                    false);
            break;

        }

    }*/
    
    private int getPosOnlyEnclousure() {
        int pos = -1;
       // 5, 10, 30,
       // 60, 120,7,45,260,360 ,
       // 2 ,10 ,35
        switch(Constants.BUILDING_ORD[getType()]){
       case Constants.ENCLOSURE_GOAT:
    	   
    	   return 120;
       case Constants.ENCLOSURE_SHEEP:
    	   
    	   return 30;
       case Constants.ENCLOSURE_CHICKEN:
    	   
    	   return 5;
       case Constants.ENCLOSURE_PIG:
    	   
    	   return 60;
       case Constants.ENCLOSURE_COW :
    	   
    	   return 10;
       case Constants.ENCLOSURE_GOOSE:
    	   
    	   return 7;
       case Constants.ENCLOSURE_DUCK:
    	   
    	   return 45;
       case Constants.ENCLOSURE_HORSE:
    	   
    	   return 260;
       case Constants.ENCLOSURE_ANGORA:
    	   
    	   return 360;
       case Constants.ENCLOSURE_BEE:
    	   
    	   return 2;
       case Constants.ENCLOSURE_BUFFALO:
    	   
    	   return 10;
       case Constants.ENCLOSURE_SQUIRELL:
    	   
    	   return 35;
        
        }
        
        return pos;
    }

    public int transformToSeconds(int quantity, int typeTime) {
        int seconds = 0;
        if (typeTime == Constants.MINUTES) {
            seconds = quantity * 60;
        } else {
            seconds = quantity * 60 * 60;
        }

        return seconds;
    }

    public int getPosOrderInfos() {
        int posInfo = 0;
        switch (Constants.BUILDING_ORD[getType()]) {
        case Constants.BAKERY:
            posInfo = 0 * 4;
            break;
        case Constants.CAKE:
            posInfo = 1 * 4;
            break;
        case Constants.DAIRY:
            posInfo = 2 * 4;
            break;
        case Constants.FRUIT_SMASHER:
            posInfo = 3 * 4;
            break;
        case Constants.SUGAR_FACTORY:
            posInfo = 4 * 4;
            break;
        case Constants.GRILL:
            posInfo = 5 * 4;
            break;
        case Constants.RESTAURANT:
            posInfo = 6 * 4;
            break;
        case Constants.WEAVING_BUILDING:
            posInfo = 7 * 4;
            break;
        case Constants.TAILOR:
            posInfo = 8 * 4;
            break;
        case Constants.WIND_MILL:
            posInfo = 9 * 4;
            break;
        case Constants.STORAGE:
            posInfo = 16 * 4;
            break;
        case Constants.FEED_MILL:
            posInfo = (17 * 4) + 1;
            break;
        case Constants.CHEESE_DAIRY:
        	 posInfo = 10 * 4;
        	break;
        case Constants.FLOWER_SHOP:
        	 posInfo = 13 * 4;
        	break;
        case Constants.JUICERY:
        	 posInfo = 11 * 4;
        	break;
        case Constants.MERMERLADE:
        	 posInfo = 12 * 4;
        	break;
        case Constants.FORGE:
        		posInfo = 14 * 4;
        		break;
        case Constants.WINTER_SHOP:
        		posInfo = 15 * 4;
       	break;
        }
        return posInfo;
    }

    public void paint(Canvas canvas, int Pos_Initial_X, int Pos_Initial_Y,
            boolean isSelected) {

        int posFinal_X = 0;
        int posFinal_Y = 0;

        if (!isReady()
                && (classType == Constants.BUILDINGNORMAL || classType == Constants.BUILDINGANIMAL) /*
                                                                                                     * &&
                                                                                                     * getUpdgrade
                                                                                                     * (
                                                                                                     * )
                                                                                                     * ==
                                                                                                     * 0
                                                                                                     */) {
            if (!isOpenBuilding()) {
                if (!isFourSpace()) {
                    posFinal_X = Pos_Initial_X + World.posWorldX;
                    posFinal_Y = Pos_Initial_Y
                            + World.posWorldY
                            + World.tamTiledY
                            - (int) (Constants.underConstruction.getHeight() * World.mScaleFactor);
                    World.mMatrixflip.setTranslate(posFinal_X, posFinal_Y);
                    World.mMatrixflip.preScale(World.mScaleFactor,
                            World.mScaleFactor);
                    canvas.drawBitmap(Constants.underConstruction,
                            World.mMatrixflip, null);
                } else {
                    posFinal_X = Pos_Initial_X
                            + World.posWorldX
                            - (int) (Constants.underConstructionBig.getWidth() * World.mScaleFactor)
                            / 2 + World.tamTiledX / 2;
                    posFinal_Y = Pos_Initial_Y
                            + World.posWorldY
                            + (World.tamTiledY * 2)
                            - (int) (Constants.underConstructionBig.getHeight() * World.mScaleFactor);
                    World.mMatrixflip.setTranslate(posFinal_X, posFinal_Y);
                    World.mMatrixflip.preScale(World.mScaleFactor,
                            World.mScaleFactor);
                    canvas.drawBitmap(Constants.underConstructionBig,
                            World.mMatrixflip, null);
                }
            } else {
                if (!isFourSpace()) {
                    posFinal_X = Pos_Initial_X + World.posWorldX;
                    posFinal_Y = Pos_Initial_Y
                            + World.posWorldY
                            + World.tamTiledY
                            - (int) (Constants.buildingReadySmall.getHeight() * World.mScaleFactor);
                    World.mMatrixflip.setTranslate(posFinal_X, posFinal_Y);
                    World.mMatrixflip.preScale(World.mScaleFactor,
                            World.mScaleFactor);
                    canvas.drawBitmap(Constants.buildingReadySmall,
                            World.mMatrixflip, null);
                } else {
                    posFinal_X = Pos_Initial_X
                            + World.posWorldX
                            - (int) (Constants.buildingReady.getWidth() * World.mScaleFactor)
                            / 2 + World.tamTiledX / 2;
                    posFinal_Y = Pos_Initial_Y
                            + World.posWorldY
                            + (World.tamTiledY * 2)
                            - (int) (Constants.buildingReady.getHeight() * World.mScaleFactor);
                    World.mMatrixflip.setTranslate(posFinal_X, posFinal_Y);
                    World.mMatrixflip.preScale(World.mScaleFactor,
                            World.mScaleFactor);
                    canvas.drawBitmap(Constants.buildingReady,
                            World.mMatrixflip, null);
                }

            }

            return;
        }

        int upd = getUpdgrade();
        if (classType == Constants.BUILDINGNORMAL
                || classType == Constants.BUILDINGANIMAL) {
            upd -= 1;
        }

        posFinal_X = Pos_Initial_X
                + World.posWorldX
                + (World.tamTiledX / 2)
                - (int) ((Constants.buildings[Constants.BUILDING_ORD[getType()]][upd]
                        .getWidth() * World.mScaleFactor)) / 2;
        posFinal_Y = Pos_Initial_Y
                + World.posWorldY
                + (World.tamTiledY * 2)
                - ((int) (Constants.buildings[Constants.BUILDING_ORD[getType()]][upd]
                        .getHeight() * World.mScaleFactor));

        if (!isFourSpace()) {
            posFinal_Y = Pos_Initial_Y
                    + World.posWorldY
                    + (World.tamTiledY - (int) (Constants.buildings[Constants.BUILDING_ORD[getType()]][upd]
                            .getHeight() * World.mScaleFactor));
        }

        int orientation = 1;
        if (isFlip()) {
            orientation = -1;
            World.mMatrixflip
                    .setTranslate(
                            posFinal_X
                                    + (int) (Constants.buildings[Constants.BUILDING_ORD[getType()]][upd]
                                            .getWidth() * World.mScaleFactor),
                            posFinal_Y);
        } else {
            World.mMatrixflip.setTranslate(posFinal_X, posFinal_Y);
        }

        World.mMatrixflip.preScale(World.mScaleFactor * orientation,
                World.mScaleFactor);

        canvas.drawBitmap(
                Constants.buildings[Constants.BUILDING_ORD[getType()]][upd],
                World.mMatrixflip, null);

        if (isMenuRotate() || isMoveFree()) {
            UtilSoftgames.animationSelectedObject(canvas,
                    Constants.buildings[Constants.BUILDING_ORD[getType()]][upd],
                    posFinal_X, posFinal_Y, isFlip(), 1, 1);
            return;
        }

        if (classType == Constants.FARMHOUSE) {
            if (Constants.achiviementsActive) {
                Constants.blink.paint(canvas, tileAnimationBuilding,
                        Pos_Initial_X + World.posWorldX
                                + World.tamTiledX / 2,
                        Pos_Initial_Y + World.posWorldY
                                + World.tamTiledY,
                        Constants.blink.auxImage.getHeight(),
                        Constants.blink.auxImage.getWidth() / 10, false,
                        false, false);

                if (System.currentTimeMillis() - timeStar >= 80) {
                    timeStar = System.currentTimeMillis();
                    tileAnimationBuilding++;
                    if (tileAnimationBuilding == 11) {
                        tileAnimationBuilding = 1;
                    }
                }
            }
            return;
        }

        if (classType != Constants.BUILDINGNORMAL || !isReady())
            return;
        if (currentStatus == Status.EMPTY) {

        } else if (validateCloudProducing()) {
            Constants.animationBuilding
                    .paint(canvas,
                            tileAnimationBuilding,
                            Pos_Initial_X
                                    + World.posWorldX
                                    + (World.tamTiledX / 2)
                                    - ((Constants.animationBuilding.auxImage
                                            .getWidth() / 5) / 2),
                            Pos_Initial_Y
                                    + World.posWorldY
                                    + (World.tamTiledY / 2)
                                    - (Constants.buildings[Constants.BUILDING_ORD[getType()]][upd]
                                            .getHeight() / 2),
                            Constants.animationBuilding.auxImage.getHeight() / 1,
                            Constants.animationBuilding.auxImage.getWidth() / 5,
                            false, false, false);

            if (System.currentTimeMillis() - timeStar >= 80) {
                timeStar = System.currentTimeMillis();
                tileAnimationBuilding++;
                if (tileAnimationBuilding == 6) {
                    tileAnimationBuilding = 1;
                }
            }
        } else if (validateCloudProduced()) {
            // UtilSoftgames.paintAnimationStart(canvas, Pos_Initial_X +
            // Constants.Pos_World_X, Pos_Initial_Y + Constants.Pos_World_Y);

            for (int i = 0; i < 5; i++) {
                if (slot[i] == 3) {
                    int typeIcon = getItemProducing()[i];
                    int posIcon_X = Pos_Initial_X + World.posWorldX
                            + World.tamTiledX / 2;
                    int posIcon_Y = Pos_Initial_Y + World.posWorldY
                            + World.tamTiledY / 2;

                    UtilSoftgames.animationSmallToBig(canvas,
                            Constants.iconProduced[typeIcon], posIcon_X,
                            posIcon_Y, 0.7f, 0.4f);

                    return;
                }
            }
        } else if (validateCloudSleep()) {
            canvas.drawBitmap(
                    Constants.cloudSleep,
                    Pos_Initial_X + World.posWorldX
                            + (World.tamTiledX / 2)
                            - Constants.cloudSleep.getWidth() / 2,
                    Pos_Initial_Y
                            + World.posWorldY
                            + (World.tamTiledY / 2)
                            - (Constants.buildings[Constants.BUILDING_ORD[getType()]][upd]
                                    .getHeight()) + 14, null);
        }
    }

    private boolean validateCloudProducing() {
        for (int i = 0; i < 5; i++) {
            if (slot[i] == 2) {
                return true;
            }
        }

        return false;
    }

    private boolean validateCloudProduced() {
        for (int i = 0; i < 5; i++) {
            if (slot[i] == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean validateCloudSleep() {
        for (int i = 0; i < 5; i++) {
            if (slot[i] != 0 && slot[i] != 1) {
                return false;
            }
        }

        return true;
    }

    public boolean canUpgrade() {

        boolean canUpdgrade = true;

        if (classType == Constants.BUILDINGANIMAL) {
            return false;
        }
        for (int i = 0; i < 5; i++) {
            if (slot[i] != 0 && slot[i] != 1) {
                canUpdgrade = false;
            }
        }

        return canUpdgrade;
    }

    public boolean canFinishAll() {

        boolean finishAll = false;

        for (int i = 0; i < 5; i++) {
            if (slot[i] == 2) {
                finishAll = true;
                break;
            }
        }

        return finishAll;
    }

    public void changeStatus(int ordinal) {
        if (ordinal == Status.READY.ordinal()) {
            this.currentStatus = Status.READY;
        } else if (ordinal == Status.PRODUCING.ordinal()) {
            this.currentStatus = Status.PRODUCING;
        } else if (ordinal == Status.PRODUCED.ordinal()) {
            this.currentStatus = Status.PRODUCED;
        } else if (ordinal == Status.CHOOSE.ordinal()) {
            this.currentStatus = Status.CHOOSE;
        }
    }

    public void setPosALL(int posX, int posY) {
        this.posX = posX;
        this.posY = posY;

        if (isFourSpace()) {
            setPosX_1(posX);
            setPosY_1(posY + 1);
            setPosX_2(posX + 1);
            setPosY_2(posY);
            setPosX_3(posX + 1);
            setPosY_3(posY + 1);
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

    public boolean isReady() {
        return ready;
    }

    public void setReady(boolean ready) {
        setOpenBuilding(false);
        this.ready = ready;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Status getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(Status currentStatus) {
        this.currentStatus = currentStatus;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int[] getTimeProducts() {
        return timeProducts;
    }

    public void setTimeProducts(int timeProducts, int pos) {
        this.timeProducts[pos] = timeProducts;
    }

    public int getTimeTranscurrent() {
        return timeTranscurrent;
    }

    public void setTimeTranscurrent(int timeTranscurrent) {
        this.timeTranscurrent = timeTranscurrent;
    }

    public int getValueToPay() {
        return valueToPay;
    }

    public void setValueToPay(int valueToPay) {
        this.valueToPay = valueToPay;
    }

    public int[] getQuantityMaterialProcesing1() {
        return quantityMaterialProcesing1;
    }

    public void setQuantityMaterialProcesing1(int[] quantityMaterialProcesing1) {
        this.quantityMaterialProcesing1 = quantityMaterialProcesing1;
    }

    public int[] getQuantityMaterialProcesing2() {
        return quantityMaterialProcesing2;
    }

    public void setQuantityMaterialProcesing2(int[] quantityMaterialProcesing2) {
        this.quantityMaterialProcesing2 = quantityMaterialProcesing2;
    }

    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getFriendsRequired() {
        return friendsRequired;
    }

    public void setFriendsRequired(int friendsRequired) {
        this.friendsRequired = friendsRequired;
    }

    public int[] getMaterialProcesing1() {
        return materialProcesing1;
    }

    public void setMaterialProcesing1(int[] materialProcesing1) {
        this.materialProcesing1 = materialProcesing1;
    }

    public int[] getMaterialProcesing2() {
        return materialProcesing2;
    }

    public void setMaterialProcesing2(int[] materialProcesing2) {
        this.materialProcesing2 = materialProcesing2;
    }

    public int[] getDiamondAddMaterial_1() {
        return diamondAddMaterial_1;
    }

    public void setDiamondAddMaterial_1(int[] diamondAddMaterial_1) {
        this.diamondAddMaterial_1 = diamondAddMaterial_1;
    }

    public int[] getDiamondAddMaterial_2() {
        return diamondAddMaterial_2;
    }

    public void setDiamondAddMaterial_2(int[] diamondAddMaterial_2) {
        this.diamondAddMaterial_2 = diamondAddMaterial_2;
    }

    public int getDiamondFinishTime() {
        return diamondFinishTime;
    }

    public void setDiamondFinishTime(int diamondFinishTime) {
        this.diamondFinishTime = diamondFinishTime;
    }

    public String getTimeForRecollect(int posProduct) {
        int seconds = 0;
        seconds = getTimeProductsInSlot()[posProduct] - getTimeTranscurrent();

        if (seconds <= 0) {
            return "0: 00: 00";
        }
        return UtilSoftgames.secondsToString(seconds);
    }

    public int[] getSlot() {
        return slot;
    }

    public void setSlot(int slot, int pos) {
        this.slot[pos] = slot;
    }

    public int getCurrentSlotActive() {
        return currentSlotActive;
    }

    public void setCurrentSlotActive(int currentSlotActive) {
        this.currentSlotActive = currentSlotActive;
    }

    public int getUpdgrade() {
        return updgrade;
    }

    public void setUpdgrade(int updgrade) {
        if (classType == Constants.BUILDINGNORMAL && updgrade < 4) {
            timeUnderConstruct = transformToSeconds(
                    Constants.BUILDING_NEED_UPGRADE[getPosOrderInfos() + updgrade][6],
                    Constants.BUILDING_NEED_UPGRADE[getPosOrderInfos() + updgrade][7]);
        }
        this.updgrade = updgrade;
    }

    public int getClassType() {
        return classType;
    }

    public void setClassType(int classType) {
        this.classType = classType;
    }

    public int getPosX_1() {
        return posX_1;
    }

    public void setPosX_1(int posX_1) {
        this.posX_1 = posX_1;
    }

    public int getPosY_1() {
        return posY_1;
    }

    public void setPosY_1(int posY_1) {
        this.posY_1 = posY_1;
    }

    public int getPosX_2() {
        return posX_2;
    }

    public void setPosX_2(int posX_2) {
        this.posX_2 = posX_2;
    }

    public int getPosY_2() {
        return posY_2;
    }

    public void setPosY_2(int posY_2) {
        this.posY_2 = posY_2;
    }

    public int getPosX_3() {
        return posX_3;
    }

    public void setPosX_3(int posX_3) {
        this.posX_3 = posX_3;
    }

    public int getPosY_3() {
        return posY_3;
    }

    public void setPosY_3(int posY_3) {
        this.posY_3 = posY_3;
    }

    public boolean isFourSpace() {
        return isFourSpace;
    }

    public void setFourSpace(boolean isFourSpace) {
        this.isFourSpace = isFourSpace;
    }

    /*
     * public boolean isOpenMenu() { return openMenu; }
     * 
     * public void setOpenMenu(boolean openMenu) { this.openMenu = openMenu; }
     */

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

    public int getTimeUnderConstruct() {
        return timeUnderConstruct;
    }

    public void setTimeUnderConstruct(int timeUnderConstruct) {
        if (timeUnderConstruct <= 0) {
            setShowTimeUnderConstruction(false);
            setOpenBuilding(true);
            timeUnderConstruct = 0;
        }
        this.timeUnderConstruct = timeUnderConstruct;
    }

    public String getTimeForConstruction() {
        return UtilSoftgames.secondsToString(getTimeUnderConstruct());
    }

    public boolean isShowTimeUnderConstruction() {
        return showTimeUnderConstruction;
    }

    public void setShowTimeUnderConstruction(boolean showTimeUnderConstruction) {
        this.showTimeUnderConstruction = showTimeUnderConstruction;
    }

    public boolean isMoveFree() {
        return moveFree;
    }

    public void setMoveFree(boolean moveFree) {
        this.moveFree = moveFree;
    }

    public int[] getItemProduce() {
        return itemProduce;
    }

    public void setItemProduce(int[] itemProduce) {
        this.itemProduce = itemProduce;
    }

    public int[] getItemProducing() {
        return itemProducingInSlot;
    }

    public void setItemProducing(int itemProducing, int pos) {
        this.itemProducingInSlot[pos] = itemProducing;
    }

    public int[] getTimeProductsInSlot() {
        return timeProductsInSlot;
    }

    public void setTimeProductsInSlot(int timeProductsInSlot, int pos) {
        this.timeProductsInSlot[pos] = timeProductsInSlot;
    }

    public boolean isOpenBuilding() {
        return openBuilding;
    }

    public void setOpenBuilding(boolean openBuilding) {
        this.openBuilding = openBuilding;
    }

    public int getDiamondsFinishProducts(int classType, int type) {
        int diamonds = 1;
        switch (classType) {

        case Constants.BANANAS:
        case Constants.CHERRY:
        case Constants.CLOVE:
        case Constants.GRAPES:
        case Constants.LILLIES:
        case Constants.MANGO:
        case Constants.POMEGRANATE:
        case Constants.TULIP: 
        case Constants.OAK:
        case Constants.PINE:
        case Constants.BIRCH:
        case Constants.BEECH:
        	classType -= 66;
        case Constants.WHEAT:
        case Constants.CORN:
        case Constants.VANILLA:
        case Constants.RYE:
        case Constants.SUGAR_CANE:
        case Constants.ONIONS:
        case Constants.SORGHUM:
        case Constants.COTTON_PLANT:
        case Constants.STRAWBERRY:
        case Constants.BLUEBERRY:
        case Constants.HANF:
        case Constants.TOMATOES:
        case Constants.CACAO:
        case Constants.POTATOES:
        case Constants.APPLE:
        case Constants.ORANGE:
        case Constants.LEMON:
        
     
        	
        	
            if (Constants.CROPS_COINS_TO_PAY[classType] <= 50) {
                diamonds = 1;
            } else if (Constants.CROPS_COINS_TO_PAY[classType] <= 90) {
                diamonds = 2;
            } else if (Constants.CROPS_COINS_TO_PAY[classType] <= 150) {
                diamonds = 3;
            } else if (Constants.CROPS_COINS_TO_PAY[classType] <= 200) {
                diamonds = 4;
            } else if (Constants.CROPS_COINS_TO_PAY[classType] <= 350) {
                diamonds = 5;
            } else {
                diamonds = 6;
            }
            break;

        case Constants.EGGS:
        case Constants.MILK:
        case Constants.GOAT_MILK:
        case Constants.MEAT:
        case Constants.WOOL:
        case Constants.GOOSE_EGG:
        case Constants.HORSE_HAIR:
        case Constants.ANGORA_WOOL:
        case Constants.DUCK_MEAT:
        case Constants.HONEY:
        case Constants.BUFALO_MILK:
        case Constants.NUTS:

            if (Constants.PRODUCT_ANIMAL_INFO[classType - 156][1] <= 25) {
                diamonds = 1;
            } else if (Constants.PRODUCT_ANIMAL_INFO[classType - 156][1] <= 50) {
                diamonds = 2;
            } else {
                diamonds = 3;
            }

            return diamonds;
        }

        for (int i = 0; i < Constants.BUILDING_PRODUCTS.length; i++) {
            if (Constants.BUILDING_PRODUCTS[i][0] == classType) {
                int info = Constants.BUILDING_PRODUCTS[i][type];

                if (info <= 100) {
                    diamonds = 2;
                } else if (info <= 200) {
                    diamonds = 5;
                } else if (info <= 400) {
                    diamonds = 8;
                } else if (info <= 800) {
                    diamonds = 15;
                } else if (info <= 1300) {
                    diamonds = 20;
                } else if (info <= 2000) {
                    diamonds = 25;
                } else {
                    diamonds = 40;
                }
                break;
            }
        }

        return diamonds;
    }

}
