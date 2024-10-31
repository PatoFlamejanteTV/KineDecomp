package com.nexstreaming.kinemaster.codeccaps;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Range;
import c.d.b.a.a;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.gson.GsonBuilder;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.app.general.util.C1702f;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nexstreaming.kinemaster.usage.analytics.KMEvents;
import com.nextreaming.nexeditorui.EditorGlobal;
import com.nextreaming.nexeditorui.KineMasterApplication;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import com.nextreaming.nexeditorui.NexExportProfile;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* compiled from: CapabilityReporter.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f20140a = {"video/avc", "video/hevc"};

    /* renamed from: b, reason: collision with root package name */
    private static String f20141b = null;

    /* renamed from: c, reason: collision with root package name */
    private static final com.nexstreaming.app.general.util.F[] f20142c = {new com.nexstreaming.app.general.util.F(3840, 2160), new com.nexstreaming.app.general.util.F(2560, 1440), new com.nexstreaming.app.general.util.F(1920, 1080), new com.nexstreaming.app.general.util.F(1280, 720), new com.nexstreaming.app.general.util.F(960, 540), new com.nexstreaming.app.general.util.F(640, 360), new com.nexstreaming.app.general.util.F(3840, 2880), new com.nexstreaming.app.general.util.F(2560, 1920), new com.nexstreaming.app.general.util.F(1920, 1440), new com.nexstreaming.app.general.util.F(1280, 960), new com.nexstreaming.app.general.util.F(960, 720), new com.nexstreaming.app.general.util.F(640, 480)};

    public static void a(Context context, u uVar) {
        HashMap hashMap = new HashMap();
        hashMap.put("h264_high_profile", Boolean.toString(uVar.c()));
        hashMap.put("max_codec_count", Integer.toString(uVar.p()));
        hashMap.put("max_codec_mem_size", Integer.toString(uVar.d()));
        hashMap.put("max_import_res_overlap", Integer.toString(uVar.n().f3592b));
        hashMap.put("max_import_res_no_overlap", Integer.toString(uVar.g().f3592b));
        hashMap.put("max_export_res", Integer.toString(uVar.a().f3592b));
        hashMap.put("max_transcode_res", Integer.toString(uVar.l().f3592b));
        hashMap.put("chipset", c.d.b.a.a.f3576b.c());
        hashMap.put("chipset_src", c.d.b.a.a.f3576b.i());
        hashMap.put("product", Build.PRODUCT);
        hashMap.put("model", Build.MODEL);
        KMEvents.CAPABILITY_CHECK_RESULT.logEvent(hashMap);
    }

    public static CapabilityReport b(u uVar) {
        CapabilityReport capabilityReport = new CapabilityReport();
        capabilityReport.capabilityTestVersion = 7;
        capabilityReport.deviceInfo = c(uVar);
        capabilityReport.capabilityInfo = g(uVar);
        capabilityReport.heuristicBasedCapabilityInfo = Q.a();
        capabilityReport.testResults = h(uVar);
        capabilityReport.legacyDeviceProfile = f(uVar);
        return capabilityReport;
    }

    private static CapabilityReport.PlaybackTestResult c(CapabilityChecker.c cVar, P.b bVar) {
        CapabilityReport.PlaybackTestResult playbackTestResult = new CapabilityReport.PlaybackTestResult();
        playbackTestResult.success = bVar.m();
        playbackTestResult.resultCode = a(bVar.e());
        playbackTestResult.resultCodeName = b(bVar.e());
        playbackTestResult.testElapsedTime = bVar.d();
        playbackTestResult.inputRes = bVar.f();
        playbackTestResult.totalFrames = bVar.l();
        playbackTestResult.renderedFrames = bVar.j();
        playbackTestResult.droppedFrames = bVar.c();
        playbackTestResult.dropFrameRatio = bVar.b();
        playbackTestResult.codecMemoryUsage = bVar.a();
        playbackTestResult.frameWaitTimeouts = NexEditor.PerformanceCounter.FRAME_WAIT_TIMEOUT.get(bVar.i());
        playbackTestResult.secondaryInputRes = cVar.f20036d;
        playbackTestResult.codecCount = cVar.f20037e;
        return playbackTestResult;
    }

    private static CapabilityReport.TranscodeTestResult d(CapabilityChecker.c cVar, P.b bVar) {
        CapabilityReport.TranscodeTestResult transcodeTestResult = new CapabilityReport.TranscodeTestResult();
        transcodeTestResult.success = bVar.m();
        transcodeTestResult.resultCode = a(bVar.e());
        transcodeTestResult.resultCodeName = b(bVar.e());
        transcodeTestResult.testElapsedTime = bVar.d();
        transcodeTestResult.inputRes = bVar.f();
        transcodeTestResult.outputRes = bVar.h();
        transcodeTestResult.codecMemoryUsage = bVar.a();
        return transcodeTestResult;
    }

    public static boolean e(u uVar) {
        String str;
        FileOutputStream fileOutputStream;
        String a2 = a(uVar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        File a3 = EditorGlobal.a();
        a3.mkdirs();
        String str2 = f20141b;
        try {
            try {
                if (str2 != null) {
                    String b2 = b(str2);
                    if (b2.length() > 0) {
                        str = io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b2;
                        fileOutputStream = new FileOutputStream(new File(a3, "CCT_" + ("V7" + str + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(c.d.b.a.a.f3576b.c()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MANUFACTURER) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MODEL) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.PRODUCT) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + Build.VERSION.SDK_INT + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + simpleDateFormat.format(new Date())) + ".json"));
                        fileOutputStream.write(a2.getBytes());
                        C1702f.a(fileOutputStream);
                        return true;
                    }
                }
                fileOutputStream.write(a2.getBytes());
                C1702f.a(fileOutputStream);
                return true;
            } catch (Throwable th) {
                C1702f.a(fileOutputStream);
                throw th;
            }
            fileOutputStream = new FileOutputStream(new File(a3, "CCT_" + ("V7" + str + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(c.d.b.a.a.f3576b.c()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MANUFACTURER) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MODEL) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.PRODUCT) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + Build.VERSION.SDK_INT + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + simpleDateFormat.format(new Date())) + ".json"));
        } catch (IOException e2) {
            Log.e("CapabilityReporter", "Json write error", e2);
            return false;
        }
        str = "";
    }

    private static CapabilityReport.LegacyDeviceProfile f(u uVar) {
        CapabilityReport.LegacyDeviceProfile legacyDeviceProfile = new CapabilityReport.LegacyDeviceProfile();
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        if (deviceProfile != null) {
            legacyDeviceProfile.match = deviceProfile.getProfileSource().name();
            legacyDeviceProfile.matchInfo = a(uVar, deviceProfile);
            legacyDeviceProfile.maxFrameRate = deviceProfile.getMaxSupportedFPS();
            legacyDeviceProfile.fullHDMaxTransitionTime = deviceProfile.getLegacyFullHDMaxTransitionTime();
            legacyDeviceProfile.hwDecMaxCount = deviceProfile.getLegacyHardwareDecMaxCount();
            legacyDeviceProfile.hwEncMaxCount = deviceProfile.getLegacyHardwareEncMaxCount();
            legacyDeviceProfile.hwCodecMemorySize = deviceProfile.getLegacyHardwareCodecMemSize();
            legacyDeviceProfile.imageRec = deviceProfile.getLegacyImageRecordingMode().name();
            legacyDeviceProfile.videoRec = deviceProfile.getLegacyVideoRecordingMode().name();
            legacyDeviceProfile.useAndroidJpegDec = deviceProfile.getLegacyUseAndroidJPEGDecoder();
            legacyDeviceProfile.audioCodecMax = deviceProfile.getLegacyAudioCodecMaxCount();
            legacyDeviceProfile.mediaExtractorSupported = deviceProfile.getLegacyUseMediaExtractor();
            legacyDeviceProfile.needColorFormatCheck = deviceProfile.getNeedsColorFormatCheck();
            legacyDeviceProfile.needSeekBeforeFastPreview = deviceProfile.getLegacyNeedSeekBeforeFastPreview();
            legacyDeviceProfile.captureSize = deviceProfile.getCaptureSize().f24097b;
            legacyDeviceProfile.legacyExportProfiles = new ArrayList();
            NexExportProfile[] supportedExportProfiles = deviceProfile.getSupportedExportProfiles(KineMasterApplication.f24056d.r().b());
            if (supportedExportProfiles != null) {
                for (NexExportProfile nexExportProfile : supportedExportProfiles) {
                    legacyDeviceProfile.legacyExportProfiles.add(a(nexExportProfile));
                }
                deviceProfile.clearCachedExportProfile();
            }
        }
        return legacyDeviceProfile;
    }

    private static CapabilityReport.CapabilityInfo g(u uVar) {
        if (uVar == null) {
            return null;
        }
        CapabilityReport.CapabilityInfo capabilityInfo = new CapabilityReport.CapabilityInfo();
        capabilityInfo.deviceSupported = uVar.b();
        capabilityInfo.supportHighProfile = uVar.c();
        capabilityInfo.maxCodecMemorySize = uVar.d();
        capabilityInfo.maxPlaybackCodecMemorySize = uVar.f();
        capabilityInfo.maxResolution = uVar.m().f3592b;
        capabilityInfo.minResolution = uVar.h().f3592b;
        capabilityInfo.maxImportResolutionNoOverlap = uVar.g().f3592b;
        capabilityInfo.maxImportResolutionWithOverlap = uVar.n().f3592b;
        capabilityInfo.maxDetectedImportResolutionNoOverlap = capabilityInfo.maxImportResolutionNoOverlap;
        capabilityInfo.maxDetectedImportResolutionWithOverlap = capabilityInfo.maxImportResolutionWithOverlap;
        capabilityInfo.maxExportResolution = uVar.a().f3592b;
        capabilityInfo.maxTranscodeResolution = uVar.l().f3592b;
        capabilityInfo.maxCodecCount = uVar.p();
        capabilityInfo.maxCodecCountAtMaxImportRes = uVar.j();
        capabilityInfo.maxCodecCountAtMaxImportResNoSkipping = capabilityInfo.maxCodecCountAtMaxImportRes;
        capabilityInfo.codecInstanceCountByResolution = uVar.q();
        capabilityInfo.codecInstanceCountByResolutionMinorSkipping = uVar.o();
        capabilityInfo.codecInstanceCountByResolutionNoSkipping = uVar.e();
        if (capabilityInfo.codecInstanceCountByResolutionMinorSkipping.containsKey(Integer.valueOf(capabilityInfo.maxImportResolutionWithOverlap))) {
            capabilityInfo.maxCodecCountAtMaxImportResNoSkipping = capabilityInfo.codecInstanceCountByResolutionMinorSkipping.get(Integer.valueOf(capabilityInfo.maxImportResolutionWithOverlap)).intValue();
        }
        b(capabilityInfo);
        return capabilityInfo;
    }

    private static CapabilityReport.TestResults h(u uVar) {
        CapabilityReport.TestResults testResults = new CapabilityReport.TestResults();
        testResults.testDeviceName = f20141b;
        testResults.appVersion = 14242;
        testResults.appVersionName = "4.11.15.14242.GP";
        testResults.appBuildType = "release";
        testResults.appPackage = com.nexstreaming.app.general.util.N.b(KineMasterApplication.f24056d.getApplicationContext());
        testResults.appPackageVerName = com.nexstreaming.app.general.util.N.d(KineMasterApplication.f24056d.getApplicationContext());
        testResults.testStartDate = System.currentTimeMillis();
        testResults.elapsedTestTimeMillis = uVar.k();
        testResults.encodeTestResults = new ArrayList();
        testResults.transcodeTestResults = new ArrayList();
        testResults.playbackTestResults = new ArrayList();
        testResults.exportTestResults = new ArrayList();
        for (P.b bVar : uVar.i()) {
            CapabilityChecker.c cVar = (CapabilityChecker.c) bVar.k();
            int i = y.f20139a[cVar.f20034b.ordinal()];
            if (i == 1) {
                testResults.exportTestResults.add(b(cVar, bVar));
            } else if (i == 2) {
                testResults.encodeTestResults.add(a(cVar, bVar));
            } else if (i == 3) {
                testResults.playbackTestResults.add(c(cVar, bVar));
            } else if (i == 4) {
                testResults.transcodeTestResults.add(d(cVar, bVar));
            }
        }
        return testResults;
    }

    private static String b(Task.TaskError taskError) {
        if (taskError == null) {
            return "NONE";
        }
        if (taskError instanceof NexEditor.b) {
            return ((NexEditor.b) taskError).d();
        }
        String message = taskError.getMessage();
        return (message == null || message.trim().length() <= 0) ? "UNKNOWN" : message.trim();
    }

    public static Task d(u uVar) {
        String str;
        Task task = new Task();
        if (!c.d.b.c.a.d(KineMasterApplication.f24056d.getApplicationContext())) {
            task.sendFailure(Task.makeTaskError("not enabled firebase"));
            return task;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss", Locale.US);
        StorageReference a2 = FirebaseStorage.b().b("gs://api-project-652995075284.appspot.com").a("dc");
        String str2 = f20141b;
        if (str2 != null) {
            String b2 = b(str2);
            if (b2.length() > 0) {
                str = io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b2;
                a2.a("CCT_V7" + str + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(c.d.b.a.a.f3576b.c()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MANUFACTURER) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MODEL) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.PRODUCT) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + Build.VERSION.SDK_INT + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + simpleDateFormat.format(new Date()) + ".json").a(a(uVar).getBytes()).a((OnFailureListener) new x(task)).a((OnSuccessListener<? super UploadTask.TaskSnapshot>) new w(task));
                return task;
            }
        }
        str = "";
        a2.a("CCT_V7" + str + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(c.d.b.a.a.f3576b.c()) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MANUFACTURER) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.MODEL) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + b(Build.PRODUCT) + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + Build.VERSION.SDK_INT + io.fabric.sdk.android.a.b.c.ROLL_OVER_FILE_NAME_SEPARATOR + simpleDateFormat.format(new Date()) + ".json").a(a(uVar).getBytes()).a((OnFailureListener) new x(task)).a((OnSuccessListener<? super UploadTask.TaskSnapshot>) new w(task));
        return task;
    }

    private static CapabilityReport.ExportTestResult b(CapabilityChecker.c cVar, P.b bVar) {
        CapabilityReport.ExportTestResult exportTestResult = new CapabilityReport.ExportTestResult();
        exportTestResult.success = bVar.m();
        exportTestResult.resultCode = a(bVar.e());
        exportTestResult.resultCodeName = b(bVar.e());
        exportTestResult.testElapsedTime = bVar.d();
        exportTestResult.inputRes = bVar.f();
        exportTestResult.outputRes = bVar.h();
        exportTestResult.codecMemoryUsage = bVar.a();
        exportTestResult.totalFrames = bVar.l();
        exportTestResult.renderedFrames = bVar.j();
        exportTestResult.droppedFrames = bVar.c();
        exportTestResult.frameWaitTimeouts = NexEditor.PerformanceCounter.FRAME_WAIT_TIMEOUT.get(bVar.i());
        exportTestResult.dropFrameRatio = bVar.b();
        return exportTestResult;
    }

    public static void a(String str) {
        f20141b = str;
    }

    public static String a(u uVar) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(b(uVar));
    }

    public static CapabilityReport.DeviceInfo c(u uVar) {
        DisplayMetrics displayMetrics = KineMasterApplication.f24056d.getApplicationContext().getResources().getDisplayMetrics();
        Configuration configuration = KineMasterApplication.f24056d.getApplicationContext().getResources().getConfiguration();
        CapabilityReport.DeviceInfo deviceInfo = new CapabilityReport.DeviceInfo();
        deviceInfo.model = Build.MODEL;
        deviceInfo.product = Build.PRODUCT;
        deviceInfo.manufacturer = Build.MANUFACTURER;
        deviceInfo.hardware = Build.HARDWARE;
        deviceInfo.brand = Build.BRAND;
        deviceInfo.chipset = c.d.b.a.a.f3576b.c();
        deviceInfo.chipset_src = c.d.b.a.a.f3576b.i();
        a.InterfaceC0013a f2 = c.d.b.a.a.f3576b.f();
        if (f2 != null) {
            deviceInfo.cpuinfo_processor = f2.e();
            deviceInfo.cpuinfo_features = f2.f();
            deviceInfo.cpuinfo_implementer = f2.a();
            deviceInfo.cpuinfo_architecture = f2.c();
            deviceInfo.cpuinfo_variant = f2.g();
            deviceInfo.cpuinfo_part = f2.d();
            deviceInfo.cpuinfo_revision = f2.b();
            deviceInfo.cpuinfo_hardware = f2.i();
        }
        deviceInfo.board_platform = c.d.b.a.a.f3576b.b();
        deviceInfo.mtk_platform = c.d.b.a.a.f3576b.g();
        deviceInfo.product_board = c.d.b.a.a.f3576b.h();
        deviceInfo.sdkLevel = Build.VERSION.SDK_INT;
        deviceInfo.osVersion = Build.VERSION.RELEASE;
        deviceInfo.screenWidthPixels = displayMetrics.widthPixels;
        deviceInfo.screenHeightPixels = displayMetrics.heightPixels;
        deviceInfo.densityDpi = displayMetrics.densityDpi;
        deviceInfo.xdpi = displayMetrics.xdpi;
        deviceInfo.ydpi = displayMetrics.ydpi;
        deviceInfo.density = displayMetrics.density;
        deviceInfo.screenHeightDP = configuration.screenHeightDp;
        deviceInfo.screenWidthDP = configuration.screenWidthDp;
        deviceInfo.mediaCodecCapabilities = a();
        ActivityManager activityManager = (ActivityManager) KineMasterApplication.f24056d.getSystemService("activity");
        if (activityManager != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            activityManager.getMemoryInfo(memoryInfo);
            deviceInfo.totalMemory = memoryInfo.totalMem;
            deviceInfo.memoryThreshold = memoryInfo.threshold;
        } else {
            deviceInfo.totalMemory = -1L;
            deviceInfo.memoryThreshold = -1L;
        }
        int i = configuration.screenLayout & 15;
        if (i == 1) {
            deviceInfo.screenSize = "small";
        } else if (i == 2) {
            deviceInfo.screenSize = "normal";
        } else if (i == 3) {
            deviceInfo.screenSize = "large";
        } else if (i != 4) {
            deviceInfo.screenSize = "unknown";
        } else {
            deviceInfo.screenSize = "xlarge";
        }
        int i2 = configuration.screenLayout & 48;
        if (i2 == 16) {
            deviceInfo.longScreen = false;
        } else if (i2 == 32) {
            deviceInfo.longScreen = true;
        }
        return deviceInfo;
    }

    private static CapabilityReport.LegacyExportProfile a(NexExportProfile nexExportProfile) {
        CapabilityReport.LegacyExportProfile legacyExportProfile = new CapabilityReport.LegacyExportProfile();
        legacyExportProfile.bitrate = nexExportProfile.bitrate();
        legacyExportProfile.height = nexExportProfile.height();
        legacyExportProfile.width = nexExportProfile.width();
        legacyExportProfile.displayHeight = nexExportProfile.displayHeight();
        return legacyExportProfile;
    }

    private static CapabilityReport.LegacyMatchInfo a(u uVar, NexEditorDeviceProfile nexEditorDeviceProfile) {
        CapabilityReport.LegacyMatchInfo legacyMatchInfo = new CapabilityReport.LegacyMatchInfo();
        NexEditorDeviceProfile.a matchInfo = nexEditorDeviceProfile.getMatchInfo();
        if (matchInfo != null) {
            legacyMatchInfo.record_number = matchInfo.f24086a;
            legacyMatchInfo.build_model = matchInfo.f24087b;
            legacyMatchInfo.build_device = matchInfo.f24088c;
            legacyMatchInfo.manufacturer = matchInfo.f24089d;
            legacyMatchInfo.board_platform = matchInfo.f24090e;
            legacyMatchInfo.os_api_level_min = matchInfo.f24091f;
            legacyMatchInfo.os_api_level_max = matchInfo.f24092g;
            legacyMatchInfo.predicate_name = matchInfo.f24093h;
        }
        return legacyMatchInfo;
    }

    private static int b(Map<Integer, Integer> map, int i) {
        Integer num;
        if (map == null || (num = map.get(Integer.valueOf(i))) == null) {
            return 0;
        }
        return num.intValue();
    }

    private static void b(CapabilityReport.CapabilityInfo capabilityInfo) {
        int a2 = a(capabilityInfo.codecInstanceCountByResolution, 3);
        int a3 = a(capabilityInfo.codecInstanceCountByResolution, 2);
        int a4 = a(capabilityInfo.codecInstanceCountByResolutionMinorSkipping, 3);
        int a5 = a(capabilityInfo.codecInstanceCountByResolutionMinorSkipping, 2);
        int a6 = a(capabilityInfo.codecInstanceCountByResolutionNoSkipping, 3);
        int a7 = a(capabilityInfo.codecInstanceCountByResolutionNoSkipping, 2);
        int min = Math.min(a2, Math.max(a4, a6));
        int min2 = Math.min(a3, Math.max(a5, a7));
        int min3 = Math.min(b(capabilityInfo.codecInstanceCountByResolution, min), Math.max(b(capabilityInfo.codecInstanceCountByResolutionMinorSkipping, min), b(capabilityInfo.codecInstanceCountByResolutionNoSkipping, min)));
        int min4 = Math.min(b(capabilityInfo.codecInstanceCountByResolution, min2), Math.max(b(capabilityInfo.codecInstanceCountByResolutionMinorSkipping, min2), b(capabilityInfo.codecInstanceCountByResolutionNoSkipping, min2)));
        capabilityInfo.maxCodecCountAtMaxImportResWithOverlap = min3;
        capabilityInfo.maxCodecCountAtMaxImportResNoOverlap = min4;
        capabilityInfo.maxImportResolutionWithOverlap = min;
        capabilityInfo.maxImportResolutionNoOverlap = min2;
        a(capabilityInfo);
    }

    private static int a(Task.TaskError taskError) {
        if (taskError instanceof NexEditor.b) {
            return ((NexEditor.b) taskError).getIntErrorCode();
        }
        return 0;
    }

    private static CapabilityReport.EncodeTestResult a(CapabilityChecker.c cVar, P.b bVar) {
        CapabilityReport.EncodeTestResult encodeTestResult = new CapabilityReport.EncodeTestResult();
        encodeTestResult.success = bVar.m();
        encodeTestResult.resultCode = a(bVar.e());
        encodeTestResult.resultCodeName = b(bVar.e());
        encodeTestResult.testElapsedTime = bVar.d();
        encodeTestResult.outputRes = bVar.h();
        MediaInfo g2 = bVar.g();
        encodeTestResult.codecProfile = g2 == null ? 0 : bVar.g().N();
        encodeTestResult.codecLevel = g2 != null ? bVar.g().M() : 0;
        encodeTestResult.codecMemoryUsage = bVar.a();
        encodeTestResult.totalFrames = bVar.l();
        encodeTestResult.renderedFrames = bVar.j();
        encodeTestResult.droppedFrames = bVar.c();
        encodeTestResult.frameWaitTimeouts = NexEditor.PerformanceCounter.FRAME_WAIT_TIMEOUT.get(bVar.i());
        encodeTestResult.dropFrameRatio = bVar.b();
        return encodeTestResult;
    }

    private static int a(Map<Integer, Integer> map, int i) {
        int i2 = 0;
        if (map == null) {
            return 0;
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().intValue() >= i) {
                i2 = Math.max(i2, entry.getKey().intValue());
            }
        }
        return i2;
    }

    public static void a(CapabilityReport.CapabilityInfo capabilityInfo) {
        if (!capabilityInfo.deviceSupported) {
            capabilityInfo.supportLevel = 0;
            capabilityInfo.supportLevelName = "NONE";
            return;
        }
        int i = capabilityInfo.maxImportResolutionWithOverlap;
        if (i <= 0) {
            if (capabilityInfo.maxImportResolutionNoOverlap >= 720) {
                capabilityInfo.supportLevel = 10;
                capabilityInfo.supportLevelName = "NO-OVERLAP";
                return;
            } else {
                capabilityInfo.supportLevel = 5;
                capabilityInfo.supportLevelName = "REDUCED-RESOLUTION-NO-OVERLAP";
                return;
            }
        }
        if (capabilityInfo.maxCodecCountAtMaxImportResWithOverlap >= 4) {
            if (i > 2000) {
                capabilityInfo.supportLevel = 110;
                capabilityInfo.supportLevelName = "4K-SINGLE-PASS-EXPORT";
                return;
            }
            if (i > 1088) {
                capabilityInfo.supportLevel = 90;
                capabilityInfo.supportLevelName = "UHD-SINGLE-PASS-EXPORT";
                return;
            } else if (i >= 1080) {
                capabilityInfo.supportLevel = 70;
                capabilityInfo.supportLevelName = "FHD-SINGLE-PASS-EXPORT";
                return;
            } else if (i >= 720) {
                capabilityInfo.supportLevel = 50;
                capabilityInfo.supportLevelName = "HD-SINGLE-PASS-EXPORT";
                return;
            } else {
                capabilityInfo.supportLevel = 30;
                capabilityInfo.supportLevelName = "REDUCED-RESOLUTION-SINGLE-PASS-EXPORT";
                return;
            }
        }
        if (i > 2000) {
            capabilityInfo.supportLevel = 100;
            capabilityInfo.supportLevelName = "4K-MULTI-PASS-EXPORT";
            return;
        }
        if (i > 1088) {
            capabilityInfo.supportLevel = 80;
            capabilityInfo.supportLevelName = "UHD-MULTI-PASS-EXPORT";
        } else if (i >= 1080) {
            capabilityInfo.supportLevel = 60;
            capabilityInfo.supportLevelName = "FHD-MULTI-PASS-EXPORT";
        } else if (i >= 720) {
            capabilityInfo.supportLevel = 40;
            capabilityInfo.supportLevelName = "HD-MULTI-PASS-EXPORT";
        } else {
            capabilityInfo.supportLevel = 20;
            capabilityInfo.supportLevelName = "REDUCED-RESOLUTION-MULTI-PASS-EXPORT";
        }
    }

    private static String b(String str) {
        return str == null ? "NULL" : str.replaceAll("[^a-zA-Z0-9]", "");
    }

    private static List<CapabilityReport.MediaCodecInfo> a() {
        MediaCodecInfo[] mediaCodecInfoArr;
        MediaCodecInfo[] mediaCodecInfoArr2;
        String[] strArr;
        int i;
        com.nexstreaming.app.general.util.F[] fArr;
        String[] strArr2;
        int i2;
        if (Build.VERSION.SDK_INT < 21) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
        int length = codecInfos.length;
        int i3 = 0;
        while (i3 < length) {
            MediaCodecInfo mediaCodecInfo = codecInfos[i3];
            CapabilityReport.MediaCodecInfo mediaCodecInfo2 = new CapabilityReport.MediaCodecInfo();
            if (mediaCodecInfo.getName().startsWith("OMX.google.")) {
                mediaCodecInfoArr = codecInfos;
            } else {
                mediaCodecInfo2.name = mediaCodecInfo.getName();
                mediaCodecInfo2.encoder = mediaCodecInfo.isEncoder();
                mediaCodecInfo2.types = new ArrayList();
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length2 = supportedTypes.length;
                int i4 = 0;
                while (i4 < length2) {
                    String str = supportedTypes[i4];
                    boolean z = false;
                    for (String str2 : f20140a) {
                        if (str.equals(str2)) {
                            z = true;
                        }
                    }
                    if (z) {
                        CapabilityReport.MediaCodecTypeInfo mediaCodecTypeInfo = new CapabilityReport.MediaCodecTypeInfo();
                        mediaCodecTypeInfo.type = str;
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                        MediaCodecInfo.EncoderCapabilities encoderCapabilities = capabilitiesForType.getEncoderCapabilities();
                        MediaCodecInfo.AudioCapabilities audioCapabilities = capabilitiesForType.getAudioCapabilities();
                        mediaCodecTypeInfo.hasAudio = audioCapabilities != null;
                        mediaCodecTypeInfo.hasVideo = videoCapabilities != null;
                        if (encoderCapabilities != null) {
                            if (encoderCapabilities.getComplexityRange() != null) {
                                mediaCodecTypeInfo.minEncComplexity = encoderCapabilities.getComplexityRange().getLower().intValue();
                                mediaCodecTypeInfo.maxEncComplexity = encoderCapabilities.getComplexityRange().getUpper().intValue();
                            } else {
                                mediaCodecTypeInfo.minEncComplexity = -1;
                                mediaCodecTypeInfo.maxEncComplexity = -1;
                                mediaCodecTypeInfo.encCBR = encoderCapabilities.isBitrateModeSupported(2);
                                mediaCodecTypeInfo.encVBR = encoderCapabilities.isBitrateModeSupported(1);
                                mediaCodecTypeInfo.encCQ = encoderCapabilities.isBitrateModeSupported(0);
                            }
                        } else {
                            mediaCodecTypeInfo.minEncComplexity = -1;
                            mediaCodecTypeInfo.maxEncComplexity = -1;
                            mediaCodecTypeInfo.encCBR = false;
                            mediaCodecTypeInfo.encVBR = false;
                            mediaCodecTypeInfo.encCQ = false;
                        }
                        if (audioCapabilities != null) {
                            mediaCodecTypeInfo.maxAudioInputChannels = audioCapabilities.getMaxInputChannelCount();
                            mediaCodecTypeInfo.minAudioBitrate = audioCapabilities.getBitrateRange().getLower().intValue();
                            mediaCodecTypeInfo.maxAudioBitrate = audioCapabilities.getBitrateRange().getUpper().intValue();
                            mediaCodecTypeInfo.sampleRateRanges = new ArrayList();
                            Range<Integer>[] supportedSampleRateRanges = audioCapabilities.getSupportedSampleRateRanges();
                            int length3 = supportedSampleRateRanges.length;
                            int i5 = 0;
                            while (i5 < length3) {
                                Range<Integer> range = supportedSampleRateRanges[i5];
                                CapabilityReport.SampleRateRange sampleRateRange = new CapabilityReport.SampleRateRange();
                                sampleRateRange.minRate = range.getLower().intValue();
                                sampleRateRange.maxRate = range.getUpper().intValue();
                                mediaCodecTypeInfo.sampleRateRanges.add(sampleRateRange);
                                i5++;
                                codecInfos = codecInfos;
                            }
                        }
                        mediaCodecInfoArr2 = codecInfos;
                        mediaCodecTypeInfo.adaptivePlayback = capabilitiesForType.isFeatureSupported("adaptive-playback");
                        mediaCodecTypeInfo.intraRefresh = capabilitiesForType.isFeatureSupported("intra-refresh");
                        if (Build.VERSION.SDK_INT >= 23) {
                            mediaCodecTypeInfo.maxSupportedCodecInstances = capabilitiesForType.getMaxSupportedInstances();
                        } else {
                            mediaCodecTypeInfo.maxSupportedCodecInstances = -1;
                        }
                        mediaCodecTypeInfo.profileLevels = new ArrayList();
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                            CapabilityReport.ProfileLevel profileLevel = new CapabilityReport.ProfileLevel();
                            profileLevel.profile = codecProfileLevel.profile;
                            profileLevel.level = codecProfileLevel.level;
                            mediaCodecTypeInfo.profileLevels.add(profileLevel);
                        }
                        if (videoCapabilities != null) {
                            mediaCodecTypeInfo.heightAlignment = videoCapabilities.getHeightAlignment();
                            mediaCodecTypeInfo.widthAlignment = videoCapabilities.getWidthAlignment();
                            mediaCodecTypeInfo.minVideoBitrate = videoCapabilities.getBitrateRange().getLower().intValue();
                            mediaCodecTypeInfo.maxVideoBitrate = videoCapabilities.getBitrateRange().getUpper().intValue();
                            mediaCodecTypeInfo.sizes = new ArrayList();
                            com.nexstreaming.app.general.util.F[] fArr2 = f20142c;
                            int length4 = fArr2.length;
                            int i6 = 0;
                            while (i6 < length4) {
                                com.nexstreaming.app.general.util.F f2 = fArr2[i6];
                                if (videoCapabilities.isSizeSupported(f2.f19820a, f2.f19821b)) {
                                    CapabilityReport.MediaCodecTypeSizeInfo mediaCodecTypeSizeInfo = new CapabilityReport.MediaCodecTypeSizeInfo();
                                    fArr = fArr2;
                                    Range<Double> supportedFrameRatesFor = videoCapabilities.getSupportedFrameRatesFor(f2.f19820a, f2.f19821b);
                                    mediaCodecTypeSizeInfo.width = f2.f19820a;
                                    mediaCodecTypeSizeInfo.height = f2.f19821b;
                                    strArr2 = supportedTypes;
                                    i2 = length2;
                                    mediaCodecTypeSizeInfo.minFps = supportedFrameRatesFor.getLower().doubleValue();
                                    mediaCodecTypeSizeInfo.maxFps = supportedFrameRatesFor.getUpper().doubleValue();
                                    if (Build.VERSION.SDK_INT >= 23) {
                                        Range<Double> achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(f2.f19820a, f2.f19821b);
                                        if (achievableFrameRatesFor != null) {
                                            mediaCodecTypeSizeInfo.minPreviewFps = achievableFrameRatesFor.getLower().doubleValue();
                                            mediaCodecTypeSizeInfo.maxPreviewFps = achievableFrameRatesFor.getUpper().doubleValue();
                                        } else {
                                            mediaCodecTypeSizeInfo.minPreviewFps = -1.0d;
                                            mediaCodecTypeSizeInfo.maxPreviewFps = -1.0d;
                                        }
                                    } else {
                                        mediaCodecTypeSizeInfo.minPreviewFps = -1.0d;
                                        mediaCodecTypeSizeInfo.maxPreviewFps = -1.0d;
                                    }
                                    mediaCodecTypeInfo.sizes.add(mediaCodecTypeSizeInfo);
                                } else {
                                    fArr = fArr2;
                                    strArr2 = supportedTypes;
                                    i2 = length2;
                                }
                                i6++;
                                fArr2 = fArr;
                                supportedTypes = strArr2;
                                length2 = i2;
                            }
                        }
                        strArr = supportedTypes;
                        i = length2;
                        mediaCodecInfo2.types.add(mediaCodecTypeInfo);
                    } else {
                        mediaCodecInfoArr2 = codecInfos;
                        strArr = supportedTypes;
                        i = length2;
                    }
                    i4++;
                    supportedTypes = strArr;
                    codecInfos = mediaCodecInfoArr2;
                    length2 = i;
                }
                mediaCodecInfoArr = codecInfos;
                if (mediaCodecInfo2.types.size() > 0) {
                    arrayList.add(mediaCodecInfo2);
                }
            }
            i3++;
            codecInfos = mediaCodecInfoArr;
        }
        return arrayList;
    }
}
