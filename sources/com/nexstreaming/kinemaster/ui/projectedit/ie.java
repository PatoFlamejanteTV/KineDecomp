package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.VideoLayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ie implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoLayer f3975a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ie(ProjectEditActivity projectEditActivity, VideoLayer videoLayer) {
        this.b = projectEditActivity;
        this.f3975a = videoLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c(this.f3975a);
    }
}
