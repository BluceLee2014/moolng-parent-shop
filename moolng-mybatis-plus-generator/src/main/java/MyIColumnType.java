import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 306548063@qq.com
 * @Desc
 * @date 2020/6/6 23:04
 */
public enum MyIColumnType implements IColumnType {
    ARRAY("Object", null),
    BIGINT("Long", null),
    BINARY("byte[]", null),
    BIT("Boolean", null),
    BLOB("byte[]", null),
    BOOLEAN("Boolean", null),
    CHAR("String", null),
    CLOB("String", null),
    DATALINK("Object", null),
    DATE("Date", Date.class.getName()),
    DECIMAL("BigDecimal", BigDecimal.class.getName()),
    DISTINCT("Object", null),
    DOUBLE("Double", null),
    FLOAT("Double", null),
    INTEGER("Integer", null),
    JAVA_OBJECT("Object", null),
    LONGNVARCHAR("String", null),
    LONGVARBINARY("byte[]", null),
    LONGVARCHAR("String", null),
    NCHAR("String", null),
    NCLOB("String", null),
    NVARCHAR("String", null),
    NULL("Object", null),
    NUMERIC("BigDecimal", BigDecimal.class.getName()),
    OTHER("Object", null),
    REAL("Float", null),
    REF("Object", null),
    SMALLINT("Short", null),
    STRUCT("Object", null),
    TIME("Date", Date.class.getName()),
    TIMESTAMP("Date", Date.class.getName()),
    TINYINT("Byte", null),
    VARBINARY("byte[]", null),
    VARCHAR("String", null),
    // JDK 1.8 types
    TIME_WITH_TIMEZONE("OffsetTime","java.time.OffsetTime"),
    TIMESTAMP_WITH_TIMEZONE("OffsetDateTime","java.time.OffsetDateTime"),
    ;

    /**
     * 类型
     */
    private String type;

    /**
     * 包路径
     */
    private String pkg;

    MyIColumnType(final String type, final String pkg) {
        this.type = type;
        this.pkg = pkg;
    }

    MyIColumnType() {
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String getPkg() {
        return pkg;
    }
}
