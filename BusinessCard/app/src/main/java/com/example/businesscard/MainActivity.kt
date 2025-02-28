package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Icon

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    Greeting(
                        fullName = "An Nhi",
                        title = "Student",
                        phoneNumber = "0901165598",
                        tag = "@anryenyn",
                        email = "soranryenyn.2208@gmail.com"
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    fullName: String,
    title: String,
    phoneNumber: String,
    tag: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ){
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
        ) {
            Text(
                text = fullName,
                fontSize = 43.sp,
                fontWeight = FontWeight.Bold,
                modifier = modifier
            )
            Text(
                text = title,
                fontSize = 28.sp,
                modifier = Modifier.padding(
                    vertical = 10.dp
                )
            )
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(
                top = 50.dp
            )
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Outlined.Call,
                    contentDescription = "Phone number",
                    modifier = Modifier
                        .padding(
                            end = 10.dp
                        )
                )
                Text(
                    text = phoneNumber,
                    fontSize = 25.sp,
                    modifier = modifier
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Outlined.Info,
                    contentDescription = "Tag",
                    modifier = Modifier
                        .padding(
                            end = 10.dp
                        )
                )
                Text(
                    text = tag,
                    fontSize = 25.sp,
                    modifier = modifier
                )
            }
            Row (
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(
                    imageVector = Icons.Outlined.Email,
                    contentDescription = "Email",
                    modifier = Modifier
                        .padding(
                            end = 10.dp
                        )
                )
                Text(
                    text = email,
                    fontSize = 25.sp,
                    modifier = modifier
                )
            }
        }
    }
}