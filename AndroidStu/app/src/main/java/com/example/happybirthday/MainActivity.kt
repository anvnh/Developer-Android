package com.example.happybirthday

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.happybirthday.ui.theme.HappyBirthdayTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HappyBirthdayTheme {
                Surface (
                    modifier = Modifier.fillMaxSize()
                    )
                {
                    GreetingText(
                        name= "Em",
                        message = "Happy Birthday",
                        from = "From Emma",
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(name: String,message: String, from:String, modifier: Modifier = Modifier) {
    Column (
        modifier = modifier
    ){
        Text(text = "Hello $name!",)
        Text(
            text= message,

        )
        Text(
            text= from,
            modifier = Modifier.padding(16.dp)
                .align(alignment = Alignment.End)

        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HappyBirthdayTheme {
        GreetingText(name = "Em", message = "Happy Birthday Sam!", from = "From Emma")
    }
}