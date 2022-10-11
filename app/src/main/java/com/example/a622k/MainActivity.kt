package com.example.a622k

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.widget.AppCompatButton
import com.example.a622k.managers.PreferenceManagerss

class MainActivity : AppCompatActivity() {


    lateinit var save: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

    }

    private fun initViews() {
        val fullname: EditText = findViewById(R.id.fullname)
        val email: EditText = findViewById(R.id.email)
        val password: EditText = findViewById(R.id.password)
        val confirm_password: EditText = findViewById(R.id.confirm_password)

        save = findViewById(R.id.button_sign)

        save.setOnClickListener {


            val save_fullname = fullname.text.toString().trim()
            val save_email = email.text.toString().trim()
            val save_password = password.text.toString().trim()
            val save_confirm_password = confirm_password.text.toString().trim()

            val signIn = SignIn(save_fullname,save_email,
                save_password, save_confirm_password)

            PreferenceManagerss.getInstance(this)?.saveDate(signIn)

        }
    }
}