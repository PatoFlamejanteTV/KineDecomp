package com.nexstreaming.kinemaster.codeccaps;

import android.app.Activity;
import com.crashlytics.android.Crashlytics;
import com.google.protos.datapol.SemanticAnnotations;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityChecker.java */
/* loaded from: classes.dex */
public class t implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ CapabilityChecker f20120a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(CapabilityChecker capabilityChecker) {
        this.f20120a = capabilityChecker;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        boolean z2;
        List list;
        List list2;
        boolean z3;
        ResultTask resultTask;
        int i;
        List list3;
        int i2;
        List list4;
        WeakReference weakReference;
        List list5;
        ResultTask resultTask2;
        CapabilityChecker.b bVar;
        InterfaceC1716d interfaceC1716d;
        ResultTask resultTask3;
        ResultTask resultTask4;
        int i3;
        int i4;
        ResultTask resultTask5;
        int i5;
        int i6;
        long j;
        CapabilityChecker.b bVar2;
        CapabilityChecker.b bVar3;
        SortedMap sortedMap;
        String b2;
        CapabilityChecker.b bVar4;
        SortedMap sortedMap2;
        String b3;
        CapabilityChecker.b bVar5;
        SortedMap sortedMap3;
        String b4;
        CapabilityChecker.b bVar6;
        CapabilityChecker.a aVar;
        CapabilityChecker.b bVar7;
        CapabilityChecker.a aVar2;
        CapabilityChecker.b bVar8;
        CapabilityChecker.a aVar3;
        CapabilityChecker.b bVar9;
        CapabilityChecker.a aVar4;
        CapabilityChecker.b bVar10;
        CapabilityChecker.a aVar5;
        CapabilityChecker.b bVar11;
        CapabilityChecker.a aVar6;
        CapabilityChecker.b bVar12;
        CapabilityChecker.a aVar7;
        CapabilityChecker.b bVar13;
        CapabilityChecker.a aVar8;
        CapabilityChecker.b bVar14;
        CapabilityChecker.a aVar9;
        CapabilityChecker.a aVar10;
        CapabilityChecker.a aVar11;
        CapabilityChecker.a aVar12;
        CapabilityChecker.a aVar13;
        SortedMap sortedMap4;
        CapabilityChecker.a aVar14;
        SortedMap sortedMap5;
        CapabilityChecker.a aVar15;
        SortedMap sortedMap6;
        boolean z4;
        ResultTask resultTask6;
        CapabilityChecker.a aVar16;
        List<File> list6;
        boolean z5;
        CapabilityChecker.a aVar17;
        CapabilityChecker.a aVar18;
        CapabilityChecker.a aVar19;
        CapabilityChecker.a aVar20;
        CapabilityChecker.a aVar21;
        SortedMap sortedMap7;
        SortedMap sortedMap8;
        File file;
        File file2;
        List list7;
        List list8;
        CapabilityChecker.a aVar22;
        CapabilityChecker.a aVar23;
        List list9;
        z = this.f20120a.t;
        if (z) {
            return;
        }
        z2 = this.f20120a.y;
        if (z2) {
            list9 = this.f20120a.A;
            list9.clear();
            this.f20120a.u = true;
        }
        list = this.f20120a.A;
        if (list.isEmpty()) {
            z5 = this.f20120a.u;
            if (!z5) {
                aVar17 = this.f20120a.D;
                int i7 = aVar17.f20029e;
                aVar18 = this.f20120a.D;
                int i8 = aVar18.f20029e;
                aVar19 = this.f20120a.D;
                if (i8 >= aVar19.f20027c) {
                    aVar22 = this.f20120a.D;
                    aVar23 = this.f20120a.D;
                    aVar22.f20032h = aVar23.f20027c;
                } else {
                    aVar20 = this.f20120a.D;
                    int i9 = aVar20.f20032h;
                    aVar21 = this.f20120a.D;
                    if (i9 < aVar21.f20027c) {
                        sortedMap7 = this.f20120a.q;
                        Iterator it = sortedMap7.entrySet().iterator();
                        while (it.hasNext()) {
                            int intValue = ((Integer) ((Map.Entry) it.next()).getKey()).intValue();
                            if (intValue > i7) {
                                sortedMap8 = this.f20120a.q;
                                Iterator it2 = sortedMap8.entrySet().iterator();
                                while (it2.hasNext()) {
                                    int intValue2 = ((Integer) ((Map.Entry) it2.next()).getKey()).intValue();
                                    if (intValue2 <= i7) {
                                        file = this.f20120a.C;
                                        File file3 = new File(file, "tc_" + intValue + "p_to_" + intValue2 + "p.mp4");
                                        file2 = this.f20120a.C;
                                        StringBuilder sb = new StringBuilder();
                                        sb.append(com.umeng.commonsdk.proguard.e.ar);
                                        sb.append(intValue);
                                        sb.append("p.mp4");
                                        File file4 = new File(file2, sb.toString());
                                        list7 = this.f20120a.p;
                                        list7.add(file3);
                                        P a2 = P.a(new CapabilityChecker.c("Transcode " + intValue + "p to " + intValue2 + "p", CapabilityChecker.TagType.Transcode, intValue, intValue2, 1), SemanticAnnotations.SemanticType.ST_AVOCADO_ID_VALUE, file3.getAbsolutePath(), (intValue2 * 16) / 9, intValue2, 30, -1, null, null);
                                        a2.a(file4.getAbsolutePath(), 150);
                                        list8 = this.f20120a.A;
                                        list8.add(a2);
                                    }
                                }
                            }
                        }
                    }
                }
                this.f20120a.u = true;
            }
        }
        list2 = this.f20120a.A;
        if (list2.isEmpty()) {
            resultTask5 = this.f20120a.l;
            i5 = this.f20120a.B;
            i6 = this.f20120a.B;
            resultTask5.setProgress(i5, i6);
            long nanoTime = System.nanoTime();
            j = this.f20120a.i;
            long j2 = nanoTime - j;
            long j3 = j2 / 1000000000;
            long j4 = j3 / 60;
            bVar2 = this.f20120a.z;
            bVar2.log("Test Suite Completed;  Elapsed time: " + j4 + "m" + (j3 - (60 * j4)) + com.umeng.commonsdk.proguard.e.ap);
            bVar3 = this.f20120a.z;
            sortedMap = this.f20120a.q;
            b2 = CapabilityChecker.b("Export and Transcode:", (SortedMap<Integer, Integer>) sortedMap);
            bVar3.log(b2);
            bVar4 = this.f20120a.z;
            sortedMap2 = this.f20120a.s;
            b3 = CapabilityChecker.b("Preview (partial drop):", (SortedMap<Integer, Integer>) sortedMap2);
            bVar4.log(b3);
            bVar5 = this.f20120a.z;
            sortedMap3 = this.f20120a.r;
            b4 = CapabilityChecker.b("Perfect Preview (no drop):", (SortedMap<Integer, Integer>) sortedMap3);
            bVar5.log(b4);
            bVar6 = this.f20120a.z;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("MaxCodecMemSize(MCMS)=");
            aVar = this.f20120a.D;
            sb2.append(aVar.d());
            bVar6.log(sb2.toString());
            bVar7 = this.f20120a.z;
            StringBuilder sb3 = new StringBuilder();
            sb3.append("MaxPreviewMemSize(MPMS)=");
            aVar2 = this.f20120a.D;
            sb3.append(aVar2.f());
            bVar7.log(sb3.toString());
            bVar8 = this.f20120a.z;
            StringBuilder sb4 = new StringBuilder();
            sb4.append("MaxCodecCount=");
            aVar3 = this.f20120a.D;
            sb4.append(aVar3.p());
            bVar8.log(sb4.toString());
            bVar9 = this.f20120a.z;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("MaxCodecCountAtImportRes=");
            aVar4 = this.f20120a.D;
            sb5.append(aVar4.j());
            bVar9.log(sb5.toString());
            bVar10 = this.f20120a.z;
            StringBuilder sb6 = new StringBuilder();
            sb6.append("MaxImportSizeOverlap=");
            aVar5 = this.f20120a.D;
            sb6.append(aVar5.n());
            bVar10.log(sb6.toString());
            bVar11 = this.f20120a.z;
            StringBuilder sb7 = new StringBuilder();
            sb7.append("MaxImportSizeNoOverlap=");
            aVar6 = this.f20120a.D;
            sb7.append(aVar6.g());
            bVar11.log(sb7.toString());
            bVar12 = this.f20120a.z;
            StringBuilder sb8 = new StringBuilder();
            sb8.append("MaxExportSize=");
            aVar7 = this.f20120a.D;
            sb8.append(aVar7.a());
            bVar12.log(sb8.toString());
            bVar13 = this.f20120a.z;
            StringBuilder sb9 = new StringBuilder();
            sb9.append("MaxTranscodeSize=");
            aVar8 = this.f20120a.D;
            sb9.append(aVar8.l());
            bVar13.log(sb9.toString());
            bVar14 = this.f20120a.z;
            StringBuilder sb10 = new StringBuilder();
            aVar9 = this.f20120a.D;
            sb10.append(aVar9.b() ? "SUPPORTED-DEVICE" : "NOT-SUPPORTED-DEVICE!");
            sb10.append(" ");
            aVar10 = this.f20120a.D;
            sb10.append(aVar10.c() ? "HIGH-PROFILE" : "BASELINE-PROFILE");
            sb10.append(" ");
            aVar11 = this.f20120a.D;
            sb10.append(aVar11.r() ? "OK-OVERLAP-TRANSITION" : "NO-OVERLAP-TRANSITION");
            bVar14.log(sb10.toString());
            this.f20120a.k = true;
            aVar12 = this.f20120a.D;
            aVar12.j = (int) (j2 / 1000000);
            aVar13 = this.f20120a.D;
            sortedMap4 = this.f20120a.q;
            aVar13.p = sortedMap4;
            aVar14 = this.f20120a.D;
            sortedMap5 = this.f20120a.s;
            aVar14.q = sortedMap5;
            aVar15 = this.f20120a.D;
            sortedMap6 = this.f20120a.r;
            aVar15.r = sortedMap6;
            z4 = this.f20120a.w;
            if (!z4) {
                list6 = this.f20120a.p;
                for (File file5 : list6) {
                    if (file5.exists()) {
                        file5.delete();
                    }
                }
            }
            resultTask6 = this.f20120a.l;
            aVar16 = this.f20120a.D;
            resultTask6.sendResult(aVar16);
            return;
        }
        z3 = this.f20120a.u;
        if (z3) {
            resultTask4 = this.f20120a.l;
            i3 = this.f20120a.B;
            i4 = this.f20120a.B;
            resultTask4.setProgress(i3, i4);
        } else {
            resultTask = this.f20120a.l;
            i = this.f20120a.B;
            list3 = this.f20120a.A;
            int size = i - list3.size();
            i2 = this.f20120a.B;
            resultTask.setProgress(size, i2);
        }
        list4 = this.f20120a.A;
        P p = (P) list4.remove(0);
        weakReference = this.f20120a.o;
        Activity activity = (Activity) weakReference.get();
        if (activity == null || activity.isFinishing()) {
            list5 = this.f20120a.A;
            list5.clear();
            Crashlytics.log("[CapabilityChecker] invalid activity");
            resultTask2 = this.f20120a.l;
            resultTask2.sendFailure(Task.makeTaskError("Invalid activity"));
            return;
        }
        this.f20120a.m = p;
        bVar = this.f20120a.z;
        bVar.log("[" + ((CapabilityChecker.c) p.b()).f20033a + "]");
        long nanoTime2 = System.nanoTime();
        CapabilityChecker capabilityChecker = this.f20120a;
        interfaceC1716d = capabilityChecker.n;
        capabilityChecker.x = p.a(interfaceC1716d, activity);
        resultTask3 = this.f20120a.x;
        resultTask3.onResultAvailable(new s(this, nanoTime2)).onProgress((Task.OnProgressListener) new r(this));
    }
}
