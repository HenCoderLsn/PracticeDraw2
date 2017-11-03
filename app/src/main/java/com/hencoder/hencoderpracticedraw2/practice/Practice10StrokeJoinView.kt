package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Created by xh on 2017/10/19.
 */
class Practice10StrokeJoinView : View {

    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val mPath = Path()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        mPaint.strokeWidth = 40f
        mPaint.style = Paint.Style.STROKE

        mPath.rLineTo(200f, 0f)
        mPath.rLineTo(-160f, 120f)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.translate(100f, 100f)
        canvas.drawPath(mPath, mPaint)

        canvas.translate(300f, 0f)
        mPaint.strokeJoin = Paint.Join.BEVEL
        canvas.drawPath(mPath, mPaint)

        canvas.translate(300f, 0f)
        mPaint.strokeJoin = Paint.Join.ROUND
        canvas.drawPath(mPath, mPaint)

    }

}