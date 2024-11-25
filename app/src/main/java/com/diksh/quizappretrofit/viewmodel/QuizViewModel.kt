package com.diksh.quizappretrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.diksh.quizappretrofit.model.QuestionList
import com.diksh.quizappretrofit.repository.QuizRepository

class QuizViewModel: ViewModel() {

    var repository: QuizRepository = QuizRepository()

    lateinit var questionLiveData: LiveData<QuestionList>

    init {
        questionLiveData = repository.getQuestionsFromAPI()
    }


    fun getQuestionsFromLiveData(): LiveData<QuestionList>{
        return questionLiveData
    }
}