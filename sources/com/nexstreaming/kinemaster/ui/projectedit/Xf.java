package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Xf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22171a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xf(ProjectEditActivity projectEditActivity) {
        this.f22171a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor z;
        z = this.f22171a.z();
        z.a(NexEditor.FastPreviewOption.nofx, 0, true);
    }
}
