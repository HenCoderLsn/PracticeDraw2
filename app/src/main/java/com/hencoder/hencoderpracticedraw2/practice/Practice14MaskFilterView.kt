package com.hencoder.hencoderpracticedraw2.practice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.BlurMaskFilter
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * Created by xh on 2017/11/1.
 */
class Practice14MaskFilterView : View {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mBitmap = BitmapFactory.decodeResource(resources, R.drawable.what_the_fuck)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, null)
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        // 第一个：NORMAL
        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.NORMAL)
        canvas!!.drawBitmap(mBitmap, 100f, 50f, mPaint)

        // 第二个：INNER
        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.INNER)
        canvas.drawBitmap(mBitmap, mBitmap.width + 200f, 50f, mPaint)

        // 第三个：OUTER
        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.OUTER)
        canvas.drawBitmap(mBitmap, 100f, mBitmap.height + 100f, mPaint)

        // 第四个：SOLID
        mPaint.maskFilter = BlurMaskFilter(50f, BlurMaskFilter.Blur.SOLID)
        canvas.drawBitmap(mBitmap, mBitmap.width + 200f, mBitmap.height + 100f, mPaint)

    }

}