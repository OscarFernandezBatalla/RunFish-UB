package com.example.frponsll40alumnes.runfish

import android.graphics.Canvas
import android.view.SurfaceHolder


class GameThread(private var surfaceHolder: SurfaceHolder, private var gameView: GameView) : Thread(){
    private val FPS : Int = 30

    private val avgFPS : Double = 0.0
    private var isRunning : Boolean = false
    private var canvas : Canvas? = null             //es pot esborrar aixo i fer el companion d'abaix, no se la

    fun setRunning(isRunning: Boolean) {
        this.isRunning = isRunning
    }

    override fun run() {
        var targetTime = 1000/FPS
        while (isRunning){
            var startTime = System.nanoTime()
            canvas = null

            try{
                canvas = this.surfaceHolder.lockCanvas()
                synchronized(surfaceHolder) {
                    gameView.update()
                    //falta el draw()?
                    gameView.draw(canvas!!)
                }

                } catch (e : Exception){
                    e.printStackTrace()
                } finally {
                    if (canvas != null){
                        try {
                            surfaceHolder.unlockCanvasAndPost(canvas)
                        } catch (e: Exception){
                            e.printStackTrace()
                        }
                    }
                }
            var timeMilis = (System.nanoTime()-startTime) / 1000000
            var waitMilis = targetTime - timeMilis

            try {
                sleep(waitMilis)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }
/*
    companion object {
        private var canvas: Canvas? = null
    }
*/

}