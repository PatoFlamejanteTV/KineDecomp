package com.adobe.creativesdk.foundation.storage;

import java.util.Comparator;
import java.util.Map;

/* compiled from: AdobeAssetPSFixFile.java */
/* loaded from: classes.dex */
class Pa implements Comparator<String> {

    /* renamed from: a */
    final /* synthetic */ Map f7085a;

    /* renamed from: b */
    final /* synthetic */ Qa f7086b;

    public Pa(Qa qa, Map map) {
        this.f7086b = qa;
        this.f7085a = map;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(String str, String str2) {
        return Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7085a.get(str)).a()).compareTo(Long.valueOf(((com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha) this.f7085a.get(str2)).a()));
    }
}
