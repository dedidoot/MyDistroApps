package com.mydistroapps.helper;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.mydistroapps.R;


/**
 * Created by Dedi on 24/08/2018.
 * Happy coding, buddy!
 * https://inthecheesefactory.com/blog/get-to-know-glide-recommended-by-google/en
 */

public class ImageUtils {

    public void showImageDefault(Context context, final ImageView imageView, String url) {

        try {
            Glide.with(context)
                    .load(url)
                    .dontAnimate()
                    .error(R.color.white)
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(imageView);
        } catch (Exception iae) {
            Glide.clear(imageView);
        }
    }

}
