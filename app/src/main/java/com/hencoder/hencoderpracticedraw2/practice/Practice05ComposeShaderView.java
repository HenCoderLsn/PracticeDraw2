package com.hencoder.hencoderpracticedraw2.practice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw2.R;

public class Practice05ComposeShaderView extends View {

    private Paint mPaint;

    public Practice05ComposeShaderView(Context context) {
        this(context, null);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Practice05ComposeShaderView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        Bitmap bitmapA = BitmapFactory.decodeResource(getResources(), R.drawable.batman);
        Bitmap bitmapB = BitmapFactory.decodeResource(getResources(), R.drawable.batman_logo);

        setLayerType(LAYER_TYPE_SOFTWARE, null); // 硬件加速下 ComposeShader 不能使用两个同类型的 Shader

        Shader bitmapAShader = new BitmapShader(bitmapA, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);
        Shader bitmapBShader = new BitmapShader(bitmapB, Shader.TileMode.CLAMP, Shader.TileMode.MIRROR);

        Shader shader = new ComposeShader(bitmapAShader, bitmapBShader, PorterDuff.Mode.DST_ATOP);

        mPaint.setShader(shader);

        // 用 Paint.setShader(shader) 设置一个 ComposeShader
        // Shader 1: BitmapShader 图片：R.drawable.batman
        // Shader 2: BitmapShader 图片：R.drawable.batman_logo
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawCircle(200, 200, 200, mPaint);
    }

}
