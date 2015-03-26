package de.softgames.en.mylittlefarm2;


import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;


public class ImageButton {

    private int posX;
    private int posY;
    private int posInTouchX;
    private int posInTouchY;

    private Bitmap image;
    private Bitmap imageOver;
    private int color;
    private boolean isSelected = false;
    private long timePressed = 0;

    public ImageButton(Bitmap image, int posX, int posY, Bitmap imageOver) {
        this.image = image;
        this.posX = posX;
        this.posY = posY;
        this.imageOver = imageOver;
        setColor(Color.BLACK);
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public Bitmap getImage() {
        return image;
    }
    
    public void paintScale(Canvas canvas, float sizeToReduce, String texto, Paint mPaint,boolean imageNormal) {
        Matrix matrixnew = new Matrix();
        matrixnew.setTranslate(getPosX(), getPosY());
        matrixnew.preScale(sizeToReduce, sizeToReduce);
       
        /*if (!imageNormal && imageOver != null) {
            canvas.drawBitmap(imageOver, matrixnew, null);
    	} else {
    		canvas.drawBitmap(image, matrixnew, null);
    	}*/
        
        if (imageOver != null) {
            if (isSelected && posInTouchX == posX && posInTouchY == posY) {
            	 matrixnew.setTranslate(posInTouchX, posInTouchY);
                 matrixnew.preScale(sizeToReduce, sizeToReduce);
                canvas.drawBitmap(imageOver, matrixnew, null);
                if (System.currentTimeMillis() - timePressed >= 150) {
                    isSelected = false;
                }
            } else {
            	if (!imageNormal && imageOver != null) {
                    canvas.drawBitmap(imageOver, matrixnew, null);
            	} else {
            		canvas.drawBitmap(image, matrixnew, null);
            	}
            }
        } else {
        	 
        	if (!imageNormal && imageOver != null) {
                canvas.drawBitmap(imageOver, matrixnew, null);
        	} else {
        		canvas.drawBitmap(image, matrixnew, null);
        	}
            getOverImage(canvas);
        }
        
        if (texto != null) {
            canvas.drawText(texto, getPosX() + (getImage().getWidth()*sizeToReduce) / 2, getPosY() + ((getImage().getHeight()*sizeToReduce) / 4) * 3, mPaint);
        }
    }
    
    public void paintWithTextImage(Canvas canvas, String text, Paint mPaint, int addPosTextX, int addPosTextY, Bitmap imageText, float scale) {

    	paintScale(canvas, scale, null, null, true);
        if(imageText != null){
        	UtilSoftgames.PaintTextWithImageInLine(canvas, text, imageText, mPaint, getPosX() + (int)(getImage().getWidth()*scale)/2,
        				getPosY() + (int)((getImage().getHeight()*scale)/4)*3, false, 1.0f);
        }

    }
    public void paintScale(Canvas canvas, float sizeToReduce) {
        Matrix matrixnew = new Matrix();
        matrixnew.setTranslate(getPosX(), getPosY());

        matrixnew.preScale(sizeToReduce, sizeToReduce);

        canvas.drawBitmap(image, matrixnew, null);

    }

    public void paintWithText(Canvas canvas, String texto, Paint mPaint,
            int addPosTextX, int addPosTextY) {

        if (imageOver != null) {
            if (isSelected && posInTouchX == posX && posInTouchY == posY) {
                canvas.drawBitmap(imageOver, posInTouchX, posInTouchY, null);
                if (System.currentTimeMillis() - timePressed >= 150) {
                    isSelected = false;

                }
            } else {
                canvas.drawBitmap(image, posX, posY, null);
            }
        } else {
            canvas.drawBitmap(image, posX, posY, null);
            getOverImage(canvas);
        }
        if (texto != null) {
            canvas.drawText(texto, getPosX() + getImage().getWidth() / 2
                    + addPosTextX, getPosY() + (getImage().getHeight() / 4) * 3
                    - addPosTextY, mPaint);

        }

    }

    public void paint(Canvas canvas) {

        if (imageOver != null) {
            if (isSelected && posInTouchX == posX && posInTouchY == posY) {
                canvas.drawBitmap(imageOver, posInTouchX, posInTouchY, null);
                if (System.currentTimeMillis() - timePressed >= 150) {
                    isSelected = false;

                }
            } else {
                canvas.drawBitmap(image, posX, posY, null);
            }
        } else {
            canvas.drawBitmap(image, posX, posY, null);
            getOverImage(canvas);
        }

    }

    public void paintFlip(Canvas canvas) {
        Matrix mMatrixflip = new Matrix();
        mMatrixflip.setTranslate(getPosX() + this.getImage().getWidth(),
                this.getPosY());
        mMatrixflip.preScale(-1.0f, 1.0f);
        canvas.drawBitmap(image, mMatrixflip, null);

        if (imageOver != null) {
            if (isSelected && posInTouchX == posX && posInTouchY == posY) {
                mMatrixflip.setTranslate(posInTouchX
                        + this.getImage().getWidth(), posInTouchY);
                mMatrixflip.preScale(-1.0f, 1.0f);
                canvas.drawBitmap(imageOver, mMatrixflip, null);
                if (System.currentTimeMillis() - timePressed >= 150) {
                    isSelected = false;

                }
            }
        } else {
            getOverImage(canvas);
        }

    }

    private void getOverImage(Canvas canvas) {

        if (isSelected) {
            BlurMaskFilter blurFilter = new BlurMaskFilter(13,
                    BlurMaskFilter.Blur.OUTER);
            Paint shadowPaint = new Paint();
            shadowPaint.setMaskFilter(blurFilter);
            shadowPaint.setColor(0xFFFFFFFF);
            int[] offsetXY = new int[2];
            Bitmap shadowImage = image.extractAlpha(shadowPaint, offsetXY);
            offsetXY[0] = posX;
            offsetXY[1] = posY;
            Paint shadowPaint2 = new Paint();
            shadowPaint2.setColor(this.color);
            shadowPaint2.setStrokeWidth(34);
            canvas.drawBitmap(shadowImage, offsetXY[0] - 13, offsetXY[1] - 13,
                    shadowPaint2);

            if (System.currentTimeMillis() - timePressed >= 150) {
                isSelected = false;

            }
        }
    }

    public boolean touch(MotionEvent event) {
        boolean isTouch = false;
        if (event.getX() >= posX && event.getX() <= (posX + image.getWidth())
                && event.getY() >= posY
                && event.getY() <= (posY + image.getHeight())) {
            isTouch = true;
            isSelected = true;

            setPosInTouchX(posX);
            setPosInTouchY(posY);

            timePressed = System.currentTimeMillis();
        }

        return isTouch;
    }
    
    public void recycle(){
        if (image != null) {
            image.recycle();
        }
        if (imageOver != null) {
            imageOver.recycle();
        }
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getPosInTouchX() {
        return posInTouchX;
    }

    public void setPosInTouchX(int posInTouchX) {
        this.posInTouchX = posInTouchX;
    }

    public int getPosInTouchY() {
        return posInTouchY;
    }

    public void setPosInTouchY(int posInTouchY) {
        this.posInTouchY = posInTouchY;
    }

}
