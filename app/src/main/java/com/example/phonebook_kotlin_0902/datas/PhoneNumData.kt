package com.example.phonebook_kotlin_0902.datas

import java.text.SimpleDateFormat
import java.util.*

class PhoneNumData {

    var name = "" // name 에 String 이 들어갈거라고 암시
    var phoneNum = ""
    val birthDay = Calendar.getInstance() // 기본값: 오늘 날짜
//    set 기능으로 내부에 적힌 값을 바꿈. -> 새 객체를 집어넣는 방식이아님.
//    변수의 입장에서는 연결된 객체가 바뀔일이 없다. -> val 로 만들어주자.

    //    가진데이터를 => 파일에 저장할 수 있는 양식 "이름,폰번,1996-04-17" 양식으로 가공.
//    날짜 변환 양식은, 외부 노출 X 나만 혼자 사용. (private)
    private val fileDateFormat = SimpleDateFormat("yyyy-MM-dd")
    fun getFileFormatData(): String {

//    birthDay (Calendar) -> String 가공
//        멤버변수로 만들어둔 SimpleDateFormat 하나를 활용하자.

//    코틀린에서 String 가공.
        return "${name},${phoneNum},${fileDateFormat.format(this.birthDay.time)}"
    }
}