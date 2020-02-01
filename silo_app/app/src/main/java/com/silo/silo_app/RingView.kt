package com.silo.silo_app

import android.animation.ArgbEvaluator
import android.animation.ValueAnimator
import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class RingView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : View(context, attrs, defStyleAttr) {

    val redColor = resources.getColor(R.color.red)
    val greenColor = Color.GREEN

    var ecoVal: Float = 0f
    val ringPaint: Paint = Paint().apply {
        color = resources.getColor(R.color.red)
        strokeWidth = 40f
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }

    val backgroundRingPaint: Paint = Paint().apply {
        strokeWidth = 40f
        style = Paint.Style.STROKE
        strokeCap = Paint.Cap.ROUND
    }

    val textPaint: Paint = Paint().apply {
        color = Color.BLACK
        textSize = 250f
    }

    var animator: ValueAnimator = ValueAnimator()
    var colorAnimator: ValueAnimator = ValueAnimator()

    fun setEcoValue(newEcoVal: Float) {
        if (animator.isRunning) {
            animator.cancel()
            colorAnimator.cancel()
        }

        val duration: Long = 1300
        val endColor: Object = ArgbEvaluator().evaluate(newEcoVal, redColor, greenColor) as Object
        colorAnimator = ValueAnimator.ofObject(ArgbEvaluator(), redColor, endColor).apply {
            this.duration = duration
            addUpdateListener {
                ringPaint.color = it.animatedValue as Int
            }
        }

        animator = ValueAnimator.ofFloat(0f, newEcoVal).apply {
            this.duration = duration
            addUpdateListener {
                ecoVal = it.animatedValue as Float
                invalidate()
            }
        }
        colorAnimator.start()
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

        canvas.drawArc(leftTopX, leftTopY, rightBotX, rightBotY, 0f, 360f, false, backgroundRingPaint)
        canvas.drawArc(leftTopX, leftTopY, rightBotX, rightBotY, 130f, ecoVal * 360f, false, ringPaint)
    }
}
