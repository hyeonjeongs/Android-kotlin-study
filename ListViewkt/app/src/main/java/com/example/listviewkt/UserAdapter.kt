package com.example.listviewkt

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextClock
import android.widget.TextView
import com.example.listviewkt.databinding.ActivityMainBinding

class UserAdapter(val context: Context, val userList:ArrayList<User> ) : BaseAdapter() {

    override fun getCount(): Int {
        return userList.size
    }

    override fun getItem(position: Int): Any {
        return userList[position] //어떤 아이템 끌고올지, ArrayList에 있는 위치만큼 아이템 가져오기

    }


    override fun getItemId(position: Int): Long {
        return 0

    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View { //뷰 가져왔을때 어떻게 뿌려줄건지

        val view:View = LayoutInflater.from(context).inflate(R.layout.list_item_user,null) //리스트뷰에 한 열당 아이템은 이 형태를 따라줘라고 하는것

        val profile = view.findViewById<ImageView>(R.id.iv_file) //id로부터 view를 찾아라
        val name = view.findViewById<TextView>(R.id.tv_name)
        val age = view.findViewById<TextView>(R.id.tv_age)
        val greet = view.findViewById<TextView>(R.id.tv_greet)

        val user = userList[position] //하나씩 0~세는 인덱스임 (main에서 어뎁터 만들때 하나씩 넣어줄것)

        profile.setImageResource(user.profile) //어뎁터랑 연결시킴
        name.text = user.name
        age.text = user.age
        greet.text = user.greet

        return view
    }
}