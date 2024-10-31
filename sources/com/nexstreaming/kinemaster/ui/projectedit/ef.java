package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;

/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
class Ef implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Bitmap f21831a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Ff f21832b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ef(Ff ff, Bitmap bitmap) {
        this.f21832b = ff;
        this.f21831a = bitmap;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Ff ff = this.f21832b;
        ff.f21850c.f21879b.a(ff.f21848a, ff.f21849b, this.f21831a, ProjectEditActivity.InsertPosition.CurrentTime, true, true);
        this.f21832b.f21850c.f21879b.Da();
    }
}
