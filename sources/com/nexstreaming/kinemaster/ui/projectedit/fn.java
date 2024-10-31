package com.nexstreaming.kinemaster.ui.projectedit;

import android.graphics.Bitmap;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fn implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3904a;
    final /* synthetic */ fm b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fn(fm fmVar, MSID msid) {
        this.b = fmVar;
        this.f3904a = msid;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.f3903a.b.b.a(this.f3904a, (Bitmap) null);
        this.b.f3903a.b.b.d();
    }
}
