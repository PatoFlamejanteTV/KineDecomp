package com.adobe.creativesdk.foundation.storage;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
public class Tc implements c.a.a.a.c<AdobeCSDKException> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f7131a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7132b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7133c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Tc(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.c cVar, AdobePhotoCatalog adobePhotoCatalog2) {
        this.f7133c = adobePhotoCatalog;
        this.f7131a = cVar;
        this.f7132b = adobePhotoCatalog2;
    }

    @Override // c.a.a.a.c
    public void a(AdobeCSDKException adobeCSDKException) {
        String str;
        c.a.a.a.c cVar = this.f7131a;
        if (cVar != null) {
            cVar.a(adobeCSDKException);
            return;
        }
        Level level = Level.WARN;
        String simpleName = AdobePhotoCatalog.class.getSimpleName();
        StringBuilder sb = new StringBuilder();
        sb.append("Failed list the collections in catalog ");
        str = this.f7132b._name;
        sb.append(str);
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(level, simpleName, sb.toString());
    }
}
