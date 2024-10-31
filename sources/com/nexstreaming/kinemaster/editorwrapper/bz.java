package com.nexstreaming.kinemaster.editorwrapper;

import android.net.Uri;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class bz implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uri f3352a;
    final /* synthetic */ String b;
    final /* synthetic */ by c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(by byVar, Uri uri, String str) {
        this.c = byVar;
        this.f3352a = uri;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3352a == null || this.b == null) {
            this.c.f3351a.d.sendFailure(NexEditor.b.bq);
        } else {
            this.c.f3351a.d.sendResult(new File(this.b));
        }
    }
}
