package com.gamecodeschool.c17snake;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

public class GameObject {

    protected Point location = new Point();
    protected int mSize;
    protected Bitmap mBitmap;
    void draw(Canvas canvas, Paint paint){
        canvas.drawBitmap(mBitmap,
                location.x * mSize, location.y * mSize, paint);

    }

    Point getLocation(){
        return location;
    }

}