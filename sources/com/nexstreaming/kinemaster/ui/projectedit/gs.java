package com.nexstreaming.kinemaster.ui.projectedit;

import android.os.Handler;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
public class gs implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItem f3936a;
    final /* synthetic */ gr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gs(gr grVar, MediaStoreItem mediaStoreItem) {
        this.b = grVar;
        this.f3936a = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.b.b.a(this.f3936a.c(), null, ProjectEditActivity.InsertPosition.BeforeSelected, true, true);
        this.b.b.A();
        new Handler().postDelayed(new gt(this), 300L);
    }
}
