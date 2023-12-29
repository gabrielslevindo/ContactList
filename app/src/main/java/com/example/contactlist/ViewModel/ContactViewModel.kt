package com.example.contactlist.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contactlist.Data.Contact
import com.example.contactlist.repository.repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ContactViewModel @Inject constructor(private val repository: repository) : ViewModel() {


    private val _allContacts = MutableStateFlow<MutableList<Contact>>(mutableListOf())
    private val allContacts: StateFlow<MutableList<Contact>> = _allContacts


    fun SaveContact(contactList: MutableList<Contact>) {


        viewModelScope.launch {


            repository.SaveContact(contactList)


        }


    }

    fun getCOntacts(): Flow<MutableList<Contact>> {

        viewModelScope.launch {


            repository.getContact.collect {


                _allContacts.value = it


            }


        }

        return allContacts


    }

    fun deletecontact(id: Int) {


        viewModelScope.launch {


            repository.deleteContact(id)


        }


    }

    fun updatecontact(id: String, name: String, surname: String, years: String, phone: String) {


        viewModelScope.launch {


            repository.updateContact(id, name, surname, years, phone)


        }


    }


}