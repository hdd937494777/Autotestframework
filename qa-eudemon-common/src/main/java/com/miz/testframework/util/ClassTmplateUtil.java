//package com.miz.testframework.util;
//
//import com.alibaba.fastjson.JSONObject;
//import com.miz.rapid.lang.resp.pojo.IBo;
//import com.miz.testframework.entity.ClassEntity;
//import freemarker.template.Configuration;
//import freemarker.template.DefaultObjectWrapper;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//import java.io.File;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.Writer;
//import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ClassTmplateUtil {
//
//    private static Logger logger = LoggerFactory.getLogger(ClassTmplateUtil.class);
//
//    private static  File javaFile = null;
//
//    /**
//     *   根据模板生成测试脚本
//     * @param classs     测试类 eg: BidService.class
//     * @param testAbsolutePath  模板加载数据源地址 eg: E:\workspace-dev\neutralgate\test\src\test
//     * @param suffix  生成脚本文件的后缀 eg: Normal，FuncExp
//     *
//     */
//    public static void classTemplate(Class classs,String methodName,String testAbsolutePath, String suffix) {
//
//        Configuration cfg = new Configuration();
//        try {
//            // 步骤一：指定 模板文件从何处加载的数据源，这里设置一个文件目录
//            //String templatePath = ClassTmplateUtil.class.getClassLoader().getResource("").getPath()+"template";
//             String templatePath = ClassTmplateUtil.class.getClass().getResource("/").getPath()+"template"+File.separator;
//            cfg.setDirectoryForTemplateLoading(new File(templatePath));
//            cfg.setObjectWrapper(new DefaultObjectWrapper());
//
//            // 步骤二：获取 模板文件
//            Template template = cfg.getTemplate("javaTemplate.ftl");
//
//            // 步骤三：创建 数据模型
//            Map<String, Object> root = getClassProperty(classs,methodName,suffix,testAbsolutePath);
//
//
//            // 步骤四：合并 模板 和 数据模型
//            // 创建.java类文件
//            if (javaFile != null) {
//                Writer javaWriter = new FileWriter(javaFile);
//                template.process(root, javaWriter);
//                javaWriter.flush();
//               logger.info("文件生成路径：{}" , javaFile.getCanonicalPath());
//                javaWriter.close();
//            }
//            // 输出到Console控制台
//          /*  Writer out = new OutputStreamWriter(System.out);
//            template.process(root, out);
//            out.flush();
//            out.close();*/
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (TemplateException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * 解析测试服务类与方法
//     *
//     * @return
//     */
//    private static Map<String, Object> getClassProperty(Class T, String methodName,String suffix,String testAbsolutePath) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
//        Map<String, Object> map = new HashMap<>();//ftl模板解析对象存放map
//        ClassEntity classEntity = new ClassEntity();//ftl模板解析对象
//        List<String> requestParameters = new ArrayList<String>();//测试接口方法对应请求体的参数列表
//        List<String> listFileName = new ArrayList<>();//测试接口方法对应请求体的参数名列表
//        List<Map<String, String>> methodParameter = new ArrayList<>();//测试接口方法对应请求体的参数名、参数类型的键值对
//
//        //1、获取类名
//        String className = T.getName();
//        classEntity.setClassName(className);//接口类名
//        classEntity.setShortClassName(className.substring(className.lastIndexOf(".")+1,className.length()));//接口类名简写
//        classEntity.setScriptClassName(methodName + suffix+"Test" );//脚本类名
//
//        //2、获取方法名
//        classEntity.setMethodName(methodName);//测试接口方法名
//
//        //3、获取类的包名
//        String packageName = T.getPackage().getName();
//        classEntity.setPackageName(packageName);//接口包名
//        classEntity.setScriptPackage("com.miz.autotest.servicetest."+classEntity.getShortClassName().toLowerCase());//脚本包名
//
//        //4、获取对应方法的参数对象
//        Method[] methods = T.getMethods();
//        for (Method method : methods) {
//            if (methodName.trim().equals(method.getName())) {
//                //5、获取对应方法的返回类型、返回类型的简写
//                Type returnType = method.getGenericReturnType();
//                String returnTypeName = returnType.getTypeName();
//                classEntity.setReturnType(returnTypeName);
//                if (returnType.getTypeName().contains(".")){
//                    classEntity.setShortReturnType(returnTypeName.substring(returnTypeName.lastIndexOf(".")+1,returnTypeName.length()));
//                }else{
//                    classEntity.setShortReturnType(returnTypeName);
//                }
//
//                Class[] parameterTypes = method.getParameterTypes();
//                for (Class<?> clas : parameterTypes) {
//                    String requestParameter = clas.getName();
//                    if( requestParameter.contains("miz")){
//                        Class clazz = Class.forName(requestParameter);
//                        IBo duang = (IBo) clazz.newInstance();
//                        listFileName =  ObjectReflact.getFiledName(duang);
//                        methodParameter = ObjectReflact.getFiledsMap(duang);
//                    }
//                    classEntity.setXlsParameter(listFileName);
//                    classEntity.setMethodParameter(methodParameter);
//
//
//                    if (requestParameter.contains(".")){
//                        classEntity.setShortRequestName(requestParameter.substring(requestParameter.lastIndexOf(".")+1,requestParameter.length()));
//                    }else{
//                        classEntity.setShortRequestName(requestParameter);
//                    }
//
//                    //7、生成主csv
//                    String maincsvPath = testAbsolutePath + "/resources/testers"+File.separator+suffix.toLowerCase()+File.separator+methodName+File.separator+methodName+suffix+"Test"+"."+methodName+".csv";
//                    CSVUtil.createCsvForMain(maincsvPath,listFileName,methodName);
//
//                    //8、生成请求csv
//                    String requestcsvPath = testAbsolutePath + "/resources/testers"+File.separator+suffix.toLowerCase()+File.separator+methodName+File.separator+"request.csv";
//                    CSVUtil.createCsvForRequest(classEntity.getShortClassName(),listFileName,requestcsvPath);
//
//                    requestParameters.add(requestParameter);
//                    logger.info("获取类: {}的方法：{}的入参为:{}返回参数值：{}",className,methodName,requestParameter,returnType);
//                }
//                classEntity.setRequestParameters(requestParameters);
//                break;
//            }
//        }
//
//        map.put("classEntity",classEntity);
//        logger.info("解析出来的类对象属性ClassEntity：{}",JSONObject.toJSONString(classEntity));
//
//        // 9、创建.java类文件
//        File outDirFile = new File(testAbsolutePath+"/java");
//        if (!outDirFile.exists()) {
//            outDirFile.mkdir();
//        }
//
//
//
//
//        javaFile = toJavaFilename(outDirFile, classEntity.getShortClassName(),methodName,suffix);
//
//        return map;
//    }
//
//    /**
//     * 创建.java文件所在路径 和 返回.java文件File对象
//     *
//     * @param outDirFile    生成文件路径
//     * @param methodName   方法名
//     * @param shortClassName java类名
//     * @return
//     */
//    private static File toJavaFilename(File outDirFile,String shortClassName,String methodName,String suffix) {
//        String javaClassSub = "com/miz/autotest/servicetest/" +shortClassName.toLowerCase();//javaClassName.replace('.', '/');
//        File javaClassPath = new File(outDirFile, javaClassSub);
//        File file = new File(javaClassPath, methodName + suffix + "Test.java");
//        if (!javaClassPath.exists()) {
//            javaClassPath.mkdirs();
//        }
//        return file;
//    }/*
//    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
//        classTemplate(ErrorRequestService.class, "insert","E:\\workspace-test\\qa-eudemon\\qa-eudemon-common\\src\\test","Normal");
//
//    }*/
//}
