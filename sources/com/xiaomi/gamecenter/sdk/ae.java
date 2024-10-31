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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ MiCommplatform f4881a;
    private Activity b;
    private MiResponseHandler c;
    private Object[] d;
    private int e;

    public ae(MiCommplatform miCommplatform, Activity activity, int i, MiResponseHandler miResponseHandler, Object... objArr) {
        this.f4881a = miCommplatform;
        this.b = activity;
        this.c = miResponseHandler;
        this.d = objArr;
        this.e = i;
        new Thread(this).start();
    }

    private MiGamMessageResponse a(int i) {
        IGameCenterSDK iGameCenterSDK;
        MiliaoInfo miliaoInfo;
        MiGamMessageResponse shareToMiTalkForImgAndUrl;
        IGameCenterSDK iGameCenterSDK2;
        IGameCenterSDK iGameCenterSDK3;
        IGameCenterSDK iGameCenterSDK4;
        MiliaoInfo miliaoInfo2;
        IGameCenterSDK iGameCenterSDK5;
        MiliaoInfo miliaoInfo3;
        IGameCenterSDK iGameCenterSDK6;
        IGameCenterSDK iGameCenterSDK7;
        IGameCenterSDK iGameCenterSDK8;
        MiliaoInfo miliaoInfo4;
        IGameCenterSDK iGameCenterSDK9;
        MiliaoInfo miliaoInfo5;
        IGameCenterSDK iGameCenterSDK10;
        IGameCenterSDK iGameCenterSDK11;
        IGameCenterSDK iGameCenterSDK12;
        IGameCenterSDK iGameCenterSDK13;
        String str;
        IGameCenterSDK iGameCenterSDK14;
        String str2;
        IGameCenterSDK iGameCenterSDK15;
        IGameCenterSDK iGameCenterSDK16;
        IGameCenterSDK iGameCenterSDK17;
        IGameCenterSDK iGameCenterSDK18;
        IGameCenterSDK iGameCenterSDK19;
        IGameCenterSDK iGameCenterSDK20;
        IGameCenterSDK iGameCenterSDK21;
        IGameCenterSDK iGameCenterSDK22;
        try {
            switch (i) {
                case 1:
                    iGameCenterSDK22 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK22.loadGameInfo();
                    break;
                case 2:
                    iGameCenterSDK21 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK21.loadGameMe();
                    break;
                case 3:
                    iGameCenterSDK20 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK20.loadGameFriends();
                    break;
                case 4:
                    int intValue = ((Integer) this.d[0]).intValue();
                    int intValue2 = ((Integer) this.d[1]).intValue();
                    byte[] bArr = (byte[]) this.d[2];
                    byte[] bArr2 = (byte[]) this.d[3];
                    iGameCenterSDK18 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK18.updateMe(intValue, intValue2, bArr, bArr2);
                    break;
                case 5:
                    iGameCenterSDK19 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK19.loadGameMessage();
                    break;
                case 6:
                    String str3 = (String) this.d[0];
                    boolean booleanValue = ((Boolean) this.d[1]).booleanValue();
                    String str4 = (String) this.d[2];
                    String str5 = (String) this.d[3];
                    int intValue3 = ((Integer) this.d[4]).intValue();
                    byte[] bArr3 = (byte[]) this.d[5];
                    List list = (List) this.d[6];
                    iGameCenterSDK12 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK12.sendGameMessage(str3, booleanValue, str4, str5, intValue3, bArr3, a(list));
                    break;
                case 7:
                    String str6 = (String) this.d[0];
                    iGameCenterSDK17 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK17.acceptMessage(str6);
                    break;
                case 8:
                    iGameCenterSDK16 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK16.acceptAllMessage();
                    break;
                case 9:
                    int intValue4 = ((Integer) this.d[0]).intValue();
                    boolean booleanValue2 = ((Boolean) this.d[1]).booleanValue();
                    iGameCenterSDK15 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK15.useHeart(intValue4, booleanValue2);
                    break;
                case 10:
                    String str7 = (String) this.d[0];
                    int intValue5 = ((Integer) this.d[1]).intValue();
                    int intValue6 = ((Integer) this.d[2]).intValue();
                    byte[] bArr4 = (byte[]) this.d[3];
                    byte[] bArr5 = (byte[]) this.d[4];
                    int intValue7 = ((Integer) this.d[5]).intValue();
                    String str8 = (String) this.d[6];
                    iGameCenterSDK14 = this.f4881a.sdk;
                    str2 = this.f4881a.useHeartToken;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK14.updateResult(str7, intValue5, intValue6, bArr4, bArr5, str2, intValue7, str8);
                    break;
                case 11:
                    HashMap hashMap = (HashMap) this.d[0];
                    int intValue8 = ((Integer) this.d[1]).intValue();
                    byte[] bArr6 = (byte[]) this.d[2];
                    byte[] bArr7 = (byte[]) this.d[3];
                    int intValue9 = ((Integer) this.d[4]).intValue();
                    String str9 = (String) this.d[5];
                    iGameCenterSDK13 = this.f4881a.sdk;
                    ScoresEntry[] a2 = a(hashMap);
                    str = this.f4881a.useHeartToken;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK13.updateResults(a2, intValue8, bArr6, bArr7, str, intValue9, str9);
                    break;
                case 12:
                    String str10 = (String) this.d[0];
                    int intValue10 = ((Integer) this.d[1]).intValue();
                    int intValue11 = ((Integer) this.d[2]).intValue();
                    iGameCenterSDK11 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK11.loadLeaderBoard(str10, intValue10, intValue11);
                    break;
                case 13:
                    boolean booleanValue3 = ((Boolean) this.d[0]).booleanValue();
                    iGameCenterSDK10 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK10.messageBlock(booleanValue3);
                    break;
                case 14:
                    String str11 = (String) this.d[0];
                    boolean booleanValue4 = ((Boolean) this.d[1]).booleanValue();
                    String str12 = (String) this.d[2];
                    List list2 = (List) this.d[3];
                    iGameCenterSDK9 = this.f4881a.sdk;
                    GamMetaInfo[] a3 = a(list2);
                    miliaoInfo5 = this.f4881a.miliaoInfo;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK9.sendInviteMessage(str11, booleanValue4, str12, a3, miliaoInfo5);
                    break;
                case 15:
                    iGameCenterSDK7 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK7.deleteMe();
                    break;
                case 16:
                    iGameCenterSDK6 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK6.loadLotteryPrize();
                    break;
                case 17:
                    String str13 = (String) this.d[0];
                    String str14 = (String) this.d[1];
                    String str15 = (String) this.d[2];
                    iGameCenterSDK5 = this.f4881a.sdk;
                    miliaoInfo3 = this.f4881a.miliaoInfo;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK5.shareToMiliao(miliaoInfo3, str13, str14, str15);
                    break;
                case 18:
                    String str16 = (String) this.d[0];
                    int intValue12 = ((Integer) this.d[1]).intValue();
                    int intValue13 = ((Integer) this.d[2]).intValue();
                    byte[] bArr8 = (byte[]) this.d[3];
                    byte[] bArr9 = (byte[]) this.d[4];
                    iGameCenterSDK3 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK3.syncResult(str16, intValue12, intValue13, bArr8, bArr9);
                    break;
                case 19:
                    HashMap hashMap2 = (HashMap) this.d[0];
                    int intValue14 = ((Integer) this.d[1]).intValue();
                    byte[] bArr10 = (byte[]) this.d[2];
                    byte[] bArr11 = (byte[]) this.d[3];
                    iGameCenterSDK2 = this.f4881a.sdk;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK2.syncResults(a(hashMap2), intValue14, bArr10, bArr11);
                    break;
                case 20:
                    String str17 = (String) this.d[0];
                    String str18 = (String) this.d[1];
                    iGameCenterSDK4 = this.f4881a.sdk;
                    miliaoInfo2 = this.f4881a.miliaoInfo;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK4.shareToMiliaoForLargeImg(str18, str17, miliaoInfo2);
                    break;
                case 21:
                    String str19 = (String) this.d[0];
                    String str20 = (String) this.d[1];
                    String str21 = (String) this.d[2];
                    iGameCenterSDK8 = this.f4881a.sdk;
                    miliaoInfo4 = this.f4881a.miliaoInfo;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK8.sendInviteMessageNew(str19, str20, str21, miliaoInfo4);
                    break;
                case 22:
                    String str22 = (String) this.d[0];
                    String str23 = (String) this.d[1];
                    String str24 = (String) this.d[2];
                    String str25 = (String) this.d[3];
                    iGameCenterSDK = this.f4881a.sdk;
                    miliaoInfo = this.f4881a.miliaoInfo;
                    shareToMiTalkForImgAndUrl = iGameCenterSDK.shareToMiTalkForImgAndUrl(str22, str23, str24, str25, miliaoInfo);
                    break;
                default:
                    return null;
            }
            return shareToMiTalkForImgAndUrl;
        } catch (Exception e) {
            e.printStackTrace();
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
            String str = (String) ((Map) list.get(i)).get("os");
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
        Set entrySet = hashMap.entrySet();
        ScoresEntry[] scoresEntryArr = new ScoresEntry[entrySet.size()];
        int i = 0;
        Iterator it = entrySet.iterator();
        while (true) {
            int i2 = i;
            if (!it.hasNext()) {
                return scoresEntryArr;
            }
            Map.Entry entry = (Map.Entry) it.next();
            ScoresEntry scoresEntry = new ScoresEntry();
            String str = (String) entry.getKey();
            int intValue = ((Integer) entry.getValue()).intValue();
            scoresEntry.setScoreKey(str);
            scoresEntry.setScoreValue(intValue);
            scoresEntryArr[i2] = scoresEntry;
            i = i2 + 1;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        Context context2;
        int check_and_connect;
        Context context3;
        boolean check_user_changed;
        MiliaoInfo miliaoInfo;
        Context context4;
        try {
            try {
                check_and_connect = this.f4881a.check_and_connect(this.b, false);
                if (check_and_connect != 0) {
                    this.f4881a.mTouch = false;
                    this.c.sendResultMsg(-107, null);
                    this.f4881a.mTouch = false;
                    MiCommplatform miCommplatform = this.f4881a;
                    context4 = this.f4881a.ctx;
                    miCommplatform.disconnect(context4);
                    return;
                }
                MiGamMessageResponse a2 = a(this.e);
                if (a2 != null) {
                    this.f4881a.mTouch = false;
                    check_user_changed = this.f4881a.check_user_changed(this.b, a2.getSdkStatus());
                    if (!check_user_changed) {
                        if (this.e == 10 || this.e == 11) {
                            this.f4881a.useHeartToken = null;
                        }
                        if (this.e == 1 && (miliaoInfo = a2.getMiliaoInfo()) != null) {
                            this.f4881a.miliaoInfo = miliaoInfo;
                        }
                        if (this.e == 9 && !TextUtils.isEmpty(a2.getHeartToken())) {
                            this.f4881a.useHeartToken = a2.getHeartToken();
                        }
                        this.c.sendResultMsg(a2.getSdkStatus(), a2.getMsgResult());
                    }
                } else {
                    this.c.sendResultMsg(-107, null);
                }
                this.f4881a.mTouch = false;
                MiCommplatform miCommplatform2 = this.f4881a;
                context3 = this.f4881a.ctx;
                miCommplatform2.disconnect(context3);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    this.f4881a.mTouch = false;
                    this.c.sendResultMsg(-107, null);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f4881a.mTouch = false;
                MiCommplatform miCommplatform3 = this.f4881a;
                context = this.f4881a.ctx;
                miCommplatform3.disconnect(context);
            }
        } catch (Throwable th) {
            this.f4881a.mTouch = false;
            MiCommplatform miCommplatform4 = this.f4881a;
            context2 = this.f4881a.ctx;
            miCommplatform4.disconnect(context2);
            throw th;
        }
    }
}
