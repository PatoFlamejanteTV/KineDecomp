package com.nextreaming.nexeditorui;

import android.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.TransitionIconView;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.TransitionRangeView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexTimelineItem;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class NexTransitionItem extends NexPrimaryTimelineItem implements NexTimelineItem.l {

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f24137d = {R.attr.state_selected, R.attr.state_enabled};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f24138e = {R.attr.state_enabled};

    /* renamed from: f, reason: collision with root package name */
    private static MaskFilter f24139f = new EmbossMaskFilter(new float[]{3.0f, -3.0f, 5.0f}, 0.6f, 15.0f, 3.0f);
    private static final long serialVersionUID = 2;

    /* renamed from: g, reason: collision with root package name */
    private transient Bitmap f24140g;
    private HashMap<String, String> m_effectOptions;
    private String m_transitionEffectID;
    private int mAssetIdx = 0;
    private String m_captureFilename = null;
    private int m_transitionDuration = SemanticAnnotations.SemanticType.ST_SOFTWARE_ID_VALUE;
    private int m_transitionEngineDuration = SemanticAnnotations.SemanticType.ST_SOFTWARE_ID_VALUE;
    private int m_transitionOverlapPercent = 100;
    private int m_transitionOffsetPercent = 100;
    private boolean m_disabled = false;
    private int m_durationLimit = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private boolean m_allowOverlap = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NexTransitionItem() {
        this.m_transitionEffectID = null;
        this.m_transitionEffectID = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        updateOffsetOverlap();
    }

    private boolean a() {
        String str = this.m_transitionEffectID;
        return str == null || str.length() <= 0 || this.m_transitionEffectID.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE);
    }

    public static NexTransitionItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        NexTransitionItem nexTransitionItem = new NexTransitionItem();
        nexTransitionItem.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        KMProto.KMProject.Transition transition = timelineItem.transition;
        nexTransitionItem.m_captureFilename = transition.captureFilename;
        nexTransitionItem.m_transitionEffectID = transition.transition_effect_id;
        nexTransitionItem.m_transitionDuration = transition.transition_duration.intValue();
        nexTransitionItem.m_transitionEngineDuration = transition.transition_engine_duration.intValue();
        nexTransitionItem.m_transitionOffsetPercent = transition.transition_offset_percent.intValue();
        nexTransitionItem.m_transitionOverlapPercent = transition.transition_overlap_percent.intValue();
        nexTransitionItem.m_disabled = transition.disabled.booleanValue();
        nexTransitionItem.m_effectOptions = c.d.b.g.a.a(transition.effect_options);
        nexTransitionItem.m_durationLimit = transition.duration_limit.intValue();
        nexTransitionItem.m_allowOverlap = transition.allow_overlap.booleanValue();
        return nexTransitionItem;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Collection<ProjectDependency> collection) {
        int indexOf;
        com.nexstreaming.app.general.nexasset.assetpackage.r a2;
        if (!a()) {
            collection.add(ProjectDependency.b(this.m_transitionEffectID));
        }
        for (Map.Entry<String, String> entry : getEffectOptions().entrySet()) {
            String value = entry.getValue();
            if (entry.getKey().startsWith("text:") && (indexOf = value.indexOf(27)) > 0) {
                String substring = value.substring(0, indexOf);
                if (!substring.equals("null") && (a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(substring)) != null && a2.getAssetPackage() != null) {
                    collection.add(ProjectDependency.c(a2.getAssetPackage().getAssetIdx() + "/" + substring));
                }
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.Transition.Builder builder = new KMProto.KMProject.Transition.Builder();
        builder.captureFilename = this.m_captureFilename;
        builder.transition_effect_id = this.m_transitionEffectID;
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.TRANSITION).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).transition(builder.transition_duration(Integer.valueOf(this.m_transitionDuration)).transition_engine_duration(Integer.valueOf(this.m_transitionEngineDuration)).transition_offset_percent(Integer.valueOf(this.m_transitionOffsetPercent)).transition_overlap_percent(Integer.valueOf(this.m_transitionOverlapPercent)).disabled(Boolean.valueOf(this.m_disabled)).minimum_duration(100).maximum_duration(30000).effect_options(c.d.b.g.a.a(this.m_effectOptions)).duration_limit(Integer.valueOf(this.m_durationLimit)).allow_overlap(Boolean.valueOf(this.m_allowOverlap)).build()).build();
    }

    public boolean availableTransition() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline == null) {
            return false;
        }
        if (!a() || (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this)) < 1 || indexOfPrimaryItem >= timeline.getPrimaryItemCount() - 1) {
            return true;
        }
        NexPrimaryTimelineItem primaryItem = timeline.getPrimaryItem(indexOfPrimaryItem - 1);
        NexPrimaryTimelineItem primaryItem2 = timeline.getPrimaryItem(indexOfPrimaryItem + 1);
        if (primaryItem == null || !(primaryItem instanceof NexVideoClipItem) || primaryItem2 == null || !(primaryItem2 instanceof NexVideoClipItem)) {
            return false;
        }
        NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
        if (nexVideoClipItem.isVideo() && primaryItem.getRepresentedDuration() < 100) {
            return false;
        }
        if (nexVideoClipItem.isImage() && primaryItem.getRepresentedDuration() < 780) {
            return false;
        }
        NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) primaryItem2;
        if (!nexVideoClipItem2.isVideo() || primaryItem2.getRepresentedDuration() >= 100) {
            return !nexVideoClipItem2.isImage() || primaryItem2.getRepresentedDuration() >= 780;
        }
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        ((TransitionRangeView) view.findViewById(com.nexstreaming.app.kinemasterfree.R.id.range)).setTransitionItem(this);
        TransitionIconView transitionIconView = (TransitionIconView) view.findViewById(com.nexstreaming.app.kinemasterfree.R.id.icon);
        transitionIconView.setTransitionItem(this);
        transitionIconView.setSelected(interfaceC2028i.a());
        if (interfaceC2028i.b() == com.nexstreaming.app.kinemasterfree.R.id.editmode_multi_select) {
            transitionIconView.setVisibility(8);
        } else {
            transitionIconView.setVisibility(0);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public boolean checkAndDeleteFontOfEffect() {
        Map<String, String> effectOptions = getEffectOptions();
        for (Map.Entry<String, String> entry : effectOptions.entrySet()) {
            if (entry.getKey().startsWith("text:") && entry.getValue().contains("\u001b")) {
                String[] split = entry.getValue().split("\u001b");
                String str = split[0];
                String str2 = split.length > 1 ? split[1] : "";
                if (str != null && !str.equals("null") && com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(str) == null) {
                    effectOptions.put(entry.getKey(), "null\u001b" + str2);
                    return true;
                }
            }
        }
        return false;
    }

    public void clearTransitionEffect() {
        this.m_transitionEffectID = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        ensureTransitionFits();
        this.f24140g = null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f2, NexTimelineItem.i iVar, boolean z3, float f3, int i, int i2, List<ob> list, NexTimelineItem.r rVar) {
        throw new IllegalStateException();
    }

    public boolean ensureTransitionFits() {
        int i = this.m_transitionEngineDuration;
        int i2 = this.m_transitionDuration;
        if (!isSet()) {
            this.m_disabled = true;
        }
        updateDurationLimit();
        if (this.m_transitionDuration < 100) {
            this.m_transitionDuration = 100;
        }
        if (this.m_transitionDuration > 30000) {
            this.m_transitionDuration = 30000;
        }
        int i3 = this.m_transitionDuration;
        int i4 = this.m_durationLimit;
        if (i3 > i4) {
            this.m_transitionDuration = i4;
        }
        if (this.m_transitionDuration < 100) {
            this.m_disabled = true;
        }
        if (!isSet()) {
            this.m_transitionEngineDuration = 0;
        } else {
            this.m_transitionEngineDuration = this.m_transitionDuration;
        }
        return (i == this.m_transitionEngineDuration && i2 == this.m_transitionDuration) ? false : true;
    }

    public boolean getAllowOverlap() {
        return this.m_allowOverlap;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public String getCaptureFilename() {
        return this.m_captureFilename;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        if (isSet()) {
            return this.m_transitionDuration;
        }
        return 0;
    }

    public int getDurationLimit() {
        updateDurationLimit();
        return this.m_durationLimit;
    }

    public String getEffectAssetID() {
        if (a()) {
            return NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        }
        String str = this.m_transitionEffectID;
        return str.substring(0, str.indexOf(47));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public int getEffectAssetIdx() {
        return this.mAssetIdx;
    }

    public int getEffectDuration() {
        return getDuration();
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public String getEffectID() {
        return a() ? NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE : this.m_transitionEffectID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public String getEffectItemID() {
        if (a()) {
            return NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        }
        String str = this.m_transitionEffectID;
        return str.substring(str.indexOf(47) + 1);
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem.l
    public Map<String, String> getEffectOptions() {
        if (this.m_effectOptions == null) {
            this.m_effectOptions = new HashMap<>();
        }
        return this.m_effectOptions;
    }

    @Deprecated
    public boolean getEnabled() {
        return !isSet();
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getEndOverlap() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getEndThumbnail(int i) {
        return null;
    }

    public int getEngineDuration() {
        if (isSet()) {
            return this.m_transitionEngineDuration;
        }
        return 0;
    }

    public NexVideoClipItem getLeftClip() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline != null && (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this)) >= 0) {
            return (NexVideoClipItem) timeline.getPrimaryItem(indexOfPrimaryItem - 1);
        }
        return null;
    }

    public int getMaximumDuration() {
        updateDurationLimit();
        int i = 0;
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = ((29900 * i2) / 9) + 100;
            int i4 = i3 - (i3 % SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE);
            int i5 = i4 >= 100 ? i4 : 100;
            if (i5 > 30000) {
                i5 = 30000;
            }
            if (i5 > getDurationLimit()) {
                break;
            }
            if (i5 <= getDurationLimit()) {
                i = i5;
            }
        }
        return i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return com.nexstreaming.kinemaster.ui.assetbrowser.n.class;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getPixelWidth(float f2, float f3) {
        int representedDuration = (int) ((getRepresentedDuration() * f2) / 1000.0f);
        int max = (int) ((Math.max(getRepresentedDuration(), 750) * f2) / 1000.0f);
        float f4 = representedDuration;
        float f5 = 35.0f * f3;
        if (f4 >= f5) {
            return representedDuration;
        }
        float max2 = Math.max(representedDuration, max);
        float f6 = 15.0f * f3;
        return max2 >= f6 ? (int) f5 : Math.max((int) (f5 - ((f6 - f4) * 2.0f)), (int) (f3 * 1.0f));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        if (isSet()) {
            return getDuration();
        }
        return 0;
    }

    public NexVideoClipItem getRightClip() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline != null && (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this)) >= 0) {
            return (NexVideoClipItem) timeline.getPrimaryItem(indexOfPrimaryItem + 1);
        }
        return null;
    }

    public int getSideItemMinDuration() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline != null && (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this)) >= 1 && indexOfPrimaryItem < timeline.getPrimaryItemCount() - 1) {
            NexPrimaryTimelineItem primaryItem = timeline.getPrimaryItem(indexOfPrimaryItem - 1);
            NexPrimaryTimelineItem primaryItem2 = timeline.getPrimaryItem(indexOfPrimaryItem + 1);
            if ((primaryItem instanceof NexVideoClipItem) && (primaryItem2 instanceof NexVideoClipItem)) {
                return Math.min(((NexVideoClipItem) primaryItem).getDuration(), ((NexVideoClipItem) primaryItem2).getDuration());
            }
        }
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getStartOverlap() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getStartThumbnail(int i) {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getThumbnail(Context context) {
        return null;
    }

    public int[] getTimeOptions() {
        return getTimeOptions(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return com.nexstreaming.app.kinemasterfree.R.layout.timeline_item_transition;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public NexTransitionItem getTransition() {
        return this;
    }

    public String getTransitionEffectID() {
        return a() ? NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE : this.m_transitionEffectID;
    }

    public int getTransitionOffset() {
        if (isSet()) {
            return (this.m_transitionDuration * this.m_transitionOffsetPercent) / 100;
        }
        return 0;
    }

    public int getTransitionOffsetPercent() {
        return this.m_transitionOffsetPercent;
    }

    public int getTransitionOverlap() {
        if (isSet()) {
            return (this.m_transitionDuration * this.m_transitionOverlapPercent) / 100;
        }
        return 0;
    }

    public int getTransitionOverlapPercent() {
        return this.m_transitionOverlapPercent;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean hasDependencyFromAsset(String str) {
        return getEffectAssetID() != null && getEffectAssetID().equals(str);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.InterfaceC1732b
    public boolean isDraggable() {
        return true;
    }

    public boolean isSet() {
        return (a() || this.m_disabled) ? false : true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.i iVar, NexTimelineItem.w wVar, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.i iVar, NexTimelineItem.w wVar) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.i iVar, Rect rect) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onDown(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0566 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0567  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x008f  */
    /* JADX WARN: Type inference failed for: r0v14, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v0, types: [android.text.TextPaint, android.graphics.Paint] */
    /* JADX WARN: Type inference failed for: r14v0, types: [android.graphics.Canvas] */
    /* JADX WARN: Type inference failed for: r1v25, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r2v3, types: [android.graphics.drawable.Drawable] */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(com.nexstreaming.kinemaster.ui.projectedit.C1916ib r41) {
        /*
            Method dump skipped, instructions count: 1582
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexTransitionItem.onDraw(com.nexstreaming.kinemaster.ui.projectedit.ib):void");
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void onDuplicated(int i) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onLongPress(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.p pVar) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void removeRequiredOverlaysFromDeleteSet(Set<String> set) {
        String str = this.m_captureFilename;
        if (str != null) {
            set.remove(str);
        }
        HashMap<String, String> hashMap = this.m_effectOptions;
        if (hashMap == null || hashMap.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : this.m_effectOptions.entrySet()) {
            if (entry.getKey().startsWith("overlay:")) {
                String value = entry.getValue();
                int lastIndexOf = value.lastIndexOf(32);
                if (lastIndexOf >= 0) {
                    value = value.substring(lastIndexOf + 1);
                }
                set.remove(value);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void setCaptureFilename(String str) {
        this.m_captureFilename = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        this.m_transitionDuration = i;
        ensureTransitionFits();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public void setEffectItem(com.nexstreaming.app.general.nexasset.assetpackage.r rVar) {
        if (rVar == null) {
            setTransitionEffectID(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE);
        } else {
            if (rVar.getAssetPackage() != null) {
                this.mAssetIdx = rVar.getAssetPackage().getAssetIdx();
            }
            setTransitionEffectID(this.mAssetIdx + "/" + rVar.getId());
        }
        this.f24140g = null;
    }

    @Deprecated
    public void setEnabled(boolean z) {
        throw new UnsupportedOperationException();
    }

    public void setTransitionEffectID(String str) {
        String str2 = this.m_transitionEffectID;
        if (str2 == null || !str2.equals(str)) {
            this.m_transitionEffectID = str;
            this.m_disabled = false;
            updateOffsetOverlap();
            ensureTransitionFits();
        }
    }

    public void updateDurationLimit() {
        NexTimeline timeline = getTimeline();
        if (timeline == null) {
            return;
        }
        int indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this);
        int i = 0;
        boolean z = true;
        if (indexOfPrimaryItem >= 1 && indexOfPrimaryItem < timeline.getPrimaryItemCount() - 1) {
            NexPrimaryTimelineItem primaryItem = timeline.getPrimaryItem(indexOfPrimaryItem - 1);
            NexPrimaryTimelineItem primaryItem2 = timeline.getPrimaryItem(indexOfPrimaryItem + 1);
            if (primaryItem != null && (primaryItem instanceof NexVideoClipItem) && primaryItem2 != null && (primaryItem2 instanceof NexVideoClipItem)) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) primaryItem2;
                int duration = (((((nexVideoClipItem.getDuration() - nexVideoClipItem.getTrimTimeStart()) - nexVideoClipItem.getTrimTimeEnd()) * 100) / nexVideoClipItem.getPlaybackSpeed()) - nexVideoClipItem.getStartOverlap()) - 100;
                int duration2 = (((((nexVideoClipItem2.getDuration() - nexVideoClipItem2.getTrimTimeStart()) - nexVideoClipItem2.getTrimTimeEnd()) * 100) / nexVideoClipItem2.getPlaybackSpeed()) - nexVideoClipItem2.getEndOverlap()) - 100;
                int i2 = this.m_transitionOffsetPercent;
                int i3 = (int) ((duration * 100.0f) / i2);
                if (i2 != 100) {
                    i2 = 100 - i2;
                }
                int min = Math.min(i3, (int) ((duration2 * 100.0f) / i2));
                if (((!nexVideoClipItem.isImage() && nexVideoClipItem.getHeight() >= 1000) || (!nexVideoClipItem2.isImage() && nexVideoClipItem2.getHeight() >= 1000)) && min > NexEditorDeviceProfile.getDeviceProfile().getFullHDMaxTransitionTime()) {
                    min = NexEditorDeviceProfile.getDeviceProfile().getFullHDMaxTransitionTime();
                }
                if (!nexVideoClipItem.isImage() && !nexVideoClipItem2.isImage() && !NexEditorDeviceProfile.getDeviceProfile().allowOverlappingVideo()) {
                    z = false;
                }
                this.m_allowOverlap = z;
                if (this.m_allowOverlap || this.m_transitionOverlapPercent <= 0) {
                    i = min;
                }
                this.m_durationLimit = i;
                int i4 = this.m_transitionOverlapPercent;
            }
        }
        i = 30000;
        this.m_durationLimit = i;
        int i42 = this.m_transitionOverlapPercent;
    }

    public void updateOffsetOverlap() {
        if (this.m_transitionEffectID != null) {
            com.nexstreaming.app.general.nexasset.assetpackage.u uVar = null;
            try {
                uVar = com.nexstreaming.app.general.nexasset.assetpackage.y.a(KineMasterApplication.f24056d.getApplicationContext(), getEffectItemID());
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (XmlPullParserException e3) {
                e3.printStackTrace();
            }
            if (uVar == null) {
                this.m_transitionOffsetPercent = 0;
                this.m_transitionOverlapPercent = 0;
                return;
            } else {
                this.m_transitionOffsetPercent = uVar.d();
                this.m_transitionOverlapPercent = uVar.c();
                return;
            }
        }
        this.m_transitionOffsetPercent = 0;
        this.m_transitionOverlapPercent = 0;
    }

    public int[] getTimeOptions(int i) {
        ArrayList arrayList = new ArrayList(9);
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = ((29900 * i2) / 9) + 100;
            int i4 = i3 - (i3 % SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE);
            if (i4 < 100) {
                i4 = 100;
            }
            if (i4 > 30000) {
                i4 = 30000;
            }
            if (i4 <= i) {
                arrayList.add(Integer.valueOf(i4));
            }
        }
        return com.nexstreaming.app.general.util.q.a(arrayList);
    }

    NexTransitionItem(String str) {
        this.m_transitionEffectID = null;
        this.m_transitionEffectID = str;
        updateOffsetOverlap();
    }
}
