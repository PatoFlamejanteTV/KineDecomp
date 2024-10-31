package com.nexstreaming.app.general.util;

import java.util.Random;

/* loaded from: classes.dex */
public class DiagnosticLogger {
    private static final DiagnosticLogger b = new DiagnosticLogger();
    private StringBuilder c = new StringBuilder();

    /* renamed from: a, reason: collision with root package name */
    boolean f3219a = false;
    private String d = null;

    /* loaded from: classes.dex */
    public interface a {
        int getIntErrorCode();
    }

    /* loaded from: classes.dex */
    public enum Tag {
        NEF_CLICK_EXPORT("A"),
        NEF_APC_VALID("B"),
        NEF_APC_NONE_CACHED("C"),
        NEF_APC_NONE_UNCACHED("D"),
        NEF_START_EXPORT_WM("E"),
        NEF_START_EXPORT_NOWM("ZF"),
        NEF_SUB_HAS("G"),
        NEF_SUB_NOHAS_OKSKU("ZV"),
        APCM_UNEX_CC("ZA"),
        APCM_HFAIL("J"),
        APCM_UNEX_NEG("K"),
        IW_GETSKU_INVALID("ZG"),
        IW_GETSKU_OK("M"),
        IW_GETSKU_MISSING("FT"),
        IW_P_NOTVALID("ZB"),
        IW_P_NOTVALID_INAPP("ZU"),
        IW_P_NOTPURCHASED_REFUNDED("FG"),
        IW_P_NOTPURCHASED_CANCELED("FJ"),
        IW_P_NOTPURCHASED_OTHER("FK"),
        IW_P_NO_PLD("S"),
        IW_P_OLD_PLD("T"),
        IW_P_BAD_PLD("FM"),
        IW_P_OK_PLD("V"),
        IW_P_PREFIX_OK("WA"),
        IW_P_PREFIX_OK_INAPP("WB"),
        IW_P_PREFIX_NOT_FOUND("XA"),
        IW_P_PREFIX_NOT_FOUND_INAPP("XB"),
        IW_P_SUFFIX_MALFORMED("XC"),
        IW_P_EXPIRED("XD"),
        IH_GET_PURCHASES_START("H"),
        IH_SCONN_OK("ZC"),
        IH_SCONN_DIS("ZD"),
        IH_GETSKU_SCONN_DIS("PA"),
        IH_GETSKU_SCONN_NOCTX("PB"),
        IH_VFY_SVF("ZE"),
        IH_VFY_SVOK("L"),
        IH_VFY_NSALGO("ZH"),
        IH_VFY_INVALKEY("ZM"),
        IH_VFY_SIGEX("ZJ"),
        IH_VFY_SVX("ZK"),
        IH_VFY_SKIP("ZL"),
        IH_BIND_FAIL("FL");

        final String code;

        Tag(String str) {
            this.code = str;
        }
    }

    /* loaded from: classes.dex */
    public enum ParamTag {
        NEF_APC_FAIL_GET_STATUS("FA"),
        NEF_SUB_NOHAS_BADSKU("FB"),
        NEF_SUB_FAIL("FC"),
        APCM_FAIL("FD"),
        APCM_RESPONSE("ZT"),
        IW_GETP_FAIL("FE"),
        IW_GETP_FAIL_INAPP("FW"),
        IW_GETSKU_FAIL("FF"),
        IW_GETP_RESULT("ZP"),
        IW_GETP_RESULT_INAPP("ZN"),
        IH_LIST_SIZES("ZW"),
        IH_VFY_CONT("ZR"),
        IH_GETP_SIZE("ZS"),
        IH_GETSKU_SCONN_EX("PC"),
        IH_GETSKU_FAIL("PD"),
        IH_GETSKU_OK("PE");

        final String code;

        ParamTag(String str) {
            this.code = str;
        }
    }

    private DiagnosticLogger() {
    }

    public static DiagnosticLogger a() {
        return b;
    }

    private static boolean a(char c) {
        return c >= '0' && c <= '9';
    }

    private void c() {
        if (this.c.length() > 100) {
            this.c.setLength(100);
        }
    }

    public synchronized void a(Tag tag) {
        if (this.f3219a && a(tag.code.charAt(0))) {
            this.c.append('Y');
        }
        this.f3219a = false;
        this.c.append(tag.code);
        c();
    }

    public synchronized void a(ParamTag paramTag, int i) {
        this.c.append(paramTag.code);
        this.c.append(i);
        this.f3219a = true;
        c();
    }

    public synchronized void b() {
        if (this.d == null) {
            this.d = toString();
        }
    }

    public synchronized String toString() {
        String str;
        if (this.d != null) {
            str = this.d;
        } else {
            int nextInt = (new Random().nextInt() & 268435455) % 32;
            c();
            String str2 = "A" + "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt(nextInt) + a(this.c.toString().replace("0Z", "N").replace("1Z", "Q").replace("0F", "U"), "AY71GR3BU6D0SKE84Q9PZLJVTCX2M5FWNH", "T24GMZAHC7W8D1LR6KBPUV50EJNQ3X9FYS", nextInt);
            int length = str2.length();
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                char charAt = str2.charAt(i3);
                i2 = (i2 * 31) + charAt;
                i = (i * 17) + charAt;
            }
            String str3 = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt(i2 & 31) + str2 + "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt(i & 31);
            int length2 = str3.length();
            str = "";
            int i4 = 0;
            while (true) {
                if (i4 >= length2) {
                    break;
                }
                if (str.length() > 0) {
                    str = str + "-";
                }
                if (length2 - i4 < 7) {
                    str = str + str3.substring(i4);
                    break;
                }
                String str4 = str + str3.substring(i4, i4 + 4);
                i4 += 4;
                str = str4;
            }
        }
        return str;
    }

    private String a(String str, String str2, String str3, int i) {
        int length = str.length();
        String str4 = "";
        int i2 = i;
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            int indexOf = str2.indexOf(charAt);
            if (indexOf < 0) {
                str4 = str4 + charAt;
            } else {
                str4 = str4 + str3.charAt((indexOf + i2) % 34);
                i2 = (i2 + indexOf) % 34;
            }
        }
        return str4;
    }
}
