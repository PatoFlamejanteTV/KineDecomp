package com.nexstreaming.kinemaster.ui.share;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.GraphResponse;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.DiagnosticLogger;
import com.nexstreaming.app.general.util.FileType;
import com.nexstreaming.app.general.util.SupportLogger;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.editorwrapper.NexLayerItem;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nexstreaming.kinemaster.layer.HandwritingLayer;
import com.nexstreaming.kinemaster.layer.ImageLayer;
import com.nexstreaming.kinemaster.layer.StickerLayer;
import com.nexstreaming.kinemaster.layer.TextLayer;
import com.nexstreaming.kinemaster.layer.VideoLayer;
import com.nexstreaming.kinemaster.project.ProjectDependency;
import com.nexstreaming.kinemaster.usage.KMUsage;
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
import com.xiaomi.licensinglibrary.LicenseErrCode;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
public class k {

    /* renamed from: a */
    private static k f4354a;
    private final Context b;
    private final NexEditor c;
    private a g;
    private File h;
    private NexExportProfile i;
    private PowerManager.WakeLock j;
    private int m;
    private long n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private f t;
    private Handler d = new Handler();
    private boolean e = false;
    private VideoEditor f = null;
    private boolean k = false;
    private boolean l = false;

    private k() {
        KineMasterApplication a2 = KineMasterApplication.a();
        this.b = a2.getApplicationContext();
        this.c = a2.h();
    }

    public static k a() {
        if (f4354a == null) {
            f4354a = new k();
        }
        return f4354a;
    }

    public boolean b() {
        return this.e;
    }

    public void c() {
        if (this.e && !this.k) {
            this.k = true;
            if (this.f.t() == VideoEditor.State.Exporting || this.l) {
                this.c.a(new l(this));
            }
        }
    }

    /* compiled from: ExportManager.java */
    /* loaded from: classes.dex */
    public class a extends Task {
        private final File b;
        private final NexExportProfile c;

        /* synthetic */ a(k kVar, File file, NexExportProfile nexExportProfile, l lVar) {
            this(file, nexExportProfile);
        }

        private a(File file, NexExportProfile nexExportProfile) {
            this.b = file;
            this.c = nexExportProfile;
        }

        public File a() {
            return this.b;
        }

        public NexExportProfile b() {
            return this.c;
        }
    }

    public a a(File file, File file2, NexExportProfile nexExportProfile, boolean z, String str, boolean z2, int i, int i2, int i3) {
        if (EditorGlobal.n()) {
            this.t = g.a(new File(file.getParentFile(), com.nexstreaming.kinemaster.project.f.e(com.nexstreaming.kinemaster.project.f.f(file.getName())) + ".export.log"));
        } else {
            this.t = g.a();
        }
        SupportLogger.Event.Export_In.log(nexExportProfile.width(), nexExportProfile.height(), nexExportProfile.bitrate());
        a aVar = new a(this, file2, nexExportProfile, null);
        if (this.e) {
            SupportLogger.Event.Export_Fail.log(1);
            this.t.a("Error: ALREADY_EXPORTING", new String[0]);
            aVar.sendFailure(NexEditor.b.bg);
            return aVar;
        }
        if (file2.exists() && !z) {
            SupportLogger.Event.Export_Fail.log(2);
            this.t.a("Error: DESTINATION_FILE_ALREADY_EXISTS", new String[0]);
            aVar.sendFailure(NexEditor.b.aX);
            return aVar;
        }
        if (this.t.a()) {
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            f fVar = this.t;
            StringBuilder append = new StringBuilder().append("==================== BEGIN EXPORT ====================\nProject File: ").append(file.getAbsolutePath()).append("\n").append("Output File: ").append(file2.getAbsolutePath()).append("\n").append("Resolution: ").append(nexExportProfile.width()).append("x").append(nexExportProfile.height()).append("\n").append("Bitrate: ").append(nexExportProfile.bitrate()).append("\n").append("PCS: ").append(z2).append("\n").append("NEDP/Source: ").append(deviceProfile.getProfileSource()).append("\n").append("NEDP/Match/").append(deviceProfile.getMatchInfo().a().replace("\n", "          \n")).append("\n").append("Device Info:\n").append("     model: ").append(Build.MODEL).append("\n").append("     product: ").append(Build.PRODUCT).append("\n").append("     device: ").append(Build.DEVICE).append("\n").append("     manufacturer: ").append(Build.MANUFACTURER).append("\n").append("     hardware: ").append(Build.HARDWARE).append("\n").append("     board: ").append(Build.BOARD).append("\n").append("     board_platform: ");
            KineMasterApplication.a();
            fVar.a(append.append(KineMasterApplication.b()).append("\n").append("     sdk_level: ").append("").append(Build.VERSION.SDK_INT).toString(), new String[0]);
        }
        this.e = true;
        this.k = false;
        this.l = false;
        this.g = aVar;
        this.s = i2;
        this.h = file2;
        this.i = nexExportProfile;
        this.q = i;
        this.r = i3;
        this.f = new VideoEditor(this.c, this.b, true, null);
        if (str == null) {
            if (EditorGlobal.f == EditorGlobal.VersionType.ShowDemo) {
                this.c.a(false);
                str = EditorGlobal.c("up");
            } else {
                this.c.a(true);
                str = EditorGlobal.c("std");
            }
        }
        this.j = ((PowerManager) this.b.getSystemService("power")).newWakeLock(1, "KineMasterExport");
        this.j.setReferenceCounted(false);
        this.j.acquire();
        EditorGlobal.e(this.b);
        this.f.a(str);
        this.m = -1;
        SupportLogger.Event.Export_Prep.log(new int[0]);
        this.f.b(file).onComplete(new n(this, z2)).onFailure(new m(this));
        return aVar;
    }

    public void d() {
        String name;
        String str;
        NexTimeline a2 = this.f.f().a();
        int primaryItemCount = a2.getPrimaryItemCount();
        int secondaryItemCount = a2.getSecondaryItemCount();
        Set<File> requiredFiles = a2.getRequiredFiles();
        Set<ProjectDependency> dependencies = a2.getDependencies();
        if (dependencies.isEmpty()) {
            this.t.a("Dependencies: NONE", new String[0]);
        } else {
            this.t.a("Dependencies: " + dependencies.size(), new String[0]);
            Iterator<ProjectDependency> it = dependencies.iterator();
            while (it.hasNext()) {
                this.t.a("    " + it.next().a(this.b), new String[0]);
            }
        }
        if (requiredFiles.isEmpty()) {
            this.t.a("Files: NONE", new String[0]);
        } else {
            this.t.a("Files: " + requiredFiles.size(), new String[0]);
            for (File file : requiredFiles) {
                FileType fromFile = FileType.fromFile(file);
                this.t.a("    " + fromFile.getCategory() + "(" + fromFile.name() + "):" + file.getAbsolutePath() + "\n" + com.nexstreaming.kinemaster.mediainfo.ad.a(file).replace("\n", "\n        "), new String[0]);
            }
        }
        this.t.a("Primary: " + primaryItemCount, new String[0]);
        for (int i = 0; i < primaryItemCount; i++) {
            NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i);
            if (primaryItem instanceof NexVideoClipItem) {
                NexVideoClipItem nexVideoClipItem = (NexVideoClipItem) primaryItem;
                if (nexVideoClipItem.isPreset()) {
                    str = "Solid";
                } else if (nexVideoClipItem.isImage()) {
                    str = "Image";
                } else if (nexVideoClipItem.isVideo()) {
                    str = "Video";
                } else {
                    str = "Visual";
                }
                ColorEffect colorEffect = nexVideoClipItem.getColorEffect();
                this.t.a("  primary[" + i + "] (" + primaryItem.getAbsStartTime() + "~" + primaryItem.getAbsEndTime() + "): " + str + "\n            path: " + nexVideoClipItem.getMediaPath() + "\n            trim:   " + nexVideoClipItem.getTrimTimeStart() + "/" + nexVideoClipItem.getTrimTimeEnd() + "\n            volume: " + nexVideoClipItem.getClipVolume() + (nexVideoClipItem.getMuteAudio() ? " MUTED" : " APPLIED") + "\n            effect: " + String.valueOf(nexVideoClipItem.getEffectID()) + "\n            colorfx: " + (colorEffect == null ? "null" : colorEffect.getPresetName()) + "\n            ready: " + nexVideoClipItem.isReadyToPlay() + "\n            fps: " + nexVideoClipItem.getFPS() + "\n            speed: " + nexVideoClipItem.getPlaybackSpeed() + "\n            vcmu: " + nexVideoClipItem.getVideoCodecMemoryUsage() + "\n", new String[0]);
            } else if (primaryItem instanceof NexTransitionItem) {
                NexTransitionItem nexTransitionItem = (NexTransitionItem) primaryItem;
                this.t.a("  primary[" + i + "] (" + primaryItem.getAbsStartTime() + "~" + primaryItem.getAbsEndTime() + "): Transition\n            duration: " + nexTransitionItem.getDuration() + "\n            effect:   " + nexTransitionItem.getTransitionEffectID() + "\n            overlap: " + nexTransitionItem.getStartOverlap() + "/" + nexTransitionItem.getEndOverlap(), new String[0]);
            } else {
                this.t.a("  primary[" + i + "] (" + primaryItem.getAbsStartTime() + "~" + primaryItem.getAbsEndTime() + "): " + primaryItem.getClass().getName(), new String[0]);
            }
        }
        this.t.a("Secondary: " + secondaryItemCount, new String[0]);
        for (int i2 = 0; i2 < secondaryItemCount; i2++) {
            NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i2);
            if (secondaryItem instanceof NexAudioClipItem) {
                NexAudioClipItem nexAudioClipItem = (NexAudioClipItem) secondaryItem;
                this.t.a("  secondary[" + i2 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): Audio \n            path: " + nexAudioClipItem.getMediaPath() + "\n            trim:   " + nexAudioClipItem.getStartTrim() + "/" + nexAudioClipItem.getEndTrim() + "\n            volume: " + nexAudioClipItem.getClipVolume() + (nexAudioClipItem.getMuteAudio() ? " MUTED" : " APPLIED") + "\n            type: " + nexAudioClipItem.getAudioType().name() + "\n            opath: " + nexAudioClipItem.getOriginalMediaPath() + "\n            ready: " + nexAudioClipItem.isReadyToPlay() + "\n            loop: " + nexAudioClipItem.isLoop() + "\n            extend: " + nexAudioClipItem.isExtendToEnd() + "\n            pinned: " + nexAudioClipItem.getPinned() + "\n            vcmu: " + nexAudioClipItem.getVideoCodecMemoryUsage(), new String[0]);
            } else if (secondaryItem instanceof VideoLayer) {
                VideoLayer videoLayer = (VideoLayer) secondaryItem;
                this.t.a("  secondary[" + i2 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): Video Layer \n            path: " + videoLayer.getMediaPath() + "\n            trim:   " + videoLayer.getStartTrim() + "/" + videoLayer.getEndTrim() + "\n            volume: " + videoLayer.getClipVolume() + (videoLayer.getMuteAudio() ? " MUTED" : " APPLIED") + "\n            fps: " + videoLayer.getFPS() + "\n            speed: " + videoLayer.getPlaybackSpeed() + "\n            ready: " + videoLayer.isReadyToPlay() + "\n            pinned: " + videoLayer.getPinned() + "\n            vcmu: " + videoLayer.getVideoCodecMemoryUsage(), new String[0]);
            } else if (secondaryItem instanceof ImageLayer) {
                ImageLayer imageLayer = (ImageLayer) secondaryItem;
                this.t.a("  secondary[" + i2 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): Video Layer \n            path: " + imageLayer.getMediaPath() + "\n            ready: " + imageLayer.isReadyToPlay() + "\n            pinned: " + imageLayer.getPinned() + "\n            vcmu: " + imageLayer.getVideoCodecMemoryUsage(), new String[0]);
            } else if (secondaryItem instanceof NexLayerItem) {
                NexLayerItem nexLayerItem = (NexLayerItem) secondaryItem;
                if (secondaryItem instanceof TextLayer) {
                    name = "Text";
                } else if (secondaryItem instanceof HandwritingLayer) {
                    name = "Handwriting";
                } else if (secondaryItem instanceof StickerLayer) {
                    name = "Sticker";
                } else {
                    name = secondaryItem.getClass().getName();
                }
                this.t.a("  secondary[" + i2 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): " + name + " Layer \n            trim:   " + nexLayerItem.getStartTrim() + "/" + nexLayerItem.getEndTrim() + "\n            ready: " + nexLayerItem.isReadyToPlay() + "\n            pinned: " + nexLayerItem.getPinned() + "\n            vcmu: " + nexLayerItem.getVideoCodecMemoryUsage(), new String[0]);
            } else {
                this.t.a("  secondary[" + i2 + "] (" + secondaryItem.getAbsStartTime() + "~" + secondaryItem.getAbsEndTime() + "): " + secondaryItem.getClass().getName(), new String[0]);
            }
        }
    }

    public void a(Task.TaskError taskError) {
        int i;
        com.nexstreaming.kinemaster.editorwrapper.ar f;
        NexTimeline a2;
        int i2;
        int i3;
        int i4;
        b(taskError);
        this.t.a("Export failure: " + taskError.getMessage(), new String[0]);
        if (this.e) {
            if (this.f == null || (f = this.f.f()) == null || (a2 = f.a()) == null) {
                i = -1;
            } else {
                ArrayList<NexTimelineItem> arrayList = new ArrayList();
                int totalTime = a2.getTotalTime();
                int primaryItemCount = a2.getPrimaryItemCount();
                for (int i5 = 0; i5 < primaryItemCount; i5++) {
                    NexPrimaryTimelineItem primaryItem = a2.getPrimaryItem(i5);
                    int absStartTime = primaryItem.getAbsStartTime();
                    if (absStartTime > this.o - 1600 && absStartTime < this.o + 500) {
                        arrayList.add(primaryItem);
                    }
                }
                int secondaryItemCount = a2.getSecondaryItemCount();
                for (int i6 = 0; i6 < secondaryItemCount; i6++) {
                    NexSecondaryTimelineItem secondaryItem = a2.getSecondaryItem(i6);
                    int absStartTime2 = secondaryItem.getAbsStartTime();
                    if (absStartTime2 > this.o - 1600 && absStartTime2 < this.o + 500) {
                        arrayList.add(secondaryItem);
                    }
                }
                for (NexTimelineItem nexTimelineItem : arrayList) {
                    if (nexTimelineItem instanceof NexVideoClipItem) {
                        if (((NexVideoClipItem) nexTimelineItem).isVideo()) {
                            i2 = 105;
                        } else if (((NexVideoClipItem) nexTimelineItem).isPreset()) {
                            i2 = 106;
                        } else if (((NexVideoClipItem) nexTimelineItem).isImage()) {
                            i2 = 107;
                        } else {
                            i2 = 108;
                        }
                        i4 = ((NexVideoClipItem) nexTimelineItem).getWidth();
                        i3 = ((NexVideoClipItem) nexTimelineItem).getHeight();
                    } else if (nexTimelineItem instanceof NexTransitionItem) {
                        if (((NexTransitionItem) nexTimelineItem).getEngineDuration() <= 0) {
                            i2 = 200;
                            i3 = 0;
                            i4 = 0;
                        } else {
                            i2 = 201;
                            i3 = 0;
                            i4 = 0;
                        }
                    } else if (nexTimelineItem instanceof NexAudioClipItem) {
                        i2 = 300;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof TextLayer) {
                        i2 = 400;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof ImageLayer) {
                        i2 = 401;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof VideoLayer) {
                        i2 = 402;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof HandwritingLayer) {
                        i2 = 403;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof StickerLayer) {
                        i2 = 404;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof NexPrimaryTimelineItem) {
                        i2 = 501;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof NexLayerItem) {
                        i2 = 502;
                        i3 = 0;
                        i4 = 0;
                    } else if (nexTimelineItem instanceof NexSecondaryTimelineItem) {
                        i2 = 503;
                        i3 = 0;
                        i4 = 0;
                    } else {
                        i2 = 600;
                        i3 = 0;
                        i4 = 0;
                    }
                    if (i4 != 0 || i3 != 0) {
                        this.t.a("Suspicious Item: " + i2 + "," + i4 + "x" + i3, new String[0]);
                        SupportLogger.Event.Export_PossibleFailItem.log(i2, i4, i3);
                    } else {
                        this.t.a("Suspicious Item: " + i2, new String[0]);
                        SupportLogger.Event.Export_PossibleFailItem.log(i2);
                    }
                }
                i = totalTime;
            }
            if (taskError instanceof DiagnosticLogger.a) {
                int intErrorCode = ((DiagnosticLogger.a) taskError).getIntErrorCode();
                SupportLogger.Event.Export_SignalFail.log(intErrorCode, this.o, this.p);
                KMUsage.Share_ExportResult.logEvent("result", "fail", NativeProtocol.BRIDGE_ARG_ERROR_CODE, "" + intErrorCode, "error_desc", taskError.getMessage(), "cancel_time", "fail", "elapsed_time", "-1", "export_profile", this.i.width() + "x" + this.i.height() + "@" + this.i.bitrate(), "project_duration", "" + i, "export_rate", "-1", "model_prod_dev_man_hw_board", Build.MODEL + "/" + Build.PRODUCT + "/" + Build.DEVICE + "/" + Build.MANUFACTURER + "/" + Build.HARDWARE + "/" + Build.BOARD, "sdk_level", "" + Build.VERSION.SDK_INT);
            } else {
                SupportLogger.Event.Export_SignalFail.log(new int[0]);
                KMUsage.Share_ExportResult.logEvent("result", "fail", NativeProtocol.BRIDGE_ARG_ERROR_CODE, "unknown_err", "error_desc", taskError.getMessage(), "cancel_time", "fail", "elapsed_time", "-1", "export_profile", this.i.width() + "x" + this.i.height() + "@" + this.i.bitrate(), "project_duration", "" + i, "export_rate", "-1", "model_prod_dev_man_hw_board", Build.MODEL + "/" + Build.PRODUCT + "/" + Build.DEVICE + "/" + Build.MANUFACTURER + "/" + Build.HARDWARE + "/" + Build.BOARD, "sdk_level", "" + Build.VERSION.SDK_INT);
            }
            this.g.sendFailure(taskError);
            g();
        }
    }

    public void a(int i, int i2) {
        this.t.a("Export progress: " + i + "/" + i2, new String[0]);
        if (this.e) {
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
            this.g.setProgress(i, i2);
        }
    }

    public void e() {
        com.nexstreaming.kinemaster.editorwrapper.ar f;
        NexTimeline a2;
        this.t.a("Export cancelled by user", new String[0]);
        int nanoTime = (int) ((System.nanoTime() - this.n) / 1000000);
        int i = -1;
        if (this.f != null && (f = this.f.f()) != null && (a2 = f.a()) != null) {
            i = a2.getTotalTime();
        }
        SupportLogger.Event.Export_SignalCancel.log(new int[0]);
        if (this.e && this.k) {
            this.g.signalEvent(Task.Event.CANCEL);
            a("Cancel", (String) null);
            KMUsage kMUsage = KMUsage.Share_ExportResult;
            String[] strArr = new String[20];
            strArr[0] = "result";
            strArr[1] = "cancel";
            strArr[2] = NativeProtocol.BRIDGE_ARG_ERROR_CODE;
            strArr[3] = "cancel";
            strArr[4] = "error_desc";
            strArr[5] = "cancel";
            strArr[6] = "cancel_time";
            strArr[7] = "" + this.o;
            strArr[8] = "elapsed_time";
            strArr[9] = "" + nanoTime;
            strArr[10] = "export_profile";
            strArr[11] = this.i.width() + "x" + this.i.height() + "@" + this.i.bitrate();
            strArr[12] = "project_duration";
            strArr[13] = "" + i;
            strArr[14] = "export_rate";
            strArr[15] = "" + KMUsage.bucketParam0to300(this.o < 1 ? 0 : (nanoTime * 100) / this.o) + "%";
            strArr[16] = "model_prod_dev_man_hw_board";
            strArr[17] = Build.MODEL + "/" + Build.PRODUCT + "/" + Build.DEVICE + "/" + Build.MANUFACTURER + "/" + Build.HARDWARE + "/" + Build.BOARD;
            strArr[18] = "sdk_level";
            strArr[19] = "" + Build.VERSION.SDK_INT;
            kMUsage.logEvent(strArr);
            g();
        }
    }

    public void f() {
        this.t.a("Export success!", new String[0]);
        if (this.b != null) {
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.b);
            defaultSharedPreferences.edit().putInt("rate_export_success_count", defaultSharedPreferences.getInt("rate_export_success_count", 0) + 1).apply();
        }
        int nanoTime = (int) ((System.nanoTime() - this.n) / 1000000);
        SupportLogger.Event.Export_SignalSuccess.log(new int[0]);
        if (this.e) {
            KMUsage.getMixpanelPeople(this.b).a("Export Video Count", 1.0d);
            a("Success", (String) null);
            KMUsage.Share_ExportResult.logEvent("result", GraphResponse.SUCCESS_KEY, NativeProtocol.BRIDGE_ARG_ERROR_CODE, GraphResponse.SUCCESS_KEY, "error_desc", GraphResponse.SUCCESS_KEY, "cancel_time", GraphResponse.SUCCESS_KEY, "elapsed_time", "" + nanoTime, "export_profile", this.i.width() + "x" + this.i.height() + "@" + this.i.bitrate(), "project_duration", "-1", "export_rate", "" + KMUsage.bucketParam0to300((nanoTime * 100) / (-1)) + "%", "model_prod_dev_man_hw_board", Build.MODEL + "/" + Build.PRODUCT + "/" + Build.DEVICE + "/" + Build.MANUFACTURER + "/" + Build.HARDWARE + "/" + Build.BOARD, "sdk_level", "" + Build.VERSION.SDK_INT);
            this.g.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
            g();
        }
    }

    private void g() {
        this.t.a("(finishing up)", new String[0]);
        if (this.e) {
            this.e = false;
            this.h = null;
            this.i = null;
            if (this.g.isRunning()) {
                this.g.sendFailure(Task.makeTaskError("bad state"));
            }
            if (this.f.t() != VideoEditor.State.Idle) {
                this.f.p();
            }
            this.g = null;
            this.f = null;
            this.j.release();
            this.j = null;
            this.l = false;
            this.k = false;
        }
    }

    public void a(boolean z) {
        KMUsage.timeEvent(this.b, "Export Video");
        this.t.a(">> START EXPORT TASK <<", new String[0]);
        SupportLogger.Event.Export_Start.log(new int[0]);
        if (this.k) {
            e();
            return;
        }
        if (this.f == null || this.f.f() == null) {
            e();
            return;
        }
        this.n = System.nanoTime();
        NexTimeline a2 = this.f.f().a();
        KMUsage.logProjectStats(a2, KMUsage.Share_StartExport_ProjStatsA_NOSUB, KMUsage.Share_StartExport_ProjStatsB_NOSUB, KMUsage.Share_StartExport_ProjStatsA_SUB, KMUsage.Share_StartExport_ProjStatsB_SUB, z);
        if (!com.nexstreaming.app.general.util.i.a(this.h, Math.max(1, (((a2.getTotalTime() / LicenseErrCode.LICENSE_STATUS_NOT_LICENSED) * (this.i.bitrate() / 1024)) / 1024) / 8) * 1024 * 1024, 10485760L)) {
            a(NexEditor.b.W);
            return;
        }
        if (a2.getTotalTime() < 1) {
            a(NexEditor.b.bh);
            return;
        }
        if (!a2.checkResources(this.b)) {
            a(NexEditor.b.bi);
            return;
        }
        if (!a2.checkReadyToPlay()) {
            a(NexEditor.b.bd);
            return;
        }
        if (this.h.exists()) {
            SupportLogger.Event.Export_RemoveOutOutputFile.log(new int[0]);
            this.h.delete();
        }
        File file = new File(this.h.getAbsolutePath() + ".tmp");
        SupportLogger.Event.Export_BeginSeek.log(new int[0]);
        this.t.a("Seek to start...", new String[0]);
        this.f.a(0).onComplete(new s(this, file)).onFailure(new r(this));
    }

    private void b(Task.TaskError taskError) {
        if (taskError != null) {
            if (taskError.equals(NexEditor.b.bk)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Project load failed");
                return;
            }
            if (taskError.equals(NexEditor.b.bn)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Dummy Error");
                return;
            }
            if (taskError.equals(NexEditor.b.bd)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Not ready to play");
                return;
            }
            if (taskError.equals(NexEditor.b.bl)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Rename failed");
                return;
            }
            if (taskError.equals(NexEditor.b.x)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Codec init failed");
                return;
            }
            if (taskError.equals(NexEditor.b.ar) || taskError.equals(NexEditor.b.ap) || taskError.equals(NexEditor.b.aq)) {
                a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Decoder init failed");
                return;
            }
            if (taskError.equals(NexEditor.b.bh)) {
                a("Empty project", (String) null);
                return;
            }
            if (taskError.equals(NexEditor.b.bi)) {
                a("Missing resources", (String) null);
                return;
            }
            if (taskError.equals(NexEditor.b.W)) {
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
        a(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_FAILED, "Unknown error");
    }

    private void a(String str, String str2) {
        int i;
        NexTimeline nexTimeline;
        String str3;
        com.nexstreaming.kinemaster.editorwrapper.ar f;
        int nanoTime = (int) ((System.nanoTime() - this.n) / 1000000);
        if (this.f == null || (f = this.f.f()) == null) {
            i = -1;
            nexTimeline = null;
        } else {
            NexTimeline a2 = f.a();
            if (a2 != null) {
                i = a2.getTotalTime() != 0 ? a2.getTotalTime() : -1;
                nexTimeline = a2;
            } else {
                i = -1;
                nexTimeline = a2;
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Export Width", this.i.width());
            jSONObject.put("Export Height", this.i.height());
            jSONObject.put("Export Elapsed Time", nanoTime);
            jSONObject.put("Export Bitrate", this.i.bitrate());
            jSONObject.put("Export File Size", this.h.length());
            jSONObject.put("Export Rate", (nanoTime * 100) / i);
            switch (this.s) {
                case R.id.sns_share_gallery /* 2131821505 */:
                    str3 = "Gallery";
                    break;
                case R.id.shareGridLayout /* 2131821506 */:
                case R.id.sns_share_wechat /* 2131821511 */:
                default:
                    str3 = AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
                    break;
                case R.id.sns_share_youtube /* 2131821507 */:
                    str3 = "YouTube";
                    break;
                case R.id.sns_share_facebook /* 2131821508 */:
                    str3 = "Facebook";
                    break;
                case R.id.sns_share_gplus /* 2131821509 */:
                    str3 = "Google Plus";
                    break;
                case R.id.sns_share_dropbox /* 2131821510 */:
                    str3 = "Dropbox";
                    break;
                case R.id.sns_share_other /* 2131821512 */:
                    str3 = "Other";
                    break;
            }
            jSONObject.put("Export Target", str3);
            jSONObject.put("Status", str);
            Object obj = str2;
            if (str2 == null) {
                obj = 0;
            }
            jSONObject.put("Failed Desc", obj);
        } catch (JSONException e) {
            Log.e("ExportManager", "Mixpanel json err", e);
        }
        KMUsage.trackMixpanelProjectEvent(this.b, nexTimeline, "Export Video", jSONObject);
    }
}
