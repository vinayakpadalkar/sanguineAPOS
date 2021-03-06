package com.example.apos.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.apos.activity.R;
import com.example.apos.bean.clsVoidKotListDtl;
import com.example.apos.listeners.clsVoidKotListSelectionListener;

import java.util.List;


public class clsVoidKotListAdapter extends BaseAdapter {

    private static String TAG = "BeWo_Restaurant_" + clsVoidKotListAdapter.class.getName();
    private Context context;
    private Activity mActivity;
    List<clsVoidKotListDtl> listItemsListData;
    private clsVoidKotListSelectionListener kotListSelectionListener;

    public clsVoidKotListAdapter (Context context, Activity activity, List<clsVoidKotListDtl> itemsListData, clsVoidKotListSelectionListener mKotListSelectionListener) {
        this.context = context;
        this.mActivity = activity;
        this.listItemsListData = itemsListData;
        Log.i(TAG, "Size of the item lists in clsDirectBillItemsListGridViewAdapter : " + listItemsListData.size());
        this.kotListSelectionListener = mKotListSelectionListener;
    }



    @Override
    public int getCount() {
        return listItemsListData.size();
    }

    @Override
    public Object getItem(int position) {
        return listItemsListData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listItemsListData.indexOf(getItem(position));
    }

    @Override
    public View getView(final int position, View view, ViewGroup viewGroup) {
        ViewHolder holder=new ViewHolder();
        View rowView;
        LayoutInflater inflater = LayoutInflater.from(context);
        rowView = inflater.inflate(R.layout.voidkotlistitems, null);
        holder.llKotList = (LinearLayout) rowView.findViewById(R.id.ll_list_row_void_kot);
        holder.tvKotNo =(TextView) rowView.findViewById(R.id.tv_void_kot_item_name);
        holder.tvTableName = (TextView) rowView.findViewById(R.id.tv_void_kot_Table_Name);
        holder.tvWaiterName =(TextView) rowView.findViewById(R.id.tv_void_kot_waiter_Name);
        holder.tvUserName = (TextView) rowView.findViewById(R.id.tv_void_kot_User_Name);
        holder.tvItemListAmount=(TextView) rowView.findViewById(R.id.tv_void_kot_items_list_amount);



        final clsVoidKotListDtl kotListBean = (clsVoidKotListDtl) getItem(position);

        if(kotListBean.getStrKotNo() != null){
            holder.tvKotNo.setText(kotListBean.getStrKotNo());
        }

        if(kotListBean.getStrTableName() != null){
            holder.tvTableName.setText(kotListBean.getStrTableName());
        }

        if(kotListBean.getStrWaiterName() != null){
            holder.tvWaiterName.setText(kotListBean.getStrWaiterName());
        }

        if(kotListBean.getStrUser() != null){
            holder.tvUserName.setText(kotListBean.getStrUser());
        }

        if(kotListBean.getStrKotNo() != null){
            holder.tvKotNo.setText(kotListBean.getStrKotNo());
        }

        if(kotListBean.getStrAmount() != -1){
            holder.tvItemListAmount.setText(kotListBean.getStrAmount() + " Rs");
        }


        holder.llKotList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                kotListSelectionListener.getVoidKotListSelected(kotListBean.getStrKotNo());

            }
        });







        return rowView;
    }

    private class ViewHolder{

        TextView tvKotNo;
        TextView tvTableName;
        TextView tvWaiterName;
        TextView tvUserName;
        TextView tvItemListAmount;
        LinearLayout llKotList;




    }
}