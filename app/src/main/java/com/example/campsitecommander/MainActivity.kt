package com.example.campsitecommander

import android.R
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.campsitecommander.ui.theme.CampsiteCommanderTheme
import com.example.campsitecommander.ui.theme.Purple80

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CampsiteCommanderTheme {
                // ST10530609 Tshegofatso Natasha Mahapa
                val  DarkColorScheme = darkColorScheme(
                    primary = Purple80 ,
                    background = Color(0xFF12112),
                    surface = Color(0xFF1E1E1E),
                    onPrimary = Color.Black,
                    onBackground = Color.White
                )
                Column(
                    modifier =
                        Modifier.fillMaxSize(),
                    verticalArrangement =
                        Arrangement.Center,
                    horizontalAlignment =
                        Alignment.CenterHorizontally
                ) { //Adds Anything necessary for the camp.
                        Text("Add Gears")
                        var itemName by remember { mutableStateOf("") }//Enter the item name.
                        OutlinedTextField(
                            value = itemName,
                            onValueChange = { itemName = it },
                            label = { Text("Item Name") },
                            placeholder = { Text("Item Name") }
                        )
                        val nameOfItem = arrayOf("Tent","Bread","pocket knife","Bandage")//stores each item
                        var category by remember { mutableStateOf("") }//Specify which category it falls under.
                        OutlinedTextField(
                            value = category,
                            onValueChange = { category = it },
                            label = { Text("Category") },
                            placeholder = { Text("Category") }
                        )
                        val categoryOfItem = arrayOf("Shelter","Food","Safety","First Aid")//stores each item in its category.
                        var quantity by remember { mutableStateOf("") }//Indicate how many items you have per category.
                        OutlinedTextField(
                            value = quantity,
                            onValueChange = { quantity = it },
                            label = { Text("Quantity") },
                            placeholder = { Text("Quantity") }
                        )
                        val numberOfItems = arrayOf(2,8,3,10)//Specifies the number of items per category.
                        var comments by remember { mutableStateOf("") }//add anything you think could be important.
                        OutlinedTextField(
                            value = comments,
                            onValueChange = { comments = it },
                            label = { Text("Comments") },
                            placeholder = { Text("Comments") }
                        )
                        val feedback = arrayOf("3-person each waterproof","Should last for 4 days","Emergencies ONLY!!","Long strand")//Gives instructions for each item.
                        Button(//Takes you to the next screen which is the Detailed View screen.
                            onClick = {
                                val intent = Intent(this@MainActivity, DetailedView::class.java)
                                startActivity(intent)
                            }
                        ) {
                            Text("Detailed View")
                        }
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



                }
            }
        }
    }
}


