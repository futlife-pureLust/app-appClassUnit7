package com.example.appclassunit7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//手動import
import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.adapter_horizontal.view.*
/*
class MyAdapter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adapter_horizontal)
    }
}
*/
class MyAdapter constructor(private val layout:Int,private val data:ArrayList<Item>) :BaseAdapter(){
    //回傳項目筆數
    override fun getCount()=data.size
    //回傳某筆項目
    override fun getItem(position:Int)=data[position]
    //override fun getItemId(position: Int): 0L
    override fun getItemId(position: Int)= 0L

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        //建立畫面
        //val view = View.inflate(parent.context,layout,null)
        val view = View.inflate(parent?.context,layout,null)
        //根據position顯示圖片與名稱
        view.img_photo.setImageResource(data[position].photo)
        view.tv_name.text=data[position].name

        return view
    }
}