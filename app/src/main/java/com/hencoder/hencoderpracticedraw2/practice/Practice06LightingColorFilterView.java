package com.hencoder.hencoderpracticedraw2.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice06LightingColorFilterView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;

    public Practice06LightingColorFilterView(Context context) {
        this(context, null);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice06LightingColorFilterView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
    }


    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 Paint.setColorFilter() 来设置 LightingColorFilter
        LightingColorFilter colorFilter = new LightingColorFilter(0X00FFFF, 0X000000);
        mPaint.setColorFilter(colorFilter);
        // 第一个 LightingColorFilter：去掉红色部分
        canvas.drawBitmap(mBitmap, 0, 0, mPaint);


        // 第二个 LightingColorFilter：增强绿色部分
        colorFilter = new LightingColorFilter(0XFFFFFF, 0X003000);
        mPaint.setColorFilter(colorFilter);
        canvas.drawBitmap(mBitmap, mBitmap.getWidth() + 100, 0, mPaint);
    }

}
