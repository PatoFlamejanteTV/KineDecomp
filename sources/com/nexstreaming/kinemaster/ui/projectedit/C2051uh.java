package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.uh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2051uh extends TimelineView.b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22734d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TimelineView f22735e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2051uh(TimelineView timelineView, int i) {
        super();
        this.f22735e = timelineView;
        this.f22734d = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        float f2;
        int i7 = this.f22734d;
        if (i7 < i3) {
            a(i5);
            return;
        }
        if (i7 >= i3 && i7 < i3 + i4) {
            a(i5 + ((int) (i6 * ((i7 - i3) / i4))));
            return;
        }
        if (i + 1 == i2) {
            double d2 = this.f22734d - ((i3 + i4) - 1);
            Double.isNaN(d2);
            f2 = this.f22735e.n;
            double d3 = f2;
            Double.isNaN(d3);
            a(i5 + i6 + ((int) ((d2 * 1000.0d) / d3)));
        }
    }
}
