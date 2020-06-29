package com.example.projectlancuoikhongmuoncobug.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectlancuoikhongmuoncobug.Model.PlayList;
import com.example.projectlancuoikhongmuoncobug.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Playlist_Adapter extends ArrayAdapter<PlayList> {
    public Playlist_Adapter(@NonNull Context context, int resource, @NonNull List<PlayList> objects) {
        super(context, resource, objects);
    }
    class ViewHolder{
        TextView txttenplaylist;
        ImageView imgbackground, imgplaylsit;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView==null)
        {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.dong_playlist,null);
            viewHolder = new ViewHolder();
            viewHolder.txttenplaylist = convertView.findViewById(R.id.textviewtenplaylist);
            viewHolder.imgplaylsit = convertView.findViewById(R.id.imgplaylist);
            viewHolder.imgbackground=convertView.findViewById(R.id.imageviewbackgroundpplaylist);
            convertView.setTag(viewHolder);
        }
        else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        PlayList playList = getItem(position);
        Picasso.with(getContext()).load(playList.getHinhPlayList()).into(viewHolder.imgbackground);
        Picasso.with(getContext()).load(playList.getIcon()).into(viewHolder.imgplaylsit);
        viewHolder.txttenplaylist.setText(playList.getTen());

        return convertView;

    }
}
