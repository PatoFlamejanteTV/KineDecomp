package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.a.e;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f20822a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f20823b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f20824c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Task f20825d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20826e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MediaPrepManager mediaPrepManager, String str, String str2, String str3, Task task) {
        this.f20826e = mediaPrepManager;
        this.f20822a = str;
        this.f20823b = str2;
        this.f20824c = str3;
        this.f20825d = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        e.a aVar = new e.a(this.f20826e.f20774b);
        aVar.a(this.f20822a);
        aVar.b(this.f20823b, new d(this));
        aVar.a(this.f20824c, new DialogInterfaceOnClickListenerC1805c(this));
        aVar.a(new DialogInterfaceOnCancelListenerC1804b(this));
        aVar.a().show();
    }
}
