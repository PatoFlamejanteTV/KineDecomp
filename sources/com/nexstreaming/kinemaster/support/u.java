package com.nexstreaming.kinemaster.support;

import com.nexstreaming.app.general.iab.PurchaseType;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SupportMailer.java */
/* loaded from: classes.dex */
public /* synthetic */ class u {

    /* renamed from: a */
    static final /* synthetic */ int[] f21265a = new int[PurchaseType.values().length];

    static {
        try {
            f21265a[PurchaseType.None.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f21265a[PurchaseType.OneTimeExpired.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f21265a[PurchaseType.OneTimeValid.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f21265a[PurchaseType.Partner.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f21265a[PurchaseType.Promocode.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f21265a[PurchaseType.Standard.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f21265a[PurchaseType.SubAnnual.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f21265a[PurchaseType.SubMonthly.ordinal()] = 8;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f21265a[PurchaseType.SubUnknown.ordinal()] = 9;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f21265a[PurchaseType.Team.ordinal()] = 10;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
