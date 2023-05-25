package com.example.jacket_tracker.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.jacket_tracker.R
import com.example.jacket_tracker.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val intent = Intent(this, HomeActivity::class.java).apply{  }
        //startActivity(intent)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java) //Setting the ViewModel

        val singUpText = findViewById<TextView>(R.id.SingUp_tv)
        val underline = SpannableString(singUpText.text)
        underline.setSpan(UnderlineSpan(), 0, underline.length, 0)
        singUpText.text = underline

        singUpText.setOnClickListener{
            viewModel.onSingUpClicked() //Calling the viewModel function
        }

        //Observe the MainViewModel changes
        viewModel.navigateToRegister.observe(this) { navigate ->
            if (navigate) {
                intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }
        }
    }
}