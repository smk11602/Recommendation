package com.myfirstandroidapp.bookmark

import kotlinx.coroutines.flow.Flow

class RecommendationRepository (private val recommendationDao: RecommendationDao) {
    val readAllData : Flow<List<Recommendation>> = recommendationDao.readAllData()
    val readBookmarkData : Flow<List<Recommendation>> = recommendationDao.readBookmarkData()


    suspend fun addRecommendation(recommendation: Recommendation){
        recommendationDao.addRecommendation(recommendation)
    }

    suspend fun updateRecommendation(recommendation: Recommendation){
        recommendationDao.updateRecommendation(recommendation)
    }
    suspend fun deleteRecommendation(recommendation: Recommendation){
        recommendationDao.deleteRecommendation(recommendation)
    }

}