package com.example.contactlist.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.comunidadedevspace.taskbeats.data.local.AppDataBase
import com.example.contactlist.Components.ButtonCustom
import com.example.contactlist.Components.OutlinedTextFielCustom
import com.example.contactlist.Data.Contact
import com.example.contactlist.Data.ContactDao
import com.example.contactlist.ui.theme.Purple500
import com.example.contactlist.ui.theme.White
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var DAO: ContactDao


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveContacts(navController: NavController) {

    val ContactList: MutableList<Contact> = mutableListOf()
    val scope = rememberCoroutineScope()

    val context = LocalContext.current

    var name by remember {
        mutableStateOf("")
    }
    var surname by remember {
        mutableStateOf("")
    }
    var years by remember {
        mutableStateOf("")
    }
    var telephone by remember {
        mutableStateOf("")
    }




    Scaffold(

        topBar = {

            TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(

                containerColor = Purple500


            ), title = {

                Text(
                    text = "Salvar Novo Contato",
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            })
        }


    ) {
        Column(

            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {


            OutlinedTextFielCustom(

                value = name,
                onValueChange = {

                name = it

            }, label = {

                Text(text = "Nome", color = Color.Gray)


            }, keyboardOptions = KeyboardOptions(

                keyboardType = KeyboardType.Text


            ), modifier = Modifier
                .padding(20.dp, 80.dp, 20.dp, 10.dp)
                .fillMaxWidth()
            )

            OutlinedTextFielCustom(
                value = surname,
                onValueChange = {

                    surname = it

                },
                label = { Text(text = "Sobrenome", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(

                    keyboardType = KeyboardType.Text


                ),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
                    .fillMaxWidth()
            )

            OutlinedTextFielCustom(
                value = years,
                onValueChange = {

                    years = it

                },
                label = { Text(text = "Idade", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(

                    keyboardType = KeyboardType.Number


                ),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
                    .fillMaxWidth()
            )

            OutlinedTextFielCustom(
                value = telephone,
                onValueChange = {

                    telephone = it

                },
                label = { Text(text = "Telefone", color = Color.Gray) },
                keyboardOptions = KeyboardOptions(

                    keyboardType = KeyboardType.Phone


                ),
                modifier = Modifier
                    .padding(20.dp, 0.dp, 20.dp, 10.dp)
                    .fillMaxWidth()
            )

            ButtonCustom(
                onClick = {

                    var mensage : Boolean = false




                    if (name.isEmpty() || surname.isEmpty() || years.isEmpty() || telephone.isEmpty()) {

                        mensage = false

                    } else {

                        mensage = true
                        scope.launch(Dispatchers.IO) {
                            val contact = Contact(name, surname, years, telephone)
                            ContactList.add(contact)
                            DAO = AppDataBase.getAppDataBaseInstance(context).contactDao()
                            DAO.insertAll(ContactList)


                        }


                        scope.launch(Dispatchers.Main){

                        if (mensage){

                            Toast.makeText(context,"Contato Salvo com Sucesso.", Toast.LENGTH_SHORT).show()
                            navController.navigate("ContactList")

                        }else{

                            Toast.makeText(context,"Preecha todos os Campos.", Toast.LENGTH_SHORT).show()


                        }




                        }

                    }


                },

                Text = "SALVAR CONTATO"
            )


        }

    }


}

@Composable
@Preview
fun SaveContactsPreview() {

    SaveContacts(navController = rememberNavController())

}