package	 com.wbg.Util;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.sql.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DBUtil {
    //连接对象
    //Statement 命令对象
    //打开连接
    //关闭连接
    //得到一个连接对象
    //查询（有参，无参）
    //修改（有参，无参）
    static Statement stmt = null;
    //驱动，服务器地址，登录用户名，密码
    static String DBDRIVER="com.mysql.jdbc.Driver";
    static String DBURL="jdbc:mysql://localhost:3306/shoppingmall";
    static String DBUID="root";
    static String DBPWD="123456";
    //打开连接
    static  {
        //加载驱动
        try {
            Class.forName(DBDRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //关闭连接
    public static void close(Connection conn) {
        try {
            if(stmt!=null)
                stmt.close();
            if(conn!=null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 用于关闭
     * @param rs
     */
    public static void close(ResultSet rs) {
        Statement st = null;
        Connection con = null;
        try {
            try {
                if (rs != null) {
                    st = rs.getStatement();
                    rs.close();
                }
            } finally {
                try {
                    if (st != null) {
                        con = st.getConnection();
                        st.close();
                    }
                } finally {
                    if (con != null) {
                        con.close();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //得到一个连接对象，当用户使用DBUtil无法解决个性问题时
    //可以通过本方法获得连接对象
    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn=DriverManager.getConnection(DBURL,DBUID,DBPWD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //executeQuery
    //executeUpdate
    //execute
    //获得查询的数据集
    /**
     * 查询所有数据,转入查询字符串
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(String sql) {
        Connection conn = getConnection();
        try {
            stmt = conn.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    //修改表格内容
    /**
     * 进行修改,转入修改字符串
     * @param sql
     * @return
     */
    public static int executeUpdate(String sql) {
        Connection conn = getConnection();
        int result = 0;
        try {
            stmt = conn.createStatement();
            result = stmt.executeUpdate(sql);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            close(conn);
        }
        return result;
    }
    //如果执行的查询或存储过程，会返回多个数据集，或多个执行成功记录数
    //可以调用本方法，返回的结果，
    //是一个List<ResultSet>或List<Integer>集合
    public static Object execute(String sql) {
        Connection conn = getConnection();
        boolean b=false;
        try {
            stmt = conn.createStatement();
            b = stmt.execute(sql);
            //true,执行的是一个查询语句，我们可以得到一个数据集
            //false,执行的是一个修改语句，我们可以得到一个执行成功的记录数
            if(b){
                return stmt.getResultSet();
            }
            else {
                return stmt.getUpdateCount();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(!b) {
                close(conn);
            }
        }
        return null;
    }

    //
    //select * from student where name=? and sex=?
    /**
     * 进行条件查询,转入查询字符串,和参数
     * @param sql
     * @return
     */
    public static ResultSet executeQuery(String sql,Object[] in) {
        Connection conn = getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for(int i=0;i<in.length;i++)
                pst.setObject(i+1, in[i]);
            stmt = pst;//只是为了关闭命令对象pst
            return pst.executeQuery();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    public static int executeUpdate(String sql,Object[] in) {
        Connection conn = getConnection();
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for(int i=0;i<in.length;i++)
                pst.setObject(i+1, in[i]);
            stmt = pst;//只是为了关闭命令对象pst
            return pst.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            close(conn);
        }
        return 0;
    }
    public static Object execute(String sql,Object[] in) {
        Connection conn = getConnection();
        boolean b=false;
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            for(int i=0;i<in.length;i++)
                pst.setObject(i+1, in[i]);
            b = pst.execute();
            //true,执行的是一个查询语句，我们可以得到一个数据集
            //false,执行的是一个修改语句，我们可以得到一个执行成功的记录数
            if(b){
                System.out.println("----");
					/*List<ResultSet> list = new ArrayList<ResultSet>();
					list.add(pst.getResultSet());
					while(pst.getMoreResults()) {
						list.add(pst.getResultSet());
					}*/
                return pst.getResultSet();
            }
            else {
                System.out.println("****");
                List<Integer> list = new ArrayList<Integer>();
                list.add(pst.getUpdateCount());
                while(pst.getMoreResults()) {
                    list.add(pst.getUpdateCount());
                }
                return list;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            if(!b) {
                System.out.println("====");
                close(conn);
            }
        }
        return null;
    }
    //调用存储过程  proc_Insert(?,?,?)
    public static Object executeProcedure(String procName,Object[] in) {
        Connection conn = getConnection();
        try {
            procName = "{call "+procName+"(";
            String link="";
            for(int i=0;i<in.length;i++) {
                procName+=link+"?";
                link=",";
            }
            procName+=")}";
            CallableStatement cstmt = conn.prepareCall(procName);
            for(int i=0;i<in.length;i++) {
                cstmt.setObject(i+1, in[i]);
            }
            if(cstmt.execute())
            {
                return cstmt.getResultSet();
            }
            else {
                return cstmt.getUpdateCount();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }


    /*
     * 调用存储过程，并有输出参数
     * @procName ，存储过程名称：proc_Insert(?,?)
     * @in ,输入参数集合
     * @output,输出参数集合
     * @type,输出参数类型集合
     * */
    public static Object executeOutputProcedure(String procName,
                                                Object[] in,Object[] output,int[] type){
        Connection conn = getConnection();
        Object result = null;
        try {
            CallableStatement cstmt = conn.prepareCall("{call "+procName+"}");
            //设置存储过程的参数值
            int i=0;
            for(;i<in.length;i++){//设置输入参数
                cstmt.setObject(i+1, in[i]);
                //print(i+1);
            }
            int len = output.length+i;
            for(;i<len;i++){//设置输出参数
                cstmt.registerOutParameter(i+1,type[i-in.length]);
                //print(i+1);
            }
            boolean b = cstmt.execute();
            //获取输出参数的值
            for(i=in.length;i<output.length+in.length;i++)
                output[i-in.length] = cstmt.getObject(i+1);
            if(b) {
                result = cstmt.getResultSet();
            }
            else {
                result = cstmt.getUpdateCount();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }
    public static String toJson(Object obj){
        String reuqest=null;
        //对象映射
        ObjectMapper mapper=new ObjectMapper();
        //设置时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy年MM月dd日");
        mapper.setDateFormat(dateFormat);
        try {
            reuqest=mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reuqest;
    }
    public static String toJsonMMddHHmmss(Object obj){
        String reuqest=null;
        //对象映射
        ObjectMapper mapper=new ObjectMapper();
        //设置时间格式
        SimpleDateFormat dateFormat=new SimpleDateFormat("MMddHHmmss");
        mapper.setDateFormat(dateFormat);
        try {
            reuqest=mapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return reuqest;
    }
    public static <T> T toObject(String src,Class<T> valueType){
        T request=null;
        //对象反射
        ObjectMapper mapper=new ObjectMapper();
        try {
            request=mapper.readValue(src, valueType);
        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return request;
    }
    /**
     * 字符串转入时间格式,返回Date类型
     * @param date_str
     * @return
     */
    public static Date date(String date_str) {
        try {
            Calendar zcal = Calendar.getInstance();//日期类
            Timestamp timestampnow = new Timestamp(zcal.getTimeInMillis());//转换成正常的日期格式
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//改为需要的东西
            ParsePosition pos = new ParsePosition(0);
            java.util.Date current = formatter.parse(date_str, pos);
            timestampnow = new Timestamp(current.getTime());
            return timestampnow;
        }
        catch (NullPointerException e) {
            return null;
        }
    }
    /**
     * MD5加密
     */
    public static String MD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }
}
