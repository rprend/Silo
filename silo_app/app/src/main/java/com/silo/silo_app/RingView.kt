package com.silo.silo_app

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class RingView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    var ecoVal: Float = 0f
    val backgroundPaint: Paint = Paint().apply {
        color = Color.BLACK
        strokeWidth = 40f
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }

    val textPaint: Paint = Paint().apply {
        color = Color.BLACK
        textSize = 250f
    }

    var animator: ValueAnimator = ValueAnimator.ofFloat(0f, 270f).apply {
        duration = 1000
        addUpdateListener {
            ecoVal = it.animatedValue as Float
            invalidate()
        }
    }

    fun setEcoValue(newEcoVal: Float) {
        if (animator.isRunning) {
            animator.cancel()
        }

        animator = ValueAnimator.ofFloat(0f, newEcoVal).apply {
            duration = 1000
            addUpdateListener {
                ecoVal = it.animatedValue as Float
                invalidate()
            }
        }
        animator.start()
    }

    // Called when the view should render its content.
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        // DRAW STUFF HERE
        val viewWidth = width / 2f
        val viewHeight = height / 2f

        val ecoVal: Float = (animator.animatedValue as Float)
        val mulEcoVal: Float = ecoVal * 1000
        canvas!!.drawText(mulEcoVal.toInt().toString(), viewWidth - 200, viewHeight, textPaint)

        val padding = 100f

        val leftTopX = padding
        val leftTopY = padding

        val rightBotX = width - padding
        val rightBotY = height - padding

        canvas.drawArc(leftTopX, leftTopY, rightBotX, rightBotY, 130f, ecoVal * 360f, false, backgroundPaint)
    }
}
