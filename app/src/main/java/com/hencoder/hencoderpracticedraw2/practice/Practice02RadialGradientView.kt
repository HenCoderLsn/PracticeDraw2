package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.RadialGradient
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

/**
 * Created by xh on 2017/10/17.
 */
class Practice02RadialGradientView : View {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mRadiaGradient: RadialGradient

    private val mRadius = 200f

    private val mStartColor = 0XFFE91E63.toInt()
    private val mEndColor = 0XFF2196F3.toInt()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        mRadiaGradient = RadialGradient(300f, 300f, mRadius, mStartColor, mEndColor, Shader.TileMode.CLAMP)
        mPaint.shader = mRadiaGradient
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.drawCircle(300f, 300f, mRadius, mPaint)

    }

}