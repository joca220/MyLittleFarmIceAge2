package de.softgames.en.mylittlefarm2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.Random;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.Log;


public class UtilSoftgames {
    private static final String TAG = UtilSoftgames.class.getSimpleName();
    private static boolean animationShadow = false;
    private static long timeAnimationReady = 0;

    private static long timeStar = 0;
    private static int animationStart = 1;

    private static float scaleCashIn = 1.0f;

    private static float scaleCashInTransparent = 1.0f;
    private static float scaleCashInSigno = 1;
    private static long Time_Animation = 0;
    public static float rotateScale = 0.0f;
    public static float rotateScale2 = 0.0f;
    public static int alphaImage = 0;
    public static  Resources mRes;
    public static int mCanvasHeight = 1;
    public static int mCanvasWidth = 1;
    
    public static void paintImageInCenter(Canvas canvas, Bitmap image,
            int mCanvasWidth, int mCanvasHeight) {
        canvas.drawBitmap(image, mCanvasWidth / 2 - image.getWidth() / 2,
                mCanvasHeight / 2 - image.getHeight() / 2, null);
    }
    
    public static void paintImageRotate(Canvas canvas, Bitmap imageAux, int posX, int posY, int speed, boolean canRotate) {
        Matrix matrix = new Matrix();
        if(canRotate){
        	matrix.postRotate(rotateScale, imageAux.getWidth() / 2,
                imageAux.getHeight() / 2);
        } else {
        	matrix.postRotate(rotateScale2, imageAux.getWidth() / 2,
                    imageAux.getHeight() / 2);
        }
        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(imageAux, 0, 0,
                imageAux.getWidth(), imageAux.getHeight(), matrix, true);

        canvas.drawBitmap(resizedBitmap, posX - resizedBitmap.getWidth() / 2,
                posY - resizedBitmap.getHeight() / 2, null);
        
        

        if (System.currentTimeMillis() - Time_Animation >= 10) {
            Time_Animation = System.currentTimeMillis();
            rotateScale += speed;
            if (rotateScale >= 360) {
                rotateScale = 0;
            }
        }
    }
    
    
    public static Object loadObject(String register, Context mContext){
    	Object object = null;
    	  ObjectInputStream in;
			try {
				FileInputStream fos = mContext.openFileInput(register);
				  in = new ObjectInputStream(fos);
				   
				  object =  in.readObject();
	        	in.close();
			} catch (StreamCorruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return object;
    }
    
    public static void saveObject(String register, Object data, Context mContext) {
    	 ObjectOutputStream out;
			try {
				FileOutputStream fos = mContext.openFileOutput(register, Context.MODE_PRIVATE);
				out = new ObjectOutputStream(fos);
				out.writeObject(data);
				out.flush();
				 out.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    }
    public static int correctPosAccordingScrenn_X(int size){
		 int newWidth = 0;
		 if(GameCanvas.mobilIsHD){
			 newWidth =  size;
		 } else {
			  newWidth =  (size *mCanvasWidth)/ 1280;
		 }
		 return newWidth;
	 }
	 
	 public static int correctPosAccordingScrenn_Y(int size){
		 int newHeight = 0;
		 
		 if(GameCanvas.mobilIsHD){
			 newHeight =  size;
		 } else {
			  newHeight =  (size *mCanvasHeight)/ 752;
		 }
		 
		 return newHeight;
	 }

    public static void setValuesForTransparent() {
        scaleCashInTransparent = 0.7f;
        alphaImage = 0;
    }

    public static void paintImageRotate(Canvas canvas, Bitmap imageAux,
            int posX, int posY) {
        Matrix matrix = new Matrix();
        matrix.postRotate(rotateScale, imageAux.getWidth() / 2,
                imageAux.getHeight() / 2);

        // recreate the new Bitmap
        Bitmap resizedBitmap = Bitmap.createBitmap(imageAux, 0, 0,
                imageAux.getWidth(), imageAux.getHeight(), matrix, true);

        canvas.drawBitmap(resizedBitmap, posX - resizedBitmap.getWidth() / 2,
                posY - resizedBitmap.getHeight() / 2, null);

        if (System.currentTimeMillis() - Time_Animation >= 10) {
            Time_Animation = System.currentTimeMillis();
            rotateScale += 4;
            if (rotateScale >= 360) {
                rotateScale = 0;
            }
        }
    }

    public static int random(int min, int max) {
        Random random = new java.util.Random();

        int t;
        try {
            do {
                t = random.nextInt() % (max + 1);
            } while (t < min);
        } catch (ArithmeticException e) {
            t = min;
        }

        return t;
    }
    
    public static Bitmap loadImageAssetsSimple(String name, boolean isResizable) {
        InputStream is = null;
        Bitmap asset = null;

        try {
            is = mRes.getAssets().open(name);
        } catch (IOException e) {
            Log.e(TAG, "Error loading " + name);
        }

        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPurgeable = true;
        options.inInputShareable = true;
        asset = BitmapFactory.decodeStream(is, null, options);

        if((mCanvasWidth == 1196 && mCanvasHeight == 720) || (mCanvasWidth == 1280 && mCanvasHeight == 720)){
        	
        } else {
        	if (isResizable) {
        	// Log.d(TAG, "loadImageAssetsSimple(" + name + ")");
            	asset = UtilSoftgames.resizeToCalculatedResolution(asset,
                    mCanvasWidth, mCanvasHeight);
        	}
        }
        return asset;
    }


    public static String[] splitString(String[] Cad_Ref, int Num_Max_Caracter,
            int No_Cad) {

        String[] texpartes = new String[100];
        int cuenta_texpartes = 0, otro = 0;
        int inicio, fin, tam;
        byte k = 0;
        for (byte i = 0; i < No_Cad; i++) {

            otro = 0;
            inicio = 0;
            fin = Num_Max_Caracter;
            tam = Cad_Ref[i].length() / Num_Max_Caracter;
            for (int m = 0; m < tam; m++) {
                texpartes[cuenta_texpartes] = Cad_Ref[i].substring(inicio, fin);
                if (texpartes[cuenta_texpartes].charAt(Num_Max_Caracter - 1) != ' ') {
                    for (int h = (Num_Max_Caracter - 1); h > 0; h--) {
                        if (texpartes[cuenta_texpartes].charAt(h) == ' ') {
                            texpartes[cuenta_texpartes] = texpartes[cuenta_texpartes]
                                    .substring(0, h);
                            for (k = 0; k < Num_Max_Caracter - h; k++) {
                                texpartes[cuenta_texpartes] = texpartes[cuenta_texpartes]
                                        + " ";
                            }
                            inicio = h + inicio;
                            fin = inicio + Num_Max_Caracter;
                            otro = otro + (Num_Max_Caracter - h);
                            tam = (Cad_Ref[i].length() + otro)
                                    / Num_Max_Caracter;
                            break;
                        }
                    }
                } else {
                    inicio = fin;
                    fin = fin + Num_Max_Caracter;
                }
                int f = 0;
                while (texpartes[cuenta_texpartes].charAt(f) == ' ') {
                    f++;
                }
                texpartes[cuenta_texpartes] = texpartes[cuenta_texpartes]
                        .substring(f, Num_Max_Caracter);
                cuenta_texpartes++;
                // System.out.println(cuenta_texpartes);
            }// del for del tam
            inicio = fin - Num_Max_Caracter;
            fin = Cad_Ref[i].length();
            texpartes[cuenta_texpartes] = Cad_Ref[i].substring(inicio, fin);
            cuenta_texpartes++;

        }// del for del ntemas
        Constants.lineas = cuenta_texpartes;

        return texpartes;
    }

    public static Paint initFontText(int color, double stroke, double size,
            Align align, int colorShadow, Typeface mFace) {
        float fSize = (float) size; 
        Paint newPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        newPaint.setStrokeWidth(1);
        newPaint.setTextSize(fSize);
        newPaint.setTextAlign(align);
        newPaint.setTypeface(mFace);

        newPaint.setColor(color);
        if (colorShadow != -1) {
            newPaint.setShadowLayer(3, 0, 0, colorShadow);
        }

        return newPaint;
    }
    

    public static Paint initFontText2(int color, double stroke, double size,
            Align align, int colorShadow, Typeface mFace) {
        float fSize = (float) size; 
        Paint newPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        newPaint.setStrokeWidth(3);
        newPaint.setStyle(Paint.Style.STROKE);
        newPaint.setTextSize(fSize);
        newPaint.setTextAlign(align);
        newPaint.setTypeface(mFace);

        newPaint.setColor(colorShadow);

        return newPaint;
    }

    public static void transparentImage(Canvas canvas, Bitmap auxImage,
            int posX, int posY, boolean dissapear, boolean effecBig) {
        Paint newPaint = new Paint();
        newPaint.setAlpha(alphaImage);
        Matrix matrix = new Matrix();
        if (effecBig) {
            matrix.setTranslate(posX
                    - (auxImage.getWidth() * scaleCashInTransparent) / 2, posY
                    - (auxImage.getHeight() * scaleCashInTransparent) / 2);

            matrix.preScale(scaleCashInTransparent, scaleCashInTransparent);
        } else {
            matrix.setTranslate(posX, posY);
        }

        canvas.drawBitmap(auxImage, matrix, newPaint);

        if (System.currentTimeMillis() - Time_Animation >= 45) {
            Time_Animation = System.currentTimeMillis();
            if (!dissapear) {
                alphaImage += 32;

                if (scaleCashInTransparent < 1.0) {
                    scaleCashInTransparent += (0.04);
                }
                if (alphaImage >= 255) {
                    alphaImage = 255;
                }
            } else {
                alphaImage -= 32;

                if (alphaImage < 0) {
                    alphaImage = 0;
                }

                if (scaleCashInTransparent > 0.7) {
                    scaleCashInTransparent -= (0.04);
                }
            }
        }
    }

    public static void animationSmallToBig(Canvas canvas, Bitmap imageAux,
            int pointCenter_X, int pointCenter_Y, float max, float min) {
        Matrix matrix = new Matrix();

        matrix.setTranslate(pointCenter_X - (imageAux.getWidth() * scaleCashIn)
                / 2, pointCenter_Y - (imageAux.getHeight() * scaleCashIn) / 2);

        matrix.preScale(scaleCashIn, scaleCashIn);

        canvas.drawBitmap(imageAux, matrix, null);

        if (System.currentTimeMillis() - Time_Animation >= 25) {
            Time_Animation = System.currentTimeMillis();

            scaleCashIn += (scaleCashInSigno * 0.04);

            if (scaleCashIn < min || scaleCashIn > max) {
                scaleCashInSigno *= -1;
            }
        }
    }

    public static Bitmap resizeToCalculatedResolution(Bitmap asset, int mCanvasWidth, int mCanvasHeight){
        double multiplicatorHeight = 1;
        double divisorHeight = 1;

        double multiplicatorWidth = 1;
        double divisorWidth = 1;
        
        int  newWidth = 0;
        int newHeight = 0;
        
        if((mCanvasWidth == 1196 && mCanvasHeight == 720) || (mCanvasWidth == 1280 && mCanvasHeight == 720)){
       		return asset;
        }
        if (mCanvasWidth == 854 && mCanvasHeight == 480) {
            multiplicatorWidth = 1.334;
            divisorWidth = 2;
            multiplicatorHeight = 1.276;
            divisorHeight = 2;
        } else if ((mCanvasWidth == 800 && mCanvasHeight == 480) || (mCanvasWidth == 791 && mCanvasHeight == 480)) {
            multiplicatorWidth = 5;
            divisorWidth = 8;
            multiplicatorHeight = 1.276;
            divisorHeight = 2;
        } else if (mCanvasWidth == 480 && mCanvasHeight == 320) {
            multiplicatorWidth = 3;
            divisorWidth = 8;
            multiplicatorHeight = 0.4255;
            divisorHeight = 1;
        } else if (mCanvasWidth == 320 && mCanvasHeight == 240) {
            multiplicatorWidth = 1;
            divisorWidth = 4;
            multiplicatorHeight = 7;
            divisorHeight = 22;
        } else if ((mCanvasWidth == 960 && mCanvasHeight == 540) ||(mCanvasWidth == 897 && mCanvasHeight == 540)) {
            multiplicatorWidth = 9;
            divisorWidth = 12;
            multiplicatorHeight = 1.435;
            divisorHeight = 2;
        } else if (mCanvasWidth == 1024 && mCanvasHeight == 600) {
            multiplicatorWidth = 4;
            divisorWidth = 5;
            multiplicatorHeight = 1.595;
            divisorHeight = 2;
        } else if (mCanvasWidth == 1280 && mCanvasHeight == 720) {
            multiplicatorHeight = 1.915;
            divisorHeight = 2;
        } else if (mCanvasWidth == 1280 && mCanvasHeight == 736) {
            multiplicatorHeight = 1.957;
            divisorHeight = 2;
        }  else if ((mCanvasWidth == 1920 && mCanvasHeight == 1080) || (mCanvasWidth == 1794 && mCanvasHeight == 1080)
    			|| (mCanvasWidth == 1836 && mCanvasHeight == 1080)) {
       	 multiplicatorWidth = 1.5;
            divisorWidth = 1;
            
            multiplicatorHeight = 1.35;
            divisorHeight = 1;
       }   else if (mCanvasWidth == 1920 && mCanvasHeight == 1200) {
       	 multiplicatorWidth = 1.5;
            divisorWidth = 1;
            
            multiplicatorHeight = 1.5;
            divisorHeight = 1;
       }  else  {
         	
         	 newWidth =  (asset.getWidth() *mCanvasWidth)/ 1280;
         	 newHeight = (asset.getHeight() *mCanvasHeight)/ 752;
       }
         
         if(newWidth == 0){
          newWidth = (int) Math.round((asset.getWidth() / divisorWidth)
                 * multiplicatorWidth);
          newHeight = (int) Math.round((asset.getHeight() / divisorHeight)
                 * multiplicatorHeight);
         }
        
       
        return resizeBitmap(asset, newWidth, newHeight);
        
    }
    
    public static Bitmap resizeBitmap(Bitmap src, int newWidth, int newHeight) {
        Bitmap resizedBitmap = null;
        if (src == null)
            return src;
        int width = src.getWidth();
        int height = src.getHeight();
        Matrix matrix = new Matrix();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;

        matrix.postScale(scaleWidth, scaleHeight);

        resizedBitmap = Bitmap.createBitmap(src, 0, 0, width, height, matrix,
                true);

        return resizedBitmap;

    }
    
    public static void PaintTextWithImageInLine(Canvas canvas, String text,
            Bitmap image, Paint paint, int center, int posY, boolean isleft, float reduce) {
    	String[] auxText = {text};
    	Bitmap[] auxBitmap = {image};
    	
    	 PaintTextWithImageInLine(canvas, auxText, auxBitmap, paint, center, posY, isleft, reduce);
     	
    }
    
    public static void drawTextEffectBorder(Canvas canvas, String text, int posX, int posY, Paint mPaint, Paint mPaintStroke){
    	canvas.drawText(text , posX,	posY, mPaintStroke);
    	canvas.drawText(text , posX,	posY, mPaint);
    }
    
    public static void PaintTextWithImageInLine(Canvas canvas, String[] text,
            Bitmap[] image, Paint paint, int center, int posY) {
        int posInitialX = 0;
        int space = 3;
        Rect bounds = new Rect();
        // TextView tx;
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null) {
                bounds = new Rect();
                paint.getTextBounds(text[i], 0, text[i].length(), bounds);
                posInitialX += bounds.width();
                posInitialX += space;
                if (image[i] != null) {
                    posInitialX += image[i].getWidth();
                    posInitialX += space;
                }

            }
        }
        posInitialX = center - posInitialX / 2;
        // TextView tx;
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null) {
                bounds = new Rect();
                canvas.drawText(text[i], posInitialX, posY, paint);

                paint.getTextBounds(text[i], 0, text[i].length(), bounds);
                posInitialX += bounds.width();
                posInitialX += space;

                if (image[i] != null) {
                    canvas.drawBitmap(
                            image[i],
                            posInitialX,
                            posY - (paint.getTextSize() / 2)
                                    - (image[i].getHeight() / 2), null);

                    posInitialX += image[i].getWidth();
                    posInitialX += space;
                }
            }
        }
    }

    public static void PaintTextWithImageInLine(Canvas canvas, String[] text,
            Bitmap[] image, Paint paint, int center, int posY, boolean isleft, float reduce) {
        int posInitialX = 0;
        int space = 3;
        Rect bounds = new Rect();
        // TextView tx;
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null) {
                bounds = new Rect();
                paint.getTextBounds(text[i], 0, text[i].length(), bounds);
                posInitialX += bounds.width();
                posInitialX += space;
                if (image[i] != null) {
                    posInitialX += image[i].getWidth()*reduce;
                    posInitialX += space;
                }

            }
        }
        if(!isleft){
        	posInitialX = center - posInitialX / 2;
        } else {
        	posInitialX = center;
        }
        // TextView tx;
        for (int i = 0; i < text.length; i++) {
            if (text[i] != null) {
                bounds = new Rect();
                canvas.drawText(text[i], posInitialX, posY, paint);

                paint.getTextBounds(text[i], 0, text[i].length(), bounds);
                posInitialX += bounds.width();
                posInitialX += space;

                if (image[i] != null) {
                	
                    /*canvas.drawBitmap(
                            image[i],
                            posInitialX,
                            posY - (paint.getTextSize() / 2)
                                    - (image[i].getHeight() / 2), null);*/

                    paintImageReduce(canvas, image[i], (int)(posInitialX),(int)(posY - (paint.getTextSize() / 2)
                            - ((image[i].getHeight()*reduce) / 2)), reduce);
                    
                    posInitialX += image[i].getWidth()*reduce;
                    posInitialX += space;
                }
            }
        }
    }
    
    public static void paintImageReduce(Canvas canvas,Bitmap image, int posX, int posY, float reduce){
   	 Matrix matrix = new Matrix();
   	 matrix.setTranslate(posX, posY);
        matrix.preScale(reduce, reduce);
        canvas.drawBitmap(image,matrix, null);
   }

    public static void paintAnimationStart(Canvas canvas, int posX, int posY) {
        /*Constants.startReady.paint(
                canvas,
                animationStart,
                posX + World.tamTiledX / 2
                        - (Constants.startReady.auxImage.getWidth() / 18) / 2,
                posY + World.tamTiledY / 2
                        - Constants.startReady.auxImage.getHeight() / 2,
                Constants.startReady.auxImage.getHeight() / 1,
                Constants.startReady.auxImage.getWidth() / 18, false, false,
                false);*/
    	canvas.drawBitmap(Constants.startReady[animationStart-1], posX  - Constants.startReady[animationStart-1].getWidth()/2,
    			 posY 
                 - Constants.startReady[animationStart-1].getHeight() / 2, null);

        if (System.currentTimeMillis() - timeStar >= 20) {
            timeStar = System.currentTimeMillis();
            animationStart++;
            if (animationStart > 18) {
                animationStart = 1;
            }
        }
    }

    public static void animationSelectedObject(Canvas canvas, Bitmap image,
            int posX, int posY, boolean isFlip, int nFrame, int currentFrame) {
   /*     int[] offsetXY = new int[2];
        int tamSizeShadow = (int) (15 * World.mScaleFactor);
        BlurMaskFilter blurFilter = new BlurMaskFilter(tamSizeShadow,
                BlurMaskFilter.Blur.OUTER);

        Paint shadowPaint = new Paint();
        shadowPaint.setMaskFilter(blurFilter);
        shadowPaint.setColor(0xFFFFFFFF);

        Bitmap shadowImage = image.extractAlpha(shadowPaint, offsetXY);

        offsetXY[0] = posX;
        offsetXY[1] = posY;

        Paint shadowPaint2 = new Paint();
        if (animationShadow) {
            shadowPaint2.setColor(0xFFFFFFFF);
            shadowPaint2.setStrokeWidth(34);
        }

        int orientation = 1;
        if (isFlip) {
            orientation = -1;
            int add = (((int) (shadowImage.getWidth() * World.mScaleFactor) / nFrame) * (currentFrame - 1));
            int add2 = 20 - ((currentFrame - 1) * 10);
          
            World.mMatrixflip.setTranslate(offsetXY[0] - tamSizeShadow
                    + ((shadowImage.getWidth() * World.mScaleFactor) / nFrame)
                    * currentFrame + add + add2, offsetXY[1] - tamSizeShadow);
        } else {
            World.mMatrixflip.setTranslate(offsetXY[0] - tamSizeShadow,
                    offsetXY[1] - tamSizeShadow);
        }

        World.mMatrixflip.preScale(World.mScaleFactor * orientation,
                World.mScaleFactor);

        canvas.drawBitmap(shadowImage, World.mMatrixflip, shadowPaint2);

        if (System.currentTimeMillis() - timeAnimationReady >= 400) {
            timeAnimationReady = System.currentTimeMillis();
            animationShadow = (animationShadow) ? false : true;
        }*/
    }

    public static void saveData(String register, String data, Context mContex) {
        FileOutputStream fos = null;
        try {
            fos = mContex.openFileOutput(register, 0);
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF(data);
            dos.flush();
            dos.close();
        } catch (Exception e) {
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (Exception exc) {
            }
        }
    }
    
    public static String loadData(String register, Context mContex) {
        String info = "-1";

       FileInputStream fis = null;

        try {
            fis = mContex.openFileInput(register);
            DataInputStream dis = new DataInputStream(fis);
            info = dis.readUTF();
        } catch (Exception e) {
            return null;
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
            } catch (Exception exc) {
            }
        }

        if (info.equals("-1")) {
            return null;
        }

        return info;
    }
    
    public static String secondsToString(int seconds) {
        String time = "";

        int Time_For_Call = seconds;
        int Hour = 0;
        int Min_Part_1 = 0;
        int Seg_Part_1 = 0;

        int Min_Part_2 = 0;
        int Seg_Part_2 = 0;

        if (Time_For_Call >= 3600) {
            Hour = Time_For_Call / 3600;

            Min_Part_1 = ((Time_For_Call - (Hour * 3600)) / 60);

            Seg_Part_1 = Time_For_Call - (Hour * 3600) - (Min_Part_1 * 60);

            Min_Part_2 = Min_Part_1 % 10;
            Min_Part_1 = Min_Part_1 / 10;

            Seg_Part_2 = Seg_Part_1 % 10;
            Seg_Part_1 = Seg_Part_1 / 10;

        } else if (Time_For_Call >= 60) {
            Hour = 0;

            Min_Part_1 = (Time_For_Call / 60);

            Seg_Part_1 = Time_For_Call - (Min_Part_1 * 60);

            Min_Part_2 = Min_Part_1 % 10;
            Min_Part_1 = Min_Part_1 / 10;

            Seg_Part_2 = Seg_Part_1 % 10;
            Seg_Part_1 = Seg_Part_1 / 10;

        } else {
            Hour = 0;

            Min_Part_1 = 0;

            Seg_Part_1 = Time_For_Call;

            Min_Part_2 = 0;
            Min_Part_1 = 0;

            Seg_Part_2 = Seg_Part_1 % 10;
            Seg_Part_1 = Seg_Part_1 / 10;

        }
        time += Hour + ":" + Min_Part_1 + "" + Min_Part_2 + ":" + Seg_Part_1
                + "" + Seg_Part_2;

        return time;
    }

}
