package com.example.myapplication.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.myapplication.R
import com.example.myapplication.view.navhost.navigateSafe
import com.example.myapplication.view.theme.BlueSoft
import com.example.myapplication.view.theme.MyApplicationTheme
import com.example.myapplication.view.theme.White
import com.example.myapplication.viewmodel.SignInScreenViewModel

@Composable
fun SignInScreen(navController: NavController) {
    MyApplicationTheme {
        val signInViewModel: SignInScreenViewModel = viewModel()
        val customerId by signInViewModel.customerId.collectAsStateWithLifecycle()
        val password by signInViewModel.password.collectAsStateWithLifecycle()

        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(White)
                    .padding(innerPadding)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(bottom = 24.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .size(24.dp)
                            .clickable { navController.navigateSafe("home") },
                        imageVector = Icons.Outlined.ArrowBackIosNew,
                        tint = BlueSoft,
                        contentDescription = "Back Arrow"
                    )

                    Spacer(modifier = Modifier.width(16.dp))

                    Text(
                        text = stringResource(id = R.string.SingIn_Label),
                        style = MaterialTheme.typography.titleLarge.copy(fontSize = 22.sp),
                        color = BlueSoft,
                        fontWeight = FontWeight.Bold
                    )
                }

                SignInField(
                    label = stringResource(id = R.string.SignIn_CustomerID),
                    value = customerId,
                    onValueChange = { signInViewModel.onCustomerIdChange(it) },
                    isPassword = false
                )

                SignInField(
                    label = stringResource(id = R.string.SingIn_Password),
                    value = password,
                    onValueChange = { signInViewModel.onPasswordChange(it) },
                    isPassword = true
                )

                Text(
                    text = stringResource(id = R.string.SignIn_ForgotPassword),
                    color = BlueSoft,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier
                        .align(Alignment.End)
                        .clickable {}
                        .padding(bottom = 32.dp)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .clip(RoundedCornerShape(25.dp))
                        .background(BlueSoft)
                        .clickable { signInViewModel.signIn() },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = stringResource(id = R.string.SignIn_SignInButton),
                        color = White,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = stringResource(id = R.string.SignIn_DontHaveAccount),
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = stringResource(id = R.string.SignIn_CreateAccount),
                    color = BlueSoft,
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier
                        .clickable {},
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignInField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    isPassword: Boolean
) {
    OutlinedTextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label)
        },
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        shape = RoundedCornerShape(12.dp),
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = BlueSoft,
            focusedLabelColor = BlueSoft,
            cursorColor = BlueSoft
        )
    )
}
