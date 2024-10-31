package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.content.Context;
import android.view.View;

/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
final class ViewOnLongClickListenerC1838p implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21699a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f21700b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLongClickListenerC1838p(C1829g c1829g, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f21699a = c1829g;
        this.f21700b = cVar;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        Context context;
        Context context2;
        if (this.f21700b.h()) {
            context2 = this.f21699a.v;
            com.nexstreaming.kinemaster.mediainfo.J.a(context2, null, this.f21700b);
            return false;
        }
        context = this.f21699a.v;
        com.nexstreaming.kinemaster.mediainfo.J.a(context, this.f21700b.getPath(), null);
        return false;
    }
}
