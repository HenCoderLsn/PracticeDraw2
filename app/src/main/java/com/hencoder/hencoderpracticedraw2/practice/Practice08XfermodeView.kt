package com.hencoder.hencoderpracticedraw2.practice

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * Created by xh on 2017/10/17.
 */
class Practice08XfermodeView : View {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mSrcBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val mBitmap1 = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val mDestBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)
    private val mBitmap2 = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)

    private var mRectF = RectF()

    private lateinit var xfermode : PorterDuffXfermode

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        mRectF.set(0f, 0f, w.toFloat(), h.toFloat())
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.saveLayer(mRectF, null, Canvas.ALL_SAVE_FLAG)
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST)
        canvas.drawBitmap(mSrcBitmap, 0f, 0f, mPaint)
        mPaint.xfermode = null
        canvas.drawBitmap(mDestBitmap, 0f, 0f, mPaint)
        canvas.restore()

        canvas.saveLayer(mRectF, null, Canvas.ALL_SAVE_FLAG)
        canvas.translate(mSrcBitmap.width + 100f, 0f)
        mPaint.xfermode = null
        canvas.drawBitmap(mSrcBitmap, 0f, 0f, mPaint)
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_ATOP)
        canvas.drawBitmap(mDestBitmap, 0f, 0f, mPaint)
        canvas.restore()

        canvas.saveLayer(mRectF, null, Canvas.ALL_SAVE_FLAG)
        canvas.translate(0f, mSrcBitmap.height + 20f)
        mPaint.xfermode = null
        canvas.drawBitmap(mSrcBitmap, 0f, 0f, mPaint)
        mPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.DST_OUT)
        canvas.drawBitmap(mDestBitmap, 0f, 0f, mPaint)
        canvas.restore()


    }

}