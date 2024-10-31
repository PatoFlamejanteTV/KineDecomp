package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class as implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4145a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(ProjectGalleryActivity projectGalleryActivity) {
        this.f4145a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Log.i("ProjectGalleryActivity", "KmIntent DependencyCheck Cancel");
    }
}
