package com.nexstreaming.kinemaster.ui.projectgallery;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.tracelog.DeviceSupportResponse;
import com.nexstreaming.kinemaster.ui.projectgallery.ProjectGalleryActivity;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class bm implements ResultTask.OnResultAvailableListener<DeviceSupportResponse> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f4166a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bm(ProjectGalleryActivity projectGalleryActivity) {
        this.f4166a = projectGalleryActivity;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<DeviceSupportResponse> resultTask, Task.Event event, DeviceSupportResponse deviceSupportResponse) {
        NexEditorDeviceProfile.setDeviceSupportResponse(deviceSupportResponse);
        this.f4166a.a(ProjectGalleryActivity.LoadingTask.DeviceCompatibilityDBCheck);
    }
}
