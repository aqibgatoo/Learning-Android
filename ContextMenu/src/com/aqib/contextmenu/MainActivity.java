package com.aqib.contextmenu;

import java.util.zip.Inflater;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		Button button=(Button) findViewById(R.id.button);
       registerForContextMenu(button);
	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
	MenuInflater  inflater=getMenuInflater();
	inflater.inflate(R.menu.main, menu);
		
	}
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		
		  int id=item.getItemId();
		  
		switch (id) {
		case R.id.item1:
			Toast.makeText(this,"item 1 selected ",Toast.LENGTH_LONG).show();
			
			break;

		default:
			finish();
		}
		
		
		return super.onContextItemSelected(item);
	
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
