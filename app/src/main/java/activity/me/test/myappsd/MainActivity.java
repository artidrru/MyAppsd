package activity.me.test.myappsd;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private File sdCardRoot;
    List<String> ImageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*** Get Images from SDCard ***/
        ImageList = getSD();

        // gridView1
        final GridView gView1 = (GridView) findViewById(R.id.gridView1);

        gView1.setAdapter(new ImageAdapter(this, ImageList));

        // OnClick
        gView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                Toast.makeText(getApplicationContext(),
                        "Your selected : " + ImageList.get(position).toString(), Toast.LENGTH_SHORT);


                ImageView image = new ImageView(MainActivity.this);
                sdCardRoot = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                String strPath =  ImageList.get(position).toString();
                 Log.d("strPaaaaaaaaaa",""+strPath);
                Bitmap sourceBitmap = BitmapFactory.decodeFile(strPath);

               // Uri imageURI = Uri.parse(strPath);
              //  image.setImageURI(imageURI);
                image.setImageBitmap(sourceBitmap);

                new AlertDialog.Builder(MainActivity.this)
                        .setView(image)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                return;
                            }
                        })
                        .show();


            }
        });

    }

    private List<String> getSD() {
        List<String> it = new ArrayList<String>();

        sdCardRoot = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        String strPath =  sdCardRoot+"/LINE";

       // File f = new File("/mnt/sdcard/picture");
        File f = new File(sdCardRoot+"/");
        File[] files = f.listFiles();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            Log.d("Count", file.getPath());
            it.add(file.getPath());
        }
        return it;
    }
}