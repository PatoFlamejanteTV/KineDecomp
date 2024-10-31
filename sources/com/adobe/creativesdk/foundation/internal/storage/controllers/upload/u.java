package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.util.LruCache;
import java.net.URL;

/* compiled from: AdobeUploadThumbnailMgr.java */
/* loaded from: classes.dex */
public class u extends AsyncTask<URL, Integer, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ AdobeUploadAssetData f6475a;

    /* renamed from: b */
    final /* synthetic */ c.a.a.a.b f6476b;

    /* renamed from: c */
    final /* synthetic */ v f6477c;

    public u(v vVar, AdobeUploadAssetData adobeUploadAssetData, c.a.a.a.b bVar) {
        this.f6477c = vVar;
        this.f6475a = adobeUploadAssetData;
        this.f6476b = bVar;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(URL... urlArr) {
        return v.a(urlArr[0], com.adobe.creativesdk.foundation.internal.storage.model.util.c.f6622b);
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onProgressUpdate(Integer... numArr) {
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        LruCache lruCache;
        if (this.f6475a.f5272a == null || bitmap == null) {
            return;
        }
        lruCache = this.f6477c.f6479b;
        lruCache.put(this.f6475a.f5272a, bitmap);
        this.f6476b.b(bitmap);
    }
}
