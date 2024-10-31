package com.nexstreaming.kinemaster.kmpackage;

import com.nexstreaming.kinemaster.kmpackage.KMTServerIndex;
import java.net.URI;

/* compiled from: KMTPackagedItem.java */
/* loaded from: classes.dex */
public abstract class am {

    /* renamed from: a, reason: collision with root package name */
    private ai f3438a;
    private String b;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(String str, ae aeVar, int i) throws KineMasterPackageException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void a(String str, String str2, int i) throws KineMasterPackageException;

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract KMTServerIndex.Item g();

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract URI h();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(ai aiVar) {
        if (this.f3438a != null) {
            throw new RuntimeException("Package already set");
        }
        this.f3438a = aiVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j() {
        this.f3438a = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ai k() {
        return this.f3438a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        this.b = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String l() {
        return this.b;
    }
}
