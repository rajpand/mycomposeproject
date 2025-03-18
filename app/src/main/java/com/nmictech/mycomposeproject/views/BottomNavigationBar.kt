package com.nmictech.mycomposeproject.views

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.nmictech.mycomposeproject.R

@Composable
fun BottomNavigationBar(navController: NavController, notificationCount: Int? = null) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route

    BottomNavigation(
        modifier = Modifier
            .height(92.dp)
            .clip(RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp)),
        backgroundColor = colorResource(id = R.color.toolBarColor),
        contentColor = Color.White
    ) {
        Screen.allScreens.forEach { screen ->
            BottomNavigationItem(
                modifier = Modifier.weight(1f),

                icon = {
                    Box(
                        modifier = Modifier
                            .height(52.dp)
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        if (screen.route == "notifications" && (notificationCount ?: 0) > 0) {
                            BadgedBox(
                                badge = { TabBarBadgeView(count = notificationCount) }
                            ) {
                                Icon(
                                    modifier = Modifier.size(32.dp),
                                    painter = painterResource(id = screen.icon),
                                    contentDescription = screen.title
                                )
                            }
                        } else {
                            Icon(
                                modifier = Modifier.size(32.dp),
                                painter = painterResource(id = screen.icon),
                                contentDescription = screen.title
                            )
                        }
                    }

                }, selected = currentRoute == screen.route, onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}

@Composable
fun TabBarBadgeView(count: Int? = null) {
    if (count != null) {
        Badge {
            Text(count.toString())
        }
    }
}
