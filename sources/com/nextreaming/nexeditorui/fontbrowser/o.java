package com.nextreaming.nexeditorui.fontbrowser;

import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;

/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
class o implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgressBar f4639a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(l lVar, ProgressBar progressBar) {
        this.b = lVar;
        this.f4639a = progressBar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f4639a.setMax(i2);
        this.f4639a.setProgress(i);
    }
}
