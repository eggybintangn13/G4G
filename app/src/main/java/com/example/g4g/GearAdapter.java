package com.example.g4g;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.g4g.Gear;
import com.example.g4g.R;

import java.util.ArrayList;

public class GearAdapter extends BaseAdapter {
    private final Context context;
    private ArrayList<Gear> gears= new ArrayList<>();

    void setGears(ArrayList<Gear> heroes) {
        this.gears = gears;
    }

    GearAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return gears.size();
    }

    @Override
    public Object getItem(int i) {
        return gears.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null){
            itemView = LayoutInflater.from(context).inflate(R.layout.item_menu, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);

        Gear gear = (Gear) getItem(i);
        viewHolder.bind(gear);
        return itemView;
    }

    private class ViewHolder {
        private TextView txtMenu;
        private ImageView imgMenu;

        ViewHolder(View view) {
            txtMenu = view.findViewById(R.id.txt_menu);
            imgMenu = view.findViewById(R.id.img_menu);
        }

        void bind(Gear gear) {
            txtMenu.setText(gear.getName());
            imgMenu.setImageResource(gear.getPhoto());
        }
    }
}
