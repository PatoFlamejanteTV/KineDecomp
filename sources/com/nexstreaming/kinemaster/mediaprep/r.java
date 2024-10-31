package com.nexstreaming.kinemaster.mediaprep;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class r implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3541a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ String c;
    final /* synthetic */ MediaPrepManager d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem, String str) {
        this.d = mediaPrepManager;
        this.f3541a = msid;
        this.b = mediaStoreItem;
        this.c = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.d.b(this.f3541a, this.b, this.c);
    }
}
