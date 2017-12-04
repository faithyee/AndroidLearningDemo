package com.faithyee.androidlearningdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Author：yewmf on 2017/12/4 09:17
 * E-mail：faith_yee@163.com
 */
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvHolder> implements View.OnClickListener{

    private String[] datas;

    public RvAdapter(String[] datas){
        this.datas = datas;
    }

    @Override
    public RvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main_rv,parent,false);
        RvHolder vh = new RvHolder(view);
        vh.mButton.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(RvHolder holder, int position) {
        holder.mButton.setText(datas[position]);
        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.mButton.setTag(position);
    }

    @Override
    public int getItemCount() {
        return datas.length;
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    public class RvHolder extends RecyclerView.ViewHolder{


        public Button mButton;
        public RvHolder(View view){
            super(view);
            mButton = (Button) view.findViewById(R.id.bt);
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view,int position);
    }

    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
}
