package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fs implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3909a;
    final /* synthetic */ fr b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fs(fr frVar, MSID msid) {
        this.b = frVar;
        this.f3909a = msid;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.f3908a.b.b.a(this.f3909a, (Bitmap) null);
        this.b.f3908a.b.b.d();
    }
}
