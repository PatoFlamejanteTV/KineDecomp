package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit.l;
import java.util.Observable;
import java.util.Observer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeDesignLibraryEditSession.java */
/* loaded from: classes.dex */
public class b implements Observer {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ l f6199a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(l lVar) {
        this.f6199a = lVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        l.a aVar;
        boolean booleanValue = ((Boolean) obj).booleanValue();
        aVar = this.f6199a.k;
        aVar.a(booleanValue);
        a.a(false);
        this.f6199a.f6227b.onComplete();
    }
}
