package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.util.Log;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.usage.KMUsage;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes.dex */
public class at implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f4146a;
    final /* synthetic */ ProjectGalleryActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ProjectGalleryActivity projectGalleryActivity, Intent intent) {
        this.b = projectGalleryActivity;
        this.f4146a = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Log.i("ProjectGalleryActivity", "KmIntent DependencyCheck OK");
        KMUsage.ProjectList_EditProject.logEvent(NativeProtocol.WEB_DIALOG_ACTION, "Shared KM Intent OK Dependency checker");
        this.b.b(this.f4146a);
    }
}
