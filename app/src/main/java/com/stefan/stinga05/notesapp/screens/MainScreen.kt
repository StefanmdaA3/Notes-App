package com.stefan.stinga05.notesapp.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stefan.stinga05.notesapp.navigation.NavRoute

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(NavRoute.Add.route)
            }) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add icons",
                    tint = Color.White)
            }
        }
    ) {
        Column() {
            NoteItem(title = "Note 1", subtitle = "Subtitle for note 1", navController = navController)
            NoteItem(title = "Note 2", subtitle = "Subtitle for note 2", navController = navController)
            NoteItem(title = "Note 3", subtitle = "Subtitle for note 3", navController = navController)
            NoteItem(title = "Note 4", subtitle = "Subtitle for note 4", navController = navController)
            NoteItem(title = "Note 5", subtitle = "Subtitle for note 5", navController = navController)
            NoteItem(title = "Note 6", subtitle = "Subtitle for note 6", navController = navController)
            NoteItem(title = "Note 7", subtitle = "Subtitle for note 7", navController = navController)
        }
    }
}

@Composable
fun NoteItem(title: String, subtitle: String, navController: NavHostController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp)
            .clickable {
                navController.navigate(NavRoute.Note.route)
            },
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 24.sp,
                fontWeight = Bold
            )
            Text(text = subtitle)
        }
    }
}