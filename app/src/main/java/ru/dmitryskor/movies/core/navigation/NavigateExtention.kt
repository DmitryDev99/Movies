package ru.dmitryskor.movies.core.navigation

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavAction
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import ru.dmitryskor.movies.R

/**
 * Created by Dmitry Skorodumov on 11.12.2022
 */

fun Fragment.activityNavController() = requireActivity().findNavController(R.id.nav_host_fragment_container)

fun NavController.navigateSafely(@IdRes actionId: Int) {
    currentDestination?.getAction(actionId)?.let { navigate(actionId) }
}

fun NavController.navigateSafely(directions: NavDirections) {
    currentDestination?.getAction(directions.actionId)?.let { navigate(directions) }
}