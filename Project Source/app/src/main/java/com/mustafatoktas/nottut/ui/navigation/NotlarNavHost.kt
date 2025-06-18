package com.mustafatoktas.nottut.ui.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mustafatoktas.nottut.ui.favoriler.FavorilerScreen
import com.mustafatoktas.nottut.ui.favoriler.viewmodel.FavorilerViewModel
import com.mustafatoktas.nottut.ui.notlar.NotlarScreen
import com.mustafatoktas.nottut.ui.notlar.viewmodel.NotlarViewModel

@Composable
fun NotlarNavHost(
    modifier: Modifier = Modifier,
    mainNavController: NavHostController,
    subNavController: NavHostController,
    startDestination: Destination,
    context: Context,
    notlarViewModel: NotlarViewModel,
    favorilerViewModel: FavorilerViewModel,
) {
    NavHost(
        navController = subNavController,
        startDestination = Graph.NotlarGraph
    ) {
        navigation<Graph.NotlarGraph>(
            startDestination = startDestination
        ) {
            composable<Destination.NotlarScreen> {
                NotlarScreen(
                    modifier = modifier,
                    mainNavController = mainNavController,
                    context = context,
                    viewModel = notlarViewModel,
                )
            }
            composable<Destination.FavorilerScreen> {
                FavorilerScreen(
                    modifier = modifier,
                    mainNavController = mainNavController,
                    context = context,
                    viewModel = favorilerViewModel,
                )
            }
        }
    }
}
