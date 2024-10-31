package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.th, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2019th extends TimelineView.b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22544d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ TimelineView f22545e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2019th(TimelineView timelineView, int i) {
        super();
        this.f22545e = timelineView;
        this.f22544d = i;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        float f2;
        int i7 = this.f22544d;
        if (i7 >= i5 && i7 < i5 + i6) {
            a(i3 + ((int) (i4 * ((i7 - i5) / i6))));
            return;
        }
        if (i == i2 - 1) {
            float f3 = this.f22544d - ((i5 + i6) - 1);
            f2 = this.f22545e.n;
            double d2 = f3 * f2;
            Double.isNaN(d2);
            a(i3 + i4 + ((int) (d2 / 1000.0d)));
        }
    }
}
