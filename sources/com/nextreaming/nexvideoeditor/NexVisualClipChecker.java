package com.nextreaming.nexvideoeditor;

import android.support.v7.widget.ActivityChooserView;
import com.nexstreaming.kinemaster.mediainfo.CodecType;
import com.nextreaming.nexeditorui.NexEditorDeviceProfile;

/* loaded from: classes3.dex */
public class NexVisualClipChecker {

    /* renamed from: a */
    private int f24636a;

    /* renamed from: b */
    private int f24637b;

    /* renamed from: c */
    private int f24638c;

    /* renamed from: d */
    private int f24639d;

    /* renamed from: e */
    private int f24640e;

    /* renamed from: f */
    private int f24641f;

    /* renamed from: g */
    private int f24642g;

    /* renamed from: h */
    private int f24643h;
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

    /* loaded from: classes3.dex */
    public enum Profile {
        BASELINE,
        MAIN,
        HIGH
    }

    public NexVisualClipChecker(NexEditor nexEditor) {
        this.f24636a = 0;
        this.f24637b = 0;
        this.f24638c = 0;
        this.f24639d = 0;
        this.f24640e = 0;
        this.f24641f = 0;
        this.f24642g = 0;
        this.f24643h = 0;
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
        if (nexEditor == null) {
            return;
        }
        NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
        int maxCamcorderProfileSizeForUnknownDevice = deviceProfile.getMaxCamcorderProfileSizeForUnknownDevice();
        maxCamcorderProfileSizeForUnknownDevice = maxCamcorderProfileSizeForUnknownDevice <= 0 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : maxCamcorderProfileSizeForUnknownDevice;
        this.f24636a = deviceProfile.getIntProperty("Device_Support_BaselineMaxLevel", 0);
        this.f24637b = deviceProfile.getIntProperty("Device_Support_MainMaxLevel", 0);
        this.f24638c = deviceProfile.getIntProperty("Device_Support_HighMaxLevel", 0);
        this.f24639d = deviceProfile.getMCHWAVCDecBaselineSize();
        this.f24640e = deviceProfile.getMCHWAVCDecMainSize();
        this.f24641f = deviceProfile.getMCHWAVCDecHighSize();
        if (deviceProfile.isUnknownDevice()) {
            this.f24642g = a(maxCamcorderProfileSizeForUnknownDevice, nexEditor.b("MCHWAVCEncBaselineLevelSize", 0));
            this.f24643h = Math.min(maxCamcorderProfileSizeForUnknownDevice, nexEditor.b("MCHWAVCEncMainLevelSize", 0));
            this.i = Math.min(maxCamcorderProfileSizeForUnknownDevice, nexEditor.b("MCHWAVCEncHighLevelSize", 0));
        } else {
            this.f24642g = nexEditor.b("MCHWAVCEncBaselineLevelSize", 0);
            this.f24643h = nexEditor.b("MCHWAVCEncMainLevelSize", 0);
            this.i = nexEditor.b("MCHWAVCEncHighLevelSize", 0);
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
        this.r = deviceProfile.getMaxSupportedFPS(1280, 720);
        this.u = deviceProfile.getMaxSupportedVideoBitrate(0);
        this.v = deviceProfile.getMaxSupportedAudioSamplingRate(0);
        this.w = deviceProfile.getMaxSupportedAudioChannels(0);
        if (deviceProfile.isUnknownDevice()) {
            int i = this.f24639d;
            this.s = i;
            this.t = i;
        } else {
            this.s = deviceProfile.getMaxImportSize(true);
            this.t = deviceProfile.getMaxImportSize(false);
        }
    }

    private static int a(int i, int i2) {
        return i == 0 ? i2 : (i2 != 0 && i >= i2) ? i2 : i;
    }

    public int a(Profile profile) {
        int i;
        int i2;
        int i3;
        int i4;
        if (this.n) {
            i = this.o;
            i2 = this.p;
            i3 = this.q;
        } else {
            i = this.f24639d;
            i2 = this.f24640e;
            i3 = this.f24641f;
        }
        int i5 = ja.f24719a[profile.ordinal()];
        if (i5 != 1) {
            i = i5 != 2 ? i5 != 3 ? 0 : i3 : i2;
        }
        return (this.j && profile == Profile.BASELINE && i < (i4 = this.k)) ? i4 : i;
    }

    public int b() {
        return this.f24641f;
    }

    public int c() {
        return this.f24640e;
    }

    public int d() {
        return this.f24642g;
    }

    public int e() {
        return this.i;
    }

    public int f() {
        return this.f24643h;
    }

    public int g() {
        int i = this.f24639d;
        int i2 = this.f24640e;
        if (i2 > 0) {
            i = Math.min(i, i2);
        }
        int i3 = this.f24641f;
        return i3 > 0 ? Math.min(i, i3) : i;
    }

    public int h() {
        return this.k;
    }

    public int i() {
        return this.m;
    }

    public int j() {
        return this.l;
    }

    public int a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, CodecType codecType, int i9) {
        int i10;
        int i11;
        int i12;
        int i13 = this.v;
        if (i13 > 0 && i13 < i7) {
            return 5;
        }
        int i14 = this.n ? this.s : this.t;
        if (codecType == CodecType.f20660g) {
            NexEditorDeviceProfile deviceProfile = NexEditorDeviceProfile.getDeviceProfile();
            if (!deviceProfile.getIsHevcSupported()) {
                return 3;
            }
            if (i9 == 16 && !deviceProfile.IsHDRSupported()) {
                return 3;
            }
            int i15 = i3 * i4;
            if (i15 > i14) {
                return i15 > (this.n ? this.o : this.f24639d) ? 4 : 1;
            }
            return i5 > this.r ? 2 : 0;
        }
        if (i == 255) {
            int i16 = i3 * i4;
            if (i16 > i14) {
                return i16 > (this.n ? this.o : this.f24639d) ? 4 : 1;
            }
            return i5 > this.r ? 2 : 0;
        }
        if (this.n) {
            i10 = this.o;
            i11 = this.p;
            i12 = this.q;
        } else {
            i10 = this.f24639d;
            i11 = this.f24640e;
            i12 = this.f24641f;
        }
        if (i == 66) {
            int i17 = this.f24636a;
            if (i17 != 0 && i17 < i2) {
                return 5;
            }
        } else if (i != 77) {
            if (i != 100 || i12 == 0) {
                return 3;
            }
            int i18 = this.f24638c;
            if (i18 != 0 && i18 < i2) {
                return 5;
            }
            i10 = i12;
        } else {
            if (i11 == 0) {
                return 3;
            }
            int i19 = this.f24637b;
            if (i19 != 0 && i19 < i2) {
                return 5;
            }
            i10 = i11;
        }
        int i20 = i3 * i4;
        if (i20 > i10) {
            if (this.j) {
                return (i != 66 || i20 > this.k) ? 3 : 1;
            }
            return 4;
        }
        if (i20 > i14) {
            return 1;
        }
        return i5 > this.r ? 2 : 0;
    }

    public int a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, CodecType codecType, int i11) {
        int a2 = a(i, i2, i3, i4, i5, i6, i7, i8, codecType, i11);
        if (a2 != 0 || Math.abs(i9 - i10) <= 100) {
            return a2;
        }
        return 8;
    }

    public int a(boolean z) {
        return z ? this.s : this.t;
    }

    public int a() {
        return this.f24639d;
    }
}
