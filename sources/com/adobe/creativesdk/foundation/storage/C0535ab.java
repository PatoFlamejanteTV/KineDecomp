package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;

/* compiled from: AdobeAssetSharedProject.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ab, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0535ab extends AdobeAssetPackagePages {
    /* JADX INFO: Access modifiers changed from: protected */
    public C0535ab(com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar, com.adobe.creativesdk.foundation.internal.storage.model.resources.e eVar2) {
        super(eVar, eVar2);
    }

    @Override // com.adobe.creativesdk.foundation.storage.Ya
    @Deprecated
    public void a(vd vdVar, c.a.a.a.c<AdobeCSDKException> cVar) {
        super.a(new _a(this, this, vdVar), cVar);
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages, com.adobe.creativesdk.foundation.storage.Ya, com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public boolean equals(Object obj) {
        if (obj instanceof C0535ab) {
            return super.equals(obj);
        }
        return false;
    }

    @Override // com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages, com.adobe.creativesdk.foundation.storage.Ya, com.adobe.creativesdk.foundation.storage.C0578la, com.adobe.creativesdk.foundation.storage.C0533a
    public int hashCode() {
        return 42;
    }
}
