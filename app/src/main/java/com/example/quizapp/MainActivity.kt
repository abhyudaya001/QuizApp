package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn:Button= findViewById(R.id.button)
        val tx : EditText=findViewById(R.id.textE)

        btn.setOnClickListener {
            if(tx.text.isEmpty()){
                Toast.makeText(this, "Please enter your name!", Toast.LENGTH_SHORT).show()
            }
            else{
                val intent=Intent(this,QuestionsList::class.java)
                intent.putExtra(Constants.USER_NAME,tx.text.toString())
                startActivity(intent)
                finish()
            }

        }


    }

}