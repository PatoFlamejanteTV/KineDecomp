package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.view.View;

/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnClickListenerC1841t implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21705a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnClickListenerC1841t(C1829g c1829g) {
        this.f21705a = c1829g;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        InterfaceC1827e interfaceC1827e;
        interfaceC1827e = this.f21705a.f21687h;
        if (interfaceC1827e != null) {
            interfaceC1827e.c();
        }
    }
}
