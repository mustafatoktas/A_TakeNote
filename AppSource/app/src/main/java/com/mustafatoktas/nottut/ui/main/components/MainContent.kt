package com.mustafatoktas.nottut.ui.main.components

import android.content.Context
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.ui.favoriler.viewmodel.FavorilerViewModel
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseEvent
import com.mustafatoktas.nottut.ui.generalComponents.composables.CustomFAB
import com.mustafatoktas.nottut.ui.navigation.Destination
import com.mustafatoktas.nottut.ui.navigation.NotlarNavHost
import com.mustafatoktas.nottut.ui.notlar.viewmodel.NotlarViewModel

@Composable
fun MainContent(
    mainNavController: NavHostController,
    subNavController: NavHostController,
    baslangicSayfasi: BaslangicSayfasi,
    context: Context,
    notlarViewModel: NotlarViewModel,
    favorilerViewModel: FavorilerViewModel,
) {
    val navBackStackEntry by subNavController.currentBackStackEntryAsState()

    val title by remember {
        derivedStateOf {
            when (navBackStackEntry?.destination?.route) {
                Destination.NotlarScreen::class.qualifiedName -> context.getString(R.string.tum_notlar)
                Destination.FavorilerScreen::class.qualifiedName -> context.getString(R.string.favoriler)
                else -> { Constants.EMPTY_STRING }
            }
        }
    }
    val gecerliViewModel = when (navBackStackEntry?.destination?.route) {
        Destination.NotlarScreen::class.qualifiedName -> notlarViewModel
        Destination.FavorilerScreen::class.qualifiedName -> favorilerViewModel
        else -> notlarViewModel
    }

    Scaffold(
        topBar = {
            MainToolbar(
                title = title,
                onClickSettings = {
                    mainNavController.navigate(Destination.AyarlarScreen) {
                        popUpTo(mainNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onClickInfo = {
                    mainNavController.navigate(Destination.HakkindaScreen) {
                        popUpTo(mainNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                onClickSiralama = {
                    gecerliViewModel.eventHandle(NotlarBaseEvent.ToggleSiralamaBolumu)
                }
            )
        },
        bottomBar = {
            MainBottomBar(subNavController = subNavController)
        },
        floatingActionButton = {
            CustomFAB(
                onClick = {
                    mainNavController.navigate(Destination.DuzenleScreen()) {
                        popUpTo(mainNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                imageVector = Icons.Default.Add,
            )
        }
    ) { padding ->

        val startDestination = when (baslangicSayfasi) {
            BaslangicSayfasi.Tum_Notlar -> Destination.NotlarScreen
            BaslangicSayfasi.Favoriler -> Destination.FavorilerScreen
        }

        NotlarNavHost(
            modifier = Modifier.padding(padding),
            mainNavController = mainNavController,
            subNavController = subNavController,
            startDestination = startDestination,
            context = context,
            notlarViewModel = notlarViewModel,
            favorilerViewModel = favorilerViewModel,
        )
    }
}
