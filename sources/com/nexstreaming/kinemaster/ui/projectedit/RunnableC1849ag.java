package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexThemeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.ag, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1849ag implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22220a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1849ag(ProjectEditActivity projectEditActivity) {
        this.f22220a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexThemeView nexThemeView;
        nexThemeView = this.f22220a.Q;
        nexThemeView.setVisibility(8);
    }
}
