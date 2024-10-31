package com.nexstreaming.kinemaster.ui.share;

import android.util.Log;
import android.view.View;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
class bq implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareQualityActivity f4328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(ShareQualityActivity shareQualityActivity) {
        this.f4328a = shareQualityActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        View view;
        View view2;
        View view3;
        Runnable runnable;
        Log.e("ShareQualityActivity", taskError.getMessage());
        view = this.f4328a.g;
        view.setVisibility(8);
        view2 = this.f4328a.f;
        view2.setVisibility(8);
        view3 = this.f4328a.g;
        runnable = this.f4328a.l;
        view3.removeCallbacks(runnable);
    }
}
