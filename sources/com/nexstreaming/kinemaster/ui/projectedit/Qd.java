package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import java.io.File;

/* compiled from: OptionPanelDefaultFragment.kt */
/* loaded from: classes2.dex */
final class Qd implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Rd f22035a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f22036b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Qd(Rd rd, File file) {
        this.f22035a = rd;
        this.f22036b = file;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        MediaStoreItemId a2 = AndroidMediaStoreProvider.a(this.f22036b);
        VideoEditor videoEditor = this.f22035a.f22053f;
        if (videoEditor != null) {
            videoEditor.P().onComplete(new Pd(this, a2));
        } else {
            kotlin.jvm.internal.h.a();
            throw null;
        }
    }
}
