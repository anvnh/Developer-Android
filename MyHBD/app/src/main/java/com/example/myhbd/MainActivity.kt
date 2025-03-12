package com.example.myhbd
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}
@Composable
fun MyApp(){
    val currentScreen = remember { mutableStateOf("input") }
    val name = remember { mutableStateOf("") }
    val age = remember { mutableStateOf("") }
    val from = remember { mutableStateOf("") }


    if (currentScreen.value =="input"){
        InputScreen(
            name = name.value,
            age = age.value,
            from = from.value,
            onNameChange= {name.value = it},
            onAgeChange ={age.value = it},
            onFromChange ={from.value = it},
            onCreateCard={currentScreen.value = "card"}
        )
    }
    else if (currentScreen.value=="card"){
        CardScreen(name.value, age.value, from.value,  onBack={currentScreen.value = "input"})

    }

}
@Composable
fun InputScreen(name: String, age: String, from:String, onNameChange: (String) -> Unit,
                onAgeChange: (String) -> Unit,
                onFromChange: (String) -> Unit,
                onCreateCard:() -> Unit
                ){
    Column(
        modifier =Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement= Arrangement.Center,

       ){
        Spacer(modifier = Modifier.height(20.dp))
        Text("Create", modifier = Modifier.padding(top=100.dp, bottom = 10.dp),
            fontSize = 38.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)

        Text("Birthday Card", modifier = Modifier.padding(top=10.dp, bottom = 100.dp),
            fontSize = 38.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)

        Column(
            modifier =Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,


        ) {

            Text("Input Information")
            Spacer(modifier = Modifier.height(16.dp))
            TextField(
                value = name,
                onValueChange = onNameChange,
                label = {Text("Input Name")}

            )
            TextField(
                value = age,
                onValueChange = onAgeChange,
                label = { Text("Input Age") }
            )
            TextField(
                value = from,
                onValueChange = onFromChange,
                label = { Text("From") }
            )
            Button(onClick = onCreateCard) {
                Text("Create Card")
            }
        }

    }


}
@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.grapic)
    Image(
        painter = image,
        contentDescription = null,
        contentScale = ContentScale.Crop, //full screen
        alpha = 0.5F
    )
}
@Composable
fun CardScreen(name: String, age: String,from: String, onBack: () -> Unit) {
    GreetingImage( message = "Happy Birthday Sam!",
        from = "From Emma"

    )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Text("Hi $name", fontSize = 38.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)

            Text("Today is your day", fontSize = 38.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)
            Text("Happy Birthday to you", fontSize = 38.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)
            Text("From $from",fontSize = 38.sp, fontWeight = FontWeight.Medium, textAlign = TextAlign.Center)

            Button(onClick = onBack) {
                Text("Back")

            }


        }
}





//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            MyApp()
//        }
//    }
//}

//@Composable
//fun MyApp() {
//    val navController = rememberNavController()
//
//    NavHost(navController = navController, startDestination = "inputScreen") {
//        composable("inputScreen") { InputScreen(navController) }
//        composable("cardScreen/{name}/{age}") { backStackEntry ->
//            val name = backStackEntry.arguments?.getString("name") ?: ""
//            val age = backStackEntry.arguments?.getString("age") ?: ""
//            CardScreen(name, age)
//        }
//    }
//}
//
//@Composable
//fun InputScreen(navController: NavHostController) {
//    var name by remember { mutableStateOf("") }
//    var age by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("Nhập Thông Tin", fontSize = 24.sp, fontWeight = FontWeight.Bold)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        TextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Tên của bạn") }
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        TextField(
//            value = age,
//            onValueChange = { age = it },
//            label = { Text("Tuổi của bạn") }
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(
//            onClick = {
//                if (name.isNotBlank() && age.isNotBlank()) {
//                    navController.navigate("cardScreen/$name/$age")
//                }
//            }
//        ) {
//            Text("Tạo Thiệp Sinh Nhật")
//        }
//    }
//}
//
//@Composable
//fun CardScreen(name: String, age: String) {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(16.dp),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        Text("🎉 Chúc mừng sinh nhật! 🎉", fontSize = 24.sp, fontWeight = FontWeight.Bold)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Image(
//            painter = painterResource(id = android.R.drawable.ic_menu_gallery),
//            contentDescription = "Birthday Image",
//            modifier = Modifier
//                .size(200.dp)
//                .clip(RoundedCornerShape(16.dp))
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Text(text = "Chúc mừng sinh nhật $name 🎂", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.Magenta)
//        Text(text = "Bạn đã $age tuổi rồi! 🎁", fontSize = 18.sp)
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { /* Thêm chức năng khác nếu muốn */ }) {
//            Text("Cảm ơn! 😊")
//        }
//    }
//}
