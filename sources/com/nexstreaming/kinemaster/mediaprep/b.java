package com.nexstreaming.kinemaster.mediaprep;

import android.content.Context;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.ui.a.a;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f3525a;
    final /* synthetic */ String b;
    final /* synthetic */ String c;
    final /* synthetic */ Task d;
    final /* synthetic */ MediaPrepManager e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(MediaPrepManager mediaPrepManager, String str, String str2, String str3, Task task) {
        this.e = mediaPrepManager;
        this.f3525a = str;
        this.b = str2;
        this.c = str3;
        this.d = task;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.e.f3520a;
        new a.C0074a(context).a(this.f3525a).a(this.b, new e(this)).b(this.c, new d(this)).a(new c(this)).a().show();
    }
}
