package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
class Nc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7072a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7073b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7074c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Nc(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.c cVar, AdobePhotoCatalog adobePhotoCatalog2) {
        this.f7074c = adobePhotoCatalog;
        this.f7072a = cVar;
        this.f7073b = adobePhotoCatalog2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7072a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        Level level = Level.WARN;
        String simpleName = AdobePhotoCatalog.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to update catalog ");
        str = this.f7073b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
