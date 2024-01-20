package com.bekiristek.bankingapp.model.dto;

/**
 * Http Hata Kodların sabit olarak tanımlandığı sınıfdır.
 * <p>
 * Bu sınıfta tanımlanan her hata kodu açıklaması dil dosyasında tanımı yapılmalıdır.
 *
 * <p>
 * 1XX -5XX arası reserve olduğu için hata kodları 6XX ile başlamalıdır.
 */
public final class ServiceResultStatusCode {


    private ServiceResultStatusCode() throws IllegalAccessException {
        throw new IllegalAccessException();
    }

    /**
     * İşlemin başarılı olduğunu  ifade eder
     */
    public static final int SUCCESS = 200;

    /**
     * İşlemin başarısız olduğunu  ifade eder
     */
    public static final int ERROR = 500;

    /**
     * Hesabın bulunamadığını ifade eder.
     */
    public static final int ACCOUNT_NOT_FOUND = 600;

    /**
     * Tutar bilgisinin geçersiz olduğunu ifade eder.
     */
    public static final int INVALID_AMOUNT= 601;

    /**
     * Bakiyenin yetersiz olduğunu ifade eder.
     */
    public static final int  INSUFFICIENT_BALANCE = 602;

}
