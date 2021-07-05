package com.mahmouddev.implicitintentsample.utils

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.provider.ContactsContract
import java.io.ByteArrayOutputStream

object ContactHelper {


    fun Activity.openContactScreen(
        name: String? = null,
        email: String? = null,
        address: String? = null,
        number: String?,
        bitmap: Bitmap? = null
    ) {
        val intent = Intent(
            ContactsContract.Intents.Insert.ACTION,
            ContactsContract.Contacts.CONTENT_LOOKUP_URI
        ).apply {
            type = ContactsContract.RawContacts.CONTENT_TYPE

            putExtra(
                ContactsContract.Intents.Insert.NAME,
                name
            )
            putExtra(
                ContactsContract.Intents.Insert.EMAIL,
                email
            )
            putExtra(
                ContactsContract.Intents.Insert.EMAIL_TYPE,
                ContactsContract.CommonDataKinds.Email.TYPE_HOME
            )
            putExtra(ContactsContract.Intents.Insert.PHONE, number)

            putExtra(ContactsContract.Intents.Insert.POSTAL, address)

            putExtra(ContactsContract.Intents.Insert.PHONE_TYPE, ContactsContract.CommonDataKinds.Phone.TYPE_WORK)

        }
        if (bitmap != null)
            intent.putParcelableArrayListExtra(
                ContactsContract.Intents.Insert.DATA,
                setImage(bitmap)
            )

        startActivity(intent)
    }


    private fun setImage(bitmap: Bitmap): ArrayList<ContentValues> {


        val data = ArrayList<ContentValues>()

        val row = ContentValues()
        row.put(
            ContactsContract.Contacts.Data.MIMETYPE,
            ContactsContract.CommonDataKinds.Photo.CONTENT_ITEM_TYPE
        )
        row.put(
            ContactsContract.CommonDataKinds.Photo.PHOTO,
            bitmapToByteArray(bitmap)
        )
        data.add(row)
        return data
    }

    private fun bitmapToByteArray(bitmap: Bitmap): ByteArray {
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
        return stream.toByteArray()
    }

}