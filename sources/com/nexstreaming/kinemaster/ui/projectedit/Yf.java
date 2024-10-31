package com.nexstreaming.kinemaster.ui.projectedit;

import com.nextreaming.nexvideoeditor.NexThemeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Yf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22182a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Yf(ProjectEditActivity projectEditActivity) {
        this.f22182a = projectEditActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        NexThemeView nexThemeView;
        nexThemeView = this.f22182a.Q;
        nexThemeView.setVisibility(0);
    }
}
