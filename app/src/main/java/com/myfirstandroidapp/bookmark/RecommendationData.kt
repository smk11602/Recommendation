package com.myfirstandroidapp.bookmark

// RecommendationData.kt 파일에 추가

val recommendationList = mutableListOf<Recommendation>().apply {
    add(
        Recommendation(
            1,
            false,
            "운동1",
            30,
            3,
            "운동1에 대한 설명"
        )
    )
    add(
        Recommendation(
            2,
            false,
            "운동2",
            45,
            2,
            "운동2에 대한 설명"
        )
    )
    add(
        Recommendation(
            3,
            false,
            "운동3",
            60,
            4,
            "운동3에 대한 설명"
        )
    )

    add(
        Recommendation(
            4,
            false,
            "운동3",
            60,
            4,
            "운동3에 대한 설명"
        )
    )

    add(
        Recommendation(
            5,
            false,
            "운동3",
            60,
            4,
            "운동3에 대한 설명"
        )
    )

    add(
        Recommendation(
            6,
            false,
            "운동3",
            60,
            4,
            "운동3에 대한 설명"
        )
    )
}
