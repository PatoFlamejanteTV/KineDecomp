package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.vh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2060vh extends TimelineView.b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22744d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TimelineView f22745e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2060vh(TimelineView timelineView, int i, int i2) {
        super(i);
        this.f22745e = timelineView;
        this.f22744d = i2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        int i7;
        int i8;
        int i9 = this.f22744d;
        TimelineView timelineView = this.f22745e;
        int i10 = timelineView.Ea;
        if (i9 + i10 < (i4 / 2) + i3) {
            if (z) {
                i8 = timelineView.S;
                a(i8);
                return;
            } else {
                a(i + 1);
                return;
            }
        }
        if (i9 + i10 < i3 + i4) {
            if (z) {
                i7 = timelineView.S;
                a(i7);
            } else {
                a(i + 2);
            }
        }
    }
}
