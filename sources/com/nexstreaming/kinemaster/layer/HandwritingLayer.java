package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.LayerExpression;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.layer.handwriting.Stroke;
import com.nexstreaming.kinemaster.ui.projectedit.HandwritingEditFragment;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class HandwritingLayer extends NexLayerItem {
    private static final Interpolator d = new AccelerateDecelerateInterpolator();

    /* renamed from: a, reason: collision with root package name */
    private transient int f3471a;
    private transient int b;
    private int boundsBottom;
    private int boundsLeft;
    private int boundsRight;
    private int boundsTop;
    private transient boolean c;
    private transient Bitmap e;
    private transient Canvas f;
    private transient int g;
    private List<com.nexstreaming.kinemaster.layer.handwriting.a> drawingActionList = new ArrayList();
    private List<com.nexstreaming.kinemaster.layer.handwriting.a> unmodifiableDrawingActionList = Collections.unmodifiableList(this.drawingActionList);
    private int pivotX = 640;
    private int pivotY = 360;

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        int i;
        a();
        if (this.f3471a >= 1 && this.b >= 1) {
            this.e = Bitmap.createBitmap(this.f3471a, this.b, Bitmap.Config.ARGB_8888);
            this.f = new Canvas(this.e);
            this.f.save();
            this.f.translate(-this.boundsLeft, -this.boundsTop);
            int i2 = 0;
            Iterator<com.nexstreaming.kinemaster.layer.handwriting.a> it = getDrawingActions().iterator();
            while (true) {
                i = i2;
                if (!it.hasNext()) {
                    break;
                } else {
                    i2 = it.next().a() ? i + 1 : i;
                }
            }
            for (com.nexstreaming.kinemaster.layer.handwriting.a aVar : getDrawingActions()) {
                if (aVar.a()) {
                    i--;
                }
                if (i < 1) {
                    aVar.a(this.f);
                }
            }
            this.f.restore();
            this.g = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
            layerRenderer.b(this.e);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.e = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar) {
        int i;
        float f;
        boolean z;
        float f2;
        int i2;
        int i3;
        if (this.e != null) {
            layerRenderer.l();
            int i4 = 0;
            float f3 = 0.5f;
            boolean z2 = false;
            LayerExpression layerExpression = getLayerExpression(LayerExpression.Type.In);
            LayerExpression layerExpression2 = getLayerExpression(LayerExpression.Type.Out);
            if (layerExpression == LayerExpression.DrawByStroke) {
                i4 = getLayerExpressionDuration(LayerExpression.Type.In);
                f3 = 0.5f;
            } else if (layerExpression == LayerExpression.DrawInOrder) {
                i4 = getLayerExpressionDuration(LayerExpression.Type.In);
                f3 = 0.9f;
                z2 = true;
            }
            if (layerExpression2 == LayerExpression.UnDrawByStroke) {
                boolean z3 = z2;
                i = getLayerExpressionDuration(LayerExpression.Type.Out);
                f = 0.5f;
                z = z3;
            } else if (layerExpression2 != LayerExpression.UnDrawInOrder) {
                boolean z4 = z2;
                i = 0;
                f = f3;
                z = z4;
            } else {
                i = getLayerExpressionDuration(LayerExpression.Type.Out);
                f = 0.9f;
                z = true;
            }
            int absStartTime = getAbsStartTime();
            int absEndTime = getAbsEndTime() - absStartTime;
            if (i4 + i > absEndTime) {
                int i5 = (i4 + i) - absEndTime;
                i4 -= (i5 + 1) / 2;
                i -= (i5 + 1) / 2;
            }
            int j = layerRenderer.j() - absStartTime;
            if (j < i4 && i4 > 0) {
                f2 = j / i4;
            } else if (j > absEndTime - i && i > 0) {
                f2 = 1.0f - ((j - (absEndTime - i)) / i);
            } else {
                f2 = 1.0f;
            }
            int interpolation = (int) (d.getInterpolation(f2) * 1000.0f);
            if (this.g != interpolation) {
                this.g = interpolation;
                this.f.drawColor(0, PorterDuff.Mode.CLEAR);
                this.f.save();
                this.f.translate(-this.boundsLeft, -this.boundsTop);
                int i6 = 0;
                int size = getDrawingActions().size();
                Iterator<com.nexstreaming.kinemaster.layer.handwriting.a> it = getDrawingActions().iterator();
                while (true) {
                    i2 = i6;
                    if (!it.hasNext()) {
                        break;
                    } else {
                        i6 = it.next().a() ? i2 + 1 : i2;
                    }
                }
                boolean z5 = z;
                int i7 = 0;
                int i8 = size;
                float f4 = f;
                int i9 = i2;
                for (com.nexstreaming.kinemaster.layer.handwriting.a aVar : getDrawingActions()) {
                    if (aVar.a()) {
                        i9--;
                    }
                    if (i9 < 1) {
                        if (z5) {
                            z5 = false;
                            f4 = 1.0f - (1.0f / (i8 + 1.0f));
                        }
                        float f5 = interpolation / 1000.0f;
                        float f6 = (i7 / i8) * f4;
                        float f7 = (1.0f - f4) + f6;
                        if (f5 >= f6 && f5 <= f7) {
                            aVar.a(this.f, (f5 - f6) / (f7 - f6));
                        } else if (f5 >= f7) {
                            aVar.a(this.f, 1.0f);
                        }
                        i3 = i7 + 1;
                    } else {
                        i8--;
                        i3 = i7;
                    }
                    f4 = f4;
                    z5 = z5;
                    i8 = i8;
                    i7 = i3;
                }
                this.f.restore();
            }
            if (!this.c) {
                a();
            }
            layerRenderer.a(-this.pivotX, -this.pivotY);
            layerRenderer.a(this.e, this.boundsLeft, this.boundsTop, this.boundsRight, this.boundsBottom);
            layerRenderer.m();
        }
    }

    public int getPivotX() {
        return this.pivotX;
    }

    public int getPivotY() {
        return this.pivotY;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return context.getString(R.string.layer_menu_handwriting);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return context.getResources().getString(R.string.layer_menu_handwriting);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends kp> getOptionMenuClass() {
        return HandwritingEditFragment.class;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_handwriting;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_handwriting;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        a();
        return this.f3471a;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        a();
        return this.b;
    }

    private void a() {
        int i;
        int i2;
        if (!this.c) {
            boolean isPivotMovable = isPivotMovable();
            RectF rectF = new RectF();
            RectF rectF2 = new RectF();
            Iterator<com.nexstreaming.kinemaster.layer.handwriting.a> it = getDrawingActions().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                i3 = it.next().a() ? i3 + 1 : i3;
            }
            for (com.nexstreaming.kinemaster.layer.handwriting.a aVar : getDrawingActions()) {
                if (aVar.a()) {
                    i3--;
                }
                if (i3 < 1) {
                    aVar.a(rectF);
                    rectF2.union(rectF);
                }
            }
            if (!isPivotMovable) {
                rectF2.union(this.pivotX, this.pivotY);
            }
            this.boundsLeft = (int) Math.floor(rectF2.left);
            this.boundsTop = (int) Math.floor(rectF2.top);
            this.boundsRight = (int) Math.ceil(rectF2.right);
            this.boundsBottom = (int) Math.ceil(rectF2.bottom);
            this.boundsLeft = Math.max(0, this.boundsLeft);
            this.boundsTop = Math.max(0, this.boundsTop);
            this.boundsRight = Math.min(1280, this.boundsRight);
            this.boundsBottom = Math.min(720, this.boundsBottom);
            if (this.boundsRight - this.boundsLeft < 1 || this.boundsBottom - this.boundsTop < 1) {
                this.boundsLeft = 615;
                this.boundsTop = 335;
                this.boundsRight = this.boundsLeft + 50;
                this.boundsBottom = this.boundsTop + 50;
            }
            this.f3471a = this.boundsRight - this.boundsLeft;
            this.b = this.boundsBottom - this.boundsTop;
            if (isPivotMovable) {
                if (this.f3471a < 1 || this.b < 1) {
                    i = 640;
                    i2 = 360;
                } else {
                    i = (this.f3471a / 2) + this.boundsLeft;
                    i2 = this.boundsTop + (this.b / 2);
                }
                adjustForPivotChange(i - this.pivotX, i2 - this.pivotY);
                this.pivotX = i;
                this.pivotY = i2;
            }
            this.c = true;
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        if (rect != null) {
            a();
            rect.set(this.boundsLeft, this.boundsTop, this.boundsRight, this.boundsBottom);
            rect.offset(-this.pivotX, -this.pivotY);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f, float f2, int i) {
        return f >= ((float) (this.boundsLeft + (-640))) && f <= ((float) (this.boundsRight + (-640))) && f2 >= ((float) (this.boundsTop + (-360))) && f2 <= ((float) (this.boundsBottom + (-360)));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.HandwritingLayer.Builder builder = new KMProto.KMProject.HandwritingLayer.Builder();
        builder.drawing_actions = new ArrayList(this.drawingActionList.size());
        Iterator<com.nexstreaming.kinemaster.layer.handwriting.a> it = this.drawingActionList.iterator();
        while (it.hasNext()) {
            builder.drawing_actions.add(it.next().b());
        }
        builder.layer_common = getLayerCommonProtoBuf();
        builder.pivot_x = Integer.valueOf(this.pivotX);
        builder.pivot_y = Integer.valueOf(this.pivotY);
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_HANDWRITING).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).handwriting_layer(builder.build()).build();
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        HandwritingLayer handwritingLayer = new HandwritingLayer();
        handwritingLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        Iterator<KMProto.KMProject.DrawingAction> it = timelineItem.handwriting_layer.drawing_actions.iterator();
        while (it.hasNext()) {
            handwritingLayer.drawingActionList.add(com.nexstreaming.kinemaster.layer.handwriting.a.b(it.next()));
        }
        fromProtoBuf(timelineItem.handwriting_layer.layer_common, handwritingLayer);
        handwritingLayer.c = false;
        if (timelineItem.handwriting_layer.pivot_x != null && timelineItem.handwriting_layer.pivot_y != null) {
            handwritingLayer.pivotX = timelineItem.handwriting_layer.pivot_x.intValue();
            handwritingLayer.pivotY = timelineItem.handwriting_layer.pivot_y.intValue();
        }
        return handwritingLayer;
    }

    public void addStroke(Stroke stroke) {
        this.drawingActionList.add(new Stroke(stroke));
        this.c = false;
    }

    public void addDrawingAction(com.nexstreaming.kinemaster.layer.handwriting.a aVar) {
        this.drawingActionList.add(aVar);
        this.c = false;
    }

    public com.nexstreaming.kinemaster.layer.handwriting.a removeLastDrawingAction() {
        if (this.drawingActionList.size() <= 0) {
            return null;
        }
        this.c = false;
        return this.drawingActionList.remove(this.drawingActionList.size() - 1);
    }

    public void addEraseAll() {
        if (this.drawingActionList.isEmpty() || !(this.drawingActionList.get(this.drawingActionList.size() - 1) instanceof com.nexstreaming.kinemaster.layer.handwriting.b)) {
            this.drawingActionList.add(new com.nexstreaming.kinemaster.layer.handwriting.b());
            this.c = false;
        }
    }

    public List<com.nexstreaming.kinemaster.layer.handwriting.a> getDrawingActions() {
        return this.unmodifiableDrawingActionList;
    }
}
