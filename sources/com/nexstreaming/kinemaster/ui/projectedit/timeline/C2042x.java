package com.nexstreaming.kinemaster.ui.projectedit.timeline;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager;
import com.nextreaming.nexeditorui.NexTimeline;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SecondaryTrackDragDecoration.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.timeline.x, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2042x implements UniformTimelineLayoutManager.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ y f22711a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2042x(y yVar) {
        this.f22711a = yVar;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.timeline.UniformTimelineLayoutManager.a
    public void a(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i;
        int i2;
        String str;
        int i3;
        this.f22711a.h().b(this);
        int i4 = this.f22711a.h().C + this.f22711a.h().E + (this.f22711a.h().G / 2);
        NexTimeline m = this.f22711a.m();
        i = this.f22711a.D;
        int trackIndexById = m.getTrackIndexById(i);
        NexTimeline m2 = this.f22711a.m();
        i2 = this.f22711a.E;
        int trackIndexById2 = m2.getTrackIndexById(i2) - (this.f22711a.s == 5 ? 1 : 0);
        int i5 = i4;
        for (int i6 = 0; i6 <= trackIndexById2; i6++) {
            if (trackIndexById != i6) {
                i5 += this.f22711a.h().a(this.f22711a.m().getTrackAtIndex(i6));
            }
        }
        int round = i5 - Math.round(this.f22711a.h().u);
        str = y.z;
        StringBuilder sb = new StringBuilder();
        sb.append("[onItemDrop] targetTrackId: ");
        i3 = this.f22711a.E;
        sb.append(i3);
        sb.append(", trackOffset: ");
        sb.append(round);
        sb.append(", scrollY; ");
        sb.append(Math.round(this.f22711a.h().u));
        Log.d(str, sb.toString());
        this.f22711a.a(0, round, new C2041w(this)).a((bolts.i) new C2040v(this));
    }
}
