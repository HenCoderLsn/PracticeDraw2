package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10StrokeJoinView extends View {

    private Paint mPaint;
    private Path mPath;

    public Practice10StrokeJoinView(Context context) {
        this(context, null);
    }

    public Practice10StrokeJoinView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice10StrokeJoinView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPath = new Path();
        mPaint.setStrokeWidth(40);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath.rLineTo(200, 0);
        mPath.rLineTo(-160, 120);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();

        // 使用 Paint.setStrokeJoin() 来设置不同的拐角形状

        canvas.translate(100, 100);
        // 第一种形状：MITER
        canvas.drawPath(mPath, mPaint);

        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.translate(300, 0);
        // 第二种形状：BEVEL
        canvas.drawPath(mPath, mPaint);

        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.translate(300, 0);
        // 第三种形状：ROUND
        canvas.drawPath(mPath, mPaint);

        canvas.restore();
    }

}
