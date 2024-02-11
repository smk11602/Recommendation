package com.myfirstandroidapp.bookmark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.myfirstandroidapp.bookmark.databinding.FragmentBookmarkBinding


class BookmarkFragment : Fragment() {
    private var binding : FragmentBookmarkBinding? = null
    private val recommendationViewModel: RecommendationViewModel by viewModels {
        RecommendationViewModel.Factory(requireActivity().application)
    } // 뷰모델 연결
    private val adapter : RecommendationAdapter by lazy { RecommendationAdapter(recommendationViewModel, false) } // 어댑터 선언

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 뷰바인딩
        binding = FragmentBookmarkBinding.inflate(inflater,container,false)
        adapter.setHasStableIds(true)

        // 아이템을 가로로 하나씩 보여주고 어댑터 연결
        binding!!.BookmarkRecyclerview.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,false)
        binding!!.BookmarkRecyclerview.adapter = adapter


        recommendationViewModel.readBookmarkData.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        return binding!!.root
    }

}