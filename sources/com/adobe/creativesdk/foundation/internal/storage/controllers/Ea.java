package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.DisplayMetrics;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXMobilePackageItemOneUpViewerActivity;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXMobilePackageItemOneUpViewerActivity.java */
/* loaded from: classes.dex */
public class Ea extends AsyncTask<byte[], Integer, Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Fa f5629a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ea(Fa fa) {
        this.f5629a = fa;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Bitmap doInBackground(byte[]... bArr) {
        byte[] bArr2 = bArr[0];
        if (bArr2 != null) {
            return BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Bitmap bitmap) {
        RelativeLayout.LayoutParams layoutParams;
        if (bitmap != null) {
            if (this.f5629a.f5640b.getActivity() == null) {
                return;
            }
            if (this.f5629a.f5640b.f5568f == null || (bitmap.getWidth() > this.f5629a.f5640b.f5568f.f5572a && bitmap.getHeight() > this.f5629a.f5640b.f5568f.f5573b)) {
                this.f5629a.f5640b.B();
                this.f5629a.f5640b.f5568f = new AdobeUXMobilePackageItemOneUpViewerActivity.d();
                this.f5629a.f5640b.f5568f.f5572a = bitmap.getWidth();
                this.f5629a.f5640b.f5568f.f5573b = bitmap.getHeight();
                DisplayMetrics displayMetrics = this.f5629a.f5640b.getResources().getDisplayMetrics();
                if (bitmap.getWidth() >= displayMetrics.widthPixels && bitmap.getHeight() >= displayMetrics.heightPixels) {
                    layoutParams = new RelativeLayout.LayoutParams(-2, -2);
                } else {
                    layoutParams = new RelativeLayout.LayoutParams(-1, -1);
                }
                layoutParams.addRule(13);
                this.f5629a.f5639a.setLayoutParams(layoutParams);
                this.f5629a.f5639a.setImageBitmap(com.adobe.creativesdk.foundation.internal.utils.p.a(bitmap, displayMetrics.widthPixels, displayMetrics.heightPixels));
                this.f5629a.f5640b.c(false);
                return;
            }
            return;
        }
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "AdobeMobileCreations:OneUpView", "Decoding data");
    }
}
