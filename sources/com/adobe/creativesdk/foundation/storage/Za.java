package com.adobe.creativesdk.foundation.storage;

import java.util.Comparator;

/* compiled from: AdobeAssetSharedProject.java */
/* loaded from: classes.dex */
class Za implements Comparator<com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha> {

    /* renamed from: a */
    final /* synthetic */ _a f7186a;

    public Za(_a _aVar) {
        this.f7186a = _aVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha, com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha2) {
        return Long.valueOf(ha.a()).compareTo(Long.valueOf(ha2.a()));
    }
}
