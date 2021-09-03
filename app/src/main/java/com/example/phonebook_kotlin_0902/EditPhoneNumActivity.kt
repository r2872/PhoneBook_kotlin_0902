package com.example.phonebook_kotlin_0902

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import com.example.phonebook_kotlin_0902.datas.PhoneNumData
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import java.text.SimpleDateFormat
import java.util.*

class EditPhoneNumActivity : BaseActivity() {

    //    선택된 날짜의 기본값 : 화면을 연 일시.
    private val mSelectedDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)

        setupEvents()
        setValues()
    }

    override fun setValues() {

        ok_Btn.setOnClickListener {

//            1. 입력한 값들을 변수에 저장
            val inputName = name_Edt.text.toString()
            val inputPhoneNum = phoneNum_Edt.text.toString()

//            생년월일 (Calendar) -> 1996-04-17 String => SimpleDateFormat
            val sdf = SimpleDateFormat("yyyy-MM-dd")
            val birthDayStr = sdf.format(mSelectedDate)

//            2. 폰번 데이터 객체로 만들자. (클래스 추가)
            val savePhoneNumData = PhoneNumData(inputName, inputPhoneNum)
//            폰번데이터의 생년월일 -> 선택한날짜에 적힌 년월일 그대로 대입.
//            하나의 Calendar 값 -> 다른 Calendar 에 옮겨적기
            savePhoneNumData.birthDay.time = mSelectedDate.time

//            3. 해당 폰번을 -> "이름,폰번,생년월일" 양식으로 가공 -> 파일에 저장.
        }

        selectBirth_Btn.setOnClickListener {

//            달력처럼, 날짜 선택 팝업 출현 (안배운 부분)
            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

//            날짜가 선택되면 실행해줄 코드. (년 / 월 / 일 세개의 Int 를 가지고 처리하자.
                    mSelectedDate.set(year, month, dayOfMonth)

//            날짜 선택이 (Calendar) 완료되면 -> textView 에 반영. (String 으로 반영)
//            Calendar -> String 가공 : SimpleDateFormat
//                    1996. 04. 17. 양식으로 가공
                    val sdf = SimpleDateFormat("yyyy. MM. dd.")

                    birthDay_Txt.text = sdf.format(mSelectedDate.time)

                }
            }

//            달력 띄울때 넣는 날짜? 기본 선택값을 넣자.
//            기본 : 오늘 날짜. => Calendar 를 하나 만들면 : 기본값이 오늘 날짜.
//            Calendar 만든다 : 멤버변수로 만들어서 -> 선택된 값을 저장하는 용도로도.
            val datePickerDialog = DatePickerDialog(
                mContext,
                dateSetListener,
                mSelectedDate.get(Calendar.YEAR),
                mSelectedDate.get(Calendar.MONTH),
                mSelectedDate.get(Calendar.DAY_OF_MONTH)
            )

            datePickerDialog.show()


        }
    }

    override fun setupEvents() {


    }
}