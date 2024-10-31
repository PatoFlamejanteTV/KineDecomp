package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.zb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2087zb implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f22800a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.ui.a.r f22801b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Mb f22802c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2087zb(Mb mb, File file, com.nexstreaming.kinemaster.ui.a.r rVar) {
        this.f22802c = mb;
        this.f22800a = file;
        this.f22801b = rVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        if (this.f22802c.getActivity() == null || this.f22800a == null) {
            return;
        }
        MediaScannerConnection.scanFile(this.f22802c.getActivity(), new String[]{this.f22800a.getAbsolutePath()}, null, new C2079yb(this));
    }
}
