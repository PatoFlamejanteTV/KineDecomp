package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexThemeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ju implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f4018a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ju(ProjectEditActivity projectEditActivity) {
        this.f4018a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexThemeView nexThemeView;
        nexThemeView = this.f4018a.j;
        nexThemeView.setVisibility(8);
    }
}
