package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class kn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f4038a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public kn(ProjectEditActivity projectEditActivity, NexTimelineItem nexTimelineItem) {
        this.b = projectEditActivity;
        this.f4038a = nexTimelineItem;
    }

    @Override // java.lang.Runnable
    public void run() {
        TimelineView timelineView;
        timelineView = this.b.k;
        timelineView.setSelectedItem(this.f4038a);
    }
}
