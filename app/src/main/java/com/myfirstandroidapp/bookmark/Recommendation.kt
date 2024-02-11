package com.myfirstandroidapp.bookmark

import android.os.Parcel
import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Recommendation(
    @PrimaryKey(autoGenerate = true) // 자동으로 기본키 값 증가
    var id: Int = 0,
    var bookmark: Boolean,
    val name: String,
    val time: Int,
    val difficulty: Int,
    val explanation: String,
)
