
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;
import org.hibernate.mapping.MetaAttribute;

public class CustomReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {

    private Set<String> excludedColumns = new HashSet<>();

    public CustomReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
        excludedColumns.add("deleted_flg");
        excludedColumns.add("version");
        excludedColumns.add("created");
        excludedColumns.add("created_by");
        excludedColumns.add("updated");
        excludedColumns.add("updated_by");
    }

    @Override
    public boolean excludeColumn(TableIdentifier identifier, String columnName) {
        return excludedColumns.contains(columnName.toLowerCase());
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Map tableToMetaAttributes(TableIdentifier tableIdentifier) {
        Map map = new HashMap<>();
        addMeta(map, "extends", "BaseEntity");
        addMeta(map, "extra-import",
                "javax.persistence.AccessType",
                "devops_project.infrastructure.data.jpa.BaseEntity",
                "devops_project.infrastructure.data.jpa.BaseEntityListener");

        return map;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void addMeta(Map map, String name, String... values) {
        MetaAttribute attr = new MetaAttribute(name);
        for (String value : values) {
            attr.addValue(value);
        }
        map.put(name, attr);
    }

}
