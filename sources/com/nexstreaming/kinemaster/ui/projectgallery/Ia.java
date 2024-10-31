package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Ia implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22841a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(ProjectGalleryActivity projectGalleryActivity) {
        this.f22841a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.d("ProjectGalleryActivity", "failed dependency checker", taskError.getException());
    }
}
