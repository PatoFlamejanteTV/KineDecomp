package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.ImageLayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.qf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1991qf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageLayer f22488a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22489b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1991qf(ProjectEditActivity projectEditActivity, ImageLayer imageLayer) {
        this.f22489b = projectEditActivity;
        this.f22488a = imageLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22489b.i(this.f22488a);
    }
}
