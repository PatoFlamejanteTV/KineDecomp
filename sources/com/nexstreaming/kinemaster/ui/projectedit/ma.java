package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class ma extends TimelineView.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4082a;
    final /* synthetic */ TimelineView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ma(TimelineView timelineView, int i) {
        super();
        this.b = timelineView;
        this.f4082a = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        float f;
        if (this.f4082a >= i5 && this.f4082a < i5 + i6) {
            a(((int) (i4 * ((this.f4082a - i5) / i6))) + i3);
        } else if (i == i2 - 1) {
            float f2 = this.f4082a - ((i5 + i6) - 1);
            f = this.b.G;
            a(i3 + i4 + ((int) ((f2 * f) / 1000.0d)));
        }
    }
}
