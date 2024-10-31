package com.nexstreaming.kinemaster.mediaprep;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class v implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3545a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ MediaPrepManager c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(MediaPrepManager mediaPrepManager, MSID msid, MediaStoreItem mediaStoreItem) {
        this.c = mediaPrepManager;
        this.f3545a = msid;
        this.b = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        boolean f;
        f = this.c.f(this.f3545a);
        if (!f) {
            Log.i("MediaPrepManager", "Unable to check supported; will check after download: " + taskError.getMessage());
            this.c.a(this.f3545a, this.b, MediaStoreItem.MediaSupportType.Unknown);
        }
    }
}
