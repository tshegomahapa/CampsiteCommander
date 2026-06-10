package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
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
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme

class DetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsiteCommanderTheme {
                Button(
                    onClick = {
                        //Goes back to Main Screen.
                        val intent = Intent(this@DetailedView, MainActivity::class.java)
                        startActivity(intent)
                    }
                ) {
                    Text("Back To Base")
                }
            }
        }
    }
}

