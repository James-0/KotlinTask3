package com.example.kotlintask3

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class ImageAdapter internal constructor(private val mContext: Context, private var mIcons: ArrayList<Icon>): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val imageView: ImageView
        if (convertView == null) {
            imageView = ImageView(mContext)
            imageView.layoutParams = ViewGroup.LayoutParams(100, 100)
            imageView.setPadding(10, 10, 10, 10)
            imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        } else {
            imageView = (convertView as ImageView)
        }
        imageView.setImageResource(mIcons[position].logo)
        return imageView
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return mIcons.size
    }
}