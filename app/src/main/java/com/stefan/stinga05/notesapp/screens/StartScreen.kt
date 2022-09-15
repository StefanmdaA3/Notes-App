package com.stefan.stinga05.notesapp.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.stefan.stinga05.notesapp.MainViewModel
import com.stefan.stinga05.notesapp.R
import com.stefan.stinga05.notesapp.navigation.NavRoute
import com.stefan.stinga05.notesapp.utils.LOGIN
import com.stefan.stinga05.notesapp.utils.PASSWORD
import com.stefan.stinga05.notesapp.utils.TYPE_FIREBASE
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun StartScreen(navController: NavHostController, viewModel: MainViewModel) {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()

    var login by remember { mutableStateOf("Login") }
    var password by remember { mutableStateOf("Password") }

    ModalBottomSheetLayout(
        sheetState = bottomSheetState,
        sheetElevation = 5.dp,
        sheetShape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
        sheetContent = {
            Surface {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 32.dp)
                ) {
                    Text(
                        text = stringResource(R.string.login),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )

                    OutlinedTextField(
                        value = login,
                        onValueChange = { login = it },
                        label = { Text(text = "Title") },
                        isError = login.isEmpty()
                    )

                    OutlinedTextField(
                        value = password,
                        onValueChange = { password = it },
                        label = { Text(text = "Title") },
                        isError = password.isEmpty()
                    )

                    Button(
                        modifier = Modifier.padding(top = 16.dp),
                        onClick = {
                            LOGIN = login
                            PASSWORD = password
                            viewModel.initDatabase(TYPE_FIREBASE) {
                            }
                        },
                        enabled = login.isNotEmpty() && password.isNotEmpty()
                    ) {
                        Text(text = "Sign In")
                    }
                }
            }
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(R.string.what_use))
                Button(
                    onClick = {
                        coroutineScope.launch {
                            bottomSheetState.show()
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(8.dp)
                ) {
                    Text(text = "Room Database")
                }

                Button(
                    onClick = {
                        viewModel.initDatabase(TYPE_FIREBASE) {
                            navController.navigate(route = NavRoute.Main.route)
                        }
                    },
                    modifier = Modifier
                        .width(200.dp)
                        .padding(8.dp)
                ) {
                    Text(text = stringResource(R.string.firebase))
                }
            }
        }
    }
}