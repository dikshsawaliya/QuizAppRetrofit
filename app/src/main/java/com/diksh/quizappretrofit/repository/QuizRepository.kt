package com.diksh.quizappretrofit.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.diksh.quizappretrofit.model.QuestionList
import com.diksh.quizappretrofit.retrofit.QuestionsAPI
import com.diksh.quizappretrofit.retrofit.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class QuizRepository {

    var questionsAPI: QuestionsAPI

    init {
        questionsAPI = RetrofitInstance().getRetrofitInstance()
                        .create(QuestionsAPI::class.java)
    }

    fun getQuestionsFromAPI():LiveData<QuestionList>{

        //Livedata
        var data = MutableLiveData<QuestionList>()
        var questionList: QuestionList

        GlobalScope.launch(Dispatchers.IO) {

            //Returning the Response<QuestionList>
            val response = questionsAPI.getQuestion()

            if (response!= null){
                //Saving the data to array list
                questionList = response.body()!!
                data.postValue(questionList)
                Log.d("###", ""+ data.value)
            }
        }
        return data
    }
}