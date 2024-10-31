package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ja implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f3998a;
    final /* synthetic */ iy b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ja(iy iyVar, Bitmap bitmap) {
        this.b = iyVar;
        this.f3998a = bitmap;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        TextView textView;
        this.b.c.b.a(this.b.f3995a, this.b.b, this.f3998a, ProjectEditActivity.InsertPosition.CurrentTime, true, true, (ProjectEditActivity.c) null);
        textView = this.b.c.b.M;
        textView.setVisibility(4);
        this.b.c.b.L();
    }
}
