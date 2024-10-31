package com.nexstreaming.kinemaster.codeccaps;

import android.media.CamcorderProfile;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.support.v7.widget.ActivityChooserView;
import android.util.Range;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.kinemaster.codeccaps.CapabilityReport;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: HeuristicBasedCapabilityDetector.java */
/* loaded from: classes.dex */
public class Q {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f20090a = {2160, 1440, 1080, 720, 630, 540, 480, 450, 360};

    public static CapabilityReport.CapabilityInfo a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 23) {
            return e();
        }
        if (i >= 21) {
            return d();
        }
        if (i >= 18) {
            return c();
        }
        if (i >= 16) {
            return b();
        }
        return null;
    }

    private static CapabilityReport.CapabilityInfo b() {
        return a(new int[]{6, 5, 4, 3, 1, 0, 2, 7, 1006, SemanticAnnotations.SemanticType.ST_MANDELBREAD_ID_VALUE, 1001});
    }

    private static CapabilityReport.CapabilityInfo c() {
        return b();
    }

    private static CapabilityReport.CapabilityInfo d() {
        return a(new int[]{2005, 2004, 2003, 2002, 2001, SemanticAnnotations.SemanticType.ST_THIRD_PARTY_DATA_VALUE, 1008, 8, 6, 5, 4, 3, 1, 0, 2, 7, 1006, SemanticAnnotations.SemanticType.ST_MANDELBREAD_ID_VALUE, 1001});
    }

    private static CapabilityReport.CapabilityInfo e() {
        MediaCodecInfo[] mediaCodecInfoArr;
        MediaCodecInfo[] mediaCodecInfoArr2;
        MediaCodecInfo mediaCodecInfo;
        String[] strArr;
        int i;
        MediaCodecInfo mediaCodecInfo2;
        String[] strArr2;
        int i2;
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        int i3;
        CapabilityReport.CapabilityInfo capabilityInfo = new CapabilityReport.CapabilityInfo();
        capabilityInfo.deviceSupported = false;
        capabilityInfo.supportHighProfile = false;
        capabilityInfo.maxCodecMemorySize = 0;
        capabilityInfo.maxPlaybackCodecMemorySize = 0;
        capabilityInfo.maxResolution = 0;
        capabilityInfo.minResolution = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        capabilityInfo.maxImportResolutionWithOverlap = 0;
        capabilityInfo.maxImportResolutionNoOverlap = 0;
        capabilityInfo.maxTranscodeResolution = 0;
        capabilityInfo.maxCodecCount = 0;
        capabilityInfo.maxCodecCountAtMaxImportRes = 0;
        capabilityInfo.codecInstanceCountByResolution = new TreeMap(Collections.reverseOrder());
        capabilityInfo.codecInstanceCountByResolutionMinorSkipping = new TreeMap(Collections.reverseOrder());
        capabilityInfo.codecInstanceCountByResolutionNoSkipping = new TreeMap(Collections.reverseOrder());
        MediaCodecInfo[] codecInfos = new MediaCodecList(0).getCodecInfos();
        int length = codecInfos.length;
        int i4 = 0;
        while (i4 < length) {
            MediaCodecInfo mediaCodecInfo3 = codecInfos[i4];
            new CapabilityReport.MediaCodecInfo();
            if (mediaCodecInfo3.getName().startsWith("OMX.google.")) {
                mediaCodecInfoArr = codecInfos;
            } else {
                String[] supportedTypes = mediaCodecInfo3.getSupportedTypes();
                int length2 = supportedTypes.length;
                int i5 = 0;
                while (i5 < length2) {
                    String str = supportedTypes[i5];
                    if ("video/avc".equals(str)) {
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo3.getCapabilitiesForType(str);
                        MediaCodecInfo.VideoCapabilities videoCapabilities2 = capabilitiesForType.getVideoCapabilities();
                        int maxSupportedInstances = capabilitiesForType.getMaxSupportedInstances();
                        int[] iArr = f20090a;
                        int length3 = iArr.length;
                        int i6 = 0;
                        boolean z = false;
                        while (i6 < length3) {
                            int i7 = iArr[i6];
                            MediaCodecInfo[] mediaCodecInfoArr3 = codecInfos;
                            int i8 = (i7 * 16) / 9;
                            if (videoCapabilities2.isSizeSupported(i8, i7)) {
                                Range<Double> achievableFrameRatesFor = videoCapabilities2.getAchievableFrameRatesFor(i8, i7);
                                Range<Double> supportedFrameRatesFor = videoCapabilities2.getSupportedFrameRatesFor(i8, i7);
                                double doubleValue = achievableFrameRatesFor != null ? achievableFrameRatesFor.getUpper().doubleValue() : 30.0d;
                                double doubleValue2 = supportedFrameRatesFor != null ? supportedFrameRatesFor.getUpper().doubleValue() : 30.0d;
                                if (doubleValue2 < doubleValue) {
                                    doubleValue2 = doubleValue;
                                }
                                if (doubleValue <= 1.0d) {
                                    doubleValue = doubleValue2;
                                }
                                mediaCodecInfo2 = mediaCodecInfo3;
                                strArr2 = supportedTypes;
                                int min = Math.min(maxSupportedInstances, (int) Math.floor(doubleValue / 30.0d));
                                i2 = length2;
                                int min2 = Math.min(maxSupportedInstances, (int) Math.floor(doubleValue2 / 30.0d));
                                a(capabilityInfo.codecInstanceCountByResolutionNoSkipping, i7, min);
                                a(capabilityInfo.codecInstanceCountByResolutionMinorSkipping, i7, min);
                                a(capabilityInfo.codecInstanceCountByResolution, i7, min2);
                                capabilityInfo.maxCodecCount = Math.max(capabilityInfo.maxCodecCount, min);
                                capabilityInfo.maxCodecCount = Math.max(capabilityInfo.maxCodecCount, min2);
                                capabilityInfo.maxResolution = Math.max(capabilityInfo.maxResolution, i7);
                                capabilityInfo.minResolution = Math.min(capabilityInfo.minResolution, i7);
                                videoCapabilities = videoCapabilities2;
                                i3 = maxSupportedInstances;
                                double a2 = CapabilityManager.a(i8, i7);
                                Double.isNaN(a2);
                                int floor = (int) Math.floor((a2 * doubleValue2) / 30.0d);
                                double a3 = CapabilityManager.a(i8, i7);
                                Double.isNaN(a3);
                                int floor2 = (int) Math.floor((a3 * doubleValue) / 30.0d);
                                capabilityInfo.maxCodecMemorySize = Math.max(capabilityInfo.maxCodecMemorySize, floor);
                                capabilityInfo.maxPlaybackCodecMemorySize = Math.max(capabilityInfo.maxPlaybackCodecMemorySize, floor2);
                                if (min >= 2) {
                                    capabilityInfo.deviceSupported = true;
                                }
                                if (min >= 3) {
                                    if (i7 > capabilityInfo.maxImportResolutionNoOverlap) {
                                        capabilityInfo.maxImportResolutionNoOverlap = i7;
                                    }
                                    if (i7 > capabilityInfo.maxImportResolutionWithOverlap) {
                                        capabilityInfo.maxImportResolutionWithOverlap = i7;
                                        capabilityInfo.maxCodecCountAtMaxImportRes = 0;
                                    }
                                    if (i7 > capabilityInfo.maxTranscodeResolution) {
                                        capabilityInfo.maxTranscodeResolution = i7;
                                    }
                                } else if (min >= 2) {
                                    if (i7 > capabilityInfo.maxImportResolutionNoOverlap) {
                                        capabilityInfo.maxImportResolutionNoOverlap = i7;
                                    }
                                    if (i7 > capabilityInfo.maxTranscodeResolution) {
                                        capabilityInfo.maxTranscodeResolution = i7;
                                    }
                                }
                                if (capabilityInfo.maxImportResolutionWithOverlap == i7) {
                                    capabilityInfo.maxCodecCountAtMaxImportRes = Math.max(capabilityInfo.maxCodecCountAtMaxImportRes, min);
                                    capabilityInfo.maxCodecCountAtMaxImportRes = Math.max(capabilityInfo.maxCodecCountAtMaxImportRes, min2);
                                }
                                z = true;
                            } else {
                                mediaCodecInfo2 = mediaCodecInfo3;
                                strArr2 = supportedTypes;
                                i2 = length2;
                                videoCapabilities = videoCapabilities2;
                                i3 = maxSupportedInstances;
                            }
                            i6++;
                            mediaCodecInfo3 = mediaCodecInfo2;
                            codecInfos = mediaCodecInfoArr3;
                            videoCapabilities2 = videoCapabilities;
                            maxSupportedInstances = i3;
                            supportedTypes = strArr2;
                            length2 = i2;
                        }
                        mediaCodecInfoArr2 = codecInfos;
                        mediaCodecInfo = mediaCodecInfo3;
                        strArr = supportedTypes;
                        i = length2;
                        if (z) {
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                                int i9 = codecProfileLevel.profile;
                                if (i9 != 1 && i9 != 4 && (i9 == 8 || i9 == 16 || i9 == 32 || i9 == 64)) {
                                    capabilityInfo.supportHighProfile = true;
                                }
                            }
                        }
                    } else {
                        mediaCodecInfoArr2 = codecInfos;
                        mediaCodecInfo = mediaCodecInfo3;
                        strArr = supportedTypes;
                        i = length2;
                    }
                    i5++;
                    mediaCodecInfo3 = mediaCodecInfo;
                    codecInfos = mediaCodecInfoArr2;
                    supportedTypes = strArr;
                    length2 = i;
                }
                mediaCodecInfoArr = codecInfos;
                capabilityInfo.maxExportResolution = Math.max(capabilityInfo.maxImportResolutionNoOverlap, capabilityInfo.maxImportResolutionWithOverlap);
            }
            i4++;
            codecInfos = mediaCodecInfoArr;
        }
        z.a(capabilityInfo);
        return capabilityInfo;
    }

    private static CapabilityReport.CapabilityInfo a(int[] iArr) {
        CapabilityReport.CapabilityInfo capabilityInfo = new CapabilityReport.CapabilityInfo();
        capabilityInfo.deviceSupported = false;
        capabilityInfo.supportHighProfile = false;
        capabilityInfo.maxCodecMemorySize = 0;
        capabilityInfo.maxPlaybackCodecMemorySize = 0;
        capabilityInfo.maxResolution = 0;
        capabilityInfo.minResolution = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        capabilityInfo.maxImportResolutionWithOverlap = 0;
        capabilityInfo.maxImportResolutionNoOverlap = 0;
        capabilityInfo.maxTranscodeResolution = 0;
        capabilityInfo.maxCodecCount = 0;
        capabilityInfo.maxCodecCountAtMaxImportRes = 0;
        capabilityInfo.codecInstanceCountByResolution = new TreeMap(Collections.reverseOrder());
        capabilityInfo.codecInstanceCountByResolutionMinorSkipping = new TreeMap(Collections.reverseOrder());
        capabilityInfo.codecInstanceCountByResolutionNoSkipping = new TreeMap(Collections.reverseOrder());
        for (int i : iArr) {
            if (CamcorderProfile.hasProfile(i)) {
                CamcorderProfile camcorderProfile = CamcorderProfile.get(i);
                int i2 = camcorderProfile.videoFrameHeight;
                int i3 = camcorderProfile.videoFrameRate / 30;
                a(capabilityInfo.codecInstanceCountByResolutionNoSkipping, i2, i3);
                a(capabilityInfo.codecInstanceCountByResolutionMinorSkipping, i2, i3);
                a(capabilityInfo.codecInstanceCountByResolution, i2, i3);
                capabilityInfo.maxCodecCount = Math.max(capabilityInfo.maxCodecCount, i3);
                capabilityInfo.maxCodecCount = Math.max(capabilityInfo.maxCodecCount, i3);
                capabilityInfo.maxResolution = Math.max(capabilityInfo.maxResolution, i2);
                capabilityInfo.minResolution = Math.min(capabilityInfo.minResolution, i2);
                double a2 = CapabilityManager.a(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) * camcorderProfile.videoFrameRate;
                Double.isNaN(a2);
                int floor = (int) Math.floor(a2 / 30.0d);
                double a3 = CapabilityManager.a(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight) * camcorderProfile.videoFrameRate;
                Double.isNaN(a3);
                int floor2 = (int) Math.floor(a3 / 30.0d);
                capabilityInfo.maxCodecMemorySize = Math.max(capabilityInfo.maxCodecMemorySize, floor);
                capabilityInfo.maxPlaybackCodecMemorySize = Math.max(capabilityInfo.maxPlaybackCodecMemorySize, floor2);
                if (i3 >= 2) {
                    capabilityInfo.deviceSupported = true;
                }
                if (i3 >= 3) {
                    if (i2 > capabilityInfo.maxImportResolutionNoOverlap) {
                        capabilityInfo.maxImportResolutionNoOverlap = i2;
                    }
                    if (i2 > capabilityInfo.maxImportResolutionWithOverlap) {
                        capabilityInfo.maxImportResolutionWithOverlap = i2;
                        capabilityInfo.maxCodecCountAtMaxImportRes = 0;
                    }
                    if (i2 > capabilityInfo.maxTranscodeResolution) {
                        capabilityInfo.maxTranscodeResolution = i2;
                    }
                } else if (i3 >= 2) {
                    if (i2 > capabilityInfo.maxImportResolutionNoOverlap) {
                        capabilityInfo.maxImportResolutionNoOverlap = i2;
                    }
                    if (i2 > capabilityInfo.maxTranscodeResolution) {
                        capabilityInfo.maxTranscodeResolution = i2;
                    }
                }
                if (capabilityInfo.maxImportResolutionWithOverlap == i2) {
                    capabilityInfo.maxCodecCountAtMaxImportRes = Math.max(capabilityInfo.maxCodecCountAtMaxImportRes, i3);
                    capabilityInfo.maxCodecCountAtMaxImportRes = Math.max(capabilityInfo.maxCodecCountAtMaxImportRes, i3);
                }
            }
        }
        return capabilityInfo;
    }

    private static void a(Map<Integer, Integer> map, int i, int i2) {
        Integer num = map.get(Integer.valueOf(i));
        if (num == null || num.intValue() < i2) {
            map.put(Integer.valueOf(i), Integer.valueOf(i2));
        }
    }
}
