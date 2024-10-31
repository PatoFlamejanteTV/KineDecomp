package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;
import com.adobe.creativesdk.foundation.storage.Ya;
import com.adobe.creativesdk.foundation.storage.vd;
import java.util.Collections;
import java.util.List;

/* compiled from: AdobeAssetMultiRootedDataSource.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0524q implements vd {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ya f6770a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f6771b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ int[] f6772c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ List f6773d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ C0525s f6774e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0524q(C0525s c0525s, Ya ya, List list, int[] iArr, List list2) {
        this.f6774e = c0525s;
        this.f6770a = ya;
        this.f6771b = list;
        this.f6772c = iArr;
        this.f6773d = list2;
    }

    @Override // com.adobe.creativesdk.foundation.storage.vd
    public void a() {
        Ya ya = this.f6770a;
        if (!(ya instanceof AdobeAssetPackagePages) || ((AdobeAssetPackagePages) ya).j() != null) {
            this.f6771b.add(this.f6770a);
        }
        int[] iArr = this.f6772c;
        iArr[0] = iArr[0] + 1;
        if (iArr[0] >= this.f6773d.size()) {
            Collections.sort(this.f6771b, this.f6774e.f6781c);
            ((C0532z) this.f6774e.f6779a.get()).f6578f.addAll(this.f6771b);
            this.f6774e.f6782d.lock();
            C0532z.b(this.f6774e.f6786h.f6804e);
            this.f6774e.f6783e.signal();
            this.f6774e.f6782d.unlock();
        }
    }
}
