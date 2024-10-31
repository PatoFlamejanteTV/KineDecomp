package kotlin.text;

import kotlin.jvm.internal.FunctionReference;

/* compiled from: Regex.kt */
/* loaded from: classes3.dex */
final /* synthetic */ class Regex$findAll$2 extends FunctionReference implements kotlin.jvm.a.b<j, j> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getName() {
        return "next";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final kotlin.reflect.e getOwner() {
        return kotlin.jvm.internal.j.a(j.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "next()Lkotlin/text/MatchResult;";
    }

    @Override // kotlin.jvm.a.b
    public final j invoke(j jVar) {
        kotlin.jvm.internal.h.b(jVar, "p1");
        return jVar.next();
    }
}
