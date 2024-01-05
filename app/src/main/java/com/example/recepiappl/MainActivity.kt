package com.example.recepiappl
//we can only import those files which are added in dependencies in build.gradle.kts
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.recepiappl.ui.theme.RecepiApplTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecepiApplTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   RecepiScreen()
                   /* // <uses-permission android:name="android.permission.INTERNET"/> without
                // this permission we cannot connect to internet
                    //for any kind of usage in the device we have to give permission in the manifest file for
                    //example for camera, for location, for internet, for storage etc, for internet it doesnt ask the user
                    // but for other it asks the user*/
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RecepiApplTheme {
        Greeting("Android")
    }
}