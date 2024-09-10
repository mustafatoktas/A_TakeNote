package com.mustafatoktas.nottut.ui.generalComponents.composables

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.mustafatoktas.nottut.domain.model.Note
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseEvent
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseState
import com.mustafatoktas.nottut.ui.generalComponents.NotlarBaseViewModel
import com.mustafatoktas.nottut.ui.navigation.Destination

@Composable
fun NotlarContent(
    context: Context,
    state: NotlarBaseState,
    mainNavController: NavHostController,
    onSilClick: (Note) -> Unit,
    viewModel: NotlarBaseViewModel,
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        AnimatedVisibility(
            visible = state.siralamaBolumuGorunurMu,
            enter = fadeIn() + slideInVertically(),
            exit = fadeOut() + slideOutVertically()
        ) {
            OrderSection(
                context = context,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                notSiralamasi = state.notSiralamasi,
                onOrderChange = { notSiralamasi ->
                    viewModel.eventHandle(NotlarBaseEvent.Siralama(notSiralamasi))
                }
            )
        }
        LazyVerticalStaggeredGrid(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 3.dp),
            columns = StaggeredGridCells.Adaptive(160.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            items(
                items = state.notlar,
                key = { it.id!! } //
            ) {
                NoteCard(
                    note = it,
                    onEditClick = {
                        mainNavController.navigate(
                            Destination.DuzenleScreen(noteIdParam = it.id!!, duzenlemeAktifOlacakMiParam = true)
                        ) {
                            popUpTo(mainNavController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    },
                    onSilClick = { note ->
                        onSilClick(note)
                    },
                    onOpenClick = {
                        mainNavController.navigate(
                            Destination.DuzenleScreen(noteIdParam = it.id!!)
                        ) {
                            popUpTo(mainNavController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(80.dp))
            }
        }
    }
}
