package com.example.exitpoll.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.exitpoll.R;
import com.example.exitpoll.model.NumberItems;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class NumberListAdapter {
    private Context mContext;
    private int mResource;
    private List<NumberItems> mNumberItemList;

    public NumberListAdapter(@NonNull Context context,
                            int resource,
                            @NonNull List<NumberItems> numberItemList) {
        super(context, resource, numberItemList);
        this.mContext = context;
        this.mResource = resource;
        this.mNumberItemList = numberItemList;
    }

    @NonNull
    //@Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(mResource, parent, false);

        TextView titleTextView = view.findViewById(R.id.poll_result_view);
        TextView resultTextView = view.findViewById(R.id.poll_result_view);
        ImageView imageView = view.findViewById(R.id.poll_result_view);

        NumberItems numberItems = mNumberItemList.get(position);
        String filename = numberItems.image;
        Number result = numberItems.result;
        String title = numberItems.title;

        titleTextView.setText(title);


        AssetManager am = mContext.getAssets();
        try {
            InputStream is = am.open(filename);
            Drawable drawable = Drawable.createFromStream(is, "");
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            File privateDir = mContext.getFilesDir();
            File logoFile = new File(privateDir, filename);

            Bitmap bitmap = BitmapFactory.decodeFile(logoFile.getAbsolutePath(), null);
            imageView.setImageBitmap(bitmap);

            e.printStackTrace();
        }

        return view;
    }
}
