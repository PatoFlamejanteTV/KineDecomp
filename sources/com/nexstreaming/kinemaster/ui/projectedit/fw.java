package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fw implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3913a;
    final /* synthetic */ ez b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fw(ez ezVar, MSID msid) {
        this.b = ezVar;
        this.f3913a = msid;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.a(this.f3913a, (Bitmap) null);
        this.b.d();
    }
}
