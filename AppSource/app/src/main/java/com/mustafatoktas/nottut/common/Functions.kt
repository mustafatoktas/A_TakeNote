package com.mustafatoktas.nottut.common

import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.pager.PagerState
import kotlin.math.absoluteValue

fun gecerliOffsetiHesapla(page: Int, pagerState: PagerState): Float {
    return (pagerState.currentPage - page + pagerState.currentPageOffsetFraction).absoluteValue
}

// yatay animasyonlar
fun mySlideInHorizontalyPozitif() = slideInHorizontally(initialOffsetX = {
    1000
}, animationSpec = tween(700)) + fadeIn()

fun mySlideInHorizontalyNegatif() = slideInHorizontally(initialOffsetX = {
    1000
}, animationSpec = tween(700)) + fadeIn()

fun mySlideOutHorizontalyPozitif() = slideOutHorizontally(targetOffsetX = {
    1000
}, animationSpec = tween(700)) + fadeOut()

fun mySlideOutHorizontalyNegatif() = slideOutHorizontally(targetOffsetX = {
    -1000
}, animationSpec = tween(700)) + fadeOut()

// dikey animasyonlar
fun mySlideInVerticallyPozitif() = slideInVertically(initialOffsetY = { 1000 }, animationSpec = tween(700)) + fadeIn()

fun mySlideInVerticallyNegatif() = slideInVertically(initialOffsetY = { -1000 }, animationSpec = tween(700)) + fadeIn()

fun mySlideOutVerticallyPozitif() = slideOutVertically(targetOffsetY = { 1000 }, animationSpec = tween(700)) + fadeOut()

fun mySlideOutVerticallyNegatif() = slideOutVertically(targetOffsetY = {
    -1000
}, animationSpec = tween(700)) + fadeOut()
