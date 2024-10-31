package com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: ACLMAssetsListProviderMgr.java */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static a f4079a;

    /* renamed from: b, reason: collision with root package name */
    ArrayList<C0022a> f4080b = new ArrayList<>();

    /* compiled from: ACLMAssetsListProviderMgr.java */
    /* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.aclibmanager.core.a$a, reason: collision with other inner class name */
    /* loaded from: classes.dex */
    private class C0022a {

        /* renamed from: a, reason: collision with root package name */
        f f4081a;

        /* renamed from: b, reason: collision with root package name */
        ACUserAssetType f4082b;
    }

    a() {
    }

    public static a a() {
        if (f4079a == null) {
            f4079a = new a();
        }
        return f4079a;
    }

    public f a(ACUserAssetType aCUserAssetType) {
        Iterator<C0022a> it = this.f4080b.iterator();
        while (it.hasNext()) {
            C0022a next = it.next();
            if (next.f4082b == aCUserAssetType) {
                return next.f4081a;
            }
        }
        return c.a.a.a.a.b.a.b.b.b.a(aCUserAssetType);
    }
}
