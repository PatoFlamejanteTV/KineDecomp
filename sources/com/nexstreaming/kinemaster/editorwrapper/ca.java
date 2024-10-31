package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SingleClipPreview.java */
/* loaded from: classes.dex */
public class Ca implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20184a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Da f20185b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ca(Da da, int i) {
        this.f20185b = da;
        this.f20184a = i;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        VideoEditor videoEditor;
        Task task2;
        videoEditor = this.f20185b.f20187a;
        videoEditor.a(this.f20185b, this.f20184a);
        this.f20185b.f20187a = null;
        task2 = this.f20185b.f20190d;
        task2.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }
}
