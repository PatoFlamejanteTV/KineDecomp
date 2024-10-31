package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.u, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2144u implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ O f22985a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2144u(O o) {
        this.f22985a = o;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        com.nexstreaming.kinemaster.ui.a.r rVar;
        com.nexstreaming.kinemaster.ui.a.r rVar2;
        com.nexstreaming.kinemaster.ui.a.r rVar3;
        rVar = this.f22985a.i;
        rVar.e(R.string.downloading_theme_progress);
        rVar2 = this.f22985a.i;
        rVar2.i(i2);
        rVar3 = this.f22985a.i;
        rVar3.j(i);
    }
}
