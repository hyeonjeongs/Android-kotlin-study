package com.example.intentkt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intentkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    //전역 변수로 바인딩 객체 선언
    private var mBinding:ActivityMainBinding? = null
    //매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnA.setOnClickListener{
            val intent = Intent(this,SubActivity2::class.java ) //Intent라는 객체를 사용 (다음 화면으로 이동하기 위한것)
            intent.putExtra("msg",binding.tvSendMsg.text.toString()) //helloowrld라는 택스트 값 담은 뒤 msg라는 키로 잡는다.(msg 키 값을 이용)
            startActivity(intent) //intent에 저장되어 잇는 엑티비티 쪽으로 이동
            finish() //자기 자신 엑티비티를 파괴한다.
        }
    }
}