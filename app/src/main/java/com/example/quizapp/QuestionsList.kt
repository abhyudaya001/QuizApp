package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat

class QuestionsList : AppCompatActivity(), View.OnClickListener {
    private var mCurrentPosition:Int =1
    private var mQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int =0
    private var mCorrectAnswer:Int =0
    private var userName:String?=null


    private var progressBar: ProgressBar?=null
    private var tvProgress: TextView?=null
    private var tvQuestion:TextView?=null
    private var tvImage:ImageView?=null
    private var tvOp1:TextView?=null
    private var tvOp2:TextView?=null
    private var tvOp3:TextView?=null
    private var tvOp4:TextView?=null
    private var btn:Button?=null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)
        userName= intent.getStringExtra(Constants.USER_NAME)
        progressBar=findViewById(R.id.progressBar)
        tvProgress=findViewById(R.id.progressTv)
        tvQuestion=findViewById(R.id.tv_question)
        tvImage=findViewById(R.id.imgv)
        tvOp1=findViewById(R.id.op1)
        tvOp2=findViewById(R.id.op2)
        tvOp3=findViewById(R.id.op3)
        tvOp4=findViewById(R.id.op4)
        btn=findViewById(R.id.submit)
        mQuestionList = Constants.getQuestions()
        setQuestion()
        tvOp1?.setOnClickListener(this)
        tvOp2?.setOnClickListener(this)
        tvOp3?.setOnClickListener(this)
        tvOp4?.setOnClickListener(this)
        btn?.setOnClickListener(this)
    }

    private fun setQuestion() {
        val question: Question = mQuestionList!![mCurrentPosition - 1]
        defaultOption()
        if(mCurrentPosition==mQuestionList!!.size){
            btn?.text="Finish"
        }else btn?.text="SUBMIT"
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition/${progressBar?.max}"
        tvQuestion?.text = question.question
        tvImage?.setImageResource(question.image)
        tvOp1?.text = question.op1
        tvOp2?.text = question.op2
        tvOp3?.text = question.op3
        tvOp4?.text = question.op4
    }
    private fun defaultOption(){
        val options=ArrayList<TextView>()
        tvOp1?.let { options.add(0,it) }
        tvOp2?.let { options.add(1,it) }
        tvOp3?.let { options.add(2,it) }
        tvOp4?.let { options.add(3,it) }
        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(
                this, R.drawable.border
            )
        }

    }
    private fun selectedOptionView(tv:TextView,selectedOptionNum:Int){
        defaultOption()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,R.drawable.select_bg
        )
    }
    override fun onClick(view: View?) {
            when(view?.id){
                R.id.op1->{
                    tvOp1?.let {
                        selectedOptionView(it,1)
                    }
                }
                R.id.op2->{
                    tvOp2?.let {
                        selectedOptionView(it,2)
                    }
                }
                R.id.op3->{
                    tvOp3?.let {
                        selectedOptionView(it,3)
                    }
                }
                R.id.op4->{
                    tvOp4?.let {
                        selectedOptionView(it,4)
                    }
                }
                R.id.submit->{
                    if(mSelectedOptionPosition==0){
                        mCurrentPosition++
                        when{
                            mCurrentPosition<=mQuestionList!!.size->{
                                setQuestion()
                            }
                            else->{
                                val intent=Intent(this,Result::class.java)
                                intent.putExtra(Constants.USER_NAME,userName)
                                intent.putExtra(Constants.CORRECT_ANSWER,mCorrectAnswer.toString())
                                intent.putExtra(Constants.TOTAL_QUESTIONS,mQuestionList!!.size.toString())
                                startActivity(intent)
                                finish()
                            }
                        }
                    }else{
                        val question=mQuestionList?.get(mCurrentPosition-1)
                        if(question!!.corrOP!=mSelectedOptionPosition){
                            answerView(mSelectedOptionPosition,R.drawable.wrong_option)
                        }else mCorrectAnswer++;
                        answerView(question.corrOP,R.drawable.correct_option)
                        if(mCurrentPosition==mQuestionList!!.size){
                            btn?.text="FINISH"
                        }else{
                            btn?.text="NEXT"
                        }
                        mSelectedOptionPosition=0;
                    }
                }
            }
    }
    private fun answerView(answer:Int,drawableView: Int){
        when(answer){
            1->{
                tvOp1?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            2->{
                tvOp2?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            3->{
                tvOp3?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
            4->{
                tvOp4?.background=ContextCompat.getDrawable(
                    this,drawableView
                )
            }
        }
    }
}