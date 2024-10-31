package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.view.View;

/* compiled from: MediaBrowserFragment.kt */
/* loaded from: classes.dex */
final class w implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21710a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21711b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21710a = c1829g;
        this.f21711b = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1827e interfaceC1827e;
        interfaceC1827e = this.f21710a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.c(this.f21711b);
        }
    }
}
