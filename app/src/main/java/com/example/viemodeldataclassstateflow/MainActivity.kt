package com.example.viemodeldataclassstateflow

import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.viemodeldataclassstateflow.ui.theme.VieModelDataClassStateFlowTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.viemodeldataclassstateflow.ui.theme.screens.FirstScreen
import com.example.viemodeldataclassstateflow.ui.theme.screens.SecondScreen
import com.example.viemodeldataclassstateflow.viewmodels.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            // Oletetaan, että FirstScreen ottaa viewModelin parametrina
            // Tämä on yleinen käytäntö, jotta voitaisiin käyttää samaa ViewModel-instanssia useissa Composables
            val viewModel: UserViewModel = viewModel()
            FirstScreen(navController = navController, viewModel = viewModel)
        }
        composable("secondScreen") {
            val viewModel: UserViewModel = viewModel()
            SecondScreen(navController = navController, viewModel = viewModel)
        }
    }
}
