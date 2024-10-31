package com.adobe.creativesdk.foundation.storage;

import java.util.Comparator;
import java.util.Map;

/* compiled from: AdobeAssetPSMixFile.java */
/* loaded from: classes.dex */
class Sa implements Comparator<String> {

    /* renamed from: a */
    final /* synthetic */ Map f7110a;

    /* renamed from: b */
    final /* synthetic */ Ta f7111b;

    public Sa(Ta ta, Map map) {
        this.f7111b = ta;
        this.f7110a = map;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(String str, String str2) {
        return Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7110a.get(str)).a()).compareTo(Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7110a.get(str2)).a()));
    }
}
