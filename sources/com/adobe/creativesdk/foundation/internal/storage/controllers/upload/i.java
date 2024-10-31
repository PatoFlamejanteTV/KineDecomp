package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import com.adobe.creativesdk.foundation.storage.C0578la;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUploadCreateNewFolderDialogFragment.java */
/* loaded from: classes.dex */
public class i implements c.a.a.a.b<C0578la> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f6446a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(k kVar) {
        this.f6446a = kVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void b(C0578la c0578la) {
        boolean z;
        x xVar;
        z = this.f6446a.o;
        if (z) {
            this.f6446a.p = new x();
            xVar = this.f6446a.p;
            xVar.f6483b = c0578la;
            return;
        }
        this.f6446a.a(c0578la);
    }
}
