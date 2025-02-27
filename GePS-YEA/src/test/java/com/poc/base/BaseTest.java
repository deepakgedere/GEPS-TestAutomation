package com.poc.base;
import com.poc.classes.dispatchnotes.assign.DnAssign;
import com.poc.classes.dispatchnotes.assign.DnAssignTest;
import com.poc.classes.dispatchnotes.cancel.DnCancel;
import com.poc.classes.dispatchnotes.cancel.DnCancelTest;
import com.poc.classes.dispatchnotes.create.DnCreate;
import com.poc.classes.dispatchnotes.create.DnCreateTest;
import com.poc.classes.dispatchnotes.dnreturn.DnReturn;
import com.poc.classes.dispatchnotes.dnreturn.DnReturnTest;
import com.poc.classes.dispatchnotes.edit.DnEdit;
import com.poc.classes.dispatchnotes.edit.DnEditTest;
import com.poc.classes.freightforwarderrequests.invite.FfrInvite;
import com.poc.classes.freightforwarderrequests.invite.FfrInviteTest;
import com.poc.classes.freightforwarderrequests.quote.FfrQuote;
import com.poc.classes.freightforwarderrequests.quote.FfrQuoteTest;
import com.poc.classes.freightforwarderrequests.requote.FfrRequote;
import com.poc.classes.freightforwarderrequests.requote.FfrRequoteTest;
import com.poc.classes.inspections.assign.InsAssign;
import com.poc.classes.inspections.assign.InsAssignTest;
import com.poc.classes.inspections.create.InsCreate;
import com.poc.classes.inspections.create.InsCreateTest;
import com.poc.classes.inspections.fail.InsFail;
import com.poc.classes.inspections.fail.InsFailTest;
import com.poc.classes.inspections.readyforinspection.InsReadyForInspection;
import com.poc.classes.inspections.readyforinspection.InsReadyForInspectionTest;
import com.poc.classes.invoice.poinvoice.approve.InvApproval;
import com.poc.classes.invoice.poinvoice.approve.PoInvApprovalTest;
import com.poc.classes.invoice.poinvoice.cancel.InvCancel;
import com.poc.classes.invoice.poinvoice.cancel.PoInvCancelTest;
import com.poc.classes.invoice.poinvoice.checklist.InvChecklistAccept;
import com.poc.classes.invoice.poinvoice.checklist.InvChecklistReject;
import com.poc.classes.invoice.poinvoice.checklist.PoInvChecklistAcceptTest;
import com.poc.classes.invoice.poinvoice.checklist.PoInvChecklistRejectTest;
import com.poc.classes.invoice.poinvoice.create.InvCreate;
import com.poc.classes.invoice.poinvoice.create.PoInvCreateTest;
import com.poc.classes.invoice.poinvoice.edit.InvEdit;
import com.poc.classes.invoice.poinvoice.edit.PoInvEditTest;
import com.poc.classes.invoice.poinvoice.hold.InvHold;
import com.poc.classes.invoice.poinvoice.hold.PoInvHoldTest;
import com.poc.classes.invoice.poinvoice.invreturn.InvReturn;
import com.poc.classes.invoice.poinvoice.invreturn.PoInvReturnTest;
import com.poc.classes.invoice.poinvoice.reject.InvReject;
import com.poc.classes.invoice.poinvoice.reject.PoInvRejectTest;
import com.poc.classes.invoice.poinvoice.revert.InvRevert;
import com.poc.classes.invoice.poinvoice.revert.PoInvRevertTest;
import com.poc.classes.invoice.poinvoice.sendforapproval.InvSendForApproval;
import com.poc.classes.invoice.poinvoice.sendforapproval.PoInvSendForApprovalTest;
import com.poc.classes.invoice.poinvoice.sendforapproval.WoInvSendForApprovalTest;
import com.poc.classes.invoice.poinvoice.verify.InvVerify;
import com.poc.classes.invoice.poinvoice.verify.PoInvVerifyTest;
import com.poc.classes.invoice.woinvoice.approve.WoInvApproval;
import com.poc.classes.invoice.woinvoice.approve.WoInvApprovalTest;
import com.poc.classes.invoice.woinvoice.cancel.WoInvCancel;
import com.poc.classes.invoice.woinvoice.cancel.WoInvCancelTest;
import com.poc.classes.invoice.woinvoice.checklist.WoInvChecklistAccept;
import com.poc.classes.invoice.woinvoice.checklist.WoInvChecklistAcceptTest;
import com.poc.classes.invoice.woinvoice.checklist.WoInvChecklistReject;
import com.poc.classes.invoice.woinvoice.checklist.WoInvChecklistRejectTest;
import com.poc.classes.invoice.woinvoice.create.WoInvCreate;
import com.poc.classes.invoice.woinvoice.create.WoInvCreateTest;
import com.poc.classes.invoice.woinvoice.edit.WoInvEdit;
import com.poc.classes.invoice.woinvoice.edit.WoInvEditTest;
import com.poc.classes.invoice.woinvoice.hold.WoInvHold;
import com.poc.classes.invoice.woinvoice.hold.WoInvHoldTest;
import com.poc.classes.invoice.woinvoice.invreturn.WoInvReturn;
import com.poc.classes.invoice.woinvoice.invreturn.WoInvReturnTest;
import com.poc.classes.invoice.woinvoice.reject.WoInvReject;
import com.poc.classes.invoice.woinvoice.reject.WoInvRejectTest;
import com.poc.classes.invoice.woinvoice.revert.WoInvRevert;
import com.poc.classes.invoice.woinvoice.revert.WoInvRevertTest;
import com.poc.classes.invoice.woinvoice.sendforapproval.WoInvSendForApproval;
import com.poc.classes.invoice.woinvoice.verify.WoInvVerify;
import com.poc.classes.invoice.woinvoice.verify.WoInvVerifyTest;
import com.poc.classes.login.LoginTest;
import com.poc.classes.orderschedule.approval.OsApproveTest;
import com.poc.classes.orderschedule.approve.OsApprove;
import com.poc.classes.orderschedule.create.OsCreate;
import com.poc.classes.orderschedule.create.OsCreateTest;
import com.poc.classes.orderschedule.edit.OsEdit;
import com.poc.classes.orderschedule.edit.OsEditTest;
import com.poc.classes.orderschedule.reject.OsReject;
import com.poc.classes.orderschedule.reject.OsRejectTest;
import com.poc.classes.purchaseorder.create.PoCreateTest;
import com.poc.classes.purchaseorder.sendforapproval.PoSendForVendorTest;
import com.poc.classes.purchaseorderrequest.approvalandapprove.PorSendForApprovalAndApproveTest;
import com.poc.classes.purchaseorderrequest.approve.PorApproveTest;
import com.poc.classes.purchaseorderrequest.create.PorCreateTest;
import com.poc.classes.purchaseorderrequest.edit.PorEditTest;
import com.poc.classes.purchaseorderrequest.reject.PorRejectTest;
import com.poc.classes.purchaseorderrequest.sendforapproval.PorSendForApprovalTest;
import com.poc.classes.purchaseorderrequest.suspend.PorSuspendPorEditTest;
import com.poc.classes.purchaseorderrequest.suspend.PorSuspendRfqEditTest;
import com.poc.classes.requestforquotation.commercialevaluation.CommercialEvaluationTest;
import com.poc.classes.requestforquotation.create.RfqCreateTest;
import com.poc.classes.requestforquotation.edit.RfqEditTest;
import com.poc.classes.requestforquotation.regret.RegretTest;
import com.poc.classes.requestforquotation.requote.RequoteTest;
import com.poc.classes.requestforquotation.quote.QuoteTest;
import com.poc.classes.requestforquotation.readyforevaluation.ReadyForEvaluationTest;
import com.poc.classes.requestforquotation.suspend.RfqSuspendPrEditTest;
import com.poc.classes.requestforquotation.suspend.RfqSuspendRfqEditTest;
import com.poc.classes.requestforquotation.technicalevaluation.TechnicalEvaluationRejectTest;
import com.poc.classes.requestforquotation.technicalevaluation.TechnicalEvaluationTest;
import com.poc.classes.requisition.approve.ApproveTest;
import com.poc.classes.requisition.assign.AssignTest;
import com.poc.classes.requisition.create.CreateTest;
import com.poc.classes.requisition.edit.EditTest;
import com.poc.classes.requisition.reject.RejectTest;
import com.poc.classes.requisition.sendforapproval.SendForApprovalTest;
import com.poc.classes.requisition.suspend.BuyerManagerSuspend;
import com.poc.classes.requisition.suspend.BuyerManagerSuspendTest;
import com.poc.classes.requisition.suspend.BuyerSuspendTest;
import com.factory.PlaywrightFactory;
import com.microsoft.playwright.Page;
import com.poc.classes.login.Login;
import com.poc.classes.logout.Logout;
import com.poc.classes.purchaseorder.create.PoCreate;
import com.poc.classes.purchaseorder.sendforvendor.SendForVendor;
import com.poc.classes.purchaseorderrequest.approvalandapprove.PorSendForApprovalAndApprove;
import com.poc.classes.purchaseorderrequest.approve.PorApprove;
import com.poc.classes.purchaseorderrequest.create.PorCreate;
import com.poc.classes.purchaseorderrequest.edit.PorEdit;
import com.poc.classes.purchaseorderrequest.reject.PorReject;
import com.poc.classes.purchaseorderrequest.sendforapproval.PorSendForApproval;
import com.poc.classes.purchaseorderrequest.suspend.PorSuspend;
import com.poc.classes.requestforquotations.commercialevaluation.CommercialEvaluation;
import com.poc.classes.requestforquotations.create.RfqCreate;
import com.poc.classes.requestforquotations.edit.RfqEdit;
import com.poc.classes.requestforquotations.quote.Quote;
import com.poc.classes.requestforquotations.readyforevaluation.ReadyForEvaluation;
import com.poc.classes.requestforquotations.regret.QuotationRegret;
import com.poc.classes.requestforquotations.requote.Requote;
import com.poc.classes.requestforquotations.suspend.RfqSuspend;
import com.poc.classes.requestforquotations.technicalevaluation.TechnicalEvaluation;
import com.poc.classes.requestforquotations.technicalevaluation.TechnicalEvaluationReject;
import com.poc.classes.requisition.approve.Approve;
import com.poc.classes.requisition.assign.Assign;
import com.poc.classes.requisition.create.Create;
import com.poc.classes.requisition.edit.Edit;
import com.poc.classes.requisition.reject.Reject;
import com.poc.classes.requisition.sendforapproval.SendForApproval;
import com.poc.classes.requisition.suspend.BuyerSuspend;
import com.poc.classes.requisition.type.PurchaseRequisitionTypeHandler;
import com.poc.classes.workorder.create.WoCreate;
import com.poc.classes.workorder.trackerstatus.WoTrackerStatus;
import com.poc.classes.workorders.create.WoCreateTest;
import com.poc.classes.workorders.trackerstatus.WoTrackerStatusTest;
import com.poc.interfaces.currencyexchangerate.ICurrencyExchangeRate;
import com.poc.interfaces.dispatchnotes.*;
import com.poc.interfaces.freightforwarderrequests.IFfrInvite;
import com.poc.interfaces.freightforwarderrequests.IFfrQuote;
import com.poc.interfaces.freightforwarderrequests.IFfrRequote;
import com.poc.interfaces.inspections.IInsAssign;
import com.poc.interfaces.inspections.IInsCreate;
import com.poc.interfaces.inspections.IInsFail;
import com.poc.interfaces.inspections.IInsReadyForInspection;
import com.poc.interfaces.invoices.poinvoices.*;
import com.poc.interfaces.invoices.woinvoices.*;
import com.poc.interfaces.login.ILogin;
import com.poc.interfaces.logout.ILogout;
import com.poc.interfaces.orderschedule.IOsApprove;
import com.poc.interfaces.orderschedule.IOsCreate;
import com.poc.interfaces.orderschedule.IOsEdit;
import com.poc.interfaces.orderschedule.IOsReject;
import com.poc.interfaces.purchaseorderrequests.*;
import com.poc.interfaces.purchaseorders.IPoCreate;
import com.poc.interfaces.purchaseorders.IPoSendForVendor;
import com.poc.interfaces.requestforquotation.*;
import com.poc.interfaces.requisitions.*;
import com.poc.interfaces.workorders.IWoCreate;
import com.poc.interfaces.workorders.IWoTrackerStatus;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseTest {

    Logger logger;
    protected PlaywrightFactory playwrightFactory;
    protected Properties properties;
    protected Page page;
    protected ICurrencyExchangeRate iCurrencyExchangeRate;
    protected LoginTest loginTest;
    protected ILogin iLogin;
    protected ILogout iLogout;
    protected IPrType iPrType;
    protected CreateTest createTest;
    protected IPrCreate iPrCreate;
    protected EditTest editTest;
    protected IPrEdit iPrEdit;
    protected SendForApprovalTest sendForApprovalTest;
    protected IPrSendForApproval iPrSendForApproval;
    protected RejectTest rejectTest;
    protected IPrReject iPrReject;
    protected ApproveTest approveTest;
    protected IPrApprove iPrApprove;
    protected AssignTest assignTest;
    protected IPrAssign iPrAssign;
    protected BuyerSuspendTest suspend;
    protected IPrBuyerSuspend iPrBuyerSuspend;
    protected BuyerManagerSuspendTest buyerManagerSuspendTest;
    protected IPrBuyerManagerSuspend iPrBuyerManagerSuspend;
    protected RfqCreateTest rfqCreateTest;
    protected IRfqCreate iRfqCreate;
    protected RfqEditTest rfqEditTest;
    protected IRfqEdit iRfqEdit;
    protected RfqSuspendPrEditTest rfqSuspendPrEditTest;
    protected RfqSuspendRfqEditTest rfqSuspendRfqEditTest;
    protected IRfqSuspend iRfqSuspend;
    protected RegretTest regretTest;
    protected IQuoRegret iQuoRegret;
    protected QuoteTest quoteTest;
    protected IQuoSubmit iQuoSubmit;
    protected RequoteTest requoteTest;
    protected IQuoRequote iQuoRequote;
    protected ReadyForEvaluationTest readyForEvaluationTest;
    protected IReadyForEvalutation iReadyForEvalutation;
    protected TechnicalEvaluationTest technicalEvaluationTest;
    protected ITeCreate iTeCreate;
    protected TechnicalEvaluationRejectTest technicalEvaluationRejectTest;
    protected ITeReject iTeReject;
    protected CommercialEvaluationTest commercialEvaluationTest;
    protected ICeCreate iCeCreate;
    protected PorCreateTest porCreateTest;
    protected IPorCreate iPorCreate;
    protected PorEditTest porEditTest;
    protected IPorEdit iPorEdit;
    protected PorSuspendPorEditTest porSuspendPorEditTest;
    protected PorSuspendRfqEditTest porSuspendRfqEditTest;
    protected IPorSuspend iPorSuspend;
    protected PorSendForApprovalTest porSendForApprovalTest;
    protected IPorSendForApproval iPorSendForApproval;
    protected PorRejectTest porRejectTest;
    protected IPorReject iPorReject;
    protected PorApproveTest porApproveTest;
    protected IPorApprove iPorApprove;
    protected PorSendForApprovalAndApproveTest porSendForApprovalAndApproveTest;
    protected IPorSendForApprovalAndApprove iPorSendForApprovalAndApprove;
    protected PoCreateTest poCreateTest;
    protected IPoCreate iPoCreate;
    protected PoSendForVendorTest poSendForVendorTest;
    protected IPoSendForVendor iPoSendForVendor;
    protected OsCreateTest osCreateTest;
    protected IOsCreate iOsCreate;
    protected OsEditTest osEditTest;
    protected IOsEdit iOsEdit;
    protected OsRejectTest osRejectTest;
    protected IOsReject iOsReject;
    protected OsApproveTest osApproveTest;
    protected IOsApprove iOsApprove;
    protected InsReadyForInspectionTest insReadyForInspectionTest;
    protected IInsReadyForInspection iInsReadyForInspection;
    protected InsCreateTest insCreateTest;
    protected IInsCreate iInsCreate;
    protected InsAssignTest insAssignTest;
    protected IInsAssign iInsAssign;
    protected InsFailTest insFailTest;
    protected IInsFail iInsFail;
    protected DnCreateTest dnCreateTest;
    protected IDnCreate iDnCreate;
    protected DnReturnTest dnReturnTest;
    protected IDnReturn iDnReturn;
    protected DnEditTest dnEditTest;
    protected IDnEdit iDnEdit;
    protected DnAssignTest dnAssignTest;
    protected IDnAssign iDnAssign;
    protected DnCancelTest dnCancelTest;
    protected IDnCancel iDnCancel;
    protected FfrInviteTest ffrInviteTest;
    protected IFfrInvite iFfrInvite;
    protected FfrQuoteTest ffrQuoteTest;
    protected IFfrQuote iFfrQuote;
    protected FfrRequoteTest ffrRequoteTest;
    protected IFfrRequote iFfrRequote;
    protected WoCreateTest woCreateTest;
    protected IWoCreate iWoCreate;
    protected WoTrackerStatusTest woTrackerStatusTest;
    protected IWoTrackerStatus iWoTrackerStatus;
    protected PoInvCreateTest poInvCreateTest;
    protected IInvCreate iInvCreate;
    protected PoInvHoldTest poInvHoldTest;
    protected IInvHold iInvHold;
    protected PoInvRevertTest poInvRevertTest;
    protected IInvRevert iInvRevert;
    protected PoInvCancelTest poInvCancelTest;
    protected IInvCancel iInvCancel;
    protected PoInvSendForApprovalTest poInvSendForApprovalTest;
    protected IInvSendForApproval iInvSendForApproval;
    protected PoInvChecklistRejectTest poInvChecklistRejectTest;
    protected IInvChecklistReject iInvChecklistReject;
    protected PoInvChecklistAcceptTest poInvChecklistAcceptTest;
    protected IInvChecklistAccept iInvChecklistAccept;
    protected PoInvEditTest poInvEditTest;
    protected IInvEdit iInvEdit;
    protected PoInvReturnTest poInvReturnTest;
    protected IInvReturn iInvReturn;
    protected PoInvVerifyTest poInvVerifyTest;
    protected IInvVerify iInvVerify;
    protected PoInvRejectTest poInvRejectTest;
    protected IInvReject iInvReject;
    protected PoInvApprovalTest poInvApprovalTest;
    protected IInvApproval iInvApproval;
    protected WoInvCreateTest woInvCreateTest;
    protected IWoInvCreate iWoInvCreate;
    protected WoInvHoldTest woInvHoldTest;
    protected IWoInvHold iWoInvHold;
    protected WoInvRevertTest woInvRevertTest;
    protected IWoInvRevert iWoInvRevert;
    protected WoInvCancelTest woInvCancelTest;
    protected IWoInvCancel iWoInvCancel;
    protected WoInvSendForApprovalTest woInvSendForApprovalTest;
    protected IWoInvSendForApproval iWoInvSendForApproval;
    protected WoInvChecklistAcceptTest woInvChecklistAcceptTest;
    protected IWoInvChecklistAccept iWoInvChecklistAccept;
    protected WoInvChecklistRejectTest woInvChecklistRejectTest;
    protected IWoInvChecklistReject iWoInvChecklistReject;
    protected WoInvEditTest woInvEditTest;
    protected IWoInvEdit iWoInvEdit;
    protected WoInvReturnTest woInvReturnTest;
    protected IWoInvReturn iWoInvReturn;
    protected WoInvVerifyTest woInvVerifyTest;
    protected IWoInvVerify iWoInvVerify;
    protected WoInvRejectTest woInvRejectTest;
    protected IWoInvReject iWoInvReject;
    protected WoInvApprovalTest woInvApprovalTest;
    protected IWoInvApproval iWoInvApproval;

//TODO Constructor
    public BaseTest() {
    }

    @BeforeTest
    public void setUp(){
        try {
            logger = LogManager.getLogger(BaseTest.class);
            logger.info("Creating objects for all the classes");
            playwrightFactory = new PlaywrightFactory();
            properties = playwrightFactory.initializeProperties();
            page = playwrightFactory.initializePage(properties);

//TODO Requisition
            iLogin = new Login(properties, page);
            iLogout = new Logout(page);
            loginTest = new LoginTest();
            iPrCreate = new Create(iLogin, properties, page, iLogout);
            iPrType = new PurchaseRequisitionTypeHandler(iPrCreate, properties);
            createTest = new CreateTest();
            iPrSendForApproval = new SendForApproval(iLogin, properties, page, iLogout);
            sendForApprovalTest = new SendForApprovalTest();
            iPrApprove = new Approve(iLogin, properties, page, iLogout);
            approveTest = new ApproveTest();
            iPrAssign = new Assign(iLogin, properties, page, iLogout);
            assignTest = new AssignTest();
            iPrEdit = new Edit(iLogin, properties, page, iLogout, iPrSendForApproval, iPrApprove, iPrAssign);
            editTest = new EditTest();
            iPrReject = new Reject(iLogin, properties, page, iLogout, iPrEdit);
            rejectTest = new RejectTest();
            iPrBuyerManagerSuspend = new BuyerManagerSuspend(iLogin, properties, page, iLogout, iPrEdit);
            buyerManagerSuspendTest = new BuyerManagerSuspendTest();
            iPrBuyerSuspend = new BuyerSuspend(iLogin, properties, page, iLogout, iPrEdit);
            suspend = new BuyerSuspendTest();

//TODO Request For Quotation
            iRfqCreate = new RfqCreate(iLogin, properties, page, iLogout);
            rfqCreateTest = new RfqCreateTest();
            iRfqEdit = new RfqEdit(iLogin, properties, page, iLogout);
            rfqEditTest = new RfqEditTest();
            iRfqSuspend = new RfqSuspend(iLogin, properties, page, iLogout, iRfqEdit, iPrEdit, iPrSendForApproval, iPrApprove, iPrAssign, iRfqCreate);
            rfqSuspendPrEditTest = new RfqSuspendPrEditTest();
            rfqSuspendRfqEditTest = new RfqSuspendRfqEditTest();
            iQuoSubmit = new Quote(iLogin, properties, page, iLogout);
            quoteTest = new QuoteTest();
            iQuoRegret = new QuotationRegret(iQuoSubmit, iLogin, properties, page, iLogout);
            regretTest = new RegretTest();
            iQuoRequote = new Requote(iLogin, properties, page, iLogout);
            requoteTest = new RequoteTest();
            iReadyForEvalutation = new ReadyForEvaluation(iLogin, properties, page, iLogout);
            readyForEvaluationTest = new ReadyForEvaluationTest();
            iTeCreate = new TechnicalEvaluation(iLogin, properties, page, iLogout);
            technicalEvaluationTest = new TechnicalEvaluationTest();
            iTeReject = new TechnicalEvaluationReject(iLogin, properties, page, iLogout);
            technicalEvaluationRejectTest = new TechnicalEvaluationRejectTest();
            iCeCreate = new CommercialEvaluation(iLogin, properties, page, iLogout);
            commercialEvaluationTest = new CommercialEvaluationTest();

//TODO Purchase Order Request
            iPorCreate = new PorCreate(iLogin, properties, page, iLogout);
            porCreateTest = new PorCreateTest();
            iPorEdit = new PorEdit(iLogin, properties, page, iLogout);
            porEditTest = new PorEditTest();
            iPorSuspend = new PorSuspend(iLogin, properties, page, iLogout, iPorEdit, iCeCreate, iPorCreate);
            porSuspendPorEditTest = new PorSuspendPorEditTest();
            porSuspendRfqEditTest = new PorSuspendRfqEditTest();
            iPorSendForApproval = new PorSendForApproval(iLogin, properties, page, iLogout);
            porSendForApprovalTest = new PorSendForApprovalTest();
            iPorApprove = new PorApprove(iLogin, properties, page, iLogout);
            porApproveTest = new PorApproveTest();
            iPorReject = new PorReject(iLogin, properties, page, iLogout, iPorEdit, iPorSendForApproval);
            porRejectTest = new PorRejectTest();
            iPorSendForApprovalAndApprove = new PorSendForApprovalAndApprove(iPorApprove, iPorSendForApproval);
            porSendForApprovalAndApproveTest = new PorSendForApprovalAndApproveTest();

//TODO Purchase Orders
            iPoCreate = new PoCreate(iLogin, properties, page, iLogout);
            poCreateTest = new PoCreateTest();
            iPoSendForVendor = new SendForVendor(iLogin, properties, page, iLogout);
            poSendForVendorTest = new PoSendForVendorTest();

//TODO Order Schedule
            iOsCreate = new OsCreate(iLogin, properties, page, iLogout, playwrightFactory);
            osCreateTest = new OsCreateTest();
            iOsEdit = new OsEdit(iLogin, properties, page, iLogout);
            osEditTest = new OsEditTest();
            iOsReject = new OsReject(iLogin, properties, page, iLogout);
            osRejectTest = new OsRejectTest();
            iOsApprove = new OsApprove(iLogin, properties, page, iLogout);
            osApproveTest = new OsApproveTest();

//TODO Inspection
            iInsReadyForInspection = new InsReadyForInspection(iLogin, properties, page, iLogout);
            insReadyForInspectionTest = new InsReadyForInspectionTest();
            iInsCreate = new InsCreate(iLogin, properties, page, iLogout);
            insCreateTest = new InsCreateTest();
            iInsAssign = new InsAssign(iLogin, properties, page, iLogout);
            insAssignTest = new InsAssignTest();
            iInsFail = new InsFail(iLogin, properties, page, iLogout, iInsReadyForInspection);
            insFailTest = new InsFailTest();

//TODO Dispatch Notes
            iDnCreate = new DnCreate(iLogin, properties, page, iLogout);
            dnCreateTest = new DnCreateTest();
            iDnEdit = new DnEdit(iLogin, properties, page, iLogout);
            dnEditTest = new DnEditTest();
            iDnReturn = new DnReturn(iLogin, properties, page, iLogout, iDnEdit);
            dnReturnTest = new DnReturnTest();
            iDnCancel = new DnCancel(iLogin, properties, page, iLogout, iDnCreate);
            dnCancelTest = new DnCancelTest();
            iDnAssign = new DnAssign(iLogin, properties, page, iLogout, playwrightFactory);
            dnAssignTest = new DnAssignTest();

//TODO Freight Forwarder Requests
            iFfrInvite = new FfrInvite(iLogin, properties, page, iLogout);
            ffrInviteTest = new FfrInviteTest();
            iFfrQuote = new FfrQuote(iLogin, properties, page, iLogout);
            ffrQuoteTest = new FfrQuoteTest();
            iFfrRequote = new FfrRequote(iLogin, properties, iFfrQuote, iLogout, page);
            ffrRequoteTest = new FfrRequoteTest();

//TODO Work Orders
            iWoCreate = new WoCreate(iLogin, properties, page, iLogout);
            woCreateTest = new WoCreateTest();
            iWoTrackerStatus = new WoTrackerStatus(iLogin, properties, page, iLogout, playwrightFactory);
            woTrackerStatusTest = new WoTrackerStatusTest();

//TODO POInvoice
            iInvCreate = new InvCreate(playwrightFactory, iLogin, properties, page, iLogout, iCurrencyExchangeRate);
            poInvCreateTest = new PoInvCreateTest();
            iInvCancel = new InvCancel(iLogin, properties, page, iLogout, iInvCreate);
            poInvCancelTest = new PoInvCancelTest();
            iInvHold = new InvHold(iLogin, properties, page, iLogout);
            poInvHoldTest = new PoInvHoldTest();
            iInvRevert = new InvRevert(iLogin, properties, page, iLogout);
            poInvRevertTest = new PoInvRevertTest();
            iInvChecklistAccept = new InvChecklistAccept(iLogin, properties, page, iLogout);
            poInvChecklistAcceptTest = new PoInvChecklistAcceptTest();
            iInvChecklistReject = new InvChecklistReject(iLogin, properties, page, iLogout);
            poInvChecklistRejectTest = new PoInvChecklistRejectTest();
            iInvSendForApproval = new InvSendForApproval(iLogin, properties, page, iLogout);
            poInvSendForApprovalTest = new PoInvSendForApprovalTest();
            iInvReturn = new InvReturn(iLogin, properties, page, iLogout, iInvSendForApproval);
            poInvReturnTest = new PoInvReturnTest();
            iInvVerify = new InvVerify(iLogin, properties, page, iLogout);
            poInvVerifyTest = new PoInvVerifyTest();
            iInvEdit = new InvEdit(iLogin, properties, page, iLogout);
            poInvEditTest = new PoInvEditTest();
            iInvReject = new InvReject(iLogin, properties, page, iLogout, iInvSendForApproval);
            poInvRejectTest = new PoInvRejectTest();
            iInvApproval = new InvApproval(iLogin, properties, page, iLogout);
            poInvApprovalTest = new PoInvApprovalTest();

//TODO WOInvoice
            iWoInvCreate = new WoInvCreate(playwrightFactory, iLogin, properties, page, iLogout, iCurrencyExchangeRate);
            woInvCreateTest = new WoInvCreateTest();
            iWoInvCancel = new WoInvCancel(iLogin, properties, page, iLogout, iWoInvCreate);
            woInvCancelTest = new WoInvCancelTest();
            iWoInvHold = new WoInvHold(iLogin, properties, page, iLogout);
            woInvHoldTest = new WoInvHoldTest();
            iWoInvRevert = new WoInvRevert(iLogin, properties, page, iLogout);
            woInvRevertTest = new WoInvRevertTest();
            iWoInvChecklistAccept = new WoInvChecklistAccept(iLogin, properties, page, iLogout);
            woInvChecklistAcceptTest = new WoInvChecklistAcceptTest();
            iWoInvChecklistReject = new WoInvChecklistReject(iLogin, properties, page, iLogout);
            woInvChecklistRejectTest = new WoInvChecklistRejectTest();
            iWoInvSendForApproval = new WoInvSendForApproval(iLogin, properties, page, iLogout);
            woInvSendForApprovalTest = new WoInvSendForApprovalTest();
            iWoInvReturn = new WoInvReturn(iLogin, properties, page, iLogout, iWoInvSendForApproval);
            woInvReturnTest = new WoInvReturnTest();
            iWoInvVerify = new WoInvVerify(iLogin, properties, page, iLogout);
            woInvVerifyTest = new WoInvVerifyTest();
            iWoInvEdit = new WoInvEdit(iLogin, properties, page, iLogout);
            woInvEditTest = new WoInvEditTest();
            iWoInvReject = new WoInvReject(iLogin, properties, page, iLogout, iWoInvSendForApproval);
            woInvRejectTest = new WoInvRejectTest();
            iWoInvApproval = new WoInvApproval(iLogin, properties, page, iLogout);
            woInvApprovalTest = new WoInvApprovalTest();

        } catch (Exception exception) {
            logger.error("Error during object creation: ", exception.getMessage(), exception);
        }
    }

    @AfterTest
    public void tearDown() {
        try {
            logger.info("Tear down method execution");
            page.context().browser().close();
        } catch (Exception exception) {
            logger.error("Error during object creation: ", exception.getMessage(), exception);
        }
    }

    @AfterTest
    public void tearDown(Page page) {
        try {
            logger.info("Tear down method execution");
            page.context().browser().close();
        } catch (Exception exception) {
            logger.error("Error during object creation: ", exception.getMessage(), exception);
        }
    }
}