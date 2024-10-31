package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ch implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f4188a;
    final /* synthetic */ com.nexstreaming.kinemaster.project.f b;
    final /* synthetic */ ProjectGalleryActivity c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(ProjectGalleryActivity projectGalleryActivity, VideoEditor videoEditor, com.nexstreaming.kinemaster.project.f fVar) {
        this.c = projectGalleryActivity;
        this.f4188a = videoEditor;
        this.b = fVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4188a.l().onComplete(new ci(this));
    }
}
