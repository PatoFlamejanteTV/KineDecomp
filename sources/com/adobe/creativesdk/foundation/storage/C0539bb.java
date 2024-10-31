package com.adobe.creativesdk.foundation.storage;

import java.util.Comparator;
import java.util.Map;

/* compiled from: AdobeAssetSketchbook.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.bb */
/* loaded from: classes.dex */
class C0539bb implements Comparator<String> {

    /* renamed from: a */
    final /* synthetic */ Map f7209a;

    /* renamed from: b */
    final /* synthetic */ C0543cb f7210b;

    public C0539bb(C0543cb c0543cb, Map map) {
        this.f7210b = c0543cb;
        this.f7209a = map;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(String str, String str2) {
        return Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7209a.get(str)).a()).compareTo(Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7209a.get(str2)).a()));
    }
}
