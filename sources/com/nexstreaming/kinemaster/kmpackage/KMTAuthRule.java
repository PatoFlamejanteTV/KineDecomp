package com.nexstreaming.kinemaster.kmpackage;

/* loaded from: classes.dex */
class KMTAuthRule {

    /* renamed from: a, reason: collision with root package name */
    private final RuleType f3423a;
    private final MatchType b;
    private final String c;

    /* loaded from: classes.dex */
    protected enum MatchType {
        ALL,
        DEVICE
    }

    /* loaded from: classes.dex */
    protected enum RuleType {
        ALLOW,
        DENY
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public KMTAuthRule(ae aeVar) throws KineMasterPackageException {
        this.f3423a = (RuleType) an.a(aeVar.a("type"), RuleType.values());
        this.b = (MatchType) an.a(aeVar.a("match"), MatchType.values());
        if (this.f3423a == null || this.b == null) {
            throw new KineMasterPackageException("malformed authorization rule");
        }
        this.c = aeVar.a("value");
    }
}
