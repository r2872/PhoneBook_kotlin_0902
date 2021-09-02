package com.example.phonebook_kotlin_0902

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import java.time.Year
import java.util.*

class EditPhoneNumActivity : BaseActivity() {

    //    선택된 날짜의 기본값 : 화면을 연 일시.
    val mSelectedDate = Calendar.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_phone_num)

        setupEvents()
        setValues()
    }

    override fun setValues() {

        selectBirth_Btn.setOnClickListener {

//            달력처럼, 날짜 선택 팝업 출현 (안배운 부분)
            val dateSetListener = object : DatePickerDialog.OnDateSetListener {
                override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {

//            날짜가 선택되면 실행해줄 코드. (년 / 월 / 일 세개의 Int 를 가지고 처리하자.
//            날짜 선택이 (Calendar) 완료되면 -> textView 에 반영. (String 으로 반영)
//            Calendar -> String 가공 : SimpleDateFormat
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