package com.aqib.contextmenu;

import android.R.integer;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button button = (Button) findViewById(R.id.button);
		registerForContextMenu(button);

		addButtonListener(button);
	}

	private void addButtonListener(Button button) {

		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
				Notification notification = new Notification(
						android.R.drawable.stat_notify_more,
						"this is important", System.currentTimeMillis());
			CharSequence title="Notification for yawning";
				CharSequence details="Keep yawning dont stop !!";
				Context context=MainActivity.this;
				Intent intent=new Intent(context,MainActivity.class);
				PendingIntent pending=PendingIntent.getActivity(context, 0, intent, 0);
				notification.setLatestEventInfo(context, title, details, pending);
				manager.notify(0, notification);
			}
		});

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);

		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);

	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {

		int id = item.getItemId();

		switch (id) {
		case R.id.item1:
			Toast.makeText(this, "item 1 selected ", Toast.LENGTH_LONG).show();

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
