package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Pa implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22876a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Pa(ProjectGalleryActivity projectGalleryActivity) {
        this.f22876a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (taskError == Task.TIMEOUT) {
            Log.i("START_FLOW", "ProjectGalleryActivity:checkForDeviceSupportDBUpdates TIMEOUT");
        } else {
            Log.i("START_FLOW", "ProjectGalleryActivity:checkForDeviceSupportDBUpdates FAIL");
        }
        Log.i("ProjectGalleryActivity", "checkForDeviceSupportDBUpdates FAIL: " + taskError.getMessage());
        this.f22876a.a(ProjectGalleryActivity.LoadingTask.DeviceCompatibilityDBCheck);
    }
}
