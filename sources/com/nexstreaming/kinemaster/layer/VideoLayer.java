package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.h;
import com.nexstreaming.app.general.util.l;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediainfo.aq;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.ui.projectedit.ay;
import com.nexstreaming.kinemaster.ui.projectedit.bo;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.ui.projectedit.nb;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexRectangle;
import com.nextreaming.nexvideoeditor.NexVisualClip;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: classes.dex */
public class VideoLayer extends MediaLayer implements nb, NexTimelineItem.b, NexTimelineItem.c, NexTimelineItem.d, NexTimelineItem.e, NexTimelineItem.f, NexTimelineItem.g {

    /* renamed from: a, reason: collision with root package name */
    private transient int f3475a;
    private transient int b;
    private transient boolean c;
    private transient MediaInfo d;
    private transient aq e;
    private transient int f;
    private String filePath;
    private transient boolean g;
    private transient Bitmap h;
    private transient Bitmap i;
    private transient NexExportProfile j;
    private int m_Brightness;
    private int m_Contrast;
    private int m_Saturation;
    private float[] m_chromaKeyDivisions;
    private boolean m_chromaKeyEnabled;
    private boolean m_chromaKeyMaskEnabled;
    private float[] m_chromaKeyStrengths;
    private ColorEffect m_colorEffect;
    private int m_engineClipID;
    private boolean m_hasAudio;
    private boolean m_hasVideo;
    private int m_originalClipDuration;
    private int m_originalVideoHeight;
    private int m_originalVideoWidth;
    private ArrayList<Integer> m_volumeEnvelopeLevel;
    private ArrayList<Integer> m_volumeEnvelopeTime;
    private boolean m_muteAudio = false;
    private int m_clipVolume = 100;
    private int m_playbackSpeed = 100;
    private int m_chromaKeyColor = 0;
    private float m_chromaKeyClipFG = 0.72f;
    private float m_chromaKeyClipBG = 0.5f;
    private float m_chromaKeyBlend_x0 = 0.25f;
    private float m_chromaKeyBlend_y0 = 0.25f;
    private float m_chromaKeyBlend_x1 = 0.75f;
    private float m_chromaKeyBlend_y1 = 0.75f;
    private int m_voiceChanger = 0;
    private int m_audioCompressor = 0;
    private int m_pitchFactor = 0;
    private int m_audioPanLeft = -111;
    private int m_audioPanRight = -111;

    public VideoLayer() {
        if (this.m_volumeEnvelopeTime == null) {
            this.m_volumeEnvelopeTime = new ArrayList<>();
        }
        if (this.m_volumeEnvelopeLevel == null) {
            this.m_volumeEnvelopeLevel = new ArrayList<>();
        }
    }

    public static VideoLayer fromMediaStoreItem(MediaStoreItem mediaStoreItem) {
        MediaInfo a2 = MediaInfo.a(mediaStoreItem.h());
        VideoLayer videoLayer = new VideoLayer();
        videoLayer.m_originalClipDuration = a2.r() ? Math.min(a2.z(), a2.A()) : a2.A();
        videoLayer.m_originalVideoWidth = mediaStoreItem.j();
        videoLayer.m_originalVideoHeight = mediaStoreItem.k();
        videoLayer.m_hasVideo = true;
        videoLayer.m_hasAudio = mediaStoreItem.t();
        videoLayer.m_engineClipID = 0;
        videoLayer.filePath = mediaStoreItem.h();
        videoLayer.m_chromaKeyDivisions = new float[]{0.05f, 0.3f, 0.5f, 0.65f};
        videoLayer.m_chromaKeyStrengths = new float[]{0.0f, 0.25f, 0.75f, 1.0f};
        videoLayer.m_chromaKeyEnabled = false;
        videoLayer.m_chromaKeyColor = 0;
        return videoLayer;
    }

    public void changeMediaPathAfterTranscode(String str) {
        MediaInfo a2 = MediaInfo.a(str);
        this.m_originalClipDuration = a2.r() ? Math.min(a2.z(), a2.A()) : a2.A();
        this.m_originalVideoWidth = a2.w();
        this.m_originalVideoHeight = a2.x();
        this.m_hasVideo = true;
        this.m_hasAudio = a2.r();
        this.filePath = str;
        this.f = 0;
    }

    public void setEngineClipID(int i) {
        if (this.m_engineClipID != 0) {
            throw new IllegalStateException("Engine clip ID already set");
        }
        this.m_engineClipID = i;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAwake(LayerRenderer layerRenderer) {
        b();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.h = null;
        this.i = null;
    }

    private Bitmap a(Drawable drawable) {
        int i = 100;
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            intrinsicHeight = 100;
        } else {
            i = intrinsicWidth;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, i, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar) {
        layerRenderer.l();
        if (this.m_colorEffect != null && !getChromaKeyMaskEnabled()) {
            layerRenderer.a(this.m_colorEffect.getLut());
        }
        if (getChromaKeyEnabled()) {
            layerRenderer.b(getChromaKeyEnabled());
            layerRenderer.c(getChromaKeyMaskEnabled());
            layerRenderer.a(this.m_chromaKeyColor, this.m_chromaKeyClipFG, this.m_chromaKeyClipBG, this.m_chromaKeyBlend_x0, this.m_chromaKeyBlend_y0, this.m_chromaKeyBlend_x1, this.m_chromaKeyBlend_y1);
        }
        if (getOverLimit()) {
            if (this.h == null) {
                this.h = a(KineMasterApplication.a().getApplicationContext().getResources().getDrawable(R.drawable.stripes_tile));
            }
            if (this.i == null && this.e != null) {
                this.i = this.e.b(0, 0, false, false);
            }
            if (this.i != null) {
                layerRenderer.a(this.i, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
                layerRenderer.b(861230421, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
            } else {
                layerRenderer.b(-6710887, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
            }
            layerRenderer.d(0.5f);
            layerRenderer.a(this.h, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2, (getWidth() * bVar.b) / this.h.getWidth(), (getHeight() * bVar.b) / this.h.getHeight());
        } else {
            int b = EditorGlobal.a().b(layerRenderer.w().id, this.m_engineClipID);
            if (b != 0) {
                layerRenderer.a(com.nexstreaming.app.general.c.a.a(getCombinedBrightness() / 255.0f, getCombinedContrast() / 255.0f, getCombinedSaturation() / 255.0f, this.m_colorEffect != null ? this.m_colorEffect.getTintColor() : 0));
                layerRenderer.a(b, 0.0f, 0.0f, getWidth(), getHeight());
            }
        }
        layerRenderer.b(false);
        layerRenderer.a((Bitmap) null);
        layerRenderer.m();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f, float f2, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f >= ((float) i2) && f <= ((float) width) && f2 >= ((float) i3) && f2 <= ((float) (getHeight() + i3));
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return true;
    }

    private MediaInfo a() {
        if (this.d == null) {
            this.d = MediaInfo.a(this.filePath);
        }
        return this.d;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        return this.filePath == null ? context.getResources().getString(R.string.layer_menu_video) : new File(this.filePath).getName();
    }

    private void b() {
        if (!this.c) {
            this.f3475a = this.m_originalVideoWidth;
            this.b = this.m_originalVideoHeight;
            this.c = true;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return this.filePath == null ? "" : new File(this.filePath).getName();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        return (getStartTrim() == 0 && getEndTrim() == 0) ? this.m_originalVideoWidth + "×" + this.m_originalVideoHeight + "  " + EditorGlobal.b(getDuration()) : this.m_originalVideoWidth + "×" + this.m_originalVideoHeight + "  " + EditorGlobal.b(getDuration()) + " " + context.getResources().getString(R.string.video_trimmed);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_text;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_video;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        b();
        return this.f3475a;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        b();
        return this.b;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public int getOriginalHeight() {
        return this.m_originalVideoHeight;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public int getOriginalWidth() {
        return this.m_originalVideoWidth;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.VideoLayer.Builder builder = new KMProto.KMProject.VideoLayer.Builder();
        builder.brightness = Integer.valueOf(this.m_Brightness);
        builder.contrast = Integer.valueOf(this.m_Contrast);
        builder.saturation = Integer.valueOf(this.m_Saturation);
        builder.color_effect = this.m_colorEffect == null ? null : this.m_colorEffect.asProtoBuf();
        builder.video_path = this.filePath;
        builder.layer_common = getLayerCommonProtoBuf();
        builder.clip_volume = Integer.valueOf(this.m_clipVolume);
        builder.engine_clip_id = Integer.valueOf(this.m_engineClipID);
        builder.has_audio = Boolean.valueOf(this.m_hasAudio);
        builder.has_video = Boolean.valueOf(this.m_hasVideo);
        builder.mute_audio = Boolean.valueOf(this.m_muteAudio);
        builder.playback_speed = Integer.valueOf(this.m_playbackSpeed);
        builder.original_clip_duration = Integer.valueOf(this.m_originalClipDuration);
        builder.original_video_width = Integer.valueOf(this.m_originalVideoWidth);
        builder.original_video_height = Integer.valueOf(this.m_originalVideoHeight);
        builder.chroma_key_divisions(h.a(this.m_chromaKeyDivisions));
        builder.chroma_key_strengths(h.a(this.m_chromaKeyStrengths));
        builder.chroma_key_clip_bg = Float.valueOf(this.m_chromaKeyClipBG);
        builder.chroma_key_clip_fg = Float.valueOf(this.m_chromaKeyClipFG);
        builder.chroma_key_blend_x0 = Float.valueOf(this.m_chromaKeyBlend_x0);
        builder.chroma_key_blend_y0 = Float.valueOf(this.m_chromaKeyBlend_y0);
        builder.chroma_key_blend_x1 = Float.valueOf(this.m_chromaKeyBlend_x1);
        builder.chroma_key_blend_y1 = Float.valueOf(this.m_chromaKeyBlend_y1);
        builder.chroma_key_color = Integer.valueOf(this.m_chromaKeyColor);
        builder.chroma_key_enabled = Boolean.valueOf(this.m_chromaKeyEnabled);
        builder.voice_changer = Integer.valueOf(this.m_voiceChanger);
        builder.pan_left = Integer.valueOf(getAudioLeftVolume());
        builder.pan_right = Integer.valueOf(getAudioRightVolume());
        builder.compressor = Integer.valueOf(this.m_audioCompressor);
        builder.pitch_factor = Integer.valueOf(this.m_pitchFactor);
        if (this.m_volumeEnvelopeTime != null && this.m_volumeEnvelopeLevel != null) {
            builder.volume_envelope_time(this.m_volumeEnvelopeTime);
            builder.volume_envelope_level(this.m_volumeEnvelopeLevel);
        }
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_VIDEO).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).video_layer(builder.build()).build();
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        KMProto.KMProject.VideoLayer videoLayer = timelineItem.video_layer;
        VideoLayer videoLayer2 = new VideoLayer();
        videoLayer2.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        videoLayer2.m_Brightness = timelineItem.video_layer.brightness.intValue();
        videoLayer2.m_Contrast = timelineItem.video_layer.contrast.intValue();
        videoLayer2.m_Saturation = timelineItem.video_layer.saturation.intValue();
        videoLayer2.m_colorEffect = ColorEffect.fromProtoBuf(timelineItem.video_layer.color_effect);
        videoLayer2.filePath = timelineItem.video_layer.video_path;
        videoLayer2.m_clipVolume = timelineItem.video_layer.clip_volume.intValue();
        videoLayer2.m_engineClipID = timelineItem.video_layer.engine_clip_id.intValue();
        videoLayer2.m_hasAudio = timelineItem.video_layer.has_audio.booleanValue();
        videoLayer2.m_hasVideo = timelineItem.video_layer.has_video.booleanValue();
        videoLayer2.m_muteAudio = timelineItem.video_layer.mute_audio.booleanValue();
        videoLayer2.m_playbackSpeed = timelineItem.video_layer.playback_speed.intValue();
        videoLayer2.m_originalClipDuration = timelineItem.video_layer.original_clip_duration.intValue();
        videoLayer2.m_originalVideoWidth = timelineItem.video_layer.original_video_width.intValue();
        videoLayer2.m_originalVideoHeight = timelineItem.video_layer.original_video_height.intValue();
        videoLayer2.m_chromaKeyEnabled = timelineItem.video_layer.chroma_key_enabled == null ? false : timelineItem.video_layer.chroma_key_enabled.booleanValue();
        videoLayer2.m_chromaKeyColor = timelineItem.video_layer.chroma_key_color == null ? 0 : timelineItem.video_layer.chroma_key_color.intValue();
        videoLayer2.m_chromaKeyClipBG = timelineItem.video_layer.chroma_key_clip_bg == null ? 0.5f : timelineItem.video_layer.chroma_key_clip_bg.floatValue();
        videoLayer2.m_chromaKeyClipFG = timelineItem.video_layer.chroma_key_clip_fg == null ? 0.72f : timelineItem.video_layer.chroma_key_clip_fg.floatValue();
        videoLayer2.m_chromaKeyBlend_x0 = timelineItem.video_layer.chroma_key_blend_x0 == null ? 0.25f : timelineItem.video_layer.chroma_key_blend_x0.floatValue();
        videoLayer2.m_chromaKeyBlend_y0 = timelineItem.video_layer.chroma_key_blend_y0 != null ? timelineItem.video_layer.chroma_key_blend_y0.floatValue() : 0.25f;
        videoLayer2.m_chromaKeyBlend_x1 = timelineItem.video_layer.chroma_key_blend_x1 == null ? 0.75f : timelineItem.video_layer.chroma_key_blend_x1.floatValue();
        videoLayer2.m_chromaKeyBlend_y1 = timelineItem.video_layer.chroma_key_blend_y1 != null ? timelineItem.video_layer.chroma_key_blend_y1.floatValue() : 0.75f;
        videoLayer2.m_voiceChanger = timelineItem.video_layer.voice_changer == null ? 0 : timelineItem.video_layer.voice_changer.intValue();
        videoLayer2.m_audioPanLeft = timelineItem.video_layer.pan_left == null ? videoLayer2.getAudioLeftVolume() : videoLayer.pan_left.intValue();
        videoLayer2.m_audioPanRight = timelineItem.video_layer.pan_right == null ? videoLayer2.getAudioRightVolume() : videoLayer.pan_right.intValue();
        videoLayer2.m_audioCompressor = timelineItem.video_layer.compressor == null ? 0 : videoLayer.compressor.intValue();
        videoLayer2.m_pitchFactor = timelineItem.video_layer.pitch_factor != null ? videoLayer.pitch_factor.intValue() : 0;
        if (timelineItem.video_layer.chroma_key_divisions != null && timelineItem.video_layer.chroma_key_divisions.size() == 4) {
            videoLayer2.m_chromaKeyDivisions = h.a(timelineItem.video_layer.chroma_key_divisions);
        } else {
            videoLayer2.m_chromaKeyDivisions = new float[]{0.05f, 0.3f, 0.5f, 0.65f};
        }
        if (timelineItem.video_layer.chroma_key_strengths != null && timelineItem.video_layer.chroma_key_strengths.size() == 4) {
            videoLayer2.m_chromaKeyStrengths = h.a(timelineItem.video_layer.chroma_key_strengths);
        } else {
            videoLayer2.m_chromaKeyStrengths = new float[]{0.0f, 0.25f, 0.75f, 1.0f};
        }
        if (timelineItem.video_layer.volume_envelope_time != null && timelineItem.video_layer.volume_envelope_level != null) {
            videoLayer2.m_volumeEnvelopeTime = new ArrayList<>(timelineItem.video_layer.volume_envelope_time);
            videoLayer2.m_volumeEnvelopeLevel = new ArrayList<>(timelineItem.video_layer.volume_envelope_level);
        }
        if (videoLayer2.m_volumeEnvelopeTime == null) {
            videoLayer2.m_volumeEnvelopeTime = new ArrayList<>();
        }
        if (videoLayer2.m_volumeEnvelopeLevel == null) {
            videoLayer2.m_volumeEnvelopeLevel = new ArrayList<>();
        }
        fromProtoBuf(timelineItem.video_layer.layer_common, videoLayer2);
        return videoLayer2;
    }

    public NexVisualClip asNexVisualClip() {
        NexVisualClip nexVisualClip = new NexVisualClip();
        nexVisualClip.mClipID = this.m_engineClipID;
        nexVisualClip.mClipType = 7;
        nexVisualClip.mTotalTime = this.m_originalClipDuration;
        nexVisualClip.mStartTime = getAbsStartTime();
        nexVisualClip.mEndTime = getAbsEndTime();
        nexVisualClip.mStartTrimTime = getStartTrim();
        nexVisualClip.mEndTrimTime = getEndTrim();
        nexVisualClip.mWidth = this.m_originalVideoWidth;
        nexVisualClip.mHeight = this.m_originalVideoHeight;
        nexVisualClip.mExistVideo = this.m_hasVideo ? 1 : 0;
        nexVisualClip.mExistAudio = this.m_hasAudio ? 1 : 0;
        nexVisualClip.mTitleStartTime = getAbsStartTime();
        nexVisualClip.mTitleEndTime = getAbsEndTime();
        if (this.m_colorEffect != null) {
            nexVisualClip.mBrightness = getCombinedBrightness();
            nexVisualClip.mContrast = getCombinedContrast();
            nexVisualClip.mSaturation = getCombinedSaturation();
            nexVisualClip.mTintcolor = this.m_colorEffect.getTintColor();
            nexVisualClip.mLUT = 0;
            nexVisualClip.mVignette = 0;
        } else {
            nexVisualClip.mBrightness = this.m_Brightness;
            nexVisualClip.mContrast = this.m_Contrast;
            nexVisualClip.mSaturation = this.m_Saturation;
            nexVisualClip.mTintcolor = 0;
            nexVisualClip.mLUT = 0;
            nexVisualClip.mVignette = 0;
        }
        nexVisualClip.mBGMVolume = 100;
        nexVisualClip.mAudioOnOff = this.m_muteAudio ? 0 : 1;
        nexVisualClip.mClipVolume = this.m_clipVolume;
        nexVisualClip.mEffectDuration = 0;
        nexVisualClip.mClipEffectID = "none";
        nexVisualClip.mTitleEffectID = null;
        nexVisualClip.mStartRect = new NexRectangle(0, 0, NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
        nexVisualClip.mEndRect = new NexRectangle(0, 0, NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
        nexVisualClip.mClipPath = this.filePath;
        nexVisualClip.mThumbnailPath = null;
        nexVisualClip.mRotateState = 0;
        nexVisualClip.mEffectOffset = 0;
        nexVisualClip.mEffectOverlap = 0;
        nexVisualClip.mSpeedControl = this.m_playbackSpeed == 0 ? 100 : this.m_playbackSpeed;
        nexVisualClip.mVoiceChanger = this.m_voiceChanger;
        nexVisualClip.mCompressor = this.m_audioCompressor;
        nexVisualClip.mPitchFactor = this.m_pitchFactor;
        nexVisualClip.mPanLeft = getAudioLeftVolume();
        nexVisualClip.mPanRight = getAudioRightVolume();
        if (this.m_volumeEnvelopeLevel != null) {
            ArrayList arrayList = new ArrayList(this.m_volumeEnvelopeLevel.size() + 2);
            ArrayList arrayList2 = new ArrayList(this.m_volumeEnvelopeLevel.size() + 2);
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (i >= this.m_volumeEnvelopeLevel.size()) {
                    break;
                }
                int volumeEnvelopeTimeAdj = getVolumeEnvelopeTimeAdj(i);
                int volumeEnvelopeLevel = getVolumeEnvelopeLevel(i);
                int representedDuration = getRepresentedDuration();
                if (volumeEnvelopeTimeAdj <= representedDuration && volumeEnvelopeTimeAdj > 0) {
                    if (arrayList.isEmpty()) {
                        arrayList.add(0);
                        arrayList2.add(Integer.valueOf((int) (i2 + (((getStartTrim() - (getStartTrim() + i3)) / ((getStartTrim() + volumeEnvelopeTimeAdj) - (i3 + getStartTrim()))) * (volumeEnvelopeLevel - i2)))));
                    }
                    arrayList.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList2.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj <= representedDuration && volumeEnvelopeLevel > 0 && volumeEnvelopeTimeAdj == 0) {
                    arrayList.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList2.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj > representedDuration && getStartTrim() > 0) {
                    if (arrayList.isEmpty()) {
                        arrayList.add(0);
                        arrayList2.add(Integer.valueOf((int) ((((getStartTrim() - (getStartTrim() + i3)) / ((getStartTrim() + volumeEnvelopeTimeAdj) - (getStartTrim() + i3))) * (volumeEnvelopeLevel - i2)) + i2)));
                    }
                    arrayList.add(Integer.valueOf(representedDuration));
                    arrayList2.add(Integer.valueOf((int) ((((representedDuration - i3) / (volumeEnvelopeTimeAdj - i3)) * (volumeEnvelopeLevel - i2)) + i2)));
                }
                i++;
                i2 = volumeEnvelopeLevel;
                i3 = volumeEnvelopeTimeAdj;
            }
            nexVisualClip.mVolumeEnvelopeTime = l.a(arrayList);
            nexVisualClip.mVolumeEnvelopeLevel = l.a(arrayList2);
        }
        return nexVisualClip;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        return this.m_originalClipDuration;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends kp> getOptionMenuClass() {
        return bo.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setBrightness(int i) {
        this.m_Brightness = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setContrast(int i) {
        this.m_Contrast = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setSaturation(int i) {
        this.m_Saturation = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getBrightness() {
        return this.m_Brightness;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getContrast() {
        return this.m_Contrast;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getSaturation() {
        return this.m_Saturation;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getCombinedBrightness() {
        return this.m_colorEffect == null ? this.m_Brightness : this.m_Brightness + ((int) (255.0f * this.m_colorEffect.getBrightness()));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getCombinedContrast() {
        return this.m_colorEffect == null ? this.m_Contrast : this.m_Contrast + ((int) (255.0f * this.m_colorEffect.getContrast()));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getCombinedSaturation() {
        return this.m_colorEffect == null ? this.m_Saturation : this.m_Saturation + ((int) (255.0f * this.m_colorEffect.getSaturation()));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public void setColorEffect(ColorEffect colorEffect) {
        this.m_colorEffect = colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public ColorEffect getColorEffect() {
        return this.m_colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean checkResourceState(Context context) {
        return (this.filePath.startsWith("@solid:") && this.filePath.endsWith(".jpg")) || new File(this.filePath).exists();
    }

    public int getEngineClipID() {
        return this.m_engineClipID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setClipVolume(int i) {
        this.m_clipVolume = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public int getClipVolume() {
        return this.m_clipVolume;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setMuteAudio(boolean z) {
        this.m_muteAudio = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public boolean getMuteAudio() {
        return this.m_muteAudio;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setAudioCompressor(boolean z) {
        if (z) {
            this.m_audioCompressor = 4;
        } else {
            this.m_audioCompressor = 0;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public boolean isCheckedAudioCompressor() {
        return this.m_audioCompressor > 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setAudioPitch(int i) {
        this.m_pitchFactor = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public int getAudioPitch() {
        return this.m_pitchFactor;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setAudioLeftVolume(int i) {
        this.m_audioPanLeft = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public int getAudioLeftVolume() {
        if (this.m_audioPanLeft < -100) {
            MediaInfo a2 = MediaInfo.a(getMediaPath());
            if (a2 != null && a2.I() >= 2) {
                this.m_audioPanLeft = -100;
            } else {
                this.m_audioPanLeft = 0;
            }
        }
        return this.m_audioPanLeft;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setAudioRightVolume(int i) {
        this.m_audioPanRight = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public int getAudioRightVolume() {
        if (this.m_audioPanRight < -100) {
            this.m_audioPanRight = 100;
        }
        return this.m_audioPanRight;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
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

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public void changeVolumeLevel(int i, int i2) {
        this.m_volumeEnvelopeLevel.set(i, Integer.valueOf(i2));
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public void removeVolumeEnvelope(int i) {
        if (this.m_volumeEnvelopeLevel != null && this.m_volumeEnvelopeTime != null) {
            this.m_volumeEnvelopeTime.remove(i);
            this.m_volumeEnvelopeLevel.remove(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getVolumeEnvelopeLength() {
        return this.m_volumeEnvelopeTime.size();
    }

    public int getVolumeEnvelopeTime(int i) {
        if (this.m_volumeEnvelopeTime == null || this.m_volumeEnvelopeTime.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getVolumeEnvelopeTimeAdj(int i) {
        if (this.m_volumeEnvelopeTime == null || this.m_volumeEnvelopeTime.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue() - getStartTrim();
    }

    public int getVolumeEnvelopeTimeForDrawing(int i) {
        if (this.m_volumeEnvelopeTime == null || this.m_volumeEnvelopeTime.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue() - getStartTrim();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getVolumeEnvelopeLevel(int i) {
        if (this.m_volumeEnvelopeLevel == null || this.m_volumeEnvelopeLevel.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeLevel.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getEndEnvelopeTime() {
        return this.m_originalClipDuration;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getDiffAVDuration() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected boolean drawThumbnails(ay ayVar, Canvas canvas, RectF rectF) {
        if (this.e == null && !this.g) {
            MediaInfo a2 = a();
            if (a2 == null) {
                return false;
            }
            this.g = true;
            a2.b().onResultAvailable(new b(this, ayVar.a())).onFailure((Task.OnFailListener) new a(this));
        }
        if (this.e == null) {
            return false;
        }
        int startTime = getStartTime();
        int endTime = getEndTime();
        int startTrim = getStartTrim();
        int i = endTime - startTime;
        int b = this.e.b(0);
        int c = this.e.c(0);
        float height = rectF.height();
        rectF.top -= height / 2.0f;
        rectF.bottom = (height / 2.0f) + rectF.bottom;
        int height2 = (int) (((b * rectF.height()) / c) + 0.5f);
        int i2 = (int) rectF.left;
        int i3 = (int) (rectF.right + height2 + 1.0f);
        canvas.save();
        canvas.clipRect(rectF);
        for (int i4 = i2; i4 < i3; i4 += height2) {
            int i5 = (((i4 - i2) * i) / (i3 - i2)) + startTrim;
            rectF.left = i4;
            rectF.right = i4 + height2;
            if (!canvas.quickReject(rectF, Canvas.EdgeType.AA)) {
                canvas.drawBitmap(this.e.a(0, i5, false, false), (Rect) null, rectF, (Paint) null);
            }
        }
        canvas.restore();
        return true;
    }

    public int getFPS() {
        if (this.f == 0) {
            this.f = MediaInfo.a(this.filePath).B();
            if (this.f <= 0) {
                this.f = 30;
            }
        }
        return this.f;
    }

    public void setEngineClipIDAfterDuplicate(int i) {
        this.m_engineClipID = i;
    }

    public void setPlaybackSpeed(int i) {
        this.m_playbackSpeed = i;
    }

    public int getPlaybackSpeed() {
        if (this.m_playbackSpeed == 0) {
            return 100;
        }
        return this.m_playbackSpeed;
    }

    public boolean getHasAudio() {
        return this.m_hasAudio;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAudioTrackUsage() {
        return (!getHasAudio() || getMuteAudio() || getClipVolume() <= 0) ? 0 : 1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoTrackUsage() {
        return 1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecMemoryUsage() {
        return ((((((this.m_originalVideoWidth * this.m_originalVideoHeight) * 150) / 100) * Math.max(30, getFPS())) / 30) * 100) / Math.max(100, getPlaybackSpeed());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public MediaStoreItem.MediaSupportType getMediaSupportType() {
        return MediaInfo.a(this.filePath).n();
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public String getMediaPath() {
        return this.filePath;
    }

    public void setPreferredTranscodingProfile(NexExportProfile nexExportProfile) {
        this.j = nexExportProfile;
    }

    public NexExportProfile getPreferredTranscodingProfile() {
        return this.j;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public int[] getChromaKeyRecommendedColors() {
        Bitmap b;
        if (this.e != null && (b = this.e.b(0, 0, false, false)) != null) {
            float[] fArr = new float[3];
            int[] iArr = new int[360];
            int[] iArr2 = new int[b.getWidth() * b.getHeight()];
            b.getPixels(iArr2, 0, b.getWidth(), 0, 0, b.getWidth(), b.getHeight());
            for (int i : iArr2) {
                Color.colorToHSV(i, fArr);
                if (fArr[1] >= 0.3f && fArr[2] >= 0.2f) {
                    int i2 = ((int) ((fArr[0] / 360.0f) * 360.0f)) % 360;
                    iArr[i2] = iArr[i2] + 1;
                }
            }
            int[] iArr3 = new int[14];
            int i3 = 0;
            for (int i4 = 0; i4 < iArr3.length; i4++) {
                int i5 = -1;
                int i6 = -1;
                for (int i7 = 0; i7 < 360; i7++) {
                    if (iArr[i7] > i5) {
                        i5 = iArr[i7];
                        i6 = i7;
                    }
                }
                if (i6 < 0 || i5 < 5) {
                    break;
                }
                fArr[0] = (i6 * 360) / 360;
                fArr[1] = 1.0f;
                fArr[2] = 1.0f;
                iArr3[i3] = Color.HSVToColor(fArr);
                i3++;
                for (int i8 = i6 - 3; i8 < i6 + 3; i8++) {
                    iArr[(i8 + 360) % 360] = -1;
                }
            }
            if (i3 >= iArr3.length) {
                return iArr3;
            }
            int[] iArr4 = new int[i3];
            System.arraycopy(iArr3, 0, iArr4, 0, i3);
            return iArr4;
        }
        return new int[0];
    }

    public void getChromaKeyDivisions(float[] fArr) {
        System.arraycopy(this.m_chromaKeyDivisions, 0, fArr, 0, this.m_chromaKeyDivisions.length);
    }

    public void getChromaKeyStrengths(float[] fArr) {
        System.arraycopy(this.m_chromaKeyStrengths, 0, fArr, 0, this.m_chromaKeyStrengths.length);
    }

    public void setChromaKeyDivisions(float[] fArr) {
        System.arraycopy(fArr, 0, this.m_chromaKeyDivisions, 0, this.m_chromaKeyDivisions.length);
    }

    public void setChromaKeyStrengths(float[] fArr) {
        System.arraycopy(fArr, 0, this.m_chromaKeyStrengths, 0, this.m_chromaKeyStrengths.length);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public int getChromaKeyColor() {
        if (this.m_chromaKeyColor == 0) {
            int[] chromaKeyRecommendedColors = getChromaKeyRecommendedColors();
            if (chromaKeyRecommendedColors.length > 0) {
                this.m_chromaKeyColor = chromaKeyRecommendedColors[0];
            } else {
                this.m_chromaKeyColor = -16711936;
            }
        }
        return this.m_chromaKeyColor;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void setChromaKeyColor(int i) {
        this.m_chromaKeyColor = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public boolean getChromaKeyEnabled() {
        return this.m_chromaKeyEnabled;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void setChromaKeyMaskEnabled(boolean z) {
        this.m_chromaKeyMaskEnabled = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public boolean getChromaKeyMaskEnabled() {
        return this.m_chromaKeyMaskEnabled;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void setChromaKeyEnabled(boolean z) {
        this.m_chromaKeyEnabled = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void setChromaKeyFGClip(float f) {
        this.m_chromaKeyClipFG = f;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void setChromaKeyBGClip(float f) {
        this.m_chromaKeyClipBG = f;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public float getChromaKeyFGClip() {
        return this.m_chromaKeyClipFG;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public float getChromaKeyBGClip() {
        return this.m_chromaKeyClipBG;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void setChromaKeyBlend(float[] fArr) {
        this.m_chromaKeyBlend_x0 = fArr[0];
        this.m_chromaKeyBlend_y0 = fArr[1];
        this.m_chromaKeyBlend_x1 = fArr[2];
        this.m_chromaKeyBlend_y1 = fArr[3];
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.c
    public void getChromaKeyBlend(float[] fArr) {
        fArr[0] = this.m_chromaKeyBlend_x0;
        fArr[1] = this.m_chromaKeyBlend_y0;
        fArr[2] = this.m_chromaKeyBlend_x1;
        fArr[3] = this.m_chromaKeyBlend_y1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getColorOption(int i) {
        return i == R.id.opt_chroma_key_color ? getChromaKeyColor() : super.getColorOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_chroma_key_color) {
            this.m_chromaKeyColor = i2;
        } else {
            super.setColorOption(i, i2);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean getSwitchOption(int i) {
        return i == R.id.opt_chroma_key_color ? getChromaKeyEnabled() : super.getSwitchOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_chroma_key_color) {
            this.m_chromaKeyEnabled = z;
            return null;
        }
        super.setSwitchOption(i, z, context);
        return null;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_chroma_key /* 2131820640 */:
                return getChromaKeyEnabled();
            default:
                return super.isOptionApplied(i);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setAudioEffect(int i) {
        this.m_voiceChanger = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public int getAudioEffect() {
        return this.m_voiceChanger;
    }
}
