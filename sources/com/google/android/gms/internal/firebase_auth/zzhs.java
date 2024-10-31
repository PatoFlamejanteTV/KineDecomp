package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class zzhs extends zzeh {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f13113a;
    private final int zzaaj;
    private final zzeh zzaak;
    private final zzeh zzaal;
    private final int zzaam;
    private final int zzaan;

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED));
        f13113a = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = f13113a;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    private zzhs(zzeh zzehVar, zzeh zzehVar2) {
        this.zzaak = zzehVar;
        this.zzaal = zzehVar2;
        this.zzaam = zzehVar.size();
        this.zzaaj = this.zzaam + zzehVar2.size();
        this.zzaan = Math.max(zzehVar.zzfc(), zzehVar2.zzfc()) + 1;
    }

    private static zzeh a(zzeh zzehVar, zzeh zzehVar2) {
        int size = zzehVar.size();
        int size2 = zzehVar2.size();
        byte[] bArr = new byte[size + size2];
        zzehVar.zza(bArr, 0, 0, size);
        zzehVar2.zza(bArr, 0, size, size2);
        return zzeh.zza(bArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzeh zza(zzeh zzehVar, zzeh zzehVar2) {
        if (zzehVar2.size() == 0) {
            return zzehVar;
        }
        if (zzehVar.size() == 0) {
            return zzehVar2;
        }
        int size = zzehVar.size() + zzehVar2.size();
        if (size < 128) {
            return a(zzehVar, zzehVar2);
        }
        if (zzehVar instanceof zzhs) {
            zzhs zzhsVar = (zzhs) zzehVar;
            if (zzhsVar.zzaal.size() + zzehVar2.size() < 128) {
                return new zzhs(zzhsVar.zzaak, a(zzhsVar.zzaal, zzehVar2));
            }
            if (zzhsVar.zzaak.zzfc() > zzhsVar.zzaal.zzfc() && zzhsVar.zzfc() > zzehVar2.zzfc()) {
                return new zzhs(zzhsVar.zzaak, new zzhs(zzhsVar.zzaal, zzehVar2));
            }
        }
        if (size >= f13113a[Math.max(zzehVar.zzfc(), zzehVar2.zzfc()) + 1]) {
            return new zzhs(zzehVar, zzehVar2);
        }
        return C1259ka.a(new C1259ka(null), zzehVar, zzehVar2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final boolean equals(Object obj) {
        boolean zza;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh)) {
            return false;
        }
        zzeh zzehVar = (zzeh) obj;
        if (this.zzaaj != zzehVar.size()) {
            return false;
        }
        if (this.zzaaj == 0) {
            return true;
        }
        int zzfe = zzfe();
        int zzfe2 = zzehVar.zzfe();
        if (zzfe != 0 && zzfe2 != 0 && zzfe != zzfe2) {
            return false;
        }
        C1257ja c1257ja = null;
        C1261la c1261la = new C1261la(this, c1257ja);
        zzeq next = c1261la.next();
        C1261la c1261la2 = new C1261la(zzehVar, c1257ja);
        zzeq next2 = c1261la2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                zza = next.zza(next2, i2, min);
            } else {
                zza = next2.zza(next, i, min);
            }
            if (!zza) {
                return false;
            }
            i3 += min;
            int i4 = this.zzaaj;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (min == size) {
                next = c1261la.next();
                i = 0;
            } else {
                i += min;
                next = next;
            }
            if (min == size2) {
                next2 = c1261la2.next();
                i2 = 0;
            } else {
                i2 += min;
            }
        }
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final int size() {
        return this.zzaaj;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zzaam;
        if (i4 <= i5) {
            this.zzaak.zzb(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.zzaal.zzb(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.zzaak.zzb(bArr, i, i2, i6);
            this.zzaal.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final int zzc(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzaam;
        if (i4 <= i5) {
            return this.zzaak.zzc(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzaal.zzc(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzaal.zzc(this.zzaak.zzc(i, i2, i6), 0, i3 - i6);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final zzeh zzd(int i, int i2) {
        int zzd = zzeh.zzd(i, i2, this.zzaaj);
        if (zzd == 0) {
            return zzeh.zzso;
        }
        if (zzd == this.zzaaj) {
            return this;
        }
        int i3 = this.zzaam;
        if (i2 <= i3) {
            return this.zzaak.zzd(i, i2);
        }
        if (i >= i3) {
            return this.zzaal.zzd(i - i3, i2 - i3);
        }
        zzeh zzehVar = this.zzaak;
        return new zzhs(zzehVar.zzd(i, zzehVar.size()), this.zzaal.zzd(0, i2 - this.zzaam));
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh, java.lang.Iterable
    /* renamed from: zzez */
    public final zzeo iterator() {
        return new C1257ja(this);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final boolean zzfb() {
        int zzb = this.zzaak.zzb(0, 0, this.zzaam);
        zzeh zzehVar = this.zzaal;
        return zzehVar.zzb(zzb, 0, zzehVar.size()) == 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final int zzfc() {
        return this.zzaan;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final boolean zzfd() {
        return this.zzaaj >= f13113a[this.zzaan];
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final byte zzk(int i) {
        zzeh.zze(i, this.zzaaj);
        return zzl(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final byte zzl(int i) {
        int i2 = this.zzaam;
        if (i < i2) {
            return this.zzaak.zzl(i);
        }
        return this.zzaal.zzl(i - i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final int zzb(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zzaam;
        if (i4 <= i5) {
            return this.zzaak.zzb(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zzaal.zzb(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zzaal.zzb(this.zzaak.zzb(i, i2, i6), 0, i3 - i6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzhs(zzeh zzehVar, zzeh zzehVar2, C1257ja c1257ja) {
        this(zzehVar, zzehVar2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    public final void zza(zzeg zzegVar) throws IOException {
        this.zzaak.zza(zzegVar);
        this.zzaal.zza(zzegVar);
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzeh
    protected final String zza(Charset charset) {
        byte[] bArr;
        int size = size();
        if (size == 0) {
            bArr = zzfv.EMPTY_BYTE_ARRAY;
        } else {
            byte[] bArr2 = new byte[size];
            zzb(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        return new String(bArr, charset);
    }
}
