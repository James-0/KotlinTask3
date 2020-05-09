package com.example.kotlintask3


import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.signup_page.*


class SignupActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)
        submit?.setOnClickListener(this)
        reset?.setOnClickListener(this)

    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "landscape", Toast.LENGTH_LONG).show()
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "portrait", Toast.LENGTH_LONG).show()
        }
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            R.id.submit -> {
                val user =  arrayListOf(User(firstName.text.toString(), lastName.text.toString(), userName.text.toString(),
                        email.text.toString(), dob.text.toString(), password.text.toString(), quote.text.toString()))

                val list: ArrayList<User> = PreferencesManager.saveGson(user, "key") as ArrayList<User>
                println(" saved ${list.joinToString { it.fName.toString() }} ")
                Toast.makeText(applicationContext, "Saved ${list.joinToString { it.fName.toString() }}", Toast.LENGTH_LONG).show()
                intent  = Intent(applicationContext, LoginActivity::class.java)
                startActivity(intent)
                clear()
            }
            R.id.reset -> {
                clear()
            }
        }
    }

    private fun clear() {
        firstName.setText("")
        lastName.setText("")
        userName.setText("")
        quote.setText("")
        email.setText("")
        dob.setText("")
        password.setText("")
    }

}

