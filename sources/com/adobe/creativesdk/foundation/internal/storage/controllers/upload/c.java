package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import com.adobe.creativesdk.foundation.internal.utils.logging.Level;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCatalog;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;
import java.util.ArrayList;

/* compiled from: AdobeCreatePhotoCollectionDialogFragment.java */
/* loaded from: classes.dex */
class c implements c.a.a.a.b<ArrayList<AdobePhotoCatalog>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f6440a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.b f6441b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ c.a.a.a.c f6442c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ e f6443d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(e eVar, String str, c.a.a.a.b bVar, c.a.a.a.c cVar) {
        this.f6443d = eVar;
        this.f6440a = str;
        this.f6441b = bVar;
        this.f6442c = cVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(ArrayList<AdobePhotoCatalog> arrayList) {
        if (arrayList.size() > 1) {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.WARN, "AdobeCreatePhotoCollectionDialogFragment", "More than one catalog was unexpected.");
        } else {
            com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.DEBUG, "", "Loaded photo catalog.");
        }
        AdobePhotoCollection.create(this.f6440a, arrayList.get(0), this.f6441b, this.f6442c);
    }
}
