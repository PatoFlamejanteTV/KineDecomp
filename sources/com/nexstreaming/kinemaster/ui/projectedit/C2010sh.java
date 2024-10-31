package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.sh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2010sh extends TimelineView.b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22530d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int[] f22531e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ TimelineView f22532f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2010sh(TimelineView timelineView, NexTimelineItem nexTimelineItem, int[] iArr) {
        super();
        this.f22532f = timelineView;
        this.f22530d = nexTimelineItem;
        this.f22531e = iArr;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        if (nexTimelineItem == this.f22530d) {
            int[] iArr = this.f22531e;
            iArr[0] = i3;
            iArr[1] = (i3 + i4) - 1;
            a(1);
        }
    }
}
