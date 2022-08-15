package com.example.attendancesystem.Adapterrs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.attendancesystem.Models.AttendanceResponse;
import com.example.attendancesystem.R;

import java.util.List;

public class AttendanceAdapter extends RecyclerView.Adapter<AttendanceAdapter.ViewHolder> {

    private Context context;
    private AttendanceResponse attendanceResponseList;

    public AttendanceAdapter(Context context, AttendanceResponse attendanceResponseList) {
        this.context = context;
        this.attendanceResponseList = attendanceResponseList;
    }


    @NonNull
    @Override
    public AttendanceAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layouts, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull AttendanceAdapter.ViewHolder holder, int position) {
        holder.userIdTV.setText(String.valueOf(attendanceResponseList.getData().get(position).getId()));
        holder.textView.setText(attendanceResponseList.getData().get(position).getName());

    }

    @Override
    public int getItemCount() {
        return attendanceResponseList.getData().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView, userIdTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.userNameTV);
            userIdTV = itemView.findViewById(R.id.userIdTV);
        }
    }
}
