package com.example.jacket_tracker.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.style.UnderlineSpan
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.jacket_tracker.R
import com.example.jacket_tracker.ui.viewmodel.MainViewModel
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val intent = Intent(this, HomeActivity::class.java).apply{  }
        //startActivity(intent)

        val logIn = findViewById<Button>(R.id.loginBtn)
        val singUpText = findViewById<TextView>(R.id.SingUp_tv)
        val underline = SpannableString(singUpText.text)
        underline.setSpan(UnderlineSpan(), 0, underline.length, 0)
        singUpText.text = underline

        logIn.setOnClickListener {
            val email = findViewById<EditText>(R.id.email_edt).text
            val password = findViewById<EditText>(R.id.password_edt).text

            logIn(email.toString(), password.toString())
        }

        singUpText.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun logIn(email: String, password: String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                    val intent = Intent(this, HomeActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "User doesn't exist", Toast.LENGTH_SHORT).show()
                }
            }
    }
}