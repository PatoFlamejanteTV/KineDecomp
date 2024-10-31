package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bl implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4165a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(ProjectGalleryActivity projectGalleryActivity) {
        this.f4165a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.i("ProjectGalleryActivity", "checkForDeviceSupportDBUpdates FAIL: " + taskError.getMessage());
        this.f4165a.a(ProjectGalleryActivity.LoadingTask.DeviceCompatibilityDBCheck);
    }
}
