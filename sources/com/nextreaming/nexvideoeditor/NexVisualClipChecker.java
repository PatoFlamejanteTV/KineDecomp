package com.nextreaming.nexvideoeditor;

import android.media.CamcorderProfile;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;
import java.util.Vector;

/* loaded from: classes.dex */
public class NexVisualClipChecker {

    /* renamed from: a */
    private int f4805a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private boolean j;
    private int k;
    private int l;
    private int m;
    private boolean n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private Vector<CamcorderProfile> x;

    /* loaded from: classes.dex */
    public enum Profile {
        BASELINE,
        MAIN,
        HIGH
    }

    private static int a(int i, int i2) {
        if (i == 0) {
            return i2;
        }
        return (i2 != 0 && i >= i2) ? i2 : i;
    }

    public NexVisualClipChecker(NexEditor nexEditor) {
        this.f4805a = 0;
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.i = 0;
        this.j = false;
        this.k = 0;
        this.l = 0;
        this.m = 0;
        this.n = false;
        this.o = 0;
        this.p = 0;
        this.q = 0;
        this.r = 55;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = 0;
        this.w = 0;
        if (nexEditor != null) {
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            int maxCamcorderProfileSizeForUnknownDevice = deviceProfile.getMaxCamcorderProfileSizeForUnknownDevice();
            maxCamcorderProfileSizeForUnknownDevice = maxCamcorderProfileSizeForUnknownDevice <= 0 ? Integer.MAX_VALUE : maxCamcorderProfileSizeForUnknownDevice;
            this.f4805a = deviceProfile.getIntProperty("Device_Support_BaselineMaxLevel", 0);
            this.b = deviceProfile.getIntProperty("Device_Support_MainMaxLevel", 0);
            this.c = deviceProfile.getIntProperty("Device_Support_HighMaxLevel", 0);
            this.d = deviceProfile.getMCHWAVCDecBaselineSize();
            this.e = deviceProfile.getMCHWAVCDecMainSize();
            this.f = deviceProfile.getMCHWAVCDecHighSize();
            if (deviceProfile.isUnknownDevice()) {
                this.g = a(maxCamcorderProfileSizeForUnknownDevice, nexEditor.a("MCHWAVCEncBaselineLevelSize", 0));
                this.h = Math.min(maxCamcorderProfileSizeForUnknownDevice, nexEditor.a("MCHWAVCEncMainLevelSize", 0));
                this.i = Math.min(maxCamcorderProfileSizeForUnknownDevice, nexEditor.a("MCHWAVCEncHighLevelSize", 0));
            } else {
                this.g = nexEditor.a("MCHWAVCEncBaselineLevelSize", 0);
                this.h = nexEditor.a("MCHWAVCEncMainLevelSize", 0);
                this.i = nexEditor.a("MCHWAVCEncHighLevelSize", 0);
            }
            this.j = nexEditor.a("canUseMCSoftwareCodec", false);
            if (this.j) {
                this.k = deviceProfile.getMCSWAVCDecBaselineSize();
                this.l = deviceProfile.getMCSWAVCDecMainSize();
                this.m = deviceProfile.getMCSWAVCDecHighSize();
            }
            this.n = nexEditor.a("canUseSoftwareCodec", false);
            if (this.n) {
                this.o = deviceProfile.getNXSWAVCDecBaselineSize();
                this.p = deviceProfile.getNXSWAVCDecMainSize();
                this.q = deviceProfile.getNXSWAVCDecHighSize();
            }
            this.r = deviceProfile.getMaxSupportedFPS();
            this.u = deviceProfile.getMaxSupportedVideoBitrate(0);
            this.v = deviceProfile.getMaxSupportedAudioSamplingRate(0);
            this.w = deviceProfile.getMaxSupportedAudioChannels(0);
            if (deviceProfile.isUnknownDevice()) {
                this.s = this.d;
                this.t = this.d;
            } else {
                this.s = deviceProfile.getMaxImportSize(true);
                this.t = deviceProfile.getMaxImportSize(false);
            }
            this.x = new Vector<>();
            int[] iArr = {6, 5, 4, 3, 7};
            for (int i = 0; i < iArr.length; i++) {
                if (CamcorderProfile.hasProfile(iArr[i])) {
                    this.x.add(CamcorderProfile.get(iArr[i]));
                }
            }
        }
    }

    public int a(Profile profile) {
        int i;
        int i2;
        int i3;
        if (this.n) {
            i = this.o;
            i2 = this.p;
            i3 = this.q;
        } else {
            i = this.d;
            i2 = this.e;
            i3 = this.f;
        }
        switch (profile) {
            case BASELINE:
                break;
            case MAIN:
                i = i2;
                break;
            case HIGH:
                i = i3;
                break;
            default:
                i = 0;
                break;
        }
        if (this.j && profile == Profile.BASELINE && i < this.k) {
            return this.k;
        }
        return i;
    }

    public int a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        if (this.v > 0 && this.v < i7) {
            return 6;
        }
        int i12 = this.n ? this.s : this.t;
        if (i == 255) {
            if (i3 * i4 > i12) {
                if (i3 * i4 > (this.n ? this.o : this.d)) {
                    return 4;
                }
                return 1;
            }
            if (i5 > this.r) {
                return 2;
            }
            return 0;
        }
        if (this.n) {
            i9 = this.o;
            i10 = this.p;
            i11 = this.q;
        } else {
            i9 = this.d;
            i10 = this.e;
            i11 = this.f;
        }
        switch (i) {
            case 66:
                if (this.f4805a != 0 && this.f4805a < i2) {
                    return 5;
                }
                break;
            case 77:
                if (i10 == 0) {
                    return 3;
                }
                if (this.b != 0 && this.b < i2) {
                    return 5;
                }
                i9 = i10;
                break;
            case 100:
                if (i11 == 0) {
                    return 3;
                }
                if (this.c != 0 && this.c < i2) {
                    return 5;
                }
                i9 = i11;
                break;
            default:
                return 3;
        }
        if (i3 * i4 > i9) {
            if (this.j) {
                if (i == 66 && i3 * i4 <= this.k) {
                    return 1;
                }
                return 3;
            }
            return 4;
        }
        if (i3 * i4 > i12) {
            return 1;
        }
        if (i5 > this.r) {
            return 2;
        }
        return 0;
    }

    public int a() {
        int i = this.d;
        if (this.e > 0) {
            i = Math.min(i, this.e);
        }
        return this.f > 0 ? Math.min(i, this.f) : i;
    }

    public int a(boolean z) {
        return z ? this.s : this.t;
    }

    public int b() {
        return this.d;
    }

    public int c() {
        return this.e;
    }

    public int d() {
        return this.f;
    }

    public int e() {
        return this.g;
    }

    public int f() {
        return this.h;
    }

    public int g() {
        return this.i;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.l;
    }

    public int j() {
        return this.m;
    }
}
