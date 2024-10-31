package com.nexstreaming.app.general.tracelog;

import com.nexstreaming.app.general.tracelog.TLP;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public class AuthPromocodeResponse implements TLP.BaseResponse {
    public String account_name;
    public String account_type;
    public String cache_exp_date;
    public String exp_date;
    public int result;
    public long log_date = 0;
    public int event_idx = 0;

    private Date getCacheExpDateInternal() {
        String str = this.cache_exp_date;
        if (str != null && str.length() >= 1) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(this.cache_exp_date);
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    public String getAccountName() {
        return this.account_name;
    }

    public String getAccountType() {
        return this.account_type;
    }

    public Date getCacheExpDate() {
        Date cacheExpDateInternal = getCacheExpDateInternal();
        if (cacheExpDateInternal != null) {
            return cacheExpDateInternal;
        }
        Date date = new Date(System.currentTimeMillis() - 1702967296);
        Date expDate = getExpDate();
        return expDate.after(date) ? date : expDate;
    }

    public Date getExpDate() {
        String str = this.exp_date;
        if (str != null && str.length() >= 1) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).parse(this.exp_date);
            } catch (ParseException unused) {
            }
        }
        return null;
    }

    public ResponseCode getResponseCode() {
        return ResponseCode.fromValue(this.result);
    }

    @Override // com.nexstreaming.app.general.tracelog.TLP.BaseResponse
    public int getResult() {
        return this.result;
    }
}
