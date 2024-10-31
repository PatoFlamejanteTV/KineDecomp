package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ShareBaseActivity.java */
/* loaded from: classes.dex */
public class ap implements Task.OnProgressListener {

    /* renamed from: a */
    final /* synthetic */ ad f4300a;

    public ap(ad adVar) {
        this.f4300a = adVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        Log.i("ShareBaseActivity", "uploadTask:onProgress : " + i + "/" + i2 + "  " + ((i * 100) / i2) + "%");
    }
}
