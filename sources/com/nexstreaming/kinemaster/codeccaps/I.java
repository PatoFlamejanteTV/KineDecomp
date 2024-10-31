package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexThemeView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CodecTestCase.java */
/* loaded from: classes.dex */
public class I implements NexThemeView.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Task f20058a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f20059b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ P f20060c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public I(P p, Task task, ResultTask resultTask) {
        this.f20060c = p;
        this.f20058a = task;
        this.f20059b = resultTask;
    }

    @Override // com.nextreaming.nexvideoeditor.NexThemeView.b
    public void a(int i, Object obj, int i2, int i3, int i4) {
        NexThemeView nexThemeView;
        nexThemeView = this.f20060c.v;
        if (nexThemeView != null && i == 1) {
            this.f20058a.onComplete(new H(this));
        }
    }
}
