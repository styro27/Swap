import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

public class RestSpecDefault {

    {
        RestAssured.baseURI= "http://haproxy.lb.dev.tp.digitech.ru";
        RestAssured.port = 9005;
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(ContentType.JSON.withCharset("UTF-8"))
                .setAccept(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
        {
            RestAssured.responseSpecification = new ResponseSpecBuilder()
                    .expectStatusCode(200)
                    .log(LogDetail.ALL)
                    .build();
        }
    }
}
