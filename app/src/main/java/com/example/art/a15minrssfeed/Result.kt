package com.example.art.a15minrssfeed

/**
 * Created by art on 17/05/2017.
 */
import java.util.HashMap

data class Result(
        val id: String,
        val type: String,
        val sectionId: String,
        val sectionName: String,
        val webPublicationDate: String,
        val webTitle: String,
        val webUrl: String,
        val apiUrl: String,
        val isIsHosted: Boolean
)