package com.example.checkboxtest;

import java.util.zip.Inflater;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.*;

public class MainActivity extends Activity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

	        ListView listView = (ListView)rootView.findViewById(R.id.listView);
	        listView.setAdapter(new CheckBoxAdapter());



            return rootView;
        }
    }

	class CheckBoxAdapter extends BaseAdapter{

		@Override
		public int getCount() {
			return 10;
		}

		@Override
		public Object getItem(int position) {
			return null;
		}

		@Override
		public long getItemId(int position) {
			return 0;
		}

		@Override
		public View getView(final int position, View convertView, ViewGroup parent) {
			View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.list_item, parent, false);

			final CheckBox cb = (CheckBox)view.findViewById(R.id.checkBox);

			cb.setOnCheckedChangeListener(new CompoundButton.
				OnCheckedChangeListener(){
				@Override
				public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
					if (isChecked)
					{
						cb.setChecked(isChecked);
						Toast toast = Toast.makeText(getApplicationContext(), "checked" + position, Toast.LENGTH_SHORT);
						toast.show();
					}
					else
					{
						cb.setChecked(isChecked);
						Toast toast = Toast.makeText(getApplicationContext(), "unChecked" + position, Toast.LENGTH_SHORT);
						toast.show();
					}
				}
			});


			return view;
		}
	}

}
