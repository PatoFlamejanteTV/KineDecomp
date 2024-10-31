package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
class Rc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7104a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7105b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7106c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rc(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.c cVar, AdobePhotoCatalog adobePhotoCatalog2) {
        this.f7106c = adobePhotoCatalog;
        this.f7104a = cVar;
        this.f7105b = adobePhotoCatalog2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7104a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        Level level = Level.WARN;
        String simpleName = AdobePhotoCatalog.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed to delete the catalog ");
        str = this.f7105b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
