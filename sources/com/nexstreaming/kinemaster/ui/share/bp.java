package com.nexstreaming.kinemaster.ui.share;

import android.view.View;
import com.nexstreaming.app.general.task.Task;

/* compiled from: ShareQualityActivity.java */
/* loaded from: classes.dex */
class bp implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareQualityActivity f4327a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(ShareQualityActivity shareQualityActivity) {
        this.f4327a = shareQualityActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        View view;
        View view2;
        View view3;
        Runnable runnable;
        view = this.f4327a.g;
        view.setVisibility(8);
        view2 = this.f4327a.f;
        view2.setVisibility(8);
        view3 = this.f4327a.g;
        runnable = this.f4327a.l;
        view3.removeCallbacks(runnable);
    }
}
