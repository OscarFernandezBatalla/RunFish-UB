package com.example.frponsll40alumnes.runfish

import android.graphics.Canvas
import android.support.constraint.ConstraintLayout
import android.text.Layout
import android.view.SurfaceHolder
import android.view.View
import kotlinx.android.synthetic.main.fragment_game.view.*


class GameThread(private var surfaceHolder: SurfaceHolder, private var gameView: GameView) : Thread(){
    private val FPS : Int = 30
    private var isRunning : Boolean = false

    private var constraintGO : ConstraintLayout?= null
    private var constraintS : ConstraintLayout?= null


    fun setRunning(isRunning: Boolean) {
        this.isRunning = isRunning
    }

    override fun run() {
        var targetTime = 1000/FPS
        while (isRunning){
            var startTime = System.nanoTime()
            if(!gameView.getPause()) {

                canvas = null

                try {
                    canvas = this.surfaceHolder.lockCanvas()
                    synchronized(surfaceHolder) {
                        gameView.update()
                        gameView.draw(canvas!!)
                    }

                } catch (e: Exception) {
                    e.printStackTrace()
                } finally {
                    if (canvas != null) {
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvas)
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }
            var timeMilis = (System.nanoTime() - startTime) / 1000000
            var waitMilis = targetTime - timeMilis

            if(waitMilis < 0)
                waitMilis = 0 //no fa saltar les excepcions

            try {
                sleep(waitMilis)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    companion object {
        private var canvas: Canvas? = null
    }
}