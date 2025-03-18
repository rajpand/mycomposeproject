package com.nmictech.mycomposeproject.views.viewmodel


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DashboardViewModel : ViewModel() {
    private val _selectedTab = MutableStateFlow("home")
    val selectedTab = _selectedTab.asStateFlow()

    fun updateTab(tab: String) {
        _selectedTab.value = tab
    }
}
