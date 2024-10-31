package com.google.android.gms.measurement.internal;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzfj;
import com.google.android.gms.internal.measurement.zzfl;
import com.google.android.gms.internal.measurement.zzfm;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzfs;
import com.google.android.gms.internal.measurement.zzfz;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Ua extends La {
    /* JADX INFO: Access modifiers changed from: package-private */
    public Ua(zzfo zzfoVar) {
        super(zzfoVar);
    }

    private static void b(Map<Integer, List<Long>> map, int i, long j) {
        List<Long> list = map.get(Integer.valueOf(i));
        if (list == null) {
            list = new ArrayList<>();
            map.put(Integer.valueOf(i), list);
        }
        list.add(Long.valueOf(j / 1000));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:100:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0458  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0479  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0405  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x02c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.measurement.zzfr[] a(java.lang.String r68, com.google.android.gms.internal.measurement.zzft[] r69, com.google.android.gms.internal.measurement.zzfz[] r70) {
        /*
            Method dump skipped, instructions count: 3304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Ua.a(java.lang.String, com.google.android.gms.internal.measurement.zzft[], com.google.android.gms.internal.measurement.zzfz[]):com.google.android.gms.internal.measurement.zzfr[]");
    }

    @Override // com.google.android.gms.measurement.internal.La
    protected final boolean p() {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Boolean a(zzfj zzfjVar, String str, com.google.android.gms.internal.measurement.zzfu[] zzfuVarArr, long j) {
        Boolean a2;
        zzfl zzflVar = zzfjVar.zzavo;
        if (zzflVar != null) {
            Boolean a3 = a(j, zzflVar);
            if (a3 == null) {
                return null;
            }
            if (!a3.booleanValue()) {
                return false;
            }
        }
        HashSet hashSet = new HashSet();
        for (com.google.android.gms.internal.measurement.zzfk zzfkVar : zzfjVar.zzavm) {
            if (TextUtils.isEmpty(zzfkVar.zzavt)) {
                b().t().a("null or empty param name in filter. event", g().a(str));
                return null;
            }
            hashSet.add(zzfkVar.zzavt);
        }
        ArrayMap arrayMap = new ArrayMap();
        for (com.google.android.gms.internal.measurement.zzfu zzfuVar : zzfuVarArr) {
            if (hashSet.contains(zzfuVar.name)) {
                Long l = zzfuVar.zzaxe;
                if (l != null) {
                    arrayMap.put(zzfuVar.name, l);
                } else {
                    Double d2 = zzfuVar.zzaun;
                    if (d2 != null) {
                        arrayMap.put(zzfuVar.name, d2);
                    } else {
                        String str2 = zzfuVar.zzaml;
                        if (str2 != null) {
                            arrayMap.put(zzfuVar.name, str2);
                        } else {
                            b().t().a("Unknown value for param. event, param", g().a(str), g().b(zzfuVar.name));
                            return null;
                        }
                    }
                }
            }
        }
        for (com.google.android.gms.internal.measurement.zzfk zzfkVar2 : zzfjVar.zzavm) {
            boolean equals = Boolean.TRUE.equals(zzfkVar2.zzavs);
            String str3 = zzfkVar2.zzavt;
            if (TextUtils.isEmpty(str3)) {
                b().t().a("Event has empty param name. event", g().a(str));
                return null;
            }
            V v = arrayMap.get(str3);
            if (v instanceof Long) {
                if (zzfkVar2.zzavr == null) {
                    b().t().a("No number filter for long param. event, param", g().a(str), g().b(str3));
                    return null;
                }
                Boolean a4 = a(((Long) v).longValue(), zzfkVar2.zzavr);
                if (a4 == null) {
                    return null;
                }
                if ((true ^ a4.booleanValue()) ^ equals) {
                    return false;
                }
            } else if (v instanceof Double) {
                if (zzfkVar2.zzavr == null) {
                    b().t().a("No number filter for double param. event, param", g().a(str), g().b(str3));
                    return null;
                }
                Boolean a5 = a(((Double) v).doubleValue(), zzfkVar2.zzavr);
                if (a5 == null) {
                    return null;
                }
                if ((true ^ a5.booleanValue()) ^ equals) {
                    return false;
                }
            } else {
                if (!(v instanceof String)) {
                    if (v == 0) {
                        b().y().a("Missing param for filter. event, param", g().a(str), g().b(str3));
                        return false;
                    }
                    b().t().a("Unknown param type. event, param", g().a(str), g().b(str3));
                    return null;
                }
                zzfn zzfnVar = zzfkVar2.zzavq;
                if (zzfnVar != null) {
                    a2 = a((String) v, zzfnVar);
                } else if (zzfkVar2.zzavr != null) {
                    String str4 = (String) v;
                    if (zzfu.a(str4)) {
                        a2 = a(str4, zzfkVar2.zzavr);
                    } else {
                        b().t().a("Invalid param value for number filter. event, param", g().a(str), g().b(str3));
                        return null;
                    }
                } else {
                    b().t().a("No filter for String param. event, param", g().a(str), g().b(str3));
                    return null;
                }
                if (a2 == null) {
                    return null;
                }
                if ((true ^ a2.booleanValue()) ^ equals) {
                    return false;
                }
            }
        }
        return true;
    }

    private final Boolean a(zzfm zzfmVar, zzfz zzfzVar) {
        com.google.android.gms.internal.measurement.zzfk zzfkVar = zzfmVar.zzawb;
        if (zzfkVar == null) {
            b().t().a("Missing property filter. property", g().c(zzfzVar.name));
            return null;
        }
        boolean equals = Boolean.TRUE.equals(zzfkVar.zzavs);
        Long l = zzfzVar.zzaxe;
        if (l != null) {
            if (zzfkVar.zzavr == null) {
                b().t().a("No number filter for long property. property", g().c(zzfzVar.name));
                return null;
            }
            return a(a(l.longValue(), zzfkVar.zzavr), equals);
        }
        Double d2 = zzfzVar.zzaun;
        if (d2 != null) {
            if (zzfkVar.zzavr == null) {
                b().t().a("No number filter for double property. property", g().c(zzfzVar.name));
                return null;
            }
            return a(a(d2.doubleValue(), zzfkVar.zzavr), equals);
        }
        String str = zzfzVar.zzaml;
        if (str != null) {
            zzfn zzfnVar = zzfkVar.zzavq;
            if (zzfnVar == null) {
                if (zzfkVar.zzavr == null) {
                    b().t().a("No string or number filter defined. property", g().c(zzfzVar.name));
                } else {
                    if (zzfu.a(str)) {
                        return a(a(zzfzVar.zzaml, zzfkVar.zzavr), equals);
                    }
                    b().t().a("Invalid user property value for Numeric number filter. property, value", g().c(zzfzVar.name), zzfzVar.zzaml);
                }
                return null;
            }
            return a(a(str, zzfnVar), equals);
        }
        b().t().a("User property has no value, property", g().c(zzfzVar.name));
        return null;
    }

    @VisibleForTesting
    private static Boolean a(Boolean bool, boolean z) {
        if (bool == null) {
            return null;
        }
        return Boolean.valueOf(bool.booleanValue() ^ z);
    }

    @VisibleForTesting
    private final Boolean a(String str, zzfn zzfnVar) {
        Integer num;
        String str2;
        List<String> list;
        Preconditions.a(zzfnVar);
        if (str == null || (num = zzfnVar.zzawc) == null || num.intValue() == 0) {
            return null;
        }
        if (zzfnVar.zzawc.intValue() == 6) {
            String[] strArr = zzfnVar.zzawf;
            if (strArr == null || strArr.length == 0) {
                return null;
            }
        } else if (zzfnVar.zzawd == null) {
            return null;
        }
        int intValue = zzfnVar.zzawc.intValue();
        Boolean bool = zzfnVar.zzawe;
        boolean z = bool != null && bool.booleanValue();
        if (!z && intValue != 1 && intValue != 6) {
            str2 = zzfnVar.zzawd.toUpperCase(Locale.ENGLISH);
        } else {
            str2 = zzfnVar.zzawd;
        }
        String str3 = str2;
        String[] strArr2 = zzfnVar.zzawf;
        if (strArr2 == null) {
            list = null;
        } else if (z) {
            list = Arrays.asList(strArr2);
        } else {
            ArrayList arrayList = new ArrayList();
            for (String str4 : strArr2) {
                arrayList.add(str4.toUpperCase(Locale.ENGLISH));
            }
            list = arrayList;
        }
        return a(str, intValue, z, str3, list, intValue == 1 ? str3 : null);
    }

    private final Boolean a(String str, int i, boolean z, String str2, List<String> list, String str3) {
        if (str == null) {
            return null;
        }
        if (i == 6) {
            if (list == null || list.size() == 0) {
                return null;
            }
        } else if (str2 == null) {
            return null;
        }
        if (!z && i != 1) {
            str = str.toUpperCase(Locale.ENGLISH);
        }
        switch (i) {
            case 1:
                try {
                    return Boolean.valueOf(Pattern.compile(str3, z ? 0 : 66).matcher(str).matches());
                } catch (PatternSyntaxException unused) {
                    b().t().a("Invalid regular expression in REGEXP audience filter. expression", str3);
                    return null;
                }
            case 2:
                return Boolean.valueOf(str.startsWith(str2));
            case 3:
                return Boolean.valueOf(str.endsWith(str2));
            case 4:
                return Boolean.valueOf(str.contains(str2));
            case 5:
                return Boolean.valueOf(str.equals(str2));
            case 6:
                return Boolean.valueOf(list.contains(str));
            default:
                return null;
        }
    }

    private final Boolean a(long j, zzfl zzflVar) {
        try {
            return a(new BigDecimal(j), zzflVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean a(double d2, zzfl zzflVar) {
        try {
            return a(new BigDecimal(d2), zzflVar, Math.ulp(d2));
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    private final Boolean a(String str, zzfl zzflVar) {
        if (!zzfu.a(str)) {
            return null;
        }
        try {
            return a(new BigDecimal(str), zzflVar, 0.0d);
        } catch (NumberFormatException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x006f, code lost:            if (r3 != null) goto L36;     */
    @com.google.android.gms.common.util.VisibleForTesting
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.Boolean a(java.math.BigDecimal r10, com.google.android.gms.internal.measurement.zzfl r11, double r12) {
        /*
            Method dump skipped, instructions count: 242
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.Ua.a(java.math.BigDecimal, com.google.android.gms.internal.measurement.zzfl, double):java.lang.Boolean");
    }

    private static zzfs[] a(Map<Integer, Long> map) {
        if (map == null) {
            return null;
        }
        int i = 0;
        zzfs[] zzfsVarArr = new zzfs[map.size()];
        for (Integer num : map.keySet()) {
            zzfs zzfsVar = new zzfs();
            zzfsVar.zzawx = num;
            zzfsVar.zzawy = map.get(num);
            zzfsVarArr[i] = zzfsVar;
            i++;
        }
        return zzfsVarArr;
    }

    private static void a(Map<Integer, Long> map, int i, long j) {
        Long l = map.get(Integer.valueOf(i));
        long j2 = j / 1000;
        if (l == null || j2 > l.longValue()) {
            map.put(Integer.valueOf(i), Long.valueOf(j2));
        }
    }
}
