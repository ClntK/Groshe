package com.example.groshe;

import static com.example.groshe.GrosheContract.GrosheEntry.*;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.groshe.GrosheContract.GrosheEntry;

public class GrosheAdapter extends RecyclerView.Adapter<GrosheAdapter.GrosheViewHolder> {

    private Context mContext;
    private Cursor mCursor;

//    cursor gets item to be displayed from database
    public GrosheAdapter(Context context, Cursor cursor) {
        mContext = context;
        mCursor = cursor;
    }


    public class GrosheViewHolder extends RecyclerView.ViewHolder {
        public TextView nameText;
        public TextView countText;

       public GrosheViewHolder(@NonNull View itemView) {
           super(itemView);

           nameText = itemView.findViewById(R.id.textview_name_item);
           countText = itemView.findViewById(R.id.textview_amount_item);
       }
   }


    @NonNull
    @Override
    public GrosheViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.grocery_item, parent, false);
        return new GrosheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GrosheViewHolder holder, int position) {
        if(!mCursor.moveToPosition(position)) {
            return;
        }

        @SuppressLint("Range") String name = mCursor.getString(mCursor.getColumnIndex(COLUMN_NAME));
        @SuppressLint("Range") int amount = mCursor.getInt(mCursor.getColumnIndex(COLUMN_AMOUNT));
        @SuppressLint("Range") long id = mCursor.getLong(mCursor.getColumnIndex(_ID));

        holder.nameText.setText(name);
        holder.countText.setText(String.valueOf(amount));
        holder.itemView.setTag(id);
    }

    @Override
    public int getItemCount() {

        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor) {
        if (mCursor != null) {
            mCursor.close();
        }

        mCursor = newCursor;

        if (newCursor != null) {
            notifyDataSetChanged();
        }
    }

}
