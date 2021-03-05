package com.ycz.pattern.memento;

import java.util.Scanner;

/**
 * Created by ycz on  2021/02/24/6:27 下午
 */
public class Test {

    public static void main(String[] args) {
        InputText inputText=new InputText();
        SnapshotHolder snapshotHolder=new SnapshotHolder();
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String input=scanner.next();
            if(":list".equals(input)){
                System.out.println(inputText);
            }else if(":undo".equals(input)){
                Snapshot snapshot = snapshotHolder.popSnapshot();
                inputText.restoreSnapshot(snapshot);
                System.out.println(inputText);
            }else if(":exit".equals(input)){
                System.out.println(inputText);
                System.out.println("退出程序");
                break;
            }else {
                Snapshot snapshot = inputText.createSnapshot();
                snapshotHolder.pushSnapshot(snapshot);
                inputText.append(input);
            }
        }
    }
}
