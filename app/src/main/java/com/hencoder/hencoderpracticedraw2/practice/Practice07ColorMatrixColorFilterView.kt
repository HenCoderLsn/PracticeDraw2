package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * Created by xh on 2017/10/17.
 */
class Practice07ColorMatrixColorFilterView : View {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        val mColorMatrix = ColorMatrix()
        mColorMatrix.setSaturation(0f)
        val mColorMatrixColorFilter = ColorMatrixColorFilter(mColorMatrix)
        mPaint.colorFilter = mColorMatrixColorFilter
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.drawBitmap(mBitmap, 0f, 0f, mPaint)

    }

}