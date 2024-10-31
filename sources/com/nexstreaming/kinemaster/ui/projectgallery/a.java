package com.nexstreaming.kinemaster.ui.projectgallery;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;

/* compiled from: DependencyChecker.java */
/* loaded from: classes2.dex */
class A implements Task.TaskError {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ B f22810a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public A(B b2) {
        this.f22810a = b2;
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public Exception getException() {
        return new IllegalStateException(getMessage());
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getLocalizedMessage(Context context) {
        return getMessage();
    }

    @Override // com.nexstreaming.app.general.task.Task.TaskError
    public String getMessage() {
        return "Project loading failure : project or timeline is null";
    }
}
