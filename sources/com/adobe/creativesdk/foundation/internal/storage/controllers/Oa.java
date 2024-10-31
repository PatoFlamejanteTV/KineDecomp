package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.adobe.creativesdk.foundation.internal.storage.controllers.AdobeUXPhotoAssetOneUpViewerActivity;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;

/* compiled from: AdobeUXPhotoAssetOneUpViewerActivity.java */
/* loaded from: classes.dex */
class Oa implements com.adobe.creativesdk.foundation.storage.sd<byte[], AdobePhotoException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Na f5743a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ DisplayMetrics f5744b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ View f5745c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ProgressBar f5746d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ AdobeUXPhotoAssetOneUpViewerActivity.c f5747e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(AdobeUXPhotoAssetOneUpViewerActivity.c cVar, Na na, DisplayMetrics displayMetrics, View view, ProgressBar progressBar) {
        this.f5747e = cVar;
        this.f5743a = na;
        this.f5744b = displayMetrics;
        this.f5745c = view;
        this.f5746d = progressBar;
    }

    @Override // com.adobe.creativesdk.foundation.storage.ud
    public void a(double d2) {
    }

    @Override // com.adobe.creativesdk.foundation.storage.rd
    public void a() {
        b();
    }

    protected void b() {
        this.f5743a.a(false);
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(byte[] bArr) {
        Bitmap decodeByteArray = bArr != null ? BitmapFactory.decodeByteArray(bArr, 0, bArr.length) : null;
        if (decodeByteArray == null) {
            b();
            return;
        }
        if (decodeByteArray.getWidth() >= this.f5744b.widthPixels && decodeByteArray.getHeight() >= this.f5744b.heightPixels) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            this.f5745c.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams2.addRule(13);
            this.f5745c.setLayoutParams(layoutParams2);
        }
        DisplayMetrics displayMetrics = this.f5744b;
        ((ImageView) this.f5745c).setImageBitmap(com.adobe.creativesdk.foundation.internal.utils.p.a(decodeByteArray, displayMetrics.widthPixels, displayMetrics.heightPixels));
        this.f5746d.setVisibility(8);
    }

    @Override // c.a.a.a.c
    public void a(AdobePhotoException adobePhotoException) {
        b();
    }
}
