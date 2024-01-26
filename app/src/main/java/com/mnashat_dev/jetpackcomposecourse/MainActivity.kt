package com.mnashat_dev.jetpackcomposecourse

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldDemo() {

    val snackbarHostState = remember { SnackbarHostState() }
    var textFieldState by remember { mutableStateOf("")}
    val scope =  rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        snackbarHost ={
            SnackbarHost (hostState = snackbarHostState)
        }

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(value = textFieldState, onValueChange = {
                textFieldState = it
            }, label = {
                Text(text = "Set Your Name")
            })

            Button(onClick = {
                scope.launch { snackbarHostState.showSnackbar("Welcome $textFieldState") }
            }) {
                Text(text = textFieldState)
            }
        }
    }


}


@Composable
fun ButtonColorful(modifier: Modifier = Modifier, changeColor: (Color) -> Unit) {
    val color = remember {
        mutableStateOf(Color.Black)
    }
    Box(modifier = modifier
        .clickable {
            changeColor(
                Color(
                    red = Random.nextFloat(),
                    green = Random.nextFloat(),
                    blue = Random.nextFloat(),
                    1f
                )
            )
        }
        .fillMaxWidth()
        .padding(14.dp)
        .background(color.value),

        contentAlignment = Alignment.Center) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(Color.Green, fontSize = 60.sp)) {
                    append("J")
                }
                append("etpack ")
                withStyle(style = SpanStyle(Color.Green, fontSize = 60.sp)) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.Cyan,
            fontFamily = FontFamily.Monospace,
            fontSize = 33.sp,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun CustomText(color: Color) {
    val fontFamily = FontFamily(
        Font(R.font.cairo_light, weight = FontWeight.Light),
        Font(R.font.cairo_bold, weight = FontWeight.Bold),
        Font(R.font.cairo_extrabold, weight = FontWeight.ExtraBold),
        Font(R.font.cairo_extralight, weight = FontWeight.ExtraLight)
    )
    Box(
        modifier = Modifier
            .background(color = color)
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(Color.Green, fontSize = 60.sp)) {
                    append("J")
                }
                append("etpack ")
                withStyle(style = SpanStyle(Color.Green, fontSize = 60.sp)) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.Cyan,
            fontFamily = fontFamily,
            fontSize = 33.sp,
            textDecoration = TextDecoration.Underline
        )
    }
}

@Composable
fun ImageCard(
    painter: Painter, title: String, description: String, modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp), shape = RoundedCornerShape(30.dp)
    ) {
        Box(
            modifier = modifier
                .background(Color.Black)
                .height(200.dp)
        ) {
            Image(
                contentScale = ContentScale.Crop,
                painter = painter,
                contentDescription = description
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.Gray
                            ), startY = 132f
                        )
                    )
            ) {}
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
                Text(
                    text = title, style = TextStyle(
                        color = Color.White, fontSize = 44.sp
                    )
                )
            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
//    val color = remember {
//        mutableStateOf(Color.Cyan)
//    }
//    JetPackComposeCourseTheme {
//        Column {
//            ImageCard(
//                painter = painterResource(id = R.drawable.image),
//                title = "Androidr",
//                description = "decftg "
//            )
//            CustomText(color.value)
//            ButtonColorful() { newColor ->
//                color.value = newColor
//            }
//        }
//    }
//    ScaffoldDemo()


}