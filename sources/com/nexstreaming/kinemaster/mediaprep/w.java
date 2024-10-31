package com.nexstreaming.kinemaster.mediaprep;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class w implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20837a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20838b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20839c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f20839c = mediaPrepManager;
        this.f20837a = mediaStoreItemId;
        this.f20838b = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        boolean b2;
        b2 = this.f20839c.b(this.f20837a);
        if (b2) {
            return;
        }
        Log.i("MediaPrepManager", "Unable to check supported; will check after download: " + taskError.getMessage());
        this.f20839c.b(this.f20837a, this.f20838b, MediaSupportType.Unknown);
    }
}
