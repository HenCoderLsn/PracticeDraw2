package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

/**
 * Created by xh on 2017/11/2.
 */
class Practice15FillPathView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mPathPaint = Paint(Paint.ANTI_ALIAS_FLAG);

    private val mPath = Path()

    private var path1 = Path()
    private var path2 = Path()
    private var path3 = Path()

    init {
        mPath.moveTo(50f, 100f)
        mPath.rLineTo(50f, 100f)
        mPath.rLineTo(80f, -150f)
        mPath.rLineTo(100f, 100f)
        mPath.rLineTo(70f, -120f)
        mPath.rLineTo(150f, 80f)

        setLayerType(LAYER_TYPE_SOFTWARE, null)
        mPathPaint.style = Paint.Style.STROKE

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.strokeWidth = 0f

        canvas!!.drawPath(mPath, mPaint)

        canvas.save()
        canvas.translate(500f, 0f)
        mPaint.getFillPath(mPath, path1)
        canvas.drawPath(path1, mPathPaint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 200f)
        // 第一处：获取 Path
        mPaint.style = Paint.Style.STROKE
        canvas.drawPath(mPath, mPaint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 200f)
        // 第二处：设置 Style 为 STROKE 后再获取 Path
        mPaint.getFillPath(mPath, path2)
        canvas.drawPath(path2, mPathPaint)
        canvas.restore()

        canvas.save()
        canvas.translate(0f, 400f)
        mPaint.strokeWidth = 40f
        mPaint.style = Paint.Style.STROKE
        canvas.drawPath(mPath, mPaint)
        canvas.restore()

        canvas.save()
        canvas.translate(500f, 400f)
        // 第三处：Style 为 STROKE 并且线条宽度为 40 时的 Path
        mPaint.getFillPath(mPath, path3)
        canvas.drawPath(path3, mPathPaint)
        canvas.restore()

    }

}