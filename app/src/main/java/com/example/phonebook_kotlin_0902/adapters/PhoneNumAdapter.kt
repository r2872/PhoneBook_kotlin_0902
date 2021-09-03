package com.example.phonebook_kotlin_0902.adapters

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.phonebook_kotlin_0902.R
import com.example.phonebook_kotlin_0902.datas.PhoneNumData
import java.util.*

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
        val phoneNumTxt = row.findViewById<TextView>(R.id.phoneNum_Txt)
        val birthDayTxt = row.findViewById<TextView>(R.id.birthDay_Txt)
        val dialImg = row.findViewById<ImageView>(R.id.dial_Img)
        val birthDayImg = row.findViewById<ImageView>(R.id.birthDay_Img)

//        폰번 데이터 꺼내오자.
        val data = mList[position]

        nameTxt.text = data.name
        phoneNumTxt.text = data.phoneNum

//        폰번데이터의 생년월일 (Calendar) 을 -> 5월 8일 양식으로 가공 (String) 하는 방법.
        birthDayTxt.text = data.getFormattedBirthDay()

//        생일이 오늘로부터, 10일 이내라면 생일 이미지뷰 표시.
//        멀다고 하면 표시 안함.

//        1997.10.20 => 2021.10.20 변경하고, 오늘날짜랑 비교하자.

//        올해로 변환해서 계산하는데 사용할 임시 생일 변수. => 올해 날짜로 되어있다. (오늘)
        val tempBirthDay = Calendar.getInstance()
//        원본 생일 변수에 적힌 날짜를 그대로 가져옴. => 연도도 같이 바뀐.
        tempBirthDay.time = data.birthDay.time

//        오늘 날짜를 별도 변수에 저장.
        val today = Calendar.getInstance()
//        오늘날짜의 년도를 가져와서 -> 임시생일의 년도로 세팅. (올해의 생일로 완성)
        tempBirthDay.set(Calendar.YEAR, today.get(Calendar.YEAR))

//        생일 - 오늘 => 10일 이내? => 두 날짜를 모두 숫자로 변경.
        val diffInMillis = today.timeInMillis - tempBirthDay.timeInMillis

//        1/1000 초 까지 계산된 시간차이를 => 날짜로 변환.
        val diffInDays = diffInMillis / 1000 / 60 / 60 / 24

//       날짜 계산 결과 0 보다 작다 : 생일이 오늘보다 이전이다.

        if (diffInDays in 0..10) {
            birthDayImg.visibility = View.VISIBLE
        } else {
            birthDayImg.visibility = View.GONE
        }

//        이미지뷰에 클릭이벤트 부여.
        dialImg.setOnClickListener {

//            Dial 액션 Intent 활용
            val myUri = Uri.parse("tel:${data.phoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)

//            어댑터 안에서, 액티비티 기능인 StartActivity 함수를 실행하고 싶다.
//            어댑터를 만들때 -> 화면 정보를 받아옴. mContext 변수에 받아옴.

//            전달받은 mContext 의 기능 활용.
            mContext.startActivity(myIntent)
        }

        return row
    }
}