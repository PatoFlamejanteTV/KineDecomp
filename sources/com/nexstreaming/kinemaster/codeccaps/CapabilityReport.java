package com.nexstreaming.kinemaster.codeccaps;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class CapabilityReport {
    public CapabilityInfo capabilityInfo;
    public int capabilityTestVersion;
    public DeviceInfo deviceInfo;
    public CapabilityInfo heuristicBasedCapabilityInfo;
    public LegacyDeviceProfile legacyDeviceProfile;
    public TestResults testResults;

    /* loaded from: classes.dex */
    public static class CapabilityInfo {
        private static int[] rs = {2160, 1440, 1080, 720, 540, 480, 360};
        public Map<Integer, Integer> codecInstanceCountByResolution;
        public Map<Integer, Integer> codecInstanceCountByResolutionMinorSkipping;
        public Map<Integer, Integer> codecInstanceCountByResolutionNoSkipping;
        public boolean deviceSupported;
        public boolean legacyOnly;
        public int maxCodecCount;
        public int maxCodecCountAtMaxImportRes;
        public int maxCodecCountAtMaxImportResNoOverlap;
        public int maxCodecCountAtMaxImportResNoSkipping;
        public int maxCodecCountAtMaxImportResWithOverlap;
        public int maxCodecMemorySize;
        public int maxDetectedImportResolutionNoOverlap;
        public int maxDetectedImportResolutionWithOverlap;
        public int maxExportResolution;
        public int maxImportResolutionNoOverlap;
        public int maxImportResolutionWithOverlap;
        public int maxPlaybackCodecMemorySize;
        public int maxResolution;
        public int maxTranscodeResolution;
        public int minResolution;
        public boolean supportHighProfile;
        public int supportLevel;
        public String supportLevelName;
        public int versionNum;

        public static void calcSupportLevel(CapabilityInfo capabilityInfo) {
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

        public static CapabilityInfo fromInfo(c.c.a.a.a.b.b.a.a.a aVar) {
            CapabilityInfo capabilityInfo = new CapabilityInfo();
            capabilityInfo.deviceSupported = true;
            capabilityInfo.supportHighProfile = aVar.f3525e == 1;
            capabilityInfo.maxCodecMemorySize = aVar.f3521a;
            int i = capabilityInfo.maxCodecMemorySize;
            capabilityInfo.maxPlaybackCodecMemorySize = i;
            capabilityInfo.maxResolution = aVar.f3522b;
            capabilityInfo.minResolution = 360;
            int i2 = capabilityInfo.maxResolution;
            int i3 = (i / i2) / ((i2 / 9) * 16);
            if (i3 <= 2) {
                i2 = getStepLowResolution(i2);
            }
            int i4 = capabilityInfo.maxCodecMemorySize;
            capabilityInfo.maxImportResolutionWithOverlap = i2;
            int i5 = capabilityInfo.maxResolution;
            capabilityInfo.maxImportResolutionNoOverlap = i5;
            capabilityInfo.maxDetectedImportResolutionWithOverlap = i2;
            capabilityInfo.maxDetectedImportResolutionNoOverlap = i5;
            capabilityInfo.maxExportResolution = aVar.f3523c;
            capabilityInfo.maxTranscodeResolution = aVar.f3524d;
            capabilityInfo.maxCodecCount = aVar.f3526f;
            capabilityInfo.maxCodecCountAtMaxImportRes = i3;
            capabilityInfo.maxCodecCountAtMaxImportResNoSkipping = i3;
            capabilityInfo.maxCodecCountAtMaxImportResWithOverlap = (i4 / i2) / ((i2 / 9) * 16);
            capabilityInfo.maxCodecCountAtMaxImportResNoOverlap = i3;
            capabilityInfo.maxResolution = capabilityInfo.maxTranscodeResolution;
            capabilityInfo.codecInstanceCountByResolution = getInstanceOfRes(i4, capabilityInfo.maxResolution, capabilityInfo.maxCodecCount);
            capabilityInfo.codecInstanceCountByResolutionMinorSkipping = getInstanceOfRes(capabilityInfo.maxCodecMemorySize, capabilityInfo.maxResolution, capabilityInfo.maxCodecCount);
            capabilityInfo.codecInstanceCountByResolutionNoSkipping = getInstanceOfRes(capabilityInfo.maxCodecMemorySize, capabilityInfo.maxResolution, capabilityInfo.maxCodecCount);
            capabilityInfo.legacyOnly = false;
            calcSupportLevel(capabilityInfo);
            return capabilityInfo;
        }

        private static Map<Integer, Integer> getInstanceOfRes(int i, int i2, int i3) {
            int i4;
            TreeMap treeMap = new TreeMap(Collections.reverseOrder());
            for (int i5 : rs) {
                if (i5 <= i2 && (i4 = i / (((i5 / 9) * 16) * i5)) > 0) {
                    if (i4 > i3) {
                        i4 = i3;
                    }
                    treeMap.put(Integer.valueOf(i5), Integer.valueOf(i4));
                }
            }
            return treeMap;
        }

        private static int getStepLowResolution(int i) {
            for (int i2 : rs) {
                if (i2 < i) {
                    return i2;
                }
            }
            return 0;
        }
    }

    /* loaded from: classes.dex */
    public static class DeviceInfo {
        public String board_platform;
        public String brand;
        public String chipset;
        public String chipset_src;
        public String cpuinfo_architecture;
        public String cpuinfo_features;
        public String cpuinfo_hardware;
        public String cpuinfo_implementer;
        public String cpuinfo_part;
        public String cpuinfo_processor;
        public String cpuinfo_revision;
        public String cpuinfo_variant;
        public float density;
        public int densityDpi;
        public String hardware;
        public boolean longScreen;
        public String manufacturer;
        public List<MediaCodecInfo> mediaCodecCapabilities;
        public long memoryThreshold;
        public String model;
        public String mtk_platform;
        public String osVersion;
        public String product;
        public String product_board;
        public int screenHeightDP;
        public int screenHeightPixels;
        public String screenSize;
        public int screenWidthDP;
        public int screenWidthPixels;
        public int sdkLevel;
        public long totalMemory;
        public float xdpi;
        public float ydpi;
    }

    /* loaded from: classes.dex */
    public static class EncodeTestResult {
        public int codecLevel;
        public int codecMemoryUsage;
        public int codecProfile;
        public int dropFrameRatio;
        public long droppedFrames;
        public long frameWaitTimeouts;
        public int outputRes;
        public int renderedFrames;
        public int resultCode;
        public String resultCodeName;
        public boolean success;
        public int testElapsedTime;
        public int totalFrames;
    }

    /* loaded from: classes.dex */
    public static class ExportTestResult {
        public int codecMemoryUsage;
        public int dropFrameRatio;
        public long droppedFrames;
        public long frameWaitTimeouts;
        public int inputRes;
        public int outputRes;
        public int renderedFrames;
        public int resultCode;
        public String resultCodeName;
        public boolean success;
        public int testElapsedTime;
        public int totalFrames;
    }

    /* loaded from: classes.dex */
    public static class LegacyDeviceProfile {
        public int audioCodecMax;
        public int captureSize;
        public int fullHDMaxTransitionTime;
        public int hwCodecMemorySize;
        public int hwDecMaxCount;
        public int hwEncMaxCount;
        public String imageRec;
        public List<LegacyExportProfile> legacyExportProfiles;
        public String match;
        public LegacyMatchInfo matchInfo;
        public int maxFrameRate;
        public boolean mediaExtractorSupported;
        public boolean needColorFormatCheck;
        public boolean needSeekBeforeFastPreview;
        public boolean useAndroidJpegDec;
        public String videoRec;
    }

    /* loaded from: classes.dex */
    public static class LegacyExportProfile {
        public int bitrate;
        public int displayHeight;
        public int height;
        public int width;
    }

    /* loaded from: classes.dex */
    public static class LegacyMatchInfo {
        public String board_platform;
        public String build_device;
        public String build_model;
        public String manufacturer;
        public int os_api_level_max;
        public int os_api_level_min;
        public String predicate_name;
        public int record_number;
    }

    /* loaded from: classes.dex */
    public static class MediaCodecInfo {
        public boolean encoder;
        public String name;
        public List<MediaCodecTypeInfo> types;
    }

    /* loaded from: classes.dex */
    public static class MediaCodecTypeInfo {
        public boolean adaptivePlayback;
        public boolean encCBR;
        public boolean encCQ;
        public boolean encVBR;
        public boolean hasAudio;
        public boolean hasVideo;
        public int heightAlignment;
        public boolean intraRefresh;
        public int maxAudioBitrate;
        public int maxAudioInputChannels;
        public int maxEncComplexity;
        public int maxSupportedCodecInstances;
        public int maxVideoBitrate;
        public int minAudioBitrate;
        public int minEncComplexity;
        public int minVideoBitrate;
        public List<ProfileLevel> profileLevels;
        public List<SampleRateRange> sampleRateRanges;
        public List<MediaCodecTypeSizeInfo> sizes;
        public String type;
        public int widthAlignment;
    }

    /* loaded from: classes.dex */
    public static class MediaCodecTypeSizeInfo {
        public int height;
        public double maxFps;
        public double maxPreviewFps;
        public double minFps;
        public double minPreviewFps;
        public int width;
    }

    /* loaded from: classes.dex */
    public static class PlaybackTestResult {
        public int codecCount;
        public int codecMemoryUsage;
        public int dropFrameRatio;
        public long droppedFrames;
        public long frameWaitTimeouts;
        public int inputRes;
        public int renderedFrames;
        public int resultCode;
        public String resultCodeName;
        public int secondaryInputRes;
        public boolean success;
        public int testElapsedTime;
        public int totalFrames;
    }

    /* loaded from: classes.dex */
    public static class ProfileLevel {
        int level;
        int profile;
    }

    /* loaded from: classes.dex */
    public static class SampleRateRange {
        public int maxRate;
        public int minRate;
    }

    /* loaded from: classes.dex */
    public static class TestResults {
        public String appBuildType;
        public String appPackage;
        public String appPackageVerName;
        public int appVersion;
        public String appVersionName;
        public int elapsedTestTimeMillis;
        public List<EncodeTestResult> encodeTestResults;
        public List<ExportTestResult> exportTestResults;
        public List<PlaybackTestResult> playbackTestResults;
        public String testDeviceName;
        public long testStartDate;
        public List<TranscodeTestResult> transcodeTestResults;
    }

    /* loaded from: classes.dex */
    public static class TranscodeTestResult {
        public int codecMemoryUsage;
        public int inputRes;
        public int outputRes;
        public int resultCode;
        public String resultCodeName;
        public boolean success;
        public int testElapsedTime;
    }
}
