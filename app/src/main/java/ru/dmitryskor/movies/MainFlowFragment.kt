package ru.dmitryskor.movies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import ru.dmitryskor.movies.core.navigation.BaseFlowFragment
import ru.dmitryskor.movies.databinding.FlowFragmentMainBinding

/**
 * Created by Dmitry Skorodumov on 10.12.2022
 * Основной фрагмент
 */
class MainFlowFragment : BaseFlowFragment(
    R.layout.flow_fragment_main,
    R.id.main_nav_host_fragment_container
) {

    private lateinit var _binding: FlowFragmentMainBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FlowFragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initBottomNavigationView()
    }

    private fun startItemSelected(bottomNavMenu: BottomNavigationView, itemId: Int) {
        bottomNavMenu.selectedItemId = itemId
    }

    private fun initBottomNavigationView() {
        val navController = binding.mainNavHostFragmentContainer.findNavController()
        binding.bottomNavigation.setupWithNavController(navController)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigation.isVisible = getFragmentsWithBottomNav().any { it == destination.id }
        }
        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.moviesFlowFragment -> {
                    navController.graph = navController.navInflater.inflate(R.navigation.movies_graph)
                }
                R.id.listAppsFlowFragment -> {
                    navController.graph = navController.navInflater.inflate(R.navigation.apps_graph)
                }
            }
            return@setOnItemSelectedListener true
        }
        startItemSelected(binding.bottomNavigation, R.id.moviesFlowFragment)
    }

    companion object {
        fun getFragmentsWithBottomNav() = listOf(
            R.id.moviesFlowFragment,
            R.id.listAppsFlowFragment,
        )
    }

}