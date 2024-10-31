package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.pa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2136pa implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f22966a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22967b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2136pa(ProjectGalleryActivity projectGalleryActivity, Intent intent) {
        this.f22967b = projectGalleryActivity;
        this.f22966a = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.w("ProjectGalleryActivity", "KmIntent DependencyCheck Error : " + taskError.getMessage());
        this.f22967b.d(this.f22966a);
    }
}
