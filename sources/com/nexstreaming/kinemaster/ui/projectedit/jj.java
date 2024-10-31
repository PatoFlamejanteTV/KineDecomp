package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jj implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4007a;
    final /* synthetic */ ji b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jj(ji jiVar, MediaStoreItem mediaStoreItem) {
        this.b = jiVar;
        this.f4007a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        TextView textView;
        this.b.f4006a.a(this.f4007a.c(), this.f4007a, (Bitmap) null, ProjectEditActivity.InsertPosition.AfterSelected, true, true, (ProjectEditActivity.c) null);
        textView = this.b.f4006a.M;
        textView.setVisibility(4);
        this.b.f4006a.L();
    }
}
