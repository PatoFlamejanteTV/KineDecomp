package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.iab.Purchase;
import com.nexstreaming.kinemaster.tracelog.APCManager;

/* loaded from: classes2.dex */
public final /* synthetic */ class b {

    /* renamed from: a */
    public static final /* synthetic */ int[] f19436a = new int[APCManager.APCValidationResult.values().length];

    /* renamed from: b */
    public static final /* synthetic */ int[] f19437b;

    /* renamed from: c */
    public static final /* synthetic */ int[] f19438c;

    /* renamed from: d */
    public static final /* synthetic */ int[] f19439d;

    /* renamed from: e */
    public static final /* synthetic */ int[] f19440e;

    /* renamed from: f */
    public static final /* synthetic */ int[] f19441f;

    static {
        f19436a[APCManager.APCValidationResult.Valid.ordinal()] = 1;
        f19436a[APCManager.APCValidationResult.Invalid.ordinal()] = 2;
        f19436a[APCManager.APCValidationResult.Unknown.ordinal()] = 3;
        f19437b = new int[PurchaseType.values().length];
        f19437b[PurchaseType.SubAnnual.ordinal()] = 1;
        f19437b[PurchaseType.SubMonthly.ordinal()] = 2;
        f19437b[PurchaseType.SubUnknown.ordinal()] = 3;
        f19437b[PurchaseType.OneTimeValid.ordinal()] = 4;
        f19437b[PurchaseType.Promocode.ordinal()] = 5;
        f19437b[PurchaseType.Team.ordinal()] = 6;
        f19437b[PurchaseType.Standard.ordinal()] = 7;
        f19437b[PurchaseType.Partner.ordinal()] = 8;
        f19438c = new int[PurchaseType.values().length];
        f19438c[PurchaseType.SubAnnual.ordinal()] = 1;
        f19438c[PurchaseType.SubMonthly.ordinal()] = 2;
        f19438c[PurchaseType.Promocode.ordinal()] = 3;
        f19438c[PurchaseType.OneTimeValid.ordinal()] = 4;
        f19438c[PurchaseType.OneTimeExpired.ordinal()] = 5;
        f19438c[PurchaseType.SubUnknown.ordinal()] = 6;
        f19438c[PurchaseType.None.ordinal()] = 7;
        f19439d = new int[PurchaseType.values().length];
        f19439d[PurchaseType.SubAnnual.ordinal()] = 1;
        f19439d[PurchaseType.SubMonthly.ordinal()] = 2;
        f19439d[PurchaseType.Promocode.ordinal()] = 3;
        f19439d[PurchaseType.Team.ordinal()] = 4;
        f19439d[PurchaseType.Standard.ordinal()] = 5;
        f19439d[PurchaseType.Partner.ordinal()] = 6;
        f19439d[PurchaseType.OneTimeValid.ordinal()] = 7;
        f19440e = new int[Purchase.PurchaseState.values().length];
        f19440e[Purchase.PurchaseState.Canceled.ordinal()] = 1;
        f19440e[Purchase.PurchaseState.Refunded.ordinal()] = 2;
        f19441f = new int[Purchase.PurchaseState.values().length];
        f19441f[Purchase.PurchaseState.Canceled.ordinal()] = 1;
        f19441f[Purchase.PurchaseState.Refunded.ordinal()] = 2;
    }
}
