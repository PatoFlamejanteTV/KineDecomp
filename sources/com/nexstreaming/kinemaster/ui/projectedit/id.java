package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class id implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem f3974a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public id(ProjectEditActivity projectEditActivity, NexAudioClipItem nexAudioClipItem) {
        this.b = projectEditActivity;
        this.f3974a = nexAudioClipItem;
    }

    @Override // java.lang.Runnable
    public void run() {
        TimelineView timelineView;
        timelineView = this.b.k;
        timelineView.a((NexTimelineItem) this.f3974a, true);
    }
}
