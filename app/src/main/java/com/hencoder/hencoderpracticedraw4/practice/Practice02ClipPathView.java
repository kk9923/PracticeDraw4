package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends View {
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(100, 100);
    Point point2 = new Point(400, 100);
    private Path path;
    private Path path2;

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        path = new Path();
        path2 = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        path.addCircle(point1.x + 200, point1.y + 200, 150, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        path2.setFillType(Path.FillType.INVERSE_WINDING);
        path2.addCircle(point2.x + 200, point2.y + 200, 150, Path.Direction.CW);
        canvas.clipPath(path2);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
