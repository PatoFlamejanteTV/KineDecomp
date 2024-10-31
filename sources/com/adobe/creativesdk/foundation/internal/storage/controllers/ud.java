package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.os.Bundle;
import com.adobe.creativesdk.foundation.storage.AdobeAssetFile;
import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import java.util.ArrayList;

/* compiled from: MobilePackageItemsOneUpViewController.java */
/* loaded from: classes.dex */
public class ud {

    /* renamed from: a, reason: collision with root package name */
    private AdobeAssetPackagePages f6435a;

    /* renamed from: b, reason: collision with root package name */
    private int f6436b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<AdobeAssetFile> f6437c;

    public static ud a(Bundle bundle) {
        ud udVar = new ud();
        AdobeAssetPackagePages a2 = C0449nd.a(bundle.getString("collectionhref"), bundle.getString("collectionparenthref"));
        udVar.b(bundle.getInt("startindex"));
        udVar.a(a2);
        return udVar;
    }

    private void d() {
        this.f6437c.addAll(this.f6435a.j());
    }

    public AdobeAssetPackagePages b() {
        return this.f6435a;
    }

    public int c() {
        return this.f6436b;
    }

    public void b(Bundle bundle) {
        bundle.putInt("startindex", this.f6436b);
        bundle.putString("collectionhref", this.f6435a.getHref().toString());
        bundle.putString("collectionparenthref", this.f6435a.getParentHref().toString());
    }

    public void b(int i) {
        this.f6436b = i;
    }

    private void a(AdobeAssetPackagePages adobeAssetPackagePages) {
        this.f6435a = adobeAssetPackagePages;
        d();
    }

    public static ud a(AdobeAssetPackagePages adobeAssetPackagePages, ArrayList<AdobeAssetFile> arrayList, int i) {
        ud udVar = new ud();
        udVar.a(adobeAssetPackagePages, arrayList);
        udVar.b(i);
        return udVar;
    }

    private void a(AdobeAssetPackagePages adobeAssetPackagePages, ArrayList<AdobeAssetFile> arrayList) {
        this.f6435a = adobeAssetPackagePages;
        this.f6437c = arrayList;
    }

    public int a() {
        ArrayList<AdobeAssetFile> arrayList = this.f6437c;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public AdobeAssetFile a(int i) {
        ArrayList<AdobeAssetFile> arrayList = this.f6437c;
        if (arrayList == null || i < 0 || i >= arrayList.size()) {
            return null;
        }
        return this.f6437c.get(i);
    }
}
