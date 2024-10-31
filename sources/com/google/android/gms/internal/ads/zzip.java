package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Locale;
import java.util.UUID;

/* loaded from: classes2.dex */
public final class zzip implements zzhz {
    private static final zzic zzahq = new C1184zk();
    private static final byte[] zzahr = {Framer.STDOUT_FRAME_PREFIX, 10, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 32, Framer.STDIN_FRAME_PREFIX, Framer.STDIN_FRAME_PREFIX, 62, 32, 48, 48, 58, 48, 48, 58, 48, 48, 44, 48, 48, 48, 10};
    private static final byte[] zzahs = {32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32, 32};
    private static final UUID zzaht = new UUID(72057594037932032L, -9223371306706625679L);
    private long zzaan;
    private final Dk zzahk;
    private final InterfaceC1156xk zzahu;
    private final SparseArray<Bk> zzahv;
    private final boolean zzahw;
    private final zzpx zzahx;
    private final zzpx zzahy;
    private final zzpx zzahz;
    private final zzpx zzaia;
    private final zzpx zzaib;
    private final zzpx zzaic;
    private final zzpx zzaid;
    private final zzpx zzaie;
    private final zzpx zzaif;
    private ByteBuffer zzaig;
    private long zzaih;
    private long zzaii;
    private long zzaij;
    private long zzaik;
    private Bk zzail;
    private boolean zzaim;
    private int zzain;
    private long zzaio;
    private boolean zzaip;
    private long zzaiq;
    private long zzair;
    private long zzais;
    private zzpr zzait;
    private zzpr zzaiu;
    private boolean zzaiv;
    private int zzaiw;
    private long zzaix;
    private long zzaiy;
    private int zzaiz;
    private int zzaja;
    private int[] zzajb;
    private int zzajc;
    private int zzajd;
    private int zzaje;
    private int zzajf;
    private boolean zzajg;
    private boolean zzajh;
    private boolean zzaji;
    private boolean zzajj;
    private byte zzajk;
    private int zzajl;
    private int zzajm;
    private int zzajn;
    private boolean zzajo;
    private boolean zzajp;
    private zzib zzajq;

    public zzip() {
        this(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzab(int i) {
        switch (i) {
            case 131:
            case 136:
            case 155:
            case 159:
            case 176:
            case 179:
            case 186:
            case 215:
            case 231:
            case 241:
            case 251:
            case 16980:
            case 17029:
            case 17143:
            case 18401:
            case 18408:
            case 20529:
            case 20530:
            case 21420:
            case 21432:
            case 21680:
            case 21682:
            case 21690:
            case 21930:
            case 21945:
            case 21946:
            case 21947:
            case 21948:
            case 21949:
            case 22186:
            case 22203:
            case 25188:
            case 2352003:
            case 2807729:
                return 2;
            case 134:
            case 17026:
            case 2274716:
                return 3;
            case 160:
            case 174:
            case 183:
            case 187:
            case 224:
            case 225:
            case 18407:
            case 19899:
            case 20532:
            case 20533:
            case 21936:
            case 21968:
            case 25152:
            case 28032:
            case 30320:
            case 290298740:
            case 357149030:
            case 374648427:
            case 408125543:
            case 440786851:
            case 475249515:
            case 524531317:
                return 1;
            case 161:
            case 163:
            case 16981:
            case 18402:
            case 21419:
            case 25506:
            case 30322:
                return 4;
            case 181:
            case 17545:
            case 21969:
            case 21970:
            case 21971:
            case 21972:
            case 21973:
            case 21974:
            case 21975:
            case 21976:
            case 21977:
            case 21978:
                return 5;
            default:
                return 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean zzac(int i) {
        return i == 357149030 || i == 524531317 || i == 475249515 || i == 374648427;
    }

    private final void zzb(zzia zziaVar, int i) throws IOException, InterruptedException {
        if (this.zzahz.limit() >= i) {
            return;
        }
        if (this.zzahz.capacity() < i) {
            zzpx zzpxVar = this.zzahz;
            byte[] bArr = zzpxVar.data;
            zzpxVar.zzc(Arrays.copyOf(bArr, Math.max(bArr.length << 1, i)), this.zzahz.limit());
        }
        zzpx zzpxVar2 = this.zzahz;
        zziaVar.readFully(zzpxVar2.data, zzpxVar2.limit(), i - this.zzahz.limit());
        this.zzahz.zzbk(i);
    }

    private final void zzeb() {
        this.zzajf = 0;
        this.zzajn = 0;
        this.zzajm = 0;
        this.zzajg = false;
        this.zzajh = false;
        this.zzajj = false;
        this.zzajl = 0;
        this.zzajk = (byte) 0;
        this.zzaji = false;
        this.zzaic.reset();
    }

    private final long zzs(long j) throws zzfx {
        long j2 = this.zzaij;
        if (j2 != -9223372036854775807L) {
            return zzqe.zza(j, j2, 1000L);
        }
        throw new zzfx("Can't scale timecode prior to timecodeScale being set.");
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void release() {
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final boolean zza(zzia zziaVar) throws IOException, InterruptedException {
        return new Ck().a(zziaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzad(int i) throws zzfx {
        zzig zzihVar;
        zzpr zzprVar;
        zzpr zzprVar2;
        int i2;
        if (i == 160) {
            if (this.zzaiw != 2) {
                return;
            }
            if (!this.zzajp) {
                this.zzaje |= 1;
            }
            zza(this.zzahv.get(this.zzajc), this.zzaix);
            this.zzaiw = 0;
            return;
        }
        if (i == 174) {
            String str = this.zzail.f11409a;
            if ((("V_VP8".equals(str) || "V_VP9".equals(str) || "V_MPEG2".equals(str) || "V_MPEG4/ISO/SP".equals(str) || "V_MPEG4/ISO/ASP".equals(str) || "V_MPEG4/ISO/AP".equals(str) || "V_MPEG4/ISO/AVC".equals(str) || "V_MPEGH/ISO/HEVC".equals(str) || "V_MS/VFW/FOURCC".equals(str) || "V_THEORA".equals(str) || "A_OPUS".equals(str) || "A_VORBIS".equals(str) || "A_AAC".equals(str) || "A_MPEG/L2".equals(str) || "A_MPEG/L3".equals(str) || "A_AC3".equals(str) || "A_EAC3".equals(str) || "A_TRUEHD".equals(str) || "A_DTS".equals(str) || "A_DTS/EXPRESS".equals(str) || "A_DTS/LOSSLESS".equals(str) || "A_FLAC".equals(str) || "A_MS/ACM".equals(str) || "A_PCM/INT/LIT".equals(str) || "S_TEXT/UTF8".equals(str) || "S_VOBSUB".equals(str) || "S_HDMV/PGS".equals(str) || "S_DVBSUB".equals(str)) ? 1 : 0) != 0) {
                Bk bk = this.zzail;
                bk.a(this.zzajq, bk.f11410b);
                SparseArray<Bk> sparseArray = this.zzahv;
                Bk bk2 = this.zzail;
                sparseArray.put(bk2.f11410b, bk2);
            }
            this.zzail = null;
            return;
        }
        if (i == 19899) {
            int i3 = this.zzain;
            if (i3 != -1) {
                long j = this.zzaio;
                if (j != -1) {
                    if (i3 == 475249515) {
                        this.zzaiq = j;
                        return;
                    }
                    return;
                }
            }
            throw new zzfx("Mandatory element SeekID or SeekPosition not found");
        }
        if (i == 25152) {
            Bk bk3 = this.zzail;
            if (bk3.f11413e) {
                zzij zzijVar = bk3.f11415g;
                if (zzijVar != null) {
                    bk3.i = new zzhp(new zzhp.zza(zzfe.zzwm, "video/webm", zzijVar.zzahh));
                    return;
                }
                throw new zzfx("Encrypted Track found but ContentEncKeyID was not found");
            }
            return;
        }
        if (i == 28032) {
            Bk bk4 = this.zzail;
            if (bk4.f11413e && bk4.f11414f != null) {
                throw new zzfx("Combining encryption and compression is not supported");
            }
            return;
        }
        if (i == 357149030) {
            if (this.zzaij == -9223372036854775807L) {
                this.zzaij = 1000000L;
            }
            long j2 = this.zzaik;
            if (j2 != -9223372036854775807L) {
                this.zzaan = zzs(j2);
                return;
            }
            return;
        }
        if (i != 374648427) {
            if (i == 475249515 && !this.zzaim) {
                zzib zzibVar = this.zzajq;
                if (this.zzaii != -1 && this.zzaan != -9223372036854775807L && (zzprVar = this.zzait) != null && zzprVar.size() != 0 && (zzprVar2 = this.zzaiu) != null && zzprVar2.size() == this.zzait.size()) {
                    int size = this.zzait.size();
                    int[] iArr = new int[size];
                    long[] jArr = new long[size];
                    long[] jArr2 = new long[size];
                    long[] jArr3 = new long[size];
                    for (int i4 = 0; i4 < size; i4++) {
                        jArr3[i4] = this.zzait.get(i4);
                        jArr[i4] = this.zzaii + this.zzaiu.get(i4);
                    }
                    while (true) {
                        i2 = size - 1;
                        if (r1 >= i2) {
                            break;
                        }
                        int i5 = r1 + 1;
                        iArr[r1] = (int) (jArr[i5] - jArr[r1]);
                        jArr2[r1] = jArr3[i5] - jArr3[r1];
                        r1 = i5;
                    }
                    iArr[i2] = (int) ((this.zzaii + this.zzaih) - jArr[i2]);
                    jArr2[i2] = this.zzaan - jArr3[i2];
                    this.zzait = null;
                    this.zzaiu = null;
                    zzihVar = new zzhw(iArr, jArr, jArr2, jArr3);
                } else {
                    this.zzait = null;
                    this.zzaiu = null;
                    zzihVar = new zzih(this.zzaan);
                }
                zzibVar.zza(zzihVar);
                this.zzaim = true;
                return;
            }
            return;
        }
        if (this.zzahv.size() != 0) {
            this.zzajq.zzdy();
            return;
        }
        throw new zzfx("No valid tracks were found");
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zzc(long j, long j2) {
        this.zzais = -9223372036854775807L;
        this.zzaiw = 0;
        this.zzahu.reset();
        this.zzahk.a();
        zzeb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(int i, long j, long j2) throws zzfx {
        if (i == 160) {
            this.zzajp = false;
            return;
        }
        if (i == 174) {
            this.zzail = new Bk(null);
            return;
        }
        if (i == 187) {
            this.zzaiv = false;
            return;
        }
        if (i == 19899) {
            this.zzain = -1;
            this.zzaio = -1L;
            return;
        }
        if (i == 20533) {
            this.zzail.f11413e = true;
            return;
        }
        if (i == 21968) {
            this.zzail.q = true;
            return;
        }
        if (i != 25152) {
            if (i == 408125543) {
                long j3 = this.zzaii;
                if (j3 != -1 && j3 != j) {
                    throw new zzfx("Multiple Segment elements not supported");
                }
                this.zzaii = j;
                this.zzaih = j2;
                return;
            }
            if (i != 475249515) {
                if (i == 524531317 && !this.zzaim) {
                    if (this.zzahw && this.zzaiq != -1) {
                        this.zzaip = true;
                        return;
                    } else {
                        this.zzajq.zza(new zzih(this.zzaan));
                        this.zzaim = true;
                        return;
                    }
                }
                return;
            }
            this.zzait = new zzpr();
            this.zzaiu = new zzpr();
        }
    }

    public zzip(int i) {
        this(new C1114uk(), i);
    }

    @Override // com.google.android.gms.internal.ads.zzhz
    public final void zza(zzib zzibVar) {
        this.zzajq = zzibVar;
    }

    private zzip(InterfaceC1156xk interfaceC1156xk, int i) {
        this.zzaii = -1L;
        this.zzaij = -9223372036854775807L;
        this.zzaik = -9223372036854775807L;
        this.zzaan = -9223372036854775807L;
        this.zzaiq = -1L;
        this.zzair = -1L;
        this.zzais = -9223372036854775807L;
        this.zzahu = interfaceC1156xk;
        this.zzahu.a(new Ak(this, null));
        this.zzahw = (i & 1) == 0;
        this.zzahk = new Dk();
        this.zzahv = new SparseArray<>();
        this.zzahz = new zzpx(4);
        this.zzaia = new zzpx(ByteBuffer.allocate(4).putInt(-1).array());
        this.zzaib = new zzpx(4);
        this.zzahx = new zzpx(zzpu.zzbhi);
        this.zzahy = new zzpx(4);
        this.zzaic = new zzpx();
        this.zzaid = new zzpx();
        this.zzaie = new zzpx(8);
        this.zzaif = new zzpx();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0039 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0005 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzhz
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zza(com.google.android.gms.internal.ads.zzia r9, com.google.android.gms.internal.ads.zzif r10) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r8 = this;
            r0 = 0
            r8.zzajo = r0
            r1 = 1
            r2 = 1
        L5:
            if (r2 == 0) goto L3a
            boolean r3 = r8.zzajo
            if (r3 != 0) goto L3a
            com.google.android.gms.internal.ads.xk r2 = r8.zzahu
            boolean r2 = r2.a(r9)
            if (r2 == 0) goto L5
            long r3 = r9.getPosition()
            boolean r5 = r8.zzaip
            if (r5 == 0) goto L25
            r8.zzair = r3
            long r3 = r8.zzaiq
            r10.zzaha = r3
            r8.zzaip = r0
        L23:
            r3 = 1
            goto L37
        L25:
            boolean r3 = r8.zzaim
            if (r3 == 0) goto L36
            long r3 = r8.zzair
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L36
            r10.zzaha = r3
            r8.zzair = r5
            goto L23
        L36:
            r3 = 0
        L37:
            if (r3 == 0) goto L5
            return r1
        L3a:
            if (r2 == 0) goto L3d
            return r0
        L3d:
            r9 = -1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zza(com.google.android.gms.internal.ads.zzia, com.google.android.gms.internal.ads.zzif):int");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzc(int i, long j) throws zzfx {
        if (i == 20529) {
            if (j == 0) {
                return;
            }
            StringBuilder sb = new StringBuilder(55);
            sb.append("ContentEncodingOrder ");
            sb.append(j);
            sb.append(" not supported");
            throw new zzfx(sb.toString());
        }
        if (i == 20530) {
            if (j == 1) {
                return;
            }
            StringBuilder sb2 = new StringBuilder(55);
            sb2.append("ContentEncodingScope ");
            sb2.append(j);
            sb2.append(" not supported");
            throw new zzfx(sb2.toString());
        }
        switch (i) {
            case 131:
                this.zzail.f11411c = (int) j;
                return;
            case 136:
                this.zzail.L = j == 1;
                return;
            case 155:
                this.zzaiy = zzs(j);
                return;
            case 159:
                this.zzail.G = (int) j;
                return;
            case 176:
                this.zzail.j = (int) j;
                return;
            case 179:
                this.zzait.add(zzs(j));
                return;
            case 186:
                this.zzail.k = (int) j;
                return;
            case 215:
                this.zzail.f11410b = (int) j;
                return;
            case 231:
                this.zzais = zzs(j);
                return;
            case 241:
                if (this.zzaiv) {
                    return;
                }
                this.zzaiu.add(j);
                this.zzaiv = true;
                return;
            case 251:
                this.zzajp = true;
                return;
            case 16980:
                if (j == 3) {
                    return;
                }
                StringBuilder sb3 = new StringBuilder(50);
                sb3.append("ContentCompAlgo ");
                sb3.append(j);
                sb3.append(" not supported");
                throw new zzfx(sb3.toString());
            case 17029:
                if (j < 1 || j > 2) {
                    StringBuilder sb4 = new StringBuilder(53);
                    sb4.append("DocTypeReadVersion ");
                    sb4.append(j);
                    sb4.append(" not supported");
                    throw new zzfx(sb4.toString());
                }
                return;
            case 17143:
                if (j == 1) {
                    return;
                }
                StringBuilder sb5 = new StringBuilder(50);
                sb5.append("EBMLReadVersion ");
                sb5.append(j);
                sb5.append(" not supported");
                throw new zzfx(sb5.toString());
            case 18401:
                if (j == 5) {
                    return;
                }
                StringBuilder sb6 = new StringBuilder(49);
                sb6.append("ContentEncAlgo ");
                sb6.append(j);
                sb6.append(" not supported");
                throw new zzfx(sb6.toString());
            case 18408:
                if (j == 1) {
                    return;
                }
                StringBuilder sb7 = new StringBuilder(56);
                sb7.append("AESSettingsCipherMode ");
                sb7.append(j);
                sb7.append(" not supported");
                throw new zzfx(sb7.toString());
            case 21420:
                this.zzaio = j + this.zzaii;
                return;
            case 21432:
                int i2 = (int) j;
                if (i2 == 0) {
                    this.zzail.p = 0;
                    return;
                }
                if (i2 == 1) {
                    this.zzail.p = 2;
                    return;
                } else if (i2 == 3) {
                    this.zzail.p = 1;
                    return;
                } else {
                    if (i2 != 15) {
                        return;
                    }
                    this.zzail.p = 3;
                    return;
                }
            case 21680:
                this.zzail.l = (int) j;
                return;
            case 21682:
                this.zzail.n = (int) j;
                return;
            case 21690:
                this.zzail.m = (int) j;
                return;
            case 21930:
                this.zzail.M = j == 1;
                return;
            case 22186:
                this.zzail.J = j;
                return;
            case 22203:
                this.zzail.K = j;
                return;
            case 25188:
                this.zzail.H = (int) j;
                return;
            case 2352003:
                this.zzail.f11412d = (int) j;
                return;
            case 2807729:
                this.zzaij = j;
                return;
            default:
                switch (i) {
                    case 21945:
                        int i3 = (int) j;
                        if (i3 == 1) {
                            this.zzail.t = 2;
                            return;
                        } else {
                            if (i3 != 2) {
                                return;
                            }
                            this.zzail.t = 1;
                            return;
                        }
                    case 21946:
                        int i4 = (int) j;
                        if (i4 != 1) {
                            if (i4 == 16) {
                                this.zzail.s = 6;
                                return;
                            } else if (i4 == 18) {
                                this.zzail.s = 7;
                                return;
                            } else if (i4 != 6 && i4 != 7) {
                                return;
                            }
                        }
                        this.zzail.s = 3;
                        return;
                    case 21947:
                        Bk bk = this.zzail;
                        bk.q = true;
                        int i5 = (int) j;
                        if (i5 == 1) {
                            bk.r = 1;
                            return;
                        }
                        if (i5 == 9) {
                            bk.r = 6;
                            return;
                        } else {
                            if (i5 == 4 || i5 == 5 || i5 == 6 || i5 == 7) {
                                this.zzail.r = 2;
                                return;
                            }
                            return;
                        }
                    case 21948:
                        this.zzail.u = (int) j;
                        return;
                    case 21949:
                        this.zzail.v = (int) j;
                        return;
                    default:
                        return;
                }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, double d2) {
        if (i == 181) {
            this.zzail.I = (int) d2;
            return;
        }
        if (i != 17545) {
            switch (i) {
                case 21969:
                    this.zzail.w = (float) d2;
                    return;
                case 21970:
                    this.zzail.x = (float) d2;
                    return;
                case 21971:
                    this.zzail.y = (float) d2;
                    return;
                case 21972:
                    this.zzail.z = (float) d2;
                    return;
                case 21973:
                    this.zzail.A = (float) d2;
                    return;
                case 21974:
                    this.zzail.B = (float) d2;
                    return;
                case 21975:
                    this.zzail.C = (float) d2;
                    return;
                case 21976:
                    this.zzail.D = (float) d2;
                    return;
                case 21977:
                    this.zzail.E = (float) d2;
                    return;
                case 21978:
                    this.zzail.F = (float) d2;
                    return;
                default:
                    return;
            }
        }
        this.zzaik = (long) d2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zza(int i, String str) throws zzfx {
        if (i == 134) {
            this.zzail.f11409a = str;
            return;
        }
        if (i != 17026) {
            if (i != 2274716) {
                return;
            }
            Bk.a(this.zzail, str);
        } else {
            if ("webm".equals(str) || "matroska".equals(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 22);
            sb.append("DocType ");
            sb.append(str);
            sb.append(" not supported");
            throw new zzfx(sb.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x01fd, code lost:            throw new com.google.android.gms.internal.ads.zzfx("EBML lacing sample size out of range.");     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(int r20, int r21, com.google.android.gms.internal.ads.zzia r22) throws java.io.IOException, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 692
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzip.zza(int, int, com.google.android.gms.internal.ads.zzia):void");
    }

    private final void zza(Bk bk, long j) {
        byte[] zzaj;
        if ("S_TEXT/UTF8".equals(bk.f11409a)) {
            byte[] bArr = this.zzaid.data;
            long j2 = this.zzaiy;
            if (j2 == -9223372036854775807L) {
                zzaj = zzahs;
            } else {
                int i = (int) (j2 / 3600000000L);
                long j3 = j2 - (i * 3600000000L);
                int i2 = (int) (j3 / 60000000);
                long j4 = j3 - (60000000 * i2);
                zzaj = zzqe.zzaj(String.format(Locale.US, "%02d:%02d:%02d,%03d", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf((int) (j4 / 1000000)), Integer.valueOf((int) ((j4 - (1000000 * r4)) / 1000))));
            }
            System.arraycopy(zzaj, 0, bArr, 19, 12);
            zzii zziiVar = bk.O;
            zzpx zzpxVar = this.zzaid;
            zziiVar.zza(zzpxVar, zzpxVar.limit());
            this.zzajn += this.zzaid.limit();
        }
        bk.O.zza(j, this.zzaje, this.zzajn, 0, bk.f11415g);
        this.zzajo = true;
        zzeb();
    }

    private final void zza(zzia zziaVar, Bk bk, int i) throws IOException, InterruptedException {
        int i2;
        if ("S_TEXT/UTF8".equals(bk.f11409a)) {
            int length = zzahr.length + i;
            if (this.zzaid.capacity() < length) {
                this.zzaid.data = Arrays.copyOf(zzahr, length + i);
            }
            zziaVar.readFully(this.zzaid.data, zzahr.length, i);
            this.zzaid.setPosition(0);
            this.zzaid.zzbk(length);
            return;
        }
        zzii zziiVar = bk.O;
        if (!this.zzajg) {
            if (bk.f11413e) {
                this.zzaje &= -1073741825;
                if (!this.zzajh) {
                    zziaVar.readFully(this.zzahz.data, 0, 1);
                    this.zzajf++;
                    byte[] bArr = this.zzahz.data;
                    if ((bArr[0] & 128) != 128) {
                        this.zzajk = bArr[0];
                        this.zzajh = true;
                    } else {
                        throw new zzfx("Extension bit is set in signal byte");
                    }
                }
                byte b2 = this.zzajk;
                if ((b2 & 1) == 1) {
                    boolean z = (b2 & 2) == 2;
                    this.zzaje |= 1073741824;
                    if (!this.zzaji) {
                        zziaVar.readFully(this.zzaie.data, 0, 8);
                        this.zzajf += 8;
                        this.zzaji = true;
                        this.zzahz.data[0] = (byte) ((z ? 128 : 0) | 8);
                        this.zzahz.setPosition(0);
                        zziiVar.zza(this.zzahz, 1);
                        this.zzajn++;
                        this.zzaie.setPosition(0);
                        zziiVar.zza(this.zzaie, 8);
                        this.zzajn += 8;
                    }
                    if (z) {
                        if (!this.zzajj) {
                            zziaVar.readFully(this.zzahz.data, 0, 1);
                            this.zzajf++;
                            this.zzahz.setPosition(0);
                            this.zzajl = this.zzahz.readUnsignedByte();
                            this.zzajj = true;
                        }
                        int i3 = this.zzajl << 2;
                        this.zzahz.reset(i3);
                        zziaVar.readFully(this.zzahz.data, 0, i3);
                        this.zzajf += i3;
                        short s = (short) ((this.zzajl / 2) + 1);
                        int i4 = (s * 6) + 2;
                        ByteBuffer byteBuffer = this.zzaig;
                        if (byteBuffer == null || byteBuffer.capacity() < i4) {
                            this.zzaig = ByteBuffer.allocate(i4);
                        }
                        this.zzaig.position(0);
                        this.zzaig.putShort(s);
                        int i5 = 0;
                        int i6 = 0;
                        while (true) {
                            i2 = this.zzajl;
                            if (i5 >= i2) {
                                break;
                            }
                            int zzhg = this.zzahz.zzhg();
                            if (i5 % 2 == 0) {
                                this.zzaig.putShort((short) (zzhg - i6));
                            } else {
                                this.zzaig.putInt(zzhg - i6);
                            }
                            i5++;
                            i6 = zzhg;
                        }
                        int i7 = (i - this.zzajf) - i6;
                        if (i2 % 2 == 1) {
                            this.zzaig.putInt(i7);
                        } else {
                            this.zzaig.putShort((short) i7);
                            this.zzaig.putInt(0);
                        }
                        this.zzaif.zzc(this.zzaig.array(), i4);
                        zziiVar.zza(this.zzaif, i4);
                        this.zzajn += i4;
                    }
                }
            } else {
                byte[] bArr2 = bk.f11414f;
                if (bArr2 != null) {
                    this.zzaic.zzc(bArr2, bArr2.length);
                }
            }
            this.zzajg = true;
        }
        int limit = i + this.zzaic.limit();
        if (!"V_MPEG4/ISO/AVC".equals(bk.f11409a) && !"V_MPEGH/ISO/HEVC".equals(bk.f11409a)) {
            while (true) {
                int i8 = this.zzajf;
                if (i8 >= limit) {
                    break;
                } else {
                    zza(zziaVar, zziiVar, limit - i8);
                }
            }
        } else {
            byte[] bArr3 = this.zzahy.data;
            bArr3[0] = 0;
            bArr3[1] = 0;
            bArr3[2] = 0;
            int i9 = bk.P;
            int i10 = 4 - i9;
            while (this.zzajf < limit) {
                int i11 = this.zzajm;
                if (i11 == 0) {
                    int min = Math.min(i9, this.zzaic.zzhb());
                    zziaVar.readFully(bArr3, i10 + min, i9 - min);
                    if (min > 0) {
                        this.zzaic.zze(bArr3, i10, min);
                    }
                    this.zzajf += i9;
                    this.zzahy.setPosition(0);
                    this.zzajm = this.zzahy.zzhg();
                    this.zzahx.setPosition(0);
                    zziiVar.zza(this.zzahx, 4);
                    this.zzajn += 4;
                } else {
                    this.zzajm = i11 - zza(zziaVar, zziiVar, i11);
                }
            }
        }
        if ("A_VORBIS".equals(bk.f11409a)) {
            this.zzaia.setPosition(0);
            zziiVar.zza(this.zzaia, 4);
            this.zzajn += 4;
        }
    }

    private final int zza(zzia zziaVar, zzii zziiVar, int i) throws IOException, InterruptedException {
        int zza;
        int zzhb = this.zzaic.zzhb();
        if (zzhb > 0) {
            zza = Math.min(i, zzhb);
            zziiVar.zza(this.zzaic, zza);
        } else {
            zza = zziiVar.zza(zziaVar, i, false);
        }
        this.zzajf += zza;
        this.zzajn += zza;
        return zza;
    }

    private static int[] zza(int[] iArr, int i) {
        if (iArr == null) {
            return new int[i];
        }
        return iArr.length >= i ? iArr : new int[Math.max(iArr.length << 1, i)];
    }
}
