package activity.me.test.myappsd;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by artidrru on 12/24/2015.
 */

    public class ImageAdapter extends BaseAdapter
{
    private Context context;
    private List<String> lis;

    public ImageAdapter(Context c, List <String> li)
    {
        // TODO Auto-generated method stub
        context = c;
        lis = li;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return lis.size();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (convertView == null) {
            convertView = inflater.inflate(R.layout.showimage, null);
        }

        TextView textView = (TextView) convertView.findViewById(R.id.textView1);
        String strPath = lis.get(position).toString();

        // Get File Name
        String fileName = strPath.substring( strPath.lastIndexOf('/')+1, strPath.length() );
        textView.setText(fileName);

        // Image Resource
        ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView1);
        Bitmap bm = BitmapFactory.decodeFile(strPath);
        imageView.setImageBitmap(bm);

        return convertView;

    }
}
