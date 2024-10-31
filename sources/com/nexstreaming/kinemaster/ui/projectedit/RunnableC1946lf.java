package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2025f;
import com.nextreaming.nexeditorui.NexAudioClipItem;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.lf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class RunnableC1946lf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexAudioClipItem f22436a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22437b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1946lf(ProjectEditActivity projectEditActivity, NexAudioClipItem nexAudioClipItem) {
        this.f22437b = projectEditActivity;
        this.f22436a = nexAudioClipItem;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC2025f interfaceC2025f;
        interfaceC2025f = this.f22437b.T;
        interfaceC2025f.b(this.f22436a, true);
    }
}
