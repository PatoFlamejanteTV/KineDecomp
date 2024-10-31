package com.nexstreaming.kinemaster.ui.assetbrowser;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import c.e.a.a.d;
import com.nexstreaming.app.general.iab.PurchaseType;
import java.util.List;

/* compiled from: AssetGroupAdapter.kt */
/* loaded from: classes.dex */
public final class m extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    private int f21396a = -1;

    /* renamed from: b, reason: collision with root package name */
    private c.e.a.a.f f21397b;

    /* renamed from: c, reason: collision with root package name */
    private List<? extends com.nexstreaming.app.general.nexasset.assetpackage.b> f21398c;

    /* renamed from: d, reason: collision with root package name */
    private PurchaseType f21399d;

    /* compiled from: AssetGroupAdapter.kt */
    /* loaded from: classes.dex */
    private static final class a {

        /* renamed from: a, reason: collision with root package name */
        private TextView f21400a;

        /* renamed from: b, reason: collision with root package name */
        private ImageView f21401b;

        /* renamed from: c, reason: collision with root package name */
        private View f21402c;

        /* renamed from: d, reason: collision with root package name */
        private View f21403d;

        public final void a(TextView textView) {
            this.f21400a = textView;
        }

        public final TextView b() {
            return this.f21400a;
        }

        public final View c() {
            return this.f21403d;
        }

        public final View d() {
            return this.f21402c;
        }

        public final ImageView a() {
            return this.f21401b;
        }

        public final void b(View view) {
            this.f21402c = view;
        }

        public final void a(ImageView imageView) {
            this.f21401b = imageView;
        }

        public final void a(View view) {
            this.f21403d = view;
        }
    }

    public m(List<? extends com.nexstreaming.app.general.nexasset.assetpackage.b> list, Context context, FragmentManager fragmentManager, PurchaseType purchaseType) {
        this.f21398c = list;
        this.f21399d = purchaseType;
        if (this.f21397b == null) {
            this.f21397b = new l(context, context);
            d.a aVar = new d.a(context, "ASSET_ICON_CACHE");
            c.e.a.a.f fVar = this.f21397b;
            if (fVar != null) {
                fVar.a(fragmentManager, aVar);
            }
        }
    }

    public final void a(int i) {
        this.f21396a = i;
        notifyDataSetInvalidated();
    }

    public final int b() {
        return this.f21396a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<? extends com.nexstreaming.app.general.nexasset.assetpackage.b> list = this.f21398c;
        if (list != null) {
            return list.size();
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        List<? extends com.nexstreaming.app.general.nexasset.assetpackage.b> list = this.f21398c;
        if (list != null) {
            return list.get(i);
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d6, code lost:            if ((r7.toString().length() == 0) != false) goto L36;     */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View getView(int r10, android.view.View r11, android.view.ViewGroup r12) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.nexstreaming.kinemaster.ui.assetbrowser.m.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    public final void a(PurchaseType purchaseType) {
        kotlin.jvm.internal.h.b(purchaseType, "purchaseType");
        this.f21399d = purchaseType;
        notifyDataSetInvalidated();
    }

    public final PurchaseType a() {
        return this.f21399d;
    }

    public final void a(List<? extends com.nexstreaming.app.general.nexasset.assetpackage.b> list) {
        kotlin.jvm.internal.h.b(list, "list");
        this.f21398c = list;
        notifyDataSetInvalidated();
    }
}
