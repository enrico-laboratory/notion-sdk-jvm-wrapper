package com.enricoruggieri.notion_wrapper;

import notion.api.v1.NotionClient;
import notion.api.v1.exception.NotionAPIError;

class NotionClientInitializer {

    private final NotionClient client;
    private static final String NOTION_TOKEN = System.getenv("NOTION_TOKEN");

    public NotionClientInitializer() {
        if (NOTION_TOKEN == null)
            throw new NullPointerException("Notion token env variables is empty!");
        this.client = new NotionClient(NOTION_TOKEN);
        testingConnection();
    }

    private void testingConnection() {
        try {
            // dummy request
            client.listUsers().getResults();
        } catch (NotionAPIError e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public NotionClient getClient() {
        return client;
    }
}
