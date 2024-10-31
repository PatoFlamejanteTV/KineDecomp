package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fv implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3912a;
    final /* synthetic */ fu b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fv(fu fuVar, MSID msid) {
        this.b = fuVar;
        this.f3912a = msid;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (this.b.b) {
            this.b.c.d.a(this.f3912a);
        } else {
            this.b.c.d.a(this.f3912a, (Bitmap) null);
        }
        this.b.c.d.d();
    }
}
