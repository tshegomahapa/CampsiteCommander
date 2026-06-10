package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.os.postDelayed
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme

class WelcomeScreen : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsiteCommanderTheme {
                Text("Welcome to the app which helps you store the camping gear and food supplies you will need for the camp.")

                Handler(Looper.getMainLooper()).postDelayed({
                    //starts the next screen.
                    val intent = Intent(this@WelcomeScreen, MainActivity::class.java)
                    startActivity(intent)
                    overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                    finish()
                } , 3000) // changes to main screen after 3000 milliseconds(3 seconds).


            }
        }
    }


}



