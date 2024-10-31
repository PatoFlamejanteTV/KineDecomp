package com.nexstreaming.kinemaster.mediastore;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ThumbnailHelper.kt */
/* loaded from: classes.dex */
public final class l implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f20923a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f20924b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(String str, Object obj) {
        this.f20923a = str;
        this.f20924b = obj;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        String str;
        m mVar = m.f20926b;
        str = m.f20925a;
        Log.d(str, "[makeSingleThumbnail][onFailure] path: " + this.f20923a);
        synchronized (this.f20924b) {
            this.f20924b.notify();
            kotlin.k kVar = kotlin.k.f28545a;
        }
    }
}
