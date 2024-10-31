package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jt implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jt(ProjectEditActivity projectEditActivity) {
        this.f4017a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexEditor E;
        E = this.f4017a.E();
        E.a(NexEditor.FastPreviewOption.nofx, 0, true);
    }
}
