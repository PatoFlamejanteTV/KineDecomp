package com.nexstreaming.kinemaster.ui.store.model;

import android.content.Context;
import com.nexstreaming.app.general.util.J;
import com.nexstreaming.kinemaster.network.InterfaceC1821j;
import com.nextreaming.nexeditorui.KineMasterApplication;

/* compiled from: AssetAdapterItem.java */
/* loaded from: classes2.dex */
public class c extends com.nexstreaming.kinemaster.ui.store.model.a {

    /* renamed from: b, reason: collision with root package name */
    private final InterfaceC1821j f23651b;

    /* renamed from: c, reason: collision with root package name */
    private Context f23652c;

    /* compiled from: AssetAdapterItem.java */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final InterfaceC1821j f23653a;

        /* renamed from: b, reason: collision with root package name */
        private int f23654b;

        /* renamed from: c, reason: collision with root package name */
        private Context f23655c;

        public a(Context context, InterfaceC1821j interfaceC1821j) {
            this.f23653a = interfaceC1821j;
            this.f23655c = context;
        }

        public a a(int i) {
            this.f23654b = i;
            return this;
        }

        public c a() {
            return new c(this.f23655c, this.f23653a, this.f23654b);
        }
    }

    c(Context context, InterfaceC1821j interfaceC1821j, int i) {
        super(i);
        this.f23651b = interfaceC1821j;
        this.f23652c = context;
    }

    public InterfaceC1821j b() {
        return this.f23651b;
    }

    public String c() {
        return J.a(KineMasterApplication.f24056d, this.f23651b.j());
    }

    public String d() {
        if (this.f23651b == null) {
            return "";
        }
        int a2 = a();
        if (a2 != 0) {
            if (a2 != 1) {
                return this.f23651b.e();
            }
            return this.f23651b.e();
        }
        return this.f23651b.p() + "_cs";
    }
}
