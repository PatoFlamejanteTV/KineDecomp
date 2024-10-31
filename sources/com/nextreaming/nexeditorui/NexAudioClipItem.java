package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.nexstreaming.app.general.nexasset.assetpackage.AssetPackageReader;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.Bg;
import com.nexstreaming.kinemaster.ui.projectedit.Vh;
import com.nexstreaming.kinemaster.ui.projectedit.timeline.InterfaceC2028i;
import com.nexstreaming.kinemaster.ui.widget.ClipThumbView;
import com.nexstreaming.kinemaster.ui.widget.KeyFrameDrawingView;
import com.nexstreaming.kinemaster.ui.widget.OverLimitView;
import com.nexstreaming.kinemaster.ui.widget.PCMDrawingView;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexAudioClip;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class NexAudioClipItem extends NexSecondaryTimelineItem implements Vh, NexTimelineItem.e, NexTimelineItem.u, NexTimelineItem.b {

    /* renamed from: f, reason: collision with root package name */
    private static Rect f24073f = new Rect();
    private static final long serialVersionUID = 2;

    /* renamed from: g, reason: collision with root package name */
    private transient String f24074g;

    /* renamed from: h, reason: collision with root package name */
    private transient String f24075h;
    private transient String i;
    private boolean isLocked;
    private transient Bitmap j;
    private transient UUID k;
    private transient boolean l;
    private transient boolean m;
    private int m_audioCompressor;
    private int m_audioPanLeft;
    private int m_audioPanRight;
    private String m_clipName;
    private int m_clipVolume;
    private float m_clipWidth;
    private int m_duration;
    private int m_engineClipID;
    private String m_enhancedAudioFilter;
    private String m_equalizer;
    private boolean m_extendToEnd;
    private int m_extraRelativeStartTime;

    @Deprecated
    private final boolean m_isBGMusic;
    private boolean m_isExtractAudio;
    private boolean m_isPendingVoiceRecording;
    private boolean m_isUserChoiceBGMusic;
    private boolean m_isVoiceRecording;
    private boolean m_loop;
    private String m_mediaPath;
    private String m_mediaTitle;
    private boolean m_muteAudio;
    private String m_originalMediaPath;
    private boolean m_pinned;
    private int m_pitchFactor;
    private int m_relativeEndTime;
    private int m_relativeStartTime;
    private int m_savedLoopDuration;
    private int m_savedRelativeEndTime;
    private int m_savedRelativeStartTime;
    private int m_savedTrimTimeEnd;
    private int m_savedTrimTimeStart;
    private int m_trimTimeEnd;
    private int m_trimTimeStart;
    private NexVideoClipItem m_videoClip;
    private int m_voiceChanger;
    private ArrayList<Integer> m_volumeEnvelopeLevel;
    private ArrayList<Integer> m_volumeEnvelopeTime;
    private transient MediaInfo n;
    private transient byte[] o;
    private transient boolean p;
    private transient boolean q;

    /* loaded from: classes.dex */
    public enum AudioType {
        VoiceRecording,
        PendingVoiceRecording,
        ExtractedAudio,
        BackgroundAudio,
        Music
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public enum DragType {
        START,
        END
    }

    public NexAudioClipItem() {
        this.isLocked = false;
        this.m_clipVolume = 100;
        this.m_loop = false;
        this.m_extendToEnd = false;
        this.m_isVoiceRecording = false;
        this.m_isPendingVoiceRecording = false;
        this.m_isExtractAudio = false;
        this.m_clipWidth = 0.0f;
        this.m_voiceChanger = 0;
        this.m_audioCompressor = 0;
        this.m_pitchFactor = 0;
        this.m_audioPanLeft = -111;
        this.m_audioPanRight = -111;
        this.l = false;
        this.m = false;
        this.n = null;
        this.p = false;
        this.m_isBGMusic = false;
    }

    private void a(Canvas canvas) {
        byte[] bArr;
        int min = Math.min(canvas.getMaximumBitmapWidth(), 8192);
        Bitmap bitmap = this.j;
        if ((bitmap != null && !bitmap.isRecycled() && this.j.getWidth() <= min) || this.n == null || (bArr = this.o) == null) {
            return;
        }
        Paint paint = new Paint();
        int min2 = Math.min(this.n.r() / 15, min);
        if (min2 > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(min2, 64, Bitmap.Config.ALPHA_8);
            Canvas canvas2 = new Canvas(createBitmap);
            paint.setAntiAlias(true);
            Path path = new Path();
            float f2 = 65;
            path.moveTo(-50.0f, f2);
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = -1;
            while (i < min2) {
                float f3 = f2;
                Bitmap bitmap2 = createBitmap;
                int length = (int) ((i * bArr.length) / min2);
                if (bArr.length <= 0) {
                    return;
                }
                if (length != i3) {
                    int i5 = 0;
                    for (int i6 = i3 + 1; i6 <= length; i6++) {
                        i5 += bArr[length] & 255;
                    }
                    int max = i5 / Math.max(1, length - i3);
                    i3 = length;
                    i2 = max;
                }
                if (i2 != i4) {
                    path.lineTo(i, 64 - ((i2 * 64) / 255));
                    i4 = i2;
                }
                i += 3;
                f2 = f3;
                createBitmap = bitmap2;
            }
            path.lineTo(min2 - 1, 64 - ((i2 * 64) / 255));
            path.lineTo(min2 + 50, f2);
            path.close();
            canvas2.drawPath(path, paint);
            this.j = createBitmap;
        }
    }

    private void d() {
        int size = this.m_volumeEnvelopeTime.size();
        int i = 1;
        while (i < size && size > 2) {
            if (this.m_volumeEnvelopeTime.get(i).intValue() - this.m_volumeEnvelopeTime.get(i - 1).intValue() < 30) {
                this.m_volumeEnvelopeLevel.remove(i);
                this.m_volumeEnvelopeTime.remove(i);
                size--;
                i--;
            }
            i++;
        }
    }

    private boolean e() {
        return (getClipVolume() == 100 && !getMuteAudio() && !isCheckedAudioCompressor() && getAudioRightVolume() == 100 && getAudioLeftVolume() == -100 && getAudioPitch() == 0) ? false : true;
    }

    private void f() {
        String mediaPath = getMediaPath();
        String mediaPath2 = getMediaPath();
        if (this.n == null || !mediaPath2.equals(mediaPath)) {
            MediaInfo mediaInfo = this.n;
            this.n = MediaInfo.a(mediaPath);
            this.o = null;
            this.p = false;
            this.q = false;
        }
    }

    public static NexAudioClipItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        KMProto.KMProject.AudioClip audioClip = timelineItem.audio_clip;
        NexAudioClipItem nexAudioClipItem = new NexAudioClipItem();
        nexAudioClipItem.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        nexAudioClipItem.m_mediaTitle = audioClip.media_title;
        nexAudioClipItem.m_originalMediaPath = audioClip.original_media_path;
        nexAudioClipItem.m_mediaPath = audioClip.media_path;
        nexAudioClipItem.m_extraRelativeStartTime = audioClip.extra_relative_start_time.intValue();
        nexAudioClipItem.m_relativeStartTime = audioClip.relative_start_time.intValue();
        nexAudioClipItem.m_relativeEndTime = audioClip.relative_end_time.intValue();
        nexAudioClipItem.m_savedRelativeStartTime = audioClip.saved_relative_start_time.intValue();
        nexAudioClipItem.m_savedRelativeEndTime = audioClip.saved_relative_end_time.intValue();
        Integer num = audioClip.saved_loop_duration;
        nexAudioClipItem.m_savedLoopDuration = num == null ? 0 : num.intValue();
        nexAudioClipItem.m_engineClipID = audioClip.engine_clip_id.intValue();
        nexAudioClipItem.m_duration = audioClip.duration.intValue();
        nexAudioClipItem.m_trimTimeStart = audioClip.trim_time_start.intValue();
        Boolean bool = audioClip.extend_to_end;
        nexAudioClipItem.m_extendToEnd = bool == null ? false : bool.booleanValue();
        nexAudioClipItem.m_trimTimeEnd = audioClip.trim_time_end.intValue();
        nexAudioClipItem.m_clipVolume = audioClip.clip_volume.intValue();
        nexAudioClipItem.m_muteAudio = audioClip.mute_audio.booleanValue();
        nexAudioClipItem.m_loop = audioClip.loop.booleanValue();
        nexAudioClipItem.m_isVoiceRecording = audioClip.is_voice_recording.booleanValue();
        nexAudioClipItem.m_isPendingVoiceRecording = audioClip.is_pending_voice_recording.booleanValue();
        nexAudioClipItem.m_isExtractAudio = audioClip.is_extract_audio.booleanValue();
        nexAudioClipItem.m_volumeEnvelopeTime = new ArrayList<>(audioClip.volume_envelope_time);
        nexAudioClipItem.m_volumeEnvelopeLevel = new ArrayList<>(audioClip.volume_envelope_level);
        nexAudioClipItem.m_clipWidth = audioClip.clip_width.floatValue();
        nexAudioClipItem.m_videoClip = null;
        Integer num2 = audioClip.voice_changer;
        nexAudioClipItem.m_voiceChanger = num2 == null ? 0 : num2.intValue();
        nexAudioClipItem.m_enhancedAudioFilter = audioClip.enhancedAudioFilter;
        nexAudioClipItem.m_equalizer = audioClip.equalizer;
        Boolean bool2 = audioClip.pinned;
        nexAudioClipItem.m_pinned = bool2 == null ? false : bool2.booleanValue();
        Long l = audioClip.video_clip_item_uuid_msb;
        if (l != null && audioClip.video_clip_item_uuid_lsb != null) {
            nexAudioClipItem.k = new UUID(l.longValue(), audioClip.video_clip_item_uuid_lsb.longValue());
        }
        nexAudioClipItem.m_isUserChoiceBGMusic = audioClip.is_bg_music.booleanValue();
        Integer num3 = audioClip.pan_left;
        nexAudioClipItem.m_audioPanLeft = num3 == null ? nexAudioClipItem.getAudioLeftVolume() : num3.intValue();
        Integer num4 = audioClip.pan_right;
        nexAudioClipItem.m_audioPanRight = num4 == null ? nexAudioClipItem.getAudioRightVolume() : num4.intValue();
        Integer num5 = audioClip.compressor;
        nexAudioClipItem.m_audioCompressor = num5 == null ? 0 : num5.intValue();
        Integer num6 = audioClip.pitch_factor;
        nexAudioClipItem.m_pitchFactor = num6 == null ? 0 : num6.intValue();
        nexAudioClipItem.m_clipName = audioClip.clip_name;
        nexAudioClipItem.f();
        nexAudioClipItem.m_duration = nexAudioClipItem.n.r();
        nexAudioClipItem.a();
        nexAudioClipItem.d();
        Integer num7 = timelineItem.track_id;
        nexAudioClipItem.track_id = num7 != null ? num7.intValue() : 0;
        return nexAudioClipItem;
    }

    public static NexAudioClipItem newInstance(int i, String str) {
        NexAudioClipItem nexAudioClipItem = new NexAudioClipItem();
        nexAudioClipItem.m_engineClipID = i;
        nexAudioClipItem.m_mediaPath = str;
        nexAudioClipItem.m_mediaTitle = new File(str).getName();
        nexAudioClipItem.f();
        MediaInfo mediaInfo = nexAudioClipItem.n;
        if (mediaInfo == null) {
            return null;
        }
        nexAudioClipItem.m_duration = mediaInfo.r();
        nexAudioClipItem.m_relativeStartTime = 0;
        nexAudioClipItem.m_relativeEndTime = nexAudioClipItem.m_relativeStartTime + nexAudioClipItem.m_duration;
        return nexAudioClipItem;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Collection<ProjectDependency> collection) {
        String musicAssetId;
        if (isThemeMusic()) {
            String musicThemeId = getMusicThemeId();
            if (musicThemeId == null || musicThemeId.length() <= 0) {
                return;
            }
            collection.add(ProjectDependency.d(musicThemeId));
            return;
        }
        if (!isAssetMusic() || (musicAssetId = getMusicAssetId()) == null || musicAssetId.length() <= 0) {
            return;
        }
        collection.add(ProjectDependency.a(musicAssetId));
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
        nexAudioClip.mTotalTime = this.m_duration;
        nexAudioClip.mStartTime = this.m_relativeStartTime;
        if (isExtendToEnd()) {
            nexAudioClip.mEndTime = getAbsEndTime() + this.m_trimTimeStart + this.m_trimTimeEnd;
        } else {
            nexAudioClip.mEndTime = this.m_relativeEndTime;
        }
        nexAudioClip.mStartTrimTime = this.m_trimTimeStart;
        nexAudioClip.mEndTrimTime = this.m_trimTimeEnd;
        nexAudioClip.mClipVolume = this.m_clipVolume;
        nexAudioClip.mAudioOnOff = !this.m_muteAudio ? 1 : 0;
        nexAudioClip.mAutoEnvelop = this.m_isUserChoiceBGMusic ? 1 : 0;
        nexAudioClip.mVoiceChanger = this.m_voiceChanger;
        nexAudioClip.mCompressor = this.m_audioCompressor;
        nexAudioClip.mPitchFactor = this.m_pitchFactor;
        nexAudioClip.mPanLeft = getAudioLeftVolume();
        nexAudioClip.mPanRight = getAudioRightVolume();
        com.nexstreaming.kinemaster.ui.projectedit.audioeffect.t tVar = new com.nexstreaming.kinemaster.ui.projectedit.audioeffect.t();
        nexAudioClip.mEnhancedAudioFilter = tVar.b(this.m_enhancedAudioFilter);
        nexAudioClip.mEqualizer = tVar.b(this.m_equalizer);
        if (getVideoClip() == null) {
            nexAudioClip.mVisualClipID = ((NexVideoClipItem) getTimeline().getPrimaryItem(0)).getEngineClipID();
        } else {
            nexAudioClip.mVisualClipID = getVideoClip().getEngineClipID();
        }
        a();
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
                        int i4 = this.m_trimTimeStart;
                        arrayList2.add(0);
                        arrayList3.add(Integer.valueOf((int) ((((i4 - (i2 + i4)) / ((volumeEnvelopeTimeAdj + i4) - (i2 + i4))) * (volumeEnvelopeLevel - i3)) + i3)));
                    }
                    arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList3.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj <= representedDuration && volumeEnvelopeLevel > 0 && volumeEnvelopeTimeAdj == 0) {
                    arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList3.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj > representedDuration && this.m_trimTimeEnd > 0) {
                    if (arrayList2.isEmpty()) {
                        int i5 = this.m_trimTimeStart;
                        arrayList2.add(0);
                        arrayList3.add(Integer.valueOf((int) ((((i5 - (i2 + i5)) / ((volumeEnvelopeTimeAdj + i5) - (i5 + i2))) * (volumeEnvelopeLevel - i3)) + i3)));
                    }
                    arrayList2.add(Integer.valueOf(representedDuration));
                    arrayList3.add(Integer.valueOf((int) ((((representedDuration - i2) / (volumeEnvelopeTimeAdj - i2)) * (volumeEnvelopeLevel - i3)) + i3)));
                }
                i++;
                i2 = volumeEnvelopeTimeAdj;
                i3 = volumeEnvelopeLevel;
            }
            nexAudioClip.mVolumeEnvelopeTime = com.nexstreaming.app.general.util.q.a(arrayList2);
            nexAudioClip.mVolumeEnvelopeLevel = com.nexstreaming.app.general.util.q.a(arrayList3);
        }
        return nexAudioClip;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.AudioClip.Builder builder = new KMProto.KMProject.AudioClip.Builder();
        String str = this.m_mediaTitle;
        if (str != null) {
            builder.media_title(str);
        }
        String str2 = this.m_originalMediaPath;
        if (str2 != null) {
            builder.original_media_path(str2);
        }
        String str3 = this.m_mediaPath;
        if (str3 != null) {
            builder.media_path(str3);
        }
        builder.extra_relative_start_time(Integer.valueOf(this.m_extraRelativeStartTime)).relative_start_time(Integer.valueOf(this.m_relativeStartTime)).relative_end_time(Integer.valueOf(this.m_relativeEndTime)).saved_relative_start_time(Integer.valueOf(this.m_savedRelativeStartTime)).saved_relative_end_time(Integer.valueOf(this.m_savedRelativeEndTime)).saved_loop_duration(Integer.valueOf(this.m_savedLoopDuration)).engine_clip_id(Integer.valueOf(this.m_engineClipID)).duration(Integer.valueOf(this.m_duration)).trim_time_start(Integer.valueOf(this.m_trimTimeStart)).trim_time_end(Integer.valueOf(this.m_trimTimeEnd)).saved_trim_time_start(Integer.valueOf(this.m_savedTrimTimeStart)).saved_trim_time_end(Integer.valueOf(this.m_savedTrimTimeEnd)).extend_to_end(Boolean.valueOf(this.m_extendToEnd)).clip_volume(Integer.valueOf(this.m_clipVolume)).mute_audio(Boolean.valueOf(this.m_muteAudio)).pinned(Boolean.valueOf(this.m_pinned)).loop(Boolean.valueOf(this.m_loop)).is_voice_recording(Boolean.valueOf(this.m_isVoiceRecording)).is_pending_voice_recording(Boolean.valueOf(this.m_isPendingVoiceRecording)).is_extract_audio(Boolean.valueOf(this.m_isExtractAudio)).is_bg_music(Boolean.valueOf(this.m_isUserChoiceBGMusic)).volume_envelope_time(this.m_volumeEnvelopeTime).volume_envelope_level(this.m_volumeEnvelopeLevel).voice_changer(Integer.valueOf(this.m_voiceChanger)).clip_width(Float.valueOf(this.m_clipWidth)).pan_left(Integer.valueOf(getAudioLeftVolume())).pan_right(Integer.valueOf(getAudioRightVolume())).compressor(Integer.valueOf(this.m_audioCompressor)).pitch_factor(Integer.valueOf(this.m_pitchFactor)).clip_name(this.m_clipName).enhancedAudioFilter(this.m_enhancedAudioFilter).equalizer(this.m_equalizer);
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.AUDIO_CLIP).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).audio_clip(builder.build()).track_id(Integer.valueOf(this.track_id)).build();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.x beginTrim(NexTimelineItem.y yVar, int i) {
        int i2;
        int freeSpaceAtTime;
        if (i == 0) {
            return null;
        }
        if (i == 1) {
            i2 = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeStart;
            freeSpaceAtTime = getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
        } else {
            i2 = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeEnd;
            freeSpaceAtTime = getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
        }
        return new C2305ea(this, i, i2, freeSpaceAtTime, yVar);
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public void bindView(View view, InterfaceC2028i interfaceC2028i) {
        int i;
        int i2;
        super.bindView(view, interfaceC2028i);
        ImageView imageView = (ImageView) view.findViewById(R.id.clip_type_icon);
        TextView textView = (TextView) view.findViewById(R.id.clip_label);
        ClipThumbView clipThumbView = (ClipThumbView) view.findViewById(R.id.thumbnail_view);
        OverLimitView overLimitView = (OverLimitView) view.findViewById(R.id.over_limit_view);
        if (this.m_isPendingVoiceRecording) {
            i = R.color.audioclip_voicerec_pend_pcm;
            i2 = 0;
        } else if (isBGM() || isLegacyBGMusic()) {
            i = R.color.audioclip_other_pcm_v5;
            i2 = R.color.audioclip_other_pcm_shadow_v5;
        } else if (this.m_isVoiceRecording) {
            i = R.color.audioclip_voicerec_pcm_v5;
            i2 = R.color.audioclip_voicerec_pcm_shadow_v5;
        } else {
            i = R.color.audioclip_music_pcm_v5;
            i2 = R.color.audioclip_music_pcm_shadow_v5;
        }
        int color = view.getContext().getResources().getColor(i);
        if (i2 != 0) {
            i2 = view.getContext().getResources().getColor(i2);
        }
        if (!checkResourceState(view.getContext())) {
            clipThumbView.a(false);
        } else {
            clipThumbView.a(this.m_mediaPath);
        }
        String customBGMusic = getCustomBGMusic();
        int i3 = R.drawable.layericon_audio_theme_music;
        if (customBGMusic == null && !isBGM() && !isLegacyBGMusic()) {
            if (this.m_isVoiceRecording) {
                i3 = R.drawable.layericon_audio_voice_v5;
            } else {
                i3 = this.m_isExtractAudio ? R.drawable.layericon_audio_extracted : R.drawable.layericon_audio_music;
            }
        }
        if (i3 != 0) {
            imageView.setImageResource(i3);
        }
        String clipName = getClipName();
        if (TextUtils.isEmpty(clipName)) {
            clipName = getTitle(view.getContext());
        }
        textView.setText(clipName);
        if (!checkResourceState(view.getContext())) {
            textView.setAlpha(0.5f);
            imageView.setAlpha(0.5f);
        }
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        new RectF(rect);
        if (this.m_pinned) {
            ImageView imageView2 = (ImageView) view.findViewById(R.id.pin_icon);
            imageView2.setImageResource(R.drawable.pin_dark);
            imageView2.setVisibility(0);
        } else {
            ((ImageView) view.findViewById(R.id.pin_icon)).setVisibility(8);
        }
        C2309ga c2309ga = new C2309ga(this);
        PCMDrawingView pCMDrawingView = (PCMDrawingView) view.findViewById(R.id.pcm_drawing_view);
        pCMDrawingView.setDecoData(null);
        pCMDrawingView.a(this, color, i2);
        c2309ga.a(this.m_mediaPath, pCMDrawingView);
        if (getOverLimit()) {
            overLimitView.setVisibility(0);
        } else {
            overLimitView.setVisibility(8);
        }
        KeyFrameDrawingView keyFrameDrawingView = (KeyFrameDrawingView) view.findViewById(R.id.key_frame_drawing_view);
        if (interfaceC2028i.a() && interfaceC2028i.b() == R.id.editmode_volume_adjust) {
            keyFrameDrawingView.a(this, getRepresentedDuration(), getStartTrim(), true);
            keyFrameDrawingView.setVisibility(0);
        } else {
            keyFrameDrawingView.setVisibility(8);
        }
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public void changeVolumeLevel(int i, int i2) {
        this.m_volumeEnvelopeLevel.set(i, Integer.valueOf(i2));
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean checkResourceState(Context context) {
        if (isLegacyBGMusic()) {
            if (getCustomBGMusic() == null) {
                return true;
            }
            String mediaPath = getMediaPath();
            if (mediaPath == null) {
                this.l = false;
                return false;
            }
            this.l = new File(mediaPath).exists();
            return this.l;
        }
        this.l = new File(getMediaPath()).exists();
        return this.l;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f2, NexTimelineItem.i iVar, boolean z3, float f3, int i, int i2, List<ob> list, NexTimelineItem.r rVar) {
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAbsEndTime() {
        NexTimeline timeline;
        if (isExtendToEnd() && (timeline = getTimeline()) != null) {
            return Math.max(getAbsStartTime() + 1000, timeline.getTotalTime());
        }
        if (this.m_pinned) {
            return this.m_extraRelativeStartTime + this.m_relativeEndTime;
        }
        NexVideoClipItem videoClip = getVideoClip();
        if (videoClip == null) {
            return this.m_extraRelativeStartTime + this.m_relativeEndTime;
        }
        return videoClip.getAbsStartTime() + this.m_extraRelativeStartTime + this.m_relativeEndTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAbsStartTime() {
        int absStartTime;
        int i;
        if (this.m_pinned) {
            absStartTime = this.m_relativeStartTime;
            i = this.m_extraRelativeStartTime;
        } else {
            NexVideoClipItem videoClip = getVideoClip();
            if (videoClip == null) {
                absStartTime = this.m_relativeStartTime;
                i = this.m_extraRelativeStartTime;
            } else {
                absStartTime = videoClip.getAbsStartTime() + this.m_relativeStartTime;
                i = this.m_extraRelativeStartTime;
            }
        }
        return absStartTime + i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public NexPrimaryTimelineItem getAnchorItem() {
        return getVideoClip();
    }

    public String getAssetPackageId() {
        String musicAssetId = getMusicAssetId();
        if (TextUtils.isEmpty(musicAssetId)) {
            return "";
        }
        String[] split = musicAssetId.split("/");
        if (split.length <= 0) {
            return "";
        }
        String[] split2 = split[1].split("\\.");
        return split2.length > 0 ? split2[0] : "";
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

    public boolean getAudioSplitState() {
        return this.m;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAudioTrackUsage() {
        return (getMuteAudio() || getClipVolume() <= 0) ? 0 : 1;
    }

    public AudioType getAudioType() {
        if (this.m_isPendingVoiceRecording) {
            return AudioType.PendingVoiceRecording;
        }
        if (this.m_isVoiceRecording) {
            return AudioType.VoiceRecording;
        }
        if (this.m_isExtractAudio) {
            return AudioType.ExtractedAudio;
        }
        if (!isBGM() && !isLegacyBGMusic()) {
            return AudioType.Music;
        }
        return AudioType.BackgroundAudio;
    }

    public String getClipName() {
        return this.m_clipName;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public int getClipVolume() {
        return this.m_clipVolume;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getContentWeight() {
        return 0;
    }

    public String getCustomBGMusic() {
        return this.f24075h;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        int duration = getDuration();
        if (duration != getOriginalDuration()) {
            return EditorGlobal.b(duration) + " " + context.getResources().getString(R.string.video_trimmed);
        }
        return EditorGlobal.b(duration);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return getTitle(context);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getDiffAVDuration() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        int i;
        int i2;
        if (isLegacyBGMusic()) {
            NexTimeline timeline = getTimeline();
            if (timeline == null) {
                return 0;
            }
            return timeline.getTotalTime();
        }
        if (isExtendToEnd()) {
            i = getAbsEndTime();
            i2 = getAbsStartTime();
        } else {
            i = this.m_relativeEndTime;
            i2 = this.m_relativeStartTime;
        }
        return i - i2;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getEndEnvelopeTime() {
        return getOriginalDuration();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTime() {
        return this.m_relativeEndTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTrim() {
        return this.m_trimTimeEnd;
    }

    public int getEngineClipID() {
        return this.m_engineClipID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public String getEqualizer() {
        return this.m_equalizer;
    }

    public int getExtraRelativeStartTime() {
        return this.m_extraRelativeStartTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public FileType.FileCategory getFileCategory() {
        return FileType.FileCategory.Audio;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        return this.m_duration;
    }

    public boolean getIsExtractAudio() {
        return this.m_isExtractAudio;
    }

    public boolean getIsPendingVoiceRecording() {
        return this.m_isPendingVoiceRecording;
    }

    public boolean getIsVoiceRecording() {
        return this.m_isVoiceRecording;
    }

    public MediaInfo getMediaInfo() {
        return this.n;
    }

    public String getMediaPath() {
        if (this.f24074g == null) {
            String str = this.m_mediaPath;
            this.f24074g = str;
            if (str.startsWith("@")) {
                File file = null;
                if (this.m_mediaPath.startsWith("@theme:")) {
                    this.m_mediaPath = "@kmasset:" + this.m_mediaPath.substring(7) + ".music";
                }
                if (this.m_mediaPath.startsWith("@kmasset:")) {
                    String substring = this.m_mediaPath.substring(9);
                    com.nexstreaming.app.general.nexasset.assetpackage.r a2 = com.nexstreaming.app.general.nexasset.assetpackage.h.e().a(substring.substring(substring.indexOf(47) + 1));
                    if (a2 != null) {
                        try {
                            file = AssetPackageReader.a(KineMasterApplication.f24056d.getApplicationContext(), a2.getPackageURI(), a2.getAssetPackage().getAssetId()).e(a2.getFilePath());
                        } catch (IOException unused) {
                        }
                    }
                }
                if (file != null) {
                    this.f24074g = file.getAbsolutePath();
                }
            }
        }
        return this.f24074g;
    }

    public String getMusicAssetId() {
        String str = this.m_mediaPath;
        if (str == null || !str.startsWith("@kmasset:")) {
            return null;
        }
        return this.m_mediaPath.substring(9);
    }

    public String getMusicThemeId() {
        String str = this.m_mediaPath;
        if (str == null || !str.startsWith("@theme:")) {
            return null;
        }
        return this.m_mediaPath.substring(7);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean getMuteAudio() {
        return this.m_muteAudio;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends Bg> getOptionMenuClass() {
        return com.nexstreaming.kinemaster.ui.projectedit.X.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int[] getOptionMenuItems() {
        if (this.m_isVoiceRecording) {
            return new int[]{R.id.opt_volume_and_balance, R.id.opt_audio_eq, R.id.opt_volume_env, R.id.opt_audio_voice_changer, R.id.opt_voicerec_review, R.id.opt_voicerec_rerec, R.id.opt_loop, R.id.opt_extend_to_end, R.id.opt_background, R.id.opt_split_trim, R.id.opt_information};
        }
        return new int[]{R.id.opt_volume_and_balance, R.id.opt_audio_eq, R.id.opt_volume_env, R.id.opt_audio_voice_changer, R.id.opt_background, R.id.opt_loop, R.id.opt_extend_to_end, R.id.opt_split_trim, R.id.opt_information};
    }

    public int getOriginalDuration() {
        return this.m_duration;
    }

    public String getOriginalMediaPath() {
        return this.m_mediaPath;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean getPinned() {
        return this.m_pinned;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeEndTime() {
        return this.m_relativeEndTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeStartTime() {
        return this.m_relativeStartTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        return getDuration();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTime() {
        return this.m_relativeStartTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTrim() {
        return this.m_trimTimeStart;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa.b
    public boolean getSwitchOption(int i) {
        if (i == R.id.opt_loop) {
            return isLoop();
        }
        if (i == R.id.opt_background) {
            return isBGM();
        }
        if (i == R.id.opt_extend_to_end) {
            return this.m_extendToEnd;
        }
        return super.getSwitchOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem, com.nexstreaming.kinemaster.editorwrapper.Fa
    public int getTimelineViewLayoutResource() {
        return this.m_isPendingVoiceRecording ? R.layout.timeline_item_secondary_voicepending : (isBGM() || isLegacyBGMusic()) ? R.layout.timeline_item_secondary_bgm : this.m_isVoiceRecording ? R.layout.timeline_item_secondary_voice : R.layout.timeline_item_secondary_audio;
    }

    public String getTitle(Context context) {
        if (context == null) {
            return this.m_mediaTitle;
        }
        if (isLegacyBGMusic()) {
            NexTimeline timeline = getTimeline();
            String customBGMusic = timeline.getCustomBGMusic();
            String customBGMTitle = timeline.getCustomBGMTitle();
            if (customBGMusic != null) {
                return customBGMTitle != null ? customBGMTitle : customBGMusic;
            }
            return context.getString(R.string.n2_bgm_label);
        }
        String str = this.m_mediaTitle;
        if (str != null) {
            return str;
        }
        String str2 = this.m_mediaPath;
        return str2 != null ? str2 : context.getString(R.string.audio_clip);
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getTrackAffinity() {
        return this.m_isVoiceRecording ? R.drawable.track_header_voice_record_icon : this.m_isUserChoiceBGMusic ? R.drawable.track_header_bg_music_icon : R.drawable.track_header_music_icon;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int[] getTrackOptionItems() {
        return new int[]{R.id.opt_volume_and_balance};
    }

    public NexVideoClipItem getVideoClip() {
        if (this.m_videoClip == null && this.k != null) {
            this.m_videoClip = (NexVideoClipItem) getTimeline().findItemByUniqueId(this.k);
        } else {
            NexVideoClipItem nexVideoClipItem = this.m_videoClip;
            if (nexVideoClipItem != null && this.k == null) {
                this.k = nexVideoClipItem.getUniqueId();
            }
        }
        return this.m_videoClip;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecLegacyMemoryUsage() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoTrackUsage() {
        return 0;
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
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeLevel(int i) {
        if (this.m_volumeEnvelopeLevel == null || i >= this.m_volumeEnvelopeTime.size()) {
            return -1;
        }
        return this.m_volumeEnvelopeLevel.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeTime(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null || i >= arrayList.size()) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.Vh
    public int getVolumeEnvelopeTimeAdj(int i) {
        ArrayList<Integer> arrayList = this.m_volumeEnvelopeTime;
        if (arrayList == null || i >= arrayList.size()) {
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean hasDependencyFromAsset(String str) {
        if (!isAssetMusic() || getMusicAssetId() == null) {
            return false;
        }
        String musicAssetId = getMusicAssetId();
        String substring = musicAssetId.substring(0, musicAssetId.indexOf(47));
        return substring != null && substring.equals(str);
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return true;
    }

    public boolean isAssetMusic() {
        String str = this.m_mediaPath;
        return str != null && str.startsWith("@kmasset:");
    }

    public boolean isBGM() {
        return this.m_isUserChoiceBGMusic;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public boolean isCheckedAudioCompressor() {
        return this.m_audioCompressor > 0;
    }

    public boolean isExtendToEnd() {
        if (this.m_loop) {
            return this.m_extendToEnd;
        }
        return false;
    }

    public boolean isLegacyBGMusic() {
        return this.m_isBGMusic;
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public boolean isLoop() {
        return this.m_loop;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_audio_eq /* 2131363088 */:
                return this.m_equalizer != null;
            case R.id.opt_audio_voice_changer /* 2131363091 */:
                return isVoiceChangerApplied();
            case R.id.opt_background /* 2131363093 */:
                return false;
            case R.id.opt_information /* 2131363120 */:
                String str = this.m_clipName;
                return str != null && str.trim().length() > 0;
            default:
                switch (i) {
                    case R.id.opt_voicerec_rerec /* 2131363164 */:
                    case R.id.opt_voicerec_review /* 2131363165 */:
                        break;
                    case R.id.opt_volume /* 2131363166 */:
                    case R.id.opt_volume_and_balance /* 2131363167 */:
                        return e();
                    case R.id.opt_volume_env /* 2131363168 */:
                        return isVolumeEnvelopeApplied();
                    default:
                        return super.isOptionApplied(i);
                }
            case R.id.opt_loop /* 2131363128 */:
            case R.id.opt_split_trim /* 2131363143 */:
                return false;
        }
    }

    public boolean isThemeMusic() {
        String str = this.m_mediaPath;
        return str != null && str.startsWith("@theme:");
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isTrimmable() {
        return true;
    }

    public boolean isVoiceChangerApplied() {
        return this.m_voiceChanger > 0 || this.m_enhancedAudioFilter != null;
    }

    public boolean isVolumeEnvelopeApplied() {
        int volumeEnvelopeLength = getVolumeEnvelopeLength();
        for (int i = 0; i < volumeEnvelopeLength; i++) {
            if (getVolumeEnvelopeLevel(i) != 100) {
                return true;
            }
        }
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void moveClip(int i) {
        this.m_relativeEndTime = (this.m_relativeEndTime - this.m_relativeStartTime) + i;
        this.m_relativeStartTime = i;
        requestTimelineCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.i iVar, NexTimelineItem.w wVar, float f2, float f3, float f4) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.i iVar, NexTimelineItem.w wVar) {
        ViewGroup viewGroup;
        a aVar = (a) iVar;
        WindowManager windowManager = aVar.l;
        if (windowManager != null && (viewGroup = aVar.k) != null) {
            windowManager.removeView(viewGroup);
            aVar.k = null;
        }
        DragType dragType = aVar.f24076c;
        if (dragType == DragType.END) {
            wVar.a(getAbsEndTime() - 1, true);
        } else if (dragType == DragType.START) {
            wVar.a(getAbsStartTime(), true);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag_v3(NexTimelineItem.i iVar, NexTimelineItem.w wVar, float f2, float f3, float f4) {
        a aVar = (a) iVar;
        if (isExtendToEnd()) {
            return false;
        }
        int i = C2311ha.f24290a[aVar.f24076c.ordinal()];
        if (i == 1) {
            if (this.m_loop) {
                int i2 = this.m_relativeStartTime;
                int i3 = aVar.f24077d;
                this.m_relativeEndTime = i2 + i3 + ((int) ((f2 / f4) * 1000.0f));
                int i4 = this.m_relativeEndTime;
                if (i4 < i2 + 100) {
                    this.m_relativeEndTime = i2 + 100;
                } else {
                    int i5 = (i4 - i2) - i3;
                    int i6 = aVar.f24078e;
                    if (i5 > i6) {
                        this.m_relativeEndTime = i2 + i3 + i6;
                    }
                }
                aVar.j.invalidate();
            } else {
                int endTime = getEndTime() - ((aVar.f24077d - ((int) ((f2 / f4) * 1000.0f))) - getEndTrim());
                if (endTime > this.m_duration + getStartTime()) {
                    endTime = getStartTime() + this.m_duration;
                }
                if (endTime - getStartTime() < 100) {
                    endTime = getStartTime() + 100;
                }
                trimClip(getStartTime(), endTime);
                aVar.j.invalidate();
            }
            wVar.a(true);
        } else {
            if (i != 2) {
                return false;
            }
            int i7 = aVar.f24077d + ((int) ((f2 / f4) * 1000.0f));
            int startTrim = (i7 - getStartTrim()) + getStartTime();
            if (startTrim < 0) {
                startTrim = 0;
            }
            if (getEndTime() - startTrim < 100) {
                startTrim = getEndTime() - 100;
            }
            trimClip(startTrim, getEndTime());
            aVar.j.invalidate();
        }
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.i iVar, Rect rect) {
        a aVar = (a) iVar;
        if (aVar.l == null || aVar.k == null) {
            return;
        }
        if (aVar.f24076c == DragType.END) {
            aVar.m.x = rect.right - (aVar.f24080g / 2);
        } else {
            aVar.m.x = rect.left - (aVar.f24080g / 2);
        }
        aVar.l.updateViewLayout(aVar.k, aVar.m);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onDown(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 != R.id.editmode_trim || !z || isLegacyBGMusic() || isExtendToEnd()) {
            return null;
        }
        return onDown_trim(context, wVar, rectF, i, i2, z, i3);
    }

    public NexTimelineItem.k onDown_trim(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        int absEndTime;
        C2303da c2303da = null;
        if (i3 != R.id.editmode_trim) {
            return null;
        }
        int secondaryItemCount = getTimeline().getSecondaryItemCount();
        int i4 = 0;
        for (int i5 = 0; i5 < secondaryItemCount; i5++) {
            NexSecondaryTimelineItem secondaryItem = getTimeline().getSecondaryItem(i5);
            if (secondaryItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                if (nexAudioClipItem.getAbsStartTime() <= getAbsEndTime() && (absEndTime = nexAudioClipItem.getAbsEndTime()) > i4) {
                    i4 = absEndTime;
                }
            }
        }
        if (!this.m_loop && rectF.width() < rectF.height() * 4.0f) {
            if (i < rectF.left + (rectF.width() / 2.0f)) {
                a aVar = new a(c2303da);
                aVar.f24076c = DragType.START;
                aVar.o = context;
                aVar.f24077d = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeStart;
                aVar.f24078e = wVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
                a(aVar, context, (int) rectF.left, (int) rectF.top);
                return aVar;
            }
            a aVar2 = new a(c2303da);
            aVar2.f24076c = DragType.END;
            aVar2.o = context;
            aVar2.f24077d = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeEnd;
            aVar2.f24078e = wVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
            a(aVar2, context, (int) rectF.right, (int) rectF.top);
            return aVar2;
        }
        if (!this.m_loop && i < rectF.left + (rectF.height() * 2.0f)) {
            a aVar3 = new a(c2303da);
            aVar3.f24076c = DragType.START;
            aVar3.o = context;
            aVar3.f24077d = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeStart;
            aVar3.f24079f = this.m_extraRelativeStartTime;
            aVar3.f24078e = wVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
            a(aVar3, context, (int) rectF.left, (int) rectF.top);
            return aVar3;
        }
        if (i <= rectF.right - (rectF.height() * 2.0f)) {
            return null;
        }
        a aVar4 = new a(c2303da);
        aVar4.f24076c = DragType.END;
        aVar4.o = context;
        aVar4.f24077d = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeEnd;
        aVar4.f24078e = wVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
        a(aVar4, context, (int) rectF.right, (int) rectF.top);
        return aVar4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x0291, code lost:            r14 = r33;     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x0295, code lost:            r30 = r8;        r8 = r9;        r31 = r11;        r28 = r12;        r7 = r22;     */
    /* JADX WARN: Removed duplicated region for block: B:134:0x05e0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0668  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0334  */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onDraw(com.nexstreaming.kinemaster.ui.projectedit.C1916ib r34) {
        /*
            Method dump skipped, instructions count: 1772
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexAudioClipItem.onDraw(com.nexstreaming.kinemaster.ui.projectedit.ib):void");
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.k onLongPress(Context context, NexTimelineItem.w wVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return NexTimelineItem.k.f24133a;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.p pVar) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onTimelineLoaded() {
        String str = this.m_originalMediaPath;
        if (str != null && str.startsWith("@")) {
            this.m_mediaPath = this.m_originalMediaPath;
            this.m_originalMediaPath = null;
        }
        NexPrimaryTimelineItem anchorItem = getAnchorItem();
        if (anchorItem != null) {
            int absStartTime = anchorItem.getAbsStartTime();
            this.m_relativeStartTime += absStartTime;
            this.m_relativeEndTime += absStartTime;
            this.k = null;
            this.m_videoClip = null;
        }
        super.onTimelineLoaded();
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

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setAnchorItem(NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        this.m_videoClip = (NexVideoClipItem) nexPrimaryTimelineItem;
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

    public void setAudioSplitState(boolean z) {
        this.m = z;
    }

    public void setBGM(boolean z) {
        this.m_isUserChoiceBGMusic = z;
    }

    public void setClipName(String str) {
        this.m_clipName = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setClipVolume(int i) {
        this.m_clipVolume = i;
    }

    @Deprecated
    public void setCustomBGMusic(String str, String str2) {
        this.f24074g = null;
        this.j = null;
        this.f24075h = str;
        this.i = str2;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        throw new RuntimeException("setDuration not permitted on audio clips");
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTime(int i) {
        this.m_relativeEndTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTrim(int i) {
        this.m_trimTimeEnd = i;
    }

    public void setEngineClipIDAfterDuplicate(int i) {
        this.m_engineClipID = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setEqualizer(String str) {
        this.m_equalizer = str;
    }

    public void setExtendToEnd(boolean z) {
        if (this.m_extendToEnd != z) {
            this.m_extendToEnd = z;
            postNotification();
        }
    }

    public void setExtraRelativeStartTime(int i) {
        this.m_extraRelativeStartTime = i;
    }

    public void setIsExtractAudio(boolean z) {
        this.m_isExtractAudio = z;
    }

    public void setIsPendingVoiceRecording(boolean z) {
        this.m_isPendingVoiceRecording = z;
    }

    public void setIsVoiceRecording(boolean z) {
        this.m_isVoiceRecording = z;
    }

    public void setLocked(boolean z) {
        this.isLocked = z;
    }

    public void setLoop(boolean z) {
        if (this.m_loop == z) {
            return;
        }
        this.m_loop = z;
        if (z) {
            this.m_savedTrimTimeStart = this.m_trimTimeStart;
            this.m_savedTrimTimeEnd = this.m_trimTimeEnd;
            this.m_trimTimeStart = 0;
            this.m_trimTimeEnd = 0;
            int i = this.m_savedLoopDuration;
            if (i > 0) {
                this.m_relativeEndTime = this.m_relativeStartTime + i;
            } else {
                int i2 = this.m_savedRelativeEndTime;
                if (i2 > 0) {
                    this.m_relativeEndTime = i2;
                }
            }
            this.m_savedLoopDuration = 0;
            this.m_loop = true;
        } else {
            this.m_loop = false;
            this.m_trimTimeStart = this.m_savedTrimTimeStart;
            this.m_trimTimeEnd = this.m_savedTrimTimeEnd;
            int i3 = this.m_relativeEndTime;
            int i4 = this.m_relativeStartTime;
            this.m_savedLoopDuration = i3 - i4;
            this.m_savedRelativeEndTime = 0;
            this.m_relativeEndTime = ((i4 + this.m_duration) - this.m_trimTimeStart) - this.m_trimTimeEnd;
        }
        postNotification();
    }

    public void setMediaPath(String str) {
        this.f24074g = null;
        this.m_mediaPath = str;
        this.j = null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.e
    public void setMuteAudio(boolean z) {
        this.m_muteAudio = z;
    }

    public void setOriginalMediaPath(String str) {
        this.m_mediaPath = str;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setPinned(boolean z) {
        this.m_pinned = z;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeEndTime(int i) {
        this.m_relativeEndTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeStartTime(int i) {
        this.m_relativeEndTime = (this.m_relativeEndTime - this.m_relativeStartTime) + i;
        this.m_relativeStartTime = i;
        requestTimelineCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTime(int i) {
        this.m_relativeStartTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTrim(int i) {
        this.m_trimTimeStart = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_loop) {
            setLoop(z);
        } else if (i == R.id.opt_background) {
            setBGM(z);
        } else if (i == R.id.opt_extend_to_end) {
            setExtendToEnd(z);
        } else {
            super.setSwitchOption(i, z, context);
            throw null;
        }
        return null;
    }

    public void setTitle(String str) {
        this.m_mediaTitle = str;
    }

    public void setVideoClip(NexVideoClipItem nexVideoClipItem) {
        if (nexVideoClipItem == null) {
            this.m_videoClip = null;
            this.k = null;
        } else {
            this.m_videoClip = nexVideoClipItem;
            this.k = nexVideoClipItem.getUniqueId();
        }
        requestTimelineCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setVoiceChanger(String str) {
        this.m_enhancedAudioFilter = str;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void trimClip(int i, int i2) {
        if (i2 - i >= 1) {
            int i3 = this.m_relativeStartTime - this.m_trimTimeStart;
            int i4 = this.m_duration + i3;
            if (i < i3) {
                i = i3;
            }
            if (i2 <= i) {
                i2 = i + 1;
            }
            if (i2 > i4) {
                i2 = i4;
            }
            if (i >= i2) {
                i = i2 - 1;
            }
            this.m_relativeStartTime = i;
            this.m_relativeEndTime = i2;
            this.m_trimTimeStart = i - i3;
            this.m_trimTimeEnd = i4 - i2;
            requestTimelineCalcTimes();
            return;
        }
        throw new IllegalArgumentException("End time must be greater than start time");
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.u
    public void trimToLeft(int i) {
        setAudioSplitState(true);
        trimClip(i, getEndTime());
        getTimeline().requestCalcTimes();
        setAudioSplitState(false);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.u
    public void trimToRight(int i) {
        setAudioSplitState(true);
        trimClip(getStartTime(), i);
        getTimeline().requestCalcTimes();
        setAudioSplitState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends NexTimelineItem.i {

        /* renamed from: c, reason: collision with root package name */
        DragType f24076c;

        /* renamed from: d, reason: collision with root package name */
        int f24077d;

        /* renamed from: e, reason: collision with root package name */
        int f24078e;

        /* renamed from: f, reason: collision with root package name */
        int f24079f;

        /* renamed from: g, reason: collision with root package name */
        int f24080g;

        /* renamed from: h, reason: collision with root package name */
        int f24081h;
        TextView i;
        View j;
        ViewGroup k;
        WindowManager l;
        WindowManager.LayoutParams m;
        int n;
        Context o;

        private a() {
            this.f24076c = null;
            this.f24077d = 0;
            this.f24078e = 0;
            this.f24079f = 0;
            this.f24080g = 0;
            this.f24081h = 0;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = 0;
        }

        /* synthetic */ a(C2303da c2303da) {
            this();
        }
    }

    public NexAudioClipItem(boolean z) {
        this.isLocked = false;
        this.m_clipVolume = 100;
        this.m_loop = false;
        this.m_extendToEnd = false;
        this.m_isVoiceRecording = false;
        this.m_isPendingVoiceRecording = false;
        this.m_isExtractAudio = false;
        this.m_clipWidth = 0.0f;
        this.m_voiceChanger = 0;
        this.m_audioCompressor = 0;
        this.m_pitchFactor = 0;
        this.m_audioPanLeft = -111;
        this.m_audioPanRight = -111;
        this.l = false;
        this.m = false;
        this.n = null;
        this.p = false;
        this.m_isBGMusic = z;
    }

    private void a(a aVar, Context context, int i, int i2) {
        String str;
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        Paint paint = new Paint();
        DragType dragType = aVar.f24076c;
        if (dragType == DragType.START) {
            str = aVar.o.getResources().getString(R.string.video_drag_starttrim, EditorGlobal.a(this.m_trimTimeStart));
        } else if (dragType != DragType.END) {
            str = "";
        } else if (this.m_loop) {
            str = aVar.o.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.m_relativeEndTime - this.m_relativeStartTime));
        } else {
            str = aVar.o.getResources().getString(R.string.video_drag_endtrim, EditorGlobal.a(this.m_trimTimeEnd));
        }
        paint.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.getTextBounds(str, 0, str.length(), rect);
        aVar.f24080g = Math.max(rect.width() + 10, (int) TypedValue.applyDimension(1, 100.0f, displayMetrics));
        aVar.f24081h = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
        aVar.n = i - (aVar.f24080g / 2);
        aVar.l = (WindowManager) context.getSystemService("window");
        aVar.k = new FrameLayout(context);
        aVar.k.setBackgroundColor(0);
        aVar.j = new C2307fa(this, context, aVar);
        aVar.j.setLayoutParams(new FrameLayout.LayoutParams(aVar.f24080g, aVar.f24081h));
        aVar.k.addView(aVar.j);
        aVar.m = new WindowManager.LayoutParams();
        WindowManager.LayoutParams layoutParams = aVar.m;
        layoutParams.width = aVar.f24080g;
        int i3 = aVar.f24081h;
        layoutParams.height = i3;
        layoutParams.flags = 408;
        layoutParams.gravity = 51;
        layoutParams.x = aVar.n;
        layoutParams.y = (i2 - i3) + ((int) TypedValue.applyDimension(1, 2.0f, displayMetrics));
        WindowManager.LayoutParams layoutParams2 = aVar.m;
        layoutParams2.windowAnimations = 0;
        layoutParams2.format = -3;
        aVar.l.addView(aVar.k, layoutParams2);
    }

    private void a() {
        if (getVolumeEnvelopeTimeAdj(0) == -1) {
            int originalDuration = getOriginalDuration();
            addVolumeEnvelope(0, 0, 100);
            addVolumeEnvelope(1, originalDuration, 100);
        }
    }
}
