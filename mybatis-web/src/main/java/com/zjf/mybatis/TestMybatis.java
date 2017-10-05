package com.zjf.mybatis;

import java.io.Reader;
import java.util.List;

import com.zjf.mybatis.dao.PersonDao;
import com.zjf.mybatis.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * Created by Administrator on 2017/9/30.
 */
public class TestMybatis {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            //读取配置文件
            reader = Resources.getResourceAsReader("META-INF/mybatis.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static SqlSessionFactory getSession() {
        return sqlSessionFactory;
    }
//通过id查询Person表
    public void getPersonByID(Long id) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PersonDao pd = session.getMapper(PersonDao.class);

            Person person = pd.selectPersonByID(id);
            if (person != null) {
                System.out.println(person.getId() + ":" + person.getUserName() + ":" + person.getGender1() + ":" + person.getMobilephone());
            }
        } finally {
            session.close();
        }
    }

    public void getPersons() {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PersonDao pd = session.getMapper(PersonDao.class);

            List<Person> persons = pd.selectAll();
            if(persons != null){
                for(Person person : persons){
                    System.out.println(person.getId() + ":" + person.getUserName() + ":" + person.getGender1() + ":" + person.getMobilephone());
                }
            }

        } finally {
            session.close();
        }
    }
    //通过userName查询Person表中相同userName的成员
    public void getPersonByName(String userName) {
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PersonDao pd = session.getMapper(PersonDao.class);
            List<Person>  persons = pd.selectPersonByName(userName);
            for(Person ss :persons){
                if (ss != null) {
                    System.out.println(ss.getId() + ":" + ss.getUserName() + ":" + ss.getGender1() + ":" + ss.getMobilephone());
                }
            }
        } finally {
            session.close();
        }
    }
    //进行表的更新操作
 public  void  updatePerson1(int id){
     SqlSession session = sqlSessionFactory.openSession();
     try {
         PersonDao pd = session.getMapper(PersonDao.class);
         Person person = pd.selectPersonByID(Long.valueOf(String.valueOf(id)));
         if(person!=null){
                person.setUserName("小小");
                person.setGender1("女");
                person.setMobilephone("13726741987");
                pd.updatePerson(person);
                session.commit();
         }
     } finally {
         session.close();
     }
 }
//进行表中成员的插入操作
public void addPerson1(String userName , String gender, String mobilephone){
    Person person = new Person();
    person.setUserName(userName);
    person.setGender1(gender);
    person.setMobilephone(mobilephone);
    SqlSession session = sqlSessionFactory.openSession();
    try {
        PersonDao pd = session.getMapper(PersonDao.class);
        pd.addPerson(person);
        session.commit();
        System.out.println("新增用户id为:"+ person.getId());
        }
    finally {
        session.close();
    }
}
//进行表中成员的删除操作
    public  void deletePerson1(int id){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            PersonDao pd = session.getMapper(PersonDao.class);
            pd.deletePerson(id);
            session.commit();
        }
        finally {
            session.close();
        }
    }

public static void main(String[]  args){
    TestMybatis TM =  new TestMybatis();
  //  TM.addPerson1("小he","女","13726741987");
    //TM.deletePerson1(2);
   //TM.getPersons();
  TM.updatePerson1(3);
//      TM.getPersonByName("章静芳");
}

}
