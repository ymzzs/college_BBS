package muzhou.com.dao.daoImpl;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.*;

import muzhou.com.utils.DbConnectionUtil;

public class DAO<T> {

    public Class<T> clazz;

    private QueryRunner queryRunner = new QueryRunner();

    public DAO(){
        Type superClass = getClass().getGenericSuperclass();
        if(superClass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType)superClass;
            Type[] typeArgs = parameterizedType.getActualTypeArguments();
            if(typeArgs != null && typeArgs.length > 0) {
                if(typeArgs[0] instanceof Class) {
                    clazz = (Class<T>) typeArgs[0];
                }
            }
        }
    }



    /**
     *
     * @param sql
     * @param objects
     */
    public void update(String sql,Object... objects) {
        Connection connection = null;
		/*for(Object o : objects) {
			System.out.println(o);
		}*/
        try {
            connection = DbConnectionUtil.getConnection();
            //System.out.println("��ʼִ��");
            queryRunner.update(connection,sql,objects);
            //System.out.println("�Ѿ��ύ");

        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            DbConnectionUtil.closeConnection(connection);

        }
    }

    /**
     *
     * @param sql
     * @param objects
     * @return
     */
    public T get(String sql,Object ... objects) {
        Connection connection = null;
        try {
            connection = DbConnectionUtil.getConnection();
            return queryRunner.query(connection,sql, new BeanHandler<>(clazz), objects);
        } catch (Exception e) {
            // TODO: handle exception
        }finally {

            DbConnectionUtil.closeConnection(connection);
        }
        return null;
    }

    /**
     *
     * @param sql
     * @param objects
     * @return
     */
    public List<T> getForList(String sql,Object ... objects){

        Connection connection = null;
        try {
            connection = DbConnectionUtil.getConnection();
            return queryRunner.query(connection,sql, new BeanListHandler<>(clazz), objects);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DbConnectionUtil.closeConnection(connection);
        }
        return null;

    }
    public List<Map<String,Object>> getForMapList(String sql, Object ... objects){

        Connection connection = null;
        try {
            connection = DbConnectionUtil.getConnection();
            return queryRunner.query(connection,sql, new MapListHandler(), objects);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DbConnectionUtil.closeConnection(connection);
        }
        return null;

    }
    public Map<String,Object> getForMap(String sql, Object ... objects){

        Connection connection = null;
        try {
            connection = DbConnectionUtil.getConnection();
            return queryRunner.query(connection,sql, new MapHandler(), objects);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            DbConnectionUtil.closeConnection(connection);
        }
        return null;

    }

    /**
     *
     * @param sql
     * @param objects
     * @return
     */
    @SuppressWarnings("unchecked")
    public <E> E getForValue(String sql,Object ... objects){
        Connection connection = null;
        try {
            connection = DbConnectionUtil.getConnection();
            return (E)queryRunner.query(connection,sql, new ScalarHandler(), objects);
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            DbConnectionUtil.closeConnection(connection);
        }

        return null;

    }

}
