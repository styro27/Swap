import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.core.mapper.reflect.BeanMapper;

import java.util.List;
import java.util.Optional;

public class Db {
    private final Jdbi jdbi;

    public Db() {
        this.jdbi = Jdbi.create("jdbc:clickhouse://clickhouse.all-log.dev.tp.digitech.ru:58123/EVENTS","autotest","QjoaejLb");
    }

    public List<XmlInTable> getAllValues (String query){
        return jdbi.withHandle(h -> h.createQuery(query).mapToBean(XmlInTable.class).list());
    }
    public XmlInTable getValue(String query, String paramName){
        return jdbi.withHandle(h -> h.select(query,paramName).mapToBean(XmlInTable.class).findOne())
                .orElseThrow(() -> new RuntimeException("No results with such parameters"));
    }
    public String getMessageValue(String query, String paramName){
        return jdbi.withHandle(h -> h.select(query,paramName).mapTo(String.class).findOne())
                .orElseThrow(()-> new RuntimeException("No results with such parameters"));
    }
//public String getValue(String query, String paramName){
//    return jdbi.withHandle(h -> h.select(query,paramName).mapTo(String.class).findOne())
//            .orElseThrow(() -> new RuntimeException("No results with such parameters"));
//}
}
