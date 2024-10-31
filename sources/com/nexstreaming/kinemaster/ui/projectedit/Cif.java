package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.ImageLayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.if, reason: invalid class name */
/* loaded from: classes.dex */
public class Cif implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImageLayer f3976a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cif(ProjectEditActivity projectEditActivity, ImageLayer imageLayer) {
        this.b = projectEditActivity;
        this.f3976a = imageLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.c(this.f3976a);
    }
}
