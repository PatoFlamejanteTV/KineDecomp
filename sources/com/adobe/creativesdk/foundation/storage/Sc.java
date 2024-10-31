package com.adobe.creativesdk.foundation.storage;

import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoCatalog.java */
/* loaded from: classes.dex */
public class Sc implements c.a.a.a.b<ArrayList<AdobePhotoCollection>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f7120a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobePhotoCatalog f7121b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sc(AdobePhotoCatalog adobePhotoCatalog, c.a.a.a.b bVar) {
        this.f7121b = adobePhotoCatalog;
        this.f7120a = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoCollection> arrayList) {
        c.a.a.a.b bVar = this.f7120a;
        if (bVar != null) {
            bVar.b(arrayList);
        }
    }
}
