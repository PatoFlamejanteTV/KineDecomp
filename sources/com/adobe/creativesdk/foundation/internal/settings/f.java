package com.adobe.creativesdk.foundation.internal.settings;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import java.io.InputStream;
import java.net.URL;

/* compiled from: CloudPickerActivity.java */
/* loaded from: classes.dex */
class f extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a */
    private ImageView f5215a;

    public f(ImageView imageView) {
        this.f5215a = imageView;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(String... strArr) {
        Bitmap bitmap = null;
        try {
            InputStream openStream = new URL(strArr[0]).openStream();
            bitmap = BitmapFactory.decodeStream(openStream);
            openStream.close();
            return bitmap;
        } catch (Exception e2) {
            Log.e("Error", e2.getMessage());
            e2.printStackTrace();
            return bitmap;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        this.f5215a.setImageBitmap(bitmap);
    }
}
