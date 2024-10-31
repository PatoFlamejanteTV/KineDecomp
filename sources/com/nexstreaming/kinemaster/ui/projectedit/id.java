package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
public final class Id implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Jd f21901a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Id(Jd jd) {
        this.f21901a = jd;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        this.f21901a.f21912a.f21921b.P().onComplete(new Hd(this, AndroidMediaStoreProvider.a(new File(this.f21901a.f21913b))));
    }
}
