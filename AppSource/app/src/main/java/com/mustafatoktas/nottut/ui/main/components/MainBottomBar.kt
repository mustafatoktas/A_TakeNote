package com.mustafatoktas.nottut.ui.main.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.mustafatoktas.nottut.R
import com.mustafatoktas.nottut.domain.model.BottomNavigationItem
import com.mustafatoktas.nottut.ui.navigation.Destination

@Composable
fun MainBottomBar(
    subNavController: NavHostController,
) {
    val context = LocalContext.current
    var selectedItemIndex by rememberSaveable { mutableStateOf(0) }
    val navBackStackEntry by subNavController.currentBackStackEntryAsState()

    val bottomItems = listOf(
        BottomNavigationItem(
            title = context.getString(R.string.tum_notlar),
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            destination = Destination.NotlarScreen
        ),
        BottomNavigationItem(
            title = context.getString(R.string.favoriler),
            selectedIcon = Icons.Filled.Bookmark,
            unselectedIcon = Icons.Outlined.BookmarkBorder,
            destination = Destination.FavorilerScreen
        ),
    )

    LaunchedEffect(navBackStackEntry) {
        when (navBackStackEntry?.destination?.route) {
            Destination.NotlarScreen::class.qualifiedName -> selectedItemIndex = 0
            Destination.FavorilerScreen::class.qualifiedName -> selectedItemIndex = 1
        }
    }

    NavigationBar {
        bottomItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    selectedItemIndex = index
                    subNavController.navigate(item.destination) {
                        popUpTo(subNavController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                label = {
                    Text(text = item.title)
                },
                alwaysShowLabel = true,
                icon = {
                    Icon(
                        imageVector = if (index == selectedItemIndex) item.selectedIcon else item.unselectedIcon,
                        contentDescription = item.title,
                    )
                }
            )
        }
    }
}
