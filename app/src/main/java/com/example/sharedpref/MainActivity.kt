package com.example.sharedpref

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preference = applicationContext.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val welcome = preference.getString("WELCOME","Enter welcome text")
        Toast.makeText(this,welcome,Toast.LENGTH_SHORT).show()

        applybtn.setOnClickListener(){
            if (!TextUtils.isEmpty(welcometext.text.toString())) {
                val editor = preference.edit()
                editor.putString("WELCOME", welcometext.text.toString())
                editor.apply()
            }
        }


    }

}
