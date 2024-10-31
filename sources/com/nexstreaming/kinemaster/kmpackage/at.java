package com.nexstreaming.kinemaster.kmpackage;

/* compiled from: TransitionEffect.java */
/* loaded from: classes.dex */
public class at extends b {

    /* renamed from: a, reason: collision with root package name */
    private int f3442a;
    private int b;
    private int c;
    private int d;

    public int m() {
        return this.f3442a;
    }

    public int n() {
        return Math.min((this.f3442a + this.b) / 2, 10000);
    }

    public int o() {
        return this.c;
    }

    public int p() {
        return this.d;
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.b, com.nexstreaming.kinemaster.kmpackage.am
    public void a(String str, ae aeVar, int i) throws KineMasterPackageException {
        super.a(str, aeVar, i);
        if (str.equalsIgnoreCase("effect")) {
            this.f3442a = an.a(aeVar.a("minduration"), 500);
            this.b = an.a(aeVar.a("maxduration"), 3000);
            this.c = an.a(aeVar.a("effectoffset"), 100);
            this.d = an.a(aeVar.a("videooverlap"), 100);
        }
    }

    @Override // com.nexstreaming.kinemaster.kmpackage.b, com.nexstreaming.kinemaster.kmpackage.am
    public void a(String str, String str2, int i) throws KineMasterPackageException {
        super.a(str, str2, i);
    }
}
