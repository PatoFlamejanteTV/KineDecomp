package com.google.android.gms.internal.gtm;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import com.google.android.gms.internal.gtm.InterfaceC1335v;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: com.google.android.gms.internal.gtm.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1337w<T extends InterfaceC1335v> extends zzam {
    private zzbp<T> zzyn;

    public C1337w(zzap zzapVar, zzbp<T> zzbpVar) {
        super(zzapVar);
        this.zzyn = zzbpVar;
    }

    private final T zza(XmlResourceParser xmlResourceParser) {
        try {
            xmlResourceParser.next();
            int eventType = xmlResourceParser.getEventType();
            while (eventType != 1) {
                if (xmlResourceParser.getEventType() == 2) {
                    String lowerCase = xmlResourceParser.getName().toLowerCase(Locale.US);
                    if (lowerCase.equals("screenname")) {
                        String attributeValue = xmlResourceParser.getAttributeValue(null, "name");
                        String trim = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue) && !TextUtils.isEmpty(trim)) {
                            this.zzyn.zzb(attributeValue, trim);
                        }
                    } else if (lowerCase.equals("string")) {
                        String attributeValue2 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim2 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue2) && trim2 != null) {
                            this.zzyn.zzc(attributeValue2, trim2);
                        }
                    } else if (lowerCase.equals("bool")) {
                        String attributeValue3 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim3 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue3) && !TextUtils.isEmpty(trim3)) {
                            try {
                                this.zzyn.zza(attributeValue3, Boolean.parseBoolean(trim3));
                            } catch (NumberFormatException e2) {
                                zzc("Error parsing bool configuration value", trim3, e2);
                            }
                        }
                    } else if (lowerCase.equals("integer")) {
                        String attributeValue4 = xmlResourceParser.getAttributeValue(null, "name");
                        String trim4 = xmlResourceParser.nextText().trim();
                        if (!TextUtils.isEmpty(attributeValue4) && !TextUtils.isEmpty(trim4)) {
                            try {
                                this.zzyn.zzb(attributeValue4, Integer.parseInt(trim4));
                            } catch (NumberFormatException e3) {
                                zzc("Error parsing int configuration value", trim4, e3);
                            }
                        }
                    }
                }
                eventType = xmlResourceParser.next();
            }
        } catch (IOException | XmlPullParserException e4) {
            zze("Error parsing tracker configuration file", e4);
        }
        return this.zzyn.zzel();
    }

    public final T zzq(int i) {
        try {
            return zza(zzcm().zzdc().getResources().getXml(i));
        } catch (Resources.NotFoundException e2) {
            zzd("inflate() called with unknown resourceId", e2);
            return null;
        }
    }
}
