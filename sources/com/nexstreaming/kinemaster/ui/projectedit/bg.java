package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.MediaLayer;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;

/* compiled from: LayerEditManager.java */
/* loaded from: classes.dex */
public class bg {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<kp> f3787a;
    private LayerTransformTouchHandler c;
    private MarchingAnts b = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SPLIT_HANDLE);
    private VideoEditor.b d = new bh(this);

    public bg(kp kpVar) {
        this.f3787a = new WeakReference<>(kpVar);
    }

    public void a() {
        if (this.b != null) {
            this.b.h();
        }
    }

    public void b() {
        this.b = null;
        i().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        i().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    public void c() {
        if (j() != null && f() != null && e()) {
            if (this.c == null) {
                this.c = new LayerTransformTouchHandler(f(), j(), i());
            }
            this.c.a((NexLayerItem) k());
            if (this.b == null) {
                this.b = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE);
            }
            Rect rect = new Rect();
            j().getBounds(rect);
            this.b.a(rect);
            this.b.a(h(), g());
            i().a((NexLayerItem) k(), this.d, this.b);
            i().a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }

    public boolean a(View view, MotionEvent motionEvent) {
        if (!e() || j() == null || this.c == null) {
            return false;
        }
        return this.c.a(view, motionEvent);
    }

    private boolean e() {
        kp kpVar = this.f3787a.get();
        if (kpVar == null) {
            return false;
        }
        return kpVar.isAdded();
    }

    public void d() {
        this.c = null;
    }

    private Context f() {
        kp kpVar = this.f3787a.get();
        if (kpVar == null) {
            return null;
        }
        return kpVar.getActivity();
    }

    private int g() {
        kp kpVar = this.f3787a.get();
        if (kpVar == null) {
            return 0;
        }
        return kpVar.y();
    }

    private int h() {
        kp kpVar = this.f3787a.get();
        if (kpVar == null) {
            return 0;
        }
        return kpVar.x();
    }

    private VideoEditor i() {
        kp kpVar = this.f3787a.get();
        if (kpVar == null) {
            return null;
        }
        return kpVar.o();
    }

    private MediaLayer j() {
        NexTimelineItem k = k();
        if (k == null || !(k instanceof MediaLayer)) {
            return null;
        }
        return (MediaLayer) k;
    }

    private NexTimelineItem k() {
        kp kpVar = this.f3787a.get();
        if (kpVar == null) {
            return null;
        }
        return kpVar.m();
    }
}
