package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioEffectPresenter.kt */
/* loaded from: classes2.dex */
public final class o implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22246a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f22247b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.a.a f22248c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(VideoEditor videoEditor, r rVar, kotlin.jvm.a.a aVar) {
        this.f22246a = videoEditor;
        this.f22247b = rVar;
        this.f22248c = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f22247b.a(this.f22246a, AudioPlayStatus.STOP);
    }
}
