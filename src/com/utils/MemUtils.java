package com.utils;

import com.Bean.Meeting;
import com.Bean.MemberInfo;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemUtils {
    public static List<String> searchByMail(String mail) {
        List<String> temp = new ArrayList<>();
        String[] mem = FieldsName.getName(MemberInfo.class);
        try {
            PreparedStatement pstm = DB.getPrepareStmt(SQL.checkEmail);
            pstm.setString(1, mail);
            ResultSet rs = DB.executeQuery(pstm);
            while (rs.next()) {
                temp.add(getStringBuilder(mem, rs).toString());

            }
            rs.close();
            if (temp.size() > 0) {
                return temp;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean checkPassword(String mail, String password) {

        try {
            PreparedStatement pstm = DB.getPrepareStmt(SQL.checkEmail);
            pstm.setString(1, mail);
            ResultSet rs = DB.executeQuery(pstm);
            if (rs.next()) {
                if (password.equals(rs.getString("password"))) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }


    public static int insertMember(MemberInfo obj, String sql) {
        String[] obFields = FieldsName.getName(obj.getClass());
        String[] values = getObjFieldsValue(obj, obFields);
        return updateInfo(sql, values);
    }

    public static int updateStatus(String id, String status,String sql) {
        PreparedStatement preparedStatement = DB.getPrepareStmt(sql);
        try {
            preparedStatement.setString(1, status);
            preparedStatement.setString(2, id);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int deleteById(String id, String sql) {
        PreparedStatement preparedStatement = DB.getPrepareStmt(sql);
        try {
            preparedStatement.setInt(1, Integer.parseInt(id));
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static <T> int updateSQL(T obj, String sql) {

        String[] obFields = FieldsName.getName(obj.getClass());
        String[] values = getObjFieldsValue(obj, obFields);
        return updateInfo(sql, values);

    }

    public static int updateTimes(String id) {
        PreparedStatement preparedStatement = DB.getPrepareStmt(SQL.updateVoteArticle);

        try {
            preparedStatement.setInt(1, Integer.parseInt(id));
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static int updateInfo(String sql, String[] values) {
        PreparedStatement preparedStatement = DB.getPrepareStmt(sql);
        for (int i = 0; i < values.length; i++) {
            try {
                preparedStatement.setString(i + 1, values[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        try {
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static String[] getObjFieldsValue(Object obj, String[] obFields) {
        Class clazz = obj.getClass();
        String[] values = new String[obFields.length];

        for (int i = 0; i < obFields.length; i++) {
            try {
                Field field = clazz.getDeclaredField(obFields[i]);
                field.setAccessible(true);
                values[i] = (String) field.get(obj);

            } catch (Exception e) {
                values[i] = null;

            }

        }
        return values;
    }

    public static List<String> searchAll(String sql, Class clazz) {
        String[] mem = FieldsName.getName(clazz);
        List<String> temp = new ArrayList<>();
        try {
            ResultSet rs = DB.executeQuery(sql);
            while (rs.next()) {
                temp.add(getStringBuilder(mem, rs).toString());
            }
            rs.close();
            if (temp.size() > 0) {
                return temp;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static StringBuilder getStringBuilder(String[] mem, ResultSet rs) throws SQLException {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < mem.length; i++) {
            sb.append("\"");
            sb.append(mem[i]);
            sb.append("\"");
            sb.append(":");
            sb.append("\"" + rs.getString(mem[i]) + "\"");
            if (i != mem.length - 1) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb;
    }
}
