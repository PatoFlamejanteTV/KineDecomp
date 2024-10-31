package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.FaceDetector;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActivityChooserView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.text.TextPaint;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1708l;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.MediaStore;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.C1916ib;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectedit.Vh;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.MediaPrepView;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nexstreaming.kinemaster.ui.widget.FXGripDrawingView;
import com.nexstreaming.kinemaster.ui.widget.KeyFrameDrawingView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexEditorUtils;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import com.nextreaming.nexvideoeditor.NexRectangle;
import com.nextreaming.nexvideoeditor.NexVisualClip;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class NexVideoClipItem extends NexPrimaryTimelineItem implements Vh, NexTimelineItem.e, NexTimelineItem.q, NexTimelineItem.u, NexTimelineItem.l, NexTimelineItem.f, NexTimelineItem.h, NexTimelineItem.g, NexTimelineItem.s, NexTimelineItem.b {
    public static final int ABSTRACT_DIMENSION = 100000;
    private static final long serialVersionUID = 2;

    /* renamed from: f, reason: collision with root package name */
    private transient Boolean f24143f;
    private transient boolean k;
    private int m_Brightness;
    private int m_Contrast;
    private int m_Saturation;
    private int m_TintColor;
    private boolean m_abstractCrop;
    private ColorEffect m_colorEffect;
    private boolean m_cropLink;
    private HashMap<String, String> m_effectOptions;
    private float[] m_endMatrix;
    private float m_faceBounds_bottom;
    private float m_faceBounds_left;
    private float m_faceBounds_right;
    private boolean m_faceBounds_set;
    private float m_faceBounds_top;
    private boolean m_isImage;
    private MediaStoreItemId m_mediaMSID;
    private int m_playbackSpeed;
    private float[] m_startMatrix;
    private String m_titleEffectID;
    private NexTransitionItem m_transition;
    private boolean m_useIFrameOnly;
    private boolean m_vignette;
    private ArrayList<Integer> m_volumeEnvelopeLevel;
    private ArrayList<Integer> m_volumeEnvelopeTime;
    private transient boolean n;
    private transient UUID p;
    private transient int q;

    /* renamed from: d, reason: collision with root package name */
    private static Rect f24141d = new Rect();

    /* renamed from: e, reason: collision with root package name */
    private static RectF f24142e = new RectF();
    public static int FLAG_FADE_IN = 1;
    public static int FLAG_FADE_OUT = 2;
    private int mAssetIdx = 0;
    private NexRectangle inRect = new NexRectangle(0, 0, 0, 0);
    private NexRectangle outRect = new NexRectangle(0, 0, 0, 0);
    private boolean settedKenBurns = false;
    private String m_captureFilename = null;
    private int m_engineClipID = 0;
    private int m_startPositionLeft = 0;
    private int m_startPositionBottom = 0;
    private int m_startPositionRight = 0;
    private int m_startPositionTop = 0;
    private int m_endPositionLeft = 0;
    private int m_endPositionBottom = 0;
    private int m_endPositionRight = 0;
    private int m_endPositionTop = 0;
    private int m_rotatedStartPositionLeft = 0;
    private int m_rotatedStartPositionBottom = 0;
    private int m_rotatedStartPositionRight = 0;
    private int m_rotatedStartPositionTop = 0;
    private int m_rotatedEndPositionLeft = 0;
    private int m_rotatedEndPositionBottom = 0;
    private int m_rotatedEndPositionRight = 0;
    private int m_rotatedEndPositionTop = 0;
    private int m_rotation = 0;
    private boolean m_fliph = false;
    private boolean m_flipv = false;

    @Deprecated
    private int m_diffAVDuration = 0;
    private int m_trimTimeStart = 0;
    private int m_trimTimeEnd = 0;
    private int m_trimmedDuration = 0;
    private int m_preTrimmedDuration = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private int m_titleStartTime = 0;
    private int m_titleEndTime = 0;
    private int m_duration = 0;
    private int m_audioDuration = 0;
    private int m_videoDuration = 0;
    private int m_startOverlap = 0;
    private int m_endOverlap = 0;
    private int m_width = 0;
    private int m_height = 0;
    private int m_originalWidth = 0;
    private int m_originalHeight = 0;
    private int m_clipVolume = 100;
    private int m_musicVolume = 100;
    private TitleStyle m_titleStyle = TitleStyle.NONE;

    /* renamed from: g, reason: collision with root package name */
    private transient WeakReference<Bitmap> f24144g = null;

    /* renamed from: h, reason: collision with root package name */
    private transient boolean f24145h = false;
    private boolean m_muteAudio = false;
    private boolean m_muteMusic = false;
    private boolean m_hasAudio = false;
    private boolean m_hasVideo = false;
    private String m_thumbPath = null;
    private String m_mediaPath = null;
    private boolean m_isReverse = false;
    private transient MediaInfo i = null;
    private transient com.nexstreaming.kinemaster.mediainfo.T j = null;
    private transient boolean l = false;
    private transient int[] m = null;
    private transient boolean o = false;
    private int m_effectStartTime = 0;
    private int m_effectEndTime = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    private float m_clipWidth = 0.0f;
    private int m_voiceChanger = 0;
    private int m_audioCompressor = 0;
    private int m_pitchFactor = 0;
    private int m_audioPanLeft = -111;
    private int m_audioPanRight = -111;
    private boolean m_keepPitch = false;
    private String m_enhancedAudioFilter = null;
    private String m_equalizer = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class ClipItemWrapper extends NexVideoClipItem {
        boolean isFreezeFrame;

        public ClipItemWrapper(boolean z) {
            this.isFreezeFrame = z;
        }
    }

    /* loaded from: classes.dex */
    public enum CropMode {
        FIT,
        FILL,
        PAN_RAND,
        PAN_FACE;

        public static CropMode fromString(String str) {
            if (str == null) {
                return FILL;
            }
            if (str.equalsIgnoreCase(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
                return FIT;
            }
            if (str.equalsIgnoreCase("fill")) {
                return FILL;
            }
            if (str.equalsIgnoreCase("panrand")) {
                return PAN_RAND;
            }
            if (str.equalsIgnoreCase("panface")) {
                return PAN_FACE;
            }
            return FILL;
        }

        public boolean needsFaceDetection() {
            return this == PAN_FACE;
        }

        @Override // java.lang.Enum
        public String toString() {
            int i = cb.f24223b[ordinal()];
            return i != 1 ? i != 2 ? i != 3 ? i != 4 ? NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE : "panface" : "panrand" : "fill" : NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum DragType {
        START,
        END,
        FXSTART,
        FXEND
    }

    /* loaded from: classes.dex */
    public enum TitleStyle {
        NONE,
        HEADLINE,
        OPENING,
        PLAYING,
        ENDING;

        public static TitleStyle fromInt(int i) {
            if (i == 0) {
                return NONE;
            }
            if (i == 1) {
                return HEADLINE;
            }
            if (i == 2) {
                return OPENING;
            }
            if (i == 3) {
                return PLAYING;
            }
            if (i != 4) {
                return NONE;
            }
            return ENDING;
        }

        public static TitleStyle fromProtoBuf(KMProto.KMProject.TitleStyle titleStyle) {
            int i = cb.f24226e[titleStyle.ordinal()];
            if (i == 1) {
                return NONE;
            }
            if (i == 2) {
                return HEADLINE;
            }
            if (i == 3) {
                return OPENING;
            }
            if (i == 4) {
                return PLAYING;
            }
            if (i != 5) {
                return NONE;
            }
            return ENDING;
        }

        public KMProto.KMProject.TitleStyle asProtoBuf() {
            int i = cb.f24225d[ordinal()];
            if (i == 1) {
                return KMProto.KMProject.TitleStyle.TITLE_STYLE_NONE;
            }
            if (i == 2) {
                return KMProto.KMProject.TitleStyle.TITLE_STYLE_HEADLINE;
            }
            if (i == 3) {
                return KMProto.KMProject.TitleStyle.TITLE_STYLE_OPENING;
            }
            if (i == 4) {
                return KMProto.KMProject.TitleStyle.TITLE_STYLE_PLAYING;
            }
            if (i != 5) {
                return KMProto.KMProject.TitleStyle.TITLE_STYLE_NONE;
            }
            return KMProto.KMProject.TitleStyle.TITLE_STYLE_ENDING;
        }

        public int toInt() {
            int i = cb.f24225d[ordinal()];
            if (i == 1) {
                return 0;
            }
            if (i == 2) {
                return 1;
            }
            if (i == 3) {
                return 2;
            }
            if (i != 4) {
                return i != 5 ? 0 : 4;
            }
            return 3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f24146a;

        /* renamed from: b, reason: collision with root package name */
        public int f24147b;

        /* renamed from: c, reason: collision with root package name */
        public int f24148c;

        /* renamed from: d, reason: collision with root package name */
        public int f24149d;

        private a() {
        }

        /* synthetic */ a(bb bbVar) {
            this();
        }
    }

    public NexVideoClipItem() {
        this.m_abstractCrop = false;
        this.m_transition = null;
        this.m_transition = new NexTransitionItem();
        this.m_abstractCrop = true;
        if (this.m_volumeEnvelopeTime == null) {
            this.m_volumeEnvelopeTime = new ArrayList<>();
        }
        if (this.m_volumeEnvelopeLevel == null) {
            this.m_volumeEnvelopeLevel = new ArrayList<>();
        }
    }

    private void a(Rect rect, float f2) {
        if (rect.width() / rect.height() < f2) {
            int height = (int) (rect.height() * f2);
            rect.left = rect.centerX() - (height / 2);
            rect.right = rect.left + height;
        } else {
            int width = (int) (rect.width() / f2);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = rect.top + width;
        }
    }

    private void b(Rect rect, float f2) {
        if (rect.width() / rect.height() < f2) {
            int width = (int) (rect.width() / f2);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = rect.top + width;
        } else {
            int height = (int) (rect.height() * f2);
            rect.left = rect.centerX() - (height / 2);
            rect.right = rect.left + height;
        }
    }

    private Bitmap c(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.timeline3_primaryTimelineHeight);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.timeline3_primaryMaxThumbWidth);
        WeakReference<Bitmap> weakReference = this.f24144g;
        Bitmap bitmap = weakReference != null ? weakReference.get() : null;
        if (bitmap == null && getTimeline() != null) {
            bitmap = getTimeline().getThumbnailCache().get(getUniqueId());
        }
        if ((bitmap != null && Math.abs(dimensionPixelSize - bitmap.getHeight()) <= 2) || !EditorGlobal.b(this.m_mediaPath)) {
            return bitmap;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.m_mediaPath, options);
        options.inJustDecodeBounds = false;
        float f2 = options.outWidth / options.outHeight;
        float f3 = dimensionPixelSize;
        NexImageLoader.b loadBitmap = NexImageLoader.loadBitmap(this.m_mediaPath, Math.min(dimensionPixelSize2, (int) (f2 * f3)) * 2, dimensionPixelSize * 2);
        Bitmap a2 = loadBitmap.a();
        this.m_originalWidth = loadBitmap.c();
        this.m_originalHeight = loadBitmap.b();
        if (a2 == null) {
            return a2;
        }
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(a2, Math.min(dimensionPixelSize2, (int) ((a2.getWidth() / a2.getHeight()) * f3)), dimensionPixelSize, true);
        if (getTimeline() != null) {
            getTimeline().getThumbnailCache().put(getUniqueId(), createScaledBitmap);
        }
        this.f24144g = new WeakReference<>(createScaledBitmap);
        return createScaledBitmap;
    }

    private void d() {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            if (this.m_startPositionLeft == this.m_startPositionRight || this.m_startPositionTop == this.m_startPositionBottom || this.m_endPositionLeft == this.m_endPositionRight || this.m_endPositionTop == this.m_endPositionBottom) {
                randomizeStartEndPosition(false, CropMode.FIT);
                return;
            }
            return;
        }
        if (this.m_rotatedStartPositionLeft == this.m_rotatedStartPositionRight || this.m_rotatedStartPositionTop == this.m_rotatedStartPositionBottom || this.m_rotatedEndPositionLeft == this.m_rotatedEndPositionRight || this.m_rotatedEndPositionTop == this.m_rotatedEndPositionBottom) {
            randomizeStartEndPosition(false, CropMode.FIT);
        }
    }

    private int e() {
        return this.m_preTrimmedDuration;
    }

    private boolean f() {
        return this.m_equalizer != null;
    }

    public static NexVideoClipItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        KMProto.KMProject.VisualClip visualClip = timelineItem.visual_clip;
        NexVideoClipItem nexVideoClipItem = new NexVideoClipItem(null);
        nexVideoClipItem.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        nexVideoClipItem.m_mediaPath = visualClip.media_path;
        nexVideoClipItem.m_engineClipID = visualClip.engine_clip_id.intValue();
        nexVideoClipItem.m_abstractCrop = visualClip.abstract_crop.booleanValue();
        nexVideoClipItem.m_rotation = visualClip.rotation.intValue();
        nexVideoClipItem.m_fliph = visualClip.fliph.booleanValue();
        nexVideoClipItem.m_flipv = visualClip.flipv.booleanValue();
        nexVideoClipItem.m_diffAVDuration = visualClip.diff_av_duration.intValue();
        nexVideoClipItem.m_trimmedDuration = visualClip.trimmed_duration.intValue();
        nexVideoClipItem.m_preTrimmedDuration = visualClip.pre_trimmed_duration.intValue();
        nexVideoClipItem.m_duration = visualClip.duration.intValue();
        nexVideoClipItem.m_audioDuration = visualClip.audio_duration.intValue();
        nexVideoClipItem.m_videoDuration = visualClip.video_duration.intValue();
        nexVideoClipItem.m_titleStartTime = visualClip.title_start_time.intValue();
        nexVideoClipItem.m_titleEndTime = visualClip.title_end_time.intValue();
        nexVideoClipItem.m_trimTimeStart = visualClip.trim_time_start.intValue();
        nexVideoClipItem.m_trimTimeEnd = visualClip.trim_time_end.intValue();
        nexVideoClipItem.m_startOverlap = visualClip.start_overlap.intValue();
        nexVideoClipItem.m_endOverlap = visualClip.end_overlap.intValue();
        nexVideoClipItem.m_clipVolume = visualClip.clip_volume.intValue();
        nexVideoClipItem.m_width = visualClip.width.intValue();
        nexVideoClipItem.m_height = visualClip.height.intValue();
        nexVideoClipItem.m_originalWidth = visualClip.original_width.intValue();
        nexVideoClipItem.m_originalHeight = visualClip.original_height.intValue();
        nexVideoClipItem.m_clipVolume = visualClip.clip_volume.intValue();
        nexVideoClipItem.m_musicVolume = visualClip.music_volume.intValue();
        nexVideoClipItem.m_titleStyle = TitleStyle.fromProtoBuf(visualClip.title_style);
        nexVideoClipItem.m_isImage = visualClip.is_image.booleanValue();
        nexVideoClipItem.m_muteAudio = visualClip.mute_audio.booleanValue();
        nexVideoClipItem.m_muteMusic = visualClip.mute_music.booleanValue();
        nexVideoClipItem.m_hasAudio = visualClip.has_audio.booleanValue();
        nexVideoClipItem.m_hasVideo = visualClip.has_video.booleanValue();
        nexVideoClipItem.m_transition = null;
        nexVideoClipItem.p = new UUID(visualClip.transition_item_uuid_msb.longValue(), visualClip.transition_item_uuid_lsb.longValue());
        nexVideoClipItem.m_Brightness = visualClip.brightness.intValue();
        nexVideoClipItem.m_Contrast = visualClip.contrast.intValue();
        nexVideoClipItem.m_Saturation = visualClip.saturation.intValue();
        nexVideoClipItem.m_TintColor = visualClip.tintcolor.intValue();
        nexVideoClipItem.m_effectStartTime = visualClip.effect_start_time.intValue();
        nexVideoClipItem.m_effectEndTime = visualClip.effect_end_time.intValue();
        nexVideoClipItem.m_startMatrix = C1708l.a(visualClip.start_matrix.element);
        nexVideoClipItem.m_endMatrix = C1708l.a(visualClip.end_matrix.element);
        nexVideoClipItem.m_playbackSpeed = visualClip.playback_speed.intValue();
        nexVideoClipItem.m_effectOptions = c.d.b.g.a.a(visualClip.effect_options);
        nexVideoClipItem.m_muteAudio = visualClip.mute_audio.booleanValue();
        nexVideoClipItem.m_volumeEnvelopeTime = new ArrayList<>(visualClip.volume_envelope_time);
        nexVideoClipItem.m_volumeEnvelopeLevel = new ArrayList<>(visualClip.volume_envelope_level);
        nexVideoClipItem.m_clipWidth = visualClip.clip_width.floatValue();
        KMProto.KMProject.ColorEffect colorEffect = visualClip.color_effect;
        nexVideoClipItem.m_colorEffect = colorEffect == null ? null : ColorEffect.fromProtoBuf(colorEffect);
        String str = visualClip.media_msid;
        nexVideoClipItem.m_mediaMSID = str != null ? new MediaStoreItemId(str) : null;
        nexVideoClipItem.m_titleEffectID = visualClip.title_effect_id;
        Boolean bool = visualClip.is_reverse;
        nexVideoClipItem.m_isReverse = bool == null ? false : bool.booleanValue();
        Boolean bool2 = visualClip.vignette;
        nexVideoClipItem.m_vignette = bool2 == null ? false : bool2.booleanValue();
        Integer num = visualClip.voice_changer;
        nexVideoClipItem.m_voiceChanger = num == null ? 0 : num.intValue();
        Integer num2 = visualClip.pan_left;
        nexVideoClipItem.m_audioPanLeft = num2 == null ? nexVideoClipItem.getAudioLeftVolume() : num2.intValue();
        Integer num3 = visualClip.pan_right;
        nexVideoClipItem.m_audioPanRight = num3 == null ? nexVideoClipItem.getAudioRightVolume() : num3.intValue();
        Integer num4 = visualClip.compressor;
        nexVideoClipItem.m_audioCompressor = num4 == null ? 0 : num4.intValue();
        Integer num5 = visualClip.pitch_factor;
        nexVideoClipItem.m_pitchFactor = num5 == null ? 0 : num5.intValue();
        nexVideoClipItem.m_enhancedAudioFilter = visualClip.enhancedAudioFilter;
        nexVideoClipItem.m_equalizer = visualClip.equalizer;
        KMProto.KMProject.TimelineItem timelineItem2 = visualClip.unattached_transition;
        if (timelineItem2 != null) {
            nexVideoClipItem.m_transition = NexTransitionItem.fromProtoBuf(timelineItem2);
        }
        Boolean bool3 = visualClip.useIFrameOnly;
        nexVideoClipItem.m_useIFrameOnly = bool3 == null ? nexVideoClipItem.hasUseIframeOnly() : bool3.booleanValue();
        Boolean bool4 = visualClip.keepPitch;
        nexVideoClipItem.m_keepPitch = bool4 == null ? nexVideoClipItem.hasKeepPitch() : bool4.booleanValue();
        Boolean bool5 = visualClip.crop_link;
        nexVideoClipItem.m_cropLink = bool5 != null ? bool5.booleanValue() : false;
        nexVideoClipItem.m_startPositionLeft = visualClip.start_position_left.intValue();
        nexVideoClipItem.m_startPositionTop = visualClip.start_position_top.intValue();
        nexVideoClipItem.m_startPositionRight = visualClip.start_position_right.intValue();
        nexVideoClipItem.m_startPositionBottom = visualClip.start_position_bottom.intValue();
        nexVideoClipItem.m_rotatedStartPositionLeft = visualClip.rotated_start_position_left.intValue();
        nexVideoClipItem.m_rotatedStartPositionTop = visualClip.rotated_start_position_top.intValue();
        nexVideoClipItem.m_rotatedStartPositionRight = visualClip.rotated_start_position_right.intValue();
        nexVideoClipItem.m_rotatedStartPositionBottom = visualClip.rotated_start_position_bottom.intValue();
        if (nexVideoClipItem.m_cropLink) {
            nexVideoClipItem.m_endPositionLeft = visualClip.start_position_left.intValue();
            nexVideoClipItem.m_endPositionTop = visualClip.start_position_top.intValue();
            nexVideoClipItem.m_endPositionRight = visualClip.start_position_right.intValue();
            nexVideoClipItem.m_endPositionBottom = visualClip.start_position_bottom.intValue();
            nexVideoClipItem.m_rotatedEndPositionLeft = visualClip.rotated_start_position_left.intValue();
            nexVideoClipItem.m_rotatedEndPositionTop = visualClip.rotated_start_position_top.intValue();
            nexVideoClipItem.m_rotatedEndPositionRight = visualClip.rotated_start_position_right.intValue();
            nexVideoClipItem.m_rotatedEndPositionBottom = visualClip.rotated_start_position_bottom.intValue();
        } else {
            nexVideoClipItem.m_endPositionLeft = visualClip.end_position_left.intValue();
            nexVideoClipItem.m_endPositionTop = visualClip.end_position_top.intValue();
            nexVideoClipItem.m_endPositionRight = visualClip.end_position_right.intValue();
            nexVideoClipItem.m_endPositionBottom = visualClip.end_position_bottom.intValue();
            nexVideoClipItem.m_rotatedEndPositionLeft = visualClip.rotated_end_position_left.intValue();
            nexVideoClipItem.m_rotatedEndPositionTop = visualClip.rotated_end_position_top.intValue();
            nexVideoClipItem.m_rotatedEndPositionRight = visualClip.rotated_end_position_right.intValue();
            nexVideoClipItem.m_rotatedEndPositionBottom = visualClip.rotated_end_position_bottom.intValue();
        }
        nexVideoClipItem.m_enhancedAudioFilter = visualClip.enhancedAudioFilter;
        nexVideoClipItem.m_equalizer = visualClip.equalizer;
        return nexVideoClipItem;
    }

    private boolean g() {
        return (getClipVolume() == 100 && !getMuteAudio() && getMusicVolume() == 100 && !isCheckedAudioCompressor() && getAudioRightVolume() == 100 && getAudioLeftVolume() == -100 && getAudioPitch() == 0) ? false : true;
    }

    private Bitmap h() {
        int i;
        if (isPreset()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.m_mediaPath, options);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        int i2 = options.outWidth;
        if (i2 < 1 || (i = options.outHeight) < 1) {
            return null;
        }
        int i3 = (i * 720) / i2;
        options.inSampleSize = 1;
        while (true) {
            int i4 = options.outHeight;
            int i5 = options.inSampleSize;
            double d2 = i4 / i5;
            double d3 = i3;
            Double.isNaN(d3);
            if (d2 <= d3 * 1.5d) {
                double d4 = options.outWidth / i5;
                double d5 = 720;
                Double.isNaN(d5);
                if (d4 <= d5 * 1.5d) {
                    break;
                }
            }
            options.inSampleSize *= 2;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(this.m_mediaPath, options);
        if (decodeFile == null) {
            return null;
        }
        int a2 = a(this.m_mediaPath);
        if (a2 != 0) {
            Matrix matrix = new Matrix();
            matrix.postRotate(a2);
            Bitmap createBitmap = Bitmap.createBitmap(decodeFile, 0, 0, decodeFile.getWidth(), decodeFile.getHeight(), matrix, true);
            decodeFile.recycle();
            decodeFile = createBitmap;
        }
        if (decodeFile.getConfig() == Bitmap.Config.RGB_565) {
            return decodeFile;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.RGB_565);
        new Canvas(createBitmap2).drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
        decodeFile.recycle();
        return createBitmap2;
    }

    private boolean isVolumeEnvelopeApplied() {
        for (int i = 0; i < getVolumeEnvelopeLength(); i++) {
            if (getVolumeEnvelopeLevel(i) != 100) {
                return true;
            }
        }
        return false;
    }

    public static NexVideoClipItem newInstance(int i, MediaStoreItemId mediaStoreItemId, boolean z) {
        ClipItemWrapper clipItemWrapper = new ClipItemWrapper(z);
        ((NexVideoClipItem) clipItemWrapper).m_mediaMSID = mediaStoreItemId;
        ((NexVideoClipItem) clipItemWrapper).m_engineClipID = i;
        return clipItemWrapper;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Collection<ProjectDependency> collection) {
        String str;
        com.nexstreaming.app.general.nexasset.assetpackage.r a2;
        String str2 = this.m_titleEffectID;
        if (str2 != null && str2.length() > 0 && !this.m_titleEffectID.equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE)) {
            collection.add(ProjectDependency.b(this.m_titleEffectID));
        }
        for (Map.Entry<String, String> entry : getEffectOptions().entrySet()) {
            if (entry.getKey().startsWith("text:") && entry.getValue().contains("\u001b") && entry.getValue().split("\u001b").length > 0 && (str = entry.getValue().split("\u001b")[0]) != null && !str.equals("null") && (a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(str)) != null && a2.getAssetPackage() != null) {
                collection.add(ProjectDependency.c(a2.getAssetPackage().getAssetIdx() + "/" + str));
            }
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public void addVolumeEnvelope(int i, int i2, int i3) {
        if (this.m_volumeEnvelopeTime == null) {
            this.m_volumeEnvelopeTime = new ArrayList<>();
        }
        if (this.m_volumeEnvelopeLevel == null) {
            this.m_volumeEnvelopeLevel = new ArrayList<>();
        }
        this.m_volumeEnvelopeTime.add(i, Integer.valueOf(i2));
        this.m_volumeEnvelopeLevel.add(i, Integer.valueOf(i3));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void applyFinalPath(MediaStoreItemId mediaStoreItemId, String str, CropMode cropMode, int i) {
        String str2;
        MediaStoreItemId mediaStoreItemId2 = this.m_mediaMSID;
        if (mediaStoreItemId2 == null || !mediaStoreItemId2.equals(mediaStoreItemId)) {
            return;
        }
        if (!str.equals(this.m_mediaPath)) {
            this.i = null;
            this.j = null;
            this.k = false;
        }
        this.m_mediaPath = str;
        this.m_mediaMSID = null;
        this.f24145h = isSolid() || ((str2 = this.m_mediaPath) != null && new File(str2).exists());
        this.l = false;
        MediaInfo a2 = MediaInfo.a(str);
        if (a2 != null) {
            this.q = a2.t();
            this.m_width = a2.R();
            this.m_height = a2.v();
            if (a2.U()) {
                this.m_isImage = false;
                this.m_duration = a2.r();
                this.m_hasAudio = getHasAudio();
                this.m_hasVideo = true;
                this.m_rotation = a2.z();
                randomizeStartEndPosition(false, CropMode.FIT);
                return;
            }
            if (a2.T()) {
                if (mediaStoreItemId.getNamespace().equals("Backgrounds")) {
                    this.m_isImage = true;
                    this.m_mediaMSID = null;
                    if (this.m_duration == 0) {
                        this.m_duration = i;
                    }
                    this.m_hasAudio = false;
                    this.m_hasVideo = false;
                    randomizeStartEndPosition(false, CropMode.FILL);
                    return;
                }
                if (b(str)) {
                    int i2 = this.m_width;
                    this.m_width = this.m_height;
                    this.m_height = i2;
                }
                this.m_isImage = true;
                if (this.m_duration == 0) {
                    this.m_duration = i;
                }
                this.m_hasAudio = false;
                this.m_hasVideo = true;
                if (((this instanceof ClipItemWrapper) && ((ClipItemWrapper) this).isFreezeFrame) || setKenBurns(i, cropMode)) {
                    return;
                }
                randomizeStartEndPosition(true, cropMode);
                return;
            }
            throw new IllegalStateException("Item has no video or image data " + String.valueOf(str));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x013b, code lost:            if (r13 == 0) goto L40;     */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0221  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.nextreaming.nexvideoeditor.NexAudioClip asNexAudioClip() {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexVideoClipItem.asNexAudioClip():com.nextreaming.nexvideoeditor.NexAudioClip");
    }

    public NexVisualClip asNexVisualClip() {
        NexVisualClip nexVisualClip = new NexVisualClip();
        nexVisualClip.mClipID = this.m_engineClipID;
        nexVisualClip.mClipType = this.m_isImage ? 1 : 4;
        nexVisualClip.mTotalTime = this.m_duration;
        nexVisualClip.mStartTime = getAbsStartTime();
        nexVisualClip.mEndTime = getAbsEndTime();
        nexVisualClip.mStartTrimTime = this.m_trimTimeStart;
        nexVisualClip.mEndTrimTime = this.m_trimTimeEnd;
        nexVisualClip.mWidth = this.m_width;
        nexVisualClip.mHeight = this.m_height;
        nexVisualClip.mExistVideo = this.m_hasVideo ? 1 : 0;
        nexVisualClip.mExistAudio = this.m_hasAudio ? 1 : 0;
        nexVisualClip.mTitle = getEncodedEffectOptions();
        nexVisualClip.mTitleStyle = this.m_titleStyle.toInt();
        nexVisualClip.mTitleStartTime = getStartOverlap() + getAbsStartTime();
        nexVisualClip.mTitleEndTime = getAbsEndTime() - getEndOverlap();
        nexVisualClip.mVoiceChanger = this.m_voiceChanger;
        nexVisualClip.mCompressor = this.m_audioCompressor;
        nexVisualClip.mPitchFactor = this.m_pitchFactor;
        nexVisualClip.mPanLeft = getAudioLeftVolume();
        nexVisualClip.mPanRight = getAudioRightVolume();
        com.nexstreaming.kinemaster.ui.projectedit.audioeffect.t tVar = new com.nexstreaming.kinemaster.ui.projectedit.audioeffect.t();
        nexVisualClip.mEnhancedAudioFilter = tVar.b(this.m_enhancedAudioFilter);
        nexVisualClip.mEqualizer = tVar.b(this.m_equalizer);
        if (this.m_colorEffect != null) {
            nexVisualClip.mBrightness = getCombinedBrightness();
            nexVisualClip.mContrast = getCombinedContrast();
            nexVisualClip.mSaturation = getCombinedSaturation();
            nexVisualClip.mTintcolor = this.m_colorEffect.getTintColor();
            nexVisualClip.mLUT = this.m_colorEffect.getLutResourceID();
            nexVisualClip.mVignette = this.m_vignette ? 1 : 0;
        } else {
            nexVisualClip.mBrightness = this.m_Brightness;
            nexVisualClip.mContrast = this.m_Contrast;
            nexVisualClip.mSaturation = this.m_Saturation;
            nexVisualClip.mTintcolor = this.m_TintColor;
            nexVisualClip.mLUT = 0;
            nexVisualClip.mVignette = this.m_vignette ? 1 : 0;
        }
        nexVisualClip.mBGMVolume = this.m_muteMusic ? 0 : this.m_musicVolume;
        nexVisualClip.mAudioOnOff = !this.m_muteAudio ? 1 : 0;
        nexVisualClip.mClipVolume = this.m_clipVolume;
        nexVisualClip.mEffectDuration = getTransition().getEngineDuration();
        nexVisualClip.mClipEffectID = getTransition().isSet() ? getTransition().getEffectItemID() : NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        nexVisualClip.mTitleEffectID = getEffectItemID();
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            nexVisualClip.mStartRect = new NexRectangle(this.m_startPositionLeft, this.m_startPositionTop, this.m_startPositionRight, this.m_startPositionBottom);
            if (this.m_cropLink) {
                nexVisualClip.mEndRect = new NexRectangle(this.m_startPositionLeft, this.m_startPositionTop, this.m_startPositionRight, this.m_startPositionBottom);
            } else {
                nexVisualClip.mEndRect = new NexRectangle(this.m_endPositionLeft, this.m_endPositionTop, this.m_endPositionRight, this.m_endPositionBottom);
            }
        } else {
            nexVisualClip.mStartRect = new NexRectangle(this.m_rotatedStartPositionLeft, this.m_rotatedStartPositionTop, this.m_rotatedStartPositionRight, this.m_rotatedStartPositionBottom);
            if (this.m_cropLink) {
                nexVisualClip.mEndRect = new NexRectangle(this.m_rotatedStartPositionLeft, this.m_rotatedStartPositionTop, this.m_rotatedStartPositionRight, this.m_rotatedStartPositionBottom);
            } else {
                nexVisualClip.mEndRect = new NexRectangle(this.m_rotatedEndPositionLeft, this.m_rotatedEndPositionTop, this.m_rotatedEndPositionRight, this.m_rotatedEndPositionBottom);
            }
        }
        nexVisualClip.mClipPath = this.m_mediaPath;
        nexVisualClip.mThumbnailPath = this.m_thumbPath;
        nexVisualClip.mRotateState = this.m_rotation;
        if (this.m_fliph) {
            nexVisualClip.mRotateState |= 65536;
        }
        if (this.m_flipv) {
            nexVisualClip.mRotateState |= 131072;
        }
        nexVisualClip.mEffectOffset = getTransition().getTransitionOffsetPercent();
        nexVisualClip.mEffectOverlap = getTransition().getTransitionOverlapPercent();
        int i2 = this.m_playbackSpeed;
        if (i2 == 0) {
            i2 = 100;
        }
        nexVisualClip.mSpeedControl = i2;
        nexVisualClip.mIframePlay = this.m_useIFrameOnly ? 1 : 0;
        nexVisualClip.mKeepPitch = this.m_keepPitch ? 1 : 0;
        if (getVolumeEnvelopeLevel(0) == -1) {
            int representedDuration = (((getRepresentedDuration() + getStartOverlap()) + getTrimTimeEnd()) + getTrimTimeStart()) - getDiffAVDuration();
            addVolumeEnvelope(0, 0, 100);
            addVolumeEnvelope(1, representedDuration, 100);
        }
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeLevel;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 2);
            ArrayList arrayList3 = new ArrayList(this.m_volumeEnvelopeLevel.size() + 2);
            int calcSplitClipFadeFlags = calcSplitClipFadeFlags();
            int i3 = (FLAG_FADE_IN & calcSplitClipFadeFlags) != 0 ? 150 : 0;
            int i4 = (calcSplitClipFadeFlags & FLAG_FADE_OUT) == 0 ? 0 : 150;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (i5 < this.m_volumeEnvelopeLevel.size()) {
                int volumeEnvelopeTimeAdj = getVolumeEnvelopeTimeAdj(i5);
                int volumeEnvelopeLevel = getVolumeEnvelopeLevel(i5);
                if (volumeEnvelopeTimeAdj >= this.m_startOverlap) {
                    int representedDuration2 = getRepresentedDuration();
                    int i8 = this.m_startOverlap;
                    if (volumeEnvelopeTimeAdj < representedDuration2 + i8) {
                        if (i8 <= 0 && arrayList2.isEmpty()) {
                            if (i3 > 0) {
                                arrayList2.add(0);
                                arrayList3.add(0);
                            }
                            int i9 = (int) ((((i3 - i6) / (volumeEnvelopeTimeAdj - i6)) * (volumeEnvelopeLevel - i7)) + i7);
                            int i10 = this.m_trimTimeStart;
                            if (i10 <= 0 && i10 <= 0 && volumeEnvelopeTimeAdj == 0) {
                                int i11 = i5 + 1;
                                i9 = (int) ((((i3 + 0) / (getVolumeEnvelopeTimeAdj(i11) - 0)) * (getVolumeEnvelopeLevel(i11) - volumeEnvelopeLevel)) + volumeEnvelopeLevel);
                            }
                            if (i9 > 200) {
                                i9 = 200;
                            }
                            if (i9 < 0) {
                                i9 = 0;
                            }
                            arrayList2.add(Integer.valueOf(i3));
                            arrayList3.add(Integer.valueOf(i9));
                            if (volumeEnvelopeTimeAdj == 0) {
                                i5++;
                                i6 = volumeEnvelopeTimeAdj;
                                i7 = volumeEnvelopeLevel;
                            }
                        } else if (this.m_startOverlap > 0 && arrayList2.isEmpty()) {
                            arrayList2.add(0);
                            arrayList3.add(0);
                            arrayList2.add(Integer.valueOf(this.m_startOverlap));
                            arrayList3.add(Integer.valueOf((int) ((((r11 - i6) / (volumeEnvelopeTimeAdj - i6)) * (volumeEnvelopeLevel - i7)) + i7)));
                        }
                        if (volumeEnvelopeTimeAdj >= this.m_startOverlap) {
                            arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                            arrayList3.add(Integer.valueOf(volumeEnvelopeLevel));
                        }
                        i5++;
                        i6 = volumeEnvelopeTimeAdj;
                        i7 = volumeEnvelopeLevel;
                    }
                }
                int representedDuration3 = getRepresentedDuration();
                int i12 = this.m_startOverlap;
                if (volumeEnvelopeTimeAdj >= representedDuration3 + i12) {
                    if (i12 <= 0 && arrayList2.isEmpty()) {
                        if (i3 > 0) {
                            arrayList2.add(0);
                            arrayList3.add(0);
                        }
                        arrayList2.add(Integer.valueOf(i3));
                        arrayList3.add(Integer.valueOf((int) ((((i3 - i6) / (volumeEnvelopeTimeAdj - i6)) * (volumeEnvelopeLevel - i7)) + i7)));
                    } else if (this.m_startOverlap > 0 && arrayList2.isEmpty()) {
                        arrayList2.add(0);
                        arrayList3.add(0);
                        arrayList2.add(Integer.valueOf(this.m_startOverlap));
                        arrayList3.add(Integer.valueOf((int) ((((r11 - i6) / (volumeEnvelopeTimeAdj - i6)) * (volumeEnvelopeLevel - i7)) + i7)));
                    }
                    int i13 = this.m_endOverlap;
                    if (i13 <= 0) {
                        arrayList2.add(Integer.valueOf((getRepresentedDuration() + this.m_startOverlap) - i4));
                        arrayList3.add(Integer.valueOf((int) ((((((getRepresentedDuration() + this.m_startOverlap) - i4) - i6) / (volumeEnvelopeTimeAdj - i6)) * (volumeEnvelopeLevel - i7)) + i7)));
                        if (i4 > 0) {
                            arrayList2.add(Integer.valueOf(getRepresentedDuration() + this.m_startOverlap));
                            arrayList3.add(0);
                        }
                    } else if (i13 > 0) {
                        arrayList2.add(Integer.valueOf(getRepresentedDuration() + this.m_startOverlap));
                        arrayList3.add(Integer.valueOf((int) (((((getRepresentedDuration() + this.m_startOverlap) - i6) / (volumeEnvelopeTimeAdj - i6)) * (volumeEnvelopeLevel - i7)) + i7)));
                        arrayList2.add(Integer.valueOf(getRepresentedDuration() + this.m_startOverlap + this.m_endOverlap));
                        arrayList3.add(0);
                    }
                }
                i5++;
                i6 = volumeEnvelopeTimeAdj;
                i7 = volumeEnvelopeLevel;
            }
            nexVisualClip.mVolumeEnvelopeTime = com.nexstreaming.app.general.util.q.a(arrayList2);
            nexVisualClip.mVolumeEnvelopeLevel = com.nexstreaming.app.general.util.q.a(arrayList3);
        }
        return nexVisualClip;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.VisualClip.Builder builder = new KMProto.KMProject.VisualClip.Builder();
        String str = this.m_captureFilename;
        if (str != null) {
            builder.capture_filename(str);
        }
        String str2 = this.m_titleEffectID;
        if (str2 != null) {
            builder.title_effect_id(str2);
        }
        MediaStoreItemId mediaStoreItemId = this.m_mediaMSID;
        if (mediaStoreItemId != null) {
            builder.media_msid(mediaStoreItemId.toString());
        }
        String str3 = this.m_thumbPath;
        if (str3 != null) {
            builder.thumb_path(str3);
        }
        ColorEffect colorEffect = this.m_colorEffect;
        if (colorEffect != null) {
            builder.color_effect(colorEffect.asProtoBuf());
        }
        NexTransitionItem nexTransitionItem = this.m_transition;
        if (nexTransitionItem != null && nexTransitionItem.getTimeline() == null) {
            builder.unattached_transition(this.m_transition.asProtoBuf());
        }
        builder.engine_clip_id(Integer.valueOf(this.m_engineClipID)).abstract_crop(Boolean.valueOf(this.m_abstractCrop)).start_position_left(Integer.valueOf(this.m_startPositionLeft)).start_position_bottom(Integer.valueOf(this.m_startPositionBottom)).start_position_top(Integer.valueOf(this.m_startPositionTop)).start_position_right(Integer.valueOf(this.m_startPositionRight)).end_position_bottom(Integer.valueOf(this.m_endPositionBottom)).end_position_top(Integer.valueOf(this.m_endPositionTop)).end_position_left(Integer.valueOf(this.m_endPositionLeft)).end_position_right(Integer.valueOf(this.m_endPositionRight)).rotated_start_position_left(Integer.valueOf(this.m_rotatedStartPositionLeft)).rotated_start_position_bottom(Integer.valueOf(this.m_rotatedStartPositionBottom)).rotated_start_position_top(Integer.valueOf(this.m_rotatedStartPositionTop)).rotated_start_position_right(Integer.valueOf(this.m_rotatedStartPositionRight)).rotated_end_position_bottom(Integer.valueOf(this.m_rotatedEndPositionBottom)).rotated_end_position_top(Integer.valueOf(this.m_rotatedEndPositionTop)).rotated_end_position_left(Integer.valueOf(this.m_rotatedEndPositionLeft)).rotated_end_position_right(Integer.valueOf(this.m_rotatedEndPositionRight)).rotation(Integer.valueOf(this.m_rotation)).fliph(Boolean.valueOf(this.m_fliph)).flipv(Boolean.valueOf(this.m_flipv)).diff_av_duration(Integer.valueOf(this.m_diffAVDuration)).trim_time_start(Integer.valueOf(this.m_trimTimeStart)).trim_time_end(Integer.valueOf(this.m_trimTimeEnd)).trimmed_duration(Integer.valueOf(this.m_trimmedDuration)).pre_trimmed_duration(Integer.valueOf(this.m_preTrimmedDuration)).title_start_time(Integer.valueOf(this.m_titleStartTime)).title_end_time(Integer.valueOf(this.m_titleEndTime)).duration(Integer.valueOf(this.m_duration)).audio_duration(Integer.valueOf(this.m_audioDuration)).video_duration(Integer.valueOf(this.m_videoDuration)).start_overlap(Integer.valueOf(this.m_startOverlap)).end_overlap(Integer.valueOf(this.m_endOverlap)).width(Integer.valueOf(this.m_width)).height(Integer.valueOf(this.m_height)).original_width(Integer.valueOf(this.m_originalWidth)).original_height(Integer.valueOf(this.m_originalHeight)).clip_volume(Integer.valueOf(this.m_clipVolume)).music_volume(Integer.valueOf(this.m_musicVolume)).title_style(this.m_titleStyle.asProtoBuf()).is_image(Boolean.valueOf(this.m_isImage)).mute_audio(Boolean.valueOf(this.m_muteAudio)).mute_music(Boolean.valueOf(this.m_muteMusic)).has_audio(Boolean.valueOf(this.m_hasAudio)).has_video(Boolean.valueOf(this.m_hasVideo)).media_path(this.m_mediaPath).transition_item_uuid_lsb(Long.valueOf(getTransition().getUniqueId().getLeastSignificantBits())).transition_item_uuid_msb(Long.valueOf(getTransition().getUniqueId().getMostSignificantBits())).brightness(Integer.valueOf(this.m_Brightness)).contrast(Integer.valueOf(this.m_Contrast)).saturation(Integer.valueOf(this.m_Saturation)).tintcolor(Integer.valueOf(this.m_TintColor)).effect_start_time(Integer.valueOf(this.m_effectStartTime)).effect_end_time(Integer.valueOf(this.m_effectEndTime)).start_matrix(a(this.m_startMatrix)).end_matrix(a(this.m_endMatrix)).volume_envelope_time(this.m_volumeEnvelopeTime).volume_envelope_level(this.m_volumeEnvelopeLevel).clip_width(Float.valueOf(this.m_clipWidth)).playback_speed(Integer.valueOf(this.m_playbackSpeed)).crop_link(Boolean.valueOf(this.m_cropLink)).effect_options(c.d.b.g.a.a(this.m_effectOptions)).is_reverse(Boolean.valueOf(this.m_isReverse)).vignette(Boolean.valueOf(this.m_vignette)).voice_changer(Integer.valueOf(this.m_voiceChanger)).pan_left(Integer.valueOf(getAudioLeftVolume())).pan_right(Integer.valueOf(getAudioRightVolume())).compressor(Integer.valueOf(this.m_audioCompressor)).pitch_factor(Integer.valueOf(this.m_pitchFactor)).useIFrameOnly(Boolean.valueOf(this.m_useIFrameOnly)).keepPitch(Boolean.valueOf(this.m_keepPitch)).enhancedAudioFilter(this.m_enhancedAudioFilter).equalizer(this.m_equalizer);
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.VISUAL_CLIP).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).visual_clip(builder.build()).build();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.x beginTrim(NexTimelineItem.y yVar, int i) {
        int i2;
        if (i == 0) {
            return null;
        }
        if (this.m_isImage) {
            i2 = this.m_duration;
        } else if (i == 1) {
            i2 = this.m_trimTimeStart;
        } else {
            i2 = this.m_trimTimeEnd;
        }
        return new gb(this, i, i2, yVar);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        int i;
        super.bindView(view, interfaceC2028i);
        VideoEditor c2 = interfaceC2028i.c();
        ClipThumbView clipThumbView = (ClipThumbView) view.findViewById(R.id.thumbnail_view);
        if (!checkResourceState(view.getContext())) {
            clipThumbView.setImageBitmaps(null);
            clipThumbView.setImageBitmap(null);
            clipThumbView.setImageResource(R.drawable.n2_missingfile_icon_small);
        } else if (interfaceC2028i.d() != null && isImage() && !isSolid()) {
            if (clipThumbView.a() && this.m_mediaPath.equals(clipThumbView.getPath())) {
                clipThumbView.a(this);
            } else {
                clipThumbView.a(this.m_mediaPath, this);
                clipThumbView.setImageBitmaps(null);
                clipThumbView.setImageBitmap(null);
                clipThumbView.setImageResource(R.drawable.n2_loading_image_1_img);
                interfaceC2028i.d().a("large:" + getMediaPath(), clipThumbView, (Bitmap) null);
            }
        } else if (isVideo()) {
            if (clipThumbView.b() && this.m_mediaPath.equals(clipThumbView.getPath())) {
                clipThumbView.a(this);
            } else {
                clipThumbView.a(this.m_mediaPath, this);
                clipThumbView.setImageBitmaps(null);
                clipThumbView.setImageBitmap(null);
                clipThumbView.setImageResource(0);
                _a _aVar = new _a(this);
                clipThumbView.setImageBitmap(b(view.getContext()));
                _aVar.a(this.m_mediaPath, clipThumbView);
            }
        } else if (!isVideo()) {
            clipThumbView.a(getSolidColor(), this.m_mediaPath, this);
            clipThumbView.setImageBitmaps(null);
            clipThumbView.setImageBitmap(null);
            clipThumbView.setImageResource(0);
        }
        if (isSolid()) {
            i = R.drawable.n3_timeline_clip_solid;
        } else if (isImage()) {
            i = R.drawable.n3_timeline_clip_image;
        } else {
            i = this.m_isReverse ? R.drawable.n3_timeline_clip_reverse : R.drawable.n3_timeline_clip_video;
        }
        ((ImageView) view.findViewById(R.id.clip_type_icon)).setImageResource(i);
        View findViewById = view.findViewById(R.id.mute_icon);
        TextView textView = (TextView) view.findViewById(R.id.playback_text);
        if (isVideo()) {
            textView.setText(" " + (getPlaybackSpeed() / 100.0f) + FragmentC2201x.f23219a);
            if (getHasAudio() && getMuteAudio()) {
                findViewById.setVisibility(0);
            } else {
                findViewById.setVisibility(8);
            }
        } else {
            findViewById.setVisibility(8);
            textView.setVisibility(8);
        }
        if (isVideo()) {
            KeyFrameDrawingView keyFrameDrawingView = (KeyFrameDrawingView) view.findViewById(R.id.key_frame_drawing_view);
            if (interfaceC2028i.a() && interfaceC2028i.b() == R.id.editmode_volume_adjust) {
                keyFrameDrawingView.a(this, getRepresentedDuration(), getTrimTimeStart(), getPlaybackSpeed(), view);
                keyFrameDrawingView.setVisibility(0);
            } else {
                keyFrameDrawingView.setVisibility(8);
            }
        }
        FXGripDrawingView fXGripDrawingView = (FXGripDrawingView) view.findViewById(R.id.fx_grip_view);
        if (interfaceC2028i.a() && interfaceC2028i.b() == R.id.editmode_fxtime) {
            fXGripDrawingView.setVisibility(0);
            fXGripDrawingView.a(this.m_effectStartTime, this.m_effectEndTime, getRepresentedDuration(), view);
            fXGripDrawingView.setListener(new ab(this, c2));
        } else {
            fXGripDrawingView.setVisibility(8);
            fXGripDrawingView.setListener(null);
        }
        MediaPrepView mediaPrepView = (MediaPrepView) view.findViewById(R.id.media_prep_view);
        if (mediaPrepView != null) {
            mediaPrepView.setTimelineItem(this);
        }
    }

    public int calcPos(int i, int i2, int i3) {
        if (i < i2) {
            return i + (((i2 - i) * i3) / 100);
        }
        return i - (((i - i2) * i3) / 100);
    }

    public int calcSplitClipFadeFlags() {
        NexVideoClipItem nextClip = getNextClip();
        NexVideoClipItem previousClip = getPreviousClip();
        int i = (nextClip == null || !nextClip.sameMediaAs(this) || (nextClip == null ? 0 : Math.abs(nextClip.getTrimTimeStart() - (getDuration() - getTrimTimeEnd()))) >= 10) ? FLAG_FADE_OUT | 0 : 0;
        return (previousClip == null || !previousClip.sameMediaAs(this) || (previousClip != null ? Math.abs(getTrimTimeStart() - (previousClip.getDuration() - previousClip.getTrimTimeEnd())) : 0) >= 10) ? i | FLAG_FADE_IN : i;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public void changeVolumeLevel(int i, int i2) {
        this.m_volumeEnvelopeLevel.set(i, Integer.valueOf(i2));
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

    public void checkEffectTime(int i, int i2, int i3) {
        int playbackSpeed;
        int trimTimeStart = getTrimTimeStart();
        if (i3 == 3) {
            if (i2 < 0) {
                playbackSpeed = getEffectDuration();
            } else {
                playbackSpeed = ((i2 * 100) / getPlaybackSpeed()) - ((i * 100) / getPlaybackSpeed());
            }
            if (playbackSpeed < 100) {
                setEffectTiming((i * 100) / getPlaybackSpeed(), 100);
                return;
            }
            int playbackSpeed2 = (i * 100) / getPlaybackSpeed();
            if (i2 >= 0) {
                playbackSpeed = (i2 * 100) / getPlaybackSpeed();
            }
            setEffectTiming(playbackSpeed2, playbackSpeed);
            return;
        }
        if (isImage() && i3 == 1) {
            int representedDuration = getRepresentedDuration();
            if (i < representedDuration && i2 > representedDuration) {
                setEffectTiming(0, (i2 - i) - (representedDuration - i));
                return;
            }
            if (representedDuration < i && representedDuration < i2) {
                setEffectTiming(i - representedDuration, i2 - representedDuration);
                return;
            } else if (i < representedDuration && i2 <= representedDuration) {
                setEffectTiming(i, i2);
                return;
            } else {
                setEffectTiming(0, representedDuration);
                return;
            }
        }
        if (isImage() && i3 == 2) {
            int duration = getDuration();
            int e2 = e();
            if (i2 == Integer.MAX_VALUE) {
                setEffectTiming(i, duration);
                i2 = getEffectEndTime();
            }
            if (i < duration && i2 > duration) {
                setEffectTiming(i, duration);
            } else if (duration <= i || duration <= i2) {
                setEffectTiming(0, duration);
            } else if (e2 == i2) {
                setEffectTiming(i, duration);
            } else {
                setEffectTiming(i, i2);
            }
            f(duration);
            return;
        }
        int playbackSpeed3 = (trimTimeStart * 100) / getPlaybackSpeed();
        if (i3 == 1) {
            if (i < playbackSpeed3 && i2 > playbackSpeed3) {
                setEffectTiming(0, i2 - playbackSpeed3);
                return;
            }
            if (i < playbackSpeed3 && i2 < playbackSpeed3) {
                setEffectTiming(0, getRepresentedDuration());
                return;
            } else {
                if (i <= playbackSpeed3 || i2 <= playbackSpeed3) {
                    return;
                }
                setEffectTiming(i - playbackSpeed3, (i2 - i) - (playbackSpeed3 - i));
                return;
            }
        }
        if (i3 == 2) {
            int representedDuration2 = getRepresentedDuration();
            if (i < representedDuration2 && i2 > representedDuration2) {
                if (representedDuration2 < 100) {
                    setEffectTiming(i, 100);
                    return;
                } else {
                    setEffectTiming(i, getRepresentedDuration());
                    return;
                }
            }
            if (i > representedDuration2 && i2 > representedDuration2) {
                setEffectTiming(0, getRepresentedDuration());
            } else {
                if (i >= representedDuration2 || i2 >= representedDuration2) {
                    return;
                }
                setEffectTiming(i, i2);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:            r0 = new java.io.File(r12.getFilesDir(), ".km_bg");        r0.mkdirs();        r1 = new java.io.File(r0, r7);        r12 = r12.getAssets().open(com.nexstreaming.kinemaster.mediastore.item.a.m() + "/" + r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00be, code lost:            r0 = new java.io.FileOutputStream(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00c5, code lost:            r1 = new byte[10240];     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c7, code lost:            r3 = r12.read(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00cc, code lost:            if (r3 <= (-1)) goto L61;     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00ce, code lost:            r0.write(r1, 0, r3);     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00d5, code lost:            r12.close();        r11.f24145h = new java.io.File(r11.m_mediaPath).exists();     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e6, code lost:            r1 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e7, code lost:            r0.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00ea, code lost:            throw r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00eb, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00ec, code lost:            r12.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ef, code lost:            throw r0;     */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkResourceState(android.content.Context r12) {
        /*
            Method dump skipped, instructions count: 255
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexVideoClipItem.checkResourceState(android.content.Context):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x01a8 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void copyOptions(com.nextreaming.nexeditorui.NexVideoClipItem r14) {
        /*
            Method dump skipped, instructions count: 446
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexVideoClipItem.copyOptions(com.nextreaming.nexeditorui.NexVideoClipItem):void");
    }

    public void copyStartEndRect(NexVideoClipItem nexVideoClipItem) {
        if (nexVideoClipItem != null && getWidth() == nexVideoClipItem.getWidth() && getHeight() == nexVideoClipItem.getHeight()) {
            Rect rect = new Rect();
            nexVideoClipItem.getStartRectRaw(rect, true);
            this.m_rotatedStartPositionLeft = rect.left;
            this.m_rotatedStartPositionTop = rect.top;
            this.m_rotatedStartPositionRight = rect.right;
            this.m_rotatedStartPositionBottom = rect.bottom;
            nexVideoClipItem.getStartRectRaw(rect, false);
            this.m_startPositionLeft = rect.left;
            this.m_startPositionTop = rect.top;
            this.m_startPositionRight = rect.right;
            this.m_startPositionBottom = rect.bottom;
            nexVideoClipItem.getEndRectRaw(rect, true);
            this.m_rotatedEndPositionLeft = rect.left;
            this.m_rotatedEndPositionTop = rect.top;
            this.m_rotatedEndPositionRight = rect.right;
            this.m_rotatedEndPositionBottom = rect.bottom;
            nexVideoClipItem.getEndRectRaw(rect, false);
            this.m_endPositionLeft = rect.left;
            this.m_endPositionTop = rect.top;
            this.m_endPositionRight = rect.right;
            this.m_endPositionBottom = rect.bottom;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f2, NexTimelineItem.i iVar, boolean z3, float f3, int i, int i2, List<ob> list, NexTimelineItem.r rVar) {
        a(context, canvas, rectF, rectF2, paint, z, z2, f2, iVar, z3, f3, i, i2, rVar);
        throw null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioCompressor() {
        return this.m_audioCompressor;
    }

    public int getAudioDuration() {
        return this.m_audioDuration;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioLeftVolume() {
        if (this.m_audioPanLeft < -100) {
            MediaInfo a2 = MediaInfo.a(getMediaPath());
            if (a2 != null && a2.m() >= 2) {
                this.m_audioPanLeft = -100;
            } else if (a2 != null && a2.m() == 1) {
                this.m_audioPanLeft = 0;
            } else {
                this.m_audioPanLeft = 0;
            }
        }
        return this.m_audioPanLeft;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioPitch() {
        return this.m_pitchFactor;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioRightVolume() {
        MediaInfo a2 = MediaInfo.a(getMediaPath());
        if (a2 != null && a2.m() == 1) {
            this.m_audioPanRight = getAudioLeftVolume();
            return this.m_audioPanRight;
        }
        if (this.m_audioPanRight < -100) {
            this.m_audioPanRight = 100;
        }
        return this.m_audioPanRight;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAudioTrackUsage() {
        return (!getHasAudio() || getMuteAudio() || getClipVolume() <= 0) ? 0 : 1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getBrightness() {
        return this.m_Brightness;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public String getCaptureFilename() {
        return this.m_captureFilename;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getClipVolume() {
        return this.m_clipVolume;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.h
    public ColorEffect getColorEffect() {
        return this.m_colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public int getColorOption(int i) {
        if (i == R.id.opt_color) {
            return getSolidColor();
        }
        return super.getColorOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public int getCombinedBrightness() {
        ColorEffect colorEffect = this.m_colorEffect;
        if (colorEffect == null) {
            return this.m_Brightness;
        }
        return this.m_Brightness + ((int) (colorEffect.getBrightness() * 255.0f));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public int getCombinedContrast() {
        ColorEffect colorEffect = this.m_colorEffect;
        if (colorEffect == null) {
            return this.m_Contrast;
        }
        return this.m_Contrast + ((int) (colorEffect.getContrast() * 255.0f));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public int getCombinedSaturation() {
        ColorEffect colorEffect = this.m_colorEffect;
        if (colorEffect == null) {
            return this.m_Saturation;
        }
        return this.m_Saturation + ((int) (colorEffect.getSaturation() * 255.0f));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getContentWeight() {
        if (isVideo()) {
            return CapabilityManager.a(getWidth(), getHeight(), getPlaybackSpeed(), getFPS());
        }
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getContrast() {
        return this.m_Contrast;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        MediaInfo mediaInfo;
        int originalWidth = getOriginalWidth();
        int originalHeight = getOriginalHeight();
        if (isVideo() && (mediaInfo = this.i) != null) {
            originalWidth = mediaInfo.D();
            originalHeight = this.i.C();
        }
        if (isSolid()) {
            int solidColor = getSolidColor();
            return context.getResources().getString(R.string.solid_clip_rgb, Integer.valueOf(Color.red(solidColor)), Integer.valueOf(Color.green(solidColor)), Integer.valueOf(Color.blue(solidColor)));
        }
        if (isImage()) {
            return originalWidth + "×" + originalHeight + " (" + EditorGlobal.b(getDuration()) + ")";
        }
        int trimTimeStart = getTrimTimeStart();
        int trimTimeEnd = getTrimTimeEnd();
        if (trimTimeStart == 0 && trimTimeEnd == 0) {
            return originalWidth + "×" + originalHeight + "  " + EditorGlobal.b(getDuration());
        }
        return originalWidth + "×" + originalHeight + "  " + EditorGlobal.b((getDuration() - trimTimeStart) - trimTimeEnd) + " " + context.getResources().getString(R.string.video_trimmed);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        if (isSolid()) {
            return context.getString(R.string.solid_color_clip);
        }
        String str = this.m_mediaPath;
        return str == null ? "" : new File(str).getName();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getDiffAVDuration() {
        return Math.min(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, getDuration() - getVideoDuration());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        return this.m_duration;
    }

    public String getEffectAssetID() {
        int indexOf;
        String str = this.m_titleEffectID;
        if (str != null && (indexOf = str.indexOf(47)) > 0) {
            return this.m_titleEffectID.substring(0, indexOf - 1);
        }
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public int getEffectAssetIdx() {
        return this.mAssetIdx;
    }

    public int getEffectDuration() {
        return Math.min(getRepresentedDuration(), this.m_effectEndTime - this.m_effectStartTime);
    }

    public int getEffectEndTime() {
        return this.m_effectEndTime;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public String getEffectID() {
        return this.m_titleEffectID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public String getEffectItemID() {
        String str = this.m_titleEffectID;
        if (str == null) {
            return null;
        }
        return str.substring(str.indexOf(47) + 1);
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem.l
    public Map<String, String> getEffectOptions() {
        if (this.m_effectOptions == null) {
            this.m_effectOptions = new HashMap<>();
        }
        return this.m_effectOptions;
    }

    public int getEffectStartTime() {
        return this.m_effectStartTime;
    }

    public String getEncodedEffectOptions() {
        return getEncodedEffectOptions(true);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getEndEnvelopeTime() {
        return (((getRepresentedDuration() + getStartOverlap()) + getTrimTimeEnd()) + getTrimTimeStart()) - getDiffAVDuration();
    }

    public void getEndMatrix(Matrix matrix) {
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        matrix.setValues(this.m_endMatrix);
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getEndOverlap() {
        return this.m_endOverlap;
    }

    public void getEndPosition(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            long j = this.m_endPositionBottom;
            int i2 = this.m_height;
            rect.bottom = (int) ((j * i2) / 100000);
            long j2 = this.m_endPositionLeft;
            int i3 = this.m_width;
            rect.left = (int) ((j2 * i3) / 100000);
            rect.right = (int) ((this.m_endPositionRight * i3) / 100000);
            rect.top = (int) ((this.m_endPositionTop * i2) / 100000);
            return;
        }
        long j3 = this.m_rotatedEndPositionBottom;
        int i4 = this.m_width;
        rect.bottom = (int) ((j3 * i4) / 100000);
        long j4 = this.m_rotatedEndPositionLeft;
        int i5 = this.m_height;
        rect.left = (int) ((j4 * i5) / 100000);
        rect.right = (int) ((this.m_rotatedEndPositionRight * i5) / 100000);
        rect.top = (int) ((this.m_rotatedEndPositionTop * i4) / 100000);
    }

    public void getEndPositionRaw(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            rect.bottom = this.m_endPositionBottom;
            rect.left = this.m_endPositionLeft;
            rect.right = this.m_endPositionRight;
            rect.top = this.m_endPositionTop;
            return;
        }
        rect.bottom = this.m_rotatedEndPositionBottom;
        rect.left = this.m_rotatedEndPositionLeft;
        rect.right = this.m_rotatedEndPositionRight;
        rect.top = this.m_rotatedEndPositionTop;
    }

    public void getEndRectRaw(Rect rect, boolean z) {
        if (z) {
            rect.left = this.m_rotatedEndPositionLeft;
            rect.top = this.m_rotatedEndPositionTop;
            rect.right = this.m_rotatedEndPositionRight;
            rect.bottom = this.m_rotatedEndPositionBottom;
            return;
        }
        rect.left = this.m_endPositionLeft;
        rect.top = this.m_endPositionTop;
        rect.right = this.m_endPositionRight;
        rect.bottom = this.m_endPositionBottom;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getEndThumbnail(int i) {
        if (!isSolid() && !isImage()) {
            ResultTask<Bitmap> resultTask = new ResultTask<>();
            if (this.i == null) {
                String str = this.m_mediaPath;
                this.i = str == null ? null : MediaInfo.a(new File(str));
            }
            MediaInfo mediaInfo = this.i;
            if (mediaInfo == null) {
                resultTask.sendFailure(Task.makeTaskError("Unable to get media info"));
                return resultTask;
            }
            mediaInfo.w().onResultAvailable(new Xa(this, resultTask)).onFailure((Task.OnFailListener) new Wa(this, resultTask));
            return resultTask;
        }
        return getStartThumbnail(i);
    }

    public int getEngineClipID() {
        return this.m_engineClipID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public String getEqualizer() {
        return this.m_equalizer;
    }

    public int getFPS() {
        MediaInfo a2;
        if (isImage()) {
            return 0;
        }
        if (this.q == 0) {
            String str = this.m_mediaPath;
            if (str == null || (a2 = MediaInfo.a(str)) == null) {
                return 30;
            }
            this.q = a2.t();
            if (this.q <= 0) {
                return 30;
            }
        }
        return this.q;
    }

    public void getFaceBounds(Rect rect) {
        com.nexstreaming.kinemaster.ui.c.b a2 = com.nexstreaming.kinemaster.ui.c.b.a(this.m_mediaPath);
        if (a2 != null) {
            RectF rectF = new RectF();
            a2.a(rectF);
            float width = getWidth();
            float height = getHeight();
            rect.set((int) (rectF.left * width), (int) (rectF.top * height), (int) (rectF.right * width), (int) (rectF.bottom * height));
            return;
        }
        a();
        if (!this.m_faceBounds_set) {
            rect.setEmpty();
            return;
        }
        float width2 = getWidth();
        float height2 = getHeight();
        rect.set((int) (this.m_faceBounds_left * width2), (int) (this.m_faceBounds_top * height2), (int) (this.m_faceBounds_right * width2), (int) (this.m_faceBounds_bottom * height2));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public FileType.FileCategory getFileCategory() {
        return isVideo() ? FileType.FileCategory.Video : FileType.FileCategory.Image;
    }

    public int getFirstRepresentedTime() {
        return this.m_startOverlap + this.m_trimTimeStart;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public boolean getFlipH() {
        return this.m_fliph;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public boolean getFlipV() {
        return this.m_flipv;
    }

    public boolean getHasAudio() {
        return this.m_hasAudio;
    }

    public int getHeight() {
        return this.m_height;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public MediaStoreItemId getMediaMSID() {
        return this.m_mediaMSID;
    }

    public String getMediaPath() {
        return this.m_mediaPath;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public int getMusicVolume() {
        return this.m_musicVolume;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean getMuteAudio() {
        return this.m_muteAudio;
    }

    public boolean getMuteMusic() {
        return this.m_muteMusic;
    }

    public NexVideoClipItem getNextClip() {
        int indexOfPrimaryItem;
        NexPrimaryTimelineItem primaryItem;
        if (getTimeline() != null && (indexOfPrimaryItem = getTimeline().getIndexOfPrimaryItem(this) + 2) < getTimeline().getPrimaryItemCount() && (primaryItem = getTimeline().getPrimaryItem(indexOfPrimaryItem)) != null && (primaryItem instanceof NexVideoClipItem)) {
            return (NexVideoClipItem) primaryItem;
        }
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int[] getOptionMenuItems() {
        if (isSolid()) {
            return new int[]{R.id.opt_color, R.id.opt_split_trim, R.id.opt_clip_effect_expand, R.id.opt_color_filter, R.id.opt_color_adj, R.id.opt_vignette};
        }
        if (isImage()) {
            return new int[]{R.id.opt_split_trim, R.id.opt_img_crop, R.id.opt_rotate, R.id.opt_clip_effect_expand, R.id.opt_color_filter, R.id.opt_color_adj, R.id.opt_vignette};
        }
        if (isVideo() && Build.VERSION.SDK_INT >= 18) {
            return new int[]{R.id.opt_split_trim, R.id.opt_vid_crop, R.id.opt_volume_and_balance, R.id.opt_clip_effect_expand, R.id.opt_speed_control, R.id.opt_reverse, R.id.opt_rotate, R.id.opt_color_filter, R.id.opt_color_adj, R.id.opt_audio_eq, R.id.opt_volume_env, R.id.opt_audio_voice_changer, R.id.opt_vignette, R.id.opt_extract_audio};
        }
        return new int[]{R.id.opt_split_trim, R.id.opt_vid_crop, R.id.opt_volume_and_balance, R.id.opt_clip_effect_expand, R.id.opt_speed_control, R.id.opt_rotate, R.id.opt_color_filter, R.id.opt_color_adj, R.id.opt_audio_eq, R.id.opt_volume_env, R.id.opt_audio_voice_changer, R.id.opt_vignette, R.id.opt_extract_audio};
    }

    public int getOriginalHeight() {
        int i = this.m_originalHeight;
        return i > 0 ? i : this.m_height;
    }

    public int getOriginalWidth() {
        int i = this.m_originalWidth;
        return i > 0 ? i : this.m_width;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getPixelWidth(float f2, float f3) {
        if (!isClipReady()) {
            int representedDuration = (int) ((getRepresentedDuration() * f2) / 1000.0f);
            float f4 = representedDuration;
            return (f4 <= 80.0f * f3 || f4 >= 200.0f * f3) ? (int) (f3 * 120.0f) : representedDuration;
        }
        int representedDuration2 = (int) ((getRepresentedDuration() * f2) / 1000.0f);
        float f5 = f3 * 20.0f;
        return ((float) representedDuration2) < f5 ? (int) f5 : representedDuration2;
    }

    public int getPlaybackSpeed() {
        int i = this.m_playbackSpeed;
        if (i == 0) {
            return 100;
        }
        return i;
    }

    public NexTransitionItem getPrecedingTransition() {
        int indexOfPrimaryItem;
        NexPrimaryTimelineItem primaryItem;
        if (getTimeline() != null && (indexOfPrimaryItem = getTimeline().getIndexOfPrimaryItem(this)) > 0 && (primaryItem = getTimeline().getPrimaryItem(indexOfPrimaryItem - 1)) != null && (primaryItem instanceof NexTransitionItem)) {
            return (NexTransitionItem) primaryItem;
        }
        return null;
    }

    public NexVideoClipItem getPreviousClip() {
        int indexOfPrimaryItem;
        NexPrimaryTimelineItem primaryItem;
        if (getTimeline() != null && (indexOfPrimaryItem = getTimeline().getIndexOfPrimaryItem(this)) > 1 && (primaryItem = getTimeline().getPrimaryItem(indexOfPrimaryItem - 2)) != null && (primaryItem instanceof NexVideoClipItem)) {
            return (NexVideoClipItem) primaryItem;
        }
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        return getRepresentedDuration(0);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDurationWithoutOverlap() {
        return (this.m_duration - this.m_trimTimeStart) - this.m_trimTimeEnd;
    }

    public int getRepresentedDurationWithoutSpeedControl() {
        return (((this.m_duration - this.m_startOverlap) - this.m_endOverlap) - this.m_trimTimeStart) - this.m_trimTimeEnd;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public int getRotation() {
        return this.m_rotation;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getSaturation() {
        return this.m_Saturation;
    }

    public Bitmap getSmallThumbnailForTime(int i, float f2, float f3, Context context, NexTimelineItem.r rVar) {
        a(rVar);
        int absStartTime = (getAbsStartTime() - getStartOverlap()) - getTrimTimeStart();
        int absEndTime = getAbsEndTime() + getEndOverlap() + getTrimTimeEnd();
        int i2 = i < absStartTime ? 0 : i > absEndTime ? absEndTime - absStartTime : i - absStartTime;
        if (!this.f24145h) {
            return ((BitmapDrawable) context.getResources().getDrawable(R.drawable.n2_missingfile_icon_small)).getBitmap();
        }
        Bitmap b2 = b(context);
        if (b2 != null) {
            return b2;
        }
        com.nexstreaming.kinemaster.mediainfo.T t = this.j;
        if (t != null) {
            return t.b(this.m_rotation, i2, this.m_fliph, this.m_flipv);
        }
        return null;
    }

    public int getSolidColor() {
        if (isSolid()) {
            return (int) Long.parseLong(this.m_mediaPath.substring(7, 15), 16);
        }
        return 0;
    }

    public void getStartMatrix(Matrix matrix) {
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        matrix.setValues(this.m_startMatrix);
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getStartOverlap() {
        return this.m_startOverlap;
    }

    public void getStartPosition(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            long j = this.m_startPositionBottom;
            int i2 = this.m_height;
            rect.bottom = (int) ((j * i2) / 100000);
            long j2 = this.m_startPositionLeft;
            int i3 = this.m_width;
            rect.left = (int) ((j2 * i3) / 100000);
            rect.right = (int) ((this.m_startPositionRight * i3) / 100000);
            rect.top = (int) ((this.m_startPositionTop * i2) / 100000);
            return;
        }
        long j3 = this.m_rotatedStartPositionBottom;
        int i4 = this.m_width;
        rect.bottom = (int) ((j3 * i4) / 100000);
        long j4 = this.m_rotatedStartPositionLeft;
        int i5 = this.m_height;
        rect.left = (int) ((j4 * i5) / 100000);
        rect.right = (int) ((this.m_rotatedStartPositionRight * i5) / 100000);
        rect.top = (int) ((this.m_rotatedStartPositionTop * i4) / 100000);
    }

    public void getStartPositionRaw(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            rect.bottom = this.m_startPositionBottom;
            rect.left = this.m_startPositionLeft;
            rect.right = this.m_startPositionRight;
            rect.top = this.m_startPositionTop;
            return;
        }
        rect.bottom = this.m_rotatedStartPositionBottom;
        rect.left = this.m_rotatedStartPositionLeft;
        rect.right = this.m_rotatedStartPositionRight;
        rect.top = this.m_rotatedStartPositionTop;
    }

    public void getStartRectRaw(Rect rect, boolean z) {
        if (z) {
            rect.left = this.m_rotatedStartPositionLeft;
            rect.top = this.m_rotatedStartPositionTop;
            rect.right = this.m_rotatedStartPositionRight;
            rect.bottom = this.m_rotatedStartPositionBottom;
            return;
        }
        rect.left = this.m_startPositionLeft;
        rect.top = this.m_startPositionTop;
        rect.right = this.m_startPositionRight;
        rect.bottom = this.m_startPositionBottom;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getStartThumbnail(int i) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        if (isSolid()) {
            Bitmap createBitmap = Bitmap.createBitmap((i * 16) / 9, i, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(getSolidColor());
            resultTask.sendResult(createBitmap);
        } else if (isImage()) {
            File file = new File(this.m_mediaPath);
            if (!file.exists()) {
                resultTask.sendFailure(Task.makeTaskError("File not found"));
                return resultTask;
            }
            new Ta(this, file, i, resultTask).executeOnExecutor(EditorGlobal.D, new Void[0]);
        } else {
            if (this.i == null) {
                String str = this.m_mediaPath;
                this.i = str == null ? null : MediaInfo.a(new File(str));
            }
            MediaInfo mediaInfo = this.i;
            if (mediaInfo == null) {
                resultTask.sendFailure(Task.makeTaskError("Unable to get media info"));
                return resultTask;
            }
            mediaInfo.x().onResultAvailable(new Va(this, resultTask)).onFailure((Task.OnFailListener) new Ua(this, resultTask));
        }
        return resultTask;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        if (i == R.id.opt_vignette) {
            return this.m_vignette;
        }
        return super.getSwitchOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getThumbnail(Context context) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        Bitmap b2 = b(context);
        if (b2 != null) {
            String str = this.m_mediaPath;
            File file = str == null ? null : new File(str);
            if (EditorGlobal.b(this.m_mediaPath) && file.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.m_mediaPath, options);
                int i = (options.outHeight * ModuleDescriptor.MODULE_VERSION) / options.outWidth;
                String str2 = this.m_mediaPath;
                double d2 = ModuleDescriptor.MODULE_VERSION;
                Double.isNaN(d2);
                double d3 = i;
                Double.isNaN(d3);
                Bitmap a2 = NexImageLoader.loadBitmap(str2, (int) (d2 * 2.5d), (int) (d3 * 2.5d)).a();
                if (a2 != null) {
                    Bitmap rotateAndFlipImage = NexImageLoader.rotateAndFlipImage(a2, (360 - this.m_rotation) % 360, this.m_fliph, this.m_flipv);
                    int l = (int) (ModuleDescriptor.MODULE_VERSION / EditorGlobal.l());
                    Bitmap createBitmap = Bitmap.createBitmap(ModuleDescriptor.MODULE_VERSION, l, Bitmap.Config.RGB_565);
                    Rect rect = new Rect();
                    int i2 = this.m_rotation;
                    if (i2 != 90 && i2 != 270) {
                        rect.bottom = (this.m_startPositionBottom * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                        rect.left = (this.m_startPositionLeft * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.right = (this.m_startPositionRight * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.top = (this.m_startPositionTop * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                    } else {
                        rect.bottom = (this.m_rotatedStartPositionBottom * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                        rect.left = (this.m_rotatedStartPositionLeft * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.right = (this.m_rotatedStartPositionRight * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.top = (this.m_rotatedStartPositionTop * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                    }
                    new Canvas(createBitmap).drawBitmap(rotateAndFlipImage, rect, new Rect(0, 0, ModuleDescriptor.MODULE_VERSION, l), (Paint) null);
                    resultTask.setResult(createBitmap);
                    resultTask.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
                    return resultTask;
                }
            }
            resultTask.setResult(b2);
            resultTask.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return resultTask;
        }
        if (this.i == null && !isImage() && !isSolid()) {
            String str3 = this.m_mediaPath;
            this.i = str3 != null ? MediaInfo.a(new File(str3)) : null;
        }
        MediaInfo mediaInfo = this.i;
        if (mediaInfo != null) {
            mediaInfo.x().onResultAvailable(new Za(this, resultTask)).onFailure((Task.OnFailListener) new Ya(this, resultTask));
            return resultTask;
        }
        resultTask.signalEvent(Task.Event.FAIL);
        return resultTask;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return isImage() ? R.layout.timeline_item_primary_image : R.layout.timeline_item_primary_visual;
    }

    public int getTintColor() {
        return this.m_TintColor;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public NexTransitionItem getTransition() {
        if (this.m_transition == null && this.p != null) {
            NexTimeline timeline = getTimeline();
            if (timeline != null) {
                this.m_transition = (NexTransitionItem) timeline.findItemByUniqueId(this.p);
                if (this.m_transition == null) {
                    throw new RuntimeException("cannot find transition");
                }
            } else {
                throw new RuntimeException("null timeline");
            }
        } else {
            NexTransitionItem nexTransitionItem = this.m_transition;
            if (nexTransitionItem != null && this.p == null) {
                this.p = nexTransitionItem.getUniqueId();
            } else if (this.m_transition == null) {
                this.m_transition = new NexTransitionItem();
            }
        }
        return this.m_transition;
    }

    public int getTrimTimeEnd() {
        return this.m_trimTimeEnd;
    }

    public int getTrimTimeStart() {
        return this.m_trimTimeStart;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getUIEndTime() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline != null && (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this) + 1) < timeline.getPrimaryItemCount()) {
            NexPrimaryTimelineItem primaryItem = timeline.getPrimaryItem(indexOfPrimaryItem);
            if (primaryItem instanceof NexTransitionItem) {
                return getAbsEndTime() - (((NexTransitionItem) primaryItem).getTransitionOverlap() / 2);
            }
        }
        return getAbsEndTime();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getUIStartTime() {
        int indexOfPrimaryItem;
        NexTimeline timeline = getTimeline();
        if (timeline != null && (indexOfPrimaryItem = timeline.getIndexOfPrimaryItem(this)) > 0) {
            NexPrimaryTimelineItem primaryItem = timeline.getPrimaryItem(indexOfPrimaryItem - 1);
            if (primaryItem instanceof NexTransitionItem) {
                return getAbsStartTime() + (((NexTransitionItem) primaryItem).getTransitionOverlap() / 2);
            }
        }
        return getAbsStartTime();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecExportMemoryUsage() {
        if (isVideo()) {
            return CapabilityManager.a(getWidth(), getHeight());
        }
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecLegacyMemoryUsage() {
        if (isVideo()) {
            return ((((((getWidth() * getHeight()) * 150) / 100) * Math.max(30, getFPS())) / 30) * 100) / Math.max(100, getPlaybackSpeed());
        }
        return 0;
    }

    public int getVideoDuration() {
        return this.m_videoDuration;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoTrackUsage() {
        return isVideo() ? 1 : 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public String getVoiceChanger() {
        if (this.m_voiceChanger != 0) {
            String a2 = new com.nexstreaming.kinemaster.ui.projectedit.audioeffect.t().a(this.m_voiceChanger);
            this.m_voiceChanger = 0;
            return a2;
        }
        return this.m_enhancedAudioFilter;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeLength() {
        return this.m_volumeEnvelopeTime.size();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeLevel(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeLevel;
        if (arrayList == null || arrayList.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeLevel.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeTime(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null) {
            return -1;
        }
        return arrayList.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeTimeAdj(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null) {
            return -1;
        }
        return ((arrayList.get(i).intValue() - getTrimTimeStart()) * 100) / getPlaybackSpeed();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeTimeForDrawing(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null) {
            return -1;
        }
        return (((arrayList.get(i).intValue() - getTrimTimeStart()) * 100) / getPlaybackSpeed()) - getStartOverlap();
    }

    public int getWidth() {
        return this.m_width;
    }

    public boolean hasDataInMainTextField() {
        String str = getEffectOptions().get("text:f_text");
        return str == null || str.trim().length() < 1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean hasDependencyFromAsset(String str) {
        return getEffectAssetID() != null && getEffectAssetID().equals(str);
    }

    public boolean hasKeepPitch() {
        return this.m_keepPitch;
    }

    public boolean hasUseIframeOnly() {
        return this.m_useIFrameOnly;
    }

    public boolean isAdjustedPosition() {
        int i = this.m_rotation;
        return (((i != 90 && i != 270) || (this.m_rotatedStartPositionLeft == 0 && this.m_rotatedStartPositionTop == 0 && this.m_rotatedStartPositionRight == 100000 && this.m_rotatedStartPositionBottom == 100000 && this.m_rotatedEndPositionLeft == 0 && this.m_rotatedEndPositionTop == 0 && this.m_rotatedEndPositionRight == 100000 && this.m_rotatedEndPositionBottom == 100000)) && this.m_startPositionLeft == 0 && this.m_startPositionTop == 0 && this.m_startPositionRight == 100000 && this.m_startPositionBottom == 100000 && this.m_endPositionLeft == 0 && this.m_endPositionTop == 0 && this.m_endPositionRight == 100000 && this.m_endPositionBottom == 100000) ? false : true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean isCheckedAudioCompressor() {
        return this.m_audioCompressor > 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isClipReady() {
        return this.m_mediaMSID == null;
    }

    public boolean isCropLink() {
        return this.m_cropLink;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.InterfaceC1732b
    public boolean isDraggable() {
        return true;
    }

    public boolean isImage() {
        return this.m_isImage;
    }

    @Deprecated
    public boolean isLogoClip() {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_audio_eq /* 2131363088 */:
                return f();
            case R.id.opt_audio_voice_changer /* 2131363091 */:
                return isVoiceChangerApplied();
            case R.id.opt_clip_effect_expand /* 2131363102 */:
                return getEffectItemID() != null && getEffectItemID().length() > 0;
            case R.id.opt_color /* 2131363103 */:
                return false;
            case R.id.opt_color_adj /* 2131363104 */:
                return (getBrightness() == 0 && getContrast() == 0 && getSaturation() == 0) ? false : true;
            case R.id.opt_color_filter /* 2131363106 */:
            case R.id.opt_color_tint /* 2131363107 */:
                return (getColorEffect() == null || getColorEffect().equals(ColorEffect.NONE)) ? false : true;
            case R.id.opt_img_crop /* 2131363118 */:
                return isAdjustedPosition();
            case R.id.opt_rotate /* 2131363137 */:
                return getRotation() != 0 || getFlipH() || getFlipV();
            case R.id.opt_speed_control /* 2131363141 */:
                return getPlaybackSpeed() != 100;
            case R.id.opt_split_trim /* 2131363143 */:
                return isVideo() && (getTrimTimeStart() > 0 || getTrimTimeEnd() > 0);
            case R.id.opt_vid_crop /* 2131363162 */:
                return isAdjustedPosition();
            case R.id.opt_volume /* 2131363166 */:
            case R.id.opt_volume_and_balance /* 2131363167 */:
                return g();
            case R.id.opt_volume_env /* 2131363168 */:
                return isVolumeEnvelopeApplied();
            default:
                return super.isOptionApplied(i);
        }
    }

    public boolean isPreset() {
        return isSolid();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isReadyToPlay() {
        return this.m_mediaPath != null && this.m_mediaMSID == null;
    }

    public boolean isSolid() {
        String str = this.m_mediaPath;
        return str != null && str.startsWith("@solid:") && this.m_mediaPath.endsWith(".jpg");
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isTrimmable() {
        return true;
    }

    public boolean isVideo() {
        return (isImage() || isSolid()) ? false : true;
    }

    public boolean isVignetteApplied() {
        return this.m_vignette;
    }

    public boolean isVoiceChangerApplied() {
        return this.m_voiceChanger > 0 || this.m_enhancedAudioFilter != null;
    }

    public ResultTask<Bitmap> makeSingleThumbnail(int i, int i2) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        if (isSolid()) {
            Bitmap createBitmap = Bitmap.createBitmap((i2 * 16) / 9, i2, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(getSolidColor());
            resultTask.sendResult(createBitmap);
        } else if (isImage()) {
            File file = new File(this.m_mediaPath);
            if (!file.exists()) {
                resultTask.sendFailure(Task.makeTaskError("File not found"));
                return resultTask;
            }
            new ib(this, file, i2, resultTask).executeOnExecutor(EditorGlobal.D, new Void[0]);
        } else {
            if (this.i == null) {
                String str = this.m_mediaPath;
                this.i = str == null ? null : MediaInfo.a(new File(str));
            }
            MediaInfo mediaInfo = this.i;
            if (mediaInfo == null) {
                resultTask.sendFailure(Task.makeTaskError("Unable to get media info"));
                return resultTask;
            }
            mediaInfo.a(mediaInfo.R(), this.i.v(), i).onResultAvailable(new Sa(this, resultTask)).onFailure((Task.OnFailListener) new jb(this, resultTask));
        }
        return resultTask;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.i iVar, NexTimelineItem.w wVar, float f2, float f3, float f4) {
        b bVar = (b) iVar;
        int i = cb.f24224c[bVar.f24150c.ordinal()];
        if (i == 1) {
            this.m_effectStartTime = bVar.f24153f + ((int) ((f2 / f4) * 1000.0f));
            if (this.m_effectStartTime < 0) {
                this.m_effectStartTime = 0;
            }
            if (this.m_effectStartTime > getRepresentedDuration() - 100) {
                this.m_effectStartTime = getRepresentedDuration() - 100;
            }
            int i2 = this.m_effectStartTime;
            int i3 = this.m_effectEndTime;
            if (i2 > i3 - 100) {
                this.m_effectStartTime = i3 - 100;
            }
            bVar.m.invalidate();
            return true;
        }
        if (i == 2) {
            this.m_effectEndTime = bVar.f24153f + ((int) ((f2 / f4) * 1000.0f));
            if (this.m_effectEndTime < 0) {
                this.m_effectEndTime = 0;
            }
            int i4 = this.m_effectEndTime;
            int i5 = this.m_effectStartTime;
            if (i4 < i5 + 100) {
                this.m_effectEndTime = i5 + 100;
            }
            if (this.m_effectEndTime > getRepresentedDuration()) {
                this.m_effectEndTime = getRepresentedDuration();
            }
            bVar.m.invalidate();
            return true;
        }
        if (i != 3) {
            if (i != 4) {
                return false;
            }
            this.m_trimTimeStart = bVar.f24151d + ((Math.min((int) ((f2 / f4) * 1000.0f), bVar.f24154g) * getPlaybackSpeed()) / 100);
            int round = (this.m_duration - this.m_trimTimeEnd) - Math.round((Math.max(100, (getStartOverlap() + getEndOverlap()) + 100) * getPlaybackSpeed()) / 100.0f);
            this.m_trimTimeStart = snapToIFrame(this.m_trimTimeStart);
            if (this.m_trimTimeStart > round) {
                this.m_trimTimeStart = round;
            }
            if (this.m_trimTimeStart < 0) {
                this.m_trimTimeStart = 0;
            }
            this.m_trimmedDuration = (this.m_duration - this.m_trimTimeEnd) - this.m_trimTimeStart;
            bVar.v.apply();
            bVar.m.invalidate();
            wVar.a(bVar.f24152e + (((bVar.f24151d - this.m_trimTimeStart) / getPlaybackSpeed()) * 100));
            com.nexstreaming.kinemaster.editorwrapper.Da da = bVar.f24155h;
            if (da != null) {
                da.b(this.m_trimTimeStart);
            }
            return true;
        }
        if (this.m_isImage) {
            int max = getTimeline().getPrimaryItemCount() != 1 ? Math.max(getStartOverlap() + getEndOverlap() + 100, 100) : 100;
            this.m_duration = bVar.f24151d + Math.max((int) ((f2 / f4) * 1000.0f), -bVar.f24154g);
            if (this.m_duration < max) {
                this.m_duration = max;
            }
            if (this.m_duration > 1800000) {
                this.m_duration = 1800000;
            }
            bVar.v.apply();
            bVar.m.invalidate();
            com.nexstreaming.kinemaster.editorwrapper.Da da2 = bVar.f24155h;
            if (da2 != null) {
                da2.b(this.m_duration);
            }
        } else {
            this.m_trimTimeEnd = bVar.f24151d - ((Math.max((int) ((f2 / f4) * 1000.0f), -bVar.f24154g) * getPlaybackSpeed()) / 100);
            int round2 = (this.m_duration - this.m_trimTimeStart) - Math.round((Math.max((getStartOverlap() + getEndOverlap()) + 100, 100) * getPlaybackSpeed()) / 100.0f);
            if (this.m_trimTimeEnd > round2) {
                this.m_trimTimeEnd = round2;
            }
            if (this.m_trimTimeEnd < 0) {
                this.m_trimTimeEnd = 0;
            }
            this.m_trimmedDuration = (this.m_duration - this.m_trimTimeEnd) - this.m_trimTimeStart;
            bVar.v.apply();
            bVar.m.invalidate();
            com.nexstreaming.kinemaster.editorwrapper.Da da3 = bVar.f24155h;
            if (da3 != null) {
                da3.b(this.m_duration - this.m_trimTimeEnd);
            }
        }
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.i iVar, NexTimelineItem.w wVar) {
        ViewGroup viewGroup;
        b bVar = (b) iVar;
        if (bVar.f24155h != null) {
            int i = 0;
            DragType dragType = bVar.f24150c;
            if (dragType == DragType.END) {
                i = getAbsEndTime() - 2;
            } else if (dragType == DragType.START) {
                i = getAbsStartTime();
            }
            bVar.f24155h.a(i);
            bVar.f24155h = null;
        }
        WindowManager windowManager = bVar.n;
        if (windowManager != null && (viewGroup = bVar.l) != null) {
            windowManager.removeView(viewGroup);
            bVar.l = null;
        }
        DragType dragType2 = bVar.f24150c;
        if (dragType2 == DragType.START) {
            checkEffectTime(getEffectStartTime(), getEffectEndTime(), 1);
        } else if (dragType2 == DragType.END) {
            checkEffectTime(getEffectStartTime(), getEffectEndTime(), 2);
        }
        getTransition().ensureTransitionFits();
        if (getPrecedingTransition() != null) {
            getPrecedingTransition().ensureTransitionFits();
        }
        DragType dragType3 = bVar.f24150c;
        if (dragType3 == DragType.END) {
            wVar.a(getAbsEndTime() - 2, true);
        } else if (dragType3 == DragType.START) {
            wVar.a(getAbsStartTime(), true);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.i iVar, Rect rect) {
        ViewGroup viewGroup;
        b bVar = (b) iVar;
        WindowManager windowManager = bVar.n;
        if (windowManager == null || (viewGroup = bVar.l) == null) {
            return;
        }
        DragType dragType = bVar.f24150c;
        if (dragType == DragType.END) {
            WindowManager.LayoutParams layoutParams = bVar.o;
            layoutParams.x = rect.right - (bVar.i / 2);
            windowManager.updateViewLayout(viewGroup, layoutParams);
            return;
        }
        if (dragType == DragType.START) {
            WindowManager.LayoutParams layoutParams2 = bVar.o;
            layoutParams2.x = rect.left - (bVar.i / 2);
            windowManager.updateViewLayout(viewGroup, layoutParams2);
        } else {
            if (dragType == DragType.FXSTART) {
                a a2 = a(rect);
                WindowManager.LayoutParams layoutParams3 = bVar.o;
                layoutParams3.x = a2.f24148c - (bVar.i / 2);
                bVar.n.updateViewLayout(bVar.l, layoutParams3);
                return;
            }
            if (dragType == DragType.FXEND) {
                a a3 = a(rect);
                WindowManager.LayoutParams layoutParams4 = bVar.o;
                layoutParams4.x = a3.f24149d - (bVar.i / 2);
                bVar.n.updateViewLayout(bVar.l, layoutParams4);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onDown(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 == R.id.editmode_trim) {
            return onDown_trim(context, wVar, rectF, i, i2, z, i3);
        }
        if (i3 == R.id.editmode_fxtime) {
            return onDown_fxtime(context, wVar, rectF, i, i2, z, i3);
        }
        return null;
    }

    public NexTimelineItem.k onDown_fxtime(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        bb bbVar = null;
        if (i3 != R.id.editmode_fxtime) {
            return null;
        }
        a a2 = a(rectF);
        float abs = Math.abs(a2.f24148c - i);
        float abs2 = Math.abs(a2.f24149d - i);
        if (Math.min(abs, abs2) > rectF.height()) {
            return null;
        }
        if (abs < abs2) {
            b bVar = new b(bbVar);
            bVar.f24150c = DragType.FXSTART;
            bVar.q = context;
            bVar.f24153f = a2.f24146a;
            a(bVar, context, a2.f24148c, (int) rectF.top);
            return bVar;
        }
        b bVar2 = new b(bbVar);
        bVar2.f24150c = DragType.FXEND;
        bVar2.q = context;
        bVar2.f24153f = a2.f24147b;
        a(bVar2, context, a2.f24149d, (int) rectF.top);
        return bVar2;
    }

    public NexTimelineItem.k onDown_trim(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        bb bbVar = null;
        if (i3 != R.id.editmode_trim) {
            return null;
        }
        getTimeline().getSecondaryItemCount();
        if (!this.m_isImage && rectF.width() < rectF.height() * 2.0f) {
            if (i < rectF.left + (rectF.width() / 2.0f)) {
                b bVar = new b(bbVar);
                bVar.f24150c = DragType.START;
                bVar.q = context;
                bVar.f24151d = this.m_isImage ? this.m_duration : this.m_trimTimeStart;
                bVar.f24152e = wVar.getCurrentTime();
                bVar.f24154g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
                bVar.v = getTimeline().beginTimeChange();
                if (context instanceof ProjectEditActivity) {
                    bVar.f24155h = ((ProjectEditActivity) context).ja().L();
                    bVar.f24155h.a(new File(getMediaPath()));
                    bVar.f24155h.b(this.m_trimTimeStart);
                }
                a(bVar, context, (int) rectF.left, (int) rectF.top);
                return bVar;
            }
            b bVar2 = new b(bbVar);
            bVar2.f24150c = DragType.END;
            bVar2.q = context;
            bVar2.f24151d = this.m_isImage ? this.m_duration : this.m_trimTimeEnd;
            bVar2.f24154g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            bVar2.v = getTimeline().beginTimeChange();
            a(bVar2, context, (int) rectF.right, (int) rectF.top);
            if (context instanceof ProjectEditActivity) {
                bVar2.f24155h = ((ProjectEditActivity) context).ja().L();
                bVar2.f24155h.a(new File(getMediaPath()));
                bVar2.f24155h.b(this.m_duration - this.m_trimTimeEnd);
            }
            return bVar2;
        }
        if (!this.m_isImage && i < rectF.left + rectF.height()) {
            b bVar3 = new b(bbVar);
            bVar3.f24150c = DragType.START;
            bVar3.q = context;
            bVar3.f24151d = this.m_isImage ? this.m_duration : this.m_trimTimeStart;
            bVar3.f24152e = wVar.getCurrentTime();
            bVar3.f24154g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            bVar3.v = getTimeline().beginTimeChange();
            if (context instanceof ProjectEditActivity) {
                bVar3.f24155h = ((ProjectEditActivity) context).ja().L();
                bVar3.f24155h.a(new File(getMediaPath()));
                bVar3.f24155h.b(this.m_trimTimeStart);
            }
            a(bVar3, context, (int) rectF.left, (int) rectF.top);
            return bVar3;
        }
        if (i <= rectF.right - rectF.height()) {
            return null;
        }
        b bVar4 = new b(bbVar);
        bVar4.f24150c = DragType.END;
        bVar4.q = context;
        bVar4.f24151d = this.m_isImage ? this.m_duration : this.m_trimTimeEnd;
        bVar4.f24154g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        bVar4.v = getTimeline().beginTimeChange();
        if ((context instanceof ProjectEditActivity) && isVideo()) {
            bVar4.f24155h = ((ProjectEditActivity) context).ja().L();
            bVar4.f24155h.a(new File(getMediaPath()));
            bVar4.f24155h.b(this.m_duration - this.m_trimTimeEnd);
        }
        if (this.m_isImage) {
            a(bVar4, context, (int) rectF.right, (int) rectF.top);
        } else {
            a(bVar4, context, (int) rectF.right, (int) rectF.top);
        }
        return bVar4;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onDraw(C1916ib c1916ib) {
        boolean z;
        float f2;
        NexVideoClipItem nexVideoClipItem;
        C1916ib c1916ib2;
        Drawable drawable;
        int i;
        float f3;
        float f4;
        boolean p = c1916ib.p();
        RectF k = c1916ib.k();
        TextPaint j = c1916ib.j();
        Canvas a2 = c1916ib.a();
        RectF e2 = c1916ib.e();
        float i2 = c1916ib.i();
        a(c1916ib.h());
        Drawable drawable2 = c1916ib.getResources().getDrawable(p ? R.drawable.timeline_item_border_sel : R.drawable.timeline_item_border_nor);
        drawable2.getPadding(f24141d);
        MediaInfo mediaInfo = this.i;
        if (mediaInfo != null && this.m == null && !this.n && !this.o) {
            this.n = true;
            mediaInfo.F().onResultAvailable(new fb(this)).onFailure((Task.OnFailListener) new eb(this));
        }
        j.reset();
        if (c1916ib.o()) {
            k.set(e2);
            int i3 = (int) (i2 * 2.0f);
            float f5 = i3;
            k.inset(f5, f5);
            float f6 = -i3;
            k.offset(f6, f6);
            j.setColor(-1157627904);
            j.setStyle(Paint.Style.STROKE);
            j.setStrokeWidth(0.0f);
            a2.drawRect(k, j);
            return;
        }
        this.m_clipWidth = e2.width();
        j.setStyle(Paint.Style.FILL);
        k.set(e2);
        float f7 = k.left;
        Rect rect = f24141d;
        k.left = f7 + rect.left;
        k.top += rect.top;
        k.right -= rect.right;
        k.bottom -= rect.bottom;
        boolean isLogoClip = isLogoClip();
        if (!this.f24145h) {
            RectF rectF = f24142e;
            float height = k.height();
            Drawable drawable3 = c1916ib.getResources().getDrawable(R.drawable.n2_missingfile_icon_small);
            float intrinsicHeight = (int) ((height / drawable3.getIntrinsicHeight()) * drawable3.getIntrinsicWidth());
            rectF.top = k.top;
            rectF.bottom = k.bottom;
            float f8 = k.left;
            while (f8 < k.right) {
                rectF.left = f8;
                f8 += intrinsicHeight;
                rectF.right = f8;
                if (!a2.quickReject(rectF, Canvas.EdgeType.AA)) {
                    drawable3.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    drawable3.draw(a2);
                }
            }
            if (p) {
                j.setColor(-2130725888);
                j.setStyle(Paint.Style.STROKE);
                j.setStrokeWidth(i2 * 2.0f);
                a2.drawRect(k, j);
                return;
            }
            return;
        }
        if (this.i != null && this.j != null) {
            RectF rectF2 = f24142e;
            float height2 = k.height();
            float a3 = this.j.a(this.m_rotation, height2);
            int firstRepresentedTime = getFirstRepresentedTime();
            int representedDuration = getRepresentedDuration();
            z = p;
            if (((int) a3) > 5) {
                rectF2.top = k.top;
                rectF2.bottom = k.bottom;
                if (representedDuration >= 1) {
                    int width = (int) ((firstRepresentedTime * k.width()) / representedDuration);
                    if (width < 0) {
                        width = 0;
                    }
                    float f9 = k.left - width;
                    Drawable drawable4 = null;
                    while (f9 < k.right) {
                        rectF2.left = f9;
                        float f10 = f9 + a3;
                        rectF2.right = f10;
                        if (a2.quickReject(rectF2, Canvas.EdgeType.AA)) {
                            f3 = a3;
                            f4 = f10;
                        } else {
                            com.nexstreaming.kinemaster.mediainfo.T t = this.j;
                            int i4 = this.m_rotation;
                            f3 = a3;
                            float f11 = k.left;
                            f4 = f10;
                            Bitmap b2 = t.b(i4, ((int) (((f9 - f11) / (k.right - f11)) * getRepresentedDurationWithoutSpeedControl())) + firstRepresentedTime, this.m_fliph, this.m_flipv);
                            if (b2 != null) {
                                a2.drawBitmap(b2, (Rect) null, rectF2, j);
                            } else {
                                if (drawable4 == null) {
                                    drawable4 = c1916ib.getResources().getDrawable(R.drawable.n2_loading_image_1_img);
                                }
                                drawable4.setBounds((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                                drawable4.draw(a2);
                            }
                        }
                        a3 = f3;
                        f9 = f4;
                    }
                }
            } else {
                Drawable drawable5 = c1916ib.getResources().getDrawable(R.drawable.n2_loading_image_1_img);
                float intrinsicHeight2 = (int) ((height2 / drawable5.getIntrinsicHeight()) * drawable5.getIntrinsicWidth());
                rectF2.top = k.top;
                rectF2.bottom = k.bottom;
                float f12 = k.left;
                while (f12 < k.right) {
                    rectF2.left = f12;
                    f12 += intrinsicHeight2;
                    rectF2.right = f12;
                    if (!a2.quickReject(rectF2, Canvas.EdgeType.AA)) {
                        drawable5.setBounds((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                        drawable5.draw(a2);
                    }
                }
            }
        } else {
            z = p;
            if (isSolid()) {
                j.setColor((int) Long.parseLong(this.m_mediaPath.substring(7, 15), 16));
                a2.drawRect(k, j);
            } else {
                Bitmap b3 = b(c1916ib);
                if (b3 != null && b3.getWidth() > 0) {
                    Bitmap a4 = a(b3);
                    RectF rectF3 = f24142e;
                    k.height();
                    float width2 = a4.getWidth();
                    rectF3.top = k.top;
                    rectF3.bottom = k.bottom;
                    float f13 = k.left;
                    while (f13 < k.right) {
                        rectF3.left = f13;
                        f13 += width2;
                        rectF3.right = f13;
                        if (!a2.quickReject(rectF3, Canvas.EdgeType.AA)) {
                            a2.drawBitmap(a4, (Rect) null, rectF3, j);
                        }
                    }
                }
            }
        }
        if (isLogoClip) {
            f2 = i2;
        } else {
            if (isSolid()) {
                i = R.drawable.n3_timeline_clip_solid;
            } else if (isImage()) {
                i = R.drawable.n3_timeline_clip_image;
            } else {
                i = this.m_isReverse ? R.drawable.n3_timeline_clip_reverse : R.drawable.n3_timeline_clip_video;
            }
            Drawable drawable6 = c1916ib.getResources().getDrawable(i);
            int intrinsicWidth = drawable6.getIntrinsicWidth();
            int intrinsicHeight3 = drawable6.getIntrinsicHeight();
            double d2 = i2;
            Double.isNaN(d2);
            int i5 = (int) (d2 * 2.5d);
            float f14 = k.left;
            float f15 = k.top;
            float f16 = i5;
            drawable6.setBounds(((int) f14) + i5, ((int) f15) + i5, (int) (f14 + f16 + intrinsicWidth), ((int) f15) + i5 + intrinsicHeight3);
            drawable6.draw(a2);
            if (isImage() || isSolid()) {
                f2 = i2;
            } else {
                a2.save();
                String str = " " + (getPlaybackSpeed() / 100.0f) + FragmentC2201x.f23219a;
                j.setShadowLayer(3.0f, 0.0f, 0.0f, ViewCompat.MEASURED_STATE_MASK);
                j.setColor(-1);
                j.setTextSize(10.0f * i2);
                j.setTypeface(Typeface.SANS_SERIF);
                j.getTextBounds(str, 0, str.length() - 1, new Rect());
                f2 = i2;
                a2.clipRect(k.left, k.top, 1280.0f, k.bottom);
                a2.drawText(str, k.left + (i5 * 8) + ((drawable6.getIntrinsicWidth() / 2) - (r9.width() / 2)), k.top + (f16 * 3.5f) + ((drawable6.getIntrinsicHeight() / 2) - (r9.height() / 2)), j);
                a2.restore();
            }
            if (getEffectID() != null) {
                Drawable drawable7 = c1916ib.getResources().getDrawable(R.drawable.n3_timeline_clip_effect);
                if (!isImage() && !isSolid() && getHasAudio() && getMuteAudio()) {
                    float f17 = k.left;
                    int i6 = i5 * 2;
                    float f18 = k.top;
                    drawable7.setBounds(((int) f17) + i6 + intrinsicWidth, ((int) f18) + i6 + intrinsicHeight3, ((int) f17) + i6 + (intrinsicWidth * 2), ((int) f18) + i6 + (intrinsicHeight3 * 2));
                } else {
                    float f19 = k.left;
                    float f20 = k.top;
                    int i7 = i5 * 2;
                    drawable7.setBounds(((int) f19) + i5, ((int) f20) + i7 + intrinsicHeight3, ((int) f19) + i5 + intrinsicWidth, ((int) f20) + i7 + (intrinsicHeight3 * 2));
                }
                drawable7.draw(a2);
            }
            if (!isImage() && !isSolid() && getHasAudio() && getMuteAudio()) {
                Drawable drawable8 = c1916ib.getResources().getDrawable(R.drawable.n3_timeline_clip_muteaudio);
                float f21 = k.left;
                float f22 = k.top;
                int i8 = i5 * 2;
                drawable8.setBounds(((int) f21) + i5, ((int) f22) + i8 + intrinsicHeight3, ((int) f21) + i5 + intrinsicWidth, ((int) f22) + i8 + (intrinsicHeight3 * 2));
                drawable8.draw(a2);
            }
        }
        drawable2.setBounds((int) e2.left, (int) e2.top, (int) e2.right, (int) e2.bottom);
        drawable2.draw(a2);
        if (z) {
            j.setColor(-19456);
            j.setStyle(Paint.Style.STROKE);
            j.setStrokeWidth(f2 * 2.0f);
            if (c1916ib.d() == R.id.editmode_trim) {
                a2.save();
                c1916ib2 = c1916ib;
                int a5 = c1916ib2.a(8.0f);
                float f23 = a5;
                a2.clipRect(e2.left - f23, e2.top, e2.right + f23, e2.bottom, Region.Op.REPLACE);
                if (isImage()) {
                    drawable = c1916ib.getResources().getDrawable(R.drawable.grip_yellow_right);
                    drawable.setBounds(((int) e2.left) - a5, (int) e2.top, ((int) e2.right) + a5, (int) e2.bottom);
                } else {
                    drawable = c1916ib.getResources().getDrawable(R.drawable.grip_yellow);
                    drawable.setBounds(((int) e2.left) - a5, (int) e2.top, ((int) e2.right) + a5, (int) e2.bottom);
                }
                drawable.draw(a2);
                a2.restore();
                nexVideoClipItem = this;
            } else {
                c1916ib2 = c1916ib;
                if (c1916ib.d() == R.id.editmode_fxtime) {
                    nexVideoClipItem = this;
                    a a6 = nexVideoClipItem.a(k);
                    int a7 = c1916ib2.a(2.0f);
                    k.left = a6.f24148c + a7;
                    k.right = a6.f24149d - a7;
                    k.top += c1916ib2.a(1.0f);
                    k.bottom -= c1916ib2.a(1.0f);
                    j.setStyle(Paint.Style.FILL);
                    j.setColor(2147464192);
                    a2.drawRect(k, j);
                    k.left = a6.f24148c - a7;
                    k.right = a6.f24149d + a7;
                    k.top -= c1916ib2.a(1.0f);
                    k.bottom += c1916ib2.a(1.0f);
                    a2.save();
                    Drawable drawable9 = c1916ib.getResources().getDrawable(R.drawable.grip_yellow_for_fx);
                    a2.clipRect(k.left, k.top, k.right, k.bottom, Region.Op.REPLACE);
                    drawable9.setBounds(((int) k.left) + a7, (int) k.top, ((int) k.right) - a7, (int) k.bottom);
                    drawable9.draw(a2);
                    a2.restore();
                } else {
                    nexVideoClipItem = this;
                    if (c1916ib.d() == R.id.editmode_volume_adjust) {
                        int size = nexVideoClipItem.m_volumeEnvelopeTime.size();
                        new Path();
                        Drawable drawable10 = c1916ib.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
                        PointF[] pointFArr = new PointF[size];
                        int intrinsicWidth2 = drawable10.getIntrinsicWidth() / 2;
                        int intrinsicHeight4 = drawable10.getIntrinsicHeight() / 2;
                        int i9 = 0;
                        for (int i10 = 0; i10 < size; i10++) {
                            if (i10 == 0) {
                                pointFArr[i9] = new PointF();
                                pointFArr[i9].x = (nexVideoClipItem.getVolumeEnvelopeTimeForDrawing(i10) / getRepresentedDuration()) * k.right;
                                pointFArr[i9].y = k.bottom - ((nexVideoClipItem.m_volumeEnvelopeLevel.get(i10).intValue() / 200.0f) * k.bottom);
                            } else {
                                pointFArr[i9] = new PointF();
                                pointFArr[i9].x = (nexVideoClipItem.getVolumeEnvelopeTimeForDrawing(i10) / getRepresentedDuration()) * k.right;
                                pointFArr[i9].y = k.bottom - ((nexVideoClipItem.m_volumeEnvelopeLevel.get(i10).intValue() / 200.0f) * k.bottom);
                            }
                            i9++;
                        }
                        a2.clipRect(k);
                        j.reset();
                        j.setAntiAlias(true);
                        j.setStrokeWidth(5.0f);
                        j.setStyle(Paint.Style.STROKE);
                        j.setColor(-1);
                        int i11 = 0;
                        while (i11 < pointFArr.length - 1) {
                            float f24 = pointFArr[i11].x;
                            float f25 = pointFArr[i11].y;
                            i11++;
                            a2.drawLine(f24, f25, pointFArr[i11].x, pointFArr[i11].y, j);
                        }
                        for (int i12 = 0; i12 < pointFArr.length && pointFArr[i12] != null; i12++) {
                            int volumeEnvelopeTimeAdj = nexVideoClipItem.getVolumeEnvelopeTimeAdj(i12);
                            int representedDurationWithoutOverlap = ((getRepresentedDurationWithoutOverlap() + nexVideoClipItem.m_trimTimeStart) * 100) / getPlaybackSpeed();
                            if (nexVideoClipItem.m_startOverlap + ((nexVideoClipItem.m_trimTimeStart * 100) / getPlaybackSpeed()) <= ((nexVideoClipItem.m_trimTimeStart * 100) / getPlaybackSpeed()) + volumeEnvelopeTimeAdj && representedDurationWithoutOverlap - nexVideoClipItem.m_endOverlap >= volumeEnvelopeTimeAdj + ((nexVideoClipItem.m_trimTimeStart * 100) / getPlaybackSpeed())) {
                                drawable10.setBounds(((int) pointFArr[i12].x) - intrinsicWidth2, ((int) pointFArr[i12].y) - intrinsicHeight4, ((int) pointFArr[i12].x) + intrinsicWidth2, ((int) pointFArr[i12].y) + intrinsicHeight4);
                                drawable10.draw(a2);
                            }
                        }
                    } else {
                        c1916ib.d();
                    }
                }
            }
        } else {
            nexVideoClipItem = this;
            c1916ib2 = c1916ib;
        }
        if (nexVideoClipItem.i == null || nexVideoClipItem.j == null) {
            return;
        }
        int firstRepresentedTime2 = getFirstRepresentedTime();
        int representedDuration2 = getRepresentedDuration();
        int representedDurationWithoutSpeedControl = getRepresentedDurationWithoutSpeedControl();
        int startOverlap = getStartOverlap() + ((getTrimTimeStart() * 100) / getPlaybackSpeed());
        if (c1916ib.d() == R.id.editmode_trim && z && !nexVideoClipItem.o) {
            Drawable drawable11 = c1916ib.getResources().getDrawable(R.drawable.iframe_mark);
            int intrinsicWidth3 = drawable11.getIntrinsicWidth();
            int intrinsicHeight5 = drawable11.getIntrinsicHeight();
            int a8 = c1916ib2.a(2.5f);
            int[] iArr = nexVideoClipItem.m;
            if (iArr == null) {
                iArr = nexVideoClipItem.i.G();
            }
            for (int i13 = 0; iArr != null && i13 < iArr.length; i13++) {
                int i14 = iArr[i13];
                if (i14 >= firstRepresentedTime2 && i14 <= firstRepresentedTime2 + representedDurationWithoutSpeedControl) {
                    int playbackSpeed = (int) (((((i14 * 100) / getPlaybackSpeed()) - startOverlap) * e2.width()) / representedDuration2);
                    int i15 = intrinsicWidth3 / 2;
                    drawable11.setBounds(playbackSpeed - i15, a8, playbackSpeed + i15, a8 + intrinsicHeight5);
                    drawable11.draw(a2);
                }
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void onDuplicated(int i) {
        this.p = null;
        this.m_engineClipID = i;
        if (getTransition() != null) {
            getTransition().setUniqueId(null);
            getTransition().getUniqueId();
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onLongPress(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (isLogoClip()) {
            PreferenceManager.getDefaultSharedPreferences(context);
        }
        return NexTimelineItem.k.f24133a;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.p pVar) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onTimelineLoaded() {
        String str;
        if (!this.m_abstractCrop) {
            int i = this.m_width;
            this.m_startPositionLeft = (int) ((this.m_startPositionLeft * 100000) / i);
            int i2 = this.m_height;
            this.m_startPositionTop = (int) ((this.m_startPositionTop * 100000) / i2);
            this.m_startPositionRight = (int) ((this.m_startPositionRight * 100000) / i);
            this.m_startPositionBottom = (int) ((this.m_startPositionBottom * 100000) / i2);
            this.m_endPositionLeft = (int) ((this.m_endPositionLeft * 100000) / i);
            this.m_endPositionTop = (int) ((this.m_endPositionTop * 100000) / i2);
            this.m_endPositionRight = (int) ((this.m_endPositionRight * 100000) / i);
            this.m_endPositionBottom = (int) ((this.m_endPositionBottom * 100000) / i2);
            this.m_abstractCrop = true;
        }
        if (isImage() && (str = this.m_mediaPath) != null && new File(str).exists() && b(this.m_mediaPath)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.m_mediaPath, options);
            int i3 = options.outHeight;
            int i4 = options.outWidth;
            int i5 = this.m_width;
            int i6 = this.m_height;
            if (i5 != i6 && i5 == i4 && i6 == i3) {
                Log.i("NexVideoClipItem", "Fixed EXIF orientation");
                this.m_width = i3;
                this.m_height = i4;
                randomizeStartEndPosition(false, CropMode.FIT);
            } else if (this.m_width != i3 || this.m_height != i4) {
                Log.w("NexVideoClipItem", "Width/height mismatch : " + this.m_width + FragmentC2201x.f23219a + this.m_height + " != " + i3 + FragmentC2201x.f23219a + i4);
            }
        }
        NexTransitionItem transition = getTransition();
        if (transition != null && getTimeline().findItemByUniqueId(transition.getUniqueId()) == null) {
            transition.onTimelineLoaded();
        }
        d();
        super.onTimelineLoaded();
    }

    public void randomizeStartEndPosition(boolean z, CropMode cropMode) {
        int height;
        int width;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getStartPosition(rect);
        getEndPosition(rect2);
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            height = getWidth();
            width = getHeight();
        } else {
            height = getHeight();
            width = getWidth();
        }
        if (height < 1 || width < 1) {
            return;
        }
        if (isSolid()) {
            Rect rect3 = new Rect(2, 2, height - 2, width - 2);
            setStartPosition(rect3);
            setEndPosition(rect3);
            return;
        }
        if (cropMode == CropMode.FILL) {
            Rect rect4 = new Rect(0, 0, height, width);
            b(rect4, EditorGlobal.l());
            setStartPosition(rect4);
            setEndPosition(rect4);
            return;
        }
        if (cropMode == CropMode.FIT) {
            Rect rect5 = new Rect(0, 0, height, width);
            a(rect5, EditorGlobal.l());
            setStartPosition(rect5);
            setEndPosition(rect5);
            return;
        }
        Rect rect6 = new Rect();
        if (z && cropMode == CropMode.PAN_FACE) {
            getFaceBounds(rect6);
        }
        if (rect6.isEmpty()) {
            rect6.set(0, 0, (height * 2) / 3, (width * 2) / 3);
            double d2 = height;
            double random = Math.random();
            Double.isNaN(d2);
            int i2 = (int) ((d2 * random) / 3.0d);
            double d3 = width;
            double random2 = Math.random();
            Double.isNaN(d3);
            rect6.offset(i2, (int) ((d3 * random2) / 3.0d));
        } else {
            int width2 = (height / 4) - rect6.width();
            if (width2 >= 2) {
                int i3 = width2 / 2;
                rect6.left -= i3;
                rect6.right += i3;
            }
            int height2 = (width / 4) - rect6.height();
            if (height2 >= 2) {
                int i4 = height2 / 2;
                rect6.top -= i4;
                rect6.bottom += i4;
            }
            a(rect6, EditorGlobal.l());
            if (!rect6.intersect(0, 0, height, width)) {
                rect6.set(0, 0, (height * 2) / 3, (width * 2) / 3);
                double d4 = height;
                double random3 = Math.random();
                Double.isNaN(d4);
                int i5 = (int) ((d4 * random3) / 3.0d);
                double d5 = width;
                double random4 = Math.random();
                Double.isNaN(d5);
                rect6.offset(i5, (int) ((d5 * random4) / 3.0d));
            }
        }
        b(rect6, EditorGlobal.l());
        Rect rect7 = new Rect(0, 0, height, width);
        b(rect7, EditorGlobal.l());
        rect7.offset(0, -(rect7.top / 3));
        if (rect6.isEmpty()) {
            return;
        }
        if (Math.random() < 0.5d) {
            setStartPosition(rect7);
            setEndPosition(rect6);
        } else {
            setStartPosition(rect6);
            setEndPosition(rect7);
        }
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

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public void removeVolumeEnvelope(int i) {
        ArrayList<Integer> arrayList;
        if (this.m_volumeEnvelopeLevel == null || (arrayList = this.m_volumeEnvelopeTime) == null) {
            return;
        }
        arrayList.remove(i);
        this.m_volumeEnvelopeLevel.remove(i);
    }

    public boolean sameMediaAs(NexVideoClipItem nexVideoClipItem) {
        MediaStoreItemId mediaStoreItemId;
        if (nexVideoClipItem == null) {
            return false;
        }
        if (nexVideoClipItem.m_mediaPath == this.m_mediaPath && (mediaStoreItemId = nexVideoClipItem.m_mediaMSID) == mediaStoreItemId) {
            return true;
        }
        Object obj = nexVideoClipItem.m_mediaPath;
        String str = this.m_mediaPath;
        boolean z = obj == str || !(str == null || obj == null || !str.equals(obj));
        Object obj2 = nexVideoClipItem.m_mediaMSID;
        MediaStoreItemId mediaStoreItemId2 = this.m_mediaMSID;
        return z && (obj2 == mediaStoreItemId2 || (mediaStoreItemId2 != null && obj2 != null && mediaStoreItemId2.equals(obj2)));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioCompressor(boolean z) {
        if (z) {
            this.m_audioCompressor = 4;
        } else {
            this.m_audioCompressor = 0;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioLeftVolume(int i) {
        this.m_audioPanLeft = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioPitch(int i) {
        this.m_pitchFactor = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setAudioRightVolume(int i) {
        this.m_audioPanRight = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setBrightness(int i) {
        this.m_Brightness = i;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void setCaptureFilename(String str) {
        this.m_captureFilename = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setClipVolume(int i) {
        this.m_clipVolume = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.h
    public void setColorEffect(ColorEffect colorEffect) {
        this.m_colorEffect = colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.a
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_color && isSolid()) {
            setSolidColor(i2);
        } else {
            super.setColorOption(i, i2);
            throw null;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setContrast(int i) {
        this.m_Contrast = i;
    }

    public void setCropLink(boolean z) {
        this.m_cropLink = z;
    }

    @Deprecated
    public void setDimensions(int i, int i2) {
        this.m_width = i;
        this.m_height = i2;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        this.m_duration = i;
    }

    public void setEffectID(String str) {
        this.m_titleEffectID = str;
        this.f24143f = null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.l
    public void setEffectItem(com.nexstreaming.app.general.nexasset.assetpackage.r rVar) {
        if (rVar == null) {
            setEffectID(null);
            return;
        }
        if (rVar.getAssetPackage() != null) {
            this.mAssetIdx = rVar.getAssetPackage().getAssetIdx();
        }
        setEffectID(this.mAssetIdx + "/" + rVar.getId());
    }

    public void setEffectTiming(int i, int i2) {
        this.m_effectStartTime = i;
        this.m_effectEndTime = i2;
    }

    public void setEndMatrix(Matrix matrix) {
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        matrix.getValues(this.m_endMatrix);
        RectF a2 = a(matrix);
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            this.m_endPositionBottom = (int) a2.bottom;
            this.m_endPositionLeft = (int) a2.left;
            this.m_endPositionRight = (int) a2.right;
            this.m_endPositionTop = (int) a2.top;
            return;
        }
        this.m_rotatedEndPositionBottom = (int) a2.bottom;
        this.m_rotatedEndPositionLeft = (int) a2.left;
        this.m_rotatedEndPositionRight = (int) a2.right;
        this.m_rotatedEndPositionTop = (int) a2.top;
    }

    public void setEndOverlap(int i) {
        this.m_endOverlap = i;
    }

    public void setEndPosition(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            int i2 = this.m_height;
            this.m_endPositionBottom = (int) ((rect.bottom * 100000) / i2);
            int i3 = this.m_width;
            this.m_endPositionLeft = (int) ((rect.left * 100000) / i3);
            this.m_endPositionRight = (int) ((rect.right * 100000) / i3);
            this.m_endPositionTop = (int) ((rect.top * 100000) / i2);
        } else {
            int i4 = this.m_width;
            this.m_rotatedEndPositionBottom = (int) ((rect.bottom * 100000) / i4);
            int i5 = this.m_height;
            this.m_rotatedEndPositionLeft = (int) ((rect.left * 100000) / i5);
            this.m_rotatedEndPositionRight = (int) ((rect.right * 100000) / i5);
            this.m_rotatedEndPositionTop = (int) ((rect.top * 100000) / i4);
        }
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        b(rect).setValues(this.m_endMatrix);
    }

    public void setEndPositionRaw(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            this.m_endPositionBottom = rect.bottom;
            this.m_endPositionLeft = rect.left;
            this.m_endPositionRight = rect.right;
            this.m_endPositionTop = rect.top;
        } else {
            this.m_rotatedEndPositionBottom = rect.bottom;
            this.m_rotatedEndPositionLeft = rect.left;
            this.m_rotatedEndPositionRight = rect.right;
            this.m_rotatedEndPositionTop = rect.top;
        }
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        b(rect).setValues(this.m_endMatrix);
    }

    public void setEngineClipID(int i) {
        this.m_engineClipID = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setEqualizer(String str) {
        this.m_equalizer = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void setFlipH(boolean z) {
        this.m_fliph = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void setFlipV(boolean z) {
        this.m_flipv = z;
    }

    public void setHasAudio(boolean z) {
        this.m_hasAudio = z;
    }

    public void setKeepPitch(boolean z) {
        this.m_keepPitch = z;
    }

    public boolean setKenBurns(int i, CropMode cropMode) {
        Bitmap h2;
        if (this.settedKenBurns) {
            setStartPosition(this.inRect.toRect());
            setEndPosition(this.outRect.toRect());
            return true;
        }
        float width = getWidth();
        float height = getHeight();
        if (cropMode == CropMode.PAN_RAND && NexEditor.b.a(NexEditorUtils.a((int) width, (int) height, null, EditorGlobal.n(), EditorGlobal.m(), i, new NexRectangle[]{this.inRect, this.outRect})) == NexEditor.b.f24591b) {
            setStartPosition(this.inRect.toRect());
            setEndPosition(this.outRect.toRect());
            this.settedKenBurns = true;
            return true;
        }
        if (cropMode != CropMode.PAN_FACE || (h2 = h()) == null) {
            return false;
        }
        FaceDetector.Face[] faceArr = new FaceDetector.Face[32];
        int findFaces = new FaceDetector(h2.getWidth(), h2.getHeight(), 32).findFaces(h2, faceArr);
        PointF pointF = new PointF();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < findFaces; i2++) {
            if (faceArr[i2].confidence() >= 0.4d) {
                float eyesDistance = faceArr[i2].eyesDistance();
                faceArr[i2].getMidPoint(pointF);
                float f2 = eyesDistance / 2.0f;
                float f3 = eyesDistance / 3.0f;
                arrayList.add(new NexRectangle((int) (((pointF.x - f2) / h2.getWidth()) * width), (int) (((pointF.y - f3) / h2.getHeight()) * height), (int) (((pointF.x + f2) / h2.getWidth()) * width), (int) (((pointF.y + (f3 * 2.0f)) / h2.getHeight()) * height)));
            }
        }
        h2.recycle();
        if (NexEditor.b.a(NexEditorUtils.a((int) width, (int) height, arrayList.size() > 0 ? (NexRectangle[]) arrayList.toArray(new NexRectangle[arrayList.size()]) : null, EditorGlobal.n(), EditorGlobal.m(), i, new NexRectangle[]{this.inRect, this.outRect})) != NexEditor.b.f24591b) {
            return false;
        }
        setStartPosition(this.inRect.toRect());
        setEndPosition(this.outRect.toRect());
        this.settedKenBurns = true;
        return true;
    }

    public void setMediaPath(String str) {
        this.m_mediaPath = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public void setMusicVolume(int i) {
        this.m_musicVolume = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setMuteAudio(boolean z) {
        this.m_muteAudio = z;
    }

    public void setMuteMusic(boolean z) {
        this.m_muteMusic = z;
    }

    public void setPlaybackSpeed(int i) {
        this.m_playbackSpeed = i;
    }

    public void setReversePath(String str) {
        if (isSolid() || isImage()) {
            return;
        }
        this.m_mediaPath = str;
        this.m_mediaMSID = null;
        MediaInfo a2 = MediaInfo.a(str);
        if (a2 == null || !a2.U()) {
            return;
        }
        this.m_duration = a2.r();
        this.m_hasAudio = getHasAudio();
    }

    public void setReverseState(boolean z) {
        this.m_isReverse = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void setRotation(int i) {
        this.m_rotation = i;
        int i2 = this.m_rotation;
        if (i2 == 90 || i2 == 270) {
            if (this.m_rotatedStartPositionLeft == this.m_rotatedStartPositionRight || this.m_rotatedStartPositionTop == this.m_rotatedStartPositionBottom || this.m_rotatedEndPositionLeft == this.m_rotatedEndPositionRight || this.m_rotatedEndPositionTop == this.m_rotatedEndPositionBottom) {
                randomizeStartEndPosition(false, CropMode.FIT);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setSaturation(int i) {
        this.m_Saturation = i;
    }

    public void setSolidColor(int i) {
        if (isSolid()) {
            this.m_mediaPath = String.format("@solid:%08X.jpg", Integer.valueOf(i));
        }
    }

    public void setStartMatrix(Matrix matrix) {
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        matrix.getValues(this.m_startMatrix);
        RectF a2 = a(matrix);
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            this.m_startPositionBottom = (int) a2.bottom;
            this.m_startPositionLeft = (int) a2.left;
            this.m_startPositionRight = (int) a2.right;
            this.m_startPositionTop = (int) a2.top;
            return;
        }
        this.m_rotatedStartPositionBottom = (int) a2.bottom;
        this.m_rotatedStartPositionLeft = (int) a2.left;
        this.m_rotatedStartPositionRight = (int) a2.right;
        this.m_rotatedStartPositionTop = (int) a2.top;
    }

    public void setStartOverlap(int i) {
        this.m_startOverlap = i;
    }

    public void setStartPosition(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            int i2 = this.m_height;
            this.m_startPositionBottom = (int) ((rect.bottom * 100000) / i2);
            int i3 = this.m_width;
            this.m_startPositionLeft = (int) ((rect.left * 100000) / i3);
            this.m_startPositionRight = (int) ((rect.right * 100000) / i3);
            this.m_startPositionTop = (int) ((rect.top * 100000) / i2);
        } else {
            int i4 = this.m_width;
            this.m_rotatedStartPositionBottom = (int) ((rect.bottom * 100000) / i4);
            int i5 = this.m_height;
            this.m_rotatedStartPositionLeft = (int) ((rect.left * 100000) / i5);
            this.m_rotatedStartPositionRight = (int) ((rect.right * 100000) / i5);
            this.m_rotatedStartPositionTop = (int) ((rect.top * 100000) / i4);
        }
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        b(rect).setValues(this.m_startMatrix);
    }

    public void setStartPositionRaw(Rect rect) {
        int i = this.m_rotation;
        if (i != 90 && i != 270) {
            this.m_startPositionBottom = rect.bottom;
            this.m_startPositionLeft = rect.left;
            this.m_startPositionRight = rect.right;
            this.m_startPositionTop = rect.top;
        } else {
            this.m_rotatedStartPositionBottom = rect.bottom;
            this.m_rotatedStartPositionLeft = rect.left;
            this.m_rotatedStartPositionRight = rect.right;
            this.m_rotatedStartPositionTop = rect.top;
        }
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        b(rect).setValues(this.m_startMatrix);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_vignette) {
            this.m_vignette = !this.m_vignette;
            return null;
        }
        super.setSwitchOption(i, z, context);
        throw null;
    }

    public void setTintColor(int i) {
        this.m_TintColor = i;
    }

    public void setTitleEndTime(int i) {
        this.m_titleEndTime = i;
    }

    public void setTitleStartTime(int i) {
        this.m_titleStartTime = i;
    }

    public void setTrim(int i, int i2) {
        this.m_trimTimeStart = snapToIFrame(i);
        this.m_trimTimeEnd = i2;
    }

    public void setTrimEnd(int i) {
        this.m_trimTimeEnd = i;
    }

    public void setTrimStart(int i) {
        this.m_trimTimeStart = snapToIFrame(i);
    }

    public void setUseIFrameOnly(boolean z) {
        this.m_useIFrameOnly = z;
    }

    public void setVignette(boolean z) {
        this.m_vignette = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setVoiceChanger(String str) {
        this.m_enhancedAudioFilter = str;
    }

    public int snapToIFrame(int i) {
        MediaInfo mediaInfo;
        if ((getWidth() > 1280 || getHeight() > 720) && (mediaInfo = this.i) != null) {
            int[] iArr = this.m;
            if (iArr == null) {
                iArr = mediaInfo.G();
            }
            int i2 = -1;
            int extraDurationForSplit = NexEditorDeviceProfile.getDeviceProfile().getExtraDurationForSplit();
            if (iArr != null) {
                for (int i3 : iArr) {
                    Log.d("NexVideoClipItem", "[snapToIFrame] time: " + i + ", seekPoint: " + i3 + ", extra: " + extraDurationForSplit + ", closetSeekPoint: " + i2);
                    if (i >= i3 && i <= i3 + extraDurationForSplit) {
                        return i;
                    }
                    if (i < i3) {
                        return i3 - i < i - i2 ? i3 : i2;
                    }
                    if (i2 < 0 && i < i3) {
                        return i3;
                    }
                    i2 = i3 + extraDurationForSplit;
                }
            }
            if (i2 >= 0) {
                return i2;
            }
        }
        return i;
    }

    public String toString() {
        return super.toString();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.u
    public void trimToLeft(int i) {
        int absStartTime = i - getAbsStartTime();
        int trimTimeStart = (((getTrimTimeStart() * 100) / getPlaybackSpeed()) + absStartTime) - getStartOverlap();
        NexTimeline.c beginTimeChange = getTimeline().beginTimeChange();
        int duration = getDuration();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getStartPosition(rect);
        getEndPosition(rect2);
        int i2 = duration - absStartTime;
        int i3 = (i2 * 100) / duration;
        rect2.left = calcPos(rect.left, rect2.left, i3);
        rect2.top = calcPos(rect.top, rect2.top, i3);
        rect2.right = calcPos(rect.right, rect2.right, i3);
        rect2.bottom = calcPos(rect.bottom, rect2.bottom, i3);
        if (isImage()) {
            setDuration(i2);
        } else {
            setTrimStart((trimTimeStart / 100) * getPlaybackSpeed());
        }
        checkEffectTime(getEffectStartTime(), getEffectEndTime(), 1);
        beginTimeChange.apply();
        getTransition().ensureTransitionFits();
        getTimeline().requestCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.u
    public void trimToRight(int i) {
        int absEndTime = getAbsEndTime() - i;
        int trimTimeEnd = ((getTrimTimeEnd() * 100) / getPlaybackSpeed()) + absEndTime;
        int duration = getDuration();
        NexTimeline.c beginTimeChange = getTimeline().beginTimeChange();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getStartPosition(rect);
        getEndPosition(rect2);
        int i2 = duration - absEndTime;
        int i3 = (i2 * 100) / duration;
        rect2.left = calcPos(rect.left, rect2.left, i3);
        rect2.top = calcPos(rect.top, rect2.top, i3);
        rect2.right = calcPos(rect.right, rect2.right, i3);
        rect2.bottom = calcPos(rect.bottom, rect2.bottom, i3);
        if (isImage()) {
            setDuration(i2);
        } else {
            setTrimEnd((trimTimeEnd / 100) * getPlaybackSpeed());
        }
        checkEffectTime(getEffectStartTime(), getEffectEndTime(), 2);
        getTransition().ensureTransitionFits();
        if (getPrecedingTransition() != null) {
            getPrecedingTransition().ensureTransitionFits();
        }
        beginTimeChange.apply();
        getTimeline().requestCalcTimes();
    }

    public void updateFromNexVisualClip(NexVisualClip nexVisualClip) {
        if (nexVisualClip == null) {
            return;
        }
        this.m_engineClipID = nexVisualClip.mClipID;
        this.m_isImage = nexVisualClip.mClipType == 1;
        this.m_duration = nexVisualClip.mTotalTime;
        this.m_trimTimeStart = nexVisualClip.mStartTrimTime;
        this.m_trimTimeEnd = nexVisualClip.mEndTrimTime;
        this.m_width = nexVisualClip.mWidth;
        this.m_height = nexVisualClip.mHeight;
        this.m_audioDuration = nexVisualClip.mTotalAudioTime;
        this.m_videoDuration = nexVisualClip.mTotalVideoTime;
        this.m_hasVideo = nexVisualClip.mExistVideo != 0;
        this.m_hasAudio = nexVisualClip.mExistAudio != 0;
        this.m_rotation = nexVisualClip.mRotateState;
        this.m_fliph = (this.m_rotation & 65536) == 65536;
        this.m_flipv = (this.m_rotation & 131072) == 131072;
        this.m_rotation &= -65537;
        this.m_rotation &= -131073;
        this.m_titleStyle = TitleStyle.fromInt(nexVisualClip.mTitleStyle);
        this.m_titleStartTime = nexVisualClip.mTitleStartTime;
        this.m_titleEndTime = nexVisualClip.mTitleEndTime;
        int i = nexVisualClip.mSpeedControl;
        if (i == 0) {
            i = 100;
        }
        this.m_playbackSpeed = i;
        int i2 = nexVisualClip.mBGMVolume;
        if (i2 > 0) {
            this.m_musicVolume = i2;
            this.m_muteMusic = false;
        } else if (this.m_musicVolume > 0) {
            this.m_muteMusic = true;
        }
        this.m_muteAudio = nexVisualClip.mAudioOnOff == 0;
        this.m_clipVolume = nexVisualClip.mClipVolume;
        if (getTransition().getTransitionEffectID() == null) {
            getTransition().setTransitionEffectID(nexVisualClip.mClipEffectID);
        }
        if (getTransition().getTransitionEffectID().equals(NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE) && nexVisualClip.mEffectDuration == 0) {
            nexVisualClip.mEffectDuration = 1000;
            getTransition().setDuration(nexVisualClip.mEffectDuration);
        } else {
            getTransition().setDuration(nexVisualClip.mEffectDuration);
        }
        String str = nexVisualClip.mTitleEffectID;
        if (str != null) {
            this.m_titleEffectID = str;
        }
        String str2 = nexVisualClip.mClipPath;
        if (str2 != null) {
            String str3 = this.m_mediaPath;
            if (str3 != null && !str3.equals(str2)) {
                this.m_mediaPath = nexVisualClip.mClipPath;
                this.i = MediaInfo.a(new File(this.m_mediaPath));
            } else {
                this.m_mediaPath = nexVisualClip.mClipPath;
            }
        }
        String str4 = nexVisualClip.mThumbnailPath;
        if (str4 != null) {
            this.m_thumbPath = str4;
        }
    }

    private void f(int i) {
        this.m_preTrimmedDuration = i;
    }

    public String getEncodedEffectOptions(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append(z ? this.m_effectStartTime : 0);
        sb.append(',');
        sb.append(z ? this.m_effectEndTime : 0);
        sb.append('?');
        a(sb, getTransition().getEffectOptions());
        sb.append('?');
        a(sb, getEffectOptions());
        return sb.toString();
    }

    public int getRepresentedDuration(int i) {
        return (((int) ((((this.m_duration - this.m_trimTimeStart) - (this.m_trimTimeEnd - i)) * 100) / getPlaybackSpeed())) - this.m_startOverlap) - Math.max(0, this.m_endOverlap - i);
    }

    public int setTitleEndTime() {
        return this.m_titleEndTime;
    }

    public int setTitleStartTime() {
        return this.m_titleStartTime;
    }

    public static NexVideoClipItem newInstance(int i, com.nexstreaming.kinemaster.mediastore.item.c cVar, int i2, boolean z) {
        MediaInfo mediaInfo;
        ClipItemWrapper clipItemWrapper = new ClipItemWrapper(z);
        ((NexVideoClipItem) clipItemWrapper).m_mediaMSID = cVar.getId();
        ((NexVideoClipItem) clipItemWrapper).m_engineClipID = i;
        if (cVar.h()) {
            mediaInfo = null;
        } else {
            ((NexVideoClipItem) clipItemWrapper).m_mediaPath = cVar.getPath();
            mediaInfo = MediaInfo.a(((NexVideoClipItem) clipItemWrapper).m_mediaPath);
        }
        try {
            ((NexVideoClipItem) clipItemWrapper).m_width = cVar.getWidth();
            ((NexVideoClipItem) clipItemWrapper).m_height = cVar.getHeight();
        } catch (MediaStore.UnavailableDataException unused) {
            ((NexVideoClipItem) clipItemWrapper).m_width = 0;
            ((NexVideoClipItem) clipItemWrapper).m_height = 0;
        }
        int i3 = cb.f24222a[cVar.getType().ordinal()];
        if (i3 == 1) {
            ((NexVideoClipItem) clipItemWrapper).m_isImage = true;
            ((NexVideoClipItem) clipItemWrapper).m_duration = i2;
            ((NexVideoClipItem) clipItemWrapper).m_hasAudio = false;
            ((NexVideoClipItem) clipItemWrapper).m_hasVideo = false;
        } else {
            if (i3 != 2 && i3 != 3) {
                throw new IllegalStateException("Unsupported type: " + String.valueOf(cVar.getType()));
            }
            ((NexVideoClipItem) clipItemWrapper).m_isImage = false;
            if (mediaInfo != null) {
                ((NexVideoClipItem) clipItemWrapper).m_duration = mediaInfo.r();
                ((NexVideoClipItem) clipItemWrapper).m_hasAudio = mediaInfo.S();
                ((NexVideoClipItem) clipItemWrapper).q = mediaInfo.t();
                ((NexVideoClipItem) clipItemWrapper).m_width = mediaInfo.R();
                ((NexVideoClipItem) clipItemWrapper).m_height = mediaInfo.v();
            } else {
                try {
                    ((NexVideoClipItem) clipItemWrapper).m_duration = cVar.getDuration();
                } catch (MediaStore.UnavailableDataException unused2) {
                    ((NexVideoClipItem) clipItemWrapper).m_duration = 5000;
                }
                try {
                    ((NexVideoClipItem) clipItemWrapper).m_hasAudio = cVar.f();
                } catch (MediaStore.UnavailableDataException unused3) {
                    ((NexVideoClipItem) clipItemWrapper).m_hasAudio = false;
                }
                try {
                    ((NexVideoClipItem) clipItemWrapper).q = cVar.b();
                } catch (MediaStore.UnavailableDataException unused4) {
                    ((NexVideoClipItem) clipItemWrapper).q = 0;
                }
            }
            ((NexVideoClipItem) clipItemWrapper).m_hasVideo = true;
        }
        clipItemWrapper.randomizeStartEndPosition(false, CropMode.FIT);
        return clipItemWrapper;
    }

    private void a() {
        Bitmap h2;
        float f2;
        int i;
        FaceDetector.Face[] faceArr;
        if (this.m_faceBounds_set || (h2 = h()) == null) {
            return;
        }
        FaceDetector.Face[] faceArr2 = new FaceDetector.Face[32];
        int findFaces = new FaceDetector(h2.getWidth(), h2.getHeight(), 32).findFaces(h2, faceArr2);
        RectF rectF = new RectF();
        RectF rectF2 = new RectF();
        PointF pointF = new PointF();
        float width = getWidth();
        float height = getHeight();
        float f3 = width / 30.0f;
        float f4 = height / 30.0f;
        int i2 = 0;
        while (i2 < findFaces) {
            if (faceArr2[i2].confidence() >= 0.4d) {
                faceArr2[i2].getMidPoint(pointF);
                float eyesDistance = faceArr2[i2].eyesDistance();
                if (eyesDistance >= f3 && eyesDistance >= f4) {
                    float f5 = pointF.x;
                    float f6 = eyesDistance / 2.0f;
                    i = findFaces;
                    float f7 = pointF.y;
                    float f8 = eyesDistance / 3.0f;
                    faceArr = faceArr2;
                    rectF2.set((f5 - f6) / width, (f7 - f8) / height, (f5 + f6) / width, (f7 + (f8 * 2.0f)) / height);
                    rectF.union(rectF2);
                    i2++;
                    findFaces = i;
                    faceArr2 = faceArr;
                }
            }
            i = findFaces;
            faceArr = faceArr2;
            i2++;
            findFaces = i;
            faceArr2 = faceArr;
        }
        h2.recycle();
        if (!rectF.isEmpty()) {
            float width2 = 0.6f - rectF.width();
            float height2 = 0.6f - rectF.height();
            if (width2 > 0.0f) {
                f2 = 2.0f;
                float f9 = width2 / 2.0f;
                rectF.left -= f9;
                rectF.right += f9;
            } else {
                f2 = 2.0f;
            }
            if (height2 > 0.0f) {
                float f10 = height2 / f2;
                rectF.top -= f10;
                rectF.bottom += f10;
            }
        }
        this.m_faceBounds_set = true;
        this.m_faceBounds_left = Math.max(0.0f, rectF.left);
        this.m_faceBounds_top = Math.max(0.0f, rectF.top);
        this.m_faceBounds_right = Math.min(rectF.right, 1.0f);
        this.m_faceBounds_bottom = Math.min(rectF.bottom, 1.0f);
    }

    private static boolean b(String str) {
        int attributeInt;
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".jpg")) {
            try {
                attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            } catch (IOException unused) {
            }
            return attributeInt != 6 || attributeInt == 8;
        }
        attributeInt = 0;
        if (attributeInt != 6) {
        }
    }

    private Matrix b(Rect rect) {
        return a(rect.left, rect.top, rect.right, rect.bottom);
    }

    private Bitmap b(Context context) {
        return c(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends NexTimelineItem.i {

        /* renamed from: c, reason: collision with root package name */
        DragType f24150c;

        /* renamed from: d, reason: collision with root package name */
        int f24151d;

        /* renamed from: e, reason: collision with root package name */
        int f24152e;

        /* renamed from: f, reason: collision with root package name */
        int f24153f;

        /* renamed from: g, reason: collision with root package name */
        int f24154g;

        /* renamed from: h, reason: collision with root package name */
        com.nexstreaming.kinemaster.editorwrapper.Da f24155h;
        int i;
        int j;
        TextView k;
        ViewGroup l;
        View m;
        WindowManager n;
        WindowManager.LayoutParams o;
        int p;
        Context q;
        ViewGroup r;
        TextView s;
        TextView t;
        TextView u;
        NexTimeline.c v;

        private b() {
            this.f24150c = null;
            this.f24151d = 0;
            this.f24152e = 0;
            this.f24153f = 0;
            this.f24154g = 0;
            this.f24155h = null;
            this.i = 0;
            this.j = 0;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = 0;
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.v = null;
        }

        /* synthetic */ b(bb bbVar) {
            this();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(java.lang.String r3) {
        /*
            java.util.Locale r0 = java.util.Locale.US
            java.lang.String r0 = r3.toLowerCase(r0)
            java.lang.String r1 = ".jpeg"
            boolean r1 = r0.endsWith(r1)
            r2 = 0
            if (r1 != 0) goto L1a
            java.lang.String r1 = ".jpg"
            boolean r0 = r0.endsWith(r1)
            if (r0 == 0) goto L18
            goto L1a
        L18:
            r3 = 0
            goto L25
        L1a:
            android.media.ExifInterface r0 = new android.media.ExifInterface     // Catch: java.io.IOException -> L18
            r0.<init>(r3)     // Catch: java.io.IOException -> L18
            java.lang.String r3 = "Orientation"
            int r3 = r0.getAttributeInt(r3, r2)     // Catch: java.io.IOException -> L18
        L25:
            r0 = 6
            if (r3 != r0) goto L2b
            r3 = 90
            return r3
        L2b:
            r0 = 3
            if (r3 != r0) goto L31
            r3 = 180(0xb4, float:2.52E-43)
            return r3
        L31:
            r0 = 8
            if (r3 != r0) goto L38
            r3 = 270(0x10e, float:3.78E-43)
            return r3
        L38:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexVideoClipItem.a(java.lang.String):int");
    }

    private void a(NexTimelineItem.r rVar) {
        if (this.i == null && !isImage() && !isSolid()) {
            String str = this.m_mediaPath;
            this.i = str == null ? null : MediaInfo.a(new File(str));
        }
        MediaInfo mediaInfo = this.i;
        if (mediaInfo == null || this.j != null || this.k || this.l) {
            return;
        }
        this.k = true;
        mediaInfo.H().onResultAvailable(new db(this, rVar)).onFailure((Task.OnFailListener) new bb(this));
    }

    private void a(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f2, NexTimelineItem.i iVar, boolean z3, float f3, int i, int i2, NexTimelineItem.r rVar) {
        throw new IllegalStateException();
    }

    private Matrix a(float f2, float f3, float f4, float f5) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(-f2, -f3);
        matrix.postScale(EditorGlobal.l() / (f4 - f2), 1.0f / (f5 - f3));
        return matrix;
    }

    private RectF a(Matrix matrix) {
        float[] fArr = {0.0f, 0.0f, this.m_width, this.m_height};
        matrix.mapPoints(fArr);
        RectF rectF = new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
        rectF.left = (int) (((0.0f - rectF.left) / rectF.width()) * this.m_width);
        rectF.top = (int) (((0.0f - rectF.top) / rectF.height()) * this.m_height);
        rectF.right = (int) (((EditorGlobal.l() - rectF.left) / rectF.width()) * this.m_width);
        rectF.bottom = (int) (((1.0f - rectF.top) / rectF.height()) * this.m_height);
        return rectF;
    }

    private a a(RectF rectF) {
        a aVar = new a(null);
        aVar.f24146a = this.m_effectStartTime;
        aVar.f24147b = this.m_effectEndTime;
        int representedDuration = getRepresentedDuration();
        if (aVar.f24146a < 0) {
            aVar.f24146a = 0;
        }
        int i = aVar.f24147b;
        if (i > representedDuration || i == 0) {
            aVar.f24147b = representedDuration;
        }
        int i2 = aVar.f24147b;
        int i3 = aVar.f24146a;
        if (i2 < i3 + 100) {
            aVar.f24147b = Math.min(representedDuration, i3 + 100);
        }
        float f2 = representedDuration;
        aVar.f24148c = (int) (rectF.left + ((aVar.f24146a * rectF.width()) / f2));
        aVar.f24149d = (int) (rectF.left + ((aVar.f24147b * rectF.width()) / f2));
        return aVar;
    }

    private a a(Rect rect) {
        a aVar = new a(null);
        aVar.f24146a = this.m_effectStartTime;
        aVar.f24147b = this.m_effectEndTime;
        int representedDuration = getRepresentedDuration();
        if (aVar.f24146a < 0) {
            aVar.f24146a = 0;
        }
        int i = aVar.f24147b;
        if (i > representedDuration || i == 0) {
            aVar.f24147b = representedDuration;
        }
        int i2 = aVar.f24147b;
        int i3 = aVar.f24146a;
        if (i2 < i3 + 100) {
            aVar.f24147b = Math.min(representedDuration, i3 + 100);
        }
        long j = representedDuration;
        aVar.f24148c = (int) (rect.left + ((aVar.f24146a * rect.width()) / j));
        aVar.f24149d = (int) (rect.left + ((aVar.f24147b * rect.width()) / j));
        return aVar;
    }

    private NexVideoClipItem(NexTransitionItem nexTransitionItem) {
        this.m_abstractCrop = false;
        this.m_transition = null;
        this.m_transition = nexTransitionItem;
        this.m_abstractCrop = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0062, code lost:            if (r1.length() > r2.length()) goto L26;     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0066, code lost:            r1 = r2;     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00f3, code lost:            if (r1.length() > r2.length()) goto L26;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.nextreaming.nexeditorui.NexVideoClipItem.b r9, android.content.Context r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 450
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexVideoClipItem.a(com.nextreaming.nexeditorui.NexVideoClipItem$b, android.content.Context, int, int):void");
    }

    private static String[] a(Context context) throws IOException {
        if (context == null) {
            return null;
        }
        return context.getAssets().list(com.nexstreaming.kinemaster.mediastore.item.a.m());
    }

    private KMProto.KMProject.Matrix a(float[] fArr) {
        KMProto.KMProject.Matrix.Builder builder = new KMProto.KMProject.Matrix.Builder();
        if (fArr == null) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        if (fArr != null) {
            builder.element = new ArrayList();
            for (float f2 : fArr) {
                builder.element.add(Float.valueOf(f2));
            }
        }
        return builder.build();
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

    private Bitmap a(Bitmap bitmap) {
        int i = this.m_rotation;
        if (i == 180) {
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas = new Canvas(createBitmap);
            if (this.m_fliph && this.m_flipv) {
                canvas.scale(-1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (this.m_fliph) {
                canvas.scale(-1.0f, 1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            } else if (this.m_flipv) {
                canvas.scale(1.0f, -1.0f, createBitmap.getWidth() / 2, createBitmap.getHeight() / 2);
            }
            canvas.rotate(180.0f, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
            canvas.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
            return createBitmap;
        }
        if (i == 0) {
            Bitmap createBitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.RGB_565);
            Canvas canvas2 = new Canvas(createBitmap2);
            if (this.m_fliph && this.m_flipv) {
                canvas2.scale(-1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (this.m_fliph) {
                canvas2.scale(-1.0f, 1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            } else if (this.m_flipv) {
                canvas2.scale(1.0f, -1.0f, createBitmap2.getWidth() / 2, createBitmap2.getHeight() / 2);
            }
            canvas2.drawBitmap(bitmap, (Rect) null, new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()), (Paint) null);
            return createBitmap2;
        }
        if (i == 90) {
            Bitmap createBitmap3 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
            Canvas canvas3 = new Canvas(createBitmap3);
            if (this.m_fliph && this.m_flipv) {
                canvas3.scale(-1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (this.m_fliph) {
                canvas3.scale(1.0f, -1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            } else if (this.m_flipv) {
                canvas3.scale(-1.0f, 1.0f, createBitmap3.getWidth() / 2, createBitmap3.getHeight() / 2);
            }
            canvas3.rotate(270.0f, 0.0f, 0.0f);
            canvas3.drawBitmap(bitmap, (Rect) null, new Rect(-bitmap.getWidth(), 0, 0, bitmap.getHeight()), (Paint) null);
            return createBitmap3;
        }
        if (i != 270) {
            return bitmap;
        }
        Bitmap createBitmap4 = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Bitmap.Config.RGB_565);
        Canvas canvas4 = new Canvas(createBitmap4);
        if (this.m_fliph && this.m_flipv) {
            canvas4.scale(-1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (this.m_fliph) {
            canvas4.scale(1.0f, -1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        } else if (this.m_flipv) {
            canvas4.scale(-1.0f, 1.0f, createBitmap4.getWidth() / 2, createBitmap4.getHeight() / 2);
        }
        canvas4.rotate(90.0f, 0.0f, 0.0f);
        canvas4.drawBitmap(bitmap, (Rect) null, new Rect(0, -bitmap.getHeight(), bitmap.getWidth(), 0), (Paint) null);
        return createBitmap4;
    }
}
