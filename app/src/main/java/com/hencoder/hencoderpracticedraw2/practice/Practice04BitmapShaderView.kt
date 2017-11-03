package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * Created by xh on 2017/10/17.
 */
class Practice04BitmapShaderView : View {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var mBitmapShader: BitmapShader

    private val mBitmap= BitmapFactory.decodeResource(resources, R.drawable.batman)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        mBitmapShader = BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        mPaint.shader = mBitmapShader
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.drawCircle(200f, 200f, 200f, mPaint)

    }

}