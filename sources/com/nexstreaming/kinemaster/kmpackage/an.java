package com.nexstreaming.kinemaster.kmpackage;

import com.facebook.internal.ServerProtocol;
import java.util.Locale;

/* compiled from: KMTParseTools.java */
/* loaded from: classes.dex */
class an {
    /* JADX INFO: Access modifiers changed from: protected */
    public static <T extends Enum<?>> T a(String str, T[] tArr) {
        if (str == null) {
            return null;
        }
        String replace = str.trim().toUpperCase(Locale.US).replace('-', '_');
        for (T t : tArr) {
            if (t.name().equals(replace)) {
                return t;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean a(String str, boolean z) throws PackageXMLParseException {
        if (str != null && str.trim().length() >= 1) {
            if (!str.trim().equalsIgnoreCase(ServerProtocol.DIALOG_RETURN_SCOPES_TRUE) && !str.trim().equalsIgnoreCase("false")) {
                throw new PackageXMLParseException("Boolean must be 'true' or 'false'");
            }
            return true;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(String str, int i) throws PackageXMLParseException {
        if (str != null && str.trim().length() >= 1) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                throw new PackageXMLParseException(e);
            }
        }
        return i;
    }
}
