package com.example.demo.tweetsycompose.models

import com.google.gson.annotations.SerializedName

data class TweetsItem(

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("category")
	val category: String? = null
)