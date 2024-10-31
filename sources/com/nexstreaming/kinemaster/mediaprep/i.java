package com.nexstreaming.kinemaster.mediaprep;

import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f20798a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ j f20799b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(j jVar, String str) {
        this.f20799b = jVar;
        this.f20798a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        KineMasterApplication.f24056d.h().a(new File(this.f20798a)).onComplete(new h(this));
    }
}
