package com.example.navigationkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.example.navigationkt.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private var mBinding : ActivityMainBinding? =null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNavi.setOnClickListener {
            binding.layoutDrawer.openDrawer((GravityCompat.START)) //START : left, END : right 방향으로밀어라
        }

        //네비게이션 메뉴 아이템에 클릭 속성 부여
        binding.naviView.setNavigationItemSelectedListener(this) //이코드로 아래 것들의 기능 사용 가능함
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean { //네비게이션 메뉴 아이템 클릭시 수행
        //메뉴 버튼 클릭시 아이템 버튼 형성됨
        when (item.itemId) //아이템 값생겼을 때, 이 아이템의 아이디 가져옴
        {
            R.id.access -> Toast.makeText(applicationContext, "접근성",Toast.LENGTH_SHORT).show()
            R.id.email -> Toast.makeText(applicationContext, "이메일",Toast.LENGTH_SHORT).show()
            R.id.message -> Toast.makeText(applicationContext, "메시지",Toast.LENGTH_SHORT).show()

        }
        binding.layoutDrawer.closeDrawers() //네비게인션 뷰 닫기
        return false
    }


    override fun onBackPressed() { //백버튼 눌렀을때 아에 꺼지는거 방지하기 위해 사용
        if(binding.layoutDrawer.isDrawerOpen(GravityCompat.START)){ //네비게이션 뷰 켜져있으면
            binding.layoutDrawer.closeDrawers() //이 바를 먼저 끄기
        }
        else { //만약 뷰가 꺼져있는거면 아에 앱끄기
            super.onBackPressed() //일반 백버튼 기능 실행(finish)
        }
    }
}