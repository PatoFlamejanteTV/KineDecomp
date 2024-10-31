package com.nexstreaming.kinemaster.ui.projectedit;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class HandwritingEditFragment extends OptionTabFragment implements ht {
    private WeakReference<com.nexstreaming.kinemaster.ui.widget.j> A;
    private WeakReference<ColorPickerPopup> B;

    /* renamed from: a, reason: collision with root package name */
    private OptionTabFragment.TabId f3734a;
    private OptionTabFragment.TabId b;
    private int f;
    private int g;
    private int h;
    private int i;
    private Bitmap j;
    private Bitmap k;
    private Bitmap[] l;
    private Canvas[] m;
    private float o;
    private float p;
    private ImageView q;
    private ImageView r;
    private ImageView s;
    private ImageView t;
    private Tool v;
    private BrushType w;
    private LayerTransformTouchHandler x;
    private ImageView y;
    private Object c = new Object();
    private Stroke d = new Stroke();
    private Stroke e = new Stroke();
    private Rect n = new Rect();
    private boolean u = false;
    private List<com.nexstreaming.kinemaster.layer.handwriting.a> z = new ArrayList();
    private VideoEditor.b C = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts D = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
    private VideoEditor.b E = new ag(this);
    private Rect F = new Rect();
    private Rect G = new Rect();
    private int H = 0;
    private float[] I = {0.0f, 0.0f};
    private Matrix J = new Matrix();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum Tool {
        Pencil,
        Eraser
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ep.a
    public void c(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum BrushType {
        Line(R.id.handwriting_line, R.drawable.handwriting_line),
        Arrow(R.id.handwriting_arrow, R.drawable.handwriting_arrow),
        ArrowDouble(R.id.handwriting_arrow_dbl, R.drawable.handwriting_arrow_dbl),
        Brush(R.id.handwriting_brush, R.drawable.handwriting_brush),
        Pencil(R.id.handwriting_pencil, R.drawable.handwriting_pencil),
        XShape(R.id.handwriting_xmark, R.drawable.handwriting_xmark),
        RectFill(R.id.handwriting_rect_fill, R.drawable.handwriting_rect_fill),
        EllipseFill(R.id.handwriting_ellipse_fill, R.drawable.handwriting_ellipse_fill),
        Rect(R.id.handwriting_rect, R.drawable.handwriting_rect),
        Ellipse(R.id.handwriting_ellipse, R.drawable.handwriting_ellipse);

        final int iconRsrc;
        final int id;

        BrushType(int i, int i2) {
            this.id = i;
            this.iconRsrc = i2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static BrushType fromId(int i) {
            for (BrushType brushType : values()) {
                if (brushType.id == i) {
                    return brushType;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setStroke(Stroke stroke) {
            switch (this) {
                case Pencil:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.c(1.0f);
                    stroke.a(false);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                case Brush:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.c(0.5f);
                    stroke.a(false);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                case Line:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                case Arrow:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.SolidArrow);
                    return;
                case ArrowDouble:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.SolidArrow);
                    stroke.b(Stroke.CapDecorationStyle.SolidArrow);
                    return;
                case Rect:
                    stroke.a(Stroke.PathStyle.Rect);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                case Ellipse:
                    stroke.a(Stroke.PathStyle.Ellipse);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                case RectFill:
                    stroke.a(Stroke.PathStyle.FillRect);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                case EllipseFill:
                    stroke.a(Stroke.PathStyle.FillEllipse);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                case XShape:
                    stroke.a(Stroke.PathStyle.XShape);
                    stroke.c(1.0f);
                    stroke.a(true);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, android.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        H();
        I();
    }

    private void H() {
        if (this.b != this.f3734a) {
            this.f3734a = this.b;
            if (this.b == OptionTabFragment.TabId.ItemEditTab) {
                a(R.id.action_step_undo, R.drawable.action_stepundo, R.id.action_step_redo, R.drawable.action_stepredo, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
            } else if (this.b == OptionTabFragment.TabId.ItemOptionTab) {
                a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        if (N() != null) {
            d(R.id.action_step_undo, N().getDrawingActions().size() > 0);
            d(R.id.action_step_redo, this.z.size() > 0);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.kp, com.nexstreaming.kinemaster.ui.projectedit.a
    public boolean a(int i) {
        switch (i) {
            case R.id.action_step_redo /* 2131820578 */:
                if (this.z.size() > 0) {
                    N().addDrawingAction(this.z.remove(this.z.size() - 1));
                    this.n.set(0, 0, 1280, 720);
                    this.u = true;
                    M();
                    I();
                }
                return true;
            case R.id.action_step_undo /* 2131820579 */:
                com.nexstreaming.kinemaster.layer.handwriting.a removeLastDrawingAction = N().removeLastDrawingAction();
                if (removeLastDrawingAction != null) {
                    this.z.add(removeLastDrawingAction);
                    this.n.set(0, 0, 1280, 720);
                    this.u = true;
                    M();
                    I();
                }
                return true;
            default:
                return super.a(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected String a() {
        return getString(R.string.layer_menu_handwriting);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected int[] c() {
        return new int[]{R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_alpha_adj, R.id.opt_split_trim, R.id.opt_rotate, R.id.opt_layer_mask, R.id.opt_layer_name};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed
    protected boolean d(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.handwriting_edit_tab, viewGroup, false);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(viewGroup.getContext());
        this.d.a(defaultSharedPreferences.getInt("km.ui.handwriting.color", -65536));
        this.d.b(defaultSharedPreferences.getFloat("km.ui.handwriting.strokeWidth", 5.0f));
        this.e.b(defaultSharedPreferences.getFloat("km.ui.handwriting.eraserWidth", 38.0f));
        this.e.b(true);
        this.v = Tool.valueOf(defaultSharedPreferences.getString("km.ui.handwriting.tool", Tool.Pencil.name()));
        this.w = BrushType.valueOf(defaultSharedPreferences.getString("km.ui.handwriting.brush", BrushType.Pencil.name()));
        this.q = (ImageView) inflate.findViewById(R.id.buttonEraser);
        this.r = (ImageView) inflate.findViewById(R.id.buttonPencil);
        this.y = (ImageView) inflate.findViewById(R.id.buttonEraseAll);
        this.r.setImageResource(this.w.iconRsrc);
        this.w.setStroke(this.d);
        this.r.setOnClickListener(new ak(this));
        this.y.setOnClickListener(new al(this));
        this.r.setOnLongClickListener(new am(this));
        this.q.setOnClickListener(new an(this));
        this.q.setOnLongClickListener(new ao(this));
        this.s = (ImageView) inflate.findViewById(R.id.buttonColor);
        this.s.setImageDrawable(new q(getActivity(), this.d.g()));
        this.s.setOnClickListener(new ap(this));
        this.t = (ImageView) inflate.findViewById(R.id.buttonSize);
        this.t.setOnClickListener(new as(this));
        L();
        this.x = new LayerTransformTouchHandler(inflate.getContext(), N(), o());
        return inflate;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        com.nexstreaming.kinemaster.ui.widget.b bVar = new com.nexstreaming.kinemaster.ui.widget.b(this.r.getContext(), true);
        this.A = new WeakReference<>(bVar);
        BrushType[] values = BrushType.values();
        int length = values.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            BrushType brushType = values[i2];
            bVar.a(brushType.iconRsrc, brushType.id, this.w == brushType);
            i++;
            if (i == 5) {
                bVar.m_();
            }
        }
        bVar.a(new ax(this));
        bVar.a(new ah(this));
        P();
        bVar.a(this.r, 3, 0, getResources().getDimensionPixelOffset(R.dimen.handwriting_popup_offset));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        float f = 1.0f;
        switch (this.v) {
            case Pencil:
                this.r.setActivated(true);
                this.q.setActivated(false);
                this.s.setEnabled(true);
                this.s.setAlpha(1.0f);
                f = this.d.f();
                break;
            case Eraser:
                this.r.setActivated(false);
                this.q.setActivated(true);
                this.s.setEnabled(false);
                this.s.setAlpha(0.2f);
                f = this.e.f();
                break;
        }
        this.t.setImageDrawable(new lg(getActivity(), (f * x()) / 1280.0f));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected void a(OptionTabFragment.TabId tabId) {
        this.b = tabId;
        H();
        switch (tabId) {
            case ItemEditTab:
                g(0);
                o().a((NexLayerItem) m(), this.C, this.E);
                M();
                o().a(NexEditor.FastPreviewOption.normal, 0, true);
                return;
            case ItemOptionTab:
                g(R.id.editmode_trim);
                Rect rect = new Rect();
                N().getBounds(rect);
                this.D.a(rect);
                View w = w();
                if (w != null) {
                    w.addOnLayoutChangeListener(new ai(this));
                    w.getViewTreeObserver().addOnGlobalLayoutListener(new aj(this));
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.app.Fragment
    public void onStop() {
        if (this.u) {
            d();
        }
        o().a((NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        o().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.ed, android.app.Fragment
    public void onDestroyView() {
        if (this.B != null) {
            ColorPickerPopup colorPickerPopup = this.B.get();
            if (colorPickerPopup != null) {
                colorPickerPopup.a();
            }
            this.B = null;
        }
        if (this.A != null) {
            com.nexstreaming.kinemaster.ui.widget.j jVar = this.A.get();
            if (jVar != null) {
                jVar.a();
            }
            this.A = null;
        }
        this.l = null;
        this.m = null;
        this.j = null;
        this.k = null;
        this.s = null;
        this.t = null;
        this.q = null;
        this.r = null;
        this.x = null;
        super.onDestroyView();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int h() {
        return R.drawable.opthdr_handwriting;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        HandwritingLayer N = N();
        if (N != null) {
            this.H++;
            Color.argb(100, this.H % 256, (this.H * 2) % 256, (this.H * 4) % 256);
            Rect rect = this.F;
            synchronized (this.c) {
                int x = x();
                int y = y();
                if (this.l == null || this.h != x || this.i != y) {
                    int length = this.l == null ? 0 : this.l.length;
                    this.h = x;
                    this.i = y;
                    this.g = ((x + 256) - 1) / 256;
                    this.f = ((y + 256) - 1) / 256;
                    int i = this.g * this.f;
                    if (i > length) {
                        Bitmap[] bitmapArr = new Bitmap[this.g * this.f];
                        Canvas[] canvasArr = new Canvas[this.g * this.f];
                        if (this.l != null && this.m != null) {
                            System.arraycopy(this.l, 0, bitmapArr, 0, this.l.length);
                            System.arraycopy(this.m, 0, canvasArr, 0, this.m.length);
                        }
                        while (length < i) {
                            bitmapArr[length] = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
                            canvasArr[length] = new Canvas(bitmapArr[length]);
                            length++;
                        }
                        this.l = bitmapArr;
                        this.m = canvasArr;
                    }
                    this.n.set(0, 0, 1280, 720);
                }
                if (this.n.intersect(0, 0, 1280, 720)) {
                    this.o = 327680 / x;
                    this.p = 184320 / y;
                    List<com.nexstreaming.kinemaster.layer.handwriting.a> drawingActions = N.getDrawingActions();
                    int i2 = 0;
                    Iterator<com.nexstreaming.kinemaster.layer.handwriting.a> it = drawingActions.iterator();
                    while (it.hasNext()) {
                        i2 = it.next().a() ? i2 + 1 : i2;
                    }
                    for (int i3 = 0; i3 < this.f; i3++) {
                        for (int i4 = 0; i4 < this.g; i4++) {
                            int i5 = (this.g * i3) + i4;
                            rect.set(((int) (i4 * this.o)) - 1, ((int) (i3 * this.p)) - 1, ((int) ((i4 + 1) * this.o)) + 1, ((int) ((i3 + 1) * this.p)) + 1);
                            if (this.n.intersects(rect.left, rect.top, rect.right, rect.bottom)) {
                                float f = (-i4) * this.o;
                                float f2 = (-i3) * this.p;
                                Canvas canvas = this.m[i5];
                                canvas.save();
                                canvas.clipRect(((this.n.left + f) * x) / 1280.0f, ((this.n.top + f2) * y) / 720.0f, ((this.n.right + f) * x) / 1280.0f, ((this.n.bottom + f2) * y) / 720.0f);
                                if (i2 < 1) {
                                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                                }
                                canvas.scale(x / 1280.0f, y / 720.0f);
                                canvas.translate(f, f2);
                                int i6 = i2;
                                for (com.nexstreaming.kinemaster.layer.handwriting.a aVar : drawingActions) {
                                    if (aVar.a()) {
                                        i6--;
                                    }
                                    if (i6 < 1) {
                                        aVar.a(canvas);
                                    }
                                }
                                O().a(canvas);
                                canvas.restore();
                            }
                        }
                    }
                    this.n.setEmpty();
                    o().a(NexEditor.FastPreviewOption.normal, 0, true);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HandwritingLayer N() {
        NexTimelineItem m = m();
        if (m == null || !(m instanceof HandwritingLayer)) {
            return null;
        }
        return (HandwritingLayer) m;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.ht
    public boolean a(View view, MotionEvent motionEvent) {
        HandwritingLayer N;
        if (!isAdded() || (N = N()) == null) {
            return false;
        }
        Stroke O = O();
        if (this.b == OptionTabFragment.TabId.ItemEditTab) {
            NexLayerItem.b closestKeyframe = N().getClosestKeyframe(N().getScaledTime(o().u()));
            if (closestKeyframe == null) {
                return false;
            }
            float pivotX = N.getPivotX();
            float pivotY = N.getPivotY();
            float[] fArr = this.I;
            Matrix matrix = this.J;
            matrix.reset();
            matrix.postScale(1280.0f / view.getWidth(), 720.0f / view.getHeight());
            matrix.postRotate(-closestKeyframe.e, closestKeyframe.c, closestKeyframe.d);
            matrix.postScale(1.0f / closestKeyframe.b, 1.0f / closestKeyframe.b, closestKeyframe.c, closestKeyframe.d);
            matrix.postTranslate(-closestKeyframe.c, -closestKeyframe.d);
            matrix.postTranslate(pivotX, pivotY);
            switch (motionEvent.getActionMasked()) {
                case 0:
                    O.c();
                    fArr[0] = motionEvent.getX();
                    fArr[1] = motionEvent.getY();
                    matrix.mapPoints(fArr);
                    O.a(fArr[0], fArr[1], this.n);
                    M();
                    break;
                case 1:
                    fArr[0] = motionEvent.getX();
                    fArr[1] = motionEvent.getY();
                    matrix.mapPoints(fArr);
                    O.a(fArr[0], fArr[1], this.n);
                    N.addStroke(O);
                    this.e.c();
                    this.d.c();
                    this.z.clear();
                    M();
                    I();
                    this.u = true;
                    break;
                case 2:
                    int historySize = motionEvent.getHistorySize();
                    for (int i = 0; i < historySize; i++) {
                        fArr[0] = motionEvent.getHistoricalX(i);
                        fArr[1] = motionEvent.getHistoricalY(i);
                        matrix.mapPoints(fArr);
                        O.a(fArr[0], fArr[1], this.n);
                    }
                    fArr[0] = motionEvent.getX();
                    fArr[1] = motionEvent.getY();
                    matrix.mapPoints(fArr);
                    O.a(fArr[0], fArr[1], this.n);
                    M();
                    break;
            }
            return true;
        }
        if (this.b == OptionTabFragment.TabId.ItemOptionTab) {
            return this.x.a(view, motionEvent);
        }
        return false;
    }

    private Stroke O() {
        switch (this.v) {
            case Pencil:
                return this.d;
            case Eraser:
                return this.e;
            default:
                return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.ed, com.nexstreaming.kinemaster.ui.projectedit.kp
    public void f() {
        if (N() != null && N().getDrawingActions().size() > 0) {
            if (this.b != OptionTabFragment.TabId.ItemOptionTab) {
                b(OptionTabFragment.TabId.ItemOptionTab);
            } else {
                a(OptionTabFragment.TabId.ItemOptionTab);
            }
        }
        if (this.x != null && this.x.a() != N()) {
            if (this.u) {
                d(this.x.a());
                this.u = false;
            }
            this.l = null;
            this.m = null;
            this.j = null;
            this.k = null;
            this.x.a(N());
        }
        M();
        H();
        I();
        d(R.id.action_animation, true);
        super.f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        i(false);
        k(false);
        j(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        i(true);
        k(true);
        j(true);
    }
}
