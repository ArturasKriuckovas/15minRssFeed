package com.example.art.a15minrssfeed

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.single_list_item.*


open class SingleItemFragmen(item: String): Fragment(){

    val singleItem: String = item
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val View = inflater!!.inflate(R.layout.single_list_item, container, false)
        return View
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        one_list_item.setText(singleItem)
    }

}