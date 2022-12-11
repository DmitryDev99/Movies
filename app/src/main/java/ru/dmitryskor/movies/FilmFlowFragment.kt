package ru.dmitryskor.movies

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.dmitryskor.movies.core.navigation.activityNavController

/**
 * Created by Dmitry Skorodumov on 11.12.2022
 */
class FilmFlowFragment : Fragment(
    R.layout.flow_fragment_film
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activityNavController().backQueue
        activityNavController().currentDestination
        activityNavController().currentBackStackEntry
        findNavController()
    }
}