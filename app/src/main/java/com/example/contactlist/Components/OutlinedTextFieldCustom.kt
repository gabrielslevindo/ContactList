package com.example.contactlist.Components


import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.contactlist.ui.theme.Purple500

@Composable
fun OutlinedTextFielCustom(
    value: String,
    onValueChange: (String) -> Unit,
    label: @Composable () -> Unit,
    keyboardOptions: KeyboardOptions,
    modifier: Modifier
) {


    OutlinedTextField(

        value,
        onValueChange,
        label = label,
        keyboardOptions = keyboardOptions,
        modifier = modifier,

        colors = TextFieldDefaults.outlinedTextFieldColors(

            cursorColor = Purple500,
            focusedBorderColor = Purple500,
            focusedLabelColor = Purple500,
            textColor = Color.Gray

        ),
        textStyle = TextStyle(fontSize = 18.sp),
        maxLines = 1,
        singleLine = true
    )


}