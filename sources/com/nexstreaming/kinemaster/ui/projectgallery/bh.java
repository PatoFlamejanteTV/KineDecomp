package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bh implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4161a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(ProjectGalleryActivity projectGalleryActivity) {
        this.f4161a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4161a.C = false;
    }
}
