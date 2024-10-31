package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ib, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2119ib implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22934a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f22935b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22936c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2119ib(ProjectGalleryActivity projectGalleryActivity, VideoEditor videoEditor, String str) {
        this.f22936c = projectGalleryActivity;
        this.f22934a = videoEditor;
        this.f22935b = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22936c.a(this.f22934a.s().a(), this.f22935b);
    }
}
