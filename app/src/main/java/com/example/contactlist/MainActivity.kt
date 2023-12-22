package com.example.contactlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactlist.ui.theme.ContactListTheme
import com.example.contactlist.views.ContactList
import com.example.contactlist.views.SaveContacts
import com.example.contactlist.views.UpdatesContacts

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactListTheme {


                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "ContactList") {


                    composable("ContactList") {

                        ContactList(navController)

                    }
                    composable("SaveContact") {

                        SaveContacts(navController)

                    }
                    composable(
                        "UpdatesContacts/{id}",
                        arguments = listOf(navArgument("id"){})

                    ) {

                        UpdatesContacts(navController, it.arguments?.getString("id").toString())

                    }


                }


            }
        }
    }
}

