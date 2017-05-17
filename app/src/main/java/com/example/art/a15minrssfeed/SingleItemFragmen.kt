package com.example.art.a15minrssfeed

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.rss_single_item.*


open class SingleItemFragmen(item: String): Fragment(){

    val singleItem: String = item
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val View = inflater!!.inflate(R.layout.rss_single_item, container, false) //single_list_item kolkas turetu but, dabartinis variantas netinka
        return View
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        one_item_feed_title.setText(singleItem) //one_list_item
    }

}