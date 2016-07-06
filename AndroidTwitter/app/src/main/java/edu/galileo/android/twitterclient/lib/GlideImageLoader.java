package edu.galileo.android.twitterclient.lib;

import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by ykro.
 */
public class GlideImageLoader implements ImageLoader {
    private RequestManager glideRequestManager;

    public GlideImageLoader(Fragment fragment) {
        this.glideRequestManager = Glide.with(fragment);
    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .override(600, 400)
                .into(imageView);
    }
}
