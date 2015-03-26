package de.softgames.en.mylittlefarm2;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.util.Log;


/**
 * 
 * @author josecarlosariasabuabara
 * 
 */
public class Decoration {
    private int Pos_X = 0;

    private int Pos_Y = 0;

    private int type;

    private boolean statusActive = true;

    private int moneyPay = 0;

    private int moneyWin = 0;

    private boolean flip = false;

    // private int moneyPayDiamonts = 25;

    private int expWin = 2000;

    private boolean menuRotate = false;

    private boolean moveFree = false;

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

    public Decoration(int Pos_X, int Pos_Y, int type) {
        this.Pos_X = Pos_X;
        this.Pos_Y = Pos_Y;
        this.type = type;

        expWin = Constants.DECORATIONS_INFO[type][3];
        moneyPay = ((Constants.DECORATIONS_INFO[type][7] == Constants.GOLD) ? Constants.DECORATIONS_INFO[type][1]
                : Constants.DECORATIONS_INFO[type][2]);
        // moneyPayDiamonts = Constants.decorationsDiamondsToPay[type];
        if (Constants.decorationsImage[Constants.DECORATIONS_INFO[type][6]] == null) {
        
        	loadDecorationsImg(type);
        }
                                                                           
    }
    
    private void loadDecorationsImg(int type) {

        switch (Constants.DECORATIONS_INFO[type][6]) {
        case 0:
            Constants.decorationsImage[0] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/spring-flowers.png", false);
            break;
        case 1:
            Constants.decorationsImage[1] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/wood-pile.png", false);
            break;
        case 2:
            Constants.decorationsImage[2] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/hay-bail.png", false);
            break;
        case 3:
            Constants.decorationsImage[3] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/stones.png", false);
            break;
        case 4:
            Constants.decorationsImage[4] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/clothes.png", false);
            break;
        case 5:
            Constants.decorationsImage[5] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/woodplate.png", false);
            break;

        case 6:
            Constants.decorationsImage[6] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/woodplateenter1.png", false);
            break;
        case 7:
            Constants.decorationsImage[7] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/wind-wheel.png", false);
            break;
        case 8:
            Constants.decorationsImage[8] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/hay-cart.png", false);
            break;
        case 9:
            Constants.decorationsImage[9] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/stonewatch.png", false);
            break;
        case 10:
            Constants.decorationsImage[10] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/tractor.png", false);
            break;
        case 11:
            Constants.decorationsImage[11] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/fireplace.png", false);
            break;

        case 12:
            Constants.decorationsImage[12] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/horse shoes.png", false);
            break;
        case 13:
            Constants.decorationsImage[13] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/park.png", false);
            break;
        case 14:
            Constants.decorationsImage[14] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/haytrailer.png", false);
            break;
        case 15:
            Constants.decorationsImage[15] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/picnic.png", false);
            break;
        case 16:
            Constants.decorationsImage[16] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/rabbithill.png", false);
            break;
        case 17:
            Constants.decorationsImage[17] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/Scare crow.png", false);
            break;

        case 18:
            Constants.decorationsImage[18] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/treehouse.png", false);
            break;
        case 19:
            Constants.decorationsImage[19] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/Fountain.png", false);
            break;
        case 20:
            Constants.decorationsImage[20] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/Wood storage.png", false);
            break;
        case 21:
            Constants.decorationsImage[21] = UtilSoftgames.loadImageAssetsSimple(
                    "decoration/Wood house.png", false);
            break;

        }
    }

    /*
     * public void paintMove(Canvas canvas){ int posX =
     * (int)(Constants.Pos_Move_Free_X) -
     * (Constants.decorationsImage[getType()].getWidth()/2); int posY =
     * (int)(Constants.Pos_Move_Free_Y) -
     * (Constants.decorationsImage[getType()].getHeight()/2);
     * 
     * 
     * int orientation = 1; if(isFlip()){ orientation = -1;
     * World.mMatrixflip.setTranslate(posX +
     * Constants.decorationsImage[getType()].getWidth()* World.mScaleFactor,
     * posY); } else { World.mMatrixflip.setTranslate(posX,posY); }
     * 
     * World.mMatrixflip.preScale(World.mScaleFactor * orientation,
     * World.mScaleFactor);
     * 
     * canvas.drawBitmap(Constants.decorationsImage[getType()],
     * World.mMatrixflip , null);
     * 
     * if(isMenuRotate()){ UtilSoftgames.animationSelectedObject(canvas,
     * Constants.decorationsImage[getType()], posX, posY, isFlip(), 1, 1); } }
     */

    public void paint(Canvas canvas, int Pos_Initial_X, int Pos_Initial_Y) {
        Bitmap currentDecoration = Constants.decorationsImage[getType()];
        
        int posX = Pos_Initial_X + World.posWorldX
                + (World.tamTiledX / 2)
                - (currentDecoration.getWidth() / 2);
        int posY = Pos_Initial_Y
                + World.posWorldY
                + (World.tamTiledY - (int) (currentDecoration
                        .getHeight() * World.mScaleFactor));

        if (Constants.DECORATIONS_INFO[getType()][8] == 1) {
            posY = Pos_Initial_Y
                    + World.posWorldY
                    + (World.tamTiledY * 2 - (int) (currentDecoration
                            .getHeight() * World.mScaleFactor));
        }

        int orientation = 1;
        if (isFlip()) {
            orientation = -1;
            World.mMatrixflip.setTranslate(posX
                    + currentDecoration.getWidth()
                    * World.mScaleFactor, posY);
        } else {
            World.mMatrixflip.setTranslate(posX, posY);
        }

        World.mMatrixflip.preScale(World.mScaleFactor * orientation,
                World.mScaleFactor);

        canvas.drawBitmap(currentDecoration,
                World.mMatrixflip, null);

        if (isMenuRotate()) {
            UtilSoftgames.animationSelectedObject(canvas,
                    currentDecoration, posX, posY,
                    isFlip(), 1, 1);
        }

    }

    public int getMoneyPay() {
        return moneyPay;
    }

    public void setMoneyPay(int moneyPay) {
        this.moneyPay = moneyPay;
    }

    public int getExpWin() {
        return expWin;
    }

    public void setExpWin(int expWin) {
        this.expWin = expWin;
    }

    public int getMoneyWin() {
        return moneyWin;
    }

    public void setMoneyWin(int moneyWin) {
        this.moneyWin = moneyWin;
    }

    public boolean isFlip() {
        return flip;
    }

    public void setFlip(boolean flip) {
        this.flip = flip;
    }

    public boolean isMenuRotate() {
        return menuRotate;
    }

    public void setMenuRotate(boolean menuRotate) {
        this.menuRotate = menuRotate;
    }

    public boolean isMoveFree() {
        return moveFree;
    }

    public void setMoveFree(boolean moveFree) {
        this.moveFree = moveFree;
    }

}
