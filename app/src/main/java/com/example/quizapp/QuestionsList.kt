package com.example.quizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuestionsList : AppCompatActivity() {
    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView?=null
    private var tvQuestion:TextView?=null
    private var tvImage:ImageView?=null
    private var tvOp1:TextView?=null
    private var tvOp2:TextView?=null
    private var tvOp3:TextView?=null
    private var tvOp4:TextView?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.progressTv)
        tvQuestion=findViewById(R.id.tv_question)
        tvImage=findViewById(R.id.imgv)
        tvOp1=findViewById(R.id.op1)
        tvOp2=findViewById(R.id.op2)
        tvOp3=findViewById(R.id.op3)
        tvOp4=findViewById(R.id.op4)
        val questionsList= Constants.getQuestions()
        Log.i("QuestionList size is", "${questionsList.size}")
        for(i in questionsList){
            Log.e("Questions",i.question)
        }
        var currentPosition=1
        val question:Question=questionsList[currentPosition-1]
        progressBar?.progress=currentPosition
        tvProgress?.text="$currentPosition/${progressBar?.max}"
        tvQuestion?.text=question.question
        tvOp1?.text=question.op1
        tvOp2?.text=question.op2
        tvOp3?.text=question.op3
        tvOp4?.text=question.op4
        tvImage?.setImageResource(question.image)
        val btn:Button =findViewById(R.id.submit)
        btn.setOnClickListener {
            if(currentPosition==progressBar?.max){
                val intent=Intent(this,Result::class.java)
                startActivity(intent)
                finish()
            }
            else{currentPosition++;
            val question:Question=questionsList[currentPosition-1]
            progressBar?.progress=currentPosition
            tvProgress?.text="$currentPosition/${progressBar?.max}"
            tvQuestion?.text=question.question
                tvOp1?.text=question.op1
                tvOp2?.text=question.op2
                tvOp3?.text=question.op3
                tvOp4?.text=question.op4
                tvImage?.setImageResource(question.image)
            }
        }
    }
}