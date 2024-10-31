package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

@SuppressLint({"InlinedApi"})
@TargetApi(16)
/* loaded from: classes2.dex */
public final class zzkc {
    private static final SparseIntArray zzavl;
    private static final SparseIntArray zzavm;
    private static final Map<String, Integer> zzavn;
    private static final zzjx zzavi = zzjx.zzt("OMX.google.raw.decoder");
    private static final Pattern zzavj = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<a, List<zzjx>> zzavk = new HashMap<>();
    private static int zzavo = -1;

    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a */
        public final String f12742a;

        /* renamed from: b */
        public final boolean f12743b;

        public a(String str, boolean z) {
            this.f12742a = str;
            this.f12743b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.f12742a, aVar.f12742a) && this.f12743b == aVar.f12743b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.f12742a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f12743b ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzavl = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzavl.put(77, 2);
        zzavl.put(88, 4);
        zzavl.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzavm = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zzavm.put(11, 4);
        zzavm.put(12, 8);
        zzavm.put(13, 16);
        zzavm.put(20, 32);
        zzavm.put(21, 64);
        zzavm.put(22, 128);
        zzavm.put(30, 256);
        zzavm.put(31, 512);
        zzavm.put(32, 1024);
        zzavm.put(40, 2048);
        zzavm.put(41, 4096);
        zzavm.put(42, 8192);
        zzavm.put(50, 16384);
        zzavm.put(51, 32768);
        zzavm.put(52, 65536);
        HashMap hashMap = new HashMap();
        zzavn = hashMap;
        hashMap.put("L30", 1);
        zzavn.put("L60", 4);
        zzavn.put("L63", 16);
        zzavn.put("L90", 64);
        zzavn.put("L93", 256);
        zzavn.put("L120", 1024);
        zzavn.put("L123", 4096);
        zzavn.put("L150", 16384);
        zzavn.put("L153", 65536);
        zzavn.put("L156", 262144);
        zzavn.put("L180", 1048576);
        zzavn.put("L183", 4194304);
        zzavn.put("L186", 16777216);
        zzavn.put("H30", 2);
        zzavn.put("H60", 8);
        zzavn.put("H63", 32);
        zzavn.put("H90", 128);
        zzavn.put("H93", 512);
        zzavn.put("H120", 2048);
        zzavn.put("H123", 8192);
        zzavn.put("H150", 32768);
        zzavn.put("H153", 131072);
        zzavn.put("H156", 524288);
        zzavn.put("H180", 2097152);
        zzavn.put("H183", 8388608);
        zzavn.put("H186", 33554432);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzke.<init>(java.lang.Throwable, com.google.android.gms.internal.ads.bl):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:289)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:172)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01b2 A[Catch: Exception -> 0x02ae, TryCatch #1 {Exception -> 0x02ae, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x0030, B:14:0x0036, B:16:0x003e, B:18:0x0046, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:27:0x0068, B:29:0x006e, B:32:0x0078, B:34:0x007c, B:36:0x0084, B:39:0x0090, B:41:0x0096, B:43:0x009e, B:45:0x00a8, B:47:0x00b2, B:49:0x00bc, B:51:0x00c6, B:53:0x00d0, B:55:0x00da, B:57:0x00e4, B:59:0x00ee, B:61:0x00f8, B:63:0x0102, B:65:0x010c, B:68:0x0118, B:70:0x011c, B:72:0x0124, B:74:0x012e, B:76:0x0138, B:78:0x0142, B:81:0x014d, B:84:0x0155, B:86:0x015d, B:88:0x0167, B:90:0x0171, B:92:0x017b, B:94:0x0183, B:96:0x018d, B:99:0x0198, B:101:0x019c, B:103:0x01a4, B:108:0x01b2, B:110:0x01ba, B:143:0x0232, B:146:0x023a, B:148:0x0240, B:151:0x0264, B:152:0x0298), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01fd A[Catch: Exception -> 0x01f8, TryCatch #3 {Exception -> 0x01f8, blocks: (B:158:0x01d2, B:160:0x01dc, B:162:0x01e6, B:164:0x01ee, B:121:0x01fd, B:125:0x020b, B:128:0x0206, B:134:0x0219), top: B:157:0x01d2 }] */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02a3 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.google.android.gms.internal.ads.zzjx> zza(com.google.android.gms.internal.ads.zzkc.a r17, com.google.android.gms.internal.ads.InterfaceC0864cl r18) throws com.google.android.gms.internal.ads.zzke {
        /*
            Method dump skipped, instructions count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkc.zza(com.google.android.gms.internal.ads.zzkc$a, com.google.android.gms.internal.ads.cl):java.util.List");
    }

    public static zzjx zzb(String str, boolean z) throws zzke {
        List<zzjx> zzc = zzc(str, z);
        if (zzc.isEmpty()) {
            return null;
        }
        return zzc.get(0);
    }

    private static synchronized List<zzjx> zzc(String str, boolean z) throws zzke {
        synchronized (zzkc.class) {
            a aVar = new a(str, z);
            List<zzjx> list = zzavk.get(aVar);
            if (list != null) {
                return list;
            }
            List<zzjx> zza = zza(aVar, zzqe.SDK_INT >= 21 ? new C0893el(z) : new C0879dl());
            if (z && zza.isEmpty() && 21 <= zzqe.SDK_INT && zzqe.SDK_INT <= 23) {
                zza = zza(aVar, new C0879dl());
                if (!zza.isEmpty()) {
                    String str2 = zza.get(0).name;
                    StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                    sb.append("MediaCodecList API didn't list secure decoder for: ");
                    sb.append(str);
                    sb.append(". Assuming: ");
                    sb.append(str2);
                    Log.w("MediaCodecUtil", sb.toString());
                }
            }
            List<zzjx> unmodifiableList = Collections.unmodifiableList(zza);
            zzavk.put(aVar, unmodifiableList);
            return unmodifiableList;
        }
    }

    public static zzjx zzeq() {
        return zzavi;
    }

    public static int zzer() throws zzke {
        int i;
        if (zzavo == -1) {
            int i2 = 0;
            zzjx zzb = zzb("video/avc", false);
            if (zzb != null) {
                MediaCodecInfo.CodecProfileLevel[] zzej = zzb.zzej();
                int length = zzej.length;
                int i3 = 0;
                while (i2 < length) {
                    int i4 = zzej[i2].level;
                    if (i4 != 1 && i4 != 2) {
                        switch (i4) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case 2048:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    i3 = Math.max(i, i3);
                    i2++;
                }
                i2 = Math.max(i3, zzqe.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzavo = i2;
        }
        return zzavo;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0029, code lost:            if (r3.equals("hev1") != false) goto L86;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzw(java.lang.String r9) {
        /*
            Method dump skipped, instructions count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkc.zzw(java.lang.String):android.util.Pair");
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer valueOf;
        Integer valueOf2;
        if (strArr.length < 2) {
            String valueOf3 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf3.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf3) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer valueOf4 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                valueOf = valueOf4;
            } else if (strArr.length >= 3) {
                valueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                valueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                String valueOf5 = String.valueOf(str);
                Log.w("MediaCodecUtil", valueOf5.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf5) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer valueOf6 = Integer.valueOf(zzavl.get(valueOf.intValue()));
            if (valueOf6 == null) {
                String valueOf7 = String.valueOf(valueOf);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf7).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(valueOf7);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer valueOf8 = Integer.valueOf(zzavm.get(valueOf2.intValue()));
            if (valueOf8 == null) {
                String valueOf9 = String.valueOf(valueOf2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(valueOf9).length() + 19);
                sb2.append("Unknown AVC level: ");
                sb2.append(valueOf9);
                Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            return new Pair<>(valueOf6, valueOf8);
        } catch (NumberFormatException unused) {
            String valueOf10 = String.valueOf(str);
            Log.w("MediaCodecUtil", valueOf10.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(valueOf10) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }
}
