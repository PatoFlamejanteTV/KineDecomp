package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.lh, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1948lh implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22439a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f22440b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimelineView f22441c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1948lh(TimelineView timelineView, NexTimelineItem nexTimelineItem, boolean z) {
        this.f22441c = timelineView;
        this.f22439a = nexTimelineItem;
        this.f22440b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        NexTimeline nexTimeline;
        runnable = this.f22441c.Sb;
        if (runnable != this) {
            return;
        }
        NexTimelineItem nexTimelineItem = this.f22439a;
        if (nexTimelineItem != null) {
            NexTimeline timeline = nexTimelineItem.getTimeline();
            nexTimeline = this.f22441c.z;
            if (timeline == nexTimeline) {
                this.f22441c.c(this.f22439a, this.f22440b);
                return;
            }
        }
        this.f22441c.Sb = null;
    }
}
