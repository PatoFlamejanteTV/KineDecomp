package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
public class i implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f6220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(l lVar) {
        this.f6220a = lVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        l.a aVar;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        aVar = this.f6220a.k;
        aVar.a(booleanValue);
        a.a(false);
        this.f6220a.f6227b.onComplete();
    }
}
