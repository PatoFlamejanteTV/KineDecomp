package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SecondaryItemDragDecoration.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.t, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2038t implements UniformTimelineLayoutManager.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2039u f22708a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2038t(C2039u c2039u) {
        this.f22708a = c2039u;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager.a
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        this.f22708a.h().b(this);
        View a2 = this.f22708a.h().a(this.f22708a.h().a((Fa) ((NexSecondaryTimelineItem) this.f22708a.p.getItem()).getTrack()));
        int i = this.f22708a.h().F;
        int i2 = this.f22708a.h().G;
        float c2 = this.f22708a.p.c() - this.f22708a.h().t;
        float e2 = this.f22708a.p.e() - this.f22708a.h().u;
        this.f22708a.a(((int) Math.floor(((r8.getStartTime() * this.f22708a.k()) - r2) - c2)) + 1, ((int) Math.floor(((a2.getTop() + (i2 / 2)) + (r8.getSubTrackMapping() * (i + i2))) - e2)) + 1).a((bolts.i) new C2037s(this));
    }
}
