package com.example.bizcardapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bizcardapp.ui.theme.BizCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BizCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CreateBizCard()
                }
            }
        }
    }
}
@Composable
fun CreateBizCard(){
    val buttonClickedState = remember {
        mutableStateOf(false)
    }
    Surface(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight(),
        color = Color.White)
    {
     Card(modifier = Modifier
         .width(200.dp)
         .height(390.dp)
         .padding(10.dp),
          shape = RoundedCornerShape(corner = CornerSize(15.dp)),
          elevation = CardDefaults.cardElevation(4.dp),
         colors = CardDefaults.cardColors(Color.White))
     {

     Column(verticalArrangement = Arrangement.Top,
         horizontalAlignment = Alignment.CenterHorizontally,
         modifier = Modifier
             .fillMaxWidth()
             .fillMaxHeight())
     {
         CreateImageProfile()
         Divider()
         CreateInfo()

         Button(colors = ButtonDefaults.buttonColors(Color.Blue),
             shape = RoundedCornerShape(corner = CornerSize(2.dp)),
             onClick = {
                Log.d("Clicked", "CreateBizCard: Clicked!!")
                 buttonClickedState.value = ! buttonClickedState.value

             })
         {
             Text(text = "Portfolio",
                 style = TextStyle(fontSize = 19.sp),
                 color = Color.White
             )
         }
         if (buttonClickedState.value){
             Content()
         }
         else{
             Box{

             }

         }
     }
     }

    }
}

@Composable
fun Content(){
    Box(modifier = Modifier
        .fillMaxWidth()
        .fillMaxHeight()
        .padding(5.dp)){
        Surface(modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        shape = RoundedCornerShape(corner = CornerSize(6.dp)),
            border = BorderStroke(width = 1.dp, color = Color.LightGray)
        ) {
            Portfolio(data = listOf(
                "Project 1",
                "Project 2",
                "Project 3",
                "Project 4"))

        }
    }

}

@Composable
fun Portfolio(data: List<String>) {
    LazyColumn(modifier = Modifier.background(Color.White)){
        items(data){ item ->
            Card(modifier = Modifier
                .padding(9.dp)
                .fillMaxWidth(),
                //border =BorderStroke(width = 1.dp, color = Color.LightGray),
                colors = CardDefaults.cardColors(Color.White),
                shape = RectangleShape,
                elevation = CardDefaults.cardElevation(4.dp))
            {
                Row(modifier = Modifier
                    .padding(2.dp)
                    .background(color = Color.White)
                    .padding(4.dp)) {
                    CreateImageProfile(modifier = Modifier.size(100.dp))
                    Column(modifier = Modifier.padding(7.dp).align(alignment = Alignment.CenterVertically)) {
                        Text(text = item, fontWeight = FontWeight.Bold,
                            color = Color.Black)
                        Text(text = "What a great Project Jyoti!!",
                            style = TextStyle(fontSize = 12.sp),
                            color = Color.Black)
                    }


                }



            }
        }
    }

}

@Composable
private fun CreateInfo() {
    Column(modifier = Modifier.padding(5.dp)) {
        Text(text = "Miles P.",
            style = TextStyle(fontSize = 35.sp),
            color = Color.Blue)

        Text(text = "Android Compose Programmer", modifier = Modifier.padding(3.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black)

        Text(text = "@themilesCompose", modifier = Modifier.padding(3.dp),
            fontWeight = FontWeight.Bold,
            color = Color.Black)
    }
}

@Composable
private fun CreateImageProfile(modifier: Modifier = Modifier) {
    Surface(modifier = Modifier
        //.size(150.dp)
        .padding(5.dp),
        shape = CircleShape,
        border = BorderStroke(0.5.dp, Color.LightGray),
        tonalElevation = 6.dp,
        shadowElevation = 3.dp,
        color = Color.White
    ) {
        Image(painter = painterResource(id = R.drawable.profile_img),
            contentDescription = "Profile image",
            modifier = modifier.size(135.dp),
            contentScale = ContentScale.Crop)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    BizCardAppTheme {
//        CreateBizCard()
//    }
//}