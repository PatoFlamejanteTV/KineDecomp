package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fu implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3911a;
    final /* synthetic */ boolean b;
    final /* synthetic */ ft c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fu(ft ftVar, File file, boolean z) {
        this.c = ftVar;
        this.f3911a = file;
        this.b = z;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.c.c.e().onComplete(new fv(this, AndroidMediaStoreProvider.a(this.f3911a)));
    }
}
