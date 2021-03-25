package com.example.viewpager2

import com.google.gson.annotations.SerializedName

data class ResponseSearchVideo(
    val meta: Meta,
    val documents: MutableList<Documents>

) {
    data class Meta(
        @SerializedName("total_count")
        val totalCount: Int,
        @SerializedName("pageable_count")
        val pageableCount: Int,
        @SerializedName("is_end")
        val isEnd: Boolean
    )

    data class Documents(
        val title: String,
        @SerializedName("play_time")
        val playTime: Int,
        val thumbnail: String,
        val url: String,
        val datetime: String,
        val author: String
    )
}