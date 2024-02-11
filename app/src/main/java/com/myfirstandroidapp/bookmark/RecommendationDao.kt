package com.myfirstandroidapp.bookmark

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface RecommendationDao {
    // OnConflictStrategy.IGNORE = 동일한 아이디가 있을 시 무시
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addRecommendation(recommendation: Recommendation)

    @Update
    suspend fun updateRecommendation(recommendation: Recommendation)

    @Delete
    suspend fun deleteRecommendation(recommendation: Recommendation)

    @Query("SELECT * FROM Recommendation ORDER BY id DESC")
    fun readAllData(): Flow<List<Recommendation>>

    //즐겨찾기된 목록만 출력
    @Query("SELECT * FROM Recommendation WHERE `bookmark` = 1 ORDER BY  id DESC")
    fun readBookmarkData(): Flow<List<Recommendation>>

}


