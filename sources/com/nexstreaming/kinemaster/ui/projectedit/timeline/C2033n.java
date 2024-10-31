package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.support.v7.widget.RecyclerView;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PrimaryItemDragDragDecoration.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.n, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2033n implements UniformTimelineLayoutManager.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2034o f22691a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2033n(C2034o c2034o) {
        this.f22691a = c2034o;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager.a
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        float f2;
        this.f22691a.h().b(this);
        f2 = this.f22691a.E;
        this.f22691a.a((int) ((f2 - this.f22691a.p.c()) + 0.5f), this.f22691a.h().E).a((bolts.i) new C2032m(this));
    }
}
