package com.adobe.creativesdk.foundation.internal.storage.controllers.OneUpViewConfiguration;

import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.util.ArrayList;

/* compiled from: AdobeOneUpViewerMobileCreationConfiguration.java */
/* loaded from: classes.dex */
public class h extends b {

    /* renamed from: g, reason: collision with root package name */
    private AdobeAssetPackagePages f5774g;

    /* renamed from: h, reason: collision with root package name */
    private int f5775h;
    private ArrayList<AdobeAssetFile> i;

    public void a(AdobeAssetPackagePages adobeAssetPackagePages) {
        this.f5774g = adobeAssetPackagePages;
    }

    public void b(int i) {
        this.f5775h = i;
    }

    public AdobeAssetPackagePages d() {
        return this.f5774g;
    }

    public ArrayList<AdobeAssetFile> e() {
        return this.i;
    }

    public int f() {
        return this.f5775h;
    }

    public void a(ArrayList<AdobeAssetFile> arrayList) {
        this.i = arrayList;
    }
}
