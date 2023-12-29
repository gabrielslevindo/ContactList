package com.example.contactlist.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.comunidadedevspace.taskbeats.data.local.AppDataBase
import com.example.contactlist.Data.Contact
import com.example.contactlist.Data.ContactDao
import com.example.contactlist.R
import com.example.contactlist.ViewModel.ContactViewModel
import com.example.contactlist.ui.theme.Purple500
import com.example.contactlist.ui.theme.White
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@SuppressLint("CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContactList(navController: NavController, viewModel: ContactViewModel = hiltViewModel()) {


    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val contacList = viewModel.getCOntacts().collectAsState(mutableListOf()).value


    Scaffold(

        topBar = {

            TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(

                containerColor = Purple500


            ), title = {

                Text(
                    text = "Lista de Contatos",
                    color = White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )
            })
        }, floatingActionButton = {

            FloatingActionButton(
                onClick = {


                    navController.navigate("SaveContact")


                },
                containerColor = Purple500,
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 8.dp),
                shape = CircleShape
            ) {

                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.baseline_add_24),
                    contentDescription = "Save Icon"
                )

            }


        }


    ) {


        Column(

            modifier = Modifier.padding(it)

        ) {

            LazyColumn() {


                // Os itens esperam uma lambda com o item e com o position
                itemsIndexed(contacList) { position, item ->

                    itemList(navController, position, contacList, context, viewModel)


                }


            }


        }
    }


}

@Composable
@Preview
fun ContactListPreview() {

    ContactList(navController = rememberNavController(), viewModel = hiltViewModel())

}