package com.nextreaming.nexeditorui.newproject;

import android.app.Activity;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;

/* compiled from: NewProjectActivity.java */
/* loaded from: classes.dex */
class c implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4684a;
    final /* synthetic */ NewProjectActivity b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NewProjectActivity newProjectActivity, String str) {
        this.b = newProjectActivity;
        this.f4684a = str;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Activity D;
        NewProjectActivity newProjectActivity = this.b;
        D = this.b.D();
        newProjectActivity.f = EffectLibrary.a(D).e(this.f4684a);
    }
}
