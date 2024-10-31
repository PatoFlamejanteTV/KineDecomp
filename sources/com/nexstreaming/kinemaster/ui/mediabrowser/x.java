package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.view.View;

/* compiled from: MediaBrowserFragment.kt */
/* loaded from: classes.dex */
final class x implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21712a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21713b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21712a = c1829g;
        this.f21713b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1827e interfaceC1827e;
        interfaceC1827e = this.f21712a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.d(this.f21713b);
        }
    }
}
