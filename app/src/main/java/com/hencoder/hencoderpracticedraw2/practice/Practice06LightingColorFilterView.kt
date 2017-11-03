package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * Created by xh on 2017/10/17.
 */
class Practice06LightingColorFilterView : View {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)

    private var mLightingColorFilter1 = LightingColorFilter(0X00FFFF, 0)
    private var  mLightingColorFilter2 = LightingColorFilter(0XFFFFFF, 0X003000)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        mPaint.colorFilter = mLightingColorFilter1
        canvas!!.drawBitmap(mBitmap, 0f, 0f, mPaint)
        mPaint.colorFilter = mLightingColorFilter2
        canvas.drawBitmap(mBitmap, mBitmap.width + 100f, 0f, mPaint)

    }

}