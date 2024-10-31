package com.nexstreaming.kinemaster.layer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1708l;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.general.util.q;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediainfo.T;
import com.nexstreaming.kinemaster.mediastore.MediaSupportType;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.C1916ib;
import com.nexstreaming.kinemaster.ui.projectedit.Mb;
import com.nexstreaming.kinemaster.ui.projectedit.Vh;
import com.nexstreaming.kinemaster.ui.projectedit.audioeffect.t;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nexstreaming.kinemaster.ui.widget.KeyFrameDrawingView;
import com.nexstreaming.kinemaster.ui.widget.OverLimitView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.LayerRenderer;
import com.nextreaming.nexvideoeditor.NexAudioClip;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexRectangle;
import com.nextreaming.nexvideoeditor.NexVisualClip;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes.dex */
public class VideoLayer extends MediaLayer implements NexTimelineItem.f, NexTimelineItem.h, NexTimelineItem.g, NexTimelineItem.e, NexTimelineItem.d, Vh, NexTimelineItem.b {
    private String filePath;
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
    private transient int n;
    private transient int o;
    private transient boolean p;
    private transient MediaInfo q;
    private transient T r;
    private transient int s;
    private transient boolean t;
    private transient Bitmap u;
    private transient Bitmap v;
    private transient NexExportProfile w;
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
    private String m_enhancedAudioFilter = null;
    private String m_equalizer = null;
    private int[] effect_id_ = {-1, -1};
    private int[] current_blend_mode_ = {0, 0};

    public VideoLayer() {
        if (this.m_volumeEnvelopeTime == null) {
            this.m_volumeEnvelopeTime = new ArrayList<>();
        }
        if (this.m_volumeEnvelopeLevel == null) {
            this.m_volumeEnvelopeLevel = new ArrayList<>();
        }
    }

    private Bitmap a(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            intrinsicWidth = 100;
            intrinsicHeight = 100;
        }
        Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        drawable.draw(canvas);
        return createBitmap;
    }

    private void f() {
        if (this.p) {
            return;
        }
        this.n = this.m_originalVideoWidth;
        this.o = this.m_originalVideoHeight;
        this.p = true;
    }

    public static VideoLayer fromMediaStoreItem(com.nexstreaming.kinemaster.mediastore.item.c cVar) {
        MediaInfo a2 = MediaInfo.a(cVar.getPath());
        VideoLayer videoLayer = new VideoLayer();
        videoLayer.m_originalClipDuration = a2.S() ? Math.min(a2.o(), a2.K()) : a2.K();
        videoLayer.m_originalVideoWidth = a2.R();
        videoLayer.m_originalVideoHeight = a2.v();
        videoLayer.m_hasVideo = true;
        videoLayer.m_hasAudio = cVar.f();
        videoLayer.m_engineClipID = 0;
        videoLayer.filePath = cVar.getPath();
        videoLayer.m_chromaKeyDivisions = new float[]{0.05f, 0.3f, 0.5f, 0.65f};
        videoLayer.m_chromaKeyStrengths = new float[]{0.0f, 0.25f, 0.75f, 1.0f};
        videoLayer.m_chromaKeyEnabled = false;
        videoLayer.m_chromaKeyColor = 0;
        videoLayer.setSplitScreenType(c.d.b.l.a.f3846a.a());
        if (videoLayer.getSplitScreenType() != SplitScreenType.OFF) {
            videoLayer.fitKeyframeToSplitscreenRect(videoLayer.getSplitScreenKeyframe());
        }
        return videoLayer;
    }

    public static NexSecondaryTimelineItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        KMProto.KMProject.VideoLayer videoLayer = timelineItem.video_layer;
        VideoLayer videoLayer2 = new VideoLayer();
        videoLayer2.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        videoLayer2.m_Brightness = timelineItem.video_layer.brightness.intValue();
        videoLayer2.m_Contrast = timelineItem.video_layer.contrast.intValue();
        videoLayer2.m_Saturation = timelineItem.video_layer.saturation.intValue();
        videoLayer2.m_colorEffect = ColorEffect.fromProtoBuf(timelineItem.video_layer.color_effect);
        KMProto.KMProject.VideoLayer videoLayer3 = timelineItem.video_layer;
        videoLayer2.filePath = videoLayer3.video_path;
        videoLayer2.m_clipVolume = videoLayer3.clip_volume.intValue();
        videoLayer2.m_engineClipID = timelineItem.video_layer.engine_clip_id.intValue();
        videoLayer2.m_hasAudio = timelineItem.video_layer.has_audio.booleanValue();
        videoLayer2.m_hasVideo = timelineItem.video_layer.has_video.booleanValue();
        videoLayer2.m_muteAudio = timelineItem.video_layer.mute_audio.booleanValue();
        videoLayer2.m_playbackSpeed = timelineItem.video_layer.playback_speed.intValue();
        videoLayer2.m_originalClipDuration = timelineItem.video_layer.original_clip_duration.intValue();
        videoLayer2.m_originalVideoWidth = timelineItem.video_layer.original_video_width.intValue();
        videoLayer2.m_originalVideoHeight = timelineItem.video_layer.original_video_height.intValue();
        Boolean bool = timelineItem.video_layer.chroma_key_enabled;
        videoLayer2.m_chromaKeyEnabled = bool == null ? false : bool.booleanValue();
        Integer num = timelineItem.video_layer.chroma_key_color;
        videoLayer2.m_chromaKeyColor = num == null ? 0 : num.intValue();
        Float f2 = timelineItem.video_layer.chroma_key_clip_bg;
        videoLayer2.m_chromaKeyClipBG = f2 == null ? 0.5f : f2.floatValue();
        Float f3 = timelineItem.video_layer.chroma_key_clip_fg;
        videoLayer2.m_chromaKeyClipFG = f3 == null ? 0.72f : f3.floatValue();
        Float f4 = timelineItem.video_layer.chroma_key_blend_x0;
        videoLayer2.m_chromaKeyBlend_x0 = f4 == null ? 0.25f : f4.floatValue();
        Float f5 = timelineItem.video_layer.chroma_key_blend_y0;
        videoLayer2.m_chromaKeyBlend_y0 = f5 != null ? f5.floatValue() : 0.25f;
        Float f6 = timelineItem.video_layer.chroma_key_blend_x1;
        videoLayer2.m_chromaKeyBlend_x1 = f6 == null ? 0.75f : f6.floatValue();
        Float f7 = timelineItem.video_layer.chroma_key_blend_y1;
        videoLayer2.m_chromaKeyBlend_y1 = f7 != null ? f7.floatValue() : 0.75f;
        Integer num2 = timelineItem.video_layer.voice_changer;
        videoLayer2.m_voiceChanger = num2 == null ? 0 : num2.intValue();
        videoLayer2.m_audioPanLeft = timelineItem.video_layer.pan_left == null ? videoLayer2.getAudioLeftVolume() : videoLayer.pan_left.intValue();
        videoLayer2.m_audioPanRight = timelineItem.video_layer.pan_right == null ? videoLayer2.getAudioRightVolume() : videoLayer.pan_right.intValue();
        videoLayer2.m_audioCompressor = timelineItem.video_layer.compressor == null ? 0 : videoLayer.compressor.intValue();
        videoLayer2.m_pitchFactor = timelineItem.video_layer.pitch_factor == null ? 0 : videoLayer.pitch_factor.intValue();
        videoLayer2.m_enhancedAudioFilter = timelineItem.video_layer.enhancedAudioFilter == null ? null : videoLayer.enhancedAudioFilter;
        videoLayer2.m_equalizer = timelineItem.video_layer.equalizer != null ? videoLayer.equalizer : null;
        List<Float> list = timelineItem.video_layer.chroma_key_divisions;
        if (list != null && list.size() == 4) {
            videoLayer2.m_chromaKeyDivisions = C1708l.a(timelineItem.video_layer.chroma_key_divisions);
        } else {
            videoLayer2.m_chromaKeyDivisions = new float[]{0.05f, 0.3f, 0.5f, 0.65f};
        }
        List<Float> list2 = timelineItem.video_layer.chroma_key_strengths;
        if (list2 != null && list2.size() == 4) {
            videoLayer2.m_chromaKeyStrengths = C1708l.a(timelineItem.video_layer.chroma_key_strengths);
        } else {
            videoLayer2.m_chromaKeyStrengths = new float[]{0.0f, 0.25f, 0.75f, 1.0f};
        }
        KMProto.KMProject.VideoLayer videoLayer4 = timelineItem.video_layer;
        List<Integer> list3 = videoLayer4.volume_envelope_time;
        if (list3 != null && videoLayer4.volume_envelope_level != null) {
            videoLayer2.m_volumeEnvelopeTime = new ArrayList<>(list3);
            videoLayer2.m_volumeEnvelopeLevel = new ArrayList<>(timelineItem.video_layer.volume_envelope_level);
        }
        if (videoLayer2.m_volumeEnvelopeTime == null) {
            videoLayer2.m_volumeEnvelopeTime = new ArrayList<>();
        }
        if (videoLayer2.m_volumeEnvelopeLevel == null) {
            videoLayer2.m_volumeEnvelopeLevel = new ArrayList<>();
        }
        NexLayerItem.fromProtoBuf(timelineItem.video_layer.layer_common, videoLayer2);
        Integer num3 = timelineItem.track_id;
        videoLayer2.track_id = num3 != null ? num3.intValue() : 0;
        return videoLayer2;
    }

    public static VideoLayer fromVideoClipItem(NexVideoClipItem nexVideoClipItem) {
        MediaInfo a2 = MediaInfo.a(nexVideoClipItem.getMediaPath());
        VideoLayer videoLayer = new VideoLayer();
        videoLayer.m_originalClipDuration = a2.S() ? Math.min(a2.o(), a2.K()) : a2.K();
        videoLayer.m_originalVideoWidth = a2.R();
        videoLayer.m_originalVideoHeight = a2.v();
        videoLayer.m_hasVideo = true;
        videoLayer.m_engineClipID = 0;
        videoLayer.filePath = a2.B().getAbsolutePath();
        videoLayer.m_chromaKeyDivisions = new float[]{0.05f, 0.3f, 0.5f, 0.65f};
        videoLayer.m_chromaKeyStrengths = new float[]{0.0f, 0.25f, 0.75f, 1.0f};
        videoLayer.m_chromaKeyEnabled = false;
        videoLayer.m_chromaKeyColor = 0;
        videoLayer.m_Brightness = nexVideoClipItem.getBrightness();
        videoLayer.m_Contrast = nexVideoClipItem.getContrast();
        videoLayer.m_Saturation = nexVideoClipItem.getSaturation();
        videoLayer.m_colorEffect = nexVideoClipItem.getColorEffect();
        videoLayer.m_clipVolume = nexVideoClipItem.getClipVolume();
        videoLayer.m_hasAudio = nexVideoClipItem.getHasAudio();
        videoLayer.m_muteAudio = nexVideoClipItem.getMuteAudio();
        videoLayer.m_chromaKeyClipBG = 0.5f;
        videoLayer.m_chromaKeyClipFG = 0.72f;
        videoLayer.m_chromaKeyBlend_x0 = 0.25f;
        videoLayer.m_chromaKeyBlend_y0 = 0.25f;
        videoLayer.m_chromaKeyBlend_x1 = 0.75f;
        videoLayer.m_chromaKeyBlend_y1 = 0.75f;
        videoLayer.m_voiceChanger = 0;
        videoLayer.m_audioPanLeft = nexVideoClipItem.getAudioLeftVolume();
        videoLayer.m_audioPanRight = nexVideoClipItem.getAudioRightVolume();
        videoLayer.m_audioCompressor = nexVideoClipItem.isCheckedAudioCompressor() ? 4 : 0;
        videoLayer.m_pitchFactor = nexVideoClipItem.getAudioPitch();
        videoLayer.m_volumeEnvelopeTime = new ArrayList<>(nexVideoClipItem.asProtoBuf().visual_clip.volume_envelope_time);
        videoLayer.m_volumeEnvelopeLevel = new ArrayList<>(nexVideoClipItem.asProtoBuf().visual_clip.volume_envelope_level);
        videoLayer.m_enhancedAudioFilter = nexVideoClipItem.getVoiceChanger();
        videoLayer.m_equalizer = nexVideoClipItem.getEqualizer();
        if (nexVideoClipItem.getRotation() != 90 && nexVideoClipItem.getRotation() != 270) {
            videoLayer.setFlipH(nexVideoClipItem.getFlipH());
            videoLayer.setFlipV(nexVideoClipItem.getFlipV());
        } else {
            videoLayer.setFlipH(nexVideoClipItem.getFlipV());
            videoLayer.setFlipV(nexVideoClipItem.getFlipH());
        }
        videoLayer.setSplitScreenType(c.d.b.l.a.f3846a.a());
        if (videoLayer.getSplitScreenType() != SplitScreenType.OFF) {
            videoLayer.fitKeyframeToSplitscreenRect(videoLayer.getSplitScreenKeyframe());
        }
        return videoLayer;
    }

    private boolean g() {
        return (getClipVolume() == 100 && !getMuteAudio() && !isCheckedAudioCompressor() && getAudioRightVolume() == 100 && getAudioLeftVolume() == -100 && getAudioPitch() == 0) ? false : true;
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

    public NexAudioClip asNexAudioClip() {
        NexAudioClip nexAudioClip = new NexAudioClip();
        nexAudioClip.mClipPath = getMediaPath();
        nexAudioClip.mClipID = this.m_engineClipID;
        nexAudioClip.mTotalTime = this.m_originalClipDuration;
        nexAudioClip.mStartTime = getAbsStartTime();
        nexAudioClip.mEndTime = getAbsEndTime();
        nexAudioClip.mStartTrimTime = getStartTrim();
        nexAudioClip.mEndTrimTime = getEndTrim();
        nexAudioClip.mClipVolume = this.m_clipVolume;
        nexAudioClip.mAudioOnOff = !this.m_muteAudio ? 1 : 0;
        nexAudioClip.mAutoEnvelop = 0;
        nexAudioClip.mVoiceChanger = this.m_voiceChanger;
        nexAudioClip.mCompressor = this.m_audioCompressor;
        nexAudioClip.mPitchFactor = this.m_pitchFactor;
        nexAudioClip.mPanLeft = getAudioLeftVolume();
        nexAudioClip.mPanRight = getAudioRightVolume();
        t tVar = new t();
        nexAudioClip.mEnhancedAudioFilter = tVar.b(this.m_enhancedAudioFilter);
        nexAudioClip.mEqualizer = tVar.b(this.m_equalizer);
        nexAudioClip.mVisualClipID = ((NexVideoClipItem) getTimeline().getPrimaryItem(0)).getEngineClipID();
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeLevel;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 2);
            ArrayList arrayList3 = new ArrayList(this.m_volumeEnvelopeLevel.size() + 2);
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
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(0);
                        arrayList3.add(Integer.valueOf((int) ((((getStartTrim() - (getStartTrim() + i2)) / ((getStartTrim() + volumeEnvelopeTimeAdj) - (i2 + getStartTrim()))) * (volumeEnvelopeLevel - i3)) + i3)));
                    }
                    arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList3.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj <= representedDuration && volumeEnvelopeLevel > 0 && volumeEnvelopeTimeAdj == 0) {
                    arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList3.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj > representedDuration && getStartTrim() > 0) {
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(0);
                        arrayList3.add(Integer.valueOf((int) ((((getStartTrim() - (getStartTrim() + i2)) / ((getStartTrim() + volumeEnvelopeTimeAdj) - (getStartTrim() + i2))) * (volumeEnvelopeLevel - i3)) + i3)));
                    }
                    arrayList2.add(Integer.valueOf(representedDuration));
                    arrayList3.add(Integer.valueOf((int) ((((representedDuration - i2) / (volumeEnvelopeTimeAdj - i2)) * (volumeEnvelopeLevel - i3)) + i3)));
                }
                i++;
                i2 = volumeEnvelopeTimeAdj;
                i3 = volumeEnvelopeLevel;
            }
            nexAudioClip.mVolumeEnvelopeTime = q.a(arrayList2);
            nexAudioClip.mVolumeEnvelopeLevel = q.a(arrayList3);
        }
        return nexAudioClip;
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
        nexVisualClip.mAudioOnOff = !this.m_muteAudio ? 1 : 0;
        nexVisualClip.mClipVolume = this.m_clipVolume;
        nexVisualClip.mEffectDuration = 0;
        nexVisualClip.mClipEffectID = NexTimeline.DEFAULT_PROJECT_PHOTO_CROP_MODE;
        nexVisualClip.mTitleEffectID = null;
        nexVisualClip.mStartRect = new NexRectangle(0, 0, NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
        nexVisualClip.mEndRect = new NexRectangle(0, 0, NexVideoClipItem.ABSTRACT_DIMENSION, NexVideoClipItem.ABSTRACT_DIMENSION);
        nexVisualClip.mClipPath = this.filePath;
        nexVisualClip.mThumbnailPath = null;
        nexVisualClip.mRotateState = 0;
        nexVisualClip.mEffectOffset = 0;
        nexVisualClip.mEffectOverlap = 0;
        int i = this.m_playbackSpeed;
        nexVisualClip.mSpeedControl = i != 0 ? i : 100;
        nexVisualClip.mVoiceChanger = this.m_voiceChanger;
        nexVisualClip.mCompressor = this.m_audioCompressor;
        nexVisualClip.mPitchFactor = this.m_pitchFactor;
        nexVisualClip.mPanLeft = getAudioLeftVolume();
        nexVisualClip.mPanRight = getAudioRightVolume();
        t tVar = new t();
        nexVisualClip.mEnhancedAudioFilter = tVar.b(this.m_enhancedAudioFilter);
        nexVisualClip.mEqualizer = tVar.b(this.m_equalizer);
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeLevel;
        if (arrayList != null) {
            ArrayList arrayList2 = new ArrayList(arrayList.size() + 2);
            ArrayList arrayList3 = new ArrayList(this.m_volumeEnvelopeLevel.size() + 2);
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i2 >= this.m_volumeEnvelopeLevel.size()) {
                    break;
                }
                int volumeEnvelopeTimeAdj = getVolumeEnvelopeTimeAdj(i2);
                int volumeEnvelopeLevel = getVolumeEnvelopeLevel(i2);
                int representedDuration = getRepresentedDuration();
                if (volumeEnvelopeTimeAdj <= representedDuration && volumeEnvelopeTimeAdj > 0) {
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(0);
                        arrayList3.add(Integer.valueOf((int) ((((getStartTrim() - (getStartTrim() + i3)) / ((getStartTrim() + volumeEnvelopeTimeAdj) - (i3 + getStartTrim()))) * (volumeEnvelopeLevel - i4)) + i4)));
                    }
                    arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList3.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj <= representedDuration && volumeEnvelopeLevel > 0 && volumeEnvelopeTimeAdj == 0) {
                    arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList3.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj > representedDuration && getStartTrim() > 0) {
                    if (arrayList2.isEmpty()) {
                        arrayList2.add(0);
                        arrayList3.add(Integer.valueOf((int) ((((getStartTrim() - (getStartTrim() + i3)) / ((getStartTrim() + volumeEnvelopeTimeAdj) - (getStartTrim() + i3))) * (volumeEnvelopeLevel - i4)) + i4)));
                    }
                    arrayList2.add(Integer.valueOf(representedDuration));
                    arrayList3.add(Integer.valueOf((int) ((((representedDuration - i3) / (volumeEnvelopeTimeAdj - i3)) * (volumeEnvelopeLevel - i4)) + i4)));
                }
                i2++;
                i3 = volumeEnvelopeTimeAdj;
                i4 = volumeEnvelopeLevel;
            }
            nexVisualClip.mVolumeEnvelopeTime = q.a(arrayList2);
            nexVisualClip.mVolumeEnvelopeLevel = q.a(arrayList3);
        }
        return nexVisualClip;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.VideoLayer.Builder builder = new KMProto.KMProject.VideoLayer.Builder();
        builder.brightness = Integer.valueOf(this.m_Brightness);
        builder.contrast = Integer.valueOf(this.m_Contrast);
        builder.saturation = Integer.valueOf(this.m_Saturation);
        ColorEffect colorEffect = this.m_colorEffect;
        builder.color_effect = colorEffect == null ? null : colorEffect.asProtoBuf();
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
        builder.chroma_key_divisions(C1708l.a(this.m_chromaKeyDivisions));
        builder.chroma_key_strengths(C1708l.a(this.m_chromaKeyStrengths));
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
        builder.enhancedAudioFilter = this.m_enhancedAudioFilter;
        builder.equalizer = this.m_equalizer;
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList != null && this.m_volumeEnvelopeLevel != null) {
            builder.volume_envelope_time(arrayList);
            builder.volume_envelope_level(this.m_volumeEnvelopeLevel);
        }
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.LAYER_VIDEO).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).video_layer(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexSecondaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        super.bindView(view, interfaceC2028i);
        ClipThumbView clipThumbView = (ClipThumbView) view.findViewById(R.id.thumbnail_view);
        OverLimitView overLimitView = (OverLimitView) view.findViewById(R.id.over_limit_view);
        if (getRotation() <= 0) {
            Math.abs(getRotation());
        }
        if (!checkResourceState(view.getContext())) {
            clipThumbView.a(false);
        } else if (clipThumbView.b() && this.filePath.equals(clipThumbView.getPath())) {
            clipThumbView.a(this);
        } else {
            clipThumbView.a(this.filePath, this);
            new d(this).a(this.filePath, clipThumbView);
        }
        if (checkResourceState(view.getContext()) && getOverLimit()) {
            overLimitView.setVisibility(0);
        } else {
            overLimitView.setVisibility(8);
        }
        List<NexLayerItem.b> keyFrames = getKeyFrames();
        KeyFrameDrawingView keyFrameDrawingView = (KeyFrameDrawingView) view.findViewById(R.id.key_frame_drawing_view);
        if ((interfaceC2028i.a() && interfaceC2028i.b() == R.id.editmode_layer_anim) || (keyFrames != null && keyFrames.size() > 1 && interfaceC2028i.b() != R.id.editmode_volume_adjust)) {
            keyFrameDrawingView.a(getKeyFrames(), getDuration());
            keyFrameDrawingView.setVisibility(0);
        } else if (interfaceC2028i.a() && interfaceC2028i.b() == R.id.editmode_volume_adjust) {
            keyFrameDrawingView.a(this, getRepresentedDuration(), getStartTrim(), true);
            keyFrameDrawingView.setVisibility(0);
        } else {
            keyFrameDrawingView.setVisibility(8);
        }
    }

    public void changeMediaPathAfterTranscode(String str) {
        MediaInfo a2 = MediaInfo.a(str);
        this.m_originalClipDuration = a2.S() ? Math.min(a2.o(), a2.K()) : a2.K();
        this.m_originalVideoWidth = a2.R();
        this.m_originalVideoHeight = a2.v();
        this.p = false;
        NexLayerItem.b closestKeyframe = getClosestKeyframe(0.0f);
        closestKeyframe.f20232c = EditorGlobal.n() / 2;
        closestKeyframe.f20233d = EditorGlobal.m() / 2;
        closestKeyframe.f20231b = 1.0f;
        closestKeyframe.f20234e = -a2.z();
        int height = getHeight();
        int width = getWidth();
        int n = (EditorGlobal.n() * 3) / 4;
        int m = (EditorGlobal.m() * 3) / 4;
        if ((closestKeyframe.f20234e / 90.0f) % 2.0f != 0.0f) {
            if (height > n) {
                closestKeyframe.f20231b = n / height;
            }
            if (width > m) {
                closestKeyframe.f20231b = Math.min(closestKeyframe.f20231b, m / width);
            }
        } else {
            if (width > n) {
                closestKeyframe.f20231b = n / width;
            }
            if (height > m) {
                closestKeyframe.f20231b = Math.min(closestKeyframe.f20231b, m / height);
            }
        }
        this.m_hasVideo = true;
        this.m_hasAudio = a2.S();
        this.filePath = str;
        this.s = 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public void changeVolumeLevel(int i, int i2) {
        this.m_volumeEnvelopeLevel.set(i, Integer.valueOf(i2));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean checkResourceState(Context context) {
        return new File(this.filePath).exists();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:64:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0278 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void copyOptions(com.nextreaming.nexeditorui.NexTimelineItem r14) {
        /*
            Method dump skipped, instructions count: 659
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.layer.VideoLayer.copyOptions(com.nextreaming.nexeditorui.NexTimelineItem):void");
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected boolean drawThumbnails(C1916ib c1916ib, Canvas canvas, RectF rectF) {
        if (this.r == null && !this.t) {
            MediaInfo mediaInfo = getMediaInfo();
            if (mediaInfo == null) {
                return false;
            }
            this.t = true;
            mediaInfo.H().onResultAvailable(new c(this, c1916ib.h())).onFailure((Task.OnFailListener) new b(this));
        }
        if (this.r == null) {
            return false;
        }
        int startTime = getStartTime();
        int endTime = getEndTime();
        int startTrim = getStartTrim();
        int i = endTime - startTime;
        int c2 = this.r.c(0);
        int b2 = this.r.b(0);
        float height = rectF.height() / 2.0f;
        rectF.top -= height;
        rectF.bottom += height;
        int height2 = (int) (((c2 * rectF.height()) / b2) + 0.5f);
        int i2 = (int) rectF.left;
        int i3 = (int) (rectF.right + height2 + 1.0f);
        canvas.save();
        canvas.clipRect(rectF);
        int i4 = i2;
        while (i4 < i3) {
            int i5 = (((i4 - i2) * i) / (i3 - i2)) + startTrim;
            rectF.left = i4;
            i4 += height2;
            rectF.right = i4;
            if (!canvas.quickReject(rectF, Canvas.EdgeType.AA)) {
                canvas.drawBitmap(this.r.b(getOrientation(), i5, false, false), (Rect) null, rectF, (Paint) null);
            }
        }
        canvas.restore();
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioCompressor() {
        return this.m_audioCompressor;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getAudioLeftVolume() {
        if (this.m_audioPanLeft < -100) {
            MediaInfo a2 = MediaInfo.a(getMediaPath());
            if (a2 != null && a2.m() >= 2) {
                this.m_audioPanLeft = -100;
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

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getBGColor() {
        return R.color.layer_text;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void getBounds(Rect rect) {
        rect.left = (-getWidth()) / 2;
        rect.right = rect.left + getWidth();
        rect.top = (-getHeight()) / 2;
        rect.bottom = rect.top + getHeight();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getBrightness() {
        return this.m_Brightness;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public float getChromaKeyBGClip() {
        return this.m_chromaKeyClipBG;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void getChromaKeyBlend(float[] fArr) {
        fArr[0] = this.m_chromaKeyBlend_x0;
        fArr[1] = this.m_chromaKeyBlend_y0;
        fArr[2] = this.m_chromaKeyBlend_x1;
        fArr[3] = this.m_chromaKeyBlend_y1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
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

    public void getChromaKeyDivisions(float[] fArr) {
        float[] fArr2 = this.m_chromaKeyDivisions;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public boolean getChromaKeyEnabled() {
        return this.m_chromaKeyEnabled;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public float getChromaKeyFGClip() {
        return this.m_chromaKeyClipFG;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public boolean getChromaKeyMaskEnabled() {
        return this.m_chromaKeyMaskEnabled;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public int[] getChromaKeyRecommendedColors() {
        Bitmap a2;
        T t = this.r;
        if (t != null && (a2 = t.a(0, 0, false, false)) != null) {
            float[] fArr = new float[3];
            int[] iArr = new int[360];
            int[] iArr2 = new int[a2.getWidth() * a2.getHeight()];
            a2.getPixels(iArr2, 0, a2.getWidth(), 0, 0, a2.getWidth(), a2.getHeight());
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
                    if (iArr[i7] > i6) {
                        i6 = iArr[i7];
                        i5 = i7;
                    }
                }
                if (i5 < 0 || i6 < 5) {
                    break;
                }
                fArr[0] = (i5 * 360) / 360;
                fArr[1] = 1.0f;
                fArr[2] = 1.0f;
                iArr3[i3] = Color.HSVToColor(fArr);
                i3++;
                for (int i8 = i5 - 3; i8 < i5 + 3; i8++) {
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

    public void getChromaKeyStrengths(float[] fArr) {
        float[] fArr2 = this.m_chromaKeyStrengths;
        System.arraycopy(fArr2, 0, fArr, 0, fArr2.length);
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
        if (i == R.id.opt_chroma_key_color) {
            return getChromaKeyColor();
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
        return CapabilityManager.a(getWidth(), getHeight(), getPlaybackSpeed(), getFPS());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getContrast() {
        return this.m_Contrast;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        String str;
        int startTrim = getStartTrim();
        int endTrim = getEndTrim();
        MediaInfo mediaInfo = getMediaInfo();
        if (mediaInfo != null) {
            str = mediaInfo.D() + "×" + mediaInfo.C() + "  ";
        } else {
            str = "";
        }
        if (startTrim == 0 && endTrim == 0) {
            return str + EditorGlobal.b(getDuration());
        }
        return str + EditorGlobal.b(getDuration()) + " " + context.getResources().getString(R.string.video_trimmed);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        String str = this.filePath;
        return str == null ? "" : new File(str).getName();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getDiffAVDuration() {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getEndEnvelopeTime() {
        return this.m_originalClipDuration;
    }

    public int getEngineClipID() {
        return this.m_engineClipID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public String getEqualizer() {
        return this.m_equalizer;
    }

    public int getFPS() {
        if (this.s == 0) {
            this.s = MediaInfo.a(this.filePath).t();
            if (this.s <= 0) {
                this.s = 30;
            }
        }
        return this.s;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public FileType.FileCategory getFileCategory() {
        return FileType.FileCategory.Video;
    }

    public boolean getHasAudio() {
        return this.m_hasAudio;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getHeight() {
        f();
        return this.o;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected int getIcon() {
        return R.drawable.layericon_video;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        return this.m_originalClipDuration;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    protected String getLabelText(Context context) {
        String str = this.filePath;
        if (str == null) {
            return context.getResources().getString(R.string.layer_menu_video);
        }
        return new File(str).getName();
    }

    public MediaInfo getMediaInfo() {
        if (this.q == null) {
            this.q = MediaInfo.a(this.filePath);
        }
        return this.q;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public String getMediaPath() {
        return this.filePath;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public MediaSupportType getMediaSupportType() {
        return MediaInfo.a(this.filePath).y();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean getMuteAudio() {
        return this.m_muteAudio;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return Mb.class;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public int getOriginalHeight() {
        return this.m_originalVideoHeight;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public int getOriginalWidth() {
        return this.m_originalVideoWidth;
    }

    public int getPlaybackSpeed() {
        int i = this.m_playbackSpeed;
        if (i == 0) {
            return 100;
        }
        return i;
    }

    public NexExportProfile getPreferredTranscodingProfile() {
        return this.w;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public int getSaturation() {
        return this.m_Saturation;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        if (i == R.id.opt_chroma_key_color) {
            return getChromaKeyEnabled();
        }
        return super.getSwitchOption(i);
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return R.layout.timeline_item_secondary_videolayer;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getTrackAffinity() {
        return R.drawable.track_header_video_icon;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int[] getTrackOptionItems() {
        return new int[]{R.id.opt_alpha_adj, R.id.opt_volume_and_balance};
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecExportMemoryUsage() {
        return CapabilityManager.a(getWidth(), getHeight());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecLegacyMemoryUsage() {
        return ((((((this.m_originalVideoWidth * this.m_originalVideoHeight) * 150) / 100) * Math.max(30, getFPS())) / 30) * 100) / Math.max(100, getPlaybackSpeed());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoTrackUsage() {
        return 1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public String getVoiceChanger() {
        if (this.m_voiceChanger != 0) {
            String a2 = new t().a(this.m_voiceChanger);
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
        if (arrayList == null || arrayList.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeTimeAdj(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null || arrayList.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue() - getStartTrim();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeTimeForDrawing(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null || arrayList.size() < 1) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue() - getStartTrim();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public int getWidth() {
        f();
        return this.n;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean isCheckedAudioCompressor() {
        return this.m_audioCompressor > 0;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem, com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_audio_eq /* 2131363088 */:
                return this.m_equalizer != null;
            case R.id.opt_audio_voice_changer /* 2131363091 */:
                return this.m_voiceChanger > 0 || this.m_enhancedAudioFilter != null;
            case R.id.opt_blending /* 2131363096 */:
                return getBlendMode() != BlendMode.NONE;
            case R.id.opt_chroma_key /* 2131363098 */:
                return getChromaKeyEnabled();
            case R.id.opt_rotate /* 2131363137 */:
                return getRotation() != 0 || getFlipH() || getFlipV();
            case R.id.opt_speed_control /* 2131363141 */:
                return getPlaybackSpeed() != 100;
            case R.id.opt_split_trim /* 2131363143 */:
                return this.m_hasVideo && (getStartTrim() > 0 || getEndTrim() > 0);
            case R.id.opt_volume /* 2131363166 */:
            case R.id.opt_volume_and_balance /* 2131363167 */:
                return g();
            default:
                return super.isOptionApplied(i);
        }
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean isTransformedPointInLayerAtTime(float f2, float f3, int i) {
        int i2 = (-getWidth()) / 2;
        int width = getWidth() + i2;
        int i3 = (-getHeight()) / 2;
        return f2 >= ((float) i2) && f2 <= ((float) width) && f3 >= ((float) i3) && f3 <= ((float) (getHeight() + i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRender(LayerRenderer layerRenderer, NexLayerItem.b bVar, boolean z) {
        boolean z2;
        T t;
        NexEditor i;
        layerRenderer.x();
        if (this.m_colorEffect != null && !getChromaKeyMaskEnabled()) {
            layerRenderer.c(this.m_colorEffect.getLut());
        }
        if (getChromaKeyEnabled()) {
            layerRenderer.b(getChromaKeyEnabled());
            layerRenderer.c(getChromaKeyMaskEnabled());
            layerRenderer.a(this.m_chromaKeyColor, this.m_chromaKeyClipFG, this.m_chromaKeyClipBG, this.m_chromaKeyBlend_x0, this.m_chromaKeyBlend_y0, this.m_chromaKeyBlend_x1, this.m_chromaKeyBlend_y1);
        }
        if (!getOverLimit() && checkResourceState(null)) {
            int a2 = EditorGlobal.i().a(layerRenderer.l().id, this.m_engineClipID);
            if (a2 != 0) {
                float combinedBrightness = getCombinedBrightness() / 255.0f;
                float combinedContrast = getCombinedContrast() / 255.0f;
                float combinedSaturation = getCombinedSaturation() / 255.0f;
                ColorEffect colorEffect = this.m_colorEffect;
                layerRenderer.a(c.d.a.a.e.a.a(combinedBrightness, combinedContrast, combinedSaturation, colorEffect != null ? colorEffect.getTintColor() : 0));
                int ordinal = getBlendMode().ordinal();
                if (ordinal > 0) {
                    if (this.current_blend_mode_[layerRenderer.l().id] != ordinal) {
                        if (this.effect_id_[layerRenderer.l().id] >= 0) {
                            EditorGlobal.i().d(this.effect_id_[layerRenderer.l().id], layerRenderer.l().id);
                        }
                        this.effect_id_[layerRenderer.l().id] = -1;
                        this.current_blend_mode_[layerRenderer.l().id] = 0;
                    }
                    if (this.effect_id_[layerRenderer.l().id] < 0 && (i = EditorGlobal.i()) != null) {
                        this.effect_id_[layerRenderer.l().id] = i.a(String.format(Locale.US, "com.nexstreaming.editor.blend_%02d", Integer.valueOf(ordinal)), layerRenderer.l().id);
                        this.current_blend_mode_[layerRenderer.l().id] = ordinal;
                    }
                }
                if (this.effect_id_[layerRenderer.l().id] >= 0 && ordinal > 0) {
                    z2 = false;
                    layerRenderer.a(this.effect_id_[layerRenderer.l().id], a2, "", layerRenderer.f(), 0, 1000, 0.0f, 0.0f, getWidth(), getHeight(), layerRenderer.d(), layerRenderer.i());
                } else {
                    z2 = false;
                    layerRenderer.b(a2, 0.0f, 0.0f, getWidth(), getHeight());
                }
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
            if (this.u == null) {
                this.u = a(KineMasterApplication.f24056d.getApplicationContext().getResources().getDrawable(R.drawable.stripes_tile));
            }
            if (this.v == null && (t = this.r) != null) {
                this.v = t.a(0, 0, false, false);
            }
            Bitmap bitmap = this.v;
            if (bitmap != null) {
                layerRenderer.a(bitmap, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
                layerRenderer.c(861230421, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
            } else {
                layerRenderer.c(-6710887, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2);
            }
            layerRenderer.a(0.5f);
            layerRenderer.a(this.u, (-getWidth()) / 2, (-getHeight()) / 2, getWidth() / 2, getHeight() / 2, (getWidth() * bVar.f20231b) / this.u.getWidth(), (getHeight() * bVar.f20231b) / this.u.getHeight());
        }
        layerRenderer.b(z2);
        layerRenderer.c((Bitmap) null);
        layerRenderer.w();
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public void onRenderAsleep(LayerRenderer layerRenderer) {
        this.u = null;
        this.v = null;
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
        f();
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setChromaKeyBGClip(float f2) {
        this.m_chromaKeyClipBG = f2;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setChromaKeyBlend(float[] fArr) {
        this.m_chromaKeyBlend_x0 = fArr[0];
        this.m_chromaKeyBlend_y0 = fArr[1];
        this.m_chromaKeyBlend_x1 = fArr[2];
        this.m_chromaKeyBlend_y1 = fArr[3];
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setChromaKeyColor(int i) {
        this.m_chromaKeyColor = i;
    }

    public void setChromaKeyDivisions(float[] fArr) {
        float[] fArr2 = this.m_chromaKeyDivisions;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setChromaKeyEnabled(boolean z) {
        this.m_chromaKeyEnabled = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setChromaKeyFGClip(float f2) {
        this.m_chromaKeyClipFG = f2;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setChromaKeyMaskEnabled(boolean z) {
        this.m_chromaKeyMaskEnabled = z;
    }

    public void setChromaKeyStrengths(float[] fArr) {
        float[] fArr2 = this.m_chromaKeyStrengths;
        System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
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
        if (i == R.id.opt_chroma_key_color) {
            this.m_chromaKeyColor = i2;
        } else {
            super.setColorOption(i, i2);
            throw null;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setContrast(int i) {
        this.m_Contrast = i;
    }

    public void setEngineClipID(int i) {
        if (this.m_engineClipID == 0) {
            this.m_engineClipID = i;
            return;
        }
        throw new IllegalStateException("Engine clip ID already set");
    }

    public void setEngineClipIDAfterDuplicate(int i) {
        this.m_engineClipID = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setEqualizer(String str) {
        this.m_equalizer = str;
    }

    @Override // com.nexstreaming.kinemaster.layer.MediaLayer
    public void setMediaPath(String str) {
        this.filePath = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setMuteAudio(boolean z) {
        this.m_muteAudio = z;
    }

    public void setPlaybackSpeed(int i) {
        this.m_playbackSpeed = i;
    }

    public void setPreferredTranscodingProfile(NexExportProfile nexExportProfile) {
        this.w = nexExportProfile;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.f
    public void setSaturation(int i) {
        this.m_Saturation = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_chroma_key_color) {
            this.m_chromaKeyEnabled = z;
            return null;
        }
        super.setSwitchOption(i, z, context);
        throw null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setVoiceChanger(String str) {
        this.m_enhancedAudioFilter = str;
    }

    @Override // com.nexstreaming.kinemaster.editorwrapper.NexLayerItem
    public boolean supportsSplitScreen() {
        return true;
    }
}
