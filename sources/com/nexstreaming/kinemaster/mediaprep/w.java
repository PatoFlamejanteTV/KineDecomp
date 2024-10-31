package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class w implements ResultTask.OnResultAvailableListener<MediaStoreItem.MediaSupportType> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3546a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaPrepManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem) {
        this.c = mediaPrepManager;
        this.f3546a = msid;
        this.b = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<MediaStoreItem.MediaSupportType> resultTask, Task.Event event, MediaStoreItem.MediaSupportType mediaSupportType) {
        boolean f;
        f = this.c.f(this.f3546a);
        if (!f) {
            this.c.a(this.f3546a, this.b, mediaSupportType);
        }
    }
}
