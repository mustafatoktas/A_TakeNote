package com.mustafatoktas.nottut.domain.model

import androidx.compose.ui.graphics.vector.ImageVector
import com.mustafatoktas.nottut.ui.navigation.Destination

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val destination: Destination,
)
