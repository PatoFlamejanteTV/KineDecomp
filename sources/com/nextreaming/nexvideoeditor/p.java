package com.nextreaming.nexvideoeditor;

import android.graphics.Bitmap;
import android.util.Log;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
public class p extends NexEditor.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor.f f4840a;
    final /* synthetic */ NexEditor b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(NexEditor nexEditor, NexEditor.f fVar) {
        this.b = nexEditor;
        this.f4840a = fVar;
    }

    void a(NexEditor.b bVar, Bitmap bitmap) {
        boolean z;
        int i;
        this.b.ae = true;
        if (bitmap != null) {
            this.b.ad = false;
            this.f4840a.a(bitmap);
        } else {
            Log.e("NexEditor.java", "  Capture failed; error=" + bVar.d() + " (" + bVar.c() + ")");
            this.b.ad = false;
            this.f4840a.a(bVar);
        }
        this.b.ae = false;
        z = this.b.ad;
        if (!z) {
            this.b.ad = true;
            NexEditor nexEditor = this.b;
            i = this.b.af;
            nexEditor.a(i, false, (NexEditor.p) new q(this));
        }
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(NexEditor.b bVar) {
        a(bVar, null);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(Bitmap bitmap) {
        a(NexEditor.b.f4793a, bitmap);
    }
}
