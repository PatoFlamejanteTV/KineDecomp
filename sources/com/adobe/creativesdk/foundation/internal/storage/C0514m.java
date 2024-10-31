package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.adobeinternal.cloud.AdobeCloud;
import com.adobe.creativesdk.foundation.storage.AdobeAssetDataSourceType;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: AdobeAssetLibraryDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.m */
/* loaded from: classes.dex */
public class C0514m implements ga {

    /* renamed from: a */
    private AdobeCloud f6598a;

    /* renamed from: b */
    private ha f6599b;

    /* renamed from: c */
    AdobeAssetDataSourceType f6600c = AdobeAssetDataSourceType.AdobeAssetDataSourceLibrary;

    public C0514m(AdobeCloud adobeCloud) {
        this.f6598a = adobeCloud;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void b() {
        a((ha) null);
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public void c() {
        a();
    }

    public ArrayList<C0614ub> d() {
        return c.a.a.a.a.b.a.a.b.c().e().e();
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public int getCount() {
        if (!c.a.a.a.a.b.a.a.b.f() || c.a.a.a.a.b.a.a.b.c().e().e() == null) {
            return 0;
        }
        return c.a.a.a.a.b.a.a.b.c().e().e().size();
    }

    public ArrayList<C0614ub> a(String str) {
        if (str == null) {
            return null;
        }
        if (str.isEmpty()) {
            return d();
        }
        ArrayList<C0614ub> e2 = c.a.a.a.a.b.a.a.b.c().e().e();
        ArrayList<C0614ub> arrayList = new ArrayList<>();
        if (e2 != null) {
            Iterator<C0614ub> it = e2.iterator();
            while (it.hasNext()) {
                C0614ub next = it.next();
                if (next.m() != null && next.m().toLowerCase().contains(str.toLowerCase())) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    public void a(ha haVar) {
        this.f6599b = haVar;
    }

    @Override // com.adobe.creativesdk.foundation.internal.storage.ga
    public boolean a() {
        if (!c.a.a.a.a.b.a.a.b.f()) {
            return false;
        }
        c.a.a.a.a.b.a.a.b.c().a(new C0513l(this));
        return false;
    }
}
