package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.gamecenter.sdk.gam.GamMetaInfo;
import com.xiaomi.gamecenter.sdk.gam.MiGamMessageResponse;
import com.xiaomi.gamecenter.sdk.gam.MiResponseHandler;
import com.xiaomi.gamecenter.sdk.gam.MiliaoInfo;
import com.xiaomi.gamecenter.sdk.gam.ScoresEntry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes3.dex */
class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f26558a;

    /* renamed from: b, reason: collision with root package name */
    private Activity f26559b;

    /* renamed from: c, reason: collision with root package name */
    private MiResponseHandler f26560c;

    /* renamed from: d, reason: collision with root package name */
    private Object[] f26561d;

    /* renamed from: e, reason: collision with root package name */
    private int f26562e;

    public ae(MiCommplatform miCommplatform, Activity activity, int i, MiResponseHandler miResponseHandler, Object... objArr) {
        this.f26558a = miCommplatform;
        this.f26559b = activity;
        this.f26560c = miResponseHandler;
        this.f26561d = objArr;
        this.f26562e = i;
        new Thread(this).start();
    }

    private MiGamMessageResponse a(int i) {
        IGameCenterSDK iGameCenterSDK;
        IGameCenterSDK iGameCenterSDK2;
        IGameCenterSDK iGameCenterSDK3;
        IGameCenterSDK iGameCenterSDK4;
        IGameCenterSDK iGameCenterSDK5;
        IGameCenterSDK iGameCenterSDK6;
        IGameCenterSDK iGameCenterSDK7;
        IGameCenterSDK iGameCenterSDK8;
        IGameCenterSDK iGameCenterSDK9;
        IGameCenterSDK iGameCenterSDK10;
        String str;
        IGameCenterSDK iGameCenterSDK11;
        String str2;
        IGameCenterSDK iGameCenterSDK12;
        IGameCenterSDK iGameCenterSDK13;
        IGameCenterSDK iGameCenterSDK14;
        MiliaoInfo miliaoInfo;
        IGameCenterSDK iGameCenterSDK15;
        IGameCenterSDK iGameCenterSDK16;
        IGameCenterSDK iGameCenterSDK17;
        MiliaoInfo miliaoInfo2;
        IGameCenterSDK iGameCenterSDK18;
        IGameCenterSDK iGameCenterSDK19;
        IGameCenterSDK iGameCenterSDK20;
        MiliaoInfo miliaoInfo3;
        IGameCenterSDK iGameCenterSDK21;
        MiliaoInfo miliaoInfo4;
        IGameCenterSDK iGameCenterSDK22;
        MiliaoInfo miliaoInfo5;
        try {
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        switch (i) {
            case 1:
                iGameCenterSDK = this.f26558a.sdk;
                return iGameCenterSDK.loadGameInfo();
            case 2:
                iGameCenterSDK2 = this.f26558a.sdk;
                return iGameCenterSDK2.loadGameMe();
            case 3:
                iGameCenterSDK3 = this.f26558a.sdk;
                return iGameCenterSDK3.loadGameFriends();
            case 4:
                int intValue = ((Integer) this.f26561d[0]).intValue();
                int intValue2 = ((Integer) this.f26561d[1]).intValue();
                byte[] bArr = (byte[]) this.f26561d[2];
                byte[] bArr2 = (byte[]) this.f26561d[3];
                iGameCenterSDK4 = this.f26558a.sdk;
                return iGameCenterSDK4.updateMe(intValue, intValue2, bArr, bArr2);
            case 5:
                iGameCenterSDK5 = this.f26558a.sdk;
                return iGameCenterSDK5.loadGameMessage();
            case 6:
                String str3 = (String) this.f26561d[0];
                boolean booleanValue = ((Boolean) this.f26561d[1]).booleanValue();
                String str4 = (String) this.f26561d[2];
                String str5 = (String) this.f26561d[3];
                int intValue3 = ((Integer) this.f26561d[4]).intValue();
                byte[] bArr3 = (byte[]) this.f26561d[5];
                List list = (List) this.f26561d[6];
                iGameCenterSDK6 = this.f26558a.sdk;
                return iGameCenterSDK6.sendGameMessage(str3, booleanValue, str4, str5, intValue3, bArr3, a(list));
            case 7:
                String str6 = (String) this.f26561d[0];
                iGameCenterSDK7 = this.f26558a.sdk;
                return iGameCenterSDK7.acceptMessage(str6);
            case 8:
                iGameCenterSDK8 = this.f26558a.sdk;
                return iGameCenterSDK8.acceptAllMessage();
            case 9:
                int intValue4 = ((Integer) this.f26561d[0]).intValue();
                boolean booleanValue2 = ((Boolean) this.f26561d[1]).booleanValue();
                iGameCenterSDK9 = this.f26558a.sdk;
                return iGameCenterSDK9.useHeart(intValue4, booleanValue2);
            case 10:
                String str7 = (String) this.f26561d[0];
                int intValue5 = ((Integer) this.f26561d[1]).intValue();
                int intValue6 = ((Integer) this.f26561d[2]).intValue();
                byte[] bArr4 = (byte[]) this.f26561d[3];
                byte[] bArr5 = (byte[]) this.f26561d[4];
                int intValue7 = ((Integer) this.f26561d[5]).intValue();
                String str8 = (String) this.f26561d[6];
                iGameCenterSDK10 = this.f26558a.sdk;
                str = this.f26558a.useHeartToken;
                return iGameCenterSDK10.updateResult(str7, intValue5, intValue6, bArr4, bArr5, str, intValue7, str8);
            case 11:
                HashMap hashMap = (HashMap) this.f26561d[0];
                int intValue8 = ((Integer) this.f26561d[1]).intValue();
                byte[] bArr6 = (byte[]) this.f26561d[2];
                byte[] bArr7 = (byte[]) this.f26561d[3];
                int intValue9 = ((Integer) this.f26561d[4]).intValue();
                String str9 = (String) this.f26561d[5];
                iGameCenterSDK11 = this.f26558a.sdk;
                ScoresEntry[] a2 = a(hashMap);
                str2 = this.f26558a.useHeartToken;
                return iGameCenterSDK11.updateResults(a2, intValue8, bArr6, bArr7, str2, intValue9, str9);
            case 12:
                String str10 = (String) this.f26561d[0];
                int intValue10 = ((Integer) this.f26561d[1]).intValue();
                int intValue11 = ((Integer) this.f26561d[2]).intValue();
                iGameCenterSDK12 = this.f26558a.sdk;
                return iGameCenterSDK12.loadLeaderBoard(str10, intValue10, intValue11);
            case 13:
                boolean booleanValue3 = ((Boolean) this.f26561d[0]).booleanValue();
                iGameCenterSDK13 = this.f26558a.sdk;
                return iGameCenterSDK13.messageBlock(booleanValue3);
            case 14:
                String str11 = (String) this.f26561d[0];
                boolean booleanValue4 = ((Boolean) this.f26561d[1]).booleanValue();
                String str12 = (String) this.f26561d[2];
                List list2 = (List) this.f26561d[3];
                iGameCenterSDK14 = this.f26558a.sdk;
                GamMetaInfo[] a3 = a(list2);
                miliaoInfo = this.f26558a.miliaoInfo;
                return iGameCenterSDK14.sendInviteMessage(str11, booleanValue4, str12, a3, miliaoInfo);
            case 15:
                iGameCenterSDK15 = this.f26558a.sdk;
                return iGameCenterSDK15.deleteMe();
            case 16:
                iGameCenterSDK16 = this.f26558a.sdk;
                return iGameCenterSDK16.loadLotteryPrize();
            case 17:
                String str13 = (String) this.f26561d[0];
                String str14 = (String) this.f26561d[1];
                String str15 = (String) this.f26561d[2];
                iGameCenterSDK17 = this.f26558a.sdk;
                miliaoInfo2 = this.f26558a.miliaoInfo;
                return iGameCenterSDK17.shareToMiliao(miliaoInfo2, str13, str14, str15);
            case 18:
                String str16 = (String) this.f26561d[0];
                int intValue12 = ((Integer) this.f26561d[1]).intValue();
                int intValue13 = ((Integer) this.f26561d[2]).intValue();
                byte[] bArr8 = (byte[]) this.f26561d[3];
                byte[] bArr9 = (byte[]) this.f26561d[4];
                iGameCenterSDK18 = this.f26558a.sdk;
                return iGameCenterSDK18.syncResult(str16, intValue12, intValue13, bArr8, bArr9);
            case 19:
                HashMap hashMap2 = (HashMap) this.f26561d[0];
                int intValue14 = ((Integer) this.f26561d[1]).intValue();
                byte[] bArr10 = (byte[]) this.f26561d[2];
                byte[] bArr11 = (byte[]) this.f26561d[3];
                iGameCenterSDK19 = this.f26558a.sdk;
                return iGameCenterSDK19.syncResults(a(hashMap2), intValue14, bArr10, bArr11);
            case 20:
                String str17 = (String) this.f26561d[0];
                String str18 = (String) this.f26561d[1];
                iGameCenterSDK20 = this.f26558a.sdk;
                miliaoInfo3 = this.f26558a.miliaoInfo;
                return iGameCenterSDK20.shareToMiliaoForLargeImg(str18, str17, miliaoInfo3);
            case 21:
                String str19 = (String) this.f26561d[0];
                String str20 = (String) this.f26561d[1];
                String str21 = (String) this.f26561d[2];
                iGameCenterSDK21 = this.f26558a.sdk;
                miliaoInfo4 = this.f26558a.miliaoInfo;
                return iGameCenterSDK21.sendInviteMessageNew(str19, str20, str21, miliaoInfo4);
            case 22:
                String str22 = (String) this.f26561d[0];
                String str23 = (String) this.f26561d[1];
                String str24 = (String) this.f26561d[2];
                String str25 = (String) this.f26561d[3];
                iGameCenterSDK22 = this.f26558a.sdk;
                miliaoInfo5 = this.f26558a.miliaoInfo;
                return iGameCenterSDK22.shareToMiTalkForImgAndUrl(str22, str23, str24, str25, miliaoInfo5);
            default:
                return null;
        }
    }

    private GamMetaInfo[] a(List list) {
        if (list == null) {
            return null;
        }
        int size = list.size();
        GamMetaInfo[] gamMetaInfoArr = new GamMetaInfo[size];
        for (int i = 0; i < size; i++) {
            GamMetaInfo gamMetaInfo = new GamMetaInfo();
            String str = (String) ((Map) list.get(i)).get(com.umeng.commonsdk.proguard.e.w);
            String str2 = (String) ((Map) list.get(i)).get("executeurl");
            gamMetaInfo.setOs(str);
            if (str2 != null) {
                gamMetaInfo.setExecuteurl(str2);
            }
            gamMetaInfoArr[i] = gamMetaInfo;
        }
        return gamMetaInfoArr;
    }

    private ScoresEntry[] a(HashMap hashMap) {
        if (hashMap == null) {
            return null;
        }
        Set<Map.Entry> entrySet = hashMap.entrySet();
        ScoresEntry[] scoresEntryArr = new ScoresEntry[entrySet.size()];
        int i = 0;
        for (Map.Entry entry : entrySet) {
            ScoresEntry scoresEntry = new ScoresEntry();
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            scoresEntry.setScoreKey(str);
            scoresEntry.setScoreValue(intValue);
            scoresEntryArr[i] = scoresEntry;
            i++;
        }
        return scoresEntryArr;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        int check_and_connect;
        boolean check_user_changed;
        MiliaoInfo miliaoInfo;
        try {
            try {
                check_and_connect = this.f26558a.check_and_connect(this.f26559b, false);
            } catch (Exception e2) {
                e2.printStackTrace();
                try {
                    this.f26558a.mTouch = false;
                    this.f26560c.sendResultMsg(-107, null);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
            if (check_and_connect != 0) {
                this.f26558a.mTouch = false;
                this.f26560c.sendResultMsg(-107, null);
                return;
            }
            MiGamMessageResponse a2 = a(this.f26562e);
            if (a2 != null) {
                this.f26558a.mTouch = false;
                check_user_changed = this.f26558a.check_user_changed(this.f26559b, a2.getSdkStatus());
                if (!check_user_changed) {
                    if (this.f26562e == 10 || this.f26562e == 11) {
                        this.f26558a.useHeartToken = null;
                    }
                    if (this.f26562e == 1 && (miliaoInfo = a2.getMiliaoInfo()) != null) {
                        this.f26558a.miliaoInfo = miliaoInfo;
                    }
                    if (this.f26562e == 9 && !TextUtils.isEmpty(a2.getHeartToken())) {
                        this.f26558a.useHeartToken = a2.getHeartToken();
                    }
                    this.f26560c.sendResultMsg(a2.getSdkStatus(), a2.getMsgResult());
                }
            } else {
                this.f26560c.sendResultMsg(-107, null);
            }
        } finally {
            this.f26558a.mTouch = false;
            MiCommplatform miCommplatform = this.f26558a;
            context = miCommplatform.ctx;
            miCommplatform.disconnect(context);
        }
    }
}
