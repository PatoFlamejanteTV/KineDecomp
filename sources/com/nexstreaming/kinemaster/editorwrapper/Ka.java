package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Ka implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20212a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f20213b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Task f20214c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20215d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(VideoEditor videoEditor, int i, boolean z, Task task) {
        this.f20215d = videoEditor;
        this.f20212a = i;
        this.f20213b = z;
        this.f20214c = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20215d.R().a(this.f20212a, this.f20213b, new Ja(this));
    }
}
