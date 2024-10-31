package com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration;

import android.widget.ImageView;
import android.widget.TextView;
import com.adobe.creativesdk.foundation.internal.storage.AdobeStorageDataSource;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;

/* compiled from: AdobeOneUpViewerFilesConfiguration.java */
/* loaded from: classes.dex */
public class f extends b {

    /* renamed from: g, reason: collision with root package name */
    private AdobeAssetFile f5770g;

    /* renamed from: h, reason: collision with root package name */
    private AdobeStorageDataSource f5771h;
    private int i;
    private int j;
    private int k;
    private TextView l;
    private ImageView m;

    public void a(AdobeAssetFile adobeAssetFile) {
        this.f5770g = adobeAssetFile;
    }

    public void b(int i) {
        this.j = i;
    }

    public void c(int i) {
        this.k = i;
    }

    public AdobeAssetFile d() {
        return this.f5770g;
    }

    public AdobeStorageDataSource e() {
        return this.f5771h;
    }

    public void a(AdobeStorageDataSource adobeStorageDataSource) {
        this.f5771h = adobeStorageDataSource;
    }

    public void d(int i) {
        this.i = i;
    }

    public void a(TextView textView) {
        this.l = textView;
    }

    public void a(ImageView imageView) {
        this.m = imageView;
    }
}
