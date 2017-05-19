package com.example.art.a15minrssfeed

/**
 * Created by art on 17/05/2017.
 */
import com.google.gson.annotations.SerializedName
import java.util.HashMap

data class Response(
        val status: String,
        val userTier: String,
        val total: Long,
        val startIndex: Long,
        val pageSize: Long,
        val currentPage: Long,
        val pages: Long,
        val orderBy: String,
        val results: List<Result> = emptyList()
)