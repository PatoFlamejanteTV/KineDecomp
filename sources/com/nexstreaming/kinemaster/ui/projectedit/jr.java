package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jr implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4015a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jr(ProjectEditActivity projectEditActivity) {
        this.f4015a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor E;
        E = this.f4015a.E();
        E.a(NexEditor.FastPreviewOption.nofx, 0, true);
    }
}
