package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.kt */
/* renamed from: com.nexstreaming.kinemaster.ui.mediabrowser.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnLongClickListenerC1832j implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21692a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ViewOnLongClickListenerC1832j(C1829g c1829g) {
        this.f21692a = c1829g;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        InterfaceC1827e interfaceC1827e;
        RecyclerView recyclerView = (RecyclerView) this.f21692a.m(com.nexstreaming.app.kinemasterfree.b.mediaListView);
        Integer valueOf = recyclerView != null ? Integer.valueOf(recyclerView.getChildLayoutPosition(view)) : null;
        if (valueOf == null || valueOf.intValue() == -1) {
            return false;
        }
        interfaceC1827e = this.f21692a.f21687h;
        if (interfaceC1827e == null) {
            return true;
        }
        interfaceC1827e.b(valueOf.intValue());
        return true;
    }
}
