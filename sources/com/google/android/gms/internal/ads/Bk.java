package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class Bk {
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public int G;
    public int H;
    public int I;
    public long J;
    public long K;
    public boolean L;
    public boolean M;
    private String N;
    public zzii O;
    public int P;

    /* renamed from: a */
    public String f11409a;

    /* renamed from: b */
    public int f11410b;

    /* renamed from: c */
    public int f11411c;

    /* renamed from: d */
    public int f11412d;

    /* renamed from: e */
    public boolean f11413e;

    /* renamed from: f */
    public byte[] f11414f;

    /* renamed from: g */
    public zzij f11415g;

    /* renamed from: h */
    public byte[] f11416h;
    public zzhp i;
    public int j;
    public int k;
    public int l;
    public int m;
    public int n;
    public byte[] o;
    public int p;
    public boolean q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public float w;
    public float x;
    public float y;
    public float z;

    private Bk() {
        this.j = -1;
        this.k = -1;
        this.l = -1;
        this.m = -1;
        this.n = 0;
        this.o = null;
        this.p = -1;
        this.q = false;
        this.r = -1;
        this.s = -1;
        this.t = -1;
        this.u = 1000;
        this.v = 200;
        this.w = -1.0f;
        this.x = -1.0f;
        this.y = -1.0f;
        this.z = -1.0f;
        this.A = -1.0f;
        this.B = -1.0f;
        this.C = -1.0f;
        this.D = -1.0f;
        this.E = -1.0f;
        this.F = -1.0f;
        this.G = 1;
        this.H = -1;
        this.I = io.fabric.sdk.android.a.b.c.MAX_BYTE_SIZE_PER_FILE;
        this.J = 0L;
        this.K = 0L;
        this.M = true;
        this.N = "eng";
    }

    private static boolean b(zzpx zzpxVar) throws zzfx {
        UUID uuid;
        UUID uuid2;
        try {
            int zzhc = zzpxVar.zzhc();
            if (zzhc == 1) {
                return true;
            }
            if (zzhc == 65534) {
                zzpxVar.setPosition(24);
                long readLong = zzpxVar.readLong();
                uuid = zzip.zzaht;
                if (readLong == uuid.getMostSignificantBits()) {
                    long readLong2 = zzpxVar.readLong();
                    uuid2 = zzip.zzaht;
                    if (readLong2 == uuid2.getLeastSignificantBits()) {
                        return true;
                    }
                }
            }
            return false;
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing MS/ACM codec private");
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:7:0x015f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0312  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.google.android.gms.internal.ads.zzib r30, int r31) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 1402
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Bk.a(com.google.android.gms.internal.ads.zzib, int):void");
    }

    public /* synthetic */ Bk(C1184zk c1184zk) {
        this();
    }

    private static List<byte[]> a(zzpx zzpxVar) throws zzfx {
        try {
            zzpxVar.zzbl(16);
            if (zzpxVar.zzhe() != 826496599) {
                return null;
            }
            byte[] bArr = zzpxVar.data;
            for (int position = zzpxVar.getPosition() + 20; position < bArr.length - 4; position++) {
                if (bArr[position] == 0 && bArr[position + 1] == 0 && bArr[position + 2] == 1 && bArr[position + 3] == 15) {
                    return Collections.singletonList(Arrays.copyOfRange(bArr, position, bArr.length));
                }
            }
            throw new zzfx("Failed to find FourCC VC1 initialization data");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing FourCC VC1 codec private");
        }
    }

    private static List<byte[]> a(byte[] bArr) throws zzfx {
        try {
            if (bArr[0] == 2) {
                int i = 1;
                int i2 = 0;
                while (bArr[i] == -1) {
                    i2 += 255;
                    i++;
                }
                int i3 = i + 1;
                int i4 = i2 + bArr[i];
                int i5 = 0;
                while (bArr[i3] == -1) {
                    i5 += 255;
                    i3++;
                }
                int i6 = i3 + 1;
                int i7 = i5 + bArr[i3];
                if (bArr[i6] == 1) {
                    byte[] bArr2 = new byte[i4];
                    System.arraycopy(bArr, i6, bArr2, 0, i4);
                    int i8 = i6 + i4;
                    if (bArr[i8] == 3) {
                        int i9 = i8 + i7;
                        if (bArr[i9] == 5) {
                            byte[] bArr3 = new byte[bArr.length - i9];
                            System.arraycopy(bArr, i9, bArr3, 0, bArr.length - i9);
                            ArrayList arrayList = new ArrayList(2);
                            arrayList.add(bArr2);
                            arrayList.add(bArr3);
                            return arrayList;
                        }
                        throw new zzfx("Error parsing vorbis codec private");
                    }
                    throw new zzfx("Error parsing vorbis codec private");
                }
                throw new zzfx("Error parsing vorbis codec private");
            }
            throw new zzfx("Error parsing vorbis codec private");
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new zzfx("Error parsing vorbis codec private");
        }
    }

    public static /* synthetic */ String a(Bk bk, String str) {
        bk.N = str;
        return str;
    }
}
