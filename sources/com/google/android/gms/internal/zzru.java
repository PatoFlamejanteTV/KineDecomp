package com.google.android.gms.internal;

import java.io.IOException;

/* loaded from: classes.dex */
public final class zzru extends zzry<zzru> {
    public String[] zzbhU;
    public int[] zzbhV;
    public byte[][] zzbhW;

    public zzru() {
        zzFn();
    }

    public static zzru zzz(byte[] bArr) throws zzsd {
        return (zzru) zzse.zza(new zzru(), bArr);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzru)) {
            return false;
        }
        zzru zzruVar = (zzru) obj;
        if (zzsc.equals(this.zzbhU, zzruVar.zzbhU) && zzsc.equals(this.zzbhV, zzruVar.zzbhV) && zzsc.zza(this.zzbhW, zzruVar.zzbhW)) {
            return (this.zzbik == null || this.zzbik.isEmpty()) ? zzruVar.zzbik == null || zzruVar.zzbik.isEmpty() : this.zzbik.equals(zzruVar.zzbik);
        }
        return false;
    }

    public int hashCode() {
        return ((this.zzbik == null || this.zzbik.isEmpty()) ? 0 : this.zzbik.hashCode()) + ((((((((getClass().getName().hashCode() + 527) * 31) + zzsc.hashCode(this.zzbhU)) * 31) + zzsc.hashCode(this.zzbhV)) * 31) + zzsc.zza(this.zzbhW)) * 31);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public int zzB() {
        int i;
        int zzB = super.zzB();
        if (this.zzbhU == null || this.zzbhU.length <= 0) {
            i = zzB;
        } else {
            int i2 = 0;
            int i3 = 0;
            for (int i4 = 0; i4 < this.zzbhU.length; i4++) {
                String str = this.zzbhU[i4];
                if (str != null) {
                    i3++;
                    i2 += zzrx.zzfA(str);
                }
            }
            i = zzB + i2 + (i3 * 1);
        }
        if (this.zzbhV != null && this.zzbhV.length > 0) {
            int i5 = 0;
            for (int i6 = 0; i6 < this.zzbhV.length; i6++) {
                i5 += zzrx.zzlJ(this.zzbhV[i6]);
            }
            i = i + i5 + (this.zzbhV.length * 1);
        }
        if (this.zzbhW == null || this.zzbhW.length <= 0) {
            return i;
        }
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < this.zzbhW.length; i9++) {
            byte[] bArr = this.zzbhW[i9];
            if (bArr != null) {
                i8++;
                i7 += zzrx.zzE(bArr);
            }
        }
        return i + i7 + (i8 * 1);
    }

    @Override // com.google.android.gms.internal.zzse
    /* renamed from: zzE, reason: merged with bridge method [inline-methods] */
    public zzru zzb(zzrw zzrwVar) throws IOException {
        while (true) {
            int zzFo = zzrwVar.zzFo();
            switch (zzFo) {
                case 0:
                    break;
                case 10:
                    int zzc = zzsh.zzc(zzrwVar, 10);
                    int length = this.zzbhU == null ? 0 : this.zzbhU.length;
                    String[] strArr = new String[zzc + length];
                    if (length != 0) {
                        System.arraycopy(this.zzbhU, 0, strArr, 0, length);
                    }
                    while (length < strArr.length - 1) {
                        strArr[length] = zzrwVar.readString();
                        zzrwVar.zzFo();
                        length++;
                    }
                    strArr[length] = zzrwVar.readString();
                    this.zzbhU = strArr;
                    break;
                case 16:
                    int zzc2 = zzsh.zzc(zzrwVar, 16);
                    int length2 = this.zzbhV == null ? 0 : this.zzbhV.length;
                    int[] iArr = new int[zzc2 + length2];
                    if (length2 != 0) {
                        System.arraycopy(this.zzbhV, 0, iArr, 0, length2);
                    }
                    while (length2 < iArr.length - 1) {
                        iArr[length2] = zzrwVar.zzFr();
                        zzrwVar.zzFo();
                        length2++;
                    }
                    iArr[length2] = zzrwVar.zzFr();
                    this.zzbhV = iArr;
                    break;
                case 18:
                    int zzlC = zzrwVar.zzlC(zzrwVar.zzFv());
                    int position = zzrwVar.getPosition();
                    int i = 0;
                    while (zzrwVar.zzFA() > 0) {
                        zzrwVar.zzFr();
                        i++;
                    }
                    zzrwVar.zzlE(position);
                    int length3 = this.zzbhV == null ? 0 : this.zzbhV.length;
                    int[] iArr2 = new int[i + length3];
                    if (length3 != 0) {
                        System.arraycopy(this.zzbhV, 0, iArr2, 0, length3);
                    }
                    while (length3 < iArr2.length) {
                        iArr2[length3] = zzrwVar.zzFr();
                        length3++;
                    }
                    this.zzbhV = iArr2;
                    zzrwVar.zzlD(zzlC);
                    break;
                case 26:
                    int zzc3 = zzsh.zzc(zzrwVar, 26);
                    int length4 = this.zzbhW == null ? 0 : this.zzbhW.length;
                    byte[][] bArr = new byte[zzc3 + length4];
                    if (length4 != 0) {
                        System.arraycopy(this.zzbhW, 0, bArr, 0, length4);
                    }
                    while (length4 < bArr.length - 1) {
                        bArr[length4] = zzrwVar.readBytes();
                        zzrwVar.zzFo();
                        length4++;
                    }
                    bArr[length4] = zzrwVar.readBytes();
                    this.zzbhW = bArr;
                    break;
                default:
                    if (!zza(zzrwVar, zzFo)) {
                        break;
                    } else {
                        break;
                    }
            }
        }
        return this;
    }

    public zzru zzFn() {
        this.zzbhU = zzsh.zzbiC;
        this.zzbhV = zzsh.zzbix;
        this.zzbhW = zzsh.zzbiD;
        this.zzbik = null;
        this.zzbiv = -1;
        return this;
    }

    @Override // com.google.android.gms.internal.zzry, com.google.android.gms.internal.zzse
    public void zza(zzrx zzrxVar) throws IOException {
        if (this.zzbhU != null && this.zzbhU.length > 0) {
            for (int i = 0; i < this.zzbhU.length; i++) {
                String str = this.zzbhU[i];
                if (str != null) {
                    zzrxVar.zzb(1, str);
                }
            }
        }
        if (this.zzbhV != null && this.zzbhV.length > 0) {
            for (int i2 = 0; i2 < this.zzbhV.length; i2++) {
                zzrxVar.zzy(2, this.zzbhV[i2]);
            }
        }
        if (this.zzbhW != null && this.zzbhW.length > 0) {
            for (int i3 = 0; i3 < this.zzbhW.length; i3++) {
                byte[] bArr = this.zzbhW[i3];
                if (bArr != null) {
                    zzrxVar.zza(3, bArr);
                }
            }
        }
        super.zza(zzrxVar);
    }
}
