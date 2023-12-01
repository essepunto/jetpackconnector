package ru.essepunto.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import ru.essepunto.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) {
        NavigationGraph(navController = navController)
    }
}

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "screen1") {
        composable("screen1") { Screen1() }
        composable("screen2") { Screen2() }
        composable("screen3") { Screen3() }
        composable("screen4") { Screen4() }
        composable("screen5") { Screen5() }
    }
}

@Composable
fun BottomNavigationBar(navController: NavHostController) {
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
    BottomNavigation(
        backgroundColor = Color.Black,
        contentColor = Color.White
    ) {
        BottomNavigationItem(
            selected = currentRoute == "screen1",
            onClick = { navController.navigate("screen1") },
            icon = {
                Icon(
                    Icons.Filled.Home,
                    contentDescription = "Screen 1",
                    tint = if (currentRoute == "screen1") Color.Green else Color.White,
                    modifier = if (currentRoute == "screen1") Modifier.size(40.dp) else Modifier.size(24.dp)
                )
            }
        )
        BottomNavigationItem(
            selected = currentRoute == "screen",
            onClick = { navController.navigate("screen4") },
            icon = {
                Icon(
                    Icons.Filled.Favorite,
                    contentDescription = "Screen 4",
                    tint = if (currentRoute == "screen4") Color.Red else Color.White,
                    modifier = if (currentRoute == "screen4") Modifier.size(40.dp) else Modifier.size(24.dp)
                )
            }
        )
        BottomNavigationItem(
            selected = currentRoute == "screen5",
            onClick = { navController.navigate("screen5") },
            icon = {
                Icon(
                    Icons.Filled.Settings,
                    contentDescription = "Screen 5",
                    tint = if (currentRoute == "screen5") Color.Green else Color.White,
                    modifier = if (currentRoute == "screen5") Modifier.size(40.dp) else Modifier.size(24.dp)
                )
            }
        )
    }
}

@Composable
fun Screen1() {
    Text(text = "Screen 1 Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun Screen2() {
    Text(text = "Screen 2 Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun Screen3() {
    Text(text = "Screen 3 Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun Screen4() {
    Text(text = "Screen 4 Content", modifier = Modifier.padding(16.dp))
}

@Composable
fun Screen5() {
    Text(text = "Screen 5 Content", modifier = Modifier.padding(16.dp))
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MainScreen()
    }
}
