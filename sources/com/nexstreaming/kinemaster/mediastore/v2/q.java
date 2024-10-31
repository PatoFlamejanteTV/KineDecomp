package com.nexstreaming.kinemaster.mediastore.v2;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThumbnailHelper.java */
/* loaded from: classes.dex */
public final class q implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3600a;
    final /* synthetic */ Object b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(String str, Object obj) {
        this.f3600a = str;
        this.b = obj;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        Log.d("ThumbnailHelper", "[makeSingleThumbnail][onFailure] path: " + this.f3600a);
        synchronized (this.b) {
            this.b.notify();
        }
    }
}
