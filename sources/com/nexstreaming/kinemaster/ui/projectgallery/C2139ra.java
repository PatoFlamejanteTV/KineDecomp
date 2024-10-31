package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectgallery.ra, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2139ra implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Intent f22973a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22974b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2139ra(ProjectGalleryActivity projectGalleryActivity, Intent intent) {
        this.f22974b = projectGalleryActivity;
        this.f22973a = intent;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f22974b.d(this.f22973a);
    }
}
