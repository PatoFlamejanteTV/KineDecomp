package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes.dex */
public class ix implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3994a;
    final /* synthetic */ MediaStoreItem b;
    final /* synthetic */ iw c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ix(iw iwVar, MSID msid, MediaStoreItem mediaStoreItem) {
        this.c = iwVar;
        this.f3994a = msid;
        this.b = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        TextView textView;
        this.c.b.a(this.f3994a, this.b, (Bitmap) null, ProjectEditActivity.InsertPosition.BeforeSelected, true, true, (ProjectEditActivity.c) null);
        textView = this.c.b.M;
        textView.setVisibility(4);
        this.c.b.L();
    }
}
