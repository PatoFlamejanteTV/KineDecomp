package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.support.v4.app.FragmentManager;
import android.view.View;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryDeleteAlert.java */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f6242a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(t tVar) {
        this.f6242a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0614ub c0614ub;
        a.b(true);
        a.c(true);
        FragmentManager fragmentManager = this.f6242a.getFragmentManager();
        c0614ub = this.f6242a.f6249e;
        l a2 = a.a(c0614ub.k(), fragmentManager, AdobeDesignLibraryEditOperation.ADOBE_PUBLIC_LIBRARY_COMP_EDIT_OPERATION_DELETE, new p(this));
        a2.b();
        a2.b();
        this.f6242a.dismiss();
    }
}
