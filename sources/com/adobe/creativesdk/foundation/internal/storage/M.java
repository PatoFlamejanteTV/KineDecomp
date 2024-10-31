package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
public class M implements c.a.a.a.b<ArrayList<AdobePhotoCollection>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f5245a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public M(U u) {
        this.f5245a = u;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoCollection> arrayList) {
        ja jaVar;
        ja jaVar2;
        ArrayList arrayList2;
        if (arrayList != null) {
            this.f5245a.i = arrayList;
            U u = this.f5245a;
            arrayList2 = u.i;
            u.f5263h = arrayList2.size() == 0;
            this.f5245a.f5259d = true;
        }
        jaVar = this.f5245a.f5256a;
        if (jaVar != null) {
            jaVar2 = this.f5245a.f5256a;
            jaVar2.b();
        }
    }
}
