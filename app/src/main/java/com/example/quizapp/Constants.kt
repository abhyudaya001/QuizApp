package com.example.quizapp

object Constants {
    const val USER_NAME :String="user_name";
    const val TOTAL_QUESTIONS :String="total_questions"
    const val CORRECT_ANSWER :String="correct_answer"
    fun getQuestions():ArrayList<Question>{
        val questionsList=ArrayList<Question>()
        val q1=Question(
            1,R.drawable.q1, "What will be the output of the following code snippet?","3 5","3 3","5 5","5 3",4
        )
        questionsList.add(q1)
        val q2=Question(
            2,R.drawable.q2, "What will be the output of the following code snippet?","1","4","20","10",4
        )
        questionsList.add(q2)
        val q3=Question(
            3,R.drawable.q3, "What will be the output of the following code snippet?","5","18","16","0",3
        )
        questionsList.add(q3)
        val q4=Question(
            4,R.drawable.q4, "What will be the output of the following code snippet?","12","24","20","18",3
        )
        questionsList.add(q4)
        val q5=Question(
            5,R.drawable.q5, "What will be the output of the following code snippet?","5","0","1","Compilation Error",1
        )
        questionsList.add(q5)
        return questionsList
    }
}