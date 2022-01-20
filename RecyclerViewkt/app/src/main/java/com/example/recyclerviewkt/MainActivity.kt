package com.example.recyclerviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val profileList = arrayListOf( //리스트형태의 객체들을 넣어줌
            Profiles(R.drawable.woman,"박현정",24,"소프트웨어학부 사이버보안"),
            Profiles(R.drawable.woman,"현정",22,"소프트웨어 사이버보안"),
            Profiles(R.drawable.woman,"박정",20,"사이버보안"),
            Profiles(R.drawable.woman,"정",21,"소프트웨어학부"),
            Profiles(R.drawable.woman,"박현",26,"보안"),
            Profiles(R.drawable.woman,"현",26,"사이버보안"),
            Profiles(R.drawable.woman,"정",34,"소프트웨어학부"),
            Profiles(R.drawable.woman,"박현정",27,"보안"),
            Profiles(R.drawable.woman,"박정",20,"사이버"),
            Profiles(R.drawable.woman,"현정",21,"소프트웨어학부 사이버보안")

        )
        val rvprofile = findViewById<RecyclerView>(R.id.rv_profile)
        rvprofile.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvprofile.setHasFixedSize(true) //리사이클러뷰 성능 개선

        rvprofile.adapter = ProfileAdapter(profileList) //위에서 선언한 리스트를 어뎁터에 변수인 profileList로 전달
    }
}