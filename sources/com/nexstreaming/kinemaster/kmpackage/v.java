package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EffectPreviewView.java */
/* loaded from: classes.dex */
public class v implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3466a;
    final /* synthetic */ EffectPreviewView b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(EffectPreviewView effectPreviewView, String str) {
        this.b = effectPreviewView;
        this.f3466a = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.b.setEffect(this.b.t.c(this.f3466a));
    }
}
