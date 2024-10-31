package org.apache.commons.cli;

/* compiled from: OptionValidator.java */
/* loaded from: classes3.dex */
class d {
    public static void a(String str) throws IllegalArgumentException {
        if (str == null) {
            return;
        }
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if (b(charAt)) {
                return;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("illegal option value '");
            stringBuffer.append(charAt);
            stringBuffer.append("'");
            throw new IllegalArgumentException(stringBuffer.toString());
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (!a(charArray[i])) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("opt contains illegal character value '");
                stringBuffer2.append(charArray[i]);
                stringBuffer2.append("'");
                throw new IllegalArgumentException(stringBuffer2.toString());
            }
        }
    }

    private static boolean b(char c2) {
        return a(c2) || c2 == ' ' || c2 == '?' || c2 == '@';
    }

    private static boolean a(char c2) {
        return Character.isJavaIdentifierPart(c2);
    }
}
