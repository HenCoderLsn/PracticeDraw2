package com.hencoder.hencoderpracticedraw2.practice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

import java.util.Calendar;

public class Practice08XfermodeView extends View {

    private Paint mPaint;
    private Bitmap mBitmap1;
    private Bitmap mBitmap2;

    public Practice08XfermodeView(Context context) {
        this(context, null);
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice08XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mBitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        mBitmap2 = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);

    }

    @SuppressLint("DrawAllocation")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 mPaint.setXfermode() 设置不同的结合绘制效果

        // 别忘了用 canvas.saveLayer() 开启 off-screen buffer

        canvas.saveLayer(new RectF(0, 0, getWidth(), getHeight()), mPaint, Canvas.ALL_SAVE_FLAG);

        canvas.drawBitmap(mBitmap1, 0, 0, mPaint);

        Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        mPaint.setXfermode(xfermode);
        // 第一个：PorterDuff.Mode.SRC
        canvas.drawBitmap(mBitmap2, 0, 0, mPaint);
        canvas.restore();

        mPaint.setXfermode(null);

        canvas.saveLayer(new RectF(0, 0, getWidth(), getHeight()), mPaint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(mBitmap1, mBitmap1.getWidth() + 100, 0, mPaint);
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP);
        mPaint.setXfermode(xfermode);
        // 第二个：PorterDuff.Mode.DST_IN
        canvas.drawBitmap(mBitmap2, mBitmap1.getWidth() + 100, 0, mPaint);
        mPaint.setXfermode(null);
        canvas.restore();

        canvas.saveLayer(new RectF(0, 0, getWidth(), getHeight()), mPaint, Canvas.ALL_SAVE_FLAG);
        xfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        canvas.drawBitmap(mBitmap1, 0, mBitmap1.getHeight() + 20, mPaint);
        mPaint.setXfermode(xfermode);
        // 第三个：PorterDuff.Mode.DST_OUT
        canvas.drawBitmap(mBitmap2, 0, mBitmap1.getHeight() + 20, mPaint);
        mPaint.setXfermode(null);
        canvas.restore();
        // 用完之后使用 canvas.restore() 恢复 off-screen buffer
    }

}
