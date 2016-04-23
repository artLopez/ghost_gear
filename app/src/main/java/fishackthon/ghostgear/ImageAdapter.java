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

    private Context context;
    private ArrayList<Integer> bitmapList;

    public ImageAdapter(Context context, ArrayList<Integer> bitmapList) {
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

    class ViewHolder implements View.OnTouchListener {
        ImageView picture;
        ViewHolder(View v) {
            picture = (ImageView) v.findViewById(R.id.imageView);
            picture.setOnTouchListener(this);

        }

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            Log.v("Touched", "Touched");
            return false;
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
        holder.picture.setImageResource(bitmapList.get(position));
        holder.picture.setAdjustViewBounds(true);
        return row;
    }

}