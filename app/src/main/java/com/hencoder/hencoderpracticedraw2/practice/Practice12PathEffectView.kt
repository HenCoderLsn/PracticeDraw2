package com.hencoder.hencoderpracticedraw2.practice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

/**
 * Created by xh on 2017/10/19.
 */
class Practice12PathEffectView : View {

    val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    val mPath = Path()

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        mPaint.style = Paint.Style.STROKE
        mPath.moveTo(50f, 100f)
        mPath.rLineTo(50f, 100f)
        mPath.rLineTo(80f, -150f)
        mPath.rLineTo(100f, 100f)
        mPath.rLineTo(70f, -120f)
        mPath.rLineTo(150f, 80f)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.pathEffect = CornerPathEffect(20f)
        canvas!!.drawPath(mPath, mPaint)

        canvas.translate(500f, 0f)
        mPaint.pathEffect = DiscretePathEffect(20f, 5f)
        canvas.drawPath(mPath, mPaint)

        canvas.translate(-500f, 200f)
        mPaint.pathEffect = DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 5f)
        canvas.drawPath(mPath, mPaint)

        canvas.translate(500f, 0f)
        val path = Path();
        path.rLineTo(20f, -25f)
        path.rLineTo(20f, 25f)
        mPaint.pathEffect = PathDashPathEffect(path, 47f, 0f, PathDashPathEffect.Style.MORPH)
        canvas.drawPath(mPath, mPaint)

        canvas.translate(-500f, 200f)
        mPaint.pathEffect = SumPathEffect(DiscretePathEffect(20f, 5f), DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 5f))
        canvas.drawPath(mPath, mPaint)

        canvas.translate(500f, 0f)
        mPaint.pathEffect = ComposePathEffect(DashPathEffect(floatArrayOf(20f, 10f, 5f, 10f), 5f), DiscretePathEffect(20f, 5f))
        canvas.drawPath(mPath, mPaint)

    }

}