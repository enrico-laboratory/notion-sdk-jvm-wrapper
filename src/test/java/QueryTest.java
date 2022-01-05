import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageProperty;
import notion.api.v1.model.search.SearchResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class QueryTest {

    private final NotionClient client = new NotionClientInitializer().getClient();
    private static final String testDatabaseId = "586ae99a-8a1a-42aa-a758-f1eb307adf15";

    @Test
    public void queryTheDatabasesList() {
        List<SearchResult> listDatabases = new Query().listDatabases(client);

        Assertions.assertNotNull(listDatabases);
    }

    @Test
    public void queryASpecificDatabaseAndRetrieveTheObjectTypePage() {
        List<Page> pageList = new Query().queryDatabase(client, testDatabaseId);
        String objectType = pageList.get(0).getObjectType().getValue();

        Assertions.assertEquals("page", objectType);
    }

    @Test
    public void givingAPageFieldNameGetThePageProperty() {
        Page page = new Query().queryDatabase(client, testDatabaseId).get(0);
        PageProperty pageProperty = new Query().queryPageProperty(
                page,
                "Phone Field"
        );

        Assertions.assertNotNull(pageProperty);
    }

    @Test
    public void givingANotExistingPageFieldNameGetException() {
        Page page = new Query().queryDatabase(client, testDatabaseId).get(0);
        String field = "Not existing field";
        NullPointerException exception = Assertions.assertThrows(
                NullPointerException.class, () ->
                        new Query().queryPageProperty(
                                page,
                                field
                        )
        );

        String expectedMessage = "Field \"" + field + "\" does not exist";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }
}