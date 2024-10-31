package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Intent;
import android.net.Uri;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
public class Ka implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.project.k f22853a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ProjectGalleryActivity f22854b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(ProjectGalleryActivity projectGalleryActivity, com.nexstreaming.kinemaster.project.k kVar) {
        this.f22854b = projectGalleryActivity;
        this.f22853a = kVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        O o;
        o = this.f22854b.Ba;
        o.c();
        Intent intent = new Intent(this.f22854b, (Class<?>) ProjectEditActivity.class);
        intent.setFlags(67108864);
        intent.setData(Uri.fromFile(this.f22853a.e()));
        this.f22854b.startActivityForResult(intent, 8226);
        this.f22854b.overridePendingTransition(0, 0);
        this.f22854b.ha();
    }
}
