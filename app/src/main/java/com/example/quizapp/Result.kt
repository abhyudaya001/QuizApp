package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Result : AppCompatActivity() {
    var userName :String?=null
    var correct:String?=null
    var total:String?=null
    private var tvName:TextView?=null
    private var score:TextView?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        userName=intent.getStringExtra(Constants.USER_NAME)
        correct=intent.getStringExtra(Constants.CORRECT_ANSWER)
        total=intent.getStringExtra(Constants.TOTAL_QUESTIONS)
        tvName=findViewById(R.id.tv_name)
        score=findViewById(R.id.tv_score)
        var finish:Button=findViewById(R.id.btn_finish)
        finish.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        tvName?.text=userName
        score?.text="You have scored $correct out of $total"

    }
}