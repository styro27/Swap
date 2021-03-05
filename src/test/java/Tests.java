import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import static io.restassured.RestAssured.*;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.hamcrest.CoreMatchers.equalTo;


public class Tests extends RestSpecDefault {

    private Db db = new Db();
    private static final String guid = GuidHelper.getGuid();

    @Test
    void check() throws Exception {
        String message = ReadFromFileHelper.readData("./post_files/ex_1.txt");
        given()
                .headers("message-id-dgt", guid,"object-id-dgt",guid,"topic-dgt","torg_ekb_analytics.main.nomencl","protocol-version-dgt","sys:1.0","transaction_id-dgt",guid,"token-dgt","-","data-action-dgt","torg_ekb_update_nomencl","content-type-dgt","json")
                .body(message)
                .when().post()
                .then().body("result",equalTo("true"));
        XmlInTable o1 = (XmlInTable) Serializer.deserializeFromFile("./files/ex_1.ser");
        XmlInTable o2 = db.getValue("select message from xmlIn where transactionId = ?",guid);
        Assertions.assertThat(o1.equals(o2));

    }
    @Test
    void writeTextSample() throws Exception {
        String transId = "58cbf559-6d29-447e-9d5e-c54698093e80";
        String  message = db.getMessageValue("select message from xmlIn where transactionId = ?",transId);
        WriteToFileHelper.writeData("./post_files/ex_1.txt",message);
        XmlInTable o1 = db.getValue("select message from xmlIn where transactionId = ?",transId);
        Serializer.serializeToFile("./files/ex_1.ser",o1);

    }
}
