package com.nextreaming.nexeditorui.fontbrowser;

import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
public class q implements Task.OnProgressListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgressBar f4641a;
    final /* synthetic */ l b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar, ProgressBar progressBar) {
        this.b = lVar;
        this.f4641a = progressBar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnProgressListener
    public void onProgress(Task task, Task.Event event, int i, int i2) {
        this.f4641a.setMax(i2);
        this.f4641a.setProgress(i);
    }
}
