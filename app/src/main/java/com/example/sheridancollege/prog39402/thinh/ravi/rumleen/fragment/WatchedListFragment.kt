package com.example.sheridancollege.prog39402.thinh.ravi.rumleen.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.R
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter.MyListAdapter
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter.WatchedListAdapter
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentMoviesBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentMyListBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentTVShowsBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentWatchedListBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyListViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList.WatchList
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.watchList.WatchListviewModel

class WatchedListFragment : Fragment() {
     var _binding: FragmentWatchedListBinding? = null
    private val binding get() = _binding!!
    private lateinit var watchedListAdapter: WatchedListAdapter
    private lateinit var watchListviewModel: WatchListviewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWatchedListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        watchedListAdapter = WatchedListAdapter(requireActivity(), emptyList())
        watchListviewModel = ViewModelProvider(this).get(WatchListviewModel::class.java)
        setData()
    }

    fun setData() {
        binding.rvMovies.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = watchedListAdapter
        }
        watchListviewModel.getAllWatchList(requireContext()).observe(this, Observer {
            var list = it as ArrayList<WatchList>
            watchedListAdapter.setData(list)
        })
    }



}