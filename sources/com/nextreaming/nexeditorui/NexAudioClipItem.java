package com.nextreaming.nexeditorui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.internal.Utility;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.kp;
import com.nexstreaming.kinemaster.ui.projectedit.nb;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexAudioClip;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: classes.dex */
public class NexAudioClipItem extends NexSecondaryTimelineItem implements nb, NexTimelineItem.b, NexTimelineItem.d, NexTimelineItem.s {

    /* renamed from: a, reason: collision with root package name */
    private static Rect f4477a = new Rect();
    private static final long serialVersionUID = 2;
    private transient String b;
    private transient String c;
    private transient String d;
    private transient Bitmap e;
    private transient UUID f;
    private transient boolean g;
    private transient boolean h;
    private transient MediaInfo i;
    private transient byte[] j;
    private transient boolean k;
    private transient boolean l;
    private int m_audioCompressor;
    private int m_audioPanLeft;
    private int m_audioPanRight;
    private int m_clipVolume;
    private float m_clipWidth;
    private int m_duration;
    private int m_engineClipID;
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
        this.g = false;
        this.h = false;
        this.i = null;
        this.k = false;
        this.m_isBGMusic = false;
    }

    public NexAudioClipItem(boolean z) {
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
        this.g = false;
        this.h = false;
        this.i = null;
        this.k = false;
        this.m_isBGMusic = z;
    }

    public static NexAudioClipItem newInstance(int i, String str) {
        NexAudioClipItem nexAudioClipItem = new NexAudioClipItem();
        nexAudioClipItem.m_engineClipID = i;
        nexAudioClipItem.m_mediaPath = str;
        nexAudioClipItem.m_mediaTitle = new File(str).getName();
        nexAudioClipItem.a();
        if (nexAudioClipItem.i == null) {
            return null;
        }
        nexAudioClipItem.m_duration = nexAudioClipItem.i.y();
        nexAudioClipItem.m_relativeStartTime = 0;
        nexAudioClipItem.m_relativeEndTime = nexAudioClipItem.m_relativeStartTime + nexAudioClipItem.m_duration;
        return nexAudioClipItem;
    }

    public void setEngineClipIDAfterDuplicate(int i) {
        this.m_engineClipID = i;
    }

    public boolean isThemeMusic() {
        return this.m_mediaPath != null && this.m_mediaPath.startsWith("@theme:");
    }

    public String getMusicThemeId() {
        if (this.m_mediaPath == null || !this.m_mediaPath.startsWith("@theme:")) {
            return null;
        }
        return this.m_mediaPath.substring(7);
    }

    public String getOriginalMediaPath() {
        return this.m_mediaPath;
    }

    public String getMediaPath() {
        if (this.b == null) {
            this.b = this.m_mediaPath;
            if (this.m_mediaPath.startsWith("@")) {
                File file = null;
                if (getTimeline() != null) {
                    file = getTimeline().resolveMusicPath(this.m_mediaPath);
                } else if (this.m_mediaPath.startsWith("@theme:")) {
                    file = KineMasterApplication.a().e().h(this.m_mediaPath.substring(7));
                }
                if (file != null) {
                    this.b = file.getAbsolutePath();
                }
            }
        }
        return this.b;
    }

    public int getEngineClipID() {
        return this.m_engineClipID;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeEndTime() {
        return this.m_relativeEndTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getRelativeStartTime() {
        return this.m_relativeStartTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTrim() {
        return this.m_trimTimeStart;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTrim(int i) {
        this.m_trimTimeStart = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTrim() {
        return this.m_trimTimeEnd;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void moveClip(int i) {
        this.m_relativeEndTime = (this.m_relativeEndTime - this.m_relativeStartTime) + i;
        this.m_relativeStartTime = i;
        requestTimelineCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void trimClip(int i, int i2) {
        if (i2 - i < 1) {
            throw new IllegalArgumentException("End time must be greater than start time");
        }
        int i3 = this.m_relativeStartTime - this.m_trimTimeStart;
        int i4 = i3 + this.m_duration;
        int i5 = i < i3 ? i3 : i;
        int i6 = i2 <= i5 ? i5 + 1 : i2;
        if (i6 > i4) {
            i6 = i4;
        }
        if (i5 >= i6) {
            i5 = i6 - 1;
        }
        this.m_relativeStartTime = i5;
        this.m_relativeEndTime = i6;
        this.m_trimTimeStart = i5 - i3;
        this.m_trimTimeEnd = i4 - i6;
        requestTimelineCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTrim(int i) {
        this.m_trimTimeEnd = i;
    }

    public int getOriginalDuration() {
        return this.m_duration;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAbsEndTime() {
        NexTimeline timeline;
        if (isExtendToEnd() && (timeline = getTimeline()) != null) {
            return Math.max(getAbsStartTime() + LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, timeline.getTotalTime());
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
        if (this.m_pinned) {
            return this.m_relativeStartTime + this.m_extraRelativeStartTime;
        }
        NexVideoClipItem videoClip = getVideoClip();
        if (videoClip == null) {
            return this.m_relativeStartTime + this.m_extraRelativeStartTime;
        }
        return videoClip.getAbsStartTime() + this.m_relativeStartTime + this.m_extraRelativeStartTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        if (isLegacyBGMusic()) {
            NexTimeline timeline = getTimeline();
            if (timeline == null) {
                return 0;
            }
            return timeline.getTotalTime();
        }
        if (isExtendToEnd()) {
            return getAbsEndTime() - getAbsStartTime();
        }
        return this.m_relativeEndTime - this.m_relativeStartTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        return getDuration();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        throw new RuntimeException("setDuration not permitted on audio clips");
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeStartTime(int i) {
        this.m_relativeEndTime = (this.m_relativeEndTime - this.m_relativeStartTime) + i;
        this.m_relativeStartTime = i;
        requestTimelineCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setRelativeEndTime(int i) {
        this.m_relativeEndTime = i;
    }

    public boolean isLoop() {
        return this.m_loop;
    }

    public String getTitle(Context context) {
        Theme e;
        String a2;
        if (context == null) {
            return this.m_mediaTitle;
        }
        if (isLegacyBGMusic()) {
            NexTimeline timeline = getTimeline();
            String customBGMusic = timeline.getCustomBGMusic();
            String customBGMTitle = timeline.getCustomBGMTitle();
            if (customBGMusic != null) {
                return customBGMTitle == null ? customBGMusic : customBGMTitle;
            }
            EffectLibrary effectLibrary = null;
            if (EditorGlobal.a() != null) {
                effectLibrary = EditorGlobal.a().q();
            }
            if (effectLibrary != null && timeline != null && (e = effectLibrary.e(timeline.getThemeId())) != null && (a2 = e.a(context)) != null) {
                return context.getString(R.string.background_music_track, a2);
            }
            return context.getString(R.string.n2_bgm_label);
        }
        if (this.m_mediaTitle != null) {
            return this.m_mediaTitle;
        }
        if (this.m_mediaPath != null) {
            return this.m_mediaPath;
        }
        return context.getString(R.string.audio_clip);
    }

    public void setTitle(String str) {
        this.m_mediaTitle = str;
    }

    public void setVideoClip(NexVideoClipItem nexVideoClipItem) {
        if (nexVideoClipItem == null) {
            this.m_videoClip = null;
            this.f = null;
        } else {
            this.m_videoClip = nexVideoClipItem;
            this.f = nexVideoClipItem.getUniqueId();
        }
        requestTimelineCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setAnchorItem(NexPrimaryTimelineItem nexPrimaryTimelineItem) {
        this.m_videoClip = (NexVideoClipItem) nexPrimaryTimelineItem;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public NexPrimaryTimelineItem getAnchorItem() {
        return getVideoClip();
    }

    public void setExtendToEnd(boolean z) {
        this.m_extendToEnd = z;
    }

    public boolean isExtendToEnd() {
        if (this.m_loop) {
            return this.m_extendToEnd;
        }
        return false;
    }

    public boolean isAudioModulationApplied() {
        return this.m_voiceChanger != 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public void setAudioEffect(int i) {
        this.m_voiceChanger = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.b
    public int getAudioEffect() {
        return this.m_voiceChanger;
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
        if (isBGM() || isLegacyBGMusic()) {
            return AudioType.BackgroundAudio;
        }
        return AudioType.Music;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setStartTime(int i) {
        this.m_relativeStartTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setEndTime(int i) {
        this.m_relativeEndTime = i;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getStartTime() {
        return this.m_relativeStartTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getEndTime() {
        return this.m_relativeEndTime;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public void setPinned(boolean z) {
        this.m_pinned = z;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean getPinned() {
        return this.m_pinned;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public boolean hasIntrinsicDuration() {
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexSecondaryTimelineItem
    public int getIntinsicDuration() {
        return this.m_duration;
    }

    private void a() {
        String mediaPath = getMediaPath();
        String absolutePath = this.i == null ? null : this.i.h().getAbsolutePath();
        if (this.i == null || !absolutePath.equals(mediaPath)) {
            if (this.i != null) {
            }
            this.i = MediaInfo.a(mediaPath);
            this.j = null;
            this.k = false;
            this.l = false;
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onDraw(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar) {
        int i;
        int i2;
        Drawable drawable;
        float f;
        float f2;
        int y;
        boolean f3 = ayVar.f();
        RectF d = ayVar.d();
        TextPaint e = ayVar.e();
        Canvas b = ayVar.b();
        RectF c = ayVar.c();
        float j = ayVar.j();
        NexTimelineItem.p a2 = ayVar.a();
        a();
        if (this.j == null && this.i != null && !this.l && !this.k) {
            this.l = true;
            this.i.c().onResultAvailable(new bq(this, a2));
        }
        Drawable drawable2 = ayVar.getResources().getDrawable(f3 ? R.drawable.timeline_item_border_sel : R.drawable.timeline_item_border_nor);
        drawable2.getPadding(f4477a);
        this.m_clipWidth = c.width();
        d.set(c);
        d.left += f4477a.left;
        d.top += f4477a.top;
        d.right -= f4477a.right;
        d.bottom -= f4477a.bottom;
        if (ayVar.g()) {
            e.setStyle(Paint.Style.STROKE);
            e.setColor(-6710887);
            e.setStrokeWidth(1.0f);
            b.drawRoundRect(d, 2.0f, 2.0f, e);
            return;
        }
        if (this.m_isPendingVoiceRecording) {
            i = R.color.audioclip_voicerec_pend_bg;
            i2 = R.color.audioclip_voicerec_pend_pcm;
        } else if (isBGM() || isLegacyBGMusic()) {
            i = R.color.audioclip_other_bg;
            i2 = R.color.audioclip_other_pcm;
        } else if (this.m_isVoiceRecording) {
            i = R.color.audioclip_voicerec_bg;
            i2 = R.color.audioclip_voicerec_pcm;
        } else if (this.m_isExtractAudio) {
            i = R.color.audioclip_extract_bg;
            i2 = R.color.audioclip_extract_pcm;
        } else {
            i = R.color.audioclip_music_bg;
            i2 = R.color.audioclip_music_pcm;
        }
        int color = ayVar.getResources().getColor(i);
        int color2 = ayVar.getResources().getColor(i2);
        e.setStyle(Paint.Style.FILL);
        e.setColor(color);
        b.drawRect(d, e);
        if (this.j != null) {
            a(b);
            if (this.e != null) {
                e.setColor(color2);
                e.setFilterBitmap(false);
                Rect rect = new Rect(0, 0, this.e.getWidth(), this.e.getHeight());
                List<ef> o = ayVar.o();
                if (o != null) {
                    b.save();
                    b.clipRect(d);
                    int y2 = isLegacyBGMusic() ? this.i.y() : getOriginalDuration();
                    if (y2 > 0) {
                        int startTrim = rect.left + ((getStartTrim() * this.e.getWidth()) / y2);
                        if (isLegacyBGMusic() || isLoop()) {
                            y = rect.right - (((this.i.y() - getDuration()) * this.e.getWidth()) / this.i.y());
                            rect.right = y;
                        } else {
                            y = (int) (rect.right - ((getEndTrim() * this.e.getWidth()) / (isLegacyBGMusic() ? this.i.y() : getOriginalDuration())));
                            rect.right = y;
                        }
                        int i3 = y - startTrim;
                        int absEndTime = getAbsEndTime() - getAbsStartTime();
                        float f4 = d.left;
                        int i4 = 0;
                        int y3 = (absEndTime / this.i.y()) + 1;
                        int i5 = 1;
                        while (true) {
                            int i6 = i5;
                            int i7 = i4;
                            if (i6 > y3) {
                                break;
                            }
                            int y4 = (i6 - 1) * this.i.y();
                            int i8 = i7;
                            i4 = i7;
                            while (i8 < o.size() - 1) {
                                ef efVar = o.get(i8);
                                ef efVar2 = o.get(i8 + 1);
                                if (absEndTime > 0 && i3 > 0) {
                                    rect.left = (((efVar.f4622a - y4) * i3) / absEndTime) + startTrim;
                                    rect.right = (int) (startTrim + (((efVar2.f4622a - y4) * i3) / absEndTime));
                                    d.left = efVar.b + f4;
                                    d.right = efVar2.b + f4 + 1.0f;
                                    if (rect.right > (i3 / y3) - 20 && i8 - 2 == o.size()) {
                                        d.right -= 20.0f;
                                    }
                                    if (!f3 && efVar.f4622a == efVar2.f4622a) {
                                        e.setColor(color);
                                    } else {
                                        e.setColor(color2);
                                    }
                                    b.save();
                                    b.clipRect(d);
                                    b.drawBitmap(this.e, rect, d, e);
                                    b.restore();
                                    if (efVar2.f4622a < this.i.y() * i6) {
                                        i8++;
                                        i4++;
                                    }
                                }
                                i5 = i6 + 1;
                            }
                            i5 = i6 + 1;
                        }
                    }
                    b.restore();
                } else {
                    rect.left += (getStartTrim() * this.e.getWidth()) / getOriginalDuration();
                    rect.right -= (getEndTrim() * this.e.getWidth()) / getOriginalDuration();
                    b.save();
                    b.clipRect(d);
                    b.drawBitmap(this.e, rect, d, e);
                    b.restore();
                }
            }
        }
        d.set(c);
        d.left += f4477a.left;
        d.top += f4477a.top;
        d.right -= f4477a.right;
        d.bottom -= f4477a.bottom;
        if (this.m_isVoiceRecording) {
            drawable = ayVar.getResources().getDrawable(R.drawable.layericon_audio_voice);
        } else if (this.m_isExtractAudio) {
            drawable = ayVar.getResources().getDrawable(R.drawable.layericon_audio_extracted);
        } else if (getCustomBGMusic() != null) {
            drawable = ayVar.getResources().getDrawable(R.drawable.layericon_audio_theme_music);
        } else if (isLegacyBGMusic()) {
            drawable = ayVar.getResources().getDrawable(R.drawable.layericon_audio_theme_music);
        } else {
            drawable = ayVar.getResources().getDrawable(R.drawable.layericon_audio_music);
        }
        int i9 = (int) (1.0f * j);
        drawable.setBounds(((int) d.left) + i9 + 0, ((int) d.top) + i9, (int) (((drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight()) * (d.height() - (i9 * 2))) + d.left + 0 + i9), ((int) d.bottom) - i9);
        drawable.draw(b);
        e.setColor(-1);
        if (!this.g && !isLegacyBGMusic()) {
            e.setAlpha(50);
        }
        e.setTextSize(ayVar.getResources().getDimension(R.dimen.timeline_audioClipTextSize));
        Paint.FontMetrics fontMetrics = e.getFontMetrics();
        e.setAntiAlias(true);
        b.drawText(getTitle(ayVar), c.left + c.height() + (0.0f * j) + 0, c.centerY() - (fontMetrics.ascent / 3.0f), e);
        if (ayVar.l() == R.id.editmode_volume_adjust && f3 && !ayVar.g() && !isLegacyBGMusic()) {
            List<ef> o2 = ayVar.o();
            d.set(c);
            d.inset(1.0f, 1.0f);
            int size = this.m_volumeEnvelopeTime.size();
            int representedDuration = getRepresentedDuration();
            new Path();
            Drawable drawable3 = ayVar.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
            PointF[] pointFArr = new PointF[size];
            int intrinsicWidth = drawable3.getIntrinsicWidth() / 2;
            int intrinsicHeight = drawable3.getIntrinsicHeight() / 2;
            float f5 = 0.0f;
            b.clipRect(d);
            e.reset();
            e.setAntiAlias(true);
            e.setStrokeWidth(5.0f);
            e.setStyle(Paint.Style.STROKE);
            e.setColor(-1);
            int i10 = 0;
            int i11 = 0;
            float f6 = 0.0f;
            while (i10 < size) {
                if (i10 == 0) {
                    pointFArr[i11] = new PointF();
                    pointFArr[i11].x = (getVolumeEnvelopeTimeAdj(i10) / getRepresentedDuration()) * d.right;
                    pointFArr[i11].y = d.bottom - ((getVolumeEnvelopeLevel(i10) / 200.0f) * d.bottom);
                    f = pointFArr[i11].x;
                    f2 = pointFArr[i11].y;
                } else {
                    int volumeEnvelopeTimeAdj = getVolumeEnvelopeTimeAdj(i10);
                    pointFArr[i11] = new PointF();
                    pointFArr[i11].x = (volumeEnvelopeTimeAdj / representedDuration) * d.right;
                    if (o2 != null) {
                        int i12 = 0;
                        while (true) {
                            int i13 = i12;
                            if (i13 >= o2.size() - 1) {
                                break;
                            }
                            ef efVar3 = o2.get(i13);
                            ef efVar4 = o2.get(i13 + 1);
                            if (efVar3.f4622a > volumeEnvelopeTimeAdj || volumeEnvelopeTimeAdj >= efVar4.f4622a) {
                                i12 = i13 + 1;
                            } else {
                                pointFArr[i11].x = (((volumeEnvelopeTimeAdj - efVar3.f4622a) * (efVar4.b - efVar3.b)) / (efVar4.f4622a - efVar3.f4622a)) + efVar3.b;
                                break;
                            }
                        }
                    }
                    pointFArr[i11].y = d.bottom - ((getVolumeEnvelopeLevel(i10) / 200.0f) * d.bottom);
                    b.drawLine(f6, f5, pointFArr[i11].x, pointFArr[i11].y, e);
                    f = pointFArr[i11].x;
                    f2 = pointFArr[i11].y;
                }
                i10++;
                i11++;
                float f7 = f;
                f5 = f2;
                f6 = f7;
            }
            for (int i14 = 0; i14 < pointFArr.length && pointFArr[i14] != null; i14++) {
                if (pointFArr[i14].x <= ayVar.n() || !ayVar.h()) {
                    drawable3.setBounds(((int) pointFArr[i14].x) - intrinsicWidth, ((int) pointFArr[i14].y) - intrinsicHeight, ((int) pointFArr[i14].x) + intrinsicWidth, ((int) pointFArr[i14].y) + intrinsicHeight);
                    drawable3.draw(b);
                }
            }
        }
        drawPin(ayVar, R.drawable.pin_dark);
        if (getOverLimit()) {
            Drawable drawable4 = ayVar.getResources().getDrawable(R.drawable.stripes_tile);
            int intrinsicWidth2 = drawable4.getIntrinsicWidth();
            int intrinsicHeight2 = drawable4.getIntrinsicHeight();
            int i15 = (int) c.top;
            while (true) {
                int i16 = i15;
                if (i16 >= c.bottom + 1.0f) {
                    break;
                }
                int i17 = (int) c.left;
                while (true) {
                    int i18 = i17;
                    if (i18 < c.right + 1.0f) {
                        int i19 = i18 + intrinsicWidth2;
                        int i20 = i16 + intrinsicHeight2;
                        if (!b.quickReject(i18, i16, i19, i20, Canvas.EdgeType.AA)) {
                            drawable4.setBounds(i18, i16, i19, i20);
                            drawable4.setAlpha(100);
                            drawable4.draw(b);
                        }
                        i17 = i18 + intrinsicWidth2;
                    }
                }
                i15 = i16 + intrinsicHeight2;
            }
        }
        if (ayVar.i()) {
            trimBorderForDragShadow(ayVar, ((int) c.left) + f4477a.left, ((int) c.top) + f4477a.top, ((int) c.right) - f4477a.right, ((int) c.bottom) - f4477a.bottom);
        } else {
            drawable2.setBounds((int) c.left, (int) c.top, (int) c.right, (int) c.bottom);
            drawable2.draw(b);
        }
        if (ayVar.l() == R.id.editmode_trim && f3 && !ayVar.g() && !isLegacyBGMusic() && !isExtendToEnd()) {
            b.save();
            Drawable drawable5 = ayVar.getResources().getDrawable(R.drawable.grip_yellow);
            int a3 = ayVar.a(8.0f);
            b.clipRect(c.left - a3, c.top, c.right + a3, c.bottom, Region.Op.REPLACE);
            Drawable drawable6 = isLoop() ? ayVar.getResources().getDrawable(R.drawable.grip_yellow_right) : drawable5;
            drawable6.setBounds(((int) c.left) - a3, (int) c.top, ((int) c.right) + a3, (int) c.bottom);
            drawable6.draw(b);
            b.restore();
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f, NexTimelineItem.h hVar, boolean z3, float f2, int i, int i2, List<ef> list, NexTimelineItem.p pVar) {
    }

    private void a(Canvas canvas) {
        byte[] bArr;
        int i;
        int min = Math.min(canvas.getMaximumBitmapWidth(), Utility.DEFAULT_STREAM_BUFFER_SIZE);
        if ((this.e == null || this.e.isRecycled() || this.e.getWidth() > min) && this.i != null && (bArr = this.j) != null) {
            Paint paint = new Paint();
            int min2 = Math.min(this.i.y() / 15, min);
            int i2 = -1;
            if (min2 > 0) {
                Bitmap createBitmap = Bitmap.createBitmap(min2, 64, Bitmap.Config.ALPHA_8);
                Canvas canvas2 = new Canvas(createBitmap);
                paint.setAntiAlias(true);
                Path path = new Path();
                int i3 = -1;
                path.moveTo(-50.0f, 65);
                int i4 = 0;
                int i5 = -1;
                while (i4 < min2) {
                    int length = (int) ((i4 * bArr.length) / min2);
                    if (bArr.length > 0) {
                        if (length != i3) {
                            int i6 = 0;
                            for (int i7 = i3 + 1; i7 <= length; i7++) {
                                i6 += bArr[length] & 255;
                            }
                            i = i6 / Math.max(1, length - i3);
                            i3 = length;
                        } else {
                            i = i2;
                        }
                        if (i != i5) {
                            path.lineTo(i4, 64 - ((i * 64) / 255));
                            i5 = i;
                        }
                        i4 += 3;
                        i2 = i;
                    } else {
                        return;
                    }
                }
                path.lineTo(min2 - 1, 64 - ((i2 * 64) / 255));
                path.lineTo(min2 + 50, 65);
                path.close();
                canvas2.drawPath(path, paint);
                this.e = createBitmap;
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.n nVar) {
        return false;
    }

    public NexTimelineItem.i onDown_trim(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        int i4;
        if (i3 != R.id.editmode_trim) {
            return null;
        }
        int secondaryItemCount = getTimeline().getSecondaryItemCount();
        int i5 = 0;
        int i6 = 0;
        while (i6 < secondaryItemCount) {
            NexSecondaryTimelineItem secondaryItem = getTimeline().getSecondaryItem(i6);
            if (secondaryItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                if (nexAudioClipItem.getAbsStartTime() > getAbsEndTime()) {
                    i4 = i5;
                } else {
                    i4 = nexAudioClipItem.getAbsEndTime();
                    if (i4 > i5) {
                    }
                }
                i6++;
                i5 = i4;
            }
            i4 = i5;
            i6++;
            i5 = i4;
        }
        if (!this.m_loop && rectF.width() < rectF.height() * 4.0f) {
            if (i < rectF.left + (rectF.width() / 2.0f)) {
                a aVar = new a(null);
                aVar.f4479a = DragType.START;
                aVar.m = context;
                aVar.b = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeStart;
                aVar.c = tVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
                a(aVar, context, (int) rectF.left, (int) rectF.top);
                return aVar;
            }
            a aVar2 = new a(null);
            aVar2.f4479a = DragType.END;
            aVar2.m = context;
            aVar2.b = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeEnd;
            aVar2.c = tVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
            a(aVar2, context, (int) rectF.right, (int) rectF.top);
            return aVar2;
        }
        if (!this.m_loop && i < rectF.left + (rectF.height() * 2.0f)) {
            a aVar3 = new a(null);
            aVar3.f4479a = DragType.START;
            aVar3.m = context;
            aVar3.b = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeStart;
            aVar3.d = this.m_extraRelativeStartTime;
            aVar3.c = tVar.getTimeline().freeSpaceAtTime(getAbsStartTime() - 1, 3, 100, true);
            a(aVar3, context, (int) rectF.left, (int) rectF.top);
            return aVar3;
        }
        if (i > rectF.right - (rectF.height() * 2.0f)) {
            a aVar4 = new a(null);
            aVar4.f4479a = DragType.END;
            aVar4.m = context;
            aVar4.b = this.m_loop ? this.m_relativeEndTime - this.m_relativeStartTime : this.m_trimTimeEnd;
            aVar4.c = tVar.getTimeline().freeSpaceAtTime(getAbsEndTime() + 1, 3, 100, false);
            a(aVar4, context, (int) rectF.right, (int) rectF.top);
            return aVar4;
        }
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onDown(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 != R.id.editmode_trim || !z || isLegacyBGMusic() || isExtendToEnd()) {
            return null;
        }
        return onDown_trim(context, tVar, rectF, i, i2, z, i3);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onLongPress(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        return NexTimelineItem.i.n;
    }

    private void a(a aVar, Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        Paint paint = new Paint();
        String str = "";
        if (aVar.f4479a == DragType.START) {
            str = aVar.m.getResources().getString(R.string.video_drag_starttrim, EditorGlobal.a(this.m_trimTimeStart));
        } else if (aVar.f4479a == DragType.END) {
            if (this.m_loop) {
                str = aVar.m.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(this.m_relativeEndTime - this.m_relativeStartTime));
            } else {
                str = aVar.m.getResources().getString(R.string.video_drag_endtrim, EditorGlobal.a(this.m_trimTimeEnd));
            }
        }
        paint.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.getTextBounds(str, 0, str.length(), rect);
        aVar.e = Math.max(rect.width() + 10, (int) TypedValue.applyDimension(1, 100.0f, displayMetrics));
        aVar.f = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
        aVar.l = i - (aVar.e / 2);
        aVar.j = (WindowManager) context.getSystemService("window");
        aVar.i = new FrameLayout(context);
        aVar.i.setBackgroundColor(0);
        aVar.h = new br(this, context, aVar);
        aVar.h.setLayoutParams(new FrameLayout.LayoutParams(aVar.e, aVar.f));
        aVar.i.addView(aVar.h);
        aVar.k = new WindowManager.LayoutParams();
        aVar.k.width = aVar.e;
        aVar.k.height = aVar.f;
        aVar.k.flags = 408;
        aVar.k.gravity = 51;
        aVar.k.x = aVar.l;
        aVar.k.y = ((int) TypedValue.applyDimension(1, 2.0f, displayMetrics)) + (i2 - aVar.f);
        aVar.k.windowAnimations = 0;
        aVar.k.format = -3;
        aVar.j.addView(aVar.i, aVar.k);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag_v3(NexTimelineItem.h hVar, NexTimelineItem.t tVar, float f, float f2, float f3) {
        a aVar = (a) hVar;
        if (isExtendToEnd()) {
            return false;
        }
        switch (aVar.f4479a) {
            case END:
                if (this.m_loop) {
                    this.m_relativeEndTime = this.m_relativeStartTime + aVar.b + ((int) ((f / f3) * 1000.0f));
                    if (this.m_relativeEndTime < this.m_relativeStartTime + 500) {
                        this.m_relativeEndTime = this.m_relativeStartTime + 500;
                    } else if ((this.m_relativeEndTime - this.m_relativeStartTime) - aVar.b > aVar.c) {
                        this.m_relativeEndTime = this.m_relativeStartTime + aVar.b + aVar.c;
                    }
                    aVar.h.invalidate();
                } else {
                    int endTime = getEndTime() - ((aVar.b - ((int) ((f / f3) * 1000.0f))) - getEndTrim());
                    if (endTime > this.m_duration + getStartTime()) {
                        endTime = getStartTime() + this.m_duration;
                    }
                    if (endTime - getStartTime() < 500) {
                        endTime = getStartTime() + 500;
                    }
                    trimClip(getStartTime(), endTime);
                    aVar.h.invalidate();
                }
                tVar.a(true);
                break;
            case START:
                int startTrim = ((aVar.b + ((int) ((f / f3) * 1000.0f))) - getStartTrim()) + getStartTime();
                int i = startTrim >= 0 ? startTrim : 0;
                if (getEndTime() - i < 500) {
                    i = getEndTime() - 500;
                }
                trimClip(i, getEndTime());
                aVar.h.invalidate();
                break;
            default:
                return false;
        }
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.h hVar, NexTimelineItem.t tVar, float f, float f2, float f3) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.h hVar, Rect rect) {
        a aVar = (a) hVar;
        if (aVar.j != null && aVar.i != null) {
            if (aVar.f4479a == DragType.END) {
                aVar.k.x = rect.right - (aVar.e / 2);
            } else {
                aVar.k.x = rect.left - (aVar.e / 2);
            }
            aVar.j.updateViewLayout(aVar.i, aVar.k);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.h hVar, NexTimelineItem.t tVar) {
        a aVar = (a) hVar;
        if (aVar.j != null && aVar.i != null) {
            aVar.j.removeView(aVar.i);
            aVar.i = null;
        }
        if (aVar.f4479a == DragType.END) {
            tVar.a(getAbsEndTime() - 1, true);
        } else if (aVar.f4479a == DragType.START) {
            tVar.a(getAbsStartTime(), true);
        }
    }

    public NexVideoClipItem getVideoClip() {
        if (this.m_videoClip == null && this.f != null) {
            this.m_videoClip = (NexVideoClipItem) getTimeline().findItemByUniqueId(this.f);
        } else if (this.m_videoClip != null && this.f == null) {
            this.f = this.m_videoClip.getUniqueId();
        }
        return this.m_videoClip;
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
        if (this.m_volumeEnvelopeTime == null) {
            return 0;
        }
        return this.m_volumeEnvelopeTime.size();
    }

    public int getVolumeEnvelopeTime(int i) {
        if (this.m_volumeEnvelopeTime == null || i >= this.m_volumeEnvelopeTime.size()) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getVolumeEnvelopeTimeAdj(int i) {
        if (this.m_volumeEnvelopeTime == null || i >= this.m_volumeEnvelopeTime.size()) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue() - getStartTrim();
    }

    public int getVolumeEnvelopeTimeForDrawing(int i) {
        return 0;
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getVolumeEnvelopeLevel(int i) {
        if (this.m_volumeEnvelopeLevel == null || i >= this.m_volumeEnvelopeTime.size()) {
            return -1;
        }
        return this.m_volumeEnvelopeLevel.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getEndEnvelopeTime() {
        return getOriginalDuration();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getDiffAVDuration() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void trimToLeft(int i) {
        setAudioSplitState(true);
        trimClip(i, getEndTime());
        getTimeline().requestCalcTimes();
        setAudioSplitState(false);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void trimToRight(int i) {
        setAudioSplitState(true);
        trimClip(getStartTime(), i);
        getTimeline().requestCalcTimes();
        setAudioSplitState(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends NexTimelineItem.h {

        /* renamed from: a, reason: collision with root package name */
        DragType f4479a;
        int b;
        int c;
        int d;
        int e;
        int f;
        TextView g;
        View h;
        ViewGroup i;
        WindowManager j;
        WindowManager.LayoutParams k;
        int l;
        Context m;

        private a() {
            this.f4479a = null;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = 0;
        }

        /* synthetic */ a(bq bqVar) {
            this();
        }
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
        nexAudioClip.mAudioOnOff = this.m_muteAudio ? 0 : 1;
        nexAudioClip.mAutoEnvelop = this.m_isUserChoiceBGMusic ? 1 : 0;
        nexAudioClip.mVoiceChanger = this.m_voiceChanger;
        nexAudioClip.mCompressor = this.m_audioCompressor;
        nexAudioClip.mPitchFactor = this.m_pitchFactor;
        nexAudioClip.mPanLeft = getAudioLeftVolume();
        nexAudioClip.mPanRight = getAudioRightVolume();
        if (getVideoClip() == null) {
            nexAudioClip.mVisualClipID = ((NexVideoClipItem) getTimeline().getPrimaryItem(0)).getEngineClipID();
        } else {
            nexAudioClip.mVisualClipID = getVideoClip().getEngineClipID();
        }
        b();
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
                        arrayList2.add(Integer.valueOf((int) (i2 + (((this.m_trimTimeStart - (this.m_trimTimeStart + i3)) / ((this.m_trimTimeStart + volumeEnvelopeTimeAdj) - (i3 + this.m_trimTimeStart))) * (volumeEnvelopeLevel - i2)))));
                    }
                    arrayList.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList2.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj <= representedDuration && volumeEnvelopeLevel > 0 && volumeEnvelopeTimeAdj == 0) {
                    arrayList.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                    arrayList2.add(Integer.valueOf(volumeEnvelopeLevel));
                } else if (volumeEnvelopeTimeAdj > representedDuration && this.m_trimTimeEnd > 0) {
                    if (arrayList.isEmpty()) {
                        arrayList.add(0);
                        arrayList2.add(Integer.valueOf((int) ((((this.m_trimTimeStart - (this.m_trimTimeStart + i3)) / ((this.m_trimTimeStart + volumeEnvelopeTimeAdj) - (this.m_trimTimeStart + i3))) * (volumeEnvelopeLevel - i2)) + i2)));
                    }
                    arrayList.add(Integer.valueOf(representedDuration));
                    arrayList2.add(Integer.valueOf((int) ((((representedDuration - i3) / (volumeEnvelopeTimeAdj - i3)) * (volumeEnvelopeLevel - i2)) + i2)));
                }
                i++;
                i2 = volumeEnvelopeLevel;
                i3 = volumeEnvelopeTimeAdj;
            }
            nexAudioClip.mVolumeEnvelopeTime = com.nexstreaming.app.general.util.l.a(arrayList);
            nexAudioClip.mVolumeEnvelopeLevel = com.nexstreaming.app.general.util.l.a(arrayList2);
        }
        return nexAudioClip;
    }

    private void b() {
        if (getVolumeEnvelopeTimeAdj(0) == -1) {
            int originalDuration = getOriginalDuration();
            addVolumeEnvelope(0, 0, 100);
            addVolumeEnvelope(1, originalDuration, 100);
        }
    }

    private void c() {
        int i;
        int size = this.m_volumeEnvelopeTime.size();
        int i2 = 1;
        while (i2 < size && size > 2) {
            if (this.m_volumeEnvelopeTime.get(i2).intValue() - this.m_volumeEnvelopeTime.get(i2 - 1).intValue() < 30) {
                this.m_volumeEnvelopeLevel.remove(i2);
                this.m_volumeEnvelopeTime.remove(i2);
                size--;
                i = i2 - 1;
            } else {
                i = i2;
            }
            size = size;
            i2 = i + 1;
        }
    }

    public int getExtraRelativeStartTime() {
        return this.m_extraRelativeStartTime;
    }

    public void setExtraRelativeStartTime(int i) {
        this.m_extraRelativeStartTime = i;
    }

    public void setIsVoiceRecording(boolean z) {
        this.m_isVoiceRecording = z;
    }

    public void setIsPendingVoiceRecording(boolean z) {
        this.m_isPendingVoiceRecording = z;
    }

    public void setIsExtractAudio(boolean z) {
        this.m_isExtractAudio = z;
    }

    public boolean getIsPendingVoiceRecording() {
        return this.m_isPendingVoiceRecording;
    }

    public boolean getIsVoiceRecording() {
        return this.m_isVoiceRecording;
    }

    public boolean getIsExtractAudio() {
        return this.m_isExtractAudio;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean checkResourceState(Context context) {
        if (isLegacyBGMusic()) {
            if (getCustomBGMusic() != null) {
                String mediaPath = getMediaPath();
                if (mediaPath == null) {
                    this.g = false;
                    return false;
                }
                this.g = new File(mediaPath).exists();
                if (!this.g) {
                }
                return this.g;
            }
            return true;
        }
        this.g = new File(getMediaPath()).exists();
        if (!this.g) {
        }
        return this.g;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public int getClipVolume() {
        return this.m_clipVolume;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setClipVolume(int i) {
        this.m_clipVolume = i;
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.d
    public void setMuteAudio(boolean z) {
        this.m_muteAudio = z;
    }

    public void setLoop(boolean z) {
        if (this.m_loop != z) {
            this.m_loop = z;
            if (z) {
                this.m_savedTrimTimeStart = this.m_trimTimeStart;
                this.m_savedTrimTimeEnd = this.m_trimTimeEnd;
                this.m_trimTimeStart = 0;
                this.m_trimTimeEnd = 0;
                if (this.m_savedLoopDuration > 0) {
                    this.m_relativeEndTime = this.m_relativeStartTime + this.m_savedLoopDuration;
                } else if (this.m_savedRelativeEndTime > 0) {
                    this.m_relativeEndTime = this.m_savedRelativeEndTime;
                }
                this.m_savedLoopDuration = 0;
                this.m_loop = true;
                return;
            }
            this.m_loop = false;
            this.m_trimTimeStart = this.m_savedTrimTimeStart;
            this.m_trimTimeEnd = this.m_savedTrimTimeEnd;
            this.m_savedLoopDuration = this.m_relativeEndTime - this.m_relativeStartTime;
            this.m_savedRelativeEndTime = 0;
            this.m_relativeEndTime = ((this.m_relativeStartTime + this.m_duration) - this.m_trimTimeStart) - this.m_trimTimeEnd;
        }
    }

    public boolean isLegacyBGMusic() {
        return this.m_isBGMusic;
    }

    public boolean isBGM() {
        return this.m_isUserChoiceBGMusic;
    }

    public void setBGM(boolean z) {
        this.m_isUserChoiceBGMusic = z;
    }

    @Deprecated
    public void setCustomBGMusic(String str, String str2) {
        this.b = null;
        this.e = null;
        this.c = str;
        this.d = str2;
    }

    public String getCustomBGMusic() {
        return this.c;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onThemeChanged(Theme theme, EffectLibrary effectLibrary) {
        this.b = null;
        this.e = null;
        super.onThemeChanged(theme, effectLibrary);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onTimelineLoaded(EffectLibrary effectLibrary, int i) {
        NexPrimaryTimelineItem anchorItem;
        if (this.m_originalMediaPath != null && this.m_originalMediaPath.startsWith("@")) {
            this.m_mediaPath = this.m_originalMediaPath;
            this.m_originalMediaPath = null;
        }
        if (i == 3 && (anchorItem = getAnchorItem()) != null) {
            int absStartTime = anchorItem.getAbsStartTime();
            this.m_relativeStartTime += absStartTime;
            this.m_relativeEndTime = absStartTime + this.m_relativeEndTime;
            this.f = null;
            this.m_videoClip = null;
        }
        super.onTimelineLoaded(effectLibrary, i);
    }

    public boolean getAudioSplitState() {
        return this.h;
    }

    public void setAudioSplitState(boolean z) {
        this.h = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int[] getOptionMenuItems() {
        return this.m_isVoiceRecording ? new int[]{R.id.opt_volume_and_balance, R.id.opt_audio_effect, R.id.opt_volume_env, R.id.opt_voicerec_review, R.id.opt_voicerec_rerec, R.id.opt_loop, R.id.opt_extend_to_end, R.id.opt_background, R.id.opt_split_trim} : new int[]{R.id.opt_volume_and_balance, R.id.opt_audio_effect, R.id.opt_volume_env, R.id.opt_background, R.id.opt_loop, R.id.opt_extend_to_end, R.id.opt_split_trim};
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_audio_effect /* 2131820632 */:
                return isAudioModulationApplied();
            case R.id.opt_background /* 2131820636 */:
            case R.id.opt_loop /* 2131820660 */:
            case R.id.opt_split_trim /* 2131820672 */:
            case R.id.opt_voicerec_rerec /* 2131820689 */:
            case R.id.opt_voicerec_review /* 2131820690 */:
                return false;
            case R.id.opt_volume /* 2131820691 */:
                return getClipVolume() != 100 || getMuteAudio();
            case R.id.opt_volume_env /* 2131820693 */:
                return isVolumeEnvelopeApplied();
            default:
                return super.isOptionApplied(i);
        }
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Class<? extends kp> getOptionMenuClass() {
        return com.nexstreaming.kinemaster.ui.projectedit.e.class;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        return getTitle(context);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        int duration = getDuration();
        return duration != getOriginalDuration() ? EditorGlobal.b(duration) + " " + context.getResources().getString(R.string.video_trimmed) : EditorGlobal.b(duration);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_loop) {
            setLoop(z);
            return null;
        }
        if (i == R.id.opt_background) {
            setBGM(z);
            return null;
        }
        if (i == R.id.opt_extend_to_end) {
            setExtendToEnd(z);
            return null;
        }
        super.setSwitchOption(i, z, context);
        return null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Set<ProjectDependency> set) {
        String musicThemeId;
        if (isThemeMusic() && (musicThemeId = getMusicThemeId()) != null && musicThemeId.length() > 0) {
            set.add(ProjectDependency.a(musicThemeId));
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAudioTrackUsage() {
        return (getMuteAudio() || getClipVolume() <= 0) ? 0 : 1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoTrackUsage() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecMemoryUsage() {
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.AudioClip.Builder builder = new KMProto.KMProject.AudioClip.Builder();
        if (this.m_mediaTitle != null) {
            builder.media_title(this.m_mediaTitle);
        }
        if (this.m_originalMediaPath != null) {
            builder.original_media_path(this.m_originalMediaPath);
        }
        if (this.m_mediaPath != null) {
            builder.media_path(this.m_mediaPath);
        }
        builder.extra_relative_start_time(Integer.valueOf(this.m_extraRelativeStartTime)).relative_start_time(Integer.valueOf(this.m_relativeStartTime)).relative_end_time(Integer.valueOf(this.m_relativeEndTime)).saved_relative_start_time(Integer.valueOf(this.m_savedRelativeStartTime)).saved_relative_end_time(Integer.valueOf(this.m_savedRelativeEndTime)).saved_loop_duration(Integer.valueOf(this.m_savedLoopDuration)).engine_clip_id(Integer.valueOf(this.m_engineClipID)).duration(Integer.valueOf(this.m_duration)).trim_time_start(Integer.valueOf(this.m_trimTimeStart)).trim_time_end(Integer.valueOf(this.m_trimTimeEnd)).saved_trim_time_start(Integer.valueOf(this.m_savedTrimTimeStart)).saved_trim_time_end(Integer.valueOf(this.m_savedTrimTimeEnd)).extend_to_end(Boolean.valueOf(this.m_extendToEnd)).clip_volume(Integer.valueOf(this.m_clipVolume)).mute_audio(Boolean.valueOf(this.m_muteAudio)).pinned(Boolean.valueOf(this.m_pinned)).loop(Boolean.valueOf(this.m_loop)).is_voice_recording(Boolean.valueOf(this.m_isVoiceRecording)).is_pending_voice_recording(Boolean.valueOf(this.m_isPendingVoiceRecording)).is_extract_audio(Boolean.valueOf(this.m_isExtractAudio)).is_bg_music(Boolean.valueOf(this.m_isUserChoiceBGMusic)).volume_envelope_time(this.m_volumeEnvelopeTime).volume_envelope_level(this.m_volumeEnvelopeLevel).voice_changer(Integer.valueOf(this.m_voiceChanger)).clip_width(Float.valueOf(this.m_clipWidth)).pan_left(Integer.valueOf(getAudioLeftVolume())).pan_right(Integer.valueOf(getAudioRightVolume())).compressor(Integer.valueOf(this.m_audioCompressor)).pitch_factor(Integer.valueOf(this.m_pitchFactor));
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.AUDIO_CLIP).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).audio_clip(builder.build()).build();
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
        nexAudioClipItem.m_savedLoopDuration = audioClip.saved_loop_duration == null ? 0 : audioClip.saved_loop_duration.intValue();
        nexAudioClipItem.m_engineClipID = audioClip.engine_clip_id.intValue();
        nexAudioClipItem.m_duration = audioClip.duration.intValue();
        nexAudioClipItem.m_trimTimeStart = audioClip.trim_time_start.intValue();
        nexAudioClipItem.m_extendToEnd = audioClip.extend_to_end == null ? false : audioClip.extend_to_end.booleanValue();
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
        nexAudioClipItem.m_voiceChanger = audioClip.voice_changer == null ? 0 : audioClip.voice_changer.intValue();
        nexAudioClipItem.m_pinned = audioClip.pinned == null ? false : audioClip.pinned.booleanValue();
        if (audioClip.video_clip_item_uuid_msb != null && audioClip.video_clip_item_uuid_lsb != null) {
            nexAudioClipItem.f = new UUID(audioClip.video_clip_item_uuid_msb.longValue(), audioClip.video_clip_item_uuid_lsb.longValue());
        }
        nexAudioClipItem.m_isUserChoiceBGMusic = audioClip.is_bg_music.booleanValue();
        nexAudioClipItem.m_audioPanLeft = audioClip.pan_left == null ? nexAudioClipItem.getAudioLeftVolume() : audioClip.pan_left.intValue();
        nexAudioClipItem.m_audioPanRight = audioClip.pan_right == null ? nexAudioClipItem.getAudioRightVolume() : audioClip.pan_right.intValue();
        nexAudioClipItem.m_audioCompressor = audioClip.compressor == null ? 0 : audioClip.compressor.intValue();
        nexAudioClipItem.m_pitchFactor = audioClip.pitch_factor != null ? audioClip.pitch_factor.intValue() : 0;
        nexAudioClipItem.a();
        nexAudioClipItem.m_duration = nexAudioClipItem.i.y();
        nexAudioClipItem.b();
        nexAudioClipItem.c();
        return nexAudioClipItem;
    }
}
