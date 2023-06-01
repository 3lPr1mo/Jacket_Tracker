package com.example.jacket_tracker.ui.view.Login_Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.jacket_tracker.databinding.ActivityRegisterBinding
import com.example.jacket_tracker.ui.view.Activity.MainActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding
    private var auth: FirebaseAuth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnRegister.setOnClickListener {
            val firstname = binding.firstnameEdt.text.toString()
            val lastname = binding.lastnameEdt.text.toString()
            val id = binding.idEdt.text.toString()
            val password = binding.passwordRegisterEdt.text.toString()
            val email = binding.emailEdt.text.toString()
            register(email, password)
        }

    }

    private fun register(email: String, password: String){
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, go to main activity
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(this, "Some error occurred", Toast.LENGTH_SHORT).show()
                }
            }
    }
}