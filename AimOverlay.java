package com.soccerstars.aimassist;
import android.content.Context;import android.graphics.*;import android.view.View;
public class AimOverlay extends View{Paint p=new Paint(1);public AimOverlay(Context c){super(c);}protected void onDraw(Canvas c){float x=getWidth()*.5f,y=getHeight()*.62f,ex=getWidth()*.72f,ey=getHeight()*.57f;p.setStyle(Paint.Style.STROKE);p.setStrokeWidth(5);p.setColor(Color.CYAN);c.drawLine(x,y,ex,ey,p);p.setStyle(Paint.Style.FILL);p.setColor(Color.RED);c.drawCircle(ex,ey,18,p);}}
