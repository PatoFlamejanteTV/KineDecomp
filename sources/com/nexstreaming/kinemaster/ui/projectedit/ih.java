package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
class ih implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f3978a;
    final /* synthetic */ ProjectEditActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ih(ProjectEditActivity projectEditActivity, MediaStoreItem mediaStoreItem) {
        this.b = projectEditActivity;
        this.f3978a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.b.a(this.f3978a.c(), this.f3978a, (Bitmap) null);
    }
}
