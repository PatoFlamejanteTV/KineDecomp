package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexThemeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class js implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4016a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public js(ProjectEditActivity projectEditActivity) {
        this.f4016a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexThemeView nexThemeView;
        nexThemeView = this.f4016a.j;
        nexThemeView.setVisibility(0);
    }
}
