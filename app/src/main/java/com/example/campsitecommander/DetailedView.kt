package com.example.campsitecommander

import android.R.attr.text
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme

class DetailedView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsiteCommanderTheme {
                Column(
                    modifier =
                        Modifier.fillMaxSize(),
                    verticalArrangement =
                        Arrangement.Center,
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) {


                    data class GearItem(
                        val itemName: String,
                        val category: String,
                        val quantity: Int,
                        val comments: String
                    )
                    data class PackedItem (val itemName: String , val quantity: Int)
                    val itemList = listOf(
                        PackedItem("Tent",2),
                        PackedItem("Bread",8),
                        PackedItem("pocket knife",3),
                        PackedItem("Bandage",10)
                    )
                    var totalPacked = 0

                    //Loop through each item in the list

                    for (item in itemList) {
                        totalPacked +=item.quantity //adds individual quantity to the total
                    }
                    Text("Total Items Packed:$totalPacked")


                    Button(
                        onClick = {
                            //Returns to Main Screen.
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
}



