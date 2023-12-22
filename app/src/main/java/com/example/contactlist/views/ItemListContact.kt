package com.example.contactlist.views

import android.app.AlertDialog
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.comunidadedevspace.taskbeats.data.local.AppDataBase
import com.example.contactlist.Data.Contact
import com.example.contactlist.Data.ContactDao
import com.example.contactlist.R
import com.example.contactlist.ui.theme.White
import com.example.contactlist.ui.theme.shapesCardView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

private lateinit var DAO : ContactDao


@Composable
fun itemList(

    navController: NavController,
    position: Int,
    ContactList: MutableList<Contact>,
    context: Context

) {

    val scope=rememberCoroutineScope()

    val namev = ContactList[position].name
    val surnamev = ContactList[position].surname
    val yearsv = ContactList[position].years
    val phonev = ContactList[position].phone
    val id = ContactList[position].id


    val contact = ContactList[position]


    fun AlertDaialogDeleteContact() {

        val alertDialog = AlertDialog.Builder(context)
        alertDialog.setTitle("Deseja Excluir?")
            .setMessage("Tem Certeza?")
        alertDialog.setPositiveButton("Ok") { _, _ ->

            scope.launch(Dispatchers.IO) {

                DAO =AppDataBase.getAppDataBaseInstance(context).contactDao()
                DAO.deleteById(id)
                ContactList.remove(contact)
            }
            scope.launch(Dispatchers.Main) {

                navController.navigate("ContactList")

                Toast.makeText(context,"COntato Removido com Sucesso!", Toast.LENGTH_SHORT).show()


            }

        }
        alertDialog.setNegativeButton("Cancelar") { _, _ -> }
        alertDialog.show()


    }





    Card(

        colors = CardDefaults.cardColors(
            contentColor = White,
            containerColor = White,

            ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp
        ),
        shape = shapesCardView.medium,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 20.dp, 10.dp, 10.dp)

    ) {
        ConstraintLayout(

            modifier = Modifier.padding(20.dp)

        ) {

            val (name, years, phone, up, delete) = createRefs()

            Text(text = "Contato: $namev $surnamev",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(name) {


                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )

            Text(text = "Idade: $yearsv ",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(years) {


                    top.linkTo(name.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )
            Text(text = "Telefone: $phonev ",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.constrainAs(phone) {


                    top.linkTo(years.bottom, margin = 3.dp)
                    start.linkTo(parent.start, margin = 10.dp)


                }
            )
            Button(
                onClick = {

                    navController.navigate("UpdatesContacts/$id")

                },


                modifier = Modifier.constrainAs(up) {


                    start.linkTo(phone.end, margin = -5.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                }, colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = White
                )


            ) {


                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_mode_edit_24),
                    contentDescription = "Edit contac"
                )

            }
            Button(
                onClick = {


                          AlertDaialogDeleteContact()
                },


                modifier = Modifier.constrainAs(delete) {


                    start.linkTo(up.end, margin = -5.dp)
                    top.linkTo(parent.top, margin = 50.dp)
                }, colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                    containerColor = White
                )


            ) {


                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_delete_24),
                    contentDescription = "delete contac"
                )

            }


        }
    }


}



