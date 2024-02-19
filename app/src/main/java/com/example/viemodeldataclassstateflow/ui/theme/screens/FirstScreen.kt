package com.example.viemodeldataclassstateflow.ui.theme.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import com.example.viemodeldataclassstateflow.viewmodels.UserViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun FirstScreen(navController: NavController, viewModel: UserViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    Column {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Nimi") })
        TextField(value = age, onValueChange = { age = it }, label = { Text("Ikä") })
        TextField(value = email, onValueChange = { email = it }, label = { Text("Sähköposti") })
        Button(onClick = {
            viewModel.saveUser(name, age, email)
            navController.navigate("secondScreen")
        }) {
            Text("Tallenna ja jatka")
        }
    }
}
