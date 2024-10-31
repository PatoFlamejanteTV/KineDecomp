package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
public class fr implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ fq f3908a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fr(fq fqVar) {
        this.f3908a = fqVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f3908a.b.f3906a.e().onComplete(new fs(this, AndroidMediaStoreProvider.a(new File(this.f3908a.f3907a))));
    }
}
