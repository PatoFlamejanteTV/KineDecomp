package com.nexstreaming.kinemaster.mediaprep;

import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class k implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MediaStoreItemId f20801a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ File f20802b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.c f20803c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MediaPrepManager f20804d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MediaPrepManager mediaPrepManager, MediaStoreItemId mediaStoreItemId, File file, com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        this.f20804d = mediaPrepManager;
        this.f20801a = mediaStoreItemId;
        this.f20802b = file;
        this.f20803c = cVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        MediaScannerConnection.scanFile(this.f20804d.f20774b, new String[]{this.f20802b.getAbsolutePath()}, null, new j(this));
    }
}
