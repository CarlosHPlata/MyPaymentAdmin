package com.kingskull.mypaymentadmin.view.activities;

import android.animation.Animator;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.kingskull.mypaymentadmin.R;
import com.kingskull.mypaymentadmin.model.PaymentLog;
import com.kingskull.mypaymentadmin.widget.AdapterPaymentLog;
import com.kingskull.mypaymentadmin.widget.CircularProgressBar;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    private CircularProgressBar mainBar;
    private LinearLayout list_month;

    private List<PaymentLog> logs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logs = new ArrayList<PaymentLog>();

        logs.add(new PaymentLog(null, 500, 2000, "transaccion exitosa", 1, true, new Date()));
        logs.add(new PaymentLog(null, 2500, 2000, "transaccion exitosa", 1, true, new Date()));
        logs.add(new PaymentLog(null, 2000, 500, "transaccion exitosa", 1, false, new Date()));

        mainBar = (CircularProgressBar) findViewById(R.id.circularprogressbar1);
        mainBar.setProgress(70);
       // mainBar.setProgressColor(getResources().getColor(R.color.circular_progress_warning_progress));

        list_month = (LinearLayout) findViewById(R.id.list_month);

        fillList();
    }

    public void fillList(){
        AdapterPaymentLog adapter = new AdapterPaymentLog((ArrayList<PaymentLog>) logs, this);
        for (int i = 0; i<logs.size(); i++){
            View v = adapter.getView(i, null, null);
            list_month.addView(v);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
