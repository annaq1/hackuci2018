package com.example.annar.joystick;

import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.util.AttributeSet;
import android.content.Context;
import android.graphics.*;


/**
 * Created by annar on 2/3/2018.
 */

public class JoyStickControl extends SurfaceView
{
    private float centerX;
    private float centerY;
    private float baseRadius;
    private float hatRadius;
    public JoyStickControl(Context context)
    {
        super(context);
        getHolder().addCallback(this);
    }
    public JoyStickControl(Context context, AttributeSet attributes, int style)
    {
        super(context, attributes, style);
        getHolder().addCallback(this);
    }
    public JoyStickControl(Context context, AttributeSet attributes)
    {
        super(context, attributes);
        getHolder().addCallback(this);
    }
    private void drawJoystick(float newX, float newY)
    {
        if (getHolder().getSurface().isValid())
        {
            Canvas myCanvas = this.getHolder().lockCanvas();
            Paint colors = new Paint();
            myCanvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
            colors.setARGB(255, 50, 50, 50);
            myCanvas.drawCircle(centerX, centerY, baseRadius, colors);
            colors.setARGB(255,0,0,255);
            myCanvas.drawCircle(newX,newY, hatRadius, colors);
            getHolder().unlockCanvasAndPost(myCanvas);
        }
    }
    void setupDimensions()
    {
        centerX = getWidth()/2;
        centerY = getHeight()/2;
        baseRadius = Math.min(getWidth(), getHeight())/3;
        hatRadius = Math.min(getWidth(), getHeight())/5;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        setupDimensions();
        drawJoystick(centerX, centerY);
    }
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }
    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {

    }

}
