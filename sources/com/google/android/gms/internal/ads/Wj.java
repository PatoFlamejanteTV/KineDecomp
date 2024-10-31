package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;
import java.io.IOException;

/* loaded from: classes2.dex */
final class Wj implements Handler.Callback, zzln, zzlp, zzoq {
    private int A;
    private Yj B;
    private long C;
    private Xj D;
    private Xj E;
    private Xj F;
    private zzgc G;

    /* renamed from: a, reason: collision with root package name */
    private final zzfz[] f11934a;

    /* renamed from: b, reason: collision with root package name */
    private final zzga[] f11935b;

    /* renamed from: c, reason: collision with root package name */
    private final zzop f11936c;

    /* renamed from: d, reason: collision with root package name */
    private final zzfw f11937d;

    /* renamed from: e, reason: collision with root package name */
    private final zzqa f11938e;

    /* renamed from: f, reason: collision with root package name */
    private final Handler f11939f;

    /* renamed from: g, reason: collision with root package name */
    private final HandlerThread f11940g;

    /* renamed from: h, reason: collision with root package name */
    private final Handler f11941h;
    private final zzfg i;
    private final zzgf j;
    private final zzge k;
    private zzfp l;
    private zzfy m;
    private zzfz n;
    private zzps o;
    private zzlo p;
    private zzfz[] q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int x;
    private int y;
    private long z;
    private int w = 0;
    private int v = 1;

    public Wj(zzfz[] zzfzVarArr, zzop zzopVar, zzfw zzfwVar, boolean z, int i, Handler handler, zzfp zzfpVar, zzfg zzfgVar) {
        this.f11934a = zzfzVarArr;
        this.f11936c = zzopVar;
        this.f11937d = zzfwVar;
        this.s = z;
        this.f11941h = handler;
        this.l = zzfpVar;
        this.i = zzfgVar;
        this.f11935b = new zzga[zzfzVarArr.length];
        for (int i2 = 0; i2 < zzfzVarArr.length; i2++) {
            zzfzVarArr[i2].setIndex(i2);
            this.f11935b[i2] = zzfzVarArr[i2].zzbe();
        }
        this.f11938e = new zzqa();
        this.q = new zzfz[0];
        this.j = new zzgf();
        this.k = new zzge();
        zzopVar.zza(this);
        this.m = zzfy.zzaaf;
        this.f11940g = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.f11940g.start();
        this.f11939f = new Handler(this.f11940g.getLooper(), this);
    }

    private final void c() throws zzff {
        this.t = false;
        this.f11938e.start();
        for (zzfz zzfzVar : this.q) {
            zzfzVar.start();
        }
    }

    private final void d() throws zzff {
        this.f11938e.stop();
        for (zzfz zzfzVar : this.q) {
            a(zzfzVar);
        }
    }

    private final void e() throws zzff {
        Xj xj = this.F;
        if (xj == null) {
            return;
        }
        long zzey = xj.f11959a.zzey();
        if (zzey != -9223372036854775807L) {
            a(zzey);
        } else {
            zzfz zzfzVar = this.n;
            if (zzfzVar != null && !zzfzVar.zzcj()) {
                this.C = this.o.zzde();
                this.f11938e.zzam(this.C);
            } else {
                this.C = this.f11938e.zzde();
            }
            zzey = this.C - this.F.b();
        }
        this.l.zzyz = zzey;
        this.z = SystemClock.elapsedRealtime() * 1000;
        long zzez = this.q.length == 0 ? Long.MIN_VALUE : this.F.f11959a.zzez();
        zzfp zzfpVar = this.l;
        if (zzez == Long.MIN_VALUE) {
            zzez = this.G.zza(this.F.f11965g, this.k, false).zzaan;
        }
        zzfpVar.zzza = zzez;
    }

    private final void f() {
        c(true);
        this.f11937d.onStopped();
        a(1);
    }

    private final void g() throws IOException {
        Xj xj = this.D;
        if (xj == null || xj.j) {
            return;
        }
        Xj xj2 = this.E;
        if (xj2 == null || xj2.l == xj) {
            for (zzfz zzfzVar : this.q) {
                if (!zzfzVar.zzbh()) {
                    return;
                }
            }
            this.D.f11959a.zzew();
        }
    }

    private final void h() {
        Xj xj = this.D;
        long zzeu = !xj.j ? 0L : xj.f11959a.zzeu();
        if (zzeu == Long.MIN_VALUE) {
            b(false);
            return;
        }
        long b2 = this.C - this.D.b();
        boolean zzk = this.f11937d.zzk(zzeu - b2);
        b(zzk);
        if (zzk) {
            this.D.f11959a.zzy(b2);
        }
    }

    public final void a(zzlo zzloVar, boolean z) {
        this.f11939f.obtainMessage(0, 1, 0, zzloVar).sendToTarget();
    }

    public final void b() {
        this.f11939f.sendEmptyMessage(5);
    }

    /* JADX WARN: Removed duplicated region for block: B:182:0x028f A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0296 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0292 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0733 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x07ec  */
    /* JADX WARN: Removed duplicated region for block: B:405:0x05b5 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:415:0x05d1 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, LOOP:9: B:415:0x05d1->B:419:0x05e3, LOOP_START, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:495:0x0542 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:499:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:502:0x05a1 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:504:0x0566 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:505:0x0549 A[Catch: IOException -> 0x08b9, zzff -> 0x08be, RuntimeException -> 0x08c3, TryCatch #3 {RuntimeException -> 0x08c3, blocks: (B:3:0x0005, B:9:0x0019, B:11:0x0021, B:13:0x0028, B:16:0x002f, B:20:0x003a, B:23:0x004c, B:25:0x0052, B:28:0x005b, B:32:0x0063, B:37:0x0065, B:39:0x0069, B:40:0x0070, B:42:0x007a, B:44:0x007e, B:46:0x0082, B:47:0x0095, B:50:0x009b, B:56:0x0024, B:57:0x009f, B:67:0x00bd, B:76:0x00cb, B:79:0x00ce, B:83:0x00d8, B:88:0x00dc, B:89:0x00dd, B:91:0x00e1, B:93:0x00e6, B:95:0x00ec, B:97:0x00f2, B:101:0x00f7, B:105:0x00fc, B:108:0x0105, B:110:0x012f, B:111:0x0136, B:112:0x013d, B:114:0x0142, B:117:0x014f, B:119:0x0159, B:120:0x015b, B:122:0x015f, B:124:0x0165, B:127:0x016b, B:128:0x0172, B:129:0x0176, B:132:0x017d, B:134:0x0181, B:131:0x0186, B:140:0x0189, B:141:0x01c6, B:143:0x0198, B:145:0x01a0, B:147:0x01a6, B:149:0x01b0, B:154:0x01d2, B:156:0x01da, B:159:0x01e1, B:161:0x01e5, B:163:0x01ed, B:166:0x01f4, B:168:0x0207, B:169:0x0217, B:171:0x021b, B:173:0x022b, B:175:0x022f, B:177:0x023d, B:179:0x0242, B:180:0x028b, B:182:0x028f, B:184:0x0296, B:186:0x02a0, B:188:0x02aa, B:189:0x02af, B:190:0x02d7, B:192:0x02db, B:196:0x02e8, B:200:0x02eb, B:201:0x02f8, B:204:0x0306, B:206:0x030c, B:208:0x031f, B:210:0x0323, B:212:0x0333, B:214:0x0345, B:218:0x0353, B:223:0x0358, B:224:0x036c, B:228:0x0375, B:229:0x0292, B:230:0x025a, B:232:0x0262, B:234:0x026a, B:235:0x026f, B:237:0x0379, B:238:0x0384, B:247:0x038f, B:248:0x0390, B:250:0x0394, B:252:0x039c, B:253:0x03a9, B:255:0x03a3, B:256:0x03b5, B:258:0x03bd, B:260:0x03c6, B:262:0x03cc, B:263:0x03ec, B:266:0x03f5, B:273:0x0418, B:276:0x0426, B:283:0x043c, B:286:0x044a, B:291:0x0455, B:294:0x0464, B:295:0x046d, B:298:0x046e, B:300:0x0476, B:301:0x06e4, B:303:0x06ea, B:305:0x06f2, B:307:0x070d, B:309:0x0718, B:312:0x0721, B:314:0x0727, B:319:0x0733, B:324:0x073d, B:331:0x0744, B:332:0x0747, B:334:0x074b, B:336:0x0759, B:337:0x076c, B:341:0x0785, B:343:0x078d, B:345:0x0793, B:346:0x081d, B:348:0x0821, B:350:0x0826, B:352:0x082e, B:354:0x0832, B:356:0x083b, B:357:0x0851, B:358:0x0837, B:360:0x0841, B:362:0x0846, B:363:0x084c, B:364:0x079d, B:366:0x07a2, B:369:0x07a9, B:371:0x07b1, B:374:0x07c4, B:380:0x07f6, B:382:0x07fe, B:383:0x07cc, B:384:0x07da, B:385:0x07b6, B:387:0x07f0, B:388:0x0802, B:390:0x0807, B:394:0x0813, B:395:0x080d, B:396:0x047e, B:398:0x0482, B:399:0x04c5, B:401:0x04cd, B:403:0x05b1, B:405:0x05b5, B:408:0x05be, B:410:0x05c2, B:412:0x05c6, B:413:0x05cd, B:415:0x05d1, B:417:0x05d7, B:419:0x05e3, B:421:0x060e, B:424:0x0615, B:426:0x061a, B:428:0x0626, B:430:0x062c, B:432:0x0632, B:434:0x0635, B:440:0x0639, B:442:0x063e, B:445:0x0650, B:450:0x0658, B:454:0x065b, B:456:0x0661, B:458:0x0669, B:462:0x068c, B:464:0x0691, B:467:0x069f, B:469:0x06a5, B:471:0x06b5, B:473:0x06bb, B:474:0x06c2, B:476:0x06c5, B:478:0x06ce, B:482:0x06de, B:480:0x06e1, B:488:0x05ca, B:489:0x04d5, B:491:0x04d9, B:493:0x053e, B:495:0x0542, B:497:0x055f, B:500:0x056d, B:502:0x05a1, B:503:0x05a5, B:504:0x0566, B:505:0x0549, B:506:0x04df, B:509:0x04fa, B:511:0x052d, B:512:0x0487, B:514:0x0491, B:516:0x0499, B:519:0x04a8, B:521:0x04ac, B:523:0x04b9, B:524:0x0855, B:527:0x085d, B:529:0x0863, B:531:0x086a, B:533:0x086f, B:534:0x0878, B:536:0x087c, B:538:0x0882, B:541:0x088e, B:543:0x089d, B:544:0x08a9), top: B:2:0x0005 }] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r37) {
        /*
            Method dump skipped, instructions count: 2354
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.Wj.handleMessage(android.os.Message):boolean");
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.gms.internal.ads.zzln
    public final void zza(zzlm zzlmVar) {
        this.f11939f.obtainMessage(8, zzlmVar).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzlp
    public final void zzb(zzgc zzgcVar, Object obj) {
        this.f11939f.obtainMessage(7, Pair.create(zzgcVar, obj)).sendToTarget();
    }

    @Override // com.google.android.gms.internal.ads.zzoq
    public final void zzbu() {
        this.f11939f.sendEmptyMessage(10);
    }

    public final synchronized void b(zzfj... zzfjVarArr) {
        if (this.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        int i = this.x;
        this.x = i + 1;
        this.f11939f.obtainMessage(11, zzfjVarArr).sendToTarget();
        while (this.y <= i) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzlx
    public final /* synthetic */ void zza(zzlm zzlmVar) {
        this.f11939f.obtainMessage(9, zzlmVar).sendToTarget();
    }

    public final void a(boolean z) {
        this.f11939f.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }

    public final void a(zzgc zzgcVar, int i, long j) {
        this.f11939f.obtainMessage(3, new Yj(zzgcVar, i, j)).sendToTarget();
    }

    private final void c(boolean z) {
        this.f11939f.removeMessages(2);
        this.t = false;
        this.f11938e.stop();
        this.o = null;
        this.n = null;
        this.C = 60000000L;
        for (zzfz zzfzVar : this.q) {
            try {
                a(zzfzVar);
                zzfzVar.disable();
            } catch (zzff | RuntimeException e2) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e2);
            }
        }
        this.q = new zzfz[0];
        Xj xj = this.F;
        if (xj == null) {
            xj = this.D;
        }
        a(xj);
        this.D = null;
        this.E = null;
        this.F = null;
        b(false);
        if (z) {
            zzlo zzloVar = this.p;
            if (zzloVar != null) {
                zzloVar.zzfh();
                this.p = null;
            }
            this.G = null;
        }
    }

    public final void a(zzfj... zzfjVarArr) {
        if (this.r) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        } else {
            this.x++;
            this.f11939f.obtainMessage(11, zzfjVarArr).sendToTarget();
        }
    }

    public final synchronized void a() {
        if (this.r) {
            return;
        }
        this.f11939f.sendEmptyMessage(6);
        while (!this.r) {
            try {
                wait();
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
        this.f11940g.quit();
    }

    private final void b(boolean z) {
        if (this.u != z) {
            this.u = z;
            this.f11941h.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final boolean b(long j) {
        if (j == -9223372036854775807L || this.l.zzyz < j) {
            return true;
        }
        Xj xj = this.F.l;
        return xj != null && xj.j;
    }

    private final void b(Object obj, int i) {
        this.f11941h.obtainMessage(6, new zzfr(this.G, obj, this.l, i)).sendToTarget();
    }

    private final boolean b(int i) {
        this.G.zza(i, this.k, false);
        return !this.G.zza(0, this.j, false, 0L).zzaat && this.G.zza(i, this.k, this.j, this.w) == -1;
    }

    private final void a(int i) {
        if (this.v != i) {
            this.v = i;
            this.f11941h.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final void a(long j, long j2) {
        this.f11939f.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.f11939f.sendEmptyMessage(2);
        } else {
            this.f11939f.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private final Pair<Integer, Long> b(int i, long j) {
        return b(this.G, i, -9223372036854775807L);
    }

    private final Pair<Integer, Long> b(zzgc zzgcVar, int i, long j) {
        return a(zzgcVar, i, j, 0L);
    }

    private final long a(int i, long j) throws zzff {
        Xj xj;
        d();
        this.t = false;
        a(2);
        Xj xj2 = this.F;
        if (xj2 == null) {
            Xj xj3 = this.D;
            if (xj3 != null) {
                xj3.a();
            }
            xj = null;
        } else {
            xj = null;
            while (xj2 != null) {
                if (xj2.f11965g == i && xj2.j) {
                    xj = xj2;
                } else {
                    xj2.a();
                }
                xj2 = xj2.l;
            }
        }
        Xj xj4 = this.F;
        if (xj4 != xj || xj4 != this.E) {
            for (zzfz zzfzVar : this.q) {
                zzfzVar.disable();
            }
            this.q = new zzfz[0];
            this.o = null;
            this.n = null;
            this.F = null;
        }
        if (xj != null) {
            xj.l = null;
            this.D = xj;
            this.E = xj;
            b(xj);
            Xj xj5 = this.F;
            if (xj5.k) {
                j = xj5.f11959a.zzab(j);
            }
            a(j);
            h();
        } else {
            this.D = null;
            this.E = null;
            this.F = null;
            a(j);
        }
        this.f11939f.sendEmptyMessage(2);
        return j;
    }

    private final void b(Xj xj) throws zzff {
        if (this.F == xj) {
            return;
        }
        boolean[] zArr = new boolean[this.f11934a.length];
        int i = 0;
        int i2 = 0;
        while (true) {
            zzfz[] zzfzVarArr = this.f11934a;
            if (i < zzfzVarArr.length) {
                zzfz zzfzVar = zzfzVarArr[i];
                zArr[i] = zzfzVar.getState() != 0;
                zzom zzbe = xj.m.zzbfl.zzbe(i);
                if (zzbe != null) {
                    i2++;
                }
                if (zArr[i] && (zzbe == null || (zzfzVar.zzbj() && zzfzVar.zzbg() == this.F.f11962d[i]))) {
                    if (zzfzVar == this.n) {
                        this.f11938e.zza(this.o);
                        this.o = null;
                        this.n = null;
                    }
                    a(zzfzVar);
                    zzfzVar.disable();
                }
                i++;
            } else {
                this.F = xj;
                this.f11941h.obtainMessage(3, xj.m).sendToTarget();
                a(zArr, i2);
                return;
            }
        }
    }

    private final void a(long j) throws zzff {
        Xj xj = this.F;
        this.C = j + (xj == null ? 60000000L : xj.b());
        this.f11938e.zzam(this.C);
        for (zzfz zzfzVar : this.q) {
            zzfzVar.zzd(this.C);
        }
    }

    private static void a(zzfz zzfzVar) throws zzff {
        if (zzfzVar.getState() == 2) {
            zzfzVar.stop();
        }
    }

    private final void a(Object obj, int i) {
        this.l = new zzfp(0, 0L);
        b(obj, i);
        this.l = new zzfp(0, -9223372036854775807L);
        a(4);
        c(false);
    }

    private final int a(int i, zzgc zzgcVar, zzgc zzgcVar2) {
        int zzcl = zzgcVar.zzcl();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzcl && i3 == -1; i4++) {
            i2 = zzgcVar.zza(i2, this.k, this.j, this.w);
            i3 = zzgcVar2.zzc(zzgcVar.zza(i2, this.k, true).zzyn);
        }
        return i3;
    }

    private final Pair<Integer, Long> a(Yj yj) {
        zzgc zzgcVar = yj.f11985a;
        if (zzgcVar.isEmpty()) {
            zzgcVar = this.G;
        }
        try {
            Pair<Integer, Long> b2 = b(zzgcVar, yj.f11986b, yj.f11987c);
            zzgc zzgcVar2 = this.G;
            if (zzgcVar2 == zzgcVar) {
                return b2;
            }
            int zzc = zzgcVar2.zzc(zzgcVar.zza(((Integer) b2.first).intValue(), this.k, true).zzyn);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) b2.second);
            }
            int a2 = a(((Integer) b2.first).intValue(), zzgcVar, this.G);
            if (a2 == -1) {
                return null;
            }
            this.G.zza(a2, this.k, false);
            return b(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzfv(this.G, yj.f11986b, yj.f11987c);
        }
    }

    private final Pair<Integer, Long> a(zzgc zzgcVar, int i, long j, long j2) {
        zzpo.zzc(i, 0, zzgcVar.zzck());
        zzgcVar.zza(i, this.j, false, j2);
        if (j == -9223372036854775807L) {
            j = this.j.zzaaw;
            if (j == -9223372036854775807L) {
                return null;
            }
        }
        long j3 = this.j.zzaax + j;
        long j4 = zzgcVar.zza(0, this.k, false).zzaan;
        int i2 = 0;
        while (j4 != -9223372036854775807L && j3 >= j4 && i2 < this.j.zzaav) {
            j3 -= j4;
            i2++;
            j4 = zzgcVar.zza(i2, this.k, false).zzaan;
        }
        return Pair.create(Integer.valueOf(i2), Long.valueOf(j3));
    }

    private static void a(Xj xj) {
        while (xj != null) {
            xj.a();
            xj = xj.l;
        }
    }

    private final void a(boolean[] zArr, int i) throws zzff {
        this.q = new zzfz[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzfz[] zzfzVarArr = this.f11934a;
            if (i2 >= zzfzVarArr.length) {
                return;
            }
            zzfz zzfzVar = zzfzVarArr[i2];
            zzom zzbe = this.F.m.zzbfl.zzbe(i2);
            if (zzbe != null) {
                int i4 = i3 + 1;
                this.q[i3] = zzfzVar;
                if (zzfzVar.getState() == 0) {
                    zzgb zzgbVar = this.F.m.zzbfn[i2];
                    boolean z = this.s && this.v == 3;
                    boolean z2 = !zArr[i2] && z;
                    zzfs[] zzfsVarArr = new zzfs[zzbe.length()];
                    for (int i5 = 0; i5 < zzfsVarArr.length; i5++) {
                        zzfsVarArr[i5] = zzbe.zzat(i5);
                    }
                    Xj xj = this.F;
                    zzfzVar.zza(zzgbVar, zzfsVarArr, xj.f11962d[i2], this.C, z2, xj.b());
                    zzps zzbf = zzfzVar.zzbf();
                    if (zzbf != null) {
                        if (this.o == null) {
                            this.o = zzbf;
                            this.n = zzfzVar;
                            this.o.zzb(this.m);
                        } else {
                            throw zzff.zza(new IllegalStateException("Multiple renderer media clocks enabled."));
                        }
                    }
                    if (z) {
                        zzfzVar.start();
                    }
                }
                i3 = i4;
            }
            i2++;
        }
    }
}
