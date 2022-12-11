package ru.dmitryskor.movies

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.fragment.findNavController
import ru.dmitryskor.movies.core.navigation.BaseFlowFragment
import ru.dmitryskor.movies.core.navigation.navigateSafely

/**
 * Created by Dmitry Skorodumov on 11.12.2022
 */
class MoviesFlowFragment : BaseFlowFragment(
    R.layout.flow_fragment_movies,
    R.id.main_nav_host_fragment_container
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().findViewById<AppCompatButton>(R.id.button_open_film).setOnClickListener {
            val action = MoviesFlowFragmentDirections.moviesFlowFragmentToFilmFlowFragment()
            findNavController().navigateSafely(action)
        }
    }
}