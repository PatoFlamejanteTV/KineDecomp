package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import java.util.ArrayList;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.google.android.gms.common.api.internal.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0808l extends AbstractRunnableC0812p {

    /* renamed from: b, reason: collision with root package name */
    private final ArrayList<Api.Client> f10843b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zaak f10844c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0808l(zaak zaakVar, ArrayList<Api.Client> arrayList) {
        super(zaakVar, null);
        this.f10844c = zaakVar;
        this.f10843b = arrayList;
    }

    @Override // com.google.android.gms.common.api.internal.AbstractRunnableC0812p
    public final void b() {
        zabe zabeVar;
        Set<Scope> g2;
        IAccountAccessor iAccountAccessor;
        zabe zabeVar2;
        zabeVar = this.f10844c.f10872a;
        zaaw zaawVar = zabeVar.n;
        g2 = this.f10844c.g();
        zaawVar.q = g2;
        ArrayList<Api.Client> arrayList = this.f10843b;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Api.Client client = arrayList.get(i);
            i++;
            iAccountAccessor = this.f10844c.o;
            zabeVar2 = this.f10844c.f10872a;
            client.getRemoteService(iAccountAccessor, zabeVar2.n.q);
        }
    }
}
