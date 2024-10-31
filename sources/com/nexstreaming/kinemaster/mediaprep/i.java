package com.nexstreaming.kinemaster.mediaprep;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class i implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MSID f3532a;
    final /* synthetic */ File b;
    final /* synthetic */ MediaStoreItem c;
    final /* synthetic */ MediaPrepManager d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(MediaPrepManager mediaPrepManager, MSID msid, File file, MediaStoreItem mediaStoreItem) {
        this.d = mediaPrepManager;
        this.f3532a = msid;
        this.b = file;
        this.c = mediaStoreItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Context context;
        context = this.d.f3520a;
        MediaScannerConnection.scanFile(context, new String[]{this.b.getAbsolutePath()}, null, new j(this));
    }
}
