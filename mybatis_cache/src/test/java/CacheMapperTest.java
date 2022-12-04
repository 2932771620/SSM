import com.atguigu.mybatis.Mapper.CacheMapper;
import com.atguigu.mybatis.pojo.Emp;
import com.atguigu.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.lf5.util.Resource;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    /*
    一级缓存是sqlSession级别的，通过同一个sqlSession查询出的数据会被缓存，如果需要再次查询
    同一条数据，则需要从缓存中获取
    增删改会清空缓存
    MyBatis的二级缓存：
    myBatis的二级缓存是SqlSessionFactory级别的，即通过同一个SqlSessionFactory所获得的SqlSession
    对象查询的数据会被缓存，在通过同一个SqlSessionFactory所获得的SqlSession查询相同的对象会从缓存中获得
    查询的数据转换的实体类型必须实现序列化接口
    映射文件设置标签<cache/>
    sqlSession必须关闭或者提交
     */
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp empById = mapper.getEmpById(1);
        System.out.println(empById);
        sqlSession.clearCache();//手动清空
        Emp empById1 = mapper.getEmpById(1);
        System.out.println(empById1);
    }
    @Test
    public void test2() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = build.openSession(true);
        SqlSession sqlSession1 = build.openSession(true);
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
        Emp empById = mapper.getEmpById(1);
        sqlSession.close();
        Emp empById1 = mapper1.getEmpById(1);
        System.out.println(empById);
        System.out.println(empById1);
    }

}
