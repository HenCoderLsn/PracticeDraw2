package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by xh on 2017/11/1.
 */
class Practice13ShadowLayerView : View {

    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val mLeftMargin = 50f
    private val mTopMargin = 200f

    private val mTextSize = 120f
    private val mText = "Hello HenCoder"

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.textSize = mTextSize
        mPaint.setShadowLayer(5f, 5f, 5f, Color.RED)

        canvas!!.drawText(mText, mLeftMargin, mTopMargin, mPaint)


    }

}