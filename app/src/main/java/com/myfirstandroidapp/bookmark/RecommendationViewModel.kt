package com.myfirstandroidapp.bookmark

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecommendationViewModel(application: Application) : AndroidViewModel(application) {

    val readAllData: LiveData<List<Recommendation>>
    val readBookmarkData: LiveData<List<Recommendation>> //즐겨찾기 데이터 읽어오기
    private val repository: RecommendationRepository

    //이 부분 수정함******** 건드리지 말 것
    class Factory(private val application: Application) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(RecommendationViewModel::class.java)) {

                return RecommendationViewModel(application) as T
            }
            //  요청된 클래스가 ViewModel과 매치되지 않는 경우 예외를 발생
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    // get set
    private var _currentData = MutableLiveData<List<Recommendation>>()
    val currentData: LiveData<List<Recommendation>>
    get() = _currentData

    init {
        val recommendationDao =
            RecommendationDatabase.getDatabase(application)!!.recommendationDao()
        repository = RecommendationRepository(recommendationDao)
        readAllData = repository.readAllData.asLiveData()
        readBookmarkData = repository.readBookmarkData.asLiveData() //즐겨찾기 데이터 읽어오기
    }

    fun addRecommendation(recommendation: Recommendation){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addRecommendation(recommendation)
        }
    }

    fun updateRecommendation(recommendation: Recommendation){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateRecommendation(recommendation)
        }
    }

    fun deleteRecommendation(recommendation: Recommendation){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteRecommendation(recommendation)
        }
    }

    }



