package com.nmictech.mycomposeproject.views

import SearchScreen
import com.nmictech.mycomposeproject.views.screens.BrokenScreen
import com.nmictech.mycomposeproject.views.screens.HomeScreen
import com.nmictech.mycomposeproject.views.screens.ProfileScreen
import com.nmictech.mycomposeproject.views.screens.TabsScreen
import androidx.compose.runtime.Composable
import androidx.navigation.*
import androidx.navigation.compose.*


@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Add.route) {
        composable(Screen.Home.route) { HomeScreen() }
        composable(Screen.Search.route) { SearchScreen() }
        composable(Screen.Add.route) { TabsScreen() }
        composable(Screen.Notifications.route) { BrokenScreen() }
        composable(Screen.Profile.route) { ProfileScreen() }
    }
}
