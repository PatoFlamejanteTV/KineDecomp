package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class HandwritingLayer extends NexLayerItem {
    private static final Interpolator n = new AccelerateDecelerateInterpolator();
    private int boundsBottom;
    private int boundsLeft;
    private int boundsRight;
    private int boundsTop;
    private transient int o;
    private transient int p;
    private transient boolean q;
    private transient Bitmap r;
    private transient Canvas s;
    private transient int t;
    private List<com.nexstreaming.kinemaster.layer.handwriting.b> drawingActionList = new ArrayList();
    private List<com.nexstreaming.kinemaster.layer.handwriting.b> unmodifiableDrawingActionList = Collections.unmodifiableList(this.drawingActionList);
    private int pivotX = EditorGlobal.n() / 2;
    private int pivotY = EditorGlobal.m() / 2;
    private int[] effect_id_ = {-1, -1};
    private int[] current_blend_mode_ = {0, 0};

    private void f() {
        int n2;
        int m;
        int i;
        if (this.q) {
            return;
        }
        boolean isPivotMovable = isPivotMovable();
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        Iterator<com.nexstreaming.kinemaster.layer.handwriting.b> it = getDrawingActions().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().b()) {
                i2++;
            }
        }
        for (com.nexstreaming.kinemaster.layer.handwriting.b bVar : getDrawingActions()) {
            if (bVar.b()) {
                i2--;
            }
            if (i2 < 1) {
                bVar.a(rectF);
                rectF2.union(rectF);
            }
        }
        this.boundsLeft = (int) Math.floor(rectF2.left);
        this.boundsTop = (int) Math.floor(rectF2.top);
        this.boundsRight = (int) Math.ceil(rectF2.right);
        this.boundsBottom = (int) Math.ceil(rectF2.bottom);
        this.boundsLeft = Math.max(0, this.boundsLeft);
        this.boundsTop = Math.max(0, this.boundsTop);
        this.boundsRight = Math.min(EditorGlobal.n(), this.boundsRight);
        this.boundsBottom = Math.min(EditorGlobal.m(), this.boundsBottom);
        if (this.boundsRight - this.boundsLeft < 1 || this.boundsBottom - this.boundsTop < 1) {
            this.boundsLeft = (EditorGlobal.n() / 2) - 25;
            this.boundsTop = (EditorGlobal.m() / 2) - 25;
            this.boundsRight = this.boundsLeft + 50;
            this.boundsBottom = this.boundsTop + 50;
        }
        int i3 = this.boundsRight;
        int i4 = this.boundsLeft;
        this.o = i3 - i4;
        int i5 = this.boundsBottom;
        int i6 = this.boundsTop;
        this.p = i5 - i6;
        if (isPivotMovable) {
            int i7 = this.o;
            if (i7 >= 1 && (i = this.p) >= 1) {
                n2 = i4 + (i7 / 2);
                m = i6 + (i / 2);
            } else {
                n2 = EditorGlobal.n() / 2;
                m = EditorGlobal.m() / 2;
            }
            adjustForPivotChange(n2 - this.pivotX, m - this.pivotY);
            this.pivotX = n2;
            this.pivotY = m;
        }
        this.q = true;
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        HandwritingLayer handwritingLayer = new HandwritingLayer();
        handwritingLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        Iterator<KMProto.KMProject.DrawingAction> it = timelineItem.handwriting_layer.drawing_actions.iterator();
        while (it.hasNext()) {
            handwritingLayer.drawingActionList.add(com.nexstreaming.kinemaster.layer.handwriting.b.a(it.next()));
        }
        NexLayerItem.fromProtoBuf(timelineItem.handwriting_layer.layer_common, handwritingLayer);
        handwritingLayer.q = false;
        KMProto.KMProject.HandwritingLayer handwritingLayer2 = timelineItem.handwriting_layer;
        Integer num = handwritingLayer2.pivot_x;
        if (num != null && handwritingLayer2.pivot_y != null) {
            handwritingLayer.pivotX = num.intValue();
            handwritingLayer.pivotY = timelineItem.handwriting_layer.pivot_y.intValue();
        }
        Integer num2 = timelineItem.track_id;
        handwritingLayer.track_id = num2 != null ? num2.intValue() : 0;
        return handwritingLayer;
    }

    public void addDrawingAction(com.nexstreaming.kinemaster.layer.handwriting.b bVar) {
        this.drawingActionList.add(bVar);
        this.q = false;
    }

    public void addEraseAll() {
        if (!this.drawingActionList.isEmpty()) {
            if (this.drawingActionList.get(r0.size() - 1) instanceof com.nexstreaming.kinemaster.layer.handwriting.c) {
                return;
            }
        }
        this.drawingActionList.add(new com.nexstreaming.kinemaster.layer.handwriting.c());
        this.q = false;
    }

    public void addStroke(Stroke stroke) {
        this.drawingActionList.add(new Stroke(stroke));
        this.q = false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.HandwritingLayer.Builder builder = new KMProto.KMProject.HandwritingLayer.Builder();
        builder.drawing_actions = new ArrayList(this.drawingActionList.size());
        Iterator<com.nexstreaming.kinemaster.layer.handwriting.b> it = this.drawingActionList.iterator();
        while (it.hasNext()) {
            builder.drawing_actions.add(it.next().a());
        }
        builder.layer_common = getLayerCommonProtoBuf();
        builder.pivot_x = Integer.valueOf(this.pivotX);
        builder.pivot_y = Integer.valueOf(this.pivotY);
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_HANDWRITING).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).handwriting_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_handwriting;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        if (rect != null) {
            f();
            rect.set(this.boundsLeft, this.boundsTop, this.boundsRight, this.boundsBottom);
            rect.offset(-this.pivotX, -this.pivotY);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return context.getResources().getString(R.string.layer_menu_handwriting);
    }

    public List<com.nexstreaming.kinemaster.layer.handwriting.b> getDrawingActions() {
        return this.unmodifiableDrawingActionList;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        f();
        return this.p;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_handwriting;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return context.getString(R.string.layer_menu_handwriting);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return HandwritingEditFragment.class;
    }

    public int getPivotX() {
        return this.pivotX;
    }

    public int getPivotY() {
        return this.pivotY;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_item_secondary_handwriting;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getTrackAffinity() {
        return R.drawable.track_header_handwriting_icon;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int[] getTrackOptionItems() {
        return new int[]{R.id.opt_alpha_adj};
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        f();
        return this.o;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        if (i == R.id.opt_blending) {
            return getBlendMode() != BlendMode.NONE;
        }
        if (i != R.id.opt_rotate) {
            return super.isOptionApplied(i);
        }
        return getRotation() != 0 || getFlipH() || getFlipV();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f2, float f3, int i) {
        return f2 >= ((float) (this.boundsLeft - (EditorGlobal.n() / 2))) && f2 <= ((float) (this.boundsRight - (EditorGlobal.n() / 2))) && f3 >= ((float) (this.boundsTop - (EditorGlobal.m() / 2))) && f3 <= ((float) (this.boundsBottom - (EditorGlobal.m() / 2)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0135  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003e  */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onRender(com.nextreaming.nexvideoeditor.LayerRenderer r22, com.nexstreaming.kinemaster.editorwrapper.NexLayerItem.b r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.layer.HandwritingLayer.onRender(com.nextreaming.nexvideoeditor.LayerRenderer, com.nexstreaming.kinemaster.editorwrapper.NexLayerItem$b, boolean):void");
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.r = null;
        NexEditor i = EditorGlobal.i();
        if (i == null || this.effect_id_[layerRenderer.l().id] < 0) {
            return;
        }
        i.d(this.effect_id_[layerRenderer.l().id], layerRenderer.l().id);
        this.effect_id_[layerRenderer.l().id] = -1;
        this.current_blend_mode_[layerRenderer.l().id] = 0;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        int i;
        f();
        int i2 = this.o;
        if (i2 < 1 || (i = this.p) < 1) {
            return;
        }
        this.r = Bitmap.createBitmap(i2, i, Bitmap.Config.ARGB_8888);
        this.s = new Canvas(this.r);
        this.s.save();
        this.s.translate(-this.boundsLeft, -this.boundsTop);
        int i3 = 0;
        Iterator<com.nexstreaming.kinemaster.layer.handwriting.b> it = getDrawingActions().iterator();
        while (it.hasNext()) {
            if (it.next().b()) {
                i3++;
            }
        }
        for (com.nexstreaming.kinemaster.layer.handwriting.b bVar : getDrawingActions()) {
            if (bVar.b()) {
                i3--;
            }
            if (i3 < 1) {
                bVar.a(this.s);
            }
        }
        this.s.restore();
        this.t = 1000;
        layerRenderer.a(this.r);
    }

    public com.nexstreaming.kinemaster.layer.handwriting.b removeLastDrawingAction() {
        if (this.drawingActionList.size() <= 0) {
            return null;
        }
        this.q = false;
        return this.drawingActionList.remove(r0.size() - 1);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }
}
