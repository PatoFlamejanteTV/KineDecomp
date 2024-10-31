package com.google.android.gms.internal.ads;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.ConditionVariable;
import android.os.SystemClock;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes2.dex */
public final class zzgs {
    private static boolean zzabu = false;
    private static boolean zzabv = false;
    private int streamType;
    private final C0975kk zzabx;
    private final zzhi zzaby;
    private final zzgi[] zzabz;
    private final zzgy zzaca;
    private final long[] zzacc;
    private final C0934hk zzacd;
    private final LinkedList<C0961jk> zzace;
    private AudioTrack zzacf;
    private int zzacg;
    private int zzach;
    private int zzaci;
    private boolean zzacj;
    private int zzack;
    private long zzacl;
    private zzfy zzacm;
    private long zzacn;
    private long zzaco;
    private ByteBuffer zzacp;
    private int zzacq;
    private int zzacr;
    private int zzacs;
    private long zzact;
    private long zzacu;
    private boolean zzacv;
    private long zzacw;
    private Method zzacx;
    private int zzacy;
    private long zzacz;
    private long zzada;
    private int zzadb;
    private long zzadc;
    private long zzadd;
    private int zzade;
    private int zzadf;
    private long zzadg;
    private long zzadh;
    private long zzadi;
    private zzgi[] zzadj;
    private ByteBuffer[] zzadk;
    private ByteBuffer zzadl;
    private ByteBuffer zzadm;
    private byte[] zzadn;
    private int zzado;
    private int zzadp;
    private boolean zzadq;
    private boolean zzadr;
    private int zzads;
    private boolean zzadt;
    private boolean zzadu;
    private long zzadv;
    private float zzcu;
    private zzfy zzxm;
    private int zzzu;
    private final zzgh zzabw = null;
    private final ConditionVariable zzacb = new ConditionVariable(true);

    public zzgs(zzgh zzghVar, zzgi[] zzgiVarArr, zzgy zzgyVar) {
        C0920gk c0920gk = null;
        this.zzaca = zzgyVar;
        if (zzqe.SDK_INT >= 18) {
            try {
                this.zzacx = AudioTrack.class.getMethod("getLatency", null);
            } catch (NoSuchMethodException unused) {
            }
        }
        if (zzqe.SDK_INT >= 19) {
            this.zzacd = new C0947ik();
        } else {
            this.zzacd = new C0934hk(c0920gk);
        }
        this.zzabx = new C0975kk();
        this.zzaby = new zzhi();
        this.zzabz = new zzgi[zzgiVarArr.length + 3];
        this.zzabz[0] = new C1017nk();
        zzgi[] zzgiVarArr2 = this.zzabz;
        zzgiVarArr2[1] = this.zzabx;
        System.arraycopy(zzgiVarArr, 0, zzgiVarArr2, 2, zzgiVarArr.length);
        this.zzabz[zzgiVarArr.length + 2] = this.zzaby;
        this.zzacc = new long[10];
        this.zzcu = 1.0f;
        this.zzadf = 0;
        this.streamType = 3;
        this.zzads = 0;
        this.zzxm = zzfy.zzaaf;
        this.zzadp = -1;
        this.zzadj = new zzgi[0];
        this.zzadk = new ByteBuffer[0];
        this.zzace = new LinkedList<>();
    }

    private final boolean isInitialized() {
        return this.zzacf != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d9, code lost:            if (r11 < r10) goto L26;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzb(java.nio.ByteBuffer r9, long r10) throws com.google.android.gms.internal.ads.zzha {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgs.zzb(java.nio.ByteBuffer, long):boolean");
    }

    private final void zzcs() {
        ArrayList arrayList = new ArrayList();
        for (zzgi zzgiVar : this.zzabz) {
            if (zzgiVar.isActive()) {
                arrayList.add(zzgiVar);
            } else {
                zzgiVar.flush();
            }
        }
        int size = arrayList.size();
        this.zzadj = (zzgi[]) arrayList.toArray(new zzgi[size]);
        this.zzadk = new ByteBuffer[size];
        for (int i = 0; i < size; i++) {
            zzgi zzgiVar2 = this.zzadj[i];
            zzgiVar2.flush();
            this.zzadk[i] = zzgiVar2.zzcr();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0038  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x0032 -> B:7:0x0012). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean zzcv() throws com.google.android.gms.internal.ads.zzha {
        /*
            r9 = this;
            int r0 = r9.zzadp
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L14
            boolean r0 = r9.zzacj
            if (r0 == 0) goto Lf
            com.google.android.gms.internal.ads.zzgi[] r0 = r9.zzadj
            int r0 = r0.length
            goto L10
        Lf:
            r0 = 0
        L10:
            r9.zzadp = r0
        L12:
            r0 = 1
            goto L15
        L14:
            r0 = 0
        L15:
            int r4 = r9.zzadp
            com.google.android.gms.internal.ads.zzgi[] r5 = r9.zzadj
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L38
            r4 = r5[r4]
            if (r0 == 0) goto L28
            r4.zzcq()
        L28:
            r9.zzm(r7)
            boolean r0 = r4.zzcj()
            if (r0 != 0) goto L32
            return r3
        L32:
            int r0 = r9.zzadp
            int r0 = r0 + r2
            r9.zzadp = r0
            goto L12
        L38:
            java.nio.ByteBuffer r0 = r9.zzadm
            if (r0 == 0) goto L44
            r9.zzb(r0, r7)
            java.nio.ByteBuffer r0 = r9.zzadm
            if (r0 == 0) goto L44
            return r3
        L44:
            r9.zzadp = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgs.zzcv():boolean");
    }

    private final void zzcz() {
        if (isInitialized()) {
            if (zzqe.SDK_INT >= 21) {
                this.zzacf.setVolume(this.zzcu);
                return;
            }
            AudioTrack audioTrack = this.zzacf;
            float f2 = this.zzcu;
            audioTrack.setStereoVolume(f2, f2);
        }
    }

    private final long zzda() {
        return this.zzacj ? this.zzadd : this.zzadc / this.zzadb;
    }

    private final void zzdb() {
        this.zzact = 0L;
        this.zzacs = 0;
        this.zzacr = 0;
        this.zzacu = 0L;
        this.zzacv = false;
        this.zzacw = 0L;
    }

    private final boolean zzdc() {
        if (zzqe.SDK_INT >= 23) {
            return false;
        }
        int i = this.zzaci;
        return i == 5 || i == 6;
    }

    private final void zzm(long j) throws zzha {
        ByteBuffer byteBuffer;
        int length = this.zzadj.length;
        int i = length;
        while (i >= 0) {
            if (i > 0) {
                byteBuffer = this.zzadk[i - 1];
            } else {
                byteBuffer = this.zzadl;
                if (byteBuffer == null) {
                    byteBuffer = zzgi.zzabh;
                }
            }
            if (i == length) {
                zzb(byteBuffer, j);
            } else {
                zzgi zzgiVar = this.zzadj[i];
                zzgiVar.zzi(byteBuffer);
                ByteBuffer zzcr = zzgiVar.zzcr();
                this.zzadk[i] = zzcr;
                if (zzcr.hasRemaining()) {
                    i++;
                }
            }
            if (byteBuffer.hasRemaining()) {
                return;
            } else {
                i--;
            }
        }
    }

    private final long zzo(long j) {
        return (j * this.zzzu) / 1000000;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static int zzr(String str) {
        char c2;
        switch (str.hashCode()) {
            case -1095064472:
                if (str.equals("audio/vnd.dts")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 187078296:
                if (str.equals("audio/ac3")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 1504578661:
                if (str.equals("audio/eac3")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 1505942594:
                if (str.equals("audio/vnd.dts.hd")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            return 5;
        }
        if (c2 == 1) {
            return 6;
        }
        if (c2 != 2) {
            return c2 != 3 ? 0 : 8;
        }
        return 7;
    }

    public final void pause() {
        this.zzadr = false;
        if (isInitialized()) {
            zzdb();
            this.zzacd.a();
        }
    }

    public final void play() {
        this.zzadr = true;
        if (isInitialized()) {
            this.zzadh = System.nanoTime() / 1000;
            this.zzacf.play();
        }
    }

    public final void release() {
        reset();
        for (zzgi zzgiVar : this.zzabz) {
            zzgiVar.reset();
        }
        this.zzads = 0;
        this.zzadr = false;
    }

    public final void reset() {
        if (isInitialized()) {
            this.zzacz = 0L;
            this.zzada = 0L;
            this.zzadc = 0L;
            this.zzadd = 0L;
            this.zzade = 0;
            zzfy zzfyVar = this.zzacm;
            if (zzfyVar != null) {
                this.zzxm = zzfyVar;
                this.zzacm = null;
            } else if (!this.zzace.isEmpty()) {
                this.zzxm = C0961jk.a(this.zzace.getLast());
            }
            this.zzace.clear();
            this.zzacn = 0L;
            this.zzaco = 0L;
            this.zzadl = null;
            this.zzadm = null;
            int i = 0;
            while (true) {
                zzgi[] zzgiVarArr = this.zzadj;
                if (i >= zzgiVarArr.length) {
                    break;
                }
                zzgi zzgiVar = zzgiVarArr[i];
                zzgiVar.flush();
                this.zzadk[i] = zzgiVar.zzcr();
                i++;
            }
            this.zzadq = false;
            this.zzadp = -1;
            this.zzacp = null;
            this.zzacq = 0;
            this.zzadf = 0;
            this.zzadi = 0L;
            zzdb();
            if (this.zzacf.getPlayState() == 3) {
                this.zzacf.pause();
            }
            AudioTrack audioTrack = this.zzacf;
            this.zzacf = null;
            this.zzacd.a(null, false);
            this.zzacb.close();
            new C0920gk(this, audioTrack).start();
        }
    }

    public final void setStreamType(int i) {
        if (this.streamType == i) {
            return;
        }
        this.streamType = i;
        if (this.zzadt) {
            return;
        }
        reset();
        this.zzads = 0;
    }

    public final void setVolume(float f2) {
        if (this.zzcu != f2) {
            this.zzcu = f2;
            zzcz();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0102  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.String r8, int r9, int r10, int r11, int r12, int[] r13) throws com.google.android.gms.internal.ads.zzgw {
        /*
            Method dump skipped, instructions count: 360
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgs.zza(java.lang.String, int, int, int, int, int[]):void");
    }

    public final boolean zzcj() {
        if (isInitialized()) {
            return this.zzadq && !zzcw();
        }
        return true;
    }

    public final void zzct() {
        if (this.zzadf == 1) {
            this.zzadf = 2;
        }
    }

    public final void zzcu() throws zzha {
        if (!this.zzadq && isInitialized() && zzcv()) {
            this.zzacd.a(zzda());
            this.zzacq = 0;
            this.zzadq = true;
        }
    }

    public final boolean zzcw() {
        if (isInitialized()) {
            if (zzda() <= this.zzacd.b()) {
                if (zzdc() && this.zzacf.getPlayState() == 2 && this.zzacf.getPlaybackHeadPosition() == 0) {
                }
            }
            return true;
        }
        return false;
    }

    public final zzfy zzcx() {
        return this.zzxm;
    }

    public final void zzcy() {
        if (this.zzadt) {
            this.zzadt = false;
            this.zzads = 0;
            reset();
        }
    }

    public final long zzg(boolean z) {
        long j;
        long j2;
        long j3;
        long j4;
        if (!(isInitialized() && this.zzadf != 0)) {
            return Long.MIN_VALUE;
        }
        if (this.zzacf.getPlayState() == 3) {
            long c2 = this.zzacd.c();
            if (c2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - this.zzacu >= com.umeng.commonsdk.proguard.c.f26227d) {
                    long[] jArr = this.zzacc;
                    int i = this.zzacr;
                    jArr[i] = c2 - nanoTime;
                    this.zzacr = (i + 1) % 10;
                    int i2 = this.zzacs;
                    if (i2 < 10) {
                        this.zzacs = i2 + 1;
                    }
                    this.zzacu = nanoTime;
                    this.zzact = 0L;
                    int i3 = 0;
                    while (true) {
                        int i4 = this.zzacs;
                        if (i3 >= i4) {
                            break;
                        }
                        this.zzact += this.zzacc[i3] / i4;
                        i3++;
                    }
                }
                if (!zzdc() && nanoTime - this.zzacw >= 500000) {
                    this.zzacv = this.zzacd.d();
                    if (this.zzacv) {
                        long e2 = this.zzacd.e() / 1000;
                        long f2 = this.zzacd.f();
                        if (e2 < this.zzadh) {
                            this.zzacv = false;
                        } else if (Math.abs(e2 - nanoTime) > 5000000) {
                            StringBuilder sb = new StringBuilder(136);
                            sb.append("Spurious audio timestamp (system clock mismatch): ");
                            sb.append(f2);
                            sb.append(", ");
                            sb.append(e2);
                            sb.append(", ");
                            sb.append(nanoTime);
                            sb.append(", ");
                            sb.append(c2);
                            Log.w("AudioTrack", sb.toString());
                            this.zzacv = false;
                        } else if (Math.abs(zzn(f2) - c2) > 5000000) {
                            StringBuilder sb2 = new StringBuilder(138);
                            sb2.append("Spurious audio timestamp (frame position mismatch): ");
                            sb2.append(f2);
                            sb2.append(", ");
                            sb2.append(e2);
                            sb2.append(", ");
                            sb2.append(nanoTime);
                            sb2.append(", ");
                            sb2.append(c2);
                            Log.w("AudioTrack", sb2.toString());
                            this.zzacv = false;
                        }
                    }
                    if (this.zzacx != null && !this.zzacj) {
                        try {
                            this.zzadi = (((Integer) r1.invoke(this.zzacf, null)).intValue() * 1000) - this.zzacl;
                            this.zzadi = Math.max(this.zzadi, 0L);
                            if (this.zzadi > 5000000) {
                                long j5 = this.zzadi;
                                StringBuilder sb3 = new StringBuilder(61);
                                sb3.append("Ignoring impossibly large audio latency: ");
                                sb3.append(j5);
                                Log.w("AudioTrack", sb3.toString());
                                this.zzadi = 0L;
                            }
                        } catch (Exception unused) {
                            this.zzacx = null;
                        }
                    }
                    this.zzacw = nanoTime;
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        if (this.zzacv) {
            j = zzn(this.zzacd.f() + zzo(nanoTime2 - (this.zzacd.e() / 1000)));
        } else {
            if (this.zzacs == 0) {
                j = this.zzacd.c();
            } else {
                j = nanoTime2 + this.zzact;
            }
            if (!z) {
                j -= this.zzadi;
            }
        }
        long j6 = this.zzadg;
        while (!this.zzace.isEmpty() && j >= C0961jk.b(this.zzace.getFirst())) {
            C0961jk remove = this.zzace.remove();
            this.zzxm = C0961jk.a(remove);
            this.zzaco = C0961jk.b(remove);
            this.zzacn = C0961jk.c(remove) - this.zzadg;
        }
        if (this.zzxm.zzaag == 1.0f) {
            j4 = (j + this.zzacn) - this.zzaco;
        } else {
            if (this.zzace.isEmpty() && this.zzaby.zzdn() >= PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                j2 = this.zzacn;
                j3 = zzqe.zza(j - this.zzaco, this.zzaby.zzdm(), this.zzaby.zzdn());
            } else {
                j2 = this.zzacn;
                double d2 = this.zzxm.zzaag;
                double d3 = j - this.zzaco;
                Double.isNaN(d2);
                Double.isNaN(d3);
                j3 = (long) (d2 * d3);
            }
            j4 = j3 + j2;
        }
        return j6 + j4;
    }

    public final void zzn(int i) {
        zzpo.checkState(zzqe.SDK_INT >= 21);
        if (this.zzadt && this.zzads == i) {
            return;
        }
        this.zzadt = true;
        this.zzads = i;
        reset();
    }

    public final boolean zzq(String str) {
        zzgh zzghVar = this.zzabw;
        return zzghVar != null && zzghVar.zzk(zzr(str));
    }

    private final long zzn(long j) {
        return (j * 1000000) / this.zzzu;
    }

    public final boolean zza(ByteBuffer byteBuffer, long j) throws zzgx, zzha {
        int i;
        int zzj;
        ByteBuffer byteBuffer2 = this.zzadl;
        zzpo.checkArgument(byteBuffer2 == null || byteBuffer == byteBuffer2);
        if (!isInitialized()) {
            this.zzacb.block();
            if (this.zzadt) {
                this.zzacf = new AudioTrack(new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(16).build(), new AudioFormat.Builder().setChannelMask(this.zzacg).setEncoding(this.zzaci).setSampleRate(this.zzzu).build(), this.zzack, 1, this.zzads);
            } else {
                int i2 = this.zzads;
                if (i2 == 0) {
                    this.zzacf = new AudioTrack(this.streamType, this.zzzu, this.zzacg, this.zzaci, this.zzack, 1);
                } else {
                    this.zzacf = new AudioTrack(this.streamType, this.zzzu, this.zzacg, this.zzaci, this.zzack, 1, i2);
                }
            }
            int state = this.zzacf.getState();
            if (state == 1) {
                int audioSessionId = this.zzacf.getAudioSessionId();
                if (this.zzads != audioSessionId) {
                    this.zzads = audioSessionId;
                    this.zzaca.zzl(audioSessionId);
                }
                this.zzacd.a(this.zzacf, zzdc());
                zzcz();
                this.zzadu = false;
                if (this.zzadr) {
                    play();
                }
            } else {
                try {
                    this.zzacf.release();
                } catch (Exception unused) {
                } finally {
                    this.zzacf = null;
                }
                throw new zzgx(state, this.zzzu, this.zzacg, this.zzack);
            }
        }
        if (zzdc()) {
            if (this.zzacf.getPlayState() == 2) {
                this.zzadu = false;
                return false;
            }
            if (this.zzacf.getPlayState() == 1 && this.zzacd.b() != 0) {
                return false;
            }
        }
        boolean z = this.zzadu;
        this.zzadu = zzcw();
        if (z && !this.zzadu && this.zzacf.getPlayState() != 1) {
            this.zzaca.zzc(this.zzack, zzfe.zzf(this.zzacl), SystemClock.elapsedRealtime() - this.zzadv);
        }
        if (this.zzadl == null) {
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            if (this.zzacj && this.zzade == 0) {
                int i3 = this.zzaci;
                if (i3 == 7 || i3 == 8) {
                    zzj = zzhc.zzj(byteBuffer);
                } else if (i3 == 5) {
                    zzj = zzgg.zzcn();
                } else if (i3 == 6) {
                    zzj = zzgg.zzh(byteBuffer);
                } else {
                    StringBuilder sb = new StringBuilder(38);
                    sb.append("Unexpected audio encoding: ");
                    sb.append(i3);
                    throw new IllegalStateException(sb.toString());
                }
                this.zzade = zzj;
            }
            if (this.zzacm != null) {
                if (!zzcv()) {
                    return false;
                }
                this.zzace.add(new C0961jk(this.zzacm, Math.max(0L, j), zzn(zzda()), null));
                this.zzacm = null;
                zzcs();
            }
            if (this.zzadf == 0) {
                this.zzadg = Math.max(0L, j);
                this.zzadf = 1;
            } else {
                long zzn = this.zzadg + zzn(this.zzacj ? this.zzada : this.zzacz / this.zzacy);
                if (this.zzadf != 1 || Math.abs(zzn - j) <= 200000) {
                    i = 2;
                } else {
                    StringBuilder sb2 = new StringBuilder(80);
                    sb2.append("Discontinuity detected [expected ");
                    sb2.append(zzn);
                    sb2.append(", got ");
                    sb2.append(j);
                    sb2.append("]");
                    Log.e("AudioTrack", sb2.toString());
                    i = 2;
                    this.zzadf = 2;
                }
                if (this.zzadf == i) {
                    this.zzadg += j - zzn;
                    this.zzadf = 1;
                    this.zzaca.zzbs();
                }
            }
            if (this.zzacj) {
                this.zzada += this.zzade;
            } else {
                this.zzacz += byteBuffer.remaining();
            }
            this.zzadl = byteBuffer;
        }
        if (this.zzacj) {
            zzb(this.zzadl, j);
        } else {
            zzm(j);
        }
        if (this.zzadl.hasRemaining()) {
            return false;
        }
        this.zzadl = null;
        return true;
    }

    public final zzfy zzb(zzfy zzfyVar) {
        if (this.zzacj) {
            this.zzxm = zzfy.zzaaf;
            return this.zzxm;
        }
        zzfy zzfyVar2 = new zzfy(this.zzaby.zzb(zzfyVar.zzaag), this.zzaby.zzc(zzfyVar.zzaah));
        zzfy zzfyVar3 = this.zzacm;
        if (zzfyVar3 == null) {
            if (!this.zzace.isEmpty()) {
                zzfyVar3 = C0961jk.a(this.zzace.getLast());
            } else {
                zzfyVar3 = this.zzxm;
            }
        }
        if (!zzfyVar2.equals(zzfyVar3)) {
            if (isInitialized()) {
                this.zzacm = zzfyVar2;
            } else {
                this.zzxm = zzfyVar2;
            }
        }
        return this.zzxm;
    }
}
