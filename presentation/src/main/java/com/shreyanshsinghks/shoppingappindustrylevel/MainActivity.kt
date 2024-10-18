package com.shreyanshsinghks.shoppingappindustrylevel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.shreyanshsinghks.shoppingappindustrylevel.feature.home.HomeScreen
import com.shreyanshsinghks.shoppingappindustrylevel.ui.theme.ShoppingAppIndustryLevelTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ShoppingAppIndustryLevelTheme {
                val navController = rememberNavController()
                Scaffold { innerPadding ->
                    Surface(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "home") {
                            composable("home") {
                                HomeScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {

}

//sealed class BottomNavItems(val route: String, val title: String, val icon: Int) {
//    object Home : BottomNavItems("home", "Home", R.drawable.ic_home)
//    object Cart : BottomNavItems("cart", "Cart", R.drawable.ic_cart)
//    object Profile : BottomNavItems("profile", "Profile", R.drawable.ic_profile)
//}