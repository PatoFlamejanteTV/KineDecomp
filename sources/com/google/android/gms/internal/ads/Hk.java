package com.google.android.gms.internal.ads;

import android.util.Log;
import android.util.Pair;
import com.google.android.gms.internal.ads.zzki;
import java.util.ArrayList;

/* loaded from: classes2.dex */
final class Hk {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11575a = zzqe.zzam("vide");

    /* renamed from: b, reason: collision with root package name */
    private static final int f11576b = zzqe.zzam("soun");

    /* renamed from: c, reason: collision with root package name */
    private static final int f11577c = zzqe.zzam("text");

    /* renamed from: d, reason: collision with root package name */
    private static final int f11578d = zzqe.zzam("sbtl");

    /* renamed from: e, reason: collision with root package name */
    private static final int f11579e = zzqe.zzam("subt");

    /* renamed from: f, reason: collision with root package name */
    private static final int f11580f = zzqe.zzam("clcp");

    /* renamed from: g, reason: collision with root package name */
    private static final int f11581g = zzqe.zzam("cenc");

    /* renamed from: h, reason: collision with root package name */
    private static final int f11582h = zzqe.zzam("meta");

    /* JADX WARN: Removed duplicated region for block: B:152:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0409  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x03aa  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:395:0x0830 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:396:0x0831  */
    /* JADX WARN: Removed duplicated region for block: B:399:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:402:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:403:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x01b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzjs a(com.google.android.gms.internal.ads.Fk r48, com.google.android.gms.internal.ads.Gk r49, long r50, com.google.android.gms.internal.ads.zzhp r52, boolean r53) throws com.google.android.gms.internal.ads.zzfx {
        /*
            Method dump skipped, instructions count: 2154
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Hk.a(com.google.android.gms.internal.ads.Fk, com.google.android.gms.internal.ads.Gk, long, com.google.android.gms.internal.ads.zzhp, boolean):com.google.android.gms.internal.ads.zzjs");
    }

    public static Zk a(zzjs zzjsVar, Fk fk, zzid zzidVar) throws zzfx {
        Kk nk;
        boolean z;
        int i;
        int i2;
        int i3;
        long[] jArr;
        int[] iArr;
        long[] jArr2;
        int[] iArr2;
        int i4;
        long j;
        long j2;
        int[] iArr3;
        int[] iArr4;
        int i5;
        long[] jArr3;
        boolean z2;
        int[] iArr5;
        long[] jArr4;
        int i6;
        int i7;
        zzjs zzjsVar2 = zzjsVar;
        Gk d2 = fk.d(Ek.qa);
        if (d2 != null) {
            nk = new Mk(d2);
        } else {
            Gk d3 = fk.d(Ek.ra);
            if (d3 != null) {
                nk = new Nk(d3);
            } else {
                throw new zzfx("Track has no sample table size information");
            }
        }
        int c2 = nk.c();
        if (c2 == 0) {
            return new Zk(new long[0], new int[0], 0, new long[0], new int[0]);
        }
        Gk d4 = fk.d(Ek.sa);
        if (d4 == null) {
            d4 = fk.d(Ek.ta);
            z = true;
        } else {
            z = false;
        }
        zzpx zzpxVar = d4.Qa;
        zzpx zzpxVar2 = fk.d(Ek.pa).Qa;
        zzpx zzpxVar3 = fk.d(Ek.ma).Qa;
        Gk d5 = fk.d(Ek.na);
        zzpx zzpxVar4 = d5 != null ? d5.Qa : null;
        Gk d6 = fk.d(Ek.oa);
        zzpx zzpxVar5 = d6 != null ? d6.Qa : null;
        Ik ik = new Ik(zzpxVar2, zzpxVar, z);
        zzpxVar3.setPosition(12);
        int zzhg = zzpxVar3.zzhg() - 1;
        int zzhg2 = zzpxVar3.zzhg();
        int zzhg3 = zzpxVar3.zzhg();
        if (zzpxVar5 != null) {
            zzpxVar5.setPosition(12);
            i = zzpxVar5.zzhg();
        } else {
            i = 0;
        }
        int i8 = -1;
        if (zzpxVar4 != null) {
            zzpxVar4.setPosition(12);
            i2 = zzpxVar4.zzhg();
            if (i2 > 0) {
                i8 = zzpxVar4.zzhg() - 1;
            } else {
                zzpxVar4 = null;
            }
        } else {
            i2 = 0;
        }
        long j3 = 0;
        if (!(nk.b() && "audio/raw".equals(zzjsVar2.zzaad.zzzj) && zzhg == 0 && i == 0 && i2 == 0)) {
            jArr = new long[c2];
            iArr = new int[c2];
            jArr2 = new long[c2];
            int i9 = i2;
            iArr2 = new int[c2];
            int i10 = i9;
            int i11 = zzhg3;
            int i12 = i;
            int i13 = i8;
            long j4 = 0;
            long j5 = 0;
            int i14 = 0;
            int i15 = 0;
            int i16 = 0;
            int i17 = 0;
            int i18 = zzhg2;
            int i19 = zzhg;
            int i20 = 0;
            while (i20 < c2) {
                long j6 = j4;
                int i21 = i14;
                while (i21 == 0) {
                    zzpo.checkState(ik.a());
                    j6 = ik.f11611d;
                    i21 = ik.f11610c;
                    i19 = i19;
                    i11 = i11;
                }
                int i22 = i19;
                int i23 = i11;
                if (zzpxVar5 != null) {
                    while (i17 == 0 && i12 > 0) {
                        i17 = zzpxVar5.zzhg();
                        i16 = zzpxVar5.readInt();
                        i12--;
                    }
                    i17--;
                }
                int i24 = i16;
                jArr[i20] = j6;
                iArr[i20] = nk.a();
                if (iArr[i20] > i15) {
                    i6 = c2;
                    i15 = iArr[i20];
                } else {
                    i6 = c2;
                }
                Kk kk = nk;
                jArr2[i20] = j5 + i24;
                iArr2[i20] = zzpxVar4 == null ? 1 : 0;
                if (i20 == i13) {
                    iArr2[i20] = 1;
                    i10--;
                    if (i10 > 0) {
                        i13 = zzpxVar4.zzhg() - 1;
                    }
                }
                int i25 = i10;
                int i26 = i13;
                int i27 = i23;
                j5 += i27;
                i18--;
                if (i18 != 0 || i22 <= 0) {
                    i7 = i22;
                } else {
                    i7 = i22 - 1;
                    i18 = zzpxVar3.zzhg();
                    i27 = zzpxVar3.zzhg();
                }
                int i28 = i7;
                long j7 = j6 + iArr[i20];
                i20++;
                i13 = i26;
                c2 = i6;
                i14 = i21 - 1;
                i16 = i24;
                i19 = i28;
                j4 = j7;
                i11 = i27;
                i10 = i25;
                nk = kk;
            }
            i3 = c2;
            int i29 = i19;
            zzpo.checkArgument(i17 == 0);
            while (i12 > 0) {
                zzpo.checkArgument(zzpxVar5.zzhg() == 0);
                zzpxVar5.readInt();
                i12--;
            }
            if (i10 == 0 && i18 == 0 && i14 == 0 && i29 == 0) {
                zzjsVar2 = zzjsVar;
            } else {
                int i30 = i10;
                zzjsVar2 = zzjsVar;
                int i31 = zzjsVar2.id;
                StringBuilder sb = new StringBuilder(215);
                sb.append("Inconsistent stbl box for track ");
                sb.append(i31);
                sb.append(": remainingSynchronizationSamples ");
                sb.append(i30);
                sb.append(", remainingSamplesAtTimestampDelta ");
                sb.append(i18);
                sb.append(", remainingSamplesInChunk ");
                sb.append(i14);
                sb.append(", remainingTimestampDeltaChanges ");
                sb.append(i29);
                Log.w("AtomParsers", sb.toString());
            }
            j = j5;
            i4 = i15;
        } else {
            i3 = c2;
            Kk kk2 = nk;
            int i32 = ik.f11608a;
            long[] jArr5 = new long[i32];
            int[] iArr6 = new int[i32];
            while (ik.a()) {
                int i33 = ik.f11609b;
                jArr5[i33] = ik.f11611d;
                iArr6[i33] = ik.f11610c;
            }
            int a2 = kk2.a();
            long j8 = zzhg3;
            int i34 = 8192 / a2;
            int i35 = 0;
            for (int i36 : iArr6) {
                i35 += zzqe.zzf(i36, i34);
            }
            long[] jArr6 = new long[i35];
            int[] iArr7 = new int[i35];
            long[] jArr7 = new long[i35];
            int[] iArr8 = new int[i35];
            int i37 = 0;
            int i38 = 0;
            int i39 = 0;
            int i40 = 0;
            while (i37 < iArr6.length) {
                int i41 = iArr6[i37];
                long j9 = jArr5[i37];
                int i42 = i38;
                int i43 = i40;
                while (i41 > 0) {
                    int min = Math.min(i34, i41);
                    jArr6[i39] = j9;
                    iArr7[i39] = a2 * min;
                    i43 = Math.max(i43, iArr7[i39]);
                    jArr7[i39] = i42 * j8;
                    iArr8[i39] = 1;
                    j9 += iArr7[i39];
                    i42 += min;
                    i41 -= min;
                    i39++;
                    iArr6 = iArr6;
                    jArr5 = jArr5;
                }
                i37++;
                i40 = i43;
                i38 = i42;
            }
            zzjh zzjhVar = new zzjh(jArr6, iArr7, i40, jArr7, iArr8);
            jArr = zzjhVar.zzagu;
            iArr = zzjhVar.zzagt;
            int i44 = zzjhVar.zzapp;
            jArr2 = zzjhVar.zzapq;
            iArr2 = zzjhVar.zzapr;
            i4 = i44;
            j = 0;
        }
        if (zzjsVar2.zzaso != null && !zzidVar.zzea()) {
            long[] jArr8 = zzjsVar2.zzaso;
            if (jArr8.length == 1 && zzjsVar2.type == 1 && jArr2.length >= 2) {
                long j10 = zzjsVar2.zzasp[0];
                long zza = zzqe.zza(jArr8[0], zzjsVar2.zzcr, zzjsVar2.zzasl) + j10;
                if (jArr2[0] <= j10 && j10 < jArr2[1] && jArr2[jArr2.length - 1] < zza && zza <= j) {
                    long j11 = j - zza;
                    long zza2 = zzqe.zza(j10 - jArr2[0], zzjsVar2.zzaad.zzzu, zzjsVar2.zzcr);
                    long zza3 = zzqe.zza(j11, zzjsVar2.zzaad.zzzu, zzjsVar2.zzcr);
                    if ((zza2 != 0 || zza3 != 0) && zza2 <= 2147483647L && zza3 <= 2147483647L) {
                        zzidVar.zzzw = (int) zza2;
                        zzidVar.zzzx = (int) zza3;
                        zzqe.zza(jArr2, 1000000L, zzjsVar2.zzcr);
                        return new Zk(jArr, iArr, i4, jArr2, iArr2);
                    }
                }
            }
            long[] jArr9 = zzjsVar2.zzaso;
            if (jArr9.length == 1) {
                char c3 = 0;
                if (jArr9[0] == 0) {
                    int i45 = 0;
                    while (i45 < jArr2.length) {
                        jArr2[i45] = zzqe.zza(jArr2[i45] - zzjsVar2.zzasp[c3], 1000000L, zzjsVar2.zzcr);
                        i45++;
                        c3 = 0;
                    }
                    return new Zk(jArr, iArr, i4, jArr2, iArr2);
                }
            }
            boolean z3 = zzjsVar2.type == 1;
            int i46 = 0;
            boolean z4 = false;
            int i47 = 0;
            int i48 = 0;
            while (true) {
                long[] jArr10 = zzjsVar2.zzaso;
                j2 = -1;
                if (i46 >= jArr10.length) {
                    break;
                }
                int[] iArr9 = iArr;
                long j12 = zzjsVar2.zzasp[i46];
                if (j12 != -1) {
                    long zza4 = zzqe.zza(jArr10[i46], zzjsVar2.zzcr, zzjsVar2.zzasl);
                    int zzb = zzqe.zzb(jArr2, j12, true, true);
                    int zzb2 = zzqe.zzb(jArr2, j12 + zza4, z3, false);
                    i47 += zzb2 - zzb;
                    z4 |= i48 != zzb;
                    i48 = zzb2;
                }
                i46++;
                iArr = iArr9;
            }
            int[] iArr10 = iArr;
            boolean z5 = (i47 != i3) | z4;
            long[] jArr11 = z5 ? new long[i47] : jArr;
            int[] iArr11 = z5 ? new int[i47] : iArr10;
            if (z5) {
                i4 = 0;
            }
            int[] iArr12 = z5 ? new int[i47] : iArr2;
            long[] jArr12 = new long[i47];
            int i49 = i4;
            int i50 = 0;
            int i51 = 0;
            while (true) {
                long[] jArr13 = zzjsVar2.zzaso;
                if (i50 >= jArr13.length) {
                    break;
                }
                long[] jArr14 = jArr11;
                long[] jArr15 = jArr12;
                long j13 = zzjsVar2.zzasp[i50];
                long j14 = jArr13[i50];
                if (j13 != j2) {
                    iArr4 = iArr12;
                    i5 = i50;
                    long zza5 = zzqe.zza(j14, zzjsVar2.zzcr, zzjsVar2.zzasl) + j13;
                    int zzb3 = zzqe.zzb(jArr2, j13, true, true);
                    int zzb4 = zzqe.zzb(jArr2, zza5, z3, false);
                    if (z5) {
                        int i52 = zzb4 - zzb3;
                        jArr3 = jArr14;
                        System.arraycopy(jArr, zzb3, jArr3, i51, i52);
                        z2 = z3;
                        iArr5 = iArr10;
                        System.arraycopy(iArr5, zzb3, iArr11, i51, i52);
                        System.arraycopy(iArr2, zzb3, iArr4, i51, i52);
                    } else {
                        jArr3 = jArr14;
                        z2 = z3;
                        iArr5 = iArr10;
                    }
                    int i53 = i49;
                    while (zzb3 < zzb4) {
                        long[] jArr16 = jArr;
                        int[] iArr13 = iArr2;
                        long j15 = j13;
                        jArr15[i51] = zzqe.zza(j3, 1000000L, zzjsVar2.zzasl) + zzqe.zza(jArr2[zzb3] - j13, 1000000L, zzjsVar2.zzcr);
                        if (z5 && iArr11[i51] > i53) {
                            i53 = iArr5[zzb3];
                        }
                        i51++;
                        zzb3++;
                        jArr = jArr16;
                        j13 = j15;
                        iArr2 = iArr13;
                    }
                    jArr4 = jArr;
                    iArr3 = iArr2;
                    i49 = i53;
                } else {
                    iArr3 = iArr2;
                    iArr4 = iArr12;
                    i5 = i50;
                    jArr3 = jArr14;
                    z2 = z3;
                    iArr5 = iArr10;
                    jArr4 = jArr;
                }
                j3 += j14;
                i50 = i5 + 1;
                jArr = jArr4;
                iArr10 = iArr5;
                iArr12 = iArr4;
                jArr11 = jArr3;
                z3 = z2;
                iArr2 = iArr3;
                jArr12 = jArr15;
                j2 = -1;
            }
            long[] jArr17 = jArr11;
            long[] jArr18 = jArr12;
            int[] iArr14 = iArr12;
            boolean z6 = false;
            for (int i54 = 0; i54 < iArr14.length && !z6; i54++) {
                z6 |= (iArr14[i54] & 1) != 0;
            }
            if (z6) {
                return new Zk(jArr17, iArr11, i49, jArr18, iArr14);
            }
            throw new zzfx("The edited sample sequence does not contain a sync sample.");
        }
        int[] iArr15 = iArr;
        zzqe.zza(jArr2, 1000000L, zzjsVar2.zzcr);
        return new Zk(jArr, iArr15, i4, jArr2, iArr2);
    }

    public static zzki a(Gk gk, boolean z) {
        if (z) {
            return null;
        }
        zzpx zzpxVar = gk.Qa;
        zzpxVar.setPosition(8);
        while (zzpxVar.zzhb() >= 8) {
            int position = zzpxVar.getPosition();
            int readInt = zzpxVar.readInt();
            if (zzpxVar.readInt() == Ek.Ba) {
                zzpxVar.setPosition(position);
                int i = position + readInt;
                zzpxVar.zzbl(12);
                while (true) {
                    if (zzpxVar.getPosition() >= i) {
                        break;
                    }
                    int position2 = zzpxVar.getPosition();
                    int readInt2 = zzpxVar.readInt();
                    if (zzpxVar.readInt() == Ek.Ca) {
                        zzpxVar.setPosition(position2);
                        int i2 = position2 + readInt2;
                        zzpxVar.zzbl(8);
                        ArrayList arrayList = new ArrayList();
                        while (zzpxVar.getPosition() < i2) {
                            zzki.zza a2 = Uk.a(zzpxVar);
                            if (a2 != null) {
                                arrayList.add(a2);
                            }
                        }
                        if (!arrayList.isEmpty()) {
                            return new zzki(arrayList);
                        }
                    } else {
                        zzpxVar.zzbl(readInt2 - 8);
                    }
                }
                return null;
            }
            zzpxVar.zzbl(readInt - 8);
        }
        return null;
    }

    private static Pair<String, byte[]> a(zzpx zzpxVar, int i) {
        zzpxVar.setPosition(i + 8 + 4);
        zzpxVar.zzbl(1);
        a(zzpxVar);
        zzpxVar.zzbl(2);
        int readUnsignedByte = zzpxVar.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            zzpxVar.zzbl(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            zzpxVar.zzbl(zzpxVar.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            zzpxVar.zzbl(2);
        }
        zzpxVar.zzbl(1);
        a(zzpxVar);
        int readUnsignedByte2 = zzpxVar.readUnsignedByte();
        String str = null;
        if (readUnsignedByte2 == 32) {
            str = "video/mp4v-es";
        } else if (readUnsignedByte2 == 33) {
            str = "video/avc";
        } else if (readUnsignedByte2 != 35) {
            if (readUnsignedByte2 != 64) {
                if (readUnsignedByte2 == 107) {
                    return Pair.create("audio/mpeg", null);
                }
                if (readUnsignedByte2 == 165) {
                    str = "audio/ac3";
                } else if (readUnsignedByte2 != 166) {
                    switch (readUnsignedByte2) {
                        case 102:
                        case 103:
                        case 104:
                            break;
                        default:
                            switch (readUnsignedByte2) {
                                case 169:
                                case 172:
                                    return Pair.create("audio/vnd.dts", null);
                                case 170:
                                case 171:
                                    return Pair.create("audio/vnd.dts.hd", null);
                            }
                    }
                } else {
                    str = "audio/eac3";
                }
            }
            str = "audio/mp4a-latm";
        } else {
            str = "video/hevc";
        }
        zzpxVar.zzbl(12);
        zzpxVar.zzbl(1);
        int a2 = a(zzpxVar);
        byte[] bArr = new byte[a2];
        zzpxVar.zze(bArr, 0, a2);
        return Pair.create(str, bArr);
    }

    private static int a(zzpx zzpxVar, int i, int i2, Lk lk, int i3) {
        zzjt zzjtVar;
        int position = zzpxVar.getPosition();
        while (true) {
            if (position - i >= i2) {
                return 0;
            }
            zzpxVar.setPosition(position);
            int readInt = zzpxVar.readInt();
            zzpo.checkArgument(readInt > 0, "childAtomSize should be positive");
            if (zzpxVar.readInt() == Ek.V) {
                int i4 = position + 8;
                Pair pair = null;
                Integer num = null;
                zzjt zzjtVar2 = null;
                boolean z = false;
                while (i4 - position < readInt) {
                    zzpxVar.setPosition(i4);
                    int readInt2 = zzpxVar.readInt();
                    int readInt3 = zzpxVar.readInt();
                    if (readInt3 == Ek.ba) {
                        num = Integer.valueOf(zzpxVar.readInt());
                    } else if (readInt3 == Ek.W) {
                        zzpxVar.zzbl(4);
                        z = zzpxVar.readInt() == f11581g;
                    } else if (readInt3 == Ek.X) {
                        int i5 = i4 + 8;
                        while (true) {
                            if (i5 - i4 >= readInt2) {
                                zzjtVar = null;
                                break;
                            }
                            zzpxVar.setPosition(i5);
                            int readInt4 = zzpxVar.readInt();
                            if (zzpxVar.readInt() == Ek.Y) {
                                zzpxVar.zzbl(6);
                                boolean z2 = zzpxVar.readUnsignedByte() == 1;
                                int readUnsignedByte = zzpxVar.readUnsignedByte();
                                byte[] bArr = new byte[16];
                                zzpxVar.zze(bArr, 0, 16);
                                zzjtVar = new zzjt(z2, readUnsignedByte, bArr);
                            } else {
                                i5 += readInt4;
                            }
                        }
                        zzjtVar2 = zzjtVar;
                    }
                    i4 += readInt2;
                }
                if (z) {
                    zzpo.checkArgument(num != null, "frma atom is mandatory");
                    zzpo.checkArgument(zzjtVar2 != null, "schi->tenc atom is mandatory");
                    pair = Pair.create(num, zzjtVar2);
                }
                if (pair != null) {
                    lk.f11670a[i3] = (zzjt) pair.second;
                    return ((Integer) pair.first).intValue();
                }
            }
            position += readInt;
        }
    }

    private static int a(zzpx zzpxVar) {
        int readUnsignedByte = zzpxVar.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = zzpxVar.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }
}
