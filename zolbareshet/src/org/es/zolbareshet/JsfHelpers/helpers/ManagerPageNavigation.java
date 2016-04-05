package org.es.zolbareshet.JsfHelpers.helpers;

import org.es.zolbareshet.queries.SimpleQueryInvoker;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.Map;

@ManagedBean
@ViewScoped
public class ManagerPageNavigation {
    //main menu
    private final static String MANAGER = "manager";
    private final static String REPORT = "report";
    private final static String PRODUCT = "product";
    private final static String SERVER_STATE = "server-state";
    //server state sub menu
    private final static String LOG = "log";
    private final static String CONFIG = "config";
    private final static String SERVICES = "services";

    //super users sub menu
    private final static String NEW_SUPER = "new-uper-user";
    private final static String LIST_SUPER = "list-of-supers";
    private final static String REGULAR_USER = "regular-users";
    private final static String EDIT_USER ="edit-user";

    //when entering all sections are closed
    private boolean showManagerSection = false;
    private boolean showReportSection = false;
    private boolean showProductsSection = false;
    private boolean showServerStateSection = false;
    private boolean showLogSection = false;
    private boolean showConfigurationSection = false;
    private boolean showServiceSection = false;
    private boolean showNewSuperusersSection = false;
    private boolean showListSuperusersSection = false;
    private boolean showRegularUsersSection =false;
    private boolean showEditusersSection = false;

    public boolean isShowEditusersSection() {
        return showEditusersSection;
    }

    public boolean isShowRegularUsersSection() {
        return showRegularUsersSection;
    }

    public boolean isShowListSuperusersSection() {
        return showListSuperusersSection;
    }

    public boolean isShowNewSuperusersSection() {
        return showNewSuperusersSection;
    }

    public boolean isShowServiceSection() {
        return showServiceSection;
    }

    public boolean isShowServerStateSection() {
        return showServerStateSection;
    }

    public boolean isShowManagerSection() {
        return showManagerSection;
    }

    public boolean isShowReportSection() {
        return showReportSection;
    }

    public boolean isShowLogSection() {
        return showLogSection;
    }

    public boolean isShowConfigurationSection() {
        return showConfigurationSection;
    }

    public boolean isShowProductsSection() {
        return showProductsSection;
    }

    public void setShowEditusersSection(boolean showEditusersSection) {
        this.showEditusersSection = showEditusersSection;
    }

    public void setShowRegularUsersSection(boolean showRegularUsersSection) {
        this.showRegularUsersSection = showRegularUsersSection;
    }

    public void setShowNewSuperusersSection(boolean showNewSuperusersSection) {
        this.showNewSuperusersSection = showNewSuperusersSection;
    }

    public void setShowListSuperusersSection(boolean showListSuperusersSection) {
        this.showListSuperusersSection = showListSuperusersSection;
    }

    public void setShowServiceSection(boolean showServiceSection) {
        this.showServiceSection = showServiceSection;
    }

    public void setShowServerStateSection(boolean showServerStateSection) {
        this.showServerStateSection = showServerStateSection;
    }

    public void setShowManagerSection(boolean showManagerSection) {
        this.showManagerSection = showManagerSection;
    }

    public void setShowReportSection(boolean showReportSection) {
        this.showReportSection = showReportSection;
    }

    public void setShowProductsSection(boolean showProductsSection) {
        this.showProductsSection = showProductsSection;
    }

    public void setShowLogSection(boolean showLogSection) {
        this.showLogSection = showLogSection;
    }

    public void setShowConfigurationSection(boolean showConfigurationSection) {
        this.showConfigurationSection = showConfigurationSection;
    }

    public void setShowRegularUsersSection() {
        changeContext(REGULAR_USER);
    }

    public void setShowReportSection() {
        changeContext(REPORT);
    }

    public void setShowServerStateSection() {
        changeContext(SERVER_STATE);
    }

    public void setShowProductsSection() {
        changeContext(PRODUCT);
    }

    public void setShowLogSection() {
        changeContext(LOG);
    }

    public void setShowConfigurationSection() {
        changeContext(CONFIG);
    }

    public void setShowManagerSection() {
        changeContext(MANAGER);
    }

    public void setShowServiceSection() {
        changeContext(SERVICES);
    }

    public void setShowNewSuperusersSection() {
        changeContext(NEW_SUPER);
    }

    public void setShowListSuperusersSection() {
        changeContext(LIST_SUPER);
    }


    public void changeContext(String s) {
        switch (s) {
            case MANAGER:
                setShowProductsSection(false);
                setShowReportSection(false);
                setShowServerStateSection(false);
                setShowManagerSection(!isShowManagerSection());
                setShowListSuperusersSection(false);
                setShowNewSuperusersSection(false);
                setShowRegularUsersSection(false);
                break;
            case NEW_SUPER:
                setShowNewSuperusersSection(!isShowNewSuperusersSection());
                setShowListSuperusersSection(false);
                setShowRegularUsersSection(false);
                setShowEditusersSection(false);
                break;
            case LIST_SUPER:
                setShowNewSuperusersSection(false);
                setShowListSuperusersSection(!isShowListSuperusersSection());
                setShowRegularUsersSection(false);
                setShowEditusersSection(false);
                break;
            case REGULAR_USER:
                setShowNewSuperusersSection(false);
                setShowListSuperusersSection(false);
                setShowRegularUsersSection(!isShowRegularUsersSection());
                setShowEditusersSection(false);
                break;
            case EDIT_USER:
                setShowNewSuperusersSection(false);
                setShowListSuperusersSection(false);
                setShowRegularUsersSection(false);
                setShowEditusersSection(true);
                break;
            case PRODUCT:
                setShowReportSection(false);
                setShowServerStateSection(false);
                setShowProductsSection(!isShowProductsSection());
                setShowManagerSection(false);
                break;
            case REPORT:
                setShowReportSection(!isShowReportSection());
                setShowProductsSection(false);
                setShowServerStateSection(false);
                setShowManagerSection(false);
                break;
            case SERVER_STATE:
                setShowConfigurationSection(false);
                setShowLogSection(false);
                setShowServiceSection(false);
                setShowReportSection(false);
                setShowProductsSection(false);
                setShowManagerSection(false);
                setShowServerStateSection(!isShowServerStateSection());
                break;
            case LOG:
                setShowConfigurationSection(false);
                setShowLogSection(!isShowLogSection());
                setShowServiceSection(false);
                break;
            case CONFIG:
                setShowConfigurationSection(!isShowConfigurationSection());
                setShowLogSection(false);
                setShowServiceSection(false);
                break;
            case SERVICES:
                setShowServiceSection(!isShowServiceSection());
                setShowLogSection(false);
                setShowConfigurationSection(false);
                break;
        }
    }


    public void editUser(String user) {

        changeContext(EDIT_USER);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        Map<String, Object> params =
                externalContext.getRequestMap();
        ArrayList<String> userDetails = SimpleQueryInvoker.getUserDetails(user);

        String[] fields = {"nickname","firstname","lastname","password","email","role","phone1-per","phone1-num","phone1-type","phone2-per","phone2-num","phone2-type",
                "phone3-per","phone3-num","phone3-type","phone4-per","phone4-num","phone1-type"};
        for(int i=0;i<userDetails.size();i++){
            params.put(fields[i],userDetails.get(i));
        }
    }
}
