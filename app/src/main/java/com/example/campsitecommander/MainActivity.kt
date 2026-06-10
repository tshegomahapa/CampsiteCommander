package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsiteCommanderTheme {
                // ST10530609 Tshegofatso Natasha Mahapa
                    Column() { //Adds Items needed,puts each into their category,shows the quantity and adds necessary comments.
                        Text("Add Gears")
                        var itemName by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = itemName,
                            onValueChange = { itemName = it },
                            label = { Text("Item Name") },
                            placeholder = { Text("Item Name") }
                        )
                        var category by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = category,
                            onValueChange = { category = it },
                            label = { Text("Category") },
                            placeholder = { Text("Category") }
                        )
                        var quantity by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = quantity,
                            onValueChange = { quantity = it },
                            label = { Text("Quantity") },
                            placeholder = { Text("Quantity") }
                        )
                        var comments by remember { mutableStateOf("") }
                        OutlinedTextField(
                            value = comments,
                            onValueChange = { comments = it },
                            label = { Text("Comments") },
                            placeholder = { Text("Comments") }
                        )
                    }
            }
        }
    }
}


