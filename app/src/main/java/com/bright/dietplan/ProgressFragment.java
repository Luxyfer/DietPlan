package com.bright.dietplan;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Luis on 09/04/2016.
 */
public class ProgressFragment extends Fragment {

    EditText peso;
    Button b1;
    Calendar c;
    int month = 0;
    ArrayList<Integer> Arraypeso;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_progress, container, false);
        LineChart lineChart = (LineChart) rootView.findViewById(R.id.chart);

        peso = (EditText)rootView.findViewById(R.id.pesoprog);


        Arraypeso = new ArrayList<>();
        Arraypeso.add(100); Arraypeso.add(80); //Para teste, como se fosse o seu peso inicial
        //Obter mês actual
        c = Calendar.getInstance();
        month = c.get(Calendar.MONTH);

        if (Arraypeso.size()==3){
            Toast.makeText(ProgressFragment.this.getActivity(), "Fez refresh", Toast.LENGTH_LONG).show();
        }
        ArrayList<Entry> entries = new ArrayList<>();
        for(int i=0;i<Arraypeso.size();i++){
            entries.add(new Entry(Arraypeso.get(i),month + i));
        }



        LineDataSet dataset = new LineDataSet(entries, "# of Calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");
        labels.add("July");
        labels.add("August");
        labels.add("September");
        labels.add("October");
        labels.add("November");
        labels.add("December");

        LineData data = new LineData(labels, dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //
        dataset.setDrawCubic(true);
        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);
        b1 = (Button) rootView.findViewById(R.id.adicionar);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(peso.getText().toString().matches("")){
                    Toast.makeText(ProgressFragment.this.getActivity(), "Nenhum peso inserido", Toast.LENGTH_LONG).show();
                }else{
                    Arraypeso.add(Integer.parseInt(peso.getText().toString()));
                    FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.detach(ProgressFragment.this).attach(ProgressFragment.this).commit();
                }
            }
        });
        return rootView;
    }

}
