package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import kotlin.TypeCastException;

/* compiled from: OptionAudioEffectFragment.kt */
/* loaded from: classes2.dex */
public final class u extends RecyclerView.OnScrollListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ RecyclerView f22267a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ w f22268b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(RecyclerView recyclerView, w wVar) {
        this.f22267a = recyclerView;
        this.f22268b = wVar;
    }

    @Override // android.support.v7.widget.RecyclerView.OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        super.onScrolled(recyclerView, i, i2);
        RecyclerView.LayoutManager layoutManager = this.f22267a.getLayoutManager();
        if (layoutManager != null) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.findFirstVisibleItemPosition() == 0) {
                w.c(this.f22268b).setVisibility(8);
            } else {
                w.c(this.f22268b).setVisibility(0);
            }
            int findLastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();
            kotlin.jvm.internal.h.a((Object) this.f22267a.getAdapter(), "adapter");
            if (findLastVisibleItemPosition == r4.getItemCount() - 1) {
                w.b(this.f22268b).setVisibility(8);
                return;
            } else {
                w.b(this.f22268b).setVisibility(0);
                return;
            }
        }
        throw new TypeCastException("null cannot be cast to non-null type android.support.v7.widget.LinearLayoutManager");
    }
}
