package com.example.frponsll40alumnes.runfish

import android.graphics.Canvas
import android.view.SurfaceHolder


class GameThread(private var surfaceHolder: SurfaceHolder, private var gameView: GameView) : Thread(){
    private val FPS : Int = 30
    private var isRunning : Boolean = false

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

        //aqui el gameOver / successful? ojo

    }

    companion object {
        private var canvas: Canvas? = null
    }
}