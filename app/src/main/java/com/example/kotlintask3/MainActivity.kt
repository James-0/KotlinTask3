package com.example.kotlintask3

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val logos = ArrayList<Icon>()
    private var user = ArrayList<User>()
//    private val intent = getIntent()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addItem()
        val gridView = findViewById<GridView>(R.id.gridView)
        var intent = intent
        var user: ArrayList<User>?  = intent.getParcelableArrayListExtra<User>("user")
        gridView.adapter = ImageAdapter(this, logos)
        val fullName = user?.joinToString { "${it.fName } ${ it.lName }" }
        nameFull.text = fullName
        toolBar.title = user?.joinToString { it.uName.toString() }
        eMail.text = user?.joinToString { it.email.toString() }
        description.text = user?.joinToString { it.quote.toString() }
        gridView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
        Toast.makeText(this, " Clicked Position: " + (logos[position].title),
                Toast.LENGTH_SHORT).show()
            val page = Uri.parse(logos[position].uri)
            val intent = Intent(Intent.ACTION_VIEW, page)

            val chooser = Intent.createChooser(intent, "Open With")
            if (intent.resolveActivity(packageManager) != null) {
                startActivity(chooser)
            } else {
                Log.d("Implicit Intents", "Can't handle this intent")
            }
            }
        }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("TAG", "onRestoreInstanceState")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.d("TAG", "onSaveInstanceState")
    }
   private fun addItem( ) {
           logos.addAll(listOf(
               Icon("http://assistant.google.com", "google", R.drawable.google),
               Icon("http://youtube.com", "youtube", R.drawable.youtube),
               Icon("https://bitbucket.org", "bitbucket", R.drawable.bitbucket),
               Icon("https://android.com", "android", R.drawable.android),
               Icon("https://www.internetsociety.org", "linkedin", R.drawable.internet),
               Icon("https://dribble.com", "dribble", R.drawable.dribbble),
               Icon("https://facebook.com", "facebook", R.drawable.facebook),
               Icon("http://google.com/plus", "googleplus", R.drawable.googleplus),
               Icon("https://mail.google.com", "gmail", R.drawable.gmail),
               Icon("https://play.google.com/store", "googleplay", R.drawable.googleplay),
               Icon("http://instagram.com", "instagram", R.drawable.instagram),
               Icon("https://www.linkedin.com", "linkedin", R.drawable.linkedin),
               Icon("https://github.com", "github", R.drawable.github),
               Icon("http://skype.com", "skype", R.drawable.skype),
               Icon("https://twitter.com", "twitter", R.drawable.twitter),
               Icon("https://www.whatsapp.com", "whatsapp", R.drawable.whatsapp)

           ))
    }

}
