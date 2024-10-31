package com.nexstreaming.app.general.util;

import java.util.Random;

/* loaded from: classes2.dex */
public class DiagnosticLogger {

    /* renamed from: a */
    private static final DiagnosticLogger f19804a = new DiagnosticLogger();

    /* renamed from: b */
    private StringBuilder f19805b = new StringBuilder();

    /* renamed from: c */
    boolean f19806c = false;

    /* renamed from: d */
    private String f19807d = null;

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
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

    /* loaded from: classes2.dex */
    public interface a {
        int getIntErrorCode();
    }

    private DiagnosticLogger() {
    }

    private static boolean a(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static DiagnosticLogger b() {
        return f19804a;
    }

    private void c() {
        if (this.f19805b.length() > 100) {
            this.f19805b.setLength(100);
        }
    }

    public synchronized void a(Tag tag) {
        if (this.f19806c && a(tag.code.charAt(0))) {
            this.f19805b.append('Y');
        }
        this.f19806c = false;
        this.f19805b.append(tag.code);
        c();
    }

    public synchronized String toString() {
        if (this.f19807d != null) {
            return this.f19807d;
        }
        int nextInt = (new Random().nextInt() & 268435455) % 32;
        c();
        String str = "A" + "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt(nextInt) + a(this.f19805b.toString().replace("0Z", "N").replace("1Z", "Q").replace("0F", "U"), "AY71GR3BU6D0SKE84Q9PZLJVTCX2M5FWNH", "T24GMZAHC7W8D1LR6KBPUV50EJNQ3X9FYS", nextInt);
        int length = str.length();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            i2 = (i2 * 31) + charAt;
            i3 = (i3 * 17) + charAt;
        }
        String str2 = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt(i2 & 31) + str + "ABCDEFGHJKLMNPQRSTUVWXYZ23456789".charAt(i3 & 31);
        String str3 = "";
        int length2 = str2.length();
        while (true) {
            if (i >= length2) {
                break;
            }
            if (str3.length() > 0) {
                str3 = str3 + "-";
            }
            if (length2 - i < 7) {
                str3 = str3 + str2.substring(i);
                break;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            int i5 = i + 4;
            sb.append(str2.substring(i, i5));
            i = i5;
            str3 = sb.toString();
        }
        return str3;
    }

    public synchronized void a(ParamTag paramTag, int i) {
        this.f19805b.append(paramTag.code);
        this.f19805b.append(i);
        this.f19806c = true;
        c();
    }

    public synchronized void a() {
        if (this.f19807d == null) {
            this.f19807d = toString();
        }
    }

    private String a(String str, String str2, String str3, int i) {
        int length = str.length();
        String str4 = "";
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            int indexOf = str2.indexOf(charAt);
            if (indexOf < 0) {
                str4 = str4 + charAt;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(str4);
                int i3 = (indexOf + i) % 34;
                sb.append(str3.charAt(i3));
                str4 = sb.toString();
                i = i3;
            }
        }
        return str4;
    }
}
