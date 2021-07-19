package com.example.appclassunit7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
//手動import
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    //手動加入
    private val items=ArrayList<Item>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //從R讀取圖片資源 圖片應選2k~6k
        val imgArray=resources.obtainTypedArray(R.array.imgArray)
        //val nameArray=resources.obtainTypedArray(R.array.nameArray)
        val nameArray=resources.getStringArray(R.array.nameArray)
        //建立項目物件，放入圖片資源與名稱
        for(i in 0 until imgArray.length())
            items.add(Item(imgArray.getResourceId(i,0), nameArray[i]))
        //回收TypedArray
        imgArray.recycle()


        //連結Adapter，設定layout為adapter_horizontal
        spinner.adapter=MyAdapter(R.layout.adapter_horizontal,items)
        val view = spinner.adapter

        //設定setOnItenSelectedListerner當按下sprinner項目選項時回應名稱

        /*spinner.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tv_choice.text="你選的是:${nameArray[position]}"
            }
        }
        */

        /*spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                //parent: AdapterView<*>?,
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tv_choice.text="你選的是:${nameArray[position]}"
            }
        }
        */
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                //parent: AdapterView<*>?,
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                tv_choice.text=nameArray[position]
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {/*TODO("Not yet implemented")*/}
        }


        //設定橫向顯示的項目筆數
        gridview.numColumns=3

        //連結Adapter，設定layout為adapter_vertical
        gridview.adapter=MyAdapter(R.layout.adapter_vertical,items)

        //設定setOnItenclickListener當按下gridView項目選項時回應名稱
        gridview.setOnItemClickListener{parent,v,position,id->
            tv_choice.text=nameArray[position]
        }

        //連結Adapter，設定layout為simple_list_item_1與字串陣列
        listView.adapter=ArrayAdapter(this,android.R.layout.simple_list_item_1,
            arrayListOf("蘋果","酪梨","香蕉","櫻桃","椰子","葡萄","檸檬","橘子","桃子"))
            //arrayListOf("項目1","項目2","項目3","項目4","項目5","項目6","項目7","項目8","項目9"))

        //設定setIntenclickListener當按下listview項目選項時回應名稱
        listView.setOnItemClickListener{
            _,_,position,_->
            tv_choice.text=nameArray[position]
        }

        gridview.setOnItemClickListener{ parent , v , position,id->
            tv_choice.text=nameArray[position]
        }
    }
}
//自定義類別
data class Item(
    val photo:Int,   //圖片Resource
    val name: String //名稱
)