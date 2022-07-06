package com.reactive.orgi_portal;

public interface OgriApiPath {
    String API = "api",
            VERSION = "v1",
            OGRI_PROCESS = "ogri-process";

    String OGRI_PROCESS_PATH = "/" + API + "/" + VERSION + "/" + OGRI_PROCESS,
            SAVE_OGRI_USER = "/saveOgriUser",
            ALL_USERS = "/" + "allUsers",
            DELETE_USER = "/" + "deleteUser",
            TOTAL_COUNT = "/" + "totalCount",
            USER_ID_BY_ACN = "/" + "userIdByAcn",
            GET_FORM_ANOTHER_SERVICE = "/" + "employeeDetails",
            GRAPHQL_ALL_USERS = "/" + "graphqlAllUsers",
            GRAPHQL_SAVE_OGRI_USER = "/" + "graphqlSaveOgriUser",
            TESTING = "/" + "testing";

    ;

}
