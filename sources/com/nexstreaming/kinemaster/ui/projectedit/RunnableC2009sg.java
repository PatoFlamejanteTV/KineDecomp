package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.sg, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC2009sg implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f22528a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22529b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2009sg(ProjectEditActivity projectEditActivity, NexTimelineItem nexTimelineItem) {
        this.f22529b = projectEditActivity;
        this.f22528a = nexTimelineItem;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC2025f interfaceC2025f;
        interfaceC2025f = this.f22529b.T;
        interfaceC2025f.setSelectedItem(this.f22528a);
    }
}
