package com.umeng.commonsdk.proguard;

import com.umeng.commonsdk.proguard.ac;

/* compiled from: TProtocolUtil.java */
/* loaded from: classes3.dex */
public class al {

    /* renamed from: a, reason: collision with root package name */
    private static int f26195a = Integer.MAX_VALUE;

    public static void a(int i) {
        f26195a = i;
    }

    public static void a(ai aiVar, byte b2) throws p {
        a(aiVar, b2, f26195a);
    }

    public static void a(ai aiVar, byte b2, int i) throws p {
        if (i > 0) {
            int i2 = 0;
            switch (b2) {
                case 2:
                    aiVar.t();
                    return;
                case 3:
                    aiVar.u();
                    return;
                case 4:
                    aiVar.y();
                    return;
                case 5:
                case 7:
                case 9:
                default:
                    return;
                case 6:
                    aiVar.v();
                    return;
                case 8:
                    aiVar.w();
                    return;
                case 10:
                    aiVar.x();
                    return;
                case 11:
                    aiVar.A();
                    return;
                case 12:
                    aiVar.j();
                    while (true) {
                        byte b3 = aiVar.l().f26172b;
                        if (b3 == 0) {
                            aiVar.k();
                            return;
                        } else {
                            a(aiVar, b3, i - 1);
                            aiVar.m();
                        }
                    }
                case 13:
                    af n = aiVar.n();
                    while (i2 < n.f26178c) {
                        int i3 = i - 1;
                        a(aiVar, n.f26176a, i3);
                        a(aiVar, n.f26177b, i3);
                        i2++;
                    }
                    aiVar.o();
                    return;
                case 14:
                    am r = aiVar.r();
                    while (i2 < r.f26197b) {
                        a(aiVar, r.f26196a, i - 1);
                        i2++;
                    }
                    aiVar.s();
                    return;
                case 15:
                    ae p = aiVar.p();
                    while (i2 < p.f26175b) {
                        a(aiVar, p.f26174a, i - 1);
                        i2++;
                    }
                    aiVar.q();
                    return;
            }
        } else {
            throw new p("Maximum skip depth exceeded");
        }
    }

    public static ak a(byte[] bArr, ak akVar) {
        if (bArr[0] > 16) {
            return new ac.a();
        }
        return (bArr.length <= 1 || (bArr[1] & 128) == 0) ? akVar : new ac.a();
    }
}
