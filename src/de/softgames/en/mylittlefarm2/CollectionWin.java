package de.softgames.en.mylittlefarm2;


public class CollectionWin {

    private int posTiledX;
    private int posTiledY;
    private boolean active = false;
    private int type;
    private int position;
    public long timeToDissapear = 0;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public CollectionWin() {

    }

    public int getPosTiledX() {
        return posTiledX;
    }

    public void setPosTiledX(int posTiledX) {
        this.posTiledX = posTiledX;
    }

    public int getPosTiledY() {
        return posTiledY;
    }

    public void setPosTiledY(int posTiledY) {
        this.posTiledY = posTiledY;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void updateStatus() {
        if (System.currentTimeMillis() - timeToDissapear >= 5000) {
            timeToDissapear = System.currentTimeMillis();
            Constants.canShowCollection = true;
            Constants.timeShowCollection = System.currentTimeMillis();
            Constants.typeCollectionShow = type;
            Constants.posCollectionShow = position;
            if (isActive()) {
                setActive(false);
            }
        }
    }

}
