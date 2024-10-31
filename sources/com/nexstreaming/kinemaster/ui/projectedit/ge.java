package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import java.io.File;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes2.dex */
class Ge implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f21876a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ He f21877b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ge(He he, int i) {
        this.f21877b = he;
        this.f21876a = i;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        com.nexstreaming.kinemaster.mediastore.item.c b2 = this.f21877b.O().b(AndroidMediaStoreProvider.a(file));
        this.f21877b.O().a(b2, new Fe(this, b2));
    }
}
