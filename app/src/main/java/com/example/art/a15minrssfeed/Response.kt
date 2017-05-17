package com.example.art.a15minrssfeed

/**
 * Created by art on 17/05/2017.
 */
import java.util.HashMap

class Response {

    var status: String? = null
    var userTier: String? = null
    var total: Long = 0
    var startIndex: Long = 0
    var pageSize: Long = 0
    var currentPage: Long = 0
    var pages: Long = 0
    var orderBy: String? = null
    var results: List<Result>? = null
    private val additionalProperties = HashMap<String, Any>()

    fun getAdditionalProperties(): Map<String, Any> {
        return this.additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        this.additionalProperties.put(name, value)
    }

}