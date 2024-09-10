package com.mustafatoktas.nottut.ui.navigation

import kotlinx.serialization.Serializable

sealed class Graph {

    @Serializable
    data object MainGraph : Graph()

    @Serializable
    data object NotlarGraph : Graph()
}

sealed class Destination {

    @Serializable
    data object MainScreen : Destination()

    @Serializable
    data object AyarlarScreen : Destination()

    @Serializable
    data object NotlarScreen : Destination()

    @Serializable
    data object FavorilerScreen : Destination()

    @Serializable
    data object HakkindaScreen : Destination()

    @Serializable
    data class DuzenleScreen(
        val noteIdParam: Int = -1,
        val duzenlemeAktifOlacakMiParam: Boolean = false
    ) : Destination()
}
