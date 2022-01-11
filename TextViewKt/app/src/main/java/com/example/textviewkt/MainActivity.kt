package com.example.textviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.textviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    //매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) { // 앱이 최초 실행되었을 때 수행
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main) // xml  화면 뷰를 연결한다.

        //자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메소드를 활용해서
        //액티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        //getRoot 메서드로 레이아웃 내부의 최상위 위치 뷰의
        //인스턴스 활용해서 생성된 뷰를 액티비티에 표시 합니다.
        setContentView(binding.root)

        //이제부터 binding 바인딩 변수를 활용하여 마음 껏 xml 파일 내부 뷰 id 접근이 가능해진다.
        //뷰 id도 파스칼케이스 + 카멜케이스의 네이밍 규칙 적용으로 인해서 tv_message -> tvMessage로 자동변환됨
        binding.tvMessage.setText("Hello world~")
    }

    //액티비티가 파괴될 때 ..
    override fun onDestroy() {
        //onDestroy에서 binding class 인스턴스 참조를 정리해줘야함
        mBinding = null
        super.onDestroy()
    }
}