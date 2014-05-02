package com.roalts.codeminatorstheinception.cti;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.VideoView;


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

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Instructions!");
        builder.setMessage("Ask any question of your choice, about the future, to be answered in Yes/No!");
        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener(){


            @Override
            public void onClick(
                    DialogInterface dialog,
                    int i) {
                dialog.dismiss();
            }
        });
        builder.show();

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

            final View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            Button button = (Button) rootView.findViewById(R.id.a);
            final EditText txt = (EditText) rootView.findViewById(R.id.b);
            final VideoView vv = (VideoView)rootView.findViewById(R.id.videoView);
            final String f = "android.resource://" + getPackageName() + "/" + R.raw.main;
            vv.setVisibility(vv.INVISIBLE);
            final String l;
            l = txt.getText().toString();


            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if(l==null)
                    {
                       AlertDialog.Builder build;
                        build = new AlertDialog.Builder(getApplicationContext());
                        build.setMessage("Error!");
                    }
                    int DELAY = 1700;

                    Handler h = new Handler();
                    h.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                            startActivity(i);
                        }
                    }, DELAY);




                    vv.setVisibility(vv.VISIBLE);
                    vv.setVideoURI(Uri.parse(f));
                    vv.start();



                }
            });
            return rootView;


        }
    }
}
