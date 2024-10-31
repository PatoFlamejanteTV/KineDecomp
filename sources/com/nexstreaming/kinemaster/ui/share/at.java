package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class at implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareIntentActivity f4304a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ShareIntentActivity shareIntentActivity) {
        this.f4304a = shareIntentActivity;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4304a.a(this.f4304a.getIntent());
    }
}
