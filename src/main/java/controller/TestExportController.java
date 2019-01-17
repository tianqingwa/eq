package controller;

import ch.qos.logback.core.util.FileUtil;
import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import entity.ExcelEntity;
import entity.ExcelUtil;
import org.apache.catalina.util.ParameterMap;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tianqinghua
 * @date 2018/11/26 10:42
 */
@RestController
@RequestMapping("/test")
public class TestExportController {
    @GetMapping("/testExport")
    public void testExpost(HttpServletResponse response) {
        List<ExcelEntity> list = new ArrayList<>();
        list.add(new ExcelEntity("test1", "1", "1"));
        list.add(new ExcelEntity("test2", "2", "2"));
        list.add(new ExcelEntity("test2", "2", "2"));
        list.add(new ExcelEntity("test2", "2", "2"));
//        Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams(),
//                ExcelEntity.class, list);
        ExcelUtil.exportExcel(list, "testTitle", "testSheetName", ExcelEntity.class, "testFileName.xls", response);
//        C:\Users\ThinkPad\Desktop
    }

    @GetMapping("/testImport")
    public void testImport() {
        String filePath = "C:\\Users\\ThinkPad\\Desktop\\testFileName.xls";
        //解析excel，
        List<ExcelEntity> personList = ExcelUtil.importExcel(filePath, 1, 1, ExcelEntity.class);
        //也可以使用MultipartFile,使用 FileUtil.importExcel(MultipartFile file, Integer titleRows, Integer headerRows, Class<T> pojoClass)导入
        System.out.println("导入数据一共【" + personList.size() + "】行");

        //TODO 保存数据库

    }
}
