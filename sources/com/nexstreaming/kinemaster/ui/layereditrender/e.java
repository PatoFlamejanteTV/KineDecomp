package com.nexstreaming.kinemaster.ui.layereditrender;

import android.content.Context;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import java.lang.ref.WeakReference;

/* compiled from: SimpleLayerEditRenderer.java */
/* loaded from: classes.dex */
public abstract class e implements VideoEditor.b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f3717a = false;
    private boolean b = false;
    private WeakReference<Context> c;

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(Context context, VideoEditor videoEditor, boolean z) {
        if (this.f3717a) {
            throw new IllegalStateException("Already added");
        }
        this.f3717a = true;
        this.c = new WeakReference<>(context);
        this.b = z;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a() {
        this.c = null;
        this.f3717a = false;
    }
}
