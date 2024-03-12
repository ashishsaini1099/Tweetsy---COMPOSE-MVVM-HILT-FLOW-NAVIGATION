package com.example.demo.tweetsycompose.repository

import com.example.demo.tweetsycompose.api.TweetsyApi
import com.example.demo.tweetsycompose.models.TweetsItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val  tweetsyApi: TweetsyApi) {

    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories : StateFlow<List<String>> get() =  _categories

    private val _tweets = MutableStateFlow<List<TweetsItem>>(emptyList())
    val tweets : StateFlow<List<TweetsItem>> get() =  _tweets

    suspend fun getCategory(){
        val  response =  tweetsyApi.getCategories()
        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)
        }
    }

    suspend fun getTweets(category: String){
        val  response =  tweetsyApi.getTweets("tweets[?(@.category==\"${category}\")]")
        if (response.isSuccessful && response.body() != null){
            _tweets.emit(response.body()!!)
        }
    }

}
