package com.example.kotlintask3


import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import kotlinx.android.synthetic.main.home.*

class StartActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var toast: Toast
    private val prefName = "Database"
    private val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home)
        signupBtn.setOnClickListener(this)
        loginBtn.setOnClickListener(this)
        preferences = application.getSharedPreferences(prefName, MODE)
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.loginBtn ->  {
                intent  = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
            }
            R.id.signupBtn -> {
                PreferencesManager.clear()
                Toast.makeText(applicationContext, "cleared", Toast.LENGTH_LONG).show()
                intent  = Intent(applicationContext, SignupActivity::class.java)
                startActivity(intent)
            }

        }
     }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "Landscape", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Portrait", Toast.LENGTH_LONG).show()
        }
    }


}
