package com.example.phonebook_kotlin_0902

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.example.phonebook_kotlin_0902.adapters.PhoneNumAdapter
import com.example.phonebook_kotlin_0902.datas.PhoneNumData
import kotlinx.android.synthetic.main.activity_edit_phone_num.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class MainActivity : BaseActivity() {

    private val mPhoneNumList = ArrayList<PhoneNumData>()

    //    1. 멤버변수로 빼는게 편하다.
//    2. 초기화 할때 화면정보 (Context) 가 필요한가? => 필요하다: onCreate 내부 or 이후 에서 대입.
//    Hint: JAVA 에서 배우는 클래스들 -> 대부분 화면 필요 X, val 로 만들어도 된다.
    lateinit var mAdapter: PhoneNumAdapter

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

//    임시방편: 직접 리스트에 데이터 객체 추가.
        mPhoneNumList.add(PhoneNumData("테스트1", "010-1111-2222"))
        mPhoneNumList.add(PhoneNumData("테스트2", "010-2222-2222"))
        mPhoneNumList.add(PhoneNumData("테스트3", "010-3333-2222"))
        mPhoneNumList.add(PhoneNumData("테스트4", "010-4444-2222"))

//        수정방안 -> 파일을 불러와서, 그 내용을 읽고 -> PhoneNumDate() 로 변환 -> 목록에 추가.

//        어댑터 초기화.
        mAdapter = PhoneNumAdapter(mContext, R.layout.phone_num_list_item, mPhoneNumList)

//        리스트뷰의 어댑터로 연결
        phoneNumListView.adapter = mAdapter

    }

    override fun setupEvents() {

        addPhoneNum_Btn.setOnClickListener {

//            자바의 인터페이스를 개량한 버전의 코드.
//            EditPhoneNumActivity 로 이동 : intent
            startActivity(Intent(mContext, EditPhoneNumActivity::class.java))
        }
    }
}