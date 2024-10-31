package com.nexstreaming.kinemaster.ui.share;

import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class S implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f23296a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f23297b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ U f23298c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public S(U u, File file, File file2) {
        this.f23298c = u;
        this.f23296a = file;
        this.f23297b = file2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Task a2;
        a2 = this.f23298c.a(this.f23296a, 1, 2);
        a2.onComplete(new Q(this));
    }
}
