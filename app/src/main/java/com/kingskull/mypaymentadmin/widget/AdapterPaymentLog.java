package com.kingskull.mypaymentadmin.widget;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kingskull.mypaymentadmin.R;
import com.kingskull.mypaymentadmin.model.PaymentLog;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 03/08/2015.
 */
public class AdapterPaymentLog extends BaseAdapter {

    private List<PaymentLog> logs;
    private Activity activity;

    public AdapterPaymentLog(ArrayList<PaymentLog> logs, Activity parent){
        this.logs = logs;
        this.activity = parent;
    }

    @Override
    public int getCount() {
        return logs.size();
    }

    @Override
    public PaymentLog getItem(int position) {
        return logs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return logs.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PaymentLog log = getItem(position);

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_month_item, null);
        }

        ImageView iconView      = (ImageView) convertView.findViewById(R.id.icon_item);
        TextView amountView     = (TextView) convertView.findViewById(R.id.original_amount);
        TextView depositView    = (TextView) convertView.findViewById(R.id.transaction_up);
        TextView withdrawView   = (TextView) convertView.findViewById(R.id.transaction_down);
        TextView dateTransView  = (TextView) convertView.findViewById(R.id.transaction_date);

        if (log.isDeposiTransaction()){
            withdrawView.setText("");
            depositView.setText("+ $" + log.getTransaction());
        } else {
            depositView.setText("");
            withdrawView.setText("- $" + log.getTransaction());
        }

        amountView.setText("" + log.getOriginal_amount());

        dateTransView.setText(log.getDate().getDay() + "/" + log.getDate().getMonth() + "/" + log.getDate().getYear());

        return convertView;
    }
}
