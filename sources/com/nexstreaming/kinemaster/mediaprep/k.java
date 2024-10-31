package com.nexstreaming.kinemaster.mediaprep;

import com.nextreaming.nexeditorui.KineMasterApplication;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class k implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3534a;
    final /* synthetic */ j b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar, String str) {
        this.b = jVar;
        this.f3534a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        KineMasterApplication.a().c().a(new File(this.f3534a)).onComplete(new l(this));
    }
}
