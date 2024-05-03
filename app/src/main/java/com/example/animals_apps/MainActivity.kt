import android.os.Bundle
import android.provider.CalendarContract.Colors
import android.webkit.WebSettings.TextSize
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animals_apps.R
import com.example.animals_apps.data.Header
import com.example.animals_apps.ui.theme.AnimalsAppsTheme
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontFamily
import com.example.animals_apps.ui.theme.mainColor
import com.example.animals_apps.ui.theme.buttonColor
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimalsAppsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainPage()
                }
            }
        }
    }
}

@Composable
fun MainPage() {
    val headerData = Header(
        title = "PurrfectFeed",
        titleColor = mainColor,
        titleFont = FontFamily.Serif,
        logoResId = R.drawable.logo
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderWithLogo(header = headerData)

        Spacer(modifier = Modifier.height(30.dp))

        Image(
            painter = painterResource(id = R.drawable.image_cat),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .size(500.dp)
        )
        BottomBar(onButtonClick = {
            //logic tombol
        })
    }

}

@Composable
fun HeaderWithLogo(header: Header) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(top = 40.dp)
    ) {
        // Gambar logo
        Image(
            painter = painterResource(id = header.logoResId),
            contentDescription = null,
            modifier = Modifier.size(25.dp)
        )

        Spacer(modifier = Modifier.width(2.dp))

        Text(
            text = header.title,
            color = header.titleColor,
            fontFamily = header.titleFont,
            modifier = Modifier.padding(bottom = 2.dp)
        )
    }
}

@Composable
fun BottomBar(onButtonClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
                .background(
                    color = mainColor,
                    shape = RoundedCornerShape(
                        topStart = 100.dp,
                        topEnd = 100.dp,
                        bottomStart = 0.dp,
                        bottomEnd = 0.dp
                    )
                )
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 40.dp)
            ) {
                Text(
                    text = "Meow!",
                    color = Color.Black,
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Feed me please",
                    color = Color.Black,
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Button(
                    onClick = onButtonClick,
                    colors = ButtonDefaults.buttonColors(buttonColor),
                    shape = RoundedCornerShape(10.dp), // Mengatur sudut yang dibulatkan
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                        .size(width = 150.dp, height = 50.dp)
                        .clip(RoundedCornerShape(10.dp)) // Mengatur sudut yang dibulatkan hanya pada tombol
                ) {
                    Text(text = "Feed Now!", color = Color.White, fontSize = 20.sp)
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun MainPagePreview() {
    AnimalsAppsTheme {
        MainPage()
    }
}
