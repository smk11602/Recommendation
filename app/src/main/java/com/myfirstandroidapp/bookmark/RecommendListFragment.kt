package com.myfirstandroidapp.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.myfirstandroidapp.bookmark.databinding.FragmentRecommendListBinding


class RecommendListFragment : Fragment() {
    private var binding: FragmentRecommendListBinding? = null
    private val recommendationViewModel: RecommendationViewModel by viewModels {
        RecommendationViewModel.Factory(requireActivity().application)
    }
    private val adapter: RecommendationAdapter by lazy { RecommendationAdapter(recommendationViewModel) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecommendListBinding.inflate(inflater, container, false)
        adapter.setHasStableIds(true)

        binding!!.PERRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
        binding!!.PERRecyclerview.adapter = adapter

        // 운동 추천 목록 설정
        adapter.setData(recommendationList) // recommendationList 추가

        recommendationViewModel.currentData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        return binding!!.root
    }


    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}