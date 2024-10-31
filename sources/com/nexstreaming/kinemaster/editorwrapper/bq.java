package com.nexstreaming.kinemaster.editorwrapper;

import android.net.Uri;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class bq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uri f3343a;
    final /* synthetic */ String b;
    final /* synthetic */ bp c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bp bpVar, Uri uri, String str) {
        this.c = bpVar;
        this.f3343a = uri;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f3343a == null || this.b == null) {
            this.c.b.f3341a.b.sendFailure(NexEditor.b.bq);
        } else {
            KineMasterApplication.a().c().a(this.c.f3342a).onComplete(new br(this));
        }
    }
}
