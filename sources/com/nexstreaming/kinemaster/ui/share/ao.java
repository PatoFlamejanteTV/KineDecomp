package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class ao implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ ad f4299a;

    public ao(ad adVar) {
        this.f4299a = adVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Log.i("ShareBaseActivity", "uploadTask:onComplete");
        this.f4299a.g();
    }
}
