package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;
import java.util.List;

/* compiled from: AdobeLibraryManager.java */
/* loaded from: classes.dex */
class Cb implements com.adobe.creativesdk.foundation.adobeinternal.imageservice.w {

    /* renamed from: a */
    final /* synthetic */ List f6938a;

    /* renamed from: b */
    final /* synthetic */ ArrayList f6939b;

    /* renamed from: c */
    final /* synthetic */ Db f6940c;

    public Cb(Db db, List list, ArrayList arrayList) {
        this.f6940c = db;
        this.f6938a = list;
        this.f6939b = arrayList;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean a(String str, String str2) {
        if (this.f6938a.indexOf(str) != -1) {
            return true;
        }
        this.f6939b.add(str);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean b(String str, String str2) {
        if (this.f6938a.indexOf(str) != -1) {
            return true;
        }
        this.f6939b.add(str);
        return true;
    }

    @Override // com.adobe.creativesdk.foundation.adobeinternal.imageservice.w
    public boolean c(String str, String str2) {
        return true;
    }
}
