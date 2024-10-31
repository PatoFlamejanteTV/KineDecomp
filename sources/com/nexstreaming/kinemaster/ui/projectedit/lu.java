package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TimelineView.java */
/* loaded from: classes.dex */
public class lu implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f4075a;
    final /* synthetic */ boolean b;
    final /* synthetic */ TimelineView c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public lu(TimelineView timelineView, NexTimelineItem nexTimelineItem, boolean z) {
        this.c = timelineView;
        this.f4075a = nexTimelineItem;
        this.b = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        Runnable runnable;
        NexTimeline nexTimeline;
        runnable = this.c.y;
        if (runnable == this) {
            if (this.f4075a != null) {
                NexTimeline timeline = this.f4075a.getTimeline();
                nexTimeline = this.c.S;
                if (timeline == nexTimeline) {
                    this.c.c(this.f4075a, this.b);
                    return;
                }
            }
            this.c.y = null;
        }
    }
}
