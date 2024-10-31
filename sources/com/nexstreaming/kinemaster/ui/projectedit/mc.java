package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class mc extends TimelineView.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f4084a;
    final /* synthetic */ TimelineView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public mc(TimelineView timelineView, int i, int i2) {
        super(i);
        this.b = timelineView;
        this.f4084a = i2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        int i7;
        int i8;
        if (this.f4084a + this.b.aW >= (i4 / 2) + i3) {
            if (this.f4084a + this.b.aW < i3 + i4) {
                if (z) {
                    i7 = this.b.ao;
                    a(i7);
                    return;
                } else {
                    a(i + 2);
                    return;
                }
            }
            return;
        }
        if (z) {
            i8 = this.b.ao;
            a(i8);
        } else {
            a(i + 1);
        }
    }
}
