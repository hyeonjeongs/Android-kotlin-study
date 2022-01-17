package com.example.webviewkt

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import com.example.webviewkt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var mBinding : ActivityMainBinding? =null
    private val binding get() = mBinding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.webView.settings.javaScriptEnabled = true //자바 스크립트 허용(웹 뷰 안에서 자바스크립트 페이지 있으면 허용)
        /*웹뷰에서 새창이 뜨지 않도록 방지하는 구문(이 두줄 안쓰면 이 웹뷰에서 화면 띄우는 것이 아니라 새로운 창을 띄워버림*/
        binding.webView.webViewClient = WebViewClient()
        binding.webView.webChromeClient = WebChromeClient()
        /*웹뷰에서 새창이 뜨지 않도록 방지하는 구문*/
        binding.webView.loadUrl("https://www.naver.com") //링크 주소 load함
     }

    override fun onBackPressed() {
        if(binding.webView.canGoBack()){
            //웹사이트에서 뒤로 갈 페이지가존재 한다면
            binding.webView.goBack() //웹사이트 뒤로 가기
        }
        else{
            super.onBackPressed() //본래의 백버튼 수행(안드로이드)
        }

    }
}