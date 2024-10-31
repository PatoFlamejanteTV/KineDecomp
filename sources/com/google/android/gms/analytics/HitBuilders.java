package com.google.android.gms.analytics;

import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;
import com.google.android.gms.internal.gtm.zzcz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@VisibleForTesting
/* loaded from: classes.dex */
public class HitBuilders {

    @VisibleForTesting
    @Deprecated
    /* loaded from: classes.dex */
    public static class AppViewBuilder extends HitBuilder<AppViewBuilder> {
        public AppViewBuilder() {
            a("&t", "screenview");
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class EventBuilder extends HitBuilder<EventBuilder> {
        public EventBuilder() {
            a("&t", NotificationCompat.CATEGORY_EVENT);
        }
    }

    @VisibleForTesting
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
            a("&exf", zzcz.zzc(z));
            return this;
        }
    }

    @VisibleForTesting
    @Deprecated
    /* loaded from: classes.dex */
    public static class ItemBuilder extends HitBuilder<ItemBuilder> {
        public ItemBuilder() {
            a("&t", "item");
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class ScreenViewBuilder extends HitBuilder<ScreenViewBuilder> {
        public ScreenViewBuilder() {
            a("&t", "screenview");
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class SocialBuilder extends HitBuilder<SocialBuilder> {
        public SocialBuilder() {
            a("&t", NotificationCompat.CATEGORY_SOCIAL);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class TimingBuilder extends HitBuilder<TimingBuilder> {
        public TimingBuilder() {
            a("&t", "timing");
        }
    }

    @VisibleForTesting
    @Deprecated
    /* loaded from: classes.dex */
    public static class TransactionBuilder extends HitBuilder<TransactionBuilder> {
        public TransactionBuilder() {
            a("&t", "transaction");
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class HitBuilder<T extends HitBuilder> {

        /* renamed from: b */
        private ProductAction f10331b;

        /* renamed from: a */
        private Map<String, String> f10330a = new HashMap();

        /* renamed from: c */
        private Map<String, List<Product>> f10332c = new HashMap();

        /* renamed from: d */
        private List<Promotion> f10333d = new ArrayList();

        /* renamed from: e */
        private List<Product> f10334e = new ArrayList();

        protected HitBuilder() {
        }

        public final T a(String str, String str2) {
            if (str != null) {
                this.f10330a.put(str, str2);
            } else {
                zzch.zzac("HitBuilder.set() called with a null paramName.");
            }
            return this;
        }

        public Map<String, String> a() {
            HashMap hashMap = new HashMap(this.f10330a);
            ProductAction productAction = this.f10331b;
            if (productAction != null) {
                hashMap.putAll(productAction.a());
            }
            Iterator<Promotion> it = this.f10333d.iterator();
            int i = 1;
            while (it.hasNext()) {
                hashMap.putAll(it.next().a(zzd.e(i)));
                i++;
            }
            Iterator<Product> it2 = this.f10334e.iterator();
            int i2 = 1;
            while (it2.hasNext()) {
                hashMap.putAll(it2.next().a(zzd.c(i2)));
                i2++;
            }
            int i3 = 1;
            for (Map.Entry<String, List<Product>> entry : this.f10332c.entrySet()) {
                List<Product> value = entry.getValue();
                String h2 = zzd.h(i3);
                int i4 = 1;
                for (Product product : value) {
                    String valueOf = String.valueOf(h2);
                    String valueOf2 = String.valueOf(zzd.g(i4));
                    hashMap.putAll(product.a(valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf)));
                    i4++;
                }
                if (!TextUtils.isEmpty(entry.getKey())) {
                    String valueOf3 = String.valueOf(h2);
                    hashMap.put("nm".length() != 0 ? valueOf3.concat("nm") : new String(valueOf3), entry.getKey());
                }
                i3++;
            }
            return hashMap;
        }
    }
}
