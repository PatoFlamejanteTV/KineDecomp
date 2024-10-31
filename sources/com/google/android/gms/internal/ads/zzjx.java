package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;
import android.util.Pair;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;

@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzjx {
    private final String mimeType;
    public final String name;
    public final boolean zzadt;
    public final boolean zzatq;
    public final boolean zzatr;
    private final MediaCodecInfo.CodecCapabilities zzats;

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0059, code lost:            if ((com.google.android.gms.internal.ads.zzqe.SDK_INT >= 21 && r4.isFeatureSupported("secure-playback")) != false) goto L76;     */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0048  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzjx(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            com.google.android.gms.internal.ads.zzpo.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.mimeType = r3
            r1.zzats = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L29
            if (r4 == 0) goto L29
            int r5 = com.google.android.gms.internal.ads.zzqe.SDK_INT
            r0 = 19
            if (r5 < r0) goto L24
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L24
            r5 = 1
            goto L25
        L24:
            r5 = 0
        L25:
            if (r5 == 0) goto L29
            r5 = 1
            goto L2a
        L29:
            r5 = 0
        L2a:
            r1.zzatq = r5
            r5 = 21
            if (r4 == 0) goto L43
            int r0 = com.google.android.gms.internal.ads.zzqe.SDK_INT
            if (r0 < r5) goto L3e
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L3e
            r0 = 1
            goto L3f
        L3e:
            r0 = 0
        L3f:
            if (r0 == 0) goto L43
            r0 = 1
            goto L44
        L43:
            r0 = 0
        L44:
            r1.zzadt = r0
            if (r6 != 0) goto L5d
            if (r4 == 0) goto L5c
            int r6 = com.google.android.gms.internal.ads.zzqe.SDK_INT
            if (r6 < r5) goto L58
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L58
            r4 = 1
            goto L59
        L58:
            r4 = 0
        L59:
            if (r4 == 0) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            r1.zzatr = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzjx.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public static zzjx zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzjx(str, str2, codecCapabilities, z, z2);
    }

    public static zzjx zzt(String str) {
        return new zzjx(str, null, null, false, false);
    }

    private final void zzv(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzqe.zzbic;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    public final boolean zzam(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzats;
        if (codecCapabilities == null) {
            zzv("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzv("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("sampleRate.support, ");
        sb.append(i);
        zzv(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean zzan(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzats;
        if (codecCapabilities == null) {
            zzv("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzv("channelCount.aCaps");
            return false;
        }
        if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("channelCount.support, ");
        sb.append(i);
        zzv(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final Point zzc(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzats;
        if (codecCapabilities == null) {
            zzv("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzv("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzqe.zzf(i, widthAlignment) * widthAlignment, zzqe.zzf(i2, heightAlignment) * heightAlignment);
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzej() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzats;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public final boolean zzu(String str) {
        String zzae;
        if (str == null || this.mimeType == null || (zzae = zzpt.zzae(str)) == null) {
            return true;
        }
        if (!this.mimeType.equals(zzae)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(zzae).length());
            sb.append("codec.mime ");
            sb.append(str);
            sb.append(", ");
            sb.append(zzae);
            zzv(sb.toString());
            return false;
        }
        Pair<Integer, Integer> zzw = zzkc.zzw(str);
        if (zzw == null) {
            return true;
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : zzej()) {
            if (codecProfileLevel.profile == ((Integer) zzw.first).intValue() && codecProfileLevel.level >= ((Integer) zzw.second).intValue()) {
                return true;
            }
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 22 + String.valueOf(zzae).length());
        sb2.append("codec.profileLevel, ");
        sb2.append(str);
        sb2.append(", ");
        sb2.append(zzae);
        zzv(sb2.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean zza(int i, int i2, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzats;
        if (codecCapabilities == null) {
            zzv("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzv("sizeAndRate.vCaps");
            return false;
        }
        if (zza(videoCapabilities, i, i2, d2)) {
            return true;
        }
        if (i < i2 && zza(videoCapabilities, i2, i, d2)) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("sizeAndRate.rotated, ");
            sb.append(i);
            sb.append(FragmentC2201x.f23219a);
            sb.append(i2);
            sb.append(FragmentC2201x.f23219a);
            sb.append(d2);
            String sb2 = sb.toString();
            String str = this.name;
            String str2 = this.mimeType;
            String str3 = zzqe.zzbic;
            StringBuilder sb3 = new StringBuilder(String.valueOf(sb2).length() + 25 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
            sb3.append("AssumedSupport [");
            sb3.append(sb2);
            sb3.append("] [");
            sb3.append(str);
            sb3.append(", ");
            sb3.append(str2);
            sb3.append("] [");
            sb3.append(str3);
            sb3.append("]");
            Log.d("MediaCodecInfo", sb3.toString());
            return true;
        }
        StringBuilder sb4 = new StringBuilder(69);
        sb4.append("sizeAndRate.support, ");
        sb4.append(i);
        sb4.append(FragmentC2201x.f23219a);
        sb4.append(i2);
        sb4.append(FragmentC2201x.f23219a);
        sb4.append(d2);
        zzv(sb4.toString());
        return false;
    }

    @TargetApi(21)
    private static boolean zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        if (d2 != -1.0d && d2 > 0.0d) {
            return videoCapabilities.areSizeAndRateSupported(i, i2, d2);
        }
        return videoCapabilities.isSizeSupported(i, i2);
    }
}
