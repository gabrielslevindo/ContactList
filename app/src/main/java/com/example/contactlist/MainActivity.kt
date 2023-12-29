package com.example.contactlist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.contactlist.ViewModel.ContactViewModel
import com.example.contactlist.ui.theme.ContactListTheme
import com.example.contactlist.views.ContactList
import com.example.contactlist.views.SaveContacts
import com.example.contactlist.views.UpdatesContacts
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ContactListTheme {


                val navController = rememberNavController()
                val viewModel: ContactViewModel = hiltViewModel()

                NavHost(navController = navController, startDestination = "ContactList") {


                    composable("ContactList") {

                        ContactList(navController, viewModel)

                    }
                    composable("SaveContact") {

                        SaveContacts(navController, viewModel)

                    }
                    composable(
                        "UpdatesContacts/{id}",
                        arguments = listOf(navArgument("id"){})

                    ) {

                        UpdatesContacts(navController, it.arguments?.getString("id").toString(), viewModel)

                    }


                }


            }
        }
    }
}

