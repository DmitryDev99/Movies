package ru.dmitryskor.movies

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.dmitryskor.movies.core.navigation.BaseFlowFragment
import ru.dmitryskor.movies.core.navigation.navigateSafely

/**
 * Created by Dmitry Skorodumov on 10.12.2022
 * Основной фрагмент
 */
class MainFlowFragment : BaseFlowFragment(
    R.layout.flow_fragment_main,
    R.id.main_nav_host_fragment_container
) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bottomNavMenu = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        val fragContainer = childFragmentManager.findFragmentById(R.id.main_nav_host_fragment_container) as NavHostFragment
        val navController = fragContainer.navController
        val navGraphMovies = navController.navInflater.inflate(R.navigation.movies_graph)
        val navGraphApps = navController.navInflater.inflate(R.navigation.apps_graph)

        setDefaultSelectedItem(bottomNavMenu, navController, navGraphMovies, R.id.movies_item_main_menu)

        bottomNavMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.movies_item_main_menu -> {
                    navController.graph = navGraphMovies
//                    val action = MainFlowFragmentDirections.actionMainFlowFragmentToMoviesGraph()
//                    findNavController().navigateSafely(action)
                }
                R.id.list_apps_item_main_menu -> {
                    navController.graph = navGraphApps
//                    val action = MainFlowFragmentDirections.actionMainFlowFragmentToAppsGraph()
//                    findNavController().navigateSafely(action)
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun setDefaultSelectedItem(bottomNavMenu: BottomNavigationView, navController: NavController, navGraph: NavGraph, itemId: Int) {
        bottomNavMenu.selectedItemId = itemId
        navController.graph = navGraph
    }
}