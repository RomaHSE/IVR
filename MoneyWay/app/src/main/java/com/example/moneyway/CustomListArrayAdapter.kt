package com.example.moneyway

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.moneyway.localDB.SpendingsDataDB

class CustomListArrayAdapter(context: Context, spendings: ArrayList<SpendingsDataDB>?)
    : ArrayAdapter<SpendingsDataDB>(context, R.layout.list_item, spendings!!) {

    //создание кастомного адаптера для связи xml и выпадающего списка
    override fun getView(position : Int, view : View?, container : ViewGroup) : View {

        var convertView = view
        val listData = getItem(position)

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, container, false)
        }

        val listType = convertView!!.findViewById<TextView>(R.id.listType)
        val listAmount = convertView.findViewById<TextView>(R.id.spendingAmount)
        val spendingDescription = convertView.findViewById<TextView>(R.id.spendingDescription)
        val listDate = convertView.findViewById<TextView>(R.id.listDate)


        listType.text = listData!!.s_type
        listAmount.text = listData.s_amount.toString()
        spendingDescription.text = listData.s_description
        listDate.text = listData.s_date.toString()

        return convertView
    }
}