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
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.adapter.MoviesAdapter
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.common.SharedPreferencesHelper
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.databinding.FragmentMoviesBinding
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.casts.Cast
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.Movies
import com.example.sheridancollege.prog39402.thinh.ravi.rumleen.room.movies.MoviesViewModel


class MoviesFragment : Fragment() {
    private var _binding: FragmentMoviesBinding? = null
    private val binding get() = _binding!!
    private lateinit var moviesAdapter: MoviesAdapter
    private lateinit var moviesViewModel: MoviesViewModel
    lateinit var sharedPreferencesHelper :SharedPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMoviesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        moviesAdapter = MoviesAdapter(requireActivity(), emptyList())
        moviesViewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)
        sharedPreferencesHelper = SharedPreferencesHelper(requireContext())
        setData()
    }

    fun setData() {
        val movie1Cast = listOf(
            Cast(
                role_name = "Ethan Hunt",
                name = "Tom Cruise",
                image = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTNGXVvM5RZUllNyheM7KJBs8c0eJ1tn35PLcido5hQLlZseigK"
            ),
            Cast(
                role_name = "Grace",
                name = "Hayley Atwell",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQJVbeBRGX0ZmAgrWu-I1wiax5T9l-igX5K4hENQZBfE2N7-AQqEe2RuaNgMEMYN3XC_m0&usqp=CAU"
            ),
            Cast(
                role_name = "Iisa Faust",
                name = "Rebecca Ferguson",
                image = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/89/Rebecca_Ferguson_in_Paris_2018.jpg/270px-Rebecca_Ferguson_in_Paris_2018.jpg"
            ),
            Cast(
                role_name = "Alanna Mitsop",
                name = "Vanessa Kirby",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTAXxp1YILUp1jC2NO6-qL5QW_Ioog0KEIBNA&usqp=CAU"
            ),
            Cast(
                role_name = "Gabriel",
                name = "Esai Morales",
                image = "https://t3.gstatic.com/images?q=tbn:ANd9GcTpzZd-bizm59KQrswCxGa2xw4OR33uZ5yS4mjZQZcgBL0ofHpPuLTN0z3F_-VIz-TSbYNFEA"
            )
        )
        val movie2Cast = listOf(
            Cast(
                role_name = "Prince Yan",
                name = "Park Seo-joon",
                image = "https://encrypted-tbn3.gstatic.com/licensed-image?q=tbn:ANd9GcQYF2F2_hW0igtINCb1qEiJQnLyXslIsrmS8JkDG6XhkbG3z_oQYL40oJq994SY4fXivuotS6v3614SOdQ"
            ),
            Cast(
                role_name = "Carol Vanvers",
                name = "Brie Larson",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4hgAC7FFVjMj9KkVLgOKeQq0lcolAb0G0EA&usqp=CAU"
            ),
            Cast(
                role_name = "Ms. Marvel",
                name = "Iman Vellani",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ9YjMFEdtAJZ2wAzFTVq_7FsbFE9IyaLH18A&usqp=CAU"
            ),
            Cast(
                role_name = "Zave Ashton",
                name = "Zave Ashton",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTYHKOCj9bb04F359DxEbGljSCIem2TeJC7RA&usqp=CAU"
            ),
            Cast(
                role_name = "Monica Ramb",
                name = "Teyonah Parris",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQwz_gft5Ki7Ml9LyZKpw9IzGjkjuY3RlGf7Q&usqp=CAU"
            )
        )
        val movie3Cast = listOf(
            Cast(
                role_name = "Ariel",
                name = "Halle Bailey",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5aiVXmy5xMpKfC9K_QN-cSErxWtC_8nvPww&usqp=CAU"
            ),
            Cast(
                role_name = "King Triton",
                name = "Javier Bardem",
                image = "https://t3.gstatic.com/images?q=tbn:ANd9GcR-VqGfbyLq8QOkn4m2sLg-7fFbzKHJ8hI1T4mxHLrC85NDa81vGs7Dh_xtP4zA6AYaPKjQ_g"
            ),
            Cast(
                role_name = "Ursula",
                name = "Melissa McCarthy",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT4nX3QS5OgOVEcNwEQHuVSIGCTAHwVd5rkWw&usqp=CAU"
            ),
            Cast(
                role_name = "Prince Eric",
                name = "Jonah HauerKing",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTLB95PSCoWtLszigu5B2EVNEn4sVvrPGfrqg&usqp=CAUU"
            ),
        )
        val movie4Cast = listOf(
            Cast(
                role_name = "Princess Peach",
                name = "Anya TaylorJoy",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRxpEx2kosguYYUgteX9szs-pBT8rB8fM5JA&usqp=CAU"
            ),
            Cast(
                role_name = "Mario",
                name = "Chris Pratt",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoqdE9TkiSQGTPJ2LJXCdD1RM95boiJiSUpw&usqp=CAU"
            ),
            Cast(
                role_name = "Bowser",
                name = "Jack Black",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTsdVNQc3Lx7vG2oMrDNXX3vp38y9ZYmzjsDw&usqp=CAUU"
            ),
            Cast(
                role_name = "Luigi",
                name = "Charlie Day",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTWWvrHhW39EbbAGo-flm_QkxN4jNy9xoT6Ow&usqp=CAU"
            ),
            Cast(
                role_name = "Giuseppe",
                name = "Charles Martinet",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTtf4lSik04-DAAvh9t2rT7jIZLf01dS-a7iw&usqp=CAU"
            ),
        )
        val movies = listOf(
            Movies(
                name = "Mission: Impossible – Dead Reckoning Part One",
                image = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQCIGf-WLMi6m16lR3y9zKnyu6OpBRr-4nlpmcgAQuXpPuVHc8O",
                isChildren = "No",
                director_name = "Christopher McQuarrie",
                director_image = "https://pyxis.nymag.com/v1/imgs/e4e/36b/624da5a1f403cfab4591f9972d3a0836c0-19-chris-mcquarrie.2x.h473.w710.jpg",
                trailor_link = "https://www.youtube.com/watch?v=avz06PDqDbM",
                total_time = "2 hours 30 minutes",
                rating = "7.8",
                isInMyList = "No",
                isWatched = "No",
                casts = movie1Cast,
                description = "Ethan Hunt and the IMF team must track down a terrifying new weapon that threatens all of humanity if it falls into the wrong hands. With control of the future and the fate of the world at stake, a deadly race around the globe begins. Confronted by a mysterious, all-powerful enemy, Ethan is forced to consider that nothing can matter more than the mission -- not even the lives of those he cares about most.",
                user_review = "",
                user_score = ""
            ),
            Movies(
                name = "The Marvels",
                image = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcQqTIGLtYhubpG9jKeeyLotATBM73Ydq81TMIXO9esF_SSlKxny",
                isChildren = "No",
                director_name = "Nia DaCostae",
                director_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXFfZh38haaj8JXUmYQVTGwgfyS1uyUBa9Nw&usqp=CAU",
                trailor_link = "https://www.youtube.com/watch?v=wS_qbDztgVY",
                total_time = "2 hours 00 minutes",
                rating = "9.0",
                isInMyList = "No",
                isWatched = "No",
                casts = movie2Cast,
                description = "Carol Danvers, aka Captain Marvel, has reclaimed her identity from the tyrannical Kree and taken revenge on the Supreme Intelligence. However, unintended consequences see her shouldering the burden of a destabilized universe. When her duties send her to an anomalous wormhole linked to a Kree revolutionary, her powers become entangled with two other superheroes to form the Marvels.",
                user_review = "",
                user_score = ""
            ),
            Movies(
                name = "The Little Mermaid",
                image = "https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTY56eLCU8tJ4dCfhJbZpLbJf-kYGXqg7H4zpNvw3HRRcmH02YY",
                isChildren = "Yes",
                director_name = "Rob Marshall",
                director_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT34N339rRal4t4HUi1dGybtcomcTi6W0DKlQ&usqp=CAU",
                trailor_link = "https://www.youtube.com/watch?v=kpGo2_d3oYE",
                total_time = "3 hours 50 minutes",
                rating = "8.5",
                isInMyList = "No",
                isWatched = "No",
                casts = movie3Cast,
                description = "The youngest of King Triton's daughters, Ariel is a beautiful and spirited young mermaid with a thirst for adventure. Longing to find out more about the world beyond the sea, Ariel visits the surface and falls for the dashing Prince Eric. Following her heart, she makes a deal with the evil sea witch, Ursula, to experience life on land.",
                user_review = "",
                user_score = ""
            ),
            Movies(
                name = "The Super Mario Bros. Movie",
                image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSpBbVu_x3gJEzXXSiVtCzEq6Qn1_iT5DozrA&usqp=CAU",
                isChildren = "Yes",
                director_name = "Michael Jelenic",
                director_image = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQoP9ofTX8REE_DbU2bGFF11oPwp99wCBk5SA&usqp=CAU",
                trailor_link = "https://www.youtube.com/watch?v=TnGl01FkMMo",
                total_time = "3 hours 40 minutes",
                rating = "6.9",
                isInMyList = "No",
                isWatched = "No",
                casts = movie4Cast,
                description = "While working underground to fix a water main, Brooklyn plumbers and brothers Mario and Luigi are transported through a mysterious pipe to a magical new world. But when the siblings are separated, an epic adventure begins.",
                user_review = "",
                user_score = ""
            ),
        )

        binding.rvMovies.apply {
            setHasFixedSize(true)
            layoutManager= LinearLayoutManager(activity)
            adapter=moviesAdapter
        }
        if(sharedPreferencesHelper.getString("currentUserIsChildren").equals("Yes")){
            moviesViewModel.getAllMoviesData(requireContext()).observe(this, Observer {
                var list = it as ArrayList<Movies>
                if(list.isEmpty()){
                    moviesViewModel.insertMovies(requireContext(),movies)
                }
                moviesAdapter.setData(it as ArrayList<Movies>)
            })
        }
        else{
            moviesViewModel.getAllMoviesDataforAdult(requireContext()).observe(this, Observer {
                var list = it as ArrayList<Movies>
                if(list.isEmpty()){
                    moviesViewModel.insertMovies(requireContext(),movies)
                }
                moviesAdapter.setData(it as ArrayList<Movies>)
            })
        }



    }

}