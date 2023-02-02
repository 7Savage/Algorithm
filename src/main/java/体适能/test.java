package 体适能;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class test {

    static String[] T;
    static double[] Power;
    static double[] SBP;
    static double[] DBP;
    static double[] VO2;//摄氧量
    static double[] VCO2;//二氧化碳产生量
    static double[] VE;//通气量
    static double[] RR;//呼吸频率
    static double[] BOA;//脑氧
    static double[] HR;//心率
    static double[] SV;//每搏输出量
    static double[] CO;//心输出量
    static double[] SI;
    static double[] CI;
    static double[] ICON;
    static double[] LVET;
    static double[] Time;
    static double[] EQO2;
    static double[] EQCO2;
    static double[] OP;
    static double[] RQ;
    static double[] Ca_vO2;


    public static void main(String[] args) {
        readExcel();
        CPETAssessment();
    }

    public static void readExcel() {
        //excel文件路径
        String excelPath = "/Users/eric_wang/IdeaProjects/Algorithm/src/main/java/体适能/被试1.xlsx";

        try {
            //String encoding = "GBK";
            File excel = new File(excelPath);
            if (excel.isFile() && excel.exists()) {   //判断文件是否存在

                String[] split = excel.getName().split("\\.");  //.是特殊字符，需要转义！！！！！
                Workbook wb;
                //根据文件后缀（xls/xlsx）进行判断
                if ("xls".equals(split[1])) {
                    FileInputStream fis = new FileInputStream(excel);   //文件流对象
                    wb = new HSSFWorkbook(fis);
                } else if ("xlsx".equals(split[1])) {
                    wb = new XSSFWorkbook(excel);
                } else {
                    System.out.println("文件类型错误!");
                    return;
                }

                //开始解析
                Sheet sheet = wb.getSheetAt(0);     //读取sheet 0

                int firstRowIndex = sheet.getFirstRowNum() + 1;   //第一行是列名，所以不读
                int lastRowIndex = sheet.getLastRowNum();
                int nums = lastRowIndex;//行数
                T = new String[nums];
                Power = new double[nums];
                SBP = new double[nums];
                DBP = new double[nums];
                VO2 = new double[nums];
                VCO2 = new double[nums];
                VE = new double[nums];
                RR = new double[nums];
                BOA = new double[nums];
                HR = new double[nums];
                SV = new double[nums];
                CO = new double[nums];
                SI = new double[nums];
                CI = new double[nums];
                ICON = new double[nums];
                LVET = new double[nums];
                Time = new double[nums];
                EQO2 = new double[nums];
                EQCO2 = new double[nums];
                OP = new double[nums];
                RQ = new double[nums];
                Ca_vO2 = new double[nums];


                for (int rIndex = firstRowIndex; rIndex <= lastRowIndex; rIndex++) {   //遍历行
                    //System.out.println("rIndex: " + rIndex);
                    Row row = sheet.getRow(rIndex);
                    if (row != null) {
                        int cIndex = row.getFirstCellNum();
                        cIndex++;//过滤帧头
                        T[rIndex - 1] = String.valueOf(row.getCell(cIndex++).getNumericCellValue());
                        Power[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        SBP[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        DBP[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        VO2[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        VCO2[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        VE[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        RR[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        BOA[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        HR[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        SV[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        CO[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        SI[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        CI[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        ICON[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        LVET[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                        Time[rIndex - 1] = row.getCell(cIndex++).getNumericCellValue();
                    }
                }
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void CPETAssessment() {
        for (int i = 0; i < VE.length; i++) {
            EQO2[i] = VE[i] * 1000 / VO2[i];
            EQCO2[i] = VE[i] * 1000 / VCO2[i];
            OP[i] = VO2[i] / HR[i];
            RQ[i] = VCO2[i] / VO2[i];
            Ca_vO2[i] = VO2[i] / (HR[i] * SV[i]);
        }
        int row = EQCO2.length;

        int AT = 0;
        String timeAT = "";
        for (int i = 0; i < row; i++) {
            if (VO2[i] < VCO2[i] && VO2[i + 1] < VCO2[i + 1]) {
                timeAT = T[i];//无氧阈
                AT = i;
                System.out.println("AT的时间：" + timeAT);
                break;
            }
        }

        int Max = 0;
        String timeMax = "";
        for (int i = 0; i < row; i++) {
            if (Power[i + 1] < Power[i]) {
                timeMax = T[i];
                System.out.println("力竭的时间：" + timeMax);
                Max = i;
                break;
            }
        }

        double x1 = HR[AT];
        double HR_AT = HR[AT];
        double x1_max = 173;
        double x1_min = 71;

        double x2 = HR[Max];
        double x2_max = 198;
        double x2_min = 115;

        double x3 = SV[AT];
        double x3_max = 132;
        double x3_min = 8.8;

        double x4 = SV[Max];
        double x4_max = 192.1;
        double x4_min = 12.1;

        double x6 = OP[Max];
        double x6_max = 22.6;
        double x6_min = 6.8;

        double x7 = EQO2[AT];
        double x7_max = 33.1;
        double x7_min = 20.2;

        double x8 = EQO2[Max];
        double x8_max = 72.3;
        double x8_min = 22.5;

        double x9 = VE[AT];
        double x9_max = 82.8;
        double x9_min = 18.3;

        double x10 = VE[Max];
        double x10_max = 168.6;
        double x10_min = 28.4;

        double x11 = VO2[AT];
        double x11_max = 39.4;
        double x11_min = 14.06;

        double x12 = VO2[Max];
        double x12_max = 61.02;
        double x12_min = 21.68;

        double x14 = RQ[Max];
        double x14_max = 1.47;
        double x14_min = 0.97;

        double x15 = Ca_vO2[AT];
        double x15_max = 0.977;
        double x15_min = 0.105;

        double x16 = Ca_vO2[Max];
        double x16_max = 0.88;
        double x16_min = 0.0916;

        double[][] matrix = new double[3][14];//评价矩阵
        matrix[0][0] = x1;
        matrix[0][1] = x2;
        matrix[0][2] = x3;
        matrix[0][3] = x4;
        matrix[0][4] = x6;
        matrix[0][5] = x7;
        matrix[0][6] = x8;
        matrix[0][7] = x9;
        matrix[0][8] = x10;
        matrix[0][9] = x11;
        matrix[0][10] = x12;
        matrix[0][11] = x14;
        matrix[0][12] = x15;
        matrix[0][13] = x16;

        matrix[1][0] = x1_max;
        matrix[1][1] = x2_max;
        matrix[1][2] = x3_max;
        matrix[1][3] = x4_max;
        matrix[1][4] = x6_max;
        matrix[1][5] = x7_max;
        matrix[1][6] = x8_max;
        matrix[1][7] = x9_max;
        matrix[1][8] = x10_max;
        matrix[1][9] = x11_max;
        matrix[1][10] = x12_max;
        matrix[1][11] = x14_max;
        matrix[1][12] = x15_max;
        matrix[1][13] = x16_max;

        matrix[2][0] = x1_min;
        matrix[2][1] = x2_min;
        matrix[2][2] = x3_min;
        matrix[2][3] = x4_min;
        matrix[2][4] = x6_min;
        matrix[2][5] = x7_min;
        matrix[2][6] = x8_min;
        matrix[2][7] = x9_min;
        matrix[2][8] = x10_min;
        matrix[2][9] = x11_min;
        matrix[2][10] = x12_min;
        matrix[2][11] = x14_min;
        matrix[2][12] = x15_min;
        matrix[2][13] = x16_min;


        double[] Weight = {0.078, 0.058, 0.073, 0.048, 0.075, 0.096, 0.064, 0.075, 0.087, 0.064, 0.111, 0.053, 0.054, 0.066};

        double[][] D = new double[2][5];
        double s1 = 0;
        double s2 = 0;

        for (int i = 0; i < 5; i++) {
            D[0][i] = Weight[i] * ((matrix[0][i] - matrix[1][i]) / (matrix[1][i] - matrix[2][i]));
            s1 += Math.pow(D[0][i], 2);
        }
        s1 = Math.sqrt(s1);
        for (int i = 0; i < 5; i++) {
            D[1][i] = Weight[i] * ((matrix[0][i] - matrix[2][i]) / (matrix[1][i] - matrix[2][i]));
            s1 += Math.pow(D[1][i], 2);
        }
        s2 = Math.sqrt(s2);
        double Score1 = 70.855 * s2 / (s1 + s2) + 40.615;
        Score1 = new BigDecimal(Score1).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("心血管能力得分为：" + Score1);

        D = new double[2][4];
        s1 = 0;
        s2 = 0;
        for (int i = 0; i < 4; i++) {
            D[0][i] = Weight[i] * ((matrix[0][i + 5] - matrix[1][i + 1]) / (matrix[1][i + 5] - matrix[2][i + 5]));
            s1 += Math.pow(D[0][i], 2);
        }
        s1 = Math.sqrt(s1);
        for (int i = 0; i < 4; i++) {
            D[1][i] = Weight[i] * ((matrix[0][i + 5] - matrix[2][i + 5]) / (matrix[1][i + 5] - matrix[2][i + 5]));
            s2 += Math.pow(D[1][i], 2);
        }
        s2 = Math.sqrt(s2);
        double Score2 = 69.855 * s2 / (s1 + s2) + 48.615;
        Score2 = new BigDecimal(Score2).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("呼吸能力得分为：" + Score2);

        D = new double[2][5];
        s1 = 0;
        s2 = 0;
        for (int i = 0; i < 5; i++) {
            D[0][i] = Weight[i] * ((matrix[0][i + 9] - matrix[1][i + 9]) / (matrix[1][i + 9] - matrix[2][i + 9]));
            s1 += Math.pow(D[0][i], 2);
        }
        s1 = Math.sqrt(s1);
        for (int i = 0; i < 5; i++) {
            D[1][i] = Weight[i] * ((matrix[0][i + 9] - matrix[2][i + 9]) / (matrix[1][i + 9] - matrix[2][i + 9]));
            s2 += Math.pow(D[1][i], 2);
        }
        s2 = Math.sqrt(s2);
        double Score3 = 70.855 * s2 / (s1 + s2) + 44.615;
        Score3 = new BigDecimal(Score3).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("代谢能力得分为：" + Score3);

        double MroScore = (Score1 + Score2 + Score3) / 3;
        MroScore = Math.round(MroScore);
        System.out.println("心肺耐力综合得分为：" + MroScore);

        double Score4 = (((10.0 / 9) * HR[Max] - 80) + ((1.0 / 105) * VO2[Max] + 27)) / 2;
        Score4 = new BigDecimal(Score4).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("乳酸耐受力为：" + Score4);

        double EXP_MroScore = 1.095 * MroScore;
        EXP_MroScore = new BigDecimal(EXP_MroScore).setScale(1, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println("期待的心肺耐力综合得分为：" + EXP_MroScore);
    }

}