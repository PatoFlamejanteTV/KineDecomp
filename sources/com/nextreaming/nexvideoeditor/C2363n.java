package com.nextreaming.nexvideoeditor;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditor.java */
/* renamed from: com.nextreaming.nexvideoeditor.n, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
class C2363n extends NexEditor.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2364o f24729a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2363n(C2364o c2364o) {
        this.f24729a = c2364o;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(Bitmap bitmap) {
        SurfaceHolder.Callback callback;
        Surface surface;
        SurfaceHolder holder = this.f24729a.f24730a.f24731a.f24732a.getHolder();
        callback = this.f24729a.f24730a.f24731a.f24734c.ja;
        holder.removeCallback(callback);
        this.f24729a.f24730a.f24731a.f24732a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f24729a.f24730a.f24731a.f24734c;
        surface = nexEditor.R;
        nexEditor.prepareSurface(surface);
        this.f24729a.f24730a.f24731a.f24734c.ka = false;
        this.f24729a.f24730a.f24731a.f24733b.sendResult(bitmap);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(NexEditor.b bVar) {
        SurfaceHolder.Callback callback;
        Surface surface;
        SurfaceHolder holder = this.f24729a.f24730a.f24731a.f24732a.getHolder();
        callback = this.f24729a.f24730a.f24731a.f24734c.ja;
        holder.removeCallback(callback);
        this.f24729a.f24730a.f24731a.f24732a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f24729a.f24730a.f24731a.f24734c;
        surface = nexEditor.R;
        nexEditor.prepareSurface(surface);
        this.f24729a.f24730a.f24731a.f24734c.ka = false;
        this.f24729a.f24730a.f24731a.f24733b.sendFailure(bVar);
    }
}
