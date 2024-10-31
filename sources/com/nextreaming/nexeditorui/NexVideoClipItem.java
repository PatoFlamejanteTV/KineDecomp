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
import android.preference.PreferenceManager;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.kmpackage.ClipEffectAutoSelectContext;
import com.nexstreaming.kinemaster.kmpackage.EffectLibrary;
import com.nexstreaming.kinemaster.kmpackage.Theme;
import com.nexstreaming.kinemaster.kmpackage.ThemeEffectType;
import com.nexstreaming.kinemaster.kmpackage.UserFieldType;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.mediastore.v2.MSID;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStore;
import com.nexstreaming.kinemaster.mediastore.v2.MediaStoreItem;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.projectedit.nb;
import com.nexstreaming.kinemaster.wire.KMProto;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexvideoeditor.NexImageLoader;
import com.nextreaming.nexvideoeditor.NexRectangle;
import com.nextreaming.nexvideoeditor.NexVisualClip;
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class NexVideoClipItem extends NexPrimaryTimelineItem implements nb, NexTimelineItem.b, NexTimelineItem.d, NexTimelineItem.e, NexTimelineItem.f, NexTimelineItem.g, NexTimelineItem.j, NexTimelineItem.o, NexTimelineItem.q, NexTimelineItem.s {
    public static final int ABSTRACT_DIMENSION = 100000;

    /* renamed from: a */
    private static Rect f4496a = new Rect();
    private static RectF b = new RectF();
    private static String[] c = null;
    private static final long serialVersionUID = 2;
    private transient Boolean d;
    private transient boolean i;
    private transient boolean l;
    private int m_Brightness;
    private int m_Contrast;
    private int m_Saturation;
    private int m_TintColor;
    private boolean m_abstractCrop;
    private ThemeEffectType m_autoThemeEffect;
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
    private MSID m_mediaMSID;
    private int m_playbackSpeed;
    private float[] m_startMatrix;
    private String m_titleEffectID;
    private NexTransitionItem m_transition;
    private boolean m_vignette;
    private ArrayList<Integer> m_volumeEnvelopeLevel;
    private ArrayList<Integer> m_volumeEnvelopeTime;
    private transient UUID n;
    private transient int q;
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
    private int m_preTrimmedDuration = Integer.MAX_VALUE;
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
    private transient WeakReference<Bitmap> e = null;
    private transient boolean f = false;
    private boolean m_muteAudio = false;
    private boolean m_muteMusic = false;
    private boolean m_hasAudio = false;
    private boolean m_hasVideo = false;
    private String m_thumbPath = null;
    private String m_mediaPath = null;
    private boolean m_isReverse = false;
    private transient MediaInfo g = null;
    private transient com.nexstreaming.kinemaster.mediainfo.aq h = null;
    private transient boolean j = false;
    private transient int[] k = null;
    private transient boolean m = false;
    private int m_effectStartTime = 0;
    private int m_effectEndTime = Integer.MAX_VALUE;
    private transient int o = 0;
    private transient int p = 0;
    private float m_clipWidth = 0.0f;
    private int m_voiceChanger = 0;
    private int m_audioCompressor = 0;
    private int m_pitchFactor = 0;
    private int m_audioPanLeft = -111;
    private int m_audioPanRight = -111;

    /* loaded from: classes.dex */
    public enum DragType {
        START,
        END,
        FXSTART,
        FXEND
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

    private NexVideoClipItem(NexTransitionItem nexTransitionItem) {
        this.m_abstractCrop = false;
        this.m_transition = null;
        this.m_transition = nexTransitionItem;
        this.m_abstractCrop = true;
    }

    public static NexVideoClipItem newInstance(int i, MSID msid) {
        NexVideoClipItem nexVideoClipItem = new NexVideoClipItem();
        nexVideoClipItem.m_mediaMSID = msid;
        nexVideoClipItem.m_engineClipID = i;
        return nexVideoClipItem;
    }

    public static NexVideoClipItem newInstance(int i, MediaStoreItem mediaStoreItem, int i2) {
        NexVideoClipItem nexVideoClipItem = new NexVideoClipItem();
        nexVideoClipItem.m_mediaMSID = mediaStoreItem.c();
        nexVideoClipItem.m_engineClipID = i;
        MediaInfo mediaInfo = null;
        if (!mediaStoreItem.n()) {
            nexVideoClipItem.m_mediaPath = mediaStoreItem.h();
            mediaInfo = MediaInfo.a(nexVideoClipItem.m_mediaPath);
        }
        try {
            nexVideoClipItem.m_width = mediaStoreItem.j();
            nexVideoClipItem.m_height = mediaStoreItem.k();
        } catch (MediaStore.UnavailableDataException e) {
            nexVideoClipItem.m_width = 0;
            nexVideoClipItem.m_height = 0;
        }
        switch (mediaStoreItem.b()) {
            case IMAGE:
                nexVideoClipItem.m_isImage = true;
                nexVideoClipItem.m_duration = i2;
                nexVideoClipItem.m_hasAudio = false;
                nexVideoClipItem.m_hasVideo = false;
                break;
            case VIDEO:
            case FILE:
                nexVideoClipItem.m_isImage = false;
                if (mediaInfo != null) {
                    nexVideoClipItem.m_duration = mediaInfo.y();
                    nexVideoClipItem.m_hasAudio = mediaInfo.r();
                    nexVideoClipItem.q = mediaInfo.B();
                } else {
                    try {
                        nexVideoClipItem.m_duration = mediaStoreItem.m();
                    } catch (MediaStore.UnavailableDataException e2) {
                        nexVideoClipItem.m_duration = 5000;
                    }
                    try {
                        nexVideoClipItem.m_hasAudio = mediaStoreItem.t();
                    } catch (MediaStore.UnavailableDataException e3) {
                        nexVideoClipItem.m_hasAudio = false;
                    }
                    try {
                        nexVideoClipItem.q = mediaStoreItem.s();
                    } catch (MediaStore.UnavailableDataException e4) {
                        nexVideoClipItem.q = 0;
                    }
                }
                nexVideoClipItem.m_hasVideo = true;
                break;
            default:
                throw new IllegalStateException("Unsupported type: " + String.valueOf(mediaStoreItem.b()));
        }
        nexVideoClipItem.randomizeStartEndPosition(false, CropMode.FIT);
        return nexVideoClipItem;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void onDuplicated(int i) {
        this.n = null;
        this.m_engineClipID = i;
        if (getTransition() != null) {
            getTransition().setUniqueId(null);
            getTransition().getUniqueId();
        }
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public NexTransitionItem getTransition() {
        if (this.m_transition == null && this.n != null) {
            NexTimeline timeline = getTimeline();
            if (timeline == null) {
                throw new RuntimeException("null timeline");
            }
            this.m_transition = (NexTransitionItem) timeline.findItemByUniqueId(this.n);
            if (this.m_transition == null) {
                throw new RuntimeException("cannot find transition");
            }
        } else if (this.m_transition != null && this.n == null) {
            this.n = this.m_transition.getUniqueId();
        } else if (this.m_transition == null) {
            this.m_transition = new NexTransitionItem();
        }
        return this.m_transition;
    }

    public NexTransitionItem getPrecedingTransition() {
        NexPrimaryTimelineItem primaryItem;
        if (getTimeline() == null) {
            return null;
        }
        int indexOfPrimaryItem = getTimeline().getIndexOfPrimaryItem(this);
        if (indexOfPrimaryItem <= 0 || (primaryItem = getTimeline().getPrimaryItem(indexOfPrimaryItem - 1)) == null || !(primaryItem instanceof NexTransitionItem)) {
            return null;
        }
        return (NexTransitionItem) primaryItem;
    }

    public NexVideoClipItem getPreviousClip() {
        NexPrimaryTimelineItem primaryItem;
        if (getTimeline() == null) {
            return null;
        }
        int indexOfPrimaryItem = getTimeline().getIndexOfPrimaryItem(this);
        if (indexOfPrimaryItem <= 1 || (primaryItem = getTimeline().getPrimaryItem(indexOfPrimaryItem - 2)) == null || !(primaryItem instanceof NexVideoClipItem)) {
            return null;
        }
        return (NexVideoClipItem) primaryItem;
    }

    public NexVideoClipItem getNextClip() {
        NexPrimaryTimelineItem primaryItem;
        if (getTimeline() == null) {
            return null;
        }
        int indexOfPrimaryItem = getTimeline().getIndexOfPrimaryItem(this);
        if (indexOfPrimaryItem + 2 >= getTimeline().getPrimaryItemCount() || (primaryItem = getTimeline().getPrimaryItem(indexOfPrimaryItem + 2)) == null || !(primaryItem instanceof NexVideoClipItem)) {
            return null;
        }
        return (NexVideoClipItem) primaryItem;
    }

    private void a(Rect rect, float f) {
        if (rect.width() / rect.height() < f) {
            int width = (int) (rect.width() / f);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = width + rect.top;
        } else {
            int height = (int) (rect.height() * f);
            rect.left = rect.centerX() - (height / 2);
            rect.right = height + rect.left;
        }
    }

    private void b(Rect rect, float f) {
        if (rect.width() / rect.height() < f) {
            int height = (int) (rect.height() * f);
            rect.left = rect.centerX() - (height / 2);
            rect.right = height + rect.left;
        } else {
            int width = (int) (rect.width() / f);
            rect.top = rect.centerY() - (width / 2);
            rect.bottom = width + rect.top;
        }
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
        if (this.m_volumeEnvelopeTime == null) {
            return -1;
        }
        return this.m_volumeEnvelopeTime.get(i).intValue();
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getVolumeEnvelopeTimeAdj(int i) {
        if (this.m_volumeEnvelopeTime == null) {
            return -1;
        }
        return ((this.m_volumeEnvelopeTime.get(i).intValue() - getTrimTimeStart()) * 100) / getPlaybackSpeed();
    }

    public int getVolumeEnvelopeTimeForDrawing(int i) {
        if (this.m_volumeEnvelopeTime == null) {
            return -1;
        }
        return (((this.m_volumeEnvelopeTime.get(i).intValue() - getTrimTimeStart()) * 100) / getPlaybackSpeed()) - getStartOverlap();
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
        return (((getRepresentedDuration() + getStartOverlap()) + getTrimTimeEnd()) + getTrimTimeStart()) - getDiffAVDuration();
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
            } else if (a2 != null && a2.I() == 1) {
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

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public void setMusicVolume(int i) {
        this.m_musicVolume = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.o
    public int getMusicVolume() {
        return this.m_musicVolume;
    }

    public void setMuteMusic(boolean z) {
        this.m_muteMusic = z;
    }

    public boolean getMuteMusic() {
        return this.m_muteMusic;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void trimToLeft(int i) {
        int absStartTime = i - getAbsStartTime();
        int trimTimeStart = (((getTrimTimeStart() * 100) / getPlaybackSpeed()) + absStartTime) - getStartOverlap();
        NexTimeline.c beginTimeChange = getTimeline().beginTimeChange();
        int duration = getDuration();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getStartPosition(rect);
        getEndPosition(rect2);
        int i2 = ((duration - absStartTime) * 100) / duration;
        rect2.left = calcPos(rect.left, rect2.left, i2);
        rect2.top = calcPos(rect.top, rect2.top, i2);
        rect2.right = calcPos(rect.right, rect2.right, i2);
        rect2.bottom = calcPos(rect.bottom, rect2.bottom, i2);
        if (isImage()) {
            setDuration(duration - absStartTime);
        } else {
            setTrimStart((trimTimeStart / 100) * getPlaybackSpeed());
        }
        checkEffectTime(getEffectStartTime(), getEffectEndTime(), 1);
        beginTimeChange.a();
        getTransition().ensureTransitionFits();
        getTimeline().requestCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.s
    public void trimToRight(int i) {
        int absEndTime = getAbsEndTime() - i;
        int trimTimeEnd = ((getTrimTimeEnd() * 100) / getPlaybackSpeed()) + absEndTime;
        int duration = getDuration();
        NexTimeline.c beginTimeChange = getTimeline().beginTimeChange();
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getStartPosition(rect);
        getEndPosition(rect2);
        int i2 = ((duration - absEndTime) * 100) / duration;
        rect2.left = calcPos(rect.left, rect2.left, i2);
        rect2.top = calcPos(rect.top, rect2.top, i2);
        rect2.right = calcPos(rect.right, rect2.right, i2);
        rect2.bottom = calcPos(rect.bottom, rect2.bottom, i2);
        if (isImage()) {
            setDuration(duration - absEndTime);
        } else {
            setTrimEnd((trimTimeEnd / 100) * getPlaybackSpeed());
        }
        checkEffectTime(getEffectStartTime(), getEffectEndTime(), 2);
        getTransition().ensureTransitionFits();
        if (getPrecedingTransition() != null) {
            getPrecedingTransition().ensureTransitionFits();
        }
        beginTimeChange.a();
        getTimeline().requestCalcTimes();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public void setEffect(com.nexstreaming.kinemaster.kmpackage.b bVar) {
        if (bVar == null) {
            setEffectID(null);
        } else {
            setEffectID(bVar.a());
        }
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

    public boolean isVignetteApplied() {
        return this.m_vignette;
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
            if (str.equalsIgnoreCase("none")) {
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
    }

    public void randomizeStartEndPosition(boolean z, CropMode cropMode) {
        int height;
        int width;
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        getStartPosition(rect);
        getEndPosition(rect2);
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            height = getHeight();
            width = getWidth();
        } else {
            height = getWidth();
            width = getHeight();
        }
        if (height >= 1 && width >= 1) {
            if (f()) {
                Rect rect3 = new Rect(2, 2, height - 2, width - 2);
                setStartPosition(rect3);
                setEndPosition(rect3);
                return;
            }
            if (cropMode == CropMode.FILL) {
                Rect rect4 = new Rect(0, 0, height, width);
                a(rect4, 1.7777778f);
                setStartPosition(rect4);
                setEndPosition(rect4);
                return;
            }
            if (cropMode == CropMode.FIT) {
                Rect rect5 = new Rect(0, 0, height, width);
                b(rect5, 1.7777778f);
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
                rect6.offset((int) ((height * Math.random()) / 3.0d), (int) ((width * Math.random()) / 3.0d));
            } else {
                int width2 = (height / 4) - rect6.width();
                if (width2 >= 2) {
                    rect6.left -= width2 / 2;
                    rect6.right = (width2 / 2) + rect6.right;
                }
                int height2 = (width / 4) - rect6.height();
                if (height2 >= 2) {
                    rect6.top -= height2 / 2;
                    rect6.bottom = (height2 / 2) + rect6.bottom;
                }
                b(rect6, 1.7777778f);
                if (!rect6.intersect(0, 0, height, width)) {
                    rect6.set(0, 0, (height * 2) / 3, (width * 2) / 3);
                    rect6.offset((int) ((height * Math.random()) / 3.0d), (int) ((width * Math.random()) / 3.0d));
                }
            }
            a(rect6, 1.7777778f);
            Rect rect7 = new Rect(0, 0, height, width);
            a(rect7, 1.7777778f);
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
    }

    public void getFaceBounds(Rect rect) {
        com.nexstreaming.kinemaster.ui.c.a a2 = com.nexstreaming.kinemaster.ui.c.a.a(this.m_mediaPath);
        if (a2 != null) {
            RectF rectF = new RectF();
            a2.a(rectF);
            float width = getWidth();
            float height = getHeight();
            rect.set((int) (rectF.left * width), (int) (rectF.top * height), (int) (width * rectF.right), (int) (rectF.bottom * height));
            return;
        }
        a();
        if (!this.m_faceBounds_set) {
            rect.setEmpty();
            return;
        }
        float width2 = getWidth();
        float height2 = getHeight();
        rect.set((int) (this.m_faceBounds_left * width2), (int) (this.m_faceBounds_top * height2), (int) (width2 * this.m_faceBounds_right), (int) (height2 * this.m_faceBounds_bottom));
    }

    private void a() {
        Bitmap b2;
        if (!this.m_faceBounds_set && (b2 = b()) != null) {
            FaceDetector.Face[] faceArr = new FaceDetector.Face[32];
            int findFaces = new FaceDetector(b2.getWidth(), b2.getHeight(), 32).findFaces(b2, faceArr);
            RectF rectF = new RectF();
            RectF rectF2 = new RectF();
            PointF pointF = new PointF();
            float width = getWidth();
            float height = getHeight();
            float f = width / 30.0f;
            float f2 = height / 30.0f;
            for (int i = 0; i < findFaces; i++) {
                if (faceArr[i].confidence() >= 0.4d) {
                    faceArr[i].getMidPoint(pointF);
                    float eyesDistance = faceArr[i].eyesDistance();
                    if (eyesDistance >= f && eyesDistance >= f2) {
                        rectF2.set((pointF.x - (eyesDistance / 2.0f)) / width, (pointF.y - (eyesDistance / 3.0f)) / height, (pointF.x + (eyesDistance / 2.0f)) / width, (((eyesDistance / 3.0f) * 2.0f) + pointF.y) / height);
                        rectF.union(rectF2);
                    }
                }
            }
            b2.recycle();
            if (!rectF.isEmpty()) {
                float width2 = 0.6f - rectF.width();
                float height2 = 0.6f - rectF.height();
                if (width2 > 0.0f) {
                    rectF.left -= width2 / 2.0f;
                    rectF.right = (width2 / 2.0f) + rectF.right;
                }
                if (height2 > 0.0f) {
                    rectF.top -= height2 / 2.0f;
                    rectF.bottom += height2 / 2.0f;
                }
            }
            this.m_faceBounds_set = true;
            this.m_faceBounds_left = Math.max(0.0f, rectF.left);
            this.m_faceBounds_top = Math.max(0.0f, rectF.top);
            this.m_faceBounds_right = Math.min(rectF.right, 1.0f);
            this.m_faceBounds_bottom = Math.min(rectF.bottom, 1.0f);
        }
    }

    private Bitmap b() {
        if (isPreset()) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(this.m_mediaPath, options);
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        if (options.outWidth < 1 || options.outHeight < 1) {
            return null;
        }
        int i = (options.outHeight * 720) / options.outWidth;
        options.inSampleSize = 1;
        while (true) {
            if (options.outHeight / options.inSampleSize <= i * 1.5d && options.outWidth / options.inSampleSize <= 720 * 1.5d) {
                break;
            }
            options.inSampleSize *= 2;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(this.m_mediaPath, options);
        if (decodeFile == null) {
            return null;
        }
        if (decodeFile.getConfig() == Bitmap.Config.RGB_565) {
            return decodeFile;
        }
        Bitmap createBitmap = Bitmap.createBitmap(decodeFile.getWidth(), decodeFile.getHeight(), Bitmap.Config.RGB_565);
        new Canvas(createBitmap).drawBitmap(decodeFile, 0.0f, 0.0f, (Paint) null);
        decodeFile.recycle();
        return createBitmap;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem.j
    public String getEffectID() {
        return this.m_titleEffectID;
    }

    public void setEffectID(String str) {
        if (this.m_autoThemeEffect != null) {
            throw new IllegalStateException();
        }
        this.m_titleEffectID = str;
        this.d = null;
    }

    @Deprecated
    public ThemeEffectType getClipEffectAutoType() {
        return this.m_autoThemeEffect;
    }

    @Deprecated
    public void setClipEffectAutoType(Theme theme, ThemeEffectType themeEffectType) {
        throw new IllegalStateException();
    }

    public String effectIdByContextForTheme(Theme theme) {
        return effectIdByContextForTheme(theme, null);
    }

    public void setReversePath(String str) {
        if (!f() && !isImage()) {
            this.m_mediaPath = str;
            this.m_mediaMSID = null;
            MediaInfo a2 = MediaInfo.a(str);
            if (a2 != null && a2.s()) {
                this.m_duration = a2.y();
                this.m_hasAudio = getHasAudio();
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void applyFinalPath(MSID msid, String str, CropMode cropMode, int i) {
        if (this.m_mediaMSID != null && this.m_mediaMSID.equals(msid)) {
            this.m_mediaPath = str;
            this.m_mediaMSID = null;
            this.f = f() || (this.m_mediaPath != null && new File(this.m_mediaPath).exists());
            if (this.j) {
                this.j = false;
            }
            MediaInfo a2 = MediaInfo.a(str);
            if (a2 != null) {
                this.q = a2.B();
                this.m_width = a2.w();
                this.m_height = a2.x();
                if (a2.s()) {
                    this.m_isImage = false;
                    this.m_duration = a2.y();
                    this.m_hasAudio = getHasAudio();
                    this.m_hasVideo = true;
                    this.m_rotation = a2.C();
                    randomizeStartEndPosition(false, CropMode.FIT);
                    return;
                }
                if (a2.t()) {
                    if (msid.getNamespace().equals(com.nexstreaming.kinemaster.mediastore.v2.providers.j.e())) {
                        this.m_isImage = true;
                        this.m_mediaMSID = null;
                        this.m_duration = i;
                        this.m_hasAudio = false;
                        this.m_hasVideo = false;
                        randomizeStartEndPosition(false, CropMode.FILL);
                        return;
                    }
                    if (a(str)) {
                        int i2 = this.m_width;
                        this.m_width = this.m_height;
                        this.m_height = i2;
                    }
                    this.m_isImage = true;
                    this.m_duration = i;
                    this.m_hasAudio = false;
                    this.m_hasVideo = true;
                    randomizeStartEndPosition(true, cropMode);
                    return;
                }
                throw new IllegalStateException("Item has no video or image data " + String.valueOf(str));
            }
        }
    }

    private static boolean a(String str) {
        int i;
        String lowerCase = str.toLowerCase(Locale.US);
        if (lowerCase.endsWith(".jpeg") || lowerCase.endsWith(".jpg")) {
            try {
                i = new ExifInterface(str).getAttributeInt("Orientation", 0);
            } catch (IOException e) {
                i = 0;
            }
        } else {
            i = 0;
        }
        return i == 6 || i == 8;
    }

    public String effectIdByContextForTheme(Theme theme, ThemeEffectType themeEffectType) {
        ClipEffectAutoSelectContext clipEffectAutoSelectContext = new ClipEffectAutoSelectContext();
        clipEffectAutoSelectContext.clipDuration = getDuration();
        if (isImage()) {
            clipEffectAutoSelectContext.getClass();
            clipEffectAutoSelectContext.clipType = 2;
        } else if (isPreset()) {
            clipEffectAutoSelectContext.getClass();
            clipEffectAutoSelectContext.clipType = 3;
        } else {
            clipEffectAutoSelectContext.getClass();
            clipEffectAutoSelectContext.clipType = 1;
        }
        clipEffectAutoSelectContext.clipHasText = hasDataInMainTextField();
        switch (getClipEffectAutoType()) {
            case ACCENT:
                clipEffectAutoSelectContext.getClass();
                clipEffectAutoSelectContext.clipEffectType = 4;
                break;
            case CLIP:
                clipEffectAutoSelectContext.getClass();
                clipEffectAutoSelectContext.clipEffectType = 0;
                break;
            case ENDING:
                clipEffectAutoSelectContext.getClass();
                clipEffectAutoSelectContext.clipEffectType = 3;
                break;
            case MIDDLE:
                clipEffectAutoSelectContext.getClass();
                clipEffectAutoSelectContext.clipEffectType = 2;
                break;
            case OPENING:
                clipEffectAutoSelectContext.getClass();
                clipEffectAutoSelectContext.clipEffectType = 1;
                break;
            case TRANSITION:
                clipEffectAutoSelectContext.getClass();
                clipEffectAutoSelectContext.clipEffectType = 0;
                break;
        }
        clipEffectAutoSelectContext.endTime = getAbsEndTime() / 1000.0d;
        clipEffectAutoSelectContext.index = getTimeline().getIndexOfPrimaryItem(this) / 2;
        clipEffectAutoSelectContext.clipIndex = clipEffectAutoSelectContext.index;
        clipEffectAutoSelectContext.numberOfClips = (getTimeline().getPrimaryItemCount() + 1) / 2;
        clipEffectAutoSelectContext.lastClip = clipEffectAutoSelectContext.numberOfClips;
        clipEffectAutoSelectContext.projectDuration = getTimeline().getTotalTime();
        clipEffectAutoSelectContext.startTime = getAbsStartTime() / 1000.0d;
        clipEffectAutoSelectContext.versionCode = getTimeline().getAppVersionCode();
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        clipEffectAutoSelectContext.multisample = deviceProfile.getGLMultisample();
        clipEffectAutoSelectContext.depthBits = deviceProfile.getGLDepthBufferBits();
        String a2 = theme.a(clipEffectAutoSelectContext);
        if (a2 == null) {
            return theme.a(themeEffectType);
        }
        return a2;
    }

    public void applyAutoEffect(Theme theme) {
        if (this.m_autoThemeEffect != null) {
            this.m_titleEffectID = effectIdByContextForTheme(theme, this.m_autoThemeEffect);
        }
    }

    public boolean hasDataInMainTextField() {
        String str = getEffectOptions().get("text:f_text");
        return str == null || str.trim().length() < 1;
    }

    public boolean hasText() {
        boolean z;
        if (this.d != null) {
            return this.d.booleanValue();
        }
        com.nexstreaming.kinemaster.kmpackage.b c2 = EditorGlobal.a().q().c(getEffectID());
        if (c2 == null) {
            return false;
        }
        Iterator<com.nexstreaming.kinemaster.kmpackage.au> it = c2.e().iterator();
        while (true) {
            if (!it.hasNext()) {
                z = false;
                break;
            }
            if (it.next().f() == UserFieldType.text) {
                z = true;
                break;
            }
        }
        this.d = Boolean.valueOf(z);
        return this.d.booleanValue();
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getPixelWidth(float f, float f2) {
        if (!isClipReady()) {
            int representedDuration = (int) ((getRepresentedDuration() * f) / 1000.0f);
            if (representedDuration <= 80.0f * f2 || representedDuration >= 200.0f * f2) {
                return (int) (120.0f * f2);
            }
            return representedDuration;
        }
        int representedDuration2 = (int) ((getRepresentedDuration() * f) / 1000.0f);
        if (representedDuration2 < 20.0f * f2) {
            return (int) (20.0f * f2);
        }
        return representedDuration2;
    }

    private void a(NexTimelineItem.p pVar) {
        if (this.g == null && !isImage() && !f()) {
            this.g = this.m_mediaPath == null ? null : MediaInfo.a(new File(this.m_mediaPath));
        }
        if (this.g != null && this.h == null && !this.i && !this.j) {
            this.i = true;
            this.g.b().onResultAvailable(new dj(this, pVar)).onFailure((Task.OnFailListener) new db(this));
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getColorOption(int i) {
        return i == R.id.opt_color ? getSolidColor() : super.getColorOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setColorOption(int i, int i2) {
        if (i == R.id.opt_color && f()) {
            setSolidColor(i2);
        } else {
            super.setColorOption(i, i2);
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveTitle(Context context) {
        if (f()) {
            return context.getString(R.string.solid_color_clip);
        }
        return this.m_mediaPath == null ? "" : new File(this.m_mediaPath).getName();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public String getDescriptiveSubtitle(Context context) {
        int originalWidth = getOriginalWidth();
        int originalHeight = getOriginalHeight();
        if (f()) {
            int solidColor = getSolidColor();
            return context.getResources().getString(R.string.solid_clip_rgb, Integer.valueOf(Color.red(solidColor)), Integer.valueOf(Color.green(solidColor)), Integer.valueOf(Color.blue(solidColor)));
        }
        if (isImage()) {
            return originalWidth + "×" + originalHeight + " (" + EditorGlobal.b(getDuration()) + ")";
        }
        int trimTimeStart = getTrimTimeStart();
        int trimTimeEnd = getTrimTimeEnd();
        if (trimTimeStart != 0 || trimTimeEnd != 0) {
            return originalWidth + "×" + originalHeight + "  " + EditorGlobal.b((getDuration() - trimTimeStart) - trimTimeEnd) + " " + context.getResources().getString(R.string.video_trimmed);
        }
        return originalWidth + "×" + originalHeight + "  " + EditorGlobal.b(getDuration());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isOptionApplied(int i) {
        switch (i) {
            case R.id.opt_audio_effect /* 2131820632 */:
                return isAudioModulationApplied();
            case R.id.opt_clip_effect /* 2131820644 */:
                return getEffectID() != null && getEffectID().length() > 0;
            case R.id.opt_color /* 2131820645 */:
                return false;
            case R.id.opt_color_adj /* 2131820646 */:
                return (getBrightness() == 0 && getContrast() == 0 && getSaturation() == 0) ? false : true;
            case R.id.opt_color_tint /* 2131820648 */:
                return (getColorEffect() == null || getColorEffect().equals(ColorEffect.NONE)) ? false : true;
            case R.id.opt_img_crop /* 2131820656 */:
                return false;
            case R.id.opt_rotate /* 2131820667 */:
                return (getRotation() == 0 || getFlipH() || getFlipV()) ? false : true;
            case R.id.opt_speed_control /* 2131820670 */:
                return getPlaybackSpeed() != 100;
            case R.id.opt_split_trim /* 2131820672 */:
                return isVideo() && (getTrimTimeStart() > 0 || getTrimTimeEnd() > 0);
            case R.id.opt_vid_crop /* 2131820687 */:
                return false;
            case R.id.opt_volume /* 2131820691 */:
                return (getClipVolume() == 100 && !getMuteAudio() && getMusicVolume() == 100) ? false : true;
            case R.id.opt_volume_env /* 2131820693 */:
                return c();
            default:
                return super.isOptionApplied(i);
        }
    }

    private boolean c() {
        for (int i = 0; i < getVolumeEnvelopeLength(); i++) {
            if (getVolumeEnvelopeLevel(i) != 100) {
                return true;
            }
        }
        return false;
    }

    public boolean isVideo() {
        return (isImage() || f()) ? false : true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int[] getOptionMenuItems() {
        if (f()) {
            return new int[]{R.id.opt_color, R.id.opt_split_trim, R.id.opt_clip_effect, R.id.opt_color_tint, R.id.opt_color_adj, R.id.opt_vignette};
        }
        if (isImage()) {
            return new int[]{R.id.opt_split_trim, R.id.opt_img_crop, R.id.opt_rotate, R.id.opt_clip_effect, R.id.opt_color_tint, R.id.opt_color_adj, R.id.opt_vignette};
        }
        return new int[]{R.id.opt_split_trim, R.id.opt_vid_crop, R.id.opt_volume_and_balance, R.id.opt_clip_effect, R.id.opt_speed_control, R.id.opt_rotate, R.id.opt_color_tint, R.id.opt_color_adj, R.id.opt_volume_env, R.id.opt_audio_effect, R.id.opt_vignette};
    }

    public void setReverseState(boolean z) {
        this.m_isReverse = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onDraw(com.nexstreaming.kinemaster.ui.projectedit.ay ayVar) {
        Drawable drawable;
        int i;
        Drawable drawable2;
        boolean f = ayVar.f();
        RectF d = ayVar.d();
        TextPaint e = ayVar.e();
        Canvas b2 = ayVar.b();
        RectF c2 = ayVar.c();
        float j = ayVar.j();
        a(ayVar.a());
        Drawable drawable3 = ayVar.getResources().getDrawable(f ? R.drawable.timeline_item_border_sel : R.drawable.timeline_item_border_nor);
        drawable3.getPadding(f4496a);
        if (this.g != null && this.k == null && !this.l && !this.m) {
            this.l = true;
            this.g.g().onResultAvailable(new dl(this)).onFailure((Task.OnFailListener) new dk(this));
        }
        e.reset();
        if (ayVar.g()) {
            d.set(c2);
            d.inset((int) (2.0f * j), (int) (2.0f * j));
            d.offset(-((int) (2.0f * j)), -((int) (2.0f * j)));
            e.setColor(-1157627904);
            e.setStyle(Paint.Style.STROKE);
            e.setStrokeWidth(0.0f);
            b2.drawRect(d, e);
            return;
        }
        this.m_clipWidth = c2.width();
        e.setStyle(Paint.Style.FILL);
        d.set(c2);
        d.left += f4496a.left;
        d.top += f4496a.top;
        d.right -= f4496a.right;
        d.bottom -= f4496a.bottom;
        boolean isLogoClip = isLogoClip();
        if (!this.f) {
            RectF rectF = b;
            float height = d.height();
            Drawable drawable4 = null;
            if (0 == 0) {
                drawable4 = ayVar.getResources().getDrawable(R.drawable.n2_missingfile_icon_small);
            }
            float intrinsicHeight = (int) ((height / drawable4.getIntrinsicHeight()) * drawable4.getIntrinsicWidth());
            rectF.top = d.top;
            rectF.bottom = d.bottom;
            for (float f2 = d.left; f2 < d.right; f2 += intrinsicHeight) {
                rectF.left = f2;
                rectF.right = f2 + intrinsicHeight;
                if (!b2.quickReject(rectF, Canvas.EdgeType.AA)) {
                    drawable4.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
                    drawable4.draw(b2);
                }
            }
            if (f) {
                e.setColor(-2130725888);
                e.setStyle(Paint.Style.STROKE);
                e.setStrokeWidth(2.0f * j);
                b2.drawRect(d, e);
                return;
            }
            return;
        }
        if (this.g != null && this.h != null) {
            RectF rectF2 = b;
            float height2 = d.height();
            float a2 = this.h.a(this.m_rotation, height2);
            int firstRepresentedTime = getFirstRepresentedTime();
            int representedDuration = getRepresentedDuration();
            Drawable drawable5 = null;
            if (((int) a2) > 5) {
                rectF2.top = d.top;
                rectF2.bottom = d.bottom;
                if (representedDuration >= 1) {
                    int width = (int) ((firstRepresentedTime * d.width()) / representedDuration);
                    if (width < 0) {
                        width = 0;
                    }
                    float f3 = d.left - width;
                    Drawable drawable6 = null;
                    for (float f4 = f3; f4 < d.right; f4 += a2) {
                        rectF2.left = f4;
                        rectF2.right = f4 + a2;
                        if (!b2.quickReject(rectF2, Canvas.EdgeType.AA)) {
                            Bitmap a3 = this.h.a(this.m_rotation, ((int) (((f4 - d.left) / (d.right - d.left)) * getRepresentedDurationWithoutSpeedControl())) + firstRepresentedTime, this.m_fliph, this.m_flipv);
                            if (a3 != null) {
                                b2.drawBitmap(a3, (Rect) null, rectF2, e);
                            } else {
                                if (drawable6 == null) {
                                    drawable6 = ayVar.getResources().getDrawable(R.drawable.n2_loading_image_1_img);
                                }
                                drawable6.setBounds((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                                drawable6.draw(b2);
                            }
                        }
                    }
                }
            } else {
                if (0 == 0) {
                    drawable5 = ayVar.getResources().getDrawable(R.drawable.n2_loading_image_1_img);
                }
                float intrinsicHeight2 = (int) ((height2 / drawable5.getIntrinsicHeight()) * drawable5.getIntrinsicWidth());
                rectF2.top = d.top;
                rectF2.bottom = d.bottom;
                for (float f5 = d.left; f5 < d.right; f5 += intrinsicHeight2) {
                    rectF2.left = f5;
                    rectF2.right = f5 + intrinsicHeight2;
                    if (!b2.quickReject(rectF2, Canvas.EdgeType.AA)) {
                        drawable5.setBounds((int) rectF2.left, (int) rectF2.top, (int) rectF2.right, (int) rectF2.bottom);
                        drawable5.draw(b2);
                    }
                }
            }
        } else if (f()) {
            e.setColor((int) Long.parseLong(this.m_mediaPath.substring(7, 15), 16));
            b2.drawRect(d, e);
            if (isLogoClip) {
            }
        } else {
            Bitmap b3 = b(ayVar);
            if (b3 != null && b3.getWidth() > 0) {
                Bitmap a4 = a(b3);
                RectF rectF3 = b;
                d.height();
                float width2 = a4.getWidth();
                rectF3.top = d.top;
                rectF3.bottom = d.bottom;
                for (float f6 = d.left; f6 < d.right; f6 += width2) {
                    rectF3.left = f6;
                    rectF3.right = f6 + width2;
                    if (!b2.quickReject(rectF3, Canvas.EdgeType.AA)) {
                        b2.drawBitmap(a4, (Rect) null, rectF3, e);
                    }
                }
            }
        }
        if (!isLogoClip) {
            if (f()) {
                i = R.drawable.n3_timeline_clip_solid;
            } else if (isImage()) {
                i = R.drawable.n3_timeline_clip_image;
            } else if (this.m_isReverse) {
                i = R.drawable.n3_timeline_clip_reverse;
            } else {
                i = R.drawable.n3_timeline_clip_video;
            }
            Drawable drawable7 = ayVar.getResources().getDrawable(i);
            int intrinsicWidth = drawable7.getIntrinsicWidth();
            int intrinsicHeight3 = drawable7.getIntrinsicHeight();
            int i2 = (int) (2.5d * j);
            drawable7.setBounds(((int) d.left) + i2, ((int) d.top) + i2, (int) (d.left + i2 + intrinsicWidth), ((int) d.top) + i2 + intrinsicHeight3);
            drawable7.draw(b2);
            if (!isImage() && !f()) {
                b2.save();
                String str = " " + (getPlaybackSpeed() / 100.0f) + "x";
                e.setShadowLayer(3.0f, 0.0f, 0.0f, -16777216);
                e.setColor(-1);
                e.setTextSize(10.0f * j);
                e.setTypeface(Typeface.SANS_SERIF);
                e.getTextBounds(str, 0, str.length() - 1, new Rect());
                b2.clipRect(d.left, d.top, 1280.0f, d.bottom);
                b2.drawText(str, d.left + (i2 * 8) + ((drawable7.getIntrinsicWidth() / 2) - (r16.width() / 2)), ((drawable7.getIntrinsicHeight() / 2) - (r16.height() / 2)) + d.top + (i2 * 3.5f), e);
                b2.restore();
            }
            if (getEffectID() != null) {
                if (hasText()) {
                    drawable2 = ayVar.getResources().getDrawable(R.drawable.n3_timeline_clip_effect);
                } else {
                    drawable2 = ayVar.getResources().getDrawable(R.drawable.n3_timeline_clip_effect);
                }
                if (!isImage() && !f() && getHasAudio() && getMuteAudio()) {
                    drawable2.setBounds(((int) d.left) + (i2 * 2) + intrinsicWidth, ((int) d.top) + (i2 * 2) + intrinsicHeight3, ((int) d.left) + (i2 * 2) + (intrinsicWidth * 2), ((int) d.top) + (i2 * 2) + (intrinsicHeight3 * 2));
                } else {
                    drawable2.setBounds(((int) d.left) + i2, ((int) d.top) + (i2 * 2) + intrinsicHeight3, ((int) d.left) + i2 + intrinsicWidth, ((int) d.top) + (i2 * 2) + (intrinsicHeight3 * 2));
                }
                drawable2.draw(b2);
            }
            if (!isImage() && !f() && getHasAudio() && getMuteAudio()) {
                Drawable drawable8 = ayVar.getResources().getDrawable(R.drawable.n3_timeline_clip_muteaudio);
                drawable8.setBounds(((int) d.left) + i2, ((int) d.top) + (i2 * 2) + intrinsicHeight3, intrinsicWidth + ((int) d.left) + i2, (intrinsicHeight3 * 2) + (i2 * 2) + ((int) d.top));
                drawable8.draw(b2);
            }
        }
        drawable3.setBounds((int) c2.left, (int) c2.top, (int) c2.right, (int) c2.bottom);
        drawable3.draw(b2);
        if (f) {
            e.setColor(-19456);
            e.setStyle(Paint.Style.STROKE);
            e.setStrokeWidth(2.0f * j);
            if (ayVar.l() == R.id.editmode_trim) {
                b2.save();
                int a5 = ayVar.a(8.0f);
                b2.clipRect(c2.left - a5, c2.top, c2.right + a5, c2.bottom, Region.Op.REPLACE);
                if (isImage()) {
                    drawable = ayVar.getResources().getDrawable(R.drawable.grip_yellow_right);
                    drawable.setBounds(((int) c2.left) - a5, (int) c2.top, ((int) c2.right) + a5, (int) c2.bottom);
                } else {
                    drawable = ayVar.getResources().getDrawable(R.drawable.grip_yellow);
                    drawable.setBounds(((int) c2.left) - a5, (int) c2.top, ((int) c2.right) + a5, (int) c2.bottom);
                }
                drawable.draw(b2);
                b2.restore();
            } else if (ayVar.l() == R.id.editmode_fxtime) {
                a a6 = a(d);
                int a7 = ayVar.a(2.0f);
                d.left = a6.c + a7;
                d.right = a6.d - a7;
                d.top += ayVar.a(1.0f);
                d.bottom -= ayVar.a(1.0f);
                e.setStyle(Paint.Style.FILL);
                e.setColor(2147464192);
                b2.drawRect(d, e);
                d.left = a6.c - a7;
                d.right = a6.d + a7;
                d.top -= ayVar.a(1.0f);
                d.bottom += ayVar.a(1.0f);
                b2.save();
                Drawable drawable9 = ayVar.getResources().getDrawable(R.drawable.grip_yellow_for_fx);
                b2.clipRect(d.left, d.top, d.right, d.bottom, Region.Op.REPLACE);
                drawable9.setBounds(((int) d.left) + a7, (int) d.top, ((int) d.right) - a7, (int) d.bottom);
                drawable9.draw(b2);
                b2.restore();
            } else if (ayVar.l() == R.id.editmode_volume_adjust) {
                int size = this.m_volumeEnvelopeTime.size();
                new Path();
                Drawable drawable10 = ayVar.getResources().getDrawable(R.drawable.vol_env_keyframe_icon);
                PointF[] pointFArr = new PointF[size];
                int intrinsicWidth2 = drawable10.getIntrinsicWidth() / 2;
                int intrinsicHeight4 = drawable10.getIntrinsicHeight() / 2;
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    if (i4 == 0) {
                        pointFArr[i3] = new PointF();
                        pointFArr[i3].x = (getVolumeEnvelopeTimeForDrawing(i4) / getRepresentedDuration()) * d.right;
                        pointFArr[i3].y = d.bottom - ((this.m_volumeEnvelopeLevel.get(i4).intValue() / 200.0f) * d.bottom);
                    } else {
                        pointFArr[i3] = new PointF();
                        pointFArr[i3].x = (getVolumeEnvelopeTimeForDrawing(i4) / getRepresentedDuration()) * d.right;
                        pointFArr[i3].y = d.bottom - ((this.m_volumeEnvelopeLevel.get(i4).intValue() / 200.0f) * d.bottom);
                    }
                    i4++;
                    i3++;
                }
                b2.clipRect(d);
                e.reset();
                e.setAntiAlias(true);
                e.setStrokeWidth(5.0f);
                e.setStyle(Paint.Style.STROKE);
                e.setColor(-1);
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= pointFArr.length - 1) {
                        break;
                    }
                    b2.drawLine(pointFArr[i6].x, pointFArr[i6].y, pointFArr[i6 + 1].x, pointFArr[i6 + 1].y, e);
                    i5 = i6 + 1;
                }
                for (int i7 = 0; i7 < pointFArr.length && pointFArr[i7] != null; i7++) {
                    int volumeEnvelopeTimeAdj = getVolumeEnvelopeTimeAdj(i7);
                    int representedDurationWithoutOverlap = ((getRepresentedDurationWithoutOverlap() + this.m_trimTimeStart) * 100) / getPlaybackSpeed();
                    if (this.m_startOverlap + ((this.m_trimTimeStart * 100) / getPlaybackSpeed()) <= ((this.m_trimTimeStart * 100) / getPlaybackSpeed()) + volumeEnvelopeTimeAdj && representedDurationWithoutOverlap - this.m_endOverlap >= volumeEnvelopeTimeAdj + ((this.m_trimTimeStart * 100) / getPlaybackSpeed())) {
                        drawable10.setBounds(((int) pointFArr[i7].x) - intrinsicWidth2, ((int) pointFArr[i7].y) - intrinsicHeight4, ((int) pointFArr[i7].x) + intrinsicWidth2, ((int) pointFArr[i7].y) + intrinsicHeight4);
                        drawable10.draw(b2);
                    }
                }
            }
        }
        if (this.g != null && this.h != null) {
            int firstRepresentedTime2 = getFirstRepresentedTime();
            int representedDuration2 = getRepresentedDuration();
            int representedDurationWithoutSpeedControl = getRepresentedDurationWithoutSpeedControl();
            int startOverlap = getStartOverlap() + ((getTrimTimeStart() * 100) / getPlaybackSpeed());
            if (ayVar.l() == R.id.editmode_trim && f && !this.m) {
                Drawable drawable11 = ayVar.getResources().getDrawable(R.drawable.iframe_mark);
                int intrinsicWidth3 = drawable11.getIntrinsicWidth();
                int intrinsicHeight5 = drawable11.getIntrinsicHeight();
                int a8 = ayVar.a(2.5f);
                int[] iArr = this.k;
                if (iArr == null) {
                    iArr = this.g.f();
                }
                for (int i8 = 0; iArr != null && i8 < iArr.length; i8++) {
                    int i9 = iArr[i8];
                    if (i9 >= firstRepresentedTime2 && i9 <= firstRepresentedTime2 + representedDurationWithoutSpeedControl) {
                        int playbackSpeed = (int) (((((i9 * 100) / getPlaybackSpeed()) - startOverlap) * c2.width()) / representedDuration2);
                        drawable11.setBounds(playbackSpeed - (intrinsicWidth3 / 2), a8, playbackSpeed + (intrinsicWidth3 / 2), a8 + intrinsicHeight5);
                        drawable11.draw(b2);
                    }
                }
            }
        }
    }

    private void a(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f, NexTimelineItem.h hVar, boolean z3, float f2, int i, int i2, NexTimelineItem.p pVar) {
        throw new IllegalStateException();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void drawInCanvas(Context context, Canvas canvas, RectF rectF, RectF rectF2, Paint paint, boolean z, boolean z2, float f, NexTimelineItem.h hVar, boolean z3, float f2, int i, int i2, List<ef> list, NexTimelineItem.p pVar) {
        a(context, canvas, rectF, rectF2, paint, z, z2, f, hVar, z3, f2, i, i2, pVar);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDuration() {
        return (((((this.m_duration - this.m_trimTimeStart) - this.m_trimTimeEnd) * 100) / getPlaybackSpeed()) - this.m_startOverlap) - this.m_endOverlap;
    }

    public int getRepresentedDurationWithoutSpeedControl() {
        return (((this.m_duration - this.m_startOverlap) - this.m_endOverlap) - this.m_trimTimeStart) - this.m_trimTimeEnd;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getRepresentedDurationWithoutOverlap() {
        return (this.m_duration - this.m_trimTimeStart) - this.m_trimTimeEnd;
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

    public int getFirstRepresentedTime() {
        return this.m_startOverlap + this.m_trimTimeStart;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getStartOverlap() {
        return this.m_startOverlap;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public int getEndOverlap() {
        return this.m_endOverlap;
    }

    public void setStartOverlap(int i) {
        this.m_startOverlap = i;
    }

    public void setEndOverlap(int i) {
        this.m_endOverlap = i;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getDuration() {
        return this.m_duration;
    }

    public int getAudioDuration() {
        return this.m_audioDuration;
    }

    public int getVideoDuration() {
        return this.m_videoDuration;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void setDuration(int i) {
        this.m_duration = i;
    }

    public void setTrim(int i, int i2) {
        this.m_trimTimeStart = snapToIFrame(i);
        this.m_trimTimeEnd = i2;
    }

    public void setTrimStart(int i) {
        this.m_trimTimeStart = snapToIFrame(i);
    }

    public int snapToIFrame(int i) {
        if ((getWidth() > 1280 || getHeight() > 720) && this.g != null) {
            int[] iArr = this.k;
            if (iArr == null) {
                iArr = this.g.f();
            }
            int i2 = -1;
            int extraDurationForSplit = NexEditorDeviceProfile.getDeviceProfile().getExtraDurationForSplit();
            if (iArr != null) {
                int length = iArr.length;
                int i3 = 0;
                while (i3 < length) {
                    int i4 = iArr[i3];
                    if (i < i4 || i > i4 + extraDurationForSplit) {
                        if (i < i4) {
                            return i4 - i < i - i2 ? i4 : i2;
                        }
                        if (i2 < 0 && i < i4) {
                            return i4;
                        }
                        i3++;
                        i2 = i4 + extraDurationForSplit;
                    } else {
                        return i;
                    }
                }
            }
            int i5 = i2;
            return i5 >= 0 ? i5 : i;
        }
        return i;
    }

    public void setTrimEnd(int i) {
        this.m_trimTimeEnd = i;
    }

    public int getTrimTimeStart() {
        return this.m_trimTimeStart;
    }

    public int getTrimTimeEnd() {
        return this.m_trimTimeEnd;
    }

    private void a(int i) {
        this.m_preTrimmedDuration = i;
    }

    private int d() {
        return this.m_preTrimmedDuration;
    }

    public void checkEffectTime(int i, int i2, int i3) {
        int trimTimeStart = getTrimTimeStart();
        if (i3 == 3) {
            int effectDuration = i2 < 0 ? getEffectDuration() : ((i2 * 100) / getPlaybackSpeed()) - ((i * 100) / getPlaybackSpeed());
            if (effectDuration < 500) {
                setEffectTiming((i * 100) / getPlaybackSpeed(), 500);
                return;
            }
            int playbackSpeed = (i * 100) / getPlaybackSpeed();
            if (i2 >= 0) {
                effectDuration = (i2 * 100) / getPlaybackSpeed();
            }
            setEffectTiming(playbackSpeed, effectDuration);
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
            int d = d();
            if (i2 == Integer.MAX_VALUE) {
                setEffectTiming(i, duration);
                i2 = getEffectEndTime();
            }
            if (i < duration && i2 > duration) {
                setEffectTiming(i, duration);
            } else if (duration > i && duration > i2) {
                if (d == i2) {
                    setEffectTiming(i, duration);
                } else {
                    setEffectTiming(i, i2);
                }
            } else {
                setEffectTiming(0, duration);
            }
            a(duration);
            return;
        }
        int playbackSpeed2 = (trimTimeStart * 100) / getPlaybackSpeed();
        if (i3 == 1) {
            if (i < playbackSpeed2 && i2 > playbackSpeed2) {
                setEffectTiming(0, i2 - playbackSpeed2);
                return;
            }
            if (i < playbackSpeed2 && i2 < playbackSpeed2) {
                setEffectTiming(0, getRepresentedDuration());
                return;
            } else {
                if (i > playbackSpeed2 && i2 > playbackSpeed2) {
                    setEffectTiming(i - playbackSpeed2, (i2 - i) - (playbackSpeed2 - i));
                    return;
                }
                return;
            }
        }
        if (i3 == 2) {
            int representedDuration2 = getRepresentedDuration();
            if (i < representedDuration2 && i2 > representedDuration2) {
                if (representedDuration2 < 500) {
                    setEffectTiming(i, 500);
                    return;
                } else {
                    setEffectTiming(i, getRepresentedDuration());
                    return;
                }
            }
            if (i > representedDuration2 && i2 > representedDuration2) {
                setEffectTiming(0, getRepresentedDuration());
            } else if (i < representedDuration2 && i2 < representedDuration2) {
                setEffectTiming(i, i2);
            }
        }
    }

    public void getStartPosition(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            rect.bottom = (int) ((this.m_rotatedStartPositionBottom * this.m_width) / 100000);
            rect.left = (int) ((this.m_rotatedStartPositionLeft * this.m_height) / 100000);
            rect.right = (int) ((this.m_rotatedStartPositionRight * this.m_height) / 100000);
            rect.top = (int) ((this.m_rotatedStartPositionTop * this.m_width) / 100000);
            return;
        }
        rect.bottom = (int) ((this.m_startPositionBottom * this.m_height) / 100000);
        rect.left = (int) ((this.m_startPositionLeft * this.m_width) / 100000);
        rect.right = (int) ((this.m_startPositionRight * this.m_width) / 100000);
        rect.top = (int) ((this.m_startPositionTop * this.m_height) / 100000);
    }

    private void e() {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            if (this.m_rotatedStartPositionLeft == this.m_rotatedStartPositionRight || this.m_rotatedStartPositionTop == this.m_rotatedStartPositionBottom || this.m_rotatedEndPositionLeft == this.m_rotatedEndPositionRight || this.m_rotatedEndPositionTop == this.m_rotatedEndPositionBottom) {
                randomizeStartEndPosition(false, CropMode.FIT);
                return;
            }
            return;
        }
        if (this.m_startPositionLeft == this.m_startPositionRight || this.m_startPositionTop == this.m_startPositionBottom || this.m_endPositionLeft == this.m_endPositionRight || this.m_endPositionTop == this.m_endPositionBottom) {
            randomizeStartEndPosition(false, CropMode.FIT);
        }
    }

    public void setStartPosition(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            this.m_rotatedStartPositionBottom = (int) ((rect.bottom * 100000) / this.m_width);
            this.m_rotatedStartPositionLeft = (int) ((rect.left * 100000) / this.m_height);
            this.m_rotatedStartPositionRight = (int) ((rect.right * 100000) / this.m_height);
            this.m_rotatedStartPositionTop = (int) ((rect.top * 100000) / this.m_width);
        } else {
            this.m_startPositionBottom = (int) ((rect.bottom * 100000) / this.m_height);
            this.m_startPositionLeft = (int) ((rect.left * 100000) / this.m_width);
            this.m_startPositionRight = (int) ((rect.right * 100000) / this.m_width);
            this.m_startPositionTop = (int) ((rect.top * 100000) / this.m_height);
        }
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        a(rect).setValues(this.m_startMatrix);
    }

    public void getEndPosition(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            rect.bottom = (int) ((this.m_rotatedEndPositionBottom * this.m_width) / 100000);
            rect.left = (int) ((this.m_rotatedEndPositionLeft * this.m_height) / 100000);
            rect.right = (int) ((this.m_rotatedEndPositionRight * this.m_height) / 100000);
            rect.top = (int) ((this.m_rotatedEndPositionTop * this.m_width) / 100000);
            return;
        }
        rect.bottom = (int) ((this.m_endPositionBottom * this.m_height) / 100000);
        rect.left = (int) ((this.m_endPositionLeft * this.m_width) / 100000);
        rect.right = (int) ((this.m_endPositionRight * this.m_width) / 100000);
        rect.top = (int) ((this.m_endPositionTop * this.m_height) / 100000);
    }

    public void setEndPosition(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            this.m_rotatedEndPositionBottom = (int) ((rect.bottom * 100000) / this.m_width);
            this.m_rotatedEndPositionLeft = (int) ((rect.left * 100000) / this.m_height);
            this.m_rotatedEndPositionRight = (int) ((rect.right * 100000) / this.m_height);
            this.m_rotatedEndPositionTop = (int) ((rect.top * 100000) / this.m_width);
        } else {
            this.m_endPositionBottom = (int) ((rect.bottom * 100000) / this.m_height);
            this.m_endPositionLeft = (int) ((rect.left * 100000) / this.m_width);
            this.m_endPositionRight = (int) ((rect.right * 100000) / this.m_width);
            this.m_endPositionTop = (int) ((rect.top * 100000) / this.m_height);
        }
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        a(rect).setValues(this.m_endMatrix);
    }

    public void getStartPositionRaw(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            rect.bottom = this.m_rotatedStartPositionBottom;
            rect.left = this.m_rotatedStartPositionLeft;
            rect.right = this.m_rotatedStartPositionRight;
            rect.top = this.m_rotatedStartPositionTop;
            return;
        }
        rect.bottom = this.m_startPositionBottom;
        rect.left = this.m_startPositionLeft;
        rect.right = this.m_startPositionRight;
        rect.top = this.m_startPositionTop;
    }

    public void setStartPositionRaw(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            this.m_rotatedStartPositionBottom = rect.bottom;
            this.m_rotatedStartPositionLeft = rect.left;
            this.m_rotatedStartPositionRight = rect.right;
            this.m_rotatedStartPositionTop = rect.top;
        } else {
            this.m_startPositionBottom = rect.bottom;
            this.m_startPositionLeft = rect.left;
            this.m_startPositionRight = rect.right;
            this.m_startPositionTop = rect.top;
        }
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        a(rect).setValues(this.m_startMatrix);
    }

    public void getEndPositionRaw(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            rect.bottom = this.m_rotatedEndPositionBottom;
            rect.left = this.m_rotatedEndPositionLeft;
            rect.right = this.m_rotatedEndPositionRight;
            rect.top = this.m_rotatedEndPositionTop;
            return;
        }
        rect.bottom = this.m_endPositionBottom;
        rect.left = this.m_endPositionLeft;
        rect.right = this.m_endPositionRight;
        rect.top = this.m_endPositionTop;
    }

    public void setEndPositionRaw(Rect rect) {
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            this.m_rotatedEndPositionBottom = rect.bottom;
            this.m_rotatedEndPositionLeft = rect.left;
            this.m_rotatedEndPositionRight = rect.right;
            this.m_rotatedEndPositionTop = rect.top;
        } else {
            this.m_endPositionBottom = rect.bottom;
            this.m_endPositionLeft = rect.left;
            this.m_endPositionRight = rect.right;
            this.m_endPositionTop = rect.top;
        }
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        a(rect).setValues(this.m_endMatrix);
    }

    public void getStartMatrix(Matrix matrix) {
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        matrix.setValues(this.m_startMatrix);
    }

    public void getEndMatrix(Matrix matrix) {
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        matrix.setValues(this.m_endMatrix);
    }

    public void setStartMatrix(Matrix matrix) {
        if (this.m_startMatrix == null) {
            this.m_startMatrix = new float[9];
        }
        matrix.getValues(this.m_startMatrix);
        RectF a2 = a(matrix);
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            this.m_rotatedStartPositionBottom = (int) a2.bottom;
            this.m_rotatedStartPositionLeft = (int) a2.left;
            this.m_rotatedStartPositionRight = (int) a2.right;
            this.m_rotatedStartPositionTop = (int) a2.top;
            return;
        }
        this.m_startPositionBottom = (int) a2.bottom;
        this.m_startPositionLeft = (int) a2.left;
        this.m_startPositionRight = (int) a2.right;
        this.m_startPositionTop = (int) a2.top;
    }

    public void setEndMatrix(Matrix matrix) {
        if (this.m_endMatrix == null) {
            this.m_endMatrix = new float[9];
        }
        matrix.getValues(this.m_endMatrix);
        RectF a2 = a(matrix);
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            this.m_rotatedEndPositionBottom = (int) a2.bottom;
            this.m_rotatedEndPositionLeft = (int) a2.left;
            this.m_rotatedEndPositionRight = (int) a2.right;
            this.m_rotatedEndPositionTop = (int) a2.top;
            return;
        }
        this.m_endPositionBottom = (int) a2.bottom;
        this.m_endPositionLeft = (int) a2.left;
        this.m_endPositionRight = (int) a2.right;
        this.m_endPositionTop = (int) a2.top;
    }

    private Matrix a(Rect rect) {
        return a(rect.left, rect.top, rect.right, rect.bottom);
    }

    private Matrix a(float f, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        matrix.postTranslate(-f, -f2);
        matrix.postScale(1.7777778f / (f3 - f), 1.0f / (f4 - f2));
        return matrix;
    }

    private RectF a(Matrix matrix) {
        float[] fArr = {0.0f, 0.0f, this.m_width, this.m_height};
        matrix.mapPoints(fArr);
        RectF rectF = new RectF(fArr[0], fArr[1], fArr[2], fArr[3]);
        rectF.left = (int) (((0.0f - rectF.left) / rectF.width()) * this.m_width);
        rectF.top = (int) (((0.0f - rectF.top) / rectF.height()) * this.m_height);
        rectF.right = (int) (((1.7777778f - rectF.left) / rectF.width()) * this.m_width);
        rectF.bottom = (int) (((1.0f - rectF.top) / rectF.height()) * this.m_height);
        return rectF;
    }

    public void setEngineClipID(int i) {
        this.m_engineClipID = i;
    }

    public int getEngineClipID() {
        return this.m_engineClipID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public void setRotation(int i) {
        this.m_rotation = i;
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            if (this.m_rotatedStartPositionLeft == this.m_rotatedStartPositionRight || this.m_rotatedStartPositionTop == this.m_rotatedStartPositionBottom || this.m_rotatedEndPositionLeft == this.m_rotatedEndPositionRight || this.m_rotatedEndPositionTop == this.m_rotatedEndPositionBottom) {
                randomizeStartEndPosition(false, CropMode.FIT);
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public int getRotation() {
        return this.m_rotation;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public boolean getFlipH() {
        return this.m_fliph;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public boolean getFlipV() {
        return this.m_flipv;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public void setFlipH(boolean z) {
        this.m_fliph = z;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.q
    public void setFlipV(boolean z) {
        this.m_flipv = z;
    }

    public void setHasAudio(boolean z) {
        this.m_hasAudio = z;
    }

    public boolean getHasAudio() {
        return this.m_hasAudio;
    }

    @Deprecated
    public void setDimensions(int i, int i2) {
        this.m_width = i;
        this.m_height = i2;
    }

    public int getWidth() {
        return this.m_width;
    }

    public int getHeight() {
        return this.m_height;
    }

    public int getOriginalWidth() {
        return this.m_originalWidth > 0 ? this.m_originalWidth : this.m_width;
    }

    public int getOriginalHeight() {
        return this.m_originalHeight > 0 ? this.m_originalHeight : this.m_height;
    }

    public void setTitleStartTime(int i) {
        this.m_titleStartTime = i;
    }

    public void setTitleEndTime(int i) {
        this.m_titleEndTime = i;
    }

    public int setTitleStartTime() {
        return this.m_titleStartTime;
    }

    public int setTitleEndTime() {
        return this.m_titleEndTime;
    }

    public String getMediaPath() {
        return this.m_mediaPath;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public MSID getMediaMSID() {
        return this.m_mediaMSID;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onShowItemMenu(Context context, int i, int i2, int i3, int i4, int i5, NexTimelineItem.n nVar) {
        return false;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onDown(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 == R.id.editmode_trim) {
            return onDown_trim(context, tVar, rectF, i, i2, z, i3);
        }
        if (i3 == R.id.editmode_fxtime) {
            return onDown_fxtime(context, tVar, rectF, i, i2, z, i3);
        }
        return null;
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public int f4498a;
        public int b;
        public int c;
        public int d;

        private a() {
        }

        /* synthetic */ a(db dbVar) {
            this();
        }
    }

    private a a(RectF rectF) {
        a aVar = new a(null);
        aVar.f4498a = this.m_effectStartTime;
        aVar.b = this.m_effectEndTime;
        int representedDuration = getRepresentedDuration();
        if (aVar.f4498a < 0) {
            aVar.f4498a = 0;
        }
        if (aVar.b > representedDuration || aVar.b == 0) {
            aVar.b = representedDuration;
        }
        if (aVar.b < aVar.f4498a + 500) {
            aVar.b = Math.min(representedDuration, aVar.f4498a + 500);
        }
        aVar.c = (int) (rectF.left + ((aVar.f4498a * rectF.width()) / representedDuration));
        aVar.d = (int) (((aVar.b * rectF.width()) / representedDuration) + rectF.left);
        return aVar;
    }

    private a b(Rect rect) {
        a aVar = new a(null);
        aVar.f4498a = this.m_effectStartTime;
        aVar.b = this.m_effectEndTime;
        int representedDuration = getRepresentedDuration();
        if (aVar.f4498a < 0) {
            aVar.f4498a = 0;
        }
        if (aVar.b > representedDuration || aVar.b == 0) {
            aVar.b = representedDuration;
        }
        if (aVar.b < aVar.f4498a + 500) {
            aVar.b = Math.min(representedDuration, aVar.f4498a + 500);
        }
        aVar.c = (int) (rect.left + ((aVar.f4498a * rect.width()) / representedDuration));
        aVar.d = (int) (rect.left + ((aVar.b * rect.width()) / representedDuration));
        return aVar;
    }

    public NexTimelineItem.i onDown_fxtime(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 != R.id.editmode_fxtime) {
            return null;
        }
        a a2 = a(rectF);
        float abs = Math.abs(a2.c - i);
        float abs2 = Math.abs(a2.d - i);
        if (Math.min(abs, abs2) > rectF.height()) {
            return null;
        }
        if (abs < abs2) {
            b bVar = new b(null);
            bVar.f4499a = DragType.FXSTART;
            bVar.q = context;
            bVar.d = a2.f4498a;
            a(bVar, context, a2.c, (int) rectF.top);
            return bVar;
        }
        b bVar2 = new b(null);
        bVar2.f4499a = DragType.FXEND;
        bVar2.q = context;
        bVar2.d = a2.b;
        a(bVar2, context, a2.d, (int) rectF.top);
        return bVar2;
    }

    public NexTimelineItem.i onDown_trim(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (i3 != R.id.editmode_trim) {
            return null;
        }
        getTimeline().getSecondaryItemCount();
        if (!this.m_isImage && rectF.width() < rectF.height() * 2.0f) {
            if (i < rectF.left + (rectF.width() / 2.0f)) {
                b bVar = new b(null);
                bVar.f4499a = DragType.START;
                bVar.q = context;
                bVar.b = this.m_isImage ? this.m_duration : this.m_trimTimeStart;
                bVar.c = tVar.getCurrentTime();
                bVar.e = Integer.MAX_VALUE;
                bVar.v = getTimeline().beginTimeChange();
                if (context instanceof ProjectEditActivity) {
                    bVar.f = ((ProjectEditActivity) context).p().y();
                    bVar.f.a(new File(getMediaPath()));
                    bVar.f.a(this.m_trimTimeStart);
                }
                a(bVar, context, (int) rectF.left, (int) rectF.top);
                return bVar;
            }
            b bVar2 = new b(null);
            bVar2.f4499a = DragType.END;
            bVar2.q = context;
            bVar2.b = this.m_isImage ? this.m_duration : this.m_trimTimeEnd;
            bVar2.e = Integer.MAX_VALUE;
            bVar2.v = getTimeline().beginTimeChange();
            a(bVar2, context, (int) rectF.right, (int) rectF.top);
            if (context instanceof ProjectEditActivity) {
                bVar2.f = ((ProjectEditActivity) context).p().y();
                bVar2.f.a(new File(getMediaPath()));
                bVar2.f.a(this.m_duration - this.m_trimTimeEnd);
            }
            return bVar2;
        }
        if (!this.m_isImage && i < rectF.left + rectF.height()) {
            b bVar3 = new b(null);
            bVar3.f4499a = DragType.START;
            bVar3.q = context;
            bVar3.b = this.m_isImage ? this.m_duration : this.m_trimTimeStart;
            bVar3.c = tVar.getCurrentTime();
            bVar3.e = Integer.MAX_VALUE;
            bVar3.v = getTimeline().beginTimeChange();
            if (context instanceof ProjectEditActivity) {
                bVar3.f = ((ProjectEditActivity) context).p().y();
                bVar3.f.a(new File(getMediaPath()));
                bVar3.f.a(this.m_trimTimeStart);
            }
            a(bVar3, context, (int) rectF.left, (int) rectF.top);
            return bVar3;
        }
        if (i <= rectF.right - rectF.height()) {
            return null;
        }
        b bVar4 = new b(null);
        bVar4.f4499a = DragType.END;
        bVar4.q = context;
        bVar4.b = this.m_isImage ? this.m_duration : this.m_trimTimeEnd;
        bVar4.e = Integer.MAX_VALUE;
        bVar4.v = getTimeline().beginTimeChange();
        if ((context instanceof ProjectEditActivity) && isVideo()) {
            bVar4.f = ((ProjectEditActivity) context).p().y();
            bVar4.f.a(new File(getMediaPath()));
            bVar4.f.a(this.m_duration - this.m_trimTimeEnd);
        }
        if (this.m_isImage) {
            a(bVar4, context, (int) rectF.right, (int) rectF.top);
        } else {
            a(bVar4, context, (int) rectF.right, (int) rectF.top);
        }
        return bVar4;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public NexTimelineItem.i onLongPress(Context context, NexTimelineItem.t tVar, RectF rectF, int i, int i2, boolean z, int i3) {
        if (isLogoClip()) {
            PreferenceManager.getDefaultSharedPreferences(context);
        }
        return NexTimelineItem.i.n;
    }

    /* loaded from: classes.dex */
    public static class b extends NexTimelineItem.h {

        /* renamed from: a */
        DragType f4499a;
        int b;
        int c;
        int d;
        int e;
        com.nexstreaming.kinemaster.editorwrapper.at f;
        int g;
        int h;
        TextView i;
        ViewGroup j;
        View k;
        WindowManager l;
        WindowManager.LayoutParams m;
        int p;
        Context q;
        ViewGroup r;
        TextView s;
        TextView t;
        TextView u;
        NexTimeline.c v;

        private b() {
            this.f4499a = null;
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = null;
            this.g = 0;
            this.h = 0;
            this.i = null;
            this.j = null;
            this.k = null;
            this.l = null;
            this.m = null;
            this.p = 0;
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.v = null;
        }

        /* synthetic */ b(db dbVar) {
            this();
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean onCustomDrag(NexTimelineItem.h hVar, NexTimelineItem.t tVar, float f, float f2, float f3) {
        int i = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
        b bVar = (b) hVar;
        switch (bVar.f4499a) {
            case FXSTART:
                this.m_effectStartTime = bVar.d + ((int) ((f / f3) * 1000.0f));
                if (this.m_effectStartTime < 0) {
                    this.m_effectStartTime = 0;
                }
                if (this.m_effectStartTime > getRepresentedDuration() - 500) {
                    this.m_effectStartTime = getRepresentedDuration() - 500;
                }
                if (this.m_effectStartTime > this.m_effectEndTime - 500) {
                    this.m_effectStartTime = this.m_effectEndTime - 500;
                }
                bVar.k.invalidate();
                return true;
            case FXEND:
                this.m_effectEndTime = bVar.d + ((int) ((f / f3) * 1000.0f));
                if (this.m_effectEndTime < 0) {
                    this.m_effectEndTime = 0;
                }
                if (this.m_effectEndTime < this.m_effectStartTime + 500) {
                    this.m_effectEndTime = this.m_effectStartTime + 500;
                }
                if (this.m_effectEndTime > getRepresentedDuration()) {
                    this.m_effectEndTime = getRepresentedDuration();
                }
                bVar.k.invalidate();
                return true;
            case END:
                if (this.m_isImage) {
                    if (getTimeline().getPrimaryItemCount() != 1) {
                        i = Math.max(getStartOverlap() + getEndOverlap() + 750, 500);
                    }
                    this.m_duration = bVar.b + Math.max((int) ((f / f3) * 1000.0f), -bVar.e);
                    if (this.m_duration < i) {
                        this.m_duration = i;
                    }
                    if (this.m_duration > 1800000) {
                        this.m_duration = 1800000;
                    }
                    bVar.v.a();
                    bVar.k.invalidate();
                    if (bVar.f != null) {
                        bVar.f.a(this.m_duration);
                    }
                } else {
                    this.m_trimTimeEnd = bVar.b - ((Math.max((int) ((f / f3) * 1000.0f), -bVar.e) * getPlaybackSpeed()) / 100);
                    int round = (this.m_duration - this.m_trimTimeStart) - Math.round((Math.max((getStartOverlap() + getEndOverlap()) + 750, LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) * getPlaybackSpeed()) / 100.0f);
                    if (this.m_trimTimeEnd > round) {
                        this.m_trimTimeEnd = round;
                    }
                    if (this.m_trimTimeEnd < 0) {
                        this.m_trimTimeEnd = 0;
                    }
                    this.m_trimmedDuration = (this.m_duration - this.m_trimTimeEnd) - this.m_trimTimeStart;
                    bVar.v.a();
                    bVar.k.invalidate();
                    if (bVar.f != null) {
                        bVar.f.a(this.m_duration - this.m_trimTimeEnd);
                    }
                }
                return true;
            case START:
                this.m_trimTimeStart = bVar.b + ((Math.min((int) ((f / f3) * 1000.0f), bVar.e) * getPlaybackSpeed()) / 100);
                int round2 = (this.m_duration - this.m_trimTimeEnd) - Math.round((Math.max(LicenseErrCode.LICENSE_STATUS_NOT_LICENSED, (getStartOverlap() + getEndOverlap()) + 750) * getPlaybackSpeed()) / 100.0f);
                this.m_trimTimeStart = snapToIFrame(this.m_trimTimeStart);
                if (this.m_trimTimeStart > round2) {
                    this.m_trimTimeStart = round2;
                }
                if (this.m_trimTimeStart < 0) {
                    this.m_trimTimeStart = 0;
                }
                this.m_trimmedDuration = (this.m_duration - this.m_trimTimeEnd) - this.m_trimTimeStart;
                bVar.v.a();
                bVar.k.invalidate();
                tVar.c(bVar.c + (((bVar.b - this.m_trimTimeStart) / getPlaybackSpeed()) * 100));
                if (bVar.f != null) {
                    bVar.f.a(this.m_trimTimeStart);
                }
                return true;
            default:
                return false;
        }
    }

    private void a(b bVar, Context context, int i, int i2) {
        Rect rect = new Rect();
        String str = "";
        if (bVar.f4499a == DragType.START) {
            if (isImage()) {
                str = context.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(getDuration()));
            } else {
                str = context.getResources().getString(R.string.video_drag_duration, EditorGlobal.a((this.m_trimmedDuration * 100) / getPlaybackSpeed()));
                String string = context.getResources().getString(R.string.video_drag_starttrim, EditorGlobal.a(this.m_trimTimeStart));
                if (str.length() <= string.length()) {
                    str = string;
                }
            }
        } else if (bVar.f4499a == DragType.FXSTART) {
            str = context.getResources().getString(R.string.video_drag_fxstart, EditorGlobal.a(this.m_effectStartTime));
        } else if (bVar.f4499a == DragType.FXEND) {
            str = context.getResources().getString(R.string.video_drag_fxend, EditorGlobal.a(this.m_effectEndTime));
        } else if (bVar.f4499a == DragType.END) {
            if (isImage()) {
                str = context.getResources().getString(R.string.video_drag_duration, EditorGlobal.a(getDuration()));
            } else {
                str = context.getResources().getString(R.string.video_drag_duration, EditorGlobal.a((this.m_trimmedDuration * 100) / getPlaybackSpeed()));
                String string2 = context.getResources().getString(R.string.video_drag_endtrim, EditorGlobal.a(this.m_trimTimeEnd));
                if (str.length() <= string2.length()) {
                    str = string2;
                }
            }
        }
        Paint paint = new Paint();
        paint.setTextSize(context.getResources().getDimensionPixelSize(R.dimen.custom_drag_text_size));
        paint.getTextBounds(str, 0, str.length(), rect);
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        bVar.g = Math.max(rect.width() + 10, (int) TypedValue.applyDimension(1, 100.0f, displayMetrics));
        if (isImage() || bVar.f4499a == DragType.FXSTART || bVar.f4499a == DragType.FXEND) {
            bVar.h = (int) TypedValue.applyDimension(1, 32.0f, displayMetrics);
        } else {
            bVar.h = (int) TypedValue.applyDimension(1, 48.0f, displayMetrics);
        }
        bVar.p = i - (bVar.g / 2);
        bVar.l = (WindowManager) context.getSystemService("window");
        bVar.j = new FrameLayout(context);
        bVar.j.setBackgroundColor(0);
        bVar.k = new dm(this, context, bVar);
        bVar.k.setLayoutParams(new FrameLayout.LayoutParams(bVar.g, bVar.h));
        bVar.j.addView(bVar.k);
        bVar.m = new WindowManager.LayoutParams();
        bVar.m.width = bVar.g;
        bVar.m.height = bVar.h;
        bVar.m.flags = 408;
        bVar.m.gravity = 51;
        bVar.m.x = bVar.p;
        bVar.m.y = ((int) TypedValue.applyDimension(1, 2.0f, displayMetrics)) + (i2 - bVar.h);
        bVar.m.windowAnimations = 0;
        bVar.m.format = -3;
        bVar.l.addView(bVar.j, bVar.m);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomPostDrag(NexTimelineItem.h hVar, Rect rect) {
        b bVar = (b) hVar;
        if (bVar.l != null && bVar.j != null) {
            if (bVar.f4499a == DragType.END) {
                bVar.m.x = rect.right - (bVar.g / 2);
                bVar.l.updateViewLayout(bVar.j, bVar.m);
                return;
            }
            if (bVar.f4499a == DragType.START) {
                bVar.m.x = rect.left - (bVar.g / 2);
                bVar.l.updateViewLayout(bVar.j, bVar.m);
            } else {
                if (bVar.f4499a == DragType.FXSTART) {
                    a b2 = b(rect);
                    bVar.m.x = b2.c - (bVar.g / 2);
                    bVar.l.updateViewLayout(bVar.j, bVar.m);
                    return;
                }
                if (bVar.f4499a == DragType.FXEND) {
                    a b3 = b(rect);
                    bVar.m.x = b3.d - (bVar.g / 2);
                    bVar.l.updateViewLayout(bVar.j, bVar.m);
                }
            }
        }
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isReadyToPlay() {
        return this.m_mediaPath != null && this.m_mediaMSID == null;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onCustomDragDone(NexTimelineItem.h hVar, NexTimelineItem.t tVar) {
        b bVar = (b) hVar;
        if (bVar.f != null) {
            int i = 0;
            if (bVar.f4499a == DragType.END) {
                i = getAbsEndTime() - 2;
            } else if (bVar.f4499a == DragType.START) {
                i = getAbsStartTime();
            }
            bVar.f.b(i);
            bVar.f = null;
        }
        if (bVar.l != null && bVar.j != null) {
            bVar.l.removeView(bVar.j);
            bVar.j = null;
        }
        if (bVar.f4499a == DragType.START) {
            checkEffectTime(getEffectStartTime(), getEffectEndTime(), 1);
        } else if (bVar.f4499a == DragType.END) {
            checkEffectTime(getEffectStartTime(), getEffectEndTime(), 2);
        }
        getTransition().ensureTransitionFits();
        if (getPrecedingTransition() != null) {
            getPrecedingTransition().ensureTransitionFits();
        }
        if (bVar.f4499a == DragType.END) {
            tVar.a(getAbsEndTime() - 2, true);
        } else if (bVar.f4499a == DragType.START) {
            tVar.a(getAbsStartTime(), true);
        }
    }

    public NexVisualClip asNexVisualClip() {
        int volumeEnvelopeTimeAdj;
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
        nexVisualClip.mTitleEndTime = (getDuration() - getEndOverlap()) + getAbsStartTime();
        nexVisualClip.mVoiceChanger = this.m_voiceChanger;
        nexVisualClip.mCompressor = this.m_audioCompressor;
        nexVisualClip.mPitchFactor = this.m_pitchFactor;
        nexVisualClip.mPanLeft = getAudioLeftVolume();
        nexVisualClip.mPanRight = getAudioRightVolume();
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
        nexVisualClip.mAudioOnOff = this.m_muteAudio ? 0 : 1;
        nexVisualClip.mClipVolume = this.m_clipVolume;
        nexVisualClip.mEffectDuration = getTransition().getEngineDuration();
        nexVisualClip.mClipEffectID = getTransition().isSet() ? getTransition().getTransitionEffectID() : "none";
        nexVisualClip.mTitleEffectID = this.m_titleEffectID;
        if (this.m_rotation == 90 || this.m_rotation == 270) {
            nexVisualClip.mStartRect = new NexRectangle(this.m_rotatedStartPositionLeft, this.m_rotatedStartPositionTop, this.m_rotatedStartPositionRight, this.m_rotatedStartPositionBottom);
            if (this.m_cropLink) {
                nexVisualClip.mEndRect = new NexRectangle(this.m_rotatedStartPositionLeft, this.m_rotatedStartPositionTop, this.m_rotatedStartPositionRight, this.m_rotatedStartPositionBottom);
            } else {
                nexVisualClip.mEndRect = new NexRectangle(this.m_rotatedEndPositionLeft, this.m_rotatedEndPositionTop, this.m_rotatedEndPositionRight, this.m_rotatedEndPositionBottom);
            }
        } else {
            nexVisualClip.mStartRect = new NexRectangle(this.m_startPositionLeft, this.m_startPositionTop, this.m_startPositionRight, this.m_startPositionBottom);
            if (this.m_cropLink) {
                nexVisualClip.mEndRect = new NexRectangle(this.m_startPositionLeft, this.m_startPositionTop, this.m_startPositionRight, this.m_startPositionBottom);
            } else {
                nexVisualClip.mEndRect = new NexRectangle(this.m_endPositionLeft, this.m_endPositionTop, this.m_endPositionRight, this.m_endPositionBottom);
            }
        }
        nexVisualClip.mClipPath = this.m_mediaPath;
        nexVisualClip.mThumbnailPath = this.m_thumbPath;
        nexVisualClip.mRotateState = this.m_rotation;
        if (this.m_fliph) {
            nexVisualClip.mRotateState |= NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST;
        }
        if (this.m_flipv) {
            nexVisualClip.mRotateState |= 131072;
        }
        nexVisualClip.mEffectOffset = getTransition().getTransitionOffsetPercent();
        nexVisualClip.mEffectOverlap = getTransition().getTransitionOverlapPercent();
        nexVisualClip.mSpeedControl = this.m_playbackSpeed == 0 ? 100 : this.m_playbackSpeed;
        if (getVolumeEnvelopeLevel(0) == -1) {
            int representedDuration = (((getRepresentedDuration() + getStartOverlap()) + getTrimTimeEnd()) + getTrimTimeStart()) - getDiffAVDuration();
            addVolumeEnvelope(0, 0, 100);
            addVolumeEnvelope(1, representedDuration, 100);
        }
        if (this.m_volumeEnvelopeLevel != null) {
            ArrayList arrayList = new ArrayList(this.m_volumeEnvelopeLevel.size() + 2);
            ArrayList arrayList2 = new ArrayList(this.m_volumeEnvelopeLevel.size() + 2);
            calcSplitClipFadeTime();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < this.m_volumeEnvelopeLevel.size(); i3++) {
                int volumeEnvelopeTimeAdj2 = getVolumeEnvelopeTimeAdj(i3);
                int volumeEnvelopeLevel = getVolumeEnvelopeLevel(i3);
                if (volumeEnvelopeTimeAdj2 >= this.m_startOverlap && volumeEnvelopeTimeAdj2 < getRepresentedDuration() + this.m_startOverlap) {
                    if (this.m_startOverlap <= 0 && arrayList.isEmpty()) {
                        if (this.o > 0) {
                            arrayList.add(0);
                            arrayList2.add(0);
                        }
                        int i4 = (int) ((((this.o - i2) / (volumeEnvelopeTimeAdj2 - i2)) * (volumeEnvelopeLevel - i)) + i);
                        if (this.m_trimTimeStart > 0) {
                            volumeEnvelopeTimeAdj = (int) (i + (((this.o - i2) / (volumeEnvelopeTimeAdj2 - i2)) * (volumeEnvelopeLevel - i)));
                        } else {
                            volumeEnvelopeTimeAdj = (this.m_trimTimeStart > 0 || volumeEnvelopeTimeAdj2 != 0) ? i4 : (int) ((((this.o + 0) / (getVolumeEnvelopeTimeAdj(i3 + 1) + 0)) * (getVolumeEnvelopeLevel(i3 + 1) - volumeEnvelopeLevel)) + volumeEnvelopeLevel);
                        }
                        if (volumeEnvelopeTimeAdj > 200) {
                            volumeEnvelopeTimeAdj = 200;
                        }
                        if (volumeEnvelopeTimeAdj < 0) {
                            volumeEnvelopeTimeAdj = 0;
                        }
                        arrayList.add(Integer.valueOf(this.o));
                        arrayList2.add(Integer.valueOf(volumeEnvelopeTimeAdj));
                        if (volumeEnvelopeTimeAdj2 == 0) {
                        }
                    } else if (this.m_startOverlap > 0 && arrayList.isEmpty()) {
                        arrayList.add(0);
                        arrayList2.add(0);
                        arrayList.add(Integer.valueOf(this.m_startOverlap));
                        arrayList2.add(Integer.valueOf((int) (i + (((this.m_startOverlap - i2) / (volumeEnvelopeTimeAdj2 - i2)) * (volumeEnvelopeLevel - i)))));
                    }
                    if (volumeEnvelopeTimeAdj2 >= this.m_startOverlap) {
                        arrayList.add(Integer.valueOf(volumeEnvelopeTimeAdj2));
                        arrayList2.add(Integer.valueOf(volumeEnvelopeLevel));
                    }
                } else if (volumeEnvelopeTimeAdj2 >= getRepresentedDuration() + this.m_startOverlap) {
                    if (this.m_startOverlap <= 0 && arrayList.isEmpty()) {
                        if (this.o > 0) {
                            arrayList.add(0);
                            arrayList2.add(0);
                        }
                        arrayList.add(Integer.valueOf(this.o));
                        arrayList2.add(Integer.valueOf((int) ((((this.o - i2) / (volumeEnvelopeTimeAdj2 - i2)) * (volumeEnvelopeLevel - i)) + i)));
                    } else if (this.m_startOverlap > 0 && arrayList.isEmpty()) {
                        arrayList.add(0);
                        arrayList2.add(0);
                        arrayList.add(Integer.valueOf(this.m_startOverlap));
                        arrayList2.add(Integer.valueOf((int) ((((this.m_startOverlap - i2) / (volumeEnvelopeTimeAdj2 - i2)) * (volumeEnvelopeLevel - i)) + i)));
                    }
                    if (this.m_endOverlap <= 0) {
                        arrayList.add(Integer.valueOf((getRepresentedDuration() + this.m_startOverlap) - this.p));
                        arrayList2.add(Integer.valueOf((int) (i + (((((getRepresentedDuration() + this.m_startOverlap) - this.p) - i2) / (volumeEnvelopeTimeAdj2 - i2)) * (volumeEnvelopeLevel - i)))));
                        if (this.p > 0) {
                            arrayList.add(Integer.valueOf(getRepresentedDuration() + this.m_startOverlap));
                            arrayList2.add(0);
                        }
                    } else if (this.m_endOverlap > 0) {
                        arrayList.add(Integer.valueOf(getRepresentedDuration() + this.m_startOverlap));
                        arrayList2.add(Integer.valueOf((int) (i + ((((getRepresentedDuration() + this.m_startOverlap) - i2) / (volumeEnvelopeTimeAdj2 - i2)) * (volumeEnvelopeLevel - i)))));
                        arrayList.add(Integer.valueOf(getRepresentedDuration() + this.m_startOverlap + this.m_endOverlap));
                        arrayList2.add(0);
                    }
                }
                i = volumeEnvelopeLevel;
                i2 = volumeEnvelopeTimeAdj2;
            }
            nexVisualClip.mVolumeEnvelopeTime = com.nexstreaming.app.general.util.l.a(arrayList);
            nexVisualClip.mVolumeEnvelopeLevel = com.nexstreaming.app.general.util.l.a(arrayList2);
        }
        return nexVisualClip;
    }

    public int getAudioFadeInDuration() {
        return this.o;
    }

    public int getAudioFadeOutDuration() {
        return this.p;
    }

    public void calcSplitClipFadeTime() {
        NexVideoClipItem nextClip = getNextClip();
        NexVideoClipItem previousClip = getPreviousClip();
        this.p = (nextClip == null || !nextClip.sameMediaAs(this) || (nextClip != null ? Math.abs(nextClip.getTrimTimeStart() - (getDuration() - getTrimTimeEnd())) : 0) >= 33) ? 100 : 0;
        this.o = (previousClip == null || !previousClip.sameMediaAs(this) || (previousClip != null ? Math.abs(getTrimTimeStart() - (previousClip.getDuration() - previousClip.getTrimTimeEnd())) : 0) >= 33) ? 100 : 0;
    }

    public boolean sameMediaAs(NexVideoClipItem nexVideoClipItem) {
        if (nexVideoClipItem == null) {
            return false;
        }
        if (nexVideoClipItem.m_mediaPath == this.m_mediaPath && nexVideoClipItem.m_mediaMSID == nexVideoClipItem.m_mediaMSID) {
            return true;
        }
        return (nexVideoClipItem.m_mediaPath == this.m_mediaPath || (this.m_mediaPath != null && nexVideoClipItem.m_mediaPath != null && this.m_mediaPath.equals(nexVideoClipItem.m_mediaPath))) && (nexVideoClipItem.m_mediaMSID == this.m_mediaMSID || (this.m_mediaMSID != null && nexVideoClipItem.m_mediaMSID != null && this.m_mediaMSID.equals(nexVideoClipItem.m_mediaMSID)));
    }

    public boolean calcFadeTime() {
        NexVideoClipItem nextClip = getNextClip();
        NexVideoClipItem previousClip = getPreviousClip();
        int i = ((this.m_duration - this.m_trimTimeStart) - this.m_trimTimeEnd) / 3;
        int max = Math.max((nextClip == null || !nextClip.sameMediaAs(this) || (nextClip != null ? Math.abs(nextClip.getTrimTimeStart() - (getDuration() - getTrimTimeEnd())) : 0) >= 33) ? 100 : 0, Math.min(i, getTransition().getEngineDuration()));
        int i2 = (previousClip == null || !previousClip.sameMediaAs(this) || (previousClip != null ? Math.abs(getTrimTimeStart() - (previousClip.getDuration() - previousClip.getTrimTimeEnd())) : 0) >= 33) ? 200 : 0;
        NexTransitionItem precedingTransition = getPrecedingTransition();
        int max2 = precedingTransition != null ? Math.max(i2, Math.min(i, precedingTransition.getEngineDuration())) : 100;
        if (this.o == max2 && this.p == max) {
            return false;
        }
        this.o = max2;
        this.p = max;
        return true;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onTimelineLoaded(EffectLibrary effectLibrary, int i) {
        if (!this.m_abstractCrop) {
            this.m_startPositionLeft = (int) ((this.m_startPositionLeft * 100000) / this.m_width);
            this.m_startPositionTop = (int) ((this.m_startPositionTop * 100000) / this.m_height);
            this.m_startPositionRight = (int) ((this.m_startPositionRight * 100000) / this.m_width);
            this.m_startPositionBottom = (int) ((this.m_startPositionBottom * 100000) / this.m_height);
            this.m_endPositionLeft = (int) ((this.m_endPositionLeft * 100000) / this.m_width);
            this.m_endPositionTop = (int) ((this.m_endPositionTop * 100000) / this.m_height);
            this.m_endPositionRight = (int) ((this.m_endPositionRight * 100000) / this.m_width);
            this.m_endPositionBottom = (int) ((this.m_endPositionBottom * 100000) / this.m_height);
            this.m_abstractCrop = true;
        }
        if (i == 3) {
            if (this.m_autoThemeEffect != null) {
                Theme e = effectLibrary.e(getTimeline().getThemeId());
                if (e != null) {
                    this.m_titleEffectID = effectIdByContextForTheme(e, this.m_autoThemeEffect);
                } else {
                    this.m_titleEffectID = "none";
                }
                this.m_autoThemeEffect = null;
            }
            if (isImage() && this.m_mediaPath != null && new File(this.m_mediaPath).exists() && a(this.m_mediaPath)) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.m_mediaPath, options);
                int i2 = options.outHeight;
                int i3 = options.outWidth;
                if (this.m_width != this.m_height && this.m_width == i3 && this.m_height == i2) {
                    Log.i("NexVideoClipItem", "Fixed EXIF orientation");
                    this.m_width = i2;
                    this.m_height = i3;
                    randomizeStartEndPosition(false, CropMode.FIT);
                } else if (this.m_width != i2 || this.m_height != i3) {
                    Log.w("NexVideoClipItem", "Width/height mismatch : " + this.m_width + "x" + this.m_height + " != " + i2 + "x" + i3);
                }
            }
        }
        NexTransitionItem transition = getTransition();
        if (transition != null && getTimeline().findItemByUniqueId(transition.getUniqueId()) == null) {
            transition.onTimelineLoaded(effectLibrary, i);
        }
        e();
        super.onTimelineLoaded(effectLibrary, i);
    }

    public void updateFromNexVisualClip(NexVisualClip nexVisualClip) {
        if (nexVisualClip != null) {
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
            this.m_fliph = (this.m_rotation & NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST) == 65536;
            this.m_flipv = (this.m_rotation & 131072) == 131072;
            this.m_rotation &= -65537;
            this.m_rotation &= -131073;
            this.m_titleStyle = TitleStyle.fromInt(nexVisualClip.mTitleStyle);
            this.m_titleStartTime = nexVisualClip.mTitleStartTime;
            this.m_titleEndTime = nexVisualClip.mTitleEndTime;
            this.m_playbackSpeed = nexVisualClip.mSpeedControl == 0 ? 100 : nexVisualClip.mSpeedControl;
            if (nexVisualClip.mBGMVolume > 0) {
                this.m_musicVolume = nexVisualClip.mBGMVolume;
                this.m_muteMusic = false;
            } else if (this.m_musicVolume > 0) {
                this.m_muteMusic = true;
            }
            this.m_muteAudio = nexVisualClip.mAudioOnOff == 0;
            this.m_clipVolume = nexVisualClip.mClipVolume;
            if (getTransition().getTransitionEffectID() == null) {
                getTransition().setTransitionEffectID(nexVisualClip.mClipEffectID);
            }
            if (getTransition().getTransitionEffectID().equals("none") && nexVisualClip.mEffectDuration == 0) {
                nexVisualClip.mEffectDuration = LicenseErrCode.LICENSE_STATUS_NOT_LICENSED;
                getTransition().setDuration(nexVisualClip.mEffectDuration);
            } else {
                getTransition().setDuration(nexVisualClip.mEffectDuration);
            }
            if (nexVisualClip.mTitleEffectID != null) {
                this.m_titleEffectID = nexVisualClip.mTitleEffectID;
            }
            if (nexVisualClip.mClipPath != null) {
                if (this.m_mediaPath != null && !this.m_mediaPath.equals(nexVisualClip.mClipPath)) {
                    this.m_mediaPath = nexVisualClip.mClipPath;
                    this.g = MediaInfo.a(new File(this.m_mediaPath));
                } else {
                    this.m_mediaPath = nexVisualClip.mClipPath;
                }
            }
            if (nexVisualClip.mThumbnailPath != null) {
                this.m_thumbPath = nexVisualClip.mThumbnailPath;
            }
        }
    }

    public boolean isImage() {
        return this.m_isImage;
    }

    /* loaded from: classes.dex */
    public enum TitleStyle {
        NONE,
        HEADLINE,
        OPENING,
        PLAYING,
        ENDING;

        public static TitleStyle fromInt(int i) {
            switch (i) {
                case 0:
                    return NONE;
                case 1:
                    return HEADLINE;
                case 2:
                    return OPENING;
                case 3:
                    return PLAYING;
                case 4:
                    return ENDING;
                default:
                    return NONE;
            }
        }

        public int toInt() {
            switch (this) {
                case NONE:
                default:
                    return 0;
                case HEADLINE:
                    return 1;
                case OPENING:
                    return 2;
                case PLAYING:
                    return 3;
                case ENDING:
                    return 4;
            }
        }

        public KMProto.KMProject.TitleStyle asProtoBuf() {
            switch (this) {
                case NONE:
                    return KMProto.KMProject.TitleStyle.TITLE_STYLE_NONE;
                case HEADLINE:
                    return KMProto.KMProject.TitleStyle.TITLE_STYLE_HEADLINE;
                case OPENING:
                    return KMProto.KMProject.TitleStyle.TITLE_STYLE_OPENING;
                case PLAYING:
                    return KMProto.KMProject.TitleStyle.TITLE_STYLE_PLAYING;
                case ENDING:
                    return KMProto.KMProject.TitleStyle.TITLE_STYLE_ENDING;
                default:
                    return KMProto.KMProject.TitleStyle.TITLE_STYLE_NONE;
            }
        }

        public static TitleStyle fromProtoBuf(KMProto.KMProject.TitleStyle titleStyle) {
            switch (titleStyle) {
                case TITLE_STYLE_NONE:
                    return NONE;
                case TITLE_STYLE_HEADLINE:
                    return HEADLINE;
                case TITLE_STYLE_OPENING:
                    return OPENING;
                case TITLE_STYLE_PLAYING:
                    return PLAYING;
                case TITLE_STYLE_ENDING:
                    return ENDING;
                default:
                    return NONE;
            }
        }
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

    public void setTintColor(int i) {
        this.m_TintColor = i;
    }

    public int getTintColor() {
        return this.m_TintColor;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public void setColorEffect(ColorEffect colorEffect) {
        this.m_colorEffect = colorEffect;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.g
    public ColorEffect getColorEffect() {
        return this.m_colorEffect;
    }

    public boolean isLogoClip() {
        return f() && this.m_titleEffectID != null && this.m_titleEffectID.equalsIgnoreCase("com.nexstreaming.kinemaster.builtin.kmlogoending");
    }

    private boolean f() {
        return this.m_mediaPath != null && this.m_mediaPath.startsWith("@solid:") && this.m_mediaPath.endsWith(".jpg");
    }

    public int getSolidColor() {
        if (!f()) {
            return 0;
        }
        return (int) Long.parseLong(this.m_mediaPath.substring(7, 15), 16);
    }

    public void setSolidColor(int i) {
        if (f()) {
            this.m_mediaPath = String.format("@solid:%08X.jpg", Integer.valueOf(i));
        }
    }

    public boolean isPreset() {
        return f();
    }

    public void setCropLink(boolean z) {
        this.m_cropLink = z;
    }

    public boolean isCropLink() {
        return this.m_cropLink;
    }

    private static String[] a(Context context) throws IOException {
        if (c == null) {
            c = context.getAssets().list("backgrounds");
        }
        return c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0092, code lost:            if (0 != 0) goto L123;     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0094, code lost:            r0 = new java.io.File(r11.getFilesDir(), ".km_bg");        r0.mkdirs();     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00a2, code lost:            r1 = new java.io.File(r0, r7);        r2 = r11.getAssets().open("backgrounds/" + r6);     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c2, code lost:            r3 = new java.io.FileOutputStream(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c9, code lost:            r0 = new byte[10240];     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00cb, code lost:            r1 = r2.read(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00d0, code lost:            if (r1 <= (-1)) goto L130;     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00d2, code lost:            r3.write(r0, 0, r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:            r2.close();        r10.f = new java.io.File(r10.m_mediaPath).exists();     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00d7, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d8, code lost:            r3.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00db, code lost:            throw r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00dc, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00dd, code lost:            r2.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e0, code lost:            throw r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x010f, code lost:            r0 = null;     */
    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean checkResourceState(android.content.Context r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexVideoClipItem.checkResourceState(android.content.Context):boolean");
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void removeRequiredOverlaysFromDeleteSet(Set<String> set) {
        if (this.m_captureFilename != null) {
            set.remove(this.m_captureFilename);
        }
        if (this.m_effectOptions != null && !this.m_effectOptions.isEmpty()) {
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
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public String getCaptureFilename() {
        return this.m_captureFilename;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public void setCaptureFilename(String str) {
        this.m_captureFilename = str;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void onThemeChanged(Theme theme, EffectLibrary effectLibrary) {
        if ("themeEffect".equals(this.m_titleEffectID)) {
            this.m_titleEffectID = null;
            this.m_autoThemeEffect = ThemeEffectType.TRANSITION;
        } else if ("themeOpeningTitle".equals(this.m_titleEffectID)) {
            this.m_titleEffectID = null;
            this.m_autoThemeEffect = ThemeEffectType.OPENING;
        } else if ("themeTitle".equals(this.m_titleEffectID)) {
            this.m_titleEffectID = null;
            this.m_autoThemeEffect = ThemeEffectType.MIDDLE;
        } else if ("themeEndingTitle".equals(this.m_titleEffectID)) {
            this.m_titleEffectID = null;
            this.m_autoThemeEffect = ThemeEffectType.ENDING;
        } else if ("themeAccent".equals(this.m_titleEffectID)) {
            this.m_titleEffectID = null;
            this.m_autoThemeEffect = ThemeEffectType.ACCENT;
        } else if (this.m_titleEffectID != null && !this.m_titleEffectID.contains(".")) {
            String[][] strArr = {new String[]{"accent_alien", "com.nexstreaming.kinemaster.builtin.accent.alien"}, new String[]{"accent_bw", "com.nexstreaming.kinemaster.builtin.accent.bw"}, new String[]{"accent_cool", "com.nexstreaming.kinemaster.builtin.accent.cool"}, new String[]{"accent_redalert", "com.nexstreaming.kinemaster.builtin.accent.redalert"}, new String[]{"accent_sepia", "com.nexstreaming.kinemaster.builtin.accent.sepia"}, new String[]{"accent_sunny", "com.nexstreaming.kinemaster.builtin.accent.sunny"}, new String[]{"clipfx_handwriting", "com.nexstreaming.kinemaster.builtin.overlay.handwriting"}, new String[]{"title_bam", "com.nexstreaming.kinemaster.builtin.title.bam"}, new String[]{"bulletin_title", "com.nexstreaming.kinemaster.builtin.title.bulletin"}, new String[]{"mid_title_flip", "com.nexstreaming.kinemaster.builtin.title.centerflip"}, new String[]{"mid_title_low", "com.nexstreaming.kinemaster.builtin.title.centerlow"}, new String[]{"mid_title", "com.nexstreaming.kinemaster.builtin.title.center"}, new String[]{"comic_title", "com.nexstreaming.kinemaster.builtin.title.comic"}, new String[]{"title_credits_mid", "com.nexstreaming.kinemaster.builtin.title.creditsmid"}, new String[]{"elegant_title", "com.nexstreaming.kinemaster.builtin.title.elegant"}, new String[]{"manuscript_title", "com.nexstreaming.kinemaster.builtin.title.manuscript"}, new String[]{"modern_title", "com.nexstreaming.kinemaster.builtin.title.modern"}, new String[]{"Scary_title", "com.nexstreaming.kinemaster.builtin.title.ghoststory"}, new String[]{"Simple", "com.nexstreaming.kinemaster.builtin.title.simple"}, new String[]{"title_stylish_finale", "com.nexstreaming.kinemaster.builtin.title.stylishfinale"}, new String[]{"title_stylish_main", "com.nexstreaming.kinemaster.builtin.title.stylishmain"}, new String[]{"title_stylish_sub", "com.nexstreaming.kinemaster.builtin.title.stylishsub"}, new String[]{"thriller_title", "com.nexstreaming.kinemaster.builtin.title.thriller"}};
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                String[] strArr2 = strArr[i];
                if (!strArr2[0].equals(this.m_titleEffectID)) {
                    i++;
                } else {
                    this.m_titleEffectID = strArr2[1];
                    break;
                }
            }
        }
        applyAutoEffect(theme);
        super.onThemeChanged(theme, effectLibrary);
    }

    @Override // com.nexstreaming.kinemaster.ui.projectedit.nb
    public int getDiffAVDuration() {
        return Math.min(250, getDuration() - getVideoDuration());
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public KMProto.KMProject.TimelineItem asProtoBuf() {
        KMProto.KMProject.VisualClip.Builder builder = new KMProto.KMProject.VisualClip.Builder();
        if (this.m_captureFilename != null) {
            builder.capture_filename(this.m_captureFilename);
        }
        if (this.m_titleEffectID != null) {
            builder.title_effect_id(this.m_titleEffectID);
        }
        if (this.m_mediaMSID != null) {
            builder.media_msid(this.m_mediaMSID.toString());
        }
        if (this.m_thumbPath != null) {
            builder.thumb_path(this.m_thumbPath);
        }
        if (this.m_autoThemeEffect != null) {
            builder.auto_theme_effect(this.m_autoThemeEffect.asProtoBuf());
        }
        if (this.m_colorEffect != null) {
            builder.color_effect(this.m_colorEffect.asProtoBuf());
        }
        if (this.m_transition != null && this.m_transition.getTimeline() == null) {
            builder.unattached_transition(this.m_transition.asProtoBuf());
        }
        builder.engine_clip_id(Integer.valueOf(this.m_engineClipID)).abstract_crop(Boolean.valueOf(this.m_abstractCrop)).start_position_left(Integer.valueOf(this.m_startPositionLeft)).start_position_bottom(Integer.valueOf(this.m_startPositionBottom)).start_position_top(Integer.valueOf(this.m_startPositionTop)).start_position_right(Integer.valueOf(this.m_startPositionRight)).end_position_bottom(Integer.valueOf(this.m_endPositionBottom)).end_position_top(Integer.valueOf(this.m_endPositionTop)).end_position_left(Integer.valueOf(this.m_endPositionLeft)).end_position_right(Integer.valueOf(this.m_endPositionRight)).rotated_start_position_left(Integer.valueOf(this.m_rotatedStartPositionLeft)).rotated_start_position_bottom(Integer.valueOf(this.m_rotatedStartPositionBottom)).rotated_start_position_top(Integer.valueOf(this.m_rotatedStartPositionTop)).rotated_start_position_right(Integer.valueOf(this.m_rotatedStartPositionRight)).rotated_end_position_bottom(Integer.valueOf(this.m_rotatedEndPositionBottom)).rotated_end_position_top(Integer.valueOf(this.m_rotatedEndPositionTop)).rotated_end_position_left(Integer.valueOf(this.m_rotatedEndPositionLeft)).rotated_end_position_right(Integer.valueOf(this.m_rotatedEndPositionRight)).rotation(Integer.valueOf(this.m_rotation)).fliph(Boolean.valueOf(this.m_fliph)).flipv(Boolean.valueOf(this.m_flipv)).diff_av_duration(Integer.valueOf(this.m_diffAVDuration)).trim_time_start(Integer.valueOf(this.m_trimTimeStart)).trim_time_end(Integer.valueOf(this.m_trimTimeEnd)).trimmed_duration(Integer.valueOf(this.m_trimmedDuration)).pre_trimmed_duration(Integer.valueOf(this.m_preTrimmedDuration)).title_start_time(Integer.valueOf(this.m_titleStartTime)).title_end_time(Integer.valueOf(this.m_titleEndTime)).duration(Integer.valueOf(this.m_duration)).audio_duration(Integer.valueOf(this.m_audioDuration)).video_duration(Integer.valueOf(this.m_videoDuration)).start_overlap(Integer.valueOf(this.m_startOverlap)).end_overlap(Integer.valueOf(this.m_endOverlap)).width(Integer.valueOf(this.m_width)).height(Integer.valueOf(this.m_height)).original_width(Integer.valueOf(this.m_originalWidth)).original_height(Integer.valueOf(this.m_originalHeight)).clip_volume(Integer.valueOf(this.m_clipVolume)).music_volume(Integer.valueOf(this.m_musicVolume)).title_style(this.m_titleStyle.asProtoBuf()).is_image(Boolean.valueOf(this.m_isImage)).mute_audio(Boolean.valueOf(this.m_muteAudio)).mute_music(Boolean.valueOf(this.m_muteMusic)).has_audio(Boolean.valueOf(this.m_hasAudio)).has_video(Boolean.valueOf(this.m_hasVideo)).media_path(this.m_mediaPath).transition_item_uuid_lsb(Long.valueOf(getTransition().getUniqueId().getLeastSignificantBits())).transition_item_uuid_msb(Long.valueOf(getTransition().getUniqueId().getMostSignificantBits())).brightness(Integer.valueOf(this.m_Brightness)).contrast(Integer.valueOf(this.m_Contrast)).saturation(Integer.valueOf(this.m_Saturation)).tintcolor(Integer.valueOf(this.m_TintColor)).effect_start_time(Integer.valueOf(this.m_effectStartTime)).effect_end_time(Integer.valueOf(this.m_effectEndTime)).start_matrix(a(this.m_startMatrix)).end_matrix(a(this.m_endMatrix)).volume_envelope_time(this.m_volumeEnvelopeTime).volume_envelope_level(this.m_volumeEnvelopeLevel).clip_width(Float.valueOf(this.m_clipWidth)).playback_speed(Integer.valueOf(this.m_playbackSpeed)).crop_link(Boolean.valueOf(this.m_cropLink)).effect_options(com.nexstreaming.kinemaster.c.a.a(this.m_effectOptions)).is_reverse(Boolean.valueOf(this.m_isReverse)).vignette(Boolean.valueOf(this.m_vignette)).voice_changer(Integer.valueOf(this.m_voiceChanger)).pan_left(Integer.valueOf(getAudioLeftVolume())).pan_right(Integer.valueOf(getAudioRightVolume())).compressor(Integer.valueOf(this.m_audioCompressor)).pitch_factor(Integer.valueOf(this.m_pitchFactor));
        return new KMProto.KMProject.TimelineItem.Builder().clip_type(KMProto.KMProject.ClipType.VISUAL_CLIP).unique_id_lsb(Long.valueOf(getUniqueId().getLeastSignificantBits())).unique_id_msb(Long.valueOf(getUniqueId().getMostSignificantBits())).visual_clip(builder.build()).build();
    }

    public static NexVideoClipItem fromProtoBuf(KMProto.KMProject.TimelineItem timelineItem) {
        KMProto.KMProject.VisualClip visualClip = timelineItem.visual_clip;
        NexVideoClipItem nexVideoClipItem = new NexVideoClipItem(null);
        nexVideoClipItem.setUniqueId(new UUID(timelineItem.unique_id_msb.longValue(), timelineItem.unique_id_lsb.longValue()));
        nexVideoClipItem.m_mediaPath = visualClip.media_path;
        nexVideoClipItem.m_engineClipID = visualClip.engine_clip_id.intValue();
        nexVideoClipItem.m_abstractCrop = visualClip.abstract_crop.booleanValue();
        nexVideoClipItem.m_startPositionLeft = visualClip.start_position_left.intValue();
        nexVideoClipItem.m_startPositionTop = visualClip.start_position_top.intValue();
        nexVideoClipItem.m_startPositionRight = visualClip.start_position_right.intValue();
        nexVideoClipItem.m_startPositionBottom = visualClip.start_position_bottom.intValue();
        nexVideoClipItem.m_rotatedStartPositionLeft = visualClip.rotated_start_position_left.intValue();
        nexVideoClipItem.m_rotatedStartPositionTop = visualClip.rotated_start_position_top.intValue();
        nexVideoClipItem.m_rotatedStartPositionRight = visualClip.rotated_start_position_right.intValue();
        nexVideoClipItem.m_rotatedStartPositionBottom = visualClip.rotated_start_position_bottom.intValue();
        nexVideoClipItem.m_endPositionLeft = visualClip.end_position_left.intValue();
        nexVideoClipItem.m_endPositionTop = visualClip.end_position_top.intValue();
        nexVideoClipItem.m_endPositionRight = visualClip.end_position_right.intValue();
        nexVideoClipItem.m_endPositionBottom = visualClip.end_position_bottom.intValue();
        nexVideoClipItem.m_rotatedEndPositionLeft = visualClip.rotated_end_position_left.intValue();
        nexVideoClipItem.m_rotatedEndPositionTop = visualClip.rotated_end_position_top.intValue();
        nexVideoClipItem.m_rotatedEndPositionRight = visualClip.rotated_end_position_right.intValue();
        nexVideoClipItem.m_rotatedEndPositionBottom = visualClip.rotated_end_position_bottom.intValue();
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
        nexVideoClipItem.n = new UUID(visualClip.transition_item_uuid_msb.longValue(), visualClip.transition_item_uuid_lsb.longValue());
        nexVideoClipItem.m_Brightness = visualClip.brightness.intValue();
        nexVideoClipItem.m_Contrast = visualClip.contrast.intValue();
        nexVideoClipItem.m_Saturation = visualClip.saturation.intValue();
        nexVideoClipItem.m_TintColor = visualClip.tintcolor.intValue();
        nexVideoClipItem.m_effectStartTime = visualClip.effect_start_time.intValue();
        nexVideoClipItem.m_effectEndTime = visualClip.effect_end_time.intValue();
        nexVideoClipItem.m_startMatrix = com.nexstreaming.app.general.util.h.a(visualClip.start_matrix.element);
        nexVideoClipItem.m_endMatrix = com.nexstreaming.app.general.util.h.a(visualClip.end_matrix.element);
        nexVideoClipItem.m_playbackSpeed = visualClip.playback_speed.intValue();
        nexVideoClipItem.m_effectOptions = com.nexstreaming.kinemaster.c.a.a(visualClip.effect_options);
        nexVideoClipItem.m_muteAudio = visualClip.mute_audio.booleanValue();
        nexVideoClipItem.m_volumeEnvelopeTime = new ArrayList<>(visualClip.volume_envelope_time);
        nexVideoClipItem.m_volumeEnvelopeLevel = new ArrayList<>(visualClip.volume_envelope_level);
        nexVideoClipItem.m_clipWidth = visualClip.clip_width.floatValue();
        nexVideoClipItem.m_colorEffect = visualClip.color_effect == null ? null : ColorEffect.fromProtoBuf(visualClip.color_effect);
        nexVideoClipItem.m_mediaMSID = visualClip.media_msid != null ? new MSID(visualClip.media_msid) : null;
        nexVideoClipItem.m_titleEffectID = visualClip.title_effect_id;
        nexVideoClipItem.m_cropLink = visualClip.crop_link == null ? false : visualClip.crop_link.booleanValue();
        nexVideoClipItem.m_isReverse = visualClip.is_reverse == null ? false : visualClip.is_reverse.booleanValue();
        nexVideoClipItem.m_vignette = visualClip.vignette == null ? false : visualClip.vignette.booleanValue();
        nexVideoClipItem.m_voiceChanger = visualClip.voice_changer == null ? 0 : visualClip.voice_changer.intValue();
        nexVideoClipItem.m_audioPanLeft = visualClip.pan_left == null ? nexVideoClipItem.getAudioLeftVolume() : visualClip.pan_left.intValue();
        nexVideoClipItem.m_audioPanRight = visualClip.pan_right == null ? nexVideoClipItem.getAudioRightVolume() : visualClip.pan_right.intValue();
        nexVideoClipItem.m_audioCompressor = visualClip.compressor == null ? 0 : visualClip.compressor.intValue();
        nexVideoClipItem.m_pitchFactor = visualClip.pitch_factor != null ? visualClip.pitch_factor.intValue() : 0;
        if (visualClip.unattached_transition != null) {
            nexVideoClipItem.m_transition = NexTransitionItem.fromProtoBuf(visualClip.unattached_transition);
        }
        return nexVideoClipItem;
    }

    private KMProto.KMProject.Matrix a(float[] fArr) {
        KMProto.KMProject.Matrix.Builder builder = new KMProto.KMProject.Matrix.Builder();
        if (fArr == null) {
            fArr = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
        }
        if (fArr != null) {
            builder.element = new ArrayList();
            for (float f : fArr) {
                builder.element.add(Float.valueOf(f));
            }
        }
        return builder.build();
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean isClipReady() {
        return this.m_mediaMSID == null;
    }

    public void setEffectTiming(int i, int i2) {
        this.m_effectStartTime = i;
        this.m_effectEndTime = i2;
    }

    public int getEffectStartTime() {
        return this.m_effectStartTime;
    }

    public int getEffectEndTime() {
        return this.m_effectEndTime;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem.j
    public int getEffectDuration() {
        return Math.min(getRepresentedDuration(), this.m_effectEndTime - this.m_effectStartTime);
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem, com.nextreaming.nexeditorui.NexTimelineItem.j
    public Map<String, String> getEffectOptions() {
        if (this.m_effectOptions == null) {
            this.m_effectOptions = new HashMap<>();
        }
        return this.m_effectOptions;
    }

    private void a(StringBuilder sb, Map<String, String> map) {
        boolean z = true;
        try {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (z) {
                    z = false;
                } else {
                    sb.append('&');
                }
                sb.append(URLEncoder.encode(entry.getKey(), Keyczar.DEFAULT_ENCODING));
                sb.append('=');
                sb.append(URLEncoder.encode(entry.getValue(), Keyczar.DEFAULT_ENCODING));
                z = z;
            }
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException(e);
        }
    }

    public String getEncodedEffectOptions() {
        return getEncodedEffectOptions(true);
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

    public ResultTask<Bitmap> makeSingleThumbnail(int i, int i2) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        if (f()) {
            Bitmap createBitmap = Bitmap.createBitmap((i2 * 16) / 9, i2, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(getSolidColor());
            resultTask.sendResult(createBitmap);
        } else if (isImage()) {
            File file = new File(this.m_mediaPath);
            if (!file.exists()) {
                resultTask.sendFailure(Task.makeTaskError("File not found"));
                return resultTask;
            }
            new dn(this, file, i2, resultTask).executeOnExecutor(EditorGlobal.m, new Void[0]);
        } else {
            if (this.g == null) {
                this.g = this.m_mediaPath == null ? null : MediaInfo.a(new File(this.m_mediaPath));
            }
            if (this.g == null) {
                resultTask.sendFailure(Task.makeTaskError("Unable to get media info"));
                return resultTask;
            }
            this.g.a(this.g.w(), this.g.x(), i).onResultAvailable(new dp(this, resultTask)).onFailure((Task.OnFailListener) new Cdo(this, resultTask));
        }
        return resultTask;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getStartThumbnail(int i) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        if (f()) {
            Bitmap createBitmap = Bitmap.createBitmap((i * 16) / 9, i, Bitmap.Config.ARGB_8888);
            new Canvas(createBitmap).drawColor(getSolidColor());
            resultTask.sendResult(createBitmap);
        } else if (isImage()) {
            File file = new File(this.m_mediaPath);
            if (!file.exists()) {
                resultTask.sendFailure(Task.makeTaskError("File not found"));
                return resultTask;
            }
            new dc(this, file, i, resultTask).executeOnExecutor(EditorGlobal.m, new Void[0]);
        } else {
            if (this.g == null) {
                this.g = this.m_mediaPath == null ? null : MediaInfo.a(new File(this.m_mediaPath));
            }
            if (this.g == null) {
                resultTask.sendFailure(Task.makeTaskError("Unable to get media info"));
                return resultTask;
            }
            this.g.d().onResultAvailable(new de(this, resultTask)).onFailure((Task.OnFailListener) new dd(this, resultTask));
        }
        return resultTask;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getEndThumbnail(int i) {
        if (f() || isImage()) {
            return getStartThumbnail(i);
        }
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        if (this.g == null) {
            this.g = this.m_mediaPath == null ? null : MediaInfo.a(new File(this.m_mediaPath));
        }
        if (this.g == null) {
            resultTask.sendFailure(Task.makeTaskError("Unable to get media info"));
            return resultTask;
        }
        this.g.e().onResultAvailable(new dg(this, resultTask)).onFailure((Task.OnFailListener) new df(this, resultTask));
        return resultTask;
    }

    @Override // com.nextreaming.nexeditorui.NexPrimaryTimelineItem
    public ResultTask<Bitmap> getThumbnail(Context context) {
        ResultTask<Bitmap> resultTask = new ResultTask<>();
        Bitmap b2 = b(context);
        if (b2 != null) {
            File file = this.m_mediaPath == null ? null : new File(this.m_mediaPath);
            if (EditorGlobal.a(this.m_mediaPath) && file.exists()) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.m_mediaPath, options);
                Bitmap a2 = NexImageLoader.loadBitmap(this.m_mediaPath, (int) (320 * 2.5d), (int) (((options.outHeight * 320) / options.outWidth) * 2.5d)).a();
                if (a2 != null) {
                    Bitmap rotateAndFlipImage = NexImageLoader.rotateAndFlipImage(a2, (360 - this.m_rotation) % 360, this.m_fliph, this.m_flipv);
                    int i = (int) (320 / 1.7777778f);
                    Bitmap createBitmap = Bitmap.createBitmap(320, i, Bitmap.Config.RGB_565);
                    Rect rect = new Rect();
                    if (this.m_rotation == 90 || this.m_rotation == 270) {
                        rect.bottom = (this.m_rotatedStartPositionBottom * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                        rect.left = (this.m_rotatedStartPositionLeft * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.right = (this.m_rotatedStartPositionRight * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.top = (this.m_rotatedStartPositionTop * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                    } else {
                        rect.bottom = (this.m_startPositionBottom * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                        rect.left = (this.m_startPositionLeft * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.right = (this.m_startPositionRight * rotateAndFlipImage.getWidth()) / ABSTRACT_DIMENSION;
                        rect.top = (this.m_startPositionTop * rotateAndFlipImage.getHeight()) / ABSTRACT_DIMENSION;
                    }
                    new Canvas(createBitmap).drawBitmap(rotateAndFlipImage, rect, new Rect(0, 0, 320, i), (Paint) null);
                    resultTask.setResult(createBitmap);
                    resultTask.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
                    return resultTask;
                }
            }
            resultTask.setResult(b2);
            resultTask.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return resultTask;
        }
        if (this.g == null && !isImage() && !f()) {
            this.g = this.m_mediaPath == null ? null : MediaInfo.a(new File(this.m_mediaPath));
        }
        if (this.g != null) {
            this.g.d().onResultAvailable(new di(this, resultTask)).onFailure((Task.OnFailListener) new dh(this, resultTask));
            return resultTask;
        }
        resultTask.signalEvent(Task.Event.FAIL);
        return resultTask;
    }

    public Bitmap getSmallThumbnailForTime(int i, float f, float f2, Context context, NexTimelineItem.p pVar) {
        int i2;
        a(pVar);
        int absStartTime = (getAbsStartTime() - getStartOverlap()) - getTrimTimeStart();
        int absEndTime = getAbsEndTime() + getEndOverlap() + getTrimTimeEnd();
        if (i < absStartTime) {
            i2 = 0;
        } else if (i > absEndTime) {
            i2 = absEndTime - absStartTime;
        } else {
            i2 = i - absStartTime;
        }
        if (!this.f) {
            return ((BitmapDrawable) context.getResources().getDrawable(R.drawable.n2_missingfile_icon_small)).getBitmap();
        }
        Bitmap b2 = b(context);
        if (b2 != null) {
            return b2;
        }
        if (this.h != null) {
            return this.h.a(this.m_rotation, i2, this.m_fliph, this.m_flipv);
        }
        return null;
    }

    private Bitmap b(Context context) {
        return c(context);
    }

    private Bitmap c(Context context) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.timeline3_primaryTimelineHeight);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.timeline3_primaryMaxThumbWidth);
        Bitmap bitmap = null;
        if (this.e != null) {
            bitmap = this.e.get();
        }
        if (bitmap == null && getTimeline() != null) {
            bitmap = getTimeline().getThumbnailCache().get(getUniqueId());
        }
        if ((bitmap == null || Math.abs(dimensionPixelSize - bitmap.getHeight()) > 2) && EditorGlobal.a(this.m_mediaPath)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(this.m_mediaPath, options);
            options.inJustDecodeBounds = false;
            NexImageLoader.b loadBitmap = NexImageLoader.loadBitmap(this.m_mediaPath, Math.min(dimensionPixelSize2, (int) ((options.outWidth / options.outHeight) * dimensionPixelSize)) * 2, dimensionPixelSize * 2);
            bitmap = loadBitmap.a();
            this.m_originalWidth = loadBitmap.b();
            this.m_originalHeight = loadBitmap.c();
            if (bitmap != null) {
                bitmap = Bitmap.createScaledBitmap(bitmap, Math.min(dimensionPixelSize2, (int) ((bitmap.getWidth() / bitmap.getHeight()) * dimensionPixelSize)), dimensionPixelSize, true);
                if (getTimeline() != null) {
                    getTimeline().getThumbnailCache().put(getUniqueId(), bitmap);
                }
                this.e = new WeakReference<>(bitmap);
            }
        }
        return bitmap;
    }

    private Bitmap a(Bitmap bitmap) {
        if (this.m_rotation == 180) {
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
        if (this.m_rotation == 0) {
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
        if (this.m_rotation == 90) {
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
        if (this.m_rotation == 270) {
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
        return bitmap;
    }

    public int calcPos(int i, int i2, int i3) {
        if (i < i2) {
            return (((i2 - i) * i3) / 100) + i;
        }
        return i - (((i - i2) * i3) / 100);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public void addDependencies(Set<ProjectDependency> set) {
        if (this.m_titleEffectID != null && this.m_titleEffectID.length() > 0 && !this.m_titleEffectID.equals("none")) {
            set.add(ProjectDependency.b(this.m_titleEffectID));
        }
    }

    public int getFPS() {
        MediaInfo a2;
        if (isImage()) {
            return 0;
        }
        if (this.q == 0) {
            if (this.m_mediaPath == null || (a2 = MediaInfo.a(this.m_mediaPath)) == null) {
                return 30;
            }
            this.q = a2.B();
            if (this.q <= 0) {
                return 30;
            }
        }
        return this.q;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getAudioTrackUsage() {
        return (!getHasAudio() || getMuteAudio() || getClipVolume() <= 0) ? 0 : 1;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoTrackUsage() {
        return isVideo() ? 1 : 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public int getVideoCodecMemoryUsage() {
        if (isVideo()) {
            return ((((((getWidth() * getHeight()) * 150) / 100) * Math.max(30, getFPS())) / 30) * 100) / Math.max(100, getPlaybackSpeed());
        }
        return 0;
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public boolean getSwitchOption(int i) {
        return i == R.id.opt_vignette ? this.m_vignette : super.getSwitchOption(i);
    }

    @Override // com.nextreaming.nexeditorui.NexTimelineItem
    public Task setSwitchOption(int i, boolean z, Context context) {
        if (i == R.id.opt_vignette) {
            this.m_vignette = !this.m_vignette;
            return null;
        }
        return super.setSwitchOption(i, z, context);
    }
}
