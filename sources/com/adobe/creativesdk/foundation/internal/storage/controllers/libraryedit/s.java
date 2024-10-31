package com.adobe.creativesdk.foundation.internal.storage.controllers.libraryedit;

import android.support.v4.app.FragmentManager;
import android.view.View;
import com.adobe.creativesdk.foundation.storage.C0614ub;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeLibraryDeleteAlert.java */
/* loaded from: classes.dex */
public class s implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ t f6244a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(t tVar) {
        this.f6244a = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C0614ub c0614ub;
        a.b(true);
        a.c(true);
        FragmentManager fragmentManager = this.f6244a.getFragmentManager();
        c0614ub = this.f6244a.f6249e;
        a.a(c0614ub.k(), fragmentManager, AdobeDesignLibraryEditOperation.ADOBE_LIBRARY_COMP_EDIT_OPERATION_DELETE, new r(this)).b();
        this.f6244a.dismiss();
    }
}
