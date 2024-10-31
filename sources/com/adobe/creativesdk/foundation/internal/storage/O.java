package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
public class O implements c.a.a.a.b<ArrayList<AdobePhotoCollection>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f5247a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f5248b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ U f5249c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public O(U u, String str, c.a.a.a.b bVar) {
        this.f5249c = u;
        this.f5247a = str;
        this.f5248b = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoCollection> arrayList) {
        this.f5249c.f5261f = true;
        this.f5249c.f5262g = this.f5247a;
        c.a.a.a.b bVar = this.f5248b;
        if (bVar != null) {
            bVar.b(arrayList);
        }
    }
}
