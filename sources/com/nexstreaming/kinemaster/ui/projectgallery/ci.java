package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
class ci implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ch f4189a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(ch chVar) {
        this.f4189a = chVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        boolean a2;
        if (!this.f4189a.b.a().getName().equals(this.f4189a.f4188a.g().getName())) {
            a2 = this.f4189a.c.a(this.f4189a.f4188a.g());
            this.f4189a.c.c(a2);
        }
    }
}
