package com.example.recyclerviewkt

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProfileAdapter(val profileList: ArrayList<Profiles>) : RecyclerView.Adapter<ProfileAdapter.CustomViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileAdapter.CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item,parent,false)
        return CustomViewHolder(view) //생성자에 view로 연결되고 이 클래스 실행됨
    }

    //onCreateViewHolder에서 만든 뷰를 가져가서 연결해주는것 (스크롤할때 지속적으로 호출되면서 데이터 매치시켜줌)
    override fun onBindViewHolder(holder: ProfileAdapter.CustomViewHolder, position: Int) {
        holder.gender.setImageResource(profileList.get(position).gender)
        holder.name.text = profileList.get(position).name
        holder.age.text = profileList.get(position).age.toString() //숫자인 age를 문자열형태로 변환하여 저장
        holder.job.text = profileList.get(position).job

    }

    //총 리스트들의 개수를 알려줌
    override fun getItemCount(): Int {
        return profileList.size
    }

    //view에 대한 것들을 잡아줌
    class CustomViewHolder(itemview:View) : RecyclerView.ViewHolder(itemview){ //클래스안에 클래스 형성
        val gender = itemview.findViewById<ImageView>(R.id.iv_profile) //성별
        val name = itemview.findViewById<TextView>(R.id.tv_name) //이름
        val age = itemview.findViewById<TextView>(R.id.tv_age) //나이
        val job = itemview.findViewById<TextView>(R.id.tv_job) //직업
    }
}