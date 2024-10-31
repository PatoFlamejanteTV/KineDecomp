package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
final class Fk extends Ek {
    public final long Qa;
    public final List<Gk> Ra;
    public final List<Fk> Sa;

    public Fk(int i, long j) {
        super(i);
        this.Qa = j;
        this.Ra = new ArrayList();
        this.Sa = new ArrayList();
    }

    public final void a(Gk gk) {
        this.Ra.add(gk);
    }

    public final Gk d(int i) {
        int size = this.Ra.size();
        for (int i2 = 0; i2 < size; i2++) {
            Gk gk = this.Ra.get(i2);
            if (gk.Pa == i) {
                return gk;
            }
        }
        return null;
    }

    public final Fk e(int i) {
        int size = this.Sa.size();
        for (int i2 = 0; i2 < size; i2++) {
            Fk fk = this.Sa.get(i2);
            if (fk.Pa == i) {
                return fk;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.Ek
    public final String toString() {
        String c2 = Ek.c(this.Pa);
        String arrays = Arrays.toString(this.Ra.toArray());
        String arrays2 = Arrays.toString(this.Sa.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(c2);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final void a(Fk fk) {
        this.Sa.add(fk);
    }
}
