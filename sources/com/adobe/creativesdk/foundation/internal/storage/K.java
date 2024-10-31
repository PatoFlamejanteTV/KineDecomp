package com.adobe.creativesdk.foundation.internal.storage;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCollectionsDataSource.java */
/* loaded from: classes.dex */
public class K implements c.a.a.a.b<ArrayList<AdobePhotoCatalog>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f5243a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public K(U u) {
        this.f5243a = u;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoCatalog> arrayList) {
        ja jaVar;
        ja jaVar2;
        AdobePhotoCatalog adobePhotoCatalog;
        if (arrayList.size() > 1) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, U.class.getSimpleName(), "More than one catalog was unexpected.");
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, U.class.getSimpleName(), "Loaded photo catalog.");
        }
        this.f5243a.f5257b = arrayList.get(0);
        this.f5243a.f5258c = true;
        jaVar = this.f5243a.f5256a;
        if (jaVar != null) {
            jaVar2 = this.f5243a.f5256a;
            adobePhotoCatalog = this.f5243a.f5257b;
            jaVar2.a(adobePhotoCatalog);
        }
        this.f5243a.f();
    }
}
