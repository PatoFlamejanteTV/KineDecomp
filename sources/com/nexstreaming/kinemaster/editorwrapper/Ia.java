package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class Ia implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f20207a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f20208b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Task f20209c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ VideoEditor f20210d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ia(VideoEditor videoEditor, int i, boolean z, Task task) {
        this.f20210d = videoEditor;
        this.f20207a = i;
        this.f20208b = z;
        this.f20209c = task;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f20210d.R().a(this.f20207a, this.f20208b, new Ha(this));
    }
}
