package org.es.zolbareshet.JsfHelpers.helpers;

import javafx.util.Pair;
import org.es.zolbareshet.logging.MainLogger;
import org.es.zolbareshet.queries.QueriesHandler;
import org.es.zolbareshet.utilities.PropertiesFileManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;


@ManagedBean
@SessionScoped
public class ManagerPageHelperBean {
    //main menu
    private final static String MANAGER = "manager";
    private final static String REPORT = "report";
    private final static String PRODUCT = "product";
    private final static String SERVER_STATE="server-state";
    //server state sub menu
    private final static String LOG = "log";
    private final static String CONFIG = "config";
    private final static String SERVICES = "services";

    //super users sub menu
    private final static String NEW_SUPER = "new-uper-user";
    private final static String LIST_SUPER = "list-of-supers";

    //when entering all sections are closed
    private boolean showManagerSection = false;
    private boolean showReportSection = false;
    private boolean showProductsSection = false;
    private boolean showServerStateSection=false;
    private boolean showLogSection = false;
    private boolean showConfigurationSection = false;
    private boolean showServiceSection = false;
    private boolean showNewSuperusersSection = false;
    private boolean showListSuperusersSection = false;

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

    public void setShowNewSuperusersSection(){
        changeContext(NEW_SUPER);
    }

    public void setShowListSuperusersSection(){
        changeContext(LIST_SUPER);
    }


    private void changeContext(String s) {
        switch (s) {
            case MANAGER:
                setShowProductsSection(false);
                setShowReportSection(false);
                setShowServerStateSection(false);
                setShowManagerSection(!isShowManagerSection());
                setShowListSuperusersSection(false);
                setShowNewSuperusersSection(false);
                break;
            case NEW_SUPER:
                setShowNewSuperusersSection(!isShowNewSuperusersSection());
                setShowListSuperusersSection(false);
                break;
            case LIST_SUPER:
                setShowNewSuperusersSection(false);
                setShowListSuperusersSection(!isShowListSuperusersSection());
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

    public static void openConfigFile(){
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(PropertiesFileManager.getConfigFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void clearLog(){
      /*  int result = JOptionPane.showConfirmDialog(null,"This will delete the content of the log file, do you confirm this action?","DELETE LOG",JOptionPane.YES_NO_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION){*/
            MainLogger.clearLog();
      //  }
    }

    public static java.util.List<Pair<String, Integer>> readLog(){
        return MainLogger.readLog();
    }

}

