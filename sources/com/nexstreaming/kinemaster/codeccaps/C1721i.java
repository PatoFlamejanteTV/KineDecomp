package com.nexstreaming.kinemaster.codeccaps;

import com.nexstreaming.kinemaster.codeccaps.CapabilityChecker;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: CapabilityCheckPopup.java */
/* renamed from: com.nexstreaming.kinemaster.codeccaps.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1721i implements CapabilityChecker.b {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1728p f20100a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1721i(C1728p c1728p) {
        this.f20100a = c1728p;
    }

    @Override // com.nexstreaming.kinemaster.codeccaps.CapabilityChecker.b
    public void log(String str) {
        StringBuilder sb;
        String[] strArr;
        String[] strArr2;
        String[] strArr3;
        String[] strArr4;
        String[] strArr5;
        com.nexstreaming.kinemaster.ui.a.r rVar;
        String[] strArr6;
        sb = this.f20100a.f20116e;
        sb.append(str + "\n");
        strArr = this.f20100a.f20115d;
        strArr2 = this.f20100a.f20115d;
        strArr3 = this.f20100a.f20115d;
        System.arraycopy(strArr, 1, strArr2, 0, strArr3.length - 1);
        strArr4 = this.f20100a.f20115d;
        strArr5 = this.f20100a.f20115d;
        strArr4[strArr5.length - 1] = str;
        rVar = this.f20100a.f20113b;
        strArr6 = this.f20100a.f20115d;
        rVar.d(com.nexstreaming.app.general.util.J.a(strArr6, "\n"));
    }
}
