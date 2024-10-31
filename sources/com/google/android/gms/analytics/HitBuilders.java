package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class HitBuilders {

    @Deprecated
    /* loaded from: classes.dex */
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            a("&t", "screenview");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }

    /* loaded from: classes.dex */
    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            a("&t", "event");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }

    /* loaded from: classes.dex */
    public static class ExceptionBuilder extends HitBuilder<ExceptionBuilder> {
        public ExceptionBuilder() {
            a("&t", "exception");
        }

        public ExceptionBuilder a(String str) {
            a("&exd", str);
            return this;
        }

        public ExceptionBuilder a(boolean z) {
            a("&exf", zzam.a(z));
            return this;
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }

    /* loaded from: classes.dex */
    protected static class HitBuilder<T extends HitBuilder> {

        /* renamed from: a, reason: collision with root package name */
        ProductAction f685a;
        private Map<String, String> e = new HashMap();
        Map<String, List<Product>> b = new HashMap();
        List<Promotion> c = new ArrayList();
        List<Product> d = new ArrayList();

        protected HitBuilder() {
        }

        public T a(Product product) {
            if (product == null) {
                zzae.b("product should be non-null");
            } else {
                this.d.add(product);
            }
            return this;
        }

        public T a(Product product, String str) {
            if (product == null) {
                zzae.b("product should be non-null");
            } else {
                if (str == null) {
                    str = "";
                }
                if (!this.b.containsKey(str)) {
                    this.b.put(str, new ArrayList());
                }
                this.b.get(str).add(product);
            }
            return this;
        }

        public T a(ProductAction productAction) {
            this.f685a = productAction;
            return this;
        }

        public T a(Promotion promotion) {
            if (promotion == null) {
                zzae.b("promotion should be non-null");
            } else {
                this.c.add(promotion);
            }
            return this;
        }

        public final T a(String str, String str2) {
            if (str != null) {
                this.e.put(str, str2);
            } else {
                zzae.b(" HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public final T a(Map<String, String> map) {
            if (map != null) {
                this.e.putAll(new HashMap(map));
            }
            return this;
        }

        public Map<String, String> a() {
            HashMap hashMap = new HashMap(this.e);
            if (this.f685a != null) {
                hashMap.putAll(this.f685a.a());
            }
            Iterator<Promotion> it = this.c.iterator();
            int i = 1;
            while (it.hasNext()) {
                hashMap.putAll(it.next().e(zzc.e(i)));
                i++;
            }
            Iterator<Product> it2 = this.d.iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                hashMap.putAll(it2.next().g(zzc.c(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry : this.b.entrySet()) {
                List<Product> value = entry.getValue();
                String h = zzc.h(i3);
                Iterator<Product> it3 = value.iterator();
                int i4 = 1;
                while (it3.hasNext()) {
                    hashMap.putAll(it3.next().g(h + zzc.g(i4)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry.getKey())) {
                    hashMap.put(h + "nm", entry.getKey());
                }
                i3++;
            }
            return hashMap;
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            a("&t", "item");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }

    /* loaded from: classes.dex */
    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            a("&t", "screenview");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }

    /* loaded from: classes.dex */
    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            a("&t", "social");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }

    /* loaded from: classes.dex */
    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            a("&t", "timing");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            a("&t", "transaction");
        }

        @Override // com.google.android.gms.analytics.HitBuilders.HitBuilder
        public /* bridge */ /* synthetic */ Map a() {
            return super.a();
        }
    }
}
