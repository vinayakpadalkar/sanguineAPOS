package com.example.apos.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.apos.activity.R;
import com.example.apos.bean.clsItemPriceRateBean;
import com.example.apos.bean.clsTableMaster;
import com.example.apos.listeners.clsKotTableListSelectionListener;
import java.util.ArrayList;

public class clsBilledTableAdapter extends BaseAdapter
{
    private Context mContext;
    private ArrayList arrListTable;


    public clsBilledTableAdapter(Context c,Activity activity, ArrayList arrListTable) {
        mContext = c;
        this.arrListTable=arrListTable;

    }

    public int getCount() {
        return arrListTable.size();
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridView;
        gridView =new View(mContext);
        gridView = inflater.inflate(R.layout.viewtablestatusgridviewmembers, null);

        final Button btnTable = (Button) gridView.findViewById(R.id.btnTableStatus);
        btnTable.setTag(position);
        clsTableMaster objTable = (clsTableMaster)arrListTable.get(position);
        btnTable.setText(objTable.getStrTableName());
        btnTable.setBackgroundResource(R.drawable.bluebutton);

        return gridView;
    }



}