package com.adobe.creativesdk.foundation.internal.storage.controllers.edit;

import com.adobe.creativesdk.foundation.storage.C0533a;
import java.util.ArrayList;

/* compiled from: AdobeAssetViewEditSelectedAssetsController.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.edit.k */
/* loaded from: classes.dex */
public class C0393k {

    /* renamed from: a */
    private static C0393k f6044a;

    /* renamed from: b */
    private ArrayList<C0533a> f6045b;

    private C0393k() {
    }

    public static C0393k c() {
        if (f6044a == null) {
            f6044a = new C0393k();
        }
        return f6044a;
    }

    public void a(ArrayList<C0533a> arrayList) {
        this.f6045b = arrayList;
    }

    public ArrayList<C0533a> b() {
        return this.f6045b;
    }

    public static void a() {
        f6044a = null;
    }
}
