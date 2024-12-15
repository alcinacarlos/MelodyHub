package com.alcinacarlos.melodyhub.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Password
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alcinacarlos.melodyhub.R

@Composable
fun Email(
    email: String,
    emailError: Boolean,
    onTextChanged: (String) -> Unit,
    focusRequester: FocusRequester
) {

    var isFocused by remember { mutableStateOf(false) }

    BoxLogin(
        isFocused = isFocused,
        isError = emailError,
        modifier = Modifier
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .focusRequester(focusRequester)
    ) {
        OutlinedTextField(
            value = email,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .focusRequester(focusRequester),
            label = {
                Text(
                    text = stringResource(R.string.email),
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.white)
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "Email",
                    tint = colorResource(id = R.color.naranja)
                )
            },
            shape = RoundedCornerShape(15.dp),
            colors = coloresCampos()
        )
    }
    if (emailError){
        Text(
            text = "Introduce un emal válido",
            color = Color.Red
        )
    }

}

@Composable
fun Password(
    password: String,
    passwordError: Boolean,
    isPasswordVisible: Boolean,
    onPasswordVisibility: () -> Unit,
    onTextChanged: (String) -> Unit,
    focusRequester: FocusRequester
) {

    var isFocused by remember { mutableStateOf(false) }

    BoxLogin(
        isFocused = isFocused,
        isError = passwordError,
        modifier = Modifier
            .onFocusChanged { focusState ->
                isFocused = focusState.isFocused
            }
            .focusRequester(focusRequester)
    ) {
        OutlinedTextField(
            value = password,
            onValueChange = { onTextChanged(it) },
            modifier = Modifier
                .fillMaxWidth()
                .onFocusChanged { focusState ->
                    isFocused = focusState.isFocused
                }
                .focusRequester(focusRequester),
            label = {
                Text(
                    text = stringResource(R.string.password),
                    fontWeight = FontWeight.Medium,
                    color = colorResource(R.color.white)
                )
            },
            maxLines = 1,
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Rounded.Password,
                    contentDescription = "Email",
                    tint = colorResource(id = R.color.naranja)
                )
            },
            trailingIcon = {
                IconButton(
                    onClick = { onPasswordVisibility() }) {
                    Icon(
                        imageVector = if (isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = "Ocultar contraseña"
                    )
                }
            },
            visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            shape = RoundedCornerShape(15.dp),
            colors = coloresCampos()
        )
    }
    if (passwordError){
        Text(
            text = "La contraseña tiene que tener más de 6 caracteres",
            color = Color.Red
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun coloresCampos() = TextFieldDefaults.outlinedTextFieldColors(
    focusedBorderColor = Color.Transparent,
    unfocusedBorderColor = Color.Transparent,
    focusedTextColor = Color.White,
    unfocusedTextColor = Color.White
)

@Composable
fun BoxLogin(
    isFocused: Boolean,
    isError: Boolean,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    val gradientColors = if (!isError) {
        listOf(
            colorResource(R.color.naranja),
            colorResource(R.color.naranja)
        )
    } else {
        listOf(Color.Red, Color.Red)
    }
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(15.dp))
            .background(colorResource(R.color.grayblack))
            .drawBehind {
                if (isFocused || isError) {
                    val strokeWidth = 3.dp.toPx()
                    val offset = strokeWidth / 2
                    val gradient = Brush.linearGradient(gradientColors)
                    drawRoundRect(
                        brush = gradient,
                        topLeft = Offset(offset, offset),
                        size = Size(size.width - strokeWidth, size.height - strokeWidth),
                        cornerRadius = CornerRadius(15.dp.toPx()),
                        style = Stroke(width = strokeWidth)
                    )
                }
            }
            .padding(6.dp)
    ) {
        content()
    }
}

@Composable
fun KeepLoggedInCheckbox(
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    focusRequester: FocusRequester
) {
    val isFocused = remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .focusRequester(focusRequester)
            .onFocusChanged { focusState ->
                isFocused.value = focusState.isFocused
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = { newValue ->
                onCheckedChange(newValue)
            },
            colors = CheckboxDefaults.colors(
                checkedColor = colorResource(R.color.naranja),
                uncheckedColor = Color.White
            )
        )
        Text(
            text = stringResource(id = R.string.keep_logged_in),
            fontSize = 17.sp,
            fontWeight = FontWeight.SemiBold,
            color = colorResource(id = R.color.white)
        )

    }
}

@Composable
fun LoginButton(
    onClick: () -> Unit,
    enabled: Boolean
) {
    Spacer(modifier = Modifier.height(20.dp))
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonColors(
            contentColor = colorResource(R.color.white),
            containerColor = colorResource(R.color.naranja),
            disabledContainerColor = colorResource(R.color.naranja2),
            disabledContentColor = colorResource(R.color.white)
        ),
        modifier = Modifier
            .size(100.dp)
    ) {
        Icon(
            modifier = Modifier.size(35.dp),
            imageVector = Icons.AutoMirrored.Filled.ArrowForward,
            contentDescription = "Arrow",
            tint = colorResource(R.color.white)
        )
    }
}

@Composable
fun WelcomeText(
    text: String
) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(20.dp))
}

@Composable
fun FooterButton(
    question: String,
    text: String,
    onClickSignIn: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = question,
            color = colorResource(R.color.white),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium
        )
        Text(
            text = text,
            color = colorResource(R.color.naranja),
            fontSize = 15.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.clickable {
                onClickSignIn()
            }
        )
    }
}