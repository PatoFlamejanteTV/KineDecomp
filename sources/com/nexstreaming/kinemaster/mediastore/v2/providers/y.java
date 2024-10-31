package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.google.api.services.drive.model.File;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class y implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f3598a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(l lVar, ResultTask resultTask) {
        this.b = lVar;
        this.f3598a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        MediaStoreItem a2;
        a2 = this.b.a(file);
        if (a2 == null) {
            this.f3598a.sendFailure(MediaStore.MediaStoreError.ItemNotFound);
        } else {
            this.f3598a.sendResult(a2);
        }
    }
}
