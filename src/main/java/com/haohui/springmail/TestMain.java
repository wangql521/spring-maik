package com.haohui.springmail;

public class TestMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	        int [] arrays = {2 ,4 ,20 ,21 ,22 ,44 ,45 ,488 ,499 ,888,1000};
	        System.out.println(fintFlag(arrays,0,arrays.length-1,499));
	    }
	   
	    public static int fintFlag(int[] sortArray,int form,int to ,int findFlag){
	        if(to-form<0){
	            return -1;
	        }
	        int temp = (form+to)/2;
	        if(sortArray[temp]==findFlag){
	            return temp;
	        }
	        if(sortArray[temp]<findFlag){
	            return fintFlag(sortArray,temp+1,to,findFlag);
	        }
	        return fintFlag(sortArray,form,temp-1,findFlag);
	    }
      
}  

