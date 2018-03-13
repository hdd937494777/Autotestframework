package com.mizlicai.cashier.util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Created by MaiBenBen on 2017/6/2.
 */
public class SheetUtils {
    public static void removeSheetByName(XSSFWorkbook wb, String string) {
        XSSFSheet sheet = wb.getSheet(string);
        wb.removeSheetAt(wb.getSheetIndex(sheet));
    }
}
