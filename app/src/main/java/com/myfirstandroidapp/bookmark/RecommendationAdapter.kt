package com.myfirstandroidapp.bookmark

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.myfirstandroidapp.bookmark.databinding.ItemRecommendationBinding



class RecommendationAdapter(private val recommendationViewModel: RecommendationViewModel, private val isBookmarkVisible: Boolean)
    : RecyclerView.Adapter<RecommendationAdapter.MyViewHolder>() {

    private var recommendationList = emptyList<Recommendation>()

    inner class MyViewHolder(private val binding: ItemRecommendationBinding) : RecyclerView.ViewHolder(binding.root) {

        lateinit var recommendation: Recommendation
        lateinit var recommendationViewModel: RecommendationViewModel

        fun bind(currentRecommendation: Recommendation, recommendationViewModel: RecommendationViewModel) {
            binding.recommendation = currentRecommendation
            this.recommendationViewModel = recommendationViewModel

            //즐찾버튼 숨김/보임
            if (!isBookmarkVisible) {
                binding.BookmarkCheckButton.visibility = View.GONE
            } else {
                binding.BookmarkCheckButton.visibility = View.VISIBLE
            }


            binding.BookmarkCheckButton.setOnCheckedChangeListener(null)


            // 메모 체크 시 체크 데이터 업데이트 -- 에러 있음
            binding.BookmarkCheckButton.setOnCheckedChangeListener { _, check ->
                if (check) {
                    recommendation = Recommendation(
                        currentRecommendation.id,
                        true,
                        currentRecommendation.name,
                        currentRecommendation.time,
                        currentRecommendation.difficulty,
                        currentRecommendation.explanation

                    )
                    this.recommendationViewModel.addRecommendation(recommendation)



                } else {
                    recommendation = Recommendation(
                        currentRecommendation.id,
                        false,
                        currentRecommendation.name,
                        currentRecommendation.time,
                        currentRecommendation.difficulty,
                        currentRecommendation.explanation
                    )
                    this.recommendationViewModel.deleteRecommendation(recommendation)

                }

                Log.d("BookmarkStatus", "Bookmark status ${recommendation.bookmark} =? $check  for item ${currentRecommendation.name}")
            }

            binding.ToRecommendationDialogButton.setOnClickListener{
                recommendation = currentRecommendation
                val recommendationDialog = RecommendationDialog(binding.root.context, currentRecommendation)
                recommendationDialog.show()

            }

        }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemRecommendationBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recommendationList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(recommendationList[position],recommendationViewModel)

    }

    fun setData(newRecommendations: List<Recommendation>) {
        val diffResult = DiffUtil.calculateDiff(RecommendationDiffCallback(recommendationList, newRecommendations))
        recommendationList = newRecommendations
        diffResult.dispatchUpdatesTo(this)
    }



    override fun getItemId(position: Int): Long {
        return position.toLong()
    }


}


