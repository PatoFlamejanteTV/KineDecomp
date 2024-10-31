package com.nextreaming.nexeditorui.fontbrowser;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: FontListAdapter.java */
/* loaded from: classes.dex */
public class s implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ProgressBar f4643a;
    final /* synthetic */ ImageButton b;
    final /* synthetic */ View c;
    final /* synthetic */ l d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(l lVar, ProgressBar progressBar, ImageButton imageButton, View view) {
        this.d = lVar;
        this.f4643a = progressBar;
        this.b = imageButton;
        this.c = view;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        this.f4643a.setVisibility(4);
        this.b.setVisibility(4);
        this.f4643a.setProgress(0);
        this.c.invalidate();
    }
}
