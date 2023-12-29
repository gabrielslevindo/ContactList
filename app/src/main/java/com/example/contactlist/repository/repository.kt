package com.example.contactlist.repository

import com.example.contactlist.Data.Contact
import com.example.contactlist.Data.ContactDao
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@ViewModelScoped
class repository @Inject constructor(private val contactDao: ContactDao) {

      val getContact: Flow<MutableList<Contact>> = contactDao.getAll()

    suspend fun SaveContact(contactList: MutableList<Contact>){


        contactDao.insertAll(contactList)

    }


    suspend fun deleteContact(id: Int){

        contactDao.deleteById(id)

    }

    suspend fun updateContact(
       id: String,
        name: String,
        surname: String,
        years: String,
        phone: String ){

        contactDao.update(id,name,surname,years,phone)

    }






}