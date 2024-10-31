package com.nextreaming.nexeditorui.newproject.b;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;

/* compiled from: ThemeBrowserFragment.java */
/* loaded from: classes.dex */
class h implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4670a;
    final /* synthetic */ f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(f fVar, String str) {
        this.b = fVar;
        this.f4670a = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        EffectLibrary effectLibrary;
        f fVar = this.b;
        effectLibrary = this.b.f4667a;
        fVar.e = effectLibrary.e(this.f4670a);
    }
}
