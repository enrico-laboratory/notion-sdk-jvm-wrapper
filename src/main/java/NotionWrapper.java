import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageProperty;

import java.util.ArrayList;
import java.util.List;

class NotionWrapper {

    private final PageProperty queryPageProperty;
    private final List<PageProperty> queryPagePropertyRollup;

    NotionWrapper(Page page, String field) {
        Query query = new Query();
        this.queryPageProperty = query.queryPageProperty(page, field);
        this.queryPagePropertyRollup = query.queryPagePropertyRollup(page, field);
    }
    // -------------------
    // Properties --------
    // -------------------

    String getTitle() {
        if (queryPageProperty == null) {
            return "";
        } else if (queryPageProperty.getTitle().isEmpty()) {
            return "";
        } else {
            return queryPageProperty.getTitle().get(0).getPlainText();
        }
    }

    String getRichText() {
        if (queryPageProperty == null) {
            return "";
        } else if (queryPageProperty.getRichText().isEmpty()) {
            return "";
        } else {
            return queryPageProperty.getRichText().get(0).getPlainText();
        }
    }

    Number getNumber() {
        if (queryPageProperty == null) {
            return null;
        } else {
            return queryPageProperty.getNumber();
        }
    }

    String getSelect() {
        if (queryPageProperty == null) {
            return "";
        } else if (queryPageProperty.getSelect() == null) {
            return "";
        } else {
            return queryPageProperty.getSelect().getName();
        }
    }

    List<String> getMultiSelect() {
        List<String> multiSelectNames = new ArrayList<>();
        if (queryPageProperty == null) {
            return new ArrayList<>();
        } else if (queryPageProperty.getMultiSelect().isEmpty()) {
            return new ArrayList<>();
        }
        queryPageProperty.getMultiSelect()
                .forEach(multiSelectName ->
                        multiSelectNames.add(multiSelectName.getName()));
        return multiSelectNames;
    }

    List<String> getDate() {
        if (queryPageProperty == null) {
            return getDateList("", "");
        } else if (queryPageProperty.getDate() == null) {
            return getDateList("", "");
        } else {
            return getDateList(
                    queryPageProperty.getDate().getStart(),
                    queryPageProperty.getDate().getEnd());
        }
    }

    private List<String> getDateList(String startDateAndTime, String endDateAndTime) {
        List<String> date = new ArrayList<>();
        date.add(startDateAndTime);
        date.add(endDateAndTime);
        return date;
    }

    List<String> getPerson() {
        if (queryPageProperty == null) {
            return new ArrayList<>();
        } else if (queryPageProperty.getPeople() == null) {
            return new ArrayList<>();
        } else {
            List<String> peopleList = new ArrayList<>();
            queryPageProperty.getPeople()
                    .forEach(person ->
                            peopleList.add(person.getName()));
            return peopleList;
        }
    }

    //    getFilesAndMedia() not implemented because always return empty array

    Boolean getCheckbox() {
        return queryPageProperty.getCheckbox();
    }

    String getUrl() {
        if (queryPageProperty == null) {
            return "";
        } else if (queryPageProperty.getUrl() == null) {
            return "";
        } else {
            return queryPageProperty.getUrl();
        }
    }

    String getEmail() {
        if (queryPageProperty == null) {
            return "";
        } else if (queryPageProperty.getEmail() == null) {
            return "";
        } else {
            return queryPageProperty.getEmail();
        }
    }

    String getPhoneNumber() {
        if (queryPageProperty == null) {
            return "";
        } else if (queryPageProperty.getPhoneNumber() == null) {
            return "";
        } else {
            return queryPageProperty.getPhoneNumber();
        }
    }

    List<String> getRelation() {
        if (queryPageProperty == null) {
            return new ArrayList<>();
        } else if (queryPageProperty.getRelation() == null) {
            return new ArrayList<>();
        } else {
            List<String> relationIds = new ArrayList<>();
            queryPageProperty.getRelation().forEach(relation ->
                    relationIds.add(relation.getId()));
            return relationIds;
        }
    }

    // -------------------
    // Property Rollup ---
    // -------------------

    String getTitleRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return "";
        } else if (queryPagePropertyRollup.get(0).getTitle().isEmpty()) {
            return "";
        } else {
            return queryPagePropertyRollup.get(0).getTitle().get(0).getPlainText();
        }
    }

    String getPhoneNumberRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return "";
        } else if (queryPagePropertyRollup.get(0).getPhoneNumber() == null) {
            return "";
        } else {
            return queryPagePropertyRollup.get(0).getPhoneNumber();
        }
    }

    String getSelectRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return "";
        } else if (queryPagePropertyRollup.get(0).getSelect() == null) {
            return "";
        } else {
            return queryPagePropertyRollup.get(0).getSelect().getName();
        }
    }

    String getEmailRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return "";
        } else if (queryPagePropertyRollup.get(0).getEmail() == null) {
            return "";
        } else {
            return queryPagePropertyRollup.get(0).getEmail();
        }
    }

    //    getFilesAndMediaRollup() not implemented because always return empty array

    List<String> getMultiSelectRollup() {
        List<String> multiSelectNames = new ArrayList<>();
        if (queryPagePropertyRollup.isEmpty()) {
            return new ArrayList<>();
        } else if (queryPagePropertyRollup.get(0).getMultiSelect().isEmpty()) {
            return new ArrayList<>();
        }
        queryPagePropertyRollup.get(0).getMultiSelect()
                .forEach(name ->
                        multiSelectNames.add(name.getName()));
        return multiSelectNames;
    }

    String getUrlRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return "";
        } else if (queryPagePropertyRollup.get(0).getUrl() == null) {
            return "";
        } else {
            return queryPagePropertyRollup.get(0).getUrl();
        }
    }

    List<String> getPersonRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return new ArrayList<>();
        } else if (queryPagePropertyRollup.get(0).getPeople() == null) {
            return new ArrayList<>();
        } else {
            List<String> peopleList = new ArrayList<>();
            queryPagePropertyRollup.get(0).getPeople()
                    .forEach(person ->
                            peopleList.add(person.getName()));
            return peopleList;
        }
    }

    Boolean getCheckboxRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return false;
        } else if (queryPagePropertyRollup.get(0).getCheckbox() == null) {
            return false;
        } else {
            return queryPagePropertyRollup.get(0).getCheckbox();
        }
    }

    List<String> getDateRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return getDateList("", "");
        } else if (queryPagePropertyRollup.get(0).getDate() == null) {
            return getDateList("", "");
        } else {
            return getDateList(
                    queryPagePropertyRollup.get(0).getDate().getStart(),
                    queryPagePropertyRollup.get(0).getDate().getEnd());
        }
    }

    Number getNumberRollup() {
        if (queryPagePropertyRollup.isEmpty()) {
            return null;
        } else if (queryPagePropertyRollup.get(0).getNumber() == null) {
            return null;
        } else {
            return queryPagePropertyRollup.get(0).getNumber();
        }
    }

    String getCreatedBy() {
        if (queryPageProperty == null) {
            return "";
        } else {
            return queryPageProperty.getCreatedBy().getName();
        }
    }

    String getLastEditedBy() {
        if (queryPageProperty == null) {
            return "";
        } else {
            return queryPageProperty.getLastEditedBy().getName();
        }
    }

    String getCreatedTime() {
        if (queryPageProperty == null) {
            return "";
        } else {
            return queryPageProperty.getCreatedTime();
        }
    }

    String getLastEditedTime() {
        if (queryPageProperty == null) {
            return "";
        } else {
            return queryPageProperty.getLastEditedTime();
        }
    }
}