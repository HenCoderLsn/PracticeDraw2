package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import android.util.AttributeSet
import android.view.View

/**
 * Created by xh on 2017/10/16.
 */
class Practice01LinearGradientView : View {

    private var mLinearGradient: LinearGradient

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mRadius = 200f

    private val mStartColor = 0XFFE91E63.toInt()
    private val mEndColor = 0XFF2196F3.toInt()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init{
        mLinearGradient = LinearGradient(100f, 100f, 500f, 500f, mStartColor, mEndColor, Shader.TileMode.CLAMP)
        mPaint.shader = mLinearGradient
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.drawCircle(300f, 300f, mRadius, mPaint)

    }

}