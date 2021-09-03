package com.example.phonebook_kotlin_0902.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.phonebook_kotlin_0902.R
import com.example.phonebook_kotlin_0902.datas.PhoneNumData

class PhoneNumAdapter(
    private val mContext: Context,
    resId: Int,
    private val mList: List<PhoneNumData>
) : ArrayAdapter<PhoneNumData>(mContext, resId, mList) {

    private val mInflater = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

//        getView : xml -> position 에 맞는 데이터를 입혀서 -> ListView 의 각 position 에 뿌려주기.
        var row = convertView

        if (row == null) {
            row = mInflater.inflate(R.layout.phone_num_list_item, null)
        }

        row!! // 이미 row 는 무조건 null 이 아니라고 우김.
//        이 밑으로는 row 는 null 이 아닌걸로 됨

        val nameTxt = row.findViewById<TextView>(R.id.name_Txt)
        val birthDayTxt = row.findViewById<TextView>(R.id.birthDay_Txt)

        return row
    }
}