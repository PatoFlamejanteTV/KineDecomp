package com.nextreaming.nexvideoeditor;

import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: NexEditor.java */
/* loaded from: classes.dex */
class o extends NexEditor.f {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ n f4839a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar) {
        this.f4839a = nVar;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(Bitmap bitmap) {
        SurfaceHolder.Callback callback;
        Surface surface;
        SurfaceHolder holder = this.f4839a.f4838a.f4836a.f4834a.getHolder();
        callback = this.f4839a.f4838a.f4836a.c.ab;
        holder.removeCallback(callback);
        this.f4839a.f4838a.f4836a.f4834a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f4839a.f4838a.f4836a.c;
        surface = this.f4839a.f4838a.f4836a.c.N;
        nexEditor.prepareSurface(surface);
        this.f4839a.f4838a.f4836a.c.ac = false;
        this.f4839a.f4838a.f4836a.b.sendResult(bitmap);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.f
    public void a(NexEditor.b bVar) {
        SurfaceHolder.Callback callback;
        Surface surface;
        SurfaceHolder holder = this.f4839a.f4838a.f4836a.f4834a.getHolder();
        callback = this.f4839a.f4838a.f4836a.c.ab;
        holder.removeCallback(callback);
        this.f4839a.f4838a.f4836a.f4834a.getHolder().setSizeFromLayout();
        NexEditor nexEditor = this.f4839a.f4838a.f4836a.c;
        surface = this.f4839a.f4838a.f4836a.c.N;
        nexEditor.prepareSurface(surface);
        this.f4839a.f4838a.f4836a.c.ac = false;
        this.f4839a.f4838a.f4836a.b.sendFailure(bVar);
    }
}
