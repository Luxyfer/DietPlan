package com.bright.dietplan;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class User extends AppCompatActivity {
    DataBaseHelper db;
    EditText editnome, editdtnasc, editpeso;
    Button guardar;
    RadioButton Rmasc, Rfem;
    public String sexo;
    CheckBox Cgluten, Clactose;
    public int gluten = 0, lactose = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        db = new DataBaseHelper(this);

        //EditText
        editnome =(EditText)findViewById(R.id.nome);
        editdtnasc = (EditText)findViewById(R.id.dtnasc);
        editpeso = (EditText)findViewById(R.id.peso);

        //Botão
        guardar = (Button)findViewById(R.id.Guardar);

        //RadioButton
        Rmasc = (RadioButton)findViewById(R.id.masc);
        Rfem = (RadioButton) findViewById(R.id.fem);
        if(Rmasc.isChecked())
            sexo = "masculino";
        else
            sexo = "feminino";
        //CheckBox
        Cgluten = (CheckBox)findViewById(R.id.checkBox);
        Clactose = (CheckBox)findViewById(R.id.checkBox2);
        if(Cgluten.isChecked())
            gluten = 1;
        if(Clactose.isChecked())
            lactose = 1;
    }

    public void OnClick(View v){
        boolean isInserted = db.insertData(editnome.getText().toString(),
                editdtnasc.getText().toString(),
                sexo,
                Integer.parseInt( editpeso.getText().toString()),
                gluten,
                lactose);
        if(isInserted =true)
            Toast.makeText(User.this, "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(User.this,"Data not Inserted",Toast.LENGTH_LONG).show();
    }

}
