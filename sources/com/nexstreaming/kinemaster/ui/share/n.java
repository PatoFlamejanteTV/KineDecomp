package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class N implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f23290a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f23291b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ U f23292c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(U u, int i, int i2) {
        this.f23292c = u;
        this.f23290a = i;
        this.f23291b = i2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f23292c.a(i + ((this.f23290a - 1) * i2), i2 * this.f23291b);
    }
}
