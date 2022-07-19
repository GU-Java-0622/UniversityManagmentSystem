package web.validators;


import javax.persistence.Column;
import java.lang.reflect.Field;

public class FieldNameChecker {
    public static String checkFieldName(Class clazz,String fieldName){
        if(fieldName==null){
            return null;
        }
        if(fieldName.equals("id")){
            return "id";
        }
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Column col = field.getAnnotation(Column.class);
            if (col != null && col.name().equals(fieldName)) {
                return field.getName();
            }
        }
        return null;
    }
}
