package com.constants.inspections;

public class LInsFail {

    public static final String OS_NAVIGATION_BAR = "//*[contains(text(), 'Order Schedules')]";
    public static final String LIST_CONTAINER = "#listContainer tr td";
    public static final String DETAILS_BUTTON = ".btn-link";
    public static final String ASSIGN_INSPECTOR_BUTTON = "#btnAssignInspector";
    public static final String SELECT_INSPECTOR_DROP_DOWN = "#select2-InspectionId-container";
    public static final String SEARCH_FIELD = ".select2-search__field";
    public static final String SAVE_INSPECTOR = "#saveInspector";
    public static final String ACCEPT_BUTTON = ".bootbox-accept";
    public static final String CREATE_INSPECTION_BUTTON = "#btnForCreateInspection";
    public static final String PHYSICAL_INSPECTION_NOT_REQUIRED = "#physicalInspectionNotReq";
    public static final String INSPECTION_FAIL_BUTTON = "#inspectFail";
    public static final String REMARKS_INPUT = ".bootbox-input";
    public static final String CREATE_BUTTON = "#btnCreateInspection";

//TODO Constructor
    private LInsFail(){
    }

    public static String getTitle(String title){
        String title1 = "//span[contains(text(), '"+ title +"')]";
        return title1;
    }

    public static String getRequestorId(String id){
        String id1 = "//li[contains(text(), '"+ id +"')]";
        return id1;
    }
}
