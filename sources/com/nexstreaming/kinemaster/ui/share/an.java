package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class an implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ ad f4298a;

    public an(ad adVar) {
        this.f4298a = adVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Log.i("ShareBaseActivity", "uploadTask:onSuccess");
    }
}
