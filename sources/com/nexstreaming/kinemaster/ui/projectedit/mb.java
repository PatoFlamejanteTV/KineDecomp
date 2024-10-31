package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class mb extends TimelineView.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4083a;
    final /* synthetic */ TimelineView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mb(TimelineView timelineView, int i) {
        super();
        this.b = timelineView;
        this.f4083a = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        float f;
        if (this.f4083a < i3) {
            a(i5);
            return;
        }
        if (this.f4083a >= i3 && this.f4083a < i3 + i4) {
            a(((int) (i6 * ((this.f4083a - i3) / i4))) + i5);
        } else if (i + 1 == i2) {
            f = this.b.G;
            a(((int) (((this.f4083a - ((i3 + i4) - 1)) * 1000.0d) / f)) + i5 + i6);
        }
    }
}
