package com.grf.utils.Format;

import org.junit.Test;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class DecimalFormatDemo {

    /**
     * 测试 0 与 # 的区别
     */
    @Test
    public void testFormatPattern() {
        //末尾不足两位小数会自动补零
        System.out.println(new DecimalFormat("0.00").format(12.3));//结果 12.30
        //使用("#.##")不会自动补零
        System.out.println(new DecimalFormat("#.##").format(12.3));//结果 12.3
    }

    /**
      默认方式，特殊的舍入规则,避免运算数据丢失严重 RoundingMode.HALF_EVEN
      四舍五入 RoundingMode.HALF_UP
      五舍四入 HALF_DOWN
      进 up  、 舍 DOWN
      正舍负进 Floor
      正进负舍 CEILING
     */
    @Test
    public void testRoundingMode() {
        DecimalFormat decimalFormat = new DecimalFormat("0.00");
        printWholeTable(decimalFormat);
    }

    private void printWholeTable(DecimalFormat decimalFormat){
        printTableBar();
        printTableData(0.004,decimalFormat);
        printTableData(0.005,decimalFormat);
        printTableData(0.006,decimalFormat);
        printTableData(-0.004,decimalFormat);
        printTableData(-0.005,decimalFormat);
        printTableData(-0.006,decimalFormat);
    }

    private void printTableData(Double sData, DecimalFormat decimalFormat) {

        StringBuilder tableContent = new StringBuilder(sData + "\t");
        for (RoundingMode value : RoundingMode.values()) {
            decimalFormat.setRoundingMode(value);
            String dData;
            try {
                dData=decimalFormat.format(sData);
            }catch (Exception e){
                dData=e.getClass().getSimpleName();
            }
            tableContent.append(dData + "\t\t");
        }
        System.out.println(tableContent);
    }

    private  void printTableBar(){
        for (RoundingMode value : RoundingMode.values()) {
            System.out.print("\t\t"+value);
        }
        System.out.println();
    }



}
