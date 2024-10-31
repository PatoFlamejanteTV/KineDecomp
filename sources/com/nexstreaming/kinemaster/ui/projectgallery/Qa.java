package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.DeviceSupportResponse;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Qa implements ResultTask.OnResultAvailableListener<DeviceSupportResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22879a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qa(ProjectGalleryActivity projectGalleryActivity) {
        this.f22879a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<DeviceSupportResponse> resultTask, Task.Event event, DeviceSupportResponse deviceSupportResponse) {
        Log.i("START_FLOW", "ProjectGalleryActivity:checkForDeviceSupportDBUpdates SUCCESS");
        NexEditorDeviceProfile.setDeviceSupportResponse(deviceSupportResponse);
        this.f22879a.a(ProjectGalleryActivity.LoadingTask.DeviceCompatibilityDBCheck);
    }
}
