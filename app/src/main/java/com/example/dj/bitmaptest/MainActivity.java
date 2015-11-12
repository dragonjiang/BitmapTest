package com.example.dj.bitmaptest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = (ImageView) findViewById(R.id.img);
//        mImageView.setImageDrawable(getResources().getDrawable(R.mipmap.img));
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        printBitmapSize(mImageView);
    }

    private void printBitmapSize(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            Bitmap bitmap = bitmapDrawable.getBitmap();
            Bitmap.Config config = bitmap.getConfig();
            int bytes = 0;
            double size = 0;
            switch (config){
                case ALPHA_8:
                    bytes = 1;
                    break;
                case RGB_565:
                    bytes = 2;
                    break;
                case ARGB_4444:
                    bytes = 2;
                    break;
                case ARGB_8888:
                    bytes = 4;
                    break;
            }
            size = bitmap.getWidth() * bitmap.getHeight() * bytes / 1024.0 / 1024.0;
            Log.d(TAG, " width = " + bitmap.getWidth() + " height = " + bitmap.getHeight()
                    + "  config = " + config
                    + "  size = " + size +"M ");
        } else {
            Log.d(TAG, "Drawable is null !");
        }
    }
}
