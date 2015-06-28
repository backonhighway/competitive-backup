package kita;

import java.util.Properties;

import org.eclipse.swt.internal.win32.*;

public class Tryial {
    static void process() {
    	short[] keystate = new short[129];
    	for(int i=0; i<=128; i++){
    		keystate[i] = 0;
    	}
    	
    	while(true){
        	if (OS.GetAsyncKeyState(26) < 0) {
        		break;
        	}
    		short temp = OS.GetAsyncKeyState(66);
        	if (keystate[66] != temp) {
        		keystate[66] = temp;
        		System.out.println(temp);
        	}
        	
//        	for(int i=0; i<=128; i++){
//        		short temp = OS.GetAsyncKeyState(i);
//            	if (keystate[i] != temp) {
//            		keystate[i] = temp;
//            		if(i<=65 && i<=90){
//                		System.out.println((char)(i + 32)); //win32:65=='a' java:97=='a'
//  
//            		}
//
//            	}
//        	}

    	}

    }

    public static void main(String[] args) {
        // 実行時ライブラリへのパスを確認
        Properties props = System.getProperties();
        System.out.println(props.getProperty("java.library.path"));
        System.out.println((char)97);
        // SWTによるWinAPIコールを試みます。
        process();

    }
}