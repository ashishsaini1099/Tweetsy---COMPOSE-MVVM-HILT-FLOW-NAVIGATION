package com.example.demo.tweetsycompose.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.demo.tweetsycompose.models.TweetsItem
import com.example.demo.tweetsycompose.viewmodels.DetailsViewModel


@Composable
fun DetailScreen() {

    // Todo create viewModel instance via hilt nav host
    val detailsViewModel: DetailsViewModel = hiltViewModel()
//    val detailsViewModel:DetailsViewModel = viewModel()
    val tweets: State<List<TweetsItem>> = detailsViewModel.tweets.collectAsState()

    if (tweets.value.isEmpty()){

//        Box(modifier = Modifier.fillMaxSize(1f),
//            contentAlignment = Alignment.Center){
//            Text(
//                text = "Loading...",
//                style = MaterialTheme.typography.headlineLarge
//            )
//        }

        ProgressLoader()

    }else{

        LazyColumn(content = {
            items(tweets.value){
                TweetListItem(tweet = it.text!!)
            }
        })

    }

}

@Composable
fun TweetListItem(tweet:String) {

    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        border = BorderStroke(1.dp, Color(0xFFCCCCCC)),
        content = {
            Text(text = tweet,
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    )


}