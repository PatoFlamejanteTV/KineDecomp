package org.koin.android.ext.koin;

import android.app.Application;
import android.content.Context;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import org.koin.core.definition.Kind;
import org.koin.core.definition.c;
import org.koin.core.logger.Level;

/* compiled from: KoinExt.kt */
/* loaded from: classes3.dex */
public final class a {
    public static /* synthetic */ org.koin.core.b a(org.koin.core.b bVar, Level level, int i, Object obj) {
        if ((i & 1) != 0) {
            level = Level.INFO;
        }
        a(bVar, level);
        return bVar;
    }

    public static final org.koin.core.b a(org.koin.core.b bVar, Level level) {
        h.b(bVar, "$this$androidLogger");
        h.b(level, "level");
        org.koin.core.b.f29345b.a(new g.a.a.b.b(level));
        return bVar;
    }

    public static final org.koin.core.b a(org.koin.core.b bVar, final Context context) {
        h.b(bVar, "$this$androidContext");
        h.b(context, "androidContext");
        if (org.koin.core.b.f29345b.b().a(Level.INFO)) {
            org.koin.core.b.f29345b.b().c("[init] declare Android Context");
        }
        org.koin.core.f.a b2 = bVar.c().b().b();
        c cVar = c.f29370a;
        kotlin.jvm.a.c<org.koin.core.scope.a, org.koin.core.d.a, Context> cVar2 = new kotlin.jvm.a.c<org.koin.core.scope.a, org.koin.core.d.a, Context>() { // from class: org.koin.android.ext.koin.KoinExtKt$androidContext$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.a.c
            public final Context invoke(org.koin.core.scope.a aVar, org.koin.core.d.a aVar2) {
                h.b(aVar, "$receiver");
                h.b(aVar2, "it");
                return context;
            }
        };
        Kind kind = Kind.Single;
        org.koin.core.definition.b<?> bVar2 = new org.koin.core.definition.b<>(null, null, j.a(Context.class));
        bVar2.a(cVar2);
        bVar2.a(kind);
        b2.a(bVar2);
        if (context instanceof Application) {
            org.koin.core.f.a b3 = bVar.c().b().b();
            c cVar3 = c.f29370a;
            kotlin.jvm.a.c<org.koin.core.scope.a, org.koin.core.d.a, Application> cVar4 = new kotlin.jvm.a.c<org.koin.core.scope.a, org.koin.core.d.a, Application>() { // from class: org.koin.android.ext.koin.KoinExtKt$androidContext$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.a.c
                public final Application invoke(org.koin.core.scope.a aVar, org.koin.core.d.a aVar2) {
                    h.b(aVar, "$receiver");
                    h.b(aVar2, "it");
                    return (Application) context;
                }
            };
            Kind kind2 = Kind.Single;
            org.koin.core.definition.b<?> bVar3 = new org.koin.core.definition.b<>(null, null, j.a(Application.class));
            bVar3.a(cVar4);
            bVar3.a(kind2);
            b3.a(bVar3);
        }
        return bVar;
    }
}
