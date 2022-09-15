package com.stefan.stinga05.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stefan.stinga05.notesapp.MainViewModel
import com.stefan.stinga05.notesapp.screens.AddScreen
import com.stefan.stinga05.notesapp.screens.MainScreen
import com.stefan.stinga05.notesapp.screens.NoteScreen
import com.stefan.stinga05.notesapp.screens.StartScreen
import com.stefan.stinga05.notesapp.utils.Constants.Screens.ADD_SCREEN
import com.stefan.stinga05.notesapp.utils.Constants.Screens.MAIN_SCREEN
import com.stefan.stinga05.notesapp.utils.Constants.Screens.NOTE_SCREEN
import com.stefan.stinga05.notesapp.utils.Constants.Screens.START_SCREEN

sealed class NavRoute(val route: String) {
    object Start : NavRoute(START_SCREEN)
    object Main : NavRoute(MAIN_SCREEN)
    object Add : NavRoute(ADD_SCREEN)
    object Note : NavRoute(NOTE_SCREEN)
}

@Composable
fun NotesNavHost(mainViewModel: MainViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavRoute.Start.route) {
        composable(NavRoute.Start.route) {
            StartScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(NavRoute.Main.route) {
            MainScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(NavRoute.Add.route) {
            AddScreen(navController = navController, viewModel = mainViewModel)
        }
        composable(NavRoute.Note.route + "/{id}") { backStackEntry ->
            NoteScreen(navController = navController, viewModel = mainViewModel, noteId =
            backStackEntry.arguments?.getString("id"))
        }
    }
}