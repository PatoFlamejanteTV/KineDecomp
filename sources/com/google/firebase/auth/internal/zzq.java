package com.google.firebase.auth.internal;

import android.text.TextUtils;
import com.google.android.gms.common.api.Status;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public final class zzq {
    public static Status a(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Status(17499);
        }
        String[] split = str.split(":", 2);
        split[0] = split[0].trim();
        if (split.length > 1 && split[1] != null) {
            split[1] = split[1].trim();
        }
        List asList = Arrays.asList(split);
        if (asList.size() > 1) {
            return a((String) asList.get(0), (String) asList.get(1));
        }
        return a((String) asList.get(0), null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static Status a(String str, String str2) {
        char c2;
        int i;
        switch (str.hashCode()) {
            case -2065866930:
                if (str.equals("INVALID_RECIPIENT_EMAIL")) {
                    c2 = 27;
                    break;
                }
                c2 = 65535;
                break;
            case -2014808264:
                if (str.equals("WEB_CONTEXT_ALREADY_PRESENTED")) {
                    c2 = '.';
                    break;
                }
                c2 = 65535;
                break;
            case -2001169389:
                if (str.equals("INVALID_IDP_RESPONSE")) {
                    c2 = 3;
                    break;
                }
                c2 = 65535;
                break;
            case -1944433728:
                if (str.equals("DYNAMIC_LINK_NOT_ACTIVATED")) {
                    c2 = ',';
                    break;
                }
                c2 = 65535;
                break;
            case -1800638118:
                if (str.equals("QUOTA_EXCEEDED")) {
                    c2 = '&';
                    break;
                }
                c2 = 65535;
                break;
            case -1774756919:
                if (str.equals("WEB_NETWORK_REQUEST_FAILED")) {
                    c2 = '(';
                    break;
                }
                c2 = 65535;
                break;
            case -1587614300:
                if (str.equals("EXPIRED_OOB_CODE")) {
                    c2 = 24;
                    break;
                }
                c2 = 65535;
                break;
            case -1583894766:
                if (str.equals("INVALID_OOB_CODE")) {
                    c2 = 23;
                    break;
                }
                c2 = 65535;
                break;
            case -1458751677:
                if (str.equals("MISSING_EMAIL")) {
                    c2 = 28;
                    break;
                }
                c2 = 65535;
                break;
            case -1421414571:
                if (str.equals("INVALID_CODE")) {
                    c2 = '!';
                    break;
                }
                c2 = 65535;
                break;
            case -1345867105:
                if (str.equals("TOKEN_EXPIRED")) {
                    c2 = 22;
                    break;
                }
                c2 = 65535;
                break;
            case -1232010689:
                if (str.equals("INVALID_SESSION_INFO")) {
                    c2 = '#';
                    break;
                }
                c2 = 65535;
                break;
            case -1112393964:
                if (str.equals("INVALID_EMAIL")) {
                    c2 = 6;
                    break;
                }
                c2 = 65535;
                break;
            case -863830559:
                if (str.equals("INVALID_CERT_HASH")) {
                    c2 = '\'';
                    break;
                }
                c2 = 65535;
                break;
            case -828507413:
                if (str.equals("NO_SUCH_PROVIDER")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case -736207500:
                if (str.equals("MISSING_PASSWORD")) {
                    c2 = 29;
                    break;
                }
                c2 = 65535;
                break;
            case -646022241:
                if (str.equals("CREDENTIAL_TOO_OLD_LOGIN_AGAIN")) {
                    c2 = 19;
                    break;
                }
                c2 = 65535;
                break;
            case -595928767:
                if (str.equals("TIMEOUT")) {
                    c2 = '\r';
                    break;
                }
                c2 = 65535;
                break;
            case -333672188:
                if (str.equals("OPERATION_NOT_ALLOWED")) {
                    c2 = 16;
                    break;
                }
                c2 = 65535;
                break;
            case -294485423:
                if (str.equals("WEB_INTERNAL_ERROR")) {
                    c2 = ')';
                    break;
                }
                c2 = 65535;
                break;
            case -75433118:
                if (str.equals("USER_NOT_FOUND")) {
                    c2 = '\b';
                    break;
                }
                c2 = 65535;
                break;
            case -40686718:
                if (str.equals("WEAK_PASSWORD")) {
                    c2 = 15;
                    break;
                }
                c2 = 65535;
                break;
            case 15352275:
                if (str.equals("EMAIL_NOT_FOUND")) {
                    c2 = 7;
                    break;
                }
                c2 = 65535;
                break;
            case 269327773:
                if (str.equals("INVALID_SENDER")) {
                    c2 = 26;
                    break;
                }
                c2 = 65535;
                break;
            case 278802867:
                if (str.equals("MISSING_PHONE_NUMBER")) {
                    c2 = 30;
                    break;
                }
                c2 = 65535;
                break;
            case 408411681:
                if (str.equals("INVALID_DYNAMIC_LINK_DOMAIN")) {
                    c2 = '1';
                    break;
                }
                c2 = 65535;
                break;
            case 483847807:
                if (str.equals("EMAIL_EXISTS")) {
                    c2 = '\t';
                    break;
                }
                c2 = 65535;
                break;
            case 491979549:
                if (str.equals("INVALID_ID_TOKEN")) {
                    c2 = '\f';
                    break;
                }
                c2 = 65535;
                break;
            case 492072102:
                if (str.equals("WEB_STORAGE_UNSUPPORTED")) {
                    c2 = '*';
                    break;
                }
                c2 = 65535;
                break;
            case 542728406:
                if (str.equals("PASSWORD_LOGIN_DISABLED")) {
                    c2 = 17;
                    break;
                }
                c2 = 65535;
                break;
            case 605031096:
                if (str.equals("REJECTED_CREDENTIAL")) {
                    c2 = '2';
                    break;
                }
                c2 = 65535;
                break;
            case 786916712:
                if (str.equals("INVALID_VERIFICATION_PROOF")) {
                    c2 = '$';
                    break;
                }
                c2 = 65535;
                break;
            case 799258561:
                if (str.equals("INVALID_PROVIDER_ID")) {
                    c2 = '-';
                    break;
                }
                c2 = 65535;
                break;
            case 819646646:
                if (str.equals("CREDENTIAL_MISMATCH")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 844240628:
                if (str.equals("WEB_CONTEXT_CANCELED")) {
                    c2 = '/';
                    break;
                }
                c2 = 65535;
                break;
            case 922685102:
                if (str.equals("INVALID_MESSAGE_PAYLOAD")) {
                    c2 = 25;
                    break;
                }
                c2 = 65535;
                break;
            case 989000548:
                if (str.equals("RESET_PASSWORD_EXCEED_LIMIT")) {
                    c2 = 21;
                    break;
                }
                c2 = 65535;
                break;
            case 1072360691:
                if (str.equals("INVALID_CUSTOM_TOKEN")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            case 1094975491:
                if (str.equals("INVALID_PASSWORD")) {
                    c2 = '\n';
                    break;
                }
                c2 = 65535;
                break;
            case 1107081238:
                if (str.equals("<<Network Error>>")) {
                    c2 = 14;
                    break;
                }
                c2 = 65535;
                break;
            case 1141576252:
                if (str.equals("SESSION_EXPIRED")) {
                    c2 = '%';
                    break;
                }
                c2 = 65535;
                break;
            case 1199811910:
                if (str.equals("MISSING_CODE")) {
                    c2 = ' ';
                    break;
                }
                c2 = 65535;
                break;
            case 1226505451:
                if (str.equals("FEDERATED_USER_ID_ALREADY_LINKED")) {
                    c2 = 11;
                    break;
                }
                c2 = 65535;
                break;
            case 1388786705:
                if (str.equals("INVALID_IDENTIFIER")) {
                    c2 = 5;
                    break;
                }
                c2 = 65535;
                break;
            case 1433767024:
                if (str.equals("USER_DISABLED")) {
                    c2 = 4;
                    break;
                }
                c2 = 65535;
                break;
            case 1442968770:
                if (str.equals("INVALID_PHONE_NUMBER")) {
                    c2 = 31;
                    break;
                }
                c2 = 65535;
                break;
            case 1494923453:
                if (str.equals("INVALID_APP_CREDENTIAL")) {
                    c2 = 18;
                    break;
                }
                c2 = 65535;
                break;
            case 1497901284:
                if (str.equals("TOO_MANY_ATTEMPTS_TRY_LATER")) {
                    c2 = 20;
                    break;
                }
                c2 = 65535;
                break;
            case 1803454477:
                if (str.equals("MISSING_CONTINUE_URI")) {
                    c2 = '+';
                    break;
                }
                c2 = 65535;
                break;
            case 1898790704:
                if (str.equals("MISSING_SESSION_INFO")) {
                    c2 = '\"';
                    break;
                }
                c2 = 65535;
                break;
            case 2082564316:
                if (str.equals("UNSUPPORTED_TENANT_OPERATION")) {
                    c2 = '0';
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        switch (c2) {
            case 0:
                i = 17016;
                break;
            case 1:
                i = 17002;
                break;
            case 2:
                i = 17000;
                break;
            case 3:
                i = 17004;
                break;
            case 4:
                i = 17005;
                break;
            case 5:
            case 6:
                i = 17008;
                break;
            case 7:
            case '\b':
                i = 17011;
                break;
            case '\t':
                i = 17007;
                break;
            case '\n':
                i = 17009;
                break;
            case 11:
                i = 17025;
                break;
            case '\f':
                i = 17017;
                break;
            case '\r':
            case 14:
                i = 17020;
                break;
            case 15:
                i = 17026;
                break;
            case 16:
            case 17:
                i = 17006;
                break;
            case 18:
                i = 17028;
                break;
            case 19:
                i = 17014;
                break;
            case 20:
            case 21:
                i = 17010;
                break;
            case 22:
                i = 17021;
                break;
            case 23:
                i = 17030;
                break;
            case 24:
                i = 17029;
                break;
            case 25:
                i = 17031;
                break;
            case 26:
                i = 17032;
                break;
            case 27:
                i = 17033;
                break;
            case 28:
                i = 17034;
                break;
            case 29:
                i = 17035;
                break;
            case 30:
                i = 17041;
                break;
            case 31:
                i = 17042;
                break;
            case ' ':
                i = 17043;
                break;
            case '!':
                i = 17044;
                break;
            case '\"':
                i = 17045;
                break;
            case '#':
                i = 17046;
                break;
            case '$':
                i = 17049;
                break;
            case '%':
                i = 17051;
                break;
            case '&':
                i = 17052;
                break;
            case '\'':
                i = 17064;
                break;
            case '(':
                i = 17061;
                break;
            case ')':
                i = 17062;
                break;
            case '*':
                i = 17065;
                break;
            case '+':
                i = 17040;
                break;
            case ',':
                i = 17068;
                break;
            case '-':
                i = 17071;
                break;
            case '.':
                i = 17057;
                break;
            case '/':
                i = 17058;
                break;
            case '0':
                i = 17073;
                break;
            case '1':
                i = 17074;
                break;
            case '2':
                i = 17075;
                break;
            default:
                i = 17499;
                break;
        }
        if (i != 17499) {
            return new Status(i, str2);
        }
        if (str2 != null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
            sb.append(str);
            sb.append(":");
            sb.append(str2);
            return new Status(i, sb.toString());
        }
        return new Status(i, str);
    }
}
