package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.view.View;

/* compiled from: MediaBrowserFragment.kt */
/* loaded from: classes.dex */
final class u implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21706a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21707b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21706a = c1829g;
        this.f21707b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1827e interfaceC1827e;
        interfaceC1827e = this.f21706a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.a(this.f21707b);
        }
    }
}
