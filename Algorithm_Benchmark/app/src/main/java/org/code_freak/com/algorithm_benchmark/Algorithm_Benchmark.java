package org.code_freak.com.algorithm_benchmark;

import android.content.Intent;
import android.renderscript.Script;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Algorithm_Benchmark extends AppCompatActivity {
    private static int[] generated_array;
     EditText etArraySize;
     RadioGroup rgGroup;
     TextView tvBubbleTime;
     TextView tvSelectionTime;
    TextView tvMerge;
    GridLayout glAlgo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_algorithm__benchmark_layout);
        etArraySize = (EditText) findViewById(R.id.etArraySize);
        tvBubbleTime = (TextView) findViewById(R.id.tvBubbleTime);
        tvSelectionTime = (TextView) findViewById(R.id.tvSelectionTime);
        rgGroup = (RadioGroup) findViewById(R.id.rgGroup);
        glAlgo = (GridLayout) findViewById(R.id.glAlgo);
        tvMerge = (TextView) findViewById(R.id.tvMergeSort);
    }
    public void sortit(View view){


        Log.d("kuldeep","sort method called");
        switch (view.getId()){
            case R.id.btnBubble:
                int[] arrayclonebbl = Arrays.copyOf(generated_array,generated_array.length);
                long bubbleStart = System.currentTimeMillis();
                Calculation.bubbleSort(arrayclonebbl);
                long bubbleEnd = System.currentTimeMillis();
                tvBubbleTime.setText(""+(bubbleEnd-bubbleStart));
                break;
            case R.id.btnSelection:
                int[] arrayclonesel = Arrays.copyOf(generated_array,generated_array.length);
                long selectionstart = System.currentTimeMillis();
                Arrays.sort(arrayclonesel);
                long selectionend = System.currentTimeMillis();
                tvSelectionTime.setText(""+(selectionend-selectionstart));
                break;
            case R.id.btnMerge:
                int[] arraymerge = Arrays.copyOf(generated_array, generated_array.length);
                long mergestart = System.currentTimeMillis();
                Calculation.doSelectionSort(arraymerge);
                long mergeend = System.currentTimeMillis();
                tvMerge.setText(""+(mergeend-mergestart));
                break;
        }
    }
    public void GenerateArray(View view){
        tvSelectionTime.setText("");
        tvBubbleTime.setText("");
        tvMerge.setText("");
        Log.d("kuldeep","genetare method called");
        switch (rgGroup.getCheckedRadioButtonId()){
            case R.id.rbBestCase:
                generated_array = Calculation.generateNaturalArray(Integer.parseInt(etArraySize.getText().toString()));
                Toast.makeText(this,"array size in best case is "+etArraySize.getText(),Toast.LENGTH_LONG).show();
                glAlgo.setVisibility(View.VISIBLE);
                break;
            case R.id.rbAvgCase:
                generated_array = Calculation.generateNaturalArray(Integer.parseInt(etArraySize.getText().toString()));
                Toast.makeText(this,"array size in avg case is "+etArraySize.getText(),Toast.LENGTH_LONG).show();
                glAlgo.setVisibility(View.VISIBLE);
                break;
            case R.id.rbWorstCase:
                generated_array = Calculation.generateNaturalArray(Integer.parseInt(etArraySize.getText().toString()));
                Toast.makeText(this,"array size in worst case is "+etArraySize.getText(),Toast.LENGTH_LONG).show();
                glAlgo.setVisibility(View.VISIBLE);
                break;

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        glAlgo.setVisibility(View.INVISIBLE);
    }
}
