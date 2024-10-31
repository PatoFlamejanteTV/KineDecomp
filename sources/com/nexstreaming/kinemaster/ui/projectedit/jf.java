package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class jf implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f4003a;
    final /* synthetic */ je b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public jf(je jeVar, MediaStoreItem mediaStoreItem) {
        this.b = jeVar;
        this.f4003a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        TextView textView;
        this.b.f4002a.a(this.f4003a.c(), this.f4003a, (Bitmap) null, ProjectEditActivity.InsertPosition.BeforeSelected, true, true, (ProjectEditActivity.c) null);
        textView = this.b.f4002a.M;
        textView.setVisibility(4);
        this.b.f4002a.L();
    }
}
