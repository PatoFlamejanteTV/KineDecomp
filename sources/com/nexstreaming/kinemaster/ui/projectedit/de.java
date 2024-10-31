package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes2.dex */
class De implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f21817a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Fe f21818b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public De(Fe fe, Bitmap bitmap) {
        this.f21818b = fe;
        this.f21817a = bitmap;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Fe fe = this.f21818b;
        fe.f21847b.f21877b.a(fe.f21846a.getId(), this.f21818b.f21846a, this.f21817a, ProjectEditActivity.InsertPosition.CurrentTime, true, true, true);
        this.f21818b.f21847b.f21877b.ga();
        new Handler().postDelayed(new Ce(this), 300L);
    }
}
