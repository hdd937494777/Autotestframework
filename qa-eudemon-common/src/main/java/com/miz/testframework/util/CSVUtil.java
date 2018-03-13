package com.miz.testframework.util;


import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import com.alibaba.fastjson.JSONObject;
import com.miz.testframework.vo.XlsRowVO;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by huangyt on 2017/7/10.
 */
public class CSVUtil {

    private  static  final Logger logger = LoggerFactory.getLogger(CSVUtil.class);


    /** static字段 */
    private static final int STATIC            = 0x00000008;

    /** final字段 */
    private static final int FINAL             = 0x00000010;


    /** LOGGER */
    private static final Log LOGGER            = LogFactory.getLog(CSVUtil.class);

    /**
     *解析excel为map
     * @param path 文件路径
     * @param sheetat 文件读取标签页(0,1)
     * @return
     */
    public static List<XlsRowVO> parseXls(String path, int sheetat ) {

        File file = new File(path);
        FileInputStream in;
        try {
            in = new FileInputStream(file);
            List<XlsRowVO> rowVOList = new ArrayList<XlsRowVO>();
            HSSFWorkbook workbook = new HSSFWorkbook(in);
            Sheet sheet = workbook.getSheetAt(0);
            int coloumNum = sheet.getRow(0).getPhysicalNumberOfCells();//列数
            int rowNums=sheet.getLastRowNum();//行数
            List<String> titleList = new ArrayList<>();
            for (int rowNum =0 ; rowNum <= rowNums ; rowNum++) {
                // 跳过title
                Row row = sheet.getRow(rowNum);
                if (row.getRowNum() == 0) {
                    for (int i = 0; i < coloumNum; i++){
                        titleList.add(row.getCell(i).getStringCellValue());
                    }
                    continue;
                }
                XlsRowVO xlsRowVO = new XlsRowVO();
                xlsRowVO.setRowNo(row.getRowNum() + 1);
                Map<String, Object > map = new HashMap<String ,Object >();
                xlsRowVO.setMapData(map);
                for (int i = 0; i < coloumNum; i++) {
                    Cell cell = row.getCell(i);
                    if (cell != null) {
                        row.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
                        xlsRowVO.getMapData().put(titleList.get(i),row.getCell(i).getStringCellValue().trim());
                    } else {
                        xlsRowVO.getMapData().put(titleList.get(i),"");
                    }
                }
                // 排除空白行
                if (!checkBlankLine(xlsRowVO.getMapData())) {
                    rowVOList.add(xlsRowVO);
                }

            }
            return rowVOList;
        } catch (Exception e) {
            throw new RuntimeException("解析excel文件失败", e);
        }
    }


    public static void writeExcel(String fileName){
        WritableWorkbook wwb = null;
        try {
            //首先要使用Workbook类的工厂方法创建一个可写入的工作薄(Workbook)对象
            wwb =  jxl.Workbook.createWorkbook(new File(fileName));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if(wwb!=null){
            //创建一个可写入的工作表
            //Workbook的createSheet方法有两个参数，第一个是工作表的名称，第二个是工作表在工作薄中的位置
            WritableSheet ws = wwb.createSheet("工作表名称", 0);

            //下面开始添加单元格
            for(int i=0;i<10;i++){
                for(int j=0;j<5;j++){
                    //这里需要注意的是，在Excel中，第一个参数表示列，第二个表示行
                    Label labelC = new Label(j, i, "这是第"+(i+1)+"行，第"+(j+1)+"列");
                    try {
                        //将生成的单元格添加到工作表中
                        ws.addCell(labelC);
                    } catch (RowsExceededException e) {
                        e.printStackTrace();
                    } catch (WriteException e) {
                        e.printStackTrace();
                    }

                }
            }

            try {
                //从内存中写入文件中
                wwb.write();
                //关闭资源，释放内存
                wwb.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (WriteException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *   将实体类的属性名读取并生成一个Excel文件POI
     *   @param   inputFile   输入模板文件路径
     *   @param   outputFile   输入文件存放于服务器路径
     *   @param   dataList   待导出数据
     *   @throws   Exception
     *   @roseuid:
     */
    public static void exportExcelDField(String inputFile,String outputFile,List dataList) throws Exception{
        //用模板文件构造poi
        POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(inputFile));
        //创建模板工作表
        HSSFWorkbook templatewb = new HSSFWorkbook(fs);
        //直接取模板第一个sheet对象
        HSSFSheet templateSheet = templatewb.getSheetAt(1);
        //得到模板的第一个sheet的第一行对象   为了得到模板样式
        HSSFRow templateRow = templateSheet.getRow(0);
        //HSSFSheet   timplateSheet   =   templatewb.getSheetAt(1);
        //取得Excel文件的总列数
        int columns = templateSheet.getRow((short) 0)
                .getPhysicalNumberOfCells();
        //  Debug.println("columns   is   :   " + columns);  //=========================
        //创建样式数组
        HSSFCellStyle styleArray[] = new HSSFCellStyle[columns];
        //一次性创建所有列的样式放在数组里
        for (int s = 0; s < columns; s++) {
            //得到数组实例
            styleArray[s] = templatewb.createCellStyle();
        }
        //循环对每一个单元格进行赋值
        //定位行
        for (int rowId = 1; rowId < dataList.size(); rowId++) {
            //依次取第rowId行数据   每一个数据是valueList
            List valueList = (List) dataList.get(rowId - 1);
            //定位列
            for (int columnId = 0; columnId < columns; columnId++) {
                //依次取出对应与colunmId列的值
                //每一个单元格的值
                String dataValue = (String) valueList.get(columnId);
                //取出colunmId列的的style
                //模板每一列的样式
                HSSFCellStyle style = styleArray[columnId];
                //取模板第colunmId列的单元格对象
                //模板单元格对象
                HSSFCell templateCell = templateRow.getCell((short) columnId);
                //创建一个新的rowId行   行对象
                //新建的行对象
                HSSFRow hssfRow = templateSheet.createRow(rowId);
                //创建新的rowId行   columnId列   单元格对象
                //新建的单元格对象
                HSSFCell cell = hssfRow.createCell((short) columnId);
                //如果对应的模板单元格   样式为非锁定
                if (templateCell.getCellStyle().getLocked() == false) {
                    //设置此列style为非锁定
                    style.setLocked(false);
                    //设置到新的单元格上
                    cell.setCellStyle(style);
                }
                //否则样式为锁定
                else {
                    //设置此列style为锁定
                    style.setLocked(true);
                    //设置到新单元格上
                    cell.setCellStyle(style);
                }
                //设置编码
               // cell.setEncoding(HSSFCell.ENCODING_UTF_16);
                //Debug.println("dataValue   :   "   +   dataValue);
                //设置值   统一为String
                cell.setCellValue(dataValue);
            }
        }
        //设置输入流
        FileOutputStream fOut = new FileOutputStream(outputFile);
        //将模板的内容写到输出文件上
        templatewb.write(fOut);
        fOut.flush();
        //操作结束，关闭文件
        fOut.close();
    }


    /**
     * 生成脚本对应的主csvw文件
     * @param fos 生成Excel文件Path
     * @param fileNames 要导入的数据
     */
    public static void  createCsvForMain(String fos, List<String> fileNames,String sheetName)
    {
        jxl.write.WritableWorkbook wwb;
        try
        {
            File file = new File(fos);
            File fileParent = file.getParentFile();
            if (!fileParent.exists()){
                fileParent.mkdirs();
            }
            file.createNewFile();
            List<String[]> outputValues = new ArrayList<String[]>();
            List<String> header = new ArrayList<String>();
            header.add("caseId");
            header.add("description");
            for (String name:fileNames) {
                if (name.equals("id") || name.equals("serialVersionUID")){
                    continue;
                }
                if (name.equals("createTime") || name.equals("updateTime")){
                    continue;
                }
                header.add(name);
            }
            header.add("expect_response_status");
            header.add("expect_response_code");
            header.add("expect_response_data");
            outputValues.add(header.toArray(new String[header.size()]));
            //初始化写入文件
            OutputStream outputStream = null;
            outputStream = new FileOutputStream(file);
            //将生成内容写入CSV文件
            OutputStreamWriter osw = null;
            osw = new OutputStreamWriter(outputStream);
            CSVWriter csvWriter = new CSVWriter(osw);
            csvWriter.writeAll(outputValues);
            csvWriter.close();

        } catch (Exception e) {
            logger.error("创建主文件失败",e);
        }
    }



    /**
     * 根据请求对象生成子CSV校验文件（注：该方法只支持简单对象，如果对象中嵌套复杂对象，则只生成第一层对象的CSV校验文件）
     * @param className 目标class
     * @param baseDir 目标路径（包含文件名）
     */
    public static void createCsvForRequest(String className,List<String> fileNames, String baseDir) {
        try {
            //组装文件路径
            File file = new File(baseDir);
            File fileParent = file.getParentFile();
            if (!fileParent.exists()){
                fileParent.mkdirs();
            }
            file.createNewFile();


            List<String[]> outputValues = new ArrayList<String[]>();
            //组装CSV文件第一行，标题行
            List<String> header = new ArrayList<String>();
            header.add("class");
            header.add("property");
            header.add("flag");
            header.add("exp");

            outputValues.add(header.toArray(new String[header.size()]));

            int i = 1;
            for (String filename : fileNames) {
                if (filename.equals("id") || filename.equals("serialVersionUID")){
                    continue;
                }
                if (filename.equals("createTime") || filename.equals("updateTime")){
                    continue;
                }
                List<String> value = new ArrayList<String>();
                if (1 == i) {
                    //如果是第一个生成字段，则内容需要包含class名
                    value.add(className);
                } else {
                    value.add("");
                }
                value.add(filename);
                value.add("Y");

                outputValues.add(value.toArray(new String[value.size()]));

                i++;
            }
            //初始化写入文件
            OutputStream outputStream = null;
            try {
                outputStream = new FileOutputStream(file);
            } catch (Exception e) {
                LOGGER.error("写入文件【" + baseDir + "】初始化失败", e);
                throw e;
            }
            //将生成内容写入CSV文件
            try {
                OutputStreamWriter osw = null;
                osw = new OutputStreamWriter(outputStream);
                CSVWriter csvWriter = new CSVWriter(osw);
                csvWriter.writeAll(outputValues);
                csvWriter.close();
            } catch (Exception e) {
                LOGGER.error("通过文件流导出数据失败", e);
                throw e;
            }

        } catch (Exception e) {
            LOGGER.error(e);
        }

        LOGGER.warn("CSV文件生成完毕");
    }

    /**
     * 生成字段为竖向排列的校验文件
     * @param T 需要生成的类
     * @param path 生成文件的绝对路径
     */
    public static void createVerticalCsvForCheck(Class T ,String path){
        try {
        //组装文件路径
        File file = new File(path);
        File fileParent = file.getParentFile();
        if (!fileParent.exists()){
            fileParent.mkdirs();
        }
        file.createNewFile();


        List<String[]> outputValues = new ArrayList<String[]>();
        //组装CSV文件第一行，标题行
        List<String> header = new ArrayList<String>();
        header.add("class");
        header.add("property");
        header.add("flag");
        header.add("exp");

        outputValues.add(header.toArray(new String[header.size()]));
        Object object = T.newInstance();
        List<String> fileNames =  ObjectReflact.getFiledName(object);
        String className = T.getName();
        header.add(className.substring(className.lastIndexOf(".")+1,className.length()));
        int i = 1;
        for (String filename : fileNames) {

            List<String> value = new ArrayList<String>();
            if (1 == i) {
                //如果是第一个生成字段，则内容需要包含class名
                value.add(className);
            } else {
                value.add("");
            }
            value.add(filename);
            value.add("Y");

            outputValues.add(value.toArray(new String[value.size()]));

            i++;
        }
        //初始化写入文件
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (Exception e) {
            LOGGER.error("写入文件【" + path + "】初始化失败", e);
            throw e;
        }
        //将生成内容写入CSV文件
        try {
            OutputStreamWriter osw = null;
            osw = new OutputStreamWriter(outputStream);
            CSVWriter csvWriter = new CSVWriter(osw);
            csvWriter.writeAll(outputValues);
            csvWriter.close();
        } catch (Exception e) {
            LOGGER.error("通过文件流导出数据失败", e);
            throw e;
        }

        } catch (Exception e) {
            LOGGER.error(e);
        }

        LOGGER.warn("CSV文件生成完毕");
    }

    /**
     * 生成字段为横向排列的校验文件
     * @param T 需要生成的类
     * @param path 生成文件的绝对路径
     */

    public static void  createTransverseCsvForCheck(Class T ,String path)
    {
        jxl.write.WritableWorkbook wwb;
        try
        {
            Object object = T.newInstance();
            List<String> fileNames =  ObjectReflact.getFiledName(object);
            File file = new File(path);
            File fileParent = file.getParentFile();
            if (!fileParent.exists()){
                fileParent.mkdirs();
            }
            file.createNewFile();
            List<String[]> outputValues = new ArrayList<String[]>();
            List<String> header = new ArrayList<String>();
            String className = T.getName();
            header.add(className.substring(className.lastIndexOf(".")+1,className.length()));
            for (String name:fileNames) {
                header.add(name);
            }
            outputValues.add(header.toArray(new String[header.size()]));
            //初始化写入文件
            OutputStream outputStream = null;
            outputStream = new FileOutputStream(file);
            //将生成内容写入CSV文件
            OutputStreamWriter osw = null;
            osw = new OutputStreamWriter(outputStream);
            CSVWriter csvWriter = new CSVWriter(osw);
            csvWriter.writeAll(outputValues);
            csvWriter.close();

        } catch (Exception e) {
            logger.error("创建主文件失败",e);
        }
    }








    /**
     * 获取CSV文件内容
     *
     * @param csvPath
     *            resources下的相对路径
     * @return List<String[]>
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings("unchecked")
    public static List<String[]> getCsvDataList(String csvPath) throws UnsupportedEncodingException {

        if (StringUtil.isEmpty(csvPath)) {
            logger.error("指定csv文件路径为空.");
            return null;
        }

        InputStream is = new StringUtil().getClass().getClassLoader().getResourceAsStream(csvPath);
        if (is == null) {
            String err = "指定csv文件路径[" + csvPath + "]未找到文件.";
            logger.error(err);
            return null;
        }

        InputStreamReader isr = new InputStreamReader(is,"UTF-8");
        CSVReader csvReader = new CSVReader(isr);
        try {
            return csvReader.readAll();
        } catch (IOException e) {
            logger.error("csv文件读取失败.", e);
        }

        return null;
    }


    public static <T> T requestfromCSV (String csvPath, Class<T> clazz, int index ) {

        try {
            List<String[]> rows = getCsvDataList(csvPath);
            int rowlength = rows.size();
            String fieldname = "";
            String value = "";
            final Map<String, String> params = new HashMap<>();
            for (int i = 1; i < rowlength; i++) {
                String[] row = rows.get(i);
                fieldname = row[1];
                value = row[3 + index];
                params.put(fieldname, value);
            }

            String param = JSONObject.toJSONString(params);
            return JSONObject.parseObject(param, clazz);

        } catch (UnsupportedEncodingException e) {
            logger.error("解析csv文件失败", e);
            return null;
        }
    }


    /**
     * 判断是否是空白行
     *
     * @param cells
     *            每行数据
     * @return true:空白行 false:非空白行
     */
    private static boolean checkBlankLine(Map<String, Object> cells) {
        if (cells == null || cells.size() < 1) {
            return true;
        }
        return false;

    }

    public static void main(String[] args){
       /* final Map<String, String> params = new HashMap<>();
        params.put("requestId","sfs");
        params.put("merchantAccount","s001");
        String param = JSON.toJSONString(params);
        JSONObject json = JSONObject.parseObject(param);
        RequestInfoBo request = JSONObject.toJavaObject(json,RequestInfoBo.class);*/
        //createTransverseCsvForCheck(ErrorRequest.class,"E:\\workspace-test\\qa-eudemon\\qa-eudemon-common\\src\\test\\java\\com\\miz\\autotest\\servicetest\\errorrequestservice.csv");

        // createVerticalCsvForCheck(RequestInfoBo.class,"E:\\workspace-test\\qa-eudemon\\qa-eudemon-common\\src\\main\\java\\com\\miz\\testframework\\util\\db.csv");
    }

}
