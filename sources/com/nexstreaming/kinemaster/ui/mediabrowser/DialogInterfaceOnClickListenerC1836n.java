package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.DialogInterface;

/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class DialogInterfaceOnClickListenerC1836n implements DialogInterface.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21696a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21697b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DialogInterfaceOnClickListenerC1836n(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21696a = c1829g;
        this.f21697b = cVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        InterfaceC1827e interfaceC1827e;
        dialogInterface.dismiss();
        interfaceC1827e = this.f21696a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.f(this.f21697b);
        }
    }
}
