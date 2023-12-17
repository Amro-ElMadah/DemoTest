package com.example.check24test.ui.main.presentation.view.screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.check24test.ui.main.presentation.viewmodel.Check24ViewModel
import com.example.check24test.ui.theme.Check24TestTheme

@Composable
fun Check24AppScreens(viewModel: Check24ViewModel) {
    var selectedItemId by remember { mutableStateOf<Int?>(null) }
    val isSystemInDarkTheme = isSystemInDarkTheme()
    var darkTheme by remember { mutableStateOf(isSystemInDarkTheme) }

    Check24TestTheme(darkTheme) {
        BackHandler(
            enabled = selectedItemId != null
        ) {
            selectedItemId = null
        }
        Column(
            Modifier.background(
                MaterialTheme.colorScheme.surface
            )
        ) {
            ThemeSwitch(darkTheme) {
                darkTheme = it
            }
            when {
                selectedItemId != null -> {
                    Check24DetailsScreen(viewModel, selectedItemId!!) {
                        selectedItemId = null
                    }
                }

                else -> {
                    Check24ListScreen(viewModel) { selectedRealEstate ->
                        selectedItemId = selectedRealEstate.id
                    }
                }
            }
        }
    }
}