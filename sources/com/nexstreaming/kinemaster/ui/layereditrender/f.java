package com.nexstreaming.kinemaster.ui.layereditrender;

import android.content.Context;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import java.lang.ref.WeakReference;

/* compiled from: SimpleLayerEditRenderer.java */
/* loaded from: classes.dex */
public abstract class f implements VideoEditor.b {

    /* renamed from: a, reason: collision with root package name */
    private boolean f21637a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f21638b = false;

    /* renamed from: c, reason: collision with root package name */
    private WeakReference<Context> f21639c;

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a(Context context, VideoEditor videoEditor, boolean z) {
        if (!this.f21637a) {
            this.f21637a = true;
            this.f21639c = new WeakReference<>(context);
            this.f21638b = z;
            return;
        }
        throw new IllegalStateException("Already added");
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.VideoEditor.b
    public void a() {
        this.f21639c = null;
        this.f21637a = false;
    }
}
