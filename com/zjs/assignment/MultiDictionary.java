
package com.zjs.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author ZhouJingsen
 */
public class MultiDictionary{
    HashMap map;
    public MultiDictionary(){
        map=new HashMap();
    }

    public void put(String k,String v){
        if(map.containsKey(k)){
            ArrayList value=(ArrayList)map.get(k);
            value.add(v);
            map.put(k, value);
        }else{
            ArrayList temp=new ArrayList();
            temp.add(v);
            map.put(k, temp);
        }
    }
    
    public String[] get(String k){
        if(!map.containsKey(k))return null;
        ArrayList al=(ArrayList)map.get(k);
        Object[] o=al.toArray();
        String[] s=new String[o.length];
        for(int i=0;i<o.length;i++)s[i]=(String)o[i];
        return s;
    }
    
    @Override
    public String toString(){
        String result="";
        result=result.concat("{\r\n");
        Iterator i=map.keySet().iterator();
        String temp;
        String[] tempa;
        while(i.hasNext()){
            temp=(String)i.next();
            tempa=get(temp);
            if(tempa.length==1){
                result=result.concat("\""+temp+"\" : \""+tempa[0]+"\"\r\n");
            }else{
                result=result.concat("\""+temp+"\" : [");
                for(int j=0;j<tempa.length;j++)result=result.concat("\""+tempa[j]+"\",");
                result=result.substring(0, result.length()-1);
                result=result.concat("]\r\n");
            }
        }
        result=result.concat("}");
        return result;
    }
    
    public String torString(){
        Iterator i=map.keySet().iterator();
        MultiDictionary md=new MultiDictionary();
        String temp;
        String[] tempa;
        while(i.hasNext()){
            temp=(String)i.next();
            tempa=get(temp);
            for(int j=0;j<tempa.length;j++)md.put(tempa[j],temp);
        }
        return md.toString();
    }
}
