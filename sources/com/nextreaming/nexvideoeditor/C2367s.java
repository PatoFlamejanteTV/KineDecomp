package com.nextreaming.nexvideoeditor;

import android.graphics.Bitmap;
import android.util.Log;
import com.nextreaming.nexvideoeditor.NexEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.s, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public class C2367s extends NexEditor.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexEditor.f f24736a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexEditor f24737b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2367s(NexEditor nexEditor, NexEditor.f fVar) {
        this.f24737b = nexEditor;
        this.f24736a = fVar;
    }

    void a(NexEditor.b bVar, Bitmap bitmap) {
        boolean z;
        int i;
        this.f24737b.ma = true;
        if (bitmap == null) {
            Log.e("NexEditor.java", "  Capture failed; error=" + bVar.b() + " (" + bVar.d() + ")");
            this.f24737b.la = false;
            this.f24736a.a(bVar);
        } else {
            this.f24737b.la = false;
            this.f24736a.a(bitmap);
        }
        this.f24737b.ma = false;
        z = this.f24737b.la;
        if (z) {
            return;
        }
        this.f24737b.la = true;
        NexEditor nexEditor = this.f24737b;
        i = nexEditor.na;
        nexEditor.a(i, false, (NexEditor.q) new r(this));
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(NexEditor.b bVar) {
        a(bVar, null);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(Bitmap bitmap) {
        a(NexEditor.b.f24591b, bitmap);
    }
}
