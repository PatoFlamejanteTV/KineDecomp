package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class ar implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f4144a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(ProjectGalleryActivity projectGalleryActivity, Intent intent) {
        this.b = projectGalleryActivity;
        this.f4144a = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.e("ProjectGalleryActivity", "KmIntent DependencyCheck Error : " + taskError.getMessage());
        KMUsage.ProjectList_EditProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "Shared KM Intent Error Dependency checker");
        this.b.b(this.f4144a);
    }
}
