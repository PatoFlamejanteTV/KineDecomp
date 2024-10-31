package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class lz extends TimelineView.b {

    /* renamed from: a */
    final /* synthetic */ NexTimelineItem f4080a;
    final /* synthetic */ int[] b;
    final /* synthetic */ TimelineView c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lz(TimelineView timelineView, NexTimelineItem nexTimelineItem, int[] iArr) {
        super();
        this.c = timelineView;
        this.f4080a = nexTimelineItem;
        this.b = iArr;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        if (nexTimelineItem == this.f4080a) {
            this.b[0] = i3;
            this.b[1] = (i3 + i4) - 1;
            a(1);
        }
    }
}
