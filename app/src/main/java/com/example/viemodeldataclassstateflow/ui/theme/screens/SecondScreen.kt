package com.example.viemodeldataclassstateflow.ui.theme.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.navigation.NavController
import com.example.viemodeldataclassstateflow.viewmodels.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SecondScreen(navController: NavController, viewModel: UserViewModel = viewModel()) {
    val user = viewModel.userInfo.collectAsState().value

    Log.d("SecondScreen", "Näytettävä käyttäjä: ${user?.name}, ${user?.age}, ${user?.email}")

    Column {
        Text("Nimi: ${user?.name ?: ""}")
        Text("Ikä: ${user?.age ?: ""}")
        Text("Sähköposti: ${user?.email ?: ""}")
        Button(onClick = { navController.popBackStack() }) {
            Text("Takaisin")
        }
    }
}