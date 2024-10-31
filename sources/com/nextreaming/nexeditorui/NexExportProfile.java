package com.nextreaming.nexeditorui;

import android.content.res.Resources;
import android.media.CamcorderProfile;
import android.os.Build;
import com.nexstreaming.app.kinemasterfree.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class NexExportProfile implements Serializable {
    private static final long serialVersionUID = 1;
    private final int m_bitrate;
    private int m_customBitrate;
    private final int m_displayHeight;
    private final int m_hashCode;
    private final int m_height;
    private final long m_id;
    private final int m_labelResource;
    private final boolean m_mutable;
    private final boolean m_reverse;
    private NexExportProfile m_reverseProfile;
    private final int m_width;
    public static final NexExportProfile EXPORT_2160P = new NexExportProfile(3840, 2160, 2160, 33554432, R.string.dlg_encode_res_full_hd);
    public static final NexExportProfile EXPORT_1080P = new NexExportProfile(1920, 1080, 1080, 12582912, R.string.dlg_encode_res_full_hd);
    public static final NexExportProfile EXPORT_1088P = new NexExportProfile(1920, 1088, 1080, 12582912, R.string.dlg_encode_res_full_hd);
    public static final NexExportProfile EXPORT_720P = new NexExportProfile(1280, 720, 720, 6291456, R.string.dlg_encode_res_hd);
    public static final NexExportProfile EXPORT_736P = new NexExportProfile(1280, 736, 720, 6291456, R.string.dlg_encode_res_hd);
    public static final NexExportProfile EXPORT_960_540 = new NexExportProfile(960, 540, 540, 3145728, R.string.dlg_encode_res_med_quality);
    public static final NexExportProfile EXPORT_960_544 = new NexExportProfile(960, 544, 540, 3145728, R.string.dlg_encode_res_med_quality);
    public static final NexExportProfile EXPORT_800_480 = new NexExportProfile(800, 480, 480, 1572864, R.string.dlg_encode_res_med_quality);
    public static final NexExportProfile EXPORT_864_480 = new NexExportProfile(864, 480, 480, 2097152, R.string.dlg_encode_res_med_quality);
    public static final NexExportProfile EXPORT_640_480 = new NexExportProfile(640, 480, 480, 1572864, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_640_360 = new NexExportProfile(640, 360, 360, 2097152, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_640_368 = new NexExportProfile(640, 368, 360, 2097152, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_640_352 = new NexExportProfile(640, 352, 360, 2097152, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_400_240 = new NexExportProfile(400, 240, 240, 524288, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_320_240 = new NexExportProfile(320, 240, 240, 524288, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_320_180 = new NexExportProfile(320, 180, 180, 524288, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_320_192 = new NexExportProfile(320, 192, 180, 524288, R.string.dlg_encode_res_low_quality);

    public static NexExportProfile[] supportedProfiles() {
        return new NexExportProfile[]{EXPORT_1080P, EXPORT_720P, EXPORT_960_540, EXPORT_640_360};
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof NexExportProfile)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        NexExportProfile nexExportProfile = (NexExportProfile) obj;
        return nexExportProfile.m_width == this.m_width && nexExportProfile.m_height == this.m_height && nexExportProfile.m_displayHeight == this.m_displayHeight && nexExportProfile.m_bitrate == this.m_bitrate && nexExportProfile.m_labelResource == this.m_labelResource && nexExportProfile.m_id == this.m_id && nexExportProfile.m_hashCode == this.m_hashCode && nexExportProfile.m_reverse == this.m_reverse;
    }

    public int hashCode() {
        return this.m_hashCode;
    }

    public NexExportProfile(int i, int i2, int i3, int i4, int i5) {
        this.m_customBitrate = 0;
        this.m_reverseProfile = null;
        this.m_width = i;
        this.m_height = i2;
        this.m_bitrate = i4;
        this.m_displayHeight = i3;
        this.m_labelResource = i5;
        this.m_mutable = false;
        this.m_id = (i << 48) | (i3 << 32) | i4;
        this.m_reverse = false;
        this.m_hashCode = (this.m_reverse ? 1033 : 0) + (this.m_width * 317) + (this.m_height * 823) + ((this.m_height - this.m_displayHeight) * 31) + (this.m_bitrate * 5) + (this.m_labelResource * 31);
    }

    private NexExportProfile(NexExportProfile nexExportProfile, boolean z, boolean z2) {
        this.m_customBitrate = 0;
        this.m_reverseProfile = null;
        this.m_width = nexExportProfile.m_width;
        this.m_height = nexExportProfile.m_height;
        this.m_bitrate = nexExportProfile.m_bitrate;
        this.m_displayHeight = nexExportProfile.m_displayHeight;
        this.m_labelResource = nexExportProfile.m_labelResource;
        this.m_mutable = z2;
        this.m_id = nexExportProfile.m_id;
        this.m_reverse = z;
        this.m_hashCode = (this.m_reverse ? 1033 : 0) + (this.m_width * 317) + (this.m_height * 823) + ((this.m_height - this.m_displayHeight) * 31) + (this.m_bitrate * 5) + (this.m_labelResource * 31);
    }

    public NexExportProfile getReverseProfile() {
        if (this.m_reverseProfile == null) {
            this.m_reverseProfile = new NexExportProfile(this, true, this.m_mutable);
        }
        return this.m_reverseProfile;
    }

    public NexExportProfile mutableCopy() {
        return new NexExportProfile(this, false, true);
    }

    public boolean isReversed() {
        return this.m_reverse;
    }

    public long id() {
        return this.m_id;
    }

    public int width() {
        return this.m_width;
    }

    public int height() {
        return this.m_height;
    }

    public int displayHeight() {
        return this.m_displayHeight;
    }

    public int bitrate() {
        return (!this.m_mutable || this.m_customBitrate == 0) ? this.m_bitrate : this.m_customBitrate;
    }

    public int labelResource() {
        return this.m_labelResource;
    }

    public String label(Resources resources) {
        String string;
        return (resources == null || this.m_labelResource == 0 || (string = resources.getString(this.m_labelResource)) == null) ? this.m_width + " x " + this.m_height : string;
    }

    public void setBitrate(int i) {
        if (!this.m_mutable) {
            throw new IllegalStateException();
        }
        this.m_customBitrate = i;
    }

    public static int getLabelResource(int i, int i2) {
        if (i2 > 2000) {
            return R.string.dlg_encode_res_fourk;
        }
        if (i2 > 1000) {
            return R.string.dlg_encode_res_full_hd;
        }
        if (i2 > 700) {
            return R.string.dlg_encode_res_hd;
        }
        if (i2 > 450) {
            return R.string.dlg_encode_res_med_quality;
        }
        return R.string.dlg_encode_res_low_quality;
    }

    public static List<NexExportProfile> getExportProfiles(int i) {
        CamcorderProfile camcorderProfile;
        int[] iArr = Build.VERSION.SDK_INT >= 21 ? new int[]{8, 6, 5, 4} : new int[]{6, 5, 4};
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < iArr.length) {
                if (CamcorderProfile.hasProfile(iArr[i3]) && (camcorderProfile = CamcorderProfile.get(iArr[i3])) != null && camcorderProfile.videoFrameHeight * camcorderProfile.videoFrameWidth <= i) {
                    arrayList.add(new NexExportProfile(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, camcorderProfile.videoFrameHeight, camcorderProfile.videoBitRate, getLabelResource(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight)));
                }
                i2 = i3 + 1;
            } else {
                return arrayList;
            }
        }
    }

    public static NexExportProfile getExportProfiles(int i, int i2, int i3, int i4) {
        CamcorderProfile camcorderProfile;
        CamcorderProfile camcorderProfile2;
        NexExportProfile nexExportProfile = null;
        int[] iArr = Build.VERSION.SDK_INT >= 21 ? new int[]{8, 6, 5, 4, 3, 7} : new int[]{6, 5, 4, 3, 7};
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= iArr.length) {
                break;
            }
            if (CamcorderProfile.hasProfile(iArr[i6]) && (camcorderProfile2 = CamcorderProfile.get(iArr[i6])) != null) {
                NexExportProfile nexExportProfile2 = new NexExportProfile(camcorderProfile2.videoFrameWidth, camcorderProfile2.videoFrameHeight, camcorderProfile2.videoFrameHeight, camcorderProfile2.videoBitRate, getLabelResource(camcorderProfile2.videoFrameWidth, camcorderProfile2.videoFrameHeight));
                if (nexExportProfile2.width() * (nexExportProfile2.height() - 31) <= i3 && nexExportProfile2.decoderMemoryUsage() <= i4) {
                    int abs = Math.abs(camcorderProfile2.videoFrameWidth - i);
                    int abs2 = Math.abs(camcorderProfile2.videoFrameHeight - i2);
                    if (abs > 32 && abs2 > 32) {
                        nexExportProfile = nexExportProfile2;
                        break;
                    }
                }
            }
            i5 = i6 + 1;
        }
        if (nexExportProfile == null) {
            int i7 = 0;
            while (true) {
                int i8 = i7;
                if (i8 >= iArr.length) {
                    break;
                }
                if (CamcorderProfile.hasProfile(iArr[i8]) && (camcorderProfile = CamcorderProfile.get(iArr[i8])) != null) {
                    NexExportProfile nexExportProfile3 = new NexExportProfile(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight, camcorderProfile.videoFrameHeight, camcorderProfile.videoBitRate, getLabelResource(camcorderProfile.videoFrameWidth, camcorderProfile.videoFrameHeight));
                    if (nexExportProfile3.width() * (nexExportProfile3.height() - 31) <= i3 && nexExportProfile3.decoderMemoryUsage() <= i4) {
                        return nexExportProfile3;
                    }
                }
                i7 = i8 + 1;
            }
        }
        return nexExportProfile;
    }

    public int decoderMemoryUsage() {
        return ((width() * height()) * 150) / 100;
    }
}
