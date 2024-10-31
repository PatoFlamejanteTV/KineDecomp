package com.nextreaming.nexeditorui.di;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.nexstreaming.app.general.iab.IABManager;
import com.nexstreaming.app.general.service.download.i;
import com.nexstreaming.app.general.util.N;
import com.nexstreaming.kinemaster.network.AssetEnv;
import com.nexstreaming.kinemaster.network.InterfaceC1820i;
import com.nexstreaming.kinemaster.network.VolleyNetworkService;
import kotlin.jvm.a.b;
import kotlin.jvm.a.c;
import kotlin.jvm.internal.h;
import kotlin.jvm.internal.j;
import kotlin.k;
import org.koin.core.definition.Kind;
import org.koin.core.definition.d;

/* compiled from: Modules.kt */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    private static final org.koin.core.c.a f24234a = g.a.b.a.a(false, false, new b<org.koin.core.c.a, k>() { // from class: com.nextreaming.nexeditorui.di.ModulesKt$appModule$1
        @Override // kotlin.jvm.a.b
        public /* bridge */ /* synthetic */ k invoke(org.koin.core.c.a aVar) {
            invoke2(aVar);
            return k.f28545a;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(org.koin.core.c.a aVar) {
            h.b(aVar, "$receiver");
            AnonymousClass1 anonymousClass1 = new c<org.koin.core.scope.a, org.koin.core.d.a, InterfaceC1820i>() { // from class: com.nextreaming.nexeditorui.di.ModulesKt$appModule$1.1
                @Override // kotlin.jvm.a.c
                public final InterfaceC1820i invoke(org.koin.core.scope.a aVar2, org.koin.core.d.a aVar3) {
                    AssetEnv assetEnv;
                    h.b(aVar2, "$receiver");
                    h.b(aVar3, "it");
                    SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(org.koin.android.ext.koin.b.a(aVar2));
                    String string = defaultSharedPreferences.getString("asms_edition", "Android");
                    String string2 = defaultSharedPreferences.getString("asms_server_url", "https://api-kinemaster-assetstore.nexstreaming.com");
                    String string3 = defaultSharedPreferences.getString("asset_level", String.valueOf(5));
                    String string4 = defaultSharedPreferences.getString("asset_env", "production");
                    if (h.a((Object) string4, (Object) "draft")) {
                        assetEnv = AssetEnv.DRAFT;
                    } else {
                        assetEnv = h.a((Object) string4, (Object) "staging") ? AssetEnv.STAGING : AssetEnv.PRODUCTION;
                    }
                    VolleyNetworkService.a aVar4 = new VolleyNetworkService.a(org.koin.android.ext.koin.b.a(aVar2));
                    aVar4.a(N.b());
                    aVar4.c(string);
                    aVar4.b(string2);
                    aVar4.d(string3);
                    aVar4.e("ZmNjMTM4ZGIyODEwOWEzOTg5NzNlZmMyMzA0YjdhNjJmMWQ5MDVlYzo");
                    aVar4.a(assetEnv);
                    InterfaceC1820i a2 = aVar4.a();
                    h.a((Object) a2, "VolleyNetworkService.Bui…\n                .build()");
                    return a2;
                }
            };
            org.koin.core.definition.c cVar = org.koin.core.definition.c.f29370a;
            Kind kind = Kind.Single;
            org.koin.core.definition.b bVar = new org.koin.core.definition.b(null, null, j.a(InterfaceC1820i.class));
            bVar.a(anonymousClass1);
            bVar.a(kind);
            aVar.a(bVar, new d(false, false));
            AnonymousClass2 anonymousClass2 = new c<org.koin.core.scope.a, org.koin.core.d.a, i>() { // from class: com.nextreaming.nexeditorui.di.ModulesKt$appModule$1.2
                @Override // kotlin.jvm.a.c
                public final i invoke(org.koin.core.scope.a aVar2, org.koin.core.d.a aVar3) {
                    h.b(aVar2, "$receiver");
                    h.b(aVar3, "it");
                    return new i((Context) aVar2.a(j.a(Context.class), (org.koin.core.e.a) null, (kotlin.jvm.a.a<org.koin.core.d.a>) null));
                }
            };
            org.koin.core.definition.c cVar2 = org.koin.core.definition.c.f29370a;
            Kind kind2 = Kind.Factory;
            org.koin.core.definition.b bVar2 = new org.koin.core.definition.b(null, null, j.a(i.class));
            bVar2.a(anonymousClass2);
            bVar2.a(kind2);
            aVar.a(bVar2, new d(false, false, 1, null));
            AnonymousClass3 anonymousClass3 = new c<org.koin.core.scope.a, org.koin.core.d.a, IABManager>() { // from class: com.nextreaming.nexeditorui.di.ModulesKt$appModule$1.3
                @Override // kotlin.jvm.a.c
                public final IABManager invoke(org.koin.core.scope.a aVar2, org.koin.core.d.a aVar3) {
                    h.b(aVar2, "$receiver");
                    h.b(aVar3, "it");
                    return new IABManager(org.koin.android.ext.koin.b.a(aVar2));
                }
            };
            org.koin.core.definition.c cVar3 = org.koin.core.definition.c.f29370a;
            Kind kind3 = Kind.Single;
            org.koin.core.definition.b bVar3 = new org.koin.core.definition.b(null, null, j.a(IABManager.class));
            bVar3.a(anonymousClass3);
            bVar3.a(kind3);
            aVar.a(bVar3, new d(false, false));
        }
    }, 3, null);

    public static final org.koin.core.c.a a() {
        return f24234a;
    }
}
