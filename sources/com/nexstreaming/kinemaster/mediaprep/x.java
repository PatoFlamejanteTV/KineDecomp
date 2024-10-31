package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class x implements ResultTask.OnResultAvailableListener<MediaSupportType> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20840a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20841b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20842c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f20842c = mediaPrepManager;
        this.f20840a = mediaStoreItemId;
        this.f20841b = cVar;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<MediaSupportType> resultTask, Task.Event event, MediaSupportType mediaSupportType) {
        boolean b2;
        b2 = this.f20842c.b(this.f20840a);
        if (b2) {
            return;
        }
        this.f20842c.b(this.f20840a, this.f20841b, mediaSupportType);
    }
}
