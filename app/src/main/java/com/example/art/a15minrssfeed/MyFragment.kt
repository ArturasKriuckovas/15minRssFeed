package com.example.art.a15minrssfeed

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.list_fragmen.*
import kotlinx.android.synthetic.main.rss_single_item.*


open class MyFragment(itemsList: Array<String>) : Fragment() {

    val itemsList = itemsList
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val View = inflater!!.inflate(R.layout.list_fragmen, container, false)
        return View

    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list_fragment.adapter = ArrayAdapter<String>(context, android.R.layout.simple_list_item_1, itemsList)//one_item_feed_title || ,web_title
        (list_fragment.adapter as ArrayAdapter<String>).notifyDataSetChanged()
        list_fragment.setOnItemClickListener { parent, view, position, id ->
            (activity as MainActivity).listItemClicked(position)  }

    }


}
//class CustomArrayAdapter(context: Context?, objects: MutableList<String>?) : ArrayAdapter<String>(context, 0, objects) {
//    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
//       //val result: Result = getItem(position)
//        return super.getView(position, convertView, parent)
//    }
//}