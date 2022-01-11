package com.example.edittextbutton

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.edittextbutton.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { //엑티비티 최초 실행 되면 이곳을 수행한다.
    //전역 변수로 바인딩 객체 선언
    private var mBinding: ActivityMainBinding? = null
    //매번 null 체크를 할 필요 없이 편의성을 위해 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //자동 생성된 뷰 바인딩 클래스에서의 inflate라는 메소드를 활욯해서 엑티비티에서 사용할 바인딩 클래스의 인스턴스 생성
        //xml파일을 연결시켜준다.
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        //최상위 위치 뷰의 인스턴스 활용하여 생성된 뷰를 액티비티에 표시
        //최상위 위치의 뷰인 레이아웃을 화면에 표시
        setContentView(binding.root)

        //binding 바인딩 변수를 활용해서 xml 파일 내의 뷰 id 접근이 가능해짐!
        binding.btnGetText.setOnClickListener{ //edittext에 입력되어있는 값을 가지고 와서 텍스트 뷰에 전달
            var resultText = binding.etId.text.toString() //etid에 입력되어 있는 값
            binding.tvResult.setText(resultText)  //입력된 값을 텍스트 뷰에 보여준다.
        }

    }
}