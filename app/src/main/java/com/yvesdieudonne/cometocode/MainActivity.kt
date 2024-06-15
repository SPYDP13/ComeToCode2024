package com.yvesdieudonne.cometocode

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.yvesdieudonne.cometocode.Home.HomeActivity
import java.util.Timer


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val videoView: VideoView = findViewById<VideoView>(R.id.videoView)
        videoView.setVideoURI(Uri.parse("android.resource://"
                + packageName + "/" + R.raw.yala))
        videoView.start()

        object: CountDownTimer(4000,1000){
            override fun onTick(p0: Long) {

            }

            override fun onFinish() {
                Intent(this@MainActivity, HomeActivity::class.java).also {
                startActivity(it)
                }
            }
        }.start()



    }
}