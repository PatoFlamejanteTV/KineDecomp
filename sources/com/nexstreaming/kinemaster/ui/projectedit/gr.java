package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.mediastore.v2.providers.AndroidMediaStoreProvider;
import java.io.File;

/* compiled from: OptionSplitFragment.java */
/* loaded from: classes.dex */
class gr implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f3935a;
    final /* synthetic */ go b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public gr(go goVar, int i) {
        this.b = goVar;
        this.f3935a = i;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        MediaStoreItem a2 = this.b.p().a(AndroidMediaStoreProvider.a(file));
        this.b.p().b(a2).onResultAvailable(new gu(this, a2)).onFailure((Task.OnFailListener) new gs(this, a2));
    }
}
