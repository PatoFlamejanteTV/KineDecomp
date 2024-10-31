package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class mb implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22954a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.project.k f22955b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22956c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public mb(ProjectGalleryActivity projectGalleryActivity, VideoEditor videoEditor, com.nexstreaming.kinemaster.project.k kVar) {
        this.f22956c = projectGalleryActivity;
        this.f22954a = videoEditor;
        this.f22955b = kVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22954a.J().onComplete(new C2128lb(this));
    }
}
