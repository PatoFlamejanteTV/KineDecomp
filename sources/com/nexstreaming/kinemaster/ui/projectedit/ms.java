package com.nexstreaming.kinemaster.ui.projectedit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VoiceRecordingControler.java */
/* loaded from: classes.dex */
public class ms implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ mr f4100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ms(mr mrVar) {
        this.f4100a = mrVar;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0013 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x00b0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x004e A[SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r14 = this;
            com.nexstreaming.kinemaster.ui.projectedit.mr r0 = r14.f4100a
            r1 = 1
            com.nexstreaming.kinemaster.ui.projectedit.mr.a(r0, r1)
            r4 = 0
            long r2 = java.lang.System.currentTimeMillis()
            r0 = 0
        Ld:
            com.nexstreaming.kinemaster.ui.projectedit.mr r5 = r14.f4100a
            boolean r5 = com.nexstreaming.kinemaster.ui.projectedit.mr.a(r5)
            if (r5 == 0) goto Lba
            com.nexstreaming.kinemaster.ui.projectedit.mr r5 = r14.f4100a
            android.media.AudioRecord r5 = com.nexstreaming.kinemaster.ui.projectedit.mr.c(r5)
            com.nexstreaming.kinemaster.ui.projectedit.mr r6 = r14.f4100a
            byte[] r6 = com.nexstreaming.kinemaster.ui.projectedit.mr.b(r6)
            r7 = 0
            com.nexstreaming.kinemaster.ui.projectedit.mr r8 = r14.f4100a
            byte[] r8 = com.nexstreaming.kinemaster.ui.projectedit.mr.b(r8)
            int r8 = r8.length
            int r5 = r5.read(r6, r7, r8)
            com.nexstreaming.kinemaster.ui.projectedit.mr r6 = r14.f4100a
            boolean r6 = com.nexstreaming.kinemaster.ui.projectedit.mr.d(r6)
            if (r6 != 0) goto Lc1
            com.nexstreaming.kinemaster.ui.projectedit.mr r6 = r14.f4100a
            long r6 = com.nexstreaming.kinemaster.ui.projectedit.mr.e(r6)
            long r6 = r6 - r0
            long r8 = (long) r5
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 >= 0) goto Lc1
            com.nexstreaming.kinemaster.ui.projectedit.mr r5 = r14.f4100a
            long r6 = com.nexstreaming.kinemaster.ui.projectedit.mr.e(r5)
            long r6 = r6 - r0
            int r5 = (int) r6
            r8 = r5
        L4a:
            long r6 = (long) r8
            long r0 = r0 + r6
            if (r8 <= 0) goto Lb0
            r5 = 1
        L4f:
            if (r5 >= r8) goto L6e
            com.nexstreaming.kinemaster.ui.projectedit.mr r6 = r14.f4100a
            byte[] r6 = com.nexstreaming.kinemaster.ui.projectedit.mr.b(r6)
            r6 = r6[r5]
            int r6 = java.lang.Math.abs(r6)
            if (r6 <= r4) goto L6b
            com.nexstreaming.kinemaster.ui.projectedit.mr r4 = r14.f4100a
            byte[] r4 = com.nexstreaming.kinemaster.ui.projectedit.mr.b(r4)
            r4 = r4[r5]
            int r4 = java.lang.Math.abs(r4)
        L6b:
            int r5 = r5 + 2
            goto L4f
        L6e:
            long r6 = java.lang.System.currentTimeMillis()
            long r10 = r6 - r2
            r12 = 30
            int r5 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r5 <= 0) goto L8c
            int r2 = r4 * 2
            r4 = 0
            com.nexstreaming.kinemaster.ui.projectedit.mr r3 = r14.f4100a
            android.os.Handler r3 = com.nexstreaming.kinemaster.ui.projectedit.mr.g(r3)
            com.nexstreaming.kinemaster.ui.projectedit.mt r5 = new com.nexstreaming.kinemaster.ui.projectedit.mt
            r5.<init>(r14, r2)
            r3.post(r5)
            r2 = r6
        L8c:
            com.nexstreaming.kinemaster.ui.projectedit.mr r5 = r14.f4100a
            boolean r5 = com.nexstreaming.kinemaster.ui.projectedit.mr.d(r5)
            if (r5 != 0) goto La3
            com.nexstreaming.kinemaster.ui.projectedit.mr r5 = r14.f4100a
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r5 = com.nexstreaming.kinemaster.ui.projectedit.mr.h(r5)
            com.nexstreaming.kinemaster.ui.projectedit.mr r6 = r14.f4100a
            byte[] r6 = com.nexstreaming.kinemaster.ui.projectedit.mr.b(r6)
            r5.a(r6, r8)
        La3:
            r6 = 5
            java.lang.Thread.sleep(r6)     // Catch: java.lang.InterruptedException -> Laa
            goto Ld
        Laa:
            r5 = move-exception
            r5.printStackTrace()
            goto Ld
        Lb0:
            r6 = 30
            java.lang.Thread.sleep(r6)     // Catch: java.lang.InterruptedException -> Lb7
            goto Ld
        Lb7:
            r5 = move-exception
            goto Ld
        Lba:
            com.nexstreaming.kinemaster.ui.projectedit.mr r0 = r14.f4100a
            r1 = 0
            com.nexstreaming.kinemaster.ui.projectedit.mr.a(r0, r1)
            return
        Lc1:
            r8 = r5
            goto L4a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.ms.run():void");
    }
}
