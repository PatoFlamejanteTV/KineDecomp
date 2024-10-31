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
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.layereditrender.MarchingAnts;
import com.nextreaming.nexeditorui.ColorPickerPopup;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class CustomMaskEditFragment extends Bg implements InterfaceC1866cf {
    private ImageView A;
    private ImageView B;
    private Tool D;
    private BrushType E;
    private LayerTransformTouchHandler F;
    private ImageView G;
    private WeakReference<com.nexstreaming.kinemaster.ui.widget.p> I;
    private WeakReference<ColorPickerPopup> J;
    private int o;
    private int p;
    private int q;
    private int r;
    private Bitmap s;
    private Bitmap t;
    private Bitmap[] u;
    private Canvas[] v;
    private float x;
    private float y;
    private ImageView z;
    private Object l = new Object();
    private Stroke m = new Stroke();
    private Stroke n = new Stroke();
    private Rect w = new Rect();
    private boolean C = false;
    private List<com.nexstreaming.kinemaster.layer.handwriting.b> H = new ArrayList();
    private Object K = this;
    private VideoEditor.b L = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts M = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
    private VideoEditor.b N = new C1915ia(this);
    private Rect O = new Rect();
    private Rect P = new Rect();
    private int Q = 0;
    private float[] R = {0.0f, 0.0f};
    private Matrix S = new Matrix();

    /* loaded from: classes2.dex */
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

        public static BrushType fromId(int i) {
            for (BrushType brushType : values()) {
                if (brushType.id == i) {
                    return brushType;
                }
            }
            return null;
        }

        public void setStroke(Stroke stroke) {
            switch (C1906ha.f22360a[ordinal()]) {
                case 1:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.a(1.0f);
                    stroke.b(false);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                case 2:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.a(0.5f);
                    stroke.b(false);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                case 3:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                case 4:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.SolidArrow);
                    return;
                case 5:
                    stroke.a(Stroke.PathStyle.Smooth);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.SolidArrow);
                    stroke.a(Stroke.CapDecorationStyle.SolidArrow);
                    return;
                case 6:
                    stroke.a(Stroke.PathStyle.Rect);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                case 7:
                    stroke.a(Stroke.PathStyle.Ellipse);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                case 8:
                    stroke.a(Stroke.PathStyle.FillRect);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                case 9:
                    stroke.a(Stroke.PathStyle.FillEllipse);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                case 10:
                    stroke.a(Stroke.PathStyle.XShape);
                    stroke.a(1.0f);
                    stroke.b(true);
                    stroke.b(Stroke.CapDecorationStyle.None);
                    stroke.a(Stroke.CapDecorationStyle.None);
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: classes2.dex */
    public enum Tool {
        Pencil,
        Eraser
    }

    public void Aa() {
    }

    public void Ba() {
        com.nexstreaming.kinemaster.ui.widget.e eVar = new com.nexstreaming.kinemaster.ui.widget.e(this.A.getContext(), true);
        this.I = new WeakReference<>(eVar);
        BrushType[] values = BrushType.values();
        int length = values.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            BrushType brushType = values[i2];
            eVar.a(brushType.iconRsrc, brushType.id, this.E == brushType);
            i++;
            if (i == 5) {
                eVar.c();
            }
        }
        eVar.a(new C2012ta(this));
        eVar.a(new C2044ua(this));
        va();
        eVar.a(this.A, 3, 0, getResources().getDimensionPixelOffset(R.dimen.handwriting_popup_offset));
    }

    public void Ca() {
        if (ya() == null) {
            return;
        }
        int i = 1;
        this.Q++;
        int i2 = this.Q;
        Color.argb(100, i2 % 256, (i2 * 2) % 256, (i2 % 2) * 255);
        Rect rect = this.O;
        synchronized (this.l) {
            int i3 = 1280;
            if (this.u == null || this.q != 1280 || this.r != 720) {
                int length = this.u == null ? 0 : this.u.length;
                this.q = 1280;
                this.r = 720;
                this.p = 5;
                this.o = 3;
                int i4 = this.p * this.o;
                if (i4 > length) {
                    Bitmap[] bitmapArr = new Bitmap[this.p * this.o];
                    Canvas[] canvasArr = new Canvas[this.p * this.o];
                    if (this.u != null && this.v != null) {
                        System.arraycopy(this.u, 0, bitmapArr, 0, this.u.length);
                        System.arraycopy(this.v, 0, canvasArr, 0, this.v.length);
                    }
                    while (length < i4) {
                        bitmapArr[length] = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
                        canvasArr[length] = new Canvas(bitmapArr[length]);
                        length++;
                    }
                    this.u = bitmapArr;
                    this.v = canvasArr;
                }
                this.w.set(0, 0, 1280, 720);
            }
            if (this.w.intersect(0, 0, 1280, 720)) {
                this.x = 256;
                this.y = 256;
                List<com.nexstreaming.kinemaster.layer.handwriting.b> customMaskDrawingActions = xa() != null ? xa().getCustomMaskDrawingActions() : null;
                Iterator<com.nexstreaming.kinemaster.layer.handwriting.b> it = customMaskDrawingActions.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    if (it.next().b()) {
                        i5++;
                    }
                }
                int i6 = 0;
                while (i6 < this.o) {
                    int i7 = 0;
                    while (i7 < this.p) {
                        int i8 = (this.p * i6) + i7;
                        int i9 = i7 + 1;
                        rect.set(((int) (i7 * this.x)) - i, ((int) (i6 * this.y)) - i, ((int) (i9 * this.x)) + i, ((int) ((i6 + 1) * this.y)) + i);
                        if (this.w.intersects(rect.left, rect.top, rect.right, rect.bottom)) {
                            float f2 = (-i7) * this.x;
                            float f3 = (-i6) * this.y;
                            Canvas canvas = this.v[i8];
                            canvas.save();
                            float f4 = i3;
                            float f5 = 720;
                            canvas.clipRect(((this.w.left + f2) * f4) / 1280.0f, ((this.w.top + f3) * f5) / 720.0f, ((this.w.right + f2) * f4) / 1280.0f, ((this.w.bottom + f3) * f5) / 720.0f);
                            if (i5 < 1) {
                                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            }
                            canvas.scale(f4 / 1280.0f, f5 / 720.0f);
                            canvas.translate(f2, f3);
                            int i10 = i5;
                            for (com.nexstreaming.kinemaster.layer.handwriting.b bVar : customMaskDrawingActions) {
                                if (bVar.b()) {
                                    i10--;
                                }
                                if (i10 < 1) {
                                    bVar.a(canvas);
                                }
                            }
                            za().a(canvas);
                            canvas.restore();
                        }
                        i7 = i9;
                        i = 1;
                        i3 = 1280;
                    }
                    i6++;
                    i = 1;
                    i3 = 1280;
                }
                this.w.setEmpty();
                da().a(NexEditor.FastPreviewOption.normal, 0, true);
            }
        }
    }

    public void Da() {
        float g2;
        int i = C1906ha.f22361b[this.D.ordinal()];
        if (i == 1) {
            this.A.setActivated(true);
            this.z.setActivated(false);
            g2 = this.m.g();
        } else if (i != 2) {
            g2 = 1.0f;
        } else {
            this.A.setActivated(false);
            this.z.setActivated(true);
            g2 = this.n.g();
        }
        this.B.setImageDrawable(new Yg(getActivity(), (g2 * S().intValue()) / 1280.0f));
    }

    public void Ea() {
        if (ya() == null) {
            return;
        }
        c(R.id.action_step_undo, xa().getCustomMaskDrawingActions().size() > 0);
        c(R.id.action_step_redo, this.H.size() > 0);
    }

    public void va() {
        l(false);
        j(false);
        k(false);
    }

    public void wa() {
        l(true);
        j(true);
        k(true);
    }

    public NexTimelineItem.j xa() {
        Fa.a Y = Y();
        if (Y == null || !(Y instanceof NexTimelineItem.j)) {
            return null;
        }
        return (NexTimelineItem.j) Y;
    }

    public NexLayerItem ya() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof NexLayerItem)) {
            return null;
        }
        return (NexLayerItem) Y;
    }

    private Stroke za() {
        int i = C1906ha.f22361b[this.D.ordinal()];
        if (i == 1) {
            return this.m;
        }
        if (i == 2) {
            return this.n;
        }
        throw new IllegalStateException();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        this.u = null;
        this.v = null;
        this.s = null;
        this.t = null;
        LayerTransformTouchHandler layerTransformTouchHandler = this.F;
        if (layerTransformTouchHandler != null) {
            layerTransformTouchHandler.a(ya());
        }
        if (this.M != null) {
            Rect rect = new Rect();
            ya().getBounds(rect);
            this.M.a(rect);
        }
        o(0);
        da().a(this.K, (NexLayerItem) Y(), this.L, this.N);
        Ca();
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        Ea();
        c(R.id.action_animation, true);
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        Ea();
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.handwriting_edit_tab, viewGroup, false);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(viewGroup.getContext());
        this.m.a(-1);
        this.m.b(defaultSharedPreferences.getFloat("km.ui.handwriting.strokeWidth", 5.0f));
        this.n.b(defaultSharedPreferences.getFloat("km.ui.handwriting.eraserWidth", 38.0f));
        this.n.a(true);
        this.D = Tool.valueOf(defaultSharedPreferences.getString("km.ui.handwriting.tool", Tool.Pencil.name()));
        this.E = BrushType.valueOf(defaultSharedPreferences.getString("km.ui.handwriting.brush", BrushType.Pencil.name()));
        this.z = (ImageView) inflate.findViewById(R.id.buttonEraser);
        this.A = (ImageView) inflate.findViewById(R.id.buttonPencil);
        this.G = (ImageView) inflate.findViewById(R.id.buttonEraseAll);
        this.A.setImageResource(this.E.iconRsrc);
        this.E.setStroke(this.m);
        this.A.setOnClickListener(new ViewOnClickListenerC1923ja(this));
        this.G.setOnClickListener(new ViewOnClickListenerC1932ka(this));
        this.A.setOnLongClickListener(new ViewOnLongClickListenerC1941la(this));
        this.z.setOnClickListener(new ViewOnClickListenerC1950ma(this));
        this.z.setOnLongClickListener(new ViewOnLongClickListenerC1959na(this));
        this.B = (ImageView) inflate.findViewById(R.id.buttonSize);
        this.B.setOnClickListener(new ViewOnClickListenerC2003sa(this));
        Da();
        this.F = new LayerTransformTouchHandler(inflate.getContext(), ya(), da());
        na();
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        WeakReference<ColorPickerPopup> weakReference = this.J;
        if (weakReference != null) {
            ColorPickerPopup colorPickerPopup = weakReference.get();
            if (colorPickerPopup != null) {
                colorPickerPopup.a();
            }
            this.J = null;
        }
        WeakReference<com.nexstreaming.kinemaster.ui.widget.p> weakReference2 = this.I;
        if (weakReference2 != null) {
            com.nexstreaming.kinemaster.ui.widget.p pVar = weakReference2.get();
            if (pVar != null) {
                pVar.a();
            }
            this.I = null;
        }
        this.u = null;
        this.v = null;
        this.s = null;
        this.t = null;
        this.B = null;
        this.z = null;
        this.A = null;
        this.F = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (this.C) {
            G();
        }
        da().a(this.K, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1976p
    public boolean h(int i) {
        switch (i) {
            case R.id.action_step_redo /* 2131361874 */:
                if (this.H.size() > 0) {
                    NexTimelineItem.j xa = xa();
                    List<com.nexstreaming.kinemaster.layer.handwriting.b> list = this.H;
                    xa.addCMDrawingAction(list.remove(list.size() - 1));
                    this.w.set(0, 0, 1280, 720);
                    this.C = true;
                    Ca();
                    Ea();
                }
                return true;
            case R.id.action_step_undo /* 2131361875 */:
                com.nexstreaming.kinemaster.layer.handwriting.b removeLastCMDrawingAction = xa().removeLastCMDrawingAction();
                if (removeLastCMDrawingAction != null) {
                    this.H.add(removeLastCMDrawingAction);
                    this.w.set(0, 0, 1280, 720);
                    this.C = true;
                    Ca();
                    Ea();
                }
                return true;
            default:
                return super.h(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        NexLayerItem ya;
        NexTimelineItem.j xa;
        if (!isAdded() || (ya = ya()) == null || (xa = xa()) == null) {
            return false;
        }
        Stroke za = za();
        NexLayerItem.b closestKeyframe = ya().getClosestKeyframe(ya().getScaledTime(da().v()));
        if (closestKeyframe == null) {
            return false;
        }
        float[] fArr = this.R;
        Matrix matrix = this.S;
        matrix.reset();
        matrix.postScale(1280.0f / view.getWidth(), 720.0f / view.getHeight());
        matrix.postRotate(-closestKeyframe.f20234e, closestKeyframe.f20232c, closestKeyframe.f20233d);
        float f2 = closestKeyframe.f20231b;
        matrix.postScale(1.0f / f2, 1.0f / f2, closestKeyframe.f20232c, closestKeyframe.f20233d);
        matrix.postScale(1.0f / (ya.getFlipV() ? -1 : 1), 1.0f / (ya.getFlipH() ? -1 : 1), closestKeyframe.f20232c, closestKeyframe.f20233d);
        matrix.postTranslate(-closestKeyframe.f20232c, -closestKeyframe.f20233d);
        matrix.postTranslate(640.0f, 360.0f);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            za.c();
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
            matrix.mapPoints(fArr);
            za.a(fArr[0], fArr[1], this.w, motionEvent.getPressure());
            Ca();
        } else if (actionMasked == 1) {
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
            matrix.mapPoints(fArr);
            za.a(fArr[0], fArr[1], this.w, motionEvent.getPressure());
            xa.addCMStroke(za);
            this.n.c();
            this.m.c();
            this.H.clear();
            Ca();
            Ea();
            this.C = true;
        } else if (actionMasked == 2) {
            int historySize = motionEvent.getHistorySize();
            for (int i = 0; i < historySize; i++) {
                fArr[0] = motionEvent.getHistoricalX(i);
                fArr[1] = motionEvent.getHistoricalY(i);
                matrix.mapPoints(fArr);
                za.a(fArr[0], fArr[1], this.w, motionEvent.getHistoricalPressure(i));
            }
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
            matrix.mapPoints(fArr);
            za.a(fArr[0], fArr[1], this.w, motionEvent.getPressure());
            Ca();
        }
        return true;
    }
}
