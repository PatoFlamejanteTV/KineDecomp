package com.facebook.stetho.inspector.helper;

import android.annotation.TargetApi;
import android.os.Build;
import android.view.ViewDebug;

/* loaded from: classes.dex */
public class IntegerFormatter {
    private static IntegerFormatter cachedFormatter;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class IntegerFormatterWithHex extends IntegerFormatter {
        private IntegerFormatterWithHex() {
            super();
        }

        @Override // com.facebook.stetho.inspector.helper.IntegerFormatter
        @TargetApi(21)
        public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
            if (exportedProperty != null && exportedProperty.formatToHexString()) {
                return "0x" + Integer.toHexString(num.intValue());
            }
            return super.format(num, exportedProperty);
        }

        /* synthetic */ IntegerFormatterWithHex(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    /* synthetic */ IntegerFormatter(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static IntegerFormatter getInstance() {
        if (cachedFormatter == null) {
            synchronized (IntegerFormatter.class) {
                if (cachedFormatter == null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        cachedFormatter = new IntegerFormatterWithHex();
                    } else {
                        cachedFormatter = new IntegerFormatter();
                    }
                }
            }
        }
        return cachedFormatter;
    }

    public String format(Integer num, ViewDebug.ExportedProperty exportedProperty) {
        return String.valueOf(num);
    }

    private IntegerFormatter() {
    }
}
