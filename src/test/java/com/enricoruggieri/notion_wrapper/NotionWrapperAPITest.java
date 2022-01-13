package com.enricoruggieri.notion_wrapper;

import notion.api.v1.exception.NotionAPIError;
import notion.api.v1.model.pages.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NotionWrapperAPITest {

    @Test
    public void queryEmptyFieldReturnEmptyString() {
        String query = NotionWrapperAPI.getTitle(
                NotionWrapperAPI.query_database(Config.BASIC_DATABASE).get(0),
                "Title Field"
        );

        Assertions.assertEquals("", query);
    }

    @Test
    public void  queryFieldReturnExpectedString() {
        String query = NotionWrapperAPI.getTitle(
                NotionWrapperAPI.query_database(Config.BASIC_DATABASE).get(1),
                "Title Field"
        );

        Assertions.assertEquals("Test Title Basic", query);
    }

    @Test
    public void  queryNotExistentDatabaseReturnException() {

        Exception thrown = Assertions.assertThrows(NotionAPIError.class, ()
                -> NotionWrapperAPI.query_database("Not Existing Database"));

        Assertions.assertEquals(
                "Got an error from Notion (status: 400, code: validation_error, " +
                        "message: path failed validation: path.database_id should be a valid uuid, " +
                        "instead was `\"Not+Existing+Database\"`.)",
                thrown.getMessage());
    }

    @Test
    public void queryNotExistingFieldReturnException() {
        String field = "Not existing field";
        Exception thrown = Assertions.assertThrows(NullPointerException.class, ()
                -> NotionWrapperAPI.getTitle(
                        NotionWrapperAPI.query_database(Config.BASIC_DATABASE).get(1),
                        field));

        Assertions.assertEquals(
                "Field \"" + field + "\" does not exist",
                thrown.getMessage());
    }
}