package springmvcMavenMybatis;

import java.math.BigInteger;

public class TestJinzhi {

	
	public static String convertDecimalToBinary(int value){
		return Integer.toHexString(value);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(convertDecimalToBinary(8));
		System.out.println(convertDecimalToBinary(298));
		System.out.println(convertDecimalToBinary(64004));
		
		
		 String h = "fa04";
         BigInteger srch = new BigInteger(h, 16);
         
         System.out.println("十六进制字符串10000转为10进制后为:"+srch.toString());//转换为10进制并输出结果 
	}

}
