package com.example.phonebook_kotlin_0902

import android.content.Intent
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

//    0. 전화번호 추가 기능 -> 별도 화면에서 저장시키자.

//    1. 화면에 들어오면 -> 파일에 저장된 "이름, 폰번, 1996-04-17" 문장을 불러내자.
//    안드로이드에서 파일 다루는법? + String 분리 / UserData 변환 등등.

//    2. 불러낸 데이터들을 -> 리스트뷰에 뿌려주자. (리스트뷰 사용법)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setValues()
        setupEvents()
    }

    override fun setValues() {


    }

    override fun setupEvents() {

        addPhoneNum_Btn.setOnClickListener {

//            자바의 인터페이스를 개량한 버전의 코드.
//            EditPhoneNumActivity 로 이동 : intent
            startActivity(Intent(mContext, EditPhoneNumActivity::class.java))
        }
    }
}