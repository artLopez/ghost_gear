package fishackthon.ghostgear;

/**
 * Created by Algernon on 4/23/16.
 */

import android.util.Log;
import android.widget.*;
import java.util.*;
import android.view.*;
import android.content.*;

public class ImageAdapter extends BaseAdapter {

    public static Context context;

    private String prevId = "1";
    private String currentId = "1";

    private ArrayList<MatchesActivity.CodeID> bitmapList;

    public ImageAdapter(Context context, ArrayList<MatchesActivity.CodeID> bitmapList) {
        this.context = context;
        this.bitmapList = bitmapList;
    }

    public int getCount() {
        return this.bitmapList.size();
    }

    public Object getItem(int position) {
        return this.bitmapList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }


    class ViewHolder {
        ImageView picture;
        ViewHolder(View v) {
            picture = (ImageView) v.findViewById(R.id.imageView);

        }
    }

    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            imageView = new ImageView(this.context);
//            imageView.setLayoutParams(new GridView.LayoutParams(115, 115));
//            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
//        } else {
//            imageView = (ImageView) convertView;
//        }
//
//        imageView.setImageBitmap(this.bitmapList.get(position));
//        return imageView;
        View row = convertView;
        ViewHolder holder = null;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.single_picture, parent, false);
            holder = new ViewHolder(row);
            row.setTag(holder);
        } else {
            holder = (ViewHolder) row.getTag();

        }

        row.setClickable(true);

        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("Image", "Clicked");
                Log.v("Image", String.valueOf(v.getId()));
                prevId = bitmapList.get(v.getId()).ID;

                currentId = bitmapList.get(v.getId()).ID;
                //ImageView selectedImage = (ImageView) findViewById(currentId);
                //ImageView prevImage = (ImageView) findViewById(prevId);

                String nameLol = bitmapList.get(v.getId()).code + " was selected!";

                CharSequence text = nameLol;
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(ImageAdapter.context, text, duration);
                toast.show();


                String name = bitmapList.get(v.getId()).ID;

                Log.v("Image", name);
                Log.v("Image", nameLol);

            }
        });

        row.setId(position);
        Log.v("Image", String.valueOf(bitmapList.get(position).ID));
        holder.picture.setImageResource(Integer.parseInt(bitmapList.get(position).ID));
        holder.picture.setAdjustViewBounds(true);
        return row;
    }

    void removeImage() {

    }


}