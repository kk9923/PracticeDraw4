package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice12CameraRotateFixedView extends View {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);
    Camera camera = new Camera();
    Matrix matrix = new Matrix();
    public Practice12CameraRotateFixedView(Context context) {
        super(context);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice12CameraRotateFixedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        //图片1的中心点坐标
        int center1X = point1.x+ bitmapWidth/2;
        int center1Y = point1.y+ bitmapHeight/2;
//        camera.save();
//        matrix.reset();
//        camera.rotateX(30);
//        camera.getMatrix(matrix);
//        camera.restore();
//        matrix.postTranslate(-centerX1,-centerY1);
//      //  camera.applyToCanvas(canvas);
//        matrix.postTranslate(centerX1,centerY1);
//        canvas.save();
//        canvas.concat(matrix);
//        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
//        canvas.restore();

        camera.save();
        matrix.reset();
        float locationX = camera.getLocationX();
        float locationY = camera.getLocationY();
        float locationZ = camera.getLocationZ();
        System.out.println(locationX);
        System.out.println(locationY);
        System.out.println(locationZ);
        camera.setLocation(center1X,center1Y,-8);
        System.out.println("new x =   "+camera.getLocationX());
        System.out.println("new y =   "+camera.getLocationY());
        System.out.println("new z =   "+camera.getLocationZ());
      //  camera.getMatrix(matrix);
       // camera.restore();
      //  matrix.preTranslate(-center1X, -center1Y);
       // matrix.postTranslate(center1X, center1Y);

        canvas.save();
       // canvas.concat(matrix);
        camera.rotateX(30);
        camera.applyToCanvas(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        canvas.restore();


        //图片2的中心点坐标
        int centerX2 = point2.x+ bitmapWidth/2;
        int centerY2 = point2.y+ bitmapWidth/2;

    }
}
