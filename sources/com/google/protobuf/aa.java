package com.google.protobuf;

/* compiled from: TextFormatEscaper.java */
/* loaded from: classes2.dex */
final class aa {

    /* compiled from: TextFormatEscaper.java */
    /* loaded from: classes2.dex */
    public interface a {
        byte a(int i);

        int size();
    }

    static String a(a aVar) {
        StringBuilder sb = new StringBuilder(aVar.size());
        for (int i = 0; i < aVar.size(); i++) {
            byte a2 = aVar.a(i);
            if (a2 == 34) {
                sb.append("\\\"");
            } else if (a2 == 39) {
                sb.append("\\'");
            } else if (a2 != 92) {
                switch (a2) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (a2 >= 32 && a2 <= 126) {
                            sb.append((char) a2);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((a2 >>> 6) & 3) + 48));
                            sb.append((char) (((a2 >>> 3) & 7) + 48));
                            sb.append((char) ((a2 & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String a(ByteString byteString) {
        return a(new Z(byteString));
    }

    public static String a(String str) {
        return a(ByteString.copyFromUtf8(str));
    }
}
