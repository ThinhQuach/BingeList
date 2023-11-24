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
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter.TvShowsAdapter
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.SharedPreferencesHelper
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentTVShowsBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShows
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.tvShows.TvShowsModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class TVShowsFragment : Fragment() {
    private var _binding: FragmentTVShowsBinding? = null
    private val binding get() = _binding!!
    private lateinit var tvShowsAdapter: TvShowsAdapter
    private lateinit var tvShowsModel: TvShowsModel
    lateinit var sharedPreferencesHelper :SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTVShowsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvShowsAdapter = TvShowsAdapter(requireActivity(), emptyList())
        tvShowsModel = ViewModelProvider(this).get(TvShowsModel::class.java)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())
        setData()
    }

    fun setData() {
        val tvSHow1Cast = listOf(
            Cast(
                role_name = "Wednesday",
                name = "Jenna Ortega",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjnFxBzxAxDFQwV5cQEoa4gi_4"
            ),
            Cast(
                role_name = "Enid Sinclair",
                name = "Emma Myers",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRSW2k0pGIyZKDk8b33RMbRM7PV-efbRGRHGA&usqp=CAU"
            ),
            Cast(
                role_name = "Marylin Thornhill",
                name = "Christina Ricci",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-dzr1L7MQh7fYlIWzz9wXHwW9wStazH-mRw&usqp=CAU"
            ),
            Cast(
                role_name = "Xavier Thorpe",
                name = "Percy Hynes",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeyilPh5gzUWuDr53m0xb25F6I84VD3MIk6A&usqp=CAU"
            ),
            Cast(
                role_name = "Tyler Galpin",
                name = "Hunter Duhan",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSn7Lva1KcO48wRVRWKezNz5eutc0Y58Z8txQ&usqp=CAU"
            )
        )
        val tvSHows2Cast = listOf(
            Cast(
                role_name = "Tyler Locke",
                name = "Connor Jessup",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT-7BA56tWNJb7CrQWhmEYuzGEJ_EXmBK_K1w&usqp=CAU"
            ),
            Cast(
                role_name = "Kinsey Jones",
                name = "Emilia Jones",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQjyjsoYKYcS2JZ7PgsnTpyf1b1If3VH0ZgQ&usqp=CAU"
            ),
            Cast(
                role_name = "Nina Locke",
                name = "Darby Stanchfield",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRT6SnsuH1tzz0YxmOx-pNoOPazoVD6oZbCyg&usqp=CAU"
            ),
            Cast(
                role_name = "Bode Locke",
                name = "Jakson Robert Scott",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStJHYuBKUxAUFn8supXX4yfkowTyfecUwJHQ&usqp=CAU"
            ),
            Cast(
                role_name = "Dodge",
                name = "Laysla De Oliveria",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQp8ZKoiRtFMc7hcV-TsnOJWB8AWX34X2-Irg&usqp=CAUGjkjuY3RlGf7Q&usqp=CAU"
            )
        )
        val tvShows3Cast = listOf(
            Cast(
                role_name = "Eleven",
                name = "Millie Bobby Brown",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRe4KiLLEhAP4pne2OJ5KIrhslv7ROVG4elzg&usqp=CAU"
            ),
            Cast(
                role_name = "Will Byers",
                name = "Noah Schnapp",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRe9haI5SClilSc-k0gW_acB0Hkdj7uNKHSHQ&usqp=CAU"
            ),
            Cast(
                role_name = "Mike Wheller",
                name = "Finn Wolfhard",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5nkoXTZFiE5H5noUISYZR7E_kyHhd43PHHg&usqp=CAU"
            ),
            Cast(
                role_name = "Locar Sinclair",
                name = "Caleb McLaughlin",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ97mVW64YXbZhzbuYB3ZuUaqCBEexOk4l_Tw&usqp=CAU"
            ),
        )
        val tvShows4Cast = listOf(
            Cast(
                role_name = "The Proffesor",
                name = "Alvaro Morte",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTo4jzAKZoCKwaxLUJe2cjFypDtvXn6GKaW_w&usqp=CAU"
            ),
            Cast(
                role_name = "Tokyo",
                name = "Ursula Corbero",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSSB8hhVtn_H0Ky1V29U60nj3r5U0Vxpih33w&usqp=CAU"
            ),
            Cast(
                role_name = "Berlin",
                name = "Pedro Alonso",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSmqd5B5VSHfieOH9zCmrrK0FfPI0EhYP_u2g&usqp=CAU"
            ),
            Cast(
                role_name = "Raquel Murillo",
                name = "Itzair Ituno",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSv1m_2BAE0esfsrSetKyS1gPIOGAk08zOFug&usqp=CAU"
            ),

        )
        val tvShows = listOf(
            TvShows(
                name = "Wednesday",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcMvzTK3P4utQeyTN-LXqnSI0RVoqvqxT50J6jbX61_vBydTUS",
                isChildren = "Yes",
                director_name = "Miles Millar",
                director_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLvGN8clS4XzvvBjzmMZp50dfUMojGJkRQxQ&usqp=CAU",
                trailor_link = "https://www.youtube.com/watch?v=NakTu_VZxJ0",
                total_time = "3 hours 30 minutes",
                rating = "6.0",
                isInMyList = "No",
                isWatched = "No",
                casts = tvSHow1Cast,
                description = "While attending Nevermore Academy, Wednesday Addams attempts to master her emerging psychic ability, thwart a killing spree and solve the mystery that embroiled her parents 25 years ago."
            ),
            TvShows(
                name = "Locke & Key",
                image = "https://encrypted-tbn2.gstatic.com/images?q=tbn:ANd9GcTGgZQVdHjcCSNZmlQn5kIcx0_nayhAXlKGYxxt8-YzjdEtcgzB",
                isChildren = "Yes",
                director_name = "Aron Eli Coleite",
                director_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR98eAGZ7zhBhNXnTWMzgnUggV9u-o8xFKf0hnXa-wT2vYPQIGI8N4SOFFiM3PvZ1nkvHY&usqp=CAU",
                trailor_link = "https://www.youtube.com/watch?v=_EonRi0yQOE",
                total_time = "4 hours 00 minutes",
                rating = "7.0",
                isInMyList = "No",
                isWatched = "No",
                casts = tvSHows2Cast,
                description = "Following their father's murder, three siblings move into a house filled with reality-bending keys; from the comics by Joe Hill and Gabriel Rodriguez."
            ),
            TvShows(
                name = "Stranger Things",
                image = "https://images-na.ssl-images-amazon.com/images/M/MV5BMjEzMDAxOTUyMV5BMl5BanBnXkFtZTgwNzAxMzYzOTE@._V1_.jpg",
                isChildren = "No",
                director_name = "Ross Duffer",
                director_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0ECrae0uBdICXys9aWEiYFOG2Z12qa6k1HQ&usqp=CAU",
                trailor_link = "https://www.youtube.com/watch?v=b9EkMc79ZSU",
                total_time = "3 hours 50 minutes",
                rating = "8.5",
                isInMyList = "No",
                isWatched = "No",
                casts = tvShows3Cast,
                description = "In 1980s Indiana, a group of young friends witness supernatural forces and secret government exploits. As they search for answers, the children unravel a series of extraordinary mysteries."
            ),
            TvShows(
                name = "Money Heist",
                image = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQcEazg1RHMebusfpj_3nR8f-d_CgNLxAc0Wm9foVDza9M4hKcf",
                isChildren = "No",
                director_name = "Álex Pina",
                director_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSego0c73uMurGQqs7WL4knQ8CcgbhVm6pjgw&usqp=CAU",
                trailor_link = "https://www.youtube.com/watch?v=_InqQJRqGW4",
                total_time = "4 hours 40 minutes",
                rating = "7.9",
                isInMyList = "No",
                isWatched = "No",
                casts = tvShows4Cast,
                description = "A criminal mastermind who goes by \"The Professor\" has a plan to pull off the biggest heist in recorded history -- to print billions of euros in the Royal Mint of Spain. To help him carry out the ambitious plan, he recruits eight people with certain abilities and who have nothing to lose. The group of thieves take hostages to aid in their negotiations with the authorities, who strategize to come up with a way to capture The Professor. As more time elapses, the robbers prepare for a showdown with the police."
            ),
        )

        binding.rvTVSHows.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(activity)
            adapter=tvShowsAdapter
        }
        if(sharedPreferencesHelper.getString("currentUserIsChildren").equals("Yes")){
            tvShowsModel.getAllTVSHows(requireContext()).observe(this, Observer {
                var list = it as ArrayList<TvShows>
                if(list.isEmpty()){
                    tvShowsModel.insertTVShows(requireContext(),tvShows)
                }
                tvShowsAdapter.setData(it as ArrayList<TvShows>)
            })
        }
        else{
            tvShowsModel.getAllTVShowsforAdult(requireContext()).observe(this, Observer {
                var list = it as ArrayList<TvShows>
                if(list.isEmpty()){
                    tvShowsModel.insertTVShows(requireContext(),tvShows)
                }
                tvShowsAdapter.setData(it as ArrayList<TvShows>)
            })
        }


    }

}