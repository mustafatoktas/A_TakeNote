package com.mustafatoktas.nottut.ui.hakkinda

import android.annotation.SuppressLint
import android.content.Context
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.fontscaling.MathUtils.lerp
import androidx.navigation.NavHostController
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.common.gecerliOffsetiHesapla
import com.mustafatoktas.nottut.ui.hakkinda.components.DialogLibrariesInfo
import com.mustafatoktas.nottut.ui.hakkinda.components.PageBilgi
import com.mustafatoktas.nottut.ui.hakkinda.components.PageKutuphaneler
import com.mustafatoktas.nottut.ui.hakkinda.viewmodel.HakkindaViewModel
import kotlinx.coroutines.launch
import kotlin.math.absoluteValue

@SuppressLint("RestrictedApi")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HakkindaScreen(
    mainNavController: NavHostController,
    context: Context,
    viewModel: HakkindaViewModel,
) {
    val state = viewModel.state.value
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { 2 })
    val scope = rememberCoroutineScope()
    var dialogLibrariesInfo by remember { mutableStateOf(false) }

    BackHandler(
        enabled = pagerState.currentPage == 1,
    ) {
        scope.launch {
            pagerState.animateScrollToPage(0)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(context.getString(R.string.not_tut_hakkında))
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            mainNavController.navigateUp()
                        }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBackIos, contentDescription = null)
                    }
                },
                actions = {
                    if (pagerState.currentPage == 1) {
                        IconButton(
                            onClick = {
                                dialogLibrariesInfo = true
                            }
                        ) {
                            Icon(imageVector = Icons.Outlined.Info, contentDescription = null)
                        }
                    }
                }
            )
        },
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            TabRow(
                selectedTabIndex = pagerState.currentPage,
                modifier = Modifier.fillMaxWidth()
            ) {
                val tabs = listOf(
                    context.getString(R.string.bilgi),
                    context.getString(R.string.kutuphaneler)
                )

                tabs.forEachIndexed { index, title ->
                    Tab(
                        text = { Text(title) },
                        selected = pagerState.currentPage == index,
                        onClick = {
                            scope.launch {
                                pagerState.animateScrollToPage(index)
                            }
                        }
                    )
                }
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .fillMaxSize()
            ) { page ->
                val pageOffset = gecerliOffsetiHesapla(page, pagerState)
                val scale = lerp(0.85f, 1f, 1f - pageOffset.absoluteValue)
                val alpha = lerp(0.5f, 1f, 1f - pageOffset.absoluteValue)

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .graphicsLayer {
                            scaleX = scale
                            scaleY = scale
                            this.alpha = alpha
                        }
                        .background(MaterialTheme.colorScheme.surfaceVariant),
                    contentAlignment = Alignment.Center
                ) {
                    when (page) {
                        0 -> {
                            PageBilgi(
                                context = context,
                                versionNumber = state.versiyon,
                                isletimSistemi = state.isletimSistemi,
                                telefonModeli = state.telefonModeli
                            )
                        }
                        1 -> PageKutuphaneler(context = context)
                        else -> {}
                    }
                }
            }
        }
    }

    if (dialogLibrariesInfo) {
        DialogLibrariesInfo(
            context = context,
            onDismiss = { dialogLibrariesInfo = false }
        )
    }
}
