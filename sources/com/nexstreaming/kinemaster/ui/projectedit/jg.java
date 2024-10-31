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
public class jg implements ResultTask.OnResultAvailableListener<Bitmap> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4004a;
    final /* synthetic */ je b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jg(je jeVar, MediaStoreItem mediaStoreItem) {
        this.b = jeVar;
        this.f4004a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<Bitmap> resultTask, Task.Event event, Bitmap bitmap) {
        TextView textView;
        this.b.f4002a.a(this.f4004a.c(), this.f4004a, bitmap, ProjectEditActivity.InsertPosition.BeforeSelected, true, true, (ProjectEditActivity.c) null);
        textView = this.b.f4002a.M;
        textView.setVisibility(4);
        this.b.f4002a.L();
    }
}
