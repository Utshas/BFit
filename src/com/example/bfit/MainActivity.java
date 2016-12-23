package com.example.bfit;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener{
EditText e1,e2;
TextView t;
ListView list;
ArrayAdapter<String>adapter;
ArrayList<String>aList;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		e1=(EditText)findViewById(R.id.editText1);
		e2=(EditText)findViewById(R.id.editText2);
		t=(TextView)findViewById(R.id.textView3);
		t.setText("Enter the value in the textfields first. Then select unit from the following list.");
		list=(ListView)findViewById(R.id.listView1);
		aList=new ArrayList<String>();
		aList.add("Inch-Pound");
		aList.add("metre-kg");
		aList.add("Inch-kg");
		adapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,aList);
		list.setAdapter(adapter);
		list.setOnItemClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
public void checkValue(Double h, Double w) {
		
		Double r=w/(h*h);
		if(r<=18.5)
		{
			t.setText("Your wieght is extremely low according to BMI standard. You need to increase your weight.");
		}
		else if(r<=24.9 && r>18.5)
		{
			t.setText("Your wieght is Perfect according to BMI standard. Keep going and remain healthy.");
		}
		else if(r<=29.9 && r>24.9)
		{
			t.setText("Your wieght is slightly high according to BMI standard. Just have a little more exersice or control you diet a bit.");
		}
		else if(r<=34.9 && r>30)
		{
			t.setText("Your wieght is high according to BMI standard. You should decrease your weight.");
		}
		else if(r<=39.9 && r>34.9)
		{
			t.setText("Your wieght is extremely high according to BMI standard. You must decrease your weight. Be careful about your weight, diet and take a regular exercise.");
		}
		else
		{
			t.setText("Shit! Your weight is gonna BLAST my app and I'm not joking.");
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int a, long arg3) {
		// TODO Auto-generated method stub
		if(a==0)
		{
			Double h,w;
			String hi,wi;
			hi=e1.getText().toString();
			wi=e2.getText().toString();
			h=Double.parseDouble(hi);
			w=Double.parseDouble(wi);
			w=w*0.4536;
			h=h*0.0254;
			checkValue(h,w);
		}
		if(a==1)
		{
			Double h,w;
			String hi,wi;
			hi=e1.getText().toString();
			wi=e2.getText().toString();
			h=Double.parseDouble(hi);
			w=Double.parseDouble(wi);
			checkValue(h,w);
		}
		if(a==2)
		{
			Double h,w;
			String hi,wi;
			hi=e1.getText().toString();
			wi=e2.getText().toString();
			h=Double.parseDouble(hi);
			w=Double.parseDouble(wi);
			h=h*0.0254;
			checkValue(h,w);
		}
	}
}
