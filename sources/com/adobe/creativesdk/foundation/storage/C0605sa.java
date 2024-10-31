package com.adobe.creativesdk.foundation.storage;

import java.lang.ref.WeakReference;
import java.util.Date;

/* compiled from: AdobeAssetLibraryItem.java */
@Deprecated
/* renamed from: com.adobe.creativesdk.foundation.storage.sa, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0605sa {

    /* renamed from: a, reason: collision with root package name */
    protected String f7410a;

    /* renamed from: b, reason: collision with root package name */
    protected String f7411b;

    /* renamed from: c, reason: collision with root package name */
    protected Date f7412c;

    /* renamed from: d, reason: collision with root package name */
    protected Date f7413d;

    /* renamed from: e, reason: collision with root package name */
    protected WeakReference<C0590oa> f7414e;

    /* renamed from: f, reason: collision with root package name */
    protected String f7415f;

    /* JADX INFO: Access modifiers changed from: protected */
    public C0605sa(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Ha ha, String str, C0590oa c0590oa) {
        Date date = new Date(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(ha.a("library#created")));
        Date date2 = new Date(com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.Za.a(ha.a("library#modified")));
        this.f7410a = ha.f();
        this.f7415f = str;
        this.f7411b = ha.g();
        this.f7412c = date;
        this.f7413d = date2;
        this.f7414e = new WeakReference<>(c0590oa);
    }
}
