package com.example.happybirthday
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

class Test : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inputScreen") {
        composable("inputScreen") { InputScreen(navController) }
        composable("cardScreen/{name}/{age}") { backStackEntry ->
            val name = backStackEntry.arguments?.getString("name") ?: ""
            val age = backStackEntry.arguments?.getString("age") ?: ""
            CardScreen(name, age)
        }
    }
}

@Composable
fun InputScreen(navController: NavHostController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Nhập Thông Tin", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Tên của bạn") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = age,
            onValueChange = { age = it },
            label = { Text("Tuổi của bạn") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (name.isNotBlank() && age.isNotBlank()) {
                    navController.navigate("cardScreen/$name/$age")
                }
            }
        ) {
            Text("Tạo Thiệp Sinh Nhật")
        }
    }
}

@Composable
fun CardScreen(name: String, age: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🎉 Chúc mừng sinh nhật! 🎉", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
            contentDescription = "Birthday Image",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(16.dp))
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Chúc mừng sinh nhật $name 🎂", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Magenta)
        Text(text = "Bạn đã $age tuổi rồi! 🎁", fontSize = 18.sp)

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Thêm chức năng khác nếu muốn */ }) {
            Text("Cảm ơn! 😊")
        }
    }
}

