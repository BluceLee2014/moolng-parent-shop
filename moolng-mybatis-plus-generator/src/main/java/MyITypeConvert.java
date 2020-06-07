import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

import java.lang.reflect.Field;
import java.sql.Types;

/**
 * @author 306548063@qq.com
 * @Desc
 * @date 2020/6/6 22:47
 */
public class MyITypeConvert implements ITypeConvert {

    @Override
    public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
        MyIColumnType type = MyIColumnType.VARCHAR;
        try {
            type = this.getFieldType(fieldType.toUpperCase());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return type;
    }

    private String getMySQLFieldType(String fieldType){
        if(fieldType != null && !"".equals(fieldType)){
            if(fieldType.contains("(")){
                return fieldType.substring(0, fieldType.indexOf("("));
            }
        }
        return fieldType;
    }

    private MyIColumnType getFieldType(String fieldName) throws IllegalAccessException {
        fieldName = this.getMySQLFieldType(fieldName);
        System.out.println(fieldName);
        if("datetime".equalsIgnoreCase(fieldName)){
            return MyIColumnType.TIMESTAMP;
        }else if("date".equalsIgnoreCase(fieldName) || fieldName.contains("year")){
            return MyIColumnType.DATE;
        }
        Class clazz = Types.class;
        Field[] fields = clazz.getFields();
        for(Field field : fields){
            if(field.getName().equalsIgnoreCase(fieldName)){
                return MyIColumnType.valueOf(fieldName.toUpperCase());
            }
        }
        return MyIColumnType.VARCHAR;
    }

/*    public static void main(String[] args) throws IllegalAccessException {
        Class clazz = Types.class;
        Field[] fields = clazz.getFields();
        for(Field field : fields){
//            System.out.println(field.getName());
            if(field.getName().equalsIgnoreCase("VARCHAR")){
                System.out.println(field.get(field.getName()));
            }
        }
//        System.out.println(Types.ARRAY);
    }*/

}
