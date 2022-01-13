package com.enricoruggieri.notion_wrapper;

import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;

import java.util.List;

public class NotionWrapperAPI {

    public static List<Page> query_database(String databaseId){
        NotionClient client = new NotionClientInitializer().getClient();
        return new Query().queryDatabase(client, databaseId);
    }

    public static String getTitle(Page page, String field) {
        return new NotionWrapper(page, field).getTitle();
    }

    public static String getRichText(Page page, String field) {
        return new NotionWrapper(page, field).getRichText();
    }

    public static Number getNumber(Page page, String field) {
        return new NotionWrapper(page, field).getNumber();
    }

    public static String getSelect(Page page, String field) {
        return new NotionWrapper(page, field).getSelect();
    }

    public static List<String> getMultiSelect(Page page, String field) {
        return new NotionWrapper(page, field).getMultiSelect();
    }

    public static List<String> getDate(Page page, String field) {
        return new NotionWrapper(page, field).getDate();
    }

    public static List<String> getPerson(Page page, String field) {
        return new NotionWrapper(page, field).getPerson();
    }

    //    getFilesAndMedia() not implemented because always return empty array

    public static Boolean getCheckbox(Page page, String field) {
        return new NotionWrapper(page, field).getCheckbox();
    }

    public static String getUrl(Page page, String field) {
        return new NotionWrapper(page, field).getUrl();
    }

    public static String getEmail(Page page, String field) {
        return new NotionWrapper(page, field).getEmail();
    }

    public static String getPhoneNumber(Page page, String field) {
        return new NotionWrapper(page, field).getPhoneNumber();
    }

    public static List<String> getRelation(Page page, String field) {
        return new NotionWrapper(page, field).getRelation();
    }

    // -------------------
    // Property Rollup ---
    // -------------------

    public static String getTitleRollup(Page page, String field) {
        return new NotionWrapper(page, field).getTitleRollup();
    }

    public static String getPhoneNumberRollup(Page page, String field) {
        return new NotionWrapper(page, field).getPhoneNumberRollup();
    }

    public static String getSelectRollup(Page page, String field) {
        return new NotionWrapper(page, field).getSelectRollup();
    }

    public static String getEmailRollup(Page page, String field) {
        return new NotionWrapper(page, field).getEmailRollup();
    }

    //    getFilesAndMediaRollup() not implemented because always return empty array

    public static List<String> getMultiSelectRollup(Page page, String field) {
        return new NotionWrapper(page, field).getMultiSelectRollup();
    }

    public static String getUrlRollup(Page page, String field) {
        return new NotionWrapper(page, field).getUrlRollup();
    }

    public static List<String> getPersonRollup(Page page, String field) {
        return new NotionWrapper(page, field).getPersonRollup();
    }

    public static Boolean getCheckboxRollup(Page page, String field) {
        return new NotionWrapper(page, field).getCheckboxRollup();
    }

    public static List<String> getDateRollup(Page page, String field) {
        return new NotionWrapper(page, field).getDateRollup();
    }

    public static Number getNumberRollup(Page page, String field) {
        return new NotionWrapper(page, field).getNumberRollup();
    }

    public static String getCreatedBy(Page page, String field) {
        return new NotionWrapper(page, field).getCreatedBy();
    }

    public static String getLastEditedBy(Page page, String field) {
        return new NotionWrapper(page, field).getLastEditedBy();
    }

    public static String getCreatedTime(Page page, String field) {
        return new NotionWrapper(page, field).getCreatedTime();
    }

    public static String getLastEditedTime(Page page, String field) {
        return new NotionWrapper(page, field).getLastEditedBy();
    }
}
