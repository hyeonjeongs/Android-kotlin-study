package com.example.sharedkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import com.example.sharedkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {//해당 엑티비티가 처음 실행될 떄 한번 수행하는 곳 (초기화)
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        loadData() //edit text 저장되어 있던 값을 setText
    }

    private fun loadData() { //이 클래스에서만 접근할거면 private쓰고 다른곳에서 쓰고 싶으면 public도 가능하고 안써도됨
        //저장 후 name으로 데이터 끌고와서 확인
        val pref = getSharedPreferences("pref", 0)
        // 값을 저장안한경우 밑에서 공백으로 불러오도록 설정함
        binding.etHello.setText(pref.getString("name","")) //1번째 인자에서는 저장할 당시의 키 값을 적어둠, 2번째 키 값에 데이터가 존재하지 않을 경우 대체 값을 적어둠
    }

    private fun saveData() {
        val pref = getSharedPreferences("pref", 0) //안드로이드 폴더 내부에 pref라는 이름으로 저장할것, 0번은 저장옵션
        val edit = pref.edit() //수정모드
        edit.putString("name", binding.etHello.toString()) //1번째 인자에는 키값, 2번째 인자에는 실제 담아둘 값
        edit.apply() //값을 저장 완료
    }

    override fun onDestroy() { // 액티비티 생명주기에서 해당 엡티비티가 종료되는 시점이 다가올때 호출
        super.onDestroy()

        saveData() // edit text 값을 저장(앱 종료될때 데이터값 저장하고 종료)
    }


}