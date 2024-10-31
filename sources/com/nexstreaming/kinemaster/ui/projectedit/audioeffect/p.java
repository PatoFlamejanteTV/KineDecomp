package com.nexstreaming.kinemaster.ui.projectedit.audioeffect;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioEffectPresenter.kt */
/* loaded from: classes2.dex */
public final class p implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f22249a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f22250b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ kotlin.jvm.a.a f22251c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VideoEditor videoEditor, r rVar, kotlin.jvm.a.a aVar) {
        this.f22249a = videoEditor;
        this.f22250b = rVar;
        this.f22251c = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public final void onTaskEvent(Task task, Task.Event event) {
        this.f22250b.a(this.f22249a, AudioPlayStatus.STOP);
        kotlin.jvm.a.a aVar = this.f22251c;
        if (aVar != null) {
        }
    }
}
