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
    // Käytetään viewModel() funktiota ilman parametreja. Tämä liittää ViewModelin automaattisesti
    // nykyisen Activityn LifecycleOwneriin, jolloin saat jaettua ViewModelin koko sovelluksen laajuudessa.
    val viewModel: UserViewModel = viewModel()

    NavHost(navController = navController, startDestination = "firstScreen") {
        composable("firstScreen") {
            // Välitä viewModel komponenteille. Tässä tapauksessa sama viewModel-instanssi välitetään,
            // mikä tarkoittaa, että FirstScreen ja SecondScreen jakavat saman viewModelin.
            FirstScreen(navController = navController, viewModel = viewModel)
        }
        composable("secondScreen") {
            // Ei tarvetta luoda uutta viewModelia, koska haluamme käyttää samaa instanssia.
            SecondScreen(navController = navController, viewModel = viewModel)
        }
    }
}

