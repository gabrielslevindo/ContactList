package com.example.contactlist.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.contactlist.ui.theme.Purple500
import com.example.contactlist.ui.theme.White

@Composable
fun ButtonCustom(onClick: () -> Unit, Text: String) {


    Button(
        onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
            .height(50.dp),
        colors = ButtonDefaults.buttonColors(

            backgroundColor = Purple500, contentColor = White

        )

    ) {

        androidx.compose.material.Text(
            text = Text, fontSize = 18.sp, fontWeight = FontWeight.Bold
        )

    }


}
@Preview
@Composable
fun pewview(){

    ButtonCustom(onClick = { /*TODO*/ }, Text = "")


}