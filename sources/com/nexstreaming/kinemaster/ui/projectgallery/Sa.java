package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Sa implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22883a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Sa(ProjectGalleryActivity projectGalleryActivity) {
        this.f22883a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        ProjectGalleryActivity projectGalleryActivity = this.f22883a;
        projectGalleryActivity.c(projectGalleryActivity.getIntent());
        this.f22883a.N();
    }
}
