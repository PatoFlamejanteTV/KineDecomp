package com.nexstreaming.kinemaster.ui.previewplay;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: PreviewPlayActivity.java */
/* loaded from: classes.dex */
public class i implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3728a;
    final /* synthetic */ h b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar, int i) {
        this.b = hVar;
        this.f3728a = i;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        int i;
        int i2 = this.f3728a;
        i = this.b.d;
        if (i2 == i) {
            this.b.f3727a.o = false;
            this.b.a();
        }
    }
}
