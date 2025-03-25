package com.camihruiz24.busschedulebycamihruiz24

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.camihruiz24.busschedulebycamihruiz24.ui.BusScheduleApp
import com.camihruiz24.busschedulebycamihruiz24.ui.theme.BusScheduleTheme
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusScheduleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusScheduleApp()
                }
            }
        }
    }
}

@Composable
fun BusScheduleApp2(modifier: Modifier = Modifier) {
    DestinationsNavHost(navGraph = NavGraphs.root)
}

@RootNavGraph(start = true)
@Destination
@Composable
fun HomeScreen() {
    Box(modifier = Modifier, Alignment.Center) {
        Text(text = "Hello world!")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusScheduleTheme {
        BusScheduleApp2()
    }
}
