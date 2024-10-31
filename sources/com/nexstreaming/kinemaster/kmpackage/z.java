package com.nexstreaming.kinemaster.kmpackage;

import android.util.SparseArray;
import org.keyczar.interfaces.KeyczarReader;

/* compiled from: KMKeystore.java */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a, reason: collision with root package name */
    static SparseArray<z> f3469a = new SparseArray<>();
    private final KeyczarReader b;

    private z(KeyczarReader keyczarReader) {
        this.b = keyczarReader;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyczarReader a() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static z a(int i) {
        z zVar = f3469a.get(i);
        if (zVar == null && (zVar = b(i)) != null) {
            f3469a.put(i, zVar);
        }
        return zVar;
    }

    private static z b(int i) {
        switch (i) {
            case 1:
                return new z(c());
            case 2:
                return new z(b());
            default:
                return null;
        }
    }

    private static KeyczarReader b() {
        return new aa();
    }

    private static KeyczarReader c() {
        return new ab();
    }
}
