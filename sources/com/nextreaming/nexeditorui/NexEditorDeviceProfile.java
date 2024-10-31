package com.nextreaming.nexeditorui;

import android.content.Context;
import android.media.CamcorderProfile;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.tracelog.DeviceSupportResponse;
import com.nexstreaming.app.general.util.C1698b;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.codeccaps.CapabilityManager;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import com.nextreaming.nexeditorui.BailActivity;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexVisualClipChecker;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class NexEditorDeviceProfile implements Serializable {
    public static final int UNKNOWN = Integer.MIN_VALUE;

    /* renamed from: a */
    private static Context f24083a = null;

    /* renamed from: b */
    private static NexEditorDeviceProfile f24084b = null;

    /* renamed from: c */
    private static final c[] f24085c = {new c(4096, 2160), new c(3840, 2160), new c(1920, 1080), new c(1920, 1088), new c(1280, 720), new c(1280, 736), new c(960, 540), new c(960, 544), new c(800, 480), new c(864, 480), new c(640, 480), new c(640, 360), new c(640, 368), new c(640, 352), new c(400, 240), new c(ModuleDescriptor.MODULE_VERSION, 240), new c(ModuleDescriptor.MODULE_VERSION, 180), new c(ModuleDescriptor.MODULE_VERSION, 192)};
    private static final long serialVersionUID = 1;
    private final String mBoardPlatform;
    private final int m_MCHWAVCDecBaselineSize;
    private final int m_MCHWAVCDecHighSize;
    private final int m_MCHWAVCDecMainSize;
    private final int m_MCSWAVCDecBaselineSize;
    private final int m_MCSWAVCDecHighSize;
    private final int m_MCSWAVCDecMainSize;
    private final int m_NXSWAVCDecBaselineSize;
    private final int m_NXSWAVCDecHighSize;
    private final int m_NXSWAVCDecMainSize;
    private final int m_audioCodecCount;
    private final DeviceSupportResponse m_dsr;
    private final boolean m_enableProjectProtection;
    private final NexExportProfile[] m_exportExtraProfilesHW;
    private final NexExportProfile[] m_exportExtraProfilesSW;
    private final NexExportProfile[] m_exportProfilesHW;
    private final NexExportProfile[] m_exportProfilesSW;
    private int m_fullHDMaxTransitionTime;
    private final int m_glDepthBufferBits;
    private final boolean m_glMultisample;
    private final int m_hardwareCodecMemSize;
    private final int m_hardwareDecMaxCount;
    private final int m_hardwareEncMaxCount;
    private final MediaRecordingMode m_imageRecording;
    private final boolean m_limitTextInputHeight;
    private final a m_matchInfo;
    private int m_maxCamcorderProfileSizeForUnknownDevice;
    private c m_maxCaptureSize;
    private final int m_maxImportHWSize;
    private final int m_maxImportSWSize;
    private int m_maxSupportedFPS;
    private final boolean m_needSeekBeforeFastPreview;
    private final ProfileSource m_profileSource;
    private final Map<String, String> m_properties;
    private final int m_screenHeight;
    private final int m_screenWidth;
    private final boolean m_support;
    private final boolean m_supportAVC;
    private final int m_supportIfUpgradeVersion;
    private final boolean m_supportMPEGV4;
    private final boolean m_useEditorView;
    private final boolean m_useNativeMediaDB;
    private final boolean m_usedContext;
    private final boolean m_usedDSR;
    private final MediaRecordingMode m_videoRecording;
    private final boolean m_visualMediaFromKineMasterFolderOnly;
    private final int MEM_1080P_SIZE = 2088960;
    private final int MEM_720P_SIZE = 921600;
    private final int MAX_SUPPORTED_FPS = 55;
    private boolean m_bSetUserConfig = true;
    private final int m_forceDirectExport = 0;
    private final int m_nativeLogLevel = 2;
    private final int m_supportedTimeCheker = 1;
    private final int m_deviceMaxLightLevel = 550;
    private final int m_deviceMaxGamma = 550;
    private NexExportProfile[] m_actualSupportedExportProfilesSW = null;
    private NexExportProfile[] m_actualSupportedExportProfilesHW = null;
    private NexExportProfile[] m_actualSupportedExportProfilesFeatures = null;
    private NexExportProfile[] m_actualSupportedExportProfilesResolutions = null;
    private NexExportProfile[] m_actualSupportedExportProfiles = null;
    private boolean registeredFirebaseAnalytics = false;
    private int m_bSupportHevc = -1;
    private int m_bSupportHDR = -1;
    private int m_bSupportHevcEncoder = -1;
    private NexExportProfile m_transcodeProfile = null;
    private boolean mRegisteredVideoLayerSupport = false;
    private int m_minDecSize = 0;
    private int m_maxDecSize = 0;

    /* loaded from: classes.dex */
    public enum MediaRecordingMode {
        Disable,
        UseNative,
        UseKineMaster;

        public static MediaRecordingMode fromValue(int i) {
            if (i == 0) {
                return Disable;
            }
            if (i == 1) {
                return UseNative;
            }
            if (i != 2) {
                return Disable;
            }
            return UseKineMaster;
        }
    }

    /* loaded from: classes.dex */
    public enum ProfileSource {
        Local,
        Server,
        Unknown
    }

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        public int f24086a;

        /* renamed from: b */
        public String f24087b;

        /* renamed from: c */
        public String f24088c;

        /* renamed from: d */
        public String f24089d;

        /* renamed from: e */
        public String f24090e;

        /* renamed from: f */
        public int f24091f;

        /* renamed from: g */
        public int f24092g;

        /* renamed from: h */
        public String f24093h;

        public String a() {
            return "Match Basis:\n    predicate_name: " + String.valueOf(this.f24093h) + "\n    record_number: " + String.valueOf(this.f24086a) + "\n    board_platform: " + String.valueOf(this.f24090e) + "\n    build_device: " + String.valueOf(this.f24088c) + "\n    build_model: " + String.valueOf(this.f24087b) + "\n    os_api_level_min: " + String.valueOf(this.f24091f) + "\n    os_api_level_max: " + String.valueOf(this.f24092g) + "\n    manufacturer: " + String.valueOf(this.f24089d) + "\n";
        }
    }

    /* loaded from: classes.dex */
    public abstract class b {

        /* renamed from: a */
        String f24094a;

        public b(String str) {
            this.f24094a = str;
        }

        abstract boolean a(a aVar, int i);

        public String toString() {
            return "<Predicate " + this.f24094a + ">";
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a */
        public final int f24096a;

        /* renamed from: b */
        public final int f24097b;

        public c(int i, int i2) {
            this.f24096a = i;
            this.f24097b = i2;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return cVar.f24096a == this.f24096a && cVar.f24097b == this.f24097b;
        }

        public int hashCode() {
            return (this.f24096a * 31) + this.f24097b;
        }
    }

    private NexEditorDeviceProfile(Context context, DeviceSupportResponse deviceSupportResponse) {
        CamcorderProfile camcorderProfile;
        C1698b a2;
        int i = 0;
        this.m_maxCamcorderProfileSizeForUnknownDevice = 0;
        this.m_usedContext = context != null;
        this.m_usedDSR = deviceSupportResponse != null;
        if (context != null) {
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            this.m_screenHeight = displayMetrics.heightPixels;
            this.m_screenWidth = displayMetrics.widthPixels;
        } else {
            this.m_screenHeight = 720;
            this.m_screenWidth = 1280;
        }
        this.mBoardPlatform = com.nexstreaming.app.general.util.N.a();
        if (deviceSupportResponse != null && deviceSupportResponse.result == 0 && deviceSupportResponse.match_info != null && deviceSupportResponse.device_info != null) {
            a aVar = new a();
            DeviceSupportResponse.MatchInfo matchInfo = deviceSupportResponse.match_info;
            aVar.f24090e = matchInfo.board_platform;
            aVar.f24088c = matchInfo.build_device;
            aVar.f24087b = matchInfo.build_model;
            aVar.f24089d = matchInfo.manufacturer;
            aVar.f24091f = matchInfo.os_api_level_min;
            aVar.f24092g = matchInfo.os_api_level_max;
            aVar.f24093h = "server";
            aVar.f24086a = matchInfo.record_idx.intValue();
            DeviceSupportResponse.DeviceInfo deviceInfo = deviceSupportResponse.device_info;
            this.m_support = deviceInfo.supported == 1;
            this.m_supportAVC = deviceInfo.support_avc == 3;
            this.m_supportMPEGV4 = deviceInfo.support_mpeg4v == 3;
            this.m_maxSupportedFPS = deviceInfo.max_fps;
            this.m_hardwareCodecMemSize = deviceInfo.max_codec_mem_size;
            this.m_hardwareDecMaxCount = deviceInfo.max_dec_count;
            this.m_hardwareEncMaxCount = deviceInfo.max_enc_count;
            int i2 = deviceInfo.max_fhd_trans_time;
            this.m_imageRecording = MediaRecordingMode.fromValue(deviceInfo.rec_image_mode);
            this.m_videoRecording = MediaRecordingMode.fromValue(deviceInfo.rec_video_mode);
            this.m_audioCodecCount = deviceInfo.audio_codec_count;
            this.m_maxImportSWSize = deviceInfo.max_sw_import_res;
            this.m_maxImportHWSize = deviceInfo.max_hw_import_res;
            this.m_NXSWAVCDecBaselineSize = deviceInfo.max_dec_res_nexsw_b;
            this.m_NXSWAVCDecMainSize = deviceInfo.max_dec_res_nexsw_m;
            this.m_NXSWAVCDecHighSize = deviceInfo.max_dec_res_nexsw_h;
            this.m_MCSWAVCDecBaselineSize = deviceInfo.max_dec_res_sw_b;
            this.m_MCSWAVCDecMainSize = deviceInfo.max_dec_res_sw_m;
            this.m_MCSWAVCDecHighSize = deviceInfo.max_dec_res_sw_h;
            this.m_MCHWAVCDecBaselineSize = deviceInfo.max_dec_res_hw_b;
            this.m_MCHWAVCDecMainSize = deviceInfo.max_dec_res_hw_m;
            this.m_MCHWAVCDecHighSize = deviceInfo.max_dec_res_hw_h;
            this.m_exportProfilesSW = a(deviceInfo.export_res_sw);
            this.m_exportProfilesHW = a(deviceInfo.export_res_hw);
            this.m_exportExtraProfilesHW = a(deviceInfo.export_res_extra);
            this.m_exportExtraProfilesSW = a(deviceInfo.export_res_extra);
            this.m_properties = deviceInfo.properties;
            this.m_fullHDMaxTransitionTime = i2 < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : i2;
            this.m_visualMediaFromKineMasterFolderOnly = false;
            this.m_useNativeMediaDB = true;
            this.m_useEditorView = false;
            this.m_needSeekBeforeFastPreview = true;
            this.m_limitTextInputHeight = false;
            this.m_glMultisample = true;
            this.m_glDepthBufferBits = 16;
            this.m_enableProjectProtection = false;
            this.m_matchInfo = aVar;
            this.m_supportIfUpgradeVersion = 0;
            this.m_profileSource = ProfileSource.Server;
            this.m_dsr = deviceSupportResponse;
            return;
        }
        this.m_dsr = null;
        if (context != null) {
            String str = this.mBoardPlatform;
            a aVar2 = new a();
            b[] bVarArr = {new C2313ia(this, "Device"), new C2315ja(this, "Model"), new C2317ka(this, "Mfg+Chip", str), new C2319la(this, "Mfg"), new C2321ma(this, "Chip", str)};
            C1698b a3 = a(context, aVar2, bVarArr, Build.VERSION.SDK_INT);
            if (a3 != null) {
                this.m_support = a3.a("supported", 0) == 1;
                this.m_supportAVC = a3.a("support_avc", 0) == 3;
                this.m_supportMPEGV4 = a3.a("support_mpeg4v", 0) == 3;
                this.m_maxSupportedFPS = a3.a("max_fps", 0);
                this.m_hardwareCodecMemSize = a3.a("max_codec_mem_size", 0);
                this.m_hardwareDecMaxCount = a3.a("max_dec_count", 0);
                this.m_hardwareEncMaxCount = a3.a("max_enc_count", 0);
                int a4 = a3.a("max_fhd_trans_time", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                this.m_imageRecording = MediaRecordingMode.fromValue(a3.a("rec_image_mode", 0));
                this.m_videoRecording = MediaRecordingMode.fromValue(a3.a("rec_video_mode", 0));
                this.m_audioCodecCount = a3.a("audio_codec_count", 0);
                this.m_maxImportSWSize = a3.a("max_sw_import_res", 0);
                this.m_maxImportHWSize = a3.a("max_hw_import_res", 0);
                this.m_NXSWAVCDecBaselineSize = a3.a("max_dec_res_nexsw_b", 0);
                this.m_NXSWAVCDecMainSize = a3.a("max_dec_res_nexsw_m", 0);
                this.m_NXSWAVCDecHighSize = a3.a("max_dec_res_nexsw_h", 0);
                this.m_MCSWAVCDecBaselineSize = a3.a("max_dec_res_sw_b", 0);
                this.m_MCSWAVCDecMainSize = a3.a("max_dec_res_sw_m", 0);
                this.m_MCSWAVCDecHighSize = a3.a("max_dec_res_sw_h", 0);
                this.m_MCHWAVCDecBaselineSize = a3.a("max_dec_res_hw_b", 0);
                this.m_MCHWAVCDecMainSize = a3.a("max_dec_res_hw_m", 0);
                this.m_MCHWAVCDecHighSize = a3.a("max_dec_res_hw_h", 0);
                this.m_exportProfilesSW = d(a3.a("export_res_sw", (String) null));
                this.m_exportProfilesHW = d(a3.a("export_res_hw", (String) null));
                this.m_exportExtraProfilesHW = d(a3.a("export_res_extra", (String) null));
                this.m_exportExtraProfilesSW = d(a3.a("export_res_extra", (String) null));
                this.m_properties = c(a3.a("properties", (String) null));
                this.m_fullHDMaxTransitionTime = a4 < 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : a4;
                this.m_visualMediaFromKineMasterFolderOnly = false;
                this.m_useNativeMediaDB = true;
                this.m_useEditorView = false;
                this.m_needSeekBeforeFastPreview = true;
                this.m_limitTextInputHeight = false;
                this.m_glMultisample = true;
                this.m_glDepthBufferBits = 16;
                this.m_enableProjectProtection = false;
                this.m_matchInfo = aVar2;
                this.m_profileSource = ProfileSource.Local;
                if (!getIsDeviceSupported() && (a2 = a(context, aVar2, bVarArr, io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT)) != null) {
                    boolean z = a2.a("supported", 0) == 1;
                    boolean z2 = a2.a("support_avc", 0) == 3;
                    boolean z3 = a2.a("support_mpeg4v", 0) == 3;
                    int a5 = a3.a("audio_codec_count", 0);
                    if (z && ((a5 == -1 || a5 >= 6) && (z2 || z3))) {
                        i = a2.a("os_api_level_min", 0);
                    }
                }
                this.m_supportIfUpgradeVersion = i;
                return;
            }
        }
        this.m_videoRecording = MediaRecordingMode.UseKineMaster;
        this.m_imageRecording = MediaRecordingMode.UseNative;
        this.m_supportIfUpgradeVersion = 0;
        this.m_useNativeMediaDB = true;
        this.m_needSeekBeforeFastPreview = true;
        this.m_limitTextInputHeight = false;
        this.m_glDepthBufferBits = 16;
        this.m_glMultisample = true;
        this.m_useEditorView = false;
        this.m_supportAVC = true;
        this.m_support = true;
        this.m_supportMPEGV4 = false;
        this.m_audioCodecCount = -1;
        this.m_matchInfo = null;
        this.m_hardwareDecMaxCount = 1;
        this.m_hardwareEncMaxCount = 1;
        this.m_maxImportSWSize = Integer.MIN_VALUE;
        this.m_maxImportHWSize = Integer.MIN_VALUE;
        this.m_NXSWAVCDecBaselineSize = Integer.MIN_VALUE;
        this.m_NXSWAVCDecMainSize = Integer.MIN_VALUE;
        this.m_NXSWAVCDecHighSize = Integer.MIN_VALUE;
        this.m_MCSWAVCDecBaselineSize = Integer.MIN_VALUE;
        this.m_MCSWAVCDecMainSize = Integer.MIN_VALUE;
        this.m_MCSWAVCDecHighSize = Integer.MIN_VALUE;
        this.m_MCHWAVCDecBaselineSize = Integer.MIN_VALUE;
        this.m_MCHWAVCDecMainSize = Integer.MIN_VALUE;
        this.m_MCHWAVCDecHighSize = Integer.MIN_VALUE;
        this.m_exportProfilesSW = null;
        this.m_exportProfilesHW = null;
        this.m_fullHDMaxTransitionTime = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.m_profileSource = ProfileSource.Unknown;
        this.m_properties = new HashMap();
        int[] iArr = {1, 6, 5, 4, 3, 7};
        int i3 = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (CamcorderProfile.hasProfile(iArr[i4]) && (camcorderProfile = CamcorderProfile.get(iArr[i4])) != null) {
                int i5 = (camcorderProfile.videoFrameHeight + 31) & (-16);
                int i6 = camcorderProfile.videoFrameWidth;
                if (i6 * i5 > i3) {
                    i3 = i6 * i5;
                }
            }
        }
        this.m_maxCamcorderProfileSizeForUnknownDevice = i3;
        int i7 = this.m_maxCamcorderProfileSizeForUnknownDevice;
        if (i7 * 2 > 3133440) {
            this.m_hardwareCodecMemSize = i7 * 2;
        } else {
            this.m_hardwareCodecMemSize = 3133440;
        }
        this.m_maxSupportedFPS = 35;
        NexExportProfile nexExportProfile = NexExportProfile.EXPORT_320_180;
        this.m_exportExtraProfilesSW = new NexExportProfile[]{nexExportProfile};
        this.m_exportExtraProfilesHW = new NexExportProfile[]{nexExportProfile};
        this.m_enableProjectProtection = false;
        this.m_visualMediaFromKineMasterFolderOnly = false;
    }

    private static NexExportProfile[] a(List<DeviceSupportResponse.ExportResInfo> list) {
        NexExportProfile[] nexExportProfileArr = new NexExportProfile[list.size()];
        for (int i = 0; i < nexExportProfileArr.length; i++) {
            DeviceSupportResponse.ExportResInfo exportResInfo = list.get(i);
            int i2 = exportResInfo.width;
            int i3 = exportResInfo.height;
            int i4 = exportResInfo.display_height;
            nexExportProfileArr[i] = new NexExportProfile(i2, i3, i4, exportResInfo.bitrate, NexExportProfile.getLabelResource(i2, i4));
        }
        return nexExportProfileArr;
    }

    private static int b(String str) {
        int i = 0;
        boolean z = true;
        for (String str2 : str.split(Pattern.quote("*"))) {
            if (str2.trim().length() >= 1) {
                try {
                    int parseInt = Integer.parseInt(str2.trim());
                    if (z) {
                        i = parseInt;
                        z = false;
                    } else {
                        i *= parseInt;
                    }
                } catch (NumberFormatException unused) {
                }
            }
        }
        return i;
    }

    private static Map<String, String> c(String str) {
        if (str == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (String str2 : str.split("\\|")) {
            String trim = str2.trim();
            int indexOf = trim.indexOf(61);
            if (indexOf >= 1) {
                hashMap.put(trim.substring(0, indexOf), trim.substring(indexOf + 1));
            }
        }
        return hashMap;
    }

    private static NexExportProfile[] d(String str) {
        if (str == null) {
            return new NexExportProfile[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split("\\|")) {
            String[] split = str2.split(",");
            if (split.length >= 4) {
                try {
                    int parseInt = Integer.parseInt(split[0].trim());
                    int parseInt2 = Integer.parseInt(split[1].trim());
                    int parseInt3 = Integer.parseInt(split[2].trim());
                    int b2 = b(split[3].trim());
                    if (parseInt >= 1 && parseInt2 >= 1 && parseInt3 >= 1 && b2 >= 1) {
                        arrayList.add(new NexExportProfile(parseInt, parseInt2, parseInt3, b2, NexExportProfile.getLabelResource(parseInt, parseInt3)));
                    }
                } catch (NumberFormatException e2) {
                    Log.w("NexEditorDeviceProfile", "parse error; skipping line", e2);
                }
            }
        }
        return (NexExportProfile[]) arrayList.toArray(new NexExportProfile[arrayList.size()]);
    }

    private static String e(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        return trim.length() < 1 ? "" : trim;
    }

    public static NexEditorDeviceProfile getDeviceProfile() {
        if (f24084b == null) {
            f24084b = new NexEditorDeviceProfile(null, null);
        }
        return f24084b;
    }

    public static void setAppContext(Context context) {
        NexEditorDeviceProfile nexEditorDeviceProfile = f24084b;
        if (nexEditorDeviceProfile == null || !(nexEditorDeviceProfile.m_usedContext || nexEditorDeviceProfile.m_usedDSR)) {
            f24083a = context.getApplicationContext();
            f24084b = new NexEditorDeviceProfile(f24083a, null);
        }
    }

    public static void setDeviceSupportResponse(DeviceSupportResponse deviceSupportResponse) {
        NexEditorDeviceProfile nexEditorDeviceProfile = f24084b;
        if (nexEditorDeviceProfile == null || !nexEditorDeviceProfile.m_usedDSR) {
            f24084b = new NexEditorDeviceProfile(f24083a, deviceSupportResponse);
        }
    }

    public boolean IsHDRSupported() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (this.m_bSupportHDR == -1) {
            MediaCodecList mediaCodecList = new MediaCodecList(0);
            this.m_bSupportHDR = 0;
            for (MediaCodecInfo mediaCodecInfo : mediaCodecList.getCodecInfos()) {
                for (String str : mediaCodecInfo.getSupportedTypes()) {
                    if (str.contains("hevc")) {
                        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr = mediaCodecInfo.getCapabilitiesForType("video/hevc").profileLevels;
                        for (int i = 0; i < codecProfileLevelArr.length; i++) {
                            if (codecProfileLevelArr[i].profile == 4096 || codecProfileLevelArr[i].profile == 8192) {
                                this.m_bSupportHDR = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
        return this.m_bSupportHDR == 1;
    }

    public boolean allowOverlappingVideo() {
        return getHardwareDecMaxCount() >= 2;
    }

    public void clearCachedExportProfile() {
        this.m_actualSupportedExportProfilesFeatures = null;
        this.m_actualSupportedExportProfilesResolutions = null;
    }

    public boolean getAVCSupported() {
        return this.m_supportAVC;
    }

    public int getAudioCodecMaxCount() {
        int i = this.m_audioCodecCount;
        if (i == -1) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (i < 0) {
            return 0;
        }
        return i;
    }

    public boolean getBooleanProperty(String str, boolean z) {
        if (!this.m_properties.containsKey(str)) {
            return z;
        }
        String str2 = this.m_properties.get(str);
        if (str2.trim().equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        return !str2.trim().equalsIgnoreCase("false") && getIntProperty(str, z ? 1 : 0) == 1;
    }

    public c getCaptureSize() {
        if (this.m_maxCaptureSize == null) {
            int i = 1920;
            int i2 = 1080;
            int max = Math.max(getMaxImportSize(true), getMaxImportSize(false));
            int i3 = this.m_screenWidth;
            int i4 = this.m_screenHeight;
            int max2 = Math.max(max, (i3 + (i3 / 2)) * (i4 + (i4 / 2)));
            if (2073600 > max2) {
                double d2 = 1920;
                double d3 = max2;
                double sqrt = Math.sqrt(d3);
                Double.isNaN(d2);
                double d4 = 2073600;
                i = (int) ((d2 * sqrt) / Math.sqrt(d4));
                double d5 = 1080;
                double sqrt2 = Math.sqrt(d3);
                Double.isNaN(d5);
                i2 = (int) ((d5 * sqrt2) / Math.sqrt(d4));
            }
            this.m_maxCaptureSize = new c(i, i2);
        }
        return this.m_maxCaptureSize;
    }

    public DeviceSupportResponse getDSR() {
        return this.m_dsr;
    }

    public NexExportProfile getDefaultExportProfile(boolean z) {
        NexExportProfile nexExportProfile;
        NexExportProfile[] supportedExportProfiles = getSupportedExportProfiles(z);
        int length = supportedExportProfiles.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                nexExportProfile = null;
                break;
            }
            nexExportProfile = supportedExportProfiles[i];
            if (nexExportProfile.height() == 720 || nexExportProfile.height() == 736) {
                break;
            }
            i++;
        }
        if (nexExportProfile == null) {
            int length2 = supportedExportProfiles.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length2) {
                    break;
                }
                NexExportProfile nexExportProfile2 = supportedExportProfiles[i2];
                if (nexExportProfile2.height() == 1080 && nexExportProfile2.height() == 1088) {
                    nexExportProfile = nexExportProfile2;
                    break;
                }
                i2++;
            }
        }
        return nexExportProfile == null ? supportedExportProfiles[0] : nexExportProfile;
    }

    public int getDeviceMaxGamma() {
        return 550;
    }

    public int getDeviceMaxLightLevel() {
        return 550;
    }

    public BailActivity.ReasonCode getDeviceNotSupportedReason() {
        if (!this.m_support) {
            return BailActivity.ReasonCode.DeviceNoSupport;
        }
        if (!getAVCSupported() && !getMPEGV4Supported()) {
            return BailActivity.ReasonCode.NoAVCOrMP4Support;
        }
        int i = this.m_audioCodecCount;
        if (i < -1) {
            return BailActivity.ReasonCode.InternalError;
        }
        if (i > -1 && i < 6) {
            return BailActivity.ReasonCode.NotEnoughAudioCodecInstances;
        }
        return BailActivity.ReasonCode.DeviceNoSupportUnknownReason;
    }

    public int[] getDeviceSpecificLimitationStringIds(boolean z) {
        ArrayList arrayList = new ArrayList();
        if (!getSupportsVideoLayers(z)) {
            arrayList.add(Integer.valueOf(R.string.capability_device_spec_limit_no_vlayer));
        }
        if (!allowOverlappingVideo()) {
            arrayList.add(Integer.valueOf(R.string.capability_device_spec_limit_no_overlap));
        }
        if (getFullHDMaxTransitionTime() > 0 && getFullHDMaxTransitionTime() < 30000) {
            arrayList.add(Integer.valueOf(R.string.capability_device_spec_limit_transition));
        }
        a();
        if (this.m_minDecSize != this.m_maxDecSize) {
            arrayList.add(Integer.valueOf(R.string.capability_device_spec_limit_transcode_bl));
        }
        return com.nexstreaming.app.general.util.q.a(arrayList);
    }

    public boolean getEnableProjectProtection() {
        return this.m_enableProjectProtection;
    }

    public int getExtraDurationForSplit() {
        return getIntProperty("extra_split_duration", SemanticAnnotations.SemanticType.ST_SOFTWARE_ID_VALUE);
    }

    public int getForceDirectExport() {
        return 0;
    }

    public int getFullHDMaxTransitionTime() {
        return this.m_fullHDMaxTransitionTime;
    }

    public int getGLDepthBufferBits() {
        return this.m_glDepthBufferBits;
    }

    public boolean getGLMultisample() {
        return this.m_glMultisample;
    }

    public int getHardwareCodecMemSize() {
        if (CapabilityManager.f20040b.e() == CapabilityManager.CapabilitySource.CUSTOM) {
            return CapabilityManager.f20040b.g();
        }
        return CapabilityManager.f20040b.a(this.m_hardwareCodecMemSize);
    }

    public int getHardwareDecMaxCount() {
        if (EditorGlobal.w()) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (CapabilityManager.f20040b.e() == CapabilityManager.CapabilitySource.CUSTOM) {
            return CapabilityManager.f20040b.h();
        }
        return CapabilityManager.f20040b.c(this.m_hardwareDecMaxCount);
    }

    public int getHardwareEncMaxCount() {
        return this.m_hardwareEncMaxCount;
    }

    public MediaRecordingMode getImageRecordingMode() {
        return this.m_imageRecording;
    }

    public int getIntProperty(String str, int i) {
        if (this.m_properties.containsKey(str)) {
            try {
                return Integer.parseInt(this.m_properties.get(str));
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public boolean getIsDeviceSupported() {
        int i;
        return this.m_support && ((i = this.m_audioCodecCount) == -1 || i >= 6) && (getAVCSupported() || getMPEGV4Supported());
    }

    public boolean getIsHevcSupported() {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        if (this.m_bSupportHevc == -1) {
            MediaCodecList mediaCodecList = new MediaCodecList(0);
            this.m_bSupportHevc = 0;
            for (MediaCodecInfo mediaCodecInfo : mediaCodecList.getCodecInfos()) {
                if (mediaCodecInfo.isEncoder() && !mediaCodecInfo.getName().contains("sw") && !mediaCodecInfo.getName().contains("google")) {
                    for (String str : mediaCodecInfo.getSupportedTypes()) {
                        if (str.contains("hevc")) {
                            this.m_bSupportHevc = 1;
                        }
                    }
                }
            }
        }
        return this.m_bSupportHevc == 1;
    }

    public int getLableResource(int i) {
        if (i > 3000) {
            return 0;
        }
        return i > 2000 ? R.string.res_4k : i > 1200 ? R.string.res_qhd : i >= 1080 ? R.string.res_fhd : i >= 720 ? R.string.res_hd : i >= 500 ? R.string.res_sd : R.string.res_low;
    }

    public int getLegacyAudioCodecMaxCount() {
        return this.m_audioCodecCount;
    }

    public int getLegacyFullHDMaxTransitionTime() {
        return this.m_fullHDMaxTransitionTime;
    }

    public int getLegacyHardwareCodecMemSize() {
        return this.m_hardwareCodecMemSize;
    }

    public int getLegacyHardwareDecMaxCount() {
        return this.m_hardwareDecMaxCount;
    }

    public int getLegacyHardwareEncMaxCount() {
        return this.m_hardwareEncMaxCount;
    }

    public MediaRecordingMode getLegacyImageRecordingMode() {
        return this.m_imageRecording;
    }

    public int getLegacyMaxExportHeight() {
        int i = 0;
        for (NexExportProfile nexExportProfile : getSupportedExportProfiles(EditorGlobal.i().b())) {
            i = Math.max(i, nexExportProfile.displayHeight());
        }
        return i;
    }

    public int getLegacyMaxExportHeightWithVideoLayers() {
        if (!isLegacySupportsVideoLayers()) {
            return 0;
        }
        if (getSupportsVideoLayers(EditorGlobal.i().b(), 1920, 1080)) {
            return 1080;
        }
        return getSupportsVideoLayers(EditorGlobal.i().b(), 1280, 720) ? 720 : 0;
    }

    public boolean getLegacyNeedSeekBeforeFastPreview() {
        return this.m_needSeekBeforeFastPreview;
    }

    public boolean getLegacyUseAndroidJPEGDecoder() {
        return getIntProperty("use_android_jpeg_dec", 1) == 1;
    }

    public boolean getLegacyUseMediaExtractor() {
        return getIntProperty("use_mediaextractor", 1) == 1;
    }

    public int getLegacyVideoLayerCount() {
        return isLegacySupportsVideoLayers() ? 2 : 0;
    }

    public MediaRecordingMode getLegacyVideoRecordingMode() {
        return this.m_videoRecording;
    }

    public boolean getLimitTextInputHeight() {
        return this.m_limitTextInputHeight;
    }

    public long getLongProperty(String str, long j) {
        if (this.m_properties.containsKey(str)) {
            try {
                return Long.parseLong(this.m_properties.get(str));
            } catch (NumberFormatException unused) {
            }
        }
        return j;
    }

    public int getMCHWAVCDecBaselineSize() {
        if (CapabilityManager.f20040b.t()) {
            return a(this.m_MCHWAVCDecBaselineSize, (String) null, "MCHWAVCDecBaselineLevelSize");
        }
        int f2 = CapabilityManager.f20040b.f(a(this.m_MCHWAVCDecHighSize, (String) null, "MCHWAVCDecHighLevelSize"));
        return f2 * ((f2 * 16) / 9);
    }

    public int getMCHWAVCDecHighSize() {
        if (CapabilityManager.f20040b.t()) {
            return a(this.m_MCHWAVCDecHighSize, (String) null, "MCHWAVCDecHighLevelSize");
        }
        int f2 = CapabilityManager.f20040b.f(a(this.m_MCHWAVCDecHighSize, (String) null, "MCHWAVCDecHighLevelSize"));
        return f2 * ((f2 * 16) / 9);
    }

    public int getMCHWAVCDecMainSize() {
        if (CapabilityManager.f20040b.t()) {
            return a(this.m_MCHWAVCDecMainSize, (String) null, "MCHWAVCDecMainLevelSize");
        }
        int f2 = CapabilityManager.f20040b.f(a(this.m_MCHWAVCDecHighSize, (String) null, "MCHWAVCDecHighLevelSize"));
        return f2 * ((f2 * 16) / 9);
    }

    public int getMCSWAVCDecBaselineSize() {
        return a(this.m_MCSWAVCDecBaselineSize, "canUseMCSoftwareCodec", "MCSWAVCDecBaselineLevelSize");
    }

    public int getMCSWAVCDecHighSize() {
        return a(this.m_MCSWAVCDecHighSize, "canUseMCSoftwareCodec", "MCSWAVCDecMainLevelSize");
    }

    public int getMCSWAVCDecMainSize() {
        return a(this.m_MCSWAVCDecMainSize, "canUseMCSoftwareCodec", "MCSWAVCDecMainLevelSize");
    }

    public boolean getMPEGV4Supported() {
        return this.m_supportMPEGV4;
    }

    public a getMatchInfo() {
        return this.m_matchInfo;
    }

    public int getMaxAudioTrackCount() {
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public int getMaxCamcorderProfileSizeForUnknownDevice() {
        return this.m_maxCamcorderProfileSizeForUnknownDevice;
    }

    public int getMaxCodecMemSizeForVideoLayers() {
        if (EditorGlobal.w()) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (CapabilityManager.f20040b.e() == CapabilityManager.CapabilitySource.CUSTOM) {
            return (CapabilityManager.f20040b.g() * 15) / 10;
        }
        return CapabilityManager.f20040b.b(this.m_hardwareCodecMemSize);
    }

    public int getMaxDecoderMemorySize(boolean z, int i, int i2, boolean z2) {
        int maxEncoderMemorySize = getMaxEncoderMemorySize(z2);
        int maxCodecMemSizeForVideoLayers = getMaxCodecMemSizeForVideoLayers();
        if (maxEncoderMemorySize * 3 > maxCodecMemSizeForVideoLayers && allowOverlappingVideo()) {
            maxCodecMemSizeForVideoLayers = (maxCodecMemSizeForVideoLayers * 150) / 100;
        }
        if (i2 > 0 && i > 0) {
            maxEncoderMemorySize = ((i * i2) * 150) / 100;
        }
        if (z) {
            maxEncoderMemorySize = 0;
        }
        return maxCodecMemSizeForVideoLayers - maxEncoderMemorySize;
    }

    public int getMaxEncoderMemorySize(boolean z) {
        return EditorGlobal.w() ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : getMaxEncoderMemorySize(z, false);
    }

    public int getMaxExportHeight(boolean z) {
        int i = 0;
        for (NexExportProfile nexExportProfile : getSupportedExportProfiles(z)) {
            i = Math.max(i, nexExportProfile.displayHeight());
        }
        return i;
    }

    public int getMaxExportHeightWithVideoLayers(boolean z) {
        if (!getSupportsVideoLayers(z)) {
            return 0;
        }
        if (getSupportsVideoLayers(z, 1920, 1080)) {
            return 1080;
        }
        return getSupportsVideoLayers(z, 1280, 720) ? 720 : 0;
    }

    public int getMaxImportHeight(boolean z, boolean z2) {
        if (EditorGlobal.w() && !z2) {
            return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        }
        if (CapabilityManager.f20040b.e() == CapabilityManager.CapabilitySource.CUSTOM) {
            return CapabilityManager.f20040b.i();
        }
        return CapabilityManager.f20040b.e(a(getMaxImportSize(z)).f24097b);
    }

    public int getMaxImportSize(boolean z) {
        return getMaxImportSize(z, false);
    }

    public int getMaxSpeedControlFPS(int i, int i2, int i3) {
        int maxSupportedFPS = getMaxSupportedFPS(1280, 720);
        if (maxSupportedFPS < 30) {
            maxSupportedFPS = 30;
        } else if (maxSupportedFPS > 50) {
            maxSupportedFPS = 120;
        }
        int intProperty = getIntProperty("max_speed_control_fps", maxSupportedFPS);
        return CapabilityManager.f20040b.t() ? intProperty : CapabilityManager.f20040b.b(i, i2, i3, intProperty);
    }

    public int getMaxSpeedCtrlValue(int i, int i2) {
        int i3 = i * i2;
        int i4 = (i3 > this.m_maxImportHWSize && i3 > 942080) ? 100 : 150;
        if (CapabilityManager.f20040b.t()) {
            return 150;
        }
        return (CapabilityManager.f20040b.b(i, i2, 30, (i4 * 30) / 100) * 100) / 30;
    }

    public int getMaxSupportedAudioChannels(int i) {
        return getIntProperty("max_supported_audio_channels", i);
    }

    public int getMaxSupportedAudioSamplingRate(int i) {
        return getIntProperty("max_supported_audio_samplingrate", i);
    }

    public int getMaxSupportedFPS() {
        return this.m_maxSupportedFPS;
    }

    public int getMaxSupportedVideoBitrate(int i) {
        return getIntProperty("max_supported_video_bitrate", i);
    }

    public int getMaxTranscodingHeight(boolean z) {
        if (CapabilityManager.f20040b.e() == CapabilityManager.CapabilitySource.CUSTOM) {
            return CapabilityManager.f20040b.j();
        }
        a();
        return CapabilityManager.f20040b.f(a(this.m_maxDecSize).f24097b);
    }

    public int getMaxVideoLayerCount() {
        if (CapabilityManager.f20040b.t()) {
            return getSupportsVideoLayers(usingSoftwareCodec()) ? 2 : 0;
        }
        return CapabilityManager.f20040b.r();
    }

    public int getMinSpeedCtrlValue() {
        return 25;
    }

    public int getNXSWAVCDecBaselineSize() {
        return a(this.m_NXSWAVCDecBaselineSize, "canUseSoftwareCodec", "NXSWAVCDecBaselineLevelSize");
    }

    public int getNXSWAVCDecHighSize() {
        return a(this.m_NXSWAVCDecHighSize, "canUseSoftwareCodec", "NXSWAVCDecHighLevelSize");
    }

    public int getNXSWAVCDecMainSize() {
        return a(this.m_NXSWAVCDecMainSize, "canUseSoftwareCodec", "NXSWAVCDecMainLevelSize");
    }

    public int getNativeLogLevel() {
        return 2;
    }

    public boolean getNeedSeekBeforeFastPreview() {
        return this.m_needSeekBeforeFastPreview;
    }

    public boolean getNeedsColorFormatCheck() {
        return isUnknownDevice() ? Build.VERSION.SDK_INT <= 17 && this.mBoardPlatform.trim().toLowerCase(Locale.US).contains("exynos") : getIntProperty("chk_color_fmt", 0) == 1;
    }

    public ProfileSource getProfileSource() {
        return this.m_profileSource;
    }

    public String getStringProperty(String str, String str2) {
        return this.m_properties.containsKey(str) ? this.m_properties.get(str) : str2;
    }

    public boolean getSupportFrameTimeChecker() {
        return getBooleanProperty("use_frame_time_checker", true);
    }

    public int getSupportIfUpgradeVersion() {
        return this.m_supportIfUpgradeVersion;
    }

    public NexExportProfile[] getSupportedExportProfiles(boolean z) {
        return getSupportedExportProfiles(z, false);
    }

    public NexExportProfile[] getSupportedExtraProfiles(boolean z) {
        if (z) {
            return this.m_exportExtraProfilesSW;
        }
        return this.m_exportExtraProfilesHW;
    }

    public int getSupportedTimeCheker() {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0033, code lost:            if ((((r0 * 150) / 100) * 3) <= (getMaxCodecMemSizeForVideoLayers() - getMaxEncoderMemorySize(r5))) goto L32;     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0035, code lost:            r2 = true;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x003d, code lost:            if (com.nexstreaming.kinemaster.codeccaps.CapabilityManager.f20040b.r() > 0) goto L32;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean getSupportsVideoLayers(boolean r5) {
        /*
            r4 = this;
            com.nexstreaming.kinemaster.codeccaps.CapabilityManager r0 = com.nexstreaming.kinemaster.codeccaps.CapabilityManager.f20040b
            boolean r0 = r0.t()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L37
            java.lang.String r0 = "support_video_layers"
            boolean r3 = r4.isPropertyDefined(r0)
            if (r3 == 0) goto L1a
            boolean r5 = r4.getBooleanProperty(r0, r2)
            r4.a(r5)
            return r5
        L1a:
            int r0 = r4.getMaxImportSize(r5)
            r3 = 2073600(0x1fa400, float:2.905732E-39)
            if (r0 >= r3) goto L24
            goto L40
        L24:
            int r0 = r0 * 150
            int r0 = r0 / 100
            int r5 = r4.getMaxEncoderMemorySize(r5)
            int r3 = r4.getMaxCodecMemSizeForVideoLayers()
            int r3 = r3 - r5
            int r0 = r0 * 3
            if (r0 > r3) goto L40
        L35:
            r2 = 1
            goto L40
        L37:
            com.nexstreaming.kinemaster.codeccaps.CapabilityManager r5 = com.nexstreaming.kinemaster.codeccaps.CapabilityManager.f20040b
            int r5 = r5.r()
            if (r5 <= 0) goto L40
            goto L35
        L40:
            r4.a(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nextreaming.nexeditorui.NexEditorDeviceProfile.getSupportsVideoLayers(boolean):boolean");
    }

    public NexExportProfile getTranscodableProfile(int i, int i2) {
        if (CapabilityManager.f20040b.t()) {
            if (EditorGlobal.i() == null) {
                return null;
            }
            return getTranscodeProfile(EditorGlobal.i().b());
        }
        return a(i, i2);
    }

    public NexExportProfile getTranscodeProfile(boolean z) {
        if (this.m_transcodeProfile == null) {
            this.m_transcodeProfile = getTranscodeProfile(z, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        }
        return this.m_transcodeProfile;
    }

    public boolean getUseAndroidJPEGDecoder() {
        return getIntProperty("use_android_jpeg_dec", 1) == 1;
    }

    public boolean getUseEditorView() {
        return this.m_useEditorView;
    }

    @Deprecated
    public boolean getUseMediaExtractor() {
        return getIntProperty("use_mediaextractor", 1) == 1;
    }

    public boolean getUseNativeMediaDB() {
        return this.m_useNativeMediaDB;
    }

    public boolean getUserConfigSettings() {
        return this.m_bSetUserConfig;
    }

    public String getVideoLayerCountAndResolution(Context context) {
        int i;
        int i2;
        if (CapabilityManager.f20040b.t()) {
            if (getSupportsVideoLayers(usingSoftwareCodec())) {
                return "2 X " + getMaxExportHeightWithVideoLayers(usingSoftwareCodec());
            }
            return context.getResources().getString(R.string.not_supported);
        }
        if (CapabilityManager.f20040b.r() > 0) {
            CapabilityManager capabilityManager = CapabilityManager.f20040b;
            int a2 = capabilityManager.a(capabilityManager.d());
            int p = CapabilityManager.f20040b.p();
            int min = Math.min(a2, (CapabilityManager.f20040b.m() / (((p * 16) / 9) * p)) - 2);
            int[] iArr = {2160, 1080, 720, 540, 360};
            StringBuilder sb = new StringBuilder();
            sb.append(String.format("%d X %dp", Integer.valueOf(min), Integer.valueOf(p)));
            int i3 = 0;
            while (true) {
                if (i3 >= iArr.length) {
                    i = 0;
                    break;
                }
                if (iArr[i3] < p) {
                    i = iArr[i3];
                    int i4 = i3 + 1;
                    if (i4 < iArr.length) {
                        i2 = iArr[i4];
                    }
                } else {
                    i3++;
                }
            }
            i2 = 0;
            CapabilityReport.CapabilityInfo a3 = CapabilityManager.f20040b.a();
            if (i != 0) {
                int min2 = Math.min(Math.max(a(a3.codecInstanceCountByResolutionMinorSkipping, i), a(a3.codecInstanceCountByResolutionNoSkipping, i)) - 2, (CapabilityManager.f20040b.m() / (((i * 16) / 9) * i)) - 2);
                if (min2 <= 0) {
                    min2 = min;
                }
                sb.append("\n");
                sb.append(String.format("%d X %dp", Integer.valueOf(min2), Integer.valueOf(i)));
            }
            if (i2 != 0) {
                int max = Math.max(a(a3.codecInstanceCountByResolutionMinorSkipping, i2), a(a3.codecInstanceCountByResolutionNoSkipping, i2));
                int min3 = Math.min(max == 0 ? getHardwareDecMaxCount() - 2 : max - 2, (CapabilityManager.f20040b.m() / (((i2 * 16) / 9) * i2)) - 2);
                if (min3 > 0) {
                    min = min3;
                }
                sb.append("\n");
                sb.append(String.format("%d X %dp", Integer.valueOf(min), Integer.valueOf(i2)));
            }
            if (i2 != 0 && i2 != 360) {
                sb.append("\n...");
            }
            return sb.toString();
        }
        return context.getResources().getString(R.string.not_supported);
    }

    public MediaRecordingMode getVideoRecordingMode() {
        return this.m_videoRecording;
    }

    public boolean getVisualMediaFromKineMasterFolderOnly() {
        return this.m_visualMediaFromKineMasterFolderOnly;
    }

    public boolean getWaitToGLFinish() {
        return getBooleanProperty("use_wait_gl_finish", false);
    }

    public boolean isLegacySupportsVideoLayers() {
        if (isPropertyDefined("support_video_layers")) {
            return getBooleanProperty("support_video_layers", false);
        }
        int maxImportSize = getMaxImportSize(EditorGlobal.i().b(), true);
        if (maxImportSize >= 2073600) {
            return ((maxImportSize * 150) / 100) * 3 <= this.m_hardwareCodecMemSize - getMaxEncoderMemorySize(EditorGlobal.i().b(), true);
        }
        return false;
    }

    public boolean isPropertyDefined(String str) {
        return this.m_properties.containsKey(str);
    }

    public boolean isUnknownDevice() {
        return !CapabilityManager.f20040b.s() && this.m_profileSource == ProfileSource.Unknown;
    }

    public void registerFirebaseAnalytics(NexEditor nexEditor) {
        if (this.registeredFirebaseAnalytics || nexEditor == null) {
            return;
        }
        this.registeredFirebaseAnalytics = true;
    }

    public void resetTranscodeProfile() {
        if (CapabilityManager.f20040b.t() || this.m_transcodeProfile == null) {
            return;
        }
        this.m_transcodeProfile = null;
    }

    public boolean usingSoftwareCodec() {
        NexEditor s = KineMasterApplication.i().s();
        if (s == null) {
            return false;
        }
        return s.b();
    }

    public int getMaxImportSize(boolean z, boolean z2) {
        int i;
        if (isUnknownDevice()) {
            NexEditor i2 = EditorGlobal.i();
            if (i2 == null) {
                i = this.m_maxCamcorderProfileSizeForUnknownDevice;
            } else {
                int i3 = this.m_maxCamcorderProfileSizeForUnknownDevice;
                if (i3 <= 0) {
                    i = i2.i().g();
                } else {
                    i = Math.min(i3, i2.i().g());
                }
            }
        } else {
            i = z ? this.m_maxImportSWSize : this.m_maxImportHWSize;
        }
        return z2 ? i : CapabilityManager.f20040b.d(i);
    }

    public int getMaxSupportedFPS(int i, int i2) {
        if (CapabilityManager.f20040b.t()) {
            return this.m_maxSupportedFPS;
        }
        return CapabilityManager.f20040b.a(i, i2, this.m_maxSupportedFPS);
    }

    public NexExportProfile[] getSupportedExportProfiles(boolean z, boolean z2) {
        NexExportProfile[] nexExportProfileArr;
        NexExportProfile[] nexExportProfileArr2;
        if (!z2 && !CapabilityManager.f20040b.t()) {
            return a(CapabilityManager.f20040b.d());
        }
        if (z) {
            nexExportProfileArr = this.m_actualSupportedExportProfilesSW;
        } else {
            nexExportProfileArr = this.m_actualSupportedExportProfilesHW;
        }
        if (nexExportProfileArr != null) {
            return a(nexExportProfileArr, z, true);
        }
        if (z) {
            nexExportProfileArr2 = this.m_exportProfilesSW;
        } else {
            nexExportProfileArr2 = this.m_exportProfilesHW;
        }
        if (nexExportProfileArr2 == null) {
            NexEditor i = EditorGlobal.i();
            if (i == null) {
                nexExportProfileArr2 = new NexExportProfile[0];
            } else {
                List<NexExportProfile> exportProfiles = NexExportProfile.getExportProfiles(i.i().d());
                nexExportProfileArr2 = (NexExportProfile[]) exportProfiles.toArray(new NexExportProfile[exportProfiles.size()]);
            }
        }
        if (z) {
            this.m_actualSupportedExportProfilesSW = nexExportProfileArr2;
        } else {
            this.m_actualSupportedExportProfilesHW = nexExportProfileArr2;
        }
        return a(nexExportProfileArr2, z, true);
    }

    public int getMaxEncoderMemorySize(boolean z, boolean z2) {
        int i = 0;
        for (NexExportProfile nexExportProfile : getSupportedExportProfiles(z, z2)) {
            int width = ((nexExportProfile.width() * nexExportProfile.height()) * 150) / 100;
            if (width > i) {
                i = width;
            }
        }
        return i;
    }

    private List<NexExportProfile> b() {
        ArrayList arrayList = new ArrayList();
        int p = CapabilityManager.f20040b.p();
        Iterator<Integer> it = CapabilityManager.f20040b.a().codecInstanceCountByResolution.keySet().iterator();
        while (it.hasNext()) {
            int intValue = it.next().intValue();
            if (intValue <= p && arrayList.size() < 5) {
                int i = (intValue * 16) / 9;
                arrayList.add(new NexExportProfile(i, intValue, intValue, (int) (((((((float) (i * intValue)) * 30.0f) * 2.0f) * 0.07f) / 1000.0f) * 1024.0f), getLableResource(intValue)));
            }
        }
        return arrayList;
    }

    public NexExportProfile getTranscodeProfile(boolean z, int i) {
        int maxImportSize = getMaxImportSize(z);
        NexExportProfile nexExportProfile = null;
        for (NexExportProfile nexExportProfile2 : getSupportedExportProfiles(z)) {
            if (nexExportProfile2.width() * (nexExportProfile2.height() - 31) <= maxImportSize && ((!CapabilityManager.f20040b.t() || (nexExportProfile2.width() <= 1920 && nexExportProfile2.height() <= 1080 && nexExportProfile2.decoderMemoryUsage() <= i)) && (nexExportProfile == null || nexExportProfile.height() < nexExportProfile2.height()))) {
                nexExportProfile = nexExportProfile2;
            }
        }
        return nexExportProfile;
    }

    public boolean a(String str) {
        return str == null || str.trim().length() < 1;
    }

    private C1698b a(Context context, a aVar, b[] bVarArr, int i) {
        C1698b c1698b;
        for (b bVar : bVarArr) {
            aVar.f24093h = bVar.f24094a;
            try {
                c1698b = new C1698b(context.getAssets().open("km_device_support.csv"));
            } catch (IOException e2) {
                Log.e("NexEditorDeviceProfile", "Device Suport - Read Error", e2);
            }
            do {
                try {
                    if (c1698b.b()) {
                        aVar.f24086a = c1698b.a();
                        aVar.f24087b = e(c1698b.a("build_model", (String) null));
                        aVar.f24088c = e(c1698b.a("build_device", (String) null));
                        aVar.f24089d = e(c1698b.a("manufacturer", (String) null));
                        aVar.f24090e = e(c1698b.a("board_platform", (String) null));
                        aVar.f24091f = c1698b.a("os_api_level_min", Integer.MIN_VALUE);
                        aVar.f24092g = c1698b.a("os_api_level_max", ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
                    } else {
                        c1698b.close();
                    }
                } catch (Throwable th) {
                    c1698b.close();
                    throw th;
                }
            } while (!bVar.a(aVar, Build.VERSION.SDK_INT));
            c1698b.close();
            return c1698b;
        }
        return null;
    }

    public boolean getSupportsVideoLayers(boolean z, int i, int i2) {
        if (isPropertyDefined("support_video_layers")) {
            return getBooleanProperty("support_video_layers", false) && getMaxExportHeight(z) >= i2;
        }
        int i3 = i * i2;
        if (getMaxImportSize(z) < i3) {
            return false;
        }
        int i4 = (i3 * 150) / 100;
        return i4 * 3 <= getMaxCodecMemSizeForVideoLayers() - Math.min(i4, getMaxEncoderMemorySize(z));
    }

    public NexExportProfile getTranscodeProfile(int i, int i2) {
        if (!CapabilityManager.f20040b.t()) {
            return a(i, i2);
        }
        throw new IllegalStateException();
    }

    private void b(List<NexExportProfile> list) {
        if (list != null) {
            int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (NexExportProfile nexExportProfile : list) {
                if (nexExportProfile.height() <= i) {
                    i = nexExportProfile.height();
                }
            }
            for (int i2 : new int[]{1440, 1080, 720, 540, 480, 360}) {
                if (i > i2) {
                    a(list, i2);
                }
            }
            return;
        }
        throw new IllegalArgumentException("profileList is null");
    }

    public NexExportProfile getTranscodeProfile(boolean z, int i, int i2) {
        return getTranscodeProfile(z, i, i2, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public NexExportProfile getTranscodeProfile(boolean z, int i, int i2, int i3) {
        int width;
        int i4 = i * i2;
        int i5 = z ? this.m_maxImportSWSize : this.m_maxImportHWSize;
        NexExportProfile nexExportProfile = null;
        int maxImportSize = getMaxImportSize(z);
        NexExportProfile[] supportedExportProfiles = getSupportedExportProfiles(z);
        int length = supportedExportProfiles.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            NexExportProfile nexExportProfile2 = supportedExportProfiles[i6];
            if (nexExportProfile2.width() * (nexExportProfile2.height() - 31) <= maxImportSize && nexExportProfile2.decoderMemoryUsage() <= i3 && (width = nexExportProfile2.width() * nexExportProfile2.height()) <= (i4 * 105) / 100 && width <= i5) {
                nexExportProfile = nexExportProfile2;
                break;
            }
            i6++;
        }
        return nexExportProfile == null ? NexExportProfile.getExportProfiles(i, i2, maxImportSize, i3) : nexExportProfile;
    }

    private int a(int i, String str, String str2) {
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        NexEditor i2 = EditorGlobal.i();
        if (i2 == null) {
            return this.m_maxCamcorderProfileSizeForUnknownDevice;
        }
        if ((str != null && !i2.a(str, false)) || str2 == null) {
            return 0;
        }
        int i3 = this.m_maxCamcorderProfileSizeForUnknownDevice;
        if (i3 <= 0) {
            return i2.b(str2, 0);
        }
        return Math.min(i3, i2.b(str2, 0));
    }

    private void a(List<NexExportProfile> list, int i) {
        if (list.size() >= 5) {
            return;
        }
        int i2 = (i * 16) / 9;
        list.add(new NexExportProfile(i2, i, i, (int) (((((((float) (i2 * i)) * 30.0f) * 2.0f) * 0.07f) / 1000.0f) * 1024.0f), getLableResource(i)));
    }

    private NexExportProfile[] a(CapabilityManager.CapabilityMode capabilityMode) {
        if (capabilityMode != CapabilityManager.CapabilityMode.LEGACY) {
            if (capabilityMode == CapabilityManager.CapabilityMode.MAXIMIZE_FEATURES) {
                if (this.m_actualSupportedExportProfilesFeatures == null) {
                    List<NexExportProfile> b2 = b();
                    b(b2);
                    this.m_actualSupportedExportProfilesFeatures = (NexExportProfile[]) b2.toArray(new NexExportProfile[b2.size()]);
                }
                this.m_actualSupportedExportProfiles = this.m_actualSupportedExportProfilesFeatures;
            } else if (capabilityMode == CapabilityManager.CapabilityMode.MAXIMIZE_RESOLUTION) {
                if (this.m_actualSupportedExportProfilesResolutions == null) {
                    List<NexExportProfile> b3 = b();
                    b(b3);
                    this.m_actualSupportedExportProfilesResolutions = (NexExportProfile[]) b3.toArray(new NexExportProfile[b3.size()]);
                }
                this.m_actualSupportedExportProfiles = this.m_actualSupportedExportProfilesResolutions;
            }
            return this.m_actualSupportedExportProfiles;
        }
        throw new IllegalArgumentException("mode is LEGACY");
    }

    private NexExportProfile[] a(NexExportProfile[] nexExportProfileArr, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList(nexExportProfileArr.length);
        int maxImportSize = getMaxImportSize(z, z2);
        NexExportProfile nexExportProfile = null;
        for (NexExportProfile nexExportProfile2 : nexExportProfileArr) {
            if (nexExportProfile2.width() * (nexExportProfile2.height() - 31) <= maxImportSize) {
                arrayList.add(nexExportProfile2);
            } else if (nexExportProfile == null || nexExportProfile.width() * nexExportProfile.height() > nexExportProfile2.width() * nexExportProfile2.height()) {
                nexExportProfile = nexExportProfile2;
            }
        }
        if (arrayList.size() < 1 && nexExportProfile != null) {
            arrayList.add(nexExportProfile);
        }
        return (NexExportProfile[]) arrayList.toArray(new NexExportProfile[arrayList.size()]);
    }

    private NexExportProfile a(int i, int i2) {
        int a2 = CapabilityManager.a(i, i2);
        NexExportProfile[] supportedExportProfiles = getSupportedExportProfiles(false);
        NexExportProfile nexExportProfile = null;
        for (NexExportProfile nexExportProfile2 : supportedExportProfiles) {
            if (nexExportProfile2.height() <= 1088) {
                int a3 = CapabilityManager.a(nexExportProfile2.width(), nexExportProfile2.height());
                if (nexExportProfile2.height() <= CapabilityManager.f20040b.p() && a3 + a2 <= CapabilityManager.f20040b.m() && (nexExportProfile == null || Math.abs(nexExportProfile2.height() - i2) < Math.abs(nexExportProfile.height() - i2))) {
                    nexExportProfile = nexExportProfile2;
                }
            }
        }
        if (nexExportProfile == null) {
            for (NexExportProfile nexExportProfile3 : supportedExportProfiles) {
                int a4 = CapabilityManager.a(nexExportProfile3.width(), nexExportProfile3.height());
                if (nexExportProfile3.height() <= CapabilityManager.f20040b.p() && a4 + a2 <= CapabilityManager.f20040b.m() && (nexExportProfile == null || Math.abs(nexExportProfile3.height() - i2) < Math.abs(nexExportProfile.height() - i2))) {
                    nexExportProfile = nexExportProfile3;
                }
            }
        }
        return nexExportProfile;
    }

    private boolean a(boolean z) {
        if (this.mRegisteredVideoLayerSupport) {
            return z;
        }
        this.mRegisteredVideoLayerSupport = true;
        return z;
    }

    private void a() {
        NexEditor i;
        if ((this.m_minDecSize <= 0 || this.m_maxDecSize <= 0) && (i = EditorGlobal.i()) != null) {
            NexVisualClipChecker i2 = i.i();
            NexVisualClipChecker.Profile[] values = NexVisualClipChecker.Profile.values();
            int i3 = 0;
            int i4 = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
            for (NexVisualClipChecker.Profile profile : values) {
                int a2 = i2.a(profile);
                i3 = Math.max(i3, a2);
                i4 = Math.min(i4, a2);
            }
            this.m_maxDecSize = i3;
            this.m_minDecSize = i4;
        }
    }

    private static int a(Map<Integer, Integer> map, int i) {
        Integer num;
        if (map == null || (num = map.get(Integer.valueOf(i))) == null) {
            return 0;
        }
        return num.intValue();
    }

    private c a(int i) {
        c cVar = null;
        for (c cVar2 : f24085c) {
            int i2 = cVar2.f24096a;
            int i3 = cVar2.f24097b;
            if (i2 * i3 <= i && (cVar == null || i2 * i3 > cVar.f24096a * cVar.f24097b)) {
                cVar = cVar2;
            }
        }
        return cVar == null ? new c(0, 0) : cVar;
    }
}
