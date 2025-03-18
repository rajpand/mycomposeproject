package com.nmictech.mycomposeproject.views

import com.nmictech.mycomposeproject.R

sealed class Screen(val route: String, val title: String, val icon: Int) {
    object Home : Screen("home", "Home", R.drawable.icons8_home_96)
    object Search : Screen("search", "Search", R.drawable.icons_search)
    object Add : Screen("add", "Add", R.drawable.outline_add_circle_24)
    object Notifications : Screen("notifications", "Notifications", R.drawable.outline_3p_24)
    object Profile : Screen("Profile", "Profile", R.drawable.icons8_person_100)

    companion object {
        val allScreens = listOf(Home, Search, Add, Notifications, Profile)
    }
}
