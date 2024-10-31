package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CCFilesListView.java */
/* loaded from: classes.dex */
public class Mb extends AsyncTask<byte[], Integer, Bitmap> {

    /* renamed from: a */
    final /* synthetic */ Ob f5724a;

    public Mb(Ob ob) {
        this.f5724a = ob;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public Bitmap doInBackground(byte[]... bArr) {
        byte[] bArr2 = bArr[0];
        if (bArr2 != null) {
            return BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
        }
        return null;
    }

    @Override // android.os.AsyncTask
    /* renamed from: a */
    public void onPostExecute(Bitmap bitmap) {
        this.f5724a.f5748a.b(bitmap);
    }
}
