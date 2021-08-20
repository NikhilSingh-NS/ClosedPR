package com.example.myclosedprs.util

import android.widget.ImageView
import com.squareup.picasso.Picasso
import java.lang.ref.WeakReference

class ImageLoader {

    companion object {
        fun loadImage(imageView: WeakReference<ImageView>, url: String) {
            Picasso.get().load(url).resize(200, 200).into(imageView.get())
        }
    }
}