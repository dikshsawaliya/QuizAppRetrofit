package com.diksh.quizappretrofit.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.diksh.quizappretrofit.R
import com.diksh.quizappretrofit.databinding.ActivityMainBinding
import com.diksh.quizappretrofit.model.Question
import com.diksh.quizappretrofit.model.QuestionList
import com.diksh.quizappretrofit.viewmodel.QuizViewModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var quizViewModel: QuizViewModel
    lateinit var questionList: List<Question>


    //Whenever you start any quiz, we need to instantiate a result and total questions
    companion object{
        var result = 0
        var totalQuestion = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //Since we are going to use this app many times, we need to reset the quiz (scores = 0, totalQuestions = 0)
        result = 0
        totalQuestion = 0

        quizViewModel = ViewModelProvider(this)
                        .get(QuizViewModel::class.java)


    }
}