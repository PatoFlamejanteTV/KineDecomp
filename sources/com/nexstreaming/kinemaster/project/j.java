package com.nexstreaming.kinemaster.project;

import java.text.Collator;
import java.util.Comparator;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectInfo.java */
/* loaded from: classes.dex */
public class j implements Comparator<f> {

    /* renamed from: a */
    final /* synthetic */ Collator f3626a;
    final /* synthetic */ h b;

    public j(h hVar, Collator collator) {
        this.b = hVar;
        this.f3626a = collator;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(f fVar, f fVar2) {
        String i;
        String i2;
        switch (this.b.f3624a) {
            case EDIT:
                return (fVar2.c() == null ? new Date(Long.MIN_VALUE) : fVar2.c()).compareTo(fVar.c() == null ? new Date(Long.MIN_VALUE) : fVar.c());
            case MAKE:
                return fVar2.b().compareTo(fVar.b());
            case NAME:
                Collator collator = this.f3626a;
                i = f.i(fVar.f());
                i2 = f.i(fVar2.f());
                return collator.compare(i, i2);
            default:
                return 0;
        }
    }
}
