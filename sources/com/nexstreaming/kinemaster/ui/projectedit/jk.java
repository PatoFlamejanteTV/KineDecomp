package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jk implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4008a;
    final /* synthetic */ ji b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jk(ji jiVar, MediaStoreItem mediaStoreItem) {
        this.b = jiVar;
        this.f4008a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        TextView textView;
        this.b.f4006a.a(this.f4008a.c(), this.f4008a, bitmap, ProjectEditActivity.InsertPosition.AfterSelected, true, true, (ProjectEditActivity.c) null);
        textView = this.b.f4006a.M;
        textView.setVisibility(4);
        this.b.f4006a.L();
    }
}
