package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class ly extends TimelineView.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4079a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ List d;
    final /* synthetic */ TimelineView e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ly(TimelineView timelineView, int i, int i2, int i3, List list) {
        super();
        this.e = timelineView;
        this.f4079a = i;
        this.b = i2;
        this.c = i3;
        this.d = list;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i5 - this.f4079a;
        int i8 = i3 - ((int) this.e.bw.left);
        if (i8 > this.b || i7 > this.c) {
            a(0);
            return;
        }
        if (i7 > 0 && i8 > 0) {
            this.d.add(new com.nextreaming.nexeditorui.ef(i7, i8));
        }
        int i9 = (i5 + i6) - this.f4079a;
        int i10 = (i3 + i4) - ((int) this.e.bw.left);
        if (i10 > this.b || i9 > this.c) {
            a(0);
        } else if (i9 > 0 && i10 > 0) {
            this.d.add(new com.nextreaming.nexeditorui.ef(i9, i10));
        }
    }
}
