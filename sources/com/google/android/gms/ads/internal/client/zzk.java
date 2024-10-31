package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class zzk {

    /* renamed from: a, reason: collision with root package name */
    private final AdSize[] f544a;
    private final String b;

    public zzk(Context context, AttributeSet attributeSet) {
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R.styleable.AdsAttrs);
        String string = obtainAttributes.getString(R.styleable.AdsAttrs_adSize);
        String string2 = obtainAttributes.getString(R.styleable.AdsAttrs_adSizes);
        boolean z = !TextUtils.isEmpty(string);
        boolean z2 = TextUtils.isEmpty(string2) ? false : true;
        if (z && !z2) {
            this.f544a = a(string);
        } else {
            if (z || !z2) {
                if (!z || !z2) {
                    throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
                }
                throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
            }
            this.f544a = a(string2);
        }
        this.b = obtainAttributes.getString(R.styleable.AdsAttrs_adUnitId);
        if (TextUtils.isEmpty(this.b)) {
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
    }

    private static AdSize[] a(String str) {
        String[] split = str.split("\\s*,\\s*");
        AdSize[] adSizeArr = new AdSize[split.length];
        for (int i = 0; i < split.length; i++) {
            String trim = split[i].trim();
            if (trim.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) {
                String[] split2 = trim.split("[xX]");
                split2[0] = split2[0].trim();
                split2[1] = split2[1].trim();
                try {
                    adSizeArr[i] = new AdSize("FULL_WIDTH".equals(split2[0]) ? -1 : Integer.parseInt(split2[0]), "AUTO_HEIGHT".equals(split2[1]) ? -2 : Integer.parseInt(split2[1]));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
                }
            } else if ("BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.f516a;
            } else if ("LARGE_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.c;
            } else if ("FULL_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.b;
            } else if ("LEADERBOARD".equals(trim)) {
                adSizeArr[i] = AdSize.d;
            } else if ("MEDIUM_RECTANGLE".equals(trim)) {
                adSizeArr[i] = AdSize.e;
            } else if ("SMART_BANNER".equals(trim)) {
                adSizeArr[i] = AdSize.g;
            } else if ("WIDE_SKYSCRAPER".equals(trim)) {
                adSizeArr[i] = AdSize.f;
            } else {
                if (!"FLUID".equals(trim)) {
                    throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + trim);
                }
                adSizeArr[i] = AdSize.h;
            }
        }
        if (adSizeArr.length == 0) {
            throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + str);
        }
        return adSizeArr;
    }

    public String a() {
        return this.b;
    }

    public AdSize[] a(boolean z) {
        if (z || this.f544a.length == 1) {
            return this.f544a;
        }
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }
}
