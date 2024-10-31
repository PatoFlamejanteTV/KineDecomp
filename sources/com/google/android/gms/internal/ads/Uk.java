package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.gms.internal.ads.zzki;

/* loaded from: classes2.dex */
final class Uk {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11888a = zzqe.zzam("nam");

    /* renamed from: b, reason: collision with root package name */
    private static final int f11889b = zzqe.zzam("trk");

    /* renamed from: c, reason: collision with root package name */
    private static final int f11890c = zzqe.zzam("cmt");

    /* renamed from: d, reason: collision with root package name */
    private static final int f11891d = zzqe.zzam("day");

    /* renamed from: e, reason: collision with root package name */
    private static final int f11892e = zzqe.zzam("ART");

    /* renamed from: f, reason: collision with root package name */
    private static final int f11893f = zzqe.zzam("too");

    /* renamed from: g, reason: collision with root package name */
    private static final int f11894g = zzqe.zzam("alb");

    /* renamed from: h, reason: collision with root package name */
    private static final int f11895h = zzqe.zzam("com");
    private static final int i = zzqe.zzam("wrt");
    private static final int j = zzqe.zzam("lyr");
    private static final int k = zzqe.zzam("gen");
    private static final int l = zzqe.zzam("covr");
    private static final int m = zzqe.zzam("gnre");
    private static final int n = zzqe.zzam("grp");
    private static final int o = zzqe.zzam("disk");
    private static final int p = zzqe.zzam("trkn");
    private static final int q = zzqe.zzam("tmpo");
    private static final int r = zzqe.zzam("cpil");
    private static final int s = zzqe.zzam("aART");
    private static final int t = zzqe.zzam("sonm");
    private static final int u = zzqe.zzam("soal");
    private static final int v = zzqe.zzam("soar");
    private static final int w = zzqe.zzam("soaa");
    private static final int x = zzqe.zzam("soco");
    private static final int y = zzqe.zzam("rtng");
    private static final int z = zzqe.zzam("pgap");
    private static final int A = zzqe.zzam("sosn");
    private static final int B = zzqe.zzam("tvsh");
    private static final int C = zzqe.zzam("----");
    private static final String[] D = {"Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop"};

    public static zzki.zza a(zzpx zzpxVar) {
        zzkq zzkqVar;
        int position = zzpxVar.getPosition() + zzpxVar.readInt();
        int readInt = zzpxVar.readInt();
        int i2 = readInt >>> 24;
        zzkp zzkpVar = null;
        try {
            if (i2 != 169 && i2 != 65533) {
                if (readInt == m) {
                    int b2 = b(zzpxVar);
                    String str = (b2 <= 0 || b2 > D.length) ? null : D[b2 - 1];
                    if (str != null) {
                        zzkqVar = new zzkq("TCON", null, str);
                    } else {
                        Log.w("MetadataUtil", "Failed to parse standard genre code");
                        zzkqVar = null;
                    }
                    return zzkqVar;
                }
                if (readInt == o) {
                    return b(readInt, "TPOS", zzpxVar);
                }
                if (readInt == p) {
                    return b(readInt, "TRCK", zzpxVar);
                }
                if (readInt == q) {
                    return a(readInt, "TBPM", zzpxVar, true, false);
                }
                if (readInt == r) {
                    return a(readInt, "TCMP", zzpxVar, true, true);
                }
                if (readInt == l) {
                    int readInt2 = zzpxVar.readInt();
                    if (zzpxVar.readInt() == Ek.Fa) {
                        int b3 = Ek.b(zzpxVar.readInt());
                        String str2 = b3 == 13 ? "image/jpeg" : b3 == 14 ? "image/png" : null;
                        if (str2 == null) {
                            StringBuilder sb = new StringBuilder(41);
                            sb.append("Unrecognized cover art flags: ");
                            sb.append(b3);
                            Log.w("MetadataUtil", sb.toString());
                        } else {
                            zzpxVar.zzbl(4);
                            byte[] bArr = new byte[readInt2 - 16];
                            zzpxVar.zze(bArr, 0, bArr.length);
                            zzkpVar = new zzkk(str2, null, 3, bArr);
                        }
                    } else {
                        Log.w("MetadataUtil", "Failed to parse cover art attribute");
                    }
                    return zzkpVar;
                }
                if (readInt == s) {
                    return a(readInt, "TPE2", zzpxVar);
                }
                if (readInt == t) {
                    return a(readInt, "TSOT", zzpxVar);
                }
                if (readInt == u) {
                    return a(readInt, "TSO2", zzpxVar);
                }
                if (readInt == v) {
                    return a(readInt, "TSOA", zzpxVar);
                }
                if (readInt == w) {
                    return a(readInt, "TSOP", zzpxVar);
                }
                if (readInt == x) {
                    return a(readInt, "TSOC", zzpxVar);
                }
                if (readInt == y) {
                    return a(readInt, "ITUNESADVISORY", zzpxVar, false, false);
                }
                if (readInt == z) {
                    return a(readInt, "ITUNESGAPLESS", zzpxVar, false, true);
                }
                if (readInt == A) {
                    return a(readInt, "TVSHOWSORT", zzpxVar);
                }
                if (readInt == B) {
                    return a(readInt, "TVSHOW", zzpxVar);
                }
                if (readInt == C) {
                    String str3 = null;
                    String str4 = null;
                    int i3 = -1;
                    int i4 = -1;
                    while (zzpxVar.getPosition() < position) {
                        int position2 = zzpxVar.getPosition();
                        int readInt3 = zzpxVar.readInt();
                        int readInt4 = zzpxVar.readInt();
                        zzpxVar.zzbl(4);
                        if (readInt4 == Ek.Da) {
                            str3 = zzpxVar.zzbm(readInt3 - 12);
                        } else if (readInt4 == Ek.Ea) {
                            str4 = zzpxVar.zzbm(readInt3 - 12);
                        } else {
                            if (readInt4 == Ek.Fa) {
                                i3 = position2;
                                i4 = readInt3;
                            }
                            zzpxVar.zzbl(readInt3 - 12);
                        }
                    }
                    if ("com.apple.iTunes".equals(str3) && "iTunSMPB".equals(str4) && i3 != -1) {
                        zzpxVar.setPosition(i3);
                        zzpxVar.zzbl(16);
                        zzkpVar = new zzkm("und", str4, zzpxVar.zzbm(i4 - 16));
                    }
                    return zzkpVar;
                }
            } else {
                int i5 = 16777215 & readInt;
                if (i5 == f11890c) {
                    int readInt5 = zzpxVar.readInt();
                    if (zzpxVar.readInt() == Ek.Fa) {
                        zzpxVar.zzbl(8);
                        String zzbm = zzpxVar.zzbm(readInt5 - 16);
                        zzkpVar = new zzkm("und", zzbm, zzbm);
                    } else {
                        String valueOf = String.valueOf(Ek.c(readInt));
                        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse comment attribute: ".concat(valueOf) : new String("Failed to parse comment attribute: "));
                    }
                    return zzkpVar;
                }
                if (i5 != f11888a && i5 != f11889b) {
                    if (i5 != f11895h && i5 != i) {
                        if (i5 == f11891d) {
                            return a(readInt, "TDRC", zzpxVar);
                        }
                        if (i5 == f11892e) {
                            return a(readInt, "TPE1", zzpxVar);
                        }
                        if (i5 == f11893f) {
                            return a(readInt, "TSSE", zzpxVar);
                        }
                        if (i5 == f11894g) {
                            return a(readInt, "TALB", zzpxVar);
                        }
                        if (i5 == j) {
                            return a(readInt, "USLT", zzpxVar);
                        }
                        if (i5 == k) {
                            return a(readInt, "TCON", zzpxVar);
                        }
                        if (i5 == n) {
                            return a(readInt, "TIT1", zzpxVar);
                        }
                    }
                    return a(readInt, "TCOM", zzpxVar);
                }
                return a(readInt, "TIT2", zzpxVar);
            }
            String valueOf2 = String.valueOf(Ek.c(readInt));
            Log.d("MetadataUtil", valueOf2.length() != 0 ? "Skipped unknown metadata entry: ".concat(valueOf2) : new String("Skipped unknown metadata entry: "));
            return null;
        } finally {
            zzpxVar.setPosition(position);
        }
    }

    private static zzkq b(int i2, String str, zzpx zzpxVar) {
        int readInt = zzpxVar.readInt();
        if (zzpxVar.readInt() == Ek.Fa && readInt >= 22) {
            zzpxVar.zzbl(10);
            int readUnsignedShort = zzpxVar.readUnsignedShort();
            if (readUnsignedShort > 0) {
                StringBuilder sb = new StringBuilder(11);
                sb.append(readUnsignedShort);
                String sb2 = sb.toString();
                int readUnsignedShort2 = zzpxVar.readUnsignedShort();
                if (readUnsignedShort2 > 0) {
                    String valueOf = String.valueOf(sb2);
                    StringBuilder sb3 = new StringBuilder(String.valueOf(valueOf).length() + 12);
                    sb3.append(valueOf);
                    sb3.append("/");
                    sb3.append(readUnsignedShort2);
                    sb2 = sb3.toString();
                }
                return new zzkq(str, null, sb2);
            }
        }
        String valueOf2 = String.valueOf(Ek.c(i2));
        Log.w("MetadataUtil", valueOf2.length() != 0 ? "Failed to parse index/count attribute: ".concat(valueOf2) : new String("Failed to parse index/count attribute: "));
        return null;
    }

    private static int b(zzpx zzpxVar) {
        zzpxVar.zzbl(4);
        if (zzpxVar.readInt() == Ek.Fa) {
            zzpxVar.zzbl(8);
            return zzpxVar.readUnsignedByte();
        }
        Log.w("MetadataUtil", "Failed to parse uint8 attribute value");
        return -1;
    }

    private static zzkq a(int i2, String str, zzpx zzpxVar) {
        int readInt = zzpxVar.readInt();
        if (zzpxVar.readInt() == Ek.Fa) {
            zzpxVar.zzbl(8);
            return new zzkq(str, null, zzpxVar.zzbm(readInt - 16));
        }
        String valueOf = String.valueOf(Ek.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse text attribute: ".concat(valueOf) : new String("Failed to parse text attribute: "));
        return null;
    }

    private static zzkp a(int i2, String str, zzpx zzpxVar, boolean z2, boolean z3) {
        int b2 = b(zzpxVar);
        if (z3) {
            b2 = Math.min(1, b2);
        }
        if (b2 >= 0) {
            if (z2) {
                return new zzkq(str, null, Integer.toString(b2));
            }
            return new zzkm("und", str, Integer.toString(b2));
        }
        String valueOf = String.valueOf(Ek.c(i2));
        Log.w("MetadataUtil", valueOf.length() != 0 ? "Failed to parse uint8 attribute: ".concat(valueOf) : new String("Failed to parse uint8 attribute: "));
        return null;
    }
}
