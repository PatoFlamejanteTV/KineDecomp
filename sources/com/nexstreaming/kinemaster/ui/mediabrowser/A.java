package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.DialogInterface;

/* compiled from: MediaBrowserFragment.kt */
/* loaded from: classes.dex */
final class A implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21641a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21642b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21641a = c1829g;
        this.f21642b = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        InterfaceC1827e interfaceC1827e;
        rVar = this.f21641a.f21685f;
        if (rVar != null) {
            rVar.dismiss();
        }
        interfaceC1827e = this.f21641a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.e(this.f21642b);
        }
    }
}
