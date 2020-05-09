package com.example.kotlintask3

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.login_page.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private var progressBar : ProgressBar? = null
    private var i = 0
    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_page)
        progressBar = findViewById<ProgressBar>(R.id.progressBar)
        button5.setOnClickListener(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        var user: ArrayList<User> = PreferencesManager.getGson("key")
        when(v?.id) {
            R.id.button5 -> {
                var firstN = email?.text.toString()
                var passs = password?.text.toString()

                if (firstN.trim().isNotEmpty() && passs.trim().isNotEmpty()) {

                    if (user.joinToString { it.email.toString() } == firstN && user.joinToString { it.password.toString() } == passs) {
                        Toast.makeText(applicationContext, "Welcome ${user.joinToString { it.fName.toString() }}", Toast.LENGTH_SHORT).show()
                        progress()
                        intent  = Intent(applicationContext, MainActivity::class.java)
                        intent.putParcelableArrayListExtra("user", user)
                        startActivity(intent)
                        progressBar?.visibility = View.GONE
                    } else {
                        Toast.makeText(applicationContext, "incorrect email/password combination. \n try again", Toast.LENGTH_SHORT).show()
                        email.setText("")
                        password.setText("")
                    }

                } else {
                    Toast.makeText(applicationContext, "Empty Values", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
    private fun progress() {
        i = progressBar!!.progress
        Thread(Runnable {
            while (i < 100) {
                i += 5
                handler.post(Runnable {
                    progressBar?.visibility = View.VISIBLE
                    progressBar!!.progress = i
                })
                try {
                    Thread.sleep(10)
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }).start()
    }
}
