package com.nextreaming.nexeditorui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.preference.PreferenceManager;
import android.util.Log;
import android.util.LruCache;
import android.widget.Toast;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.compat.EffectAssetCompatMap;
import com.nexstreaming.kinemaster.editorwrapper.Fa;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.AssetLayer;
import com.nexstreaming.kinemaster.layer.EffectLayer;
import com.nexstreaming.kinemaster.layer.GroupLayer;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.project.TimelineResourceUsage;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class NexTimeline implements Serializable {
    public static final String DEFAULT_PROJECT_IMAGE_DURATION = "4500";
    public static final String DEFAULT_PROJECT_LAYER_DURATION = "4500";
    public static final String DEFAULT_PROJECT_PHOTO_CROP_MODE = "none";

    /* renamed from: a, reason: collision with root package name */
    private static long f24120a = 0;
    private static final long serialVersionUID = 1;

    /* renamed from: d, reason: collision with root package name */
    private transient TimelineResourceUsage f24123d;

    /* renamed from: e, reason: collision with root package name */
    private transient TimelineResourceUsage f24124e;
    private transient NexAudioClipItem i;
    private transient NexProjectHeader j;
    private transient int[] k;
    private transient int l;
    private transient LruCache<UUID, Bitmap> m;
    private Set<Integer> m_bookmarks;
    private boolean m_isProjectVideoFadeInOn;
    private boolean m_isProjectVideoFadeOutOn;
    private int m_projectAspectRatioHeight;
    private int m_projectAspectRatioWidth;
    private boolean m_projectAutoMaster;
    private NexVideoClipItem.CropMode m_projectDefaultCropMode;
    private int m_projectDefaultLayerDuration;
    private int m_projectDefaultPhotoDuration;
    private int m_projectMasterVolume;
    private ProjectAspectRatio m_projectRatio;
    private int m_recentScrollTime;
    private int m_simulAudioTracks;
    private String m_themeId;
    private boolean m_themeMusicEnable;
    private int m_themeMusicVolume;
    private transient WeakReference<MediaStore> n;

    /* renamed from: b, reason: collision with root package name */
    private transient int f24121b = 0;

    /* renamed from: c, reason: collision with root package name */
    private transient int f24122c = 0;

    /* renamed from: f, reason: collision with root package name */
    private transient com.nexstreaming.kinemaster.project.n f24125f = null;

    /* renamed from: g, reason: collision with root package name */
    private transient com.nexstreaming.app.general.util.u<b> f24126g = null;

    /* renamed from: h, reason: collision with root package name */
    private transient WeakHashMap<NexTimelineItem, TimelineResourceUsage.b> f24127h = new WeakHashMap<>();
    private List<NexPrimaryTimelineItem> m_primaryItems = new ArrayList();
    private List<NexSecondaryTimelineItem> m_secondaryItems = new ArrayList();
    private List<com.nexstreaming.kinemaster.editorwrapper.Ea> m_tracks = new ArrayList();
    private String m_customBackgroundMusicPath = null;
    private String m_customBackgroundMusicTitle = null;
    private int m_timelimeFormatVersion = 6;
    private float m_projectVideoFadeInTime = 2.0f;
    private float m_projectVideoFadeOutTime = 2.0f;
    private float m_projectAudioFadeInTime = 0.2f;
    private float m_projectAudioFadeOutTime = 2.0f;
    private boolean m_isProjectAudioFadeInOn = false;
    private boolean m_isProjectAudioFadeOutOn = false;

    /* loaded from: classes.dex */
    public static class ClipNotFoundException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public ClipNotFoundException(String str) {
            super(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f24128a;

        /* renamed from: b, reason: collision with root package name */
        int f24129b;

        /* renamed from: c, reason: collision with root package name */
        NexSecondaryTimelineItem f24130c;

        /* renamed from: d, reason: collision with root package name */
        NexVideoClipItem f24131d;

        private a() {
        }

        public String toString() {
            String str;
            String str2 = "null";
            if (this.f24130c == null) {
                str = "null";
            } else {
                str = "S@" + this.f24130c.getStartTime();
            }
            if (this.f24131d != null) {
                str2 = "E@" + this.f24131d.getEngineClipID();
            }
            return "[" + str + " at " + str2 + "+" + this.f24128a + "->" + this.f24129b + "]";
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public /* synthetic */ a(Ma ma) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        void b(int i);

        int getCTSBeforeTimeChange();
    }

    /* loaded from: classes.dex */
    public interface c {
        void apply();
    }

    public NexTimeline() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext());
        this.m_projectDefaultLayerDuration = Integer.parseInt(defaultSharedPreferences.getString("add_layer_def_duration", "4500"));
        this.m_projectDefaultPhotoDuration = Integer.parseInt(defaultSharedPreferences.getString("add_img_def_duration", "4500"));
        this.m_projectDefaultCropMode = NexVideoClipItem.CropMode.fromString(defaultSharedPreferences.getString("add_img_def_crop", DEFAULT_PROJECT_PHOTO_CROP_MODE));
        this.m_projectAutoMaster = false;
        this.m_projectMasterVolume = 100;
    }

    private int a(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<a> list) {
        b();
        for (a aVar : list) {
            aVar.f24130c.moveClip(aVar.f24131d.getAbsStartTime() + aVar.f24128a);
        }
    }

    private void b() {
        a(false);
    }

    private void c() {
        Iterator<NexSecondaryTimelineItem> it = this.m_secondaryItems.iterator();
        while (it.hasNext()) {
            it.next().setOverLimit(false);
        }
    }

    private List<a> d() {
        int secondaryItemCount = getSecondaryItemCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < secondaryItemCount; i++) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i);
            if (!secondaryItem.getPinned()) {
                a aVar = new a(null);
                aVar.f24131d = getFirstVideoClipAtTime(secondaryItem.getAbsStartTime());
                if (aVar.f24131d != null) {
                    aVar.f24130c = secondaryItem;
                    aVar.f24128a = secondaryItem.getAbsStartTime() - aVar.f24131d.getAbsStartTime();
                    aVar.f24129b = secondaryItem.getAbsEndTime() - aVar.f24131d.getAbsStartTime();
                    arrayList.add(aVar);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.nexstreaming.app.general.util.u<b> e() {
        if (this.f24126g == null) {
            this.f24126g = new com.nexstreaming.app.general.util.u<>();
        }
        return this.f24126g;
    }

    public static NexTimeline fromProtoBuf(KMProto.KMProject kMProject) {
        NexTimeline nexTimeline = new NexTimeline();
        nexTimeline.m_bookmarks = new HashSet(kMProject.bookmarks);
        nexTimeline.m_projectRatio = ProjectAspectRatio.fromProtoBuf(kMProject.project_ratio);
        Integer num = kMProject.aspect_ratio_width;
        if (num != null) {
            nexTimeline.m_projectAspectRatioWidth = num.intValue();
        }
        Integer num2 = kMProject.aspect_ratio_height;
        if (num2 != null) {
            nexTimeline.m_projectAspectRatioHeight = num2.intValue();
        }
        nexTimeline.m_timelimeFormatVersion = kMProject.timeline_format_version.intValue();
        nexTimeline.m_recentScrollTime = kMProject.recent_scroll_time.intValue();
        Float f2 = kMProject.project_video_fade_in_time;
        if (f2 != null && kMProject.project_video_fade_out_time != null && kMProject.is_project_video_fade_in_on != null && kMProject.is_project_video_fade_out_on != null) {
            nexTimeline.m_projectVideoFadeInTime = f2.floatValue();
            nexTimeline.m_projectVideoFadeOutTime = kMProject.project_video_fade_out_time.floatValue();
            nexTimeline.m_isProjectVideoFadeInOn = kMProject.is_project_video_fade_in_on.booleanValue();
            nexTimeline.m_isProjectVideoFadeOutOn = kMProject.is_project_video_fade_out_on.booleanValue();
        } else {
            nexTimeline.m_projectVideoFadeInTime = 2.0f;
            nexTimeline.m_projectVideoFadeOutTime = 2.0f;
            nexTimeline.m_isProjectVideoFadeInOn = false;
            nexTimeline.m_isProjectVideoFadeOutOn = false;
        }
        nexTimeline.m_projectAudioFadeInTime = kMProject.project_audio_fade_in_time.floatValue();
        nexTimeline.m_projectAudioFadeOutTime = kMProject.project_audio_fade_out_time.floatValue();
        nexTimeline.m_isProjectAudioFadeInOn = kMProject.is_project_audio_fade_in_on.booleanValue();
        nexTimeline.m_isProjectAudioFadeOutOn = kMProject.is_project_audio_fade_out_on.booleanValue();
        if (kMProject.project_default_img_crop_mode == null && kMProject.project_default_img_duration == null && kMProject.project_default_layer_duration == null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext());
            nexTimeline.m_projectDefaultLayerDuration = Integer.parseInt(defaultSharedPreferences.getString("add_layer_def_duration", "4500"));
            nexTimeline.m_projectDefaultPhotoDuration = Integer.parseInt(defaultSharedPreferences.getString("add_img_def_duration", "4500"));
            nexTimeline.m_projectDefaultCropMode = NexVideoClipItem.CropMode.fromString(defaultSharedPreferences.getString("add_img_def_crop", DEFAULT_PROJECT_PHOTO_CROP_MODE));
        } else {
            nexTimeline.m_projectDefaultLayerDuration = kMProject.project_default_layer_duration.intValue();
            nexTimeline.m_projectDefaultPhotoDuration = kMProject.project_default_img_duration.intValue();
            nexTimeline.m_projectDefaultCropMode = NexVideoClipItem.CropMode.fromString(kMProject.project_default_img_crop_mode);
        }
        Boolean bool = kMProject.project_auto_master;
        nexTimeline.m_projectAutoMaster = bool == null ? false : bool.booleanValue();
        Integer num3 = kMProject.project_master_volume;
        nexTimeline.m_projectMasterVolume = num3 == null ? 100 : num3.intValue();
        if (kMProject.project_capability_mode == null) {
            CapabilityManager.f20040b.b(CapabilityManager.CapabilityMode.LEGACY);
        } else if (CapabilityManager.f20040b.d() == null || kMProject.project_capability_mode.intValue() != 2) {
            CapabilityManager.f20040b.b(CapabilityManager.CapabilityMode.fromValue(kMProject.project_capability_mode.intValue()));
        }
        Iterator<KMProto.KMProject.TimelineItem> it = kMProject.primary_items.iterator();
        while (it.hasNext()) {
            NexPrimaryTimelineItem primaryItemFromProtoBuf = primaryItemFromProtoBuf(it.next());
            if (primaryItemFromProtoBuf != null) {
                nexTimeline.m_primaryItems.add(primaryItemFromProtoBuf);
            }
        }
        Iterator<KMProto.KMProject.Track> it2 = kMProject.tracks.iterator();
        while (it2.hasNext()) {
            com.nexstreaming.kinemaster.editorwrapper.Ea trackItemFromProtoBuf = trackItemFromProtoBuf(it2.next());
            if (trackItemFromProtoBuf != null) {
                nexTimeline.m_tracks.add(trackItemFromProtoBuf);
                trackItemFromProtoBuf.a(nexTimeline);
            }
        }
        Iterator<KMProto.KMProject.TimelineItem> it3 = kMProject.secondary_items.iterator();
        while (it3.hasNext()) {
            NexSecondaryTimelineItem secondaryItemFromProtoBuf = secondaryItemFromProtoBuf(it3.next());
            if (secondaryItemFromProtoBuf != null) {
                nexTimeline.m_secondaryItems.add(secondaryItemFromProtoBuf);
            }
        }
        int primaryItemCount = nexTimeline.getPrimaryItemCount();
        int secondaryItemCount = nexTimeline.getSecondaryItemCount();
        for (int i = 0; i < primaryItemCount; i++) {
            nexTimeline.getPrimaryItem(i).wasAddedToTimeline(nexTimeline);
        }
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            nexTimeline.getSecondaryItem(i2).wasAddedToTimeline(nexTimeline);
        }
        nexTimeline.requestCalcTimes();
        return nexTimeline;
    }

    public static NexPrimaryTimelineItem primaryItemFromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        int i = Pa.f24162b[timelineItem.clip_type.ordinal()];
        if (i == 1) {
            return NexTransitionItem.fromProtoBuf(timelineItem);
        }
        if (i != 2) {
            return null;
        }
        return NexVideoClipItem.fromProtoBuf(timelineItem);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int primaryItemCount = getPrimaryItemCount();
        int secondaryItemCount = getSecondaryItemCount();
        for (int i = 0; i < primaryItemCount; i++) {
            getPrimaryItem(i).wasAddedToTimeline(this);
        }
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            getSecondaryItem(i2).wasAddedToTimeline(this);
        }
        requestCalcTimes();
    }

    public static NexSecondaryTimelineItem secondaryItemFromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        switch (Pa.f24162b[timelineItem.clip_type.ordinal()]) {
            case 3:
                return NexAudioClipItem.fromProtoBuf(timelineItem);
            case 4:
                return HandwritingLayer.fromProtoBuf(timelineItem);
            case 5:
                return StickerLayer.fromProtoBuf(timelineItem);
            case 6:
                return TextLayer.fromProtoBuf(timelineItem);
            case 7:
                return ImageLayer.fromProtoBuf(timelineItem);
            case 8:
                return EffectLayer.fromProtoBuf(timelineItem);
            case 9:
                return AssetLayer.fromProtoBuf(timelineItem);
            case 10:
                return VideoLayer.fromProtoBuf(timelineItem);
            case 11:
                return GroupLayer.fromProtoBuf(timelineItem);
            default:
                return null;
        }
    }

    public static com.nexstreaming.kinemaster.editorwrapper.Ea trackItemFromProtoBuf(KMProto.KMProject.Track track) {
        return com.nexstreaming.kinemaster.editorwrapper.Ea.a(track);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public void addBookmark(int i) {
        a(i);
        if (this.m_bookmarks == null) {
            this.m_bookmarks = new HashSet();
        }
        if (this.m_bookmarks.contains(Integer.valueOf(i))) {
            return;
        }
        this.m_bookmarks.add(Integer.valueOf(i));
        this.k = null;
    }

    public void addLayer(NexLayerItem nexLayerItem) {
        if (nexLayerItem instanceof VideoLayer) {
            ((VideoLayer) nexLayerItem).setEngineClipID(nextAvailableEngineClipId());
        }
        nexLayerItem.setZOrder(getFrontmostLayerZOrder() + 1);
        nexLayerItem.getUniqueId();
        addSecondaryItem(nexLayerItem);
    }

    public synchronized void addPrimaryItem(int i, NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        a(i, nexPrimaryTimelineItem, true);
    }

    public synchronized void addSecondaryItem(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        this.m_secondaryItems.add(nexSecondaryTimelineItem);
        nexSecondaryTimelineItem.wasAddedToTimeline(this);
        requestCalcTimes();
        a();
    }

    public com.nexstreaming.kinemaster.editorwrapper.Ea addTrack(int i) {
        return addTrack(i, new com.nexstreaming.kinemaster.editorwrapper.Ea(getMaxTrackId() + 1));
    }

    public void applyFinalPathForMSID(MediaStoreItemId mediaStoreItemId, String str, NexVideoClipItem.CropMode cropMode, int i) {
        try {
            Iterator<NexPrimaryTimelineItem> it = this.m_primaryItems.iterator();
            while (it.hasNext()) {
                it.next().applyFinalPath(mediaStoreItemId, str, cropMode, i);
            }
            Iterator<NexSecondaryTimelineItem> it2 = this.m_secondaryItems.iterator();
            while (it2.hasNext()) {
                it2.next().applyFinalPath(mediaStoreItemId, str, cropMode, i);
            }
            b();
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }

    public void applyProjectSettingsToEditor(NexEditor nexEditor, VideoEditor.ExportPass exportPass) {
        if (exportPass == VideoEditor.ExportPass.Layers) {
            nexEditor.setProjectVolumeFade(0, 0);
            nexEditor.setProjectManualVolumeControl(1);
            nexEditor.setProjectVolume(100);
        } else {
            applyVolumeFadingToEditor(nexEditor);
            a(nexEditor);
        }
    }

    public void applyVolumeFadingToEditor(NexEditor nexEditor) {
        int projectAudioFadeInTimeMillis = !isProjectAudioFadeInTimeOn() ? 0 : getProjectAudioFadeInTimeMillis();
        int projectAudioFadeOutTimeMillis = isProjectAudioFadeOutTimeOn() ? getProjectAudioFadeOutTimeMillis() : 0;
        int totalTime = getTotalTime();
        int i = projectAudioFadeInTimeMillis + projectAudioFadeOutTimeMillis;
        if (i > totalTime) {
            projectAudioFadeInTimeMillis = (projectAudioFadeInTimeMillis * totalTime) / i;
            projectAudioFadeOutTimeMillis = totalTime - projectAudioFadeInTimeMillis;
        }
        nexEditor.setProjectVolumeFade(projectAudioFadeInTimeMillis, projectAudioFadeOutTimeMillis);
    }

    public KMProto.KMProject asProtoBuf() {
        KMProto.KMProject.Builder builder = new KMProto.KMProject.Builder();
        builder.primary_items = new ArrayList();
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
            KMProto.KMProject.TimelineItem asProtoBuf = nexPrimaryTimelineItem.asProtoBuf();
            if (asProtoBuf != null) {
                builder.primary_items.add(asProtoBuf);
            } else if (System.currentTimeMillis() - f24120a > 120000) {
                f24120a = System.currentTimeMillis();
                Toast.makeText(KineMasterApplication.f24056d.getApplicationContext(), "No Serializer: " + nexPrimaryTimelineItem.getClass().getName(), 0).show();
            }
        }
        builder.tracks = new ArrayList();
        for (com.nexstreaming.kinemaster.editorwrapper.Ea ea : this.m_tracks) {
            KMProto.KMProject.Track a2 = ea.a();
            if (a2 != null) {
                builder.tracks.add(a2);
            } else if (System.currentTimeMillis() - f24120a > 120000) {
                f24120a = System.currentTimeMillis();
                Toast.makeText(KineMasterApplication.f24056d.getApplicationContext(), "No Serializer: " + ea.getClass().getName(), 0).show();
            }
        }
        builder.secondary_items = new ArrayList();
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            KMProto.KMProject.TimelineItem asProtoBuf2 = nexSecondaryTimelineItem.asProtoBuf();
            if (asProtoBuf2 != null) {
                builder.secondary_items.add(asProtoBuf2);
            } else if (System.currentTimeMillis() - f24120a > 120000) {
                f24120a = System.currentTimeMillis();
                Toast.makeText(KineMasterApplication.f24056d.getApplicationContext(), "No Serializer: " + nexSecondaryTimelineItem.getClass().getName(), 0).show();
            }
        }
        if (this.m_bookmarks != null) {
            builder.bookmarks = new ArrayList();
            builder.bookmarks.addAll(this.m_bookmarks);
        }
        ProjectAspectRatio projectAspectRatio = this.m_projectRatio;
        builder.project_ratio = projectAspectRatio == null ? null : projectAspectRatio.asProtoBuf();
        builder.aspect_ratio_width = Integer.valueOf(this.m_projectAspectRatioWidth);
        builder.aspect_ratio_height = Integer.valueOf(this.m_projectAspectRatioHeight);
        return builder.timeline_format_version(Integer.valueOf(this.m_timelimeFormatVersion)).recent_scroll_time(Integer.valueOf(this.m_recentScrollTime)).project_audio_fade_in_time(Float.valueOf(this.m_projectAudioFadeInTime)).project_audio_fade_out_time(Float.valueOf(this.m_projectAudioFadeOutTime)).is_project_audio_fade_in_on(Boolean.valueOf(this.m_isProjectAudioFadeInOn)).is_project_audio_fade_out_on(Boolean.valueOf(this.m_isProjectAudioFadeOutOn)).project_video_fade_in_time(Float.valueOf(this.m_projectVideoFadeInTime)).project_video_fade_out_time(Float.valueOf(this.m_projectVideoFadeOutTime)).is_project_video_fade_in_on(Boolean.valueOf(this.m_isProjectVideoFadeInOn)).is_project_video_fade_out_on(Boolean.valueOf(this.m_isProjectVideoFadeOutOn)).project_default_img_duration(Integer.valueOf(this.m_projectDefaultPhotoDuration)).project_default_layer_duration(Integer.valueOf(this.m_projectDefaultLayerDuration)).project_default_img_crop_mode(this.m_projectDefaultCropMode.toString()).project_auto_master(Boolean.valueOf(this.m_projectAutoMaster)).project_master_volume(Integer.valueOf(this.m_projectMasterVolume)).project_capability_mode(Integer.valueOf((CapabilityManager.f20040b.s() ? CapabilityManager.f20040b.d() : CapabilityManager.CapabilityMode.LEGACY).ordinal())).build();
    }

    public c beginTimeChange() {
        b();
        List<a> d2 = d();
        HashMap hashMap = new HashMap();
        e().a(new Ma(this, hashMap));
        return new Oa(this, d2, hashMap);
    }

    public boolean checkReadyToPlay() {
        int size = this.m_primaryItems.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            if (!this.m_primaryItems.get(i).isReadyToPlay()) {
                z = false;
            }
        }
        int size2 = this.m_secondaryItems.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (!this.m_secondaryItems.get(i2).isReadyToPlay()) {
                z = false;
            }
        }
        return z;
    }

    public boolean checkResources(Context context) {
        int size = this.m_primaryItems.size();
        boolean z = true;
        for (int i = 0; i < size; i++) {
            if (!this.m_primaryItems.get(i).checkResourceState(context)) {
                z = false;
            }
        }
        int size2 = this.m_secondaryItems.size();
        for (int i2 = 0; i2 < size2; i2++) {
            if (!this.m_secondaryItems.get(i2).checkResourceState(context)) {
                z = false;
            }
        }
        String customBGMusic = getCustomBGMusic();
        if (customBGMusic == null || customBGMusic.startsWith("@") || new File(customBGMusic).exists()) {
            return z;
        }
        return false;
    }

    public boolean checkSecondaryItemLimits() {
        boolean checkSecondaryItemLimits = checkSecondaryItemLimits(com.nexstreaming.kinemaster.project.f.f21190a.a(), 4);
        if (checkSecondaryItemLimits(com.nexstreaming.kinemaster.project.f.f21190a.b(), 2)) {
            return true;
        }
        return checkSecondaryItemLimits;
    }

    public void clearAllBookmarks() {
        this.m_bookmarks = null;
        this.k = null;
    }

    public void clearTimeline() {
        this.m_primaryItems.clear();
        this.m_secondaryItems.clear();
    }

    public boolean deleteDependentItemOnAsset(String str, VideoEditor videoEditor) {
        int size = this.m_primaryItems.size();
        ArrayList<NexPrimaryTimelineItem> arrayList = new ArrayList();
        for (int i = 0; i < size; i++) {
            if (this.m_primaryItems.get(i).hasDependencyFromAsset(str)) {
                arrayList.add(this.m_primaryItems.get(i));
            }
            if (this.m_primaryItems.get(i).checkAndDeleteFontOfEffect()) {
                videoEditor.c(this.m_primaryItems.get(i));
            }
        }
        boolean z = false;
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : arrayList) {
            if (nexPrimaryTimelineItem instanceof NexTransitionItem) {
                ((NexTransitionItem) nexPrimaryTimelineItem).clearTransitionEffect();
            }
            if (nexPrimaryTimelineItem instanceof NexVideoClipItem) {
                ((NexVideoClipItem) nexPrimaryTimelineItem).setEffectItem(null);
            }
            z = true;
        }
        int size2 = this.m_secondaryItems.size();
        ArrayList<NexSecondaryTimelineItem> arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < size2; i2++) {
            if (this.m_secondaryItems.get(i2).hasDependencyFromAsset(str)) {
                arrayList2.add(this.m_secondaryItems.get(i2));
            }
        }
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : arrayList2) {
            if (nexSecondaryTimelineItem instanceof TextLayer) {
                TextLayer textLayer = (TextLayer) nexSecondaryTimelineItem;
                textLayer.setFontId(null);
                videoEditor.c((NexLayerItem) textLayer);
            } else {
                deleteSecondaryItem(nexSecondaryTimelineItem);
            }
            z = true;
        }
        return z;
    }

    public synchronized void deletePrimaryItem(int i) {
        a(i, true);
    }

    public synchronized void deleteSecondaryItem(int i) {
        NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i);
        this.m_secondaryItems.remove(i);
        nexSecondaryTimelineItem.wasRemovedFromTimeline(this);
        requestCalcTimes();
    }

    public void dumpPrimaryTimeline(String str, String str2) {
    }

    public void dumpSecondaryTimeline(EditorGlobal.a aVar) {
        if (aVar == null) {
            aVar = new EditorGlobal.a("timeline_validation");
        }
        EditorGlobal.g().mkdirs();
        new File(EditorGlobal.g(), "timeline_validation.log");
        int secondaryItemCount = getSecondaryItemCount();
        for (int i = 0; i < secondaryItemCount; i++) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i);
            int duration = secondaryItem.getDuration();
            aVar.a("NexTimeline", "    " + i + ": " + secondaryItem.getAbsStartTime() + "->" + secondaryItem.getAbsEndTime() + "  (" + duration + ")");
            if (secondaryItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                String mediaPath = nexAudioClipItem.getMediaPath();
                if (mediaPath == null) {
                    mediaPath = "(null)";
                }
                aVar.a("NexTimeline", "        AUDIO: rel(" + nexAudioClipItem.getRelativeStartTime() + "," + nexAudioClipItem.getRelativeEndTime() + ") extra(" + nexAudioClipItem.getExtraRelativeStartTime() + ") videoStart(" + nexAudioClipItem.getVideoClip().getEngineClipID() + "/" + nexAudioClipItem.getVideoClip().getAbsStartTime() + ")");
                StringBuilder sb = new StringBuilder();
                sb.append("                  media-a: ");
                sb.append(mediaPath);
                aVar.a("NexTimeline", sb.toString());
                StringBuilder sb2 = new StringBuilder();
                sb2.append("                  media-v: ");
                sb2.append(nexAudioClipItem.getVideoClip().getMediaPath());
                aVar.a("NexTimeline", sb2.toString());
            }
        }
    }

    public void ensureItemsHaveUniqueIds() {
        Iterator<NexPrimaryTimelineItem> it = this.m_primaryItems.iterator();
        while (it.hasNext()) {
            a(it.next());
        }
        Iterator<NexSecondaryTimelineItem> it2 = this.m_secondaryItems.iterator();
        while (it2.hasNext()) {
            a((NexTimelineItem) it2.next());
        }
        int[] bookmarks = getBookmarks();
        clearAllBookmarks();
        for (int i : bookmarks) {
            addBookmark(i);
        }
    }

    public NexTimelineItem findItemByUniqueId(UUID uuid) {
        ensureItemsHaveUniqueIds();
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
            if (nexPrimaryTimelineItem.getUniqueId().equals(uuid)) {
                return nexPrimaryTimelineItem;
            }
        }
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            if (nexSecondaryTimelineItem.getUniqueId().equals(uuid)) {
                return nexSecondaryTimelineItem;
            }
        }
        NexAudioClipItem nexAudioClipItem = this.i;
        if (nexAudioClipItem == null || !nexAudioClipItem.getUniqueId().equals(uuid)) {
            return null;
        }
        return this.i;
    }

    public NexPrimaryTimelineItem findPrimaryItemByTime(int i) {
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
            if (!(nexPrimaryTimelineItem instanceof NexTransitionItem) && i >= nexPrimaryTimelineItem.getAbsStartTime() && i < nexPrimaryTimelineItem.getAbsEndTime()) {
                return nexPrimaryTimelineItem;
            }
        }
        return null;
    }

    public com.nexstreaming.kinemaster.editorwrapper.Ea findTrackByUniqueId(int i) {
        for (com.nexstreaming.kinemaster.editorwrapper.Ea ea : this.m_tracks) {
            if (ea.c() == i) {
                return ea;
            }
        }
        return null;
    }

    public void fireOnLoadEvent() {
        int size = this.m_primaryItems.size();
        for (int i = 0; i < size; i++) {
            this.m_primaryItems.get(i).onTimelineLoaded();
        }
        int size2 = this.m_secondaryItems.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.m_secondaryItems.get(i2).onTimelineLoaded();
        }
    }

    public int freeSpaceAtTime(int i, int i2, int i3, boolean z) {
        return freeSpaceAtTime(i, i2, i3, null, 0, z);
    }

    public TimelineResourceUsage getAdjustedResourceUsage() {
        getResourceUsage();
        return this.f24124e;
    }

    public List<ProjectDependency> getAllDependencies() {
        ArrayList arrayList = new ArrayList();
        String str = this.m_themeId;
        if (str != null) {
            arrayList.add(ProjectDependency.d(str));
        }
        int size = this.m_primaryItems.size();
        for (int i = 0; i < size; i++) {
            this.m_primaryItems.get(i).addDependencies(arrayList);
        }
        int size2 = this.m_secondaryItems.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.m_secondaryItems.get(i2).addDependencies(arrayList);
        }
        return arrayList;
    }

    public int getAppVersionCode() {
        return this.l;
    }

    public long getBackmostLayerZOrder() {
        int size = this.m_secondaryItems.size();
        long j = -1;
        for (int i = 0; i < size; i++) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i);
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                j = Math.min(j, ((NexLayerItem) nexSecondaryTimelineItem).getZOrder());
            }
        }
        return j;
    }

    public int[] getBookmarks() {
        if (this.k == null) {
            this.k = com.nexstreaming.app.general.util.q.a(this.m_bookmarks);
        }
        return this.k;
    }

    public int getClipTimingSerial() {
        return this.f24121b;
    }

    @Deprecated
    public String getCustomBGMTitle() {
        return this.m_customBackgroundMusicTitle;
    }

    @Deprecated
    public String getCustomBGMusic() {
        return this.m_customBackgroundMusicPath;
    }

    public int getDecoderMemoryUsageAtTime(int i) {
        int primaryItemCount = getPrimaryItemCount();
        int i2 = 0;
        for (int i3 = 0; i3 < primaryItemCount; i3++) {
            NexPrimaryTimelineItem primaryItem = getPrimaryItem(i3);
            if (i >= primaryItem.getAbsStartTime() && i <= primaryItem.getAbsEndTime()) {
                if (primaryItem instanceof NexVideoClipItem) {
                    NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                    if (nexVideoClipItem.isVideo()) {
                        i2 += ((((nexVideoClipItem.getWidth() * nexVideoClipItem.getHeight()) * 150) / 100) * nexVideoClipItem.getFPS()) / 30;
                    }
                } else {
                    boolean z = primaryItem instanceof NexTransitionItem;
                }
            }
        }
        int secondaryItemCount = getSecondaryItemCount();
        for (int i4 = 0; i4 < secondaryItemCount; i4++) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i4);
            if (i >= secondaryItem.getAbsStartTime() && i <= secondaryItem.getAbsEndTime() && (secondaryItem instanceof VideoLayer)) {
                VideoLayer videoLayer = (VideoLayer) secondaryItem;
                i2 += ((((videoLayer.getWidth() * videoLayer.getHeight()) * 150) / 100) * videoLayer.getFPS()) / 30;
            }
        }
        return i2;
    }

    public Set<ProjectDependency> getDependencies() {
        HashSet hashSet = new HashSet();
        String str = this.m_themeId;
        if (str != null) {
            hashSet.add(ProjectDependency.d(str));
        }
        int size = this.m_primaryItems.size();
        for (int i = 0; i < size; i++) {
            this.m_primaryItems.get(i).addDependencies(hashSet);
        }
        int size2 = this.m_secondaryItems.size();
        for (int i2 = 0; i2 < size2; i2++) {
            this.m_secondaryItems.get(i2).addDependencies(hashSet);
        }
        return hashSet;
    }

    public int getExactFrameTimeEqualOrGreater(int i) {
        int frameFromTime = getFrameFromTime(i);
        int timeFromFrame = getTimeFromFrame(frameFromTime);
        return timeFromFrame < i ? getTimeFromFrame(frameFromTime + 1) : timeFromFrame;
    }

    public int getExactFrameTimeEqualOrLess(int i) {
        int frameFromTime = getFrameFromTime(i);
        int timeFromFrame = getTimeFromFrame(frameFromTime);
        return timeFromFrame > i ? getTimeFromFrame(frameFromTime - 1) : timeFromFrame;
    }

    public NexVideoClipItem getFirstVideoClipAtTime(int i) {
        int i2 = -1;
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
            if (nexPrimaryTimelineItem instanceof NexVideoClipItem) {
                int absStartTime = nexPrimaryTimelineItem.getAbsStartTime();
                int absEndTime = nexPrimaryTimelineItem.getAbsEndTime();
                if ((i >= absStartTime && i < absEndTime) || (i2 < i && absStartTime > i)) {
                    return (NexVideoClipItem) nexPrimaryTimelineItem;
                }
                i2 = absEndTime;
            }
        }
        return null;
    }

    public int getFrameFromTime(int i) {
        return (int) ((i * getFrameRate()) / 1000);
    }

    public int getFrameRate() {
        return 30;
    }

    public long getFrontmostLayerZOrder() {
        int size = this.m_secondaryItems.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i);
            if (nexSecondaryTimelineItem instanceof NexLayerItem) {
                j = Math.max(j, ((NexLayerItem) nexSecondaryTimelineItem).getZOrder());
            }
        }
        return j;
    }

    public int getIndexOfPrimaryItem(NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        return this.m_primaryItems.indexOf(nexPrimaryTimelineItem);
    }

    public int getIndexOfSecondaryItem(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        return this.m_secondaryItems.indexOf(nexSecondaryTimelineItem);
    }

    @Deprecated
    public int getMaxSimultaneousAudioTrackCount() {
        return this.m_simulAudioTracks;
    }

    public int getMaxTrackId() {
        List<com.nexstreaming.kinemaster.editorwrapper.Ea> list = this.m_tracks;
        if (list == null) {
            return 0;
        }
        int size = list.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.m_tracks.get(i2).c());
        }
        return i;
    }

    public MediaStore getMediaStore() {
        WeakReference<MediaStore> weakReference = this.n;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Nullable
    public NexPrimaryTimelineItem getPrimaryItem(int i) {
        if (this.m_primaryItems.size() < i) {
            return null;
        }
        return this.m_primaryItems.get(i);
    }

    public NexPrimaryTimelineItem getPrimaryItemById(int i, String str) {
        int primaryItemCount = getPrimaryItemCount();
        for (int i2 = 0; i2 < primaryItemCount; i2++) {
            NexPrimaryTimelineItem primaryItem = getPrimaryItem(i2);
            if ((primaryItem instanceof NexVideoClipItem) && ((NexVideoClipItem) primaryItem).getEngineClipID() == i) {
                return primaryItem;
            }
        }
        String str2 = "";
        for (int i3 = 0; i3 < primaryItemCount; i3++) {
            NexPrimaryTimelineItem primaryItem2 = getPrimaryItem(i3);
            if (primaryItem2 instanceof NexVideoClipItem) {
                str2 = str2 + " " + ((NexVideoClipItem) primaryItem2).getEngineClipID();
            }
        }
        throw new ClipNotFoundException("" + i + " not found in [" + str2 + " ] " + str);
    }

    public int getPrimaryItemCount() {
        return this.m_primaryItems.size();
    }

    public List<NexPrimaryTimelineItem> getPrimaryItems() {
        return this.m_primaryItems;
    }

    public NexPrimaryTimelineItem[] getPrimaryItemsAtTime(int i) {
        int primaryItemCount = getPrimaryItemCount();
        NexPrimaryTimelineItem[] nexPrimaryTimelineItemArr = new NexPrimaryTimelineItem[3];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= primaryItemCount) {
                break;
            }
            NexPrimaryTimelineItem primaryItem = getPrimaryItem(i2);
            if (i >= primaryItem.getAbsStartTime() && i <= primaryItem.getAbsEndTime()) {
                if (i3 >= nexPrimaryTimelineItemArr.length) {
                    Log.w("NexTimeline", "getPrimaryItemsAtTime : more than 2 items detected at this time; internal consistency error");
                    break;
                }
                nexPrimaryTimelineItemArr[i3] = primaryItem;
                i3++;
            }
            i2++;
        }
        NexPrimaryTimelineItem[] nexPrimaryTimelineItemArr2 = new NexPrimaryTimelineItem[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            nexPrimaryTimelineItemArr2[i4] = nexPrimaryTimelineItemArr[i4];
        }
        return nexPrimaryTimelineItemArr2;
    }

    public int getProjectAspectRatioHeight() {
        return this.m_projectAspectRatioHeight;
    }

    public int getProjectAspectRatioWidth() {
        return this.m_projectAspectRatioWidth;
    }

    public int getProjectAudioFadeInTimeMillis() {
        float f2 = this.m_projectAudioFadeInTime;
        return f2 > 100.0f ? (int) f2 : (int) (f2 * 1000.0f);
    }

    public int getProjectAudioFadeOutTimeMillis() {
        float f2 = this.m_projectAudioFadeOutTime;
        return f2 > 100.0f ? (int) f2 : (int) (f2 * 1000.0f);
    }

    public NexVideoClipItem.CropMode getProjectDefaultCropMode() {
        return this.m_projectDefaultCropMode;
    }

    public int getProjectDefaultLayerDuration() {
        return this.m_projectDefaultLayerDuration;
    }

    public int getProjectDefaultPhotoDuration() {
        return this.m_projectDefaultPhotoDuration;
    }

    public NexProjectHeader getProjectHeader() {
        if (this.j == null) {
            this.j = new NexProjectHeader();
            this.j.creationTime = new Date();
            NexProjectHeader nexProjectHeader = this.j;
            nexProjectHeader.savedWithKMVersion = 14242;
            nexProjectHeader.savedOnPlatform = KMProto.Platform.ANDROID;
            nexProjectHeader.savedWithKMVersionName = "4.11.15.14242";
        }
        NexProjectHeader nexProjectHeader2 = this.j;
        if (nexProjectHeader2.projectUUID == null) {
            nexProjectHeader2.projectUUID = UUID.randomUUID();
        }
        return this.j;
    }

    public int getProjectMasterVolume() {
        return this.m_projectMasterVolume;
    }

    public ProjectAspectRatio getProjectRatio() {
        ProjectAspectRatio projectAspectRatio = this.m_projectRatio;
        if (projectAspectRatio == null || projectAspectRatio.equals("")) {
            this.m_projectRatio = ProjectAspectRatio.R_16_9;
        }
        return this.m_projectRatio;
    }

    public int getProjectVideoFadeInTimeMillis() {
        return (int) (this.m_projectVideoFadeInTime * 1000.0f);
    }

    public int getProjectVideoFadeOutTimeMillis() {
        return (int) (this.m_projectVideoFadeOutTime * 1000.0f);
    }

    public int getRecentScrollTime() {
        return this.m_recentScrollTime;
    }

    public Set<File> getRequiredFiles() {
        HashSet hashSet = new HashSet();
        int size = this.m_primaryItems.size();
        for (int i = 0; i < size; i++) {
            if (this.m_primaryItems.get(i) instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) this.m_primaryItems.get(i);
                if (!nexVideoClipItem.isPreset()) {
                    hashSet.add(new File(nexVideoClipItem.getMediaPath()));
                }
            }
        }
        int size2 = this.m_secondaryItems.size();
        for (int i2 = 0; i2 < size2; i2++) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i2);
            if (nexSecondaryTimelineItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) nexSecondaryTimelineItem;
                if (nexAudioClipItem.getIsVoiceRecording()) {
                    hashSet.add(new File(nexAudioClipItem.getMediaPath()));
                }
            }
            if (nexSecondaryTimelineItem instanceof ImageLayer) {
                hashSet.add(new File(((ImageLayer) nexSecondaryTimelineItem).getMediaPath()));
            } else if (nexSecondaryTimelineItem instanceof VideoLayer) {
                hashSet.add(new File(((VideoLayer) nexSecondaryTimelineItem).getMediaPath()));
            }
        }
        return hashSet;
    }

    public int getRequiredSubTrackCount() {
        Iterator<com.nexstreaming.kinemaster.editorwrapper.Ea> it = this.m_tracks.iterator();
        int i = 0;
        while (it.hasNext()) {
            i += Math.max(1, it.next().e());
        }
        return i;
    }

    public TimelineResourceUsage getResourceUsage() {
        if (this.f24123d == null || this.f24124e == null) {
            c();
            this.f24123d = new TimelineResourceUsage(this);
            this.f24124e = this.f24123d;
        }
        return this.f24123d;
    }

    public TimelineResourceUsage.b getResourceUsageForItem(NexTimelineItem nexTimelineItem) {
        if (this.f24127h == null) {
            this.f24127h = new WeakHashMap<>();
        }
        TimelineResourceUsage.b bVar = this.f24127h.get(nexTimelineItem);
        if (bVar != null) {
            return bVar;
        }
        TimelineResourceUsage.b a2 = getResourceUsage().a(nexTimelineItem.getAbsStartTime(), nexTimelineItem.getAbsEndTime());
        this.f24127h.put(nexTimelineItem, a2);
        return a2;
    }

    public NexSecondaryTimelineItem getSecondaryItem(int i) {
        if (this.m_secondaryItems.size() <= 0 || i >= this.m_secondaryItems.size()) {
            return null;
        }
        return this.m_secondaryItems.get(i);
    }

    public int getSecondaryItemCount() {
        return this.m_secondaryItems.size();
    }

    public List<NexSecondaryTimelineItem> getSecondaryItems() {
        return this.m_secondaryItems;
    }

    public int getSecondaryItemsAtTime(int i) {
        int i2 = 0;
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            int absStartTime = nexSecondaryTimelineItem.getAbsStartTime();
            int absEndTime = nexSecondaryTimelineItem.getAbsEndTime();
            if (i >= absStartTime && i <= absEndTime) {
                i2++;
            }
        }
        return i2;
    }

    public List<NexSecondaryTimelineItem> getSecondaryItemsByTrackId(int i) {
        ArrayList arrayList = new ArrayList();
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            if (nexSecondaryTimelineItem.getTrackId() == i) {
                arrayList.add(nexSecondaryTimelineItem);
            }
        }
        return arrayList;
    }

    public int getSecondaryLimitSerial() {
        return this.f24122c;
    }

    public String getThemeId() {
        String str = this.m_themeId;
        return str == null ? "com.nexstreaming.kinemaster.basic" : str;
    }

    public boolean getThemeMusicMute() {
        return !this.m_themeMusicEnable;
    }

    public int getThemeMusicVolume() {
        return this.m_themeMusicVolume;
    }

    public LruCache<UUID, Bitmap> getThumbnailCache() {
        if (this.m == null) {
            this.m = new LruCache<>(150);
        }
        return this.m;
    }

    public int getTimeFromFrame(int i) {
        return (int) (((i * 1000) + ((1000 / getFrameRate()) - 1)) / getFrameRate());
    }

    public int getTotalSecondaryTime() {
        if (this.m_secondaryItems.size() < 1) {
            return 0;
        }
        int size = this.m_secondaryItems.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i = Math.max(i, this.m_secondaryItems.get(i2).getAbsEndTime());
        }
        return i;
    }

    public int getTotalTime() {
        if (this.m_primaryItems.size() < 1) {
            return 0;
        }
        List<NexPrimaryTimelineItem> list = this.m_primaryItems;
        return list.get(list.size() - 1).getAbsEndTime();
    }

    public com.nexstreaming.kinemaster.editorwrapper.Ea getTrackAtIndex(int i) {
        return this.m_tracks.get(i);
    }

    public com.nexstreaming.kinemaster.editorwrapper.Ea getTrackById(int i) {
        List<com.nexstreaming.kinemaster.editorwrapper.Ea> list = this.m_tracks;
        if (list == null) {
            return null;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.m_tracks.get(i2).c() == i) {
                return this.m_tracks.get(i2);
            }
        }
        return null;
    }

    public int getTrackCount() {
        List<com.nexstreaming.kinemaster.editorwrapper.Ea> list = this.m_tracks;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public int getTrackIdAtIndex(int i) {
        if (i < 0 || i >= this.m_tracks.size()) {
            return -1;
        }
        return this.m_tracks.get(i).c();
    }

    public int getTrackIdByItem(com.nexstreaming.kinemaster.editorwrapper.Fa fa) {
        if (fa instanceof com.nexstreaming.kinemaster.editorwrapper.Ea) {
            return ((com.nexstreaming.kinemaster.editorwrapper.Ea) fa).c();
        }
        if (fa instanceof com.nexstreaming.kinemaster.ui.projectedit.timeline.M) {
            return ((com.nexstreaming.kinemaster.ui.projectedit.timeline.M) fa).a().c();
        }
        if (fa instanceof NexSecondaryTimelineItem) {
            return ((NexSecondaryTimelineItem) fa).getTrackId();
        }
        throw new IllegalStateException("Unsupported item type: " + fa);
    }

    public int getTrackIndexById(int i) {
        List<com.nexstreaming.kinemaster.editorwrapper.Ea> list = this.m_tracks;
        if (list == null) {
            return -1;
        }
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.m_tracks.get(i2).c() == i) {
                return i2;
            }
        }
        return -1;
    }

    public boolean isAutoMaster() {
        return this.m_projectAutoMaster;
    }

    public boolean isBookmark(int i) {
        if (this.m_bookmarks == null) {
            return false;
        }
        a(i);
        return this.m_bookmarks.contains(Integer.valueOf(i));
    }

    public boolean isProjectAudioFadeInTimeOn() {
        return this.m_isProjectAudioFadeInOn;
    }

    public boolean isProjectAudioFadeOutTimeOn() {
        return this.m_isProjectAudioFadeOutOn;
    }

    public boolean isProjectVideoFadeInTimeOn() {
        return this.m_isProjectVideoFadeInOn;
    }

    public boolean isProjectVideoFadeOutTimeOn() {
        return this.m_isProjectVideoFadeOutOn;
    }

    public boolean isSameBookmark(int i, int i2) {
        a(i);
        a(i2);
        return i == i2 && this.m_bookmarks.contains(Integer.valueOf(i));
    }

    public void movePrimaryItem(int i, int i2) {
        NexPrimaryTimelineItem primaryItem = getPrimaryItem(i);
        int primaryItemCount = getPrimaryItemCount();
        if (i2 > i) {
            a(i2, primaryItem, true);
            a(i, false);
            if (i2 >= primaryItemCount) {
                if (primaryItemCount >= 3) {
                    getPrimaryItem(primaryItemCount - 3).getTransition().wasAddedToTimeline(this);
                }
                primaryItem.getTransition().wasRemovedFromTimeline(this);
            }
        } else {
            a(i, false);
            a(i2, primaryItem, true);
            if (i + 1 == primaryItemCount) {
                getPrimaryItem(primaryItemCount - 1).getTransition().wasRemovedFromTimeline(this);
                primaryItem.getTransition().wasAddedToTimeline(this);
            }
        }
        requestCalcTimes();
    }

    public void movePrimaryItem_v5(int i, int i2) {
        NexPrimaryTimelineItem primaryItem = getPrimaryItem(i);
        int primaryItemCount = getPrimaryItemCount();
        a(i, false);
        a(i2, primaryItem, true);
        if (i2 + 1 >= primaryItemCount) {
            if (primaryItemCount >= 3) {
                getPrimaryItem(primaryItemCount - 3).getTransition().wasAddedToTimeline(this);
            }
            primaryItem.getTransition().wasRemovedFromTimeline(this);
        } else if (i + 1 == primaryItemCount) {
            getPrimaryItem(primaryItemCount - 1).getTransition().wasRemovedFromTimeline(this);
            primaryItem.getTransition().wasAddedToTimeline(this);
        }
        requestCalcTimes();
    }

    public int nextAvailableEngineClipId() {
        int engineClipID;
        int engineClipID2;
        int engineClipID3;
        int i = 1000;
        for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
            if ((nexPrimaryTimelineItem instanceof NexVideoClipItem) && i <= (engineClipID3 = ((NexVideoClipItem) nexPrimaryTimelineItem).getEngineClipID())) {
                i = engineClipID3 + 1;
            }
        }
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            if ((nexSecondaryTimelineItem instanceof NexAudioClipItem) && i <= (engineClipID2 = ((NexAudioClipItem) nexSecondaryTimelineItem).getEngineClipID())) {
                i = engineClipID2 + 1;
            }
            if ((nexSecondaryTimelineItem instanceof VideoLayer) && i <= (engineClipID = ((VideoLayer) nexSecondaryTimelineItem).getEngineClipID())) {
                i = engineClipID + 1;
            }
        }
        return i;
    }

    public void recalculateResourceUsage() {
        if (this.f24123d != null || this.f24124e != null) {
            if (this.f24127h == null) {
                this.f24127h = new WeakHashMap<>();
            }
            this.f24123d = null;
            this.f24124e = null;
            this.f24127h.clear();
            this.f24122c++;
        }
        getResourceUsage();
    }

    public void registerTimeChangeCTSCallback(b bVar) {
        e().a((com.nexstreaming.app.general.util.u<b>) bVar);
    }

    public void release() {
        this.m_primaryItems.clear();
        this.m_secondaryItems.clear();
    }

    public void removeBookmark(int i) {
        if (this.m_bookmarks == null) {
            return;
        }
        a(i);
        this.m_bookmarks.remove(Integer.valueOf(i));
        this.k = null;
    }

    public void removeEmptyTracks() {
        List<com.nexstreaming.kinemaster.editorwrapper.Ea> list = this.m_tracks;
        if (list == null) {
            return;
        }
        ArrayList arrayList = null;
        for (com.nexstreaming.kinemaster.editorwrapper.Ea ea : list) {
            if (ea.b() == 0) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ea);
            }
        }
        if (arrayList != null) {
            this.m_tracks.removeAll(arrayList);
        }
    }

    public com.nexstreaming.kinemaster.editorwrapper.Ea removeTrack(int i) {
        List<com.nexstreaming.kinemaster.editorwrapper.Ea> list = this.m_tracks;
        if (list == null) {
            return null;
        }
        return list.remove(i);
    }

    public void requestCalcTimes() {
        b();
    }

    public void setAutoMaster(boolean z) {
        this.m_projectAutoMaster = z;
    }

    @Deprecated
    public void setCustomBGMusic(String str, String str2) {
        if (com.nexstreaming.app.general.util.J.a(this.m_customBackgroundMusicPath, str) == 0) {
            return;
        }
        this.m_customBackgroundMusicPath = str;
        this.m_customBackgroundMusicTitle = str2;
        NexAudioClipItem nexAudioClipItem = this.i;
        if (nexAudioClipItem != null) {
            nexAudioClipItem.setCustomBGMusic(this.m_customBackgroundMusicPath, this.m_customBackgroundMusicTitle);
        }
    }

    @Deprecated
    public void setMaxSimultaneousAudioTrackCount(int i) {
        this.m_simulAudioTracks = i;
    }

    public void setMediaStore(MediaStore mediaStore) {
        this.n = new WeakReference<>(mediaStore);
    }

    public void setProjectAspectRatioHeight(int i) {
        this.m_projectAspectRatioHeight = i;
    }

    public void setProjectAspectRatioWidth(int i) {
        this.m_projectAspectRatioWidth = i;
    }

    public void setProjectAudioFadeInTimeMillis(int i) {
        this.m_projectAudioFadeInTime = i / 1000.0f;
    }

    public void setProjectAudioFadeInTimeOn(boolean z) {
        this.m_isProjectAudioFadeInOn = z;
    }

    public void setProjectAudioFadeOutTimeMillis(int i) {
        this.m_projectAudioFadeOutTime = i / 1000.0f;
    }

    public void setProjectAudioFadeOutTimeOn(boolean z) {
        this.m_isProjectAudioFadeOutOn = z;
    }

    public void setProjectDefaultCropMode(NexVideoClipItem.CropMode cropMode) {
        this.m_projectDefaultCropMode = cropMode;
    }

    public void setProjectDefaultLayerDuration(int i) {
        this.m_projectDefaultLayerDuration = i;
    }

    public void setProjectDefaultPhotoDuration(int i) {
        this.m_projectDefaultPhotoDuration = i;
    }

    public void setProjectMasterVolume(int i) {
        this.m_projectMasterVolume = i;
    }

    public void setProjectRatio(ProjectAspectRatio projectAspectRatio) {
        this.m_projectRatio = projectAspectRatio;
    }

    public void setProjectVideoFadeInTimeMillis(int i) {
        this.m_projectVideoFadeInTime = i / 1000.0f;
    }

    public void setProjectVideoFadeInTimeOn(boolean z) {
        this.m_isProjectVideoFadeInOn = z;
    }

    public void setProjectVideoFadeOutTimeMillis(int i) {
        this.m_projectVideoFadeOutTime = i / 1000.0f;
    }

    public void setProjectVideoFadeOutTimeOn(boolean z) {
        this.m_isProjectVideoFadeOutOn = z;
    }

    public void setProjectheader(NexProjectHeader nexProjectHeader) {
        this.j = nexProjectHeader;
        NexProjectHeader nexProjectHeader2 = this.j;
        if (nexProjectHeader2.projectUUID == null) {
            nexProjectHeader2.projectUUID = UUID.randomUUID();
        }
    }

    public void setRecentScrollTime(int i) {
        this.m_recentScrollTime = i;
    }

    @Deprecated
    public void setThemeMusicMute(boolean z) {
        if (this.m_themeMusicEnable == (!z)) {
            return;
        }
        this.m_themeMusicEnable = !z;
        NexAudioClipItem nexAudioClipItem = this.i;
        if (nexAudioClipItem != null) {
            nexAudioClipItem.setMuteAudio(!this.m_themeMusicEnable);
        }
    }

    public void setThemeMusicVolume(int i) {
        if (this.m_themeMusicVolume == i) {
            return;
        }
        this.m_themeMusicVolume = i;
        NexAudioClipItem nexAudioClipItem = this.i;
        if (nexAudioClipItem != null) {
            nexAudioClipItem.setClipVolume(this.m_themeMusicVolume);
        }
    }

    public boolean toggleBookmark(int i) {
        a(i);
        if (isBookmark(i)) {
            removeBookmark(i);
            return false;
        }
        addBookmark(i);
        return true;
    }

    public void unregisterTimeChangeCTSCallback(b bVar) {
        e().b(bVar);
    }

    public void upgradeToLatestVersion(int i) {
        this.l = i;
        if (this.m_timelimeFormatVersion >= 6) {
            a();
            return;
        }
        Log.i("NexTimeline", "Upgrade " + this.m_timelimeFormatVersion + " to 6 (IN)");
        if (this.m_timelimeFormatVersion < 2) {
            String str = this.m_themeId;
            if (str == null && str.trim().length() < 1) {
                this.m_themeId = "com.nexstreaming.kinemaster.basic";
            } else if (!this.m_themeId.contains(".")) {
                String[][] strArr = {new String[]{"3D Theme", "com.nexstreaming.kinemaster.threed"}, new String[]{"Album Theme", "com.nexstreaming.kinemaster.album"}, new String[]{"km_theme_baby", "com.nexstreaming.kinemaster.baby"}, new String[]{"Basic Theme", "com.nexstreaming.kinemaster.basic"}, new String[]{"Cloudy Theme", "com.nexstreaming.kinemaster.cloudy"}, new String[]{"Energy", "com.nexstreaming.kinemaster.energy"}, new String[]{"Fun Theme", "com.nexstreaming.kinemaster.fun"}, new String[]{"Love Theme", "com.nexstreaming.kinemaster.love"}, new String[]{"Museum Theme", "com.nexstreaming.kinemaster.museum"}, new String[]{"km_theme_nature", "com.nexstreaming.kinemaster.nature"}, new String[]{"On-Stage Theme", "com.nexstreaming.kinemaster.onstage"}, new String[]{"Serene Theme", "com.nexstreaming.kinemaster.serene"}, new String[]{"Snow Theme", "com.nexstreaming.kinemaster.snow"}, new String[]{"Travel", "com.nexstreaming.kinemaster.travel"}};
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    String[] strArr2 = strArr[i2];
                    if (strArr2[0].equals(this.m_themeId)) {
                        this.m_themeId = strArr2[1];
                        break;
                    }
                    i2++;
                }
            }
        }
        if (this.m_timelimeFormatVersion < 3 && this.m_projectAudioFadeInTime == 0.0f && this.m_projectAudioFadeOutTime == 0.0f) {
            this.m_projectAudioFadeInTime = 0.2f;
            this.m_projectAudioFadeOutTime = 2.0f;
            this.m_isProjectAudioFadeInOn = false;
            this.m_isProjectAudioFadeOutOn = false;
        }
        if (this.m_timelimeFormatVersion < 4) {
            b();
            for (NexPrimaryTimelineItem nexPrimaryTimelineItem : this.m_primaryItems) {
                if (nexPrimaryTimelineItem instanceof NexTransitionItem) {
                    ((NexTransitionItem) nexPrimaryTimelineItem).updateOffsetOverlap();
                }
            }
            a(true);
        }
        if (this.m_timelimeFormatVersion < 5) {
            for (NexPrimaryTimelineItem nexPrimaryTimelineItem2 : this.m_primaryItems) {
                if (nexPrimaryTimelineItem2 instanceof NexVideoClipItem) {
                    NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexPrimaryTimelineItem2;
                    if (nexVideoClipItem.isPreset()) {
                        Rect rect = new Rect(3, 3, nexVideoClipItem.getWidth() - 3, nexVideoClipItem.getHeight() - 3);
                        nexVideoClipItem.setStartPosition(rect);
                        nexVideoClipItem.setEndPosition(rect);
                    }
                }
            }
        }
        if (this.m_timelimeFormatVersion < 6) {
            EffectAssetCompatMap a2 = EffectAssetCompatMap.a();
            com.nexstreaming.app.general.nexasset.assetpackage.h e2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e();
            for (Fa.a aVar : com.nexstreaming.app.general.util.t.a(this.m_primaryItems, this.m_secondaryItems)) {
                if (aVar instanceof NexTimelineItem.l) {
                    NexTimelineItem.l lVar = (NexTimelineItem.l) aVar;
                    String effectItemID = lVar.getEffectItemID();
                    int i3 = Pa.f24161a[a2.a(effectItemID).ordinal()];
                    if (i3 == 1) {
                        lVar.setEffectItem(null);
                    } else if (i3 == 2) {
                        lVar.setEffectItem(e2.a(a2.b(effectItemID)));
                    }
                }
            }
        }
        if (this.m_projectDefaultCropMode == null && this.m_projectDefaultLayerDuration <= 0 && this.m_projectDefaultPhotoDuration <= 0) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(KineMasterApplication.f24056d.getApplicationContext());
            this.m_projectDefaultLayerDuration = Integer.parseInt(defaultSharedPreferences.getString("add_layer_def_duration", "4500"));
            this.m_projectDefaultPhotoDuration = Integer.parseInt(defaultSharedPreferences.getString("add_img_def_duration", "4500"));
            this.m_projectDefaultCropMode = NexVideoClipItem.CropMode.fromString(defaultSharedPreferences.getString("add_img_def_crop", DEFAULT_PROJECT_PHOTO_CROP_MODE));
            this.m_projectAutoMaster = false;
            this.m_projectMasterVolume = 100;
        }
        Log.i("NexTimeline", "Upgrade " + this.m_timelimeFormatVersion + " to 6 (OUT)");
        this.m_timelimeFormatVersion = 6;
        a();
    }

    public boolean validateTimeline() {
        int secondaryItemCount = getSecondaryItemCount();
        int[] iArr = new int[3];
        for (int i = 0; i < iArr.length; i++) {
            iArr[i] = 0;
        }
        EditorGlobal.a aVar = null;
        boolean z = true;
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i2);
            int absStartTime = secondaryItem.getAbsStartTime();
            if (absStartTime < 0) {
                absStartTime = 0;
            }
            int absEndTime = secondaryItem.getAbsEndTime();
            int i3 = absEndTime - (absEndTime % 100);
            if (absStartTime > i3) {
                if (aVar == null) {
                    aVar = new EditorGlobal.a("timeline_validation");
                }
                aVar.a("NexTimeline", "validateTimeline() : PROBLEM FOUND -> startTime > endTime : itemIdx(" + i2 + ") startTime(" + absStartTime + ") endTime(" + i3 + ")");
                z = false;
            }
            int i4 = -1;
            for (int i5 = 0; i5 < iArr.length; i5++) {
                if (absStartTime >= iArr[i5] && i4 == -1) {
                    i4 = i5;
                }
            }
            if (i4 == -1) {
                if (aVar == null) {
                    aVar = new EditorGlobal.a("timeline_validation");
                }
                aVar.a("NexTimeline", "validateTimeline() : PROBLEM FOUND -> Too many secondary items : itemIdx(" + i2 + ") startTime(" + absStartTime + ")");
                z = false;
            } else {
                iArr[i4] = i3;
            }
        }
        if (!z) {
            dumpSecondaryTimeline(aVar);
        }
        return z;
    }

    public com.nexstreaming.kinemaster.editorwrapper.Ea addTrack(int i, com.nexstreaming.kinemaster.editorwrapper.Ea ea) {
        if (this.m_tracks == null) {
            this.m_tracks = new ArrayList();
        }
        this.m_tracks.add(i, ea);
        ea.a(this);
        return ea;
    }

    public int freeSpaceAtTime(int i, int i2, int i3, NexTimelineItem nexTimelineItem, int i4, boolean z) {
        int totalTime = getTotalTime();
        int secondaryItemCount = getSecondaryItemCount();
        int[] iArr = new int[i2];
        int i5 = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = 0;
        }
        int i7 = 0;
        for (int i8 = 0; i8 < secondaryItemCount; i8++) {
            NexSecondaryTimelineItem secondaryItem = getSecondaryItem(i8);
            if (secondaryItem != nexTimelineItem) {
                int absStartTime = secondaryItem.getAbsStartTime();
                int absEndTime = secondaryItem.getAbsEndTime();
                int i9 = -1;
                int i10 = 0;
                for (int i11 = 0; i11 < iArr.length; i11++) {
                    if (absStartTime >= iArr[i11]) {
                        i10++;
                        if (i9 == -1) {
                            i9 = i11;
                        }
                    }
                }
                if (i9 != -1) {
                    iArr[i9] = absEndTime;
                    if (i10 - 1 < 1) {
                        int i12 = iArr[0];
                        for (int i13 = 1; i13 < iArr.length; i13++) {
                            if (iArr[i13] < i12) {
                                i12 = iArr[i13];
                            }
                        }
                        if (!z) {
                            i5 = 0;
                            if (i12 < i) {
                                continue;
                            } else {
                                if (absStartTime <= i) {
                                    return 0;
                                }
                                if (absStartTime > i) {
                                    if (absStartTime > totalTime) {
                                        return Math.max(0, totalTime - i);
                                    }
                                    return Math.max(0, (absStartTime - i) - i3);
                                }
                            }
                        } else if (i12 < i) {
                            i7 = i12;
                        } else {
                            if (absStartTime <= i) {
                                return 0;
                            }
                            i5 = 0;
                            if (absStartTime > i) {
                                return (i - i7) - 1;
                            }
                        }
                    }
                }
                i5 = 0;
            }
        }
        return z ? Math.max(i5, (i - i7) - 1) : Math.max(i5, (totalTime - i) + i4);
    }

    public int getSecondaryItemCount(int i) {
        Iterator<NexSecondaryTimelineItem> it = this.m_secondaryItems.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            if (it.next().track_id == i) {
                i2++;
            }
        }
        return i2;
    }

    public boolean checkSecondaryItemLimits(com.nexstreaming.kinemaster.project.f fVar, int i) {
        int max;
        int absEndTime;
        if (this.f24125f == null) {
            this.f24125f = new com.nexstreaming.kinemaster.project.n();
        }
        this.f24125f.a();
        int size = this.m_secondaryItems.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            NexSecondaryTimelineItem nexSecondaryTimelineItem = this.m_secondaryItems.get(i2);
            if ((fVar == null || fVar.a(nexSecondaryTimelineItem)) && (max = Math.max(0, nexSecondaryTimelineItem.getAbsStartTime())) <= (absEndTime = nexSecondaryTimelineItem.getAbsEndTime())) {
                int i3 = 0;
                while (max < this.f24125f.b(i3)) {
                    i3++;
                }
                this.f24125f.a(i3, absEndTime);
                boolean z2 = i3 >= i;
                if (nexSecondaryTimelineItem.getOverLimit() != z2) {
                    nexSecondaryTimelineItem.setOverLimit(z2);
                    z = true;
                }
            }
        }
        return z;
    }

    private void a(boolean z) {
        int size = this.m_primaryItems.size();
        boolean z2 = false;
        for (int i = 0; i < size; i++) {
            if (this.m_primaryItems.get(i) instanceof NexTransitionItem) {
                NexTransitionItem nexTransitionItem = (NexTransitionItem) this.m_primaryItems.get(i);
                int transitionOverlap = nexTransitionItem.getTransitionOverlap();
                int transitionOffset = nexTransitionItem.getTransitionOffset();
                int duration = nexTransitionItem.getDuration();
                if (i > 0) {
                    NexPrimaryTimelineItem nexPrimaryTimelineItem = this.m_primaryItems.get(i - 1);
                    if (nexPrimaryTimelineItem instanceof NexVideoClipItem) {
                        NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexPrimaryTimelineItem;
                        int endOverlap = nexVideoClipItem.getEndOverlap();
                        if (z && transitionOffset < endOverlap) {
                            if (nexVideoClipItem.isImage()) {
                                nexVideoClipItem.setDuration(nexVideoClipItem.getDuration() - (endOverlap - transitionOffset));
                            } else {
                                nexVideoClipItem.setTrimEnd(nexVideoClipItem.getTrimTimeEnd() + (endOverlap - transitionOffset));
                            }
                            z2 = true;
                        }
                        if (transitionOffset != endOverlap) {
                            nexVideoClipItem.setEndOverlap(transitionOffset);
                            z2 = true;
                        }
                    }
                }
                int i2 = i + 1;
                if (i2 < size) {
                    NexPrimaryTimelineItem nexPrimaryTimelineItem2 = this.m_primaryItems.get(i2);
                    if (nexPrimaryTimelineItem2 instanceof NexVideoClipItem) {
                        NexVideoClipItem nexVideoClipItem2 = (NexVideoClipItem) nexPrimaryTimelineItem2;
                        int startOverlap = nexVideoClipItem2.getStartOverlap();
                        int i3 = (duration - transitionOffset) + transitionOverlap;
                        if (z && i3 < startOverlap) {
                            if (nexVideoClipItem2.isImage()) {
                                nexVideoClipItem2.setDuration(nexVideoClipItem2.getDuration() - (startOverlap - i3));
                            } else {
                                nexVideoClipItem2.setTrimStart(nexVideoClipItem2.getTrimTimeStart() + (startOverlap - i3));
                            }
                            z2 = true;
                        }
                        if (i3 != startOverlap) {
                            nexVideoClipItem2.setStartOverlap(i3);
                            z2 = true;
                        }
                    }
                }
            }
        }
        if (size > 0) {
            if (this.m_primaryItems.get(0).getStartOverlap() != 0) {
                ((NexVideoClipItem) this.m_primaryItems.get(0)).setStartOverlap(0);
                z2 = true;
            }
            int i4 = size - 1;
            if (this.m_primaryItems.get(i4).getEndOverlap() != 0) {
                ((NexVideoClipItem) this.m_primaryItems.get(i4)).setEndOverlap(0);
                z2 = true;
            }
        }
        int i5 = 0;
        for (int i6 = 0; i6 < size; i6++) {
            NexPrimaryTimelineItem nexPrimaryTimelineItem3 = this.m_primaryItems.get(i6);
            boolean z3 = nexPrimaryTimelineItem3 instanceof NexVideoClipItem;
            int startOverlap2 = z3 ? nexPrimaryTimelineItem3.getStartOverlap() : 0;
            int endOverlap2 = z3 ? nexPrimaryTimelineItem3.getEndOverlap() : 0;
            int i7 = i5 - startOverlap2;
            i5 += nexPrimaryTimelineItem3.getRepresentedDuration();
            if (nexPrimaryTimelineItem3.updateAbsStartEndTime(i7, endOverlap2 + i5)) {
                z2 = true;
            }
        }
        Collections.sort(this.m_secondaryItems);
        if (z2) {
            recalculateResourceUsage();
            this.f24121b++;
        }
    }

    public synchronized void deleteSecondaryItem(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        if (this.m_secondaryItems.contains(nexSecondaryTimelineItem)) {
            this.m_secondaryItems.remove(nexSecondaryTimelineItem);
            nexSecondaryTimelineItem.wasRemovedFromTimeline(this);
            requestCalcTimes();
        }
    }

    private synchronized void a(int i, NexPrimaryTimelineItem nexPrimaryTimelineItem, boolean z) {
        dumpPrimaryTimeline("NexTimeline", "addPrimaryItem/IN");
        if (!(nexPrimaryTimelineItem instanceof NexTransitionItem)) {
            int size = this.m_primaryItems.size();
            if (i == 0 && size == 0) {
                this.m_primaryItems.add(nexPrimaryTimelineItem);
                if (z) {
                    nexPrimaryTimelineItem.wasAddedToTimeline(this);
                }
            } else if (i > size && size % 2 == 1) {
                NexTransitionItem transition = this.m_primaryItems.get(size - 1).getTransition();
                this.m_primaryItems.add(size, transition);
                this.m_primaryItems.add(size + 1, nexPrimaryTimelineItem);
                if (z) {
                    nexPrimaryTimelineItem.wasAddedToTimeline(this);
                    transition.wasAddedToTimeline(this);
                }
            } else if (i % 2 == 0) {
                NexTransitionItem transition2 = nexPrimaryTimelineItem.getTransition();
                this.m_primaryItems.add(i, nexPrimaryTimelineItem.getTransition());
                this.m_primaryItems.add(i, nexPrimaryTimelineItem);
                if (z) {
                    nexPrimaryTimelineItem.wasAddedToTimeline(this);
                    transition2.wasAddedToTimeline(this);
                }
            } else {
                throw new IllegalStateException("Cannot add a clip between another clip and that clip's attached transition");
            }
            dumpPrimaryTimeline("NexTimeline", "addPrimaryItem/BCALC");
            requestCalcTimes();
            dumpPrimaryTimeline("NexTimeline", "addPrimaryItem/OUT");
        } else {
            throw new IllegalStateException("Cannot add a transition to a timeline explicitly");
        }
    }

    private void a(NexTimelineItem nexTimelineItem) {
        if (nexTimelineItem.getUniqueId() == null) {
            nexTimelineItem.setUniqueId(UUID.randomUUID());
        }
    }

    private synchronized void a(int i, boolean z) {
        if (i % 2 == 0) {
            int i2 = i + 1;
            if (i2 < this.m_primaryItems.size()) {
                NexPrimaryTimelineItem nexPrimaryTimelineItem = this.m_primaryItems.get(i);
                NexPrimaryTimelineItem nexPrimaryTimelineItem2 = this.m_primaryItems.get(i2);
                this.m_primaryItems.remove(i2);
                this.m_primaryItems.remove(i);
                if (z) {
                    nexPrimaryTimelineItem.wasRemovedFromTimeline(this);
                    nexPrimaryTimelineItem2.wasRemovedFromTimeline(this);
                }
                requestCalcTimes();
                return;
            }
            int i3 = i - 1;
            if (i3 >= 0) {
                NexPrimaryTimelineItem nexPrimaryTimelineItem3 = this.m_primaryItems.get(i);
                NexPrimaryTimelineItem nexPrimaryTimelineItem4 = this.m_primaryItems.get(i3);
                if (z) {
                    nexPrimaryTimelineItem3.wasRemovedFromTimeline(this);
                    nexPrimaryTimelineItem4.wasRemovedFromTimeline(this);
                }
                this.m_primaryItems.remove(i);
                this.m_primaryItems.remove(i3);
                requestCalcTimes();
                return;
            }
        }
        this.m_primaryItems.remove(i);
        requestCalcTimes();
    }

    private void a(NexEditor nexEditor) {
        Log.d("NexTimeline", "projectSettingsDone :: ProjectVolumeMaster :: " + this.m_projectAutoMaster + ", " + this.m_projectMasterVolume);
        nexEditor.setProjectManualVolumeControl(!this.m_projectAutoMaster ? 1 : 0);
        nexEditor.setProjectVolume(this.m_projectAutoMaster ? -1 : this.m_projectMasterVolume);
    }

    private void a() {
        int maxTrackId = getMaxTrackId();
        for (NexSecondaryTimelineItem nexSecondaryTimelineItem : this.m_secondaryItems) {
            int trackId = nexSecondaryTimelineItem.getTrackId();
            if (trackId < 1 || trackId > maxTrackId) {
                a(nexSecondaryTimelineItem);
            }
        }
    }

    private com.nexstreaming.kinemaster.editorwrapper.Ea a(NexSecondaryTimelineItem nexSecondaryTimelineItem) {
        if (this.m_tracks == null) {
            this.m_tracks = new ArrayList();
        }
        for (com.nexstreaming.kinemaster.editorwrapper.Ea ea : this.m_tracks) {
            if (ea.a(nexSecondaryTimelineItem)) {
                nexSecondaryTimelineItem.setTrackId(ea.c());
                return ea;
            }
        }
        com.nexstreaming.kinemaster.editorwrapper.Ea addTrack = addTrack(getTrackCount());
        nexSecondaryTimelineItem.setTrackId(addTrack.c());
        return addTrack;
    }
}
