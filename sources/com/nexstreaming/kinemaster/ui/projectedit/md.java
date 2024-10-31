package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Md implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Nd f21956a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Md(Nd nd) {
        this.f21956a = nd;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        this.f21956a.f21972a.f21984b.P().onComplete(new Ld(this, AndroidMediaStoreProvider.a(new File(this.f21956a.f21973b))));
    }
}
