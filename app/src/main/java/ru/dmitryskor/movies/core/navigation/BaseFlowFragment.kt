package ru.dmitryskor.movies.core.navigation

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

/**
 * Created by Dmitry Skorodumov on 10.12.2022
 * Базовый фрагмент с графом
 */
abstract class BaseFlowFragment(
    @LayoutRes contentLayoutId: Int,
    @IdRes private val navHostFragmentId: Int
) : Fragment(contentLayoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val navHostFragment = childFragmentManager.findFragmentById(navHostFragmentId) as NavHostFragment
//        val navController = navHostFragment.navController
//        setupNavigation(navController)
    }

    protected open fun setupNavigation(navController: NavController) {

    }
}