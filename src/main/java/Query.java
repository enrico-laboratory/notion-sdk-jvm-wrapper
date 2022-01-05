import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;
import notion.api.v1.model.pages.PageProperty;
import notion.api.v1.model.search.SearchResult;
import notion.api.v1.request.databases.QueryDatabaseRequest;
import notion.api.v1.request.search.SearchRequest;

import java.util.List;

class Query {

    List<SearchResult> listDatabases(NotionClient client) {
        return client.search(
                new SearchRequest("",
                        new SearchRequest.SearchFilter("database", "object")
                )
        ).getResults();
    }

    List<Page> queryDatabase(NotionClient client, String tableId) {
        return client.queryDatabase(
                new QueryDatabaseRequest(
                        tableId)
        ).getResults();
    }

    PageProperty queryPageProperty(Page page, String field) {
        if (page.getProperties().get(field) == null) {
            throw new NullPointerException("Field \"" + field + "\" does not exist");
        }
        return page.getProperties().get(field);
    }
}
