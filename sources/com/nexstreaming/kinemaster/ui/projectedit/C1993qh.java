package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.qh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1993qh extends TimelineView.b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22491d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f22492e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f22493f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f22494g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ TimelineView f22495h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1993qh(TimelineView timelineView, int i, int i2, int i3, List list) {
        super();
        this.f22495h = timelineView;
        this.f22491d = i;
        this.f22492e = i2;
        this.f22493f = i3;
        this.f22494g = list;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i5 - this.f22491d;
        int i8 = i3 - ((int) this.f22495h.eb.left);
        if (i8 <= this.f22492e && i7 <= this.f22493f) {
            if (i7 > 0 && i8 > 0) {
                this.f22494g.add(new com.nextreaming.nexeditorui.ob(i7, i8));
            }
            int i9 = (i5 + i6) - this.f22491d;
            int i10 = (i3 + i4) - ((int) this.f22495h.eb.left);
            if (i10 > this.f22492e || i9 > this.f22493f) {
                a(0);
                return;
            } else {
                if (i9 <= 0 || i10 <= 0) {
                    return;
                }
                this.f22494g.add(new com.nextreaming.nexeditorui.ob(i9, i10));
                return;
            }
        }
        a(0);
    }
}
