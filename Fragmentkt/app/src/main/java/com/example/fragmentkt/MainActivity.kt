package com.example.fragmentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //초기 프레그먼트 화면
        setFrag(0)

        //버튼 클릭했을때 프래그먼트 교체
        val btn_fragment1 = findViewById<Button>(R.id.btn_fragment1)
        val btn_fragment2 = findViewById<Button>(R.id.btn_fragment2)
        val btn_fragment3 = findViewById<Button>(R.id.btn_fragment3)
        btn_fragment1.setOnClickListener{
            setFrag(0)
        }
        btn_fragment2.setOnClickListener{
            setFrag(1)
        }
        btn_fragment3.setOnClickListener{
            setFrag(2)
        }
    }


    //fragment 교체해줌
    private fun setFrag(FragNum : Int) {
        val ft = supportFragmentManager.beginTransaction() //프레그먼트 교체하기위해 관리하는 메니저 사용.화면 교체
        when(FragNum){
            0 -> {
                ft.replace(R.id.main_frame, fragment1()).commit() //메인에서 프래그먼트 조각들 교체되는것(main_frame 만큼만 교체)
            }
            1 -> {
                ft.replace(R.id.main_frame, fragment2()).commit() //메인에서 프래그먼트 조각들 교체되는것(main_frame 만큼만 교체)
            }
            2 -> {
                ft.replace(R.id.main_frame, fragment3()).commit() //메인에서 프래그먼트 조각들 교체되는것(main_frame 만큼만 교체)
            }
        }
    }
}