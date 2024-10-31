package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
public class gx implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f3941a;
    final /* synthetic */ gu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gx(gu guVar, Bitmap bitmap) {
        this.b = guVar;
        this.f3941a = bitmap;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.b.b.a(this.b.f3938a.c(), this.b.f3938a, this.f3941a, ProjectEditActivity.InsertPosition.CurrentTime, true, true);
        this.b.b.b.A();
        new Handler().postDelayed(new gy(this), 300L);
    }
}
