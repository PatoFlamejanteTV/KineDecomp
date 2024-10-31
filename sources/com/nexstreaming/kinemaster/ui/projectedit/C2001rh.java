package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.TimelineView;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.rh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2001rh extends TimelineView.b {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f22511d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f22512e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f22513f;

    /* renamed from: g, reason: collision with root package name */
    final /* synthetic */ List f22514g;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ TimelineView f22515h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2001rh(TimelineView timelineView, int i, int i2, int i3, List list) {
        super();
        this.f22515h = timelineView;
        this.f22511d = i;
        this.f22512e = i2;
        this.f22513f = i3;
        this.f22514g = list;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.TimelineView.b
    void a(int i, int i2, NexTimelineItem nexTimelineItem, int i3, int i4, int i5, int i6, boolean z) {
        int i7 = i5 - this.f22511d;
        int i8 = i3 - ((int) this.f22515h.eb.left);
        if (i8 <= this.f22512e && i7 <= this.f22513f) {
            if (i7 > 0 && i8 > 0) {
                this.f22514g.add(new com.nextreaming.nexeditorui.ob(i7, i8));
            }
            int i9 = (i5 + i6) - this.f22511d;
            int i10 = (i3 + i4) - ((int) this.f22515h.eb.left);
            if (i10 > this.f22512e || i9 > this.f22513f) {
                a(0);
                return;
            } else {
                if (i9 <= 0 || i10 <= 0) {
                    return;
                }
                this.f22514g.add(new com.nextreaming.nexeditorui.ob(i9, i10));
                return;
            }
        }
        a(0);
    }
}
