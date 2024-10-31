package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioEffectPresenter.kt */
/* loaded from: classes2.dex */
public final class n implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22243a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f22244b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.a.a f22245c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VideoEditor videoEditor, r rVar, kotlin.jvm.a.a aVar) {
        this.f22243a = videoEditor;
        this.f22244b = rVar;
        this.f22245c = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        j jVar;
        jVar = this.f22244b.f22261h;
        if (!jVar.isActive() || this.f22244b.d() == AudioPlayStatus.STOP) {
            return;
        }
        this.f22244b.a(AudioPlayStatus.PLAY);
        this.f22243a.D().onComplete(new l(this)).onFailure(new m(this));
    }
}
