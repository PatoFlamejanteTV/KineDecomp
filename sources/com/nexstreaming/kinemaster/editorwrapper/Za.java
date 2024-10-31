package com.nexstreaming.kinemaster.editorwrapper;

import android.net.Uri;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class Za implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Uri f20285a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f20286b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ _a f20287c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(_a _aVar, Uri uri, String str) {
        this.f20287c = _aVar;
        this.f20285a = uri;
        this.f20286b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f20285a != null && this.f20286b != null) {
            KineMasterApplication.f24056d.h().a(this.f20287c.f20288a).onComplete(new Ya(this));
        } else {
            this.f20287c.f20289b.f20294a.f20297b.sendFailure(NexEditor.b.qb);
        }
    }
}
