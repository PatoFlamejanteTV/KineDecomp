package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Zf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22197a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Zf(ProjectEditActivity projectEditActivity) {
        this.f22197a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor z;
        z = this.f22197a.z();
        z.a(NexEditor.FastPreviewOption.nofx, 0, true);
    }
}
