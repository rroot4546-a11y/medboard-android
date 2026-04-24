package com.rroot.medboard.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

object Routes {
    const val HOME = "home"
    const val SPECIALTY = "specialty/{specialtyId}"
    const val TOPIC = "topic/{topicId}"
    const val SEARCH = "search"
    const val DISCLAIMER = "disclaimer"

    fun specialty(id: String) = "specialty/$id"
    fun topic(id: String) = "topic/$id"
}

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Routes.HOME) {
        composable(Routes.HOME) {
            HomeScreen(
                onSpecialty = { navController.navigate(Routes.specialty(it)) },
                onSearch = { navController.navigate(Routes.SEARCH) },
                onDisclaimer = { navController.navigate(Routes.DISCLAIMER) },
            )
        }
        composable(
            Routes.SPECIALTY,
            arguments = listOf(navArgument("specialtyId") { type = NavType.StringType }),
        ) { entry ->
            val id = entry.arguments?.getString("specialtyId").orEmpty()
            SpecialtyScreen(
                specialtyId = id,
                onTopic = { navController.navigate(Routes.topic(it)) },
                onBack = { navController.popBackStack() },
            )
        }
        composable(
            Routes.TOPIC,
            arguments = listOf(navArgument("topicId") { type = NavType.StringType }),
        ) { entry ->
            val id = entry.arguments?.getString("topicId").orEmpty()
            TopicScreen(
                topicId = id,
                onBack = { navController.popBackStack() },
            )
        }
        composable(Routes.SEARCH) {
            SearchScreen(
                onTopic = { navController.navigate(Routes.topic(it)) },
                onBack = { navController.popBackStack() },
            )
        }
        composable(Routes.DISCLAIMER) {
            DisclaimerScreen(onBack = { navController.popBackStack() })
        }
    }
}
