package com.gamecodeschool.c17snake;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

import java.util.ArrayList;
import java.util.Random;

class Apple extends GameObject implements InSnake {

    // The location of the apple on the grid
    // Not in pixels
    private Point location = new Point();

    // The range of values we can choose from
    // to spawn an apple
    private Point mSpawnRange;
    private int mSize;

    /// Set up the apple in the constructor
    Apple(Context context, Point sr, int s){

        // Make a note of the passed in spawn range
        mSpawnRange = sr;
        // Hide the apple off-screen until the game starts
        location.x = -10;
        // Load the image to the bitmap
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.apple);

        // Resize the bitmap
        mBitmap = Bitmap.createScaledBitmap(mBitmap, s, s, false);
    }

    // This is called every time an apple is eaten
    void spawn(){
        // Choose two random values and place the apple
        Random random = new Random();
        location.x = random.nextInt(mSpawnRange.x) + 1;
        location.y = random.nextInt(mSpawnRange.y - 1) + 1;
    }
    void spawn(ArrayList<Point> segmentLocations){
        // Choose two random values and place the apple
        Random random = new Random();
        location.x = random.nextInt(mSpawnRange.x) + 1;
        location.y = random.nextInt(mSpawnRange.y - 1) + 1;
        //makes sure that the apple doesn't spawn in the snake, which would stop the apple from spawning.
        //potential freeze if snake covers entire screen
        if(InSnake.checkSpot(segmentLocations, location, -1)) this.spawn(segmentLocations);
    }

}