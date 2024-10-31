package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaScannerConnection;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.facebook.GraphResponse;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1709m;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.kinemaster.editorwrapper.C1780za;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.project.TimelineResourceUsage;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.ColorEffect;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexAudioClipItem;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexeditorui.NexPrimaryTimelineItem;
import com.nextreaming.nexeditorui.NexSecondaryTimelineItem;
import com.nextreaming.nexeditorui.NexTimeline;
import com.nextreaming.nexeditorui.NexTimelineItem;
import com.nextreaming.nexeditorui.NexTransitionItem;
import com.nextreaming.nexeditorui.NexVideoClipItem;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.qq.e.comm.constants.ErrorCode;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class U {

    /* renamed from: a, reason: collision with root package name */
    private static U f23301a;

    /* renamed from: b, reason: collision with root package name */
    private final Context f23302b;

    /* renamed from: c, reason: collision with root package name */
    private final NexEditor f23303c;

    /* renamed from: g, reason: collision with root package name */
    private a f23307g;

    /* renamed from: h, reason: collision with root package name */
    private File f23308h;
    private NexExportProfile i;
    private PowerManager.WakeLock j;
    private int m;
    private long n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private InterfaceC2240y t;

    /* renamed from: d, reason: collision with root package name */
    private Handler f23304d = new Handler();

    /* renamed from: e, reason: collision with root package name */
    private boolean f23305e = false;

    /* renamed from: f, reason: collision with root package name */
    private VideoEditor f23306f = null;
    private boolean k = false;
    private boolean l = false;

    /* compiled from: ExportManager.java */
    /* loaded from: classes2.dex */
    public class a extends Task {

        /* renamed from: a, reason: collision with root package name */
        private final File f23309a;

        /* renamed from: b, reason: collision with root package name */
        private final NexExportProfile f23310b;

        /* synthetic */ a(U u, File file, NexExportProfile nexExportProfile, F f2) {
            this(file, nexExportProfile);
        }

        public File a() {
            return this.f23309a;
        }

        public NexExportProfile b() {
            return this.f23310b;
        }

        private a(File file, NexExportProfile nexExportProfile) {
            this.f23309a = file;
            this.f23310b = nexExportProfile;
        }
    }

    private U() {
        KineMasterApplication kineMasterApplication = KineMasterApplication.f24056d;
        this.f23302b = kineMasterApplication.getApplicationContext();
        this.f23303c = kineMasterApplication.r();
    }

    public static U b() {
        if (f23301a == null) {
            f23301a = new U();
        }
        return f23301a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        MediaScannerConnection.scanFile(this.f23302b, new String[]{this.f23308h.getAbsolutePath()}, null, new E(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        String str;
        int i;
        String str2;
        String name;
        NexTimeline nexTimeline;
        int i2;
        U u;
        String str3;
        U u2 = this;
        NexTimeline a2 = u2.f23306f.s().a();
        int primaryItemCount = a2.getPrimaryItemCount();
        int secondaryItemCount = a2.getSecondaryItemCount();
        Set<File> requiredFiles = a2.getRequiredFiles();
        Set<ProjectDependency> dependencies = a2.getDependencies();
        if (dependencies.isEmpty()) {
            u2.t.a("Dependencies: NONE", new String[0]);
        } else {
            u2.t.a("Dependencies: " + dependencies.size(), new String[0]);
            for (ProjectDependency projectDependency : dependencies) {
                u2.t.a("    " + projectDependency.a(u2.f23302b), new String[0]);
            }
        }
        if (requiredFiles.isEmpty()) {
            u2.t.a("Files: NONE", new String[0]);
        } else {
            u2.t.a("Files: " + requiredFiles.size(), new String[0]);
            for (File file : requiredFiles) {
                FileType fromFile = FileType.fromFile(file);
                u2.t.a("%s", "    " + fromFile.getCategory() + "(" + fromFile.name() + "):" + file.getAbsolutePath() + "\n" + com.nexstreaming.kinemaster.mediainfo.J.a(file).replace("\n", "\n        "));
            }
        }
        u2.t.a("Primary: " + primaryItemCount, new String[0]);
        int i3 = 0;
        while (true) {
            str = "\n            volume: ";
            if (i3 >= primaryItemCount) {
                break;
            }
            NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i3);
            int i4 = primaryItemCount;
            if (primaryItem instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                if (nexVideoClipItem.isPreset()) {
                    str3 = "Solid";
                } else if (nexVideoClipItem.isImage()) {
                    str3 = "Image";
                } else {
                    str3 = nexVideoClipItem.isVideo() ? "Video" : "Visual";
                }
                nexTimeline = a2;
                String str4 = str3;
                ColorEffect colorEffect = nexVideoClipItem.getColorEffect();
                i2 = secondaryItemCount;
                InterfaceC2240y interfaceC2240y = u2.t;
                String[] strArr = new String[1];
                StringBuilder sb = new StringBuilder();
                sb.append("  primary[");
                sb.append(i3);
                sb.append("] (");
                sb.append(primaryItem.getAbsStartTime());
                sb.append("~");
                sb.append(primaryItem.getAbsEndTime());
                sb.append("): ");
                sb.append(str4);
                sb.append("\n            path: ");
                sb.append(nexVideoClipItem.getMediaPath());
                sb.append("\n            trim:   ");
                sb.append(nexVideoClipItem.getTrimTimeStart());
                sb.append("/");
                sb.append(nexVideoClipItem.getTrimTimeEnd());
                sb.append("\n            volume: ");
                sb.append(nexVideoClipItem.getClipVolume());
                sb.append(nexVideoClipItem.getMuteAudio() ? " MUTED" : " APPLIED");
                sb.append("\n            effect: ");
                sb.append(String.valueOf(nexVideoClipItem.getEffectID()));
                sb.append("\n            colorfx: ");
                sb.append(colorEffect == null ? "null" : colorEffect.getPresetName());
                sb.append("\n            ready: ");
                sb.append(nexVideoClipItem.isReadyToPlay());
                sb.append("\n            fps: ");
                sb.append(nexVideoClipItem.getFPS());
                sb.append("\n            speed: ");
                sb.append(nexVideoClipItem.getPlaybackSpeed());
                sb.append("\n            vcmu: ");
                sb.append(nexVideoClipItem.getVideoCodecLegacyMemoryUsage());
                sb.append("\n");
                strArr[0] = sb.toString();
                interfaceC2240y.a("%s", strArr);
                u = this;
            } else {
                nexTimeline = a2;
                i2 = secondaryItemCount;
                if (primaryItem instanceof NexTransitionItem) {
                    NexTransitionItem nexTransitionItem = (NexTransitionItem) primaryItem;
                    u = this;
                    u.t.a("  primary[" + i3 + "] (" + primaryItem.getAbsStartTime() + "~" + primaryItem.getAbsEndTime() + "): Transition\n            duration: " + nexTransitionItem.getDuration() + "\n            effect:   " + nexTransitionItem.getTransitionEffectID() + "\n            overlap: " + nexTransitionItem.getStartOverlap() + "/" + nexTransitionItem.getEndOverlap(), new String[0]);
                } else {
                    u = this;
                    u.t.a("  primary[" + i3 + "] (" + primaryItem.getAbsStartTime() + "~" + primaryItem.getAbsEndTime() + "): " + primaryItem.getClass().getName(), new String[0]);
                }
            }
            i3++;
            u2 = u;
            primaryItemCount = i4;
            a2 = nexTimeline;
            secondaryItemCount = i2;
        }
        NexTimeline nexTimeline2 = a2;
        U u3 = u2;
        InterfaceC2240y interfaceC2240y2 = u3.t;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Secondary: ");
        int i5 = secondaryItemCount;
        sb2.append(i5);
        interfaceC2240y2.a(sb2.toString(), new String[0]);
        int i6 = 0;
        while (i6 < i5) {
            NexTimeline nexTimeline3 = nexTimeline2;
            NexSecondaryTimelineItem secondaryItem = nexTimeline3.getSecondaryItem(i6);
            if (secondaryItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                nexTimeline2 = nexTimeline3;
                InterfaceC2240y interfaceC2240y3 = u3.t;
                i = i5;
                StringBuilder sb3 = new StringBuilder();
                sb3.append("  secondary[");
                sb3.append(i6);
                sb3.append("] (");
                sb3.append(secondaryItem.getAbsStartTime());
                sb3.append("~");
                sb3.append(secondaryItem.getAbsEndTime());
                sb3.append("): Audio \n            path: ");
                sb3.append(nexAudioClipItem.getMediaPath());
                sb3.append("\n            trim:   ");
                sb3.append(nexAudioClipItem.getStartTrim());
                sb3.append("/");
                sb3.append(nexAudioClipItem.getEndTrim());
                sb3.append(str);
                sb3.append(nexAudioClipItem.getClipVolume());
                sb3.append(nexAudioClipItem.getMuteAudio() ? " MUTED" : " APPLIED");
                sb3.append("\n            type: ");
                sb3.append(nexAudioClipItem.getAudioType().name());
                sb3.append("\n            opath: ");
                sb3.append(nexAudioClipItem.getOriginalMediaPath());
                sb3.append("\n            ready: ");
                sb3.append(nexAudioClipItem.isReadyToPlay());
                sb3.append("\n            loop: ");
                sb3.append(nexAudioClipItem.isLoop());
                sb3.append("\n            extend: ");
                sb3.append(nexAudioClipItem.isExtendToEnd());
                sb3.append("\n            pinned: ");
                sb3.append(nexAudioClipItem.getPinned());
                sb3.append("\n            vcmu: ");
                sb3.append(nexAudioClipItem.getVideoCodecLegacyMemoryUsage());
                interfaceC2240y3.a(sb3.toString(), new String[0]);
            } else {
                nexTimeline2 = nexTimeline3;
                i = i5;
                if (secondaryItem instanceof VideoLayer) {
                    VideoLayer videoLayer = (VideoLayer) secondaryItem;
                    InterfaceC2240y interfaceC2240y4 = u3.t;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("  secondary[");
                    sb4.append(i6);
                    sb4.append("] (");
                    sb4.append(secondaryItem.getAbsStartTime());
                    sb4.append("~");
                    sb4.append(secondaryItem.getAbsEndTime());
                    sb4.append("): Video Layer \n            path: ");
                    sb4.append(videoLayer.getMediaPath());
                    sb4.append("\n            trim:   ");
                    sb4.append(videoLayer.getStartTrim());
                    sb4.append("/");
                    sb4.append(videoLayer.getEndTrim());
                    sb4.append(str);
                    sb4.append(videoLayer.getClipVolume());
                    sb4.append(videoLayer.getMuteAudio() ? " MUTED" : " APPLIED");
                    sb4.append("\n            fps: ");
                    sb4.append(videoLayer.getFPS());
                    sb4.append("\n            speed: ");
                    sb4.append(videoLayer.getPlaybackSpeed());
                    sb4.append("\n            ready: ");
                    sb4.append(videoLayer.isReadyToPlay());
                    sb4.append("\n            pinned: ");
                    sb4.append(videoLayer.getPinned());
                    sb4.append("\n            vcmu: ");
                    sb4.append(videoLayer.getVideoCodecLegacyMemoryUsage());
                    interfaceC2240y4.a(sb4.toString(), new String[0]);
                } else if (secondaryItem instanceof ImageLayer) {
                    ImageLayer imageLayer = (ImageLayer) secondaryItem;
                    u3.t.a("  secondary[" + i6 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): Video Layer \n            path: " + imageLayer.getMediaPath() + "\n            ready: " + imageLayer.isReadyToPlay() + "\n            pinned: " + imageLayer.getPinned() + "\n            vcmu: " + imageLayer.getVideoCodecLegacyMemoryUsage(), new String[0]);
                } else if (secondaryItem instanceof NexLayerItem) {
                    NexLayerItem nexLayerItem = (NexLayerItem) secondaryItem;
                    if (secondaryItem instanceof TextLayer) {
                        name = "Text";
                    } else if (secondaryItem instanceof HandwritingLayer) {
                        name = "Handwriting";
                    } else {
                        name = secondaryItem instanceof StickerLayer ? "Sticker" : secondaryItem.getClass().getName();
                    }
                    str2 = str;
                    u3.t.a("  secondary[" + i6 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): " + name + " Layer \n            trim:   " + nexLayerItem.getStartTrim() + "/" + nexLayerItem.getEndTrim() + "\n            ready: " + nexLayerItem.isReadyToPlay() + "\n            pinned: " + nexLayerItem.getPinned() + "\n            vcmu: " + nexLayerItem.getVideoCodecLegacyMemoryUsage(), new String[0]);
                    i6++;
                    str = str2;
                    i5 = i;
                } else {
                    str2 = str;
                    u3.t.a("  secondary[" + i6 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): " + secondaryItem.getClass().getName(), new String[0]);
                    i6++;
                    str = str2;
                    i5 = i;
                }
            }
            str2 = str;
            i6++;
            str = str2;
            i5 = i;
        }
    }

    private void f() {
        this.t.a("(finishing up)", new String[0]);
        if (this.f23305e) {
            this.f23305e = false;
            this.f23308h = null;
            this.i = null;
            if (this.f23307g.isRunning()) {
                this.f23307g.sendFailure(Task.makeTaskError("bad state"));
            }
            if (this.f23306f.w() != VideoEditor.State.Idle) {
                this.f23306f.M();
            }
            this.f23307g = null;
            this.f23306f = null;
            this.j.release();
            this.j = null;
            this.l = false;
            this.k = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        C1780za s;
        NexTimeline a2;
        this.t.a("Export cancelled by user", new String[0]);
        long nanoTime = (System.nanoTime() - this.n) / 1000000;
        VideoEditor videoEditor = this.f23306f;
        if (videoEditor != null && (s = videoEditor.s()) != null && (a2 = s.a()) != null) {
            a2.getTotalTime();
        }
        SupportLogger.Event.Export_SignalCancel.log(new int[0]);
        if (this.f23305e && this.k) {
            this.f23307g.signalEvent(Task.Event.CANCEL);
            a("Cancel", (String) null);
            HashMap hashMap = new HashMap();
            hashMap.put("result", "cancel");
            hashMap.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, "cancel");
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put("model", Build.MODEL);
            KMEvents.EXPORT_RESULT.logEvent(hashMap);
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        this.t.a("Export success!", new String[0]);
        Context context = this.f23302b;
        if (context != null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            defaultSharedPreferences.edit().putInt("rate_export_success_count", defaultSharedPreferences.getInt("rate_export_success_count", 0) + 1).apply();
        }
        long nanoTime = (System.nanoTime() - this.n) / 1000000;
        SupportLogger.Event.Export_SignalSuccess.log(new int[0]);
        if (this.f23305e) {
            a("Success", (String) null);
            HashMap hashMap = new HashMap();
            hashMap.put("result", GraphResponse.SUCCESS_KEY);
            hashMap.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, GraphResponse.SUCCESS_KEY);
            hashMap.put("manufacturer", Build.MANUFACTURER);
            hashMap.put("model", Build.MODEL);
            KMEvents.EXPORT_RESULT.logEvent(hashMap);
            this.f23307g.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            f();
        }
    }

    public boolean c() {
        return this.f23305e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(Task.TaskError taskError) {
        C1780za s;
        NexTimeline a2;
        int i;
        int i2;
        int i3;
        a(taskError);
        this.t.a("Export failure: " + taskError.getMessage(), new String[0]);
        if (this.f23305e) {
            VideoEditor videoEditor = this.f23306f;
            if (videoEditor != null && (s = videoEditor.s()) != null && (a2 = s.a()) != null) {
                ArrayList<NexTimelineItem> arrayList = new ArrayList();
                a2.getTotalTime();
                int primaryItemCount = a2.getPrimaryItemCount();
                for (int i4 = 0; i4 < primaryItemCount; i4++) {
                    NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i4);
                    int absStartTime = primaryItem.getAbsStartTime();
                    int i5 = this.o;
                    if (absStartTime > i5 - 1600 && absStartTime < i5 + 500) {
                        arrayList.add(primaryItem);
                    }
                }
                int secondaryItemCount = a2.getSecondaryItemCount();
                for (int i6 = 0; i6 < secondaryItemCount; i6++) {
                    NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i6);
                    int absStartTime2 = secondaryItem.getAbsStartTime();
                    int i7 = this.o;
                    if (absStartTime2 > i7 - 1600 && absStartTime2 < i7 + 500) {
                        arrayList.add(secondaryItem);
                    }
                }
                for (NexTimelineItem nexTimelineItem : arrayList) {
                    if (nexTimelineItem instanceof NexVideoClipItem) {
                        NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) nexTimelineItem;
                        if (nexVideoClipItem.isVideo()) {
                            i = 105;
                        } else if (nexVideoClipItem.isPreset()) {
                            i = 106;
                        } else {
                            i = nexVideoClipItem.isImage() ? 107 : 108;
                        }
                        i3 = nexVideoClipItem.getWidth();
                        i2 = nexVideoClipItem.getHeight();
                    } else {
                        if (nexTimelineItem instanceof NexTransitionItem) {
                            i = ((NexTransitionItem) nexTimelineItem).getEngineDuration() <= 0 ? 200 : 201;
                        } else if (nexTimelineItem instanceof NexAudioClipItem) {
                            i = 300;
                        } else if (nexTimelineItem instanceof TextLayer) {
                            i = 400;
                        } else if (nexTimelineItem instanceof ImageLayer) {
                            i = ErrorCode.NetWorkError.QUEUE_FULL_ERROR;
                        } else if (nexTimelineItem instanceof VideoLayer) {
                            i = ErrorCode.NetWorkError.RETRY_TIME_NATIVE_ERROR;
                        } else if (nexTimelineItem instanceof HandwritingLayer) {
                            i = ErrorCode.NetWorkError.HTTP_STATUS_ERROR;
                        } else if (nexTimelineItem instanceof StickerLayer) {
                            i = 404;
                        } else if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
                            i = 501;
                        } else if (nexTimelineItem instanceof NexLayerItem) {
                            i = ErrorCode.AdError.JSON_PARSE_ERROR;
                        } else {
                            i = nexTimelineItem instanceof NexSecondaryTimelineItem ? ErrorCode.AdError.DETAIl_URL_ERROR : 600;
                        }
                        i2 = 0;
                        i3 = 0;
                    }
                    if (i3 == 0 && i2 == 0) {
                        this.t.a("Suspicious Item: " + i, new String[0]);
                        SupportLogger.Event.Export_PossibleFailItem.log(i);
                    } else {
                        this.t.a("Suspicious Item: " + i + "," + i3 + FragmentC2201x.f23219a + i2, new String[0]);
                        SupportLogger.Event.Export_PossibleFailItem.log(i, i3, i2);
                    }
                }
            }
            if (taskError instanceof DiagnosticLogger.a) {
                int intErrorCode = ((DiagnosticLogger.a) taskError).getIntErrorCode();
                SupportLogger.Event.Export_SignalFail.log(intErrorCode, this.o, this.p);
                HashMap hashMap = new HashMap();
                hashMap.put("result", "fail");
                hashMap.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, "" + intErrorCode);
                hashMap.put("manufacturer", Build.MANUFACTURER);
                hashMap.put("model", Build.MODEL);
                KMEvents.EXPORT_RESULT.logEvent(hashMap);
            } else {
                SupportLogger.Event.Export_SignalFail.log(new int[0]);
                HashMap hashMap2 = new HashMap();
                hashMap2.put("result", "fail");
                hashMap2.put(NativeProtocol.BRIDGE_ARG_ERROR_CODE, "unknown_err");
                hashMap2.put("manufacturer", Build.MANUFACTURER);
                hashMap2.put("model", Build.MODEL);
                KMEvents.EXPORT_RESULT.logEvent(hashMap2);
            }
            this.f23307g.sendFailure(taskError);
            f();
        }
    }

    public void a() {
        if (this.f23305e && !this.k) {
            this.k = true;
            if (this.f23306f.w() == VideoEditor.State.Exporting || this.l) {
                this.f23303c.a(new F(this));
            }
        }
    }

    public a a(File file, File file2, NexExportProfile nexExportProfile, boolean z, String str, boolean z2, int i, int i2, int i3) {
        String str2;
        if (EditorGlobal.u()) {
            this.t = C.a(new File(file.getParentFile(), com.nexstreaming.kinemaster.project.k.d(com.nexstreaming.kinemaster.project.k.b(file.getName())) + ".export.log"));
        } else {
            this.t = C.a();
        }
        SupportLogger.Event.Export_In.log(nexExportProfile.width(), nexExportProfile.height(), nexExportProfile.bitrate());
        a aVar = new a(this, file2, nexExportProfile, null);
        if (this.f23305e) {
            SupportLogger.Event.Export_Fail.log(1);
            this.t.a("Error: ALREADY_EXPORTING", new String[0]);
            aVar.sendFailure(NexEditor.b.gb);
            return aVar;
        }
        if (file2.exists() && !z) {
            SupportLogger.Event.Export_Fail.log(2);
            this.t.a("Error: DESTINATION_FILE_ALREADY_EXISTS", new String[0]);
            aVar.sendFailure(NexEditor.b.Ya);
            return aVar;
        }
        if (this.t.a()) {
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            String replace = deviceProfile.getMatchInfo() == null ? "NULL" : deviceProfile.getMatchInfo().a().replace("\n", "          \n");
            this.t.a("==================== BEGIN EXPORT ====================\nProject File: " + file.getAbsolutePath() + "\nOutput File: " + file2.getAbsolutePath() + "\nResolution: " + nexExportProfile.width() + FragmentC2201x.f23219a + nexExportProfile.height() + "\nBitrate: " + nexExportProfile.bitrate() + "\nPCS: " + z2 + "\nNEDP/Source: " + deviceProfile.getProfileSource() + "\nNEDP/Match/" + replace + "\nDevice Info:\n     model: " + Build.MODEL + "\n     product: " + Build.PRODUCT + "\n     device: " + Build.DEVICE + "\n     manufacturer: " + Build.MANUFACTURER + "\n     hardware: " + Build.HARDWARE + "\n     board: " + Build.BOARD + "\n     board_platform: " + KineMasterApplication.j() + "\n     sdk_level: " + Build.VERSION.SDK_INT, new String[0]);
        }
        this.f23305e = true;
        this.k = false;
        this.l = false;
        this.f23307g = aVar;
        this.s = i2;
        this.f23308h = file2;
        this.i = nexExportProfile;
        this.q = i;
        this.r = i3;
        this.f23306f = new VideoEditor(this.f23303c, this.f23302b, true, null);
        if (str != null) {
            str2 = str;
        } else if (EditorGlobal.f24026e == EditorGlobal.VersionType.ShowDemo && EditorGlobal.f24026e == EditorGlobal.VersionType.TeamEval) {
            this.f23303c.b(false);
            str2 = EditorGlobal.a("up");
        } else {
            this.f23303c.b(true);
            str2 = EditorGlobal.a("std");
        }
        this.j = ((PowerManager) this.f23302b.getSystemService("power")).newWakeLock(1, "KineMasterExport");
        this.j.setReferenceCounted(false);
        this.j.acquire();
        EditorGlobal.d(this.f23302b);
        this.f23306f.b(str2);
        this.m = -1;
        SupportLogger.Event.Export_Prep.log(new int[0]);
        this.f23306f.a(file).onComplete(new J(this, z2)).onFailure(new G(this));
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2) {
        this.t.a("Export progress: " + i + "/" + i2, new String[0]);
        if (this.f23305e) {
            this.o = i;
            this.p = i2;
            int i3 = -1;
            if (i == 0) {
                i3 = 0;
            } else if (i == i2) {
                i3 = 100;
            } else if (i > (i2 * 3) / 4) {
                i3 = 75;
            } else if (i > (i2 * 2) / 4) {
                i3 = 50;
            } else if (i > (i2 * 1) / 4) {
                i3 = 25;
            } else if (i > 0) {
                i3 = 1;
            }
            if (i3 > this.m) {
                this.m = i3;
                SupportLogger.Event.Export_Progress.log(i3);
            }
            this.f23307g.setProgress(i, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Task a(File file, int i, int i2) {
        Task task = new Task();
        a(task, file, i, i2);
        return task;
    }

    private void a(Task task, File file, int i, int i2) {
        if (this.k) {
            g();
            return;
        }
        this.t.a("Send export request to engine", new String[0]);
        NexExportProfile nexExportProfile = this.i;
        if (EditorGlobal.l() == 0.5625f) {
            nexExportProfile = this.i.toRatio9v16();
        } else if (EditorGlobal.l() == 1.0f) {
            nexExportProfile = this.i.toRatio1v1();
        }
        if (i < i2) {
            nexExportProfile = this.i.mutableCopy();
            nexExportProfile.setBitrate((nexExportProfile.bitrate() * 15) / 10);
        }
        VideoEditor.a m = this.f23306f.m();
        m.a(file);
        m.a(nexExportProfile);
        m.b(this.q);
        int i3 = this.r;
        if (i3 > 0) {
            m.a(i3);
        }
        m.a().onProgress(new N(this, i, i2)).onComplete(new M(this, task)).onFailure(new L(this)).onCancel(new K(this));
        this.l = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        this.t.a(">> START EXPORT TASK <<", new String[0]);
        SupportLogger.Event.Export_Start.log(new int[0]);
        if (this.k) {
            g();
            return;
        }
        VideoEditor videoEditor = this.f23306f;
        if (videoEditor != null && videoEditor.s() != null) {
            this.n = System.nanoTime();
            NexTimeline a2 = this.f23306f.s().a();
            int maxDecoderMemorySize = NexEditorDeviceProfile.getDeviceProfile().getMaxDecoderMemorySize(false, this.i.width(), this.i.height(), EditorGlobal.i().b());
            Iterator<? extends TimelineResourceUsage.b> it = a2.getResourceUsage().b().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                if (it.next().b() > maxDecoderMemorySize && (a2.getPrimaryItemCount() + 1) / 2 > 1) {
                    z2 = true;
                }
            }
            int max = Math.max(1, (((a2.getTotalTime() / 1000) * (this.i.bitrate() / 1024)) / 1024) / 8);
            if (z2) {
                max = (max * 25) / 10;
            }
            if (!C1709m.a(this.f23308h, max * 1024 * 1024, 10485760L)) {
                b(NexEditor.b.X);
                return;
            }
            if (a2.getTotalTime() < 1) {
                b(NexEditor.b.hb);
                return;
            }
            if (!a2.checkResources(this.f23302b)) {
                a("Missing resources", (String) null);
            }
            if (!a2.checkReadyToPlay()) {
                b(NexEditor.b.db);
                return;
            }
            if (this.f23308h.exists()) {
                SupportLogger.Event.Export_RemoveOutOutputFile.log(new int[0]);
                this.f23308h.delete();
            }
            File file = new File(this.f23308h.getAbsolutePath() + ".tmp");
            if (z2) {
                this.f23306f.a(VideoEditor.ExportPass.Primary).onComplete(new S(this, new File(this.f23308h.getAbsolutePath() + ".p1.tmp"), file));
                return;
            }
            a(file, 1, 1).onComplete(new T(this, file));
            return;
        }
        g();
    }

    private void a(Task.TaskError taskError) {
        if (taskError != null) {
            if (taskError.equals(NexEditor.b.kb)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Project load failed");
                return;
            }
            if (taskError.equals(NexEditor.b.nb)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Dummy Error");
                return;
            }
            if (taskError.equals(NexEditor.b.db)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Not ready to play");
                return;
            }
            if (taskError.equals(NexEditor.b.lb)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Rename failed");
                return;
            }
            if (taskError.equals(NexEditor.b.y)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Codec init failed");
                return;
            }
            if (!taskError.equals(NexEditor.b.sa) && !taskError.equals(NexEditor.b.qa) && !taskError.equals(NexEditor.b.ra)) {
                if (taskError.equals(NexEditor.b.hb)) {
                    a("Empty project", (String) null);
                    return;
                }
                if (taskError.equals(NexEditor.b.ib)) {
                    a("Missing resources", (String) null);
                    return;
                }
                if (taskError.equals(NexEditor.b.X)) {
                    a("No space", (String) null);
                    return;
                } else if (!TextUtils.isEmpty(taskError.getMessage())) {
                    a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, taskError.getMessage());
                    return;
                } else {
                    a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Unknown error");
                    return;
                }
            }
            a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Decoder init failed");
            return;
        }
        a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Unknown error");
    }

    private void a(String str, String str2) {
        NexTimeline nexTimeline;
        C1780za s;
        int nanoTime = (int) ((System.nanoTime() - this.n) / 1000000);
        VideoEditor videoEditor = this.f23306f;
        if (videoEditor == null || (s = videoEditor.s()) == null) {
            nexTimeline = null;
        } else {
            nexTimeline = s.a();
            if (nexTimeline != null && nexTimeline.getTotalTime() != 0) {
                nexTimeline.getTotalTime();
            }
        }
        KMEvents.SHARE_EXPORT_VIDEO.trackExport(nexTimeline, this.i, this.f23308h, str, str2, nanoTime);
    }
}
