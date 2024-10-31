package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1722j implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1728p f20101a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1722j(C1728p c1728p) {
        this.f20101a = c1728p;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        rVar = this.f20101a.f20113b;
        rVar.i(i2);
        rVar2 = this.f20101a.f20113b;
        rVar2.j(i);
    }
}
