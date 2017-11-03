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
class Practice16TextPathView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mText = "Hello HenCoder";
    private val mTextSize = 120f;

    private var mPath = Path()

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.textSize = mTextSize
        canvas!!.drawText(mText, 50f, 150f, mPaint)

        mPaint.style = Paint.Style.STROKE
        mPaint.getTextPath(mText, 0, mText.length, 0f, 0f, mPath)

        canvas.translate(50f, 300f)

        canvas.drawPath(mPath, mPaint)

    }

}