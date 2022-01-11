package com.example.intentkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivitySub2Binding

class SubActivity2 : AppCompatActivity() {
        //private var mBinding:ActivitySub2Binding? = null
        //private val binding get() = mBinding!!
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivitySub2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        
        if(intent.hasExtra("msg")){ //키값이 msg라는 것 갖고 있으면 실행해주기
            //서브 액티비티의 존재하는 텍스트뷰에 hello world가 넘겨져옴
            binding.tvGetMsg.text = intent.getStringExtra("msg") //문자열을 받아오기(text -> settext도 가능)
        }
    }
}