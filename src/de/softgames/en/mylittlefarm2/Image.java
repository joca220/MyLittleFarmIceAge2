package de.softgames.en.mylittlefarm2;


import android.graphics.Bitmap;
import android.graphics.Canvas;


/*
 * Imagenes.java
 *
 * Created on 18 de abril de 2007, 22:39
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

/**
 * 
 * @author jose carlos
 */

public class Image {

    public Bitmap auxImage = null;

    /** Creates a new instance of Image */
    public Image(Bitmap name) {
        auxImage = name;
    }

    public void paint(Canvas g, int N_Tiled, int Pos_X, int Pos_Y,
            int Tam_Tiled, int Tam_Tiled_X, boolean isResizable,
            boolean isSelected, boolean isFlip) {
        if (auxImage != null) {
            // System.out.println(Tam_Tiled_X);
            int N_x = auxImage.getWidth() / Tam_Tiled_X;
            int N_y = auxImage.getHeight() / Tam_Tiled;

            if (isResizable) {
                N_x = (int) (auxImage.getWidth() * World.mScaleFactor)
                        / Tam_Tiled_X;
                N_y = (int) (auxImage.getHeight() * World.mScaleFactor)
                        / Tam_Tiled;
            }

            int X = -2;
            int Y = -2;

            int Cont = 0;
            int[][] Mat = new int[N_y][N_x];

            for (byte i = 0; i < N_y; i++) {
                for (byte j = 0; j < N_x; j++) {
                    Mat[i][j] = Cont;
                    Cont++;
                }
            }

            for (byte i = 0; i < N_y; i++) {
                for (byte j = 0; j < N_x; j++) {
                    if (Mat[i][j] == (N_Tiled - 1)) {
                        X = j;
                        Y = i;
                        break;
                    }
                }
                if (Y != -2)
                    break;
            }

            X = (X * Tam_Tiled_X) * (-1);
            Y = (Y * Tam_Tiled) * (-1);

            int aux_Image_X = X + Pos_X;
            int aux_Image_Y = Y + Pos_Y;
            g.save();
            g.translate(0, 0);
            g.clipRect(Pos_X, Pos_Y, Tam_Tiled_X + Pos_X, Tam_Tiled + Pos_Y);
            if (isResizable) {
                int orientation = 1;
                if (isFlip) {
                    orientation = -1;
                    int add = ((int) (auxImage.getWidth() * World.mScaleFactor) / N_x)
                            * (N_Tiled - 1);

                    World.mMatrixflip
                            .setTranslate(
                                    aux_Image_X
                                            + ((auxImage.getWidth() * World.mScaleFactor) / N_x)
                                            * N_Tiled + add, aux_Image_Y);
                } else {
                    World.mMatrixflip
                            .setTranslate(aux_Image_X, aux_Image_Y);
                }

                World.mMatrixflip.preScale(World.mScaleFactor
                        * orientation, World.mScaleFactor);

                g.drawBitmap(auxImage, World.mMatrixflip, null);
            } else {
                g.drawBitmap(auxImage, aux_Image_X, aux_Image_Y, null);
            }
            if (isSelected) {
                /*
                 * if(isFlip){ aux_Image_X +=
                 * ((Aux_Image.getWidth()*World.mScaleFactor)/N_x)*N_Tiled;
                 * }
                 */
                UtilSoftgames.animationSelectedObject(g, auxImage,
                        aux_Image_X, aux_Image_Y, isFlip, N_x, N_Tiled);
            }
            g.restore();
        }
    }

}
