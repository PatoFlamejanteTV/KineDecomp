package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.lb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2128lb implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mb f22950a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2128lb(mb mbVar) {
        this.f22950a = mbVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean b2;
        if (this.f22950a.f22955b.e().getName().equals(this.f22950a.f22954a.t().getName())) {
            return;
        }
        mb mbVar = this.f22950a;
        b2 = mbVar.f22956c.b(mbVar.f22954a.t());
        this.f22950a.f22956c.k(b2);
    }
}
