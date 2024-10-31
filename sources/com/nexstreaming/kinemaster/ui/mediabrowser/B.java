package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.DialogInterface;

/* compiled from: MediaBrowserFragment.kt */
/* loaded from: classes.dex */
final class B implements DialogInterface.OnCancelListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21643a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21644b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21643a = c1829g;
        this.f21644b = cVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        InterfaceC1827e interfaceC1827e;
        interfaceC1827e = this.f21643a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.e(this.f21644b);
        }
    }
}
