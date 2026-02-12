package com.example.myapplication.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Album
import androidx.compose.material.icons.filled.DensityMedium
import androidx.compose.material.icons.outlined.Link
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.myapplication.R
import com.example.myapplication.view.navhost.navigateSafe
import com.example.myapplication.view.theme.*
import com.example.myapplication.viewmodel.HomeScreenViewModel
import kotlinx.coroutines.launch
import java.time.LocalTime

@Composable
fun HomeScreen(navController: NavController) {

    val homeViewModel: HomeScreenViewModel = viewModel()
    val currentColor by homeViewModel.titleColor.collectAsStateWithLifecycle()
    val currentVersion by homeViewModel.verNumber.collectAsStateWithLifecycle()

    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = true,
        drawerContent = {
            ModalDrawerSheet {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column (
                        modifier = Modifier.fillMaxWidth()
                            .weight(3f),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Row (
                            modifier = Modifier.fillMaxWidth()
                                .height(70.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text (
                                modifier = Modifier.clickable {
                                    scope.launch {
                                        drawerState.close()
                                        navController.navigateSafe("signin")
                                    }},
                                text = stringResource(id = R.string.Menu_SignIn),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )

                            Text (text = " " + stringResource(id = R.string.Menu_Or) + " ")

                            Text (modifier = Modifier.clickable {},
                                text = stringResource(id = R.string.Menu_CreateAccount),
                                style = TextStyle(
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                        }

                        HorizontalDivider (
                            modifier = Modifier.fillMaxWidth(0.85f)
                        )

                        Row (
                            modifier = Modifier.fillMaxWidth()
                                .height(70.dp)
                                .clickable {},
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(text = stringResource(id = R.string.Menu_CheckPay))
                        }
                    }

                    Column (
                        modifier = Modifier.fillMaxWidth()
                            .weight(1f)
                            .background(DimWhite),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        val labels = arrayOf(
                            stringResource(id = R.string.Menu_Settings),
                            stringResource(id = R.string.Menu_Terms),
                            stringResource(id = R.string.Menu_PriPolicy)
                        )
                        for (i in 0..2) {
                            Row (
                                modifier = Modifier.fillMaxWidth()
                                    .weight(1f)
                                    .clickable {},
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text (
                                    modifier = Modifier.padding(start = 10.dp),
                                    text = labels[i]
                                )
                                when (i) {
                                    2 -> Icon(
                                        modifier = Modifier.size(30.dp)
                                            .padding(start = 10.dp),
                                        imageVector = Icons.Outlined.Link,
                                        tint = Color.Black,
                                        contentDescription = "Link"
                                    )
                                }
                            }

                            HorizontalDivider (
                                modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                                color = White,
                                thickness = 2.dp
                            )
                        }

                        Row (
                            modifier = Modifier.fillMaxWidth()
                                .weight(1.5f)
                                .padding(bottom = 2.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon (
                                modifier = Modifier.padding(10.dp)
                                    .fillMaxHeight()
                                    .aspectRatio(1f),
                                imageVector = Icons.Filled.Album,
                                tint = BlueSoft,
                                contentDescription = "TFL Logo"
                            )

                            val ver = "${currentVersion[0]}.${currentVersion[1]}.${currentVersion[2]}"

                            Text (
                                modifier = Modifier.padding(end = 10.dp),
                                text = "${stringResource(id = R.string.Menu_Tfl)} v$ver"
                            )
                        }
                    }
                }
            }
        }
    ) {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column (
                modifier = Modifier.fillMaxSize()
                    .background(color = BlueSoft)
                    .padding(innerPadding),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clickable { scope.launch { drawerState.open() } },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Filled.DensityMedium,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(40.dp)
                    )
                }

                Column (
                    Modifier.fillMaxWidth()
                        .padding(20.dp)
                ) {
                    val timeHour = remember { LocalTime.now().hour }
                    val message = when (timeHour) {
                        in 0..6 -> stringResource(id = R.string.Home_HelloText_Night)
                        in 7..11 -> stringResource(id = R.string.Home_HelloText_Morning)
                        in 12..17 -> stringResource(id = R.string.Home_HelloText_Afternoon)
                        in 18..23 -> stringResource(id = R.string.Home_HelloText_Evening)
                        else -> stringResource(id = R.string.Home_HelloText_Other)
                    }

                    Text (
                        text = message,
                        style = MaterialTheme.typography.titleLarge,
                        color = currentColor
                    )

                    Row (
                        modifier = Modifier.fillMaxWidth()
                            .padding(top = 8.dp)
                            .clickable { navController.navigate("signin") },
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text (
                            text = stringResource(id = R.string.Home_SignInLabel),
                            style = MaterialTheme.typography.labelSmall,
                            color = White,
                            modifier = Modifier.weight(1f)
                        )

                        Icon (
                            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                            contentDescription = "Sign In",
                            tint = White,
                            modifier = Modifier.size(24.dp)
                        )
                    }
                }

                Row (
                    modifier = Modifier.fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    for (i in 1..2) {
                        Box (
                            modifier = Modifier.height(40.dp)
                                .weight(1f)
                                .clip(RoundedCornerShape(20.dp))
                                .background(White)
                                .clickable {},
                            contentAlignment = Alignment.Center
                        ) {
                            Text (
                                text = when (i) {
                                    1 -> stringResource(id = R.string.Home_LowerButton_1)
                                    2 -> stringResource(id = R.string.Home_LowerButton_2)
                                    else -> "None"
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
