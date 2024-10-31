package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;

/* compiled from: LayerEditManager.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.rb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class ViewOnLayoutChangeListenerC1995rb implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    private final WeakReference<Bg> f22497a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f22498b;

    /* renamed from: c, reason: collision with root package name */
    private MarchingAnts f22499c;

    /* renamed from: d, reason: collision with root package name */
    private LayerTransformTouchHandler f22500d;

    /* renamed from: e, reason: collision with root package name */
    private RectF f22501e;

    /* renamed from: f, reason: collision with root package name */
    private RectF f22502f;

    /* renamed from: g, reason: collision with root package name */
    private Rect f22503g;

    /* renamed from: h, reason: collision with root package name */
    private VideoEditor.b f22504h;
    private Object i;

    public ViewOnLayoutChangeListenerC1995rb(Bg bg) {
        this.f22501e = new RectF();
        this.f22502f = new RectF();
        this.f22503g = new Rect();
        this.f22504h = new C1987qb(this);
        this.i = this;
        this.f22497a = new WeakReference<>(bg);
        this.f22498b = false;
        this.f22499c = new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SPLIT_HANDLE);
    }

    private Context e() {
        Bg bg = this.f22497a.get();
        if (bg == null) {
            return null;
        }
        return bg.getActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public NexLayerItem f() {
        NexTimelineItem i = i();
        if (i == null || !(i instanceof NexLayerItem)) {
            return null;
        }
        return (NexLayerItem) i;
    }

    private int g() {
        Bg bg = this.f22497a.get();
        if (bg == null) {
            return 0;
        }
        return bg.R().intValue();
    }

    private int h() {
        Bg bg = this.f22497a.get();
        if (bg == null) {
            return 0;
        }
        return bg.S().intValue();
    }

    private NexTimelineItem i() {
        Bg bg = this.f22497a.get();
        if (bg == null) {
            return null;
        }
        return bg.Y();
    }

    private VideoEditor j() {
        Bg bg = this.f22497a.get();
        if (bg == null) {
            return null;
        }
        return bg.da();
    }

    private boolean k() {
        Bg bg = this.f22497a.get();
        if (bg == null) {
            return false;
        }
        return bg.isAdded();
    }

    public void d() {
        MarchingAnts marchingAnts = this.f22499c;
        if (marchingAnts != null) {
            marchingAnts.j();
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        b();
    }

    public boolean a(View view, MotionEvent motionEvent) {
        LayerTransformTouchHandler layerTransformTouchHandler;
        if (!k() || f() == null || (layerTransformTouchHandler = this.f22500d) == null) {
            return false;
        }
        return layerTransformTouchHandler.a(view, motionEvent);
    }

    public void b() {
        if (f() == null || e() == null || !k()) {
            return;
        }
        if (this.f22500d == null) {
            this.f22500d = new LayerTransformTouchHandler(e(), f(), j());
            boolean z = this.f22498b;
            if (z) {
                this.f22500d.a(z);
            }
        }
        this.f22500d.a((NexLayerItem) i());
        if (this.f22499c == null) {
            this.f22499c = this.f22498b ? new MarchingAnts(MarchingAnts.Feature.CROP_HANDLES) : new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SPLIT_HANDLE);
        }
        Rect rect = new Rect();
        f().getBounds(rect);
        if (f().getCropBounds(new RectF())) {
            this.f22499c.a((int) r3.left, (int) r3.top, (int) r3.right, (int) r3.bottom);
        } else {
            this.f22499c.a(rect);
        }
        this.f22499c.a(h(), g());
        j().a(this.i, (NexLayerItem) i(), this.f22504h, this.f22499c);
        j().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    public void c() {
        this.f22499c = null;
        j().a(this.i, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        j().a(NexEditor.FastPreviewOption.normal, 0, true);
    }

    public void a() {
        this.f22500d = null;
    }

    public ViewOnLayoutChangeListenerC1995rb(Bg bg, boolean z) {
        this.f22501e = new RectF();
        this.f22502f = new RectF();
        this.f22503g = new Rect();
        this.f22504h = new C1987qb(this);
        this.i = this;
        this.f22497a = new WeakReference<>(bg);
        this.f22498b = z;
        this.f22499c = z ? new MarchingAnts(MarchingAnts.Feature.CROP_HANDLES) : new MarchingAnts(MarchingAnts.Feature.SIZE_HANDLE, MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SPLIT_HANDLE);
    }
}
