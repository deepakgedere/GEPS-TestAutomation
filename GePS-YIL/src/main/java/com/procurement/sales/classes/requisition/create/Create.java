package com.procurement.sales.classes.requisition.create;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.interfaces.ILogin;
import com.interfaces.ILogout;
import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.RequestOptions;
import com.procurement.sales.interfaces.requisitions.IPrCreate;

import java.util.*;

import static com.factory.PlaywrightFactory.saveToPropertiesFile;
import static com.factory.PlaywrightFactory.waitForLocator;
import static com.procurement.sales.constants.requisitions.LPrCreate.*;

public class Create implements IPrCreate {
    private Page page;
    private ILogin iLogin;
    private ILogout iLogout;
    private Properties properties;
    private String prType;
    private ObjectMapper objectMapper;
    private String type;
    private String url;

    private Create() {
    }

    public Create(ILogin iLogin, Properties properties, Page page, ILogout iLogout, ObjectMapper objectMapper, String type) {
        this.page = page;
        this.properties = properties;
        this.iLogin = iLogin;
        this.iLogout = iLogout;
        this.objectMapper = objectMapper;
        this.type = type;
        this.url = properties.getProperty("appUrl");
    }

    public void requesterLoginPRCreate() {
        try {
            String requesterEmail = properties.getProperty("requesterEmail");
            iLogin.performLogin(requesterEmail);
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }

    public void createButton() {
        try {
            Locator createButton = page.locator(CREATE_BUTTON.getLocator());
            waitForLocator(createButton);
            createButton.click();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }

    public void purchaseType() {
        try {
            String prTypeLocator = getPrType(type);
            page.locator(prTypeLocator).click();
        } catch (Exception error) {
            System.out.println("What is the Error: " + error);
        }
    }

    public void title() {
        try {
            switch (type) {
                case "catalog":
                    Locator catalogTitleLocator = page.locator(TITLE.getLocator());
                    waitForLocator(catalogTitleLocator);
                    Integer catCount = Integer.parseInt(properties.getProperty("catCount"));
                    String catalogTitle = properties.getProperty("orderTitle") + "-Catalog-" + catCount;
                    catalogTitleLocator.fill(catalogTitle);
                    catCount++;
                    saveToPropertiesFile("catCount",catCount.toString());
                    saveToPropertiesFile("currentTitle",catalogTitle);
                    break;
                case "noncatalog":
                    Locator nonCatalogTitleLocator = page.locator(TITLE.getLocator());
                    waitForLocator(nonCatalogTitleLocator);
                    Integer ncCount = Integer.parseInt(properties.getProperty("nonCatalogCount"));
                    String nonCatalogTitle = properties.getProperty("orderTitle")+ "-Non Catalog-" + ncCount;
                    nonCatalogTitleLocator.fill(nonCatalogTitle);
                    ncCount++;
                    saveToPropertiesFile("nonCatalogCount",ncCount.toString());
                    saveToPropertiesFile("currentTitle",nonCatalogTitle);
                    break;
                default:
                    System.out.println("--Enter Proper PR Type--");
                    break;
            }
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }

    public void shipToYokogawa() {
        try {
            String shipToYokogawaValue = properties.getProperty("shipToYokogawa").toLowerCase().trim();
            if (shipToYokogawaValue.equals("no")) {
                page.locator(SHIP_TO_YOKOGAWA.getLocator()).check();
            }
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }

    public void plantCode() {
        try {
            String plantCode = PLANT_CODE.getLocator();
            Locator plantCodeLocator = page.locator(plantCode);
            waitForLocator(plantCodeLocator);
            plantCodeLocator.click();

            String getPlantCode = properties.getProperty("plantCode");

            Locator plantCodeSearch = page.locator(SEARCH.getLocator());
            waitForLocator(plantCodeSearch);
            plantCodeSearch.fill(getPlantCode);

            String finalPlantCode = getString(getPlantCode);

            Locator finalPlantCodeLocator = page.locator(finalPlantCode);
            waitForLocator(finalPlantCodeLocator);
            finalPlantCodeLocator.click();
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void businessUnit(){
        try{
            String buDrop = BU_DROP.getLocator();
            Locator buDropLocator = page.locator(buDrop);
            waitForLocator(buDropLocator);
            buDropLocator.click();

            String getBusinessUnit = properties.getProperty("businessUnit");

            Locator buSearch = page.locator(SEARCH.getLocator());
            waitForLocator(buSearch);
            buSearch.fill(getBusinessUnit);

            String finalBU = getString(getBusinessUnit);

            Locator finalBULocator = page.locator(finalBU);
            waitForLocator(finalBULocator);
            finalBULocator.click();

        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }

    }

    public void salesReference(){
        Locator catalogTitleLocator = page.locator(SALES_REFERENCE.getLocator());
        waitForLocator(catalogTitleLocator);
        Integer salesRefCount = Integer.parseInt(properties.getProperty("salesReference"));
        catalogTitleLocator.fill(properties.getProperty("salesReference"));
        salesRefCount++;
        saveToPropertiesFile("salesReference",salesRefCount.toString());
    }

    public Map<String, String> vendor() {
        Map<String, String> rateContractArray = new HashMap<>();
        try {
            String rateContractType = properties.getProperty("rateContractType");
            String vendorNameValue = properties.getProperty("vendorName");
            Locator vendorLocator = page.locator(VENDOR.getLocator());
            vendorLocator.click();

            APIResponse vendorApiResponse = page.request().fetch(url+"/api/Vendors/ApprovedVendorsByKeyword?keyword=" + vendorNameValue, RequestOptions.create());
            JsonNode vendorJson = objectMapper.readTree(vendorApiResponse.body());
            JsonNode vendorIdJson = vendorJson.get(0);
            int vendorId = vendorIdJson.get("id").asInt();

            Locator vendorSearchLocator = page.locator(SEARCH.getLocator());
            vendorSearchLocator.fill(vendorNameValue);

            String vendorOptionLocator = getString(vendorNameValue);
            Locator vendorOption = page.locator(vendorOptionLocator);
            vendorOption.click();

            APIResponse rateContractApiResponse;
            if(rateContractType.toLowerCase().equals("standard")){
                rateContractApiResponse = page.request().fetch(url + "/api/RateContractsByVendorId?vendorId=" + vendorId + "&&itemType=1", RequestOptions.create());
            }
            else{
                rateContractApiResponse = page.request().fetch(url + "/api/RateContractsByVendorId?vendorId=" + vendorId + "&&itemType=0", RequestOptions.create());

            }
            JsonNode rateContractJson = objectMapper.readTree(rateContractApiResponse.body());

            for(JsonNode rateContract : rateContractJson){
                if(rateContract.has("id") && rateContract.has("text")){
                    String rateContractId = rateContract.get("id").asText();
                    String rateContractText = rateContract.get("text").asText();
                    rateContractArray.put(rateContractId, rateContractText);
                }
            }
        } catch (Exception error) {
            System.out.println("Error in Vendor Function: " + error.getMessage());
        }
        System.out.println(rateContractArray);
        return rateContractArray;
    }

    public List<String> rateContract(Map<String, String> rateContractArray) {
        List<String> rateContractItems = new ArrayList<>();
        try {
            String rateContractValue = properties.getProperty("rateContract");

            Locator rateContractLocator = page.locator(RATE_CONTRACT.getLocator());
            rateContractLocator.click();

            for(Map.Entry<String, String> rateContract : rateContractArray.entrySet()){
                if(rateContract.getValue().trim().contains(rateContractValue)){
                    String rateContractId = rateContract.getKey();
                    Locator rateContractSearchLocator = page.locator(SEARCH.getLocator());
                    rateContractSearchLocator.fill(rateContractValue);

                    String rateContractOptionLocator = getString(rateContractValue);
                    Locator rateContractOption = page.locator(rateContractOptionLocator);
                    rateContractOption.click();

                    String rateContractType = properties.getProperty("rateContractType").trim().toLowerCase();
                    APIResponse rateContractResponse;

                    if(rateContractType.contains("bop")){
                        rateContractResponse = page.request().fetch(url + "/api/RateContracts/bopRCItemSearch?bopRcId=" + rateContractId, RequestOptions.create());
                        JsonNode rateContractJsonResponse = objectMapper.readTree(rateContractResponse.body());
                        for(JsonNode Response : rateContractJsonResponse) {
                            rateContractItems.add(Response.get("bopCode").asText());
                        }
                    }
                    else{
                        rateContractResponse = page.request().fetch(url + "/api/RateContracts/ratecontract?rateContractId=" + rateContractId, RequestOptions.create());
                        JsonNode rateContractJsonResponse = objectMapper.readTree(rateContractResponse.body());
                        JsonNode itemsArray = rateContractJsonResponse.get("items");
                        for(JsonNode item : itemsArray){
                            if(item.has("name")){
                                rateContractItems.add(item.get("name").asText());
                            }
                        }
                    }
                    break;

//                    JsonNode rateContractJsonResponse = objectMapper.readTree(rateContractResponse.body());
//                    JsonNode itemsArray = rateContractJsonResponse.get("items");
//                    for(JsonNode item : itemsArray){
//                        if(item.has("name")){
//                            rateContractItems.add(item.get("name").asText());
//                        }
//                    }
//                    break;
                }
            }
        } catch (Exception error) {
            System.out.println("Error in Rate Contract Function: " + error.getMessage());
        }
        return rateContractItems;
    }

    public void addLineRequisitionItemsCatalog(List<String> rateContractItems) {
        Locator itemDropdown;
        Locator addItemButton;
        try {
            Locator addLineItemButton;
            Locator quantityField;
            String catalogType = properties.getProperty("rateContractType");
            if(catalogType.trim().contains("bop")){
                addLineItemButton = page.locator(ADD_BOP2_LINE_ITEM_BUTTON.getLocator());
                itemDropdown = page.locator(BOP_RC_ITEMS_DROPDOWN.getLocator());
                addItemButton = page.locator(ADD_BOP_ITEM_BUTTON.getLocator());
                quantityField = page.locator(BOP_QUANTITY.getLocator());
            }
            else {
                addLineItemButton = page.locator(ADD_LINE_ITEM_BUTTON.getLocator());
                itemDropdown = page.locator(CATALOG_ITEMS_DROPDOWN.getLocator());
                addItemButton = page.locator(ADD_ITEM_BUTTON.getLocator());
                quantityField = page.locator(QUANTITY.getLocator());
            }
            addLineItemButton.click();

            for(int i = 0; i < rateContractItems.size(); i++){
                itemDropdown.click();

                Locator itemSearchBox = page.locator(SEARCH.getLocator());
                itemSearchBox.fill(rateContractItems.get(i));

                String itemDropDownOptionSelect = getString(rateContractItems.get(i));
                Locator itemOptionSelect = page.locator(itemDropDownOptionSelect);
                itemOptionSelect.click();

                quantityField.fill(String.valueOf(i + 10));

                addItemButton.click();

                if(i < rateContractItems.size() - 1) {
                    addLineItemButton.click();
                } else {
                    break;
                }
            }
        } catch (Exception error) {
            System.out.println("Error in Catalog Requisition Items Function: " + error.getMessage());
        }
    }

    public void incoterm() {
        try {
            Locator incotermLocator = page.locator(INCOTERM.getLocator());
            waitForLocator(incotermLocator);
            incotermLocator.click();

            String incotermValue = properties.getProperty("incoterm");
            Locator incotermSearchLocator = page.locator(SEARCH.getLocator());
            incotermSearchLocator.fill(incotermValue);

            String incotermOptionLocator = getString(incotermValue);
            Locator incotermOption = page.locator(incotermOptionLocator);
            waitForLocator(incotermOption);
            incotermOption.click();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }

    public void warrantyRequirements(){
        try {
            Locator warrantyRequirementsLocator = page.locator(WARRANTY_REQUIREMENTS.getLocator());
            waitForLocator(warrantyRequirementsLocator);
            warrantyRequirementsLocator.click();

            String warrantyRequirement = properties.getProperty("warrantyRequirement");

            Locator warrantyRequirementsSearchLocator = page.locator(SEARCH.getLocator());
            waitForLocator(warrantyRequirementsSearchLocator);
            warrantyRequirementsSearchLocator.fill(warrantyRequirement);

            String warrantyRequirementSelector = getString(warrantyRequirement);
            Locator warrantyRequirementOptionLocator = page.locator(warrantyRequirementSelector);
            waitForLocator(warrantyRequirementOptionLocator);
            warrantyRequirementOptionLocator.click();
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void priceValidity(){
        try {
            Locator priceValidityLocator = page.locator(PRICE_VALIDITY.getLocator());
            waitForLocator(priceValidityLocator);
            priceValidityLocator.click();

            String warrantyRequirement = properties.getProperty("priceValidity");

            Locator priceValiditySearchLocator = page.locator(SEARCH.getLocator());
            waitForLocator(priceValiditySearchLocator);
            priceValiditySearchLocator.fill(warrantyRequirement);

            String priceValiditySelector = getString(warrantyRequirement);
            Locator priceValidityOptionLocator = page.locator(priceValiditySelector);
            waitForLocator(priceValidityOptionLocator);
            priceValidityOptionLocator.click();
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void shippingAddress() {
        try {
            Locator shippingAddressLocator = page.locator(SHIPPING_ADDRESS.getLocator());
            waitForLocator(shippingAddressLocator);
            shippingAddressLocator.click();

            String shippingAddressValue = properties.getProperty("shippingAddressYokogawa");
            String shippingAddressOptionLocator = getString(shippingAddressValue);

            Locator shippingAddressOption = page.locator(shippingAddressOptionLocator);
            waitForLocator(shippingAddressOption);
            shippingAddressOption.last().click();
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }

    public void shippingMode() {
        try {
            String shippingMode = type.equals("catalog") ? CATALOG_SHIPPING_MODE.getLocator() : NON_CATALOG_MH_SHIPPING_MODE.getLocator();

            Locator shippingModeLocator = page.locator(shippingMode);
            waitForLocator(shippingModeLocator);
            shippingModeLocator.click();

            String getShippingMode = properties.getProperty("shippingMode");

            Locator shippingModeSearch = page.locator(SEARCH.getLocator());
            waitForLocator(shippingModeSearch);
            shippingModeSearch.fill(getShippingMode);

            String finalShippingMode = getString(getShippingMode);

            Locator finalShippingModeLocator = page.locator(finalShippingMode);
            waitForLocator(finalShippingModeLocator);
            finalShippingModeLocator.click();
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void quotationRequiredBy() {
        try {
            Locator quotationRequiredByField = page.locator(QUOTATION_REQUIRED_BY.getLocator());
            waitForLocator(quotationRequiredByField);
            quotationRequiredByField.click();

            Locator todayOption = page.locator(TODAY.getLocator());
            waitForLocator(todayOption);
            todayOption.first().click();
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void expectedPOIssue() {
        try {
            Locator expectedDeliveryField = page.locator(EXPECTED_DELIVERY.getLocator());
            waitForLocator(expectedDeliveryField);
            expectedDeliveryField.click();

            Locator expectedPoIssueField = page.locator(EXPECTED_PO_ISSUE.getLocator());
            waitForLocator(expectedPoIssueField);
            expectedPoIssueField.click();

            Locator todayOption = page.locator(TODAY.getLocator());
            for (int i = 0; i < todayOption.count(); i++) {
                if (todayOption.nth(i).isVisible()) {
                    todayOption.nth(i).click(); // Click the visible element
                    break; // Stop the loop once the visible element is found and clicked
                }
            }

            //this is because after selecting the expected PO date it requires another click outside to click on Expected Delivery
            page.locator(EXPECTED_PO_ISSUE_LABEL.getLocator()).click();

//            waitForLocator(todayOption);
//            todayOption.last().click();
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void expectedDelivery() {
        try {
            Locator expectedDeliveryField = page.locator(EXPECTED_DELIVERY.getLocator());
            waitForLocator(expectedDeliveryField);
            expectedDeliveryField.click();

            Locator todayOption = page.locator(TODAY.getLocator());
            for (int i = 0; i < todayOption.count(); i++) {
                if (todayOption.nth(i).isVisible()) {
                    todayOption.nth(i).click(); // Click the visible element
                    break; // Stop the loop once the visible element is found and clicked
                }
            }
//            waitForLocator(todayOption);
//            todayOption.last().click();
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void liquidatedDamages(){
        try {
            String liquidatedDamages = properties.getProperty("liquidatedDamages").toLowerCase().trim();
            if (liquidatedDamages.equals("special")) {
                Locator liquidatedDamagesSelector = page.locator(LIQUIDATED_DAMAGES_SELECT.getLocator());
                waitForLocator(liquidatedDamagesSelector);
                liquidatedDamagesSelector.click();

                Locator liquidatedDamagesInput = page.locator(LIQUIDATED_DAMAGES.getLocator());
                waitForLocator(liquidatedDamagesInput);
                liquidatedDamagesInput.fill("Special Liquidated Damages");
            }
        } catch (Exception error) {
            System.out.println("What is the error: " + error.getMessage());
        }
    }

    public void rohsCompliance(){
        try {
            String compliance = properties.getProperty("rohsCompliance").toLowerCase().trim();

            if (compliance.equals("no")) {
                Locator rohsComplianceLocator;
                if(type.equals("catalog")) rohsComplianceLocator = page.locator(ROHS_COMPLIANCE_CAT.getLocator());
                else rohsComplianceLocator = page.locator(ROHS_COMPLIANCE_NON_CAT.getLocator());
                waitForLocator(rohsComplianceLocator);
                rohsComplianceLocator.click();
            }
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void inspectionRequired() {
        try {
            boolean isInspectionRequired = Boolean.parseBoolean(properties.getProperty("inspectionRequired"));

            if (isInspectionRequired) {
                Locator inspectionRequiredLocator = page.locator(INSPECTION_REQUIRED.getLocator());
                waitForLocator(inspectionRequiredLocator);
                inspectionRequiredLocator.click();
            }
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void orderIntake(){
        try {
            String orderIntake = properties.getProperty("orderIntake");
            Locator orderIntakeLocator = page.locator(ORDER_INTAKE.getLocator()).first();
            waitForLocator(orderIntakeLocator);
            orderIntakeLocator.first().fill(orderIntake);
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }

    public void targetPrice(){
        try {
            String targetPrice = properties.getProperty("targetPrice");
            Locator targetPriceLocator = page.locator(TARGET_PRICE.getLocator());
            waitForLocator(targetPriceLocator);
            targetPriceLocator.fill(targetPrice);
        } catch (Exception error) {
            System.out.println("Error encountered: " + error.getMessage());
        }
    }
}
