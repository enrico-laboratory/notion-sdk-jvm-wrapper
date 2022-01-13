import notion.api.v1.NotionClient;
import notion.api.v1.model.pages.Page;

import java.util.List;

public class NotionWrapperQueryTest {

    public static void main(String[] args) {
        NotionClient client = new NotionClientInitializer().getClient();

        List<Page> database = new Query().queryDatabase(client, Config.ADVANCE_DATABASE);

        System.out.println("TEST TEST " +
                new NotionWrapper(
                        database.get(1),
                        "Rollup Title Field")
                        .getTitleRollup());
    }
}
