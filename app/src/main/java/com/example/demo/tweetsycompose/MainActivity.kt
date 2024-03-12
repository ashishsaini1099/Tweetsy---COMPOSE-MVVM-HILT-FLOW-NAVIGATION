package com.example.demo.tweetsycompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.demo.tweetsycompose.api.TweetsyApi
import com.example.demo.tweetsycompose.screens.CategoryScreen
import com.example.demo.tweetsycompose.screens.DetailScreen
import com.example.demo.tweetsycompose.ui.theme.TweetsyComposeTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

// Todo Jetpack Compose - Retrofit with MVVM and HILT
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    @Inject
//    lateinit var tweetsyApi: TweetsyApi

    private val TAG: String = "CheezyCode"

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            GlobalScope.launch {
//                val response = tweetsyApi.getCategories()
//
//                Log.d(TAG, response.body()?.distinct().toString())
//            }

            TweetsyComposeTheme {

                Scaffold(
                    topBar = {

                        TopAppBar(title = { Text(text = "Tweetsy", color = Color.Blue) },
                            colors =  TopAppBarDefaults.topAppBarColors(MaterialTheme.colorScheme.primaryContainer)
                        )
                    }
                ){
                    Box(modifier = Modifier.padding(it)){
                        App()
                    }
                }

            }
        }
    }

    @Composable
    fun App() {

        val navController = rememberNavController()

        NavHost(navController = navController, startDestination = "category"){

            composable(route = "category"){
//                    RegistrationScreen {
//                        navController.navigate("detailScreen/${it}")
//                    }
                CategoryScreen {
                    navController.navigate("detail/${it}")
                }
            }

            composable(route = "detail/{category}", arguments = listOf(
                navArgument("category"){
                    type = NavType.StringType
                }
            )){

//                val category =  it.arguments!!.getString("email")
                DetailScreen()
            }
        }

    }

//    @Composable
//    fun RegistrationScreen(onClick : ( email : String) -> Unit) {
//        Text(text = "Registration Screen",
//            modifier = Modifier.clickable {
//               //  navController.navigate("main")
//                onClick("ashishsaini1099@gmail.com")
//            },
//            style = MaterialTheme.typography.bodyLarge)
//    }
//
//    @Composable
//    fun LoginScreen(onClick: () -> Unit) {
//        Text(text = "Login Screen",
//            modifier = Modifier.clickable {
//                //  navController.navigate("main")
//                onClick()
//            },
//            style = MaterialTheme.typography.bodyLarge)
//    }
//
//    @Composable
//    fun MainScreen(email: String) {
//        Text(text = "Main Screen :- $email",
////            modifier = Modifier.clickable {
////                //  navController.navigate("main")
////                onClick()
////            },
//            style = MaterialTheme.typography.bodyLarge)
//    }
}

