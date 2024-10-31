package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.layer.VideoLayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.pf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class RunnableC1982pf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoLayer f22479a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectEditActivity f22480b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC1982pf(ProjectEditActivity projectEditActivity, VideoLayer videoLayer) {
        this.f22480b = projectEditActivity;
        this.f22479a = videoLayer;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f22480b.i(this.f22479a);
    }
}
