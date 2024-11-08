package com.diksh.quizappretrofit.retrofit

import com.diksh.quizappretrofit.model.QuestionList
import retrofit2.Response
import retrofit2.http.GET

interface QuestionsAPI {

    @GET("questionapi.php")
    suspend fun getQuestion(): Response<QuestionList>
}