package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import java.net.URI;
import java.util.Date;

/* compiled from: AdobeAssetMultiRootedData.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0516o extends C0507f {
    String i;
    URI j;
    Date k;
    Date l;
    boolean m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0516o(AdobeAssetDataSourceType adobeAssetDataSourceType, AdobeCloud adobeCloud) {
        super(adobeAssetDataSourceType, adobeCloud);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0516o) {
            return this.i.equals(((C0516o) obj).i);
        }
        return false;
    }

    public boolean h() {
        return this.m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0516o() {
        super(null, null);
    }
}
