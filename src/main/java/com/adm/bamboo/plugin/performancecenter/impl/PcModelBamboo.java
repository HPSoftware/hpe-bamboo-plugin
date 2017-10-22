package com.adm.bamboo.plugin.performancecenter.impl;


import java.util.Arrays;
import java.util.List;

/**
 * Created by bemh on 8/6/2017.
 */
public class PcModelBamboo {



    private final String           pcServerName;
    private final String           almUserName;
    private final String almPassword;
    private final String           almDomain;
    private final String           almProject;
    private final String           testId;
    private final String           testInstanceId;
    private final String           autoTestInstanceID;
    private final TimeslotDuration timeslotDuration;
    private final PostRunAction postRunAction;
    private final boolean          vudsMode;
    private final boolean          sla;
    private final String           description;
    private final String          addRunToTrendReport;
    private String trendReportId;
    private final boolean HTTPSProtocol;
    private final String proxyOutURL;
    private final String proxyOutUser;
    private final String proxyOutPassword;



    public PcModelBamboo(String pcServerName, String almUserName, String almPassword, String almDomain, String almProject,
                   String testId,String autoTestInstanceID, String testInstanceId, String timeslotDurationHours, String timeslotDurationMinutes,
                   PostRunAction postRunAction, boolean vudsMode,boolean sla, String description, String addRunToTrendReport, String trendReportId, boolean HTTPSProtocol, String proxyOutURL,String proxyOutUser, String proxyOutPassword) {

        this.pcServerName = pcServerName;
        this.almUserName = almUserName;
        this.almPassword = almPassword;
        this.almDomain = almDomain;
        this.almProject = almProject;
        this.testId = testId;
        this.autoTestInstanceID = autoTestInstanceID;
        this.testInstanceId = testInstanceId;
        this.timeslotDuration = new TimeslotDuration(timeslotDurationHours, timeslotDurationMinutes);
        this.postRunAction = postRunAction;
        this.vudsMode = vudsMode;
        this.sla = sla;
        this.description = description;
        this.addRunToTrendReport = addRunToTrendReport;
        this.HTTPSProtocol = HTTPSProtocol;
        this.trendReportId = trendReportId;
        this.proxyOutURL = proxyOutURL;
        this.proxyOutUser = proxyOutUser;
        this.proxyOutPassword = proxyOutPassword;
    }

//    protected SecretContainer setPassword(String almPassword) {
//
//        SecretContainer secretContainer = new SecretContainerImpl();
//        secretContainer.initialize(almPassword);
//        return secretContainer;
//    }

    public String getPcServerName() {

        return this.pcServerName;
    }

    public String getAlmUserName() {

        return this.almUserName;
    }

    public String getAlmPassword() {

        return this.almPassword;
    }

    public String getAlmDomain() {

        return this.almDomain;
    }

    public String getAlmProject() {

        return this.almProject;
    }

    public String getTestId() {

        return this.testId;
    }

    public String getTestInstanceId() {
        return this.testInstanceId;
    }

    public String getAutoTestInstanceID(){
        return this.autoTestInstanceID;
    }

    public TimeslotDuration getTimeslotDuration() {

        return this.timeslotDuration;
    }

    public boolean isVudsMode() {

        return this.vudsMode;
    }

    public PostRunAction getPostRunAction() {

        return this.postRunAction;
    }

    public String getDescription() {

        return this.description;
    }

    public boolean httpsProtocol(){
        return this.HTTPSProtocol;
    }

    public String getProxyOutURL(){
        return this.proxyOutURL;
    }

    public String getProxyOutUser(){
        return this.proxyOutUser;
    }

    public String getProxyOutPassword(){
        return this.proxyOutPassword;
    }

    public static List<PostRunAction> getPostRunActions() {
        return Arrays.asList(PostRunAction.values());
    }


    @Override
    public String toString() {

        return String.format("[PCServer='%s', User='%s', %s", runParamsToString().substring(1));
    }

    public String runParamsToString() {

        String vudsModeString = (vudsMode) ? ", VUDsMode='true'" : "";
        String trendString = ("USE_ID").equals(addRunToTrendReport) ? String.format(", TrendReportID = '%s'",trendReportId) : "";

        return String.format("[Domain='%s', Project='%s', TestID='%s', " +
                        "TestInstanceID='%s', TimeslotDuration='%s', PostRunAction='%s'%s%s]",

                almDomain, almProject, testId, testInstanceId,
                timeslotDuration, postRunAction, vudsModeString, trendString,HTTPSProtocol);
    }


    public String getTrendReportId() {
        return trendReportId;
    }

    public void setTrendReportId(String trendReportId){
        this.trendReportId = trendReportId;
    }

    public String getAddRunToTrendReport() {
        return addRunToTrendReport;
    }

    public String isHTTPSProtocol(){
        if (!HTTPSProtocol)
            return "http";
        return "https";
    }
}
