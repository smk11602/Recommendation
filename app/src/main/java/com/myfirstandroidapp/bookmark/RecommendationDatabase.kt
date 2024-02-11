package com.myfirstandroidapp.bookmark

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Recommendation::class], version = 2, exportSchema = false)
abstract class RecommendationDatabase : RoomDatabase(){

    abstract fun recommendationDao() : RecommendationDao

    companion object{
        /* @Volatile = 접근가능한 변수의 값을 cache를 통해 사용하지 않고
        thread가 직접 main memory에 접근 하게하여 동기화. */
        @Volatile
        private var instance : RecommendationDatabase? = null

        // 싱글톤으로 생성 (자주 생성 시 성능 손해). 이미 존재할 경우 생성하지 않고 바로 반환
        fun getDatabase(context : Context) : RecommendationDatabase? {
            if(instance == null){
                synchronized(RecommendationDatabase::class){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RecommendationDatabase::class.java,
                        "recommendation_database"
                    ).build()
                }
            }
            return instance
        }
    }
}