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
import android.support.v4.internal.view.SupportMenu;
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
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class HandwritingEditFragment extends OptionTabFragment implements InterfaceC1866cf {
    private OptionTabFragment.TabId E;
    private OptionTabFragment.TabId F;
    private int J;
    private int K;
    private int L;
    private int M;
    private Bitmap N;
    private Bitmap O;
    private Bitmap[] P;
    private Canvas[] Q;
    private float S;
    private float T;
    private ImageView U;
    private ImageView V;
    private ImageView W;
    private ImageView X;
    private Tool Z;
    private BrushType aa;
    private LayerTransformTouchHandler ba;
    private ImageView ca;
    private WeakReference<com.nexstreaming.kinemaster.ui.widget.p> ea;
    private WeakReference<ColorPickerPopup> fa;
    private Object G = new Object();
    private Stroke H = new Stroke();
    private Stroke I = new Stroke();
    private Rect R = new Rect();
    private boolean Y = false;
    private List<com.nexstreaming.kinemaster.layer.handwriting.b> da = new ArrayList();
    private VideoEditor.b ga = com.nexstreaming.kinemaster.ui.layereditrender.a.b();
    private MarchingAnts ha = new MarchingAnts(MarchingAnts.Feature.ROTATE_HANDLE, MarchingAnts.Feature.SIZE_HANDLE);
    private VideoEditor.b ia = new Ua(this);
    private Object ja = this;
    private Rect ka = new Rect();
    private Rect la = new Rect();
    private int ma = 0;
    private float[] na = {0.0f, 0.0f};
    private Matrix oa = new Matrix();

    /* JADX INFO: Access modifiers changed from: private */
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
            switch (Ta.f22096a[ordinal()]) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum Tool {
        Pencil,
        Eraser
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aa() {
        l(false);
        j(false);
        k(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ba() {
        l(true);
        j(true);
        k(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HandwritingLayer Ca() {
        NexTimelineItem Y = Y();
        if (Y == null || !(Y instanceof HandwritingLayer)) {
            return null;
        }
        return (HandwritingLayer) Y;
    }

    private Stroke Da() {
        int i = Ta.f22097b[this.Z.ordinal()];
        if (i == 1) {
            return this.H;
        }
        if (i == 2) {
            return this.I;
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ea() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Fa() {
        com.nexstreaming.kinemaster.ui.widget.e eVar = new com.nexstreaming.kinemaster.ui.widget.e(this.V.getContext(), true);
        this.ea = new WeakReference<>(eVar);
        BrushType[] values = BrushType.values();
        int length = values.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            BrushType brushType = values[i2];
            eVar.a(brushType.iconRsrc, brushType.id, this.aa == brushType);
            i++;
            if (i == 5) {
                eVar.c();
            }
        }
        eVar.a(new C1907hb(this));
        eVar.a(new Qa(this));
        Aa();
        eVar.a(this.V, 3, 0, getResources().getDimensionPixelOffset(R.dimen.handwriting_popup_offset));
    }

    private void Ga() {
        OptionTabFragment.TabId tabId = this.F;
        if (tabId == this.E) {
            return;
        }
        this.E = tabId;
        if (M().pa()) {
            pa();
        } else {
            oa();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        int i;
        int i2;
        Rect rect;
        int i3;
        HandwritingLayer Ca = Ca();
        if (Ca == null) {
            return;
        }
        this.ma++;
        int n = EditorGlobal.n();
        int m = EditorGlobal.m();
        int i4 = this.ma;
        Color.argb(100, i4 % 256, (i4 * 2) % 256, (i4 % 2) * 255);
        Rect rect2 = this.ka;
        synchronized (this.G) {
            int intValue = S().intValue();
            int intValue2 = R().intValue();
            if (this.P == null || this.L != intValue || this.M != intValue2) {
                int length = this.P == null ? 0 : this.P.length;
                this.L = intValue;
                this.M = intValue2;
                this.K = ((intValue + 256) - 1) / 256;
                this.J = ((intValue2 + 256) - 1) / 256;
                int i5 = this.K * this.J;
                if (i5 > length) {
                    Bitmap[] bitmapArr = new Bitmap[this.K * this.J];
                    Canvas[] canvasArr = new Canvas[this.K * this.J];
                    if (this.P != null && this.Q != null) {
                        System.arraycopy(this.P, 0, bitmapArr, 0, this.P.length);
                        System.arraycopy(this.Q, 0, canvasArr, 0, this.Q.length);
                    }
                    while (length < i5) {
                        bitmapArr[length] = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
                        canvasArr[length] = new Canvas(bitmapArr[length]);
                        length++;
                    }
                    this.P = bitmapArr;
                    this.Q = canvasArr;
                }
                this.R.set(0, 0, n, m);
            }
            if (this.R.intersect(0, 0, n, m)) {
                this.S = (n * 256) / intValue;
                this.T = (m * 256) / intValue2;
                List<com.nexstreaming.kinemaster.layer.handwriting.b> drawingActions = Ca.getDrawingActions();
                Iterator<com.nexstreaming.kinemaster.layer.handwriting.b> it = drawingActions.iterator();
                int i6 = 0;
                while (it.hasNext()) {
                    if (it.next().b()) {
                        i6++;
                    }
                }
                for (int i7 = 0; i7 < this.J; i7++) {
                    int i8 = 0;
                    while (i8 < this.K) {
                        int i9 = (this.K * i7) + i8;
                        int i10 = i8 + 1;
                        List<com.nexstreaming.kinemaster.layer.handwriting.b> list = drawingActions;
                        rect2.set(((int) (i8 * this.S)) - 1, ((int) (i7 * this.T)) - 1, ((int) (i10 * this.S)) + 1, ((int) ((i7 + 1) * this.T)) + 1);
                        if (this.R.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom)) {
                            float f2 = (-i8) * this.S;
                            float f3 = (-i7) * this.T;
                            Canvas canvas = this.Q[i9];
                            canvas.save();
                            float f4 = intValue;
                            float f5 = n;
                            i = n;
                            float f6 = intValue2;
                            rect = rect2;
                            float f7 = m;
                            i2 = m;
                            i3 = intValue;
                            canvas.clipRect(((this.R.left + f2) * f4) / f5, ((this.R.top + f3) * f6) / f7, ((this.R.right + f2) * f4) / f5, ((this.R.bottom + f3) * f6) / f7);
                            if (i6 < 1) {
                                canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                            }
                            canvas.scale(f4 / f5, f6 / f7);
                            canvas.translate(f2, f3);
                            int i11 = i6;
                            for (com.nexstreaming.kinemaster.layer.handwriting.b bVar : list) {
                                if (bVar.b()) {
                                    i11--;
                                }
                                if (i11 < 1) {
                                    bVar.a(canvas);
                                }
                            }
                            Da().a(canvas);
                            canvas.restore();
                        } else {
                            i = n;
                            i2 = m;
                            rect = rect2;
                            i3 = intValue;
                        }
                        i8 = i10;
                        drawingActions = list;
                        n = i;
                        rect2 = rect;
                        m = i2;
                        intValue = i3;
                    }
                }
                this.R.setEmpty();
                da().a(NexEditor.FastPreviewOption.normal, 0, true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia() {
        int i = Ta.f22097b[this.Z.ordinal()];
        float f2 = 1.0f;
        if (i == 1) {
            this.V.setActivated(true);
            this.U.setActivated(false);
            this.W.setEnabled(true);
            this.W.setAlpha(1.0f);
            f2 = this.H.g();
        } else if (i == 2) {
            this.V.setActivated(false);
            this.U.setActivated(true);
            this.W.setEnabled(false);
            this.W.setAlpha(0.2f);
            f2 = this.I.g();
        }
        this.X.setImageDrawable(new Yg(getActivity(), (f2 * S().intValue()) / EditorGlobal.n()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ja() {
        if (Ca() == null) {
            return;
        }
        c(R.id.action_step_undo, Ca().getDrawingActions().size() > 0);
        c(R.id.action_step_redo, this.da.size() > 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void na() {
        if (Ca() != null && Ca().getDrawingActions().size() > 0) {
            OptionTabFragment.TabId tabId = this.F;
            OptionTabFragment.TabId tabId2 = OptionTabFragment.TabId.ItemOptionTab;
            if (tabId != tabId2) {
                d(tabId2);
            } else {
                c(tabId2);
            }
        }
        this.P = null;
        this.Q = null;
        this.N = null;
        this.O = null;
        LayerTransformTouchHandler layerTransformTouchHandler = this.ba;
        if (layerTransformTouchHandler != null) {
            layerTransformTouchHandler.a(Ca());
        }
        if (Ca() != null && this.ha != null) {
            Rect rect = new Rect();
            Ca().getBounds(rect);
            this.ha.a(rect);
        }
        Ha();
        Ga();
        Ja();
        c(R.id.action_animation, true);
        super.na();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void oa() {
        OptionTabFragment.TabId tabId = this.F;
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            a(R.id.action_step_undo, R.drawable.action_stepundo, R.id.action_step_redo, R.drawable.action_stepredo, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_bring_forward, R.string.action_bring_forward, R.id.action_send_backward, R.string.action_send_backward, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        } else if (tabId == OptionTabFragment.TabId.ItemOptionTab) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_animation, R.drawable.action_animation, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip, R.id.action_bring_to_front, R.string.action_bring_to_front, R.id.action_bring_forward, R.string.action_bring_forward, R.id.action_send_backward, R.string.action_send_backward, R.id.action_send_to_back, R.string.action_send_to_back, R.id.action_align_center_horizontal, R.string.action_center_horizontal, R.id.action_align_center_vertical, R.string.action_center_vertical);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        Ga();
        Ja();
        super.onActivityCreated(bundle);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment, com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.Bg, android.support.v4.app.Fragment
    public void onDestroyView() {
        WeakReference<ColorPickerPopup> weakReference = this.fa;
        if (weakReference != null) {
            ColorPickerPopup colorPickerPopup = weakReference.get();
            if (colorPickerPopup != null) {
                colorPickerPopup.a();
            }
            this.fa = null;
        }
        WeakReference<com.nexstreaming.kinemaster.ui.widget.p> weakReference2 = this.ea;
        if (weakReference2 != null) {
            com.nexstreaming.kinemaster.ui.widget.p pVar = weakReference2.get();
            if (pVar != null) {
                pVar.a();
            }
            this.ea = null;
        }
        this.P = null;
        this.Q = null;
        this.N = null;
        this.O = null;
        this.W = null;
        this.X = null;
        this.U = null;
        this.V = null;
        this.ba = null;
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.F = null;
        this.E = null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        if (this.Y) {
            G();
        }
        da().a(this.ja, (NexLayerItem) null, (VideoEditor.b) null, (VideoEditor.b) null);
        da().a(NexEditor.FastPreviewOption.normal, 0, true);
        super.onStop();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg
    public void pa() {
        OptionTabFragment.TabId tabId = this.F;
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            a(R.id.action_step_undo, R.drawable.action_stepundo, R.id.action_step_redo, R.drawable.action_stepredo, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        } else if (tabId == OptionTabFragment.TabId.ItemOptionTab) {
            a(R.id.action_undo, 0, R.id.action_redo, 0, R.id.action_expand_preview, R.drawable.action_inset_preview, R.id.action_delete, R.drawable.action_icon_delete, R.id.action_overflow, R.drawable.action_overflow, R.id.action_duplicate_clip, R.string.action_duplicate_clip);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected boolean r(int i) {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected int[] ua() {
        return new int[]{R.id.opt_in_expression, R.id.opt_overall_expression, R.id.opt_out_expression, R.id.opt_alpha_adj, R.id.opt_split_trim, R.id.opt_rotate_for_hw, R.id.opt_layer_mask, R.id.opt_blending, R.id.opt_information};
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc
    protected String wa() {
        return getString(R.string.layer_menu_handwriting);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected int za() {
        return R.drawable.opthdr_handwriting;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected void c(OptionTabFragment.TabId tabId) {
        this.F = tabId;
        Ga();
        int i = Ta.f22098c[tabId.ordinal()];
        if (i == 1) {
            o(0);
            da().a(this.ja, (NexLayerItem) Y(), this.ga, this.ia);
            Ha();
            da().a(NexEditor.FastPreviewOption.normal, 0, true);
            return;
        }
        if (i != 2) {
            return;
        }
        o(R.id.editmode_trim);
        Rect rect = new Rect();
        Ca().getBounds(rect);
        this.ha.a(rect);
        View Q = Q();
        if (Q != null) {
            Q.addOnLayoutChangeListener(new Ra(this));
            Q.getViewTreeObserver().addOnGlobalLayoutListener(new Sa(this));
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Bg, com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1976p
    public boolean h(int i) {
        int n = EditorGlobal.n();
        int m = EditorGlobal.m();
        switch (i) {
            case R.id.action_step_redo /* 2131361874 */:
                if (this.da.size() > 0) {
                    HandwritingLayer Ca = Ca();
                    List<com.nexstreaming.kinemaster.layer.handwriting.b> list = this.da;
                    Ca.addDrawingAction(list.remove(list.size() - 1));
                    this.R.set(0, 0, n, m);
                    this.Y = true;
                    Ha();
                    Ja();
                }
                return true;
            case R.id.action_step_undo /* 2131361875 */:
                com.nexstreaming.kinemaster.layer.handwriting.b removeLastDrawingAction = Ca().removeLastDrawingAction();
                if (removeLastDrawingAction != null) {
                    this.da.add(removeLastDrawingAction);
                    this.R.set(0, 0, n, m);
                    this.Y = true;
                    Ha();
                    Ja();
                }
                return true;
            default:
                return super.h(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.OptionTabFragment
    protected View b(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.handwriting_edit_tab, viewGroup, false);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(viewGroup.getContext());
        this.H.a(defaultSharedPreferences.getInt("km.ui.handwriting.color", SupportMenu.CATEGORY_MASK));
        this.H.b(defaultSharedPreferences.getFloat("km.ui.handwriting.strokeWidth", 5.0f));
        this.I.b(defaultSharedPreferences.getFloat("km.ui.handwriting.eraserWidth", 38.0f));
        this.I.a(true);
        this.Z = Tool.valueOf(defaultSharedPreferences.getString("km.ui.handwriting.tool", Tool.Pencil.name()));
        this.aa = BrushType.valueOf(defaultSharedPreferences.getString("km.ui.handwriting.brush", BrushType.Pencil.name()));
        this.U = (ImageView) inflate.findViewById(R.id.buttonEraser);
        this.V = (ImageView) inflate.findViewById(R.id.buttonPencil);
        this.ca = (ImageView) inflate.findViewById(R.id.buttonEraseAll);
        this.V.setImageResource(this.aa.iconRsrc);
        this.aa.setStroke(this.H);
        this.V.setOnClickListener(new Va(this));
        this.ca.setOnClickListener(new Wa(this));
        this.V.setOnLongClickListener(new Xa(this));
        this.U.setOnClickListener(new Ya(this));
        this.U.setOnLongClickListener(new Za(this));
        this.W = (ImageView) inflate.findViewById(R.id.buttonColor);
        this.W.setImageDrawable(new C1897ga(getActivity(), this.H.d()));
        this.W.setOnClickListener(new ViewOnClickListenerC1853bb(this));
        this.X = (ImageView) inflate.findViewById(R.id.buttonSize);
        this.X.setOnClickListener(new ViewOnClickListenerC1898gb(this));
        Ia();
        this.ba = new LayerTransformTouchHandler(inflate.getContext(), Ca(), da());
        return inflate;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Xc, com.nexstreaming.kinemaster.ui.projectedit.C1935kd.a
    public void a(int i) {
        super.a(i);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.InterfaceC1866cf
    public boolean a(View view, MotionEvent motionEvent) {
        HandwritingLayer Ca;
        if (!isAdded() || (Ca = Ca()) == null) {
            return false;
        }
        Stroke Da = Da();
        OptionTabFragment.TabId tabId = this.F;
        if (tabId == OptionTabFragment.TabId.ItemEditTab) {
            NexLayerItem.b closestKeyframe = Ca().getClosestKeyframe(Ca().getScaledTime(da().v()));
            if (closestKeyframe == null) {
                return false;
            }
            float pivotX = Ca.getPivotX();
            float pivotY = Ca.getPivotY();
            float[] fArr = this.na;
            Matrix matrix = this.oa;
            matrix.reset();
            matrix.postScale(EditorGlobal.n() / view.getWidth(), EditorGlobal.m() / view.getHeight());
            matrix.postRotate(-closestKeyframe.f20234e, closestKeyframe.f20232c, closestKeyframe.f20233d);
            float f2 = closestKeyframe.f20231b;
            matrix.postScale(1.0f / f2, 1.0f / f2, closestKeyframe.f20232c, closestKeyframe.f20233d);
            matrix.postScale(1.0f / (Ca.getFlipH() ? -1 : 1), 1.0f / (Ca.getFlipV() ? -1 : 1), closestKeyframe.f20232c, closestKeyframe.f20233d);
            matrix.postTranslate(-closestKeyframe.f20232c, -closestKeyframe.f20233d);
            matrix.postTranslate(pivotX, pivotY);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                Da.c();
                fArr[0] = motionEvent.getX();
                fArr[1] = motionEvent.getY();
                matrix.mapPoints(fArr);
                Da.a(fArr[0], fArr[1], this.R, motionEvent.getPressure());
                Ha();
            } else if (actionMasked == 1) {
                fArr[0] = motionEvent.getX();
                fArr[1] = motionEvent.getY();
                matrix.mapPoints(fArr);
                Da.a(fArr[0], fArr[1], this.R, motionEvent.getPressure());
                Ca.addStroke(Da);
                this.I.c();
                this.H.c();
                this.da.clear();
                Ha();
                Ja();
                this.Y = true;
            } else if (actionMasked == 2) {
                int historySize = motionEvent.getHistorySize();
                for (int i = 0; i < historySize; i++) {
                    fArr[0] = motionEvent.getHistoricalX(i);
                    fArr[1] = motionEvent.getHistoricalY(i);
                    matrix.mapPoints(fArr);
                    Da.a(fArr[0], fArr[1], this.R, motionEvent.getHistoricalPressure(i));
                }
                fArr[0] = motionEvent.getX();
                fArr[1] = motionEvent.getY();
                matrix.mapPoints(fArr);
                Da.a(fArr[0], fArr[1], this.R, motionEvent.getPressure());
                Ha();
            }
            return true;
        }
        if (tabId == OptionTabFragment.TabId.ItemOptionTab) {
            return this.ba.a(view, motionEvent);
        }
        return false;
    }
}
