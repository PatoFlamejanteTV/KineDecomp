package com.google.android.gms.internal.ads;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@zzark
/* loaded from: classes2.dex */
public final class zzbfs extends zzbfk {
    private static final Set<String> zzewz = Collections.synchronizedSet(new HashSet());
    private static final DecimalFormat zzexa = new DecimalFormat("#,###");
    private File zzexb;
    private boolean zzexc;

    public zzbfs(zzbdz zzbdzVar) {
        super(zzbdzVar);
        File cacheDir = this.mContext.getCacheDir();
        if (cacheDir == null) {
            zzbbd.zzeo("Context.getCacheDir() returned null");
            return;
        }
        this.zzexb = new File(cacheDir, "admobVideoStreams");
        if (!this.zzexb.isDirectory() && !this.zzexb.mkdirs()) {
            String valueOf = String.valueOf(this.zzexb.getAbsolutePath());
            zzbbd.zzeo(valueOf.length() != 0 ? "Could not create preload cache directory at ".concat(valueOf) : new String("Could not create preload cache directory at "));
            this.zzexb = null;
        } else {
            if (this.zzexb.setReadable(true, false) && this.zzexb.setExecutable(true, false)) {
                return;
            }
            String valueOf2 = String.valueOf(this.zzexb.getAbsolutePath());
            zzbbd.zzeo(valueOf2.length() != 0 ? "Could not set cache file permissions at ".concat(valueOf2) : new String("Could not set cache file permissions at "));
            this.zzexb = null;
        }
    }

    private final File zzc(File file) {
        return new File(this.zzexb, String.valueOf(file.getName()).concat(".done"));
    }

    @Override // com.google.android.gms.internal.ads.zzbfk
    public final void abort() {
        this.zzexc = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:133:0x01f0, code lost:            if ((r5 instanceof java.net.HttpURLConnection) == false) goto L113;     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x01f2, code lost:            r1 = r5.getResponseCode();     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x01f8, code lost:            if (r1 < 400) goto L113;     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01fa, code lost:            r15 = "badUrl";        r2 = java.lang.String.valueOf(java.lang.Integer.toString(r1));     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x020a, code lost:            if (r2.length() == 0) goto L106;     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x020c, code lost:            r2 = "HTTP request failed. Code: ".concat(r2);     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x0217, code lost:            r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r31).length() + 32);        r4.append("HTTP status code ");        r4.append(r1);        r4.append(" at ");        r4.append(r31);     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x023f, code lost:            throw new java.io.IOException(r4.toString());     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x0242, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x0240, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x0212, code lost:            r2 = new java.lang.String("HTTP request failed. Code: ");     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x0244, code lost:            r7 = r5.getContentLength();     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0248, code lost:            if (r7 >= 0) goto L121;     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x024a, code lost:            r1 = java.lang.String.valueOf(r31);     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0254, code lost:            if (r1.length() == 0) goto L118;     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0256, code lost:            r0 = "Stream cache aborted, missing content-length header at ".concat(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0261, code lost:            com.google.android.gms.internal.ads.zzbbd.zzeo(r0);        zza(r31, r12.getAbsolutePath(), "contentLengthMissing", null);        com.google.android.gms.internal.ads.zzbfs.zzewz.remove(r14);     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0272, code lost:            return false;     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x025b, code lost:            r0 = new java.lang.String("Stream cache aborted, missing content-length header at ");     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0273, code lost:            r1 = com.google.android.gms.internal.ads.zzbfs.zzexa.format(r7);        r3 = ((java.lang.Integer) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcou)).intValue();     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x028a, code lost:            if (r7 <= r3) goto L129;     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x028c, code lost:            r2 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 33) + java.lang.String.valueOf(r31).length());        r2.append("Content length ");        r2.append(r1);        r2.append(" exceeds limit at ");        r2.append(r31);        com.google.android.gms.internal.ads.zzbbd.zzeo(r2.toString());        r1 = java.lang.String.valueOf(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x02c5, code lost:            if (r1.length() == 0) goto L126;     */
    /* JADX WARN: Code restructure failed: missing block: B:158:0x02c7, code lost:            r0 = "File too big for full file cache. Size: ".concat(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x02d2, code lost:            zza(r31, r12.getAbsolutePath(), "sizeExceeded", r0);        com.google.android.gms.internal.ads.zzbfs.zzewz.remove(r14);     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x02e0, code lost:            return false;     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x02cc, code lost:            r0 = new java.lang.String("File too big for full file cache. Size: ");     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x02e1, code lost:            r4 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 20) + java.lang.String.valueOf(r31).length());        r4.append("Caching ");        r4.append(r1);        r4.append(" bytes from ");        r4.append(r31);        com.google.android.gms.internal.ads.zzbbd.zzdn(r4.toString());        r5 = java.nio.channels.Channels.newChannel(r5.getInputStream());        r4 = new java.io.FileOutputStream(r12);     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x031c, code lost:            r2 = r4.getChannel();        r1 = java.nio.ByteBuffer.allocate(1048576);        r16 = com.google.android.gms.ads.internal.zzbv.l();        r17 = r16.a();     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x033a, code lost:            r10 = r14;     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x033b, code lost:            r6 = new com.google.android.gms.internal.ads.zzbai(((java.lang.Long) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcox)).longValue());        r13 = ((java.lang.Long) com.google.android.gms.internal.ads.zzwu.zzpz().zzd(com.google.android.gms.internal.ads.zzaan.zzcow)).longValue();     */
    /* JADX WARN: Code restructure failed: missing block: B:169:0x0354, code lost:            r20 = r5.read(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:170:0x0358, code lost:            if (r20 < 0) goto L322;     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x035a, code lost:            r11 = r11 + r20;     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x035c, code lost:            if (r11 <= r3) goto L289;     */
    /* JADX WARN: Code restructure failed: missing block: B:174:0x035e, code lost:            r15 = "sizeExceeded";        r1 = java.lang.String.valueOf(java.lang.Integer.toString(r11));     */
    /* JADX WARN: Code restructure failed: missing block: B:175:0x036e, code lost:            if (r1.length() == 0) goto L140;     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0370, code lost:            r1 = "File too big for full file cache. Size: ".concat(r1);     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0382, code lost:            throw new java.io.IOException("stream cache file size limit exceeded");     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0385, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x0386, code lost:            r2 = r1;        r1 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:183:0x038e, code lost:            r10 = r4;        r1 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:184:0x0376, code lost:            r1 = new java.lang.String("File too big for full file cache. Size: ");     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0389, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:186:0x038c, code lost:            r1 = r10;        r2 = null;     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x0391, code lost:            r1.flip();     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x0398, code lost:            if (r2.write(r1) > 0) goto L188;     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x039a, code lost:            r1.clear();        r24 = ((r16.a() - r17) > (1000 * r13) ? 1 : ((r16.a() - r17) == (1000 * r13) ? 0 : -1));     */
    /* JADX WARN: Code restructure failed: missing block: B:195:0x03a9, code lost:            if (r24 > 0) goto L323;     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x03ab, code lost:            r20 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x03af, code lost:            if (r30.zzexc != false) goto L324;     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x03b5, code lost:            if (r6.tryAcquire() == false) goto L170;     */
    /* JADX WARN: Code restructure failed: missing block: B:201:0x03bd, code lost:            r22 = r15;     */
    /* JADX WARN: Code restructure failed: missing block: B:204:0x03c1, code lost:            r24 = r10;        r25 = r2;        r26 = r3;        r27 = r4;        r21 = r5;        r19 = r6;        r29 = r7;     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x03df, code lost:            com.google.android.gms.internal.ads.zzbat.zztu.post(new com.google.android.gms.internal.ads.RunnableC1040pf(r30, r31, r12.getAbsolutePath(), r11, r7, false));     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x0400, code lost:            r6 = r19;        r1 = r20;        r5 = r21;        r15 = r22;        r10 = r24;        r2 = r25;        r3 = r26;        r4 = r27;        r7 = r29;     */
    /* JADX WARN: Code restructure failed: missing block: B:209:0x04be, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x04bf, code lost:            r15 = r22;     */
    /* JADX WARN: Code restructure failed: missing block: B:211:0x04c1, code lost:            r1 = r24;     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x04bc, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x03e8, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:216:0x03e9, code lost:            r27 = r4;        r1 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x03e6, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:220:0x03ee, code lost:            r25 = r2;        r26 = r3;        r27 = r4;        r21 = r5;        r19 = r6;        r29 = r7;        r24 = r10;        r22 = r15;     */
    /* JADX WARN: Code restructure failed: missing block: B:225:0x0423, code lost:            throw new java.io.IOException("abort requested");     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0424, code lost:            r27 = r4;        r24 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:228:0x042a, code lost:            r15 = "downloadTimeout";     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x042c, code lost:            r0 = java.lang.Long.toString(r13);        r2 = new java.lang.StringBuilder(java.lang.String.valueOf(r0).length() + 29);        r2.append("Timeout exceeded. Limit: ");        r2.append(r0);        r2.append(" sec");        r10 = r2.toString();     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0457, code lost:            throw new java.io.IOException("stream cache time limit exceeded");     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0458, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x045b, code lost:            r2 = r10;        r1 = r24;        r10 = r27;     */
    /* JADX WARN: Code restructure failed: missing block: B:236:0x0464, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:237:0x0462, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:239:0x046c, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:240:0x046d, code lost:            r27 = r4;        r1 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:242:0x0474, code lost:            r27 = r4;        r24 = r10;        r22 = r15;     */
    /* JADX WARN: Code restructure failed: missing block: B:244:0x047c, code lost:            r27.close();     */
    /* JADX WARN: Code restructure failed: missing block: B:245:0x0483, code lost:            if (com.google.android.gms.internal.ads.zzbbd.isLoggable(3) == false) goto L203;     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0485, code lost:            r1 = com.google.android.gms.internal.ads.zzbfs.zzexa.format(r11);        r3 = new java.lang.StringBuilder((java.lang.String.valueOf(r1).length() + 22) + java.lang.String.valueOf(r31).length());        r3.append("Preloaded ");        r3.append(r1);        r3.append(" bytes from ");        r3.append(r31);        com.google.android.gms.internal.ads.zzbbd.zzdn(r3.toString());     */
    /* JADX WARN: Code restructure failed: missing block: B:248:0x04c6, code lost:            r12.setReadable(true, false);     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x04cd, code lost:            if (r0.isFile() == false) goto L278;     */
    /* JADX WARN: Code restructure failed: missing block: B:250:0x04cf, code lost:            r0.setLastModified(java.lang.System.currentTimeMillis());     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x04d7, code lost:            r0.createNewFile();     */
    /* JADX WARN: Code restructure failed: missing block: B:265:0x04f0, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x04f1, code lost:            r1 = r24;     */
    /* JADX WARN: Code restructure failed: missing block: B:268:0x04f8, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x04f9, code lost:            r27 = r4;        r1 = r10;     */
    /* JADX WARN: Code restructure failed: missing block: B:270:0x0503, code lost:            r1 = r1;     */
    /* JADX WARN: Code restructure failed: missing block: B:272:0x04ff, code lost:            r0 = e;     */
    /* JADX WARN: Code restructure failed: missing block: B:273:0x0500, code lost:            r27 = r4;        r1 = r14;     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 22, insn: 0x0522: MOVE (r15 I:??[OBJECT, ARRAY]) = (r22 I:??[OBJECT, ARRAY]), block:B:282:0x0522 */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0531  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0541  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x058e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x05a4  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x05a9  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0565  */
    /* JADX WARN: Type inference failed for: r1v15, types: [int] */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r24v2 */
    /* JADX WARN: Type inference failed for: r24v3 */
    /* JADX WARN: Type inference failed for: r24v4, types: [int] */
    /* JADX WARN: Type inference failed for: r24v7 */
    /* JADX WARN: Type inference failed for: r24v8 */
    /* JADX WARN: Type inference failed for: r24v9 */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.net.URLConnection] */
    @Override // com.google.android.gms.internal.ads.zzbfk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzex(java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 1477
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbfs.zzex(java.lang.String):boolean");
    }
}
