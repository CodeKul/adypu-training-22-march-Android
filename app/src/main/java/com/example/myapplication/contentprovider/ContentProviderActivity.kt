package com.example.myapplication.contentprovider


import android.content.ContentResolver
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.myapplication.R

class ContentProviderActivity : AppCompatActivity() {

    lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content_provider)

        listView = findViewById(R.id.listview)

        fetchContact()
    }


    private fun fetchContact(){
//        @RequiresPermission.Read @NonNull Uri uri,
//        @Nullable String[] projection, @Nullable String selection,
//        @Nullable String[] selectionArgs, @Nullable String sortOrder

        val list = ArrayList<String>()
        val uri:Uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        val projection:Array<String> = arrayOf<String>(
            ContactsContract.CommonDataKinds.Phone.NUMBER,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )
        val selection:String?=null
        val selectionArgs:Array<String> = emptyArray()
        val sortOrder:String? = null

        var contentResolver:ContentResolver = getContentResolver()

        val cursor :Cursor? = contentResolver.query(uri,projection,selection,selectionArgs,sortOrder)

        while(cursor?.moveToNext()!!){

            var name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
            var number = cursor.getInt(cursor.getColumnIndex( ContactsContract.CommonDataKinds.Phone.NUMBER))

            Log.i("android","name=>${name} Number=>${number}")
            list.add(name)
        }

        listView.setAdapter(ArrayAdapter<String>(this@ContentProviderActivity,android.R.layout.simple_list_item_1,list))
    }

}