package com.example.instaprac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.instaprac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val friendlist = arrayListOf( //리스트형태의 객체들을 넣어줌
            Mymodel(R.drawable.cotato,20220202,"코테이토",R.drawable.ic_baseline_favorite_24),
            Mymodel(R.drawable.cotato,20220203,"사랑해요",R.drawable.ic_baseline_favorite_24),
            Mymodel(R.drawable.cotato,20221010,"♥",R.drawable.ic_baseline_favorite_border_24),
            //Mymodel(R.drawable.e,20221013,"모두",R.drawable.ic_baseline_favorite_24),
            Mymodel(R.drawable.cotato,20221015,"메리설날",R.drawable.ic_baseline_favorite_24),
            Mymodel(R.drawable.cotato,20221015,"다들",R.drawable.ic_baseline_favorite_border_24),
            //Mymodel(R.drawable.fdg,20220916,"대면참여하고",R.drawable.ic_baseline_favorite_24),
            //Mymodel(R.drawable.asa,20221010,"번개열어요",R.drawable.ic_baseline_favorite_border_24),
            //Mymodel(R.drawable.a,20221010,"회장님울어여",R.drawable.ic_baseline_favorite_border_24)
        )
        val rvprofile = findViewById<RecyclerView>(R.id.rv_profile)
        rvprofile.layoutManager = GridLayoutManager(this,2) //한 행에 두 열씩
        rvprofile.setHasFixedSize(true) //리사이클러뷰 성능 개선

        rvprofile.adapter = MyAdapter(friendlist) //위에서 선언한 리스트를 어뎁터에 변수인 profileList로 전달
    }
}
