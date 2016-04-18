package com.bright.dietplan;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;

public class User extends Fragment {
    DataBaseHelper db;
    EditText editnome, editdtnasc, editpeso;
    Button guardar;
    RadioButton Rmasc, Rfem;
    public String sexo;
    CheckBox Cgluten, Clactose;
    public int gluten = 0, lactose = 0;
    public ArrayList<Integer> pesos = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.activity_user, container, false);
        db = new DataBaseHelper(this.getActivity());

        //EditText
        editnome =(EditText) rootView.findViewById(R.id.nome);
        editdtnasc = (EditText)rootView.findViewById(R.id.dtnasc);
        editpeso = (EditText)rootView.findViewById(R.id.peso);



        //RadioButton
        Rmasc = (RadioButton)rootView.findViewById(R.id.masc);
        Rfem = (RadioButton) rootView.findViewById(R.id.fem);
        if(Rmasc.isChecked())
            sexo = "masculino";
        else
            sexo = "feminino";
        //CheckBox
        Cgluten = (CheckBox)rootView.findViewById(R.id.checkBox);
        Clactose = (CheckBox)rootView.findViewById(R.id.checkBox2);
        if(Cgluten.isChecked())
            gluten = 1;
        if(Clactose.isChecked())
            lactose = 1;

        //Botão
        guardar = (Button)rootView.findViewById(R.id.Guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pesos.add(Integer.parseInt(editpeso.getText().toString()));
            }
        });
        return rootView;
    }


    /*public void OnClick(View v){
        pesos.add(Integer.parseInt(editpeso.getText().toString()));
        boolean isInserted = db.insertData(editnome.getText().toString(),
                editdtnasc.getText().toString(),
                sexo,
                Integer.parseInt( editpeso.getText().toString()),
                gluten,
                lactose);
        if(isInserted =true)
            Toast.makeText(User.this.getActivity(), "Data Inserted", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(User.this.getActivity(),"Data not Inserted",Toast.LENGTH_LONG).show();
    }*/

}