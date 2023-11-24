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
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.SharedPreferencesHelper
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentMoviesBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentMyListBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentWatchedListBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyListViewModel
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.myLists.MyLists

class MyListFragment : Fragment() {

    private var _binding: FragmentMyListBinding? = null
    private val binding get() = _binding!!
    private lateinit var myListAdapter: MyListAdapter
    private lateinit var myListViewModel: MyListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMyListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myListAdapter = MyListAdapter(requireActivity(), emptyList())
        myListViewModel = ViewModelProvider(this).get(MyListViewModel::class.java)
        setData()
    }

    fun setData() {
        binding.rvMovies.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity)
            adapter = myListAdapter
        }
        myListViewModel.getAllMyList(requireContext()).observe(this, Observer {
            var list = it as ArrayList<MyLists>
            myListAdapter.setData(list)
        })

    }

}