package com.example.contactlist.Data

import android.content.Context
import android.widget.Toast

class ContactManager(private val context: Context) {

    fun saveContactToFile(contact: Contact) {

        val contactData = "Nome: ${contact.name}\n" +
                "Sobrenome: ${contact.surname}\n" +
                "Idade: ${contact.years}\n" +
                "Telefoone: ${contact.phone}"



        try {

            val fileOutputStream = context.openFileOutput(
                "contact.txt", Context.MODE_PRIVATE
            )
            fileOutputStream.write(contactData.toByteArray())
            fileOutputStream.close()
            Toast.makeText(context, "Contato Salvo em txt", Toast.LENGTH_SHORT).show()
        } catch (e: Exception) {

            e.printStackTrace()

        }


    }


}