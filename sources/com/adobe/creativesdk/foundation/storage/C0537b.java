package com.adobe.creativesdk.foundation.storage;

import java.util.Comparator;
import java.util.Map;

/* compiled from: AdobeAssetCompFile.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.b */
/* loaded from: classes.dex */
class C0537b implements Comparator<String> {

    /* renamed from: a */
    final /* synthetic */ Map f7203a;

    /* renamed from: b */
    final /* synthetic */ C0541c f7204b;

    public C0537b(C0541c c0541c, Map map) {
        this.f7204b = c0541c;
        this.f7203a = map;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(String str, String str2) {
        return Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7203a.get(str)).a()).compareTo(Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7203a.get(str2)).a()));
    }
}
