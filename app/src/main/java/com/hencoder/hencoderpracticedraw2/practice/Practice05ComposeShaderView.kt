package com.hencoder.hencoderpracticedraw2.practice

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.hencoder.hencoderpracticedraw2.R

/**
 * Created by xh on 2017/10/17.
 */
class Practice05ComposeShaderView : View {

    private val mPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val mStartBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman)
    private val mEndBitmap = BitmapFactory.decodeResource(resources, R.drawable.batman_logo)

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        setLayerType(LAYER_TYPE_SOFTWARE, mPaint)
        val mStartShader = BitmapShader(mStartBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val mEndShader = BitmapShader(mEndBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP)
        val mComposeShader = ComposeShader(mStartShader, mEndShader, PorterDuff.Mode.DST_ATOP)
        mPaint.shader = mComposeShader
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas!!.drawCircle(200f, 200f, 200f, mPaint)
//        canvas!!.drawPaint(mPaint)

    }

}