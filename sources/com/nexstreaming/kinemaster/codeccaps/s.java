package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;
import com.nexstreaming.kinemaster.codeccaps.P;
import com.nexstreaming.kinemaster.editorwrapper.H264Profile;
import com.nexstreaming.kinemaster.mediainfo.MediaInfo;
import com.nextreaming.nexvideoeditor.NexEditor;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

/* compiled from: CapabilityChecker.java */
/* loaded from: classes.dex */
class s implements ResultTask.OnResultAvailableListener<P.b> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ long f20118a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ t f20119b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(t tVar, long j) {
        this.f20119b = tVar;
        this.f20118a = j;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<P.b> resultTask, Task.Event event, P.b bVar) {
        CapabilityChecker.a aVar;
        CapabilityChecker.b bVar2;
        char c2;
        List<P> list;
        SortedMap sortedMap;
        SortedMap sortedMap2;
        CapabilityChecker.a aVar2;
        CapabilityChecker.a aVar3;
        SortedMap sortedMap3;
        SortedMap sortedMap4;
        SortedMap sortedMap5;
        SortedMap sortedMap6;
        List<P> list2;
        List<P> list3;
        List list4;
        List<P> list5;
        int i;
        CapabilityChecker.a aVar4;
        CapabilityChecker.a aVar5;
        CapabilityChecker.a aVar6;
        CapabilityChecker.a aVar7;
        CapabilityChecker.a aVar8;
        CapabilityChecker.a aVar9;
        CapabilityChecker.b bVar3;
        CapabilityChecker.a aVar10;
        CapabilityChecker.a aVar11;
        CapabilityChecker.a aVar12;
        CapabilityChecker.a aVar13;
        CapabilityChecker.a aVar14;
        CapabilityChecker.a aVar15;
        CapabilityChecker.a aVar16;
        CapabilityChecker.a aVar17;
        CapabilityChecker.a aVar18;
        CapabilityChecker.a aVar19;
        CapabilityChecker.a aVar20;
        CapabilityChecker.a aVar21;
        CapabilityChecker.a aVar22;
        CapabilityChecker.a aVar23;
        CapabilityChecker.a aVar24;
        CapabilityChecker.a aVar25;
        CapabilityChecker.a aVar26;
        CapabilityChecker.a aVar27;
        CapabilityChecker.a aVar28;
        CapabilityChecker.a aVar29;
        CapabilityChecker.b bVar4;
        CapabilityChecker.b bVar5;
        CapabilityChecker.b bVar6;
        CapabilityChecker.b bVar7;
        CapabilityChecker.b bVar8;
        CapabilityChecker.b bVar9;
        CapabilityChecker.b bVar10;
        CapabilityChecker.b bVar11;
        CapabilityChecker.b bVar12;
        CapabilityChecker.a aVar30;
        CapabilityChecker.a aVar31;
        CapabilityChecker.a aVar32;
        CapabilityChecker.a aVar33;
        CapabilityChecker.a aVar34;
        aVar = this.f20119b.f20120a.D;
        aVar.o.add(bVar);
        long nanoTime = System.nanoTime() - this.f20118a;
        CapabilityChecker.c cVar = (CapabilityChecker.c) bVar.k();
        MediaInfo g2 = bVar.g();
        int N = g2 != null ? g2.N() : 0;
        if (bVar.m()) {
            if (N == 100) {
                aVar34 = this.f20119b.f20120a.D;
                aVar34.l = true;
            }
            i = CapabilityChecker.f20017a;
            if (i == 0) {
                aVar32 = this.f20119b.f20120a.D;
                aVar33 = this.f20119b.f20120a.D;
                aVar32.f20025a = Math.max(aVar33.f20025a, bVar.a());
            } else if (bVar.b() <= 50) {
                aVar4 = this.f20119b.f20120a.D;
                aVar5 = this.f20119b.f20120a.D;
                aVar4.f20025a = Math.max(aVar5.f20025a, bVar.a());
            }
            aVar6 = this.f20119b.f20120a.D;
            aVar7 = this.f20119b.f20120a.D;
            aVar6.f20027c = Math.max(aVar7.f20027c, cVar.f20035c);
            aVar8 = this.f20119b.f20120a.D;
            aVar9 = this.f20119b.f20120a.D;
            aVar8.f20028d = Math.min(aVar9.f20028d, cVar.f20035c);
            if (cVar.f20036d > 0) {
                aVar30 = this.f20119b.f20120a.D;
                aVar31 = this.f20119b.f20120a.D;
                aVar30.f20028d = Math.min(aVar31.f20028d, cVar.f20036d);
            }
            if (bVar.b() > 50) {
                bVar12 = this.f20119b.f20120a.z;
                bVar12.log("    FAIL (EXCESSIVE_DROP_FRAMES)");
                this.f20119b.f20120a.v = 200L;
                c2 = 2;
            } else if (bVar.b() <= 1 || cVar.f20034b == CapabilityChecker.TagType.Preview) {
                bVar3 = this.f20119b.f20120a.z;
                bVar3.log("    PASS");
                this.f20119b.f20120a.v = 150L;
                if (cVar.f20034b == CapabilityChecker.TagType.Transcode) {
                    aVar28 = this.f20119b.f20120a.D;
                    aVar29 = this.f20119b.f20120a.D;
                    aVar28.f20032h = Math.max(aVar29.f20032h, cVar.f20035c);
                }
                if (cVar.f20037e >= 2) {
                    aVar23 = this.f20119b.f20120a.D;
                    aVar23.m = true;
                    aVar24 = this.f20119b.f20120a.D;
                    aVar25 = this.f20119b.f20120a.D;
                    aVar24.f20032h = Math.max(aVar25.f20032h, cVar.f20035c);
                    aVar26 = this.f20119b.f20120a.D;
                    aVar27 = this.f20119b.f20120a.D;
                    aVar26.f20030f = Math.max(aVar27.f20030f, cVar.f20035c);
                }
                if (cVar.f20037e >= 3) {
                    aVar15 = this.f20119b.f20120a.D;
                    int i2 = aVar15.f20029e;
                    aVar16 = this.f20119b.f20120a.D;
                    aVar16.n = true;
                    aVar17 = this.f20119b.f20120a.D;
                    aVar18 = this.f20119b.f20120a.D;
                    aVar17.f20029e = Math.max(aVar18.f20029e, cVar.f20035c);
                    aVar19 = this.f20119b.f20120a.D;
                    aVar20 = this.f20119b.f20120a.D;
                    aVar19.f20031g = Math.max(aVar20.f20031g, cVar.f20035c);
                    aVar21 = this.f20119b.f20120a.D;
                    if (i2 != aVar21.f20029e) {
                        aVar22 = this.f20119b.f20120a.D;
                        aVar22.k = 0;
                    }
                }
                aVar10 = this.f20119b.f20120a.D;
                if (aVar10.f20029e == cVar.f20035c) {
                    aVar13 = this.f20119b.f20120a.D;
                    aVar14 = this.f20119b.f20120a.D;
                    aVar13.k = Math.max(aVar14.k, cVar.f20037e);
                }
                aVar11 = this.f20119b.f20120a.D;
                aVar12 = this.f20119b.f20120a.D;
                aVar11.i = Math.max(aVar12.i, cVar.f20037e);
                c2 = 1;
            } else {
                bVar4 = this.f20119b.f20120a.z;
                bVar4.log("    FAIL (DROP_FRAMES_IN_EXPORT)");
                this.f20119b.f20120a.v = 500L;
                c2 = 3;
            }
            bVar5 = this.f20119b.f20120a.z;
            bVar5.log("      profile=" + N);
            bVar6 = this.f20119b.f20120a.z;
            bVar6.log("      execTime=" + (nanoTime / 1000000) + "ms");
            bVar7 = this.f20119b.f20120a.z;
            bVar7.log("      totalFrames=" + bVar.l());
            bVar8 = this.f20119b.f20120a.z;
            bVar8.log("      droppedFrames=" + bVar.c());
            bVar9 = this.f20119b.f20120a.z;
            bVar9.log("      frameWaitTimeout=" + NexEditor.PerformanceCounter.FRAME_WAIT_TIMEOUT.get(bVar.i()));
            bVar10 = this.f20119b.f20120a.z;
            bVar10.log("      renderCB=" + bVar.j());
            bVar11 = this.f20119b.f20120a.z;
            bVar11.log("      dropRate=" + bVar.b());
        } else {
            this.f20119b.f20120a.v = 1200L;
            bVar2 = this.f20119b.f20120a.z;
            bVar2.log("    FAIL (" + String.valueOf(bVar.e()) + ") execution_time=" + (nanoTime / 1000000) + "ms");
            c2 = 3;
        }
        ArrayList arrayList = null;
        CapabilityChecker.TagType tagType = cVar.f20034b;
        if (tagType == CapabilityChecker.TagType.Transcode) {
            list5 = this.f20119b.f20120a.A;
            for (P p : list5) {
                CapabilityChecker.c cVar2 = (CapabilityChecker.c) p.b();
                if (cVar.f20034b == CapabilityChecker.TagType.Transcode) {
                    if (c2 == 1) {
                        if (cVar2.f20035c == cVar.f20035c && cVar2.f20036d <= cVar.f20036d) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(p);
                        }
                    } else if (cVar2.f20035c == cVar.f20035c && cVar2.f20036d >= cVar.f20036d) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(p);
                    }
                }
            }
        } else if (tagType != CapabilityChecker.TagType.ExportOnly) {
            if (c2 != 3 && (tagType == CapabilityChecker.TagType.Preview || bVar.b() <= 1)) {
                sortedMap = this.f20119b.f20120a.q;
                Integer num = (Integer) sortedMap.get(Integer.valueOf(cVar.f20035c));
                if (num == null || num.intValue() < cVar.f20037e) {
                    sortedMap2 = this.f20119b.f20120a.q;
                    sortedMap2.put(Integer.valueOf(cVar.f20035c), Integer.valueOf(cVar.f20037e));
                }
                if (cVar.f20034b == CapabilityChecker.TagType.Preview && bVar.b() <= 50) {
                    aVar2 = this.f20119b.f20120a.D;
                    aVar3 = this.f20119b.f20120a.D;
                    aVar2.f20026b = Math.max(aVar3.f20026b, bVar.a());
                    sortedMap3 = this.f20119b.f20120a.s;
                    Integer num2 = (Integer) sortedMap3.get(Integer.valueOf(cVar.f20035c));
                    if (num2 == null || num2.intValue() < cVar.f20037e) {
                        sortedMap4 = this.f20119b.f20120a.s;
                        sortedMap4.put(Integer.valueOf(cVar.f20035c), Integer.valueOf(cVar.f20037e));
                    }
                    if (bVar.b() <= 5) {
                        sortedMap5 = this.f20119b.f20120a.r;
                        Integer num3 = (Integer) sortedMap5.get(Integer.valueOf(cVar.f20035c));
                        if (num3 == null || num3.intValue() < cVar.f20037e) {
                            sortedMap6 = this.f20119b.f20120a.r;
                            sortedMap6.put(Integer.valueOf(cVar.f20035c), Integer.valueOf(cVar.f20037e));
                        }
                    }
                }
            }
            list = this.f20119b.f20120a.A;
            for (P p2 : list) {
                CapabilityChecker.c cVar3 = (CapabilityChecker.c) p2.b();
                if (cVar.f20034b != CapabilityChecker.TagType.ExportOnly) {
                    if (c2 == 1) {
                        if (cVar3.f20035c == cVar.f20035c && cVar3.f20037e < cVar.f20037e && cVar3.f20036d <= 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(p2);
                        } else if (cVar3.f20035c < cVar.f20035c && cVar3.f20036d <= 0 && cVar.f20037e >= 10) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(p2);
                        }
                    } else if (c2 == 3 || c2 == 2) {
                        if (cVar3.f20035c == cVar.f20035c && cVar3.f20037e >= cVar.f20037e && cVar3.f20036d <= 0) {
                            if (arrayList == null) {
                                arrayList = new ArrayList();
                            }
                            arrayList.add(p2);
                        }
                    }
                }
            }
        } else if (c2 == 1) {
            list3 = this.f20119b.f20120a.A;
            for (P p3 : list3) {
                CapabilityChecker.c cVar4 = (CapabilityChecker.c) p3.b();
                if (cVar4.f20035c == cVar.f20035c && cVar4.f20034b == CapabilityChecker.TagType.ExportOnly) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(p3);
                }
            }
        } else {
            list2 = this.f20119b.f20120a.A;
            for (P p4 : list2) {
                CapabilityChecker.c cVar5 = (CapabilityChecker.c) p4.b();
                H264Profile h264Profile = cVar.f20038f;
                if (h264Profile != H264Profile.AVCProfileHigh || h264Profile == cVar5.f20038f) {
                    if (cVar5.f20035c != cVar.f20035c || cVar5.f20036d > 0) {
                        int i3 = cVar5.f20035c;
                        int i4 = cVar.f20035c;
                        if (i3 > i4) {
                            if (i4 != 720 && i4 != 1080) {
                            }
                        }
                    }
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(p4);
                }
            }
        }
        if (arrayList != null) {
            list4 = this.f20119b.f20120a.A;
            list4.removeAll(arrayList);
        }
        this.f20119b.f20120a.d();
    }
}
