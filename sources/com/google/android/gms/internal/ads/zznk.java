package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.google.android.gms.internal.ads.zzhp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes2.dex */
public final class zznk extends DefaultHandler implements zzpm<zznj> {
    private static final Pattern zzbcz = Pattern.compile("(\\d+)(?:/(\\d+))?");
    private static final Pattern zzbda = Pattern.compile("CC([1-4])=.*");
    private static final Pattern zzbdb = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    private final String zzbdc;
    private final XmlPullParserFactory zzbdd;

    public zznk() {
        this(null);
    }

    private static int zza(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    private static zzhp.zza zzb(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        boolean equals = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95".equals(xmlPullParser.getAttributeValue(null, "schemeIdUri"));
        byte[] bArr = null;
        UUID uuid = null;
        boolean z = false;
        do {
            xmlPullParser.next();
            if (bArr == null && zzqg.zzd(xmlPullParser, "cenc:pssh") && xmlPullParser.next() == 4) {
                bArr = Base64.decode(xmlPullParser.getText(), 0);
                uuid = zzjq.zze(bArr);
                if (uuid == null) {
                    Log.w("MpdParser", "Skipping malformed cenc:pssh data");
                    bArr = null;
                }
            } else if (bArr == null && equals && zzqg.zzd(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                bArr = zzjq.zza(zzfe.zzwp, Base64.decode(xmlPullParser.getText(), 0));
                uuid = zzfe.zzwp;
            } else if (zzqg.zzd(xmlPullParser, "widevine:license")) {
                String attributeValue = xmlPullParser.getAttributeValue(null, "robustness_level");
                z = attributeValue != null && attributeValue.startsWith("HW");
            }
        } while (!zzqg.zzc(xmlPullParser, "ContentProtection"));
        if (bArr != null) {
            return new zzhp.zza(uuid, "video/mp4", bArr, z);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x07f4 A[LOOP:2: B:96:0x0212->B:104:0x07f4, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0762 A[EDGE_INSN: B:105:0x0762->B:106:0x0762 BREAK  A[LOOP:2: B:96:0x0212->B:104:0x07f4], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0675  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0696 A[Catch: XmlPullParserException -> 0x081a, TryCatch #0 {XmlPullParserException -> 0x081a, blocks: (B:95:0x01f9, B:96:0x0212, B:99:0x021d, B:128:0x025b, B:130:0x0265, B:132:0x026b, B:135:0x0289, B:137:0x0291, B:140:0x02a8, B:145:0x02a0, B:146:0x02c9, B:148:0x02d3, B:149:0x02de, B:152:0x02e9, B:154:0x02f1, B:157:0x02fc, B:161:0x0303, B:163:0x030d, B:164:0x031a, B:166:0x0322, B:168:0x0337, B:170:0x033f, B:171:0x0349, B:175:0x0354, B:176:0x039f, B:179:0x03aa, B:181:0x04ac, B:185:0x04b4, B:191:0x055d, B:198:0x067f, B:200:0x0696, B:203:0x06af, B:204:0x069e, B:207:0x06a6, B:211:0x0678, B:212:0x0573, B:216:0x058f, B:218:0x0595, B:221:0x059e, B:223:0x05a4, B:225:0x05b4, B:227:0x05b8, B:237:0x05c6, B:239:0x0654, B:229:0x05d0, B:231:0x05e0, B:232:0x05ea, B:235:0x05e5, B:234:0x05ed, B:244:0x05f6, B:247:0x05ff, B:249:0x0605, B:251:0x0615, B:253:0x0619, B:263:0x0627, B:255:0x0631, B:257:0x0642, B:258:0x064c, B:261:0x0647, B:260:0x064f, B:268:0x0663, B:288:0x04ea, B:302:0x050e, B:305:0x0516, B:313:0x0534, B:326:0x03e9, B:328:0x03f3, B:329:0x040d, B:331:0x0415, B:336:0x044d, B:343:0x046e, B:349:0x0485, B:354:0x0497, B:357:0x06de, B:359:0x0702), top: B:94:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:211:0x0678 A[Catch: XmlPullParserException -> 0x081a, TryCatch #0 {XmlPullParserException -> 0x081a, blocks: (B:95:0x01f9, B:96:0x0212, B:99:0x021d, B:128:0x025b, B:130:0x0265, B:132:0x026b, B:135:0x0289, B:137:0x0291, B:140:0x02a8, B:145:0x02a0, B:146:0x02c9, B:148:0x02d3, B:149:0x02de, B:152:0x02e9, B:154:0x02f1, B:157:0x02fc, B:161:0x0303, B:163:0x030d, B:164:0x031a, B:166:0x0322, B:168:0x0337, B:170:0x033f, B:171:0x0349, B:175:0x0354, B:176:0x039f, B:179:0x03aa, B:181:0x04ac, B:185:0x04b4, B:191:0x055d, B:198:0x067f, B:200:0x0696, B:203:0x06af, B:204:0x069e, B:207:0x06a6, B:211:0x0678, B:212:0x0573, B:216:0x058f, B:218:0x0595, B:221:0x059e, B:223:0x05a4, B:225:0x05b4, B:227:0x05b8, B:237:0x05c6, B:239:0x0654, B:229:0x05d0, B:231:0x05e0, B:232:0x05ea, B:235:0x05e5, B:234:0x05ed, B:244:0x05f6, B:247:0x05ff, B:249:0x0605, B:251:0x0615, B:253:0x0619, B:263:0x0627, B:255:0x0631, B:257:0x0642, B:258:0x064c, B:261:0x0647, B:260:0x064f, B:268:0x0663, B:288:0x04ea, B:302:0x050e, B:305:0x0516, B:313:0x0534, B:326:0x03e9, B:328:0x03f3, B:329:0x040d, B:331:0x0415, B:336:0x044d, B:343:0x046e, B:349:0x0485, B:354:0x0497, B:357:0x06de, B:359:0x0702), top: B:94:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x093f A[LOOP:0: B:25:0x009d->B:31:0x093f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0909 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x092c A[Catch: XmlPullParserException -> 0x095a, TryCatch #1 {XmlPullParserException -> 0x095a, blocks: (B:3:0x0008, B:5:0x001b, B:7:0x0025, B:10:0x003d, B:12:0x0051, B:16:0x0060, B:18:0x006d, B:20:0x007a, B:21:0x0085, B:25:0x009d, B:28:0x00a8, B:29:0x0901, B:38:0x0926, B:40:0x092c, B:43:0x0937, B:44:0x093e, B:47:0x091c, B:48:0x0923, B:53:0x00d2, B:57:0x00df, B:59:0x00f5, B:61:0x00fd, B:62:0x0116, B:65:0x0120, B:66:0x0146, B:69:0x0151, B:70:0x085a, B:74:0x0862, B:79:0x0890, B:80:0x08ac, B:81:0x08ad, B:84:0x08cc, B:85:0x08c6, B:89:0x0187, B:93:0x019e, B:102:0x075a, B:106:0x0762, B:107:0x076c, B:109:0x0772, B:111:0x0787, B:112:0x0790, B:114:0x079f, B:116:0x07ce, B:117:0x07b7, B:119:0x07bb, B:122:0x07d6, B:123:0x07dd, B:125:0x07de, B:361:0x0708, B:362:0x0715, B:364:0x071f, B:365:0x072e, B:367:0x0736, B:368:0x0743, B:370:0x074b, B:371:0x0755, B:375:0x081f, B:377:0x0837, B:379:0x083f, B:381:0x0846, B:382:0x084b, B:384:0x0851, B:391:0x0038, B:392:0x0952, B:393:0x0959), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0937 A[Catch: XmlPullParserException -> 0x095a, TryCatch #1 {XmlPullParserException -> 0x095a, blocks: (B:3:0x0008, B:5:0x001b, B:7:0x0025, B:10:0x003d, B:12:0x0051, B:16:0x0060, B:18:0x006d, B:20:0x007a, B:21:0x0085, B:25:0x009d, B:28:0x00a8, B:29:0x0901, B:38:0x0926, B:40:0x092c, B:43:0x0937, B:44:0x093e, B:47:0x091c, B:48:0x0923, B:53:0x00d2, B:57:0x00df, B:59:0x00f5, B:61:0x00fd, B:62:0x0116, B:65:0x0120, B:66:0x0146, B:69:0x0151, B:70:0x085a, B:74:0x0862, B:79:0x0890, B:80:0x08ac, B:81:0x08ad, B:84:0x08cc, B:85:0x08c6, B:89:0x0187, B:93:0x019e, B:102:0x075a, B:106:0x0762, B:107:0x076c, B:109:0x0772, B:111:0x0787, B:112:0x0790, B:114:0x079f, B:116:0x07ce, B:117:0x07b7, B:119:0x07bb, B:122:0x07d6, B:123:0x07dd, B:125:0x07de, B:361:0x0708, B:362:0x0715, B:364:0x071f, B:365:0x072e, B:367:0x0736, B:368:0x0743, B:370:0x074b, B:371:0x0755, B:375:0x081f, B:377:0x0837, B:379:0x083f, B:381:0x0846, B:382:0x084b, B:384:0x0851, B:391:0x0038, B:392:0x0952, B:393:0x0959), top: B:2:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x08d3 A[LOOP:1: B:66:0x0146->B:72:0x08d3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0862 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzpm
    /* renamed from: zzc, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zznj zzb(android.net.Uri r90, java.io.InputStream r91) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 2403
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznk.zzb(android.net.Uri, java.io.InputStream):com.google.android.gms.internal.ads.zznj");
    }

    private final zzno zzd(XmlPullParser xmlPullParser) {
        return zza(xmlPullParser, "sourceURL", "range");
    }

    private static int zze(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        int zza = "urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(zzb(xmlPullParser, "schemeIdUri", (String) null)) ? zza(xmlPullParser, "value", -1) : -1;
        do {
            xmlPullParser.next();
        } while (!zzqg.zzc(xmlPullParser, "AudioChannelConfiguration"));
        return zza;
    }

    private static boolean zzx(String str) {
        return zzpt.zzad(str) || "application/ttml+xml".equals(str) || "application/x-mp4-vtt".equals(str) || "application/cea-708".equals(str) || "application/cea-608".equals(str);
    }

    private zznk(String str) {
        this.zzbdc = null;
        try {
            this.zzbdd = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    private static int zzd(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        zzpo.checkState(i == i2);
        return i;
    }

    private final zzny zza(XmlPullParser xmlPullParser, zzny zznyVar) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long zzb = zzb(xmlPullParser, "timescale", zznyVar != null ? zznyVar.zzcr : 1L);
        long zzb2 = zzb(xmlPullParser, "presentationTimeOffset", zznyVar != null ? zznyVar.zzbdw : 0L);
        long j3 = zznyVar != null ? zznyVar.zzbec : 0L;
        long j4 = zznyVar != null ? zznyVar.zzbed : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] split = attributeValue.split("-");
            long parseLong = Long.parseLong(split[0]);
            j = (Long.parseLong(split[1]) - parseLong) + 1;
            j2 = parseLong;
        } else {
            j = j4;
            j2 = j3;
        }
        zzno zznoVar = zznyVar != null ? zznyVar.zzbdv : null;
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "Initialization")) {
                zznoVar = zzd(xmlPullParser);
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentBase"));
        return new zzny(zznoVar, zzb, zzb2, j2, j);
    }

    private static String zzb(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        xmlPullParser.next();
        return zzqd.zzc(str, xmlPullParser.getText());
    }

    private final zznv zza(XmlPullParser xmlPullParser, zznv zznvVar) throws XmlPullParserException, IOException {
        long zzb = zzb(xmlPullParser, "timescale", zznvVar != null ? zznvVar.zzcr : 1L);
        long zzb2 = zzb(xmlPullParser, "presentationTimeOffset", zznvVar != null ? zznvVar.zzbdw : 0L);
        long zzb3 = zzb(xmlPullParser, "duration", zznvVar != null ? zznvVar.zzcs : -9223372036854775807L);
        int zza = zza(xmlPullParser, "startNumber", zznvVar != null ? zznvVar.zzbdx : 1);
        List list = null;
        zzno zznoVar = null;
        List<zznx> list2 = null;
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "Initialization")) {
                zznoVar = zzd(xmlPullParser);
            } else if (zzqg.zzd(xmlPullParser, "SegmentTimeline")) {
                list2 = zzc(xmlPullParser);
            } else if (zzqg.zzd(xmlPullParser, "SegmentURL")) {
                if (list == null) {
                    list = new ArrayList();
                }
                list.add(zza(xmlPullParser, "media", "mediaRange"));
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentList"));
        if (zznvVar != null) {
            if (zznoVar == null) {
                zznoVar = zznvVar.zzbdv;
            }
            if (list2 == null) {
                list2 = zznvVar.zzbdy;
            }
            if (list == null) {
                list = zznvVar.zzbdz;
            }
        }
        return new zznv(zznoVar, zzb, zzb2, zza, zzb3, list2, list);
    }

    private static long zzb(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    private static String zzb(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    private final zznw zza(XmlPullParser xmlPullParser, zznw zznwVar) throws XmlPullParserException, IOException {
        long zzb = zzb(xmlPullParser, "timescale", zznwVar != null ? zznwVar.zzcr : 1L);
        long zzb2 = zzb(xmlPullParser, "presentationTimeOffset", zznwVar != null ? zznwVar.zzbdw : 0L);
        long zzb3 = zzb(xmlPullParser, "duration", zznwVar != null ? zznwVar.zzcs : -9223372036854775807L);
        int zza = zza(xmlPullParser, "startNumber", zznwVar != null ? zznwVar.zzbdx : 1);
        zzno zznoVar = null;
        zzoa zza2 = zza(xmlPullParser, "media", zznwVar != null ? zznwVar.zzbeb : null);
        zzoa zza3 = zza(xmlPullParser, "initialization", zznwVar != null ? zznwVar.zzbea : null);
        List<zznx> list = null;
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "Initialization")) {
                zznoVar = zzd(xmlPullParser);
            } else if (zzqg.zzd(xmlPullParser, "SegmentTimeline")) {
                list = zzc(xmlPullParser);
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentTemplate"));
        if (zznwVar != null) {
            if (zznoVar == null) {
                zznoVar = zznwVar.zzbdv;
            }
            if (list == null) {
                list = zznwVar.zzbdy;
            }
        }
        return new zznw(zznoVar, zzb, zzb2, zza, zzb3, list, zza3, zza2);
    }

    private static zzoa zza(XmlPullParser xmlPullParser, String str, zzoa zzoaVar) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? zzoa.zzaa(attributeValue) : zzoaVar;
    }

    private static zzno zza(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] split = attributeValue2.split("-");
            j = Long.parseLong(split[0]);
            if (split.length == 2) {
                j2 = (Long.parseLong(split[1]) - j) + 1;
                return new zzno(attributeValue, j, j2);
            }
        } else {
            j = 0;
        }
        j2 = -1;
        return new zzno(attributeValue, j, j2);
    }

    private static zznm zza(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String zzb = zzb(xmlPullParser, "schemeIdUri", "");
        String zzb2 = zzb(xmlPullParser, "value", (String) null);
        String zzb3 = zzb(xmlPullParser, "id", (String) null);
        do {
            xmlPullParser.next();
        } while (!zzqg.zzc(xmlPullParser, str));
        return new zznm(zzb, zzb2, zzb3);
    }

    private static float zza(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f2;
        }
        Matcher matcher = zzbcz.matcher(attributeValue);
        if (!matcher.matches()) {
            return f2;
        }
        int parseInt = Integer.parseInt(matcher.group(1));
        return !TextUtils.isEmpty(matcher.group(2)) ? parseInt / Integer.parseInt(r2) : parseInt;
    }

    private static long zza(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : zzqe.zzak(attributeValue);
    }

    private static int zza(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    private static List<zznx> zzc(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long j = 0;
        do {
            xmlPullParser.next();
            if (zzqg.zzd(xmlPullParser, "S")) {
                j = zzb(xmlPullParser, com.umeng.commonsdk.proguard.e.ar, j);
                long zzb = zzb(xmlPullParser, com.umeng.commonsdk.proguard.e.am, -9223372036854775807L);
                int zza = zza(xmlPullParser, "r", 0) + 1;
                for (int i = 0; i < zza; i++) {
                    arrayList.add(new zznx(j, zzb));
                    j += zzb;
                }
            }
        } while (!zzqg.zzc(xmlPullParser, "SegmentTimeline"));
        return arrayList;
    }
}
