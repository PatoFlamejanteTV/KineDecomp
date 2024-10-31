package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v4.content.FileProvider;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Ja extends AsyncTask<byte[], Integer, Uri> {

    /* renamed from: a, reason: collision with root package name */
    boolean f5683a;

    /* renamed from: b, reason: collision with root package name */
    FileOutputStream f5684b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ka f5685c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ja(Ka ka) {
        this.f5685c = ka;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Uri doInBackground(byte[]... bArr) {
        String a2;
        this.f5683a = false;
        if (bArr == null) {
            this.f5683a = true;
            return null;
        }
        byte[] bArr2 = bArr[0];
        if (bArr2 == null) {
            this.f5683a = true;
            return null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
        if (decodeByteArray == null) {
            this.f5683a = true;
            return null;
        }
        Ka ka = this.f5685c;
        a2 = ka.f5702c.a(ka.f5701b);
        try {
            File file = new File(this.f5685c.f5702c.f6157e, a2 + ".png");
            this.f5684b = new FileOutputStream(file);
            decodeByteArray.compress(Bitmap.CompressFormat.PNG, 100, this.f5684b);
            this.f5684b.flush();
            if (this.f5685c.f5702c.B.c()) {
                return FileProvider.getUriForFile(this.f5685c.f5702c, this.f5685c.f5702c.r.a(), file);
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(Integer... numArr) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Uri uri) {
        if (!this.f5685c.f5702c.B.c()) {
            if (!this.f5683a) {
                Ka ka = this.f5685c;
                ka.f5702c.a(ka.f5700a, true);
            } else {
                Ka ka2 = this.f5685c;
                ka2.f5702c.a(ka2.f5700a, false);
            }
        }
        FileOutputStream fileOutputStream = this.f5684b;
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
