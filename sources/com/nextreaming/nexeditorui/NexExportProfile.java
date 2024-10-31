package com.nextreaming.nexeditorui;

import android.content.res.Resources;
import android.hardware.Camera;
import android.media.CamcorderProfile;
import android.os.Build;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
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
    public static final NexExportProfile EXPORT_320_240 = new NexExportProfile(ModuleDescriptor.MODULE_VERSION, 240, 240, 524288, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_320_180 = new NexExportProfile(ModuleDescriptor.MODULE_VERSION, 180, 180, 524288, R.string.dlg_encode_res_low_quality);
    public static final NexExportProfile EXPORT_320_192 = new NexExportProfile(ModuleDescriptor.MODULE_VERSION, 192, 180, 524288, R.string.dlg_encode_res_low_quality);

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
        int i6 = this.m_width * 317;
        int i7 = this.m_height;
        this.m_hashCode = i6 + (i7 * 823) + ((i7 - this.m_displayHeight) * 31) + (this.m_bitrate * 5) + (this.m_labelResource * 31) + (this.m_reverse ? 1033 : 0);
    }

    private static CamcorderProfile a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        CamcorderProfile camcorderProfile = null;
        for (int i2 = 0; i2 < numberOfCameras; i2++) {
            Camera.getCameraInfo(i2, cameraInfo);
            if (CamcorderProfile.hasProfile(i2, i) && (camcorderProfile == null || cameraInfo.facing == 0)) {
                camcorderProfile = CamcorderProfile.get(i2, i);
            }
        }
        return camcorderProfile;
    }

    public static List<NexExportProfile> getExportProfiles(int i) {
        int[] iArr = {6, 5, 4};
        int[] iArr2 = {8, 6, 5, 4};
        if (Build.VERSION.SDK_INT >= 21) {
            iArr = iArr2;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 : iArr) {
            CamcorderProfile a2 = a(i2);
            if (a2 != null) {
                int i3 = a2.videoFrameHeight;
                int i4 = a2.videoFrameWidth;
                if (i3 * i4 <= i) {
                    arrayList.add(new NexExportProfile(i4, i3, i3, a2.videoBitRate, getLabelResource(i4, i3)));
                }
            }
        }
        return arrayList;
    }

    public static int getLabelResource(int i, int i2) {
        return i2 > 2000 ? R.string.dlg_encode_res_fourk : i2 > 1000 ? R.string.dlg_encode_res_full_hd : i2 > 700 ? R.string.dlg_encode_res_hd : i2 > 450 ? R.string.dlg_encode_res_med_quality : R.string.dlg_encode_res_low_quality;
    }

    public static NexExportProfile[] supportedProfiles() {
        return new NexExportProfile[]{EXPORT_1080P, EXPORT_720P, EXPORT_960_540, EXPORT_640_360};
    }

    public int bitrate() {
        int i;
        return (!this.m_mutable || (i = this.m_customBitrate) == 0) ? this.m_bitrate : i;
    }

    public int decoderMemoryUsage() {
        return ((width() * height()) * 150) / 100;
    }

    public int displayHeight() {
        return this.m_displayHeight;
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

    public NexExportProfile getReverseProfile() {
        if (this.m_reverseProfile == null) {
            this.m_reverseProfile = new NexExportProfile(this, true, this.m_mutable);
        }
        return this.m_reverseProfile;
    }

    public int hashCode() {
        return this.m_hashCode;
    }

    public int height() {
        return this.m_height;
    }

    public long id() {
        return this.m_id;
    }

    public boolean isReversed() {
        return this.m_reverse;
    }

    public String label(Resources resources) {
        int i;
        String string;
        if (resources != null && (i = this.m_labelResource) != 0 && (string = resources.getString(i)) != null) {
            return string;
        }
        return this.m_width + " x " + this.m_height;
    }

    public int labelResource() {
        return this.m_labelResource;
    }

    public NexExportProfile mutableCopy() {
        return new NexExportProfile(this, false, true);
    }

    public void setBitrate(int i) {
        if (this.m_mutable) {
            this.m_customBitrate = i;
            return;
        }
        throw new IllegalStateException();
    }

    public NexExportProfile toRatio1v1() {
        return new NexExportProfile(this, 2);
    }

    public NexExportProfile toRatio9v16() {
        return new NexExportProfile(this, 1);
    }

    public int width() {
        return this.m_width;
    }

    public static NexExportProfile getExportProfiles(int i, int i2, int i3, int i4) {
        NexExportProfile nexExportProfile;
        int[] iArr = {6, 5, 4, 3, 7};
        int[] iArr2 = {8, 6, 5, 4, 3, 7};
        if (Build.VERSION.SDK_INT >= 21) {
            iArr = iArr2;
        }
        int i5 = 0;
        while (true) {
            if (i5 >= iArr.length) {
                nexExportProfile = null;
                break;
            }
            CamcorderProfile a2 = a(iArr[i5]);
            if (a2 != null) {
                int i6 = a2.videoFrameWidth;
                int i7 = a2.videoFrameHeight;
                nexExportProfile = new NexExportProfile(i6, i7, i7, a2.videoBitRate, getLabelResource(i6, i7));
                if (nexExportProfile.width() * (nexExportProfile.height() - 31) <= i3 && nexExportProfile.decoderMemoryUsage() <= i4) {
                    int abs = Math.abs(a2.videoFrameWidth - i);
                    int abs2 = Math.abs(a2.videoFrameHeight - i2);
                    if (abs > 32 && abs2 > 32) {
                        break;
                    }
                }
            }
            i5++;
        }
        if (nexExportProfile == null) {
            for (int i8 : iArr) {
                CamcorderProfile a3 = a(i8);
                if (a3 != null) {
                    int i9 = a3.videoFrameWidth;
                    int i10 = a3.videoFrameHeight;
                    NexExportProfile nexExportProfile2 = new NexExportProfile(i9, i10, i10, a3.videoBitRate, getLabelResource(i9, i10));
                    if (nexExportProfile2.width() * (nexExportProfile2.height() - 31) <= i3 && nexExportProfile2.decoderMemoryUsage() <= i4) {
                        return nexExportProfile2;
                    }
                }
            }
        }
        return nexExportProfile;
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
        int i = this.m_width * 317;
        int i2 = this.m_height;
        this.m_hashCode = i + (i2 * 823) + ((i2 - this.m_displayHeight) * 31) + (this.m_bitrate * 5) + (this.m_labelResource * 31) + (this.m_reverse ? 1033 : 0);
    }

    private NexExportProfile(NexExportProfile nexExportProfile, int i) {
        this.m_customBitrate = 0;
        this.m_reverseProfile = null;
        if (i == 1) {
            this.m_width = nexExportProfile.m_height;
            this.m_height = nexExportProfile.m_width;
        } else if (i == 2) {
            int i2 = nexExportProfile.m_height;
            this.m_width = i2;
            this.m_height = i2;
        } else {
            this.m_width = nexExportProfile.m_width;
            this.m_height = nexExportProfile.m_height;
        }
        this.m_bitrate = nexExportProfile.m_bitrate;
        this.m_displayHeight = nexExportProfile.m_displayHeight;
        this.m_labelResource = nexExportProfile.m_labelResource;
        this.m_mutable = nexExportProfile.m_mutable;
        this.m_id = nexExportProfile.m_id;
        this.m_reverse = nexExportProfile.m_reverse;
        int i3 = this.m_width * 317;
        int i4 = this.m_height;
        this.m_hashCode = i3 + (i4 * 823) + ((i4 - this.m_displayHeight) * 31) + (this.m_bitrate * 5) + (this.m_labelResource * 31) + (this.m_reverse ? 1033 : 0);
    }
}
