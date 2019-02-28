package com.example.a17164.contextprovider;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a17164.contextrovider.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  void OnClickAddName(View view){
        //add record
        ContentValues values=new ContentValues();//ContentValues类似于HashTable
        values.put(StudentProvider.NAME,(((EditText)findViewById(R.id.editText2)).getText().toString()));
        values.put(StudentProvider.GRADE,(((EditText)findViewById(R.id.editText3)).getText().toString()));
        Uri uri=getContentResolver().insert(StudentProvider.CONTENT_URI,values);
        Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_LONG).show();
    }

    public void onClickRetrieveStudents(View view){
        String URL="content://com.example.a17164.contextprovider.StudentProvider/students";
        Uri students=Uri.parse(URL);
        Cursor c=getContentResolver().query(students,null,null,null,"name");
        if(c.moveToFirst()){
            do{Toast.makeText(this,c.getString(c.getColumnIndex(StudentProvider._ID))+","+c.getString(c.getColumnIndex(StudentProvider.GRADE))
            +","+c.getString(c.getColumnIndex(StudentProvider.NAME)),Toast.LENGTH_SHORT).show();
            }while (c.moveToNext());
        }
    }
}
