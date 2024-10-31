package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.ColorMatrix;
import android.graphics.Rect;
import android.graphics.RectF;
import com.nexstreaming.app.general.iab.PurchaseType;
import com.nexstreaming.app.general.nexasset.assetpackage.h;
import com.nexstreaming.app.general.nexasset.assetpackage.r;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.C2052v;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class AssetLayer extends NexLayerItem implements NexTimelineItem.l {
    private String assetItemID;
    private HashMap<String, String> effectOptions;
    private AssetLayerType layerType;
    private transient int n;
    private transient int o;
    private transient int p;
    private transient boolean q;
    private transient ColorMatrix r;
    private transient com.nexstreaming.app.general.nexasset.overlay.a s;
    private transient com.nexstreaming.app.general.nexasset.overlay.b t;
    private boolean colorizeEnabled = false;
    private int colorizeColor = -8947849;
    private boolean isSyncXYScale = true;
    private int mAssetIdx = 0;
    private int[] effect_id_ = {-1, -1};

    /* loaded from: classes.dex */
    public enum AssetLayerType {
        EFFECT_LAYER(KMProto.KMProject.AssetLayer.AssetLayerType.EFFECT_LAYER),
        OVERLAY_LAYER(KMProto.KMProject.AssetLayer.AssetLayerType.OVERLAY_LAYER);

        final KMProto.KMProject.AssetLayer.AssetLayerType proto;

        AssetLayerType(KMProto.KMProject.AssetLayer.AssetLayerType assetLayerType) {
            this.proto = assetLayerType;
        }

        public static AssetLayerType fromProtoBuf(KMProto.KMProject.AssetLayer.AssetLayerType assetLayerType) {
            for (AssetLayerType assetLayerType2 : values()) {
                if (assetLayerType2.proto == assetLayerType) {
                    return assetLayerType2;
                }
            }
            return null;
        }

        public KMProto.KMProject.AssetLayer.AssetLayerType asProtoBuf() {
            return this.proto;
        }
    }

    private void a(StringBuilder sb, Map<String, String> map) {
        try {
            boolean z = true;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
            }
        } catch (UnsupportedEncodingException e2) {
            throw new IllegalStateException(e2);
        }
    }

    private void f() {
        if (this.q) {
            return;
        }
        com.nexstreaming.app.general.nexasset.overlay.b bVar = null;
        try {
            bVar = getOverlayAsset();
        } catch (IOException | XmlPullParserException unused) {
        }
        if (bVar == null) {
            this.n = 200;
            this.o = 200;
            this.p = 0;
        } else {
            this.n = bVar.b();
            this.o = bVar.a();
            this.p = bVar.c();
            if (this.n < 1 || this.o < 1) {
                this.n = 200;
                this.o = 200;
            }
        }
        this.q = true;
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        AssetLayer assetLayer = new AssetLayer();
        assetLayer.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        assetLayer.layerType = AssetLayerType.fromProtoBuf(timelineItem.asset_layer.asset_layer_type);
        assetLayer.effectOptions = c.d.b.g.a.a(timelineItem.asset_layer.effect_options);
        KMProto.KMProject.AssetLayer assetLayer2 = timelineItem.asset_layer;
        assetLayer.assetItemID = assetLayer2.asset_item_id;
        Boolean bool = assetLayer2.sync_xy_scale;
        assetLayer.isSyncXYScale = bool == null ? true : bool.booleanValue();
        if (assetLayer.isSyncXYScale && assetLayer.layerType == AssetLayerType.EFFECT_LAYER) {
            assetLayer.isSyncXYScale = false;
        }
        NexLayerItem.fromProtoBuf(timelineItem.asset_layer.layer_common, assetLayer);
        Integer num = timelineItem.track_id;
        assetLayer.track_id = num != null ? num.intValue() : 0;
        return assetLayer;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Collection<ProjectDependency> collection) {
        String str = this.assetItemID;
        if (str == null || str.length() <= 0 || this.assetItemID.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
            return;
        }
        collection.add(ProjectDependency.b(this.assetItemID));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.AssetLayer.Builder builder = new KMProto.KMProject.AssetLayer.Builder();
        builder.asset_item_id = this.assetItemID;
        builder.asset_layer_type = this.layerType.asProtoBuf();
        builder.effect_options = c.d.b.g.a.a(this.effectOptions);
        builder.layer_common = getLayerCommonProtoBuf();
        builder.sync_xy_scale = Boolean.valueOf(this.isSyncXYScale);
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_ASSET).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).asset_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean checkResourceState(Context context) {
        return context == null || h.a(context).a(getEffectItemID()) != null;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return this.layerType == AssetLayerType.EFFECT_LAYER ? R.color.layer_effect : R.color.layer_sticker;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public int getColorOption(int i) {
        if (i == R.id.opt_colorize_color) {
            return getColorizeColor();
        }
        return super.getColorOption(i);
    }

    public int getColorizeColor() {
        return this.colorizeColor;
    }

    public int getDefaultDuration() {
        f();
        return this.p;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        if (this.layerType == AssetLayerType.EFFECT_LAYER) {
            return context.getResources().getString(R.string.layer_menu_effect);
        }
        return context.getResources().getString(R.string.layer_menu_overlay);
    }

    public String getEffectAssetID() {
        String str = this.assetItemID;
        if (str == null) {
            return null;
        }
        return str.substring(0, str.indexOf(47));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public int getEffectAssetIdx() {
        return this.mAssetIdx;
    }

    public int getEffectDuration() {
        throw new UnsupportedOperationException();
    }

    public String getEffectID() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public String getEffectItemID() {
        String str = this.assetItemID;
        if (str == null) {
            return null;
        }
        return str.substring(str.indexOf(47) + 1);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public Map<String, String> getEffectOptions() {
        if (this.effectOptions == null) {
            this.effectOptions = new HashMap<>();
        }
        return this.effectOptions;
    }

    public String getEncodedEffectOptions() {
        StringBuilder sb = new StringBuilder();
        a(sb, getEffectOptions());
        return sb.toString();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        f();
        return this.o;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return this.layerType == AssetLayerType.EFFECT_LAYER ? R.drawable.layericon_effect : R.drawable.layericon_sticker;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        throw new UnsupportedOperationException();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        String a2;
        if (this.layerType == AssetLayerType.EFFECT_LAYER) {
            r a3 = h.a(context).a(getEffectItemID());
            if (a3 != null) {
                String a4 = J.a(context, a3.getLabel());
                if (a4 != null && a4.length() > 0) {
                    return a4;
                }
                String a5 = J.a(context, a3.getAssetPackage().getAssetName());
                if (a5 != null && a5.length() > 0) {
                    return a5;
                }
            }
            return context.getResources().getString(R.string.layer_menu_effect);
        }
        r a6 = h.a(context).a(getEffectItemID());
        return (a6 == null || (a2 = J.a(context, a6.getAssetPackage().getAssetName())) == null || a2.length() <= 0) ? context.getResources().getString(R.string.layer_menu_overlay) : a2;
    }

    public AssetLayerType getLayerType() {
        return this.layerType;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return C2052v.class;
    }

    public com.nexstreaming.app.general.nexasset.overlay.b getOverlayAsset() throws IOException, XmlPullParserException {
        if (this.t == null) {
            this.t = com.nexstreaming.app.general.nexasset.overlay.d.a(getEffectItemID());
        }
        return this.t;
    }

    public r getOverlayItem() {
        String effectItemID = getEffectItemID();
        if (effectItemID == null) {
            return null;
        }
        return h.e().a(effectItemID);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        if (i == R.id.opt_colorize_color) {
            return isColorizeEnabled();
        }
        return super.getSwitchOption(i);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        AssetLayerType assetLayerType = this.layerType;
        return assetLayerType == AssetLayerType.OVERLAY_LAYER ? R.layout.timeline_item_secondary_sticker : assetLayerType == AssetLayerType.EFFECT_LAYER ? R.layout.timeline_item_secondary_effectlayer : super.getTimelineViewLayoutResource();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getTrackAffinity() {
        AssetLayerType assetLayerType = this.layerType;
        return assetLayerType == AssetLayerType.EFFECT_LAYER ? R.drawable.track_header_effect_icon : assetLayerType == AssetLayerType.OVERLAY_LAYER ? R.drawable.track_header_overlay_icon : super.getTrackAffinity();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int[] getTrackOptionItems() {
        return new int[]{R.id.opt_alpha_adj};
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        f();
        return this.n;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean hasDependencyFromAsset(String str) {
        return getEffectAssetID() != null && getEffectAssetID().equals(str);
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return false;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isAvailableAsset(PurchaseType purchaseType, Context context) {
        if (h.e() != null && h.e().a(getEffectItemID()) != null && purchaseType != null) {
            com.nexstreaming.app.general.nexasset.assetpackage.b assetPackage = h.e().a(getEffectItemID()).getAssetPackage();
            if (assetPackage.getPriceType() == null || assetPackage.getPriceType().equalsIgnoreCase("Free")) {
                return true;
            }
            if (assetPackage.getPriceType().equalsIgnoreCase("Premium")) {
                return purchaseType.isActivePurchaseOrPromocode();
            }
            if (assetPackage.getPriceType().equalsIgnoreCase("Paid")) {
                return c.d.b.m.b.a(assetPackage, context);
            }
            return false;
        }
        return super.isAvailableAsset(purchaseType, context);
    }

    public boolean isColorizeEnabled() {
        return this.colorizeEnabled;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_asset_settings /* 2131363087 */:
                HashMap<String, String> hashMap = this.effectOptions;
                return hashMap != null && hashMap.size() > 0;
            case R.id.opt_blending /* 2131363096 */:
                return getBlendMode() != BlendMode.NONE;
            case R.id.opt_layer_shape /* 2131363127 */:
                return getCropShape() != 0;
            case R.id.opt_rotate /* 2131363137 */:
                return getRotation() != 0 || getFlipH() || getFlipV();
            default:
                return super.isOptionApplied(i);
        }
    }

    public boolean isSyncXYScale() {
        return this.isSyncXYScale;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f2, float f3, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f2 >= ((float) i2) && f2 <= ((float) width) && f3 >= ((float) i3) && f3 <= ((float) (getHeight() + i3));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean needRendererReawakeOnEditResize() {
        com.nexstreaming.app.general.nexasset.overlay.a aVar = this.s;
        return aVar != null && aVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar, boolean z) {
        com.nexstreaming.app.general.nexasset.overlay.a aVar = this.s;
        if (aVar == null) {
            return;
        }
        aVar.a(layerRenderer, bVar, getAbsStartTime(), getAbsEndTime(), getBlendMode().ordinal());
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        com.nexstreaming.app.general.nexasset.overlay.a aVar = this.s;
        if (aVar != null) {
            aVar.a(layerRenderer);
            this.s = null;
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        try {
            com.nexstreaming.app.general.nexasset.overlay.b overlayAsset = getOverlayAsset();
            if (overlayAsset != null) {
                Rect rect = new Rect();
                getBounds(rect);
                this.s = overlayAsset.a(layerRenderer, getScaleRange(), new RectF(rect), getEncodedEffectOptions(), getEffectOptions());
            }
        } catch (IOException | XmlPullParserException unused) {
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean onRenderRefresh(LayerRenderer layerRenderer) {
        com.nexstreaming.app.general.nexasset.overlay.a aVar = this.s;
        if (aVar != null) {
            return aVar.a(layerRenderer, getEncodedEffectOptions());
        }
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_colorize_color) {
            setColorizeColor(i2);
        } else {
            super.setColorOption(i, i2);
            throw null;
        }
    }

    public void setColorizeColor(int i) {
        this.colorizeColor = i;
        this.r = null;
    }

    public void setColorizeEnabled(boolean z) {
        this.colorizeEnabled = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public void setEffectItem(r rVar) {
        if (rVar == null) {
            this.assetItemID = null;
        } else {
            if (rVar.getAssetPackage() != null) {
                this.mAssetIdx = rVar.getAssetPackage().getAssetIdx();
            }
            this.assetItemID = this.mAssetIdx + "/" + rVar.getId();
        }
        this.t = null;
        this.q = false;
        f();
    }

    public void setLayerType(AssetLayerType assetLayerType) {
        this.layerType = assetLayerType;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_colorize_color) {
            setColorizeEnabled(z);
            return null;
        }
        super.setSwitchOption(i, z, context);
        throw null;
    }

    public void setSyncXYScale(boolean z) {
        this.isSyncXYScale = z;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return false;
    }
}
