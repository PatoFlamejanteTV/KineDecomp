package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;

/* renamed from: com.google.android.gms.internal.clearcut.w */
/* loaded from: classes2.dex */
public final class C1230w extends zzbk {

    /* renamed from: a */
    private final byte[] f12899a;

    /* renamed from: b */
    private final boolean f12900b;

    /* renamed from: c */
    private int f12901c;

    /* renamed from: d */
    private int f12902d;

    /* renamed from: e */
    private int f12903e;

    /* renamed from: f */
    private int f12904f;

    /* renamed from: g */
    private int f12905g;

    /* JADX INFO: Access modifiers changed from: private */
    public C1230w(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f12905g = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        this.f12899a = bArr;
        this.f12901c = i2 + i;
        this.f12903e = i;
        this.f12904f = this.f12903e;
        this.f12900b = z;
    }

    public /* synthetic */ C1230w(byte[] bArr, int i, int i2, boolean z, C1228v c1228v) {
        this(bArr, i, i2, z);
    }

    @Override // com.google.android.gms.internal.clearcut.zzbk
    public final int zzaf() {
        return this.f12903e - this.f12904f;
    }

    @Override // com.google.android.gms.internal.clearcut.zzbk
    public final int zzl(int i) throws zzco {
        if (i < 0) {
            throw new zzco("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int zzaf = i + zzaf();
        int i2 = this.f12905g;
        if (zzaf > i2) {
            throw zzco.zzbl();
        }
        this.f12905g = zzaf;
        this.f12901c += this.f12902d;
        int i3 = this.f12901c;
        int i4 = i3 - this.f12904f;
        int i5 = this.f12905g;
        if (i4 > i5) {
            this.f12902d = i4 - i5;
            this.f12901c = i3 - this.f12902d;
        } else {
            this.f12902d = 0;
        }
        return i2;
    }
}
