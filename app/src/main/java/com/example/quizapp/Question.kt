package com.example.quizapp

data class Question(
    var id:Int,
    val image:Int,
    val question:String,
    val op1:String,
    val op2:String,
    val op3:String,
    val op4:String,
    val corrOP:Int
)
