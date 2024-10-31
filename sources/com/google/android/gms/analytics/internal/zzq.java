package com.google.android.gms.analytics.internal;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.w;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
abstract class zzq<T extends w> extends zzc {

    /* renamed from: a, reason: collision with root package name */
    zza<T> f748a;

    /* loaded from: classes.dex */
    public interface zza<U extends w> {
        U a();

        void a(String str, int i);

        void a(String str, String str2);

        void a(String str, boolean z);

        void b(String str, String str2);
    }

    public zzq(zzf zzfVar, zza<T> zzaVar) {
        super(zzfVar);
        this.f748a = zzaVar;
    }

    private T a(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase();
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.f748a.a(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.f748a.b(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.f748a.a(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e) {
                                c("Error parsing bool configuration value", trim3, e);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.f748a.a(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e2) {
                                c("Error parsing int configuration value", trim4, e2);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException e3) {
            e("Error parsing tracker configuration file", e3);
        } catch (XmlPullParserException e4) {
            e("Error parsing tracker configuration file", e4);
        }
        return this.f748a.a();
    }

    public T a(int i) {
        try {
            return a(k().c().getResources().getXml(i));
        } catch (Resources.NotFoundException e) {
            d("inflate() called with unknown resourceId", e);
            return null;
        }
    }
}
