package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexeditorui.NexTimelineItem;

/* compiled from: VoiceRecorderFragment.java */
/* loaded from: classes.dex */
class mn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexTimelineItem f4095a;
    final /* synthetic */ mm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mn(mm mmVar, NexTimelineItem nexTimelineItem) {
        this.b = mmVar;
        this.f4095a = nexTimelineItem;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c.f4089a.c(this.f4095a);
        this.b.c.f4089a.m = false;
    }
}
