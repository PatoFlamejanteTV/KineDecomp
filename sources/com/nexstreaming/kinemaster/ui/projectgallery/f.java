package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DependencyChecker.java */
/* loaded from: classes.dex */
public class f implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ c f4207a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(c cVar) {
        this.f4207a = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        com.nexstreaming.kinemaster.ui.a.e eVar;
        com.nexstreaming.kinemaster.ui.a.e eVar2;
        com.nexstreaming.kinemaster.ui.a.e eVar3;
        eVar = this.f4207a.b.h;
        eVar.c(R.string.downloading_theme_progress);
        eVar2 = this.f4207a.b.h;
        eVar2.i(i2);
        eVar3 = this.f4207a.b.h;
        eVar3.h(i);
    }
}
