package com.example.jacket_tracker.ui.view.Login_Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import com.example.jacket_tracker.R

class Login_view : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_view)

        val singUpText = findViewById<TextView>(R.id.SingUp_tv)
        val underline = SpannableString(singUpText.text)
        underline.setSpan(UnderlineSpan(), 0, underline.length, 0)
        singUpText.text = underline

        singUpText.setOnClickListener{
            intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}