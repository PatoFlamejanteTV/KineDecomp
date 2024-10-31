package com.google.android.gms.tagmanager;

import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.Tracker;
import com.google.android.gms.analytics.ecommerce.Product;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import com.google.android.gms.analytics.ecommerce.Promotion;
import com.google.android.gms.internal.zzad;
import com.google.android.gms.internal.zzae;
import com.google.android.gms.internal.zzag;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class zzdg extends al {

    /* renamed from: a, reason: collision with root package name */
    private static final String f2239a = zzad.UNIVERSAL_ANALYTICS.toString();
    private static final String b = zzae.ACCOUNT.toString();
    private static final String c = zzae.ANALYTICS_PASS_THROUGH.toString();
    private static final String d = zzae.ENABLE_ECOMMERCE.toString();
    private static final String e = zzae.ECOMMERCE_USE_DATA_LAYER.toString();
    private static final String f = zzae.ECOMMERCE_MACRO_DATA.toString();
    private static final String g = zzae.ANALYTICS_FIELDS.toString();
    private static final String h = zzae.TRACK_TRANSACTION.toString();
    private static final String i = zzae.TRANSACTION_DATALAYER_MAP.toString();
    private static final String j = zzae.TRANSACTION_ITEM_DATALAYER_MAP.toString();
    private static final List<String> k = Arrays.asList("detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund");
    private static final Pattern l = Pattern.compile("dimension(\\d+)");
    private static final Pattern m = Pattern.compile("metric(\\d+)");
    private static Map<String, String> n;
    private static Map<String, String> o;
    private final Set<String> p;
    private final zzdc q;
    private final DataLayer r;

    private ProductAction a(String str, Map<String, Object> map) {
        ProductAction productAction = new ProductAction(str);
        Object obj = map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (obj != null) {
            productAction.a(String.valueOf(obj));
        }
        Object obj2 = map.get("affiliation");
        if (obj2 != null) {
            productAction.b(String.valueOf(obj2));
        }
        Object obj3 = map.get("coupon");
        if (obj3 != null) {
            productAction.c(String.valueOf(obj3));
        }
        Object obj4 = map.get("list");
        if (obj4 != null) {
            productAction.e(String.valueOf(obj4));
        }
        Object obj5 = map.get("option");
        if (obj5 != null) {
            productAction.d(String.valueOf(obj5));
        }
        Object obj6 = map.get("revenue");
        if (obj6 != null) {
            productAction.a(a(obj6).doubleValue());
        }
        Object obj7 = map.get("tax");
        if (obj7 != null) {
            productAction.b(a(obj7).doubleValue());
        }
        Object obj8 = map.get("shipping");
        if (obj8 != null) {
            productAction.c(a(obj8).doubleValue());
        }
        Object obj9 = map.get("step");
        if (obj9 != null) {
            productAction.a(b(obj9).intValue());
        }
        return productAction;
    }

    private Double a(Object obj) {
        if (obj instanceof String) {
            try {
                return Double.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                throw new RuntimeException("Cannot convert the object to Double: " + e2.getMessage());
            }
        }
        if (obj instanceof Integer) {
            return Double.valueOf(((Integer) obj).doubleValue());
        }
        if (obj instanceof Double) {
            return (Double) obj;
        }
        throw new RuntimeException("Cannot convert the object to Double: " + obj.toString());
    }

    private String a(String str) {
        Object b2 = this.r.b(str);
        if (b2 == null) {
            return null;
        }
        return b2.toString();
    }

    private Map<String, String> a(zzag.zza zzaVar) {
        Object c2 = zzdf.c(zzaVar);
        if (!(c2 instanceof Map)) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : ((Map) c2).entrySet()) {
            linkedHashMap.put(entry.getKey().toString(), entry.getValue().toString());
        }
        return linkedHashMap;
    }

    private void a(Tracker tracker, Map<String, zzag.zza> map) {
        String a2 = a("transactionId");
        if (a2 == null) {
            zzbg.a("Cannot find transactionId in data layer.");
            return;
        }
        LinkedList linkedList = new LinkedList();
        try {
            Map<String, String> b2 = b(map.get(g));
            b2.put("&t", "transaction");
            for (Map.Entry<String, String> entry : e(map).entrySet()) {
                a(b2, entry.getValue(), a(entry.getKey()));
            }
            linkedList.add(b2);
            List<Map<String, String>> b3 = b("transactionProducts");
            if (b3 != null) {
                for (Map<String, String> map2 : b3) {
                    if (map2.get("name") == null) {
                        zzbg.a("Unable to send transaction item hit due to missing 'name' field.");
                        return;
                    }
                    Map<String, String> b4 = b(map.get(g));
                    b4.put("&t", "item");
                    b4.put("&ti", a2);
                    for (Map.Entry<String, String> entry2 : f(map).entrySet()) {
                        a(b4, entry2.getValue(), map2.get(entry2.getKey()));
                    }
                    linkedList.add(b4);
                }
            }
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                tracker.a((Map<String, String>) it.next());
            }
        } catch (IllegalArgumentException e2) {
            zzbg.a("Unable to send transaction", e2);
        }
    }

    private void a(Map<String, String> map, String str, String str2) {
        if (str2 != null) {
            map.put(str, str2);
        }
    }

    private boolean a(Map<String, zzag.zza> map, String str) {
        zzag.zza zzaVar = map.get(str);
        if (zzaVar == null) {
            return false;
        }
        return zzdf.b(zzaVar).booleanValue();
    }

    private Integer b(Object obj) {
        if (obj instanceof String) {
            try {
                return Integer.valueOf((String) obj);
            } catch (NumberFormatException e2) {
                throw new RuntimeException("Cannot convert the object to Integer: " + e2.getMessage());
            }
        }
        if (obj instanceof Double) {
            return Integer.valueOf(((Double) obj).intValue());
        }
        if (obj instanceof Integer) {
            return (Integer) obj;
        }
        throw new RuntimeException("Cannot convert the object to Integer: " + obj.toString());
    }

    private List<Map<String, String>> b(String str) {
        Object b2 = this.r.b(str);
        if (b2 == null) {
            return null;
        }
        if (!(b2 instanceof List)) {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        Iterator it = ((List) b2).iterator();
        while (it.hasNext()) {
            if (!(it.next() instanceof Map)) {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }
        return (List) b2;
    }

    private Map<String, String> b(zzag.zza zzaVar) {
        Map<String, String> a2;
        if (zzaVar != null && (a2 = a(zzaVar)) != null) {
            String str = a2.get("&aip");
            if (str != null && this.p.contains(str.toLowerCase())) {
                a2.remove("&aip");
            }
            return a2;
        }
        return new HashMap();
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(com.google.android.gms.analytics.Tracker r8, java.util.Map<java.lang.String, com.google.android.gms.internal.zzag.zza> r9) {
        /*
            Method dump skipped, instructions count: 461
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.tagmanager.zzdg.b(com.google.android.gms.analytics.Tracker, java.util.Map):void");
    }

    private Promotion c(Map<String, String> map) {
        Promotion promotion = new Promotion();
        String str = map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (str != null) {
            promotion.a(String.valueOf(str));
        }
        String str2 = map.get("name");
        if (str2 != null) {
            promotion.b(String.valueOf(str2));
        }
        String str3 = map.get("creative");
        if (str3 != null) {
            promotion.c(String.valueOf(str3));
        }
        String str4 = map.get("position");
        if (str4 != null) {
            promotion.d(String.valueOf(str4));
        }
        return promotion;
    }

    private Product d(Map<String, Object> map) {
        Product product = new Product();
        Object obj = map.get(ShareConstants.WEB_DIALOG_PARAM_ID);
        if (obj != null) {
            product.a(String.valueOf(obj));
        }
        Object obj2 = map.get("name");
        if (obj2 != null) {
            product.b(String.valueOf(obj2));
        }
        Object obj3 = map.get("brand");
        if (obj3 != null) {
            product.c(String.valueOf(obj3));
        }
        Object obj4 = map.get("category");
        if (obj4 != null) {
            product.d(String.valueOf(obj4));
        }
        Object obj5 = map.get("variant");
        if (obj5 != null) {
            product.e(String.valueOf(obj5));
        }
        Object obj6 = map.get("coupon");
        if (obj6 != null) {
            product.f(String.valueOf(obj6));
        }
        Object obj7 = map.get("position");
        if (obj7 != null) {
            product.a(b(obj7).intValue());
        }
        Object obj8 = map.get("price");
        if (obj8 != null) {
            product.a(a(obj8).doubleValue());
        }
        Object obj9 = map.get("quantity");
        if (obj9 != null) {
            product.b(b(obj9).intValue());
        }
        for (String str : map.keySet()) {
            Matcher matcher = l.matcher(str);
            if (matcher.matches()) {
                try {
                    product.a(Integer.parseInt(matcher.group(1)), String.valueOf(map.get(str)));
                } catch (NumberFormatException e2) {
                    zzbg.b("illegal number in custom dimension value: " + str);
                }
            } else {
                Matcher matcher2 = m.matcher(str);
                if (matcher2.matches()) {
                    try {
                        product.a(Integer.parseInt(matcher2.group(1)), b(map.get(str)).intValue());
                    } catch (NumberFormatException e3) {
                        zzbg.b("illegal number in custom metric value: " + str);
                    }
                }
            }
        }
        return product;
    }

    private Map<String, String> e(Map<String, zzag.zza> map) {
        zzag.zza zzaVar = map.get(i);
        if (zzaVar != null) {
            return a(zzaVar);
        }
        if (n == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("transactionId", "&ti");
            hashMap.put("transactionAffiliation", "&ta");
            hashMap.put("transactionTax", "&tt");
            hashMap.put("transactionShipping", "&ts");
            hashMap.put("transactionTotal", "&tr");
            hashMap.put("transactionCurrency", "&cu");
            n = hashMap;
        }
        return n;
    }

    private Map<String, String> f(Map<String, zzag.zza> map) {
        zzag.zza zzaVar = map.get(j);
        if (zzaVar != null) {
            return a(zzaVar);
        }
        if (o == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("name", "&in");
            hashMap.put("sku", "&ic");
            hashMap.put("category", "&iv");
            hashMap.put("price", "&ip");
            hashMap.put("quantity", "&iq");
            hashMap.put("currency", "&cu");
            o = hashMap;
        }
        return o;
    }

    @Override // com.google.android.gms.tagmanager.al, com.google.android.gms.tagmanager.i
    public /* bridge */ /* synthetic */ zzag.zza a(Map map) {
        return super.a((Map<String, zzag.zza>) map);
    }

    @Override // com.google.android.gms.tagmanager.al, com.google.android.gms.tagmanager.i
    public /* bridge */ /* synthetic */ boolean a() {
        return super.a();
    }

    @Override // com.google.android.gms.tagmanager.i
    public /* bridge */ /* synthetic */ Set b() {
        return super.b();
    }

    @Override // com.google.android.gms.tagmanager.al
    public void b(Map<String, zzag.zza> map) {
        Tracker a2 = this.q.a("_GTM_DEFAULT_TRACKER_");
        a2.a(a(map, "collect_adid"));
        if (a(map, d)) {
            b(a2, map);
            return;
        }
        if (a(map, c)) {
            a2.a(b(map.get(g)));
        } else if (a(map, h)) {
            a(a2, map);
        } else {
            zzbg.b("Ignoring unknown tag.");
        }
    }
}
