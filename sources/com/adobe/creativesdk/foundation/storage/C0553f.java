package com.adobe.creativesdk.foundation.storage;

import java.util.Comparator;
import java.util.Map;

/* compiled from: AdobeAssetDrawFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.f */
/* loaded from: classes.dex */
class C0553f implements Comparator<String> {

    /* renamed from: a */
    final /* synthetic */ Map f7241a;

    /* renamed from: b */
    final /* synthetic */ C0557g f7242b;

    public C0553f(C0557g c0557g, Map map) {
        this.f7242b = c0557g;
        this.f7241a = map;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(String str, String str2) {
        return Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7241a.get(str)).a()).compareTo(Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7241a.get(str2)).a()));
    }
}
