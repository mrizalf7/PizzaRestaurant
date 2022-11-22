package com.example.pizzarestaurant.utils

import android.graphics.Paint
import android.graphics.Typeface

import android.text.TextPaint

import android.text.style.TypefaceSpan


class CustomTypefaceSpan(type: Typeface?) : TypefaceSpan("") {
    private var mNewType: Typeface = Typeface.DEFAULT

    init {
        if (type != null) {
            this@CustomTypefaceSpan.mNewType = type
        }
    }

    override fun updateDrawState(ds: TextPaint) {
        applyCustomTypeFace(ds, mNewType)
    }

    override fun updateMeasureState(paint: TextPaint) {
        applyCustomTypeFace(paint, mNewType)
    }

    companion object {
        private fun applyCustomTypeFace(paint: Paint, tf: Typeface) {
            val oldStyle: Int
            val old: Typeface = paint.getTypeface()
            oldStyle = old?.style ?: 0
            val fake = oldStyle and tf.style.inv()
            if (fake and Typeface.BOLD != 0) {
                paint.setFakeBoldText(true)
            }
            if (fake and Typeface.ITALIC != 0) {
                paint.setTextSkewX(-0.25f)
            }
            paint.setTypeface(tf)
        }
    }
}