package com.myfirstandroidapp.bookmark

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle

import android.widget.Button
import android.widget.TextView


class RecommendationDialog(context: Context, private val recommendation: Recommendation) : Dialog(context) {




    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.recommendation_dialog)

        var toCalendarButton : Button = findViewById(R.id.ToCalendarButton)
        var closeButton : Button = findViewById(R.id.CloseButton)
        var name : TextView = findViewById(R.id.RecommendNameTextView)
        var time : TextView = findViewById(R.id.RecommendTimeValue)
        var difficulty : TextView = findViewById(R.id.RecommendDifficultyValue)
        var explanation : TextView = findViewById(R.id.RecommendExplanationValue)

        name.text = recommendation.name
        time.text = recommendation.time.toString()
        difficulty.text = recommendation.difficulty.toString()
        explanation.text = recommendation.explanation


        window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))


        // 닫기 버튼 클릭 시 종료
        closeButton.setOnClickListener { dismiss()}
    }
}