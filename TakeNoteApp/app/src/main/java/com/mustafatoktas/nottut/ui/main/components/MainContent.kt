package com.mustafatoktas.nottut.ui.main.components

import android.content.Context
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.BaslangicSayfasi
import com.mustafatoktas.nottut.common.Constants
import com.mustafatoktas.nottut.common.sayfayaGit
import com.mustafatoktas.nottut.ui.favoriler.viewmodel.FavorilerViewModel
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseEvent
import com.mustafatoktas.nottut.ui.generalComponents.composables.CustomFAB
import com.mustafatoktas.nottut.ui.main.viewmodel.MainEvent
import com.mustafatoktas.nottut.ui.main.viewmodel.MainViewModel
import com.mustafatoktas.nottut.ui.navigation.Destination
import com.mustafatoktas.nottut.ui.navigation.NotlarNavHost
import com.mustafatoktas.nottut.ui.notlar.viewmodel.NotlarViewModel
import kotlin.math.roundToInt

@Composable
fun MainContent(
    mainNavController: NavHostController,
    subNavController: NavHostController,
    baslangicSayfasi: BaslangicSayfasi,
    context: Context,
    notlarViewModel: NotlarViewModel,
    favorilerViewModel: FavorilerViewModel,
    viewModel: MainViewModel,
) {
    val navBackStackEntry by subNavController.currentBackStackEntryAsState()
    val state = viewModel.state.value

    // Title güncelleme
    val title by remember {
        derivedStateOf {
            when (navBackStackEntry?.destination?.route) {
                Destination.NotlarScreen::class.qualifiedName -> context.getString(R.string.tum_notlar)
                Destination.FavorilerScreen::class.qualifiedName -> context.getString(R.string.favoriler)
                else -> Constants.EMPTY_STRING
            }
        }
    }

    // Geçerli ViewModel seçimi
    val gecerliViewModel = when (navBackStackEntry?.destination?.route) {
        Destination.NotlarScreen::class.qualifiedName -> notlarViewModel
        Destination.FavorilerScreen::class.qualifiedName -> favorilerViewModel
        else -> notlarViewModel
    }

    // Bottom bar ayarları (Dinamik Yükseklik)
    val density = LocalDensity.current
    val screenHeight = with(density) { LocalConfiguration.current.screenHeightDp.dp }
    val bottomBarHeight = screenHeight * 0.1f // Ekranın %10'u kadar bir yükseklik
    val bottomBarHeightPx = with(LocalDensity.current) { bottomBarHeight.roundToPx().toFloat() }
    val bottomBarOffsetHeightPx = remember { mutableStateOf(0f) }

    // Scroll bağlantısı
    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = bottomBarOffsetHeightPx.value + delta
                bottomBarOffsetHeightPx.value = newOffset.coerceIn(-bottomBarHeightPx, 0f)
                return Offset.Zero
            }
        }
    }

    Scaffold(
        modifier = Modifier.nestedScroll(nestedScrollConnection),
        topBar = {
            when (state.aramaAktifMi) {
                true -> NotlardaAra(
                    viewModel = viewModel,
                    state = state,
                    context = context,
                    mainNavController = mainNavController
                )
                false -> MainToolbar(
                    title = title,
                    onClickSettings = { mainNavController.sayfayaGit(Destination.AyarlarScreen) },
                    onClickInfo = { mainNavController.sayfayaGit(Destination.HakkindaScreen) },
                    onClickSiralama = {
                        if (notlarViewModel.state.value.notlar.isNotEmpty()) {
                            gecerliViewModel.eventHandle(NotlarBaseEvent.ToggleSiralamaBolumu)
                        }
                    },
                    onClickArama = {
                        viewModel.eventHandle(MainEvent.AramaAktifliginiDegistir(true))
                    }
                )
            }
        },
        bottomBar = {
            MainBottomBar(
                modifier = Modifier
                    .height(bottomBarHeight)
                    .offset {
                        IntOffset(
                            x = 0,
                            y = -bottomBarOffsetHeightPx.value.roundToInt()
                        )
                    },
                subNavController = subNavController,
            )
        },
        floatingActionButton = {
            CustomFAB(
                onClick = { mainNavController.sayfayaGit(Destination.DuzenleScreen()) },
                imageVector = Icons.Default.Add,
            )
        }
    ) { paddingValues ->
        val additionalPadding = if (bottomBarOffsetHeightPx.value == 0f) bottomBarHeight else 0.dp

        val paddingModifier = Modifier.padding(
            start = paddingValues.calculateStartPadding(LayoutDirection.Ltr),
            top = paddingValues.calculateTopPadding(),
            end = paddingValues.calculateEndPadding(LayoutDirection.Ltr),
            bottom = additionalPadding
        )

        val horizontalSwipeModifier = Modifier.pointerInput(Unit) {
            detectHorizontalDragGestures { change, dragAmount ->
                when {
                    dragAmount > 40F -> subNavController.sayfayaGit(Destination.NotlarScreen)
                    dragAmount < -40F -> subNavController.sayfayaGit(Destination.FavorilerScreen)
                }
                change.consume()
            }
        }

        NotlarNavHost(
            modifier = Modifier
                .then(horizontalSwipeModifier)
                .then(paddingModifier)
                .fillMaxSize(),
            mainNavController = mainNavController,
            subNavController = subNavController,
            startDestination = when (baslangicSayfasi) {
                BaslangicSayfasi.Tum_Notlar -> Destination.NotlarScreen
                BaslangicSayfasi.Favoriler -> Destination.FavorilerScreen
            },
            context = context,
            notlarViewModel = notlarViewModel,
            favorilerViewModel = favorilerViewModel,
        )
    }
}
