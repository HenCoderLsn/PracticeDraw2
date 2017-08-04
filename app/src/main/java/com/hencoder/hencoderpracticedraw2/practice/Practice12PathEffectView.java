package com.hencoder.hencoderpracticedraw2.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice12PathEffectView extends View {

    private Paint mPaint;
    private Path mPath;

    public Practice12PathEffectView(Context context) {
        this(context, null);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice12PathEffectView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();

        mPath.moveTo(50, 100);
        mPath.rLineTo(50, 100);
        mPath.rLineTo(80, -150);
        mPath.rLineTo(100, 100);
        mPath.rLineTo(70, -120);
        mPath.rLineTo(150, 80);
    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setPathEffect() 来设置不同的 PathEffect

        // 第一处：CornerPathEffect
        mPaint.setPathEffect(new CornerPathEffect(20));
        canvas.drawPath(mPath, mPaint);

        canvas.save();
        canvas.translate(500, 0);
        // 第二处：DiscretePathEffect
        mPaint.setPathEffect(new DiscretePathEffect(20, 5));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(0, 200);
        // 第三处：DashPathEffect
        mPaint.setPathEffect(new DashPathEffect(new float[]{20, 10, 5, 10}, 0));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 200);
        Path path = new Path();
        path.lineTo(20, 40);
        path.lineTo(40, 8);
        mPaint.setStyle(Paint.Style.FILL);
        // 第四处：PathDashPathEffect
        mPaint.setPathEffect(new PathDashPathEffect(path, 47, 0, PathDashPathEffect.Style.TRANSLATE));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        mPaint.setStyle(Paint.Style.STROKE);
        canvas.save();
        canvas.translate(0, 400);
        // 第五处：SumPathEffect
        mPaint.setPathEffect(new SumPathEffect(new DashPathEffect(new float[]{20, 10, 5, 10}, 0), new DiscretePathEffect(20, 5)));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();

        canvas.save();
        canvas.translate(500, 400);
        // 第六处：ComposePathEffect
        mPaint.setPathEffect(new ComposePathEffect(new DashPathEffect(new float[]{20, 10, 5, 10}, 0), new DiscretePathEffect(20, 5)));
        canvas.drawPath(mPath, mPaint);
        canvas.restore();
    }

}
