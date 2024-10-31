package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
class Pc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7091a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7092b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7093c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pc(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.c cVar, AdobePhotoCatalog adobePhotoCatalog2) {
        this.f7093c = adobePhotoCatalog;
        this.f7091a = cVar;
        this.f7092b = adobePhotoCatalog2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7091a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        Level level = Level.WARN;
        String simpleName = AdobePhotoCatalog.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to refresh the catalog ");
        str = this.f7092b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
