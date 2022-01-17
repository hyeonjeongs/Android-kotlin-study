package com.example.listviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding? = null
    private val binding get() = mBinding!!

    var userList = arrayListOf<User>( //모델에 리스트에 넣고 이 리스트를 어뎁터와 연결시킴
            User(R.drawable.fo, "현정", "24", "반가워요"),
            User(R.drawable.dd, "원우", "24", "멋져요"),
            User(R.drawable.hyeon, "지현", "24", "시험 별거아니에요"),
            User(R.drawable.yeon, "지연", "24", "난 못하는게 없어요"),
            User(R.drawable.android, "윤진", "23", "프론트 화이팅"),
            User(R.drawable.android, "감자", "24", "감자최공")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val items = arrayOf("사과","딸기","체리","바나나")
        //context란 한 엑티비티의 모든 정보를 담고있다.
        //binding.listviews.adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, items)

        val Adapter = UserAdapter(this, userList)
        binding.listviews.adapter = Adapter

        binding.listviews.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position) as User
            Toast.makeText(this,selectedItem.name, Toast.LENGTH_SHORT).show() //현재 엑티비티로부터 띄울거(this)
        }

    }
}