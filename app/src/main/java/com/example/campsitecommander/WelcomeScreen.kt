package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat
import androidx.core.os.postDelayed
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme
import com.example.campsitecommander.ui.theme.Purple80

class WelcomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            CampsiteCommanderTheme {

                val rootLayout = LinearLayout(this).apply{
                    orientation = LinearLayout.VERTICAL
                    layoutParams= LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                }
                val textTitle = TextView(this).apply {
                    text = "Campsite Commander"
                    textSize = 20f
                }
                val imageView = ImageView(this).apply {
                    setImageDrawable(ContextCompat.getDrawable(this@WelcomeScreen,R.drawable.campfire_image))
                    layoutParams= LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                    )
                }
                rootLayout.addView(textTitle)
                rootLayout.addView(imageView)
                setContentView(rootLayout)
                Column(
                    modifier =
                        Modifier.fillMaxSize(),
                    verticalArrangement =
                        Arrangement.Center,
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {


                    Text("Welcome to the app which helps you store the camping gear and food supplies you will need for the camp.")
                    Handler(Looper.getMainLooper()).postDelayed({
                        //starts the next screen.
                        val intent = Intent(this@WelcomeScreen, MainActivity::class.java)
                        startActivity(intent)
                        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                        finish()
                    }, 3000) // Transitions to main screen after 3 seconds(3000 milliseconds).


                }
            }
        }

    }
}



