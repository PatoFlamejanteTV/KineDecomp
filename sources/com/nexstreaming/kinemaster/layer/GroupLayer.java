package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.Pa;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class GroupLayer extends NexLayerItem {
    private List<NexSecondaryTimelineItem> secondaryTimelineItems = new ArrayList();

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        GroupLayer groupLayer = new GroupLayer();
        groupLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        Iterator<KMProto.KMProject.TimelineItem> it = timelineItem.group_layer.child_items.iterator();
        while (it.hasNext()) {
            NexSecondaryTimelineItem secondaryItemFromProtoBuf = NexTimeline.secondaryItemFromProtoBuf(it.next());
            if (secondaryItemFromProtoBuf != null) {
                groupLayer.secondaryTimelineItems.add(secondaryItemFromProtoBuf);
            }
        }
        NexLayerItem.fromProtoBuf(timelineItem.group_layer.layer_common, groupLayer);
        Integer num = timelineItem.track_id;
        groupLayer.track_id = num != null ? num.intValue() : 0;
        return groupLayer;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.GroupLayer.Builder builder = new KMProto.KMProject.GroupLayer.Builder();
        builder.child_items = new ArrayList();
        Iterator<NexSecondaryTimelineItem> it = this.secondaryTimelineItems.iterator();
        while (it.hasNext()) {
            KMProto.KMProject.TimelineItem asProtoBuf = it.next().asProtoBuf();
            if (asProtoBuf != null) {
                builder.child_items.add(asProtoBuf);
            }
        }
        builder.layer_common = getLayerCommonProtoBuf();
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_GROUP).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).group_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexSecondaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        super.bindView(view, interfaceC2028i);
        ImageView imageView = (ImageView) view.findViewById(R.id.clip_type_icon);
        ClipThumbView clipThumbView = (ClipThumbView) view.findViewById(R.id.thumbnail_view);
        TextView textView = (TextView) view.findViewById(R.id.clip_label);
        imageView.setImageResource(R.drawable.opt_icon_clip_group_normal);
        if (!checkResourceState(view.getContext())) {
            clipThumbView.a(false);
        } else {
            clipThumbView.a((String) null);
        }
        String layerName = getLayerName();
        if (TextUtils.isEmpty(layerName)) {
            layerName = getLabelText(view.getContext());
        }
        textView.setText(layerName);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_group;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        Rect rect2 = new Rect();
        Matrix matrix = new Matrix();
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.secondaryTimelineItems) {
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                NexLayerItem nexLayerItem = (NexLayerItem) nexSecondaryTimelineItem;
                for (NexLayerItem.b bVar : nexLayerItem.getKeyFrames()) {
                    Rect rect3 = new Rect();
                    nexLayerItem.getBounds(rect3);
                    float f2 = rect3.left;
                    float f3 = bVar.f20231b;
                    rect3.set((int) (f2 * f3), (int) (rect3.top * f3), (int) (rect3.right * f3), (int) (rect3.bottom * f3));
                    rect3.offset((int) bVar.f20232c, (int) bVar.f20233d);
                    if (bVar.f20234e != 0.0f) {
                        matrix.reset();
                        matrix.postRotate(bVar.f20234e, bVar.f20232c, bVar.f20233d);
                        int i = rect3.left;
                        int i2 = rect3.top;
                        int i3 = rect3.right;
                        int i4 = rect3.bottom;
                        float[] fArr = {i, i2, i3, i2, i, i4, i3, i4};
                        RectF rectF = new RectF(rect3);
                        matrix.mapRect(rectF);
                        rect2.union((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    } else {
                        rect2.union(rect3);
                    }
                }
            }
        }
        rect.set(rect2);
    }

    public List<? extends NexSecondaryTimelineItem> getChildList() {
        return this.secondaryTimelineItems;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        String layerName = getLayerName();
        return TextUtils.isEmpty(layerName) ? getLabelText(context) : layerName;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.opt_icon_clip_group_normal;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return context.getResources().getString(R.string.layer_menu_group);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return Pa.class;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_item_group_layer;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getTrackAffinity() {
        return R.drawable.track_header_layer_icon;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f2, float f3, int i) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar, boolean z) {
        layerRenderer.b(layerRenderer.f() - getStartTime());
        int f2 = layerRenderer.f();
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.secondaryTimelineItems) {
            if ((nexSecondaryTimelineItem instanceof NexLayerItem) && f2 >= nexSecondaryTimelineItem.getStartTime() && f2 < nexSecondaryTimelineItem.getEndTime()) {
                ((NexLayerItem) nexSecondaryTimelineItem).renderLayer(layerRenderer, z);
            }
        }
        layerRenderer.b(f2);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.secondaryTimelineItems) {
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                layerRenderer.x();
                NexLayerItem nexLayerItem = (NexLayerItem) nexSecondaryTimelineItem;
                nexLayerItem.onRenderPreAsleep(layerRenderer);
                nexLayerItem.onRenderAsleep(layerRenderer);
                nexLayerItem.clearExpressionState();
                layerRenderer.w();
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.secondaryTimelineItems) {
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                layerRenderer.x();
                NexLayerItem nexLayerItem = (NexLayerItem) nexSecondaryTimelineItem;
                nexLayerItem.onRenderPreAwake(layerRenderer);
                nexLayerItem.onRenderAwake(layerRenderer);
                layerRenderer.w();
            }
        }
    }

    public void setChildItems(List<NexSecondaryTimelineItem> list) {
        this.secondaryTimelineItems.addAll(list);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }
}
