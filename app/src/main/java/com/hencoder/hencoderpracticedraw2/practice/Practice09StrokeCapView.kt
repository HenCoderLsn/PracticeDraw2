package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * Created by xh on 2017/10/18.
 */
class Practice09StrokeCapView : View {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.style = Paint.Style.FILL
        mPaint.strokeWidth = 40f

        mPaint.strokeCap = Paint.Cap.BUTT
        canvas!!.drawLine(50f, 50f, 400f, 50f, mPaint)

        mPaint.strokeCap = Paint.Cap.ROUND
        canvas.drawLine(50f, 150f, 400f, 150f, mPaint)

        mPaint.strokeCap = Paint.Cap.SQUARE
        canvas.drawLine(50f, 250f, 400f, 250f, mPaint)

    }

}