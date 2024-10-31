package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.projectedit.Oh;

/* compiled from: VoiceRecorderFragment.kt */
/* loaded from: classes2.dex */
final class Gh implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Ih f21881a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ VideoEditor f21882b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Oh.a f21883c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Gh(Ih ih, VideoEditor videoEditor, Oh.a aVar) {
        this.f21881a = ih;
        this.f21882b = videoEditor;
        this.f21883c = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        if (this.f21881a.f21906a.isAdded()) {
            this.f21882b.E().onComplete(new Eh(this)).onFailure(new Fh(this));
        }
    }
}
