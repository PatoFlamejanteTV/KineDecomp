package com.nexstreaming.kinemaster.ui.projectgallery;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ProjectGalleryActivity.java */
/* loaded from: classes2.dex */
class Y implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2097ba f22896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Y(C2097ba c2097ba) {
        this.f22896a = c2097ba;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.w("ProjectGalleryActivity", "failed dependency check", taskError.getException());
    }
}
