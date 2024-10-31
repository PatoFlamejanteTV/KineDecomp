package com.nextreaming.nexeditorui;

import android.content.Context;
import android.media.CamcorderProfile;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.facebook.internal.ServerProtocol;
import com.nexstreaming.app.general.tracelog.DeviceSupportResponse;
import com.nexstreaming.app.kinemasterfree.R;
import com.nexstreaming.kinemaster.usage.KMUsage;
import com.nextreaming.nexeditorui.BailActivity;
import com.nextreaming.nexvideoeditor.NexEditor;
import com.nextreaming.nexvideoeditor.NexVisualClipChecker;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class NexEditorDeviceProfile implements Serializable {
    public static final int UNKNOWN = Integer.MIN_VALUE;

    /* renamed from: a, reason: collision with root package name */
    private static Context f4481a = null;
    private static NexEditorDeviceProfile b = null;
    private static final c c = new c(1920, 1088);
    private static final c[] d = {new c(4096, 2160), new c(3840, 2160), new c(1920, 1080), new c(1920, 1088), new c(1280, 720), new c(1280, 736), new c(960, 540), new c(960, 544), new c(800, 480), new c(864, 480), new c(640, 480), new c(640, 360), new c(640, 368), new c(640, 352), new c(400, 240), new c(320, 240), new c(320, 180), new c(320, 192)};
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
    private NexExportProfile[] m_actualSupportedExportProfilesSW = null;
    private NexExportProfile[] m_actualSupportedExportProfilesHW = null;
    private NexExportProfile m_transcodeProfile = null;
    private boolean mRegisteredVideoLayerSupport = false;
    private int m_minDecSize = 0;
    private int m_maxDecSize = 0;

    /* loaded from: classes.dex */
    public enum ProfileSource {
        Local,
        Server,
        Unknown
    }

    /* loaded from: classes.dex */
    public enum MediaRecordingMode {
        Disable,
        UseNative,
        UseKineMaster;

        public static MediaRecordingMode fromValue(int i) {
            switch (i) {
                case 0:
                    return Disable;
                case 1:
                    return UseNative;
                case 2:
                    return UseKineMaster;
                default:
                    return Disable;
            }
        }
    }

    public static void setAppContext(Context context) {
        if (b == null || (!b.m_usedContext && !b.m_usedDSR)) {
            f4481a = context.getApplicationContext();
            b = new NexEditorDeviceProfile(f4481a, null);
            a(b);
        }
    }

    public static void setDeviceSupportResponse(DeviceSupportResponse deviceSupportResponse) {
        if (b == null || !b.m_usedDSR) {
            b = new NexEditorDeviceProfile(f4481a, deviceSupportResponse);
            a(b);
        }
    }

    public static NexEditorDeviceProfile getDeviceProfile() {
        if (b == null) {
            b = new NexEditorDeviceProfile(null, null);
            a(b);
        }
        return b;
    }

    private static void a(NexEditorDeviceProfile nexEditorDeviceProfile) {
        try {
            if (nexEditorDeviceProfile.getMatchInfo() == null) {
                JSONObject put = new JSONObject().put("Di Match Pred", "none").put("Di Match Rec", 0).put("Di Mcms", nexEditorDeviceProfile.getMaxCodecMemSizeForVideoLayers()).put("Di Overlap Video", nexEditorDeviceProfile.allowOverlappingVideo());
                KMUsage.getMixpanelInstance(null).a(put);
                KMUsage.getMixpanelPeople(null).a(put);
            } else {
                JSONObject put2 = new JSONObject().put("Di Match Pred", nexEditorDeviceProfile.getMatchInfo().h).put("Di Match Rec", nexEditorDeviceProfile.getMatchInfo().f4482a).put("Di Mcms", nexEditorDeviceProfile.getMaxCodecMemSizeForVideoLayers()).put("Di Overlap Video", nexEditorDeviceProfile.allowOverlappingVideo());
                KMUsage.getMixpanelInstance(null).a(put2);
                KMUsage.getMixpanelPeople(null).a(put2);
            }
        } catch (JSONException e) {
            Log.w("NexEditorDeviceProfile", "MixPanel reporting error", e);
        }
    }

    private static String a(String str) {
        if (str == null) {
            return "";
        }
        String trim = str.trim();
        if (trim.length() < 1) {
            return "";
        }
        return trim;
    }

    private static int b(String str) {
        boolean z = true;
        int i = 0;
        for (String str2 : str.split(Pattern.quote("*"))) {
            if (str2.trim().length() >= 1) {
                try {
                    int parseInt = Integer.parseInt(str2.trim());
                    if (z) {
                        z = false;
                        i = parseInt;
                    } else {
                        i *= parseInt;
                    }
                } catch (NumberFormatException e) {
                }
            }
        }
        return i;
    }

    private static NexExportProfile[] a(List<DeviceSupportResponse.ExportResInfo> list) {
        NexExportProfile[] nexExportProfileArr = new NexExportProfile[list.size()];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < nexExportProfileArr.length) {
                DeviceSupportResponse.ExportResInfo exportResInfo = list.get(i2);
                nexExportProfileArr[i2] = new NexExportProfile(exportResInfo.width, exportResInfo.height, exportResInfo.display_height, exportResInfo.bitrate, NexExportProfile.getLabelResource(exportResInfo.width, exportResInfo.display_height));
                i = i2 + 1;
            } else {
                return nexExportProfileArr;
            }
        }
    }

    private static NexExportProfile[] c(String str) {
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
                } catch (NumberFormatException e) {
                    Log.w("NexEditorDeviceProfile", "parse error; skipping line", e);
                }
            }
        }
        return (NexExportProfile[]) arrayList.toArray(new NexExportProfile[arrayList.size()]);
    }

    private static Map<String, String> d(String str) {
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

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        int f4482a;
        String b;
        String c;
        String d;
        String e;
        int f;
        int g;
        String h;

        public String a() {
            StringBuilder sb = new StringBuilder();
            sb.append("Match Basis:\n");
            sb.append("    predicate_name: ").append(String.valueOf(this.h)).append("\n");
            sb.append("    record_number: ").append(String.valueOf(this.f4482a)).append("\n");
            sb.append("    board_platform: ").append(String.valueOf(this.e)).append("\n");
            sb.append("    build_device: ").append(String.valueOf(this.c)).append("\n");
            sb.append("    build_model: ").append(String.valueOf(this.b)).append("\n");
            sb.append("    os_api_level_min: ").append(String.valueOf(this.f)).append("\n");
            sb.append("    os_api_level_max: ").append(String.valueOf(this.g)).append("\n");
            sb.append("    manufacturer: ").append(String.valueOf(this.d)).append("\n");
            return sb.toString();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class b {
        String c;

        abstract boolean a(a aVar, int i);

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(String str) {
            this.c = str;
        }

        public String toString() {
            return "<Predicate " + this.c + ">";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean e(String str) {
        return str == null || str.trim().length() < 1;
    }

    private com.nexstreaming.app.general.util.a a(Context context, a aVar, b[] bVarArr, int i) {
        com.nexstreaming.app.general.util.a aVar2;
        for (b bVar : bVarArr) {
            aVar.h = bVar.c;
            try {
                aVar2 = new com.nexstreaming.app.general.util.a(context.getAssets().open("km_device_support.csv"));
            } catch (IOException e) {
                Log.e("NexEditorDeviceProfile", "Device Suport - Read Error", e);
            }
            do {
                try {
                    if (aVar2.a()) {
                        aVar.f4482a = aVar2.b();
                        aVar.b = a(aVar2.a("build_model", (String) null));
                        aVar.c = a(aVar2.a("build_device", (String) null));
                        aVar.d = a(aVar2.a("manufacturer", (String) null));
                        aVar.e = a(aVar2.a("board_platform", (String) null));
                        aVar.f = aVar2.a("os_api_level_min", UNKNOWN);
                        aVar.g = aVar2.a("os_api_level_max", Integer.MAX_VALUE);
                    }
                } finally {
                    aVar2.c();
                }
            } while (!bVar.a(aVar, Build.VERSION.SDK_INT));
            return aVar2;
        }
        return null;
    }

    private NexEditorDeviceProfile(Context context, DeviceSupportResponse deviceSupportResponse) {
        CamcorderProfile camcorderProfile;
        com.nexstreaming.app.general.util.a a2;
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
        this.mBoardPlatform = com.nexstreaming.app.general.util.z.g();
        if (deviceSupportResponse != null && deviceSupportResponse.result == 0 && deviceSupportResponse.match_info != null && deviceSupportResponse.device_info != null) {
            a aVar = new a();
            aVar.e = deviceSupportResponse.match_info.board_platform;
            aVar.c = deviceSupportResponse.match_info.build_device;
            aVar.b = deviceSupportResponse.match_info.build_model;
            aVar.d = deviceSupportResponse.match_info.manufacturer;
            aVar.f = deviceSupportResponse.match_info.os_api_level_min;
            aVar.g = deviceSupportResponse.match_info.os_api_level_max;
            aVar.h = "server";
            aVar.f4482a = deviceSupportResponse.match_info.record_idx.intValue();
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
            this.m_fullHDMaxTransitionTime = i2 < 0 ? Integer.MAX_VALUE : i2;
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
            b[] bVarArr = {new bs(this, "Device"), new bt(this, "Model"), new bu(this, "Mfg+Chip", str), new bv(this, "Mfg"), new bw(this, "Chip", str)};
            com.nexstreaming.app.general.util.a a3 = a(context, aVar2, bVarArr, Build.VERSION.SDK_INT);
            if (a3 != null) {
                this.m_support = a3.a("supported", 0) == 1;
                this.m_supportAVC = a3.a("support_avc", 0) == 3;
                this.m_supportMPEGV4 = a3.a("support_mpeg4v", 0) == 3;
                this.m_maxSupportedFPS = a3.a("max_fps", 0);
                this.m_hardwareCodecMemSize = a3.a("max_codec_mem_size", 0);
                this.m_hardwareDecMaxCount = a3.a("max_dec_count", 0);
                this.m_hardwareEncMaxCount = a3.a("max_enc_count", 0);
                int a4 = a3.a("max_fhd_trans_time", Integer.MAX_VALUE);
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
                this.m_exportProfilesSW = c(a3.a("export_res_sw", (String) null));
                this.m_exportProfilesHW = c(a3.a("export_res_hw", (String) null));
                this.m_exportExtraProfilesHW = c(a3.a("export_res_extra", (String) null));
                this.m_exportExtraProfilesSW = c(a3.a("export_res_extra", (String) null));
                this.m_properties = d(a3.a("properties", (String) null));
                this.m_fullHDMaxTransitionTime = a4 < 0 ? Integer.MAX_VALUE : a4;
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
                if (!getIsDeviceSupported() && (a2 = a(context, aVar2, bVarArr, 10000)) != null) {
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
        this.m_maxImportSWSize = UNKNOWN;
        this.m_maxImportHWSize = UNKNOWN;
        this.m_NXSWAVCDecBaselineSize = UNKNOWN;
        this.m_NXSWAVCDecMainSize = UNKNOWN;
        this.m_NXSWAVCDecHighSize = UNKNOWN;
        this.m_MCSWAVCDecBaselineSize = UNKNOWN;
        this.m_MCSWAVCDecMainSize = UNKNOWN;
        this.m_MCSWAVCDecHighSize = UNKNOWN;
        this.m_MCHWAVCDecBaselineSize = UNKNOWN;
        this.m_MCHWAVCDecMainSize = UNKNOWN;
        this.m_MCHWAVCDecHighSize = UNKNOWN;
        this.m_exportProfilesSW = null;
        this.m_exportProfilesHW = null;
        this.m_fullHDMaxTransitionTime = Integer.MAX_VALUE;
        this.m_profileSource = ProfileSource.Unknown;
        this.m_properties = new HashMap();
        int[] iArr = {1, 6, 5, 4, 3, 7};
        int i3 = 0;
        for (int i4 = 0; i4 < iArr.length; i4++) {
            if (CamcorderProfile.hasProfile(iArr[i4]) && (camcorderProfile = CamcorderProfile.get(iArr[i4])) != null) {
                int i5 = (camcorderProfile.videoFrameHeight + 31) & (-16);
                if (camcorderProfile.videoFrameWidth * i5 > i3) {
                    i3 = camcorderProfile.videoFrameWidth * i5;
                }
            }
        }
        this.m_maxCamcorderProfileSizeForUnknownDevice = i3;
        if (this.m_maxCamcorderProfileSizeForUnknownDevice * 2 > 3133440) {
            this.m_hardwareCodecMemSize = this.m_maxCamcorderProfileSizeForUnknownDevice * 2;
        } else {
            this.m_hardwareCodecMemSize = 3133440;
        }
        this.m_maxSupportedFPS = 35;
        this.m_exportExtraProfilesSW = new NexExportProfile[]{NexExportProfile.EXPORT_320_180};
        this.m_exportExtraProfilesHW = new NexExportProfile[]{NexExportProfile.EXPORT_320_180};
        this.m_enableProjectProtection = false;
        this.m_visualMediaFromKineMasterFolderOnly = false;
    }

    public ProfileSource getProfileSource() {
        return this.m_profileSource;
    }

    public boolean isUnknownDevice() {
        return this.m_profileSource == ProfileSource.Unknown;
    }

    public int getMaxImportSize(boolean z) {
        if (!isUnknownDevice()) {
            return z ? this.m_maxImportSWSize : this.m_maxImportHWSize;
        }
        NexEditor a2 = EditorGlobal.a();
        if (a2 == null) {
            return this.m_maxCamcorderProfileSizeForUnknownDevice;
        }
        if (this.m_maxCamcorderProfileSizeForUnknownDevice <= 0) {
            return a2.d().a();
        }
        return Math.min(this.m_maxCamcorderProfileSizeForUnknownDevice, a2.d().a());
    }

    private int a(int i, String str, String str2) {
        if (i == Integer.MIN_VALUE) {
            NexEditor a2 = EditorGlobal.a();
            if (a2 == null) {
                return this.m_maxCamcorderProfileSizeForUnknownDevice;
            }
            if ((str == null || a2.a(str, false)) && str2 != null) {
                if (this.m_maxCamcorderProfileSizeForUnknownDevice <= 0) {
                    return a2.a(str2, 0);
                }
                return Math.min(this.m_maxCamcorderProfileSizeForUnknownDevice, a2.a(str2, 0));
            }
            return 0;
        }
        return i;
    }

    public int getMaxCamcorderProfileSizeForUnknownDevice() {
        return this.m_maxCamcorderProfileSizeForUnknownDevice;
    }

    public int getNXSWAVCDecBaselineSize() {
        return a(this.m_NXSWAVCDecBaselineSize, "canUseSoftwareCodec", "NXSWAVCDecBaselineLevelSize");
    }

    public int getNXSWAVCDecMainSize() {
        return a(this.m_NXSWAVCDecMainSize, "canUseSoftwareCodec", "NXSWAVCDecMainLevelSize");
    }

    public int getNXSWAVCDecHighSize() {
        return a(this.m_NXSWAVCDecHighSize, "canUseSoftwareCodec", "NXSWAVCDecHighLevelSize");
    }

    public int getMCSWAVCDecBaselineSize() {
        return a(this.m_MCSWAVCDecBaselineSize, "canUseMCSoftwareCodec", "MCSWAVCDecBaselineLevelSize");
    }

    public int getMCSWAVCDecMainSize() {
        return a(this.m_MCSWAVCDecMainSize, "canUseMCSoftwareCodec", "MCSWAVCDecMainLevelSize");
    }

    public int getMCSWAVCDecHighSize() {
        return a(this.m_MCSWAVCDecHighSize, "canUseMCSoftwareCodec", "MCSWAVCDecMainLevelSize");
    }

    public int getMCHWAVCDecBaselineSize() {
        return a(this.m_MCHWAVCDecBaselineSize, null, "MCHWAVCDecBaselineLevelSize");
    }

    public int getMCHWAVCDecMainSize() {
        return a(this.m_MCHWAVCDecMainSize, null, "MCHWAVCDecMainLevelSize");
    }

    public int getMCHWAVCDecHighSize() {
        return a(this.m_MCHWAVCDecHighSize, null, "MCHWAVCDecHighLevelSize");
    }

    public int getMaxSupportedFPS() {
        return this.m_maxSupportedFPS;
    }

    public int getFullHDMaxTransitionTime() {
        return this.m_fullHDMaxTransitionTime;
    }

    public MediaRecordingMode getImageRecordingMode() {
        return this.m_imageRecording;
    }

    public MediaRecordingMode getVideoRecordingMode() {
        return this.m_videoRecording;
    }

    public boolean getUseNativeMediaDB() {
        return this.m_useNativeMediaDB;
    }

    public boolean getUseEditorView() {
        return this.m_useEditorView;
    }

    public int getMaxSpeedControlFPS() {
        int i = 30;
        int maxSupportedFPS = getMaxSupportedFPS();
        if (maxSupportedFPS >= 30) {
            i = maxSupportedFPS > 50 ? 120 : maxSupportedFPS;
        }
        return getIntProperty("max_speed_control_fps", i);
    }

    public NexExportProfile[] getSupportedExportProfiles(boolean z) {
        NexExportProfile[] nexExportProfileArr;
        NexExportProfile[] nexExportProfileArr2;
        if (z) {
            nexExportProfileArr = this.m_actualSupportedExportProfilesSW;
        } else {
            nexExportProfileArr = this.m_actualSupportedExportProfilesHW;
        }
        if (nexExportProfileArr != null) {
            return a(nexExportProfileArr, z);
        }
        if (z) {
            nexExportProfileArr2 = this.m_exportProfilesSW;
        } else {
            nexExportProfileArr2 = this.m_exportProfilesHW;
        }
        if (nexExportProfileArr2 == null) {
            NexEditor a2 = EditorGlobal.a();
            if (a2 == null) {
                nexExportProfileArr2 = new NexExportProfile[0];
            } else {
                List<NexExportProfile> exportProfiles = NexExportProfile.getExportProfiles(a2.d().e());
                nexExportProfileArr2 = (NexExportProfile[]) exportProfiles.toArray(new NexExportProfile[exportProfiles.size()]);
            }
        }
        if (z) {
            this.m_actualSupportedExportProfilesSW = nexExportProfileArr2;
        } else {
            this.m_actualSupportedExportProfilesHW = nexExportProfileArr2;
        }
        return a(nexExportProfileArr2, z);
    }

    private NexExportProfile[] a(NexExportProfile[] nexExportProfileArr, boolean z) {
        ArrayList arrayList = new ArrayList(nexExportProfileArr.length);
        int maxImportSize = getMaxImportSize(z);
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

    public NexExportProfile[] getSupportedExtraProfiles(boolean z) {
        return z ? this.m_exportExtraProfilesSW : this.m_exportExtraProfilesHW;
    }

    public NexExportProfile getDefaultExportProfile(boolean z) {
        NexExportProfile nexExportProfile;
        NexExportProfile nexExportProfile2;
        NexExportProfile[] supportedExportProfiles = getSupportedExportProfiles(z);
        if (0 == 0) {
            int length = supportedExportProfiles.length;
            for (int i = 0; i < length; i++) {
                nexExportProfile = supportedExportProfiles[i];
                if (nexExportProfile.height() == 720 || nexExportProfile.height() == 736) {
                    break;
                }
            }
        }
        nexExportProfile = null;
        if (nexExportProfile == null) {
            int length2 = supportedExportProfiles.length;
            for (int i2 = 0; i2 < length2; i2++) {
                nexExportProfile2 = supportedExportProfiles[i2];
                if (nexExportProfile2.height() == 1080 && nexExportProfile2.height() == 1088) {
                    break;
                }
            }
        }
        nexExportProfile2 = nexExportProfile;
        if (nexExportProfile2 == null) {
            return supportedExportProfiles[0];
        }
        return nexExportProfile2;
    }

    public boolean getEnableProjectProtection() {
        return this.m_enableProjectProtection;
    }

    public boolean getVisualMediaFromKineMasterFolderOnly() {
        return this.m_visualMediaFromKineMasterFolderOnly;
    }

    public boolean getNeedSeekBeforeFastPreview() {
        return this.m_needSeekBeforeFastPreview;
    }

    public boolean getLimitTextInputHeight() {
        return this.m_limitTextInputHeight;
    }

    public int getGLDepthBufferBits() {
        return this.m_glDepthBufferBits;
    }

    public boolean getGLMultisample() {
        return this.m_glMultisample;
    }

    public int getHardwareCodecMemSize() {
        return this.m_hardwareCodecMemSize;
    }

    public int getMaxCodecMemSizeForVideoLayers() {
        return this.m_hardwareCodecMemSize;
    }

    public int getHardwareDecMaxCount() {
        return this.m_hardwareDecMaxCount;
    }

    public boolean allowOverlappingVideo() {
        return getHardwareDecMaxCount() >= 2;
    }

    public int getHardwareEncMaxCount() {
        return this.m_hardwareEncMaxCount;
    }

    public c getTranscodeMaxInputResolution(boolean z) {
        return c;
    }

    public NexExportProfile getTranscodeProfile(boolean z) {
        if (this.m_transcodeProfile == null) {
            this.m_transcodeProfile = getTranscodeProfile(z, Integer.MAX_VALUE);
        }
        return this.m_transcodeProfile;
    }

    public NexExportProfile getTranscodeProfile(boolean z, int i) {
        int maxImportSize = getMaxImportSize(z);
        NexExportProfile nexExportProfile = null;
        for (NexExportProfile nexExportProfile2 : getSupportedExportProfiles(z)) {
            if (nexExportProfile2.width() * (nexExportProfile2.height() - 31) <= maxImportSize && nexExportProfile2.width() <= 1920 && nexExportProfile2.height() <= 1088 && nexExportProfile2.decoderMemoryUsage() <= i && (nexExportProfile == null || nexExportProfile.height() < nexExportProfile2.height())) {
                nexExportProfile = nexExportProfile2;
            }
        }
        return nexExportProfile;
    }

    public NexExportProfile getTranscodeProfile(boolean z, int i, int i2) {
        return getTranscodeProfile(z, i, i2, Integer.MAX_VALUE);
    }

    public NexExportProfile getTranscodeProfile(boolean z, int i, int i2, int i3) {
        NexExportProfile nexExportProfile;
        int width;
        int i4 = i * i2;
        int i5 = z ? this.m_maxImportSWSize : this.m_maxImportHWSize;
        int maxImportSize = getMaxImportSize(z);
        NexExportProfile[] supportedExportProfiles = getSupportedExportProfiles(z);
        int length = supportedExportProfiles.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                nexExportProfile = null;
                break;
            }
            NexExportProfile nexExportProfile2 = supportedExportProfiles[i6];
            if (nexExportProfile2.width() * (nexExportProfile2.height() - 31) <= maxImportSize && nexExportProfile2.decoderMemoryUsage() <= i3 && (width = nexExportProfile2.width() * nexExportProfile2.height()) <= (i4 * 105) / 100 && width <= i5) {
                nexExportProfile = nexExportProfile2;
                break;
            }
            i6++;
        }
        if (nexExportProfile == null) {
            return NexExportProfile.getExportProfiles(i, i2, maxImportSize, i3);
        }
        return nexExportProfile;
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: a, reason: collision with root package name */
        public final int f4483a;
        public final int b;

        public c(int i, int i2) {
            this.f4483a = i;
            this.b = i2;
        }

        public int hashCode() {
            return (this.f4483a * 31) + this.b;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return ((c) obj).f4483a == this.f4483a && ((c) obj).b == this.b;
            }
            return false;
        }
    }

    public int getMaxSpeedCtrlValue(int i, int i2) {
        return (i * i2 > this.m_maxImportHWSize && i * i2 > 942080) ? 100 : 150;
    }

    public int getMinSpeedCtrlValue() {
        return 25;
    }

    public int getExtraDurationForSplit() {
        return getIntProperty("extra_split_duration", 1500);
    }

    public boolean getAVCSupported() {
        return this.m_supportAVC;
    }

    public boolean getMPEGV4Supported() {
        return this.m_supportMPEGV4;
    }

    public boolean getNeedsColorFormatCheck() {
        return isUnknownDevice() ? Build.VERSION.SDK_INT <= 17 && this.mBoardPlatform.trim().toLowerCase(Locale.US).contains("exynos") : getIntProperty("chk_color_fmt", 0) == 1;
    }

    public String getStringProperty(String str, String str2) {
        return this.m_properties.containsKey(str) ? this.m_properties.get(str) : str2;
    }

    public int getIntProperty(String str, int i) {
        if (this.m_properties.containsKey(str)) {
            try {
                return Integer.parseInt(this.m_properties.get(str));
            } catch (NumberFormatException e) {
                return i;
            }
        }
        return i;
    }

    public boolean isPropertyDefined(String str) {
        return this.m_properties.containsKey(str);
    }

    public boolean getBooleanProperty(String str, boolean z) {
        if (!this.m_properties.containsKey(str)) {
            return z;
        }
        String str2 = this.m_properties.get(str);
        if (str2.trim().equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)) {
            return true;
        }
        if (str2.trim().equalsIgnoreCase("false")) {
            return false;
        }
        return getIntProperty(str, z ? 1 : 0) == 1;
    }

    public long getLongProperty(String str, long j) {
        if (this.m_properties.containsKey(str)) {
            try {
                return Long.parseLong(this.m_properties.get(str));
            } catch (NumberFormatException e) {
                return j;
            }
        }
        return j;
    }

    public a getMatchInfo() {
        return this.m_matchInfo;
    }

    public int getAudioCodecMaxCount() {
        if (this.m_audioCodecCount == -1) {
            return Integer.MAX_VALUE;
        }
        if (this.m_audioCodecCount < 0) {
            return 0;
        }
        return this.m_audioCodecCount;
    }

    public boolean getIsDeviceSupported() {
        return this.m_support && (this.m_audioCodecCount == -1 || this.m_audioCodecCount >= 6) && (getAVCSupported() || getMPEGV4Supported());
    }

    public int getSupportIfUpgradeVersion() {
        return this.m_supportIfUpgradeVersion;
    }

    public BailActivity.ReasonCode getDeviceNotSupportedReason() {
        if (!this.m_support) {
            return BailActivity.ReasonCode.DeviceNoSupport;
        }
        if (!getAVCSupported() && !getMPEGV4Supported()) {
            return BailActivity.ReasonCode.NoAVCOrMP4Support;
        }
        if (this.m_audioCodecCount < -1) {
            return BailActivity.ReasonCode.InternalError;
        }
        if (this.m_audioCodecCount > -1 && this.m_audioCodecCount < 6) {
            return BailActivity.ReasonCode.NotEnoughAudioCodecInstances;
        }
        return BailActivity.ReasonCode.DeviceNoSupportUnknownReason;
    }

    public boolean getUseAndroidJPEGDecoder() {
        return getIntProperty("use_android_jpeg_dec", 1) == 1;
    }

    public int getMaxSupportedVideoBitrate(int i) {
        return getIntProperty("max_supported_video_bitrate", i);
    }

    public int getMaxSupportedAudioSamplingRate(int i) {
        return getIntProperty("max_supported_audio_samplingrate", i);
    }

    public int getMaxSupportedAudioChannels(int i) {
        return getIntProperty("max_supported_audio_channels", i);
    }

    private boolean a(boolean z) {
        if (!this.mRegisteredVideoLayerSupport) {
            this.mRegisteredVideoLayerSupport = true;
            try {
                KMUsage.getMixpanelInstance(null).a(new JSONObject().put("Di Video Layers", z));
            } catch (JSONException e) {
                Log.w("NexEditorDeviceProfile", "MixPanel reporting error", e);
            }
        }
        return z;
    }

    public boolean getSupportsVideoLayers(boolean z) {
        if (isPropertyDefined("support_video_layers")) {
            return a(getBooleanProperty("support_video_layers", false));
        }
        int maxImportSize = getMaxImportSize(z);
        if (maxImportSize < 2073600) {
            return a(false);
        }
        return a(((maxImportSize * 150) / 100) * 3 <= getMaxCodecMemSizeForVideoLayers() - getMaxEncoderMemorySize(z));
    }

    public boolean getWaitToGLFinish() {
        return getBooleanProperty("use_wait_gl_finish", false);
    }

    public boolean getSupportFrameTimeChecker() {
        return getBooleanProperty("use_frame_time_checker", true);
    }

    public boolean getSupportsVideoLayers(boolean z, int i, int i2) {
        if (isPropertyDefined("support_video_layers")) {
            return getBooleanProperty("support_video_layers", false);
        }
        if (getMaxImportSize(z) >= i * i2) {
            return (((i * i2) * 150) / 100) * 3 <= getMaxCodecMemSizeForVideoLayers() - Math.min(((i * i2) * 150) / 100, getMaxEncoderMemorySize(z));
        }
        return false;
    }

    public int getMaxEncoderMemorySize(boolean z) {
        NexExportProfile[] supportedExportProfiles = getSupportedExportProfiles(z);
        int length = supportedExportProfiles.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            NexExportProfile nexExportProfile = supportedExportProfiles[i];
            int height = ((nexExportProfile.height() * nexExportProfile.width()) * 150) / 100;
            if (height <= i2) {
                height = i2;
            }
            i++;
            i2 = height;
        }
        return i2;
    }

    public boolean getUseMediaExtractor() {
        return getIntProperty("use_mediaextractor", 1) == 1;
    }

    public DeviceSupportResponse getDSR() {
        return this.m_dsr;
    }

    public c getCaptureSize() {
        if (this.m_maxCaptureSize == null) {
            int i = 1920;
            int i2 = 1080;
            int max = Math.max(Math.max(getMaxImportSize(true), getMaxImportSize(false)), (this.m_screenWidth + (this.m_screenWidth / 2)) * (this.m_screenHeight + (this.m_screenHeight / 2)));
            if (2073600 > max) {
                i = (int) ((1920 * Math.sqrt(max)) / Math.sqrt(2073600));
                i2 = (int) ((1080 * Math.sqrt(max)) / Math.sqrt(2073600));
            }
            this.m_maxCaptureSize = new c(i, i2);
        }
        return this.m_maxCaptureSize;
    }

    public int getMaxImportHeight(boolean z) {
        return a(getMaxImportSize(z)).b;
    }

    private void a() {
        NexEditor a2;
        if ((this.m_minDecSize <= 0 || this.m_maxDecSize <= 0) && (a2 = EditorGlobal.a()) != null) {
            NexVisualClipChecker d2 = a2.d();
            int i = Integer.MAX_VALUE;
            int i2 = 0;
            for (NexVisualClipChecker.Profile profile : NexVisualClipChecker.Profile.values()) {
                int a3 = d2.a(profile);
                i2 = Math.max(i2, a3);
                i = Math.min(i, a3);
            }
            this.m_maxDecSize = i2;
            this.m_minDecSize = i;
        }
    }

    public int getMaxTranscodingHeight(boolean z) {
        a();
        return a(this.m_maxDecSize).b;
    }

    public int getMaxExportHeight(boolean z) {
        int i = 0;
        for (NexExportProfile nexExportProfile : getSupportedExportProfiles(z)) {
            i = Math.max(i, nexExportProfile.displayHeight());
        }
        return i;
    }

    public int getMaxExportHeightWithVideoLayers(boolean z) {
        if (getSupportsVideoLayers(z)) {
            return (getSupportsVideoLayers(z, 1920, 1080) || getSupportsVideoLayers(z, 1280, 720)) ? 1080 : 0;
        }
        return 0;
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
        return com.nexstreaming.app.general.util.l.a(arrayList);
    }

    private c a(int i) {
        c cVar = null;
        for (c cVar2 : d) {
            if (cVar2.f4483a * cVar2.b <= i && (cVar == null || cVar2.f4483a * cVar2.b > cVar.f4483a * cVar.b)) {
                cVar = cVar2;
            }
        }
        return cVar;
    }
}
