package com.mustafatoktas.nottut.ui.navigation

import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mustafatoktas.nottut.common.mySlideInHorizontalyNegatif
import com.mustafatoktas.nottut.common.mySlideInHorizontalyPozitif
import com.mustafatoktas.nottut.common.mySlideInVerticallyNegatif
import com.mustafatoktas.nottut.common.mySlideInVerticallyPozitif
import com.mustafatoktas.nottut.common.mySlideOutHorizontalyNegatif
import com.mustafatoktas.nottut.common.mySlideOutHorizontalyPozitif
import com.mustafatoktas.nottut.common.mySlideOutVerticallyNegatif
import com.mustafatoktas.nottut.common.mySlideOutVerticallyPozitif
import com.mustafatoktas.nottut.ui.ayarlar.AyarlarScreen
import com.mustafatoktas.nottut.ui.ayarlar.viewmodel.AyarlarViewModel
import com.mustafatoktas.nottut.ui.duzenle.DuzenleScreen
import com.mustafatoktas.nottut.ui.favoriler.viewmodel.FavorilerViewModel
import com.mustafatoktas.nottut.ui.hakkinda.HakkindaScreen
import com.mustafatoktas.nottut.ui.hakkinda.viewmodel.HakkindaViewModel
import com.mustafatoktas.nottut.ui.main.MainScreen
import com.mustafatoktas.nottut.ui.main.viewmodel.MainViewModel
import com.mustafatoktas.nottut.ui.notlar.viewmodel.NotlarViewModel

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun MainNavHost(
    mainNavController: NavHostController,
    subNavController: NavHostController,
    context: Context,
) {
    val notlarViewModel: NotlarViewModel = hiltViewModel()
    val favorilerViewModel: FavorilerViewModel = hiltViewModel()
    val ayarlarViewModel: AyarlarViewModel = hiltViewModel()
    val mainViewModel: MainViewModel = hiltViewModel()
    val hakkindaViewModel: HakkindaViewModel = hiltViewModel()

    NavHost(
        navController = mainNavController,
        startDestination = Graph.MainGraph
    ) {
        navigation<Graph.MainGraph>(
            startDestination = Destination.MainScreen
        ) {
            composable<Destination.MainScreen> {
                MainScreen(
                    mainNavController = mainNavController,
                    subNavController = subNavController,
                    context = context,
                    notlarViewModel = notlarViewModel,
                    favorilerViewModel = favorilerViewModel,
                    viewModel = mainViewModel,
                )
            }
            composable<Destination.AyarlarScreen> (
                enterTransition = { mySlideInHorizontalyPozitif() },
                exitTransition = { mySlideOutHorizontalyNegatif() },
                popEnterTransition = { mySlideInHorizontalyNegatif() },
                popExitTransition = { mySlideOutHorizontalyPozitif() },
            ) {
                AyarlarScreen(
                    mainNavController = mainNavController,
                    context = context,
                    viewModel = ayarlarViewModel,
                )
            }
            composable<Destination.DuzenleScreen> (
                enterTransition = { mySlideInHorizontalyPozitif() },
                exitTransition = { mySlideOutHorizontalyNegatif() },
                popEnterTransition = { mySlideInHorizontalyNegatif() },
                popExitTransition = { mySlideOutHorizontalyPozitif() },
            ) {
                DuzenleScreen(
                    mainNavController = mainNavController,
                    context = context,
                )
            }
            composable<Destination.HakkindaScreen> (
                enterTransition = { mySlideInVerticallyPozitif() },
                exitTransition = { mySlideOutVerticallyNegatif() },
                popEnterTransition = { mySlideInVerticallyNegatif() },
                popExitTransition = { mySlideOutVerticallyPozitif() },
            ) {
                HakkindaScreen(
                    mainNavController = mainNavController,
                    context = context,
                    viewModel = hakkindaViewModel,
                )
            }
        }
    }
}
