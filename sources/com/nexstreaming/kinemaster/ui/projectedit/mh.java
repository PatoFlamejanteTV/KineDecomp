package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: VoiceRecordingController.java */
/* loaded from: classes2.dex */
public class Mh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Oh f21966a;

    public Mh(Oh oh) {
        this.f21966a = oh;
    }

    /* JADX WARN: Incorrect condition in loop: B:3:0x0019 */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            r15 = this;
            r0 = -19
            android.os.Process.setThreadPriority(r0)
            com.nexstreaming.kinemaster.ui.projectedit.Oh r0 = r15.f21966a
            r1 = 1
            com.nexstreaming.kinemaster.ui.projectedit.Oh.a(r0, r1)
            long r2 = java.lang.System.currentTimeMillis()
            r0 = 0
            r4 = 0
            r6 = 0
        L13:
            com.nexstreaming.kinemaster.ui.projectedit.Oh r7 = r15.f21966a
            boolean r7 = com.nexstreaming.kinemaster.ui.projectedit.Oh.a(r7)
            if (r7 == 0) goto Lba
            com.nexstreaming.kinemaster.ui.projectedit.Oh r7 = r15.f21966a
            android.media.AudioRecord r7 = com.nexstreaming.kinemaster.ui.projectedit.Oh.c(r7)
            com.nexstreaming.kinemaster.ui.projectedit.Oh r8 = r15.f21966a
            byte[] r8 = com.nexstreaming.kinemaster.ui.projectedit.Oh.b(r8)
            com.nexstreaming.kinemaster.ui.projectedit.Oh r9 = r15.f21966a
            byte[] r9 = com.nexstreaming.kinemaster.ui.projectedit.Oh.b(r9)
            int r9 = r9.length
            int r7 = r7.read(r8, r0, r9)
            com.nexstreaming.kinemaster.ui.projectedit.Oh r8 = r15.f21966a
            boolean r8 = com.nexstreaming.kinemaster.ui.projectedit.Oh.d(r8)
            if (r8 != 0) goto L4e
            com.nexstreaming.kinemaster.ui.projectedit.Oh r8 = r15.f21966a
            long r8 = com.nexstreaming.kinemaster.ui.projectedit.Oh.e(r8)
            long r8 = r8 - r4
            long r10 = (long) r7
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 >= 0) goto L4e
            com.nexstreaming.kinemaster.ui.projectedit.Oh r7 = r15.f21966a
            long r7 = com.nexstreaming.kinemaster.ui.projectedit.Oh.e(r7)
            long r7 = r7 - r4
            int r7 = (int) r7
        L4e:
            long r8 = (long) r7
            long r4 = r4 + r8
            r8 = 30
            if (r7 <= 0) goto Lb5
            r10 = r6
            r6 = 1
        L56:
            if (r6 >= r7) goto L75
            com.nexstreaming.kinemaster.ui.projectedit.Oh r11 = r15.f21966a
            byte[] r11 = com.nexstreaming.kinemaster.ui.projectedit.Oh.b(r11)
            r11 = r11[r6]
            int r11 = java.lang.Math.abs(r11)
            if (r11 <= r10) goto L72
            com.nexstreaming.kinemaster.ui.projectedit.Oh r10 = r15.f21966a
            byte[] r10 = com.nexstreaming.kinemaster.ui.projectedit.Oh.b(r10)
            r10 = r10[r6]
            int r10 = java.lang.Math.abs(r10)
        L72:
            int r6 = r6 + 2
            goto L56
        L75:
            long r11 = java.lang.System.currentTimeMillis()
            long r13 = r11 - r2
            int r6 = (r13 > r8 ? 1 : (r13 == r8 ? 0 : -1))
            if (r6 <= 0) goto L91
            int r10 = r10 * 2
            com.nexstreaming.kinemaster.ui.projectedit.Oh r2 = r15.f21966a
            android.os.Handler r2 = com.nexstreaming.kinemaster.ui.projectedit.Oh.g(r2)
            com.nexstreaming.kinemaster.ui.projectedit.Lh r3 = new com.nexstreaming.kinemaster.ui.projectedit.Lh
            r3.<init>(r15, r10)
            r2.post(r3)
            r2 = r11
            r10 = 0
        L91:
            com.nexstreaming.kinemaster.ui.projectedit.Oh r6 = r15.f21966a
            boolean r6 = com.nexstreaming.kinemaster.ui.projectedit.Oh.d(r6)
            if (r6 != 0) goto La8
            com.nexstreaming.kinemaster.ui.projectedit.Oh r6 = r15.f21966a
            com.nexstreaming.kinemaster.editorwrapper.VideoEditor r6 = com.nexstreaming.kinemaster.ui.projectedit.Oh.h(r6)
            com.nexstreaming.kinemaster.ui.projectedit.Oh r8 = r15.f21966a
            byte[] r8 = com.nexstreaming.kinemaster.ui.projectedit.Oh.b(r8)
            r6.a(r8, r7)
        La8:
            r6 = 5
            java.lang.Thread.sleep(r6)     // Catch: java.lang.InterruptedException -> Lae
            goto Lb2
        Lae:
            r6 = move-exception
            r6.printStackTrace()
        Lb2:
            r6 = r10
            goto L13
        Lb5:
            java.lang.Thread.sleep(r8)     // Catch: java.lang.InterruptedException -> L13
            goto L13
        Lba:
            com.nexstreaming.kinemaster.ui.projectedit.Oh r1 = r15.f21966a
            com.nexstreaming.kinemaster.ui.projectedit.Oh.a(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.projectedit.Mh.run():void");
    }
}
