package com.constants.purchaseorderrequests;

public class LPorSuspend {

    public static final String POR_NAVIGATION_BAR = "//*[contains(text(), 'Purchase Order Requests')]";
    public static final String SUSPEND_BUTTON = "#btnToSuspendPOR";
    public static final String YES = ".bootbox-accept";
    public static final String REMARKS_INPUT_LOCATOR = ".bootbox-input";

//TODO Constructor
    private LPorSuspend(){
    }

    public static String getTitle(String title){
        String title1 = "//span[contains(text(), '"+ title +"')]";
        return title1;
    }
}
