package com.example.art.a15minrssfeed

/**
 * Created by art on 17/05/2017.
 */
import java.util.HashMap

class Result {

    var id: String? = null
    var type: String? = null
    var sectionId: String? = null
    var sectionName: String? = null
    var webPublicationDate: String? = null
    var webTitle: String? = null
    var webUrl: String? = null
    var apiUrl: String? = null
    var isIsHosted: Boolean = false
    private val additionalProperties = HashMap<String, Any>()

    fun getAdditionalProperties(): Map<String, Any> {
        return this.additionalProperties
    }

    fun setAdditionalProperty(name: String, value: Any) {
        this.additionalProperties.put(name, value)
    }

}