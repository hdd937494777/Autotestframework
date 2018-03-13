package com.miz.testframework.jdbc;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by huangyt on 2017/7/19.
 */
public class JDBCUtils {
        static String resource = "com/oraro/cec/mybatis-config.xml";
        private static SqlSessionFactory sqlSessionFactory;

        public static SqlSessionFactory getInstance() {
            if (sqlSessionFactory == null) {
                synchronized (JDBCUtils.class) {
                    if (sqlSessionFactory == null) {
                        InputStream inputStream;
                        try {
                            inputStream = Resources.getResourceAsStream(resource);
                            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
                        } catch (IOException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                            System.out.println("getInstance() " + e);
                        }
                    }
                }
            }

            return sqlSessionFactory;
        }

        public static Object selectOne(String method, Object object) {
            Object mObject = null;
            SqlSession session=getInstance().openSession();
            try {
                mObject = session.selectOne(method, object);
            } catch (Exception e) {
                e.printStackTrace();
                // TODO: handle exception
                System.out.println("数据库操作  " + e);
            } finally {
                synchronized (JDBCUtils.class) {
                    if (session != null) {
                        session.close();
                    }
                    session = null;
                }
            }
            return mObject;
        }

        public static List selectList(String method, Object object) {
            List mObjects = null;
            SqlSession session=getInstance().openSession();
            try {
                mObjects = session.selectList(method, object);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库操作  " + e);
            } finally {
                synchronized (JDBCUtils.class) {
                    if (session != null) {
                        session.close();
                    }
                    session = null;
                }
            }
            return mObjects;
        }
        public static List selectList(String method) {
            List mObjects = null;
            SqlSession session=getInstance().openSession();
            try {
                mObjects = session.selectList(method);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库操作  " + e);
            } finally {
                synchronized (JDBCUtils.class) {
                    if (session != null) {
                        session.close();
                    }
                    session = null;
                }
            }
            return mObjects;
        }
        public static List selectAll(String method) {
            List mObjects = null;
            SqlSession session=getInstance().openSession();
            try {
                mObjects =session.selectList(method);
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库操作  " + e);
            } finally {
                synchronized (JDBCUtils.class) {
                    if (session != null) {
                        session.close();
                    }
                    session = null;
                }
            }
            return mObjects;
        }

        public static long insert(String method, Object entity) {
            long id = 0;
            SqlSession session=getInstance().openSession();
            try {
                id =session.insert(method, entity);
                // 这里必须commit,否则增删改无效
                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库操作  " + e);
            } finally {
                synchronized (JDBCUtils.class) {
                    if (session != null) {
                        session.close();
                    }
                    session = null;
                }
            }
            return id;
        }

        public static long deleteById(String method, long id) {
            long mId = 0;
            SqlSession session=getInstance().openSession();
            try {
                mId = session.delete(method, id);
                // 这里必须commit,否则增删改无效
                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库操作  " + e);
            } finally {
                synchronized (JDBCUtils.class) {
                    if (session != null) {
                        session.close();
                    }
                    session = null;
                }
            }
            return mId;
        }

        public static long update(String method, Object object) {
            long mId = 0;
            SqlSession session=getInstance().openSession();
            try {
                mId = session.update(method, object);
                // 这里必须commit,否则增删改无效
                session.commit();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("数据库操作  " + e);
            } finally {
                synchronized (JDBCUtils.class) {
                    if (session != null) {
                        session.close();
                    }
                    session = null;
                }
            }
            return mId;
        }

}
